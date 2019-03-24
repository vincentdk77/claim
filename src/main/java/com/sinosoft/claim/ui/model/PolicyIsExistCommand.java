package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PolicyIsExistCommand extends BaseCommand
{
	private String fcoPolicyNoticeNo;

	public PolicyIsExistCommand(String fcoPolicyNoticeNo) throws Exception
	{
		this.fcoPolicyNoticeNo = fcoPolicyNoticeNo;
	}
	public Object executeCommand() throws Exception
	{
    BLPolicyFacade bLPolicyFacade = new BLPolicyFacade();
    return new Boolean(bLPolicyFacade.isExist(fcoPolicyNoticeNo));
	}
}
