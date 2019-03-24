package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.ui.control.viewHelper.JobManagerViewHelper;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIADDJobManagerQueryFacade extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String forward;
		try {
			//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
			
			String editType   = request.getParameter("editType");
			forward = "success";
			if(editType.equals("SHOW") || editType.equals("EDIT")){
				String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
				String pageNo     = request.getParameter("pageNo");
				JobManagerViewHelper daaJobManagerViewHelper = new JobManagerViewHelper();
				daaJobManagerViewHelper.setPrpljobManagerDtoToView(request, pageNo, recordPerPage);
				request.setAttribute("editType", editType);
			}if(editType.equals("LINK")){
				String comCode = request.getParameter("comCode");
				JobManagerViewHelper daaJobManagerViewHelper = new JobManagerViewHelper();
				daaJobManagerViewHelper.linkJobManager(request,comCode);
				forward = "showlink";
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
