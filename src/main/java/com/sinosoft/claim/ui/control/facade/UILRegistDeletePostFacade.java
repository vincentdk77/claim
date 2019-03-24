package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP Post 车险理赔报案编辑界面
 * <p>Title: 车险理赔报案编辑界面信息</p>
 * <p>Description: 车险理赔报案编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author lixiang
 * @version 1.0
 */
public class UILRegistDeletePostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {
     

    String forward = ""; //向前流转
    String strBizName = "报案";
    String registNo=httpServletRequest.getParameter("registNo");
    String strMessage = "";
    String strSuccessMessage = "";
    String strFailMessage = "";

    try {
     //验证需要删除的报案信息，是否可以被删除
      //检查 prplclaimstatus表中该号码个数是不是大于1，如是，不许删除。
      UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();
      String conditons = " businessno ='" + registNo+"'";
      Collection claimStatusList = new ArrayList();
      claimStatusList =uiClaimStatusAction.findByConditions(conditons);
      int intCount =0;
      Iterator it = claimStatusList.iterator() ;
      while (it.hasNext() )
      {
        intCount ++;
        it.next();

      }
      String msg ="报案'"+registNo+"'已经被其它节点操作过，不可以撤消！";
      if (intCount > 1)
        {
          throw new UserException(1,3,"报案撤消",msg);
        }
      //删除业务的信息
      UIRegistAction uiRegistAction = new UIRegistAction();
      uiRegistAction.delete(registNo);
      //号码放回
      //UIBillAction uiBillAction  = new UIBillAction ();
      //uiBillAction.putno

      //删除工作流的信息


      ActionMessages messages = new ActionMessages();
      Object obj_msg =strMessage;
      ActionMessage message = new ActionMessage("prompt.regist.save",obj_msg);
      messages.add( ActionMessages.GLOBAL_MESSAGE, message );
      saveMessages( httpServletRequest, messages );
      //registDto.getPrpLregistDto().setRemark("测试remark") ;
      //httpServletRequest.setAttribute("prpLregistDto",registDto.getPrpLregistDto() ) ;
      forward = "success";
    }
    catch(UserException usee)
       {
         usee.printStackTrace() ;
         //错误信息处理
         ActionErrors errors = new ActionErrors();
         ActionError error = new ActionError("title.claimBeforeEdit.editClaim");
         errors.add(ActionErrors.GLOBAL_ERROR, error);
         httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
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
