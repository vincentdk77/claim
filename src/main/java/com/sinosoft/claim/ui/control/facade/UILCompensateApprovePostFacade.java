package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

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

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

//设置工作流测试

/**
 * 分发HTTP Post 车险理赔实赔编辑界面
 * <p>Title: 车险理赔实赔编辑界面信息</p>
 * <p>Description: 车险理赔实赔编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILCompensateApprovePostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {

    String forward = ""; //向前流转
    try {
      //取赔款计算书号
        String compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo");
        //String underWriteFlag = httpServletRequest.getParameter("prpLcompensateUnderWriteFlag");
        String underWriteFlag ="1";
        String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
        String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
        String keyString = httpServletRequest.getParameter("keyString"); //工作流keyIn
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        //保存赔款计算书信息
        UICompensateAction uiCompensateAction = new UICompensateAction();

        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();


       //目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
        uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了

        if (swfLogFlowID!=null && swfLogLogNo!=null)
        {
          UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade=new UIWorkFlowUWInterFaceFacade();
          if (uiWorkFlowUWInterFaceFacade.passVeric(httpServletRequest,swfLogFlowID,
                                            Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)),
                                            compensateNo,
                                            "方方 同意进行核赔 "+new DateTime(DateTime.current() ,DateTime.YEAR_TO_SECOND  ).toString(),"" )>-1){

            compensateNo=compensateNo+" 工作流提交成功！";
            compensateNo =compensateNo+"\n 赔案号码为：\n"+httpServletRequest.getSession().getAttribute("caseNo");
          }else{
            compensateNo=compensateNo+" 工作流提交失败！";
          }
        }


        user.setUserMessage(compensateNo);

      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.compensateApprove.approveSuccess"));
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLcompensate.compensateNo"));
      saveMessages( httpServletRequest, messages );
      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    catch(SQLException sqle)
    {
      StringWriter stringWriter = new StringWriter();
      sqle.printStackTrace(new PrintWriter(stringWriter));
      sqle.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString() ) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      e.printStackTrace(new PrintWriter(stringWriter));
      e.printStackTrace();
      //错误信息处理
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally {

    }

    return actionMapping.findForward(forward);
  }
}
