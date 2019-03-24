package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCodeAction;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * �����ȡ�߼�
 * <p>Title: ��������</p>
 * <p>Description: ����������������</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author ��Ŀ��
 * @version 1.0
 */
public class BLCodeFacade
{
  public Collection findByConditions(String codetype,String conditions,int pageNo,int rowsPerPage) throws Exception
  {
     return new BLCodeAction().findByConditions(codetype,conditions,pageNo,rowsPerPage);
  }
  
  public Collection findByConditions(String conditions) throws Exception
  {
     return new BLCodeAction().findByConditions(conditions);
  }
  
 /**
  * ���ػ������ƣ������б�
  * @return Collection �����ѯ
  * @throws SQLException
  * @throws Exception
  */
  public Collection getCurrencyList() throws Exception
  {
      return new BLCodeAction().getCurrencyList();
  } 
  
  /**
   * �������������б�
   * @return Collection �����ѯ
   * @throws SQLException
   * @throws Exception
   */
  public Collection getDeductCondition(String riskCode) throws Exception{
	  return new BLCodeAction().getDeductCondition(riskCode);
  }

 /**
  * ����ҵ�����ͼ����ֲ�ѯҵ�����
  * @param  codetype��ҵ������
  * @param  riskcode�����ִ���
  * @return PrpDcodeDto �����ѯ
  * @throws SQLException
  * @throws Exception
  */
  public Collection getCodeType(String codetype,String riskcode) throws Exception
  {
      return new BLCodeAction().getCodeType(codetype,riskcode);
  }

  /**
   * ���ݿͻ������ѯ�ͻ����
   * @param  customerCode���ͻ�����
   * @return  �ͻ����
   * @throws SQLException
   * @throws Exception
   */
 public String getCustomerType(String customerCode)
     throws Exception
 {
 	return new BLCodeAction().getCustomerType(customerCode);
 }
   
 /**
  * ���ݻ��������ѯ�ͻ�����
  * @param  comCode����������
  * @return  �ͻ�����
  * @throws SQLException
  * @throws Exception
  */
public String getComLevel(String comCode)
    throws Exception
{
	return new BLCodeAction().getComLevel(comCode);
}
   
  /**
  * ���ݹ���������ѯ�Ḷ��˾��Ϣ
  * @param  comcode��������������
  * @return PrpDcompanyDto ��������
  * @throws SQLException
  * @throws Exception
  */
   public PrpDcompanyDto getPayInfo(String comcode) throws Exception
   {
     return new BLCodeAction().getPayInfo(comcode);
   }
   /**
    * �����û������ѯ�û�
    * @param userCode String
    * @param isChinese boolean
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateUserCode(String userCode,boolean isChinese) throws SQLException,Exception
   {
     String userName = "" ;
     if (userCode == null||userCode.equals(""))
     {
       userName = "";
     }
     DBManager dbManager = new DBManager();
     try
       {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          userName = new BLCodeAction().translateUserCode(dbManager,userCode,isChinese) ;
       }
       catch (Exception ex)
       {
          throw ex;
       }
       finally
       {
          dbManager.close();
       }
       return userName ;
   }

   /**
    * ���ݴ������ͺʹ����ѯ��������
    * @param codeType String
    * @param codeCode String
    * @param isChinese boolean
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateCodeCode(String codeType,String codeCode,boolean isChinese) throws SQLException,Exception
   {
     String codeName = "" ;
     DBManager dbManager = new DBManager();
     try
       {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          codeName = new BLCodeAction().translateCodeCode(dbManager,codeType,codeCode,isChinese) ;
       }
       catch (Exception ex)
       {
          throw ex;
       }
       finally
       {
          dbManager.close();
       }
       return codeName ;
   }
 
   //add prpdlimit�����ת��
   public String translateLimit(String riskCode,String limitCode,boolean isChinese) throws SQLException,Exception
   {
     String limitName = "" ;
     DBManager dbManager = new DBManager();
     try
       {
          dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
          limitName = new BLCodeAction().translateLimit(dbManager,riskCode,limitCode,isChinese) ;
       }
       catch (Exception ex)
       {
          throw ex;
       }
       finally
       {
          dbManager.close();
       }
       return limitName ;
   }
   
   
   /**
    * �������֣����մ����ѯ����
    * @param riskCode String
    * @param kindCode String
    * @param isChinese boolean
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateKindCode(String riskCode,String kindCode,boolean isChinese) throws SQLException,Exception
   {
    String codeName = "" ;
    DBManager dbManager = new DBManager();
    try
      {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         codeName = new BLCodeAction().translateKindCode(dbManager,riskCode,kindCode,isChinese) ;
      }
      catch (Exception ex)
      {
         throw ex;
      }
      finally
      {
         dbManager.close();
      }
      return codeName ;
  }
   
   /**
    * �������֣���Ĵ����ѯ�������
    * @param riskCode String
    * @param kindCode String
    * @param isChinese boolean
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateItemCode(String riskCode,String itemCode,boolean isChinese) throws SQLException,Exception
   {
    String codeName = "" ;
    DBManager dbManager = new DBManager();
    try
      {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         codeName = new BLCodeAction().translateItemCode(dbManager,riskCode,itemCode,isChinese) ;
      }
      catch (Exception ex)
      {
         throw ex;
      }
      finally
      {
         dbManager.close();
      }
      return codeName ;
  }
   
  /**
   * ���ݱұ����õ��ұ�����
   * @param currencyCode String
   * @param isChinese boolean
   * @throws SQLException
   * @throws Exception
   * @return String
   */

