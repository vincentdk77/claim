package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIClaimDemandDto;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.ciplatform.ui.action.UICIClaimDemandAction;
import com.sinosoft.claim.bl.action.custom.BLWorkFlowAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLRegistRPolicyAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimBillManagerAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLclaimLossAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLltextAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayBillAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpayExtAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrpLrecaseAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaydetailAction;
import com.sinosoft.claim.bl.action.domain.BLPrplfiscalpaymainAction;
import com.sinosoft.claim.bl.action.domain.BLPrplpayAction;
import com.sinosoft.claim.bl.action.domain.BLSwfLogAction;
import com.sinosoft.claim.bl.action.domain.BLSwfPathLogAction;
import com.sinosoft.claim.bl.facade.BLPrpDuserFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayBillFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpayExtFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.ClaimDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLpayBillDto;
import com.sinosoft.claim.dto.domain.PrpLpayExtDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrpLrecaseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.DAAEndcaseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.PaymentFiscalViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimAcciSdPlatFormInterfaceFacade;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

public class UIWorkFlowApprovalInterFaceFacade {

	public String submitApprovalPlatform(String NodeType, String LflowID,
			String LlogNo, String businessNo, String riskCode,
			String classCode, String comCode, String handlerCode,
			String makecom, String userCode, String handler1Code,
			String contractNo) throws Exception {

		String certiType = "";
		String modelType = "";
		String uwFlowID = "";
		// 立案注销
		if ("ClaimCance".equals(NodeType)) {
			certiType = "O";
			modelType = "60";
			// 重开赔案
		} else if ("ClaimRecase".equals(NodeType)) {
			certiType = "B";
			modelType = "62";
		} else if ("MedicalAutoVeric".equals(NodeType)){
			certiType = "M";
			modelType = "22";
		}else if ("MedicalAutoRecasApprov".equals(NodeType)){
			certiType = "RA";
			modelType = "62";
		}else if ("MedicalAutoCancleApprov".equals(NodeType)) {
			certiType = "CA";
			modelType = "60";
		}else if ("MedicalAutoPaymentApprov".equals(NodeType)) {
			certiType = "PA";
			modelType = "54";
		}else if ("VeriPay".equals(NodeType)) {
			certiType = "V";
			modelType = "54";
		} else if ("PayMentRevoke".equals(NodeType)) {//主动撤回
			certiType = "D";
			modelType = "54";
		}else {
			throw new Exception("未知类型的审批类型，请联系系统管理员");
		}

		/** ***t提交审核平台，理赔任务挂起**** */
		if ("O".equals(certiType)) {
			BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
			String nodeStatus = AppConfig.get("sysconst.NODESTATUS");
			String nodeStatusBack = AppConfig.get("sysconst.NODESTATUS_BACK");
			String nodeStatusSave = AppConfig.get("sysconst.NODESTATUS_SAVE");
			String sql = "flowid='"
					+ LflowID
					+ "' and nodeStatus='0' and nodeType not in ('rcanc','cjust','rcase')";
			blSwfLogFacade.updateNodeStatus(nodeStatus, sql);

			String sqlBack = "flowid='"
					+ LflowID
					+ "' and nodeStatus='3' and nodeType not in ('rcanc','cjust','rcase')";
			blSwfLogFacade.updateNodeStatus(nodeStatusBack, sqlBack);

			String sqlSave = "flowid='"
					+ LflowID
					+ "' and nodeStatus='2' and nodeType not in ('rcanc','cjust','rcase')";
			blSwfLogFacade.updateNodeStatus(nodeStatusSave, sqlSave);
		}
		uwFlowID = submitVericTask(LflowID, LlogNo, modelType, certiType,
				businessNo, riskCode, classCode, comCode, handlerCode, makecom,
				userCode, handler1Code, contractNo);

		return uwFlowID;
	}

	/**
	 * 在双核流程流转中产生新任务
	 * 
	 * @param LflowID
	 *            String 理赔工作流号码
	 * @param LlogNo
	 *            String 理赔工作流节点号码
	 * @param modelType
	 *            String 模板类型 11:核保模板/22:核赔模板
	 * @param certiType
	 *            String 业务类型 T/P/E/C/Y
	 * @param businessNo
	 *            String 业务号
	 * @param riskCode
	 *            String 险种代码
	 * @param classCode
	 *            String 险类代码
	 * @param comCode
	 *            String 业务归属
	 * @param handlerCode
	 *            String 经办人代码
	 * @param makecom
	 *            String 出单部门
	 * @param userCode
	 *            String 系统操作人员
	 * @param handler1Code
	 *            String 业务归属人代码
	 * @param contractNo
	 *            String 合同号（一般针对车险、现只对车险核保有意义
	 * @throws Exception
	 * @return String
	 */
	public String submitVericTask(String LflowID, String LlogNo,
			String modelType, String certiType, String businessNo,
			String riskCode, String classCode, String comCode,
			String handlerCode, String makecom, String userCode,
			String handler1Code, String contractNo) throws Exception {
		
		String uwFlowID = "";

		UIWFApprovalClientFacade uiwApprovalClientFacade = new UIWFApprovalClientFacade();
		// 判断是否往双核送数据
		String SERVER_OPEN = AppConfig.get("sysconst.UW_URLOPEN");
		if (SERVER_OPEN.equals("1")) {
			uwFlowID = uiwApprovalClientFacade.sendXMLData(LflowID, LlogNo,
					modelType, certiType, businessNo, riskCode, classCode,
					comCode, handlerCode, makecom, userCode, handler1Code,
					contractNo);
		} else {
			uwFlowID = "1111111111111111111111111";
		}
		System.out.println("获得uwFlowID＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝" + uwFlowID);
		return uwFlowID;
	}
	
