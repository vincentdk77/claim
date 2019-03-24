package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoRegistClaimToPrpLinterHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoClaimViewHelper;
import com.sinosoft.claim.webservice.ClaimRequestInfo;

public class UIMedicalAutoClaimInterFaceFacade {
	
	/**
	 * 自动理赔Webservice入口
	 * @param claimdRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String saveClaimInfo(ClaimRequestInfo claimRequestInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoRegistClaimToPrpLinterHelper claimToPrpLinterHelper = new UIMedicalAutoRegistClaimToPrpLinterHelper();
		UIMedicalCheckBeforeAutoClaimViewHelper checkBeforeAutoClaimViewHelper = new UIMedicalCheckBeforeAutoClaimViewHelper();
		try {
			/**1 校验接口传入参数的合法性***/
			returnString = checkBeforeAutoClaimViewHelper.checkBeforeClaim(claimRequestInfo);
			//如果入参合法进行接下来的步骤
			if("".equals(returnString)){
				/**2 收集参数，转化为中间表对象***/
				PrpLinterRequestDto prpLinterRequestDto = claimToPrpLinterHelper.claimToPrpLinter(claimRequestInfo);
				/**3 保存中间表对象***/
				new BLPrpLinterRequestFacade().insertAll(prpLinterRequestDto);
				/**4 调用自动理赔接口***/
				returnString = new UIMedicalAutoClaimViewHelper().autoClaimMain(prpLinterRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^交互失败，" + e.toString() ;
		}
		return returnString;
	}
	
}
