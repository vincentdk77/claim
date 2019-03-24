package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import com.sinosoft.aip.webservice.server.ClaimMainInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 立案信息类
 */
public class BLPrpLclaimZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLclaimZYFacade.class);
	 /**
     * 构造函数
     */
	public BLPrpLclaimZYFacade(){
		
	}
	/**
     * 按主键查找一条数据
     * @param dbManager DB管理器
     * @param claimNo 立案号码
     * @return claimMainInfo
	 * @throws Exception 
     */
	public ClaimMainInfo findByPrimaryKey(String claimNo) throws Exception{
		DBManager dbManager = new DBManager();
		DBPrpClaimMainInfoZY dbcz = new DBPrpClaimMainInfoZY(dbManager);
		ClaimMainInfo claimMainInfo = null;
		try {
			//dbManager.beginTransaction();
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));//打开数据源
			claimMainInfo = dbcz.findByPrimaryKey(claimNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			dbManager.close();
		}
		return claimMainInfo;
	}
}
