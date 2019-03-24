package com.sinosoft.claim.query.ui.control.facade;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.query.ui.control.viewHelper.CaseNoQueryViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;



public class UICaseNoQueryFacadeRead extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String forward ="";
		String comcode ="";
		try {
			HttpSession session = httpServletRequest.getSession();
			UserDto user = (UserDto) session.getAttribute("user");
			comcode = user.getComCode();
			try {
				
				TurnPageDto turnPageDto = new TurnPageDto();
				CaseNoQueryViewHelper caseNoQueryViewHelper =  new CaseNoQueryViewHelper();
				turnPageDto = caseNoQueryViewHelper.getCaseNoList(httpServletRequest,comcode);
				
				httpServletRequest.setAttribute("turnPageDto", turnPageDto);	
				forward = "success";
			} catch (Exception e) {
				forward = "error";
			}
		} catch (Exception e) {
			forward="userError";
			httpServletRequest.setAttribute("EXCEPTION", new UserException(-98,-1010,"µÇÂ½³¬Ê±","´íÎóÐÅÏ¢"));
		}
		
		
		return actionMapping.findForward(forward);
	}
}
