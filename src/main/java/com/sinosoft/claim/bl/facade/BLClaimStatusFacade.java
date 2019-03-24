package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLClaimStatusAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimStatusAction;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  理赔节点状态逻辑分发
 * <p>Title: 车险理赔理赔节点状态</p>
 * <p>Description: 车险理赔理赔节点状态facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLClaimStatusFacade
{
  /**
   * 保存理赔节点状态
   * @param claimStatusDto：自定义理赔节点状态对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ClaimStatusDto claimStatusDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimStatusAction().save(dbManager,claimStatusDto);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
  }
  /**
   * 删除理赔节点状态
   * @param  claimStatusNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLClaimStatusAction().delete(dbManager,claimStatusNo,nodeType,serialNo);
      //提交事务
      dbManager.commitTransaction();
    }
    catch(SQLException sqle)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw sqle;
    }
    catch(Exception ex)
    {
      //回滚事务
      dbManager.rollbackTransaction();
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }

  }
  /**
   * 获得理赔节点状态
   * @param  claimStatusNo
   * @param dbManager  数据连接
   * @return 自定义理赔节点状态对象
   * @throws SQLException
   * @throws Exception
   */
  public ClaimStatusDto findByPrimaryKey(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {
    ClaimStatusDto claimStatusDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      claimStatusDto = new BLClaimStatusAction().findByPrimaryKey(dbManager,claimStatusNo,nodeType,serialNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
    return claimStatusDto;
  }

  /**
   * 判断理赔节点状态通知号是否存在
   * @param claimStatusNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String claimStatusNo,String nodeType,int serialNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLClaimStatusAction().isExist(dbManager,claimStatusNo,nodeType,serialNo);
    }
    catch(SQLException sqle)
    {
      throw sqle;
    }
    catch(Exception ex)
    {
      throw ex;
    }
    finally
    {
      //关闭数据库连接
      dbManager.close();
    }
    return exist;
  }

  /**
   * 根据条件查询理赔节点状态表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLclaimStatusDto prpLclaimStatusDto = null;
     Collection claimStatusList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLclaimStatusAction blPrpLclaimStatusAction = new BLPrpLclaimStatusAction();
       claimStatusList = (Collection)blPrpLclaimStatusAction.findByConditions(dbManager,conditions,0,0);
       /*
       String driverName = "oracle.jdbc.driver.OracleDriver";

      Class.forName(driverName).newInstance();
       String url="jdbc:oracle:thin:@192.168.60.12:1521:ccicdb";
       Connection c= DriverManager.getConnection(url , "claim" , "claim");
       java.sql.DatabaseMetaData d = c.getMetaData();
java.sql.Statement s = c.createStatement();
java.sql.ResultSet rs = s.executeQuery("select count(*) from prplclaimstatus");
       while(rs.next()){
       }
       */
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return claimStatusList;
  }


  /**
   * 根据条件查询理赔节点状态统计信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection getStatStatus(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLclaimStatusDto prpLclaimStatusDto = null;
     Collection claimStatusList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLclaimStatusAction blPrpLclaimStatusAction = new BLPrpLclaimStatusAction();
       claimStatusList = (Collection)blPrpLclaimStatusAction.getStatStatus(dbManager,conditions);
     }
     catch(SQLException sqle)
     {
       throw sqle;
     }
     catch (Exception ex) {
       throw ex;
     }
     finally
     {
       dbManager.close();
     }
     return claimStatusList;
  }

}
