package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.sinosoft.claim.bl.facade.BLPrpLcompensateFacade;
import com.sinosoft.claim.bl.facade.BLPrpLprepayFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrplpayFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogStoreFacade;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLprepayDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfFlowMainDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
/*import com.sinosoft.claim.ui.control.viewHelper.DAAReviewViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARulesmodleViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARulesmodleViewHelper;*/
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.prpall.blsvr.lp.BLPrpLprepay;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;

public class UIPrprlpaySaveFacade extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String registno=request.getParameter("registNo_payment");
		String[] compensateno = request.getParameterValues("compensateno");
		String onlySaveReq = request.getParameter("onlySave");
		String businessNo = null;
		String forward = "s";
		String flag = request.getParameter("flag");
		try {
			
			/**
			 * 风险监控功能中跳到复审处理
			 * “冻结”不影响主流程的流转，只控制支付录入不能提交。*/
			//判断案件是否冻结begin
			/*DAAReviewViewHelper daaReviewViewHelper = new DAAReviewViewHelper();
			if(!"true".equals(onlySaveReq)){
				boolean status = daaReviewViewHelper.CaseStatus(request, registno);
				if(status){
					String msg = "案件已冻结，不能提交支付！";
					throw new UserException(1, 3, "", msg);
				}
			}*/
			//判断案件是否冻结end
			
			String parentNodeSql="";//查找父节点sql
			String parentNodeName="";//父节点名称
			boolean onlySave= false;
			if ("comp".equals(flag)) {
				businessNo = compensateno[0];
				parentNodeSql="businessno='" + businessNo+ "' and nodeType = 'compp'";
				parentNodeName="理算";
			}else if ("prepay".equals(flag)) {
				businessNo = compensateno[0];
				parentNodeSql="keyout='" + businessNo+ "' and nodeType ='speci'";
				parentNodeName="预赔";
			}else {
				onlySave=true;
				parentNodeName="单证";
			}
			if (!StringUtils.isEmpty(onlySaveReq)&&"true".equals(onlySaveReq)) {
				onlySave=true;
			}
			UserDto userDto = (UserDto) request.getSession(true).getAttribute(
			"user");
			if (onlySave) {
				String vflag="1";
				//单证不修改状态
				if ("certify".equals(flag)) {
					vflag="";
				}
				new BLPrplpayFacade().save(request,vflag);
				userDto.setUserMessage("支付信息保存成功！");
			}else {
				if (businessNo == null ||StringUtils.isEmpty(businessNo)) {
					String msg = "支付信息计算书号为空，不能提交审批！";
					throw new UserException(1, 3, "支付信息审批", msg);
				}
				
	            boolean overHepei=true;
	            //未核赔通过时只保存支付信息
	            if ("comp".equals(flag)) {
	            	BLPrpLcompensateFacade bLcompensateFacade=new BLPrpLcompensateFacade();
		            PrpLcompensateDto prpLcompensateDto= bLcompensateFacade.findByPrimaryKey(businessNo);
	            	//if (prpLcompensateDto==null||"1,3".indexOf(prpLcompensateDto.getUnderWriteFlag())<0) {
						new BLPrplpayFacade().save(request,"");
						//userDto.setUserMessage("未核赔通过,支付信息保存成功！");
						userDto.setUserMessage("支付信息保存成功！");
						overHepei=false;
					//}
				}
	            if ("prepay".equals(flag)) {
	            	BLPrpLprepayFacade blPrpLprepayFacade=new BLPrpLprepayFacade();
	            	PrpLprepayDto prpLprepayDto=blPrpLprepayFacade.findByPrimaryKey(businessNo);
	            	//if (prpLprepayDto==null||"1,3".indexOf(prpLprepayDto.getUnderWriteFlag())<0) {
						new BLPrplpayFacade().save(request,"");
						//userDto.setUserMessage("未核赔通过,支付信息保存成功！");
						userDto.setUserMessage("支付信息保存成功！");
						overHepei=false;
					//}
				}
	            //通过核赔时上传平台
	            /**对于老理赔目前只是保存支付信息，在业务上没有做任何的处理，需要后续补充提交平台。复审等等信息，案件冻结等等信息
	             * 先将此处走核赔平台屏蔽掉。*/
	            overHepei = false;
	            if (overHepei) {
	            	PrpLregistDto prpLregistDto = new BLPrpLregistFacade().findByPrimaryKey(registno);
					WorkFlowDto workFlowDto = new WorkFlowDto();
					WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
					//获取上一个节点
					SwfLogDto swfLogDtoDealNode = new SwfLogDto();
					BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
					ArrayList<SwfLogDto> apayList = null;
					
					apayList = (ArrayList<SwfLogDto>) blSwfLogFacade
							.findByConditions("businessno='" + businessNo
									+ "' and nodeType='apay' order by logno desc");
					SwfLogDto apayLog=null;
					if (apayList != null && !apayList.isEmpty()) {
						apayLog=apayList.get(0);
						if ("0,3".indexOf(apayLog.getNodeStatus())==-1) {//当前代码不会生成暂存状态的数据 2011年10月17日16:38:27
							String msg = "此支付信息已经提交审批，不能再申请！";
							throw new UserException(1, 3, "支付信息审批", msg);
						}
					}

					
		            List<SwfLogDto> swfList=((ArrayList<SwfLogDto>) blSwfLogFacade
							.findByConditions(parentNodeSql));
		            BLSwfLogStoreFacade blSwfLogStoreFacade = new BLSwfLogStoreFacade();
		            if(swfList==null||swfList.isEmpty()){
		            	swfList= (ArrayList<SwfLogDto>)blSwfLogStoreFacade.findByConditions(parentNodeSql);
		            }
		            if (swfList.size()==0) {
						String msg = "未发现"+parentNodeName+"节点！";
						throw new UserException(1, 3, "支付信息审批", msg);
					}
					swfLogDtoDealNode = swfList.get(0);
					
					
					swfLogDtoDealNode.setNextBusinessNo(businessNo);
					ArrayList<SwfLogDto> nextNodeList = new ArrayList<SwfLogDto>();
					SwfLogDto nextSwfLogDto = new SwfLogDto();
					if (apayLog==null) {
						 //2.检查流程现在的状态
						UIWorkFlowAction  uiWorkFlowAction =new UIWorkFlowAction();
				        SwfFlowMainDto swfFlowMainDto=uiWorkFlowAction.findFlowMainByPrimaryKey(swfLogDtoDealNode.getFlowID());//将flowstatus置为1
				        if(swfFlowMainDto.getFlowStatus().equals( "0") ){
				        	swfFlowMainDto.setFlowStatus( "1");
				            workFlowDto.setReOpen(true);
				            workFlowDto.setReOpenSwfFlowMainDto(swfFlowMainDto);
				            uiWorkFlowAction.deal(workFlowDto);
				        }
						//新增审批节点
						nextSwfLogDto.setNodeType("apay");
						nextSwfLogDto.setNodeNo(0);
						nextSwfLogDto.setBusinessNo(businessNo);
						nextSwfLogDto.setSubmitTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND).toString());
						nextNodeList.add(nextSwfLogDto);
						swfLogDtoDealNode.setNextNodeListType("1");// 如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
						swfLogDtoDealNode.setSwfLogList(nextNodeList);
						swfLogDtoDealNode.setTaskType("S");//修改任务类型，解决当节点为特殊赔案（T）时 工作流引擎执行代码冲突
						//工作流
						workFlowDto = workFlowViewHelper.viewToDto(userDto,
								swfLogDtoDealNode);
						
						workFlowDto.setUpdateSwfLogDto(null);
						nextSwfLogDto=((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0));
						nextSwfLogDto.setSubmitTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND).toString());
						nextSwfLogDto.setNodeStatus("4");
						nextSwfLogDto.setKeyOut(businessNo);
						((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0)).setKeyOut(businessNo);
					}else {
						swfLogDtoDealNode=apayLog;
						swfLogDtoDealNode.setNextBusinessNo(businessNo);
						swfLogDtoDealNode.setNodeStatus("4");
						swfLogDtoDealNode.setHandlerCode(userDto.getUserCode());
						swfLogDtoDealNode.setHandleDept(userDto.getComName());
						swfLogDtoDealNode.setKeyOut(businessNo);
						//工作流
						workFlowDto = workFlowViewHelper.viewToDto(userDto,
								swfLogDtoDealNode);
						((SwfLogDto) workFlowDto
								.getSubmitSwfLogDtoList().get(0)).setKeyOut(businessNo);
					}
					
				
					
					
					
					//审核平台  屏蔽上传平台代码   取消屏蔽把&&false去掉
					if (workFlowViewHelper.checkDealDto(workFlowDto)) {
						
						new BLPrplpayFacade().save(request, workFlowDto);
						/*** 报案注销送审核平台 start****/
						/*int vericLogNo = 0;
						int size=workFlowDto.getSubmitSwfLogDtoList().size();
						if (workFlowDto.getSubmitSwfLogDtoList() != null
								&& size > 0) {
							vericLogNo = ((SwfLogDto) workFlowDto
									.getSubmitSwfLogDtoList().get(size-1)).getLogNo();
						}
						UIWorkFlowApprovalInterFaceFacade uiWorkFlowApprovalInterFaceFacade = new UIWorkFlowApprovalInterFaceFacade();
						String UWflowID = uiWorkFlowApprovalInterFaceFacade
								.submitApprovalPlatform("VeriPay",
										swfLogDtoDealNode.getFlowID(), Integer.valueOf(
												vericLogNo).toString(), businessNo,
												prpLregistDto.getRiskCode(),
												prpLregistDto.getClassCode(),
												prpLregistDto.getComCode(),
										userDto.getUserCode(), prpLregistDto.getMakeCom(),
										userDto.getUserCode(), userDto.getUserCode(),
										"");
						if (UWflowID.length() < 15) {
							String msg = "案件'"
									+ businessNo
									+ "'提交双核系统失败，请重新提交或者与管理员联系!";
							throw new UserException(1, 3, "工作流", msg);
						}*/
						/*** 报案注销送审核平台 end****/
						new BLPrplpayFacade().updateVFlag("2", registno, businessNo);//更新为正在审核状态
						
					} else {
						new BLPrplpayFacade().save(request,"1");
					}
					/****定损发送复审平台start******/
					/*DAARulesmodleViewHelper daaRulesmodleViewHelper =new DAARulesmodleViewHelper();
					if(daaRulesmodleViewHelper.isuploud(swfLogDtoDealNode.getRegistNo(), "1", "apay")){
						daaRulesmodleViewHelper.matchRule(swfLogDtoDealNode.getComCode(),"apay", swfLogDtoDealNode.getRegistNo(), "1", "", businessNo);
					}*/
					/****定损发送复审平台end ******/
					userDto.setUserMessage("支付信息上传审核平台成功！");
				}
			}
			
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("支付信息审批");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(request, errors);
			forward = "error";

		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("支付信息审批");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError("支付信息审批");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";

		}
		return mapping.findForward(forward);
		
		/*String onlySaveReq = request.getParameter("onlySave");
		String forward = "s";
		boolean onlySave= false;
		if (!StringUtils.isEmpty(onlySaveReq)&&"true".equals(onlySaveReq)) {
			onlySave=true;
		}
		try {
			
			UserDto userDto = (UserDto) request.getSession(true).getAttribute("user");
			if (onlySave){
				String vflag="1";
				new BLPrplpayFacade().save(request,vflag);
				userDto.setUserMessage("支付信息暂存成功！");
			}else{
				new BLPrplpayFacade().save(request,"");
				userDto.setUserMessage("支付信息保存成功！");
			}
			
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = null;
			if(onlySave){
				error = new ActionError("支付信息保存");
			}else{
				error = new ActionError("支付信息暂存");
			}
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(request, errors);
			forward = "error";

		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = null;
			if(onlySave){
				error = new ActionError("支付信息保存");
			}else{
				error = new ActionError("支付信息暂存");
			}
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = null;
			if(onlySave){
				error = new ActionError("支付信息保存");
			}else{
				error = new ActionError("支付信息暂存");
			}
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			request.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(request, errors);
			forward = "error";

		}
		return mapping.findForward(forward);*/
	}
}
