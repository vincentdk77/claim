package com.sinosoft.claim.ui.control.facade;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.domain.SwfConditionDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowModelAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowModelViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * ������ģ����������
 * <p>Title: ������ģ����������</p>
 * <p>Description: ������ģ����������</p>
 * <p>Copyright: Copyright (c) 2004-08-10</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */

public class UIWorkFlowModelCondEditPostFacade  extends Action
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
    SwfConditionDto swfCondition = null;
    UIWorkFlowModelAction uiWorkFlowModelAction = null;
    int modelNo = 0 ;//ģ���
    editType = httpServletRequest.getParameter("editType") ;
    System.out.println("######editType=" + editType + "###########");
    try
    {
        if(editType.equals("ADD"))
        {
          //�õ���ʼ������Dto
          WorkFlowModelViewHelper workFlowModelViewHelper = new WorkFlowModelViewHelper();
          swfCondition =workFlowModelViewHelper.viewSwfConditionToDto(httpServletRequest) ;
          uiWorkFlowModelAction = new UIWorkFlowModelAction();
          uiWorkFlowModelAction.saveWfCondition(swfCondition);
        }
        else if(editType.equals("EDIT"))
        {
          //�õ���ʼ������Dto
          WorkFlowModelViewHelper workFlowModelViewHelper = new WorkFlowModelViewHelper();
          swfCondition =workFlowModelViewHelper.viewSwfConditionToDto(httpServletRequest) ;
          uiWorkFlowModelAction = new UIWorkFlowModelAction();
          uiWorkFlowModelAction.saveWfCondition(swfCondition);

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

