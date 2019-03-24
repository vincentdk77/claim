package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterCancelClaimRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoCancelClaimRequestToPrpLinterHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoCancelClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoCancelViewHelper;
import com.sinosoft.claim.webservice.RegistCancelRequestInfo;

public class UIMedicalAutoCancelClaimInterFaceFacade {
	/**
	 * �Զ�ע�����
	 * @param cancelClaimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String saveCancelInfo(RegistCancelRequestInfo registCancelRequestInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoCancelClaimRequestToPrpLinterHelper cancelClaimRequestToPrpLinterHelper = new UIMedicalAutoCancelClaimRequestToPrpLinterHelper();
		UIMedicalCheckBeforeAutoCancelViewHelper checkBeforeAutoCancelViewHelper = new UIMedicalCheckBeforeAutoCancelViewHelper();
		try {
			/**1 У��ӿڴ�������ĺϷ���***/
			returnString = checkBeforeAutoCancelViewHelper.checkBeforeCancel(registCancelRequestInfo);
			//�����κϷ����н������Ĳ���
			if("".equals(returnString)){
				/**2 �ռ�������ת��Ϊ�м�����***/
				PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = cancelClaimRequestToPrpLinterHelper.cancelClaimRequestToPrpLinter(registCancelRequestInfo);
				/**3 �����м�����***/
				new BLPrpLinterCancelClaimRequestFacade().insertAll(prpLinterCancelClaimRequestDto);
				returnString = "����ɹ�";
				/**4 �����Զ�ע���ӿ�***/
				returnString = new UIMedicalAutoCancelClaimViewHelper().autoCancelMain(prpLinterCancelClaimRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^����ʧ�ܣ�" + e.toString() ;
		}
		return returnString;
	}
}
