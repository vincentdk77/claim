package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateFindByConCommand extends BaseCommand
{
  private String compensateNo;
  private String caseType;
  int type = 0;
  public CompensateFindByConCommand(String compensateNo)  throws Exception
  {
    this.compensateNo = compensateNo;
    type=1;
  }
  public CompensateFindByConCommand(String compensateNo,String caseType)  throws Exception
  {
    this.compensateNo = compensateNo;
    this.caseType = caseType;
    type=2;
  }

  public Object executeCommand() throws Exception
  {
    BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
    if(type==1){
        return bLCompensateFacade.findByPrimaryKey(compensateNo);
    }else{
    return bLCompensateFacade.findByPrimaryKey(compensateNo,caseType);
    }
  }

}
