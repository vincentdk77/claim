package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertainLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertainLossIsExistCommand extends BaseCommand
{
  private String registNo;
  private String lossItemCode;

  public CertainLossIsExistCommand(String registNo ,String lossItemCode)  throws Exception
  {
    this.registNo = registNo;
    this.lossItemCode =lossItemCode;
  }
  public Object executeCommand() throws Exception
  {
    BLCertainLossFacade bLCertainLossFacade = new BLCertainLossFacade();
    return new Boolean(bLCertainLossFacade.isExist(registNo,lossItemCode));
  }
}
