package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLBackVisitAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.dto.custom.BackVisitDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  �ط��߼��ַ�
 * <p>Title: ��������ط�</p>
 * <p>Description: ��������ط�facade</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: Sinosoft</p>
 * @author ������Ŀ��
 * @version 1.0
 */
public class BLBackVisitFacade
{
  /**
   * ����ط�
   * @param backVisitDto���Զ���طö���
   * @throws SQLException
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().save(dbManager,backVisitDto);
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
   * ����طô�������
   * @param BackVisitDto���Զ���طö���
   * @throws SQLException
   * @throws Exception
   */
  public void save(BackVisitDto backVisitDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().save(dbManager,backVisitDto);
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

  /**
   * ɾ���ط�
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param  dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(int backVisitNo,String registNo,String backVisitType) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().delete(dbManager,backVisitNo,registNo,backVisitType);
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
   * ɾ���ط�(��ɾ���������ڵ�)
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void delete(int backVisitNo,String registNo,String backVisitType, WorkFlowDto workFlowDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    //��ʼ����
    dbManager.beginTransaction();
    try
    {
      new BLBackVisitAction().delete(dbManager,backVisitNo,registNo,backVisitType);
      new BLWorkFlowAction().deal(dbManager,workFlowDto);
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
   * ��ûط�
   * @param  backVisitNo
   * @param  registNo
   * @param  backVisitType
   * @param dbManager  ��������
   * @return �Զ���طö���
   * @throws SQLException
   * @throws Exception
   */
  public BackVisitDto findByPrimaryKey(int backVisitNo,String registNo,String backVisitType) throws SQLException,Exception
  {
    BackVisitDto backVisitDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
    try
    {
      backVisitDto = new BLBackVisitAction().findByPrimaryKey(dbManager,backVisitNo,registNo,backVisitType);
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
    return backVisitDto;
  }

}