  public String translateCurrencyCode(String currencyCode,boolean isChinese) throws SQLException,Exception
  {
   String codeName = "" ;
   DBManager dbManager = new DBManager();
   try
     {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        codeName = new BLCodeAction().translateCurrencyCode(dbManager,currencyCode,isChinese) ;
     }
     catch (Exception ex)
     {
        throw ex;
     }
     finally
     {
        dbManager.close();
     }
     return codeName ;
 }
 /**
  * ���ݹ�˾����õ���˾����
  * @param comCode String
  * @param isChinese boolean
  * @throws SQLException
  * @throws Exception
  * @return String
  */
 public String translateComCode(String comCode, boolean isChinese) throws
     SQLException, Exception {
   String codeName = "";
   DBManager dbManager = new DBManager();
   try {
     dbManager.open(AppConfig.get("sysconst.DBJNDI"));
     codeName = new BLCodeAction().translateComCode(dbManager,
         comCode, isChinese);
   }
   catch (Exception ex) {
     throw ex;
   }
   finally {
     dbManager.close();
   }
   return codeName;
 }
 
  /**
  * ���ݱ��������ѯ��Ӧ���ⰸ����
  * @param comCode String
  * @param isChinese boolean
  * @throws SQLException
  * @throws Exception
  * @return String
  */
 public String translateBusinessCode(String businessNo, boolean isChinese) throws
     SQLException, Exception {
   String codeName = "";
   DBManager dbManager = new DBManager();
   try {
     dbManager.open(AppConfig.get("sysconst.DBJNDI"));
     codeName = new BLCodeAction().translateBusinessCode(dbManager,
         businessNo, isChinese);
   }
   catch (Exception ex) {
     throw ex;
   }
   finally {
     dbManager.close();
   }
   return codeName;
 }
 
 
 /**
  * ���ݱ����Ų�ѯ��ص���س��ƺ�����б�
  * @param  registNo  ������
  * @throws SQLException
  * @throws Exception
  */
  public Collection getLicenseNoList(String registNo) throws Exception
  {
      return new BLCodeAction().getLicenseNoList(registNo);
  }


 /**
    * �������ֲ�ѯ����
    * @param riskCode String
    * @param isChinese boolean
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateRiskCode(String riskCode,boolean isChinese) throws SQLException,Exception
   {
    String codeName = "" ;
    DBManager dbManager = new DBManager();
    try
      {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         codeName = new BLCodeAction().translateRiskCode(dbManager,riskCode,isChinese) ;
      }
      catch (Exception ex)
      {
         throw ex;
      }
      finally
      {
         dbManager.close();
      }
      return codeName ;
  }
 /**
    * �������֣����մ����ѯ�����ܱ����־
    * @param riskCode String
    * @param kindCode String
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateCalculateFlag(String riskCode,String kindCode) throws SQLException,Exception
   { 
    String codeName = "" ;
    DBManager dbManager = new DBManager();
    try
      {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         codeName = new BLCodeAction().translateCalculateFlag(dbManager,riskCode,kindCode) ;
      }
      catch (Exception ex)
      {
         throw ex;
      }
      finally
      {
         dbManager.close();
      }
      return codeName ;
  }  

   //modify by wangli add start 20050416
   /**
    * ���ݴ����˴���õ�����������
    * @param dbManager DBManager
    * @param agentCode �����˴���
    * @throws SQLException
    * @throws Exception
    * @return String
    */
   public String translateAgentName(String agentCode) throws SQLException,Exception
   { 
    String agentName = "" ;
    DBManager dbManager = new DBManager();
    try
      {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         agentName = new BLCodeAction().translateAgentName(dbManager,agentCode) ;
      }
      catch (Exception ex)
      {
         throw ex;
      }
      finally
      {
         dbManager.close();
      }
      return agentName ;
  }  
   
   
   
   /** ���ݿͻ�����õ��ͻ�����
    * @param agentCode �ͻ�����
    */
   
   public String translateCustomerCName(String customerCode) throws SQLException,Exception
   { 
    String customerCName = "" ;
    DBManager dbManager = new DBManager();
    try
      {
         dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
         customerCName = new BLCodeAction().translateCustomerCName(dbManager,customerCode) ;
      }
      catch (Exception ex)
      {
         throw ex;
      }
      finally
      {
         dbManager.close();
      }
      return customerCName ;
  } 
   //modify by wangli add end 20050602  
   
}
