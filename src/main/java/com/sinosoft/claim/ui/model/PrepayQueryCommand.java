package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By sunhao 2004-08-24
  * Reason:增加预赔查询Command类
  */

public class PrepayQueryCommand extends BaseCommand {
  private String conditions;

  public PrepayQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
      return bLPrepayFacade.findByQueryConditions(conditions);
  }

}