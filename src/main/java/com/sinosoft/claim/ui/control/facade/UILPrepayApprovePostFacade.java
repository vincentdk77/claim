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
import com.sinosoft.claim.ui.control.action.UIPrepayAction;
import com.sinosoft.sysframework.exceptionlog.UserException;


/**
 * �ַ�HTTP Post ��������Ԥ��༭����
 * <p>Title: ��������Ԥ��༭������Ϣ</p>
 * <p>Description: ��������Ԥ��༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILPrepayApprovePostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {
     
    String forward = ""; //��ǰ��ת
    try {
      
      UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");

      String preCompensateNo = httpServletRequest.getParameter("prpLprepayPreCompensateNo");
      String underWriteFlag = httpServletRequest.getParameter("prpLprepayUnderWriteFlag");

      //����Ԥ����Ϣ
      UIPrepayAction uiPrepayAction = new UIPrepayAction();
      uiPrepayAction.approve(preCompensateNo,user.getUserCode(),underWriteFlag);

      user.setUserMessage(preCompensateNo);


      ActionMessages messages = new ActionMessages();
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("title.prepayApprove.approveSuccess"));
      messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLprepay.preCompensateNo"));
      saveMessages( httpServletRequest, messages );

      forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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
      //������Ϣ����
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
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.registBeforeEdit.editRegist");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",stringWriter.toString()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    finally {

    }
     
    System.out.println("---------------UILPrepayEditPostFacade----liubvo-------forward-------" + forward);
    return actionMapping.findForward(forward);
  }
}
