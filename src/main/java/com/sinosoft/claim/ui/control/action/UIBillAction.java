
package com.sinosoft.claim.ui.control.action;

import com.sinosoft.claim.ui.model.BillGetNoCommand;
import com.sinosoft.claim.ui.model.BillPutNoCommand;

/**
 * 取得单证号码
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */  
 
public class UIBillAction {
  public UIBillAction() {

  }
  /** 
   *
   * @param tableName String 表名
   * @param riskCode String  险种代码
   * @param comCode String   部门代码
   * @param year int         年
   * @throws Exception
   * @return String
   */
  public String getNo(String tableName,String riskCode,String comCode,int year) throws Exception
  {
    BillGetNoCommand billGetNoCommand = new BillGetNoCommand(tableName,riskCode,comCode,year);
    return (String)billGetNoCommand.executeCommand() ;
  }
  
   /** 
   *
   * @param tableName String 表名
   * @param riskCode String  险种代码
   * @param comCode String   部门代码
   * @param year int         年
   * @param pk1         如果是双主键，这个是第一key,返回的是要建立的第2个key
   * @throws Exception
   * @return String
   */
  public String getNo(String tableName,String riskCode,String comCode,int year,String pk1) throws Exception
  {
    BillGetNoCommand billGetNoCommand = new BillGetNoCommand(tableName,riskCode,comCode,year);
    return (String)billGetNoCommand.executeCommand() ;
  }
   /** 
  *
  * @param tableName String 表名
  * @param billNo String  案件号
  * @throws Exception
  * @return boolean
  */
 public boolean putNo(String tableName,String billNo) throws Exception
 {
   BillPutNoCommand billPutNoCommand = new BillPutNoCommand(tableName,billNo);
   return ((Boolean)billPutNoCommand.execute()).booleanValue();
 }
  
}
