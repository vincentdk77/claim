package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class RegistSaveCommand extends BaseCommand
{
	private RegistDto registDto=null;
        private WorkFlowDto workFlowDto=null;

	public RegistSaveCommand(RegistDto registDto)  throws Exception
	{
            this.registDto = registDto;
 	}

	public RegistSaveCommand(RegistDto registDto,WorkFlowDto workFlowDto)  throws Exception
	{
            this.registDto = registDto;
            this.workFlowDto = workFlowDto;
  }

	public Object executeCommand() throws Exception
	{
	  BLRegistFacade bLRegistFacade = new BLRegistFacade();
    bLRegistFacade.save(registDto,workFlowDto);
    return null;
	}

}
