package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimGetNoEndCaseCommand extends BaseCommand
{
  private String iWherePart;
  private String iOtherWherePart;
  public ClaimGetNoEndCaseCommand(String iWherePart,String iOtherWherePart)  throws Exception
  {
    this.iWherePart = iWherePart;
    this.iOtherWherePart=iOtherWherePart;
  }
  public Object executeCommand() throws Exception
  {
    BLClaimFacade blClaimFacade = new BLClaimFacade();
      return blClaimFacade.getNoEndCaseClaim(this.iWherePart,this.iOtherWherePart);
  }

}

