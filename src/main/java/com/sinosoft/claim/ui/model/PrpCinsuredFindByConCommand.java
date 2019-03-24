package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrpCinsuredFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpCinsuredFindByConCommand extends BaseCommand
{       private String conditions;

  public PrpCinsuredFindByConCommand(String conditions)  throws Exception
  {

        this.conditions= conditions;
		  
  }
  public Object executeCommand() throws Exception
  {
  	BLPrpCinsuredFacade bLPrpCinsuredFacade = new BLPrpCinsuredFacade();
    return bLPrpCinsuredFacade.findByConditions(conditions);
  }

}
