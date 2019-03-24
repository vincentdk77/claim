package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleCompany;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ���ⰸ�����ȴ���action
 * <p>Title: �������� ���ⰸ�����ȴ���acton</p>
 * <p>Description: �������� ���ⰸ�����ȴ���acton</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class BLScheduleCompanyAction
{
  public BLScheduleCompanyAction()
  {
  }

  /**
   * �������ⰸ�����ȴ���
   * @param scheduleDto���Զ������ⰸ�����ȴ������
   * @param dbManager  ��������
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleCompanyDto scheduleCompanyDto)
    throws SQLException,Exception
  {
      DBScheduleCompany dbScheduleCompany = null;
      //ҵ�����
      dbScheduleCompany = new DBScheduleCompany();
      dbScheduleCompany.insert(dbManager,scheduleCompanyDto);
  
  }


 
  /**
   * ������ⰸ�����ȴ���
   * @param  scheduleNo
   * @param dbManager  ��������
   * @return �Զ������ⰸ�����ȴ������
   * @throws SQLException
   * @throws Exception
   */
  public ScheduleCompanyDto findByPrimaryKey(DBManager dbManager,String comCode)
    throws SQLException,Exception
  {
    ScheduleCompanyDto scheduleCompanyDto = null;
    scheduleCompanyDto = new DBScheduleCompany().findByPrimaryKey(dbManager,comCode);
    return scheduleCompanyDto;
  }

}
