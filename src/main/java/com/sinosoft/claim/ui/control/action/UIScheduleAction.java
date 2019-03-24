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
 * ���ⰸ�����ȴ���Schedule
 * <p>Title: �����������ⰸ�����ȴ���  </p>
 * <p>Description: �����������ⰸ�����ȴ���</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class UIScheduleAction
{
  /**
   * �������ⰸ�����ȴ���
   * @param ScheduleDto�����ⰸ�����ȴ���DTO
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto) throws SQLException,Exception
  {
          ScheduleSaveCommand scheduleSaveCommand = new ScheduleSaveCommand(scheduleDto);
          scheduleSaveCommand.execute();
  }
  
  
   /**
   * �������ⰸ�����ȴ����������
   * @param ScheduleDto�����ⰸ�����ȴ���DTO,workflowDto
   * @throws Exception
   */
  public void save(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
          ScheduleSaveCommand scheduleSaveCommand = new ScheduleSaveCommand(scheduleDto,workFlowDto);
          scheduleSaveCommand.execute();
  }
  
  
   /**
   * �������ⰸ�����ȴ����������
   * @param ScheduleDto�����ⰸ�����ȴ���DTO,workflowDto
   * @throws Exception
   */
  public void changeSave(ScheduleDto scheduleDto,WorkFlowDto workFlowDto) throws SQLException,Exception
  {
          ScheduleChangeSaveCommand scheduleChangeSaveCommand = new ScheduleChangeSaveCommand(scheduleDto,workFlowDto);
          scheduleChangeSaveCommand.execute();
  }
  
     /**
   * �������ⰸ�����ȴ����������
   * @param ScheduleDto�����ⰸ�����ȴ���DTO,workflowDto
   * @throws Exception
   */
  public void changeSave(ScheduleDto scheduleDto) throws SQLException,Exception
  {
          ScheduleChangeSaveCommand scheduleChangeSaveCommand = new ScheduleChangeSaveCommand(scheduleDto);
          scheduleChangeSaveCommand.execute();
  }
  
  
  /**
   * ɾ�����ⰸ�����ȴ���
   * @param ScheduleNo�����ⰸ�����ȴ����
   * @throws Exception
   */
  public void delete(int scheduleID,String registNo) throws SQLException,Exception
  {
    ScheduleDeleteCommand scheduleDeleteCommand = new ScheduleDeleteCommand(scheduleID,registNo);
          scheduleDeleteCommand.execute();
  }

  /**
   * ������ⰸ�����ȴ�����Ϣ
   * @param  ScheduleNo�����ⰸ�����ȴ����
   * @return ���ⰸ�����ȴ���
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
   * �ж����ⰸ�����ȴ�����Ƿ����
   * @param ScheduleNo:���ⰸ�����ȴ����
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(int scheduleID,String registNo) throws SQLException,Exception
  {
          ScheduleIsExistCommand scheduleIsExistCommand = new ScheduleIsExistCommand(scheduleID,registNo);
          return ((Boolean)scheduleIsExistCommand.execute()).booleanValue();
  }

  /**
 * ��ð������ȴ�����Ϣ
 * @param  conditions����ѯ����
 * @return �������ȴ������
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
   PrpLscheduleMainWFFindByConCommand prpLscheduleMainWFFindByConCommand = new PrpLscheduleMainWFFindByConCommand(conditions);

    return (Collection)prpLscheduleMainWFFindByConCommand.execute();
 }
 
  /**
  * ��õ��Ȳ�ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return page
  * @throws Exception
  * Add By lixiang 2005-08-17 Reason:�����µĲ�ѯ����
  */


  public PageRecord findByConditions(String conditions,int pageNo,int recordPerPage) throws SQLException,Exception
  { 
  	PrpLscheduleMainWFFindByConditionsCommand prpLscheduleMainWFFindByConCommand = new PrpLscheduleMainWFFindByConditionsCommand(conditions,pageNo,recordPerPage);

     return (PageRecord)prpLscheduleMainWFFindByConCommand.execute();
  }



  /**
   * ��ȡ���ȴ���ĵ��Ⱥ�
   * @param registNo:���������
   * @return ScheduleID
   * @throws Exception
   */
  public int getNo(String registNo) throws SQLException,Exception
  {
          ScheduleGetNoCommand scheduleGetNoCommand = new ScheduleGetNoCommand(registNo);
          return ((Integer)scheduleGetNoCommand.execute()).intValue() ;

  }


 /**
 * ��ð�������Item������Ϣ
 * @param  conditions����ѯ����
 * @return ��������Item�������
 * @throws Exception
 */

 public Collection findItemByConditions(String conditions) throws SQLException,Exception
 {
   PrpLscheduleItemFindByConCommand prpLscheduleItemFindByConCommand = new PrpLscheduleItemFindByConCommand(conditions);

    return (Collection)prpLscheduleItemFindByConCommand.execute();
 }
 
 
   /**
  * ��õ��Ȳ�ѯ��Ϣ
  * @param  conditions����ѯ����
  * @return page
  * @throws Exception
  * Add By lixiang 2005-08-17 Reason:�����µĲ�ѯ����
  */


  public PageRecord findItemByConditions(String conditions,int pageNo,int recordPerPage) throws SQLException,Exception
  { 
  	PrpLscheduleItemFindByConditionsCommand prpLscheduleItemFindByConCommand = new PrpLscheduleItemFindByConditionsCommand(conditions,pageNo,recordPerPage);

     return (PageRecord)prpLscheduleItemFindByConCommand.execute();
  }

  /**
   * ���ҷ��������ĸ���(scheduleMainWF��)
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
   * ���ҷ��������ĸ���(scheduleMainWF��)
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
  //reason:���ӷ�ҳ��ѯ
  

  public PageRecord findForRegistConditions(String conditions,int pageNo,int recordPerPage)throws Exception
  {
 	 ScheduleGetNoCommand scheduleGetNoCommand = new ScheduleGetNoCommand(conditions,pageNo,recordPerPage);
 	 return (PageRecord)scheduleGetNoCommand.executeCommand();
  }
  
 
}
