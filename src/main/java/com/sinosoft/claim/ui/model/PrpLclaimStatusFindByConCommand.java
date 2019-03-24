package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimStatusFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLclaimStatusFindByConCommand extends BaseCommand {
  private String conditions;

  public PrpLclaimStatusFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLClaimStatusFacade bLClaimStatusFacade = new BLClaimStatusFacade();
      return bLClaimStatusFacade.findByConditions(conditions);
  }

}
