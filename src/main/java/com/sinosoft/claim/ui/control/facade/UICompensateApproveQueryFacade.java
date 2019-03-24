package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.DAACompensateViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ʵ�����񸴺˲�ѯ
 * <p>Title: ��������ʵ�����񸴺˲�ѯ��Ϣ</p>
 * <p>Description: ��������ʵ��ʵ�����񸴺˲�ѯ��Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */ 
 
public class UICompensateApproveQueryFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType   = httpServletRequest.getParameter("editType");//����
    String policyNo   = httpServletRequest.getParameter("PolicyNo");    //������
    String claimNo   = httpServletRequest.getParameter("ClaimNo");//�ⰸ��
    String compensateNo   = httpServletRequest.getParameter("CompensateNo") ; //���������
    String forward  = "";      //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW")) {
        //��ѯʵ��r��Ϣ,�������룬���ڳ�ʼ������ʾ

        DAACompensateViewHelper dAACompensateViewHelper = new DAACompensateViewHelper();
        dAACompensateViewHelper.getApproveCompensateList(httpServletRequest,compensateNo,policyNo,claimNo);

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
