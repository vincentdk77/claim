package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;


public class VerifyLossSaveCommand extends BaseCommand
{
  private VerifyLossDto verifyLossDto=null;
  private WorkFlowDto workFlowDto=null;
  
  public VerifyLossSaveCommand(VerifyLossDto verifyLossDto)  throws Exception
  {
   	 this.verifyLossDto = verifyLossDto;
    
  }
  
  public VerifyLossSaveCommand(VerifyLossDto verifyLossDto,WorkFlowDto workFlowDto)  throws Exception
  {
   	 this.verifyLossDto = verifyLossDto;
     this.workFlowDto = workFlowDto;
  }
  
  public Object executeCommand() throws Exception
  {
   	BLVerifyLossFacade bLVerifyLossFacade = new BLVerifyLossFacade();
    bLVerifyLossFacade.save(verifyLossDto,workFlowDto); 
    return null;

  }
}
