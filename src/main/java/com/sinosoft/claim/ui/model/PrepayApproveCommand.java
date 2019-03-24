package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrepayApproveCommand extends BaseCommand
{
  private String prepayNo;
  private String userCode;
  private String underWriteFlag;

  public PrepayApproveCommand(String prepayNo,String userCode,String underWriteFlag)  throws Exception
  {
      this.prepayNo = prepayNo;
      this.userCode = userCode;
      this.underWriteFlag = underWriteFlag;
  }
  public Object executeCommand() throws Exception
  {
      BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
      bLPrepayFacade.approve(prepayNo,userCode,underWriteFlag); 
      return null;
  }

}
