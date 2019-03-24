package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLclaimFarmerZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLclaimFarmerZYFacade.class);
	 /**
   * 构造函数
   */
	public BLPrpLclaimFarmerZYFacade(){
		
	}
	/**
   * 按主键查找一条数据
   * @param dbManager DB管理器
   * @param caseNo 赔案号码
   * @return claimFarmerInfo
   * 
   * 
   */
	public ClaimFarmerInfo[] findByPrimaryKey(String caseNo) throws Exception{
		DBPrpClaimFarmerInfoZY dcfi = new DBPrpClaimFarmerInfoZY();
		ClaimFarmerInfo[] claimFarmerInfo =null;
		try {
			claimFarmerInfo = dcfi.findByPrimaryKey(caseNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claimFarmerInfo;
	}
}
