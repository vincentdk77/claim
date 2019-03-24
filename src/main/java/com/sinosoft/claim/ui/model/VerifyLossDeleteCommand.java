package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class VerifyLossDeleteCommand extends BaseCommand
{
  private String registNo;
  private String nodeType;

  public VerifyLossDeleteCommand(String registNo,String nodeType)  throws Exception
  {
    this.registNo = registNo;
    this.nodeType = nodeType;
  }
  public Object executeCommand() throws Exception
  {
    BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
    bLVerifyLossFacade.delete(registNo,nodeType);
    return null;
  }
}
