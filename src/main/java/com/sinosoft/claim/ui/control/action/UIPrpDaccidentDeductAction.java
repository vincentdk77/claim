package com.sinosoft.claim.ui.control.action;

import com.sinosoft.claim.bl.facade.BLPrpDaccidentDeductFacade;
import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;

/**
 * 事故责任免赔率对象
 * <p>Title: 事故责任免赔率action  </p>
 * <p>Description: 事故责任免赔率action</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sinosoft</p>
 * @author miaowenjun
 * @version 1.0
 */

public class UIPrpDaccidentDeductAction {
	/**
	 * 获得事故责任免赔率信息
	 * @return 事故责任免赔率
	 * @throws Exception
	 */
	public PrpDaccidentDeductDto findByPrimaryKey(String riskCode,String kindCode,String indemnityDuty,String dangerLevel,String deductPeriod)
    throws Exception{
		PrpDaccidentDeductDto prpDaccidentDeductDto = null;
		BLPrpDaccidentDeductFacade blPrpDaccidentDeductFacade = new BLPrpDaccidentDeductFacade();
		prpDaccidentDeductDto = blPrpDaccidentDeductFacade.findByPrimaryKey(riskCode,kindCode,indemnityDuty,dangerLevel,deductPeriod);
		return prpDaccidentDeductDto;
	}
	

	
	public double findAccidentDeductRate(String riskCode, String kindCode,
			String indemnityDuty, String dangerLevel, String validDate)
			throws Exception {
		return BLPrpDaccidentDeductFacade.getInstance().findAccidentDeductRate(
				riskCode, kindCode, indemnityDuty, dangerLevel, validDate);
	}
}
