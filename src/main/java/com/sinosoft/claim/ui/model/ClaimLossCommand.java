package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimLossCommand extends BaseCommand
{
	private String claimNo;

	public ClaimLossCommand(String claimNo)  throws Exception
	{
		this.claimNo = claimNo;
	}
	public Object executeCommand() throws Exception
	{
    BLClaimFacade bLClaimFacade = new BLClaimFacade();
    return bLClaimFacade.getClaimLoss(claimNo);
	}
}
