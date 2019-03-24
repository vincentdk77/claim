package com.gyic.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.CertainLossDto;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLpropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIReinsTrialAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAAClaimViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormInterfaceAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.claimciplatform.dto.custom.Iconstants;
import com.sinosoft.claimciplatform.dto.custom.PlatFormParam;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.reins.out.bl.facade.BLCTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.custom.CReinsTrialDto;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpCreinsTrialDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.gyic.claim.ui.control.viewHelper.AgriCombineClaimViewHelper;

/**
 * 分发HTTP Post 车险理赔立案编辑界面
 * <p>Title: 车险理赔立案编辑界面信息</p>
 * <p>Description: 车险理赔立案编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author lijiyuan,lixiang
 * @version 1.0
 */
public class UILClaimEditPostFacade extends Action {
	private static Log logger = LogFactory.getLog(UILClaimEditPostFacade.class);
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //向前流转
		String claimNo = "";
		/*
		 * 程序思路：
		 *========================================================
		 *[1]保存立案表信息
		 *[2]保存案件状态表信息，strNodeStatus
		 *[3]判断strNodeStatus是不是等于提交，不是的话，直接修改工作流Map中的状态位做Update
		 *[4]如是提交，执行Complate操作。
		 *========================================================
		 */
		String[] arrayRegistNo = httpServletRequest.getParameterValues("registNo");
		try {

			//如果是新登记，则从取号表中取赔案号码，如果是修改，则保持原来的claimNo不变
			//取赔案号
			// 0 表示不需要， 1表示需要
			//String claimNo ="";
			String comCode = "";
			String userCode = "";
			ClaimDto claimDto = null;
			ArrayList<ClaimDto> claimDtoList = new ArrayList<ClaimDto>();
			ArrayList<WorkFlowDto> workFlowDtoList = new ArrayList<WorkFlowDto>();
			UIClaimAction uiClaimAction = new UIClaimAction();
			String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldClaimLastAccessedTime");
			if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
		    	   throw new UserException(1, 3, "工作流", "请不要重复提交");
		       }
			
				httpServletRequest.getSession().setAttribute("oldClaimLastAccessedTime", strLastAccessedTime);
			

				UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
				userCode = user.getUserCode();
				String userLastActionNow = "claimAdd?"; //防止用户重复提交
				String claimControlFlags="";
				if(null != arrayRegistNo && arrayRegistNo.length>0){					
					for(int indexOfRegistNo=0;indexOfRegistNo < arrayRegistNo.length;indexOfRegistNo ++){				
						claimNo = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfRegistNo); //赔案号
						String registNo = httpServletRequest.getParameter("prpLclaimRegistNo_"+indexOfRegistNo);
						//////////////
						UIWorkFlowAction uiWorkFlowActionCheck = new UIWorkFlowAction();
						String strCondition = " registNo = '"+registNo+"' and nodeType = 'claim' and nodestatus !='4'";
						Collection swfLogCollection = null;
						swfLogCollection = uiWorkFlowActionCheck.findNodesByConditions(strCondition);
						if(null == swfLogCollection || swfLogCollection.size()!=1)
							throw new Exception ("节点异常,报案号："+registNo);
						//////////////////
						String riskCode = httpServletRequest.getParameter("prpLclaimRiskCode_"+indexOfRegistNo);   //add by lym 20060605 for 强三
						String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
						String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID_"+indexOfRegistNo); //工作流号码 add 20051228
						String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo_"+indexOfRegistNo); //工作流logno add  20051228

						comCode =  httpServletRequest.getParameter("prpLclaimComCode_"+indexOfRegistNo);
						int year = DateTime.current().getYear();
		
						
						//防止回退刷新再提交，或多人同时操作提交同一案件。
						UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
						String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus in ('4')";
					    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
					    if(certifyNodeList!=null&&certifyNodeList.size()>0){
					    	   throw new UserException(1,3,"工作流","该案件立案节点已处理！");
					    }
						//在立案保存或者提交的时候对查勘和定损环节的处理状态进行判断仅仅对养殖险进行处理
						if("I".equals(riskType)){
							BLClaimFacade blClaimFacade = new BLClaimFacade();
							blClaimFacade.checkNodeStatus(swfLogFlowID);
						}
						
		
						if (claimNo.length() < 1 || claimNo == null) {
							//取号过程还需要进一步完善
							UIBillAction uiBillAction = new UIBillAction();
							String tableName = "prplclaim";
							claimNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
						}
		
						httpServletRequest.setAttribute("claimNo_"+indexOfRegistNo, claimNo);
		
						//用viewHelper整理界面输入
		
						if("I".equals(riskType)||"H".equals(riskType)||"E".equals(riskType)){
							AgriCombineClaimViewHelper agriCombineClaimViewHelper = new AgriCombineClaimViewHelper();
							claimDto = agriCombineClaimViewHelper.viewToDto(httpServletRequest,indexOfRegistNo);
						}
						else{
						    DAAClaimViewHelper dAAClaimViewHelper = new DAAClaimViewHelper();
						    claimDto = dAAClaimViewHelper.viewToDto(httpServletRequest);
						}
						//add by wunier 20080107
						UIRegistAction uiRegistAction = new UIRegistAction();
						RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
						String businessType = registDto.getPrpLregistDto().getBusinessType();
						String businessType1 = registDto.getPrpLregistDto().getBusinessType1();
						String businessFlag = registDto.getPrpLregistDto().getBusinessFlag();
						String otherFlag	= registDto.getPrpLregistDto().getOtherFlag();
						claimDto.getPrpLclaimDto().setBusinessType(businessType);
						claimDto.getPrpLclaimDto().setBusinessType1(businessType1);
						claimDto.getPrpLclaimDto().setBusinessFlag(businessFlag);
						claimDto.getPrpLclaimDto().setOtherFlag(otherFlag);
						//end by wunier 20080107
						//add by fenglei 20080722 按照国元现在的理赔流程,在立案保存后回写表PrpLprop的立案号码
						BLPrpLpropFacade blPrpLpropFacade = new BLPrpLpropFacade();
						String conditions="registNo='"+ registNo +"'";
						Collection PrpLpropDtoList = blPrpLpropFacade.findByConditions(conditions);
				    	 if (PrpLpropDtoList!=null &&PrpLpropDtoList.size()>0 ) {
				    	 	Iterator it = PrpLpropDtoList.iterator();
				    	 	  while(it.hasNext()){
				    	 		 PrpLpropDto prpLpropDto = (PrpLpropDto)it.next();
				    	 		prpLpropDto.setClaimNo(claimNo);
				    	 		blPrpLpropFacade.update(prpLpropDto);
				    	       }
				    	 }
						//end  by fenglei 20080722
						//工作流处理过程
						//-----------------------------------------------------
						// 1requst对象,2本节点的节点类型,3本节点需要更新的状态,4本节点的业务号码,5以后节点的业务号码,6本节点的业务流入号码,7以后节点的业务流出号码
						WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
						SwfLogDto swfLogDtoDealNode = new SwfLogDto();
		
						//add by liuyanmei 20051228 start 
						if (!(swfLogFlowID == null || swfLogFlowID.equals("")) && !(swfLogLogNo == null || swfLogLogNo.equals(""))) {
							swfLogDtoDealNode.setFlowID(swfLogFlowID);
							swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
						}
						//add by liuyanmei 20051228 end 
		
						swfLogDtoDealNode.setNodeType("claim");
						swfLogDtoDealNode.setNodeStatus(claimDto.getPrpLclaimStatusDto().getStatus());
						swfLogDtoDealNode.setBusinessNo(registNo);
						swfLogDtoDealNode.setComCode(comCode);
						swfLogDtoDealNode.setNextBusinessNo(claimNo);
						//考虑 到后来几乎都是用clamno做keyin的数值的。。
						swfLogDtoDealNode.setKeyIn(claimNo);
						swfLogDtoDealNode.setKeyOut(claimNo);
		
						WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
		
						//------------------------------------------------------------
						//保存报案信息
						
		
						if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
								|| (workFlowDto.getSubmit())
								|| (workFlowDto.getClose())) {
							claimDtoList.add(claimDto);
							workFlowDtoList.add(workFlowDto);
							
							//user.setUserMessage("事故号:"+httpServletRequest.getParameter("combineNo"));
						} else {
							//uiClaimAction.save(claimDto);
							//user.setUserMessage(claimNo + ";注意:没有发现与工作流流程相关任何数据！！");
		
						}
						
