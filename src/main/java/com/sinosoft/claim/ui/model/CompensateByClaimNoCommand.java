
package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

 /** Create By wangli 20050420
  * Reason:����ʵ������ⰸ�Ų�ѯCommand��
  */

public class CompensateByClaimNoCommand extends BaseCommand {
  private String conditions;

  public CompensateByClaimNoCommand(String conditions)  throws Exception
  {
      this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
      BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
      return bLCompensateFacade.findByClaimNo(conditions);
  }

}