package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleCompanyFacade;
import com.sinosoft.claim.dto.custom.ScheduleCompanyDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleCompanySaveCommand extends BaseCommand
{
	private ScheduleCompanyDto scheduleCompanyDto =null;
 public ScheduleCompanySaveCommand(ScheduleCompanyDto scheduleCompanyDto)  throws Exception
	{
		 this.scheduleCompanyDto= scheduleCompanyDto;
  }
	
	
	
	public Object executeCommand() throws Exception
	{
		 BLScheduleCompanyFacade bLScheduleCompanyFacade = new BLScheduleCompanyFacade();
    bLScheduleCompanyFacade.save (scheduleCompanyDto); 
    return null;

	}

}
