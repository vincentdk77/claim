package com.sinosoft.claim.ui.model;

import com.sinosoft.function.insutil.bl.facade.BLBillFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class BillGetNoCommand extends BaseCommand {
  private String tableName = "";  //����
  private String comCode   = "";  //���Ŵ���
  private String riskCode  = "" ; //���ִ���
  private int    year      = 0 ;  //���
  private String pk1       ="";   //��һ������

  public BillGetNoCommand(String tableName,String riskCode,String comCode,int year)  throws Exception
  {
      this.tableName = tableName;
      this.comCode   = comCode;
      this.riskCode  = riskCode;
      this.year      = year;
  }
  
  public BillGetNoCommand(String tableName,String riskCode,String comCode,int year,String pk1)  throws Exception
  {
      this.tableName = tableName;
      this.comCode   = comCode;
      this.riskCode  = riskCode;
      this.year      = year;
      this.pk1       =pk1;
  }
  
  public Object executeCommand() throws Exception
  {
      String billNo = "";
      BLBillFacade blBillFacade = new BLBillFacade();
      billNo = blBillFacade.getNo(tableName,riskCode,comCode,year,"");
      return billNo;
  }

}
