package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class SwfLogGetNodeUserStatusStatCommand extends BaseCommand
{
  private String conditions;

  public SwfLogGetNodeUserStatusStatCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
      return bLSwfLogFacade.getNodeUserStatusStat(this.conditions);
  }

}

