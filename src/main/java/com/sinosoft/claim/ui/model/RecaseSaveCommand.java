package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLReCaseFacade;
import com.sinosoft.claim.dto.custom.ReCaseDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class RecaseSaveCommand extends BaseCommand
{
	private ReCaseDto recaseDto=null;
        private WorkFlowDto workFlowDto=null;

	public RecaseSaveCommand(ReCaseDto recaseDto)  throws Exception
	{
            this.recaseDto = recaseDto;
 	}

	public RecaseSaveCommand(ReCaseDto recaseDto,WorkFlowDto workFlowDto)  throws Exception
	{
            this.recaseDto = recaseDto;
            this.workFlowDto = workFlowDto;
  }

	public Object executeCommand() throws Exception
	{
	  BLReCaseFacade bLReCaseFacade = new BLReCaseFacade();
    bLReCaseFacade.save(recaseDto,workFlowDto);
    return null;
	}

}
