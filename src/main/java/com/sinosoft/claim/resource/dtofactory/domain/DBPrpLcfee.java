package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcfeeDto;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 这是prplcfee赔款计算金额表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcfee extends DBPrpLcfeeBase{
    private static Log log = LogFactory.getLog(DBPrpLcfee.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcfee(DBManager dbManager){
        super(dbManager);
    }
    
    
    
     /**
     * 按条件从prpLcfee表,查询符合条件的已决赔款信息
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
      */
    public Collection findSumEndCaseByConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = " SELECT RiskCode,"
                        + " Currency,"
                        + " sum(SumPaid) as SumPaid "
                        + " FROM PrpLcfee WHERE "
                        + conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLcfeeDto prpLcfeeDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);
        int count=0;
        if(pageNo>1){
            dbManager.locate(resultSet,rowsPerPage * (pageNo - 1));
        }

        while(resultSet.next()){
            count++;
            if(pageNo>0){
                if(count > rowsPerPage){
                        break;
                }
            }

            prpLcfeeDto = new PrpLcfeeDto();
            prpLcfeeDto.setRiskCode(dbManager.getString(resultSet,1));
            prpLcfeeDto.setCurrency(dbManager.getString(resultSet,2));
            prpLcfeeDto.setSumPaid(dbManager.getDouble(resultSet,3));
            collection.add(prpLcfeeDto);
        }
        resultSet.close();
        log.info("DBPrpLcfee.findSumEndCaseByConditions() success!");
        return collection;
    }

}
