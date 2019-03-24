package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPayRequestToPrpLinterHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPayViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoPayViewHelper;
import com.sinosoft.claim.webservice.PayRequestInfo;

public class UIMedicalAutoPayInterFaceFacade {
	/**
	 * 自动支付入口
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String savePayInfo(PayRequestInfo payRequestInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoPayRequestToPrpLinterHelper payRequestToPrpLinterHelper = new UIMedicalAutoPayRequestToPrpLinterHelper();
		UIMedicalCheckBeforeAutoPayViewHelper checkBeforeAutoPayViewHelper = new UIMedicalCheckBeforeAutoPayViewHelper();
		try {
			/**1 校验接口传入参数的合法性***/
			System.err.println("==24====调用开始");
			returnString = checkBeforeAutoPayViewHelper.checkBeforePay(payRequestInfo);
			//如果入参合法进行接下来的步骤
			if("".equals(returnString)){
				/**2 收集参数，转化为中间表对象***/
				PrpLinterPayRequestDto prpLinterPayRequestDto = payRequestToPrpLinterHelper.payRequestToPrpLinter(payRequestInfo);
				/**3 保存中间表对象***/
				new BLPrpLinterPayRequestFacade().insertAll(prpLinterPayRequestDto);
				returnString = "1^交互成功";
				/**4 调用自动支付接口***/
				//returnString = new UIMedicalAutoPayViewHelper().autoPayMain(prpLinterPayRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^交互失败，" + e.toString() ;
		}
		System.err.println("==41====returnStrin="+returnString);
		return returnString;
	}
}
