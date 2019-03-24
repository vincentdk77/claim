package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.domain.PrpLIndemnityReceiptDto;
import com.sinosoft.claim.ui.control.action.UIIndemnityReceiptAction;

public class UIIndemnityReceiptEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward="success";
		PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = getDtoFromView(httpServletRequest);
		try {
			UIIndemnityReceiptAction uiIndemnityReceiptAction = new UIIndemnityReceiptAction();
			uiIndemnityReceiptAction.updatePrpLIndemnityReceiptDto(prpLIndemnityReceiptDto);
			ActionMessages messages = new ActionMessages();
			messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.indemnityReceiptSave.success"));
			saveMessages( httpServletRequest, messages );
		} catch (Exception e) {
			e.printStackTrace();
			ActionMessages messages = new ActionMessages();
			ActionMessage message = new ActionMessage("prompt.indemnityReceiptSave.false");
			messages.add(ActionMessages.GLOBAL_MESSAGE, message);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveMessages(httpServletRequest, messages);
			forward = "error";
		} 
		return actionMapping.findForward(forward);
	}
	private PrpLIndemnityReceiptDto getDtoFromView(HttpServletRequest request){
		PrpLIndemnityReceiptDto prpLIndemnityReceiptDto = new PrpLIndemnityReceiptDto();
		prpLIndemnityReceiptDto.setBusinessNo(request.getParameter("prpLIndemnityReceiptBusinessNo"));
		prpLIndemnityReceiptDto.setPolicyNo(request.getParameter("prpLIndemnityReceiptPolicyNo"));
		prpLIndemnityReceiptDto.setInsuredCode(request.getParameter("prpLIndemnityReceiptInsuredCode"));
		prpLIndemnityReceiptDto.setInsuredName(request.getParameter("prpLIndemnityReceiptInsuredName"));
		prpLIndemnityReceiptDto.setUnitBank(request.getParameter("prpLIndemnityReceiptUnitBank"));
		prpLIndemnityReceiptDto.setUnitAccount(request.getParameter("prpLIndemnityReceiptUnitAccount"));
		prpLIndemnityReceiptDto.setAccount(request.getParameter("prpLIndemnityReceiptAccount"));
		prpLIndemnityReceiptDto.setIdentifyNumber(request.getParameter("prpLIndemnityReceiptIdentifyNumber"));
		prpLIndemnityReceiptDto.setCertiType(request.getParameter("prpLIndemnityReceiptCertiType"));
		return prpLIndemnityReceiptDto;
	}
}
