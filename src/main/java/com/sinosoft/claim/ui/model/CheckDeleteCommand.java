package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCheckFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CheckDeleteCommand extends BaseCommand
{
  private String checkNo;

  public CheckDeleteCommand(String checkNo)  throws Exception
  {
    this.checkNo = checkNo;
  }
  public Object executeCommand() throws Exception
  {
    BLCheckFacade bLCheckFacade = new BLCheckFacade();
    bLCheckFacade.delete(checkNo);
    return null;
  }
}
