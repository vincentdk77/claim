package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLpayShowFacade;
import com.sinosoft.claim.dto.domain.PrpLpayShowDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

public class UILpaymainMergeAddQueryFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
			ArrayList<PrpLpayShowDto> prpLpayShowDtoList = new ArrayList<PrpLpayShowDto>();
			BLPrpLpayShowFacade blPrpLpayShowFacade = new BLPrpLpayShowFacade();
			String[] payType = httpServletRequest.getParameterValues("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			if("undefined".equals(paymentType)){
				paymentType = "";
			}
			if("undefined".equals(payType)){
				payType = null;
			}
			String conditions = "";
			paymentViewHelper.paymainNewAddBefore(httpServletRequest);
			httpServletRequest.setAttribute("payType", payType);
			//String payTypeName=(String) paymentViewHelper.getPayTypeMap().get(payType);
			httpServletRequest.setAttribute("paymentType", paymentType);
			httpServletRequest.setAttribute("paymentTypeMap",paymentViewHelper.getPaymentTypeMap() );
			//String paymentTypeName = (String) paymentViewHelper.getPaymentTypeMap().get(paymentType);
			//httpServletRequest.setAttribute("paymentTypeName", paymentTypeName);
			forward = "success";
			//blPrpLpayShowFacade.getNewQueryShowList(payType, paymentType, conditions);
		}catch(Exception e){
			e.printStackTrace();
		}
		return actionMapping.findForward(forward);
	}
}
