package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLWorkFlowFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimStatusGetStatCommand extends BaseCommand {
  private String conditions;

  public ClaimStatusGetStatCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLWorkFlowFacade bLWorkFlowFacade = new BLWorkFlowFacade();
      return bLWorkFlowFacade.getStatStatus(conditions);
  }

}
