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
 * Description: 车险理赔定损前查询保单信息系统样本程序
 * @author liubvo
 * @version 1.0
 */
public class UILCertainLossBeforeEditGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		// 业务类型：ADD-新增 EDIT-修改 SHOW-显示

		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); // 用户信息
		if (user == null) {
			user = new UserDto();
		}
		String riskCode = httpServletRequest.getParameter("riskCode");
		String lossItemCode = httpServletRequest.getParameter("lossItemCode");
		int intLossItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
		ArrayList<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
		String forward = ""; // 向前
		try {

			UICodeAction uiCodeAction = new UICodeAction();
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			
			// 尚未加入type异常处理{}、其它必须参数异常处理{}
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
				String registNo = String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)); // 报案号
				//start对分户清单案件，如果查勘未处理，抛出异常，要求用户首先进行查勘 add by GYIC张菊卿
				String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
				if (riskCode != null && (taskCode.indexOf(riskCode) > -1 || riskCode.startsWith("31") || riskCode.startsWith("32"))) {
				if (registNo == null || registNo.trim().length() < 1) {
					registNo = String.valueOf(httpServletRequest.getAttribute("prpLverifyLossRegistNo_"+index)); // 报案号
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
					throw new UserException(1, 3, "工作流", "查勘节点没有处理完毕，不可以进行定损的操作");
					}
				}

				//end对分户清单案件，如果查勘未处理，抛出异常，要求用户首先进行查勘 add by GYIC张菊卿
				String editType = String.valueOf(httpServletRequest.getAttribute("editType_"+index));
				String flowID = String.valueOf(httpServletRequest.getAttribute("swfLogFlowID_"+index));
				String logNo = String.valueOf(httpServletRequest.getAttribute("swfLogLogNo_"+index));
				
				if (editType.equals("ADD")) {
					// 查询立案信息,整理输入，用于初始界面显示
					
					if (registNo == null || registNo.trim().length() < 1) {
						registNo = String.valueOf(httpServletRequest.getAttribute("prpLverifyLossRegistNo_"+index)); // 报案号
					}
					if (riskCode == null || riskCode.length() < 1 || riskCode.trim().equals("")) {
						riskCode = BusinessRuleUtil.getRiskCode(registNo, "RegistNo");
					}
	
					// ==================================================
	
					// ==================================================
					// 进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
					// 如果没有flowID和logno则不进行判断。
					
					if (flowID != null && logNo != null) {
						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
						SwfLogDto swfLogDto = new SwfLogDto();
						swfLogDto = uiWorkFlowAction.holdNodeCombine(flowID, Integer.parseInt(logNo), user
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
					DAACombineCertainLossViewHelper dAACombineCertainLossViewHelper = new DAACombineCertainLossViewHelper();
					// 已经到核价、核损的案件再能在处理
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
						// 设置出险时保单的承保数量，农险使用（种植险没有定损），用来控制赔付数量不能超过保单的总数量
						agriCombineCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo,index);
					} else if ("D".equals(strRiskType)){
						//并案环节暂时屏蔽dAACertainLossViewHelper.registDtoToView(httpServletRequest, registNo, editType);
					}
	
					// 农险增加与赔付数量对应的单位信息
					if("I".equals(strRiskType) || "H".equals(strRiskType)) {
						dAACombineCertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode,index);	
					}	
				}
				if (editType.equals("EDIT") || editType.equals("SHOW")) {
					// 查询定损信息,整理输入，用于初始界面显示
					
					if (registNo == null || registNo.trim().length() < 1) {
						registNo = String.valueOf(httpServletRequest.getAttribute("RegistNo_"+index)); // 报案号
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
						// 设置出险时保单的承保数量，农险使用（种植险没有定损），用来控制赔付数量不能超过保单的总数量
						agriCombineCertainLossViewHelper.setStatQuantity(httpServletRequest, strRiskType, registNo,1);
					} else if ("D".equals(strRiskType)) {
						//并案环节暂时屏蔽dAACertainLossViewHelper.certainLossDtoView(httpServletRequest, registNo,
						//并案环节暂时屏蔽		editType);
					}
					
					// 农险增加与赔付数量对应的单位信息
					if("I".equals(strRiskType) || "H".equals(strRiskType)) {
						dAACombineCertainLossViewHelper.setUnitCollection(httpServletRequest, riskCode,index);	
					}
					
					// 人伤定损时显示定损人员

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
		        	  throw new UserException(1,3,"工作流","");
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
			//并案环节屏蔽if (editType.equals("SelectLossType")) {
			//并案环节屏蔽	forward = "SelectLossType";
			//并案环节屏蔽}
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
		}
		return actionMapping.findForward(forward);
	}
}
