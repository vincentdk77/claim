package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.DAABackVisitViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ��֤��ѯ
 * <p>Title: �������ⵥ֤��ѯ��Ϣ</p>
 * <p>Description: �������ⵥ֤��֤��ѯ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIBackVisitQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType     = httpServletRequest.getParameter("editType");
    String registNo      = httpServletRequest.getParameter("RegistNo");         //�ⰸ��
    String policyNo   = httpServletRequest.getParameter("PolicyNo");            //������
    String statusCollect   = httpServletRequest.getParameter("statusCollect");  //����״̬
    String operateDate  = httpServletRequest.getParameter("OperateDate");       //����ʱ��

    //ȥ��status�����һ������
    if(statusCollect!=null&&statusCollect.trim().length()>0){
      statusCollect=statusCollect.substring(0,statusCollect.length()-1);
    }
    HttpSession session = httpServletRequest.getSession();
    String forward  = "";                                                       //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //��ѯ��֤��Ϣ,�������룬���ڳ�ʼ������ʾ
        DAABackVisitViewHelper dAABackVisitViewHelper = new DAABackVisitViewHelper();
        dAABackVisitViewHelper.getBackVisitList(httpServletRequest,registNo,policyNo,statusCollect,operateDate);
        forward = "success";
      }
    } catch(UserException usee) {
      usee.printStackTrace() ;
      //������Ϣ���� 
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    } catch(Exception e) {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.certifyBeforeEdit.queryCertifyList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    } finally {
 
    } 

    return actionMapping.findForward(forward);
  }

}
