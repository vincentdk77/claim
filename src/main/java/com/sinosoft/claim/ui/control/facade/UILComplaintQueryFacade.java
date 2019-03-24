package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;

public class UILComplaintQueryFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String editType = request.getParameter("editType");
		String forward = "";
		if("SHOW".equals(editType)){
			forward = "showPage";   
			request.setAttribute("nodeTypes", "dealWithTail");
		}
		if("SHOWLIST".equals(editType)){
			forward = "dealWith";
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			String conditions = daaReturnVisitViewHelper.showViewToList(request,"5");
			System.err.println(conditions);
			ArrayList<PrplcomplaintDto> prplcomplaintDtoList = daaReturnVisitViewHelper.showDealWithDtoList(request, conditions);
			UICodeAction uiCodeAction = new UICodeAction();
			for(PrplcomplaintDto prplcomplaintDto : prplcomplaintDtoList){
				
				prplcomplaintDto.setBycomplaintcomcodeName(uiCodeAction.translateComCode(prplcomplaintDto.getBycomplaintcomcode(), true));
			}
			request.setAttribute("prplcomplaintDtoList", prplcomplaintDtoList);
			request.setAttribute("editType", "ADD");
			request.setAttribute("nodeType", "compl");
		}
		if("ADD".equals(editType)){
			forward = "dealWithADD";
		}
		return mapping.findForward(forward);
	}

}
