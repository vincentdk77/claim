package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleIsExistCommand extends BaseCommand
{
	private int scheduleID;
	private String registNo;

	public ScheduleIsExistCommand(int scheduleID,String registNo)  throws Exception
	{
		this.registNo = registNo;
		this.scheduleID  =scheduleID ;
	}
	public Object executeCommand() throws Exception
	{
		BLScheduleFacade bLScheduleFacade = new BLScheduleFacade();
	    return new Boolean(bLScheduleFacade.isExist(scheduleID,registNo));
	}

}
