package com.sinosoft.claim.ui.model;

import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLinjuryPersonFacade;
import com.sinosoft.sysframework.web.model.BaseCommand;

public class PrpLinjuryPersonCommand extends BaseCommand{
	private String compeNo;
	public PrpLinjuryPersonCommand(String compeNo) throws Exception {
		this.compeNo = compeNo;
	}

	@Override
	public Object executeCommand() throws Exception {
		BLPrpLinjuryPersonFacade injuryPerson = new BLPrpLinjuryPersonFacade();
		return injuryPerson.findByPrimaryKey(compeNo);
	}
	
	public Collection executeCommandByConditions()throws Exception{
		BLPrpLinjuryPersonFacade injuryPerson = new BLPrpLinjuryPersonFacade();
		return injuryPerson.findByCondition(compeNo);
	}
	
}
