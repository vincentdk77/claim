package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLPersonLossFindbyConditionsCommand extends BaseCommand
{
  private String conditions;

	public PrpLPersonLossFindbyConditionsCommand(String conditions)  throws Exception
	{
		this.conditions = conditions;
	}
	public Object executeCommand() throws Exception
	{
    BLCompensateFacade blCompensateFacade = new BLCompensateFacade();
    return blCompensateFacade.findPersonLossByConditions(conditions);
	}

}
