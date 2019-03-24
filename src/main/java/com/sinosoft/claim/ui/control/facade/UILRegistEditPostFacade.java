package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

import com.sinosoft.bz.common.RequestType;
import com.sinosoft.ciplatform.bl.action.domain.BLCIPlatformConfigAction;
import com.sinosoft.ciplatform.bl.facade.BLCIClaimSYXPlatFormInterfaceFacade;
import com.sinosoft.ciplatform.bl.facade.BLCIPlatformConfigFacade;
import com.sinosoft.ciplatform.dto.domain.CIPlatformConfigDto;
import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriRegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.DAARegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claimciplatform.bl.action.custom.BLCIClaimPlatFormCheckAction;
import com.sinosoft.claimciplatform.bl.facade.BLCIClaimPlatFormInterfaceFacade;
import com.sinosoft.claimciplatform.dto.custom.ClaimCiPlatFormException;
import com.sinosoft.common_claim.bl.action.custom.BLCIClaimPropPlatFormInterfaceFacade;
import com.sinosoft.platform.bl.facade.BLPrpDriskConfigFacade;
import com.sinosoft.platform.dto.domain.PrpDriskConfigDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.undwrt.bl.facade.BLPrpCmainFacade;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/**
 * 分发HTTP Post 车险理赔报案编辑界面
 * <p>Title: 车险理赔报案编辑界面信息</p>
 * <p>Description: 车险理赔报案编辑界面信息</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: sinosoft.com.cn</p>
 * @author weishixin
 * @version 1.0
 */
