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

public class UILpaymainEditFromUndwrtFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		try{
			PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
			paymentViewHelper.paymainPostEditFromUndwrt(httpServletRequest);
			forward ="success";
		}catch(Exception e){
			e.printStackTrace();
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.UILpaymainMergeBeforEditFacade");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
