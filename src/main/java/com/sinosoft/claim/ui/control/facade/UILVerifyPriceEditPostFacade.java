package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

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

import com.sinosoft.claim.bl.action.domain.BLPrpLverifyLossExtAction;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLPrpLverifyLossFacade;
import com.sinosoft.claim.bl.facade.BLVerifyLossFacade;
import com.sinosoft.claim.dto.custom.ClaimStatusDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.VerifyLossDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.PrpLverifyLossDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimStatusAction;
import com.sinosoft.claim.ui.control.action.UIVerifyLossAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAVerifyLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;

/**
 * 分发HTTP Post 车险理赔核价编辑界面
 * <p>Title: 车险理赔核价编辑界面信息</p>
 * <p>Description: 车险理赔核价编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILVerifyPriceEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //向前流转
		try {

			String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //报案号
			String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo"); //赔案号
			String nodeType = httpServletRequest.getParameter("nodeType");      //节点类型
			String verpOpinion = httpServletRequest.getParameter("verpOpinion"); //核价意见
			String nextHandleDept = httpServletRequest.getParameter("nextHandleDept"); //向外询价机构代码
			String nextDeptName = httpServletRequest.getParameter("nextDeptName");     //向外询价机构名称
			String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode"); //向外询价人员代码
			String nextHandlerName = httpServletRequest.getParameter("nextHandlerName"); //向外询价人员名称
			String flowID = httpServletRequest.getParameter("swfLogFlowID");
			String LogNo = httpServletRequest.getParameter("swfLogLogNo");
			String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode");
			int nextNodeNo = 0;
			httpServletRequest.setAttribute("registNo", registNo);
			httpServletRequest.setAttribute("claimNo", claimNo);
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");

			//if(isTokenValid(httpServletRequest,true)){

			//用viewHelper整理界面输入
			//DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
			
			//VerifyLossDto verifyLossDto = dAAVerifyLossViewHelper.viewToDto(httpServletRequest);
			VerifyLossDto verifyLossDto = new VerifyLossDto();
			BLPrpLverifyLossFacade blPrpLverifyLossFacade = new BLPrpLverifyLossFacade();
			PrpLverifyLossDto prpLverifyLossDto = blPrpLverifyLossFacade.findByPrimaryKey(registNo, "-1");
			UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();		
			ClaimStatusDto claimStatusDto = uiClaimStatusAction.findByPrimaryKey(prpLverifyLossDto.getRegistNo(), nodeType,-1);

			//工作流处理过程			
			// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();

			swfLogDtoDealNode.setNodeType(nodeType);			
			swfLogDtoDealNode.setNodeStatus(httpServletRequest.getParameter("buttonSaveType"));
			swfLogDtoDealNode.setLossItemCode(prpLverifyLossDto.getLossItemCode());
			swfLogDtoDealNode.setTypeFlag("1");
			swfLogDtoDealNode.setLossItemName(prpLverifyLossDto.getLossItemName());
			swfLogDtoDealNode.setRiskCode(riskCodeTemp);
			
			//保存是否保单车辆的标志
			//swfLogDtoDealNode.setInsureCarFlag(verifyLossDto.getInsureCarFlag());

			if (claimNo != null && claimNo.length() > 0) {
				swfLogDtoDealNode.setBusinessNo(claimNo);
				swfLogDtoDealNode.setNextBusinessNo(claimNo);
			} else {
				swfLogDtoDealNode.setBusinessNo(registNo);
				swfLogDtoDealNode.setNextBusinessNo(registNo);
			}
			swfLogDtoDealNode.setKeyIn(registNo);
			swfLogDtoDealNode.setKeyOut(registNo);
			swfLogDtoDealNode.setFlowID(flowID);
			swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(LogNo)));
			
			//因为有条件限制，所以有条件的业务主键传入
			swfLogDtoDealNode.setConditionBusinessNo(registNo);
			
			Collection nextNodeList = new ArrayList();
			
			if (swfLogDtoDealNode.getNodeStatus().equals("4")) {				
				//向外询价
//				if(verpOpinion.trim().equals("05")){
//					//nextNodeNo = Integer.parseInt(httpServletRequest.getParameter("nextNodeNo"));
//	     			//swfLogDtoDealNode.setNodeNo(nextNodeNo);
//					
//					SwfLogDto swfLogNextNode = new SwfLogDto();
//					swfLogNextNode.setNodeNo(0);  
//					swfLogNextNode.setNodeType("verpo");
//					swfLogNextNode.setKeyIn(registNo);
//					swfLogNextNode.setKeyOut(registNo); 
//					swfLogNextNode.setNewHandleDept(nextHandleDept);
//					swfLogNextNode.setNewDeptName(nextDeptName);
//					swfLogNextNode.setHandlerCode(nextHandlerCode);
//					swfLogNextNode.setHandlerName(nextHandlerName);
//					swfLogNextNode.setLossItemCode(verifyLossDto.getLossItemCode());
//					swfLogNextNode.setLossItemName(verifyLossDto.getLossItemName());
//					//swfLogNextNode.setComCode(  ) ;
//					
//					//保存是否保单车辆的标志  
//					//swfLogNextNode.setInsureCarFlag(verifyLossDto.getInsureCarFlag());
//					nextNodeList.add(swfLogNextNode);					
//
//					swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
//					swfLogDtoDealNode.setSwfLogList(nextNodeList);
//				}else{
//					//对外核价,提交回原向外询价人
//					if(nodeType.trim().equals("verpo")){						
//						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();					
//						SwfLogDto swfLogNextNode = new SwfLogDto();
//						SwfLogDto swfLogDtoTmp = new SwfLogDto();
//						
//						//查询上一个向外询价人员对应的swflog
//						swfLogDtoTmp = uiWorkFlowAction.findNodeByPrimaryKey(flowID,Integer.parseInt(DataUtils.nullToZero(LogNo))-1);
//						
//						swfLogNextNode.setNodeNo(0);  
//						swfLogNextNode.setNodeType("verip");
//						swfLogNextNode.setKeyIn(registNo);
//						swfLogNextNode.setKeyOut(registNo);					
//						swfLogNextNode.setNewHandleDept(swfLogDtoTmp.getHandleDept());
//						swfLogNextNode.setNewDeptName(swfLogDtoTmp.getDeptName());
//						swfLogNextNode.setHandlerCode(swfLogDtoTmp.getHandlerCode());
//						swfLogNextNode.setHandlerName(swfLogDtoTmp.getHandlerName());					
//						swfLogNextNode.setLossItemCode(verifyLossDto.getPrpLverifyLossDto().getLossItemCode());
//						swfLogNextNode.setLossItemName(verifyLossDto.getPrpLverifyLossDto().getLossItemName());
//						
//						//保存是否保单车辆的标志  
//						swfLogNextNode.setInsureCarFlag(verifyLossDto.getPrpLverifyLossDto().getInsureCarFlag());
//						nextNodeList.add(swfLogNextNode);					
//	
//						swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
//						swfLogDtoDealNode.setSwfLogList(nextNodeList);
//					}else{
						//提交核损(没有走模板，否则需要改工作流getSubmitFlowInfo)					
						SwfLogDto swfLogNextNode = new SwfLogDto();
																		
						swfLogNextNode.setNodeNo(0);  
						swfLogNextNode.setNodeType("verif");
						swfLogNextNode.setKeyIn(registNo);
						swfLogNextNode.setKeyOut(registNo);
						
						swfLogNextNode.setLossItemCode(prpLverifyLossDto.getLossItemCode());
						swfLogNextNode.setLossItemName(prpLverifyLossDto.getLossItemName());
						//swfLogNextNode.setNodeName("核价");
						
						//保存是否保单车辆的标志  
						//swfLogNextNode.setInsureCarFlag(prpLverifyLossDto.getInsureCarFlag());
						nextNodeList.add(swfLogNextNode);					
	
						//swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
						swfLogDtoDealNode.setSwfLogList(nextNodeList);					
//					}
//				}
			}

			//退回，提交定损，并且设置为定损的回退标志
			if (swfLogDtoDealNode.getNodeStatus().equals("5")) {								
				//设置要退回的节点				
				swfLogDtoDealNode.setNodeType("propc");
				swfLogDtoDealNode.setBusinessType("verip");
				swfLogDtoDealNode.setLossItemCode(prpLverifyLossDto.getLossItemCode());
				swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定要回退的节点，如果不是，就是swflog表中寻找回退的节点
			}
			

			

			
			
			
			
			//工作流整理
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
					swfLogDtoDealNode);
			
			//保存核价信息
			UIVerifyLossAction uiVerifyLossAction = new UIVerifyLossAction();
			BLPrpLpropFacade blPrpLpropFacade = new BLPrpLpropFacade();
			//BLPrpLverifyLossExtAction blPrpLverifyLossAction = new BLPrpLverifyLossExtAction();
			BLVerifyLossFacade blVerifyLossFacade = new BLVerifyLossFacade();
			verifyLossDto = blVerifyLossFacade.findByPrimaryKey(registNo, "-1", nodeType);
			PrpLpropDto propDtoForTemp = blPrpLpropFacade.findByPrimaryKey(1, registNo);
			if (swfLogDtoDealNode.getNodeStatus().equals("5")) {
				prpLverifyLossDto.setVerifyOpinion("10");
			}
			verifyLossDto.setPrpLverifyLossDto(prpLverifyLossDto);
			ArrayList prpLpropDtoList = new ArrayList();
			prpLpropDtoList.add(propDtoForTemp);
			verifyLossDto.setPrpLpropDtoList(prpLpropDtoList);
			
			if("0310".equals(riskCodeTemp)||"0312".equals(riskCodeTemp))
			{
				
				
				BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();
				ArrayList prplCompensateHouseDtoList = new ArrayList();
				String condition = " registno='" + registNo + "' and nodetype='propc'";
				//System.err.println("condition:" + condition);
				prplCompensateHouseDtoList = (ArrayList)bLPrplcompensatehouseFacade.findByConditions(condition);
				//System.err.println("size:" + prplCompensateHouseDtoList.size());
				if(prplCompensateHouseDtoList != null && prplCompensateHouseDtoList.size() >0)
				{
					
					for(int index1=0; index1<prplCompensateHouseDtoList.size(); index1++)
					{
						PrplcompensatehouseDto PrplcompensatehouseDto = (PrplcompensatehouseDto)prplCompensateHouseDtoList.get(index1);
						PrplcompensatehouseDto.setNodetype("verip");
						PrplcompensatehouseDto.setNodeno(18);
					}
					verifyLossDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList);
				}
			}
			
			if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
					|| (workFlowDto.getSubmit()) || (workFlowDto.getClose())) {
				//System.err.println("if");
				uiVerifyLossAction.save(verifyLossDto, workFlowDto);
				user.setUserMessage(registNo);
			} else {
				//System.err.println("else");
				uiVerifyLossAction.save(verifyLossDto);
				user.setUserMessage(registNo + ";注意:没有发现与工作流流程相关任何数据！！");
			}
			
			

			// }isTokenValid

			String verifyPriceaveMessage = "q" + registNo;
			ActionMessages messages = new ActionMessages();
			Object obj_msg = verifyPriceaveMessage;

			if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.verifyPrice.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.verifyPrice.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"db.prpLclaim.registNo"));
			saveMessages(httpServletRequest, messages);
			forward = "success";
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.verifyPriceBeforeEdit.editVerifyPrice");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", usee
					.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.verifyPriceBeforeEdit.editVerifyPrice");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.verifyPriceBeforeEdit.editVerifyPrice");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} finally {
		}

		System.out.println("-----------forward--------" + forward);
		return actionMapping.findForward(forward);
	}
}
//
