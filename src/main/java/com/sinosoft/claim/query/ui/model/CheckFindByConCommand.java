package com.sinosoft.claim.query.ui.model;

import com.sinosoft.claim.query.bl.facade.BLCheckFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CheckFindByConCommand extends BaseCommand
{
  private String checkNo;

  public CheckFindByConCommand(String checkNo)  throws Exception
  {
    this.checkNo = checkNo;
  }
  public Object executeCommand() throws Exception
  {
    BLCheckFacade bLCheckFacade = new BLCheckFacade();
    return bLCheckFacade.findByPrimaryKey(checkNo);
  }
}
