package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PolicySaveCommand extends BaseCommand
{
	private PolicyDto policyDto;

	public PolicySaveCommand(PolicyDto policyDto)  throws Exception
	{
		this.policyDto = policyDto;
	}
	public Object executeCommand() throws Exception
	{
    BLPolicyFacade bLPolicyFacade = new BLPolicyFacade();
    bLPolicyFacade.save(policyDto);
    return null;
	}
}
