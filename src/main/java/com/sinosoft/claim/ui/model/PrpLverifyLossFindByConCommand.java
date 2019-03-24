package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLverifyLossFindByConCommand extends BaseCommand {
  private String conditions;
  
  public PrpLverifyLossFindByConCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
    return bLVerifyLossFacade.findByConditions(conditions);
  }
}
