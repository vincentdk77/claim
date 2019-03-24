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
	 * 大病即时即报自动支付入口
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
			//将大病即时即报接口的入参转为支付接口入参，后续环节公用
			returnString = checkBefAutoPayBySeriousInViewHelper.checkBeforePay(payRequestBySeriousInInfo);
			PayRequestInfo payRequestInfo = null;
			String seriousInterType = "";
			if("".equals(returnString)){
				payRequestInfo = autoPayBySeriousInInterPublicConvert.ConvertPayRequestBySeriousIn(payRequestBySeriousInInfo);
				//接口类型
				seriousInterType = payRequestBySeriousInInfo.getSeriousInterType();
				//判断接口类型是否为空
				if(null == seriousInterType || "".equals(seriousInterType)){
					returnString = "0^接口类型不能为空";
				}
			}
			if("".equals(returnString)){
				/**1 校验接口传入参数的合法性***/
				returnString = checkBeforeAutoPayViewHelper.checkBeforePay(payRequestInfo);
			}
			
			//如果入参合法进行接下来的步骤
			if("".equals(returnString)){
				/**2 收集参数，转化为中间表对象***/
				PrpLinterPayRequestDto prpLinterPayRequestDto = payRequestToPrpLinterHelper.payRequestToPrpLinter(payRequestInfo);
				/**将接口类型存储到中间表对象 1大病即时即报接口***/
				prpLinterPayRequestDto.setSeriousInterType(seriousInterType);
				
				/**3 保存中间表对象***/
				new BLPrpLinterPayRequestFacade().insertAll(prpLinterPayRequestDto);
				returnString = "保存成功";
				/**4 调用自动支付接口***/
				returnString = new UIMedicalAutoPayViewHelper().autoPayMain(prpLinterPayRequestDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "0^交互失败，" + e.toString() ;
		}
		return returnString;
	}
}
