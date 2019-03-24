package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class SamePolicyRegistFindByConCommand extends BaseCommand {
  private String conditions;

  public SamePolicyRegistFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLRegistFacade bLRegistFacade = new BLRegistFacade();
      return bLRegistFacade.findSamePolicyRegist(conditions);
  }

}
