/**
 * <p>Title: BLBillFacade</p>
 * <p>Description:����ȡ���� </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author Liuguoan
 * @version 1.0
 */
package com.sinosoft.function.insutil.bl.facade;

import java.util.*;
import java.sql.*;
import com.sinosoft.sysframework.reference.*;
import com.sinosoft.sysframework.common.util.*;
import com.sinosoft.sysframework.common.datatype.*;
import com.sinosoft.function.insutil.bl.action.custom.BLBillAction;

public class BLBillFacade
{
  /**
   * ���췽��
   */
  public BLBillFacade()
  {
  }

  /**
   * ��ȵ��ų�ʼ����������ʼ����
   * @param iRiskSchemas ���ִ�������
   * @param iCompanySchemas ������������
   * @param iTableSchemas   ���ݱ�����
   * @param iYear 4λ���
   * @param iInitNo ��ʼ�����
   * @return true/false  ������ʼ���ɹ�/ʧ��
   * @throws SQLException,Exception,UserException
   */
  public boolean batchInitNo(Vector iRiskSchemas,Vector iCompanySchemas,Vector iTableSchemas,
                             String iYear,String iInitNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturnFlag = batchInitNo(dbManager,iRiskSchemas,iCompanySchemas,iTableSchemas,iYear,iInitNo);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return blnReturnFlag;
  }

  /**
   * ��ȵ��ų�ʼ��
   * @param dbManager ���ݿ����ӳ�
   * @param iRiskSchemas ���ִ�������
   * @param iCompanySchemas ������������
   * @param iTableSchemas   ���ݱ�����
   * @param iYear 4λ���
   * @param iInitNo ��ʼ�����
   * @return ��
   * @throws SQLException,Exception,UserException
   */
  public boolean batchInitNo(DBManager dbManager,Vector iRiskSchemas,Vector iCompanySchemas,Vector iTableSchemas,
                             String iYear,String iInitNo) throws SQLException,Exception
  {
    return new BLBillAction().batchInitNo(dbManager,iRiskSchemas,iCompanySchemas,iTableSchemas,iYear,iInitNo);
  }

  /**
   * ��ȡһ���º�
   * @param  iTableName:�������ݱ���
   * @param  iRiskCode:���ִ���
   * @param  iComCode:��������
   * @param  iYear:ҵ�����
   * @return �����ַ���
   * @throws UserException
   * @throws Exception
   */
  public String getNo(String iTableName,String iRiskCode,String iComCode,int iYear,String iSessionID)
      throws SQLException,Exception
  {
    String strBillNo = "";
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      strBillNo = getNo(dbManager,iTableName,iRiskCode,iComCode,iYear,iSessionID);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return strBillNo;
  }

  /**
   * ��ȡһ���º�
   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * String billNo = BLBillFacade.getNo(dbManager,"prptmain","DAA","31010005",2004,"SessionID")
   * if (billNo.length()=0)
   *    alert("��ȡ����ʧ��")
   * execute series of actions
   * if (succeed in executing them){
   *    BLBillFacade.deleteNo(dbManager,"prptmain",billNo);
   * }
   * else{
   *    BLBillFacade.putNo(dbManager,"prptmain",billNo);
   * }
   * </pre>
   * @param  dbManager ���ݿ����ӳ�
   * @param  iTableName:�������ݱ���
   * @param  iRiskCode:���ִ���
   * @param  iComCode:��������
   * @param  iYear:ҵ�����
   * @return �����ַ���
   * @throws UserException
   * @throws Exception
   */
  public String getNo(DBManager dbManager,String iTableName,String iRiskCode,String iComCode,int iYear,String iSessionID)
      throws SQLException,Exception
  {
    String strBillNo = "";
    strBillNo = new BLBillAction().getNo(dbManager,iTableName,iRiskCode,iComCode,iYear,iSessionID);
    return strBillNo;
  }

  /**
   * ��������
   * @param iTableName ���ݱ���
   * @param iBillNo    ����
   * @param iGroupNo   ���
   * @return strBillNo ������ĵ���
   */
  public String pullNo(String iTableName,String iBillNo,String iGroupNo) throws Exception
  {
    String strBillNo = "";
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      strBillNo = pullNo(dbManager,iTableName,iBillNo,iGroupNo);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return strBillNo;
  }

  /**
   * ��������
   * @param dbManager ���ݿ����ӳ�
   * @param iTableName ���ݱ���
   * @param iBillNo    ����
   * @param iGroupNo   ���
   * @return strBillNo ������ĵ���
   */
  public String pullNo(DBManager dbManager,String iTableName,String iBillNo,String iGroupNo) throws Exception
  {
    String strBillNo = "";
    strBillNo = new BLBillAction().pullNo(dbManager,iTableName,iBillNo,iGroupNo);
    return strBillNo;
  }

