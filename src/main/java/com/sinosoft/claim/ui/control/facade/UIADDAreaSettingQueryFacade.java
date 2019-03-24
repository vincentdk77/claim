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
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		
		String editType = request.getParameter("editType");
		UserDto   user     = (UserDto)request.getSession().getAttribute("user");
		String handledept = request.getParameter("handledept");				//班表机构
		String handlercode = request.getParameter("handlercode");			//维护人
		String forward = "success";
			DAAAreaSettingViewHelper daaAreaSettingViewHelper = new DAAAreaSettingViewHelper();
			daaAreaSettingViewHelper.setAreaSettingToDtoView(request,handledept,handlercode);
			request.setAttribute("editType", editType);
		return mapping.findForward(forward);
	}

}
