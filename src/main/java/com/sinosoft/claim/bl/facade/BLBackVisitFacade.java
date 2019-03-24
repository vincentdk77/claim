package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLBackVisitAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  回访逻辑分发
 * <p>Title: 车险理赔回访</p>
 * <p>Description: 车险理赔回访facade</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author 理赔项目组
 * @version 1.0
 */
public class BLBackVisitFacade
{
  /**
   * 保存回访
   * @param backVisitDto：自定义回访对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().save(dbManager,backVisitDto);
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
   * 保存回访带工作流
   * @param BackVisitDto：自定义回访对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().save(dbManager,backVisitDto);
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
   * 删除回访
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param  dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(int backVisitNo,String registNo,String backVisitType) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().delete(dbManager,backVisitNo,registNo,backVisitType);
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
   * 删除回访(带删除工作流节点)
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(int backVisitNo,String registNo,String backVisitType, WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().delete(dbManager,backVisitNo,registNo,backVisitType);
      new BLWorkFlowAction().deal(dbManager,workFlowDto);
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
   * 获得回访
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param dbManager  数据连接
   * @return 自定义回访对象
   * @throws SQLException
   * @throws Exception
   */
  public BackVisitDto findByPrimaryKey(int backVisitNo,String registNo,String backVisitType) throws SQLException,Exception
  {
    BackVisitDto backVisitDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      backVisitDto = new BLBackVisitAction().findByPrimaryKey(dbManager,backVisitNo,registNo,backVisitType);
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
    return backVisitDto;
  }

}
