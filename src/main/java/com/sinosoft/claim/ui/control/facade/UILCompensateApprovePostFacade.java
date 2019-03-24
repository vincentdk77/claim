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

//���ù���������

/**
 * �ַ�HTTP Post ��������ʵ��༭����
 * <p>Title: ��������ʵ��༭������Ϣ</p>
 * <p>Description: ��������ʵ��༭������Ϣ</p>
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

    String forward = ""; //��ǰ��ת
    try {
      //ȡ���������
        String compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo");
        //String underWriteFlag = httpServletRequest.getParameter("prpLcompensateUnderWriteFlag");
        String underWriteFlag ="1";
        String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //����������
        String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //������logno
        String keyString = httpServletRequest.getParameter("keyString"); //������keyIn
        UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
        //��������������Ϣ
        UICompensateAction uiCompensateAction = new UICompensateAction();

        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        SwfLogDto swfLogDtoDealNode = new SwfLogDto();


       //Ŀǰ�ڽӿ��У����˫��û��д���ǵ�ҵ��⣬��ô����������棬����Ѿ�д�����ǵ�ҵ��⣬��ôֻҪ���湤�������ݾͿ�����
        uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
        //����ɹ��Ļ������ڹ���������ô����Ҫ�ύ�����������û�о�����

        if (swfLogFlowID!=null && swfLogLogNo!=null)
        {
          UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade=new UIWorkFlowUWInterFaceFacade();
          if (uiWorkFlowUWInterFaceFacade.passVeric(httpServletRequest,swfLogFlowID,
                                            Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)),
                                            compensateNo,
                                            "���� ͬ����к��� "+new DateTime(DateTime.current() ,DateTime.YEAR_TO_SECOND  ).toString(),"" )>-1){

            compensateNo=compensateNo+" �������ύ�ɹ���";
            compensateNo =compensateNo+"\n �ⰸ����Ϊ��\n"+httpServletRequest.getSession().getAttribute("caseNo");
          }else{
            compensateNo=compensateNo+" �������ύʧ�ܣ�";
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

    return actionMapping.findForward(forward);
  }
}
