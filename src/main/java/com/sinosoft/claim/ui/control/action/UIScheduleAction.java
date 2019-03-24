package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.PrpLscheduleItemFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLscheduleItemFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLscheduleItemGetCountCommand;
import com.sinosoft.claim.ui.model.PrpLscheduleMainWFFindByConCommand;
import com.sinosoft.claim.ui.model.PrpLscheduleMainWFFindByConditionsCommand;
import com.sinosoft.claim.ui.model.PrpLscheduleMainWFGetCountCommand;
import com.sinosoft.claim.ui.model.ScheduleChangeSaveCommand;
import com.sinosoft.claim.ui.model.ScheduleDeleteCommand;
import com.sinosoft.claim.ui.model.ScheduleFindByConCommand;
import com.sinosoft.claim.ui.model.ScheduleGetNoCommand;
import com.sinosoft.claim.ui.model.ScheduleIsExistCommand;
import com.sinosoft.claim.ui.model.ScheduleSaveCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;


/**
 * 理赔案件调度处理Schedule
 * <p>Title: 车险理赔理赔案件调度处理  </p>
 * <p>Description: 车险理赔理赔案件调度处理</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class UIScheduleAction
{
  /**
   * 保存理赔案件调度处理
   * @param ScheduleDto：理赔案件调度处理DTO
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto) throws SQLException,Exception
  {
          ScheduleSaveCommand scheduleSaveCommand = new ScheduleSaveCommand(scheduleDto);
          scheduleSaveCommand.execute();
  }
  
  
   /**
   * 保存理赔案件调度处理带工作流
   * @param ScheduleDto：理赔案件调度处理DTO,workflowDto
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
          ScheduleSaveCommand scheduleSaveCommand = new ScheduleSaveCommand(scheduleDto,workFlowDto);
          scheduleSaveCommand.execute();
  }
  
  
   /**
   * 保存理赔案件调度处理带工作流
   * @param ScheduleDto：理赔案件调度处理DTO,workflowDto
   * @throws Exception
   */
  public void changeSave(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
          ScheduleChangeSaveCommand scheduleChangeSaveCommand = new ScheduleChangeSaveCommand(scheduleDto,workFlowDto);
          scheduleChangeSaveCommand.execute();
  }
  
     /**
   * 保存理赔案件调度处理带工作流
   * @param ScheduleDto：理赔案件调度处理DTO,workflowDto
   * @throws Exception
   */
  public void changeSave(ScheduleDto scheduleDto) throws SQLException,Exception
  {
          ScheduleChangeSaveCommand scheduleChangeSaveCommand = new ScheduleChangeSaveCommand(scheduleDto);
          scheduleChangeSaveCommand.execute();
  }
  
  
  /**
   * 删除理赔案件调度处理
   * @param ScheduleNo：理赔案件调度处理号
   * @throws Exception
   */
  public void delete(int scheduleID,String registNo) throws SQLException,Exception
  {
    ScheduleDeleteCommand scheduleDeleteCommand = new ScheduleDeleteCommand(scheduleID,registNo);
          scheduleDeleteCommand.execute();
  }

  /**
   * 获得理赔案件调度处理信息
   * @param  ScheduleNo：理赔案件调度处理号
   * @return 理赔案件调度处理
   * @throws Exception
   */
  public ScheduleDto findByPrimaryKey(int scheduleID,String registNo) throws SQLException,UserException,Exception
  {
          ScheduleFindByConCommand scheduleFindByConCommand = new ScheduleFindByConCommand(scheduleID,registNo);
          ScheduleDto scheduleDto = (ScheduleDto)scheduleFindByConCommand.execute();

    if (scheduleDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return scheduleDto;
  }

  /**
   * 判断理赔案件调度处理号是否存在
   * @param ScheduleNo:理赔案件调度处理号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(int scheduleID,String registNo) throws SQLException,Exception
  {
          ScheduleIsExistCommand scheduleIsExistCommand = new ScheduleIsExistCommand(scheduleID,registNo);
          return ((Boolean)scheduleIsExistCommand.execute()).booleanValue();
  }

  /**
 * 获得案件调度处理信息
 * @param  conditions：查询条件
 * @return 案件调度处理对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
   PrpLscheduleMainWFFindByConCommand prpLscheduleMainWFFindByConCommand = new PrpLscheduleMainWFFindByConCommand(conditions);

    return (Collection)prpLscheduleMainWFFindByConCommand.execute();
 }
 
  /**
  * 获得调度查询信息
  * @param  conditions：查询条件
  * @return page
  * @throws Exception
  * Add By lixiang 2005-08-17 Reason:增加新的查询条件
  */


  public PageRecord findByConditions(String conditions,int pageNo,int recordPerPage) throws SQLException,Exception
  { 
  	PrpLscheduleMainWFFindByConditionsCommand prpLscheduleMainWFFindByConCommand = new PrpLscheduleMainWFFindByConditionsCommand(conditions,pageNo,recordPerPage);

     return (PageRecord)prpLscheduleMainWFFindByConCommand.execute();
  }



  /**
   * 获取调度处理的调度号
   * @param registNo:报案处理号
   * @return ScheduleID
   * @throws Exception
   */
  public int getNo(String registNo) throws SQLException,Exception
  {
          ScheduleGetNoCommand scheduleGetNoCommand = new ScheduleGetNoCommand(registNo);
          return ((Integer)scheduleGetNoCommand.execute()).intValue() ;

  }


 /**
 * 获得案件调度Item处理信息
 * @param  conditions：查询条件
 * @return 案件调度Item处理对象
 * @throws Exception
 */

 public Collection findItemByConditions(String conditions) throws SQLException,Exception
 {
   PrpLscheduleItemFindByConCommand prpLscheduleItemFindByConCommand = new PrpLscheduleItemFindByConCommand(conditions);

    return (Collection)prpLscheduleItemFindByConCommand.execute();
 }
 
 
   /**
  * 获得调度查询信息
  * @param  conditions：查询条件
  * @return page
  * @throws Exception
  * Add By lixiang 2005-08-17 Reason:增加新的查询条件
  */


  public PageRecord findItemByConditions(String conditions,int pageNo,int recordPerPage) throws SQLException,Exception
  { 
  	PrpLscheduleItemFindByConditionsCommand prpLscheduleItemFindByConCommand = new PrpLscheduleItemFindByConditionsCommand(conditions,pageNo,recordPerPage);

     return (PageRecord)prpLscheduleItemFindByConCommand.execute();
  }

  /**
   * 查找符合条件的个数(scheduleMainWF表)
   * @param conditon
   * @return
   * @throws Exception
   */
  public int findScheduleMainWFCountByConditon(String condition)throws Exception
	{
  	int intRet=0;
  	
  	PrpLscheduleMainWFGetCountCommand prpLscheduleMainWFGetCountCommand = new PrpLscheduleMainWFGetCountCommand(condition);
  	
  	intRet =((Integer)prpLscheduleMainWFGetCountCommand  .execute()).intValue()  ;
  	return intRet;
  }
  
  /**
   * 查找符合条件的个数(scheduleMainWF表)
   * @param conditon
   * @return
   * @throws Exception
   */
  public int findScheduleItemCountByConditon(String condition)throws Exception
	{
  	int intRet=0;
  	
  	PrpLscheduleItemGetCountCommand prpLscheduleItemGetCountCommand = new PrpLscheduleItemGetCountCommand(condition);
  	
  	intRet =((Integer)prpLscheduleItemGetCountCommand  .execute()).intValue()  ;
  	return intRet;
  }
  
  //add by zhaolu 20060802 start
  //reason:增加分页查询
  

  public PageRecord findForRegistConditions(String conditions,int pageNo,int recordPerPage)throws Exception
  {
 	 ScheduleGetNoCommand scheduleGetNoCommand = new ScheduleGetNoCommand(conditions,pageNo,recordPerPage);
 	 return (PageRecord)scheduleGetNoCommand.executeCommand();
  }
  
 
}
