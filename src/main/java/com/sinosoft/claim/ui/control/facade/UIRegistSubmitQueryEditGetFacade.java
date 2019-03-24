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
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimStatusViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 已完成报案查询
 * <p>Title: 车险理赔已完成报案查询信息</p>
 * <p>Description: 车险理赔报案已完成报案查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIRegistSubmitQueryEditGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
 //显对其他功能要复杂一些，因为需要查询条件的过滤

/*
    String editType   = httpServletRequest.getParameter("editType");
    String policyNo   = httpServletRequest.getParameter("prpLregistPolicyNo");    //保单号
    String registNo   = httpServletRequest.getParameter("prpLregistRegistNo") ; //报案号
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种
*/
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String editType   = "EDIT";
    httpServletRequest.setAttribute("editType",editType);
    String status   = "4";
    String userCode = user.getUserCode();
    String nodeType="regis";
    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //查询理赔节点状态信息,整理输入，用于初始界面显示
       /*
        DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
        dAARegistViewHelper.setPrpLregistDtoToView(httpServletRequest,registNo,policyNo);
*/
        DAAClaimStatusViewHelper dAAClaimStatusViewHelper = new DAAClaimStatusViewHelper();
        dAAClaimStatusViewHelper.getClaimStats(httpServletRequest,status,userCode,nodeType);

        forward = "success";

      }
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.queryRegistList");
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
