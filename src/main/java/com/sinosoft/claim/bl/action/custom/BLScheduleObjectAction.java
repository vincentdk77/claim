package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleObject;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ⰸ�����ȴ���action
 * <p>Title: �������� ���ⰸ�����ȴ���acton</p>
 * <p>Description: �������� ���ⰸ�����ȴ���acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleObjectAction
{
  public BLScheduleObjectAction()
  {
  }

  /**
   * �������ⰸ�����ȴ���
   * @param scheduleDto���Զ������ⰸ�����ȴ������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleObjectDto scheduleObjectDto)
    throws SQLException,Exception
  {
      DBScheduleObject dbScheduleObject = null;
      //ҵ�����
      dbScheduleObject = new DBScheduleObject();
      dbScheduleObject.insert(dbManager,scheduleObjectDto);
  
  }


 
  /**
   * ������ⰸ�����ȴ���
   * @param  scheduleNo
   * @param dbManager  ��������
   * @return �Զ������ⰸ�����ȴ������
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleObjectDto findByPrimaryKey(DBManager dbManager,String comCode)
    throws SQLException,Exception
  {
    ScheduleObjectDto scheduleObjectDto = null;
    scheduleObjectDto = new DBScheduleObject().findByPrimaryKey(dbManager,comCode);
    return scheduleObjectDto;
  }

}
