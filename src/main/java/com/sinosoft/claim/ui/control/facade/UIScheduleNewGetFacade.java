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
 * �ַ�HTTP GET ������Ƚڵ���µ���Ҫ���ȵ�����
 * <p>Title: ������Ƚڵ���µ���Ҫ���ȵ�����</p>
 * <p>Description: ������Ƚڵ���µ���Ҫ���ȵ�����</p>
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
     
    //ҵ�����ͣ���ʾ
    //�����Ȱ�scheduleNew���е��������ݶ���ʾ����

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

    //System.out.println("��ʼ��ʾ�����������Ϣ");

    String forward  = "";                                          //��ǰ
    try
    {
       //��δ����type�쳣����{}��������������쳣����{}
       //��ѯ�µ�����ʾ����Ϣ,�������룬���ڳ�ʼ������ʾ
        DAAScheduleNewViewHelper dAAScheduleNewViewHelper = new DAAScheduleNewViewHelper();
        dAAScheduleNewViewHelper.getScheduleNewTaskList(httpServletRequest,userCode);
        forward = "success";
        //System.out.println("�ɹ���ѯ��������"+forward);
    }

    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
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
