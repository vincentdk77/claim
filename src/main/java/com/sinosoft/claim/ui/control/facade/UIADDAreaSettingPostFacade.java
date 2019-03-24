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

import com.sinosoft.claim.dto.custom.AreaSettingDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrplareasettingDto;
import com.sinosoft.claim.ui.control.action.UIAreaSettingAction;
import com.sinosoft.claim.ui.control.viewHelper.AreaSettingViewHelper;

public class UIADDAreaSettingPostFacade extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		String editType = request.getParameter("editType");
		UserDto   user     = (UserDto)request.getSession().getAttribute("user");
		String forward = "success";
		try {
				AreaSettingDto areaSettingDto = new AreaSettingDto();
				AreaSettingViewHelper daaAreaSettingViewHelper = new AreaSettingViewHelper();
				areaSettingDto = daaAreaSettingViewHelper.viewToDto(request,user);
				UIAreaSettingAction uiAreaSettingAction = new UIAreaSettingAction();
				
				String prplareasettingDtoHandledept = request.getParameter("prplareasettingDtoHandledept");
				String prplareasettingDtoHandlercode = request.getParameter("prplareasettingDtoHandlercode");
				String prplareasettingDtoClassCode = request.getParameter("prplareasettingDtoClassCode");
				PrplareasettingDto prplareasettingDto = new PrplareasettingDto();
				prplareasettingDto.setHandledept(prplareasettingDtoHandledept);
				prplareasettingDto.setHandlercode(prplareasettingDtoHandlercode);
				prplareasettingDto.setClasscode(prplareasettingDtoClassCode);
				areaSettingDto.setAreaSettingDto(prplareasettingDto);
				
				uiAreaSettingAction.save(areaSettingDto);
				user.setUserMessage("����������Ϣ��ӳɹ���");
			
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
