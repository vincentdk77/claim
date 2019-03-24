package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleNewFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleNewDeleteCommand extends BaseCommand
{
	private String registNo;
	private int surevyNo;

	public ScheduleNewDeleteCommand(String registNo,int surevyNo)  throws Exception
	{
		this.registNo = registNo;
		this.surevyNo=surevyNo;
	}
	public Object executeCommand() throws Exception
	{
	BLScheduleNewFacade bLScheduleNewFacade = new BLScheduleNewFacade();
	    bLScheduleNewFacade.delete(registNo,surevyNo);
	    return null;
	}

}
