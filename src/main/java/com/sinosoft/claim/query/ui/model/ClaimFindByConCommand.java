package com.sinosoft.claim.query.ui.model;

import java.sql.SQLException;

import com.sinosoft.claim.query.bl.facade.BLClaimFacade;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimFindByConCommand extends BaseCommand
{
	private String claimNo;

	public ClaimFindByConCommand() throws Exception {}
	
	public ClaimFindByConCommand(String claimNo)  throws Exception
	{
		this.claimNo = claimNo;
	}
	public Object executeCommand() throws Exception
	{
		BLClaimFacade bLClaimFacade = new BLClaimFacade();
	  return bLClaimFacade.findByPrimaryKey(claimNo);
	}
	
	public Object findByPolicyNo(String policyNo) throws Exception {
		BLClaimFacade bLClaimFacade = new BLClaimFacade();
		return bLClaimFacade.findByPolicyNo(policyNo);  
	}
	
	public Object findByPolicyNo(String policyNo,String idcard) throws Exception {
		BLClaimFacade bLClaimFacade = new BLClaimFacade();
		return bLClaimFacade.findByPolicyNo(policyNo,idcard);  
	}
	
	public PrpCmainDto findByPolicyNoKey(String policyNo) throws SQLException, Exception {
		BLClaimFacade bLClaimFacade = new BLClaimFacade();
		return bLClaimFacade.findByPolicyNoKey(policyNo);  
	}
}
