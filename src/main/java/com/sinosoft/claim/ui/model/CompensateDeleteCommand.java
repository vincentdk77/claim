package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateDeleteCommand extends BaseCommand
{
  private String compensateNo;

  public CompensateDeleteCommand(String compensateNo)  throws Exception
  {
    this.compensateNo = compensateNo;
  }
  public Object executeCommand() throws Exception
  {
    BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
    bLCompensateFacade.delete(compensateNo);
    return null;
  }

}
