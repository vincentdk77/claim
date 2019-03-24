package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPolicyFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加报案查询Command类
  */

public class PolicyCheckPayCommand extends BaseCommand {
  private String conditions;

  public PolicyCheckPayCommand(String conditions)  throws Exception
  { 
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception 
  {
    BLPolicyFacade blPolicyFacade = new BLPolicyFacade(); 
    return new Integer(blPolicyFacade.checkPay(conditions));     
  }
}