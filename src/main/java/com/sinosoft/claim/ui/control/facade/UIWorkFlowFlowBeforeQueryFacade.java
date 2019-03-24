package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.claim.dto.custom.UserDto;

/**
 * �ַ�HTTP GET ���������̲�ѯ
 * <p>Title: ���������̲�ѯ</p>
 * <p>Description: ���������̲�ѯ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author weishixin
 * @version 1.0
 */
public class UIWorkFlowFlowBeforeQueryFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ

		String forward = ""; //��ǰ
		String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //ҵ���
		//֧������ͨ�����������Ӳ�ѯ��ع�������ͼ add by chu 20130828
		if(swfLogFlowID==null||"".equals(swfLogFlowID)){
			String rigistNo = httpServletRequest.getParameter("registNo");
			Collection collection = new BLSwfLogFacade().findByConditions(" registNo='"+rigistNo+"'");
			if(collection==null||collection.isEmpty()){
				collection= new BLSwfLogStoreFacade().findByConditions(" registNo='"+rigistNo+"'");
			}
			if(collection!=null&&!collection.isEmpty()){
				SwfLogDto swfLogDto =  (SwfLogDto) collection.iterator().next();
				swfLogFlowID = swfLogDto.getFlowID();
			}
		}
		
		UserDto ecmUser = new UserDto();
		
		ecmUser.setComCode(httpServletRequest.getParameter("comCodeEcm"));
		ecmUser.setUserName(httpServletRequest.getParameter("userNameEcm"));
		ecmUser.setUserCode(httpServletRequest.getParameter("userCodeEcm"));
		ecmUser.setComName(httpServletRequest.getParameter("comNameEcm"));
		
		httpServletRequest.setAttribute("userEcm", ecmUser);
		//�ж�IE�汾�Ƿ�֧��svg
		httpServletRequest.setAttribute("svgFlag", httpServletRequest.getParameter("svgFlag"));
		System.out.println("========"+httpServletRequest.getParameter("svgFlag"));
		//֧������ͨ�����������Ӳ�ѯ��ع�������ͼ add by chu 20130828 end
		try {

			//���ݱ����Ų�ѯ����������Ϣ
			
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			workFlowViewHelper.setFlowDtoToView(httpServletRequest,
					swfLogFlowID);	
			
		/*	//added by zhangli 20070424 ���ӹ��������й�֧������Ϣ�򣬷ǽڵ�			
			//�õ�policyNo********��compensatePolicyNo��*********
			
			
			String policyNo = "";			
			String registNo = (String)httpServletRequest.getAttribute("registNo");		
			 com.sinosoft.claim.ui.control.action.UIRegistAction uIRegistAction = 
				 new  com.sinosoft.claim.ui.control.action.UIRegistAction();
			 RegistDto registDto = uIRegistAction.findByPrimaryKey(registNo);
			 policyNo = registDto.getPrpLclaimStatusDto().getPolicyNo();
			//�õ�������������********����**********
			String insuredName = uiCompensateAction.fetchInsuredName(policyNo);
			httpServletRequest.setAttribute("compensateInsuredName", insuredName);
			
			//�õ��Ƿ�����Լ�����ܽ��			
			double realPayreffee =
				uiCompensateAction.compensatePaymentResult(httpServletRequest, registNo,policyNo);			   
			//�ж���δ֧��������֧�� ******��payed��******
			if(realPayreffee>0){
				httpServletRequest.setAttribute("payed","true" );
			}
			 
			//�ж�����ܽ�� *****��realPayreffee��****
			httpServletRequest.setAttribute("realPayreffee", Double.toString(realPayreffee));
			//�õ��������֧������******* ��compensatePayDate��********
			String compensateFinalPayDate = uiCompensateAction.fetchPayCompensateFinalDate(registNo,policyNo);
			httpServletRequest.setAttribute("compensatePayDate", compensateFinalPayDate);*/
			forward = "success";
			System.out.println("forward=" + forward);
		} catch (UserException usee) {
			usee.printStackTrace();
			//������Ϣ����
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (Exception e) {
			e.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.registBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
