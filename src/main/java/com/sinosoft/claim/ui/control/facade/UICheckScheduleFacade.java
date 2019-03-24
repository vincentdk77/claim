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
 * �ַ�HTTP GET ���ݵ�������鿱��ѯ
 * <p>Title: ����������ݵ�������鿱��ѯ��Ϣ</p>
 * <p>Description: ����������ݵ�������鿱���ݵ�������鿱��ѯ��Ϣϵͳ��������</p>
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
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ�� SHOWNEWLIST-��ʾ��������
    //HttpSession session = httpServletRequest.getSession();
    //UserDto   user     = (UserDto)session.getAttribute("user");
    //String riskCode = user.getRiskCode();                           //����

    String forward  = "";                                          //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      //��ѯ���ݵ�������鿱��Ϣ,�������룬���ڳ�ʼ������ʾ
       String editType   = httpServletRequest.getParameter("editType");//����
       String registNo =httpServletRequest.getParameter("prpLscheduleMainWFRegistNo");//������
       String scheduleID=httpServletRequest.getParameter("prpLscheduleMainWFScheduleID");//���Ⱥ�
       if (editType.equals("DAALIST") )
       {//��ʾ�鿱������б����

           DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
           dAACheckViewHelper.getCheckScheduleDtoToView(httpServletRequest);
           forward = "EDITDAA";
      } // System.out.println(new DateTime(DateTime.current().toString() ));
      //System.out.println(new DateTime(DateTime ));
       if (editType.equals("DEALCHECKSCHEDULE"))
       {
         //����鿱����
         DAACheckViewHelper dAACheckViewHelper = new DAACheckViewHelper();
         dAACheckViewHelper.getCheckScheduleDealDtoToView(httpServletRequest,registNo,scheduleID) ;
         forward = "success";



        }

    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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
