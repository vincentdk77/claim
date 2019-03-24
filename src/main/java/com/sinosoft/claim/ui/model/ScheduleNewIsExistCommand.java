package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleNewFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleNewIsExistCommand extends BaseCommand
{
	private String registNo;
	private int surveyNo;


	public ScheduleNewIsExistCommand(String registNo,int surveyNo)  throws Exception
	{
		this.registNo = registNo;
		this.surveyNo =surveyNo;
	}
	public Object executeCommand() throws Exception
	{
		BLScheduleNewFacade bLScheduleNewFacade = new BLScheduleNewFacade();
	    return new Boolean(bLScheduleNewFacade.isExist(registNo,surveyNo));
	}

}
