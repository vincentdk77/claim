package com.sinosoft.claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.resource.dtofactory.custom.DBScheduleCompany;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔案件调度处理action
 * <p>Title: 车险理赔 理赔案件调度处理acton</p>
 * <p>Description: 车险理赔 理赔案件调度处理acton</p>
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
   * 保存理赔案件调度处理
   * @param scheduleDto：自定义理赔案件调度处理对象
   * @param dbManager  数据连接
   * @throws SQLException
   * @throws Exception
   */
  public void save(DBManager dbManager,ScheduleCompanyDto scheduleCompanyDto)
    throws SQLException,Exception
  {
      DBScheduleCompany dbScheduleCompany = null;
      //业务操作
      dbScheduleCompany = new DBScheduleCompany();
      dbScheduleCompany.insert(dbManager,scheduleCompanyDto);
  
  }


 
  /**
   * 获得理赔案件调度处理
   * @param  scheduleNo
   * @param dbManager  数据连接
   * @return 自定义理赔案件调度处理对象
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
