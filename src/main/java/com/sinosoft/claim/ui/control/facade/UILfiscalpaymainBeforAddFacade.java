package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

public class UILfiscalpaymainBeforAddFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
//			paymentViewHelper.paymainEditPost(httpServletRequest);
//			String [] registNo = httpServletRequest.getParameterValues("chooseRegistNo");
			String paymentType = httpServletRequest.getParameter("paymentType");
			String payType = httpServletRequest.getParameter("payType");
			httpServletRequest.setAttribute("payType", payType);
			String payTypeName=(String) paymentViewHelper.getPayTypeMap().get(payType);
			httpServletRequest.setAttribute("payTypeName", payTypeName);
			httpServletRequest.setAttribute("paymentType", paymentType);
			String paymentTypeName = (String) paymentViewHelper.getPaymentTypeMap().get(paymentType);
			httpServletRequest.setAttribute("paymentTypeName", paymentTypeName);
			forward ="success";
		}catch(Exception e){
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.UILpaymainMergeBeforAddFacade");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
