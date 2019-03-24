package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpLpersonFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpLpersonFacade的UI Command类<br>
 * 创建于 2004-09-20 14:11:35.017<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpersonFindByConditionsCommand extends BaseCommand{
  private String conditions;

  public PrpLpersonFindByConditionsCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLPrpLpersonFacade prpLpersonFacade = new BLPrpLpersonFacade();
    return prpLpersonFacade.findByConditions(conditions);
  }
}
