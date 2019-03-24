package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLPrepayFacade;
import com.sinosoft.claim.dto.custom.PrepayDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrepaySaveCommand extends BaseCommand
{
   private PrepayDto prepayDto=null;
  private WorkFlowDto workFlowDto=null;
  public PrepaySaveCommand(PrepayDto prepayDto)  throws Exception
  {
    this.prepayDto = prepayDto;
  }   
  public PrepaySaveCommand(PrepayDto prepayDto,WorkFlowDto workFlowDto)  throws Exception
  {
    this.prepayDto = prepayDto;
    this.workFlowDto = workFlowDto;
  } 
  public Object executeCommand() throws Exception
  {
    BLPrepayFacade bLPrepayFacade = new BLPrepayFacade();
    bLPrepayFacade.save(prepayDto,workFlowDto); 
    return null;
  } 
}
