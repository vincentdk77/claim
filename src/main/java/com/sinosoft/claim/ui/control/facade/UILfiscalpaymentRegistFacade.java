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
import com.sinosoft.claim.ui.control.viewHelper.PaymentFiscalViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

public class UILfiscalpaymentRegistFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest httpServletRequest, HttpServletResponse response)
			throws Exception {
		String forward = "";
		try{
			PaymentFiscalViewHelper paymentFiscalViewHelper = new PaymentFiscalViewHelper();
			String payType = httpServletRequest.getParameter("payType");
			String paymentType = httpServletRequest.getParameter("paymentType");
			paymentFiscalViewHelper.paymainFiscalRegistBefore(httpServletRequest);
			String prevPageUrl = httpServletRequest.getParameter("prevPageUrl");
			httpServletRequest.setAttribute("prevPageUrl", prevPageUrl);
			httpServletRequest.setAttribute("payTypeMain", payType);
			httpServletRequest.setAttribute("paymentType", paymentType);			 
			forward = "success";
		}catch(Exception e){
			e.printStackTrace();
		}
		return mapping.findForward(forward);
	}

}
