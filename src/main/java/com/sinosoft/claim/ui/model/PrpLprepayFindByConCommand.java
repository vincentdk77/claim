package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLprepayFindByConCommand extends BaseCommand {
  private String conditions;

  public PrpLprepayFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
      return bLPrepayFacade.findByConditions(conditions);
  }
}
