package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLJobManagerAction;
import com.sinosoft.claim.bl.action.domain.BLPrpDclassAction;
import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLJobManagerFacade {
	/**
	   * 保存班表
	   * @param registDto：自定义报案对象
	   * @throws SQLException
	   * @throws Exception
	   */
	  public void save(JobManagerDto jobManagerDto) throws SQLException,Exception
	  {
	    //创建数据库管理对象
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //开始事务
	    dbManager.beginTransaction();
	    try
	    {
	      new BLJobManagerAction().save(dbManager,jobManagerDto);
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
	       BLJobManagerAction blJobManagerAction = new BLJobManagerAction();
	       claimList = (Collection)blJobManagerAction.findByQueryConditions(dbManager,conditions,0,0);
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
	       BLJobManagerAction blJobManagerAction = new BLJobManagerAction();
	       pageRecord = (PageRecord)blJobManagerAction.findByQueryConditions(dbManager,conditions,pageNo,recordPerPage);
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
	  /**
	   * 根据条件查找险类
	 * @throws Exception 
	   * 
	   * */
	/*public Collection findClassCodeByConditions(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
			BLPrpDclassAction blPrpDclassAction = new BLPrpDclassAction();
			return blPrpDclassAction.findByConditions(dbManager, conditions, 0, 0);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			dbManager.close();
		}
	}*/
}
