package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class VerifyLossIsExistCommand extends BaseCommand
{
  private String registNo;
  private String lossItemCode;
  private String nodeType;

  public VerifyLossIsExistCommand(String registNo,String lossItemCode,String nodeType)  throws Exception
  {
    this.registNo = registNo;
    this.lossItemCode =lossItemCode;
    this.nodeType =nodeType;
  }
  public Object executeCommand() throws Exception
  {
    BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
    return new Boolean(bLVerifyLossFacade.isExist(registNo,lossItemCode,nodeType));
  }
}
