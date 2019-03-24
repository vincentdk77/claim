package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLScheduleAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLscheduleMainWFAction;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  理赔调度逻辑分发
 * <p>Title: 车险理赔理赔调度</p>
 * <p>Description: 车险理赔理赔调度facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleFacade
{
  /**
   * 保存理赔调度
   * @param scheduleDto：自定义理赔调度对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      
      //开始事务
      dbManager.beginTransaction();
      new BLScheduleAction().save(dbManager,scheduleDto);
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
   * 保存理赔调度带工作流
   * @param scheduleDto：自定义理赔调度对象
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //开始事务
      dbManager.beginTransaction();
      new BLScheduleAction().save(dbManager,scheduleDto);
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
    
    if(scheduleDto.getSmSendSMListDtoList()!=null&&scheduleDto.getSmSendSMListDtoList().size()>0){
      	saveSmcInfo(scheduleDto);
    }
    
  }
  
  public void saveSmcInfo(ScheduleDto scheduleDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
 
   
    try
    {
    	dbManager.open(AppConfig.get("sysconst.SMCJNDI")) ; 
    	//开始事务
        dbManager.beginTransaction();
    	new BLScheduleAction().saveSmcInfo(dbManager,scheduleDto);
   
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
   * 删除理赔调度
   * @param  scheduleNo
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void delete(int scheduleID,String registNo) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //开始事务
      dbManager.beginTransaction(); 
      new BLScheduleAction().delete(dbManager,scheduleID,registNo);
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
  public ScheduleDto findByPrimaryKey(int scheduleID,String registNo) throws SQLException,Exception
  {
    ScheduleDto scheduleDto = null;
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      scheduleDto = new BLScheduleAction().findByPrimaryKey(dbManager,scheduleID,registNo);
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
    return scheduleDto;
  }

  /**
   * 判断理赔调度通知号是否存在
   * @param scheduleNo
   * @param dbManager  数据连接
   * @return 是/否
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(int scheduleID,String registNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      exist = new BLScheduleAction().isExist(dbManager,scheduleID,registNo);
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
   * 根据条件查询理赔调度表信息
   * @param conditions String
   * @throws Exception
   * @return Collection
   */
  public Collection findByConditions(String conditions) throws Exception
  {
     DBManager dbManager = new DBManager();
     PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
     Collection scheduleList = new ArrayList();
     try
     {
       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
       BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
     //由于pagerecorder的问题，目前用collection
     //  scheduleList = (Collection)blPrpLscheduleMainWFAction.findByConditions(dbManager,conditions,0,0);
       scheduleList = (Collection)blPrpLscheduleMainWFAction.findByConditions(dbManager,conditions);
     
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
     return scheduleList;
  }

/**
   * 取得调度号
   * @param registNo
   * @param dbManager  数据连接
   * @return scheduleID
   * @throws SQLException
   * @throws Exception
   */
  public int getNo(String registNo) throws SQLException,Exception
  {

    int scheduleID =0 ;
    //创建数据库管理对象
     DBManager dbManager = new DBManager();
     dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      scheduleID = new BLScheduleAction().getNo(dbManager,registNo);
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
    return scheduleID;
  }

 /**
   * 保存理赔调度改派带工作流
   * @param scheduleDto：自定义理赔调度对象
   * @throws SQLException
   * @throws Exception
   */
  public void changeSave(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	    //开始事务
      dbManager.beginTransaction(); 
      new BLScheduleAction().changeSave(dbManager,scheduleDto);
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
  
    if(scheduleDto.getSmSendSMListDtoList()!=null&&scheduleDto.getSmSendSMListDtoList().size()>0){
      saveSmcInfo(scheduleDto);
    }
    
  }
 
  /**
   * 调度将案件提交双代节点,申请双代处理   add by liyanjie 2005-12-08 
   * @param workFlowDto：工作作流对象
   * @throws SQLException
   * @throws Exception
   */
  public void applyCommiCase(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //创建数据库管理对象
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //开始事务
    
    try
    {
      dbManager.beginTransaction();
      new BLScheduleAction().applyCommiCase(dbManager,scheduleDto);
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
  //add by zhaolu 20060729 start
  //reason:增加分页查询
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception










  {
	  DBManager dbManager = new DBManager();
	     PageRecord pageRecord = null;
	     try
	     {
          
	       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
	       BLPrpLscheduleMainWFAction blPrpLscheduleMainWFAction = new BLPrpLscheduleMainWFAction();
	       pageRecord = (PageRecord)blPrpLscheduleMainWFAction.findByConditions(dbManager,conditions,pageNo,recordPerPage);
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
	     return pageRecord;











  }
  
  //add by zhaolu 20060729 end

 
}
