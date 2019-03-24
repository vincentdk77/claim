package com.sinosoft.claim.ui.control.action;


//import com.sinosoft.function.workflow.ejb.client.SharkFactory;
//import com.sinosoft.function.workflow.ejb.shark.SharkClientInterface;
import java.sql.SQLException;

import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.claim.ui.model.ScheduleCompanyFindByPrimaryKeyCommand;
import com.sinosoft.claim.ui.model.ScheduleCompanySaveCommand;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**   
 * 工作流操作逻辑
 * <p>Title: 车险理赔</p>
 * <p>Description: 车险理赔工作流接口程序</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author 项目组
 * @version 1.0
 */
public class UIScheduleCompanyAction
{
  /**
   * 获得理赔案件调度处理信息
   * @param  ScheduleNo：理赔案件调度处理号
   * @return 理赔案件调度处理
   * @throws Exception
   */
  public ScheduleCompanyDto findByPrimaryKey(String comCode) throws SQLException,UserException,Exception
  {
          ScheduleCompanyFindByPrimaryKeyCommand scheduleCompanyFindByPrimaryKeyCommand = new ScheduleCompanyFindByPrimaryKeyCommand(comCode);
          ScheduleCompanyDto scheduleCompanyDto = (ScheduleCompanyDto)scheduleCompanyFindByPrimaryKeyCommand.execute();

    if (scheduleCompanyDto == null)
    {
      throw new UserException(-98,-1000,this.getClass().getName()+".findByPrimaryKey("+comCode+")");
    }
    return scheduleCompanyDto;
  }
  
  
   /**
   * 保存理赔案件调度处理
   * @param ScheduleDto：理赔案件调度处理DTO
   * @throws Exception
   */
  public void save(ScheduleCompanyDto scheduleCompanyDto) throws SQLException,Exception
  {
          ScheduleCompanySaveCommand scheduleCompanySaveCommand = new ScheduleCompanySaveCommand(scheduleCompanyDto);
          scheduleCompanySaveCommand.execute();
  }
}
