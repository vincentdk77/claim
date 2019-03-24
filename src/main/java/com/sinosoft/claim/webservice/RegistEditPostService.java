package com.sinosoft.claim.webservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.axis.client.Service;

import com.gyic.claim.bl.facade.BLZh03PolicyListFacade;
import com.gyic.claim.dto.domain.Zh03PolicyListDto;
import com.sinosoft.claim.dto.custom.AcciRegistDto;
import com.sinosoft.claim.dto.custom.AgriRegistDto;
import com.sinosoft.claim.dto.custom.CargoRegistDto;
import com.sinosoft.claim.dto.custom.LiabRegistDto;
import com.sinosoft.claim.dto.custom.PropRegistDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcodeDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.viewHelper.AgriRegistViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.claim.util.XMLHandler;
import com.sinosoft.claim.webservice.client.NewAgriWS.ClaimForRegistServiceSoapBindingStub;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainCasualty;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.prpall.schema.PrpCmainCasualtySchema;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;

public class RegistEditPostService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * 农险报案接口
	 * @param agriRegistDto
	 * @return
	 */
	public String saveAgriRegistDto(AgriRegistDto agriRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("农险报案接口", 1,serial, agriRegistDto);
		String registNo = "";
		try {
			String policyNo = "";
			if(agriRegistDto != null){
				policyNo = agriRegistDto.getPolicyNo();
			}
			UIPolicyAction uiPolicyAction = new UIPolicyAction();
			PrpCmainDto prpCmainDto = uiPolicyAction.findPrpCmainDtoByPrimaryKey(policyNo);
			if(prpCmainDto != null && "agri".equals(prpCmainDto.getSystemFlag())){//新农险
				//String URL = "http://9.0.2.33:9012/services/ClaimForRegistService?wsdl";
				String URL = AppConfig.get("sysconst.NEWAGRI_REGISTSAVE");
				String xml = XMLHandler.getSaveAgriRegistDtoXML(agriRegistDto);
				System.out.println("农险报案接口请求报文："+xml);
				logger.log("农险报案接口请求报文：", 0,serial, xml);
				Service service = new Service();
				ClaimForRegistServiceSoapBindingStub stub = 
						new ClaimForRegistServiceSoapBindingStub(new java.net.URL(URL),service);
				String returnMessage = stub.saveAgriRegistDto(xml);
				System.out.println("农险报案接口返回报文："+returnMessage);
				logger.log("农险报案接口返回报文：", 0,serial, returnMessage);
				String code = returnMessage.substring(returnMessage.indexOf("<code>")+6, returnMessage.indexOf("</code>"));
				if("00".equals(code)){
					registNo = returnMessage.substring(returnMessage.indexOf("<registNo>")+10, returnMessage.indexOf("</registNo>"));
				}
				System.out.println("registNo="+registNo);
			}else{//老理赔
				
				RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
				//校验参数
				RegistEditPostInfoCheckAndTrans.checkAgriRegistDtoInfo(agriRegistDto);
				RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transAgriRegistEditPostInfo(agriRegistDto);
				registNo = saveMainRegistDtoInfo(registEditPostInfo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("农险报案接口",serial,e);
		}
		logger.log("农险报案接口", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * 货运险报案接口
	 * @param cargoRegistDto
	 * @return
	 */
	public String saveCargoRegistDto(CargoRegistDto cargoRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("货运险报案接口", 1,serial, cargoRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//校验参数
			RegistEditPostInfoCheckAndTrans.checkCarRegistDtoInfo(cargoRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transCargoRegistEditPostInfo(cargoRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("货运险报案接口",serial,e);
		}
		logger.log("货运险报案接口", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * 财产险报案接口
	 * @param cargoRegistDto
	 * @return
	 */
	public String savePropRegistDto(PropRegistDto propRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("财产险报案接口", 1,serial, propRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//校验参数
			RegistEditPostInfoCheckAndTrans.checkPropRegistDtoInfo(propRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transPropRegistEditPostInfo(propRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("财产险报案接口",serial,e);
		}
		logger.log("财产险报案接口", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * 意健险报案接口
	 * @param cargoRegistDto
	 * @return
	 */
	public String saveAcciRegistDto(AcciRegistDto acciRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("意健险报案接口", 1,serial, acciRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//校验参数
			RegistEditPostInfoCheckAndTrans.checkAcciRegistDtoInfo(acciRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transAcciRegistEditPostInfo(acciRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("意健险报案接口",serial,e);
		}
		logger.log("意健险报案接口", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	/**
	 * 责任险报案接口
	 * @param cargoRegistDto
	 * @return
	 */
	public String saveLiabRegistDto(LiabRegistDto liabRegistDto){
		long serial = System.currentTimeMillis();
		logger.log("责任险报案接口", 1,serial, liabRegistDto);
		String registNo = "";
		try {
			RegistEditPostInfoCheckAndTrans RegistEditPostInfoCheckAndTrans = new RegistEditPostInfoCheckAndTrans();
			//校验参数
			RegistEditPostInfoCheckAndTrans.checkLiabRegistDtoInfo(liabRegistDto);
			RegistEditPostInfo registEditPostInfo = RegistEditPostInfoCheckAndTrans.transLiabRegistEditPostInfo(liabRegistDto);
			registNo = saveMainRegistDtoInfo(registEditPostInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("责任险报案接口",serial,e);
		}
		logger.log("责任险报案接口", 0,serial, "[registNo:"+registNo+"]");
		return registNo;
	}
	
	
	private String saveMainRegistDtoInfo(RegistEditPostInfo registEditPostInfo){
		String registNo = "";
		boolean flag = false;
		try {
			UICodeAction uiCodeAction = new UICodeAction();
			String createWorkFlowFlag = "0"; //是否需要创建工作流，如果第一次保存，需要创建工作流 0 表示不需要， 1表示需要
			String registReportorName = registEditPostInfo.getPrpLregistReportorName();
			String registReportDate = registEditPostInfo.getPrpLregistReportDate();
			String registReportHour = registEditPostInfo.getPrpLregistReportHour();
			String registPolicyNo = registEditPostInfo.getPrpLregistPolicyNo();
			String riskCode = registEditPostInfo.getPrpLregistRiskCode();
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
			String typeFlag = "";
			String scheduleType = registEditPostInfo.getScheduleType();
			if ("ALLS".equals(scheduleType)) {
				typeFlag = "10";
			}
			
			String strInsuredName = "";
			UserDto user = new UserDto();
			user.setComCode(registEditPostInfo.getUserComCode());
			user.setComName(registEditPostInfo.getUserComName());
			user.setUserCode(registEditPostInfo.getUserCode());
			user.setUserName(registEditPostInfo.getUserName());
			
			//转成对应的交强险险种号
	        TransCodeCI transCodeCI = new TransCodeCI();
	        String compelRiskCode = transCodeCI.convertToRiskCodeCI(riskCode); //取得强制保险的险种代码
			
	        String policyComCode = registEditPostInfo.getPrpLregistComCode();
	        int year = DateTime.current().getYear();
	        int nextNodeNo = 0;
			if (registNo.length() < 1 || registNo == null) { //取报案号码
				UIBillAction uiBillAction = new UIBillAction();
				String tableName = "prplregist";
				registNo = uiBillAction.getNo(tableName, riskCode,
						policyComCode, year);

				createWorkFlowFlag = "1";
			}
			registEditPostInfo.setRegistNo(registNo);
			//为工作流创建的标志
			//用viewHelper整理界面输入
			//modify by miaowenjun 20060922 start 农险走自己的viewhelper
			RegistDto registDto = new RegistDto();
			//以前得版本财产险没有调度,所以针对国元得情况对财产险,责任险,货运险加上调度得控制
			//添加意健险。add by xiatian
			if ("I".equals(strRiskType)
					|| "Q".equals(strRiskType) || "Z".equals(strRiskType)
					|| "Y".equals(strRiskType)|| "H".equals(strRiskType) ||"E".equals(strRiskType)){
				AgriRegistViewHelper agriRegistViewHelper = new AgriRegistViewHelper();
				registDto = agriRegistViewHelper.viewToDtoNew(registEditPostInfo, user);
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
			swfLogDtoDealNode.setComCode(registEditPostInfo.getPrpLregistComCode());
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
			
			if(("I".equals(strRiskType) )
					&& swfLogDtoDealNode.getNodeStatus().equals("4")){
				Collection nextNodeList = new ArrayList();
//				String[] strNodeNo = httpServletRequest
//						.getParameterValues("nextNodeNoList");
//				if (strNodeNo != null) {
//					for (int i = 0; i < strNodeNo.length; i++) {
//						SwfLogDto swfLogNextNode = new SwfLogDto();
//						nextNodeNo = Integer.parseInt(strNodeNo[i]);
//						swfLogNextNode.setNodeNo(nextNodeNo);
//						nextNodeList.add(swfLogNextNode);
//					}
//				}
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
			
			//农村住房信息
			if("0310".equals(registEditPostInfo.getPrpLregistRiskCode())||"0312".equals(registEditPostInfo.getPrpLregistRiskCode())){
				 ArrayList prplCompensateHouseDtoList = new ArrayList();
				 PrplcompensatehouseDto	prplCompensateHouseDto = new PrplcompensatehouseDto();
	    		 prplCompensateHouseDto.setAddress(registEditPostInfo.getPrplCompensateHouseAddress());
	    		 prplCompensateHouseDto.setBusinessno(registEditPostInfo.getRegistNo());
	    		 //prplCompensateHouseDto.setCaseno(); 报案环节没有这些信息
	    		 //prplCompensateHouseDto.setClaimno();
	    		 //prplCompensateHouseDto.setCompensateno();
	    		 prplCompensateHouseDto.setDamagecode(registEditPostInfo.getPrpLregistDamageCode());
	    		 prplCompensateHouseDto.setDamagename(registEditPostInfo.getPrpLregistDamageName());
	    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(registEditPostInfo.getPrpLregistDamageStartDate(),DateTime.YEAR_TO_DAY));
	    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(registEditPostInfo.getPrplCompensateHouseEstimateloss())));
	    		 prplCompensateHouseDto.setHukoubu(registEditPostInfo.getPrplCompensateHouseHukoubu());
	    		 prplCompensateHouseDto.setIdcard(registEditPostInfo.getPrplCompensateHouseIdcard());
	    		 prplCompensateHouseDto.setKindcode("001");
	    		 prplCompensateHouseDto.setName(registEditPostInfo.getPrplCompensateHouseName());
	    		 prplCompensateHouseDto.setPhone(registEditPostInfo.getPrplCompensateHousePhone());
	    		 prplCompensateHouseDto.setRegistno(registEditPostInfo.getRegistNo());
	    		 prplCompensateHouseDto.setPolicyno(registEditPostInfo.getPrpLregistPolicyNo());
	    		 prplCompensateHouseDto.setNodeno(1);
	    		 prplCompensateHouseDto.setNodetype("regis");
	    		 prplCompensateHouseDto.setRemark(registEditPostInfo.getPrplCompensateHouseRemark());
				 prplCompensateHouseDto.setFloor(registEditPostInfo.getPrplCompensateHouseFloor());
	    		 prplCompensateHouseDto.setBuildingnumber(registEditPostInfo.getPrplCompensateHouseBuildingnumber());
	    		 prplCompensateHouseDto.setZhuannumber(registEditPostInfo.getPrplCompensateHouseZhuannumber());
	    		 prplCompensateHouseDto.setWanumber(registEditPostInfo.getPrplCompensateHouseWanumber());
	    		 prplCompensateHouseDto.setKitchennumber(registEditPostInfo.getPrplCompensateHouseKitchennumber());
	    		 prplCompensateHouseDto.setOthernumber(registEditPostInfo.getPrplCompensateHouseOthernumber());
	    		 prplCompensateHouseDtoList.add(prplCompensateHouseDto);
	    		 registDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList);
			}
			
			UIRegistAction uiRegistAction = new UIRegistAction();

			if (workFlowViewHelper.checkDealDto(workFlowDto)) {
				uiRegistAction.save(registDto, workFlowDto);
				flag = true;
				user.setUserMessage(registNo);
			} else {
				if (workFlowDto.getOperateResult() < 0) {
					user.setUserMessage("注意:创建工作流流程时，未找到相关工作流模板的设置，请联系系统管理员进行相应配置！！");
				} else {
					uiRegistAction.save(registDto);
					flag = true;
					user.setUserMessage(registNo + ";注意:没有发现与工作流流程相关任何数据！！");
				}
			}
			
		} catch (Exception e) {
			if(!flag){
				registNo="";
			}
			e.printStackTrace();
		}
		if(!flag){
			registNo="";
		}
		return registNo;
	}
	/**
	 * 农家福保险报案主连带被保险人信息
	 * @param policyNo
	 * @param indexCode
	 * @return
	 */
	public RegistInsuredDtoInfo[]  getRegistInsured (String policyNo,String indexCode){
		
		long serial = System.currentTimeMillis();logger.log("农家福保险报案主连带被保险人信息", 1,serial, "[policyNo:"+policyNo+"][indexCode:"+indexCode+"]");
		RegistInsuredDtoInfo[] registInsuredDtoInfos = null;
		ArrayList<RegistInsuredDtoInfo> registInsuredDtoInfoList = new ArrayList<RegistInsuredDtoInfo>();
		try {
			if(isEmpty(policyNo)){throw new Exception("保单号是必传参数，请检查！");}
			if(isEmpty(indexCode)){throw new Exception("户编号是必传参数，请检查！");}
			
			String conditions = "";

	         BLPrpCmainCasualty blPrpCmainCasualty = new BLPrpCmainCasualty();
	   		 blPrpCmainCasualty.getData(policyNo);
	   		 if(null != blPrpCmainCasualty && blPrpCmainCasualty.getSize()==1){
	   		 	PrpCmainCasualtySchema prpCmainCasualtySchema = blPrpCmainCasualty.getArr(0);
	   		 	String insureListCode = prpCmainCasualtySchema.getRemark();
	   		 	if(null!=insureListCode && insureListCode.length() > 0){
	   		 		conditions = " INUSRELISTCODE = '"+ insureListCode + "' "+//用人身意外保险来筛选所有的被保险人人名
	   		 			" AND FamilyNo LIKE '%"+indexCode+"%'  " +
	   							" and KINDCODE = '2742001' ";
	   				BLZh03PolicyListFacade blZH03PolicyListFacade = new BLZh03PolicyListFacade();
	   				Collection collection = blZH03PolicyListFacade.findByConditions(conditions);
		   	   		int recordSize = collection.size();
			        for(Iterator iterator = collection.iterator();iterator.hasNext();){
		   	   			Zh03PolicyListDto zh03PolicyListDto = (Zh03PolicyListDto)iterator.next();
		   	   			RegistInsuredDtoInfo registInsuredDtoInfo = new RegistInsuredDtoInfo();
		   	   			registInsuredDtoInfo.setIndexCode(zh03PolicyListDto.getFamilyNo());
		   	   			registInsuredDtoInfo.setSerialNo(zh03PolicyListDto.getPersonNo());
		   	   			registInsuredDtoInfo.setInsuredMainName(zh03PolicyListDto.getFamilyName());
		   	   			registInsuredDtoInfo.setIdentifyNumber(zh03PolicyListDto.getFamilyFIdCard());
		   	   			registInsuredDtoInfo.setInsuredLinkName(zh03PolicyListDto.getName());
		   	   			registInsuredDtoInfoList.add(registInsuredDtoInfo);
		   	   		}
	   		 	}
	   		 }
			registInsuredDtoInfos = new RegistInsuredDtoInfo[registInsuredDtoInfoList.size()];
			for(int i = 0;i<registInsuredDtoInfoList.size();i++){
				registInsuredDtoInfos[i] = registInsuredDtoInfoList.get(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("农家福保险报案主连带被保险人信息",serial,e);
		}
		logger.log("农家福保险报案主连带被保险人信息", 0,serial, registInsuredDtoInfos);
		return registInsuredDtoInfos;
	}
	
	private boolean isEmpty(String str){
		if(str==null||str.trim().length()==0){
			return true;
		}else{
			return false;
		}
			
	}
	
}
