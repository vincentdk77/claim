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
 * 分发HTTP GET 车险理赔单证前查询保单请求
 * <p>Title: 车险理赔单证前查询保单信息</p>
 * <p>Description: 车险理赔单证前查询保单信息系统样本程序</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Sinosoft</p>
 * @author liubvo
 * @version 1.0
 */
public class UILCertifyBeforeEditCombineGetFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		//业务类型：ADD-新增  EDIT-修改  SHOW-显示
		String editType = httpServletRequest.getParameter("editType");
		String nodeType = httpServletRequest.getParameter("nodeType");
		String combineNo = httpServletRequest.getParameter("combineNo"); //事故号
		String registNo = ""; //报案号
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user"); //用户信息
		String riskCode = "";
		if (user == null)
			riskCode = ""; //险种
		else {
			riskCode = user.getRiskCode(); //险种	
		}
		String flowID = httpServletRequest.getParameter("swfLogFlowID");
		String logNo = httpServletRequest.getParameter("swfLogLogNo");
		String forward = "";

		try {
			//尚未加入type异常处理{}、其它必须参数异常处理{}
			if (editType.equals("ADD")) {
				//查询立案信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("RegistNo"); //赔案号

				//==================================================
				//进行占号分析，只有当有工作流号码和LogNo的时候才能使用。
				//如果没有flowID和logno则不进行判断。
				
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
						throw new Exception ("节点异常,报案号："+prplcombineDto.getRegistno());

					BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
					 SwfLogDto swfLogDtoCombine = bLSwfLogFacade.findByRegistNo(prplcombineDto.getRegistno());
					 if(swfLogDtoCombine == null)throw new UserException(1, 3, "工作流", "报案号"+prplcombineDto.getRegistno()+"无对应工作流");
					if (swfLogDtoCombine.getFlowID() != null ) {
						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
						SwfLogDto swfLogDto = new SwfLogDto();
						swfLogDto = uiWorkFlowAction.holdNodeCombine(swfLogDtoCombine.getFlowID(), swfLogDtoCombine.getLogNo(), user.getUserCode(), user
								.getUserName());
						if (swfLogDto.getHoldNode() == false) {
							String msg = "案件'" + swfLogDtoCombine.getRegistNo() + "'已经被代码:'" + swfLogDto.getHandlerCode() + "',名称:'"
									+ swfLogDto.getHandlerName() + "'的用户所占用,请选择其它案件进行处理!";
							throw new UserException(1, 3, "工作流", msg);
						}
						if (uiWorkFlowAction.checkFlowClose(swfLogDtoCombine.getFlowID())==true) {
							String msg = "案件'" + swfLogDtoCombine.getRegistNo() + "已经申请注销/拒赔";
							throw new UserException(1, 3, "工作流", msg);
						}
					}
				}
				//===============================================

				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
			}
			//当编辑的时候
			if (editType.equals("EDIT") || editType.equals("SHOW") || editType.equals("DELETE")) {
				//查询单证信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("prpLcertifyCertifyNo"); //单证号
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
			}
			//当处理索赔清单的时候
			if (editType.equals("CertifyDirect")) {
				//查询单证信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("RegistNo"); //单证号
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
			//当打印索赔清单的时候
			if (editType.equals("CertifyDirectPrint")) {
				//查询单证信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("RegistNo"); //单证号
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
				//add by zhaolu 20060803 start 
				//reason:非车险打印索赔须知清单,判断险种
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
			//当打印索赔清单的时候
			if (editType.equals("CertifyDirectPrintAdd")) {
				//查询单证信息,整理输入，用于初始界面显示
				registNo = httpServletRequest.getParameter("RegistNo"); //单证号
				DAACertifyViewHelper dAACertifyViewHelper = new DAACertifyViewHelper();
				riskCode = BusinessRuleUtil.getRiskCode(registNo,"RegistNo");
				dAACertifyViewHelper.certifyDtoToView(httpServletRequest, registNo, nodeType);
				//add by zhaolu 20060807 start
				//reason:非车险打印索赔须知清单,判断险种
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

			//未处理单证任务的放弃处理
			if (editType.equals("GIVUP")) {
				 ArrayList<SwfLogDto> swfLogDtoList = new ArrayList<SwfLogDto>();
				 UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
				//add by huangyunzhong 20051226 放弃未暂存和提交的单证任务，删去结点操作人，使其他人可见可处理
				//String FlowID = httpServletRequest.getParameter("swfLogFlowID");
				//int LogNo = Integer.parseInt((String) httpServletRequest.getParameter("swfLogLogNo"));
				BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
				ArrayList prplcombineDtoList = (ArrayList)bLPrplcombineFacade.findByConditions(" combineNo='"+combineNo+"'");
				for(int i=0;i <prplcombineDtoList.size();i++){
					PrplcombineDto prplcombineDto = (PrplcombineDto)prplcombineDtoList.get(i);
					BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
					 SwfLogDto swfLogDtoCombine = bLSwfLogFacade.findByRegistNo(prplcombineDto.getRegistno());
					 if(swfLogDtoCombine == null)throw new UserException(1, 3, "工作流", "报案号"+prplcombineDto.getRegistno()+"无对应工作流");
					
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

			//取得forward
			forward = BusinessRuleUtil.getForward(httpServletRequest, riskCode, "certi", editType, 1);

			saveToken(httpServletRequest);
		} catch (SecurityException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certifyBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (UserException ue) {
		    ue.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certifyBeforeEdit.titleName");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", ue.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		}catch (Exception e) {
			e.printStackTrace();
			//错误信息处理
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
