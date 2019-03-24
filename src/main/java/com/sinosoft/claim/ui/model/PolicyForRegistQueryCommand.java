package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加报案查询Command类
  */

public class PolicyForRegistQueryCommand extends BaseCommand {
  private String conditions;
  private String pageNo;
  private String recordPerPage;
  
  public PolicyForRegistQueryCommand(String conditions,String pageNo,String recordPerPage)  throws Exception
  {
      this.conditions = conditions;
      this.pageNo = pageNo;
      this.recordPerPage = recordPerPage; 
  }
  public Object executeCommand() throws Exception
  {
      BLPolicyFacade blPolicyFacade = new BLPolicyFacade();  
      return blPolicyFacade.findForRegistConditions(conditions,pageNo,recordPerPage); 
  }

}