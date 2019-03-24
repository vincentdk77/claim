package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CodeGetCustomerTypeCommand extends BaseCommand
{
	private String customerCode;

	public CodeGetCustomerTypeCommand(String customerCode) throws Exception
	{
    try
    {
      this.customerCode = customerCode;
    }
    catch(Exception e)
    {
       throw e;
    }
	}
	public Object executeCommand() throws Exception
	{
	    BLCodeFacade bLCodeFacade = new BLCodeFacade();
	    return bLCodeFacade.getCustomerType(customerCode);
	}

}
