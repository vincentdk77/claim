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
	 * ����������ѯ Ͷ�߲�ѯ
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
	 * ����������ѯ Ͷ�߲�ѯ
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
	 * ����������ѯ �ط���Ϣ
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
	 * ����������ѯ�ط���Ϣ
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
	 * ����������ѯ�ط���Ϣ����
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
		//��ʼ����
	    dbManager.beginTransaction();
	    try
	    {
	    	new BLReturnVisitAction().save(dbManager,returnVisitDto);
	    	//�ύ����
	    	dbManager.commitTransaction();
	    }
	    catch(SQLException sqle)
	    {
	      //�ع�����
	      dbManager.rollbackTransaction();
	      throw sqle;
	    }
	    catch(Exception ex)
	    {
	      //�ع�����
	      dbManager.rollbackTransaction();
	      throw ex;
	    }
	    finally
	    {
	      //�ر����ݿ�����
	      dbManager.close();
	    }
	}
	
	
	
	
	/**
	 * �᰸�طûطò�ѯ������֧����������
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
	 * �᰸�طûطò�ѯ������֧����������
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
	 * ����������ѯ�᰸�ط���Ϣ����
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
