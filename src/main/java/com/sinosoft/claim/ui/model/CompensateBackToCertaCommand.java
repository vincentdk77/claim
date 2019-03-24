package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateBackToCertaCommand extends BaseCommand
{
  private String claimNo="";
  private WorkFlowDto workFlowDto=null;
  private PrpLverifyLossDto prpLverifyLossDto=null;
  public CompensateBackToCertaCommand(String claimNo,WorkFlowDto workFlowDto,PrpLverifyLossDto prpLverifyLossDto)  throws Exception
  {
    this.claimNo= claimNo;
    
    this.workFlowDto = workFlowDto;
    this.prpLverifyLossDto=prpLverifyLossDto;
  } 
  public Object executeCommand() throws Exception
  {
    BLCompensateFacade blCompensateFacade = new BLCompensateFacade();
    blCompensateFacade.backToCerta(claimNo,workFlowDto,prpLverifyLossDto);  
    return null;  
  }

}
 