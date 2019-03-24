package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeGetComLevelCommand extends BaseCommand
{
	private String comCode;

	public CodeGetComLevelCommand(String comCode) throws Exception
	{
    try
    {
      this.comCode = comCode;
    }
    catch(Exception e)
    {
       throw e;
    }
	}
	public Object executeCommand() throws Exception
	{
	    BLCodeFacade bLCodeFacade = new BLCodeFacade();
	    return bLCodeFacade.getComLevel(comCode);
	}

}
