package com.sinosoft.claim.ui.control.facade;

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

import com.gyic.claim.bl.facade.BLPlantingsettlelistFacade;
import com.gyic.claim.bl.facade.BLNyxsettlelistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacade;
import com.gyic.claim.bl.facade.BLSettlemainlistFacadeForMedical;
import com.gyic.claim.dto.domain.PlantingsettlelistDto;
import com.gyic.claim.dto.domain.SettlemainlistDto;
import com.gyic.claim.dto.domain.NyxsettlelistDto;
import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLpropFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
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
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.reins.out.bl.action.custom.BLLDangerGetAction;
import com.sinosoft.reins.out.bl.facade.BLCTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLFhTreatyFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLdangerUnitFacade;
import com.sinosoft.reins.out.bl.facade.BLPrpLreinsTrialFacade;
import com.sinosoft.reins.out.bl.facade.BLRepayFacade;
import com.sinosoft.reins.out.dto.custom.CReinsTrialDto;
import com.sinosoft.reins.out.dto.domain.FhTreatyDto;
import com.sinosoft.reins.out.dto.domain.PrpCreinsTrialDto;
import com.sinosoft.reins.out.dto.domain.PrpLdangerUnitDto;
import com.sinosoft.reins.out.dto.domain.PrpLreinsTrialDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
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

		try {

			//如果是新登记，则从取号表中取赔案号码，如果是修改，则保持原来的claimNo不变
			//取赔案号
			// 0 表示不需要， 1表示需要
			//String claimNo ="";
			String comCode = "";
			String userCode = "";
			ClaimDto claimDto = null;

			String strLastAccessedTime = String.valueOf(httpServletRequest.getSession().getLastAccessedTime()/ 1000);
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldClaimLastAccessedTime");
			if (oldLastAccessedTime !=null && !oldLastAccessedTime.trim().equals("")) {
		    	   throw new UserException(1, 3, "工作流", "请不要重复提交");
		       }
			
				httpServletRequest.getSession().setAttribute("oldClaimLastAccessedTime", strLastAccessedTime);
			
				claimNo = httpServletRequest.getParameter("prpLclaimClaimNo"); //赔案号
				String settleListCode=httpServletRequest.getParameter("settleListCode");
				String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
				String riskCode = httpServletRequest.getParameter("prpLclaimRiskCode");   //add by lym 20060605 for 强三
				String riskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
				String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); //工作流号码 add 20051228
				String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo"); //工作流logno add  20051228
				String userLastActionNow = "claimAdd?regist=" + registNo; //防止用户重复提交
				int year = DateTime.current().getYear();

				UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
				comCode =  httpServletRequest.getParameter("prpLclaimComCode");
				userCode = user.getUserCode();
				//防止回退刷新再提交，或多人同时操作提交同一案件。
				UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
				String condition = "flowId ='"+swfLogFlowID+"' and  logno= "+ swfLogLogNo+"  and nodeStatus in ('4')";
			    Collection certifyNodeList = uiWorkFlowAction.findNodesByConditions(condition);
			    if(certifyNodeList!=null&&certifyNodeList.size()>0){
			    	   throw new UserException(1,3,"工作流","该案件立案节点已处理！");
			    }
				//在立案保存或者提交的时候对查勘和定损环节的处理状态进行判断仅仅对养殖险进行处理
			    //add by xiatian  添加种植险判断
				if("I".equals(riskType)||"H".equals(riskType)){
					BLClaimFacade blClaimFacade = new BLClaimFacade();
					blClaimFacade.checkNodeStatus(swfLogFlowID);
				}
				

				if (claimNo.length() < 1 || claimNo == null) {
					//取号过程还需要进一步完善
					UIBillAction uiBillAction = new UIBillAction();
					String tableName = "prplclaim";
					claimNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
				}

				httpServletRequest.setAttribute("claimNo", claimNo);

				//用viewHelper整理界面输入

				if("I".equals(riskType)||"H".equals(riskType)||"E".equals(riskType)){
					AgriClaimViewHelper agriClaimViewHelper = new AgriClaimViewHelper();
					claimDto = agriClaimViewHelper.viewToDto(httpServletRequest);
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
				UIClaimAction uiClaimAction = new UIClaimAction();

				if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate())
						|| (workFlowDto.getSubmit())
						|| (workFlowDto.getClose())) {
					uiClaimAction.save(claimDto, workFlowDto);
					user.setUserMessage(claimNo);
				} else {
					//uiClaimAction.save(claimDto);
					user.setUserMessage(claimNo + ";注意:没有发现与工作流流程相关任何数据！！");

				}
				
				//重新进行危险单位生成===begain 2017-08-16
				if(claimDto.getPrpLRiskUnitDtoList() != null && claimDto.getPrpLRiskUnitDtoList().size() > 0){
				}else{
					BLPrpLdangerUnitFacade prpLdangerUnitFacade = new BLPrpLdangerUnitFacade();
					DBManager dbManager1 = new DBManager();
					BLLDangerGetAction ldangerGetAction = new BLLDangerGetAction();
					try{
			            dbManager1.open(AppConfig.get("sysconst.REINS_JNDI"));
			            dbManager1.beginTransaction();
			            //重新生成
			            ldangerGetAction.getLDangerInfoNewL(claimNo, dbManager1);
			            dbManager1.commitTransaction();
			        }catch(Exception exception){
			            dbManager1.rollbackTransaction();
			            throw exception;
			        }finally{
			            dbManager1.close();
			        }
				}
				//重新进行危险单位生成===end
				
				//车险平台上传
				try{
					
					//上海平台意健险立案信息上传
					boolean isYJXFlag = false;
					boolean isSuccess = false;
					String groupFlag = "";
					String secodeComCode  = "";
					String strPolicyNo = "";//保单号
					BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
					if(claimDto.getPrpLclaimDto() != null){
						strPolicyNo = claimDto.getPrpLclaimDto().getPolicyNo();
						secodeComCode  = blPrpDcompany.getDaaPlatformComCode(claimDto.getPrpLclaimDto().getComCode());
					}
					if("26,27,28".indexOf(riskCode.substring(0, 2)) > -1){
						isYJXFlag = true;
					}					
					if(isYJXFlag && "310000".equals(secodeComCode) && httpServletRequest.getParameter("buttonSaveType").trim().equals("4")){
						System.out.println("------------------上海平台意健险立案接口调用,claimNo= " + claimNo +" --------------------------");
						//根据保单号来查询保单信息,判断该保单是否为团单
						BLPrpCmain blPrpCmain = new BLPrpCmain();
						blPrpCmain.getData(strPolicyNo);	
						DBManager dbManager = new DBManager();
						try {					
							dbManager.open(AppConfig.get("sysconst.DBJNDI"));
							//根据prpcmain.groupNo是否为空判断是否为团单
							if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "0";//个险
								isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "02", claimNo, strPolicyNo, groupFlag, secodeComCode);
							}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "1";//团险
								isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "02", claimNo, strPolicyNo, groupFlag, secodeComCode);
							}
							if(isSuccess){
							    user.setUserMessage(user.getUserMessage() + "<br>意健险立案信息上传平台成功!");
							}else{
								user.setUserMessage(user.getUserMessage() + "<br>意健险立案信息上传平台失败!");
							}
						} catch (Exception e) {
							e.printStackTrace();
							user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
						} finally{//关闭数据源
							dbManager.close();
						}				
					}
					
					if (httpServletRequest.getParameter("buttonSaveType").trim()
							.equals("4") && "D".equals(riskType)) {
						
						System.out.println("马上进行交强险平台交互");
						boolean isUpload = false;
						
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaim(claimNo);
						
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.CLAIM_SIGN,
									claimDto.getPrpLclaimDto().getClaimNo(),"", true,"0");
							
							user.setUserMessage(user.getUserMessage() + "<br>上传车险平台成功!");
						}
						
						System.out.println("马上进行商业险平台交互");
						//2011商业险平台交互
						String configValue="";
						
						UIClaimAction uIClaimAction=new UIClaimAction();
						ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
						String comcode=claimDtopm.getPrpLclaimDto().getComCode();
						boolean boo=false;
						if("0506".equals(riskCode)){
							boo=true;
						}
						if(boo && comcode!=null && !"".equals(comcode)){
							String comCodeSub=comCode.substring(0,2);
							BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
							CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comCodeSub, "0506");
							if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
								configValue=cIPlatformConfigDto.getConfigValue();
								if("0".equals(configValue)) {//2011	0及时交互，1非及时交互
									BLCIClaimSYXPlatFormInterfaceFacade
									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
											claimNo,
											true,cIPlatformConfigDto,"0","");
									user.setUserMessage(user.getUserMessage()
											+ "<br>立案上传商业险平台成功!");
								}else{
									BLCIClaimSYXPlatFormInterfaceFacade
									.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CLAIM_SYX,
											claimNo,
											false,cIPlatformConfigDto,"0","");
									user.setUserMessage(user.getUserMessage()
											+ "<br>立案上传商业险平台成功!");
								}
							}
						}
						
						
						
					}
					//山东意外险风险预警立案登记上传平台
					if(httpServletRequest.getParameter("buttonSaveType").trim().equals("4") 
							&& AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(riskCode)>-1 && "370000".equals(secodeComCode)){
						System.out.println("-----山东意外险风险预警系统-立案登记接口调用,claimNo= " + claimNo +" -----");
						//根据保单号来查询保单信息,判断该保单是否为团单
						BLPrpCmain blPrpCmain = new BLPrpCmain();
						blPrpCmain.getData(strPolicyNo);	
						DBManager dbManager = new DBManager();
						try{
							dbManager.open(AppConfig.get("sysconst.DBJNDI"));
							if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "0";//个体
							}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "1";//团体
							}
							isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L01", claimNo, groupFlag);
							if(isSuccess){
							    user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警立案登记接口上传成功!");
							}else{
								user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警立案登记接口上传失败!");
							}
						}catch(Exception e){
							e.printStackTrace();
							user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
						}finally{
							dbManager.close();
						}
					}
				}catch(ClaimCiPlatFormException e){
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败：<br>" + e.getMessage());
				}catch(Exception e ){
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败<br>" + e.getMessage());
				}
				
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
				user.setUserLastAction(userLastActionNow);
				httpServletRequest.setAttribute("prpLclaimDto", claimDto.getPrpLclaimDto());
			

			ActionMessages messages = new ActionMessages();
			UICodeAction uiCodeAction =new UICodeAction();
			String strRiskCode = httpServletRequest.getParameter("prpLclaimRiskCode");
			String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(strRiskCode);
			 
			if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
			
				
				//add by dongyanqi begin 20050827生成分赔案
				
				Collection dangerTrial = new BLPrpLreinsTrialFacade().findByConditions("certiNo = '" + claimNo + "'");
				//如果没有分摊试算，首先进行分摊试算
				if (dangerTrial == null || dangerTrial.size() == 0) {
					new UIReinsTrialAction().simulateRepayByDangerNo(claimNo,claimNo);
					getControlFlag(claimDto);
				}
				Collection dangerUnit = new BLPrpLdangerUnitFacade().findByConditions("certiNo = '" + claimNo + "'");
				if (dangerUnit != null) {
					Iterator iter = dangerUnit.iterator();
					while (iter.hasNext()) {
						PrpLdangerUnitDto prpLdangerUnitDto = (PrpLdangerUnitDto) iter.next();
						 String newRepayNo = new BLRepayFacade().genRepay(
								claimNo, 
								prpLdangerUnitDto.getDangerNo(),
								comCode, 
								userCode,
								prpLdangerUnitDto.getClaimADDTimes()
								);
						if (!newRepayNo.equals("")) {
							new BLRepayFacade().checkRepay(newRepayNo, userCode);
						}
					}
				} //add by dongyanqi end 20050827生成分赔案
				
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.claim.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLafterward.claimNo"));
			saveMessages(httpServletRequest, messages);

			
			  //再保中的现金赔款、共同理赔处理: 需要给予提示. 2005-9-28
			  //httpServletRequest.setAttribute("com.sinosoft.flag", getControlFlag(claimDto));
			  //立案保存向理赔清单回写立案号
				if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3149,3148,3174,3150,3151,3197,3185,3165,3166,3184,3152,3153,3154,3155,3156,3228,3224,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3179,3187,3178,3158,3176,3201,3204,3238,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3177,3163,3168,3169,3182".indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
					SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
					settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
					settlemainlistDto.setRegistercode(claimNo);
					blSettlemainlistFacade.update(settlemainlistDto);
					}
				}
				if("2801".indexOf(riskCode) > -1)
				{
					if(!"".equals(settleListCode)&&null!=settleListCode){
						BLSettlemainlistFacadeForMedical blSettlemainlistFacadeForMedical=new BLSettlemainlistFacadeForMedical();
						SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
						settlemainlistDto=blSettlemainlistFacadeForMedical.findByPrimaryKey(settleListCode);
						settlemainlistDto.setRegistercode(claimNo);
						blSettlemainlistFacadeForMedical.update(settlemainlistDto);
						}
				}
				
				//多险别多标的种植险理赔：立案保存向理赔清单回写立案号。
				String planting31FarmerListFlag = SysConfig.getProperty("PLNATING_31_FARMER_LIST_FLAG","claim");
				if((null != planting31FarmerListFlag && planting31FarmerListFlag.indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
						BLSettlemainlistFacade blSettlemainlistFacade=new BLSettlemainlistFacade();
						SettlemainlistDto settlemainlistDto =new SettlemainlistDto();
						settlemainlistDto=blSettlemainlistFacade.findByPrimaryKey(settleListCode);
						settlemainlistDto.setRegistercode(claimNo);
						blSettlemainlistFacade.update(settlemainlistDto);
					}
				}
				//上一环节以缮制清单，本环节未缮制直接点击保存,需要将清单子表数据变更节点状态转储
				if(("3101,3107,3108,3122,3114,3126,3143,3145,3139,3142,3144,3146,3161,3162,3164,3186,3185,3165,3166,3184,3149,3148,3174,3150,3151,3197,3152,3153,3154,3155,3156,3190,3191,3132,3157,3181,3170,31A6,3172,3194,3193,3187,3178,3179,3158,3176,3177".indexOf(riskCode) > -1)){
					if(!"".equals(settleListCode)&&null!=settleListCode){
					PlantingsettlelistDto plantingsettlelistDto=null;
					BLPlantingsettlelistFacade blPlantingsettlelist=new BLPlantingsettlelistFacade();
					String strCondition=" settleListCode='"+settleListCode+"' and nodetype='claim'";
					String strCondition1=" settleListCode='"+settleListCode+"' and nodetype='check'";
					Collection plantingsettlelist=blPlantingsettlelist.findByConditions(strCondition);
					ArrayList plantingsettlelist1=(ArrayList)blPlantingsettlelist.findByConditions(strCondition1);
					ArrayList arrPlantingsettlelist=new ArrayList();
					if(plantingsettlelist.size()<1){
						if(plantingsettlelist1.size()>1){
							for(int i=0;i<plantingsettlelist1.size();i++){
							plantingsettlelistDto=new PlantingsettlelistDto();
							plantingsettlelistDto=(PlantingsettlelistDto)plantingsettlelist1.get(i);
							plantingsettlelistDto.setNodetype("claim");
							arrPlantingsettlelist.add(plantingsettlelistDto);
							}
							blPlantingsettlelist.insert(arrPlantingsettlelist);
						}		
					}
					}
				}
				//yx
				//if("3224".equals(riskCode))
				  if("3224,3201,3204,3238,3228,3232,3215,3219,3221,3226,3229,3230,3231,3235,3237,3222,3102,3105,3124,3125,3127,3159,3139,3167,3160,3128,3130,3131,3133,3134,3135,3136,3137,3138,3171,3173,3175,3189,3183,3180,3192,3196,3163,3168,3169,3182".indexOf(riskCode)>-1)
				{
					if(!"".equals(settleListCode)&&null!=settleListCode){
						NyxsettlelistDto nyxsettlelistDto=null;
						BLNyxsettlelistFacade blNyxsettlelistFacade=new BLNyxsettlelistFacade();
						String strCondition=" settleListCode='"+settleListCode+"' and nodetype='claim'";
						String strCondition1=" settleListCode='"+settleListCode+"' and nodetype='check'";
						Collection plantingsettlelist=blNyxsettlelistFacade.findByConditions(strCondition);
						ArrayList plantingsettlelist1=(ArrayList)blNyxsettlelistFacade.findByConditions(strCondition1);
						ArrayList arrPlantingsettlelist=new ArrayList();
						if(plantingsettlelist.size()<1){
							if(plantingsettlelist1.size()>1){
								for(int i=0;i<plantingsettlelist1.size();i++){
									nyxsettlelistDto=new NyxsettlelistDto();
									nyxsettlelistDto=(NyxsettlelistDto)plantingsettlelist1.get(i);
									nyxsettlelistDto.setNodetype("claim");
								arrPlantingsettlelist.add(nyxsettlelistDto);
								}
								blNyxsettlelistFacade.insert(arrPlantingsettlelist);
							}		
						}
						}
					
				}
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
			putNoback(claimNo);
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
			putNoback(claimNo);
		}
		return actionMapping.findForward(forward);
	}

	/**
	 * 处理再保的现金赔款、共同理赔方案
	 * @param ClaimDto 立案Dto
	 * @return String 提示信息:是否需要现金赔款、共同理赔
	 */
	/*
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
	*/
	/*
	 * 重大赔案通知标志的更新方法
	 */
	public void largelossUpdate(ClaimDto claimDto,String largeLossFlag){
		String greatClaimConditions = "update prpldangerunit set largelossflag = '"+largeLossFlag+"' where claimNo = '"+claimDto.getPrpLclaimDto().getClaimNo()+"'";
		try {
			new BLPrpLdangerUnitFacade().updateByconditions(greatClaimConditions);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * 处理再保的现金赔款、共同理赔方案
	 * @param ClaimDto 立案Dto
	 * @return String 提示信息:是否需要现金赔款、共同理赔
	 */
	private String getControlFlag(ClaimDto claimDto) {
		String setControlFlagMsg = ""; //返回提示信息
		String reinsMode = "";   //分保方式 [1]=2：合约
		String treatyNo = "";  //合约编码
		String strControlFlag = ""; //是否“共同理赔/理赔控制”
		String strLargeValueFlag = ""; // "1"为"立案(合约)估损，"0"为"危险单位估损"
		String treatyFormalNo = ""; // 实际合约号
		BLFhTreatyFacade blFhTreatyFacade = new BLFhTreatyFacade();
		FhTreatyDto fhTreatyDto = new FhTreatyDto();
		PrpLreinsTrialDto prpLreinsTrialDto = new PrpLreinsTrialDto();

		try {
			Collection trialList = new ArrayList();
			boolean flag = false;
			Collection dangerTrial = new BLPrpLreinsTrialFacade()
					.findByConditions("certiNo = '"
							+ claimDto.getPrpLclaimDto().getClaimNo() + "'");
			Iterator itTrial2 = dangerTrial.iterator();
			if ((dangerTrial != null) && (dangerTrial.size() != 0)) {
				while (itTrial2.hasNext()) {
					prpLreinsTrialDto = (PrpLreinsTrialDto) itTrial2.next();
					reinsMode = prpLreinsTrialDto.getReinsMode();
					if ((reinsMode.substring(0, 1)).equals("2")) {
						flag = false;
						treatyNo = prpLreinsTrialDto.getTreatyNo();
						// 根据合约号到fhtraty表中获取合约信息
						fhTreatyDto = blFhTreatyFacade
								.findByPrimaryKey(treatyNo);
						// 获取实际合约号
						treatyFormalNo = fhTreatyDto.getTreatyFormalNo();
						prpLreinsTrialDto.setTreatyNo(treatyFormalNo);
						strControlFlag = fhTreatyDto.getControlFlag();
						if (strControlFlag == null
								|| "".equals(strControlFlag)
								|| strControlFlag.length() < 1) {
							continue;
						}
						if (!"".equals(fhTreatyDto.getLargeLossFlag())) {
							prpLreinsTrialDto.setFlag(fhTreatyDto
									.getControlFlag().substring(0, 1)
									+ fhTreatyDto.getLargeLossFlag());
						} else {
							prpLreinsTrialDto.setFlag(fhTreatyDto
									.getControlFlag().substring(0, 1) + "2");
						}
						prpLreinsTrialDto.setSumPaid(fhTreatyDto
								.getLargeLossValue());
						Iterator iterator = trialList.iterator();
						while (iterator.hasNext()) {
							PrpLreinsTrialDto trialDto = (PrpLreinsTrialDto) iterator
									.next();
							if (trialDto.getTreatyNo().equals(treatyFormalNo)) {
								trialDto.setSumClaim(trialDto.getSumClaim()
										+ prpLreinsTrialDto.getSumClaim());
								flag = true;
								break ; 
							}

						}
						if (flag == false) {
							trialList.add(prpLreinsTrialDto);
						}
					}
				}
			}
			if (trialList != null && trialList.size() > 0) {
				Iterator iterator = trialList.iterator();
				while (iterator.hasNext()) {
					PrpLreinsTrialDto trialDto = (PrpLreinsTrialDto) iterator
							.next();
					strControlFlag = trialDto.getFlag().substring(0, 1);
					strLargeValueFlag = trialDto.getFlag().substring(1, 2);
					if ("1".equals(strControlFlag)) {
						if ("0".equals(strLargeValueFlag)
								&& claimDto.getPrpLclaimDto().getSumClaim() > prpLreinsTrialDto
										.getSumPaid()) {
							// 更新
							String greatClaimConditions = "update prpldangerunit set largelossflag = '1' where claimNo = '"
									+ claimDto.getPrpLclaimDto().getClaimNo()
									+ "' ";
							new BLPrpLdangerUnitFacade()
									.updateByconditions(greatClaimConditions);

						} else if ("1".equals(strLargeValueFlag)
								&& prpLreinsTrialDto.getSumClaim() > prpLreinsTrialDto
										.getSumPaid()) {
							String greatClaimConditions = "update prpldangerunit set largelossflag = '1' where claimNo = '"
									+ claimDto.getPrpLclaimDto().getClaimNo()
									+ "' ";
							new BLPrpLdangerUnitFacade()
									.updateByconditions(greatClaimConditions);
							break;
						}
					}
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return setControlFlagMsg;
	}
}
