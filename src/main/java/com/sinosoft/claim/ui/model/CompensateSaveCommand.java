package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateSaveCommand extends BaseCommand
{
   private CompensateDto compensateDto=null;
  private WorkFlowDto workFlowDto=null;
  
  public CompensateSaveCommand(CompensateDto compensateDto)  throws Exception
  {
    this.compensateDto = compensateDto;
  }  
  public CompensateSaveCommand(CompensateDto compensateDto,WorkFlowDto workFlowDto)  throws Exception
  {
    this.compensateDto = compensateDto;
    this.workFlowDto = workFlowDto;
  } 
  public Object executeCommand() throws Exception
  {
    BLCompensateFacade blCompensateFacade = new BLCompensateFacade();
    blCompensateFacade.save(compensateDto,workFlowDto);  
    return null;  
  }

}
 