package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateIsExistCommand extends BaseCommand
{
  private String compensateNo;

  public CompensateIsExistCommand(String compensateNo)  throws Exception
  {
    this.compensateNo = compensateNo;
  }
  public Object executeCommand() throws Exception
  {
    BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
    return new Boolean(bLCompensateFacade.isExist(compensateNo));
  }

}
