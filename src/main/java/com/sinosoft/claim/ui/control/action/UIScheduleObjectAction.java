package com.sinosoft.claim.ui.control.action;


//import com.sinosoft.function.workflow.ejb.client.SharkFactory;
//import com.sinosoft.function.workflow.ejb.shark.SharkClientInterface;
import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.claim.ui.model.ScheduleObjectFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.ScheduleObjectSaveCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**   
 * 工作流操作逻辑
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔工作流接口程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Object: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */
public class UIScheduleObjectAction
{
  /**
   * 获得理赔案件调度处理信息
   * @param  ScheduleNo：理赔案件调度处理号
   * @return 理赔案件调度处理
   * @throws Exception
   */
  public ScheduleObjectDto findByPrimaryKey(String comCode) throws SQLException,UserException,Exception
  {
          ScheduleObjectFindByPrimaryKeyCommand scheduleObjectFindByPrimaryKeyCommand = new ScheduleObjectFindByPrimaryKeyCommand(comCode);
          ScheduleObjectDto scheduleObjectDto = (ScheduleObjectDto)scheduleObjectFindByPrimaryKeyCommand.execute();

    if (scheduleObjectDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+comCode+")");
    }
    return scheduleObjectDto;
  }
  
  
   /**
   * 保存理赔案件调度处理
   * @param ScheduleDto：理赔案件调度处理DTO
   * @throws Exception
   */
  public void save(ScheduleObjectDto scheduleObjectDto) throws SQLException,Exception
  {
          ScheduleObjectSaveCommand scheduleObjectSaveCommand = new ScheduleObjectSaveCommand(scheduleObjectDto);
          scheduleObjectSaveCommand.execute();
  }
}
