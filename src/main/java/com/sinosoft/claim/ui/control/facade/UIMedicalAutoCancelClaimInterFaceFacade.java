package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoCancelClaimRequestToPrpLinterHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoCancelClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoCancelViewHelper;
import com.sinosoft.claim.webservice.RegistCancelRequestInfo;

public class UIMedicalAutoCancelClaimInterFaceFacade {
	/**
	 * 自动注销入口
	 * @param cancelClaimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String saveCancelInfo(RegistCancelRequestInfo registCancelRequestInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoCancelClaimRequestToPrpLinterHelper cancelClaimRequestToPrpLinterHelper = new UIMedicalAutoCancelClaimRequestToPrpLinterHelper();
		UIMedicalCheckBeforeAutoCancelViewHelper checkBeforeAutoCancelViewHelper = new UIMedicalCheckBeforeAutoCancelViewHelper();
		try {
			/**1 校验接口传入参数的合法性***/
			returnString = checkBeforeAutoCancelViewHelper.checkBeforeCancel(registCancelRequestInfo);
			//如果入参合法进行接下来的步骤
			if("".equals(returnString)){
				/**2 收集参数，转化为中间表对象***/
				PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = cancelClaimRequestToPrpLinterHelper.cancelClaimRequestToPrpLinter(registCancelRequestInfo);
				/**3 保存中间表对象***/
				new BLPrpLinterCancelClaimRequestFacade().insertAll(prpLinterCancelClaimRequestDto);
				returnString = "保存成功";
				/**4 调用自动注销接口***/
				returnString = new UIMedicalAutoCancelClaimViewHelper().autoCancelMain(prpLinterCancelClaimRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^交互失败，" + e.toString() ;
		}
		return returnString;
	}
}
