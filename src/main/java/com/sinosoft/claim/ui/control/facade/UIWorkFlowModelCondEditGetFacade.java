package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.ui.control.viewHelper.WorkFlowModelViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ���ѯ������ģ����Ϣ
 * <p>Title: ������ģ���ѯ</p>
 * <p>Description: ������ģ���ѯ</p>
 * <p>Copyright: Copyright (c) 2004-08-10</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIWorkFlowModelCondEditGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
    throws Exception
  {
     
    String forward = "" ;//������ת
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
    String editType = "" ; //�༭����
    int modelNo = 0 ;//ģ���
    int pathNo  = 0 ;//·����
    editType = httpServletRequest.getParameter("editType") ;
    try
    {
        WorkFlowModelViewHelper workFlowModelViewHelper = new WorkFlowModelViewHelper();
        if(editType.equals("ADD"))
        {
          //�õ���ʼ������Dto

        }
        else if(editType.equals("EDIT"))
        {
          modelNo=Integer.parseInt(httpServletRequest.getParameter("modelNo")) ;
          pathNo = Integer.parseInt(httpServletRequest.getParameter("pathNo"));
          workFlowModelViewHelper.setWfConditionDtoToView(httpServletRequest,modelNo,pathNo);
        }
        else if(editType.equals("SHOW"))
        {
          modelNo=Integer.parseInt(httpServletRequest.getParameter("modelNo")) ;
          pathNo = Integer.parseInt(httpServletRequest.getParameter("pathNo"));
          workFlowModelViewHelper.setWfConditionDtoToView(httpServletRequest,modelNo,pathNo);

        }
        forward = "success";
    }
    catch(UserException usee)
    {
      usee.printStackTrace() ;
      //������Ϣ����
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.queryVerifyLossList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",usee.getErrorMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";
    }
    catch(Exception e)
    {
      e.printStackTrace();
      ActionErrors errors = new ActionErrors();
      ActionError error = new ActionError("title.verifyLossBeforeEdit.queryVerifyLossList");
      errors.add(ActionErrors.GLOBAL_ERROR, error);
      httpServletRequest.setAttribute("errorMessage",e.getMessage()) ;
      saveErrors(httpServletRequest, errors);
      forward = "error";

    }
    finally
    {

    }
    System.out.println("UIWorkFlowModelEditGetFacade forward="+forward);
     
    return actionMapping.findForward(forward);
  }

}