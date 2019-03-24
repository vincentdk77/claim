package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleFacade;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleChangeSaveCommand extends BaseCommand
{
	private ScheduleDto scheduleDto =null;
  private WorkFlowDto workFlowDto =null;
	public ScheduleChangeSaveCommand(ScheduleDto scheduleDto)  throws Exception
	{
		 this.scheduleDto= scheduleDto;
  }
	
	public ScheduleChangeSaveCommand(ScheduleDto scheduleDto,WorkFlowDto workFlowDto)  throws Exception
	{
		 this.scheduleDto= scheduleDto;
    this.workFlowDto = workFlowDto;
	}
	
	
	public Object executeCommand() throws Exception
	{
		 BLScheduleFacade bLScheduleFacade = new BLScheduleFacade();
    bLScheduleFacade.changeSave(scheduleDto,workFlowDto); 
    return null;

	}

}
