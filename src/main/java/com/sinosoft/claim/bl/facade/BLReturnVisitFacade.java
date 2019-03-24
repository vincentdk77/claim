package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.action.custom.BLReturnVisitAction;
import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

public class BLReturnVisitFacade {
	
	/**
	 * 根据条件查询 投诉查询
	 * @param conditions
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 * @throws Exception
	 */
	public PageRecord findByQueryComplaint (String conditions, int pageNo, int recordPerPage) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		PageRecord pageRecord = new PageRecord(0,pageNo,1,recordPerPage,new ArrayList());
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			pageRecord = (PageRecord) blReturnVisitAction.findByQueryComplaint(dbManager,conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
	}
	
	/**
	 * 根据条件查询 投诉查询
	 * @param conditions
	 * @return
	 * @throws Exception
	 */
	public Collection findByQueryComplaint(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			returnVisitList = (Collection) blReturnVisitAction.findByQueryConditions(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return returnVisitList;
	}
	
	/**
	 * 根据条件查询 回访信息
	 * @param conditions
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 * @throws Exception 
	 */
	public PageRecord findByQueryConditions(String conditions, int pageNo, int recordPerPage) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		PageRecord pageRecord = new PageRecord(0,pageNo,1,recordPerPage,new ArrayList());
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			pageRecord = (PageRecord) blReturnVisitAction.findByQueryConditions(dbManager,conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
	}

	/**
	 * 根据条件查询回访信息
	 * @param conditions
	 * @return
	 * @throws Exception 
	 */
	public Collection findByQueryConditions(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			returnVisitList = (Collection) blReturnVisitAction.findByQueryConditions(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return returnVisitList;
	}
	
	
	/**
	 * 根据条件查询回访信息导出
	 * @param conditions
	 * @return
	 * @throws Exception 
	 */
	public Collection findByQueryExpConditions(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			returnVisitList = (Collection) blReturnVisitAction.findByQueryExpConditions(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return returnVisitList;
	}
	
	
	public void save(ReturnVisitDto returnVisitDto) throws Exception{
		DBManager dbManager = new DBManager();
		dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
		//开始事务
	    dbManager.beginTransaction();
	    try
	    {
	    	new BLReturnVisitAction().save(dbManager,returnVisitDto);
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
	 * 结案回访回访查询，按照支付日期排序
	 * @param conditions
	 * @param pageNo
	 * @param recordPerPage
	 * @return
	 * @throws Exception 
	 */
	public PageRecord findByQueryConditionsEndca(String conditions, int pageNo, int recordPerPage) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		PageRecord pageRecord = new PageRecord(0,pageNo,1,recordPerPage,new ArrayList());
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			pageRecord = (PageRecord) blReturnVisitAction.findByQueryConditionsEndca(dbManager,conditions,pageNo,recordPerPage);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return pageRecord;
	}

	/**
	 * 结案回访回访查询，按照支付日期排序
	 * @param conditions
	 * @return
	 * @throws Exception 
	 */
	public Collection findByQueryConditionsEndca(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			returnVisitList = (Collection) blReturnVisitAction.findByQueryConditionsEndca(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return returnVisitList;
	}
	
	
	/**
	 * 根据条件查询结案回访信息导出
	 * @param conditions
	 * @return
	 * @throws Exception 
	 */
	public Collection findByQueryExpConditionsEndca(String conditions) throws Exception {
		DBManager dbManager = new DBManager();
		Collection returnVisitList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLReturnVisitAction blReturnVisitAction = new BLReturnVisitAction();
			returnVisitList = (Collection) blReturnVisitAction.findByQueryExpConditionsEndca(dbManager, conditions, 0, 0);
		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception ex) {
			throw ex;
		} finally {
			dbManager.close();
		}
		return returnVisitList;
	}
}
