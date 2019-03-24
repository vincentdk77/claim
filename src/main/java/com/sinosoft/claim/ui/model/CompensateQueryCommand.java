package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加实赔查询Command类
  */

public class CompensateQueryCommand extends BaseCommand {
  private String conditions;
  
  //add by zhaolu 20060803 start
  private int pageNo;
  
  private int recordPerPage;
  
  public CompensateQueryCommand(String conditions,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  //add by zhaolu 20060803 end

  public CompensateQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
	  //add by zhaolu 20060803 start
	  if(pageNo != 0 && recordPerPage != 0)
	  {
		  return new BLCompensateFacade().findByQueryConditions(conditions,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060803 end
      BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
      return bLCompensateFacade.findByQueryConditions(conditions);
  }

}