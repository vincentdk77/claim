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
	 * 大病即时即报自动支付入口
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
			System.err.println("==大病支付删除====调用开始");
			returnString = checkBefAutoPayBySeriousInViewHelper.checkBeforePayDelete(detelePayRequestInfo);
			PrpLinterPayDeleteRequestDto payDeleteRequestInfo = null;
			if("".equals(returnString)){
				payDeleteRequestInfo = autoPayBySeriousInInterPublicConvert.ConvertPayDeleteRequestByPayDelete(detelePayRequestInfo);
			}
			if("".equals(returnString)){
				/**1 校验接口传入参数的合法性***/
				returnString = checkBeforeAutoPayViewHelper.checkBeforePayDelete(payDeleteRequestInfo);
			}
			
			//如果入参合法进行接下来的步骤
			if("".equals(returnString)){
				/**2 逻辑处理-保存中间表***/
				new BLPrpLinterPayDeleteRequestFacade().insert(payDeleteRequestInfo);
				returnString = "1^交互成功";
				/**3逻辑处理-核心系统数据处理***/
				new BLPrpLinterPayDeleteRequestFacade().payDeleteByPro(payDeleteRequestInfo.getOutId());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^交互失败，" + e.toString() ;
		}
		System.err.println("==大病支付删除====returnStrin="+returnString);
		return returnString;
	}
}
