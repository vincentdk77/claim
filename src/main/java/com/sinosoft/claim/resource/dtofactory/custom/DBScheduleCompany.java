package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleCompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleCompanyMobile;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔调度任务处理数据库管理对象
 * <p>Title: 车险理赔理赔调度任务处理数据管理</p>
 * <p>Description: 车险理赔理赔调度任务处理数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBScheduleCompany
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBScheduleCompany()
  {
  }


  /**
   * 理赔调度任务处理保存方法
   *@param scheduleDto 理赔调度任务处理对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,ScheduleCompanyDto scheduleCompanyDto)
    throws SQLException,Exception
  {
    if (scheduleCompanyDto.getPrpLscheduleCompanyDto() ==null)
    {
             throw new Exception();
    }

    //首先删除原来的相关数据
    deleteSubInfo(dbManager,scheduleCompanyDto);
 
    if (scheduleCompanyDto.getPrpLschecduleCompanyMobileDtoList ()!=null)
    {
      new DBPrpLscheduleCompanyMobile(dbManager).insertAll(scheduleCompanyDto.getPrpLschecduleCompanyMobileDtoList ()) ;
    }
   
   
    if(scheduleCompanyDto.getPrpLscheduleCompanyDto()!=null)
    {
       new DBPrpLscheduleCompany(dbManager).insert(scheduleCompanyDto.getPrpLscheduleCompanyDto());
    }
   }

  /**
   * 理赔调度任务处理删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleCompanyDto scheduleCompanyDto)
    throws SQLException,Exception
  {
	 //示例未完成
	   String statement = "";
	   if(scheduleCompanyDto.getPrpLscheduleCompanyDto() !=null)
   {
    
    	String condition3 = " comcode='" + StringUtils.rightTrim(scheduleCompanyDto.getPrpLscheduleCompanyDto().getComCode() ) + "' ";
     statement = " DELETE FROM prpLscheduleCompany Where " + condition3;
     dbManager.executeUpdate(statement);
    //删除扩展信息
     statement = " DELETE FROM prpLscheduleCompanyMobile Where " + condition3;
     dbManager.executeUpdate(statement);
    
    }
  
  }
  /*
   * 理赔调度任务处理查询方法
   *@param scheduleDto 理赔调度任务处理对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public ScheduleCompanyDto findByPrimaryKey(DBManager dbManager,String comCode)
    throws SQLException,Exception
  {
     String conditions = " comcode= '"+comCode+"'";
     
     ScheduleCompanyDto scheduleCompanyDto = new ScheduleCompanyDto();
     scheduleCompanyDto.setPrpLscheduleCompanyDto(new DBPrpLscheduleCompany(dbManager).findByPrimaryKey(comCode));
     scheduleCompanyDto.setPrpLschecduleCompanyMobileDtoList (new DBPrpLscheduleCompanyMobile(dbManager).findByConditions(conditions ));
     return scheduleCompanyDto; 
  }

}
