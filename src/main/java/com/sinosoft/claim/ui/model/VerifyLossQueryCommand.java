package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加核损查询Command类
  */

public class VerifyLossQueryCommand extends BaseCommand {
  private String conditions;
  private String nodeType;
  
  //add by zhaolu 20060803 start
  private int pageNo;
  
  private int recordPerPage;
  
  public VerifyLossQueryCommand(String conditions,String nodeType,int pageNo,int recordPerPage)  throws Exception
  {
	  this.conditions = conditions;
	  this.nodeType = nodeType;
	  this.pageNo = pageNo;
	  this.recordPerPage = recordPerPage;
  }
  //add by zhaolu 20060803 end

  public VerifyLossQueryCommand(String conditions,String nodeType)  throws Exception
  {
      this.conditions = conditions;
      this.nodeType = nodeType;
  }
  public Object executeCommand() throws Exception
  {
	  //add by zhaolu 20060803 start
	  if( pageNo != 0 && recordPerPage != 0)
	  {
		  return new BLVerifyLossFacade().findByCondition(conditions,nodeType,pageNo,recordPerPage);
	  }
	  //add by zhaolu 20060803 end
      BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
      return bLVerifyLossFacade.findByQueryConditions(conditions,nodeType);
  }

}