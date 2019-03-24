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
 * 理赔新案件提示ScheduleNew
 * <p>Title: 车险理赔理赔新案件提示  </p>
 * <p>Description: 车险理赔理赔新案件提示</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */
public class UIScheduleNewAction
{
  /**
   * 保存理赔新案件提示
   * @param ScheduleNewDto：理赔新案件提示DTO
   * @throws Exception
   */
  public void save(ScheduleNewDto scheduleNewDto) throws SQLException,Exception
  {
          ScheduleNewSaveCommand scheduleNewSaveCommand = new ScheduleNewSaveCommand(scheduleNewDto);
          scheduleNewSaveCommand.execute();
  }
  /**
   * 删除理赔新案件提示
   * @param ScheduleNewNo：理赔新案件提示号
   * @throws Exception
   */
  public void delete(String registNo,int surveyNo) throws SQLException,Exception
  {
    ScheduleNewDeleteCommand scheduleNewDeleteCommand = new ScheduleNewDeleteCommand(registNo,surveyNo);
          scheduleNewDeleteCommand.execute();
  }

  /**
   * 获得理赔新案件提示信息
   * @param  ScheduleNewNo：理赔新案件提示号
   * @return 理赔新案件提示
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
   * 判断理赔新案件提示号是否存在
   * @param ScheduleNewNo:理赔新案件提示号
   * @return 是/否
   * @throws Exception
   */
  public boolean isExist(String registNo,int surveyNo) throws SQLException,Exception
  {
          ScheduleNewIsExistCommand scheduleNewIsExistCommand = new ScheduleNewIsExistCommand(registNo,surveyNo);
          return ((Boolean)scheduleNewIsExistCommand.execute()).booleanValue();
  }

  /**
 * 获得新案件提示信息
 * @param  conditions：查询条件
 * @return 新案件提示对象
 * @throws Exception
 */

 public Collection findByConditions(String conditions) throws SQLException,Exception
 {
   PrpLscheduleNewFindByConCommand prpLscheduleNewFindByConCommand = new PrpLscheduleNewFindByConCommand(conditions);

    return (Collection)prpLscheduleNewFindByConCommand.execute();
 }

}
