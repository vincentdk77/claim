package com.sinosoft.claim.bl.facade;

import java.sql.SQLException;

import com.sinosoft.claim.bl.action.custom.BLScheduleObjectAction;
import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 *  ��������߼��ַ�
 * <p>Title: ���������������</p>
 * <p>Description: ���������������facade</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleObjectFacade
{
  /**
   * �����������
   * @param scheduleDto���Զ���������ȶ���
   * @throws SQLException
   * @throws Exception
   */
  public void save(ScheduleObjectDto scheduleObjectDto) throws SQLException,Exception
  {
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    
    try
    {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
        //��ʼ����
        dbManager.beginTransaction();
      new BLScheduleObjectAction().save(dbManager,scheduleObjectDto);
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
  public ScheduleObjectDto findByPrimaryKey(String comCode) throws SQLException,Exception
  {
    ScheduleObjectDto scheduleObjectDto = null;
    //�������ݿ�������
    DBManager dbManager = new DBManager();
    
    try
    {
        dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
      scheduleObjectDto = new BLScheduleObjectAction().findByPrimaryKey(dbManager,comCode);
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
    return scheduleObjectDto;
  }

  
}
