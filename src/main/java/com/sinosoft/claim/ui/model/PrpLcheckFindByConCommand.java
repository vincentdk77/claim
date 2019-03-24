package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCheckFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLcheckFindByConCommand extends BaseCommand {
  private String conditions;

  public PrpLcheckFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLCheckFacade bLCheckFacade = new BLCheckFacade();
      return bLCheckFacade.findByConditions(conditions);
  }

}
