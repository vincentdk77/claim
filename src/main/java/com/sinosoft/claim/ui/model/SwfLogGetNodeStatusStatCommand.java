package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class SwfLogGetNodeStatusStatCommand extends BaseCommand
{
  private String conditions;

  public SwfLogGetNodeStatusStatCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
      return bLSwfLogFacade.getNodeStatusStat(this.conditions);
  }

}

