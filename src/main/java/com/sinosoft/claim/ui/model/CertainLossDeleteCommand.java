package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCertainLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CertainLossDeleteCommand extends BaseCommand
{
  private String registNo;

  public CertainLossDeleteCommand(String registNo)  throws Exception
  {
    this.registNo = registNo;
  }
  public Object executeCommand() throws Exception
  {
    BLCertainLossFacade bLCertainLossFacade = new BLCertainLossFacade();
    bLCertainLossFacade.delete(registNo);
    return null;
  }
}
