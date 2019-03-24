package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.sinosoft.aip.webservice.server.CancelMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 注销/拒赔类
 * @author CDB
 *
 */
public class BLPrpLcancelZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLcancelZYFacade.class);

	/**
	 * 构造函数
	 */
	public BLPrpLcancelZYFacade() {

	}

	/**
	 * 按主键查找一条数据
	 * 
	 * @param dbManager
	 *            DB管理器
	 * @param claimNo
	 *            立案号码
	 * @return cancelMainInfo
	 * @throws Exception
	 * 
	 */
	public CancelMainInfo findByPrimaryKey(String claimNo) throws Exception {
		DBManager dbManager = new DBManager();
		DBPrpCancelMainInfoZY dcmi = new DBPrpCancelMainInfoZY(dbManager);
		CancelMainInfo cancelMainInfo = null;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));// 打开数据源
			cancelMainInfo = dcmi.findByPrimaryKey(claimNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return cancelMainInfo;

	}
}
