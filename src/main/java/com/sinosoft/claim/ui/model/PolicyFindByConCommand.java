package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PolicyFindByConCommand extends BaseCommand
{
	private String policyNo;
    public PolicyFindByConCommand () throws Exception
    {}
    
	public PolicyFindByConCommand(String policyNo) throws Exception
	{
		this.policyNo = policyNo;
	}
	public Object executeCommand() throws Exception
	{
    BLPolicyFacade bLPolicyFacade = new BLPolicyFacade();
    return bLPolicyFacade.findByPrimaryKey(policyNo);
	}

	public int findBySeriaNo(String condition) throws Exception {
		BLPolicyFacade bLPolicyFacade = new BLPolicyFacade();
		return  bLPolicyFacade.findBySeriaNo(condition);
	}
}
