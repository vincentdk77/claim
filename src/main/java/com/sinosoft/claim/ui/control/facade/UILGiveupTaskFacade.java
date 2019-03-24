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
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * <p>Title: 放弃未处理任务</p>
 * <p>Description: 放弃未处理任务程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author miaowenjun
 * @version 1.0
 */

public class UILGiveupTaskFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  { 
    String editType     = httpServletRequest.getParameter("editType");
    HttpSession session = httpServletRequest.getSession();
    UserDto   user     = (UserDto)session.getAttribute("user");
    String forward  = "";                                          //向前
    try
    {
    	//未处理任务的放弃处理
      if (editType.equals("GIVUP")) {
          String FlowID = httpServletRequest.getParameter("swfLogFlowID");
          int  LogNo=Integer.parseInt((String)httpServletRequest.getParameter("swfLogLogNo"));
          UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
          SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
          swfLogDto.setHandlerCode("");
          swfLogDto.setHandlerName("");
          swfLogDto.setFlowStatus("1");
          uiworkflowaction.updateFlow(swfLogDto);
          ActionMessages messages = new ActionMessages();
          messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
          "prompt.compensate.giveup"));
          saveMessages(httpServletRequest, messages);
          forward = "success";
      }

    }
    catch(UserException usee)
     {
       usee.printStackTrace() ;
       //错误信息处理
       ActionErrors errors = new ActionErrors();
       ActionError error = new ActionError("title.registBeforeEdit.editRegist");
       errors.add(ActionErrors.GLOBAL_ERROR, error);
       httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
       saveErrors(httpServletRequest, errors);
       forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.titleName");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally
    {

    }
     
    return actionMapping.findForward(forward);
  }
}