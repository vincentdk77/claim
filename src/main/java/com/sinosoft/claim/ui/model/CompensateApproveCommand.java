package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateApproveCommand extends BaseCommand
{
  private String compensateNo;
  private String userCode;
  private String underWriteFlag;

  public CompensateApproveCommand(String compensateNo,String userCode,String underWriteFlag)  throws Exception
  {
      this.compensateNo = compensateNo;
      this.userCode = userCode;
      this.underWriteFlag = underWriteFlag;
  }
  public Object executeCommand() throws Exception
  {
      BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
      bLCompensateFacade.approve(compensateNo,userCode,underWriteFlag); 
      return null;
  }

}
