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

import com.sinosoft.claim.ui.control.viewHelper.WorkFlowModelViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 工作流模板分配查询
 * <p>Title: 工作流模板分配</p>
 * <p>Description: 工作流模板分配</p>
 * <p>Copyright: Copyright (c) 2004-08-25</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIWorkFlowModelUseEditGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    String forward = "" ;//界面流转
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType = "" ; //编辑类型
    int modelNo = 0 ;//模板号
    editType = httpServletRequest.getParameter("editType") ;
    try
    {
        WorkFlowModelViewHelper workFlowModelViewHelper = new WorkFlowModelViewHelper();
        if(editType.equals("ADD"))
        {
          //得到初始化界面Dto
          workFlowModelViewHelper.iniWfModelUseDtoToView(httpServletRequest) ;
          forward = "batchAssign";
        }
        else if(editType.equals("EDIT"))
        {
          workFlowModelViewHelper.getSwfModelUseDtoToView(httpServletRequest);
          forward = "modelUseEdit";
        }

        ActionMessages messages = new ActionMessages();

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("db.prpLafterward.claimNo"));
        saveMessages(httpServletRequest, messages);

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.queryVerifyLossList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.queryVerifyLossList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("UIWorkFlowModelUseEditGetFacade forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
