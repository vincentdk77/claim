package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.viewHelper.DAAAreaSettingViewHelper;

public class UIADDAreaSettingQueryFacade extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		
		String editType = request.getParameter("editType");
		UserDto   user     = (UserDto)request.getSession().getAttribute("user");
		String handledept = request.getParameter("handledept");				//������
		String handlercode = request.getParameter("handlercode");			//ά����
		String forward = "success";
			DAAAreaSettingViewHelper daaAreaSettingViewHelper = new DAAAreaSettingViewHelper();
			daaAreaSettingViewHelper.setAreaSettingToDtoView(request,handledept,handlercode);
			request.setAttribute("editType", editType);
		return mapping.findForward(forward);
	}

}