public class UILRegistEditPostFacade extends Action {
	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {

		String forward = ""; //向前流转
		String registNo = "";
		/**
		 * 程序思路：
		 *========================================================
		 *[1]根据claimNo在界面是不是为空，判断是不是第一次保存报案表
		 *[2]为空，则取报案号，并使得intCreateWorkFlowFlag =1
		 *[3]保存报案表信息
		 *[4]保存案件状态表信息，strNodeStatus
		 *[5]如果intCreateWorkFlowFlag =1 创建新流程
		 *[6]判断strNodeStatus是不是等于提交，不是的话，直接修改工作流Map中的状态位做Update
		 *[7]如是提交，执行Complate操作。
		 *
		 *
		 *国元新的需求(种植险)
		 *[1]在报案的时候首先判断是否该保单是否存在报案prplregist中根据报案号查询看是否有数据
		 *[2]|| "H".equals(strRiskType)种植险和养殖险分离,原有的养殖险不变
		 *========================================================
		 */
		try {
			UICodeAction uiCodeAction = new UICodeAction();
			// String strRiskCode = uiCodeAction.translateProductCode("RISKCODE_DAA");
			// String strRiskCodeDAB = uiCodeAction.translateProductCode("RISKCODE_DAB");
			// String strRiskCodeDAE = uiCodeAction.translateProductCode("RISKCODE_DAE");
			//取报案号
			//String registNo = ""; //报案号
			registNo = httpServletRequest.getParameter("prpLregistRegistNo");
			//如果是新登记，则从取号表中取赔案号码，如果是修改，则保持原来的claimNo不变
			String createWorkFlowFlag = "0"; //是否需要创建工作流，如果第一次保存，需要创建工作流 0 表示不需要， 1表示需要
			//防止重复刷新,目前车牌号，保案人，报案日期来判断是不是同一个报案的
			String registReportorName = httpServletRequest.getParameter("prpLregistReportorName");
			String registLicenseNo = httpServletRequest.getParameter("prpLregistLicenseNo");
			String registReportDate = httpServletRequest.getParameter("prpLregistReportDate");
			String registReportHour = httpServletRequest.getParameter("prpLregistReportHour");
			String registPolicyNo = httpServletRequest.getParameter("prpLregistPolicyNo");
			String riskCode = httpServletRequest.getParameter("prpLregistRiskCode");
			String scheduleType = httpServletRequest.getParameter("scheduleType");
			String typeFlag = "";
			String mainPolicyNo = httpServletRequest.getParameter("mainPolicyNo");
			String qsFlag = httpServletRequest.getParameter("qsFlag");
			
			int year = DateTime.current().getYear();
			int nextNodeNo = 0;
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			String comCodePolicy = httpServletRequest.getParameter("prpLregistComCode");
			//传入参数是 节点的类型
			//是否定损调度
			String strScheduleTypeLoss = httpServletRequest.getParameter("nextScheduleTypeLoss");
			//是否查勘调度  
			String strScheduleTypeCheck = httpServletRequest.getParameter("nextScheduleTypeCheck");
			String policyComCode = httpServletRequest.getParameter("prpLregistComCode");
			String strLastAccessedTime = ""	+ httpServletRequest.getSession().getLastAccessedTime()/ 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getValue("oldRegistLastAccessedTime");
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			String strInsuredName = "";
	        //转成对应的交强险险种号
	        TransCodeCI transCodeCI = new TransCodeCI();
	        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode); //取得强制保险的险种代码
			
			if ("ALLS".equals(scheduleType)) {
				typeFlag = "10";
			}

//			if (oldLastAccessedTime != null) {
//				//modify by miaowenjun 20060920 end
//				if (!oldLastAccessedTime.trim().equals("")) {
//					throw new UserException(1, 3, "0000", "请不要重复提交！");
//				}
//			}

			//if(isTokenValid(httpServletRequest,true)){
			if (registNo.length() < 1 || registNo == null) { //取报案号码
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplregist";
				//registNo = uiBillAction.getNo(tableName, riskCode, comCode, year);
				registNo = uiBillAction.getNo(tableName, riskCode,
						policyComCode, year);
				//modify by wangwei add start 2005-06-06
				//原因：在session中存放一个新产生的报案号，用于报案提交或暂存后的打印信息
				// HttpSession  session = httpServletRequest.getSession();
				httpServletRequest.setAttribute("com.sinosoft.registno",
						registNo);
				httpServletRequest.setAttribute("riskCode", riskCode);
				//modify by wangwei add end 2005-06-06

				//registNo = "200000000010305000015";
				createWorkFlowFlag = "1";
			}
			
			httpServletRequest.setAttribute("registNo", registNo);
			httpServletRequest.setAttribute("newWorkFlow", createWorkFlowFlag);
			//为工作流创建的标志
			//用viewHelper整理界面输入
			//modify by miaowenjun 20060922 start 农险走自己的viewhelper
			RegistDto registDto = new RegistDto();
			//以前得版本财产险没有调度,所以针对国元得情况对财产险,责任险,货运险加上调度得控制
			//添加意健险。add by xiatian
			if ("I".equals(strRiskType)
					|| "Q".equals(strRiskType) || "Z".equals(strRiskType)
					|| "Y".equals(strRiskType)|| "H".equals(strRiskType) ||"E".equals(strRiskType)) {
				AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
				registDto = agriRegistViewHelper.viewToDto(httpServletRequest);
			} else {
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				registDto = dAARegistViewHelper.viewToDto(httpServletRequest);
			}
			//modify by miaowenjun 20060922 end 农险走自己的viewhelper
			//工作流的viewHelper整理界面输入
			//add by wunier 20080107
			//reason:种植和养殖险、建房险带出农业/涉农/非农标志以及中央政策性/地方政策性/商业性标志
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PrpCmainDto prpCmainDto = uiPolicyAction
					.findPrpCmainDtoByPrimaryKey(registPolicyNo);
			registDto.getPrpLregistDto().setBusinessType(
					prpCmainDto.getBusinessType());
			registDto.getPrpLregistDto().setBusinessType1(
					prpCmainDto.getBusinessType1());
			registDto.getPrpLregistDto().setBusinessFlag(prpCmainDto.getBusinessFlag());
			registDto.getPrpLregistDto().setOtherFlag(prpCmainDto.getOthFlag());
			//end by wunier 20080107

			WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
			SwfLogDto swfLogDtoDealNode = new SwfLogDto();
			if (createWorkFlowFlag.equals("1")){
				swfLogDtoDealNode.setCreateFlow(true);
			}
			//判断是否受理的状态,如果不受理，设置工作流的参数为工作流程结束状态。
			if (registDto.getPrpLregistDto().getAcceptFlag().equals("N")){
				swfLogDtoDealNode.setEndFlag("1");
			}
			//设置报案传入工作流的各个状态
			swfLogDtoDealNode.setNodeType("regis");
			swfLogDtoDealNode.setNodeStatus(registDto.getPrpLclaimStatusDto().getStatus());
			swfLogDtoDealNode.setBusinessNo(registNo);
			swfLogDtoDealNode.setNextBusinessNo(registNo);
			swfLogDtoDealNode.setKeyIn(registNo);
			swfLogDtoDealNode.setKeyOut(registNo);
			swfLogDtoDealNode.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
			swfLogDtoDealNode.setComCode(comCodePolicy);
			swfLogDtoDealNode.setPolicyNo(registPolicyNo);
			swfLogDtoDealNode.setRegistNo(registNo);//待处理的查询条件，增加报案号，被保险人，车牌号(工作流需要添加)  


			if (registDto.getPrpLregistDto().getInsuredNameShow() != null
					&& !registDto.getPrpLregistDto().getInsuredNameShow()
							.equals("")) {
				strInsuredName = registDto.getPrpLregistDto()
						.getInsuredNameShow();
			} else {
				strInsuredName = registDto.getPrpLregistDto().getInsuredName();
			}
			swfLogDtoDealNode.setInsuredName(strInsuredName);
			swfLogDtoDealNode.setLossItemName(registDto.getPrpLregistDto()
					.getLicenseNo());
			// modify by wangli add start 200504017
			swfLogDtoDealNode.setFlowInTime(registDto.getPrpLregistDto()
					.getFlowInTime().toString());
			// modify by wangli add end 200504017
			//因为人到人的原因/指定节点的问题，目前只有车险这样处理的。
			//modify by qinyongli 车险代码调整，从原来的就一个车险0501改为05××都为车险
			if ("D".equals(strRiskType)
					&& swfLogDtoDealNode.getNodeStatus().equals("4")) {
				String[] strNodeNo = httpServletRequest.getParameterValues("nextNodeNoList");
				Collection nextNodeList = new ArrayList();
				if (strNodeNo != null) {
					for (int i = 0; i < strNodeNo.length; i++) {
						SwfLogDto swfLogNextNode = new SwfLogDto();
						nextNodeNo = Integer.parseInt(strNodeNo[i]);
						swfLogNextNode.setNodeNo(nextNodeNo);
						nextNodeList.add(swfLogNextNode);
					}
				}
				//以上是从模板中读取的必须走的模板信息(注意，上面是节点号码，以下是客户自己选择的信息

				//因为item需要多写内容的。。

				if (strScheduleTypeCheck.equals("1")) { //加入查勘调度
					SwfLogDto swfLogNextNode = new SwfLogDto();
					swfLogNextNode.setNodeNo(0);
					swfLogNextNode.setNodeType("sched");
					swfLogNextNode.setScheduleID(1);
					swfLogNextNode.setLossItemName(registDto.getPrpLregistDto()
							.getScheduleItemNote());
					//设置itemcode的值的大小。
					swfLogNextNode.setLossItemCode(registDto.getPrpLregistDto()
							.getLossItemCode());
					swfLogNextNode.setTypeFlag(typeFlag);
					nextNodeList.add(swfLogNextNode);
				}

				//add by lym 20060202 for 强三 一个报案产生2个立案 ---start
				
			

				if (qsFlag.equals("Y")) {
					SwfLogDto swfLogNextNode = new SwfLogDto();
					swfLogNextNode.setNodeNo(0);
					swfLogNextNode.setNodeType("claim");
					swfLogNextNode.setPolicyNo(mainPolicyNo); //强三保单号
					if("0507".equals(riskCode)){//机动车
						compelRiskCode = "0506";
					}else if("0577".equals(riskCode)){//摩托车
						compelRiskCode = "0576";
					}else if("0587".equals(riskCode)){//拖拉机
						compelRiskCode = "0586";
					}
					swfLogNextNode.setRiskCode(compelRiskCode); // 强三 险种
					swfLogNextNode.setLossItemCode(registDto.getPrpLregistDto()
							.getLossItemCode());
					nextNodeList.add(swfLogNextNode);
				}
				//add by lym 20060202 for 强三 一个报案产生2个立案 ---end

				if (nextNodeList.size() > 0) {
					swfLogDtoDealNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
					swfLogDtoDealNode.setSwfLogList(nextNodeList);
				}
				//add by miaowenjun 20060921 农险也要走调度除了种植险以外的农险走调度
			} else if (("I".equals(strRiskType) )
					&& swfLogDtoDealNode.getNodeStatus().equals("4")) {
				Collection nextNodeList = new ArrayList();
				String[] strNodeNo = httpServletRequest
						.getParameterValues("nextNodeNoList");
				if (strNodeNo != null) {
					for (int i = 0; i < strNodeNo.length; i++) {
						SwfLogDto swfLogNextNode = new SwfLogDto();
						nextNodeNo = Integer.parseInt(strNodeNo[i]);
						swfLogNextNode.setNodeNo(nextNodeNo);
						nextNodeList.add(swfLogNextNode);
					}
				}
				// 以上是从模板中读取的必须走的模板信息(注意，上面是节点号码，以下是客户自己选择的信息
				SwfLogDto swfLogNextNode = new SwfLogDto();
				swfLogNextNode.setNodeNo(0);
				swfLogNextNode.setNodeType("sched");
				swfLogNextNode.setScheduleID(1);
				swfLogNextNode.setLossItemName(registDto.getPrpLregistDto()
						.getScheduleItemNote());
				// 设置itemcode的值的大小。
				swfLogNextNode.setLossItemCode(registDto.getPrpLregistDto()
						.getLossItemCode());
				swfLogNextNode.setTypeFlag(typeFlag);
				nextNodeList.add(swfLogNextNode);

				if (nextNodeList.size() > 0) {
					swfLogDtoDealNode.setNextNodeListType("1");// 如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
					swfLogDtoDealNode.setSwfLogList(nextNodeList);
				}
			}

			// 整理工作流的创建/修改/提交的数据
			WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user,
					swfLogDtoDealNode);

