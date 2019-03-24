package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;

/**
 * �ַ�HTTP Post ��������ʵ��༭����
 * <p>
 * Title: ��������ʵ��༭������Ϣ
 * </p>
 * <p>
 * Description: ��������ʵ��༭������Ϣ
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UIL0807CompensateEditQueryFacade extends Action {
	public ActionForward execute(
			ActionMapping actionMapping, 
			ActionForm actionForm,
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; //��ǰ��ת
		try {
			
			String claimNo = httpServletRequest.getParameter("prpLclaimNo"); 
			String registNo = "";
			String swfLogFlowID = "";
			String compensateNo = "";
			int logNo = 1;
			if(claimNo != null){
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
			    registNo = blPrpLclaimFacade.findByPrimaryKey(claimNo).getRegistNo();
			    
			    UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
			    swfLogFlowID = uiworkflowaction.findFlowIDBybusinessNo(claimNo);
			    logNo = uiworkflowaction.getSwfLogMaxLogNo(swfLogFlowID)-1;
			    SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(swfLogFlowID, logNo);
			    if(swfLogDto != null){
			    	if("compe".equals(swfLogDto.getNodeType())){
			    		
			    	}
			    	else{
			    		compensateNo = swfLogDto.getBusinessNo();
			    		if("veric".equals(swfLogDto.getNodeType())){
			    			throw new Exception("������δ���ͨ�����������飡");
			    		}
			    	}
			    	
			    }
			}
			String swfLogLogNo = Integer.toString(logNo); 

			
			ActionMessages messages = new ActionMessages();
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.save"));
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLcompensate.compensateNo"));
			saveMessages(httpServletRequest, messages);
			httpServletRequest.setAttribute("compensateNo", compensateNo);
			httpServletRequest.setAttribute("swfLogLogNo", swfLogLogNo);
			httpServletRequest.setAttribute("swfLogFlowID", swfLogFlowID);
			httpServletRequest.setAttribute("claimNo", claimNo);
			httpServletRequest.setAttribute("registNo", registNo);
			forward = "ADD";
			
		} 
		catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} 
		return actionMapping.findForward(forward);
	}


}   
