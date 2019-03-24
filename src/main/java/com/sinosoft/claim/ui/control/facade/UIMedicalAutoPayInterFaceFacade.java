package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPayRequestToPrpLinterHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPayViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoPayViewHelper;
import com.sinosoft.claim.webservice.PayRequestInfo;

public class UIMedicalAutoPayInterFaceFacade {
	/**
	 * �Զ�֧�����
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String savePayInfo(PayRequestInfo payRequestInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoPayRequestToPrpLinterHelper payRequestToPrpLinterHelper = new UIMedicalAutoPayRequestToPrpLinterHelper();
		UIMedicalCheckBeforeAutoPayViewHelper checkBeforeAutoPayViewHelper = new UIMedicalCheckBeforeAutoPayViewHelper();
		try {
			/**1 У��ӿڴ�������ĺϷ���***/
			System.err.println("==24====���ÿ�ʼ");
			returnString = checkBeforeAutoPayViewHelper.checkBeforePay(payRequestInfo);
			//�����κϷ����н������Ĳ���
			if("".equals(returnString)){
				/**2 �ռ�������ת��Ϊ�м�����***/
				PrpLinterPayRequestDto prpLinterPayRequestDto = payRequestToPrpLinterHelper.payRequestToPrpLinter(payRequestInfo);
				/**3 �����м�����***/
				new BLPrpLinterPayRequestFacade().insertAll(prpLinterPayRequestDto);
				returnString = "1^�����ɹ�";
				/**4 �����Զ�֧���ӿ�***/
				//returnString = new UIMedicalAutoPayViewHelper().autoPayMain(prpLinterPayRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^����ʧ�ܣ�" + e.toString() ;
		}
		System.err.println("==41====returnStrin="+returnString);
		return returnString;
	}
}
