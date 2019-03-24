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
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
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
				user.setUserMessage("区域设置信息添加成功。");
			
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
