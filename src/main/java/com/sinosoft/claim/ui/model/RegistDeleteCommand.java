package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class RegistDeleteCommand extends BaseCommand
{
	private String registNo;

	public RegistDeleteCommand(String registNo)  throws Exception
	{
		this.registNo = registNo;
	}
	public Object executeCommand() throws Exception
	{
		BLRegistFacade bLRegistFacade = new BLRegistFacade();
	    bLRegistFacade.delete(registNo);
	    return null;
	}

}
