package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLAcciCheckFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class AcciCheckFindByConCommand extends BaseCommand
{
	private String registNo;

	public AcciCheckFindByConCommand(String registNo)  throws Exception
	{
		this.registNo = registNo;
	}
	public Object executeCommand() throws Exception
	{
		BLAcciCheckFacade bLAcciCheckFacade = new BLAcciCheckFacade();
	    return bLAcciCheckFacade.findByPrimaryKey(registNo);
	}

}
