/**
 * <p>Title: BLPowerFacade</p>
 * <p>Description:Ȩ�޹����� </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author Liuguoan,weishixin
 * @version 1.0
 */

package com.sinosoft.function.power.bl.facade;

import com.sinosoft.function.power.bl.action.custom.BLPowerAction;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLPowerFacadeBase
{ 

  /**
   * ���췽��
   */
  public BLPowerFacadeBase()
  {
  }
  /**
   * �����ⲿ�����Ա������+���ִ���+�������+���ݱ�����ȡ��ѯ��������Ȩ��
   * @param  iUserCode    Ա������
   * @param  iRiskCode    ���ִ���
   * @param  iTaskCode    �������
   * @param  iTableName   ��ѯ����
   * @return ���Ӳ�ѯ�����ַ��������磺AND ( 1=1 OR 1=0 )��
   * @throws UserException,Exception
   */
  public String addPower(String iUserCode,String iRiskCode,String iTaskCode,String iTableName) throws UserException,Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    String  strPowerCondition = ""; //Ȩ������
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�

    strPowerCondition = blPowerAction.getPowerCondition(dbManager,iUserCode,iRiskCode,iTaskCode,iTableName);
    }
    catch (Exception e) {
       throw e;
    }
    finally {
      dbManager.close();
   }

    return strPowerCondition;
  }
  /* add by liuning begin 20031113 */
  /**
   * �����ⲿ�����Ա������+���ִ���+�������+���ݱ�����ȡ��ѯ��������Ȩ��
   * @param  iUserCode    Ա������
   * @param  iRiskCode    ���ִ���
   * @param  iGroupCode   Ȩ����Ŵ���
   * @param  iTaskCode    �������
   * @param  iTableName   ��ѯ����
   * @return ���Ӳ�ѯ�����ַ��������磺AND ( 1=1 OR 1=0 )��
   * @throws UserException,Exception
   */
  public String addPower(String iUserCode,String iRiskCode,String iGroupCode,String iTaskCode,String iTableName) throws UserException,Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    String  strPowerCondition = ""; //Ȩ������
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�

      strPowerCondition = blPowerAction.getPowerCondition(dbManager,iUserCode, iRiskCode,
          iGroupCode, iTaskCode, iTableName);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return strPowerCondition;
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
   * @throws UserException,Exception
   */
  public boolean checkPower(String userCode,String riskCode,String groupCode,String taskCode,String checkCode)
      throws UserException,Exception
  {
    boolean blnReturnFlag = false;
    BLPowerAction blPowerAction = new BLPowerAction();
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�

      String strPowerValue = blPowerAction.getPowerValue(dbManager,userCode,riskCode,groupCode,taskCode,checkCode);
      if (strPowerValue.trim().equals("0") || strPowerValue.length() == 0) {
        blnReturnFlag = false;
      }
      else {
        blnReturnFlag = true;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return blnReturnFlag;
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
  public boolean checkPower(String userCode,String riskCode,String taskCode,String checkCode)
      throws UserException,Exception
  {
    boolean blnReturnFlag = false;
    BLPowerAction blPowerAction = new BLPowerAction();
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�

      //System.out.println("----checkPower----1---"+userCode+"|"+riskCode+"|"+taskCode+"|"+checkCode);    
      String strPowerValue = blPowerAction.getPowerValue(dbManager, userCode,riskCode, taskCode, checkCode);
      //System.out.println("----checkPower----2---"+strPowerValue);    
      if (strPowerValue.trim().equals("0") || strPowerValue.length() == 0) {
        blnReturnFlag = false;
      }
      else {
        blnReturnFlag = true;
      }
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return blnReturnFlag;
  }


  /**
   * �˶Բ���Ա�Ƿ��ܹ���½��Ӧϵͳ
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_PRP);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_ACCOUNT);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_REINS);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_VISA);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_UNDERWRITE);
   * </pre>
   * @param  iUserCode    Ա������
   * @param  iSystemName  ��½ϵͳ����("prp","account","reins","visa","underwrite")
   * @return blnfound    �Ƿ��ܹ���½��־���ܹ���½����true�����ܵ�½����false
   * @throws Exception   �쳣
   */
  public boolean checkLogin(String userCode,String systemName) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    boolean blnReturn = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�

      blnReturn = blPowerAction.checkLogin(dbManager, userCode, systemName);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return blnReturn;
  }


  /**
   * �˶Բ���Ա�����Ƿ���ȷ
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * BLPowerFacade.checkPassword("0000000000","0000","ASDHKJHDKHSKSJSJ");
   * </pre>
   * @param  iUserCode    Ա������
   * @param  iPassword    Ա������(���룩
   * @return blnfound     �����Ƿ���ȷ��־����ȷ����true�����󷵻�false
   * @throws Exception    �쳣
   */
  public boolean checkPassword(String userCode,String password) throws Exception
  {

    BLPowerAction blPowerAction = new BLPowerAction();
    boolean blnReturn = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturn = blPowerAction.checkPassword(dbManager, userCode, password);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return blnReturn;
  }

  /**
   * �˶Բ���Աӡ���Ƿ���ȷ
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkSeal("0000000000","0000");
   * </pre>
   * @param  userCode    Ա������
   * @param  seal        ӡ��
   * @return blnfound    �����Ƿ���ȷ��־����ȷ����true�����󷵻�false
   * @throws Exception   �쳣
   */
  public boolean checkSeal(String userCode,String seal) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    boolean blnReturn = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturn = blPowerAction.checkSeal(dbManager, userCode, seal);
    }
    catch(Exception e)
    {
      throw e;
    }
    finally {
      dbManager.close();
    }

    return blnReturn;
  }


}

