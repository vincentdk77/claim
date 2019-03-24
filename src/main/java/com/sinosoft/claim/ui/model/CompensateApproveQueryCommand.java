package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By liubvo 2004-09-07
  * Reason:增加实赔查询Command类
  */

public class CompensateApproveQueryCommand extends BaseCommand {
  private String conditions;

  public CompensateApproveQueryCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
      return bLCompensateFacade.findByApproveQueryConditions(conditions);
  }

}