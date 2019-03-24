package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeFindByCodeTypeCommand extends BaseCommand
{
	private String codetype;
	private String riskcode;

	public CodeFindByCodeTypeCommand(String codetype,String riskcode) throws Exception
	{
    try
    {
      this.codetype = codetype;
      this.riskcode = riskcode;
    }
    catch(Exception e)
    {
       throw e;
    }
	}
	public Object executeCommand() throws Exception
	{
	    BLCodeFacade bLCodeFacade = new BLCodeFacade();
	    return bLCodeFacade.getCodeType(codetype,riskcode);
	}

}
