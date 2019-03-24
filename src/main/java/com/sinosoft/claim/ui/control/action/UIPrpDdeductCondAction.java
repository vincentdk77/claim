package com.sinosoft.claim.ui.control.action;

import java.util.ArrayList;

import com.sinosoft.claim.bl.facade.BLPrpDdeductCondFacade;

/**
 * �鿱����Check
 * <p>Title: �������������鿱action  </p>
 * <p>Description: �������������鿱action</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIPrpDdeductCondAction {

	private static UIPrpDdeductCondAction uiPrpDdeductCondAction = new UIPrpDdeductCondAction();

	public static UIPrpDdeductCondAction getInstance() {
		return uiPrpDdeductCondAction;
	}

	public double findDeductibleRateOfAbsolute( String clauseType, String kindCode, ArrayList deductConditionList, 
			String riskCode, String validDate)
			throws Exception {
		return BLPrpDdeductCondFacade.getInstance().findDeductibleRateOfAbsolute(
				clauseType, kindCode, deductConditionList, riskCode, validDate);
	}
}
