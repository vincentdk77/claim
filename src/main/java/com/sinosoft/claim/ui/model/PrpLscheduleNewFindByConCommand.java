package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleNewFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLscheduleNewFindByConCommand extends BaseCommand
{
  private String conditions;

  public PrpLscheduleNewFindByConCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLScheduleNewFacade bLScheduleNewFacade = new BLScheduleNewFacade();
      return bLScheduleNewFacade.findByConditions(conditions);
  }

}
