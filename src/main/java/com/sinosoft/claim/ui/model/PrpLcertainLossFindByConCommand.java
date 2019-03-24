package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertainLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLcertainLossFindByConCommand extends BaseCommand {
  private String conditions;
  
  public PrpLcertainLossFindByConCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLCertainLossFacade bLCertainLossFacade = new BLCertainLossFacade();
    return bLCertainLossFacade.findByConditions(conditions);
  }
}
