package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.WorkFlowModelViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发查询工作流模板信息
 * <p>Title: 工作流模板查询</p>
 * <p>Description: 工作流模板查询</p>
 * <p>Copyright: Copyright (c) 2004-08-10</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIWorkFlowModelQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    String forward = "" ;//界面流转
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示

    try
    {
        //查询出工作流列表
        WorkFlowModelViewHelper workFlowModelViewHelper = new WorkFlowModelViewHelper();
        workFlowModelViewHelper.viewToDto(httpServletRequest) ;
        forward = "success";

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
    System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
