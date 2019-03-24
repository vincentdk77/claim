package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpDpersonPayFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;


/**
 * 这是BLPrpDpersonPayFacade的UI Command类<br>
 * 创建于 2004-09-20 14:11:33.985<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDpersonPayFindByConditionsCommand extends BaseCommand{
  private String conditions;

  public PrpDpersonPayFindByConditionsCommand(String conditions)  throws Exception
  {
    this.conditions = conditions;
  }
  public Object executeCommand() throws Exception
  {
    BLPrpDpersonPayFacade prpDpersonPayFacade = new BLPrpDpersonPayFacade();
    return prpDpersonPayFacade.findByConditions(conditions);
  }
}
