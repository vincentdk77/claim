package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalAutoRegistClaimToPrpLinterHelper;
import com.sinosoft.claim.ui.control.viewHelper.UIMedicalCheckBeforeAutoClaimViewHelper;
import com.sinosoft.claim.webservice.ClaimRequestInfo;
import com.sinosoft.sysframework.common.datatype.DateTime;

public class UIMedicalAutoCompeInterFaceFacade {
	
	/**
	 * �Զ�����Webservice���
	 * @param claimdRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String saveClaimInfo(ClaimRequestInfo claimRequestInfo) throws Exception {
		
		String returnString = "";
		UIMedicalAutoRegistClaimToPrpLinterHelper claimToPrpLinterHelper = new UIMedicalAutoRegistClaimToPrpLinterHelper();
		UIMedicalCheckBeforeAutoClaimViewHelper checkBeforeAutoClaimViewHelper = new UIMedicalCheckBeforeAutoClaimViewHelper();
		try {
			/**1 У��ӿڴ�������ĺϷ���***/
			System.err.println("outregistno==="+claimRequestInfo.getOutRigstNo()+"====CompeTime========="+new DateTime(claimRequestInfo.getCompeTime(),DateTime.YEAR_TO_SECOND));
			returnString = checkBeforeAutoClaimViewHelper.checkBeforeCompe(claimRequestInfo);
			//�����κϷ����н������Ĳ���
			if("".equals(returnString)){
				/**2 �ռ�������ת��Ϊ�м�����***/
				PrpLinterRequestDto prpLinterRequestDto = claimToPrpLinterHelper.compeToPrpLinter(claimRequestInfo);
				/**3 �����м�����***/
				new BLPrpLinterRequestFacade().insertCompeAll(prpLinterRequestDto);
				/**4 �����Զ�����ӿ�***/
				returnString = new UIMedicalAutoClaimViewHelper().autoClaimMain(prpLinterRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^����ʧ�ܣ�" + e.toString() ;
		}
		return returnString;
	}
	
}
