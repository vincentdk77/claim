package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLCodeAction;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
/**
 * 代码获取逻辑
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔样本程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
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
  * 返回货币名称，代码列表
  * @return Collection 代码查询
  * @throws SQLException
  * @throws Exception
  */
  public Collection getCurrencyList() throws Exception
  {
      return new BLCodeAction().getCurrencyList();
  } 
  
  /**
   * 返回免赔条件列表
   * @return Collection 代码查询
   * @throws SQLException
   * @throws Exception
   */
  public Collection getDeductCondition(String riskCode) throws Exception{
	  return new BLCodeAction().getDeductCondition(riskCode);
  }

 /**
  * 根据业务类型及险种查询业务代码
  * @param  codetype：业务类型
  * @param  riskcode：险种代码
  * @return PrpDcodeDto 代码查询
  * @throws SQLException
  * @throws Exception
  */
  public Collection getCodeType(String codetype,String riskcode) throws Exception
  {
      return new BLCodeAction().getCodeType(codetype,riskcode);
  }

  /**
   * 根据客户代码查询客户类别
   * @param  customerCode：客户代码
   * @return  客户类别
   * @throws SQLException
   * @throws Exception
   */
 public String getCustomerType(String customerCode)
     throws Exception
 {
 	return new BLCodeAction().getCustomerType(customerCode);
 }
   
 /**
  * 根据机构代码查询客户级别
  * @param  comCode：机构代码
  * @return  客户级别
  * @throws SQLException
  * @throws Exception
  */
public String getComLevel(String comCode)
    throws Exception
{
	return new BLCodeAction().getComLevel(comCode);
}
   
  /**
  * 根据归属机构查询结付公司信息
  * @param  comcode：归属机构代码
  * @return PrpDcompanyDto 归属机构
  * @throws SQLException
  * @throws Exception
  */
   public PrpDcompanyDto getPayInfo(String comcode) throws Exception
   {
     return new BLCodeAction().getPayInfo(comcode);
   }
   /**
    * 根据用户代码查询用户
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
    * 根据代码类型和代码查询代码名称
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
 
   //add prpdlimit代码表转化
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
    * 根据险种，子险代码查询名称
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
    * 根据险种，标的代码查询标的名称
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
   * 根据币别代码得到币别名称
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
  * 根据公司代码得到公司名称
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
  * 根据报案号码查询对应的赔案号码
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
  * 根据报案号查询相关的相关车牌号码的列表
  * @param  registNo  报案号
  * @throws SQLException
  * @throws Exception
  */
  public Collection getLicenseNoList(String registNo) throws Exception
  {
      return new BLCodeAction().getLicenseNoList(registNo);
  }


 /**
    * 根据险种查询名称
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
    * 根据险种，子险代码查询计入总保额标志
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
    * 根据代理人代码得到代理人姓名
    * @param dbManager DBManager
    * @param agentCode 代理人代码
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
   
   
   
   /** 根据客户代码得到客户姓名
    * @param agentCode 客户代码
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
