package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * ����������
 * <p>
 * Title: ����������
 * </p>
 * <p>
 * Description: ����������
 * </p>
 * <p>
 * Copyright: Copyright (c) 2005-07-15
 * </p>
 * <p>
 * Company: Sinosoft
 * </p>
 * @author zhouxianli
 * @version 1.0
 */

public class UIWorkFlowProcessFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm, HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        String forward = "";// ������ת
        // ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
        String editType = ""; // �༭����
        int modelNo = 0;// ģ���
        editType = httpServletRequest.getParameter("editType");
        HttpSession session = httpServletRequest.getSession();
        UserDto user = (UserDto) session.getAttribute("user");

        try {
            UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
            WorkFlowDto workFlowDto = null;
            System.out.println("editType:" + editType);
            if (editType.equals("recycle")) {                
                workFlowDto = new WorkFlowDto();
                workFlowDto.setRecycle(true);
                SwfLogDto swfLogDto = new SwfLogDto();
                swfLogDto.setFlowID(httpServletRequest.getParameter("flowID"));
                swfLogDto.setLogNo(Integer.parseInt(httpServletRequest.getParameter("logNo")));
                workFlowDto.setUpdateSwfLogDto(swfLogDto);
                uiWorkFlowAction.deal(workFlowDto);
            }
            
            ActionMessages messages = new ActionMessages();
            messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("claim.back.success"));
            saveMessages(httpServletRequest, messages);
			
            forward = "success"; 

        } catch (UserException usee) {
            usee.printStackTrace();
            // ������Ϣ����
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError(
                    "");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", usee
                    .getErrorMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";
        } catch (Exception e) {
            e.printStackTrace();
            ActionErrors errors = new ActionErrors();
            ActionError error = new ActionError(
                    "");
            errors.add(ActionErrors.GLOBAL_ERROR, error);
            httpServletRequest.setAttribute("errorMessage", e.getMessage());
            saveErrors(httpServletRequest, errors);
            forward = "error";

        } finally {

        }
        System.out.println("UIWorkFlowModelUseEditPostFacade forward="
                + forward);

        return actionMapping.findForward(forward);
    }

}
