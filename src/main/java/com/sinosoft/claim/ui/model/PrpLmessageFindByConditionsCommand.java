package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLMessageListFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLmessageFindByConditionsCommand extends BaseCommand{
  private String conditions;
  
  public PrpLmessageFindByConditionsCommand(String conditions) throws Exception {
    this.conditions = conditions;
  }

  public Object executeCommand() throws Exception
  {
    BLMessageListFacade bLMessageListFacade = new BLMessageListFacade();
    return bLMessageListFacade.findByConditions(conditions);
  }
  /**
   * (�������Ľӿ�ʹ�ã�������������Ϊ(yyyy-mm-dd hh24:mi:ss))
   * @return
   * @throws Exception
   */
  public Object executeCommand1() throws Exception
  {
    BLMessageListFacade bLMessageListFacade = new BLMessageListFacade();
    return bLMessageListFacade.findByConditions1(conditions);
  }
}
