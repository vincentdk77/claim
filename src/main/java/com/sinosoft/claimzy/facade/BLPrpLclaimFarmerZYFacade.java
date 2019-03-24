package com.sinosoft.claimzy.facade;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.sinosoft.aip.webservice.server.ClaimFarmerInfo;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPrpLclaimFarmerZYFacade {
	private static Log loggr = LogFactory.getLog(BLPrpLclaimFarmerZYFacade.class);
	 /**
   * ���캯��
   */
	public BLPrpLclaimFarmerZYFacade(){
		
	}
	/**
   * ����������һ������
   * @param dbManager DB������
   * @param caseNo �ⰸ����
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