			// 异常测试
			if (registNo.equals("") || registNo.length() != 22) {
				//throw new UserException(-98,-200,"","错误测试");
			}
			//校验出险原因是否为空
			String prpLregistDamageCode = registDto.getPrpLregistDto().getDamageCode();
			String prpLregistDamageName = registDto.getPrpLregistDto().getDamageName();
			String conditions = "select * from prpdcode where codecode in (select ss.codecode "+
		       "from prpdcoderisk ss "+
		       "where ss.riskcode = '"+riskCode+"' "+
		         "and ss.codetype = 'DamageCode' )"+
					"and codetype = 'DamageCode' "+
					"and validstatus = '1'";
			ArrayList PrpDcodeDtoList = (ArrayList)uiCodeAction.findByConditions(UICodeAction.DAMAGECODE,conditions,0,0);
			if(prpLregistDamageCode == null || "".equals(prpLregistDamageCode)){
				user.setUserMessage("出险原因不能为空，请重新录入后再提交！");
				throw new UserException(-98,0,"出险原因不能为空，请重新录入后再提交！");
			}else{
				PrpDcodeDto prpDcodeDto = null;
				for(int j=0;j < PrpDcodeDtoList.size();j++){
					prpDcodeDto = new PrpDcodeDto();
					prpDcodeDto = (PrpDcodeDto)PrpDcodeDtoList.get(j);
					if(prpDcodeDto.getCodeCode().equals(prpLregistDamageCode) && 
							prpDcodeDto.getCodeCName().equals(prpLregistDamageName)	){
						
					}else{
						user.setUserMessage("出险原因代码和出险原因说明不一致，请重新录入后再提交！");
						new UserException(-98,0,"出险原因代码和出险原因说明不一致，请重新录入后再提交！");
					}
				}
			}
			
