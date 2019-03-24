package com.sinosoft.claim.ui.control.action;

import java.util.Collection;

import com.sinosoft.claim.ui.model.PrpLinjuryPersonCommand;

public class UIPrpLinjuryPersonInfoAction {
	public Collection findByClaimNo(String compeNo)throws Exception{
		PrpLinjuryPersonCommand injuryPersonCommand = new PrpLinjuryPersonCommand(compeNo);
		return injuryPersonCommand.executeCommandByConditions();
	}
}
