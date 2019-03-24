package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleNewFacade;
import com.sinosoft.claim.dto.custom.ScheduleNewDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleNewSaveCommand extends BaseCommand
{
	private ScheduleNewDto scheduleNewDto;

	public ScheduleNewSaveCommand(ScheduleNewDto scheduleNewDto)  throws Exception
	{
		this.scheduleNewDto = scheduleNewDto;
	}
	public Object executeCommand() throws Exception
	{
		BLScheduleNewFacade bLScheduleNewFacade = new BLScheduleNewFacade();
	    bLScheduleNewFacade.save(scheduleNewDto);
	    return null;
	}

}
