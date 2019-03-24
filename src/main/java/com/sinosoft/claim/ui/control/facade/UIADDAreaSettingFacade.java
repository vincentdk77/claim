package com.sinosoft.claim.ui.control.facade;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.AreaSettingViewHelper;

public class UIADDAreaSettingFacade extends Action{

	//业务类型：ADD-新增  EDIT-修改  SHOW-显示
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward = "success";
		String editType = request.getParameter("editType");			//业务类型
		String handledept = request.getParameter("handledept");		//班表机构
		String handlercode = request.getParameter("handlercode");	//查勘员
		String state = request.getParameter("state");				//状态
		request.setAttribute("editType", editType);
		String areaClassCode = request.getParameter("classCode");
		request.setAttribute("classCode", areaClassCode);
		if("ADD".equals(editType)){
			AreaSettingViewHelper daaAreaSettingViewHelper = new AreaSettingViewHelper();
			daaAreaSettingViewHelper.findPrplAreaSettingEdit(request,handledept);
			//获取本机构已经保存的区域设置
			HashMap userMap = daaAreaSettingViewHelper.findAreaSettingUser(request,handledept);
			request.setAttribute("userMap", userMap);
		}
		if("EDIT".equals(editType)){
			AreaSettingViewHelper daaAreaSettingViewHelper = new AreaSettingViewHelper();
			daaAreaSettingViewHelper.findPrplAreaSettingEdit(request, handledept);
			daaAreaSettingViewHelper.findPrplAreaSettingUpdate(request, handledept,handlercode);
			request.setAttribute("state", state);
		}
		
		return mapping.findForward(forward);
	}

}
