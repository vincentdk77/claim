package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCheckFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加查勘查询Command类
  */

public class CheckQueryCommand extends BaseCommand {
  private String conditions;
  
  //add by zhaolu 20060802 start
  
  private int pageNo;
  
  private int recordPerPage;
  
  public CheckQueryCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  //add by zhaolu 20060802 end

  public CheckQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
	  //add by zhaolu 20060802 start
	  if( pageNo != 0 && recordPerPage != 0 )
	  {
		  return new BLCheckFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060802 end
      BLCheckFacade bLCheckFacade = new BLCheckFacade();
      return bLCheckFacade.findByQueryConditions(conditions);
  }
  public Object executeCommandAcci() throws Exception
  {
	  //add by zhaolu 20060802 start
	  if( pageNo != 0 && recordPerPage != 0 )
	  {
		  return new BLCheckFacade().findByQueryConditionsAcci(conditions,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060802 end
      BLCheckFacade bLCheckFacade = new BLCheckFacade();
      return bLCheckFacade.findByQueryConditionsAcci(conditions);
  }}