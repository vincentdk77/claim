package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLScheduleCompanyAction;
import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
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
public class BLScheduleCompanyFacade
{
  /**
   * �����������
   * @param scheduleDto���Զ���������ȶ���
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleCompanyDto scheduleCompanyDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    
    try
    {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        //��ʼ����
        dbManager.beginTransaction();
      new BLScheduleCompanyAction().save(dbManager,scheduleCompanyDto);
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
  public ScheduleCompanyDto findByPrimaryKey(String comCode) throws SQLException,Exception
  {
    ScheduleCompanyDto scheduleCompanyDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    
    try
    {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      scheduleCompanyDto = new BLScheduleCompanyAction().findByPrimaryKey(dbManager,comCode);
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
    return scheduleCompanyDto;
  }

  
}
