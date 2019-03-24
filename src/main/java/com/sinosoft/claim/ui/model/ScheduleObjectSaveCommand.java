package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleObjectFacade;
import com.sinosoft.claim.dto.custom.ScheduleObjectDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleObjectSaveCommand extends BaseCommand
{
	private ScheduleObjectDto scheduleObjectDto =null;
 public ScheduleObjectSaveCommand(ScheduleObjectDto scheduleObjectDto)  throws Exception
	{
		 this.scheduleObjectDto= scheduleObjectDto;
  }
	
	
	
	public Object executeCommand() throws Exception
	{
		 BLScheduleObjectFacade bLScheduleObjectFacade = new BLScheduleObjectFacade();
    bLScheduleObjectFacade.save (scheduleObjectDto); 
    return null;

	}

}
