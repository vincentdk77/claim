package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.aip.webservice.server.CancelMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * ע��/������
 * @author CDB
 *
 */
public class BLPrpLcancelZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLcancelZYFacade.class);

	/**
	 * ���캯��
	 */
	public BLPrpLcancelZYFacade() {

	}

	/**
	 * ����������һ������
	 * 
	 * @param dbManager
	 *            DB������
	 * @param claimNo
	 *            ��������
	 * @return cancelMainInfo
	 * @throws Exception
	 * 
	 */
	public CancelMainInfo findByPrimaryKey(String claimNo) throws Exception {
		DBManager dbManager = new DBManager();
		DBPrpCancelMainInfoZY dcmi = new DBPrpCancelMainInfoZY(dbManager);
		CancelMainInfo cancelMainInfo = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));// ������Դ
			cancelMainInfo = dcmi.findByPrimaryKey(claimNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return cancelMainInfo;

	}
}
