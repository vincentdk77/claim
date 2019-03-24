package com.sinosoft.claim.ui.model;

import com.sinosoft.function.insutil.bl.facade.BLBillFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class BillPutNoCommand extends BaseCommand {
  private String tableName = "";  //����
  private String billNo  = "" ; //����


  public BillPutNoCommand(String tableName,String billNo)  throws Exception
  {
      this.tableName = tableName;
      this.billNo   = billNo;
  }
  
  
  public Object executeCommand() throws Exception
  {
      BLBillFacade blBillFacade = new BLBillFacade();
      return new Boolean(blBillFacade.putNo(tableName,billNo));
  }

}
