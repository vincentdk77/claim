package com.sinosoft.claim.ui.model;

import com.sinosoft.claim.bl.facade.BLReturnVisitFacade;
import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class ReturnVisitSaveCommand extends BaseCommand{
	
	private ReturnVisitDto returnVisitDto = null;

	public ReturnVisitSaveCommand(ReturnVisitDto returnVisitDto) throws Exception {
		this.returnVisitDto = returnVisitDto;
	}

	public Object executeCommand() throws Exception {
		BLReturnVisitFacade blReturnVisitFacade = new BLReturnVisitFacade();
		blReturnVisitFacade.save(returnVisitDto);
		return null;
	}

}
