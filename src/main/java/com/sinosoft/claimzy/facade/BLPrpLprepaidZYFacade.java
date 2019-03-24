package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.PrepaidMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * Ԥ�ⰸ��Ϣ��
 */
public class BLPrpLprepaidZYFacade {
	private static Log logger = LogFactory.getLog(BLPrpLprepaidZYFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLprepaidZYFacade(){
    }
    
    /**
     * ��ס������һ������
     * @throws Exception 
     */
    public PrepaidMainInfo findByPrimaryKey(String preCompensateNo) throws Exception{
		DBManager dbManager = new DBManager();
		DBPrpPrepaidMainInfoZY dbpz = new DBPrpPrepaidMainInfoZY(dbManager);
		PrepaidMainInfo prepaidMainInfo=null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//������Դ
			prepaidMainInfo=dbpz.findByPrimaryKey(preCompensateNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbManager.close();
    	return prepaidMainInfo;
    	
    }
    
}
