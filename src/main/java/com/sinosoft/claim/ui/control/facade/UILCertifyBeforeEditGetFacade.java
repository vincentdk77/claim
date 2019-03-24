package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAACertifyViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * �ַ�HTTP GET �������ⵥ֤ǰ��ѯ��������
 * <p>Title: �������ⵥ֤ǰ��ѯ������Ϣ</p>
 * <p>Description: �������ⵥ֤ǰ��ѯ������Ϣϵͳ��������</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILCertifyBeforeEditGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		String editType = httpServletRequest.getParameter("editType");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String registNo = ""; //������
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); //�û���Ϣ
		String riskCode = "";
		if (user == null)
			riskCode = ""; //����
		else {
			riskCode = user.getRiskCode(); //����	
		}
		String flowID = httpServletRequest.getParameter("swfLogFlowID");
		String logNo = httpServletRequest.getParameter("swfLogLogNo");
		String forward = "";
        Integer modelnoInt = 0;//ģ���
		try {
			//��δ����type�쳣����{}��������������쳣����{}
			if (editType.equals("ADD")) {
				//��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); //�ⰸ��
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
                UIRegistAction uiRegistAction = new UIRegistAction();
                RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
				
				//==================================================
				//����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
				//���û��flowID��logno�򲻽����жϡ�
				UICodeAction uiCodeAction = new UICodeAction();
				String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
				if (flowID != null ) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					modelnoInt = uiWorkFlowAction.getModelNo(riskCode, registDto.getPrpLregistDto().getComCode());

          	       if (modelnoInt.equals(1) ){ 
          	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
         	    	   Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='propc' and nodestatus='4'");
         	    	   Collection noSubmitNodesListclaim=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='claim' and nodestatus='4'");
         	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
         	    	   
         	    	    if (noSubmitNodesList.size()<1) {
         	    	   //��ɵ�������
         	    	    	throw new UserException(1,3,"0000","������"+flowID+"�Ʋ����𻷽�û�н���������¼�뵥֤��");
         	    	    }
         	    	    if (noSubmitNodesListclaim.size()<1) {
              	    	   //��ɵ�������
              	    	    	throw new UserException(1,3,"0000","������"+flowID+"��������û�н���������¼�뵥֤��");
              	    	    }
         	    	    
         	       } 
          	       if (modelnoInt.equals(12)||modelnoInt.equals(14) ){ 
          	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
         	    	   Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='check' and nodestatus='4'");
         	    	   Collection noSubmitNodesListclaim=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='claim' and nodestatus='4'");
         	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
         	    	   
         	    	    if (noSubmitNodesList.size()<1) {
         	    	   //��ɵ�������
         	    	    	throw new UserException(1,3,"0000","������"+flowID+"�鿱����û�н���������¼�뵥֤��");
         	    	    }
         	    	    if (noSubmitNodesListclaim.size()<1) {
              	    	   //��ɵ�������
              	    	    	throw new UserException(1,3,"0000","������"+flowID+"��������û�н���������¼�뵥֤��");
              	    	    }
         	    	    
         	       }
          	       if (modelnoInt.equals(87) ){ 
          	    	   UIWorkFlowAction   uiWorkFlowActioncheck = new UIWorkFlowAction();
         	    	   Collection noSubmitNodesList=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='propv' and nodestatus='4'");
         	    	   Collection noSubmitNodesListclaim=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+flowID +"' and nodeType='claim' and nodestatus='4'");
         	    	    //Collection noSubmitNodesListCheck=uiWorkFlowActioncheck.findNodesByConditions(" flowID='"+swfLogDto.getFlowID() +"' and nodeType='check' and nodestatus<'4'");
         	    	   
         	    	    if (noSubmitNodesList.size()<1) {
         	    	   //��ɵ�������
         	    	    	throw new UserException(1,3,"0000","������"+flowID+"�Ʋ����𻷽�û�н���������¼�뵥֤��");
         	    	    }
         	    	    if (noSubmitNodesListclaim.size()<1) {
              	    	   //��ɵ�������
              	    	    	throw new UserException(1,3,"0000","������"+flowID+"��������û�н���������¼�뵥֤��");
              	    	    }
         	    	    
         	       }
          	     if (logNo != null){
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user.getUserCode(), user
							.getUserName());
					if (swfLogDto.getHoldNode() == false) {
						String msg = "����'" + registNo + "'�Ѿ�������:'" + swfLogDto.getHandlerCode() + "',����:'"
								+ swfLogDto.getHandlerName() + "'���û���ռ��,��ѡ�������������д���!";
						throw new UserException(1, 3, "������", msg);
					}
					if (uiWorkFlowAction.checkFlowClose(flowID)==true) {
						String msg = "����'" + registNo + "�Ѿ�����ע��/����";
						throw new UserException(1, 3, "������", msg);
					}
					
          	     }
				}
				//===============================================

				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
			}
			//���༭��ʱ��
			if (editType.equals("EDIT") || editType.equals("SHOW") || editType.equals("DELETE")) {
				//��ѯ��֤��Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("prpLcertifyCertifyNo"); //��֤��
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
			}
			//�����������嵥��ʱ��
			if (editType.equals("CertifyDirect")) {
				//��ѯ��֤��Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); //��֤��
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
				UICodeAction uicodeAction = new UICodeAction();
				httpServletRequest.setAttribute("riskCode",riskCode);
				String strRiskType = uicodeAction.translateRiskCodetoRiskType(riskCode);
				if ("D".equals(strRiskType)) {
					return actionMapping.findForward("ADDCertifyDirect");
				} else {
					return actionMapping.findForward("ADDOtherCertifyDirect");
				}

			}
			//����ӡ�����嵥��ʱ��
			if (editType.equals("CertifyDirectPrint")) {
				//��ѯ��֤��Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); //��֤��
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
				//add by zhaolu 20060803 start 
				//reason:�ǳ��մ�ӡ������֪�嵥,�ж�����
				UICodeAction uicodeAction = new UICodeAction();
				String strRiskType = uicodeAction.translateRiskCodetoRiskType(riskCode);
				String strRiskName = uicodeAction.translateRiskCode(riskCode,true);
				if ("D".equals(strRiskType))
				return actionMapping.findForward("CertifyDirectPrint");
				else
				{
					httpServletRequest.setAttribute("riskName",strRiskName);
					return actionMapping.findForward("OtherCertifyDirectPrint");
				}
				//add by zhaolu 20060803 end
			}
			//����ӡ�����嵥��ʱ��
			if (editType.equals("CertifyDirectPrintAdd")) {
				//��ѯ��֤��Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); //��֤��
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
				//add by zhaolu 20060807 start
				//reason:�ǳ��մ�ӡ������֪�嵥,�ж�����
				UICodeAction uicodeAction = new UICodeAction();
				String strRiskType = uicodeAction.translateRiskCodetoRiskType(riskCode);
				String strRiskName = uicodeAction.translateRiskCode(riskCode,true);
				if ("D".equals(strRiskType))
				return actionMapping.findForward("CertifyDirectPrintAdd");
				else
				{
					httpServletRequest.setAttribute("riskName",strRiskName);
					return actionMapping.findForward("OtherCertifyDirectPrintAdd");
				}
				//add by zhaolu 20060807 end
			}

			//δ����֤����ķ�������
			if (editType.equals("GIVUP")) {
				//add by huangyunzhong 20051226 ����δ�ݴ���ύ�ĵ�֤����ɾȥ�������ˣ�ʹ�����˿ɼ��ɴ���
				String FlowID = httpServletRequest.getParameter("swfLogFlowID");
				int LogNo = Integer.parseInt((String) httpServletRequest.getParameter("swfLogLogNo"));
				UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID, LogNo);
				if (swfLogDto.getNodeType().equals("certi")) {
					swfLogDto.setHandlerCode("");
					swfLogDto.setHandlerName("");
					swfLogDto.setFlowStatus("1");
				}
				uiworkflowaction.updateFlow(swfLogDto);
				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.giveup"));
				saveMessages(httpServletRequest, messages);
				forward = "success";
				return actionMapping.findForward(forward);
			}

			//ȡ��forward
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "certi", editType, 1);

			saveToken(httpServletRequest);
		} catch (SecurityException usee) {
			usee.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certifyBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (UserException ue) {
		    ue.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certifyBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", ue.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}catch (Exception e) {
			e.printStackTrace();
			//������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certifyBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}
		return actionMapping.findForward(forward);
	}
}
