package com.sinosoft.claim.ui.control.action;

import java.sql.SQLException;
import java.util.Collection;

import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.claim.ui.model.PrpLscheduleNewFindByConCommand;
import com.sinosoft.claim.ui.model.ScheduleNewDeleteCommand;
import com.sinosoft.claim.ui.model.ScheduleNewFindByConCommand;
import com.sinosoft.claim.ui.model.ScheduleNewIsExistCommand;
import com.sinosoft.claim.ui.model.ScheduleNewSaveCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �����°�����ʾScheduleNew
 * <p>Title: �������������°�����ʾ  </p>
 * <p>Description: �������������°�����ʾ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class UIScheduleNewAction
{
  /**
   * ���������°�����ʾ
   * @param ScheduleNewDto�������°�����ʾDTO
   * @throws Exception
   */
  public void save(ScheduleNewDto scheduleNewDto) throws SQLException,Exception
  {
          ScheduleNewSaveCommand scheduleNewSaveCommand = new ScheduleNewSaveCommand(scheduleNewDto);
          scheduleNewSaveCommand.execute();
  }
  /**
   * ɾ�������°�����ʾ
   * @param ScheduleNewNo�������°�����ʾ��
   * @throws Exception
   */
  public void delete(String registNo,int surveyNo) throws SQLException,Exception
  {
    ScheduleNewDeleteCommand scheduleNewDeleteCommand = new ScheduleNewDeleteCommand(registNo,surveyNo);
          scheduleNewDeleteCommand.execute();
  }

  /**
   * ��������°�����ʾ��Ϣ
   * @param  ScheduleNewNo�������°�����ʾ��
   * @return �����°�����ʾ
   * @throws Exception
   */
  public ScheduleNewDto findByPrimaryKey(String registNo,int surveyNo) throws SQLException,UserException,Exception
  {
          ScheduleNewFindByConCommand scheduleNewFindByConCommand = new ScheduleNewFindByConCommand(registNo,surveyNo);
          ScheduleNewDto scheduleNewDto = (ScheduleNewDto)scheduleNewFindByConCommand.execute();

    if (scheduleNewDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+registNo+")");
    }
    return scheduleNewDto;
  }

  /**
   * �ж������°�����ʾ���Ƿ����
   * @param ScheduleNewNo:�����°�����ʾ��
   * @return ��/��
   * @throws Exception
   */
  public boolean isExist(String registNo,int surveyNo) throws SQLException,Exception
  {
          ScheduleNewIsExistCommand scheduleNewIsExistCommand = new ScheduleNewIsExistCommand(registNo,surveyNo);
          return ((Boolean)scheduleNewIsExistCommand.execute()).booleanValue();
  }

  /**
 * ����°�����ʾ��Ϣ
 * @param  conditions����ѯ����
 * @return �°�����ʾ����
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
   PrpLscheduleNewFindByConCommand prpLscheduleNewFindByConCommand = new PrpLscheduleNewFindByConCommand(conditions);

    return (Collection)prpLscheduleNewFindByConCommand.execute();
 }

}
