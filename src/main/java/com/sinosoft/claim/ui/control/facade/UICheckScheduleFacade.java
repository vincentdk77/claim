package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;


/**
 * 分发HTTP GET 根据调度任务查勘查询
 * <p>Title: 车险理赔根据调度任务查勘查询信息</p>
 * <p>Description: 车险理赔根据调度任务查勘根据调度任务查勘查询信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UICheckScheduleFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //业务类型：ADD-新增  EDIT-修改  SHOW-显示， SHOWNEWLIST-显示调度任务
    //HttpSession session = httpServletRequest.getSession();
    //UserDto   user     = (UserDto)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //险种

    String forward  = "";                                          //向前
    try
    {
      //尚未加入type异常处理{}、其它必须参数异常处理{}
      //查询根据调度任务查勘信息,整理输入，用于初始界面显示
       String editType   = httpServletRequest.getParameter("editType");//类型
       String registNo =httpServletRequest.getParameter("prpLscheduleMainWFRegistNo");//报案号
       String scheduleID=httpServletRequest.getParameter("prpLscheduleMainWFScheduleID");//调度号
       if (editType.equals("DAALIST") )
       {//显示查勘任务的列表情况

           DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
           dAACheckViewHelper.getCheckScheduleDtoToView(httpServletRequest);
           forward = "EDITDAA";
      } // System.out.println(new DateTime(DateTime.current().toString() ));
      //System.out.println(new DateTime(DateTime ));
       if (editType.equals("DEALCHECKSCHEDULE"))
       {
         //处理查勘任务
         DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
         dAACheckViewHelper.getCheckScheduleDealDtoToView(httpServletRequest,registNo,scheduleID) ;
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
