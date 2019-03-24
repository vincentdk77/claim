package com.sinosoft.claim.ui.model;

import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFittingsFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ClaimFittingsSaveCommand extends BaseCommand
{
   private Collection fittingsList;
    
  public ClaimFittingsSaveCommand(Collection fittingsList)  throws Exception
  {
    this.fittingsList = fittingsList;
  }  
  public Object executeCommand() throws Exception
  {
    BLPrpLclaimFittingsFacade blPrpLclaimFittingsFacade = new BLPrpLclaimFittingsFacade();
    blPrpLclaimFittingsFacade.save(fittingsList);  
    return null;  
  }

}
 