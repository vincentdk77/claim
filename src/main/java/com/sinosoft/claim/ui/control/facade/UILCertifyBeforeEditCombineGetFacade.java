package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
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

import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.bl.facade.BLSwfLogFacade;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBSwfLog;
import com.sinosoft.claim.ui.control.action.UICodeAction;
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
public class UILCertifyBeforeEditCombineGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		//ҵ�����ͣ�ADD-����  EDIT-�޸�  SHOW-��ʾ
		String editType = httpServletRequest.getParameter("editType");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String combineNo = httpServletRequest.getParameter("combineNo"); //�¹ʺ�
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

		try {
			//��δ����type�쳣����{}��������������쳣����{}
			if (editType.equals("ADD")) {
				//��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); //�ⰸ��

				//==================================================
				//����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
				//���û��flowID��logno�򲻽����жϡ�
				
				BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
				ArrayList prplcombineDtoList = (ArrayList)bLPrplcombineFacade.findByConditions(" combineNo='"+combineNo+"'");
				httpServletRequest.setAttribute("combineNo",combineNo);
				httpServletRequest.setAttribute("prplcombineDtoList",prplcombineDtoList);
				for(int i=0;i <prplcombineDtoList.size();i++){
					
					PrplcombineDto prplcombineDto = (PrplcombineDto)prplcombineDtoList.get(i);
					UIWorkFlowAction uiWorkFlowActionCheck = new UIWorkFlowAction();
					String conditions = " registNo = '"+prplcombineDto.getRegistno()+"' and nodeType = 'certi' and nodestatus !='4'";
					Collection swfLogCollection = null;
					swfLogCollection = uiWorkFlowActionCheck.findNodesByConditions(conditions);
					if(null == swfLogCollection || swfLogCollection.size()!=1)
						throw new Exception ("�ڵ��쳣,�����ţ�"+prplcombineDto.getRegistno());

					BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
					 SwfLogDto swfLogDtoCombine = bLSwfLogFacade.findByRegistNo(prplcombineDto.getRegistno());
					 if(swfLogDtoCombine == null)throw new UserException(1, 3, "������", "������"+prplcombineDto.getRegistno()+"�޶�Ӧ������");
					if (swfLogDtoCombine.getFlowID() != null ) {
						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
						SwfLogDto swfLogDto = new SwfLogDto();
						swfLogDto = uiWorkFlowAction.holdNodeCombine(swfLogDtoCombine.getFlowID(), swfLogDtoCombine.getLogNo(), user.getUserCode(), user
								.getUserName());
						if (swfLogDto.getHoldNode() == false) {
							String msg = "����'" + swfLogDtoCombine.getRegistNo() + "'�Ѿ�������:'" + swfLogDto.getHandlerCode() + "',����:'"
									+ swfLogDto.getHandlerName() + "'���û���ռ��,��ѡ�������������д���!";
							throw new UserException(1, 3, "������", msg);
						}
						if (uiWorkFlowAction.checkFlowClose(swfLogDtoCombine.getFlowID())==true) {
							String msg = "����'" + swfLogDtoCombine.getRegistNo() + "�Ѿ�����ע��/����";
							throw new UserException(1, 3, "������", msg);
						}
					}
				}
				//===============================================

				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
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
				 ArrayList<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
				 UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				//add by huangyunzhong 20051226 ����δ�ݴ���ύ�ĵ�֤����ɾȥ�������ˣ�ʹ�����˿ɼ��ɴ���
				//String FlowID = httpServletRequest.getParameter("swfLogFlowID");
				//int LogNo = Integer.parseInt((String) httpServletRequest.getParameter("swfLogLogNo"));
				BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
				ArrayList prplcombineDtoList = (ArrayList)bLPrplcombineFacade.findByConditions(" combineNo='"+combineNo+"'");
				for(int i=0;i <prplcombineDtoList.size();i++){
					PrplcombineDto prplcombineDto = (PrplcombineDto)prplcombineDtoList.get(i);
					BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
					 SwfLogDto swfLogDtoCombine = bLSwfLogFacade.findByRegistNo(prplcombineDto.getRegistno());
					 if(swfLogDtoCombine == null)throw new UserException(1, 3, "������", "������"+prplcombineDto.getRegistno()+"�޶�Ӧ������");
					
					SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(swfLogDtoCombine.getFlowID(), swfLogDtoCombine.getLogNo());
					if (swfLogDto.getNodeType().equals("certi")) {
						swfLogDto.setHandlerCode("");
						swfLogDto.setHandlerName("");
						swfLogDto.setFlowStatus("1");
					}
					swfLogDtoList.add(swfLogDto);
				}
				uiworkflowaction.updateFlow(swfLogDtoList);
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
