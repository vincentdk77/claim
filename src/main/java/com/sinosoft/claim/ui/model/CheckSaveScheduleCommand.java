package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCheckFacade;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CheckSaveScheduleCommand extends BaseCommand
{
  private ScheduleDto scheduleDto;

  public CheckSaveScheduleCommand(ScheduleDto scheduleDto)  throws Exception
  {
    this.scheduleDto = scheduleDto;
  }
  public Object executeCommand() throws Exception
  {
    BLCheckFacade bLCheckFacade = new BLCheckFacade();
    bLCheckFacade.saveSchedule(scheduleDto);
    return null;
  }
}
