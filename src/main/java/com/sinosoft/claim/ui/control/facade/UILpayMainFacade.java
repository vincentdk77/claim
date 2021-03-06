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
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UILpayMainFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = "";
		String submitType = httpServletRequest.getParameter("submitType");
		String registNo = httpServletRequest.getParameter("registNo");
		try{
			PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
			String paymentNo = paymentViewHelper.saveOrupdate(httpServletRequest);
			//String paymentNo = paymentViewHelper.savePayMain(httpServletRequest);
			
			//paymentViewHelper.savePays(httpServletRequest, paymentNo, "");	
			//paymentViewHelper.savePrplRegistExt(httpServletRequest,paymentNo, "");
			httpServletResponse.getWriter().write("true##"+paymentNo);
			forward="success";
		}catch(Exception e){
			e.printStackTrace();
			httpServletResponse.getWriter().write(e.getMessage());
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.payInfoSave");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return null;
	}
}
