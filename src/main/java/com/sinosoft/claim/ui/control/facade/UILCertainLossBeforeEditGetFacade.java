package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriCertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.AgriCheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConfig;

/**
 * Description: �������ⶨ��ǰ��ѯ������Ϣϵͳ��������
 * @author liubvo
 * @version 1.0
 */
public class UILCertainLossBeforeEditGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		// ҵ�����ͣ�ADD-���� EDIT-�޸� SHOW-��ʾ
		String editType = httpServletRequest.getParameter("editType");
		String registNo = ""; // ������
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // �û���Ϣ
		if (user == null) {
			user = new UserDto();
		}
		String riskCode = httpServletRequest.getParameter("riskCode");
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
		String forward = ""; // ��ǰ
		try {

			UICodeAction uiCodeAction = new UICodeAction();
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			//start�Էֻ��嵥����������鿱δ�����׳��쳣��Ҫ���û����Ƚ��в鿱 add by GYIC�ž���
			
			String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
			if (riskCode != null && (taskCode.indexOf(riskCode) > -1 || riskCode.startsWith("31") || riskCode.startsWith("32"))) {
			String	registNo1 = httpServletRequest.getParameter("RegistNo"); // ������
			if (registNo1 == null || registNo1.trim().length() < 1) {
				registNo1 = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // ������
			}
			String conditions = " registno ='" + registNo1.trim() + "' and nodeType in ('check') and  nodeStatus < '4'";
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			Collection swfLogList = new ArrayList();
			Iterator it = null;
			String nodeMsg = "";
			int checkCount = 0;
			swfLogList = uiWorkFlowAction.findNodesByConditions(conditions);
			it = swfLogList.iterator();
			while (it.hasNext()) {
				SwfLogDto swfLogDto = new SwfLogDto();
				swfLogDto = (SwfLogDto) it.next();
				nodeMsg = nodeMsg + swfLogDto.getNodeName() + ",";
				checkCount++;
			}
			if (checkCount > 0) {
				throw new UserException(1, 3, "������", "�鿱�ڵ�û�д�����ϣ������Խ��ж���Ĳ���");
				}
			}
				
			//end�Էֻ��嵥����������鿱δ�����׳��쳣��Ҫ���û����Ƚ��в鿱 add by GYIC�ž���
			// ��δ����type�쳣����{}��������������쳣����{}
			if (editType.equals("ADD")) {
				// ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("RegistNo"); // ������
				if (registNo == null || registNo.trim().length() < 1) {
					registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // ������
				}
				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
				}

				// ==================================================

				// ==================================================
				// ����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
				// ���û��flowID��logno�򲻽����жϡ�
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user
							.getUserCode(), user.getUserName());
					if (swfLogDto.getHoldNode() == false) {

						String msg = "����'" + registNo + "'�Ѿ�������:'" + swfLogDto.getHandlerCode()
								+ "',����:'" + swfLogDto.getHandlerName() + "'���û���ռ��,��ѡ�������������д���!";
						throw new UserException(1, 3, "������", msg);
					}
					// ����ʱ��ʾ�Ķ��������ơ�����
					httpServletRequest.setAttribute("handlerName", swfLogDto.getHandlerName());
					httpServletRequest.setAttribute("handlerCode", swfLogDto.getHandlerCode());
				}
				// ===============================================
				DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
				// �Ѿ����˼ۡ�����İ��������ڴ���
				boolean verifyFlag = false;
				boolean veripFlag = false;
				if ("D".equals(strRiskType)) {
					veripFlag = dAACertainLossViewHelper.checkVerifyLoss(registNo, lossItemCode,
							"verip");
					verifyFlag = dAACertainLossViewHelper.checkVerifyLoss(registNo, lossItemCode,
							"verif");
				} else if ("I".equals(strRiskType) || "H".equals(strRiskType)
						|| "Q".equals(strRiskType) || "Z".equals(strRiskType)
						|| "Y".equals(strRiskType)) {
					verifyFlag = dAACertainLossViewHelper.checkVerifyLoss(registNo, lossItemCode,
							"verif");
				}
				if (veripFlag == true) {
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
							"title.certainLossToVerifyPrice.titleName"));
					saveMessages(httpServletRequest, messages);
					return actionMapping.findForward("success");
				}
				if (verifyFlag == true) {
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
							"title.certainLossToVerify.titleName"));
					saveMessages(httpServletRequest, messages);
					return actionMapping.findForward("success");
				}
				AgriCertainLossViewHelper agriCertainLossViewHelper = new AgriCertainLossViewHelper();
				if ("I".equals(strRiskType) || "H".equals(strRiskType) || "Q".equals(strRiskType)
						|| "Z".equals(strRiskType) || "Y".equals(strRiskType)) {
					agriCertainLossViewHelper.registDtoToView(httpServletRequest, registNo,
							editType);
					// ���ó���ʱ�����ĳб�������ũ��ʹ�ã���ֲ��û�ж��𣩣����������⸶�������ܳ���������������
					agriCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo);
				} else if ("D".equals(strRiskType)){
					dAACertainLossViewHelper.registDtoToView(httpServletRequest, registNo, editType);
				}

				// ũ���������⸶������Ӧ�ĵ�λ��Ϣ
				if("I".equals(strRiskType) || "H".equals(strRiskType)) {
					dAACertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode);	
				}
			}

			if (editType.equals("EDIT") || editType.equals("SHOW")) {
				// ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
				registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // ������
				if (registNo == null || registNo.trim().length() < 1) {
					registNo = httpServletRequest.getParameter("RegistNo"); // ������
				}

				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
				}
				DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
				AgriCertainLossViewHelper agriCertainLossViewHelper = new AgriCertainLossViewHelper();
				if ("I".equals(strRiskType) || "H".equals(strRiskType) || "Q".equals(strRiskType)
						|| "Z".equals(strRiskType) || "Y".equals(strRiskType)) {
					agriCertainLossViewHelper.certainLossDtoView(httpServletRequest, registNo,
							editType);
					// ���ó���ʱ�����ĳб�������ũ��ʹ�ã���ֲ��û�ж��𣩣����������⸶�������ܳ���������������
					agriCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo);
				} else if ("D".equals(strRiskType)) {
					dAACertainLossViewHelper.certainLossDtoView(httpServletRequest, registNo,
							editType);
				}
				
				// ũ���������⸶������Ӧ�ĵ�λ��Ϣ
				if("I".equals(strRiskType) || "H".equals(strRiskType)) {
					dAACertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode);	
				}
				
				// ���˶���ʱ��ʾ������Ա
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				if (flowID != null && logNo != null && editType.equals("EDIT")) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user
							.getUserCode(), user.getUserName());
					// ����ʱ��ʾ�Ķ��������ơ�����
					httpServletRequest.setAttribute("handlerName", swfLogDto.getHandlerName());
					httpServletRequest.setAttribute("handlerCode", swfLogDto.getHandlerCode());
				}
			}
			/**�󻧵�ͼ��Ϣ��ʾ����*/
		      if(AppConfig.get("sysconst.GIS_FAMILY_RISKCODE").indexOf(riskCode)>-1
		    		  /*SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| "3139,3141".indexOf(riskCode)>-1*/){
		    	  /**��ô���Ϣ*/
		    	  UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		    	  Collection collection = uiPrpLregistRPolicyAction.findByConditions(" Registno = '"+ registNo +"' ");
		    	  if(collection.size()>0){
		    		  PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)collection.iterator().next();
			    	  String gisPolicyNo = prpLregistRPolicyDto.getPolicyNo();
			    	  UIRegistAction uiRegistAction = new UIRegistAction();
		              RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			    	  EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		                //modify by lym 20060605 for ǿ�� --start
						PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
								gisPolicyNo, registDto.getPrpLregistDto()
										.getDamageStartDate().toString(), registDto
										.getPrpLregistDto().getDamageStartHour());
			    	  String strRichFlyCode = policyDto.getPrpCmainDto().getRichFlyCode();
			    	  /**��*/
			    	  httpServletRequest.setAttribute("GisRichFlyCode", strRichFlyCode);
			    	  /**������*/
			    	  httpServletRequest.setAttribute("GisRegistNo", registNo);
			    	  /**�Ƿ���ʾ��ͼ��Ϣ��ť*/
			    	  if(!"".equals(strRichFlyCode)){
			    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "1");
			    	  }else{
			    		  httpServletRequest.setAttribute("IsDisplayGisViewInfo", "0");
			    	  }
			    		  
		    	  }
		      }
			
			httpServletRequest.setAttribute("riskCode", riskCode);
			String nodeStatus = httpServletRequest.getParameter("status");
			int count = 0;
			if ("3".equals(nodeStatus))
				count = 1;

			if (count == 0) {
				httpServletRequest.setAttribute("prplCertianLossFirst", "First");
			} else {
				httpServletRequest.setAttribute("prplCertianLossFirst", "NotFirst");
			}

			// ���ݴ�鿱����ķ�������
			if (editType.equals("giveupTemporarySave")) {
				String FlowID = httpServletRequest.getParameter("swfLogFlowID");
				int LogNo = Integer.parseInt((String) httpServletRequest
						.getParameter("swfLogLogNo"));
				UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID, LogNo);
				if (swfLogDto.getNodeType().equals("certa")) {
					swfLogDto.setHandlerCode("");
					swfLogDto.setHandlerName("");
					swfLogDto.setNodeStatus("0");
					swfLogDto.setFlowStatus("1");
				}
				uiworkflowaction.updateFlow(swfLogDto);

				ActionMessages messages = new ActionMessages();
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.compensate.giveup"));
				saveMessages(httpServletRequest, messages);
				forward = "success";
				return actionMapping.findForward(forward);
			}
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "certa", editType,
					intLossItemCode);
			if (editType.equals("SelectLossType")) {
				forward = "SelectLossType";
			}
			saveToken(httpServletRequest);
		} catch (UserException usee) {
			usee.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// ������Ϣ����
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
			System.out.println(" excetption");
		}
		return actionMapping.findForward(forward);
	}
}
