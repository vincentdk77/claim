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
			 
			 /**1 У��ӿڴ�������ĺϷ���***/
			returnStr = uiMedicalCheckViewHelper.checkBeforeClaim(reCaseRequestInfo);
			if("".equals(returnStr)||returnStr.length()<1){
				/**2 �ռ�������ת��Ϊ�м�����***/
				PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = uiRecaseToPrpLinterRecaseHelper.requestToPrpLinterRecase(reCaseRequestInfo);
				/**3 �����м�����***/
				new BLPrpLinterRecaseRequestFacade().insertAll(prpLinterRecaseRequestDto);
				/**4 �����Զ�����ӿ�***/
				returnStr = new UIMedicalClaimRecaseViewHelper().autoRecaseClaimMain(prpLinterRecaseRequestDto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			returnStr = "0^����ʧ�ܣ�" + e.toString() ;
		}
		 return returnStr;
	 }
}
