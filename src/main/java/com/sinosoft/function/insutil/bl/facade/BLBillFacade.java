/**
 * <p>Title: BLBillFacade</p>
 * <p>Description:单号取号类 </p>
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
   * 构造方法
   */
  public BLBillFacade()
  {
  }

  /**
   * 年度单号初始化（批量初始化）
   * @param iRiskSchemas 险种代码数组
   * @param iCompanySchemas 机构代码数组
   * @param iTableSchemas   数据表数组
   * @param iYear 4位年份
   * @param iInitNo 初始化序号
   * @return true/false  批量初始化成功/失败
   * @throws SQLException,Exception,UserException
   */
  public boolean batchInitNo(Vector iRiskSchemas,Vector iCompanySchemas,Vector iTableSchemas,
                             String iYear,String iInitNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 年度单号初始化
   * @param dbManager 数据库连接池
   * @param iRiskSchemas 险种代码数组
   * @param iCompanySchemas 机构代码数组
   * @param iTableSchemas   数据表数组
   * @param iYear 4位年份
   * @param iInitNo 初始化序号
   * @return 无
   * @throws SQLException,Exception,UserException
   */
  public boolean batchInitNo(DBManager dbManager,Vector iRiskSchemas,Vector iCompanySchemas,Vector iTableSchemas,
                             String iYear,String iInitNo) throws SQLException,Exception
  {
    return new BLBillAction().batchInitNo(dbManager,iRiskSchemas,iCompanySchemas,iTableSchemas,iYear,iInitNo);
  }

  /**
   * 获取一个新号
   * @param  iTableName:单号数据表名
   * @param  iRiskCode:险种代码
   * @param  iComCode:出单部门
   * @param  iYear:业务年度
   * @return 单号字符串
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
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 获取一个新号
   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * String billNo = BLBillFacade.getNo(dbManager,"prptmain","DAA","31010005",2004,"SessionID")
   * if (billNo.length()=0)
   *    alert("获取单号失败")
   * execute series of actions
   * if (succeed in executing them){
   *    BLBillFacade.deleteNo(dbManager,"prptmain",billNo);
   * }
   * else{
   *    BLBillFacade.putNo(dbManager,"prptmain",billNo);
   * }
   * </pre>
   * @param  dbManager 数据库连接池
   * @param  iTableName:单号数据表名
   * @param  iRiskCode:险种代码
   * @param  iComCode:出单部门
   * @param  iYear:业务年度
   * @return 单号字符串
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
   * 拉长单号
   * @param iTableName 数据表名
   * @param iBillNo    单号
   * @param iGroupNo   组号
   * @return strBillNo 拉长后的单号
   */
  public String pullNo(String iTableName,String iBillNo,String iGroupNo) throws Exception
  {
    String strBillNo = "";
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 拉长单号
   * @param dbManager 数据库连接池
   * @param iTableName 数据表名
   * @param iBillNo    单号
   * @param iGroupNo   组号
   * @return strBillNo 拉长后的单号
   */
  public String pullNo(DBManager dbManager,String iTableName,String iBillNo,String iGroupNo) throws Exception
  {
    String strBillNo = "";
    strBillNo = new BLBillAction().pullNo(dbManager,iTableName,iBillNo,iGroupNo);
    return strBillNo;
  }

  /**
   * 单号检查
   * @param iTableName 数据表
   * @param iBillNo    单号
   * @param iGroupNo   组号
   * @param iCheckFlag 检查类型
   * @return true/false  单号检查成功（合法）/单号检查失败（不合法）
   * @throws Exception
   */
  public boolean checkNo(String iTableName,String iBillNo,String iGroupNo,String iCheckFlag) throws Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 单号检查
   * @param dbManager 数据库连接池
   * @param iTableName 数据表
   * @param iBillNo    单号
   * @param iGroupNo   组号
   * @param iCheckFlag 检查类型
   * @return true/false  单号检查成功（合法）/单号检查失败（不合法）
   * @throws Exception
   */
  public boolean checkNo(DBManager dbManager,String iTableName,String iBillNo,String iGroupNo,String iCheckFlag) throws Exception
  {
    return new BLBillAction().checkNo(dbManager,iTableName,iBillNo,iGroupNo,iCheckFlag);
  }


  /**
   * 放回新单号
   * @param strTableName 数据表名
   * @param strBillNo  单号
   * @return true/false  放号成功/放号失败
   * @throws Exception,SQLException,UserException
   */
  public boolean putNo(String iTableName,String iBillNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 放回新单号（getNo获取新单号之后，如果执行业务操作失败，必须放回该单号）
   *   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * String billNo = BLBillFacade.getNo(dbManager,"prptmain","DAA","31010005",2004,"SessionID")
   * if (billNo.length()=0)
   *    alert("获取单号失败")
   * execute series of actions
   * if (succeed in executing them){
   *    BLBillFacade.deleteNo(dbManager,"prptmain",billNo);
   * }
   * else{
   *    BLBillFacade.putNo(dbManager,"prptmain",billNo);
   * }
   * </pre>
   * @param dbManager 数据库连接池
   * @param strTableName 数据表名
   * @param strBillNo  单号
   * @return true/false  放号成功/放号失败
   * @throws Exception,SQLException,UserException
   */
  public boolean putNo(DBManager dbManager,String iTableName,String iBillNo)
      throws SQLException,Exception
  {
    return new BLBillAction().putNo(dbManager,iTableName,iBillNo);
  }


  /**
   * 成功后删除获取的单号
   * @param strTableName  单号表名
   * @param strBillNo	 单证号
   * @return true/false   删号成功/删号失败
   * @throws Exception,SQLException,UserException
   */
  public boolean deleteNo(String iTableName,String iBillNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 成功后删除获取的单号（getNo获取新单号之后，如果执行业务操作成功，必须删除该单号）
   *   * <br>
   * <br>
   * <b>示例: </b>
   * <pre>
   * String billNo = BLBillFacade.getNo(dbManager,"prptmain","DAA","31010005",2004,"SessionID")
   * if (billNo.length()=0)
   *    alert("获取单号失败")
   * execute series of actions
   * if (succeed in executing them){
   *    BLBillFacade.deleteNo(dbManager,"prptmain",billNo);
   * }
   * else{
   *    BLBillFacade.putNo(dbManager,"prptmain",billNo);
   * }
   * </pre>
   * @param dbManager 数据库连接池
   * @param strTableName  单号表名
   * @param strBillNo	 单证号
   * @return true/false   删号成功/删号失败
   * @throws Exception,SQLException,UserException
   */
  public boolean deleteNo(DBManager dbManager,String iTableName,String iBillNo)
      throws SQLException,Exception
  {
    return new BLBillAction().deleteNo(dbManager,iTableName,iBillNo);
  }

  /**
   * 手工占号
   * @param iTableName  单号表名
   * @param iBillNo	 单证号
   * @return true/false  占号成功/占号失败
   * @throws UserException
   * @throws Exception
   */
  public boolean occupy(String iTableName,String iBillNo) throws SQLException,Exception
  {
    boolean blnReturnFlag = false;
    DBManager dbManager = new DBManager();
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")); //打开连接池
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
   * 手工占号
   * @param dbManager 数据库连接池
   * @param iTableName  单号表名
   * @param iBillNo	 单证号
   * @return true/false  占号成功/占号失败
   * @throws UserException
   * @throws Exception
   */
  public boolean occupy(DBManager dbManager,String iTableName,String iBillNo) throws SQLException,Exception
  {
    return new BLBillAction().occupy(dbManager,iTableName,iBillNo);
  }

  /**
   * 获取组号
   * @param dbManager   数据库连接池
   * @param iTableName  单号表名
   * @param iRiskCode   险种代码
   * @param iComCode    机构代码
   * @param iYear       年份
   * @return groupNo    组号
   * @throws Exception
   */
  public String getGroupNo(DBManager dbManager,String iTableName,String iRiskCode,String iComCode,String iYear)
      throws Exception
  {
    return new BLBillAction().getGroupNo(dbManager,iTableName,iRiskCode,iComCode,iYear);
  }

  /**
   * 根据单号规则拆分（如果单号涉及编组，则拆分成编组后的组号）
   * @param dbManager   数据库连接池
   * @param iTableName  单号表名
   * @param iRiskCode   单号
   * @return pickNo[3]  [0]号头 [1]组号 [2]流水号
   * @throws Exception
   */
  public String[] pickNo(DBManager dbManager,String iTableName,String iBillNo) throws Exception
  {
    return new BLBillAction().pickNo(dbManager,iTableName,iBillNo);
  }

}
