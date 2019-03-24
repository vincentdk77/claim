package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndorseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndorseFindConditions extends BaseCommand
{
	private String policyNo;

	public EndorseFindConditions(String policyNo) throws Exception
	{
		this.policyNo = policyNo; 
	}
	public Object executeCommand() throws Exception
	{
    BLEndorseFacade blEndorseFacade = new BLEndorseFacade();
    return blEndorseFacade.findByConditions(policyNo);   
	}

}
