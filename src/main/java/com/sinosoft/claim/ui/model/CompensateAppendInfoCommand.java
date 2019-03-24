package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLCompensateFacade;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class CompensateAppendInfoCommand extends BaseCommand
{
  private CompensateDto compensateDto;

  public CompensateAppendInfoCommand(CompensateDto compensateDto)  throws Exception
  {
    this.compensateDto = compensateDto;
  }
  public Object executeCommand() throws Exception
  {
    BLCompensateFacade bLCompensateFacade = new BLCompensateFacade();
    return bLCompensateFacade.findByAppendInformation(compensateDto);
  }

}
