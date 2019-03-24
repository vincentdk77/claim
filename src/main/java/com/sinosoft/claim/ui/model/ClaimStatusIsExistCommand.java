package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimStatusFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimStatusIsExistCommand extends BaseCommand
{
  private String claimStatusNo;
  private String nodeType;
  private int serialNo;

  public ClaimStatusIsExistCommand(String claimStatusNo,String nodeType,int serialNo)  throws Exception
  {
    this.claimStatusNo = claimStatusNo;
    this.nodeType = nodeType;
    this.serialNo = serialNo;
  }
  public Object executeCommand() throws Exception
  {
    BLClaimStatusFacade bLClaimStatusFacade = new BLClaimStatusFacade();
    return new Boolean(bLClaimStatusFacade.isExist(claimStatusNo,nodeType,serialNo));
  }

}
