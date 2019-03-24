package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLScheduleObjectAction;
import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  理赔调度逻辑分发
 * <p>Title: 车险理赔理赔调度</p>
 * <p>Description: 车险理赔理赔调度facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleObjectFacade
{
  /**
   * 保存理赔调度
   * @param scheduleDto：自定义理赔调度对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleObjectDto scheduleObjectDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    
    try
    {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        //开始事务
        dbManager.beginTransaction();
      new BLScheduleObjectAction().save(dbManager,scheduleObjectDto);
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
   * 获得理赔调度
   * @param  scheduleNo
   * @param dbManager  数据连接
   * @return 自定义理赔调度对象
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleObjectDto findByPrimaryKey(String comCode) throws SQLException,Exception
  {
    ScheduleObjectDto scheduleObjectDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    
    try
    {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      scheduleObjectDto = new BLScheduleObjectAction().findByPrimaryKey(dbManager,comCode);
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
    return scheduleObjectDto;
  }

  
}