	/**
	 * 审批平台回写理赔工作流数据：审核通过，审核不通过情况
	 * 
	 * @param LflowID
	 *            String 理赔工作流号码
	 * @param LlogNo
	 *            int 理赔工作流节点号码
	 * @param businessNo
	 *            String 业务号码
	 * @param notionInfo
	 *            String 审批意见 人员名 时间时间
	 * @param handlerCode
	 *            String 操作员
	 * @throws Exception
	 * @return boolean
	 */

	public int writeClaimCance(String LflowID, int LlogNo, String businessNo,
			String notionInfo, String handlerCode, String str) throws Exception{
		
		// 取赔款计算书号
		String compensateNo = businessNo;
		String nodeType = "";
		String nodeStatus = "";
		String swfLogFlowID = LflowID; // 工作流号码
		int swfLogLogNo = LlogNo; // 工作流logno
		String keyString = ""; // 工作流keyIn
		UserDto user = new UserDto(); // 因为不是用户自己操作的，所以目前暂时认为就是计算机做的
		user.setUserCode(handlerCode);
		user.setUserName("审批平台");
		SwfLogDto swfLogDto = new SwfLogDto();

		BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
		swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);

		int checkFlag = swfLogDto.getLogNo();
		if (checkFlag < 0)
			return checkFlag;
		if (checkFlag == 0)
			return checkFlag;
		keyString = swfLogDto.getKeyIn();// 获得立案号码
		user.setComCode(swfLogDto.getHandleDept());
		user.setComName(swfLogDto.getDeptName());
		DBManager dbManager = new DBManager();
		
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			BLSwfLogAction blSwfLogFacade = new BLSwfLogAction();
			// 整理工作流的DTO，返回最新的一条工作流数据
			boolean upload = false;
			if ("PassOldClaimCance".equals(str)){

				/***************************************************************
				 * 1.更新立案节点
				 **************************************************************/
				ArrayList<SwfLogDto> list = (ArrayList<SwfLogDto>) blSwfLogFacade
						.findByConditions(dbManager, "businessNO='"
								+ businessNo + "' and nodeType='claim'");
				if (list != null && !list.isEmpty()) {
					SwfLogDto swfLogDto2 = list.get(0);
					swfLogDto2.setNodeStatus("6");
					blSwfLogFacade.update(dbManager, swfLogDto2);
				}
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				swfLogDto.setNodeStatus("4");
				BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
				PrpLclaimDto prpLclaimDto = ((ArrayList<PrpLclaimDto>) blPrpLclaimAction
						.findByConditions(dbManager, "claimNo='" + businessNo
								+ "'")).get(0);
				/** ********************************* */
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplcaseno";
				String comCode = user.getComCode();
				String riskCode = BusinessRuleUtil.getRiskCode(prpLclaimDto
						.getClaimNo(), "ClaimNo");
				int year = DateTime.current().getYear();
				 DAAEndcaseViewHelper endCaseViewHelper= new DAAEndcaseViewHelper();
				String caseNo = endCaseViewHelper.getCaseNo(businessNo, comCode);
				prpLclaimDto.setCaseNo(caseNo);
				prpLclaimDto.setEndCaseDate(new DateTime(DateTime.current()
						.toString(), DateTime.YEAR_TO_SECOND));
				prpLclaimDto.setEndCaserCode(user.getUserCode());
				prpLclaimDto.setCaseNo(caseNo);
				prpLclaimDto.setCaseType("0");
				// 最后通过的时候才写这个数据的的
				prpLclaimDto.setCancelDate(new DateTime(DateTime.current()
						.toString(), DateTime.YEAR_TO_DAY));
				BLPrpLRegistRPolicyAction blPrpLRegistRPolicyAction = new BLPrpLRegistRPolicyAction();
				PrpLRegistRPolicyDto prpLRegistRPolicyDto = blPrpLRegistRPolicyAction
						.findByPrimaryKey(dbManager,
								prpLclaimDto.getRegistNo(), prpLclaimDto
										.getPolicyNo());
				//统一报案需求：立案注销修改
				prpLRegistRPolicyDto.setValidStatus("0");
				prpLRegistRPolicyDto.setClaimNo(businessNo);
				
				
				blPrpLclaimAction.update(dbManager, prpLclaimDto);
				blPrpLRegistRPolicyAction.update(dbManager,
						prpLRegistRPolicyDto);
				// 是否所有立案都结案了,如果都结案了，就需要做工作流转储
				boolean isAllClaimEnd = false;
				isAllClaimEnd = isAllClaimEnd(dbManager, swfLogFlowID);
				WorkFlowDto workFlowDto = null;
				if (isAllClaimEnd) {
					swfLogDto.setEndFlag("1");// 设置为1则会进行转储
				}
				workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDto);
				SwfLogDto updateDto = workFlowDto.getUpdateSwfLogDto();
				updateDto.setBusinessNo(businessNo);
				blWorkFlowAction.deal(dbManager, workFlowDto);
				upload = true;
				
				//调用过河兵同步状态接口 start
				try{
	  	    		UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
		  		    uiClaimSynStatusFacade.synRegistStatus(swfLogDto.getRegistNo(), "4");
	  	    	}catch(Exception e){
	  	    		e.printStackTrace();
	  	    	}
				//调用过河兵同步状态接口 end
			}else{
				BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
				blSwfPathLogAction.deleteByConditions(dbManager, "flowid='"
						+ swfLogFlowID + "' and endnodeNo='" + swfLogLogNo
						+ "'");
				blSwfLogFacade.delete(dbManager, LflowID, LlogNo);
				BLPrpLltextAction bLltextAction = new BLPrpLltextAction();
				bLltextAction.deleteByConditions(dbManager, "claimNo='"
						+ businessNo + "'");
			}
			
			nodeStatus = AppConfig.get("sysconst.NODESTATUS");
			backNodeStatus(dbManager, swfLogFlowID);
