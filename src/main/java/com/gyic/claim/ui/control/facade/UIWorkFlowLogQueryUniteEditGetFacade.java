package com.gyic.claim.ui.control.facade;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

/**
 * 分发HTTP GET 工作流状态查询
 * <p>Title: 车险理赔工作流查询信息</p>
 * <p>Description: 车险理赔工作流信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIWorkFlowLogQueryUniteEditGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
//    //业务类型：ADD-新增  EDIT-修改  SHOW-显示

	  String flag=httpServletRequest.getParameter("Flag");
	  if("N".equals(flag)){
		  String policyNo=httpServletRequest.getParameter("PolicyNo");
	      String startDate=httpServletRequest.getParameter("statStartDate");
	      String endDate=httpServletRequest.getParameter("statEndDate");
	      httpServletRequest.setAttribute("StartDate", startDate);
	      httpServletRequest.setAttribute("PolicyNo", policyNo);
	      httpServletRequest.setAttribute("EndDate", endDate);
	  }else{
		  String policyNo=httpServletRequest.getParameter("policyNo");
		  String startDate=httpServletRequest.getParameter("StartDate");
		  String endDate=httpServletRequest.getParameter("EndDate");
		  httpServletRequest.setAttribute("StartDate", startDate);
		  httpServletRequest.setAttribute("PolicyNo", policyNo);  
		  httpServletRequest.setAttribute("EndDate", endDate);  
	  }
      String nodeType     = httpServletRequest.getParameter("nodeType");
      String status      = httpServletRequest.getParameter("status");    //立案号
      HttpSession session = httpServletRequest.getSession();
      String editType= httpServletRequest.getParameter("editType");
      String isFirst		= httpServletRequest.getParameter("isFirst"); //是否第一次进来，第一次进来不查询结果
      String forward  = "";  
    try
    { 
    	//第一次进来，标志为空的，所以对其进行初始化；第二次进来，取的是页面的值，所以不为空，不用处理
    	if(isFirst == null || "".equals(isFirst)){
    		isFirst = "Y";
    	}
    	httpServletRequest.setAttribute("isFirst", isFirst);	
    	 WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        //查询工作流状态信息,整理输入，用于初始界面显示
		//需要进行翻页处理
		//每页显示的行数
    	String isFirstFlag=httpServletRequest.getParameter("isFirstFlag");
		String recordPerPage = AppConfig.get("sysconst.ROWS_PERPAGE");
		String pageNo     = httpServletRequest.getParameter("pageNo");
		if(pageNo==null||pageNo.trim().equals("")) pageNo = "1";
		if("1".equals(isFirstFlag)){
			
		}else{
			  String registNos= httpServletRequest.getParameter("checkBox");
			  httpServletRequest.setAttribute("checkBox", registNos);
              workFlowViewHelper.getComBineWorkFlowLogList(httpServletRequest,pageNo,recordPerPage);
		}
        forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.combine.queryCombineListNot");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.combine.queryCombineListNot");
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
