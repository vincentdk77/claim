package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.dto.custom.PrpLPersonLimitDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpCfeeBase;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 人员权限对照表
 * <p>Title: 人员权限对照表</p>
 * <p>Description: 人员权限对照表</p>
 * <p>Copyright: Copyright (c) 2005/11/15</p>
 * <p>Company: Sinosoft</p>
 * @author qinyongli
 * @version 1.0
 */
 public class DBPersonLimit{
    private DBManager dbManager = null; //资源管理类
    private static Log log = LogFactory.getLog(DBPrpCfeeBase.class.getName());
    /**
     * 按条件查询多条数据
     * @param conditions 根据人员代码得到所有的对象
     * @return collection 
     */
    
    public Collection findByConditions(DBManager dbManager,String conditions) throws Exception{
        String statement = "Select UserCode," + 
                           " RiskCode," + 
                           " Flag From PrpLpersonLimit Where " + conditions;
        log.debug(statement);
        Collection collection = new ArrayList();
        PrpLPersonLimitDto prpLPersonLimitDto = null;
        ResultSet resultSet = dbManager.executeQuery(statement);

        while(resultSet.next()){
            prpLPersonLimitDto = new PrpLPersonLimitDto();
            prpLPersonLimitDto.setUserCode(dbManager.getString(resultSet,1));
            prpLPersonLimitDto.setRiskCode(dbManager.getString(resultSet,2));
            prpLPersonLimitDto.setFlag(dbManager.getString(resultSet,3));
            collection.add(prpLPersonLimitDto);
        }
        resultSet.close();
        
        log.info("DBPrpCfeeBase.findByConditions() success!");
        return collection;
    }
}