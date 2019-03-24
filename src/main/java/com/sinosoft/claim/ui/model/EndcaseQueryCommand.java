package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndcaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加结案查询Command类
  */

public class EndcaseQueryCommand extends BaseCommand {
  private String conditions;

  public EndcaseQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLEndcaseFacade bLEndcaseFacade = new BLEndcaseFacade();
      return bLEndcaseFacade.findByQueryConditions(conditions);
  }

}