						//养殖险农险并案改造，暂时屏蔽车险部分。
						//车险平台上传
		//				try{
		//					if (httpServletRequest.getParameter("buttonSaveType").trim()
		//							.equals("4") && "D".equals(riskType)) {
		//						
		//						System.out.println("马上进行交强险平台交互");
		//						boolean isUpload = false;
		//						
		//						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaim(claimNo);
		//						
		//						if(isUpload){
		//							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
		//									RequestType.CLAIM_SIGN,
		//									claimDto.getPrpLclaimDto().getClaimNo(),"", true,"0");
		//							
		//							user.setUserMessage(user.getUserMessage() + "<br>上传车险平台成功!");
		//						}
		//						
		//						System.out.println("马上进行商业险平台交互");
		//						//2011商业险平台交互
		//						String configValue="";
		//						
		//						UIClaimAction uIClaimAction=new UIClaimAction();
		//						ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
		//						String comcode=claimDtopm.getPrpLclaimDto().getComCode();
		//						boolean boo=false;
		//						if("0506".equals(riskCode)){
		//							boo=true;
		//						}
		//						if(boo && comcode!=null && !"".equals(comcode)){
		//							String comCodeSub=comCode.substring(0,2);
		//							BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
		//							CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comCodeSub, "0506");
		//							if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
		//								configValue=cIPlatformConfigDto.getConfigValue();
		//								if("0".equals(configValue)) {//2011	0及时交互，1非及时交互
		//									BLCIClaimSYXPlatFormInterfaceFacade
		//									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
		//											claimNo,
		//											true,cIPlatformConfigDto,"0","");
		//									user.setUserMessage(user.getUserMessage()
		//											+ "<br>立案上传商业险平台成功!");
		//								}else{
		//									BLCIClaimSYXPlatFormInterfaceFacade
		//									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
		//											claimNo,
		//											false,cIPlatformConfigDto,"0","");
		//									user.setUserMessage(user.getUserMessage()
		//											+ "<br>立案上传商业险平台成功!");
		//								}
		//							}
		//						}
		//						
		//						
		//						
		//					}
		//				}catch(ClaimCiPlatFormException e){
		//					e.printStackTrace();
		//					user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败：<br>" + e.getMessage());
		//				}catch(Exception e ){
		//					e.printStackTrace();
		//					user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败<br>" + e.getMessage());
		//				}
						
