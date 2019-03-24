package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckDateBeforeClaimRecaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalClaimRecaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalRecaseInfoToPrpLinterRecaseHelper;
import com.sinosoft.claim.webservice.ReCaseRequestInfo;

public class UIMedicalClaimRecaseInterFaceFacade {

	 public String reCaseInfo (ReCaseRequestInfo reCaseRequestInfo){
		 UIMedicalCheckDateBeforeClaimRecaseViewHelper uiMedicalCheckViewHelper
		 		= new UIMedicalCheckDateBeforeClaimRecaseViewHelper();
		 UIMedicalRecaseInfoToPrpLinterRecaseHelper uiRecaseToPrpLinterRecaseHelper
		 		= new UIMedicalRecaseInfoToPrpLinterRecaseHelper();
		 String returnStr = "";
		 try {
			 
			 /**1 校验接口传入参数的合法性***/
			returnStr = uiMedicalCheckViewHelper.checkBeforeClaim(reCaseRequestInfo);
			if("".equals(returnStr)||returnStr.length()<1){
				/**2 收集参数，转化为中间表对象***/
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = uiRecaseToPrpLinterRecaseHelper.requestToPrpLinterRecase(reCaseRequestInfo);
				/**3 保存中间表对象***/
				new BLPrpLinterRecaseRequestFacade().insertAll(prpLinterRecaseRequestDto);
				/**4 调用自动理赔接口***/
				returnStr = new UIMedicalClaimRecaseViewHelper().autoRecaseClaimMain(prpLinterRecaseRequestDto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			returnStr = "0^交互失败，" + e.toString() ;
		}
		 return returnStr;
	 }
}
