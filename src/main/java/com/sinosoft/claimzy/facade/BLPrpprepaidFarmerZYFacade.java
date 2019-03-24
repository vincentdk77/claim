package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidFarmerInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpprepaidFarmerZYFacade {
	private static Log logger = LogFactory.getLog(BLPrpprepaidFarmerZYFacade.class);
	
	 /**
     * ���캯��
     */
    public BLPrpprepaidFarmerZYFacade(){
    }
    
    /**
     * ����������һ������
     * @throws Exception 
     */
    public PrepaidFarmerInfo[] findByPrimaryKey(String preCompensateNo) throws Exception{
		DBManager dbManager = new DBManager();
		DBPrpPrepaidFarmerInfoZY dbpf = new DBPrpPrepaidFarmerInfoZY(dbManager);
		PrepaidFarmerInfo[] prepaidFarmerInfo =null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//������Դ
			prepaidFarmerInfo = dbpf.findByPrimaryKey(preCompensateNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManager.close();
    	return prepaidFarmerInfo;
    	
    }
}
