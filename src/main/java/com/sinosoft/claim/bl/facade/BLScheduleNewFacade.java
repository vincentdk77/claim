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
 *  �����°�����ʾ�߼��ַ�
 * <p>Title: �������������°�����ʾ</p>
 * <p>Description: �������������°�����ʾfacade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleNewFacade
{
  /**
   * ���������°�����ʾ
   * @param scheduleNewDto���Զ��������°�����ʾ����
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleNewDto scheduleNewDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLScheduleNewAction().save(dbManager,scheduleNewDto);
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
   * ɾ�������°�����ʾ
   * @param  scheduleNewNo
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(String registNo,int surveyNo) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLScheduleNewAction().delete(dbManager,registNo,surveyNo);
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
   * ��������°�����ʾ
   * @param  scheduleNewNo
   * @param dbManager  ��������
   * @return �Զ��������°�����ʾ����
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleNewDto findByPrimaryKey(String registNo,int surveyNo) throws SQLException,Exception
  {
    ScheduleNewDto scheduleNewDto = null;
    //�������ݿ�������
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
      //�ر����ݿ�����
      dbManager.close();
    }
    return scheduleNewDto;
  }

  /**
   * �ж������°�����ʾ֪ͨ���Ƿ����
   * @param scheduleNewNo
   * @param dbManager  ��������
   * @return ��/��
   * @throws SQLException
   * @throws Exception
   */
  public boolean isExist(String registNo,int surveyNo) throws SQLException,Exception
  {

    boolean exist = false ;
    //�������ݿ�������
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
      //�ر����ݿ�����
      dbManager.close();
    }
    return exist;
  }

  /**
   * ����������ѯ�����°�����ʾ����Ϣ
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
     //����pagerecorder�����⣬Ŀǰ��collection
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
