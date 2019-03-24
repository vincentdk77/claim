package com.sinosoft.claim.query.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLPolicyAction;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.query.util.Constant;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �����߼��ַ�EJB
 * <p>Description: ������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ����������
 * @version 1.0
 */
public class BLPolicyFacade {
	public void save(PolicyDto policyDto) throws SQLException, Exception {
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		//��ʼ����
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		dbManager.beginTransaction();
		try {
			new BLPolicyAction().save(dbManager, policyDto);
			//�ύ����
			dbManager.commitTransaction();
		} catch (SQLException sqle) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw sqle;
		} catch (Exception ex) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}

	}

	public void delete(String policyNo) throws SQLException, Exception {
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		//��ʼ����
		dbManager.beginTransaction();
		try {
			new BLPolicyAction().delete(dbManager, policyNo);
			//�ύ����
			dbManager.commitTransaction();
		} catch (SQLException sqle) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw sqle;
		} catch (Exception ex) {
			//�ع�����
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}
	}

	public PolicyDto findByPrimaryKey(String policyNo) throws SQLException,
			Exception {
		PolicyDto policyDto = null;
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		dbManager.open(Constant.QUERY_DATA_SOURCE);
		try {
			
			policyDto = new BLPolicyAction().findByPrimaryKey(dbManager,
					policyNo);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}

		return policyDto;
	}

	/**
	 * ���ݱ����Ż����Ӧ������Ϣ
	 * @param policyNO
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public PrpCmainDto findPrpCmainDtoByPrimaryKey(String policyNO) throws SQLException,Exception {
		PrpCmainDto prpCmainDto = null;
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		dbManager.open(Constant.QUERY_DATA_SOURCE);
		try {
			
			prpCmainDto = new BLPolicyAction().findPrpCmainDtoByPrimaryKey(dbManager,policyNO);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}

		return prpCmainDto;
	}
	public int findBySeriaNo(String condition) throws SQLException, Exception {
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		int seriaNo = 0;

		try {
			seriaNo = new BLPolicyAction().findBySeriaNo(dbManager, condition);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}

		return seriaNo;
	}

	public boolean isExist(String policyNo) throws SQLException, Exception {
		boolean exist = false;
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		try {
			exist = new BLPolicyAction().isExist(dbManager, policyNo);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}
		return exist;

	}

	/**
	 * ����������ѯ����������Ϣ
	 * @param conditions String
	 * @throws Exception
	 * @return Collection
	 */
	public PageRecord findForRegistConditions(String conditions, String pageNo,
			String recordPerPage) throws Exception {
		DBManager dbManager = new DBManager();
		//PrpLpolicyDto prpLpolicyDto = null;
		PageRecord pageRecord = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLPolicyAction blPolicyAction = new BLPolicyAction();
			pageRecord = (PageRecord) blPolicyAction.findForRegistConditions(
					dbManager, conditions, Integer.parseInt(DataUtils
							.nullToZero(pageNo)), Integer.parseInt(DataUtils
							.nullToZero(recordPerPage)));
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
	}

	public int checkPay(String conditions) throws SQLException, Exception {
		int exist = -1;
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		dbManager.open(Constant.QUERY_DATA_SOURCE);
		try {
			exist = new BLPolicyAction().checkPay(dbManager, conditions);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}
		return exist;

	}

	public int[] getDelinquentfeeTime(String conditions) throws SQLException,
			Exception {
		int[] result;
		//�������ݿ�������
		DBManager dbManager = new DBManager();
		//dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		dbManager.open(Constant.QUERY_DATA_SOURCE);
		try {
			result = new BLPolicyAction().getDelinquentfeeTime(dbManager,conditions);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			//�ر����ݿ�����
			dbManager.close();
		}
		return result;
	}

}
