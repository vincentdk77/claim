package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.aip.webservice.server.RegistInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ������Ϣ��
 */

public class BLPrpLregistZYFacade {
	private static Log logger = LogFactory.getLog(BLPrpLregistZYFacade.class);

    /**
     * ���캯��
     */
    public BLPrpLregistZYFacade(){
    }
	/**
     * ����������һ������
     * @param dbManager DB������
     * @param registNo ��������
     * @return 
	 * @throws Exception 
     */
    public RegistInfo findByPrimaryKey(String registNo) throws Exception{
    	DBManager dbManager = new DBManager();
    	DBPrpRegistInfoZY dbPrpRegistZY = new DBPrpRegistInfoZY(dbManager);
    	RegistInfo registInfo =null;
        try {
        	//dbManager.beginTransaction();
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//������Դ
			registInfo = dbPrpRegistZY.findByPrimaryKey(registNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return registInfo;
    }
}
