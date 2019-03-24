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
 * �鿱����Check
 * <p>Title: �������������鿱action  </p>
 * <p>Description: �������������鿱action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0  
 */
public class UICheckAction
{
  /**
   * ����鿱
   * @param CheckDto���鿱����DTO
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDto,certainLossDto);
  	checkSaveCommand.execute();
  } 
 
  /**
   * ����鿱
   * @param CheckDto���鿱����DTO
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDtoList,certainLossDtoList);
  	checkSaveCommand.execute();
  } 
 
  /**
   * ����鿱��������
   * @param CheckDto���鿱����DTO
   * @throws Exception
   */
  public void save(ArrayList checkDtoList,ArrayList certainLossDtoList,ArrayList workFlowDtoList) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDtoList,certainLossDtoList,workFlowDtoList);
  	checkSaveCommand.execute();
  }
  /**
   * ����鿱��������
   * @param CheckDto���鿱����DTO
   * @throws Exception
   */
  public void save(CheckDto checkDto,CertainLossDto certainLossDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	CheckSaveCommand checkSaveCommand = new CheckSaveCommand(checkDto,certainLossDto,workFlowDto);
  	checkSaveCommand.execute();
  }
  /**
  * ����鿱����
  * @param CheckDto�����ȶ���DTO
  * @throws Exception
  */
 public void saveSchedule(ScheduleDto scheduleDto) throws SQLException,Exception
 {
         CheckSaveScheduleCommand checkSaveScheduleCommand = new CheckSaveScheduleCommand(scheduleDto);
         checkSaveScheduleCommand.execute();
 }


  /**
   * ɾ���鿱
   * @param checkNo���鿱��
   * @throws Exception
   */
  public void delete(String checkNo) throws SQLException,Exception
  {
    CheckDeleteCommand checkDeleteCommand = new CheckDeleteCommand(checkNo);
  	checkDeleteCommand.execute();
  }

  /**
   * ��ò鿱��Ϣ
   * @param  checkNo���鿱��
   * @return �鿱����
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
   * �жϲ鿱���Ƿ����
   * @param checkNo:�鿱��
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String checkNo) throws SQLException,Exception
  {
  	CheckIsExistCommand checkIsExistCommand = new CheckIsExistCommand(checkNo);
  	return ((Boolean)checkIsExistCommand.execute()).booleanValue();
  }
  /**
  * ��ò鿱��Ϣ
  * @param  conditions����ѯ����
  * @return �鿱����
  * @throws Exception
  */

  public Collection findByConditions(String conditions) throws SQLException,Exception
  {
     PrpLcheckFindByConCommand prpLcheckFindByConCommand = new PrpLcheckFindByConCommand(conditions);

     return (Collection)prpLcheckFindByConCommand.execute();
  }



  /**
 * ��õ��Ȳ鿱��Ϣ
 * @param  conditions����ѯ����
 * @return �鿱����
 * @throws Exception
 */

 public Collection findNewScheduleTaskList(String conditions) throws SQLException,Exception
 {
    CheckFindNewScheduleTaskListCommand checkFindNewScheduleTaskListCommand = new CheckFindNewScheduleTaskListCommand(conditions);

    return (Collection)checkFindNewScheduleTaskListCommand.execute();
 }

  /**
  * ��ò鿱��ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return ��������
  * @throws Exception
  * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
  */

  public Collection findByQueryConditions(String conditions) throws SQLException,Exception
  {
     CheckQueryCommand checkQueryCommand = new CheckQueryCommand(conditions);

     return (Collection)checkQueryCommand.executeCommand();
  }
  
  //modify by wangwei add start 2005-0006-18
  //ԭ����ӷ������ڲ�ѯ�������Ϣ
  /**
   * ��ò鿱��ѯ��Ϣ
   * @param  conditions����ѯ����
   * @return ��������
   * @throws Exception
   * Add By sunhao 2004-08-24 Reason:�����µĲ�ѯ����
   */

   public Collection findByQueryConditionsAcci(String conditions) throws SQLException,Exception
   {
      CheckQueryCommand checkQueryCommand = new CheckQueryCommand(conditions);

      return (Collection)checkQueryCommand.executeCommandAcci();
   }
  //modify by wangwei add end 2005-06-18
  
  //	mdoify by wangli start 20050414
  /**
   * ���浽���⳵����Ϣ��͵��������ı���
   * @param CheckDto���鿱����DTO
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
   * ���浽���⳵����Ϣ��͵��������ı���
   * @param CheckDto���鿱����DTO
   * @throws Exception
   */
  public void saveScheduleAddCertainLoss(CheckDto checkDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
  	ScheduleAddCertainLossCommand scheduleAddCertainLossCommand = new ScheduleAddCertainLossCommand(checkDto,workFlowDto);
  	scheduleAddCertainLossCommand.execute();
  }
  
}
