package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndcaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLendcaseFindByConCommand extends BaseCommand {
  private String conditions;

  public PrpLendcaseFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLEndcaseFacade bLEndcaseFacade = new BLEndcaseFacade();
      return bLEndcaseFacade.findByConditions(conditions);
  }
}
