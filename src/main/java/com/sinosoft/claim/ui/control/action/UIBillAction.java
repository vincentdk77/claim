
package com.sinosoft.claim.ui.control.action;

import com.sinosoft.claim.ui.model.BillGetNoCommand;
import com.sinosoft.claim.ui.model.BillPutNoCommand;

/**
 * ȡ�õ�֤����
 * <p>Title: ��������</p>
 * <p>Description: ����������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */  
 
public class UIBillAction {
  public UIBillAction() {

  }
  /** 
   *
   * @param tableName String ����
   * @param riskCode String  ���ִ���
   * @param comCode String   ���Ŵ���
   * @param year int         ��
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
   * @param tableName String ����
   * @param riskCode String  ���ִ���
   * @param comCode String   ���Ŵ���
   * @param year int         ��
   * @param pk1         �����˫����������ǵ�һkey,���ص���Ҫ�����ĵ�2��key
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
  * @param tableName String ����
  * @param billNo String  ������
  * @throws Exception
  * @return boolean
  */
 public boolean putNo(String tableName,String billNo) throws Exception
 {
   BillPutNoCommand billPutNoCommand = new BillPutNoCommand(tableName,billNo);
   return ((Boolean)billPutNoCommand.execute()).booleanValue();
 }
  
}