  /**
   * ���ż��
   * @param iTableName ���ݱ�
   * @param iBillNo    ����
   * @param iGroupNo   ���
   * @param iCheckFlag �������
   * @return true/false  ���ż��ɹ����Ϸ���/���ż��ʧ�ܣ����Ϸ���
   * @throws Exception
   */
  public boolean checkNo(String iTableName,String iBillNo,String iGroupNo,String iCheckFlag) throws Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturnFlag = checkNo(dbManager,iTableName,iBillNo,iGroupNo,iCheckFlag);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return blnReturnFlag;
  }

  /**
   * ���ż��
   * @param dbManager ���ݿ����ӳ�
   * @param iTableName ���ݱ�
   * @param iBillNo    ����
   * @param iGroupNo   ���
   * @param iCheckFlag �������
   * @return true/false  ���ż��ɹ����Ϸ���/���ż��ʧ�ܣ����Ϸ���
   * @throws Exception
   */
  public boolean checkNo(DBManager dbManager,String iTableName,String iBillNo,String iGroupNo,String iCheckFlag) throws Exception
  {
    return new BLBillAction().checkNo(dbManager,iTableName,iBillNo,iGroupNo,iCheckFlag);
  }


  /**
   * �Ż��µ���
   * @param strTableName ���ݱ���
   * @param strBillNo  ����
   * @return true/false  �źųɹ�/�ź�ʧ��
   * @throws Exception,SQLException,UserException
   */
  public boolean putNo(String iTableName,String iBillNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturnFlag = putNo(dbManager,iTableName,iBillNo);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return blnReturnFlag;
  }

  /**
   * �Ż��µ��ţ�getNo��ȡ�µ���֮�����ִ��ҵ�����ʧ�ܣ�����Żظõ��ţ�
   *   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * String billNo = BLBillFacade.getNo(dbManager,"prptmain","DAA","31010005",2004,"SessionID")
   * if (billNo.length()=0)
   *    alert("��ȡ����ʧ��")
   * execute series of actions
   * if (succeed in executing them){
   *    BLBillFacade.deleteNo(dbManager,"prptmain",billNo);
   * }
   * else{
   *    BLBillFacade.putNo(dbManager,"prptmain",billNo);
   * }
   * </pre>
   * @param dbManager ���ݿ����ӳ�
   * @param strTableName ���ݱ���
   * @param strBillNo  ����
   * @return true/false  �źųɹ�/�ź�ʧ��
   * @throws Exception,SQLException,UserException
   */
  public boolean putNo(DBManager dbManager,String iTableName,String iBillNo)
      throws SQLException,Exception
  {
    return new BLBillAction().putNo(dbManager,iTableName,iBillNo);
  }


  /**
   * �ɹ���ɾ����ȡ�ĵ���
   * @param strTableName  ���ű���
   * @param strBillNo	 ��֤��
   * @return true/false   ɾ�ųɹ�/ɾ��ʧ��
   * @throws Exception,SQLException,UserException
   */
  public boolean deleteNo(String iTableName,String iBillNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturnFlag = deleteNo(dbManager,iTableName,iBillNo);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return blnReturnFlag;
  }

  /**
   * �ɹ���ɾ����ȡ�ĵ��ţ�getNo��ȡ�µ���֮�����ִ��ҵ������ɹ�������ɾ���õ��ţ�
   *   * <br>
   * <br>
   * <b>ʾ��: </b>
   * <pre>
   * String billNo = BLBillFacade.getNo(dbManager,"prptmain","DAA","31010005",2004,"SessionID")
   * if (billNo.length()=0)
   *    alert("��ȡ����ʧ��")
   * execute series of actions
   * if (succeed in executing them){
   *    BLBillFacade.deleteNo(dbManager,"prptmain",billNo);
   * }
   * else{
   *    BLBillFacade.putNo(dbManager,"prptmain",billNo);
   * }
   * </pre>
   * @param dbManager ���ݿ����ӳ�
   * @param strTableName  ���ű���
   * @param strBillNo	 ��֤��
   * @return true/false   ɾ�ųɹ�/ɾ��ʧ��
   * @throws Exception,SQLException,UserException
   */
  public boolean deleteNo(DBManager dbManager,String iTableName,String iBillNo)
      throws SQLException,Exception
  {
    return new BLBillAction().deleteNo(dbManager,iTableName,iBillNo);
  }

  /**
   * �ֹ�ռ��
   * @param iTableName  ���ű���
   * @param iBillNo	 ��֤��
   * @return true/false  ռ�ųɹ�/ռ��ʧ��
   * @throws UserException
   * @throws Exception
   */
  public boolean occupy(String iTableName,String iBillNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //�����ӳ�
      blnReturnFlag = occupy(dbManager,iTableName,iBillNo);
      dbManager.close();
    }
    catch(Exception e)
    {
      throw e;
    }
    finally
    {
      dbManager.close();
    }

    return blnReturnFlag;
  }

  /**
   * �ֹ�ռ��
   * @param dbManager ���ݿ����ӳ�
   * @param iTableName  ���ű���
   * @param iBillNo	 ��֤��
   * @return true/false  ռ�ųɹ�/ռ��ʧ��
   * @throws UserException
   * @throws Exception
   */
  public boolean occupy(DBManager dbManager,String iTableName,String iBillNo) throws SQLException,Exception
  {
    return new BLBillAction().occupy(dbManager,iTableName,iBillNo);
  }

  /**
   * ��ȡ���
   * @param dbManager   ���ݿ����ӳ�
   * @param iTableName  ���ű���
   * @param iRiskCode   ���ִ���
   * @param iComCode    ��������
   * @param iYear       ���
   * @return groupNo    ���
   * @throws Exception
   */
  public String getGroupNo(DBManager dbManager,String iTableName,String iRiskCode,String iComCode,String iYear)
      throws Exception
  {
    return new BLBillAction().getGroupNo(dbManager,iTableName,iRiskCode,iComCode,iYear);
  }

  /**
   * ���ݵ��Ź����֣���������漰���飬���ֳɱ�������ţ�
   * @param dbManager   ���ݿ����ӳ�
   * @param iTableName  ���ű���
   * @param iRiskCode   ����
   * @return pickNo[3]  [0]��ͷ [1]��� [2]��ˮ��
   * @throws Exception
   */
  public String[] pickNo(DBManager dbManager,String iTableName,String iBillNo) throws Exception
  {
    return new BLBillAction().pickNo(dbManager,iTableName,iBillNo);
  }

}
