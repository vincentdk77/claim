package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLScheduleNewAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleNewAction;
import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleNewDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  理赔新案件提示逻辑分发
 * <p>Title: 车险理赔理赔新案件提示</p>
 * <p>Description: 车险理赔理赔新案件提示facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleNewFacade
{
  /**
   * 保存理赔新案件提示
   * @param scheduleNewDto：自定义理赔新案件提示对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleNewDto scheduleNewDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLScheduleNewAction().save(dbManager,scheduleNewDto);
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
   * 删除理赔新案件提示
   * @param  scheduleNewNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String registNo,int surveyNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    dbManager.beginTransaction();
    try
    {
      new BLScheduleNewAction().delete(dbManager,registNo,surveyNo);
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
   * 获得理赔新案件提示
   * @param  scheduleNewNo
   * @param dbManager  数据连接
   * @return 自定义理赔新案件提示对象
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleNewDto findByPrimaryKey(String registNo,int surveyNo) throws SQLException,Exception
  {
    ScheduleNewDto scheduleNewDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      scheduleNewDto = new BLScheduleNewAction().findByPrimaryKey(dbManager,registNo,surveyNo);
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
    return scheduleNewDto;
  }

  /**
   * 判断理赔新案件提示通知号是否存在
   * @param scheduleNewNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo,int surveyNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLScheduleNewAction().isExist(dbManager,registNo,surveyNo);
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
   * 根据条件查询理赔新案件提示表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLscheduleNewDto prpLscheduleNewDto = null;
     Collection scheduleNewList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLscheduleNewAction blPrpLscheduleNewAction = new BLPrpLscheduleNewAction();
     //由于pagerecorder的问题，目前用collection
     //  scheduleNewList = (Collection)blPrpLscheduleNewAction.findByConditions(dbManager,conditions,0,0);
       scheduleNewList = (Collection)blPrpLscheduleNewAction.findByConditions(dbManager,conditions);
     
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
     return scheduleNewList;
  }

}
