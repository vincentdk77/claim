package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLVisaAction;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLVisaFacade {

	private BLVisaAction blVisaAction = new BLVisaAction();

	/**
	 * 根据业务险种和业务类型获取对应的单证类型代码和名称
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
		// 创建数据库管理对象
		DBManager dbManager = getDBManager();
		try {
			return blVisaAction.getVsCode(dbManager, comCode, riskCode,
					certiType);
		} finally {
			// 关闭数据库连接
			dbManager.close();
		}
	}

	/**
	 * 检查有号单证是否可以使用
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
		// 创建数据库管理对象
		DBManager dbManager = getDBManager();
		try {
			boolean isValid = blVisaAction.checkVisaCodeValid(dbManager,
					visaCode, visaSerialNo, userCode);
			return isValid;
		} finally {
			// 关闭数据库连接
			dbManager.close();
		}
	}

	/**
	 * 业务对有号单证的使用操作
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
		// 创建数据库管理对象
		DBManager dbManager = getDBManager();
		// 开始事务
		dbManager.beginTransaction();
		try {
			blVisaAction.doUsed(dbManager, visaCode, visaSerialNo, businessNo, userCode, userName);
			// 提交事务
			dbManager.commitTransaction();
		} catch (Exception ex) {
			// 回滚事务
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			// 关闭数据库连接
			dbManager.close();
		}
	}

	/**
	 * 业务对有号单证的作废操作
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
		// 创建数据库管理对象
		DBManager dbManager = getDBManager();
		// 开始事务
		dbManager.beginTransaction();
		try {
			blVisaAction.doAnnul(dbManager, visaCode, visaSerialNo, userCode, userName);
			// 提交事务
			dbManager.commitTransaction();
		} catch (Exception ex) {
			// 回滚事务
			dbManager.rollbackTransaction();
			throw ex;
		} finally {
			// 关闭数据库连接
			dbManager.close();
		}
	}

	private DBManager getDBManager() throws Exception {
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI"));
		return dbManager;
	}
}