						  String comCodeSub= swfLogDtoDealNode.getComCode().substring(0,2);
						  if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){/*
					         PrpDriskConfigDto prpDriskConfigDto = new BLPrpDriskConfigFacade().findByPrimaryKey(comCodeSub, riskCode, "CI_TRANSPORT_MODE");
					         if(prpDriskConfigDto != null && "0".equals(prpDriskConfigDto.getConfigValue())){
					         	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.CLAIM, claimDto.getPrpLclaimDto().getClaimNo(), true);
					         }
					         if(prpDriskConfigDto != null && "1".equals(prpDriskConfigDto.getConfigValue())){
					         	BLCIClaimPlatFormInterfaceFacade.getInstance().upload(Iconstants.RequstType.CLAIM, claimDto.getPrpLclaimDto().getClaimNo(), true);
					         } 
						  */}
					         //add end by miaowenjun 20060711
		//			       add end by guolei 20060711 end
					 
						
						//防止重复刷新
						//user.setUserLastAction(userLastActionNow);
						httpServletRequest.setAttribute("prpLclaimDto_"+indexOfRegistNo, claimDto.getPrpLclaimDto());
					
		
					
					UICodeAction uiCodeAction =new UICodeAction();
					String strRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode_"+indexOfRegistNo);
					String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(strRiskCode);
  
				}
					
					if(workFlowDtoList.size() < arrayRegistNo.length)
					{
						user.setUserMessage(httpServletRequest.getParameter("combineNo") + ";注意:没有发现与工作流流程相关任何数据！！");
					}
					else
					{
						user.setUserMessage("事故号:"+httpServletRequest.getParameter("combineNo"));
					}
					ActionMessages messages = new ActionMessages();
					if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
						//add by dongyanqi begin 20050827生成分赔案
						uiClaimAction.save(claimDtoList, workFlowDtoList,comCode, 
								userCode);
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.submit"));
					} else {
						messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.save"));
					}
					//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLafterward.claimNo"));
					saveMessages(httpServletRequest, messages);
					
					if("".equals(claimControlFlags))
						claimControlFlags = getControlFlag(claimDto);
					else claimControlFlags = claimControlFlags + getControlFlag(claimDto);
					//再保中的现金赔款、共同理赔处理: 需要给予提示. 2005-9-28
					  httpServletRequest.setAttribute("com.sinosoft.flag", claimControlFlags);
			}
			//防止重复刷新
			user.setUserLastAction(userLastActionNow);	
			forward = "success";
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.claimBeforeEdit.editClaim");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
			for(int indexOfRegistNo=0;indexOfRegistNo < arrayRegistNo.length;indexOfRegistNo ++){				
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfRegistNo); //赔案号
			putNoback(claimNo);
			}
		}  catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages msgs = new ActionMessages();
			ActionMessage msg = new ActionMessage("title.claimBeforeEdit.editClaim");
			msgs.add(ActionMessages.GLOBAL_MESSAGE, msg);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, msgs);
			forward = "error";
			for(int indexOfRegistNo=0;indexOfRegistNo < arrayRegistNo.length;indexOfRegistNo ++){				
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo_"+indexOfRegistNo); //赔案号
			putNoback(claimNo);
			}
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * 处理再保的现金赔款、共同理赔方案
	 * @param ClaimDto 立案Dto
	 * @return String 提示信息:是否需要现金赔款、共同理赔
	 */
	private String getControlFlag(ClaimDto claimDto) {
		String setControlFlagMsg = ""; //返回提示信息
		String reinsMode = ""; //分保方式 [1]=2：合约
		String treatyNo = ""; //合约编码
		String strControlFlag = ""; //是否“共同理赔/理赔控制”
		boolean blnLargeLoss = false;
		boolean blnCashLoss = false;
		PrpCreinsTrialDto prpCreinsTrialDto = new PrpCreinsTrialDto();
		BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
		FhTreatyDto fhTreatyDto = new FhTreatyDto();
		BLCTrialFacade blCTrialFacade = new BLCTrialFacade();

		try {
			CReinsTrialDto cReinsTrialDto = blCTrialFacade.getCTrialInfo(
					claimDto.getPrpLclaimDto().getPolicyNo(), 
					1, 
					claimDto.getPrpLclaimDto().getDamageStartDate().toString()
					);

			ArrayList prpCreinsTrialDtoList = (ArrayList) cReinsTrialDto.getPrpCreinsTrialDtoList();
			Iterator itTrial = prpCreinsTrialDtoList.iterator();

			while (itTrial.hasNext()) {
				prpCreinsTrialDto = (PrpCreinsTrialDto) itTrial.next();
				reinsMode = prpCreinsTrialDto.getReinsMode().substring(0, 1);

				if (reinsMode.equals("2")) { //为合约分保
					treatyNo = prpCreinsTrialDto.getTreatyNo();

					//根据合约号到fhTreaty表中获取合约信息
					fhTreatyDto = blFhTreatyFacade.findByPrimaryKey(treatyNo);
					strControlFlag = fhTreatyDto.getControlFlag();

					//判断赔案的估损金额是否超过重大赔案通知额
					//如果超过，则提示操作员，需要共同理赔
					if (strControlFlag.equals("1")
							&& claimDto.getPrpLclaimDto().getSumClaim() >= fhTreatyDto.getLargeLossValue()
							&& blnLargeLoss == false) {
						setControlFlagMsg = "此案需要共同理赔.";
						blnLargeLoss = true;
					}

					//判断估损金额是否超过现金赔款通知额
					//如果超过，则提示操作员，需要现金赔款
					if (claimDto.getPrpLclaimDto().getSumClaim() >= fhTreatyDto.getCashLossValue()
							&& blnCashLoss == false) {
						setControlFlagMsg = setControlFlagMsg + "此案需要现金赔款.";
						blnCashLoss = true;
					}
				}
				if (blnLargeLoss == true && blnCashLoss == true) {
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return setControlFlagMsg;
	}

	//add by huangyunzhong 增加出错后放号回归函数 20051208
	private boolean putNoback(String claimNo) throws SQLException, Exception {
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplclaim";
		if (uiBillAction.putNo(tableName, claimNo)) {
			logger.debug("单号放回成功" + claimNo);
		} else {
			logger.debug("单号放回失败" + claimNo);
		}
		return true;
	}
	//add end by huangyunzhong 20051208
}
