package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加立案查询Command类
  */

public class ClaimQueryCommand extends BaseCommand {
  private String conditions;
  
  //add by zhaolu 20060802 start
  private int pageNo;
  
  private int recordPerPage;
  
  public ClaimQueryCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  //add by zhaolu 20060802 end

  public ClaimQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
	  //add by zhaolu 20060802 start
	  if( pageNo != 0 && recordPerPage != 0)
	  {
		  return new BLClaimFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060802 end
      BLClaimFacade bLClaimFacade = new BLClaimFacade();
      return bLClaimFacade.findByQueryConditions(conditions);
  }

}