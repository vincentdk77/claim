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
 *  ��������߼��ַ�
 * <p>Title: ���������������</p>
 * <p>Description: ���������������facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleFacade
{
  /**
   * �����������
   * @param scheduleDto���Զ���������ȶ���
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      
      //��ʼ����
      dbManager.beginTransaction();
      new BLScheduleAction().save(dbManager,scheduleDto);
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
   * ����������ȴ�������
   * @param scheduleDto���Զ���������ȶ���
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //��ʼ����
      dbManager.beginTransaction();
      new BLScheduleAction().save(dbManager,scheduleDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      
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
    
    if(scheduleDto.getSmSendSMListDtoList()!=null&&scheduleDto.getSmSendSMListDtoList().size()>0){
      	saveSmcInfo(scheduleDto);
    }
    
  }
  
  public void saveSmcInfo(ScheduleDto scheduleDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
 
   
    try
    {
    	dbManager.open(AppConfig.get("sysconst.SMCJNDI")) ; 
    	//��ʼ����
        dbManager.beginTransaction();
    	new BLScheduleAction().saveSmcInfo(dbManager,scheduleDto);
   
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
   * ɾ���������
   * @param  scheduleNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(int scheduleID,String registNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      //��ʼ����
      dbManager.beginTransaction(); 
      new BLScheduleAction().delete(dbManager,scheduleID,registNo);
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
   * ����������
   * @param  scheduleNo	
   * @param dbManager  ��������
   * @return �Զ���������ȶ���
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleDto findByPrimaryKey(int scheduleID,String registNo) throws SQLException,Exception
  {
    ScheduleDto scheduleDto = null;
    //�������ݿ�������
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
      //�ر����ݿ�����
      dbManager.close();
    }
    return scheduleDto;
  }

  /**
   * �ж��������֪ͨ���Ƿ����
   * @param scheduleNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(int scheduleID,String registNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
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
      //�ر����ݿ�����
      dbManager.close();
    }
    return exist;
  }

  /**
   * ����������ѯ������ȱ���Ϣ
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
     //����pagerecorder�����⣬Ŀǰ��collection
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
   * ȡ�õ��Ⱥ�
   * @param registNo
   * @param dbManager  ��������
   * @return scheduleID
   * @throws SQLException
   * @throws Exception
   */
  public int getNo(String registNo) throws SQLException,Exception
  {

    int scheduleID =0 ;
    //�������ݿ�������
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
      //�ر����ݿ�����
      dbManager.close();
    }
    return scheduleID;
  }

 /**
   * ����������ȸ��ɴ�������
   * @param scheduleDto���Զ���������ȶ���
   * @throws SQLException
   * @throws Exception
   */
  public void changeSave(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
   
    try
    {
      dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    	    //��ʼ����
      dbManager.beginTransaction(); 
      new BLScheduleAction().changeSave(dbManager,scheduleDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
      
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
  
    if(scheduleDto.getSmSendSMListDtoList()!=null&&scheduleDto.getSmSendSMListDtoList().size()>0){
      saveSmcInfo(scheduleDto);
    }
    
  }
 
  /**
   * ���Ƚ������ύ˫���ڵ�,����˫������   add by liyanjie 2005-12-08 
   * @param workFlowDto��������������
   * @throws SQLException
   * @throws Exception
   */
  public void applyCommiCase(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    
    try
    {
      dbManager.beginTransaction();
      new BLScheduleAction().applyCommiCase(dbManager,scheduleDto);
      if(workFlowDto!=null){
        new BLWorkFlowAction().deal(dbManager,workFlowDto);
      }
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
  //add by zhaolu 20060729 start
  //reason:���ӷ�ҳ��ѯ
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
