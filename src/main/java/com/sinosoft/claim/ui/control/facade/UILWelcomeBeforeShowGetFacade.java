package com.sinosoft.claim.ui.control.facade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.viewHelper.UserClaimStatusViewHelper;
import com.sinosoft.claim.ui.view.formbean.LogonForm;

/**
 * �ַ�HTTP��¼����
 * <p>Title: ������������</p>
 * <p>Description: ������������ ��¼facade</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UILWelcomeBeforeShowGetFacade extends Action
{
  public ActionForward execute(ActionMapping actionMapping,ActionForm actionForm,HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception
  {

    LogonForm logonForm = (LogonForm)actionForm;
    UICodeAction uiCodeAction = new UICodeAction();
    String riskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
    UserDto   user      = (UserDto)httpServletRequest.getSession().getAttribute("user");    //�û���Ϣ
    String usercode = user.getUserCode();
    String forward = "false";
    try{

      if ( usercode==null || usercode.trim().equals("") ||riskCode.equals("")||riskCode==null){
        forward = "false"; //��ⲻ���û������ձ���ת����У����Чҳ��
      } else {
        //��ѯ�û�����״̬
        UserClaimStatusViewHelper userClaimStatusViewHelper = new UserClaimStatusViewHelper();
        userClaimStatusViewHelper.getAllStatsStat(httpServletRequest, user);
        forward = "success";  //��¼��ϢУ����Ч
      } 
    } catch(Exception e) {
       e.printStackTrace() ;
    }finally{

    }
    return actionMapping.findForward(forward);
  }
}
