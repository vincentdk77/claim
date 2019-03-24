package com.sinosoft.claim.ui.model;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLCodeFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpDcurrencyFindByConditionsCommand extends BaseCommand {

  public PrpDcurrencyFindByConditionsCommand()  throws Exception
  {
  }
  public Object executeCommand() throws Exception
  {
      BLCodeFacade blCodeFacade = new BLCodeFacade();
      return (Collection)blCodeFacade.getCurrencyList();
  }
}

