package com.sinosoft.claim.resource.dtofactory.domain;

import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.sysframework.reference.DBManager;

/**
 * 这是prpcinsured保险关系人表的数据访问对象扩展类<br>
 * 创建于 2004-4-5 15:32:10<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class DBPrpCinsured extends DBPrpCinsuredBase{
    private static Log log = LogFactory.getLog(DBPrpCinsured.class.getName());

    /**
     * 构造函数
     * @param dbManager 资源管理类
     */
    public DBPrpCinsured(DBManager dbManager){
        super(dbManager);
    }
    
//modify by liuyanmei add 20051108 start
    public String  getIdentifyNumber(String conditions) throws Exception{
    	 String identifyNumber="";
    	 String statement = "Select DISTINCT identifyNumber From PrpCinsured where  " +conditions ;
         log.debug(statement);
         //PrpLverifyLossDto prpLverifyLossDto = null;
         ResultSet resultSet = dbManager.executeQuery(statement);
         //identifyNumber= dbManager.executeQuery(statement);

        while(resultSet.next()){
             identifyNumber=dbManager.getString(resultSet,1);
         }
        resultSet.close();
         //log.info("DBPrpCinsured.getIdentifyNumber() success!");
         return identifyNumber;
     }
    
    
    
    
//modify by liuyanmei add 20051108 end
    
    
}