//			backMessageNew(dbManager, swfLogDto.getNodeType(), notionInfo,
//					swfLogDto.getRegistNo(), swfLogDto.getRiskCode(),
//					handlerCode, swfLogDto.getHandleDept() , str);
			dbManager.commitTransaction();
			
			if(upload){
				PrpLclaimDto prpLclaimDto = (PrpLclaimDto) new BLPrpLclaimFacade().findByPrimaryKey(businessNo);
				
				System.out.println("============上海平台意健险立案注销信息上传平台begin============");
				//上海平台意健险立案信息上传
				boolean isYJXFlag = false;
				boolean isSuccess = false;
				String secodeComCode = "";
				String groupFlag = "";
				String registNo = prpLclaimDto.getRegistNo();
				String strPolicyNo = prpLclaimDto.getPolicyNo();//保单号
				BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
				//根据保单号来查询保单信息,判断该保单是否为团单
				BLPrpCmain blPrpCmain = new BLPrpCmain();
				blPrpCmain.getData(strPolicyNo);
				if(blPrpCmain.getSize() > 0){
					secodeComCode = blPrpDcompany.getDaaPlatformComCode(blPrpCmain.getArr(0).getComCode());
				}
				//目前确认意健险的险类为26,27,28三个;
				if("26,27,28".indexOf(prpLclaimDto.getRiskCode().substring(0,2)) > -1){
					isYJXFlag = true;
				}
				if(isYJXFlag && "310000".equals(secodeComCode)){
					System.out.println("------------------上海平台意健险立案注销接口调用,claimNo= " + businessNo +" --------------------------");
					try {
						if(blPrpCmain.getSize() > 0){
							//dbManager.open(AppConfig.get("sysconst.DBJNDI"));不重复打开数据源
							//根据prpcmain.groupNo是否为空判断是否为团单
							if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "0";//个险
								isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C12", "", businessNo, strPolicyNo, groupFlag, secodeComCode);
							}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
								groupFlag = "1";//团险
								isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C14", "", businessNo, strPolicyNo, groupFlag, secodeComCode);
							}
							if(isSuccess){
							    user.setUserMessage(user.getUserMessage() + "<br>意健险立案注销信息上传平台成功!");
							}else{
								user.setUserMessage(user.getUserMessage() + "<br>意健险立案注销信息上传平台失败!");
							}
						}						
					} catch (Exception e) {
						user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
					} finally{//关闭数据源
						//dbManager.close();
					}				
				}	
				System.out.println("============上海平台意健险立案注销信息上传平台end============");
				
				 //车险平台上传
		     	String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">详细信息</a>)";
				try{
						boolean isUpload = false;
						System.out.println("马上进行交强险平台交互");
						isUpload = BLCIClaimPlatFormCheckAction.checkUploadForClaimCancel(prpLclaimDto.getPolicyNo(), prpLclaimDto.getRegistNo());
						if(isUpload){
							BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
									RequestType.CASE_CANCEL,
									prpLclaimDto.getClaimNo(),"", true,"0");
							
							user.setUserMessage(user.getUserMessage() + "<br>上传车险平台成功!");
						}
						
						
							//2011
							System.out.println("马上进行商业险平台交互");
							String comcode=prpLclaimDto.getComCode();
							String comcodesub="";
							String riskcode=prpLclaimDto.getRiskCode();
							String configValue="";
							boolean boo=false;
							if("0506".equals(riskcode)){
								boo=true;
							}
							if(boo && comcode!=null && !"".equals(comcode)){
								String claimStatus=prpLclaimDto.getStatus();
								comcodesub=comcode.substring(0,2);
								BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
								CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comcodesub, "0506");
								if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
									configValue=cIPlatformConfigDto.getConfigValue();
									if("0".equals(configValue)) {//2011	0及时交互，1非及时交互
										if("4".equals(claimStatus)){
											BLCIClaimSYXPlatFormInterfaceFacade
											.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
													prpLclaimDto.getClaimNo(),
													true,cIPlatformConfigDto,"0","");
										}else{
											BLCIClaimSYXPlatFormInterfaceFacade
											.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
													prpLclaimDto.getRegistNo(),
													true,cIPlatformConfigDto,"0","");
										}
									}else{
										if("4".equals(claimStatus)){
											BLCIClaimSYXPlatFormInterfaceFacade
											.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
													prpLclaimDto.getClaimNo(),
													false,cIPlatformConfigDto,"0","");
										}else{
											BLCIClaimSYXPlatFormInterfaceFacade
											.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.CANCEL_CASE,
													prpLclaimDto.getRegistNo(),
													false,cIPlatformConfigDto,"0","");
										}
										
									}
									user.setUserMessage(user.getUserMessage()+ "<br>立案注销上传商业险平台成功!");
								}
							}
						
						
						
				}catch(ClaimCiPlatFormException e){
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败：<br>" + e.getMessage() + strHerf);
				}catch(Exception e ){
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>上传车险平台失败:<br>" + e.getMessage() + strHerf);
				}
				//山东意外险风险预警立案登记上传平台
				if(AppConfig.get("sysconst.SDACCI_RISKCODE").indexOf(prpLclaimDto.getRiskCode())>-1 && "370000".equals(secodeComCode)){
					System.out.println("-----山东意外险风险预警系统-立案登记接口调用,claimNo= " + businessNo +" -----");
					//根据保单号来查询保单信息,判断该保单是否为团单
					try{
						if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
							groupFlag = "0";//个体
						}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
							groupFlag = "1";//团体
						}
						isSuccess = BLCIClaimAcciSdPlatFormInterfaceFacade.getInstance().upload(dbManager, "L01", businessNo, groupFlag);
						if(isSuccess){
						    user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警立案登记接口上传成功!");
						}else{
							user.setUserMessage(user.getUserMessage() + "<br>山东意外险风险预警立案登记接口上传失败!");
						}
					}catch(Exception e){
						e.printStackTrace();
						user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
					}finally{
						//dbManager.close();
					}
				}
			}
			
		}catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		
		return checkFlag;
	}
	
	
	/**
	 * 审批平台回写理赔工作流数据：审核通过，审核不通过情况
	 * 
	 * @param LflowID
	 *            String 理赔工作流号码
	 * @param LlogNo
	 *            int 理赔工作流节点号码
	 * @param businessNo
	 *            String 业务号码
	 * @param notionInfo
	 *            String 审批意见 人员名 时间时间
	 * @param handlerCode
	 *            String 操作员
	 * @throws Exception
	 * @return boolean
	 */

	public int writeClaimRecase(String LflowID, int LlogNo, String businessNo,
			String notionInfo, String handlerCode, String str) throws Exception{
		
		// 取赔款计算书号
		DBManager dbManager = new DBManager();
		UserDto user = new UserDto(); // 因为不是用户自己操作的，所以目前暂时认为就是计算机做的
		user.setUserCode(handlerCode);
		user.setUserName("审批平台");
		user.setComName("审批平台");
		int checkFlag;
		String claimNo = businessNo;
		String swfLogFlowID = LflowID; // 工作流号码
		int swfLogLogNo = LlogNo; // 工作流logno
		SwfLogDto swfLogDto = new SwfLogDto();
		boolean upLoad=false;
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
		//增加重开赔案通过后理算机构归属
		String flowId = swfLogDto.getFlowID();
		Collection swflogTempList = new BLSwfLogFacade().findByConditions(" flowid='"+flowId+"' and nodetype='compe' order by logno desc");
		if(swflogTempList!=null&&!swflogTempList.isEmpty()){
			SwfLogDto swfLogDtoTemp = (SwfLogDto) swflogTempList.iterator().next();
			user.setComCode(swfLogDtoTemp.getHandleDept());
		}
		checkFlag = swfLogDto.getLogNo();
		if (checkFlag < 0){
			return checkFlag;
		}
		if (checkFlag == 0){
			return checkFlag;
		}
		
		try{
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			BLPrpLclaimLossAction blPrpLclaimLossAction = new BLPrpLclaimLossAction();
			BLPrpLclaimAction blPrpLclaimAction = new BLPrpLclaimAction();
			BLSwfLogAction blSwfLogAction = new BLSwfLogAction();
			dbManager.beginTransaction();
			if ("PassOldClaimRecase".equals(str)){
				ArrayList<SwfLogDto> nextnodeList = new ArrayList<SwfLogDto>();
				swfLogDto.setNodeStatus("4");
				swfLogDto.setNextBusinessNo(swfLogDto.getBusinessNo());
				SwfLogDto nextSwfLogDto = new SwfLogDto();
				nextSwfLogDto.setNodeType("compe");
				nextSwfLogDto.setNodeNo(0);
				nextnodeList.add(nextSwfLogDto);
				swfLogDto.setNextNodeListType("1");
				swfLogDto.setSwfLogList(nextnodeList);
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
						swfLogDto);
				BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
				BLPrpLrecaseAction blPrpLrecaseAction = new BLPrpLrecaseAction();
				int i = blPrpLrecaseAction.getCount(dbManager, "claimNo='"
						+ claimNo + "' order by order by serialno desc");
				PrpLrecaseDto prpLrecaseDto = blPrpLrecaseAction
						.findByPrimaryKey(dbManager, claimNo, i);
				prpLrecaseDto.setFlag("1");
				blPrpLrecaseAction.update(dbManager, prpLrecaseDto);
				blWorkFlowAction.deal(dbManager, workFlowDto);
				upLoad=true;
				
				//调用过河兵同步状态接口 start
				try{
	  	    		UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
		  		    uiClaimSynStatusFacade.synRegistStatus(swfLogDto.getRegistNo(), "6");
	  	    	}catch(Exception e){
	  	    		e.printStackTrace();
	  	    	}
				//调用过河兵同步状态接口 end
			}else{
				BLSwfPathLogAction blSwfPathLogAction = new BLSwfPathLogAction();
				blSwfPathLogAction.deleteByConditions(dbManager, "flowid='"
						+ swfLogFlowID + "' and endnodeNo='" + swfLogLogNo
						+ "'");
				blSwfLogAction.delete(dbManager, swfLogFlowID, swfLogLogNo);
				BLPrpLrecaseAction blPrpLrecaseAction = new BLPrpLrecaseAction();
				int i = blPrpLrecaseAction.getCount(dbManager, "claimNo='"
						+ claimNo + "' order by order by serialno desc");
				blPrpLrecaseAction.delete(dbManager, claimNo, i);//1、删除prplrecase表中的重开记录
				 /**
	             * 2、更新swflog的流状态
	             */
	            String statement1 = " Update swflog g set g.flowstatus ='0' where  flowid='"+swfLogFlowID+"'";
	            dbManager.prepareStatement(statement1);
	            dbManager.executePreparedUpdate();
	            /**
	             * 3、将swflog中的数据插入swflogstore
	             */
	            String statement2 = " Insert into swflogstore  value"+
	                                " select * from swflog where  flowid='"+swfLogFlowID+"'";
	            dbManager.prepareStatement(statement2);
	            dbManager.executePreparedUpdate();
	            /**
	             * 4、删除swflog表中的原有数据
	             */
	            String statement3 = " Delete from swflog where  flowid='"+swfLogFlowID+"'";
	            dbManager.prepareStatement(statement3);
	            dbManager.executePreparedUpdate();
	            /**
	             * 5、更新流程主表的数据
	             */
	            String statement4 = " Update swfflowmain n set n.flowstatus ='0',n.storeflag ='1' where flowid='"+swfLogFlowID+"'";
	            dbManager.prepareStatement(statement4);
	            dbManager.executePreparedUpdate();
			}
//			backMessage(dbManager, swfLogDto.getNodeType(), notionInfo,
//					swfLogDto.getRegistNo(), swfLogDto.getRiskCode(),
//					handlerCode, swfLogDto.getHandleDept());
			dbManager.commitTransaction();
			
			if(upLoad){
				 String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">详细信息</a>)";
		 		 String riskType = new UICodeAction().translateRiskCodetoRiskType(claimNo.substring(1, 5));
		 		 try{
		 			if("D".equals(riskType)){
		 				//交强险平台交互
		 				System.out.println("开始交强险平台交互");
		 				String uploadType = RequestType.RECASE_SIGN;
		 				
		 				boolean isUpload = false;
		 				isUpload = BLCIClaimPlatFormCheckAction.checkUploadForReCase(claimNo);
		 				
		 				if (isUpload) {
		 					BLCIClaimPlatFormInterfaceFacade.getInstance()
		 							.upload(
		 									uploadType,
		 									claimNo, "",true,
		 									"0");

		 					user.setUserMessage(user.getUserMessage()
		 							+ "<br>交强险上传车险平台成功!");
		 				}
						System.out.println("马上进行商业险平台交互");
						//2011
						String comcode="";
						String configValue="";
						boolean boo=false;
						UIClaimAction uIClaimAction=new UIClaimAction();
						ClaimDto claimDtopm=uIClaimAction.findByPrimaryKey(claimNo);
						comcode=claimDtopm.getPrpLclaimDto().getComCode();
						String registNo=claimDtopm.getPrpLclaimDto().getRegistNo();
						if("0506".equals(claimNo.substring(1, 5))){
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
		 				if("0506".equals(claimNo.substring(1, 5))){
		 					try {
								BLCIClaimSYXPlatFormInterfaceFacade
								.getInstance().upload(com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.RECASE_SYX,
										claimNo,
										true,cIPlatformConfigDto,"0","");
								user.setUserMessage(user.getUserMessage()+ "<br>重开赔案上传商业险平台成功!");
		 						user.setUserMessage(user.getUserMessage() + "<br>商业险上传车险平台成功!");
		 					} catch (com.sinosoft.ciplatform.dto.custom.ClaimCiPlatFormException e) {
		 						user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
		 					}
		 				}
		 				
		 			}
				    }
		 			}
		 		  }catch(ClaimCiPlatFormException e){
		 			e.printStackTrace();
		 			user.setUserMessage(user.getUserMessage() + "<br>交强险上传车险平台失败：<br>" + e.getMessage() + strHerf);
		 		  }catch(Exception e ){
		 			e.printStackTrace();
		 			user.setUserMessage(user.getUserMessage() + "<br>交强险上传车险平台失败:<br>" + e.getMessage() + strHerf);
		 		  }  
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		
		return checkFlag;
	}
	
	
	/**
	 * 检查增加内容是不是合法
	 * 
	 * @param flowID
	 *            String
	 * @param logNo
	 *            int
	 * @param businessNo
	 *            String
	 * @param swfLogDto
	 *            SwfLogDto
	 * @throws Exception
	 * @return int
	 */
	private SwfLogDto checkFlowNode(String flowID, int logNo, String businessNo)
			throws Exception {
		// 检查工作流是否合法。。
		UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
		System.out.println("flowID=" + flowID);
		System.out.println("logNo=" + logNo);
		System.out.println("businessNo=" + businessNo);
		SwfLogDto swfLogTemp = uiWorkFlowAction.findNodeByPrimaryKey(flowID,
				logNo);
		SwfLogDto swfLogDto = new SwfLogDto();
		// 没查询到工作流，有错误
		if (swfLogTemp == null) {
			swfLogDto.setLogNo(-1);
			System.out.println("没查询到工作流，有错误");
			return swfLogDto;
		}
		// 业务号不是这个工作流上的业务号码，直接返回false
		if (!swfLogTemp.getBusinessNo().equals(businessNo)) {
			swfLogDto.setLogNo(-2);
			System.out.println("业务号不是这个工作流上的业务号码");
			return swfLogDto;
		}
		// 已经回退过了
		if (swfLogTemp.getNodeStatus().equals("5")) {
			swfLogDto.setLogNo(-3);
			System.out.println("已经回退过了的案件");
			return swfLogDto;
		}

		// 已经提交过了，直接返回ture
		if (swfLogTemp.getNodeStatus().equals("4")) {
			swfLogDto.setLogNo(0);
			System.out.println("已经提交过了的案件");
			return swfLogDto;
		}

		swfLogDto = swfLogTemp;

		// 没有问题的
		return swfLogDto;
	}

	/**
	 * 判断特定报案所有立案是否已结案
	 * 
	 * @param dbManager
	 * @param flowID
	 * @return
	 * @throws Exception
	 */
	public boolean isAllClaimEnd(DBManager dbManager, String flowID)
			throws Exception {
		boolean isAllClaimEnd = false;
		BLSwfLogAction blSwfLogFacade = new BLSwfLogAction();
		List<SwfLogDto> logList = (List<SwfLogDto>) blSwfLogFacade
				.findByConditions(dbManager, "flowid='" + flowID
						+ "' and nodeType='claim' and nodeStatus <> '6' ");
		if (logList == null || logList.size() == 0) {
			return true;
		}

		return isAllClaimEnd;
	}
	
	private void backNodeStatus(DBManager dbManager,String swfLogFlowID) throws Exception{
		BLSwfLogAction blSwfLogFacade = new BLSwfLogAction();
		
		String nodeStatus = AppConfig.get("sysconst.NODESTATUS");
		String nodeStatusBack = AppConfig.get("sysconst.NODESTATUS_BACK");
		String nodeStatusSave = AppConfig.get("sysconst.NODESTATUS_SAVE");
		String sql = "flowid='"
				+ swfLogFlowID
				+ "' and nodeStatus='"+nodeStatus+"' and nodeType not in ('rcanc','cjust','rcase')";
		blSwfLogFacade.updateNodeStatus(dbManager,"0", sql);
		
		String sqlBack = "flowid='"
			+ swfLogFlowID
			+ "' and nodeStatus='"+nodeStatusBack+"' and nodeType not in ('rcanc','cjust','rcase')";
		blSwfLogFacade.updateNodeStatus(dbManager,"3", sqlBack);
	
	    String sqlSave = "flowid='"
			+ swfLogFlowID
			+ "' and nodeStatus='"+nodeStatusSave+"' and nodeType not in ('rcanc','cjust','rcase')";
	    blSwfLogFacade.updateNodeStatus(dbManager,"2", sqlSave);
	}
	
	/**
	 * 审批平台回写理赔工作流数据：审核通过，审核不通过情况
	 * 
	 * @param LflowID
	 *            String 理赔工作流号码
	 * @param LlogNo
	 *            int 理赔工作流节点号码
	 * @param businessNo
	 *            String 业务号码
	 * @param notionInfo
	 *            String 审批意见 人员名 时间时间
	 * @param handlerCode
	 *            String 操作员
	 * @throws Exception
	 * @return boolean
	 */

	public int writeVeriPay(String LflowID, int LlogNo, String businessNo,
			String notionInfo, String handlerCode, String str) throws Exception {

		// 取赔款计算书号
		DBManager dbManager = new DBManager();
		int checkFlag=100;
		String claimNo = businessNo;
		//String swfLogFlowID = LflowID; // 工作流号码
		//int swfLogLogNo = LlogNo; // 工作流logno
		//SwfLogDto swfLogDto = new SwfLogDto();
		//BLWorkFlowAction blWorkFlowAction = new BLWorkFlowAction();
		//swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
		
		//checkFlag = swfLogDto.getLogNo();
		// 取赔款计算书号
		String keyString = ""; // 工作流keyIn
		UserDto user = new UserDto(); // 因为不是用户自己操作的，所以目前暂时认为就是计算机做的
		user.setUserCode(handlerCode);
		PrpDuserDto userDto = new BLPrpDuserFacade().findByPrimaryKey(handlerCode);
		user.setUserName(userDto.getUserName());
		user.setComCode(userDto.getComCode());
		user.setComName(userDto.getUserName());

		// 保存赔款计算书信息,如果双核可以直接写这边的业务数据库，就不需要这一步了。
		//swfLogDto = checkFlowNode(swfLogFlowID, swfLogLogNo, businessNo);
		//keyString = swfLogDto.getKeyIn();// 获得立案号码
		//user.setComCode(swfLogDto.getHandleDept());
		//user.setComName(swfLogDto.getDeptName());
		//WorkFlowDto workFlowDto = null;
//		if (checkFlag < 0)
//			return checkFlag;
//		if (checkFlag == 0)
//			return checkFlag;
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbManager.beginTransaction();
			BLPrplpayAction blPrplpayAction=new BLPrplpayAction();
			BLPrpLpaymainAction blPrpLpaymainAction=new BLPrpLpaymainAction();
			BLPrpLpayExtAction blBLPrpLpayExtAction = new BLPrpLpayExtAction();
			if ("PassOldVeriPay".equals(str)) {
				//user.setUserName("审核平台通过");
				
				//workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo,
				//		"4", businessNo, businessNo, businessNo, businessNo, false);
				
				//blPrplpayAction.updateVFlag(dbManager, "4", "", businessNo);//更新支付信息状态为已审核
				ArrayList list = null;
				if(null!=businessNo && !"".equals(businessNo) && businessNo.startsWith("F")){
					new BLPrplfiscalpaydetailAction().updateVFlag(dbManager,"8", businessNo);
					new BLPrplfiscalpaymainAction().updateByKey(dbManager, businessNo, "8","2");	
					PaymentFiscalViewHelper paymentFiscalViewHelper = new PaymentFiscalViewHelper();
					paymentFiscalViewHelper.payrefrecRemovePlanfee(dbManager,businessNo);
				}else if(null!=businessNo && !"".equals(businessNo) && businessNo.startsWith("H")){
					BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
					PrpLpayBillDto prpLpayBillDto = null;
					list = (ArrayList)blPrpLpayBillAction.findByConditions(dbManager, " billNo = '"+businessNo+"' ");
					if(list!=null&&list.size()>0){
						String sql1 = "";
						String sql2 = "";
						String sql3 = "";
						sql1 = "update prplpaymain set vflag='8',thirdpayflag='3',VerifyFlag='1' where exists (select 1 from prplpaybill where prplpaybill.paymentno=prplpaymain.paymentno and prplpaybill.payamount>=0 and billno='"+businessNo+"')";
						sql2 = "update prplpaymain set vflag='8',thirdpayflag='a',VerifyFlag='1' where exists (select 1 from prplpaybill where prplpaybill.paymentno=prplpaymain.paymentno and prplpaybill.payamount<0 and billno='"+businessNo+"')";
						sql3 = "update prplpay set vflag='8' where exists (select 1 from prplpaybill where prplpaybill.paymentno=prplpay.serialno and billno='"+businessNo+"')";
						dbManager.executeUpdate(sql1);
						dbManager.executeUpdate(sql2);
						dbManager.executeUpdate(sql3);
					}
				}else{
					blPrplpayAction.updateVFlag(dbManager,  "8",businessNo);
					PrpLpaymainDto prplpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager,businessNo);
					prplpaymainDto.setVflag("8");
					prplpaymainDto.setVerifyFlag("1");
					if(prplpaymainDto.getPayAmount()<0){
						prplpaymainDto.setThirdPayFlag("a");//更新第三方支付标识
					}else{
						BLPrpLpaymainFacade blprpLpaymainFacade = new BLPrpLpaymainFacade();
						List<PrpLpaymainDto> listpaymain =(ArrayList<PrpLpaymainDto>)blprpLpaymainFacade.findByConditions("paymentno='"+businessNo+"'");
						String payway = listpaymain.get(0).getPayWay();
						/*if("1".equals(AppConfig.get("sysconst.NEWPAYMENT"))&&"1".equals(payway)){
							prplpaymainDto.setThirdPayFlag("f");//新支付平台第三方支付标识
						}else{
							prplpaymainDto.setThirdPayFlag("3");//更新第三方支付标识
						}*/
						prplpaymainDto.setThirdPayFlag("3");//更新第三方支付标识
					}
					blPrpLpaymainAction.update(dbManager, prplpaymainDto);
					//通过打印输出校验审核通过了状态是否正确，
//					System.out.println("校验是否审核通过状态：Vflag="+prplpaymainDto.getVflag()+"   VerifyFlag="+prplpaymainDto.getVerifyFlag()
//							+"   ThirdPayFlag="+prplpaymainDto.getThirdPayFlag());
				}
				//blPrpLpaymainAction.updateByKey(dbManager, businessNo, "4");
				//user.setComCode(prplpaymainDto.getComCode());
				//ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayAction.findByConditions(dbManager," serialno='"+businessNo+"'");
				//插入支付占用处理意见的操作
				PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();
				prpLpayExtDto.setPaymentNo(businessNo);
				int count = new BLPrpLpayExtFacade().getCount(" paymentNo='"+businessNo+"' ")+1;
				prpLpayExtDto.setSerialNo(count);
				prpLpayExtDto.setComCode(user.getComCode());
				prpLpayExtDto.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
				prpLpayExtDto.setNodeType("vpay");
				prpLpayExtDto.setNodeName("支付审批");
				prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
				prpLpayExtDto.setOperatorCode(user.getUserCode());
				prpLpayExtDto.setOperatorCodeName(user.getUserName());
				prpLpayExtDto.setFlag("Y");
				prpLpayExtDto.setNotionCode("4");
				prpLpayExtDto.setNotionName("审核通过");
				String[] strMessageStrings = notionInfo.split(" ");
				String context = strMessageStrings[strMessageStrings.length - 1];
				prpLpayExtDto.setContext(context);
				blBLPrpLpayExtAction.insert(dbManager,prpLpayExtDto);
				//生成通知单
				//若未勾选合并下发则直接生成通知单
				/*if(!"1".equals(prplpaymainDto.getMergerFlag().trim())){
					String noticeNo = new PaymentViewHelper().mergerIssued(businessNo, user.getUserCode(), prplpaymainDto.getComCode(),
							prplpaymainDto.getReceiverFullName());
					prplpaymainDto.setNoticeNo(noticeNo);
					prplpaymainDto.setVflag("8");
					if(prplpaymainDto.getPayAmount()<0){
						prplpaymainDto.setThirdPayFlag("a");//更新第三方支付标识
					}else{
						prplpaymainDto.setThirdPayFlag("3");//更新第三方支付标识
					}
					blPrpLpaymainAction.update(dbManager, prplpaymainDto);
					blPrplpayAction.updateVFlag(dbManager,"8",businessNo);
					// 处理意见记录
					*//**
					prpLpayExtDto = new PrpLpayExtDto();
					prpLpayExtDto.setPaymentNo(businessNo);
					count = blBLPrpLpayExtAction.getCount(dbManager," paymentNo='"+businessNo+"' ")+1;
					prpLpayExtDto.setSerialNo(count);
					prpLpayExtDto.setComCode(user.getComCode());
					prpLpayExtDto.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
					prpLpayExtDto.setNodeType("vpay");
					prpLpayExtDto.setNodeName("支付审批");
					prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
					prpLpayExtDto.setOperatorCode(user.getUserCode());
					prpLpayExtDto.setOperatorCodeName(user.getUserName());
					prpLpayExtDto.setFlag("Y");
					prpLpayExtDto.setNotionCode("8");
					prpLpayExtDto.setNotionName("合并下发");
					prpLpayExtDto.setContext("合并下发");
					blBLPrpLpayExtAction.insert(dbManager,prpLpayExtDto);
					*//*
				}*/
				
			}
			//放弃的方法调用
			else if("GiveUpOldVeriPay".equals(str)){
				//user.setUserName("审核平台放弃任务");
				ArrayList list = null;
				if(null!=businessNo && !"".equals(businessNo) && businessNo.startsWith("F")){
					new BLPrplfiscalpaydetailAction().updateVFlag(dbManager,"6", businessNo);
					new BLPrplfiscalpaymainAction().updateByKey(dbManager, businessNo, "6","1");	
				}else if(null!=businessNo && !"".equals(businessNo) && businessNo.startsWith("H")){
					BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
					PrpLpayBillDto prpLpayBillDto = null;
					list = (ArrayList)blPrpLpayBillAction.findByConditions(dbManager, " billNo = '"+businessNo+"' ");
					if(list!=null&&list.size()>0){
						for(int i=0;i<list.size();i++){
							prpLpayBillDto = (PrpLpayBillDto)list.get(i);
							blPrplpayAction.updateVFlag(dbManager, "6",prpLpayBillDto.getPaymentNo());
							blPrpLpaymainAction.updateByKey(dbManager, prpLpayBillDto.getPaymentNo(), "6");
						}
					}
				}else{
					blPrplpayAction.updateVFlag(dbManager, "6",businessNo);
					blPrpLpaymainAction.updateByKey(dbManager, businessNo, "6");
				}

			}
			else {
				//user.setUserName("审核平台回退");
				// 目前在接口中，如果双核没有写我们的业务库，那么就用这个保存，如果已经写了我们的业务库，那么只要保存工作流数据就可以了
				// uiCompensateAction.approve(compensateNo,user.getUserCode(),underWriteFlag);
				// 如果成功的话，存在工作流，那么就需要提交工作流，如果没有就算了
//				workFlowDto = getWorkFlowDto(user, swfLogFlowID, swfLogLogNo,
//						"5", claimNo, keyString, keyString, claimNo, false);
//				SwfLogDto vpayLog = workFlowDto.getUpdateSwfLogDto();
//				vpayLog.setHandlerCode(user.getUserCode());
//				vpayLog.setHandlerName(user.getUserName());
				ArrayList list = null;
				if(null!=businessNo && !"".equals(businessNo) && businessNo.startsWith("F")){
					new BLPrplfiscalpaydetailAction().updateVFlag(dbManager,"3", businessNo);
					new BLPrplfiscalpaymainAction().updateByKey(dbManager, businessNo, "3","3");
				}else if(null!=businessNo && !"".equals(businessNo) && businessNo.startsWith("H")){
					BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
					PrpLpayBillDto prpLpayBillDto = null;
					list = (ArrayList)blPrpLpayBillAction.findByConditions(dbManager, " billNo = '"+businessNo+"' ");
					if(list!=null&&list.size()>0){
						for(int i=0;i<list.size();i++){
							prpLpayBillDto = (PrpLpayBillDto)list.get(i);
							blPrplpayAction.updateVFlag(dbManager,  "3",prpLpayBillDto.getPaymentNo());
							blPrpLpaymainAction.updateVflagAndThirdPayFlag(dbManager, prpLpayBillDto.getPaymentNo(), "3", "2");
						}
					}
				}else{
					blPrplpayAction.updateVFlag(dbManager,  "3",businessNo);
					//blPrpLpaymainAction.updateByKey(dbManager, businessNo, "3");
					//blPrpLpaymainAction.updateThirdPayFlag(dbManager, businessNo, "2");//更新第三方支付标识
					blPrpLpaymainAction.updateVflagAndThirdPayFlag(dbManager, businessNo, "3", "2");//同时更新vflag,thirdpayflag标识
				}
				//PrpLpaymainDto prplpaymainDto = blPrpLpaymainAction.findByPrimaryKey(dbManager,businessNo);
				//user.setComCode(prplpaymainDto.getComCode());
				//ArrayList<PrplpayDto> collection = (ArrayList<PrplpayDto>)blPrplpayAction.findByConditions(dbManager," serialno='"+businessNo+"'");
				//插入审批退回处理意见的操作
				PrpLpayExtDto prpLpayExtDto = new PrpLpayExtDto();
				prpLpayExtDto.setPaymentNo(businessNo);
				int count = blBLPrpLpayExtAction.getCount(dbManager," paymentNo='"+businessNo+"' ")+1;
				prpLpayExtDto.setSerialNo(count);
				prpLpayExtDto.setComCode(user.getComCode());
				prpLpayExtDto.setComCName(new UICodeAction().translateComCode(user.getComCode(), true));
				prpLpayExtDto.setNodeType("vpay");
				prpLpayExtDto.setNodeName("支付审批");
				prpLpayExtDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
				prpLpayExtDto.setOperatorCode(user.getUserCode());
				prpLpayExtDto.setOperatorCodeName(user.getUserName());
				prpLpayExtDto.setFlag("Y");
				prpLpayExtDto.setNotionCode("3");
				prpLpayExtDto.setNotionName("下发修改	");
				String[] strMessageStrings = notionInfo.split(" ");
				String context = strMessageStrings[strMessageStrings.length - 1];
				prpLpayExtDto.setContext(context);
				blBLPrpLpayExtAction.insert(dbManager,prpLpayExtDto);
				BLPrpLpayBillAction blPrpLpayBillAction = new BLPrpLpayBillAction();
				PrpLpayBillDto prpLpayBillDto = null;
				ArrayList prpLpayBillList = (ArrayList)blPrpLpayBillAction.findByConditions(dbManager, " businessno = '"+businessNo+"'");
				BLPrpLclaimBillManagerAction blPrpLclaimBillManagerAction = new BLPrpLclaimBillManagerAction();
				BLPrpLpaymainAction blPrpLpaymainActionCheck = new BLPrpLpaymainAction();
				if(prpLpayBillList.size()>0){
					for(int i=0;i<prpLpayBillList.size();i++){
						prpLpayBillDto = (PrpLpayBillDto)prpLpayBillList.get(i);
						//判断是否为清单
						PrpLpaymainDto prpLpaymainDto=blPrpLpaymainActionCheck.findByPrimaryKey(dbManager, prpLpayBillDto.getPaymentNo());
						if(prpLpaymainDto!=null&&prpLpaymainDto.getBillFlag().equals("1"))
							blPrpLclaimBillManagerAction.update(dbManager, prpLpayBillDto.getRegistNo(), prpLpayBillDto.getCompensateNo(), prpLpayBillDto.getSerialNo(), 0, "5");
					}
				}
				//blPrplpayAction.updateVFlag(dbManager, "3", "", businessNo);//更新支付信息状态为已回退
			}
				
			//blWorkFlowAction.deal(dbManager, workFlowDto);
//			backMessage(dbManager, swfLogDto.getNodeType(), notionInfo,
//					swfLogDto.getRegistNo(), swfLogDto.getRiskCode(),
//					handlerCode, swfLogDto.getHandleDept());
			
			dbManager.commitTransaction();
		} catch (Exception e) {
			dbManager.rollbackTransaction();
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbManager.close();
		}
		return checkFlag;
	}
}