			UIRegistAction uiRegistAction = new UIRegistAction();

			if (workFlowViewHelper.checkDealDto(workFlowDto)) {
				uiRegistAction.save(registDto, workFlowDto);
				user.setUserMessage(registNo);
			} else {
				if (workFlowDto.getOperateResult() < 0) {
					user.setUserMessage("注意:创建工作流流程时，未找到相关工作流模板的设置，请联系系统管理员进行相应配置！！");
				} else {
					uiRegistAction.save(registDto);
					user.setUserMessage(registNo + ";注意:没有发现与工作流流程相关任何数据！！");
				}
			}
			httpServletRequest.getSession().putValue(
					"oldRegistLastAccessedTime", strLastAccessedTime);
			//       add end by guolei 20060711 begin
			
			//上海平台意健险报案信息上传
			boolean isYJXFlag = false;
			String groupFlag = "";
			BLPrpDcompany blPrpDcompany = new BLPrpDcompany();
			String secodeComCode = blPrpDcompany.getDaaPlatformComCode(registDto.getPrpLregistDto().getComCode());
			//String strPolicyNo = prpLregistDto.getPolicyNo();//保单号
			if("26,27,28".indexOf(riskCode.substring(0,2)) > -1){
				isYJXFlag = true;
			}
			System.out.println(httpServletRequest.getParameter("buttonSaveType").trim());
			if(isYJXFlag && "310000".equals(secodeComCode) && "4".equals(httpServletRequest.getParameter("buttonSaveType").trim())){
				System.out.println("------------------上海平台意健险报案接口调用,registno= " + registNo +" --------------------------");
				//根据保单号来查询保单信息,判断该保单是否为团单
				boolean isSuccess = false;
				BLPrpCmain blPrpCmain = new BLPrpCmain();
				blPrpCmain.getData(registPolicyNo);	
				DBManager dbManager = new DBManager();
				try {					
					dbManager.open(AppConfig.get("sysconst.DBJNDI"));
					//根据prpcmain.groupNo是否为空判断是否为团单
					if(blPrpCmain.getSize() > 0){
						if("01".equals(blPrpCmain.getArr(0).getPolicyType())){
							groupFlag = "0";//个险
							isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C01", "01", registNo, registPolicyNo, groupFlag, secodeComCode);
						}else if("02".equals(blPrpCmain.getArr(0).getPolicyType())){
							groupFlag = "1";//团险
							isSuccess = BLCIClaimPropPlatFormInterfaceFacade.getInstance().upload(dbManager, "C04", "01", registNo, registPolicyNo, groupFlag, secodeComCode);
						}
						if(isSuccess){
						    user.setUserMessage(user.getUserMessage() + "<br>意健险报案信息上传平台成功!");
						}else{
							user.setUserMessage(user.getUserMessage() + "<br>意健险报案信息上传平台失败!");
						}
					}					
				} catch (Exception e) {
					e.printStackTrace();
					user.setUserMessage(user.getUserMessage() + "<br>"+e.getMessage());
				} finally{//关闭数据源
					dbManager.close();
				}				
			}
			
