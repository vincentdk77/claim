package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 理赔节点状态查询
 * <p>Title: 车险理赔节点状态询信息</p>
 * <p>Description: 车险理赔节点状态信息系统</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIClaimStatusStatGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
  	 String riskType   = httpServletRequest.getParameter("riskType"); //add by liuyanmei 20051110
//    String editType   = httpServletRequest.getParameter("editType");
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String editType   = "EDIT";
    httpServletRequest.setAttribute("editType",editType);
    String userCode = user.getUserCode();
    String nodeType= httpServletRequest.getParameter("nodeType");
    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW"))
      {
        //查询理赔节点状态信息,整理输入，用于初始界面显示
        //DAAClaimStatusViewHelper dAAClaimStatusViewHelper = new DAAClaimStatusViewHelper();
        //dAAClaimStatusViewHelper.getClaimStatsStat(httpServletRequest,userCode,nodeType);
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        workFlowViewHelper.getWorkFLowNodeStatsStat(httpServletRequest,user,nodeType);

        forward = "success";

      }
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
     
    return actionMapping.findForward(forward);
  }

}
