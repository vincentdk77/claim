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
 * �ַ�HTTP Post ��������˼۱༭����
 * <p>Title: ��������˼۱༭������Ϣ</p>
 * <p>Description: ��������˼۱༭������Ϣ</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0
 */
public class UILVerifyPriceEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //��ǰ��ת
		try {

			String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //������
			String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo"); //�ⰸ��
			String nodeType = httpServletRequest.getParameter("nodeType");      //�ڵ�����
			String verpOpinion = httpServletRequest.getParameter("verpOpinion"); //�˼����
			String nextHandleDept = httpServletRequest.getParameter("nextHandleDept"); //����ѯ�ۻ�������
			String nextDeptName = httpServletRequest.getParameter("nextDeptName");     //����ѯ�ۻ�������
			String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode"); //����ѯ����Ա����
			String nextHandlerName = httpServletRequest.getParameter("nextHandlerName"); //����ѯ����Ա����
			String flowID = httpServletRequest.getParameter("swfLogFlowID");
			String LogNo = httpServletRequest.getParameter("swfLogLogNo");
			String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode");
			int nextNodeNo = 0;
			httpServletRequest.setAttribute("registNo", registNo);
			httpServletRequest.setAttribute("claimNo", claimNo);
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");

			//if(isTokenValid(httpServletRequest,true)){

			//��viewHelper�����������
			//DAAVerifyLossViewHelper dAAVerifyLossViewHelper = new DAAVerifyLossViewHelper();
			
			//VerifyLossDto verifyLossDto = dAAVerifyLossViewHelper.viewToDto(httpServletRequest);
			VerifyLossDto verifyLossDto = new VerifyLossDto();
			BLPrpLverifyLossFacade blPrpLverifyLossFacade = new BLPrpLverifyLossFacade();
			PrpLverifyLossDto prpLverifyLossDto = blPrpLverifyLossFacade.findByPrimaryKey(registNo, "-1");
			UIClaimStatusAction uiClaimStatusAction = new UIClaimStatusAction();		
			ClaimStatusDto claimStatusDto = uiClaimStatusAction.findByPrimaryKey(prpLverifyLossDto.getRegistNo(), nodeType,-1);

			//�������������			
			// 1requst����,2���ڵ�Ľڵ�����,3���ڵ���Ҫ���µ�״̬,4���ڵ��ҵ�����,5�Ժ�ڵ��ҵ�����,6���ڵ��ҵ���������,7�Ժ�ڵ��ҵ����������
			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();

			swfLogDtoDealNode.setNodeType(nodeType);			
			swfLogDtoDealNode.setNodeStatus(httpServletRequest.getParameter("buttonSaveType"));
			swfLogDtoDealNode.setLossItemCode(prpLverifyLossDto.getLossItemCode());
			swfLogDtoDealNode.setTypeFlag("1");
			swfLogDtoDealNode.setLossItemName(prpLverifyLossDto.getLossItemName());
			swfLogDtoDealNode.setRiskCode(riskCodeTemp);
			
			//�����Ƿ񱣵������ı�־
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
			
			//��Ϊ���������ƣ�������������ҵ����������
			swfLogDtoDealNode.setConditionBusinessNo(registNo);
			
			Collection nextNodeList = new ArrayList();
			
			if (swfLogDtoDealNode.getNodeStatus().equals("4")) {				
				//����ѯ��
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
//					//�����Ƿ񱣵������ı�־  
//					//swfLogNextNode.setInsureCarFlag(verifyLossDto.getInsureCarFlag());
//					nextNodeList.add(swfLogNextNode);					
//
//					swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
//					swfLogDtoDealNode.setSwfLogList(nextNodeList);
//				}else{
//					//����˼�,�ύ��ԭ����ѯ����
//					if(nodeType.trim().equals("verpo")){						
//						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();					
//						SwfLogDto swfLogNextNode = new SwfLogDto();
//						SwfLogDto swfLogDtoTmp = new SwfLogDto();
//						
//						//��ѯ��һ������ѯ����Ա��Ӧ��swflog
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
//						//�����Ƿ񱣵������ı�־  
//						swfLogNextNode.setInsureCarFlag(verifyLossDto.getPrpLverifyLossDto().getInsureCarFlag());
//						nextNodeList.add(swfLogNextNode);					
//	
//						swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
//						swfLogDtoDealNode.setSwfLogList(nextNodeList);
//					}else{
						//�ύ����(û����ģ�壬������Ҫ�Ĺ�����getSubmitFlowInfo)					
						SwfLogDto swfLogNextNode = new SwfLogDto();
																		
						swfLogNextNode.setNodeNo(0);  
						swfLogNextNode.setNodeType("verif");
						swfLogNextNode.setKeyIn(registNo);
						swfLogNextNode.setKeyOut(registNo);
						
						swfLogNextNode.setLossItemCode(prpLverifyLossDto.getLossItemCode());
						swfLogNextNode.setLossItemName(prpLverifyLossDto.getLossItemName());
						//swfLogNextNode.setNodeName("�˼�");
						
						//�����Ƿ񱣵������ı�־  
						//swfLogNextNode.setInsureCarFlag(prpLverifyLossDto.getInsureCarFlag());
						nextNodeList.add(swfLogNextNode);					
	
						//swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ����һ���ڵ�����У�������ǣ����Ǵ�ģ����Ѱ������Ľڵ�
						swfLogDtoDealNode.setSwfLogList(nextNodeList);					
//					}
//				}
			}

			//�˻أ��ύ���𣬲�������Ϊ����Ļ��˱�־
			if (swfLogDtoDealNode.getNodeStatus().equals("5")) {								
				//����Ҫ�˻صĽڵ�				
				swfLogDtoDealNode.setNodeType("propc");
				swfLogDtoDealNode.setBusinessType("verip");
				swfLogDtoDealNode.setLossItemCode(prpLverifyLossDto.getLossItemCode());
				swfLogDtoDealNode.setNextNodeListType("1");//�����1��������Ҫָ��Ҫ���˵Ľڵ㣬������ǣ�����swflog����Ѱ�һ��˵Ľڵ�
			}
			

			

			
			
			
			
			//����������
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
					swfLogDtoDealNode);
			
			//����˼���Ϣ
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
				user.setUserMessage(registNo + ";ע��:û�з����빤������������κ����ݣ���");
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
			//������Ϣ����
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
			//������Ϣ����
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
			//������Ϣ����
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
