package com.sinosoft.claim.query.ui.model;

import com.sinosoft.claim.query.bl.facade.BLEndorseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpPheadFindByConCommand extends BaseCommand {
  private String conditions;

  public PrpPheadFindByConCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLEndorseFacade blEndorseFacade = new BLEndorseFacade();
      return blEndorseFacade.findByPrpPheadConditions(conditions); 
  }
}
