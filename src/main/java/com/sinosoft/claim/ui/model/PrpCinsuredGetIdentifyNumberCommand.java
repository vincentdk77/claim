package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpCinsuredGetIdentifyNumberCommand extends BaseCommand
{  
	private String conditions;

	public PrpCinsuredGetIdentifyNumberCommand(String conditions) throws Exception
	{
    try
    {
      this.conditions = conditions;
    }
    catch(Exception e)
    {
       throw e;
    }
	}
	public Object executeCommand() throws Exception
	{
		BLPrpCinsuredFacade bLPrpCinsuredFacade = new BLPrpCinsuredFacade();
	    return bLPrpCinsuredFacade.getIdentifyNumber(conditions);
	
	}

}
