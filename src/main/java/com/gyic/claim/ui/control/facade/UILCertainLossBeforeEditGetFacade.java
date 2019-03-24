package com.gyic.claim.ui.control.facade;

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

import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.dto.domain.PrplcombineDto;
import com.gyic.claim.ui.control.viewHelper.AgriCombineCertainLossViewHelper;
import com.gyic.claim.ui.control.viewHelper.DAACombineCertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.AgriCheckViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACheckViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.SysConfig;
import com.gyic.claim.utils.Utils;;
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

		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // �û���Ϣ
		if (user == null) {
			user = new UserDto();
		}
		String riskCode = httpServletRequest.getParameter("riskCode");
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
		ArrayList<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
		String forward = ""; // ��ǰ
		try {

			UICodeAction uiCodeAction = new UICodeAction();
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			
			// ��δ����type�쳣����{}��������������쳣����{}
		    BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
			String strConditions = "combineNo = '" + httpServletRequest.getParameter("combineNo") + "'";
			Collection combineDtos = bLPrplcombineFacade.findByConditions(strConditions);
			
	      if(!"giveupTemporarySave".equals(httpServletRequest.getParameter("editType"))){
	    	  Iterator iterator = combineDtos.iterator();
		  		int index=0;
		  		while(iterator.hasNext()){
		  			PrplcombineDto prplcombineDto = (PrplcombineDto)iterator.next();
		  			Utils.setSwflogInfoToRequestAccordingRegistNo(httpServletRequest, httpServletRequest.getParameter("nodeType"), 
		  					prplcombineDto.getRegistno(), index, httpServletRequest.getParameter("editType"));
		  			index++;
	  		}
	  		httpServletRequest.setAttribute("combineDtos", combineDtos );
	      }	
			Iterator iterator = combineDtos.iterator();
			
			int index=0;
			while(iterator.hasNext())
			{	
				String registNo = String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)); // ������
				//start�Էֻ��嵥����������鿱δ�����׳��쳣��Ҫ���û����Ƚ��в鿱 add by GYIC�ž���
				String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
				if (riskCode != null && (taskCode.indexOf(riskCode) > -1 || riskCode.startsWith("31") || riskCode.startsWith("32"))) {
				if (registNo == null || registNo.trim().length() < 1) {
					registNo = String.valueOf(httpServletRequest.getAttribute("prpLverifyLossRegistNo_"+index)); // ������
				}
				String conditions = " registno ='" + registNo.trim() + "' and nodeType in ('check') and  nodeStatus < '4'";
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
				String editType = String.valueOf(httpServletRequest.getAttribute("editType_"+index));
				String flowID = String.valueOf(httpServletRequest.getAttribute("swfLogFlowID_"+index));
				String logNo = String.valueOf(httpServletRequest.getAttribute("swfLogLogNo_"+index));
				
				if (editType.equals("ADD")) {
					// ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
					
					if (registNo == null || registNo.trim().length() < 1) {
						registNo = String.valueOf(httpServletRequest.getAttribute("prpLverifyLossRegistNo_"+index)); // ������
					}
					if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
						riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
					}
	
					// ==================================================
	
					// ==================================================
					// ����ռ�ŷ�����ֻ�е��й����������LogNo��ʱ�����ʹ�á�
					// ���û��flowID��logno�򲻽����жϡ�
					
					if (flowID != null && logNo != null) {
						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
						SwfLogDto swfLogDto = new SwfLogDto();
						swfLogDto = uiWorkFlowAction.holdNodeCombine(flowID, Integer.parseInt(logNo), user
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
					DAACombineCertainLossViewHelper dAACombineCertainLossViewHelper = new DAACombineCertainLossViewHelper();
					// �Ѿ����˼ۡ�����İ��������ڴ���
					boolean verifyFlag = false;
					boolean veripFlag = false;
					if ("D".equals(strRiskType)) {
						veripFlag = dAACombineCertainLossViewHelper.checkVerifyLoss(registNo, lossItemCode,
								"verip");
						verifyFlag = dAACombineCertainLossViewHelper.checkVerifyLoss(registNo, lossItemCode,
								"verif");
					} else if ("I".equals(strRiskType) || "H".equals(strRiskType)
							|| "Q".equals(strRiskType) || "Z".equals(strRiskType)
							|| "Y".equals(strRiskType)) {
						verifyFlag = dAACombineCertainLossViewHelper.checkVerifyLoss(registNo, lossItemCode,
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
					AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
					if ("I".equals(strRiskType) || "H".equals(strRiskType) || "Q".equals(strRiskType)
							|| "Z".equals(strRiskType) || "Y".equals(strRiskType)) {
						agriCombineCertainLossViewHelper.registDtoToView(httpServletRequest, registNo,
								editType,index);
						// ���ó���ʱ�����ĳб�������ũ��ʹ�ã���ֲ��û�ж��𣩣����������⸶�������ܳ���������������
						agriCombineCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo,index);
					} else if ("D".equals(strRiskType)){
						//����������ʱ����dAACertainLossViewHelper.registDtoToView(httpServletRequest, registNo, editType);
					}
	
					// ũ���������⸶������Ӧ�ĵ�λ��Ϣ
					if("I".equals(strRiskType) || "H".equals(strRiskType)) {
						dAACombineCertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode,index);	
					}	
				}
				if (editType.equals("EDIT") || editType.equals("SHOW")) {
					// ��ѯ������Ϣ,�������룬���ڳ�ʼ������ʾ
					
					if (registNo == null || registNo.trim().length() < 1) {
						registNo = String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)); // ������
					}

					if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
						riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo_"+index);
					}
					DAACombineCertainLossViewHelper dAACombineCertainLossViewHelper = new DAACombineCertainLossViewHelper();
					AgriCombineCertainLossViewHelper agriCombineCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
					if ("I".equals(strRiskType) || "H".equals(strRiskType) || "Q".equals(strRiskType)
							|| "Z".equals(strRiskType) || "Y".equals(strRiskType)) {
						agriCombineCertainLossViewHelper.certainLossDtoView(httpServletRequest, registNo,
								editType,index);
						// ���ó���ʱ�����ĳб�������ũ��ʹ�ã���ֲ��û�ж��𣩣����������⸶�������ܳ���������������
						agriCombineCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo,1);
					} else if ("D".equals(strRiskType)) {
						//����������ʱ����dAACertainLossViewHelper.certainLossDtoView(httpServletRequest, registNo,
						//����������ʱ����		editType);
					}
					
					// ũ���������⸶������Ӧ�ĵ�λ��Ϣ
					if("I".equals(strRiskType) || "H".equals(strRiskType)) {
						dAACombineCertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode,index);	
					}
					
					// ���˶���ʱ��ʾ������Ա

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
			if ("giveupTemporarySave".equals(httpServletRequest.getParameter("editType"))) {
		          String FlowID = String.valueOf(httpServletRequest.getParameter("swfLogFlowID_"+index));
		          int  LogNo=Integer.parseInt(String.valueOf(httpServletRequest.getParameter("swfLogLogNo_"+index)));
		          UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
		          SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(FlowID,LogNo);
		          if(swfLogDto.getNodeStatus().equals("2")){
		          swfLogDto.setHandlerCode("");
		          swfLogDto.setHandlerName("");
		          swfLogDto.setNodeStatus("0");
		          swfLogDto.setFlowStatus("1");
		             }
		          else if(swfLogDto.getNodeStatus().equals("0")){
		        	  swfLogDto.setHandlerCode("");
			          swfLogDto.setHandlerName("");
			          swfLogDto.setFlowStatus("1");
		          }
		          else
		        	  throw new UserException(1,3,"������","");
		          swfLogDtoList.add(swfLogDto);
				}
			iterator.next();
			index++;
			}
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "certa", "ADD",
					intLossItemCode);
			if(swfLogDtoList != null && swfLogDtoList.size()>0){
				UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				uiworkflowaction.updateFlow(swfLogDtoList);
		        ActionMessages messages = new ActionMessages();
		        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
		        "prompt.compensate.giveup"));
		        saveMessages(httpServletRequest, messages);
		        forward = "success";
		        return actionMapping.findForward(forward);
			}
			//������������if (editType.equals("SelectLossType")) {
			//������������	forward = "SelectLossType";
			//������������}
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
		}
		return actionMapping.findForward(forward);
	}
}
