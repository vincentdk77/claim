package com.sinosoft.claim.query.ui.control.actioin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.ui.model.CheckDeleteCommand;
import com.sinosoft.claim.query.ui.model.CheckFindByConCommand;
import com.sinosoft.claim.ui.model.CheckFindNewScheduleTaskListCommand;
import com.sinosoft.claim.ui.model.CheckIsExistCommand;
import com.sinosoft.claim.ui.model.CheckQueryCommand;
import com.sinosoft.claim.ui.model.CheckSaveCommand;
import com.sinosoft.claim.ui.model.CheckSaveScheduleCommand;
import com.sinosoft.claim.ui.model.PrpLcheckFindByConCommand;
import com.sinosoft.claim.ui.model.ScheduleAddCertainLossCommand;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 查勘对象Check
 * <p>Title: 车险理赔样本查勘action  </p>
 * <p>Description: 车险理赔样本查勘action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0  
 */
public class UICheckAction
{
  /**
   * 保存查勘
   * @param CheckDto：查勘对象DTO
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDto,certainLossDto);
  	checkSaveCommand.execute();
  } 
 
  /**
   * 保存查勘
   * @param CheckDto：查勘对象DTO
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDtoList,certainLossDtoList);
  	checkSaveCommand.execute();
  } 
 
  /**
   * 保存查勘带工作流
   * @param CheckDto：查勘对象DTO
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDtoList,certainLossDtoList,workFlowDtoList);
  	checkSaveCommand.execute();
  }
  /**
   * 保存查勘带工作流
   * @param CheckDto：查勘对象DTO
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDto,certainLossDto,workFlowDto);
  	checkSaveCommand.execute();
  }
  /**
  * 保存查勘调度
  * @param CheckDto：调度对象DTO
  * @throws Exception
  */
 public void saveSchedule(ScheduleDto scheduleDto) throws SQLException,Exception
 {
         CheckSaveScheduleCommand checkSaveScheduleCommand = new CheckSaveScheduleCommand(scheduleDto);
         checkSaveScheduleCommand.execute();
 }


  /**
   * 删除查勘
   * @param checkNo：查勘号
   * @throws Exception
   */
  public void delete(String checkNo) throws SQLException,Exception
  {
    CheckDeleteCommand checkDeleteCommand = new CheckDeleteCommand(checkNo);
  	checkDeleteCommand.execute();
  }

  /**
   * 获得查勘信息
   * @param  checkNo：查勘号
   * @return 查勘对象
   * @throws Exception
   */
  public CheckDto findByPrimaryKey(String checkNo) throws SQLException,UserException,Exception
  {
  	CheckFindByConCommand checkFindByConCommand = new CheckFindByConCommand(checkNo);
  	CheckDto checkDto = (CheckDto)checkFindByConCommand.execute();

    if (checkDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+checkNo+")");
    }
    return checkDto;
  }

  /**
   * 判断查勘号是否存在
   * @param checkNo:查勘号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String checkNo) throws SQLException,Exception
  {
  	CheckIsExistCommand checkIsExistCommand = new CheckIsExistCommand(checkNo);
  	return ((Boolean)checkIsExistCommand.execute()).booleanValue();
  }
  /**
  * 获得查勘信息
  * @param  conditions：查询条件
  * @return 查勘对象
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcheckFindByConCommand prpLcheckFindByConCommand = new PrpLcheckFindByConCommand(conditions);

     return (Collection)prpLcheckFindByConCommand.execute();
  }



  /**
 * 获得调度查勘信息
 * @param  conditions：查询条件
 * @return 查勘对象
 * @throws Exception
 */

 public Collection findNewScheduleTaskList(String conditions) throws SQLException,Exception
 {
    CheckFindNewScheduleTaskListCommand checkFindNewScheduleTaskListCommand = new CheckFindNewScheduleTaskListCommand(conditions);

    return (Collection)checkFindNewScheduleTaskListCommand.execute();
 }

  /**
  * 获得查勘查询信息
  * @param  conditions：查询条件
  * @return 报案对象
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:增加新的查询条件
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     CheckQueryCommand checkQueryCommand = new CheckQueryCommand(conditions);

     return (Collection)checkQueryCommand.executeCommand();
  }
  
  //modify by wangwei add start 2005-0006-18
  //原因：添加方法用于查询意键险信息
  /**
   * 获得查勘查询信息
   * @param  conditions：查询条件
   * @return 报案对象
   * @throws Exception
   * Add By sunhao 2004-08-24 Reason:增加新的查询条件
   */

   public Collection findByQueryConditionsAcci(String conditions) throws SQLException,Exception
   {
      CheckQueryCommand checkQueryCommand = new CheckQueryCommand(conditions);

      return (Collection)checkQueryCommand.executeCommandAcci();
   }
  //modify by wangwei add end 2005-06-18
  
  //	mdoify by wangli start 20050414
  /**
   * 保存到理赔车辆信息表和调度任务标的表中
   * @param CheckDto：查勘对象DTO
   * @throws Exception
   */
  public void saveScheduleAddCertainLoss(CheckDto checkDto) throws SQLException,Exception
  {
  	ScheduleAddCertainLossCommand scheduleAddCertainLossCommand = new ScheduleAddCertainLossCommand(checkDto);
  	scheduleAddCertainLossCommand.execute();
  }
  
//	mdoify by wangli start 20050414
  
 //add by zhaolu 20060802 start
  public PageRecord findByQueryConditionsAcci(String conditions,int pageNo,int recordPerPage)throws SQLException,Exception
  {
	  CheckQueryCommand checkQueryCommand = new CheckQueryCommand(conditions,pageNo,recordPerPage);
	  PageRecord pageRecord = (PageRecord)checkQueryCommand.executeCommandAcci();
	  return pageRecord;
  }
  
  public PageRecord findByQueryConditions(String conditions,int pageNo,int recordPerPage)throws SQLException,Exception
  {
	  CheckQueryCommand checkQueryCommand = new CheckQueryCommand(conditions,pageNo,recordPerPage);
	  PageRecord pageRecord = (PageRecord)checkQueryCommand.executeCommand();
	  return pageRecord;
  }
  //add by zhaolu 20060802 end
  
  /**
   * 保存到理赔车辆信息表和调度任务标的表中
   * @param CheckDto：查勘对象DTO
   * @throws Exception
   */
  public void saveScheduleAddCertainLoss(CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	ScheduleAddCertainLossCommand scheduleAddCertainLossCommand = new ScheduleAddCertainLossCommand(checkDto,workFlowDto);
  	scheduleAddCertainLossCommand.execute();
  }
  
}
