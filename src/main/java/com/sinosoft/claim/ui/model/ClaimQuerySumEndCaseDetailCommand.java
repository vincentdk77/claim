package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimQuerySumEndCaseDetailCommand extends BaseCommand
{
  private String iWherePart;
  private String iOtherWherePart;
  public ClaimQuerySumEndCaseDetailCommand(String iWherePart)  throws Exception
  {
    this.iWherePart = iWherePart;
  }
  public Object executeCommand() throws Exception
  {
    BLClaimFacade blClaimFacade = new BLClaimFacade();
      return blClaimFacade.querySumEndCaseDetail(this.iWherePart);
  }

}

