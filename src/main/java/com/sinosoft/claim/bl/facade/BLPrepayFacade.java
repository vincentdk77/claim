package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLPrepayAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLprepayAction;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  预赔逻辑分发
 * <p>Title: 车险理赔预赔</p>
 * <p>Description: 车险理赔预赔facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLPrepayFacade
{
  /**
   * 保存预赔
   * @param prepayDto：自定义预赔对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(PrepayDto prepayDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLPrepayAction().save(dbManager,prepayDto);
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
   * 保存预赔带工作流
   * @param prepayDto：自定义预赔对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(PrepayDto prepayDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLPrepayAction().save(dbManager,prepayDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
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
   * 删除预赔
   * @param  prepayNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String prepayNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLPrepayAction().delete(dbManager,prepayNo);
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
   * 获得预赔
   * @param  prepayNo
   * @param dbManager  数据连接
   * @return 自定义预赔对象
   * @throws SQLException
   * @throws Exception
   */
  public PrepayDto findByPrimaryKey(String prepayNo) throws SQLException,Exception
  {
    PrepayDto prepayDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      prepayDto = new BLPrepayAction().findByPrimaryKey(dbManager,prepayNo);
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
    return prepayDto;
  }

  /**
   * 判断预赔通知号是否存在
   * @param prepayNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String prepayNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLPrepayAction().isExist(dbManager,prepayNo);
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
   * 根据条件查询预赔主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLprepayDto prpLprepayDto = null;
     Collection prepayList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLprepayAction blPrpLprepayAction = new BLPrpLprepayAction();
       prepayList = (Collection)blPrpLprepayAction.findByConditions(dbManager,conditions);
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
     return prepayList;
  }

  /**
   * 根据条件查询报案主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
   */
  public Collection findByQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     Collection prepayList = new ArrayList();
     try
     {

       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
       BLPrepayAction blPrepayAction = new BLPrepayAction();
       prepayList = (Collection)blPrepayAction.findByQueryConditions(dbManager,conditions,0,0);
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
     return prepayList;
  }


  /**
   * 根据条件查询预赔主表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByApproveQueryConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLprepayDto prpLprepayDto = null;
     Collection prepayList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrepayAction blPrepayAction = new BLPrepayAction();
       prepayList = (Collection)blPrepayAction.findByApproveQueryConditions(dbManager,conditions,0,0);
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
     return prepayList;
  }

  /**
   * 预赔任务复核
   * @param prepayNo：预赔号码
   * @param userCode：复核员代码
   * @param underWriteFlag：核赔标志
   * @throws SQLException
   * @throws Exception
   */
  public void approve(String prepayNo,String userCode,String underWriteFlag) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLPrepayAction().approve(dbManager,prepayNo,userCode,underWriteFlag);
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
}
