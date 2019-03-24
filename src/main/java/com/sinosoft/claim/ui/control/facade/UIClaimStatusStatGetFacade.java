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
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET ����ڵ�״̬��ѯ
 * <p>Title: ��������ڵ�״̬ѯ��Ϣ</p>
 * <p>Description: ��������ڵ�״̬��Ϣϵͳ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIClaimStatusStatGetFacade  extends Action
{
  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {
     
    //ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
  	 String riskType   = httpServletRequest.getParameter("riskType"); //add by liuyanmei 20051110
//    String editType   = httpServletRequest.getParameter("editType");
    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String editType   = "EDIT";
    httpServletRequest.setAttribute("editType",editType);
    String userCode = user.getUserCode();
    String nodeType= httpServletRequest.getParameter("nodeType");
    String forward  = "";                                          //��ǰ
    try
    {
      //��δ����type�쳣����{}��������������쳣����{}
      if (editType.equals("ADD") || editType.equals("EDIT") ||editType.equals("SHOW"))
      {
        //��ѯ����ڵ�״̬��Ϣ,�������룬���ڳ�ʼ������ʾ
        //DAAClaimStatusViewHelper dAAClaimStatusViewHelper = new DAAClaimStatusViewHelper();
        //dAAClaimStatusViewHelper.getClaimStatsStat(httpServletRequest,userCode,nodeType);
        WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
        workFlowViewHelper.getWorkFLowNodeStatsStat(httpServletRequest,user,nodeType);

        forward = "success";

      }
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
     
    return actionMapping.findForward(forward);
  }

}
