package com.sinosoft.claim.ui.control.action;

import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLdeductCondFacade;

public class UILdeductCondAction {
	private static final UILdeductCondAction uiLdeductCondAction = new UILdeductCondAction();
	public static UILdeductCondAction getInstance(){
		return uiLdeductCondAction;
	}
	public Collection findByConditions(String conditions)throws Exception{
		return (Collection)BLPrpLdeductCondFacade.getInstance().findByConditions(conditions);
	}
}
