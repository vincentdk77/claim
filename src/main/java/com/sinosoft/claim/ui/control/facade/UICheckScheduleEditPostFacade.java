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
 * 分发HTTP GET 理赔调度节点的保存任务
 * <p>Title: 理赔调度节点的保存任务</p>
 * <p>Description: 理赔调度节点的保存任务</p>
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
     String registNo = httpServletRequest.getParameter("prpLscheduleMainWFRegistNo"); //报案号
     String scheduleID = httpServletRequest.getParameter("prpLscheduleMainWFScheduleID"); //调度号
     //httpServletRequest.setAttribute("registNo", registNo);
     //httpServletRequest.setAttribute("scheduleID", scheduleID);

     //用viewHelper整理界面输入
     DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
     ScheduleDto scheduleDto = dAACheckViewHelper.checkViewToDto(httpServletRequest);

     //保存查勘信息
      uiCheckAction.saveSchedule(scheduleDto);
      httpServletRequest.setAttribute("registNo", registNo);
      httpServletRequest.setAttribute("nodeType1", "sched");
      httpServletRequest.setAttribute("isSave", "1");
     //System.out.println("查勘保存成功!");

      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.check.submit"));
     //messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLcompensate.registNo"));

     saveMessages( httpServletRequest, messages );
     UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
     user.setUserMessage("报案号:"+registNo+"    调度号:"+scheduleID);
     forward="success";
    }

    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
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
