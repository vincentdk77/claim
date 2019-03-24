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
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
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
			
			//�Ѽ�����
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
			
			//����û���Ϣ
			if("undwrt".equals(systemCode)){
				String message = "";
				if("ADD".equals(editType)){
					message = "�����Ϣ��ӳɹ���";
				}else if("EDIT".equals(editType)){
					message = "�����Ϣ�޸ĳɹ���";
				}
				request.setAttribute("message", message);
			}else{
				user = (UserDto)request.getSession().getAttribute("user");
				if("ADD".equals(editType)){
					user.setUserMessage("�����Ϣ��ӳɹ���");
				}else if("EDIT".equals(editType)){
					user.setUserMessage("�����Ϣ�޸ĳɹ���");
				}
			}
			forward = "success";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//������Ϣ����
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
