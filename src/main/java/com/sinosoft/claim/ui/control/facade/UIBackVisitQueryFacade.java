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

import com.sinosoft.claim.ui.control.viewHelper.DAABackVisitViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 单证查询
 * <p>Title: 车险理赔单证查询信息</p>
 * <p>Description: 车险理赔单证单证查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIBackVisitQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType     = httpServletRequest.getParameter("editType");
    String registNo      = httpServletRequest.getParameter("RegistNo");         //赔案号
    String policyNo   = httpServletRequest.getParameter("PolicyNo");            //保单号
    String statusCollect   = httpServletRequest.getParameter("statusCollect");  //案件状态
    String operateDate  = httpServletRequest.getParameter("OperateDate");       //操作时间

    //去掉status中最后一个逗号
    if(statusCollect!=null&&statusCollect.trim().length()>0){
      statusCollect=statusCollect.substring(0,statusCollect.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    String forward  = "";                                                       //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //查询单证信息,整理输入，用于初始界面显示
        DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
        dAABackVisitViewHelper.getBackVisitList(httpServletRequest,registNo,policyNo,statusCollect,operateDate);
        forward = "success";
      }
    } catch(UserException usee) {
      usee.printStackTrace() ;
      //错误信息处理 
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    } catch(Exception e) {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    } finally {
 
    } 

    return actionMapping.findForward(forward);
  }

}
