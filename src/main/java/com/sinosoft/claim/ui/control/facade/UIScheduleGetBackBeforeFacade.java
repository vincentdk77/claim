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
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAScheduleViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
/**
 * �ַ�HTTP GET ������Ƚڵ�ĸ�������
 * <p>Title: ������Ƚڵ���µĸ�������</p>
 * <p>Description: ������Ƚڵ�ĸ�������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */

public class UIScheduleGetBackBeforeFacade  extends Action
{

  public ActionForward execute(ActionMapping actionMapping,
                               ActionForm actionForm,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse)
  throws Exception
  {

   /** 4����ѯ����ȡ������
     * 5����ѯ���ȳ�������
     * 6����ѯ���ȵ�������Ϣ
    **/

    UserDto   user     = (UserDto)httpServletRequest.getSession().getAttribute("user");
    String userCode = user.getUserCode();

     String forward  = "";
     String registNo="";
                                        //��ǰ
    String editType     = httpServletRequest.getParameter("editType");
    try
    {
       
        UICodeAction uiCodeAction = new UICodeAction();
        String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
       //1������¼��Ľ���չ��
       //����λ��:��������Ǽ� ->�°�����ʾ�����б���ѡ��һ������->��ʾ����������Ϣ
      //8��������Ϣȡ����ϸ��ʾ
      //����λ��:����ȡ������ ->�����б���ѡ��һ������->��ʾ������ĵ���������Ϣ
       if(editType.equals("GETBACKEDIT"))
        {
        registNo = (String)httpServletRequest.getParameter("prpLscheduleMainWFRegistNo");     //������
        DAAScheduleViewHelper dAAScheduleViewHelper = new DAAScheduleViewHelper();
        dAAScheduleViewHelper.scheduleDtoToView(httpServletRequest,registNo,editType,"1");
        forward = "EDITDAA";
        //System.out.println(forward+"forward��Ϣȡ��");
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
