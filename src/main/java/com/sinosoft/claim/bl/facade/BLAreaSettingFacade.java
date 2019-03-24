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
	   * ������
	   * @param registDto���Զ��屨������
	   * @throws SQLException
	   * @throws Exception
	   */
	  public void save(AreaSettingDto areaSettingDto) throws SQLException,Exception
	  {
	    //�������ݿ�������
	    DBManager dbManager = new DBManager();
	    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
	    //��ʼ����
	    dbManager.beginTransaction();
	    try
	    {
	      new BLAreaSettingAction().save(dbManager,areaSettingDto);
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
	   * ����������ѯ����������Ϣ
	   * @param conditions String
	   * @throws Exception
	   * @return Collection
	   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
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
	   * ����������ѯ���������Ϣ
	   * @param conditions String
	   * @throws Exception
	   * @return Collection
	   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
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
