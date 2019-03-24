package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 预赔案信息类
 */
public class BLPrpLprepaidZYFacade {
	private static Log logger = LogFactory.getLog(BLPrpLprepaidZYFacade.class);

    /**
     * 构造函数
     */
    public BLPrpLprepaidZYFacade(){
    }
    
    /**
     * 按住键查找一条数据
     * @throws Exception 
     */
    public PrepaidMainInfo findByPrimaryKey(String preCompensateNo) throws Exception{
		DBManager dbManager = new DBManager();
		DBPrpPrepaidMainInfoZY dbpz = new DBPrpPrepaidMainInfoZY(dbManager);
		PrepaidMainInfo prepaidMainInfo=null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//打开数据源
			prepaidMainInfo=dbpz.findByPrimaryKey(preCompensateNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManager.close();
    	return prepaidMainInfo;
    	
    }
    
}
