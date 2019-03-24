package com.sinosoft.function.power.ui.action;
import java.util.*;
import com.sinosoft.function.power.ui.model.*;

/**
 * UI��Ȩ��У��
 * <p>Title: ����UI��Ȩ��У��</p>
 * <p>Description: ����UI��Ȩ��У��</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIPowerAction {
  public UIPowerAction()
  {
  }
  /**
 * �����ⲿ���������У���Ƿ���Ȩ��,�����޹�
 * <br>
 * <b>ʾ��: </b>
 * <pre>
 * boolean successFlag = BLPowerFacade.checkPower("0000000000","DAA","01",
 *                        ,"tb",PowerConst.CHECKCODE_READ);
 * </pre>
 * @param  userCode    Ա������
 * @param  riskCode    ���ִ���
 * @param  groupCode   Ȩ�����
 * @param  taskCode    �������
 * @param  checkCode   ��������
 * @return true/false  true:��Ȩ��/false:��Ȩ��
 * @throws Exception
 */
  public boolean checkPower(String userCode,String riskCode,String groupCode,String taskCode,String checkCode) throws Exception
  {
     Boolean checkReturn = null;
     PowerCheckPowerCommand powerCheckPowerCommand = new PowerCheckPowerCommand(userCode,riskCode,groupCode,taskCode,checkCode);
     checkReturn = (Boolean)powerCheckPowerCommand.execute() ;
     return checkReturn.booleanValue() ;
  }
 
  /**
   * �����ⲿ���������У���Ƿ���Ȩ��,�������
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkPower("0000000000","DAA",
   *                        ,"tb",PowerConst.CHECKCODE_READ);
   * </pre>
   * @param  userCode    Ա������
   * @param  riskCode    ���ִ���
   * @param  taskCode    �������
   * @param  checkCode   ��������
   * @return true/false  true:��Ȩ��/false:��Ȩ��
   * @throws UserException,Exception
   */

  public boolean checkPower(String userCode,String groupCode,String taskCode,String checkCode) throws Exception
  {
    Boolean checkReturn = null ;
    PowerCheckPowerRiskCommand powerCheckPowerRiskCommand = new PowerCheckPowerRiskCommand(userCode,groupCode,taskCode,checkCode);
     checkReturn = (Boolean)powerCheckPowerRiskCommand.execute() ;
     return checkReturn.booleanValue() ;

  }
  /**
   * �����ⲿ�����Ա������+���ִ���+�������+���ݱ�����ȡ��ѯ��������Ȩ��
   * @param  userCode String
   * @param  riskCode String
   * @param  taskCode String
   * @param  tableName String
   * @throws Exception
   * @return String
   */
  public String addPower(String userCode,String riskCode,String taskCode,String tableName) throws Exception
  {
     String powerReturn = null;
     PowerAddPowerCommand powerAddPowerCommand = new PowerAddPowerCommand(userCode,riskCode,taskCode,tableName);
     powerReturn = (String)powerAddPowerCommand.execute() ;
     return powerReturn;
  }
  /**
   * ���ݸ�λ�����񣩼����֣������������ĳ��λ����ԱȨ��
   * @param conditions String  ����
   * @throws Exception
   * @return Collection
   */
  public Collection findByTask(String conditions) throws Exception
  {
     Collection collection = new ArrayList();
     PowerFindByTaskCommand powerFindByTaskCommand = new PowerFindByTaskCommand(conditions);
     collection = (Collection)powerFindByTaskCommand.execute() ;
     return collection;

  }
}
