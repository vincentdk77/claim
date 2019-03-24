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
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleNewViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP GET 理赔调度节点的新的需要调度的任务
 * <p>Title: 理赔调度节点的新的需要调度的任务</p>
 * <p>Description: 理赔调度节点的新的需要调度的任务</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIScheduleNewGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //业务类型：显示
    //首先先把scheduleNew表中的所有数据都显示出来

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

    //System.out.println("开始显示调度任务表信息");

    String forward  = "";                                          //向前
    try
    {
       //尚未加入type异常处理{}、其它必须参数异常处理{}
       //查询新调度提示表信息,整理输入，用于初始界面显示
        DAAScheduleNewViewHelper dAAScheduleNewViewHelper = new DAAScheduleNewViewHelper();
        dAAScheduleNewViewHelper.getScheduleNewTaskList(httpServletRequest,userCode);
        forward = "success";
        //System.out.println("成功查询出来内容"+forward);
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
    //System.out.println("finishQueryEdit forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}
