package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLEndorFacade;
import com.sinosoft.claim.dto.custom.EndorDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class EndorSaveCommand extends BaseCommand
{
  private EndorDto endorDto = null;

  public EndorSaveCommand(EndorDto endorDto)  throws Exception
	{
	   this.endorDto = endorDto;
	}
	public Object executeCommand() throws Exception
	{
    BLEndorFacade blEndorFacade = new BLEndorFacade();
    blEndorFacade.save(endorDto);
    return null;
	}
}
