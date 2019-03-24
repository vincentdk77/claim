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

import com.sinosoft.claim.ui.control.viewHelper.SunnyCompensateViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 实赔查询
 * <p>Title: 车险理赔实赔查询信息</p>
 * <p>Description: 车险理赔实赔实赔查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICompensatePassQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  { 
   
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示
    String editType   = httpServletRequest.getParameter("editType");//类型
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //保单号
    String claimNo   = httpServletRequest.getParameter("ClaimNo");//赔案号
    String compensateNo   = httpServletRequest.getParameter("CompensateNo") ; //赔款计算书号

    String operateDate  = httpServletRequest.getParameter("OperateDate");//操作时间
    String underWriteFlag = httpServletRequest.getParameter("compensateFlag");//核赔标志
 
    //去掉compensateFlag中最后一个逗号
    if(underWriteFlag!=null&&underWriteFlag.trim().length()>0){
      underWriteFlag = underWriteFlag.substring(0,underWriteFlag.length()-1);	
    }
    HttpSession session = httpServletRequest.getSession();
    //User   user     = (User)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种

    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")||editType.equals("RegistBeforeQuery")) {
        //查询实赔r信息,整理输入，用于初始界面显示

        //需要进行翻页处理
        //每页显示的行数
        String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
        String pageNo     = httpServletRequest.getParameter("pageNo");
        if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
        SunnyCompensateViewHelper sunnyCompensateViewHelper = new SunnyCompensateViewHelper();
        sunnyCompensateViewHelper.searchPassCompensate(httpServletRequest,compensateNo,policyNo,claimNo,operateDate,underWriteFlag,pageNo,recordPerPage);
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
