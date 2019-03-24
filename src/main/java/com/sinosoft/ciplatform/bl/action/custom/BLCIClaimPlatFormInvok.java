package com.sinosoft.ciplatform.bl.action.custom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.ciplatform.bl.action.domain.BLCIClaimDemandAction;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.custom.Accounts;
import com.sinosoft.ciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.ciplatform.dto.custom.PlatFormParam;
import com.sinosoft.ciplatform.dto.custom.ReturnAccountsInfo;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLCIClaimPlatFormInvok {
	private static BLCIClaimPlatFormInvok bLCIClaimPlatFormInvok=new BLCIClaimPlatFormInvok();
	public static BLCIClaimPlatFormInvok getInstance(){
		if(bLCIClaimPlatFormInvok==null){
			bLCIClaimPlatFormInvok=new BLCIClaimPlatFormInvok();
		}
		return bLCIClaimPlatFormInvok;
	}
	

	public ReturnAccountsInfo accountNoQuery(Accounts accounts) throws ClaimCiPlatFormException,Exception{
		ReturnAccountsInfo info=null;
		try{			
			System.out.println("马上进行商业险清算码查询平台交互");
			BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
			CIPlatformConfigDto cIPlatformConfigDto = bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", "34", "0506");
			PlatFormParam platFormParam =new PlatFormParam();
			platFormParam.setUrl(cIPlatformConfigDto.getUrl());
			platFormParam.setUserName(cIPlatformConfigDto.getUserName());
			platFormParam.setUserPwd(cIPlatformConfigDto.getPwd());
			if(cIPlatformConfigDto.getUrl()!=null && cIPlatformConfigDto.getUserName()!=null && cIPlatformConfigDto.getPwd()!=null &&
			!cIPlatformConfigDto.getUrl().equals("") && !cIPlatformConfigDto.getUserName().equals("") && !cIPlatformConfigDto.getPwd().equals("")){
				String registNo=accounts.getRecoveryRegistNo();
				String claimCode=getClaimCode(registNo);
				accounts.setClaimCode(claimCode);
				info=CIPlatFormInterface.sendAccountNo(accounts, platFormParam);
			}
			System.out.println("商业险清算码查询平台交互结束");
			return info;
		  }catch(Exception e){
			throw e;
		  }		
	}
	/**
	 * 获取理赔编码
	 * @param dbManager
	 * @param businessNo
	 * @return claimCode
	 * @throws SQLException
	 * @throws Exception
	 */
	protected String getClaimCode(String registNo) throws SQLException,Exception {
		String conditions = " registNo='"+registNo+"' AND riskcode='0506' ";	
		System.out.println("========conditions=========conditions========"+conditions);
		String claimCode = "";
		List claimDemandList = new ArrayList();
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();			
		    BLCIClaimDemandAction blCIClaimDemandAction = new BLCIClaimDemandAction();
		    claimDemandList = (ArrayList)blCIClaimDemandAction.findByConditions(dbManager, conditions);
		if(claimDemandList != null && claimDemandList.size() > 0){
			claimCode = ((CIClaimDemandDto)claimDemandList.get(0)).getClaimCode();
		}
		dbManager.commitTransaction();
		System.out.println("========claimCode====claimCode==============="+claimCode);
		return claimCode;
	    }catch (Exception e) {			
		e.printStackTrace();
		dbManager.rollbackTransaction();
		throw e;
	    } finally{
		dbManager.close();	

	    }

		
	}
	
}
