package com.sinosoft.claim.ui.control.action;

import com.sinosoft.claim.bl.facade.BLPrpDaccidentDeductFacade;
import com.sinosoft.claim.dto.domain.PrpDaccidentDeductDto;

/**
 * �¹����������ʶ���
 * <p>Title: �¹�����������action  </p>
 * <p>Description: �¹�����������action</p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Sinosoft</p>
 * @author miaowenjun
 * @version 1.0
 */

public class UIPrpDaccidentDeductAction {
	/**
	 * ����¹�������������Ϣ
	 * @return �¹�����������
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
