package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLAreaSettingFacade;
import com.sinosoft.claim.bl.facade.BLJobManagerFacade;

public class AreaSettingQueryCommand {
	private String conditions;
	
	private int pageNo;
	
	private int recordPerPage;
	
	public AreaSettingQueryCommand(String conditions,int pageNo,int recordPerPage){
		this.conditions = conditions;
		this.pageNo = pageNo;
		this.recordPerPage = recordPerPage;
	}
	
	public Object executeCommand() throws Exception
	  {
		  //add by zhaolu 20060802 start
		  if( pageNo != 0 && recordPerPage != 0)
		  {
			  return new BLAreaSettingFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
		  }
		  //add by zhaolu 20060802 end
	      BLAreaSettingFacade blAreaSettingFacade = new BLAreaSettingFacade();
	      return blAreaSettingFacade.findByQueryConditions(conditions);
	  }

}
