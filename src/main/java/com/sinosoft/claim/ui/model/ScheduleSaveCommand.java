package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleFacade;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleSaveCommand extends BaseCommand
{
	private ScheduleDto scheduleDto =null;
  private WorkFlowDto workFlowDto =null;
	public ScheduleSaveCommand(ScheduleDto scheduleDto)  throws Exception
	{
		 this.scheduleDto= scheduleDto;
  }
	
	public ScheduleSaveCommand(ScheduleDto scheduleDto,WorkFlowDto workFlowDto)  throws Exception
	{
		 this.scheduleDto= scheduleDto;
    this.workFlowDto = workFlowDto;
	}
	
	
	public Object executeCommand() throws Exception
	{
		 BLScheduleFacade bLScheduleFacade = new BLScheduleFacade();
    bLScheduleFacade.save(scheduleDto,workFlowDto); 
    return null;

	}

}
