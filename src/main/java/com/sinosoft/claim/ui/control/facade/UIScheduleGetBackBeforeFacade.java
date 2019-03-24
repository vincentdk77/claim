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
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * 分发HTTP GET 理赔调度节点的改派任务
 * <p>Title: 理赔调度节点的新的改派任务</p>
 * <p>Description: 理赔调度节点的改派任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIScheduleGetBackBeforeFacade  extends Action
{

  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {

   /** 4。查询调度取回任务
     * 5。查询调度撤消任务
     * 6。查询调度的所有信息
    **/

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

     String forward  = "";
     String registNo="";
                                        //向前
    String editType     = httpServletRequest.getParameter("editType");
    try
    {
       
        UICodeAction uiCodeAction = new UICodeAction();
        String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
       //1。调度录入的界面展现
       //调用位置:调度任务登记 ->新案件提示任务列表中选中一个报案->显示调度任务信息
      //8。调度信息取回详细显示
      //调用位置:调度取回任务 ->任务列表中选中一个报案->显示保存过的调度任务信息
       if(editType.equals("GETBACKEDIT"))
        {
        registNo = (String)httpServletRequest.getParameter("prpLscheduleMainWFRegistNo");     //报案号
        DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
        dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,registNo,editType,"1");
        forward = "EDITDAA";
        //System.out.println(forward+"forward信息取回");
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
