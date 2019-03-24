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
 * Description: 车险理赔定损前查询保单信息系统样本程序
 * @author liubvo
 * @version 1.0
 */
public class UILCertainLossBeforeEditGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示
		String editType = httpServletRequest.getParameter("editType");
		String registNo = ""; // 报案号
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // 用户信息
		if (user == null) {
			user = new UserDto();
		}
		String riskCode = httpServletRequest.getParameter("riskCode");
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
		String forward = ""; // 向前
		try {

			UICodeAction uiCodeAction = new UICodeAction();
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			//start对分户清单案件，如果查勘未处理，抛出异常，要求用户首先进行查勘 add by GYIC张菊卿
			
			String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
			if (riskCode != null && (taskCode.indexOf(riskCode) > -1 || riskCode.startsWith("31") || riskCode.startsWith("32"))) {
			String	registNo1 = httpServletRequest.getParameter("RegistNo"); // 报案号
			if (registNo1 == null || registNo1.trim().length() < 1) {
				registNo1 = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // 报案号
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
				throw new UserException(1, 3, "工作流", "查勘节点没有处理完毕，不可以进行定损的操作");
				}
			}
				
			//end对分户清单案件，如果查勘未处理，抛出异常，要求用户首先进行查勘 add by GYIC张菊卿
			// 尚未加入type异常处理{}、其它必须参数异常处理{}
			if (editType.equals("ADD")) {
				// 查询立案信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("RegistNo"); // 报案号
				if (registNo == null || registNo.trim().length() < 1) {
					registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // 报案号
				}
				if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
					riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
				}

				// ==================================================

				// ==================================================
				// 进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
				// 如果没有flowID和logno则不进行判断。
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				if (flowID != null && logNo != null) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user
							.getUserCode(), user.getUserName());
					if (swfLogDto.getHoldNode() == false) {

						String msg = "案件'" + registNo + "'已经被代码:'" + swfLogDto.getHandlerCode()
								+ "',名称:'" + swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!";
						throw new UserException(1, 3, "工作流", msg);
					}
					// 定损时显示的定损人名称、代码
					httpServletRequest.setAttribute("handlerName", swfLogDto.getHandlerName());
					httpServletRequest.setAttribute("handlerCode", swfLogDto.getHandlerCode());
				}
				// ===============================================
				DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
				// 已经到核价、核损的案件再能在处理
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
					// 设置出险时保单的承保数量，农险使用（种植险没有定损），用来控制赔付数量不能超过保单的总数量
					agriCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo);
				} else if ("D".equals(strRiskType)){
					dAACertainLossViewHelper.registDtoToView(httpServletRequest, registNo, editType);
				}

				// 农险增加与赔付数量对应的单位信息
				if("I".equals(strRiskType) || "H".equals(strRiskType)) {
					dAACertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode);	
				}
			}

			if (editType.equals("EDIT") || editType.equals("SHOW")) {
				// 查询定损信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); // 报案号
				if (registNo == null || registNo.trim().length() < 1) {
					registNo = httpServletRequest.getParameter("RegistNo"); // 报案号
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
					// 设置出险时保单的承保数量，农险使用（种植险没有定损），用来控制赔付数量不能超过保单的总数量
					agriCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo);
				} else if ("D".equals(strRiskType)) {
					dAACertainLossViewHelper.certainLossDtoView(httpServletRequest, registNo,
							editType);
				}
				
				// 农险增加与赔付数量对应的单位信息
				if("I".equals(strRiskType) || "H".equals(strRiskType)) {
					dAACertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode);	
				}
				
				// 人伤定损时显示定损人员
				String flowID = httpServletRequest.getParameter("swfLogFlowID");
				String logNo = httpServletRequest.getParameter("swfLogLogNo");
				if (flowID != null && logNo != null && editType.equals("EDIT")) {
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					SwfLogDto swfLogDto = new SwfLogDto();
					swfLogDto = uiWorkFlowAction.holdNode(flowID, Integer.parseInt(logNo), user
							.getUserCode(), user.getUserName());
					// 定损时显示的定损人名称、代码
					httpServletRequest.setAttribute("handlerName", swfLogDto.getHandlerName());
					httpServletRequest.setAttribute("handlerCode", swfLogDto.getHandlerCode());
				}
			}
			/**大户地图信息显示控制*/
		      if(AppConfig.get("sysconst.GIS_FAMILY_RISKCODE").indexOf(riskCode)>-1
		    		  /*SysConfig.getProperty("PLNATING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| SysConfig.getProperty("BREEDING_FARMER_LIST_FLAG").indexOf(riskCode)>-1
						|| "3139,3141".indexOf(riskCode)>-1*/){
		    	  /**获得大户信息*/
		    	  UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
		    	  Collection collection = uiPrpLregistRPolicyAction.findByConditions(" Registno = '"+ registNo +"' ");
		    	  if(collection.size()>0){
		    		  PrpLRegistRPolicyDto prpLregistRPolicyDto = (PrpLRegistRPolicyDto)collection.iterator().next();
			    	  String gisPolicyNo = prpLregistRPolicyDto.getPolicyNo();
			    	  UIRegistAction uiRegistAction = new UIRegistAction();
		              RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			    	  EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		                //modify by lym 20060605 for 强三 --start
						PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
								gisPolicyNo, registDto.getPrpLregistDto()
										.getDamageStartDate().toString(), registDto
										.getPrpLregistDto().getDamageStartHour());
			    	  String strRichFlyCode = policyDto.getPrpCmainDto().getRichFlyCode();
			    	  /**大户*/
			    	  httpServletRequest.setAttribute("GisRichFlyCode", strRichFlyCode);
			    	  /**报案号*/
			    	  httpServletRequest.setAttribute("GisRegistNo", registNo);
			    	  /**是否显示地图信息按钮*/
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

			// 已暂存查勘任务的放弃处理
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
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
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
