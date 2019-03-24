package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.JobManagerDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpljobmanagerDto;
import com.sinosoft.claim.ui.control.action.UIJobManagerAction;
import com.sinosoft.claim.ui.control.viewHelper.JobManagerViewHelper;
import com.sinosoft.platform.dto.domain.PrpDuserDto;

public class UIADDJobManagerPostFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		String forward = "";
		UserDto user = null;
		PrpDuserDto prpDuserDto = null;
		String systemCode = request.getParameter("systemCode");
		String editType = request.getParameter("editType");
		try {
			String updateType = request.getParameter("updateType");
			JobManagerDto jobManagerDto = new JobManagerDto();
			JobManagerViewHelper dAAJobManagerViewHelper = new JobManagerViewHelper();
			jobManagerDto = dAAJobManagerViewHelper.viewToDto(request);
			jobManagerDto.setUpdateType(updateType);
			
			//搜集数据
			String prpljobmanagerDtoHandledept = request.getParameter("prpljobmanagerDtoHandledept");
			String prpljobmanagerDtoMonth = request.getParameter("prpljobmanagerDtoMonth");
			String prpljobmanagerDtoHandlercode = request.getParameter("prpljobmanagerDtoHandlercode");
			String prpljobmanagerDtoClassCode = request.getParameter("prpljobmanagerDtoClassCode");
			PrpljobmanagerDto prpljobmanagerDto = new PrpljobmanagerDto();
			prpljobmanagerDto.setHandledept(prpljobmanagerDtoHandledept);
			prpljobmanagerDto.setMonth(prpljobmanagerDtoMonth);
			prpljobmanagerDto.setHandlercode(prpljobmanagerDtoHandlercode);
			prpljobmanagerDto.setClasscode(prpljobmanagerDtoClassCode);
			jobManagerDto.setPrpljobmanagerDto(prpljobmanagerDto);
			UIJobManagerAction uiJobManagerAction = new UIJobManagerAction();
			uiJobManagerAction.save(jobManagerDto);
			
			//获得用户信息
			if("undwrt".equals(systemCode)){
				String message = "";
				if("ADD".equals(editType)){
					message = "班表信息添加成功。";
				}else if("EDIT".equals(editType)){
					message = "班表信息修改成功。";
				}
				request.setAttribute("message", message);
			}else{
				user = (UserDto)request.getSession().getAttribute("user");
				if("ADD".equals(editType)){
					user.setUserMessage("班表信息添加成功。");
				}else if("EDIT".equals(editType)){
					user.setUserMessage("班表信息修改成功。");
				}
			}
			forward = "success";
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
