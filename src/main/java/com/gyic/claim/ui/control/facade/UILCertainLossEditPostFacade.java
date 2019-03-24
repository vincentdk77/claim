package com.gyic.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.utils.Utils;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.gyic.claim.ui.control.viewHelper.AgriCombineCertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAACertainLossViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.utility.SysConfig;

/**
 * 分发HTTP Post 车险理赔定损编辑界面
 * <p>Title: 车险理赔定损编辑界面信息</p>
 * <p>Description: 车险理赔定损编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author liubvo
 * @version 1.0  
 */
public class UILCertainLossEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //向前流转
		try {

			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			
			//reason: 防止重复提交--------------------------------------------------------------------
			String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime() / 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCertainLossLastAccessedTime");
			//理算退回的定损，并且是没有增加任何记录的标记，如果为1，说明，可以直接提交到理算去。
			String NextComeBackCompensate=httpServletRequest.getParameter("NextComeBackCompensate");
			
			
			if (oldLastAccessedTime != null && !oldLastAccessedTime.trim().equals("")) 
				throw new UserException(1, 3, "工作流", "请不要重复提交");
			
				httpServletRequest.getSession().setAttribute("oldCertainLossLastAccessedTime", strLastAccessedTime);

				//防止回退刷新再提交，或多人同时操作提交同一案件。
				String[] registNoValues = httpServletRequest.getParameterValues("combineRegistNo");
				String checkInput = "";
				ActionMessages messages = new ActionMessages();
				String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode");
				String nextHandlerName = httpServletRequest.getParameter("nextHandlerName");
				checkInput = httpServletRequest.getParameter("checkInput"); //工作流logno
				ArrayList certainLossDtoList = new ArrayList();
				//开始循环生成所有DTO
				for(int index = 0;index < registNoValues.length; index++){
					String swfLogFlowID = "";
					String lossItemCode = "";
					String swfLogLogNo = "";
					String registNo = "";
					RegistDto registDto = null;
					String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode_"+index);
				
					swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+index); //工作流号码
					swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+index); //工作流logno
					
					Collection nextNodeList = new ArrayList();
	
					int nextNodeNo = 0;
					if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
						user.setRiskCode(riskCodeTemp);
					}
					//以下是业务使用
					registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo_"+index); //报案号
					//////////////
					UIWorkFlowAction uiWorkFlowActionCheck = new UIWorkFlowAction();
					String conditions = " registNo = '"+registNo+"' and nodeType = 'certa' and nodestatus !='4'";
					Collection swfLogCollection = null;
					swfLogCollection = uiWorkFlowActionCheck.findNodesByConditions(conditions);
					if(null == swfLogCollection || swfLogCollection.size()!=1)
						throw new Exception ("节点异常,报案号："+registNo);
					//////////////////
					String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo_"+index); //赔案号
					lossItemCode = httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+index); //损失代码
					String lossItemName = httpServletRequest.getParameter("prpLverifyLossLossItemName_"+index); //损失名称
					String verifyPriceFlag = httpServletRequest.getParameter("verifyPriceFlag_"+index); //是否需要核价标志
					//add by miaowenjun 20060922 获取险类
					String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCodeTemp);
					UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
					String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus ='4'";
				    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
				    if(certifyNodeList!=null&&certifyNodeList.size()>0){
				    	   throw new UserException(1,3,"工作流","该案件定损节点已处理！");
				    }
				    /*
				    String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
				    if (httpServletRequest.getParameter("prpLverifyLossRiskCode") != null &&taskCode.indexOf(httpServletRequest.getParameter("prpLverifyLossRiskCode_"+index)) > -1) {
				    	 //start耳标号真实性判断add by 张菊卿
					    String[] prplCompensateEarEarNo =httpServletRequest.getParameterValues("prplCompensateEarEarNo_"+index);
					    String   prpLCompensatePolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo_"+index);
	
					    for(int i = 1;i < prplCompensateEarEarNo.length;i++)
						{
					    	if(prpLCompensatePolicyNo == null || prplCompensateEarEarNo[i] == null ) throw new UserException(1, 3, "保单号或耳标号为空", "");
					    	if("".equals(prpLCompensatePolicyNo) || "".equals(prplCompensateEarEarNo[i]))  throw new UserException(1, 3, "保单号或耳标号为空", "");
					    	ArrayList herdPolicyListResult = (ArrayList)Utils.findHerdpolicylist(prpLCompensatePolicyNo, prplCompensateEarEarNo[i]);
	
					    	ArrayList insureMainListDtoList = (ArrayList) herdPolicyListResult.get(0);
							if(insureMainListDtoList == null || insureMainListDtoList.size() == 0)
							{
								break;
							}
							ArrayList herdPolicyListDtoList = (ArrayList)herdPolicyListResult.get(1);
							if(herdPolicyListDtoList == null || herdPolicyListDtoList.size() == 0)
							{
								throw new UserException(1, 3, "耳标号真实性检查失败：", "耳标号真实性检查失败：耳标号"+prplCompensateEarEarNo[i]);
							}
						}
					    //end耳标号真实性判断add by 张菊卿
				    }*/
			        //Modify by chenrenda update begin 20050420
					//Reason:定损提交核损时，去掉人员选择，增加核损级别
					int intItemCode = Integer.parseInt(DataUtils.nullToZero(lossItemCode));
					String prplCarLossHandlerRange = "";
					if (intItemCode > 0) {
						prplCarLossHandlerRange = httpServletRequest.getParameter("prplCarLossHandlerRange");
					}
					//Modify by chenrenda update end 20050420
	
					httpServletRequest.setAttribute("registNo_"+index, registNo);
					httpServletRequest.setAttribute("claimNo_"+index, claimNo);
	
	
					//if(isTokenValid(httpServletRequest,true)){
					//用viewHelper整理界面输入
					
					CertainLossDto certainLossDto = new CertainLossDto();
					//modify by miaowenjun 20060922 农险走不同viewhelper
					if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)){
						AgriCombineCertainLossViewHelper agriCertainLossViewHelper = new AgriCombineCertainLossViewHelper();
						certainLossDto = agriCertainLossViewHelper.viewToDto(httpServletRequest,index);
					}else{
						//并案环节暂时屏蔽掉add by GYIC张菊卿DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
						//并案环节暂时屏蔽掉add by GYIC张菊卿certainLossDto = dAACertainLossViewHelper.viewToDto(httpServletRequest);
					}
	
					UIRegistAction uiRegistAction = new UIRegistAction();
					registDto = uiRegistAction.findByPrimaryKey(registNo);
					String businessType = registDto.getPrpLregistDto().getBusinessType();
					String businessType1 = registDto.getPrpLregistDto().getBusinessType1();
					
					certainLossDto.getPrpLverifyLossDto().setBusinessType(businessType);
					certainLossDto.getPrpLverifyLossDto().setBusinessType1(businessType1);
					certainLossDtoList.add(certainLossDto);
				}
				ArrayList<CertainLossDto> certainLossDtoListWf = new ArrayList<CertainLossDto>();
				ArrayList<WorkFlowDto> workFlowDtoList = new ArrayList<WorkFlowDto>();
				String strRegistNo = "";
				UICertainLossAction uiCertainLossAction = new UICertainLossAction();
				if (checkInput != null && checkInput.equals("true")) {
					//并案屏蔽if (lossItemCode.equals("1")) {
						uiCertainLossAction.save(certainLossDtoList);
	
						//并案屏蔽} else {
						//并案屏蔽uiCertainLossAction.save(certainLossDtoList);
						//并案屏蔽}
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.save"));
					//只保存定损信息，不用管工作的情况
				} else {
					//进行与工作流有关的操作
					// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
					//判断是否是直接从0待处理到提交，如果是则先进行业务保存操作 则从0->3 ,从3->4这样的状态变更,由于后来变成人到人的方式，所以去掉以下的代码
					for(int index = 0;index < registNoValues.length; index++){
						String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+index); //工作流号码
						String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+index); //工作流logno
						String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo_"+index); //报案号
						String lossItemCode = httpServletRequest.getParameter("prpLverifyLossLossItemCode_"+index); //损失代码
						UIRegistAction uiRegistAction = new UIRegistAction();
						RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
						
						WorkFlowDto workFlowDto = new WorkFlowDto();
						workFlowDto.setSwfNotionDtoList(((CertainLossDto)certainLossDtoList.get(index)).getSwfNotionList());
						//定损的工作流设置，比较特殊
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();

						if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
							swfLogDtoDealNode.setFlowID(swfLogFlowID);
							swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
						}
						swfLogDtoDealNode.setBusinessNo(registNo);
						swfLogDtoDealNode.setNextBusinessNo(registNo);
						String statusTemp = httpServletRequest.getParameter("buttonSaveType");
						swfLogDtoDealNode.setNodeStatus(statusTemp);
						swfLogDtoDealNode.setKeyIn(registNo);
						swfLogDtoDealNode.setKeyOut(registNo);
						swfLogDtoDealNode.setConditionBusinessNo(registNo);
						swfLogDtoDealNode.setLossItemCode(lossItemCode);
						swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
						
						/*
						if ("1".equals(NextComeBackCompensate)){
	                    	nextNodeList.clear();
	                    	SwfLogDto swfLogNextNode = new SwfLogDto();
							swfLogNextNode.setNodeNo(0);
							swfLogNextNode.setNodeType("compe");
							nextNodeList.add(swfLogNextNode);
							swfLogDtoDealNode.setNextNodeListType("1"); //如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
							swfLogDtoDealNode.setSwfLogList(nextNodeList);
	                    }
						*/
						
	//					判断如果是理算退回的定损，并且该定损没有新增加数据，那么可以直接提交回理算的。
	//					相应的问题，如果理算处，以上信息都没完成，是不可以进行出理算书的。					
						
						workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						//保存定损信息
						if (((CertainLossDto)certainLossDtoList.get(index)).getPrpLclaimStatusDto().getStatus().equals("4")
								&& workFlowDto.getSubmitSwfLogDtoList() == null) {
							//strRegistNo = strRegistNo + registNo + ";\r";
						} 
						else{
							if(workFlowViewHelper.checkDealDto(workFlowDto)) {
								//add by lixiang start at 2006-4-26
								//reason:增加判断如果是提交操作的话，到理算的时候，要换成是立案号的
								/*
								if ("1".equals(NextComeBackCompensate)
								  		&&workFlowDto.getSubmitSwfLogDtoList()!=null
										&&workFlowDto.getSubmitSwfLogDtoList().size()>0){
//								      设置businessNo,KeyIn的值
									((SwfLogDto)((ArrayList)workFlowDto.getSubmitSwfLogDtoList()).get( 0)).setKeyIn( claimNo);
								  	((SwfLogDto)((ArrayList)workFlowDto.getSubmitSwfLogDtoList()).get( 0)).setBusinessNo( claimNo);
					
								 }
	                            	
	                            */
								workFlowDtoList.add(workFlowDto);
								certainLossDtoListWf.add((CertainLossDto)certainLossDtoList.get(index));
								//strRegistNo = strRegistNo + registNo + ";\r";
								//user.setUserMessage(registNo);
							}else{
								certainLossDtoListWf.add((CertainLossDto)certainLossDtoList.get(index));
								strRegistNo = strRegistNo +  registNo + ";\r";
							}
						}
					}
					if(certainLossDtoListWf.size() < registNoValues.length){
						uiCertainLossAction.save(certainLossDtoListWf);
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.workflow.submitfalse"));
						//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
						user.setUserMessage("事故号："+httpServletRequest.getParameter("combineNo"));
					}
					else
					{
						if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.submit"));
						} else {
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.save"));
						}
						//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
						if(workFlowDtoList.size() != certainLossDtoListWf.size())
						{
							uiCertainLossAction.save(certainLossDtoListWf);
							user.setUserMessage(strRegistNo + ";注意:没有发现与工作流流程相关任何数据！！");
						}
						else
						{
							uiCertainLossAction.save(certainLossDtoListWf, workFlowDtoList);
							user.setUserMessage("事故号："+httpServletRequest.getParameter("combineNo"));
						}
					}
				}

				//} isTokenValid
				saveMessages(httpServletRequest, messages);

				forward = "success";
				

		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理 
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.certainLossBeforeEdit.editCertainLoss");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} finally {
		}
		return actionMapping.findForward(forward);
	}
}
