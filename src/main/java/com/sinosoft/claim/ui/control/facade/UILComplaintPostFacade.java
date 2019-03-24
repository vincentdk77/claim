package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.ReturnVisitDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrplcomplaintDto;
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.ui.control.action.UIReturnVisitAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;

public class UILComplaintPostFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		String nodeTypes = request.getParameter("nodeTypes");
		UserDto user	= (UserDto)request.getSession().getAttribute("user");
		ReturnVisitDto returnVisitDto = new ReturnVisitDto();
		try {
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			PrplcomplaintDto prplcomplaintDto = daaReturnVisitViewHelper.complaintViewToDto(request);
			returnVisitDto.setPrplcomplaintDto(prplcomplaintDto);
			if("complaint".equals(nodeTypes)){
				if("2".equals(prplcomplaintDto.getWhethertrack())){
					PrplreturnvisitswflogDto prplreturnvisitswflogDto = daaReturnVisitViewHelper.complaintReturnVisitDto("4");
					prplreturnvisitswflogDto.setBusinessno(prplcomplaintDto.getComplaintno());
					prplreturnvisitswflogDto.setNodetype("compl");
					prplreturnvisitswflogDto.setHandlercode(user.getUserCode());
					prplreturnvisitswflogDto.setHandlername(user.getUserName());
					prplreturnvisitswflogDto.setHandlercomcode(user.getComCode());
					prplreturnvisitswflogDto.setCeasetime(prplreturnvisitswflogDto.getFlowintotime());
					returnVisitDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
				}
			}
			if("dealWith".equals(nodeTypes)){
				PrplreturnvisitswflogDto prplreturnvisitswflogDto = daaReturnVisitViewHelper.complaintReturnVisitDto("0");
				prplreturnvisitswflogDto.setBusinessno(prplcomplaintDto.getComplaintno());
				prplreturnvisitswflogDto.setNodetype("compl");
				returnVisitDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
			}
			UIReturnVisitAction uiReturnVisitAction = new UIReturnVisitAction();
			uiReturnVisitAction.save(returnVisitDto);
			request.setAttribute("nodeTypes", nodeTypes);
			user.setUserMessage("投诉添加成功。<br/>"+prplcomplaintDto.getComplaintno());
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(request, errors);
			forward = "error";
		}
		return mapping.findForward(forward);
	}
}