			//车险平台上传
			String strHerf = "(<a href=\"javascript:showErrorInfo('info')\">详细信息</a>)";
			try{
				if (httpServletRequest.getParameter("buttonSaveType").trim()
						.equals("4") && "D".equals(strRiskType)) {
					
					System.out.println("马上进行交强险平台交互");
					//从关联表中取交强险的保单号
					String policyNo = "";
					BLPrpLRegistRPolicyFacade blPrpLregistRPolicyFacade = new BLPrpLRegistRPolicyFacade();
					Collection collection = blPrpLregistRPolicyFacade.findByRegistNo(registDto.getPrpLregistDto().getRegistNo());
					PrpLRegistRPolicyDto prpLregistRPolicyDto = null;
					for(Iterator i = collection.iterator(); i.hasNext();){
						prpLregistRPolicyDto = (PrpLRegistRPolicyDto) i.next();
						if("0507".equals(prpLregistRPolicyDto.getRiskCode())){
							policyNo = prpLregistRPolicyDto.getPolicyNo();
							continue;
						}
					}
					boolean isUpload = false;
					
					isUpload = BLCIClaimPlatFormCheckAction.checkUploadForRegist(policyNo, registDto.getPrpLregistDto().getRegistNo());
					if(isUpload){
						BLCIClaimPlatFormInterfaceFacade.getInstance().upload(
								RequestType.REGIST_SIGN,
								registDto.getPrpLregistDto().getRegistNo(),"", true,"0");
						
						user.setUserMessage(user.getUserMessage() + "<br>上传车险平台成功!");
					}
					
					
					System.out.println("马上进行商业险平台交互");
					//2011
					//商业险上传平台测试
					String configValue="";
					UIRegistAction uIRegistAction=new UIRegistAction();
					RegistDto registDtopm=uIRegistAction.findByPrimaryKey(registNo);
					String comcode=registDtopm.getPrpLregistDto().getComCode();
					boolean boo=false;
					if("0506".equals(riskCode)){//商业险报案
						boo=true;
					}else{//交强险报案,查出关联的商业险报案
						BLPrpLRegistRPolicyFacade blPrpLregistRPolicyFacade2=new BLPrpLRegistRPolicyFacade();
						String condtion=" registno='"+registNo+"' and riskcode='0506' ";
						Collection coll=blPrpLregistRPolicyFacade2.findByConditions(condtion);
						if(coll!=null && coll.size()>0){
							PrpLRegistRPolicyDto prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)coll.iterator().next();
							String policyno=prpLRegistRPolicyDto.getPolicyNo();
							com.sinosoft.prpall.dto.domain.PrpCmainDto prpCmainDtopm=new com.sinosoft.prpall.bl.facade.BLPrpCmainFacade().findByPrimaryKey(policyno);
							if(prpCmainDtopm!=null ){
								comcode=prpCmainDtopm.getComCode();
								boo=true;
							}
						}
					}
					if(boo && comcode!=null && !"".equals(comcode)){
						String comcodeSub=comcode.substring(0,2);
						BLCIPlatformConfigFacade bLCIPlatformConfigFacade=new BLCIPlatformConfigFacade();
						CIPlatformConfigDto cIPlatformConfigDto=bLCIPlatformConfigFacade.findByPrimaryKey("CI_TRANSPORT_MODE", comcodeSub, "0506");
						if(cIPlatformConfigDto!=null && "1".equals(cIPlatformConfigDto.getValidStatus())){
							if("0".equals(cIPlatformConfigDto.getConfigValue())) {//2011	0及时交互，1非及时交互
								BLCIClaimSYXPlatFormInterfaceFacade
										.getInstance()
										.upload(
												com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
												registNo,
												true,cIPlatformConfigDto,"0","");
								user.setUserMessage(user.getUserMessage()
										+ "<br>报案上传商业险平台成功!");
							}else{
								BLCIClaimSYXPlatFormInterfaceFacade
								.getInstance()
								.upload(
										com.sinosoft.ciplatform.dto.custom.Iconstants.ZJRequstType.REGIST_SYX,
										registNo,
										false,cIPlatformConfigDto,"0","");
								user.setUserMessage(user.getUserMessage()
										+ "<br>报案上传商业险平台成功!");
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
			
			
			//跟据配置项 SCHEDULE_AUTOCOMMIT，对于需要自动跳转到调度的部门加入自动跳转的功能
			String strSchedule = AppConfig.get("sysconst.SCHEDULE_AUTOCOMMIT");
			String comCodeTemp = user.getComCode().substring(0, 4);
			if (swfLogDtoDealNode.getNodeStatus().equals("4")
					&& "D".equals(strRiskType)
					&& strSchedule.indexOf(comCodeTemp) >= 0) {
				//需要自动跳转,必须是提交后才能进行的跳转
				//要判断是查勘调度，还是定损调度
				String scheduleRef = "/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo="
						+ registNo
						+ "&prpLscheduleMainWFSurveyNo=0"
						+ "&status=0"
						+ "&riskCode="
						+ riskCode
						+ "&editType=ADD";
				String goFlowID = "";
				int goLogNo = 0;
				//查找跳转位置
				if (workFlowDto.getSubmitSwfLogDtoList() != null) {
				}
				if (goLogNo > 0) { //正确找到跳转的位置后
					scheduleRef = scheduleRef + "&swfLogFlowID=" + goFlowID
							+ "&swfLogLogNo=" + goLogNo;
					httpServletResponse.sendRedirect(scheduleRef);
				}
			}

			httpServletRequest.setAttribute("prpLregistDto", registDto
					.getPrpLregistDto());

			//} 

			String registSaveMessage = "q" + registNo;
			ActionMessages messages = new ActionMessages();
			Object obj_msg = registSaveMessage;
			if (httpServletRequest.getParameter("buttonSaveType").trim()
					.equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.regist.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"prompt.regist.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"db.prpLregist.registNo"));
			saveMessages(httpServletRequest, messages);
			httpServletRequest.setAttribute("buttonSaveType", httpServletRequest.getParameter("buttonSaveType").trim());
			//add by zhaolu 20060913 start
			//报案后直接调度
			httpServletRequest.setAttribute("policyNo", registPolicyNo);
			httpServletRequest.setAttribute("handleDept", comCodePolicy);
			//还需要修改判断的条件
			//种植也需要调度add by xiatian 
			if(!"H".equals(strRiskType)||!"0".equals(createWorkFlowFlag) ){
			String swfLogFlowID = workFlowDto.getUpdateSwfLogDto().getFlowID();
			httpServletRequest.setAttribute("swfLogFlowID", swfLogFlowID);
	        }
			//add by zhaolu 20060913 end
			
			
			String scheduleRef1 = httpServletRequest.getParameter("scheduleRef")==null?"":httpServletRequest.getParameter("scheduleRef");
			if("scheduleRef".equals(scheduleRef1)){
				
				String scheduleRedirect="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo="+registNo
				+"&prpLscheduleMainWFSurveyNo=0"
				+"&scheduleType=sched"
				+"&handleDept="+user.getComCode()
				+"&endflag=0"
				+"&commiFlag=0"
				+"&status=0"
				+"&riskCode="+riskCode
				+"&editType=ADD"
				+"&nodeType=sched"
				+"&businessNo="+registNo
				+"&keyIn="+registNo
				+"&schedFlag=Y"
				;
				
				if (workFlowDto.getSubmitSwfLogDtoList() != null) {
					SwfLogDto swfLog = (SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0);
					scheduleRedirect += "&swfLogFlowID="+swfLog.getFlowID()
					+"&swfLogLogNo="+swfLog.getLogNo()+"&policyNo="+swfLog.getPolicyNo()
					+"&modelNo="+swfLog.getModelNo()
					+"&nodeNo="+swfLog.getNodeNo();
				}
				
				httpServletResponse.sendRedirect(scheduleRedirect);
			}else{
				//默认不需要自动跳转
				forward = "success";
			}

		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			//erroeMessage为Unkown Message时，异常信息是自定义的
			if(usee.getErrorMessage().equals("Unkown Message")){
				httpServletRequest.setAttribute("errorMessage", usee
						.getErrorModule());
			}else{
				httpServletRequest.setAttribute("errorMessage", usee
						.getErrorMessage());
			}
			saveErrors(httpServletRequest, errors);
			forward = "error";
			this.putNoback(registNo);
		}

		catch (SQLException sqle) {
			StringWriter stringWriter = new StringWriter();
			sqle.printStackTrace(new PrintWriter(stringWriter));
			sqle.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
			this.putNoback(registNo);
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionErrors errors = new ActionErrors();
			ActionError error = new ActionError(
					
					"title.registBeforeEdit.editRegist");
			errors.add(ActionErrors.GLOBAL_ERROR, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter
					.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";
			this.putNoback(registNo);

		} finally {

		}

		return actionMapping.findForward(forward);
	}

	//add by huangyunzhong 增加出错后放号回归函数 20051208
	public boolean putNoback(String registNo) throws SQLException, Exception {

		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplregist";
		if (uiBillAction.putNo(tableName, registNo)) {
			System.out.println("单号放回成功" + registNo);
		} else {
			System.out.println("单号放回失败" + registNo);
		}
		return true;
	}
	//add end by huangyunzhong 20051208
}
