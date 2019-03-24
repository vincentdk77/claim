package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCheckFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CheckFindNewScheduleTaskListCommand extends BaseCommand
{
  private String conditons;

  public CheckFindNewScheduleTaskListCommand(String conditons)  throws Exception
  {
    this.conditons = conditons;
  }
  public Object executeCommand() throws Exception
  {
    BLCheckFacade bLCheckFacade = new BLCheckFacade();
    return bLCheckFacade.findNewScheduleTaskList(conditons);
  }
}
