package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * �ַ�HTTP GET ������Ƚڵ�ı�������
 * <p>Title: ������Ƚڵ�ı�������</p>
 * <p>Description: ������Ƚڵ�ı�������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author lixiang
 * @version 1.0
 */

public class UICheckScheduleEditPostFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
      
     String forward="";
     try{


     UICheckAction uiCheckAction = new UICheckAction();
     String registNo = httpServletRequest.getParameter("prpLscheduleMainWFRegistNo"); //������
     String scheduleID = httpServletRequest.getParameter("prpLscheduleMainWFScheduleID"); //���Ⱥ�
     //httpServletRequest.setAttribute("registNo", registNo);
     //httpServletRequest.setAttribute("scheduleID", scheduleID);

     //��viewHelper�����������
     DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
     ScheduleDto scheduleDto = dAACheckViewHelper.checkViewToDto(httpServletRequest);

     //����鿱��Ϣ
      uiCheckAction.saveSchedule(scheduleDto);
      httpServletRequest.setAttribute("registNo", registNo);
      httpServletRequest.setAttribute("nodeType1", "sched");
      httpServletRequest.setAttribute("isSave", "1");
     //System.out.println("�鿱����ɹ�!");

      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.submit"));
     //messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLcompensate.registNo"));

     saveMessages( httpServletRequest, messages );
     UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
     user.setUserMessage("������:"+registNo+"    ���Ⱥ�:"+scheduleID);
     forward="success";
    }

    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }

    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
