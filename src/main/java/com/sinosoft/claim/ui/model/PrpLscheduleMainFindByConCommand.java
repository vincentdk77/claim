package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLscheduleMainFindByConCommand extends BaseCommand
{
  private String conditions;

  public PrpLscheduleMainFindByConCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLScheduleFacade bLScheduleFacade = new BLScheduleFacade();
      return bLScheduleFacade.findByConditions(conditions);
  }

}
