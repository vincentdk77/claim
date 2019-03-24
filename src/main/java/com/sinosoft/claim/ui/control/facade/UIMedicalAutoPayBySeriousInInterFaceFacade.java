package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMediCheckBefAutoPayBySeriousInViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPayViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoPayViewHelper;
import com.sinosoft.claim.webservice.PayRequestBySeriousInInfo;
import com.sinosoft.claim.webservice.PayRequestInfo;

public class UIMedicalAutoPayBySeriousInInterFaceFacade {
	/**
	 * �󲡼�ʱ�����Զ�֧�����
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String savePayInfoBySeriousIn(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoPayBySerousInToPrpLinterHelper payRequestToPrpLinterHelper = new UIMedicalAutoPayBySerousInToPrpLinterHelper();
		UIMedicalCheckBeforeAutoPayViewHelper checkBeforeAutoPayViewHelper = new UIMedicalCheckBeforeAutoPayViewHelper();
		UIMediCheckBefAutoPayBySeriousInViewHelper checkBefAutoPayBySeriousInViewHelper = new UIMediCheckBefAutoPayBySeriousInViewHelper();
		UIMedicalAutoPayBySeriousInInterPublicFacade autoPayBySeriousInInterPublicConvert = new UIMedicalAutoPayBySeriousInInterPublicFacade();
		try {
			//���󲡼�ʱ�����ӿڵ����תΪ֧���ӿ���Σ��������ڹ���
			returnString = checkBefAutoPayBySeriousInViewHelper.checkBeforePay(payRequestBySeriousInInfo);
			PayRequestInfo payRequestInfo = null;
			String seriousInterType = "";
			if("".equals(returnString)){
				payRequestInfo = autoPayBySeriousInInterPublicConvert.ConvertPayRequestBySeriousIn(payRequestBySeriousInInfo);
				//�ӿ�����
				seriousInterType = payRequestBySeriousInInfo.getSeriousInterType();
				//�жϽӿ������Ƿ�Ϊ��
				if(null == seriousInterType || "".equals(seriousInterType)){
					returnString = "0^�ӿ����Ͳ���Ϊ��";
				}
			}
			if("".equals(returnString)){
				/**1 У��ӿڴ�������ĺϷ���***/
				returnString = checkBeforeAutoPayViewHelper.checkBeforePay(payRequestInfo);
			}
			
			//�����κϷ����н������Ĳ���
			if("".equals(returnString)){
				/**2 �ռ�������ת��Ϊ�м�����***/
				PrpLinterPayRequestDto prpLinterPayRequestDto = payRequestToPrpLinterHelper.payRequestToPrpLinter(payRequestInfo);
				/**���ӿ����ʹ洢���м����� 1�󲡼�ʱ�����ӿ�***/
				prpLinterPayRequestDto.setSeriousInterType(seriousInterType);
				
				/**3 �����м�����***/
				new BLPrpLinterPayRequestFacade().insertAll(prpLinterPayRequestDto);
				returnString = "����ɹ�";
				/**4 �����Զ�֧���ӿ�***/
				returnString = new UIMedicalAutoPayViewHelper().autoPayMain(prpLinterPayRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^����ʧ�ܣ�" + e.toString() ;
		}
		return returnString;
	}
}
