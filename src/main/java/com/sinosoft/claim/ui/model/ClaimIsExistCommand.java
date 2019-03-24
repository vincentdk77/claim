package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimIsExistCommand extends BaseCommand
{
	private String claimNo;

	public ClaimIsExistCommand(String claimNo)  throws Exception
	{
		this.claimNo = claimNo;
	}
	public Object executeCommand() throws Exception
	{
		BLClaimFacade bLClaimFacade = new BLClaimFacade();
	  return new Boolean(bLClaimFacade.isExist(claimNo));
	}
}
