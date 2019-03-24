package com.sinosoft.claim.ui.control.facade;

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
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UICertainLossAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriCertainLossViewHelper;
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
			String riskCodeTemp = httpServletRequest.getParameter("prpLverifyLossRiskCode");
			String nextHandlerCode = httpServletRequest.getParameter("nextHandlerCode");
			String nextHandlerName = httpServletRequest.getParameter("nextHandlerName");
			String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno
			String checkInput = httpServletRequest.getParameter("checkInput"); //工作流logno
			Collection nextNodeList = new ArrayList();

			int nextNodeNo = 0;
			if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
				user.setRiskCode(riskCodeTemp);
			}
			//以下是业务使用
			String registNo = httpServletRequest.getParameter("prpLverifyLossRegistNo"); //报案号
			String claimNo = httpServletRequest.getParameter("prpLverifyLossClaimNo"); //赔案号
			String lossItemCode = httpServletRequest.getParameter("prpLverifyLossLossItemCode"); //损失代码
			String lossItemName = httpServletRequest.getParameter("prpLverifyLossLossItemName"); //损失名称
			String verifyPriceFlag = httpServletRequest.getParameter("verifyPriceFlag"); //是否需要核价标志
			//reason: 防止重复提交--------------------------------------------------------------------
			String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime() / 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCertainLossLastAccessedTime");
			//理算退回的定损，并且是没有增加任何记录的标记，如果为1，说明，可以直接提交到理算去。
			String NextComeBackCompensate=httpServletRequest.getParameter("NextComeBackCompensate");
			//add by miaowenjun 20060922 获取险类
			String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCodeTemp);
			
			if (oldLastAccessedTime==null||oldLastAccessedTime.trim().equals("")) {
				httpServletRequest.getSession().setAttribute("oldCertainLossLastAccessedTime", strLastAccessedTime);

				//防止回退刷新再提交，或多人同时操作提交同一案件。
				UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
				String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus ='4'";
			    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
			    if(certifyNodeList!=null&&certifyNodeList.size()>0){
			    	   throw new UserException(1,3,"工作流","该案件定损节点已处理！");
			    }
			    /*
			    String taskCode = SysConfig.getProperty("FamilySplittingFlag","claim");
			    if (httpServletRequest.getParameter("prpLverifyLossRiskCode") != null &&taskCode.indexOf(httpServletRequest.getParameter("prpLverifyLossRiskCode")) > -1) {
			    	 //start耳标号真实性判断add by 张菊卿
				    String[] prplCompensateEarEarNo =httpServletRequest.getParameterValues("prplCompensateEarEarNo");
				    String   prpLCompensatePolicyNo  = httpServletRequest.getParameter("prpLverifyLossPolicyNo");

				    for(int index = 1;index < prplCompensateEarEarNo.length;index++)
					{
				    	if(prpLCompensatePolicyNo == null || prplCompensateEarEarNo[index] == null ) throw new UserException(1, 3, "保单号或耳标号为空", "");
				    	if("".equals(prpLCompensatePolicyNo) || "".equals(prplCompensateEarEarNo[index]))  throw new UserException(1, 3, "保单号或耳标号为空", "");
				    	ArrayList herdPolicyListResult = (ArrayList)Utils.findHerdpolicylist(prpLCompensatePolicyNo, prplCompensateEarEarNo[index]);

				    	ArrayList insureMainListDtoList = (ArrayList) herdPolicyListResult.get(0);
						if(insureMainListDtoList == null || insureMainListDtoList.size() == 0)
						{
							break;
						}
						ArrayList herdPolicyListDtoList = (ArrayList)herdPolicyListResult.get(1);
						if(herdPolicyListDtoList == null || herdPolicyListDtoList.size() == 0)
						{
							throw new UserException(1, 3, "耳标号真实性检查", "耳标号真实性检查失败：耳标号"+prplCompensateEarEarNo[index]);
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

				httpServletRequest.setAttribute("registNo", registNo);
				httpServletRequest.setAttribute("claimNo", claimNo);
				ActionMessages messages = new ActionMessages();

				//if(isTokenValid(httpServletRequest,true)){
				//用viewHelper整理界面输入
				CertainLossDto certainLossDto = null;
			
				//modify by miaowenjun 20060922 农险走不同viewhelper
				if("I".equals(riskType)||"H".equals(riskType)||"Q".equals(riskType)||"Z".equals(riskType)||"Y".equals(riskType)){
					AgriCertainLossViewHelper agriCertainLossViewHelper = new AgriCertainLossViewHelper();
					certainLossDto = agriCertainLossViewHelper.viewToDto(httpServletRequest);
				}else{
					DAACertainLossViewHelper dAACertainLossViewHelper = new DAACertainLossViewHelper();
					certainLossDto = dAACertainLossViewHelper.viewToDto(httpServletRequest);
				}

				UIRegistAction uiRegistAction = new UIRegistAction();
				RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
				String businessType = registDto.getPrpLregistDto().getBusinessType();
				String businessType1 = registDto.getPrpLregistDto().getBusinessType1();
				UICertainLossAction uiCertainLossAction = new UICertainLossAction();
				certainLossDto.getPrpLverifyLossDto().setBusinessType(businessType);
				certainLossDto.getPrpLverifyLossDto().setBusinessType1(businessType1);

				if (checkInput != null && checkInput.equals("true")) {
					if (lossItemCode.equals("1")) {
						uiCertainLossAction.save(certainLossDto);
	
					} else {
						uiCertainLossAction.save(certainLossDto);
					}
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.save"));
					//只保存定损信息，不用管工作的情况
				} else {
					//进行与工作流有关的操作
					// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
					//判断是否是直接从0待处理到提交，如果是则先进行业务保存操作 则从0->3 ,从3->4这样的状态变更,由于后来变成人到人的方式，所以去掉以下的代码
					WorkFlowDto workFlowDto = new WorkFlowDto();
					workFlowDto.setSwfNotionDtoList(certainLossDto.getSwfNotionList());
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
					if("D".equals(riskType)){
						/***************除去车险多余的节点start*******************/
						ArrayList<SwfLogDto> list = null;
						ArrayList<SwfPathLogDto>  listPath=null;
						SwfLogDto swfLogdto=null;
						SwfPathLogDto swfPathLogdto=null;
						list = workFlowDto.getSubmitSwfLogDtoList();
						listPath =workFlowDto.getSubmitSwfPathLogDtoList();
						ArrayList<SwfLogDto> listNext=new ArrayList<SwfLogDto>();
						ArrayList<SwfPathLogDto> listpathNext=new ArrayList<SwfPathLogDto>();
						if(list!=null&&!list.isEmpty()){
							for(int i=0;i<list.size();i++){
								swfLogdto =list.get(i);
								if("verif,veriw,propv".indexOf(swfLogdto.getNodeType())>-1){
									listNext.add(swfLogdto);
								}
							}
							int nodeno=listNext.get(0).getLogNo();
							for(int i=0;i<listPath.size();i++){
								swfPathLogdto =listPath.get(i);
								if(nodeno==swfPathLogdto.getEndNodeNo()){
									listpathNext.add(swfPathLogdto);
								}
							}
						}
						workFlowDto.setSubmitSwfLogDtoList(listNext);
						workFlowDto.setSubmitSwfPathLogDtoList(listpathNext);
						
						/***************除去车险多余的节点end*******************/
					}
					
					//保存定损信息
					if (certainLossDto.getPrpLclaimStatusDto().getStatus().equals("4")
							&& workFlowDto.getSubmitSwfLogDtoList() == null) {
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.workflow.submitfalse"));
					} 
					else{
						if(workFlowViewHelper.checkDealDto(workFlowDto)) {
							//add by lixiang start at 2006-4-26
							//reason:增加判断如果是提交操作的话，到理算的时候，要换成是立案号的
							/*
							if ("1".equals(NextComeBackCompensate)
							  		&&workFlowDto.getSubmitSwfLogDtoList()!=null
									&&workFlowDto.getSubmitSwfLogDtoList().size()>0){
//							      设置businessNo,KeyIn的值
								((SwfLogDto)((ArrayList)workFlowDto.getSubmitSwfLogDtoList()).get( 0)).setKeyIn( claimNo);
							  	((SwfLogDto)((ArrayList)workFlowDto.getSubmitSwfLogDtoList()).get( 0)).setBusinessNo( claimNo);
				
							 }
                            	
                            */
							
							uiCertainLossAction.save(certainLossDto, workFlowDto);
							user.setUserMessage(registNo);
						}else{
							uiCertainLossAction.save(certainLossDto);
							user.setUserMessage(registNo + ";注意:没有发现与工作流流程相关任何数据！！");

						}
						if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.submit"));
						} else {
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.certainLoss.save"));
						}
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLclaim.registNo"));
					}
				}

				//} isTokenValid
				saveMessages(httpServletRequest, messages);

				forward = "success";
			}//抛出重复提交提示
			else {
				throw new UserException(1, 3, "工作流", "请不要重复提交");
			}

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
