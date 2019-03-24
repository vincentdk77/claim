package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.domain.PrpLcaseNoDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prplcaseno赔案号表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:11<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpLcaseNo extends DBPrpLcaseNoBase{
    private static Log log = LogFactory.getLog(DBPrpLcaseNo.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpLcaseNo(DBManager dbManager){
        super(dbManager);
    }

    /**
     * 按条件从prplcompensate表,prplregist表,prplclaimstatus表和表prpLclaim中查询多条数据
     * @param conditions String
     * @param pageNo int
     * @param rowsPerPage int
     * @throws Exception
     * @return Collection
     * Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件，在查询结果中增加案件状态
     */
    public Collection findByQueryConditions(String conditions,int pageNo,int rowsPerPage) throws Exception{
       String statement = "Select DISTINCT PrpLclaim.ClaimNo,"+
                           "PrpLclaim.CaseNo, "+
                           "PrpLclaim.PolicyNo, "+
                           "PrpLregist.LicenseNo, "+
                           "PrpLclaim.EndCaserCode, "+
                           "PrpLclaim.EndCaseDate,PrpLclaim.RiskCode From PrpLclaim right join (select * from PrpLClaimStatus where NodeType='endca') b on b.policyno=PrpLclaim.policyno  left join PrpLregist on PrpLregist.registNo=PrpLclaim.registNo where"+conditions ;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLcaseNoDto prpLcaseNoDto = null;
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

            prpLcaseNoDto = new PrpLcaseNoDto();
            prpLcaseNoDto.setClaimNo(dbManager.getString(resultSet,1));
            prpLcaseNoDto.setCaseNo(dbManager.getString(resultSet,2));
            prpLcaseNoDto.setPolicyNo(dbManager.getString(resultSet,3));
            prpLcaseNoDto.setLicenseNo(dbManager.getString(resultSet,4));
            prpLcaseNoDto.setEndCaserCode(dbManager.getString(resultSet,5));
            prpLcaseNoDto.setEndCaseDate(dbManager.getDateTime(resultSet,DateTime.YEAR_TO_DAY,6));
            prpLcaseNoDto.setRiskCode(dbManager.getString(resultSet,7));
            collection.add(prpLcaseNoDto);
        }
        resultSet.close();
        log.info("DBPrpLcaseNo.findByConditions() success!");
        return collection;
    }
}
