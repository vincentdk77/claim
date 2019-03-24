package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

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

import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP Post �������ⱨ���༭����
 * <p>Title: �������ⱨ���༭������Ϣ</p>
 * <p>Description: �������ⱨ���༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author lixiang
 * @version 1.0
 */
public class UILCheckDeletePostFacade
    extends Action {
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws
      Exception {
     

    String forward = ""; //��ǰ��ת
    String registNo=httpServletRequest.getParameter("registNo");
    String status =httpServletRequest.getParameter("status");
    String strMessage = "";
    try {
     //��֤��Ҫɾ���ı�����Ϣ���Ƿ���Ա�ɾ��
      //��� prplclaimstatus���е�״̬������ǵ���4����ɾ����
      //ɾ��ҵ�����Ϣ.��ͬ�ڱ�����ֻɾ��һ���ڵ�����ݣ����Ұ�claimstatus����������ɾ������������й������Ļ����ѹ�������Ϊ������
      UICheckAction uiCheckAction = new UICheckAction();
      uiCheckAction.delete(registNo);
      //����Ż�
      //UIBillAction uiBillAction  = new UIBillAction ();
      //uiBillAction.putno

      //ɾ������������Ϣ


      ActionMessages messages = new ActionMessages();
      Object obj_msg =strMessage;
      ActionMessage message = new ActionMessage("prompt.check.delete.submit",obj_msg);
      messages.add( ActionMessages.GLOBAL_MESSAGE, message );
      saveMessages( httpServletRequest, messages );
      //registDto.getPrpLregistDto().setRemark("����remark") ;
      //httpServletRequest.setAttribute("prpLregistDto",registDto.getPrpLregistDto() ) ;
      forward = "success";
    }
    catch(UserException usee)
       {
         usee.printStackTrace() ;
         //������Ϣ����
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
     
    return actionMapping.findForward(forward);
  }
}
