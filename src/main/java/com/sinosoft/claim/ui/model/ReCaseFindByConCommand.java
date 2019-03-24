package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLReCaseFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ReCaseFindByConCommand extends BaseCommand
{       private String conditions;

  public ReCaseFindByConCommand(String conditions)  throws Exception
  {

        this.conditions= conditions;
		  
  }
  public Object executeCommand() throws Exception
  {
    BLReCaseFacade bLReCaseFacade = new BLReCaseFacade();
    return bLReCaseFacade.findByConditions(conditions);
  }

}
