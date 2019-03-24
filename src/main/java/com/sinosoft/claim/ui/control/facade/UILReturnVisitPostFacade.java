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
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		String forward;
		forward = "success";
		UserDto user	= (UserDto)request.getSession().getAttribute("user");
		String nodeType = request.getParameter("prplreturnvisitswflogDtoNodeType");
		try {
			String strLastAccessedTime = ""+ request.getSession().getLastAccessedTime() / 1000;
		    String oldLastAccessedTime = (String) request.getSession().getAttribute("oldprplreturnvisitAccessedTime");
			String visitsuccessState = request.getParameter("visitsuccessState");				//�ֶ��жϻط��Ƿ�ɹ� 1�طóɹ� 0�ط�ʧ��
			String visitfailState = request.getParameter("visitfailState");						//�Ƿ���Ҫ����
			visitsuccessState += visitfailState;
			ReturnVisitDto returnVisitDto = new ReturnVisitDto();
			DAAReturnVisitViewHelper daaReturnVisitViewHelper = new DAAReturnVisitViewHelper();
			returnVisitDto = daaReturnVisitViewHelper.viewToDto(request);
			//�޸Ļط�������Ϣ
			PrplreturnvisitswflogDto prplreturnvisitswflogDto = daaReturnVisitViewHelper.viewToReturnVisitSwflogDto(request,visitsuccessState);
			returnVisitDto.setPrplreturnvisitswflogDto(prplreturnvisitswflogDto);
			UIReturnVisitAction uiReturnVisitAction = new UIReturnVisitAction();
			if (oldLastAccessedTime != null
					&& !oldLastAccessedTime.trim().equals("")) {
				// ��������
			}else{
				uiReturnVisitAction.save(returnVisitDto);
			}
			request.getSession().setAttribute("oldprplreturnvisitAccessedTime", strLastAccessedTime);		
			if("compl".equals(nodeType)){
				user.setUserMessage("Ͷ�߸�����ӳɹ���<br/>"+returnVisitDto.getPrplreturnvisitswflogDto().getBusinessno());
			}else{
				user.setUserMessage("�ط���ӳɹ���<br/>"+returnVisitDto.getPrplreturnvisitswflogDto().getBusinessno());
			}
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
