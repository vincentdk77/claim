package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;

public class UILpaymentCompensateBillFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		request.setAttribute("prevPageUrl",request.getParameter("prevPageUrl") );
		request.setAttribute("pageConditions", request.getParameter("pageConditions"));
		request.setAttribute("type", request.getParameter("type"));
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		paymentViewHelper.paymainBillEditPost(request);
		
		return mapping.findForward(forward);
	}

}
