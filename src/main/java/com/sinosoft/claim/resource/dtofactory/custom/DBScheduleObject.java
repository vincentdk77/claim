package com.sinosoft.claim.resource.dtofactory.custom;

import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpLscheduleObject;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 理赔调度任务处理数据库管理对象
 * <p>Title: 车险理赔理赔调度任务处理数据管理</p>
 * <p>Description: 车险理赔理赔调度任务处理数据管理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Object: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class DBScheduleObject
{
  private DBManager dbManager = null; //资源管理类

  /**
   * 构造函数
   * @param dbManager 资源管理类
   */
  public DBScheduleObject()
  {
  }


  /**
   * 理赔调度任务处理保存方法
   *@param scheduleDto 理赔调度任务处理对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public void insert(DBManager dbManager,ScheduleObjectDto scheduleObjectDto)
    throws SQLException,Exception
  {
    if (scheduleObjectDto.getPrpdcompanyDto() ==null)
    {
             throw new Exception();
    }

    //首先删除原来的相关数据
    deleteSubInfo(dbManager,scheduleObjectDto);
 
    if (scheduleObjectDto.getPrpdcompanyDto()!=null)
    {
      
    	//modify by lixiang start 2005-11-11
    	//reason:如果有数据，则是更新，如果没数据，就是插入
    	int count =new DBPrpDcompany(dbManager).getCount(" comcode='"+scheduleObjectDto.getPrpdcompanyDto().getComCode() +"'");
    	
    	if (count<1){
    	  new DBPrpDcompany(dbManager).insert(scheduleObjectDto.getPrpdcompanyDto ()) ;
        
    	} else{
    	  new DBPrpDcompany(dbManager).update (scheduleObjectDto.getPrpdcompanyDto ()) ;
            	
    	}
    	
    }
    
   
   
    if(scheduleObjectDto.getPrpLscheduleObjectDto()!=null)
    {
       new DBPrpLscheduleObject(dbManager).insert(scheduleObjectDto.getPrpLscheduleObjectDto());
    }
   }

  /**
   * 理赔调度任务处理删除子表信息
   * @param fcoClaimNoticeNo
   * @throws SQLException
   * @throws Exception
   */
  private void deleteSubInfo(DBManager dbManager,ScheduleObjectDto scheduleObjectDto)
    throws SQLException,Exception
  {
	 //示例未完成
	   String statement = "";
	   if(scheduleObjectDto.getPrpdcompanyDto() !=null)
   {
    
    	String condition3 = " comcode='" + StringUtils.rightTrim(scheduleObjectDto.getPrpdcompanyDto().getComCode() ) + "' ";
     String condition1 = " scheduleobjectid='" + StringUtils.rightTrim(scheduleObjectDto.getPrpdcompanyDto().getComCode() ) + "' ";
     
     statement = " DELETE FROM prpLscheduleObject Where " + condition1;
     dbManager.executeUpdate(statement);
    //删除扩展信息
    // statement = " DELETE FROM prpdcompany Where " + condition3;
   //  dbManager.executeUpdate(statement);
    
    }
  
  }
  /*
   * 理赔调度任务处理查询方法
   *@param scheduleDto 理赔调度任务处理对象
   * @throws SQLException
   * @throws Exception
   *@return 无
   */
  public ScheduleObjectDto findByPrimaryKey(DBManager dbManager,String comCode)
    throws SQLException,Exception
  {
    
     ScheduleObjectDto scheduleObjectDto = new ScheduleObjectDto();
     scheduleObjectDto.setPrpLscheduleObjectDto(new DBPrpLscheduleObject(dbManager).findByPrimaryKey(comCode));
     scheduleObjectDto.setPrpdcompanyDto (new DBPrpDcompany(dbManager).findByPrimaryKey(comCode));
     return scheduleObjectDto; 
  }

}
