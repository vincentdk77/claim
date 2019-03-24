package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;
import com.sinosoft.platform.bl.facade.BLPrpDcodeFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;

public class UILComplaintGetFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		String forward = "success";
		String nodeTypes = request.getParameter("nodeTypes");
		String editType = request.getParameter("editType");
		try {
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			UserDto user = (UserDto) request.getSession().getAttribute("user");
			
			if ("complaint".equals(nodeTypes)) {//complaint 新增投诉
				//回访问题条件 visitIssue
				daaReturnVisitViewHelper.getComplaintDto(request);
				PrplcomplaintDto prplcomplaintDto = new PrplcomplaintDto();
				prplcomplaintDto.setComplaintdate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND));
				prplcomplaintDto.setHandlername(user.getUserName());
				request.setAttribute("prplcomplaintDto", prplcomplaintDto);

			}
			//投诉处理
			if("dealWith".equals(nodeTypes) || "compl".equals(nodeTypes)){
				daaReturnVisitViewHelper.finddealWithList(request);
				
			}
			//投诉跟踪
			if("compl".equals(nodeTypes)){
				daaReturnVisitViewHelper.findComplList(request);
				request.setAttribute("nodeType", "compl");
			}
			request.setAttribute("user", user);
			request.setAttribute("nodeTypes", nodeTypes);
			request.setAttribute("editType", editType);
		} catch (Exception e) {
			// TODO: handle exception
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					
					"");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(request, errors);
			forward = "error";
		}
		return mapping.findForward(forward);
	}

}
