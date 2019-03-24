package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class RegistIsExistCommand extends BaseCommand
{
	private String registNo;

	public RegistIsExistCommand(String registNo)  throws Exception
	{
		this.registNo = registNo;
	}
	public Object executeCommand() throws Exception
	{
		BLRegistFacade bLRegistFacade = new BLRegistFacade();
	    return new Boolean(bLRegistFacade.isExist(registNo));
	}

}
