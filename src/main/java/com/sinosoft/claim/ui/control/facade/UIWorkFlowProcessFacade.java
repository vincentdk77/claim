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
 * 工作流处理
 * <p>
 * Title: 工作流处理
 * </p>
 * <p>
 * Description: 工作流处理
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

        String forward = "";// 界面流转
        // 业务类型：ADD-新增 EDIT-修改 SHOW-显示
        String editType = ""; // 编辑类型
        int modelNo = 0;// 模板号
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
            // 错误信息处理
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
