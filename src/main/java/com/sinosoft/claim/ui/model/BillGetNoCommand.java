package com.sinosoft.claim.ui.model;

import com.sinosoft.function.insutil.bl.facade.BLBillFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class BillGetNoCommand extends BaseCommand {
  private String tableName = "";  //表名
  private String comCode   = "";  //部门代码
  private String riskCode  = "" ; //险种代码
  private int    year      = 0 ;  //年份
  private String pk1       ="";   //第一个主键

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
