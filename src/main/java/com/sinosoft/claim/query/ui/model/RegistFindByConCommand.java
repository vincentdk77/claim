package com.sinosoft.claim.query.ui.model;

import com.sinosoft.claim.query.bl.facade.BLRegistFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class RegistFindByConCommand extends BaseCommand
{
	private String registNo;

	public RegistFindByConCommand(String registNo)  throws Exception
	{
		this.registNo = registNo;
	}
	public Object executeCommand() throws Exception
	{
		BLRegistFacade bLRegistFacade = new BLRegistFacade();
	    return bLRegistFacade.findByPrimaryKey(registNo);
	}

}
