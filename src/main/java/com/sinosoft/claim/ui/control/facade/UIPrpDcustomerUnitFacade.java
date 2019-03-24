/*
 * Created on 2005-5-24
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.sinosoft.claim.ui.control.facade;

/**
 * @author qinyongli
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.platform.dto.domain.PrpDuserDto;
import com.sinosoft.platform.ui.control.action.IConstants;
import com.sinosoft.platform.ui.control.action.ProcessUtils;
import com.sinosoft.sysframework.common.util.ParamUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
public class UIPrpDcustomerUnitFacade extends Action{
	public ActionForward execute(ActionMapping actionMapping,
            ActionForm actionForm, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		
		String forward = "";
		
		try{
	        ParamUtils paramUtils = new ParamUtils(request);
	        String actionType = paramUtils.getParameter("actionType");
	        String taskCode = paramUtils.getParameter("taskCode");
	        //��ȡ�û�
	        HttpSession session = request.getSession();
	        UserDto userDto = (UserDto) (session.getAttribute("user"));
	        
	        PrpDuserDto prpDuserDto = new PrpDuserDto();
	        
	        prpDuserDto.setComCode(userDto.getComCode());
	        prpDuserDto.setUserCode(userDto.getUserCode());
	        prpDuserDto.setUserName(userDto.getUserName());
	        	        
	        String userCode = userDto.getUserCode();
	        forward = IConstants.INVALID;
	        //����actionʵ��
	        com.sinosoft.claim.ui.control.action.UIPrpDcustomerUnitAction action = new com.sinosoft.claim.ui.control.action.UIPrpDcustomerUnitAction();
	        ProcessUtils processUtils = new ProcessUtils();
	        //������Զ���ķ�������ʹ��else if��֧���룬Ҫע����Ȩ��
	        if (actionType == null || actionType.trim().equals("")) {
	            forward = IConstants.INVALID;
	        } else {
	            forward = processUtils.generalExcecte(request, response, action,
	                 actionType, prpDuserDto, taskCode, forward);
	        }
		}
        catch(UserException ue)
	    {
	        ue.printStackTrace();
    		//������Ϣ����			
	        request.setAttribute("EXCEPTION", ue);
		    forward = "userError";			
	    }
        catch(Exception e)
	    {
	      e.printStackTrace();
	      ActionErrors errors = new ActionErrors();
	      ActionError error = new ActionError("title.claimBeforeEdit.queryClaimList");
	      errors.add(ActionErrors.GLOBAL_ERROR, error);
	      request.setAttribute("errorMessage",e.getMessage()) ;
	      saveErrors(request, errors);
	      forward = "error";

	    }
	    finally
	    {

	    }
		
	    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+forward);
        return (actionMapping.findForward(forward));
    }

}
