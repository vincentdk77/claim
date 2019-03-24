package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpLscheduleItemFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLscheduleItemFindByConCommand extends BaseCommand
{
  private String conditions;
  
  //add by zhaolu 20060802 start
  //reason:增加分页查询功能
  private int pageNo;
  
  private int recordPerPage;
  
  public PrpLscheduleItemFindByConCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  //add by zhaolu 20060802 end

  public PrpLscheduleItemFindByConCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
	  //add by zhaolu 20060802 start
	  
	  if ( pageNo != 0 && recordPerPage != 0)
	  {
		  BLPrpLscheduleItemFacade bLPrpLscheduleItemFacade = new BLPrpLscheduleItemFacade();
		  return bLPrpLscheduleItemFacade.findByConditions(conditions,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060802 end
    BLPrpLscheduleItemFacade bLPrpLscheduleItemFacade = new BLPrpLscheduleItemFacade();
      return bLPrpLscheduleItemFacade.findByConditions(conditions);
  }

  
}
