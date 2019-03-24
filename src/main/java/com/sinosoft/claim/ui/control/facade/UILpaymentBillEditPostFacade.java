package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.viewHelper.PaymentViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.ParamUtils;

public class UILpaymentBillEditPostFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "";
		PaymentViewHelper paymentViewHelper = new PaymentViewHelper();
		ActionMessages messages = new ActionMessages();
		try {
			paymentViewHelper.saveBillOrupdate(request);
			
			if (request.getParameter("submitType").trim()
					.equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.billpay.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.billpay.save"));
			}
			saveMessages(request, messages);
		} catch (RuntimeException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("title.payInfoSave");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage",e.getMessage()) ;
			saveErrors(request, errors);
			forward = "error";
		}
		forward = "success";
		return mapping.findForward(forward);
	}
	
	
}
