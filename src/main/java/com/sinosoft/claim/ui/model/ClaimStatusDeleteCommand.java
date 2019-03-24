package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimStatusFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimStatusDeleteCommand extends BaseCommand
{
 private String claimStatusNo;
  private String nodeType;
  private int serialNo;

  public ClaimStatusDeleteCommand(String claimStatusNo,String nodeType,int serialNo)  throws Exception
  {
    this.claimStatusNo = claimStatusNo;
    this.nodeType = nodeType;
    this.serialNo = serialNo;
  }
  public Object executeCommand() throws Exception
  {
    BLClaimStatusFacade bLClaimStatusFacade = new BLClaimStatusFacade();
    bLClaimStatusFacade.delete(claimStatusNo,nodeType,serialNo);
    return null;
  }
}
