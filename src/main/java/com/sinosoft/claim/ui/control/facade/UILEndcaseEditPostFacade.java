package com.sinosoft.claim.ui.control.facade;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.ui.action.UICIClaimDemandAction;
import com.sinosoft.claim.bl.facade.BLPrpLrecaseFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.EndcaseDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIEndcaseAction;
import com.sinosoft.claim.ui.control.action.UIRecaseAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * 分发HTTP Post 车险理赔结案编辑界面
 * <p>
 * Title: 车险理赔结案编辑界面信息
 * </p>
 * <p>
 * Description: 车险理赔结案编辑界面信息
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company: sinosoft.com.cn
 * </p>
 * 
 * @author liubvo
 * @version 1.0
 */
public class UILEndcaseEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; // 向前流转
		try {
			String strStep = httpServletRequest.getParameter("step"); // 页面标志
			String dfFlag = httpServletRequest.getParameter("dfFlag"); // 页面标志   //add by lym 20060809  for （特殊赔案：垫支付）	
			String claimNo = httpServletRequest.getParameter("prpLendcaseClaimNo1"); // 赔案号
			String strRiskCode = httpServletRequest.getParameter("riskCode"); 			
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			boolean dfendcase=false;    //垫付结案
			DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
			 //add by lym 20060809 start for （特殊赔案：垫支付）	
			
			if ( dfFlag!=null && !dfFlag.equals("") && dfFlag.equals("Y")){
			}else {	
				 //add by lym 20060809 end for （特殊赔案：垫支付）	
			int intCompensateFlag = dAAEndcaseViewHelper.checkCompensate(httpServletRequest, claimNo);
			httpServletRequest.setAttribute("intCompensateFlag",Integer.toString(intCompensateFlag));
			if (intCompensateFlag == 0) { //有问题，如果是垫付，不应该有计算书的，这个是怎么考虑的。
				throw new UserException(1, 3, "endcase", "此立案"+ claimNo +"没有赔款计算书，不能结案！");
					}

			if (intCompensateFlag < 0) { //有计算书，但没通过核赔。
				throw new UserException(1, 3, "endcase", "有没有核赔通过的计算书，不能结案！");
			}
			
			if (intCompensateFlag ==2){
				 dfendcase=true;
			}
			
	}	
			
			
			
			if (claimNo != null) {
				claimNo = claimNo.trim();
				// add by qinyongli 2005-9-6 start
				// reason:对赔案号的存在性进行判断
				boolean isExist = true;
				UIClaimAction claimAction = new UIClaimAction();
				isExist = claimAction.isExist(claimNo);
				if (!isExist) {
					throw new UserException(1, 3, "生成赔案号", "抱歉，您输入的赔案号不存在，请检查！");
				}
			}
		    // add by qinyongli end
			// 把赔案号码设置到页面
			httpServletRequest.setAttribute("claimNo", claimNo);
			// 结案分步骤进行
			if (strStep != null) {
				if (strStep.trim().equals("step1")) {
					// 向立案表写入结案日期和结案员代码
					// 用viewHelper整理界面输入
					//DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
					/**
					 * modify by mengdongdong at 20060315 start
					 * reson:在一步内同时完成结案和归档
					 */
					
					//以下是 的业务需求:要求结案和归档要在一步完成,以避免只结案不归档带来的问题)
					boolean isRecase = dAAEndcaseViewHelper.isRecase(claimNo);
					boolean isGenrateCaseNo = dAAEndcaseViewHelper.isGenrateCaseNo(claimNo);
					boolean isPrepay = false;//特俗赔案是否结案 false没结案 true结案
					if(isGenrateCaseNo == true && isRecase == false){
						isPrepay = dAAEndcaseViewHelper.isPrepay(claimNo);
					}
			     	if (isGenrateCaseNo == true && isRecase == false  && isPrepay == false) {   // isRecase == false 无重开赔案 或 无未结案的重开赔案 
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("title.endcaseEidt.generateCaseNo"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					if (isTokenValid(httpServletRequest, true)) {
						
						String caseNo ="";
						if(isRecase==true || isPrepay==true){ //有未结的重开赔案或特俗赔案已经结案
						UIClaimAction uiClaimmAction =  new  UIClaimAction();
						ClaimDto claimDto  =  uiClaimmAction.findByPrimaryKey(claimNo);
						PrpLclaimDto prpLclaimDto =claimDto.getPrpLclaimDto();
				
							caseNo = prpLclaimDto.getCaseNo();
						}
						else {
						    caseNo = dAAEndcaseViewHelper.getCaseNo(claimNo,user.getComCode());
						} 
						
						httpServletRequest.setAttribute("caseNo", caseNo);
						EndcaseDto endcaseDto = dAAEndcaseViewHelper.viewToDto(httpServletRequest, true);
						// 工作流处理过程
						// -----------------------------------------------------
						// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码????
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();
						swfLogDtoDealNode.setNodeType("endca");
						swfLogDtoDealNode.setNodeStatus("4"); // 默认都是提交
						swfLogDtoDealNode.setBusinessNo(claimNo);
						swfLogDtoDealNode.setNextBusinessNo(claimNo);
						swfLogDtoDealNode.setKeyIn(claimNo);
						swfLogDtoDealNode.setKeyOut(caseNo);
						WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						System.out.println("====caseNo========="+caseNo);
						// ------------------------------------------------------------
						// 保存结案信息
						UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();
				        String comCodeSub= user.getComCode().substring(0,2);
					    PrpDriskConfigDto prpDriskConfigDto = new BLPrpDriskConfigFacade().findByPrimaryKey(comCodeSub,strRiskCode, "CI_TRANSPORT_MODE");
					    if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){/*
					    if(prpDriskConfigDto != null && "0".equals(prpDriskConfigDto.getConfigValue())){
					         	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.ENDCASE, endcaseDto.getPrpLclaimDto().getClaimNo(), true);
					      }
					    if(prpDriskConfigDto != null && "1".equals(prpDriskConfigDto.getConfigValue())){
					      	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.ENDCASE, endcaseDto.getPrpLclaimDto().getClaimNo(), false);
					       } 
					     */}
						if (workFlowViewHelper.checkDealDto(workFlowDto)) { //判断有可以保存的工作流
							
						   if(isRecase==true){ //重开赔案只保存流的东西,回写 prplrecase表
						  
						   	//回写 prplrecase表
						    UIRecaseAction uiRecaseAction =new UIRecaseAction();
						    uiRecaseAction.update(endcaseDto.getPrpLrecaseDto()); 
						    UIClaimAction uiClaimmAction =  new  UIClaimAction();
						    //重开赔案不回写结案时间
						    //uiClaimmAction.updateEndCaseDate(endcaseDto.getPrpLclaimDto().getClaimNo(),endcaseDto.getPrpLrecaseDto().getCloseCaseDate());
						   	UIWorkFlowAction  uiWorkFlowAction = new UIWorkFlowAction();
						   	uiWorkFlowAction.deal(workFlowDto) ; //为什么工作流和业务数据要分开，这就会成为不一个事务了
						   }else{ //一般案件结案
							   uiEndcaseAction.save(endcaseDto, workFlowDto);
							  
						   }
						   user.setUserMessage(caseNo);	
						} else {
							uiEndcaseAction.save(endcaseDto);
					       
							user.setUserMessage(caseNo + ";注意:没有发现与工作流流程相关任何数据！！");
							httpServletRequest.getSession().setAttribute("user", user);
						}
						
						//调用过河兵同步状态接口 start
						try{
							if(null != endcaseDto.getPrpLclaimDto()){
								UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
					  		    uiClaimSynStatusFacade.synRegistStatus(endcaseDto.getPrpLclaimDto().getRegistNo(), "5");
							}
			  	    	}catch(Exception e){
			  	    		e.printStackTrace();
			  	    	}
						//调用过河兵同步状态接口 end
						
						//车险平台上传
						String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">详细信息</a>)";
						String riskType = new UICodeAction().translateRiskCodetoRiskType(endcaseDto.getPrpLclaimDto().getRiskCode());
						
						//上海意健险平台结案接口交互begin
						boolean isYJXFlag = false;
						String groupFlag = "";
						String strPolicyNo = endcaseDto.getPrpLclaimDto().getPolicyNo();//获取保单号
						String upComCode = endcaseDto.getPrpLclaimDto().getComCode();
						upComCode = new BLPrpDcompany().getDaaPlatformComCode(upComCode);
						boolean isSuccess = false;
						DBManager dbManager = new DBManager();
//						if("26,27,28".indexOf(endcaseDto.getPrpLclaimDto().getRiskCode().substring(0,2)) > -1){
//							isYJXFlag = true;
//						}						
//						if(isYJXFlag && "310000".equals(upComCode) && httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
//							System.out.println("------------------上海平台意健险结案接口调用,claimNo= " + claimNo +" --------------------------");
//							//根据保单号来查询保单信息,判断该保单是否为团单
//							BLPrpCmain blPrpCmain = new BLPrpCmain();
//							blPrpCmain.getData(strPolicyNo);	
//							try {					
//								//根据prpcmain.groupNo是否为空判断是否为团单
//								if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
//									groupFlag = "0";//个险
//									isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "03", claimNo,strPolicyNo,groupFlag,upComCode);
//								}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
//									groupFlag = "1";//团险
//									isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "03", claimNo,strPolicyNo,groupFlag,upComCode);
//								}
//								if(isSuccess){
//									user.setUserMessage(user.getUserMessage()+ "<br>上海意健险结案信息上传平台成功!");
//								}else{
//									user.setUserMessage(user.getUserMessage()+ "<br>上海意健险结案信息上传平台失败!");
//								}
//							} catch (Exception e) {
//								e.printStackTrace();								
//			                    throw new Exception(e.getMessage() + "意健险上传平台失败,结案登记失败!");
//							}				
//						}
//						//上海意健险平台结案接口交互end
						try{
							if("D".equals(riskType)){
								System.out.println("马上进行交强险平台交互");
								String uploadType = RequestType.ENDCASE_SIGN;
								BLPrpLrecaseFacade blPrpLrecaseFacade = new BLPrpLrecaseFacade();
								String strCondition = " claimNo = '" + endcaseDto.getPrpLclaimDto().getClaimNo() + "'";
//								Collection collection = blPrpLrecaseFacade.findByConditions(strCondition);
//								if(collection.size() > 0){
//									uploadType = RequestType.ENDCASE_APPEND;
//								}
								
								boolean isUpload = false;
								isUpload = BLCIClaimPlatFormCheckAction.checkUploadForEndCase(claimNo);
								
								if (isUpload) {
									BLCIClaimPlatFormInterfaceFacade.getInstance()
											.upload(
													uploadType,
													endcaseDto.getPrpLclaimDto()
															.getClaimNo(),"", true,
													"0");

									user.setUserMessage(user.getUserMessage()
											+ "<br>上传车险平台成功!");
								}
								
								
								
								//2011商业险
								
								System.out.println("马上进行商业险平台交互");
									//2011
									String riskCode="";
									String comcode="";
									String configValue="";
									boolean boo=false;
									UIClaimAction uIClaimAction=new UIClaimAction();
									ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
									riskCode=claimDtopm.getPrpLclaimDto().getRiskCode();
									comcode=claimDtopm.getPrpLclaimDto().getComCode();
									String registNo=claimDtopm.getPrpLclaimDto().getRegistNo();
									if("0506".equals(riskCode)){
										boo=true;
									}
									if(boo && comcode!=null && !"".equals(comcode)){
										String comCodesub=comcode.substring(0,2);
										BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
										CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comCodesub, "0506");
										if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
											String conditions=" claimno='"+claimNo+"' ";
											UICIClaimDemandAction uICIClaimDemandAction=new UICIClaimDemandAction();
											Collection demandColl=uICIClaimDemandAction.findByConditions(conditions);
											String registFlag="";
											String claimFlag="";
											if(demandColl.iterator().hasNext()){
												CIClaimDemandDto cIClaimDemandDto=(CIClaimDemandDto)demandColl.iterator().next();
												registFlag=cIClaimDemandDto.getRegistUploadFlag();
												claimFlag=cIClaimDemandDto.getClaimUploadFlag();
											}
											
											
											configValue=cIPlatformConfigDto.getConfigValue();
											if("0".equals(configValue)) {//2011	0实时交互，1定时交互
													if(!"1".equals(registFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
																registNo,
																true,cIPlatformConfigDto,"0","");
													}
													if(!"1".equals(claimFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
																claimNo,
																true,cIPlatformConfigDto,"0","");
													}
													BLCIClaimSYXPlatFormInterfaceFacade
													.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.ENDCASE_SYX,
															claimNo,
															true,cIPlatformConfigDto,"0","");
													user.setUserMessage(user.getUserMessage()+ "<br>结案上传商业险平台成功!");
												
											}else{
													if(!"1".equals(registFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
																registNo,
																false,cIPlatformConfigDto,"0","");
													}
													if(!"1".equals(claimFlag)){
														BLCIClaimSYXPlatFormInterfaceFacade
														.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
																claimNo,
																false,cIPlatformConfigDto,"0","");
													}
													
													BLCIClaimSYXPlatFormInterfaceFacade
													.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.ENDCASE_SYX,
															claimNo,
															false,cIPlatformConfigDto,"0","");
												user.setUserMessage(user.getUserMessage()
														+ "<br>结案上传险商业险平台成功!");
											}
										}
									}
								}
								
								
							
						}catch(ClaimCiPlatFormException e){
							e.printStackTrace();
							httpServletRequest.setAttribute("ciClaimException", e);
							user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败：<br>" + e.getMessage() + strHerf);
						}catch(Exception e ){
							e.printStackTrace();
							httpServletRequest.setAttribute("ciClaimException", e);
							user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败:<br>" + e.getMessage() + strHerf);
						}
						//山东意外险风险预警系统对接-结案登记接口(手动结案环节)调用
					    if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(endcaseDto.getPrpLclaimDto().getRiskCode())>-1 && "370000".equals(upComCode)){
					      System.out.println("-----山东意外险风险预警系统对接-结案登记接口(手动结案环节)调用,claimNo= " + endcaseDto.getPrpLclaimDto().getClaimNo() +"-----");
					      try{
					    	  dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					    	  BLPrpCmain blPrpCmain = new BLPrpCmain();
						      blPrpCmain.getData(strPolicyNo);
						      if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
						        groupFlag = "0";//个险
						      }else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
						        groupFlag = "1";//团险
						      }
						      isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L02", endcaseDto.getPrpLclaimDto().getClaimNo(), groupFlag);
						      if(isSuccess){
									user.setUserMessage(user.getUserMessage()+ "<br>山东意外险风险预警系统对接-结案登记接口上传成功!");
								}else{
									user.setUserMessage(user.getUserMessage()+ "<br>山东意外险风险预警系统对接-结案登记接口上传失败!");
								}
					      }catch(Exception e){
					    	  e.printStackTrace();
					    	  throw new Exception(e.getMessage() + "山东意外险风险预警系统对接-结案登记接口上传失败!");
					      }finally{
					    	  dbManager.close();
					      }
					      }
					  //山东意外险风险预警系统对接-结案登记接口(手动结案环节)调用
					}
	
					ActionMessages messages = new ActionMessages();
					messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("prompt.endcase.save"));
					messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("db.prpLcompensate.caseNo"));
					saveMessages(httpServletRequest, messages);
					forward = "success";
					/**
					 * modify by mengdongdong at 20060315 end
					 */
				}
				/**
				 * 为处理遗留的历史数据,暂时保留
				 */
				else if (strStep.trim().equals("step2")) {
					//DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
					// 是否生成过赔案号码
					boolean isGenrateCaseNo = dAAEndcaseViewHelper.isGenrateCaseNo(claimNo);
					if (isGenrateCaseNo == true) {
						ActionMessages messages = new ActionMessages();
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("title.endcaseEidt.generateCaseNo"));
						saveMessages(httpServletRequest, messages);
						return actionMapping.findForward("success");
					}
					dAAEndcaseViewHelper.compensateDtoToView(httpServletRequest, claimNo);
					saveToken(httpServletRequest);
					forward = "step2";
				} else if (strStep.trim().equals("step3")) {
					String caseNo = httpServletRequest.getParameter("prplCaseNoCaseNo1"); // 陪案号
					httpServletRequest.setAttribute("caseNo", caseNo);
					// 用viewHelper整理界面输入
					if (isTokenValid(httpServletRequest, true)) {
						//DAAEndcaseViewHelper dAAEndcaseViewHelper = new DAAEndcaseViewHelper();
						EndcaseDto endcaseDto = dAAEndcaseViewHelper.viewToDto(httpServletRequest, true);
						// 工作流处理过程
						// -----------------------------------------------------
						// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码????
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();
						swfLogDtoDealNode.setNodeType("endca");
						swfLogDtoDealNode.setNodeStatus("4"); // 默认都是提交
						swfLogDtoDealNode.setBusinessNo(claimNo);
						swfLogDtoDealNode.setNextBusinessNo(claimNo);
						swfLogDtoDealNode.setKeyIn(claimNo);
						swfLogDtoDealNode.setKeyOut(caseNo);
						WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						// ------------------------------------------------------------
						// 保存结案信息
						UIEndcaseAction uiEndcaseAction = new UIEndcaseAction();

						if ((workFlowDto.getCreate())
								|| (workFlowDto.getUpdate())
								|| (workFlowDto.getSubmit())
								|| (workFlowDto.getClose())) {
							uiEndcaseAction.save(endcaseDto, workFlowDto);
							user.setUserMessage(caseNo);
						} else {
							uiEndcaseAction.save(endcaseDto);
							user.setUserMessage(caseNo + ";注意:没有发现与工作流流程相关任何数据！！");
							httpServletRequest.getSession().setAttribute("user", user);
						}
					}
					ActionMessages messages = new ActionMessages();

					if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("prompt.endcase.submit"));
					} else {
						messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("prompt.endcase.save"));
					}
					messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("db.prpLcompensate.caseNo"));
					saveMessages(httpServletRequest, messages);
					forward = "success";
				}
			}
		} catch (UserException usee) {
			usee.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.endcaseBeforeEdit.editEndcase");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} catch (Exception e) {
			e.printStackTrace();
			// 错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.endcaseBeforeEdit.editEndcase");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", e.getMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";
		} 
		return actionMapping.findForward(forward);
	}
}
