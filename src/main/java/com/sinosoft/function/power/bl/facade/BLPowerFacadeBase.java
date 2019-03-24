/**
 * <p>Title: BLPowerFacade</p>
 * <p>Description:权限管理类 </p>
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
   * 构造方法
   */
  public BLPowerFacadeBase()
  {
  }
  /**
   * 根据外部传入的员工代码+险种代码+任务代码+数据表名获取查询条件附加权限
   * @param  iUserCode    员工代码
   * @param  iRiskCode    险种代码
   * @param  iTaskCode    任务代码
   * @param  iTableName   查询表名
   * @return 附加查询条件字符串（例如：AND ( 1=1 OR 1=0 )）
   * @throws UserException,Exception
   */
  public String addPower(String iUserCode,String iRiskCode,String iTaskCode,String iTableName) throws UserException,Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    String  strPowerCondition = ""; //权限条件
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池

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
   * 根据外部传入的员工代码+险种代码+任务代码+数据表名获取查询条件附加权限
   * @param  iUserCode    员工代码
   * @param  iRiskCode    险种代码
   * @param  iGroupCode   权限组号代码
   * @param  iTaskCode    任务代码
   * @param  iTableName   查询表名
   * @return 附加查询条件字符串（例如：AND ( 1=1 OR 1=0 )）
   * @throws UserException,Exception
   */
  public String addPower(String iUserCode,String iRiskCode,String iGroupCode,String iTaskCode,String iTableName) throws UserException,Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    String  strPowerCondition = ""; //权限条件
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池

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
   * 根据外部传入的条件校验是否有权限,险种无关
   * <br>
   * <b>示例: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkPower("0000000000","DAA","01",
   *                        ,"tb",PowerConst.CHECKCODE_READ);
   * </pre>
   * @param  userCode    员工代码
   * @param  riskCode    险种代码
   * @param  groupCode   权限组号
   * @param  taskCode    任务代码
   * @param  checkCode   检验类型
   * @return true/false  true:有权限/false:无权限
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
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池

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
   * 根据外部传入的条件校验是否有权限,险种相关
   * <br>
   * <b>示例: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkPower("0000000000","DAA",
   *                        ,"tb",PowerConst.CHECKCODE_READ);
   * </pre>
   * @param  userCode    员工代码
   * @param  riskCode    险种代码
   * @param  taskCode    任务代码
   * @param  checkCode   检验类型
   * @return true/false  true:有权限/false:无权限
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
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池

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
   * 核对操作员是否能够登陆相应系统
   * <br>
   * <b>示例: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_PRP);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_ACCOUNT);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_REINS);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_VISA);
   * boolean successFlag = BLPowerFacade.checkLogin("0000000000",PowerConst.SYSTEM_UNDERWRITE);
   * </pre>
   * @param  iUserCode    员工代码
   * @param  iSystemName  登陆系统名称("prp","account","reins","visa","underwrite")
   * @return blnfound    是否能够登陆标志，能够登陆返回true，不能登陆返回false
   * @throws Exception   异常
   */
  public boolean checkLogin(String userCode,String systemName) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    boolean blnReturn = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池

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
   * 核对操作员密码是否正确
   * <br>
   * <b>示例: </b>
   * <pre>
   * BLPowerFacade.checkPassword("0000000000","0000","ASDHKJHDKHSKSJSJ");
   * </pre>
   * @param  iUserCode    员工代码
   * @param  iPassword    员工密码(明码）
   * @return blnfound     密码是否正确标志，正确返回true，错误返回false
   * @throws Exception    异常
   */
  public boolean checkPassword(String userCode,String password) throws Exception
  {

    BLPowerAction blPowerAction = new BLPowerAction();
    boolean blnReturn = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 核对操作员印鉴是否正确
   * <br>
   * <b>示例: </b>
   * <pre>
   * boolean successFlag = BLPowerFacade.checkSeal("0000000000","0000");
   * </pre>
   * @param  userCode    员工代码
   * @param  seal        印鉴
   * @return blnfound    密码是否正确标志，正确返回true，错误返回false
   * @throws Exception   异常
   */
  public boolean checkSeal(String userCode,String seal) throws Exception
  {
    BLPowerAction blPowerAction = new BLPowerAction();
    boolean blnReturn = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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

