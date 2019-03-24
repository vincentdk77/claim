package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndcaseFacade;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndcaseSaveCommand extends BaseCommand
{

   private EndcaseDto endcaseDto=null;
  private WorkFlowDto workFlowDto=null;

  public EndcaseSaveCommand(EndcaseDto endcaseDto)  throws Exception
  {
    this.endcaseDto = endcaseDto;
  }
  public EndcaseSaveCommand(EndcaseDto endcaseDto,WorkFlowDto workFlowDto)  throws Exception
  {
    this.endcaseDto = endcaseDto;
    this.workFlowDto = workFlowDto;
  }
  public Object executeCommand() throws Exception
  {
    BLEndcaseFacade blEndcaseFacade = new BLEndcaseFacade();
    blEndcaseFacade.save(endcaseDto,workFlowDto);
    return null;
  }

}
