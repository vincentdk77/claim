package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertifyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLcertifyFindByConCommand extends BaseCommand {
  private String conditions;

  public PrpLcertifyFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLCertifyFacade bLCertifyFacade = new BLCertifyFacade();
      return bLCertifyFacade.findByConditions(conditions);
  }
}
