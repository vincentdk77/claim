package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLVisaAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLVisaFacade {

	private BLVisaAction blVisaAction = new BLVisaAction();

	/**
	 * ����ҵ�����ֺ�ҵ�����ͻ�ȡ��Ӧ�ĵ�֤���ʹ��������
	 * 
	 * @param comCode
	 * @param riskCode
	 * @param certiType
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public Collection getVsCode(String comCode, String riskCode,
			String certiType) throws SQLException, Exception {
		// �������ݿ�������
		DBManager dbManager = getDBManager();
		try {
			return blVisaAction.getVsCode(dbManager, comCode, riskCode,
					certiType);
		} finally {
			// �ر����ݿ�����
			dbManager.close();
		}
	}

	/**
	 * ����кŵ�֤�Ƿ����ʹ��
	 * 
	 * @param visaCode
	 * @param visaSerialNo
	 * @param userCode
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public boolean checkVisaCodeValid(String visaCode, String visaSerialNo,
			String userCode) throws SQLException, Exception {
		// �������ݿ�������
		DBManager dbManager = getDBManager();
		try {
			boolean isValid = blVisaAction.checkVisaCodeValid(dbManager,
					visaCode, visaSerialNo, userCode);
			return isValid;
		} finally {
			// �ر����ݿ�����
			dbManager.close();
		}
	}

	/**
	 * ҵ����кŵ�֤��ʹ�ò���
	 * 
	 * @param visaCode
	 * @param visaSerialNo
	 * @param businessNo
	 * @param userCode
	 * @param userName
	 * @throws SQLException
	 * @throws Exception
	 */
	public void doUsed(String visaCode, String visaSerialNo, String businessNo,
			String userCode, String userName) throws SQLException, Exception {
		// �������ݿ�������
		DBManager dbManager = getDBManager();
		// ��ʼ����
		dbManager.beginTransaction();
		try {
			blVisaAction.doUsed(dbManager, visaCode, visaSerialNo, businessNo, userCode, userName);
			// �ύ����
			dbManager.commitTransaction();
		} catch (Exception ex) {
			// �ع�����
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			// �ر����ݿ�����
			dbManager.close();
		}
	}

	/**
	 * ҵ����кŵ�֤�����ϲ���
	 * 
	 * @param visaCode
	 * @param visaSerialNo
	 * @param businessNo
	 * @param userCode
	 * @param userName
	 * @throws SQLException
	 * @throws Exception
	 */
	public void doAnnul(String visaCode, String visaSerialNo, String userCode,
			String userName) throws SQLException, Exception {
		// �������ݿ�������
		DBManager dbManager = getDBManager();
		// ��ʼ����
		dbManager.beginTransaction();
		try {
			blVisaAction.doAnnul(dbManager, visaCode, visaSerialNo, userCode, userName);
			// �ύ����
			dbManager.commitTransaction();
		} catch (Exception ex) {
			// �ع�����
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			// �ر����ݿ�����
			dbManager.close();
		}
	}

	private DBManager getDBManager() throws Exception {
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		return dbManager;
	}
}
