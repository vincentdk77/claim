package com.sinosoft.claim.ui.control.facade;

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

import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.ui.control.action.UILogonAction;

/**
 * �޸��û���¼����
 * <p>Title: �޸ĵ�¼����</p>
 * <p>Description: �޸��������Ա��¼����</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author wangwei
 * @version 1.0
 */

public class UIUpdatePwdFacade extends Action {
    public ActionForward execute(ActionMapping actionMapping,
                           ActionForm actionForm,
                           HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse) throws Exception {
    	String forward = "";
    	try {
    		String userCode    = httpServletRequest.getParameter("userCode");
        	String oldPassword = httpServletRequest.getParameter("oldPassword");
        	String newPassword = httpServletRequest.getParameter("newPassword");
        	UILogonAction uiLogonAction = new UILogonAction();
        	PrpDuserDto prpDuserDto = (PrpDuserDto) uiLogonAction.checkUser(userCode, oldPassword);
        	
        	if (prpDuserDto != null) {
        		prpDuserDto.setPassword(newPassword);
        	    uiLogonAction.updatePwd(prpDuserDto);      //�޸�����
        	    
        	    //���������޸ĳɹ���ʾ��Ϣ
        	    ActionMessages messages = new ActionMessages();
        	    messages.add( ActionMessages.GLOBAL_MESSAGE, new ActionMessage("update.password.success"));
        	    saveMessages( httpServletRequest, messages );
      	        forward = "success";
        	} else {
        		
        		//���������޸�ʧ����Ϣ
        		ActionErrors errors = new ActionErrors();
      	        ActionError error = new ActionError("update.password.false");
      	        errors.add(ActionErrors.GLOBAL_ERROR, error);
      	        saveErrors(httpServletRequest, errors);
      	        forward = "error";
        	}
    	}  catch(Exception usee) {
    		
    	      //������Ϣ����
    	      ActionErrors errors = new ActionErrors();
    	      ActionError error = new ActionError("update.password.false");
    	      errors.add(ActionErrors.GLOBAL_ERROR, error);
    	      saveErrors(httpServletRequest, errors);
    	      forward = "error";
    	 } finally {
    	 }
    	return actionMapping.findForward(forward);
    }
}