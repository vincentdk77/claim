package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import com.sinosoft.aip.webservice.server.ClaimMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ������Ϣ��
 */
public class BLPrpLclaimZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLclaimZYFacade.class);
	 /**
     * ���캯��
     */
	public BLPrpLclaimZYFacade(){
		
	}
	/**
     * ����������һ������
     * @param dbManager DB������
     * @param claimNo ��������
     * @return claimMainInfo
	 * @throws Exception 
     */
	public ClaimMainInfo findByPrimaryKey(String claimNo) throws Exception{
		DBManager dbManager = new DBManager();
		DBPrpClaimMainInfoZY dbcz = new DBPrpClaimMainInfoZY(dbManager);
		ClaimMainInfo claimMainInfo = null;
		try {
			//dbManager.beginTransaction();
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//������Դ
			claimMainInfo = dbcz.findByPrimaryKey(claimNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return claimMainInfo;
	}
}
