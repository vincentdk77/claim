package com.sinosoft.claim.ui.control.facade;

import java.text.SimpleDateFormat;

import com.sinosoft.claim.bl.facade.BLPrpLinterPayDeleteRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMediCheckBefAutoPayBySeriousInViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoPayViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoPayViewHelper;
import com.sinosoft.claim.webservice.DetelePayRequestInfo;
import com.sinosoft.claim.webservice.PayRequestInfo;

public class UIMedicalAutoPayDeleteInterFaceFacade {
	/**
	 * �󲡼�ʱ�����Զ�֧�����
	 * @param payRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String deletePayInfo(DetelePayRequestInfo detelePayRequestInfo) {
		
		String returnString = "";
		UIMediCheckBefAutoPayBySeriousInViewHelper checkBefAutoPayBySeriousInViewHelper = new UIMediCheckBefAutoPayBySeriousInViewHelper();
		UIMedicalAutoPayBySeriousInInterPublicFacade autoPayBySeriousInInterPublicConvert = new UIMedicalAutoPayBySeriousInInterPublicFacade();
		UIMedicalCheckBeforeAutoPayViewHelper checkBeforeAutoPayViewHelper = new UIMedicalCheckBeforeAutoPayViewHelper();
		try {
			System.err.println("==��֧��ɾ��====���ÿ�ʼ");
			returnString = checkBefAutoPayBySeriousInViewHelper.checkBeforePayDelete(detelePayRequestInfo);
			PrpLinterPayDeleteRequestDto payDeleteRequestInfo = null;
			if("".equals(returnString)){
				payDeleteRequestInfo = autoPayBySeriousInInterPublicConvert.ConvertPayDeleteRequestByPayDelete(detelePayRequestInfo);
			}
			if("".equals(returnString)){
				/**1 У��ӿڴ�������ĺϷ���***/
				returnString = checkBeforeAutoPayViewHelper.checkBeforePayDelete(payDeleteRequestInfo);
			}
			
			//�����κϷ����н������Ĳ���
			if("".equals(returnString)){
				/**2 �߼�����-�����м��***/
				new BLPrpLinterPayDeleteRequestFacade().insert(payDeleteRequestInfo);
				returnString = "1^�����ɹ�";
				/**3�߼�����-����ϵͳ���ݴ���***/
				new BLPrpLinterPayDeleteRequestFacade().payDeleteByPro(payDeleteRequestInfo.getOutId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^����ʧ�ܣ�" + e.toString() ;
		}
		System.err.println("==��֧��ɾ��====returnStrin="+returnString);
		return returnString;
	}
}
