package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PolicyDeleteCommand extends BaseCommand
{
	private String fcoPolicyNoticeNo;

	public PolicyDeleteCommand(String fcoPolicyNoticeNo) throws Exception
	{
		this.fcoPolicyNoticeNo = fcoPolicyNoticeNo;
	}
	public Object executeCommand() throws Exception
	{
    BLPolicyFacade bLPolicyFacade = new BLPolicyFacade();
    bLPolicyFacade.delete(fcoPolicyNoticeNo);
    return null;
	}

}
