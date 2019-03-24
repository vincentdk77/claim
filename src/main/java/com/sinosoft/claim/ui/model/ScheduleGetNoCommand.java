package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLScheduleFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ScheduleGetNoCommand extends BaseCommand
{
	private String registNo;
	//add by zhaolu 20060802 start
	//reason:增加分页查询
	private int pageNo;
	
	private String conditions;
	
	
	private int recordPerPage;
	
	public ScheduleGetNoCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
	{
		this.conditions = conditions;
		this.pageNo = pageNo;
		this.recordPerPage = recordPerPage;
	}
	//add by zhaolu 20060802 end

	public ScheduleGetNoCommand(String registNo)  throws Exception
	{
		this.registNo = registNo;
	}
	public Object executeCommand() throws Exception
	{
		//add by zhaolu 20060802 start
		//reason:增加分页查询
		if( pageNo != 0 && recordPerPage != 0 )
		{
			BLScheduleFacade bLScheduleFacade = new BLScheduleFacade();
			
			return bLScheduleFacade.findByQueryConditions(conditions,pageNo,recordPerPage);
		}
		//add by zhaolu 20060802 end
            BLScheduleFacade bLScheduleFacade = new BLScheduleFacade();
	    return new Integer(bLScheduleFacade.getNo(registNo));

	}

}
