package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLReCaseFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLrecaseSaveCommand extends BaseCommand
{
	private ReCaseDto recaseDto=null;

	public PrpLrecaseSaveCommand(ReCaseDto recaseDto)  throws Exception
	{
            this.recaseDto = recaseDto;
 	}


	public Object executeCommand() throws Exception
	{
	  BLReCaseFacade bLReCaseFacade = new BLReCaseFacade();
    bLReCaseFacade.savePrpLrecase(recaseDto);
    return null;
	}

}