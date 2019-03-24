package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLAreaSettingAction;
import com.sinosoft.claim.dto.custom.AreaSettingDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLAreaSettingFacade {
	/**
	   * 保存班表
	   * @param registDto：自定义报案对象
	   * @throws SQLException
	   * @throws Exception
	   */
	  public void save(AreaSettingDto areaSettingDto) throws SQLException,Exception
	  {
	    //创建数据库管理对象
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //开始事务
	    dbManager.beginTransaction();
	    try
	    {
	      new BLAreaSettingAction().save(dbManager,areaSettingDto);
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
	   * 根据条件查询报案主表信息
	   * @param conditions String
	   * @throws Exception
	   * @return Collection
	   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
	   */
	  public Collection findByQueryConditions(String conditions) throws Exception
	  {
	     DBManager dbManager = new DBManager();
	     Collection claimList = new ArrayList();
	     try
	     {

	       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	       BLAreaSettingAction blAreaSettingAction = new BLAreaSettingAction();
	       claimList = (Collection)blAreaSettingAction.findByQueryConditions(dbManager,conditions,0,0);
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
	     return claimList;
	  }
	  
	  /**
	   * 根据条件查询班表主表信息
	   * @param conditions String
	   * @throws Exception
	   * @return Collection
	   * Add By sunhao 2004-08-24 Reason:增加新的查询方法
	   */
	  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage) throws Exception
	  {
	     DBManager dbManager = new DBManager();
	     Collection claimList = new ArrayList();
	     PageRecord pageRecord = new PageRecord(0,pageNo,1,recordPerPage,new ArrayList());
	     try
	     {
	       dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	      // BLPrpLregistAction blPrpLregistAction = new BLPrpLregistAction();
	       BLAreaSettingAction blAreaSettingAction = new BLAreaSettingAction();
	       pageRecord = (PageRecord)blAreaSettingAction.findByQueryConditions(dbManager,conditions,pageNo,recordPerPage);
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

}
