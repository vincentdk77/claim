package com.sinosoft.claim.ui.control.action;

import java.util.List;

import com.sinosoft.claim.bl.facade.BLPrpDpersonFeeCodeRiskFacade;

public class UIPersonFeeAction {
	private static final UIPersonFeeAction uiPersonFeeAction= new UIPersonFeeAction();
	private UIPersonFeeAction(){
		//禁止实例化
	}
	public static UIPersonFeeAction getInstance(){
		return uiPersonFeeAction;
	}
	
    /**
     * 获得指定险种的所有费用类别
     * @param riskCode
     * @return
     * @throws Exception
     */
    public List findAllCodeList(String riskCode) throws Exception{
    	return new BLPrpDpersonFeeCodeRiskFacade().findAllCodeList(riskCode);
    }
}
