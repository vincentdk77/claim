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
import com.sinosoft.claim.dto.domain.PrplreturnvisitswflogDto;
import com.sinosoft.claim.ui.control.action.UIReturnVisitAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAReturnVisitViewHelper;

public class UILReturnVisitPostFacade extends Action{

	/**
	 * 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		String forward;
		forward = "success";
		UserDto user	= (UserDto)request.getSession().getAttribute("user");
		String nodeType = request.getParameter("prplreturnvisitswflogDtoNodeType");
		try {
			String strLastAccessedTime = ""+ request.getSession().getLastAccessedTime() / 1000;
		    String oldLastAccessedTime = (String) request.getSession().getAttribute("oldprplreturnvisitAccessedTime");
			String visitsuccessState = request.getParameter("visitsuccessState");				//字段判断回访是否成功 1回访成功 0回访失败
			String visitfailState = request.getParameter("visitfailState");						//是否需要跟进
			visitsuccessState += visitfailState;
			ReturnVisitDto returnVisitDto = new ReturnVisitDto();
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			returnVisitDto = daaReturnVisitViewHelper.viewToDto(request);
			//修改回访主表信息
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = daaReturnVisitViewHelper.viewToReturnVisitSwflogDto(request,visitsuccessState);
			returnVisitDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
			UIReturnVisitAction uiReturnVisitAction = new UIReturnVisitAction();
			if (oldLastAccessedTime != null
					&& !oldLastAccessedTime.trim().equals("")) {
				// 不做保存
			}else{
				uiReturnVisitAction.save(returnVisitDto);
			}
			request.getSession().setAttribute("oldprplreturnvisitAccessedTime", strLastAccessedTime);		
			if("compl".equals(nodeType)){
				user.setUserMessage("投诉跟踪添加成功。<br/>"+returnVisitDto.getPrplreturnvisitswflogDto().getBusinessno());
			}else{
				user.setUserMessage("回访添加成功。<br/>"+returnVisitDto.getPrplreturnvisitswflogDto().getBusinessno());
			}
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
