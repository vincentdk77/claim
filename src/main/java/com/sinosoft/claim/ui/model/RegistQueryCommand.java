package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加报案查询Command类
  */

public class RegistQueryCommand extends BaseCommand {
  private String conditions;
  private String pageNo;
  private String recordPerPage;
  
  public RegistQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
      this.pageNo = "";
      this.recordPerPage = "";
  }
  public RegistQueryCommand(String conditions,String pageNo,String recordPerPage)  throws Exception
  {
      this.conditions = conditions;
      this.pageNo = pageNo;
      this.recordPerPage = recordPerPage; 
  }
  public Object executeCommand() throws Exception
  {
      BLRegistFacade bLRegistFacade = new BLRegistFacade();
      if ("".equals(this.pageNo) && "".equals(this.recordPerPage)) {
      	  return bLRegistFacade.findByQueryConditions(conditions);
  	  } else {
  	      return bLRegistFacade.findByQueryConditions(conditions,pageNo,recordPerPage);
  	  } 
  }
}