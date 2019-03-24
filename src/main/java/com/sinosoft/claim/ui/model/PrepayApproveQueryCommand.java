package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By liubvo 2004-09-07
  * Reason:增加预赔查询Command类
  */

public class PrepayApproveQueryCommand extends BaseCommand {
  private String conditions;

  public PrepayApproveQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
      return bLPrepayFacade.findByApproveQueryConditions(conditions);
  }

}