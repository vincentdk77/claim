package com.sinosoft.claim.webservice;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.soap.SOAPException;

import sun.misc.BASE64Decoder;

import com.sinosoft.claim.bl.action.domain.BLPrpCmainAction;
import com.sinosoft.claim.bl.facade.BLPrpCitemKindFacade;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyDirectFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcertifyImgFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcheckFacade;
import com.sinosoft.claim.bl.facade.BLPrpLcheckLossFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimStatusFacade;
import com.sinosoft.claim.bl.facade.BLPrpLdriverFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpersonTraceFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleItemFacade;
import com.sinosoft.claim.bl.facade.BLPrpLscheduleMainWFFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPartyFacade;
import com.sinosoft.claim.bl.facade.BLPrpLthirdPropFacade;
import com.sinosoft.claim.bl.facade.BLRegistFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyDirectDto;
import com.sinosoft.claim.dto.domain.PrpLcertifyImgDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcode;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDrisk;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UILogonAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.claim.util.FtpClient;
import com.sinosoft.platform.bl.facade.BLPrpDuserFacade;
import com.sinosoft.platform.bl.facade.BLUtiGradeTaskFacade;
import com.sinosoft.platform.dto.domain.UtiGradeTaskDto;
import com.sinosoft.platform.dto.domain.UtiUserGradeDto;
import com.sinosoft.platform.ui.control.action.UIPowerAction;
import com.sinosoft.platform.ui.model.UtiUserGradeQueryByUserCodeCommand;
import com.sinosoft.prpall.blsvr.cb.BLPrpCitemCar;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmainSub;
import com.sinosoft.sysframework.common.Constants;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.utiall.blsvr.BLPrpDcompany;

/***
 * 移动查勘WebService类
 * 
 * @author fengye
 * 
 */
public class MobileSurvey {

	/**
	 * 通过从任务列表传过来的报案号，读取保单信息列表，
	 * 承保机构、保单号码、被保险人、行驶证车主、车牌号码、厂型号码、车架号码、发动机号码、投保日期、投保期限
	 * 、使用性质、行驶区域、新车购置价、约定驾驶员、绝对免赔额、投保险别等
	 * 
	 * @param registNo
	 * @return 正常数据或者 null
	 * @throws SOAPException 
	 */
	public PolicyInfo getPolicyInfo(String registNo) throws SOAPException {// 完成

		PolicyInfo policyInfo = null;
		UIRegistAction uiRegistAction = new UIRegistAction();
		String comCode = "";
		String comName = "";
		String operateDate = "";
		String endDate = "";
		String driverName = "";
		String kindCode = "";
		String kindName = "";
		double deductible = 0d;

		try {
			if (isEmpty(registNo)) {// 有效性校验
				throw new Exception("报案号信息无效，请检查。。。。。！");
			}

			RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();

			if (prpLregistDto != null) {
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				policyInfo = new PolicyInfo();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(), registDto.getPrpLregistDto().getDamageStartDate().toString(), registDto.getPrpLregistDto()
						.getDamageStartHour());

				PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
				PrpCitemCarDto prpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList().get(0);
				List<PrpCitemKindDto> prpCitemKindList = policyDto.getPrpCitemKindDtoList();
				String policyNo = prpLregistDto.getPolicyNo();
				String LinkPolicyNo = "";
				
				String riskCode = prpLregistDto.getRiskCode();
				BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
				if("0506".equals(riskCode) || "0586".equals(riskCode) || "0576".equals(riskCode)){
					String conditions = " policyNo = '" + policyNo + "'";
					blPrpCmainSub.query(conditions);
					LinkPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
				}else{
					String conditions = " mainPolicyNo = '" + policyNo + "'";
					blPrpCmainSub.query(conditions);
					if(blPrpCmainSub.getSize() > 0){
						LinkPolicyNo = blPrpCmainSub.getArr(0).getPolicyNo();
					}
				}
				BLPrpCitemKindFacade blPrpCitemKindFacade = new BLPrpCitemKindFacade();
				
				ArrayList prpCitemKindList1 = new ArrayList(); 
				if(!isEmpty(LinkPolicyNo)){
					policyNo += "," + LinkPolicyNo ;
					String conditions = " policyNo = '" + LinkPolicyNo + "'";
					prpCitemKindList1 = (ArrayList)blPrpCitemKindFacade.findByConditions(conditions);
				}
				if(!isEmpty(prpCitemKindList1)){
					prpCitemKindList.addAll(prpCitemKindList1);
				}
				if ("1".equals(prpCitemCarDto.getAgreeDriverFlag())) {// 约定了驾驶员
					List<PrpCcarDriverDto> prpCcarDriverDtoList = policyDto.getPrpCcarDriverDtoList();
					if (prpCcarDriverDtoList != null && prpCcarDriverDtoList.size() != 0) {// 设置约定驾驶员
						for (int i = 0; i < prpCcarDriverDtoList.size(); i++) {
							PrpCcarDriverDto prpCcarDriverDto = prpCcarDriverDtoList.get(i);
							if (i != prpCcarDriverDtoList.size() - 1) {
								driverName += prpCcarDriverDto.getDriverName() + ",";
							} else {
								driverName += prpCcarDriverDto.getDriverName();
							}
						}
					}
				}

				if (prpCitemKindList != null && prpCitemKindList.size() != 0) {
					for (int i = 0; i < prpCitemKindList.size(); i++) {
						PrpCitemKindDto prpCitemKindDto = prpCitemKindList.get(i);
						if (i != prpCitemKindList.size() - 1) {
							kindCode += prpCitemKindDto.getKindCode() + ",";
							kindName += prpCitemKindDto.getKindName() + ",";
							deductible = prpCitemKindDto.getDeductible();
						} else {
							kindCode += prpCitemKindDto.getKindCode();
							kindName += prpCitemKindDto.getKindName();
						}
					}
				}

				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				operateDate = dateFormat.format(prpCmainDto.getStartDate().getTime());
				endDate = dateFormat.format(prpCmainDto.getEndDate().getTime());
				comCode = prpCmainDto.getComCode();
				comName = new BLPrpDcompanyFacade().findByPrimaryKey(comCode).getComCName();

				policyInfo.setPolicyNo(policyNo);
				policyInfo.setComCode(comCode);
				policyInfo.setComName(comName);
				policyInfo.setInsuredCode(prpCmainDto.getInsuredCode());
				policyInfo.setInsuredName(prpCmainDto.getInsuredName());
				policyInfo.setOperateDate(operateDate);
				policyInfo.setEndDate(endDate);
				policyInfo.setCarOwner(prpCitemCarDto.getCarOwner());
				policyInfo.setBrandName(prpCitemCarDto.getBrandName());
				policyInfo.setLicenseNo(prpCitemCarDto.getLicenseNo());
				policyInfo.setEngineNo(prpCitemCarDto.getEngineNo());
				policyInfo.setFrameNo(prpCitemCarDto.getFrameNo());
				policyInfo.setDriverName(driverName);
				policyInfo.setRunAreaCode(prpCitemCarDto.getRunAreaCode());
				policyInfo.setRunAreaName(prpCitemCarDto.getRunAreaName());
				policyInfo.setUseNatureCode(prpCitemCarDto.getUseNatureCode());
				policyInfo.setUseNatureName(new UICodeAction().translateCodeCode("UseNature", prpCitemCarDto.getUseNatureCode(), true));
				policyInfo.setPurchasePrice(prpCitemCarDto.getPurchasePrice());
				policyInfo.setLicenseColorCode(prpCitemCarDto.getLicenseColorCode());
				policyInfo.setCarKindCode(prpCitemCarDto.getCarKindCode());
				policyInfo.setKindCode(kindCode);
				policyInfo.setKindName(kindName);
				policyInfo.setDeductible(deductible);
			}

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return policyInfo;

	}

	/**
	 * （1）判断用户登录数据
	 * 
	 * @param userNo
	 * @param password
	 * @return logonStatus 是否允许登录
	 * @throws SOAPException 
	 */
	public boolean login(String userNo, String password) throws SOAPException {
		boolean logonStatus = false;
		try {
			if (isEmpty(userNo) || isEmpty(password)) {
				throw new Exception("用户名或密码错误！。。。。。");// 登录信息无意义则转发到校验无效页面
			} else {
				UILogonAction uILogonAction = new UILogonAction();
				PrpDuserDto prpDuserDto;
				prpDuserDto = uILogonAction.checkUser(userNo, password);
				if (prpDuserDto != null) {
					logonStatus = true;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return logonStatus;
	}

	/**
	 * （2）获取登录机构 数据：员工所属公司机构 字段：登录机构
	 * 
	 * @return 正常数据或者null
	 * @throws Exception
	 */
	public CompanyInfo[] getCompanyNo(String userNo) throws Exception {
		CompanyInfo[] companyInfoList = null;
		try {
			if (!isEmpty(userNo)) {
				UtiUserGradeQueryByUserCodeCommand command = new UtiUserGradeQueryByUserCodeCommand(userNo, 1, 65535);
				PageRecord record = (PageRecord) command.execute();
				Collection<?> result = record.getResult();
				if (!isEmpty(result)) {// 结果有效的话
					companyInfoList = new CompanyInfo[result.size()];
					int i = 0;
					for (Iterator<?> iter = result.iterator(); iter.hasNext();) {
						UtiUserGradeDto element = (UtiUserGradeDto) iter.next();
						companyInfoList[i++] = new CompanyInfo(element.getComCode(), element.getComName());
					}
				}
			} else {
				throw new Exception("参数信息无效！....");
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return companyInfoList;

	}

	/**
	 * 根据员工工号、员工所属公司机构以及任务状态读取员工不同状态的任务列表， 字段：报案号、车牌号、受理时间、任务状态、派工类型等
	 * 
	 * @param userNo
	 * @param loginOrgan
	 * @param taskStatus
	 * @return 正常数据或者null
	 * @throws Exception
	 */
	public TaskInfo[] getTaskList(String userNo, String loginOrgan, String taskStatus) throws Exception {

		TaskInfo[] taskList = null;
		try {
			if (isEmpty(userNo) || isEmpty(loginOrgan) || isEmpty(taskStatus)) {
				throw new Exception("参数信息无效！");
			}

			com.sinosoft.platform.dto.domain.PrpDuserDto userDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			BLUtiGradeTaskFacade blUtiGradeTaskFacade = new BLUtiGradeTaskFacade();
			UtiGradeTaskDto utiGradeTaskDto = null;
			Map<String, String> gradeCodeMap = new HashMap<String, String>();
			String gradecodes = "";
			String gradeCondition = " taskcode = 'claim' and gradecode in " + // 只查询理赔系统的权限代码
					"(select gradecode from utiusergradepower " + "where usercode='" + userNo + "') and gradecode<>'122'";
			ArrayList<?> gradeList = (ArrayList<?>) blUtiGradeTaskFacade.findByConditions(gradeCondition);
			for (int i = 0; i < gradeList.size(); i++) {
				utiGradeTaskDto = (UtiGradeTaskDto) gradeList.get(i);
				if (!gradeCodeMap.containsKey(utiGradeTaskDto.getGradeCode())) {
					gradeCodeMap.put(utiGradeTaskDto.getGradeCode(), utiGradeTaskDto.getGradeCode());
					gradecodes += "," + utiGradeTaskDto.getGradeCode();
				}
			}
			if (gradecodes.length() > 1) {
				gradecodes = gradecodes.substring(1, gradecodes.length());
			}
			// ----------------------------
			userDto.setUserCode(userNo);
			userDto.setLoginComCode(loginOrgan);
			userDto.setLoginGradeCodes(gradecodes);
			// ------------------------\
			String nodeType = "check";
			String condition = " nodeType='" + nodeType + "' and flowStatus!='0' and (handlerCode='" + userNo + "' or handlerCode is null or handlerCode='')";
			//add by xiatian 26 27 31 也可查勘
			condition = condition + " and NodeStatus='" + taskStatus +"'";     //"' and (riskcode not like '27%' and riskCode not like '26%' and riskCode not like '31%')";
			condition = condition + " and riskcode in (select distinct outercode from uticodetransfer where risktype='D' and validstatus='1') ";
			condition = condition + " and ((modelno=7  " + UIPowerAction.addPower(userDto, "vv", "", "ComCode").replace("vv", "Swflog") + ") or (modelno<>7 "
					+ UIPowerAction.addPower(userDto, "kk", "", "handledept").replace("kk", "Swflog") + ") )";
			condition = condition + "order by flowintime desc";
			Collection<?> swfList = uiWorkFlowAction.findNodesByConditions(condition);

			if (!isEmpty(swfList)) {
				taskList = new TaskInfo[swfList.size()];
				int i = 0;
				for (Iterator<?> it = swfList.iterator(); it.hasNext();) {
					TaskInfo temp = new TaskInfo();
					SwfLogDto swflogtemp = (SwfLogDto) it.next();

					temp.setRegistNo(swflogtemp.getRegistNo());
					temp.setLicenseNo(swflogtemp.getLossItemName());
					temp.setTaskStatus(swflogtemp.getNodeStatus());
					temp.setAcceptTime(swflogtemp.getHandleTime());
					temp.setDispatchType("调度");
					temp.setInsuredName(swflogtemp.getInsuredName());
					taskList[i++] = temp;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return taskList;
	}

	/**
	 * 通过从任务列表传过来的报案号，读取调度信息列表，包括调度时间、调度人员、调度意见、紧急程度、地图信息等。
	 * 
	 * @param registNo
	 * @return 正常数据或者NUll
	 * @throws Exception
	 */
	public DispatchInfo getDispatchInfo(String registNo) throws Exception {//

		DispatchInfo dispatchInfo = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception();
			}
			BLPrpLscheduleMainWFFacade bLPrpLscheduleMainWFFacade = new BLPrpLscheduleMainWFFacade();
			Collection<PrpLscheduleMainWFDto> prpLscheduleMainWFDtoList = bLPrpLscheduleMainWFFacade.findByConditions("registNo=" + registNo);
			if (!isEmpty(prpLscheduleMainWFDtoList)) {
				Iterator<?> it = prpLscheduleMainWFDtoList.iterator();
				PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto) it.next();
				if (prpLscheduleMainWFDto == null || "0".equals(prpLscheduleMainWFDto.getScheduleFlag())) {// 为调度或者未查到信息无效
					throw new Exception();
				}
				dispatchInfo = new DispatchInfo();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String dispatchDate = dateFormat.format(prpLscheduleMainWFDto.getInputDate().getTime());
				
				dispatchInfo.setDispatchDate(dispatchDate);
				dispatchInfo.setCheckInfo(prpLscheduleMainWFDto.getCheckInfo());
				dispatchInfo.setHandlerCode(prpLscheduleMainWFDto.getOperatorCode());
				UICodeAction uICodeAction = new UICodeAction();
				dispatchInfo.setHandlerName(uICodeAction.translateUserCode(prpLscheduleMainWFDto.getOperatorCode(),true));
			}
		} catch (Exception e) {
			throw new SOAPException("报案信息无效或者该案件未进行调度处理......");
		}
		return dispatchInfo;
	}

	/**
	 * 数据交互：通过从任务列表传过来的报案号，读取报案信息列表
	 * 包括报案代码、出险时间、报案人、报案人电话、驾驶员、驾驶员电话、车牌号码、事故类型、出险原因
	 * 、出险区域、处理部门、事故责任、损失类型、伤情描述、出险经过、出险地点、出险次数等信息。
	 * 
	 * @param registNo
	 *            ——报案号
	 * @return 正常数据或者NUll
	 * @throws SOAPException 
	 */
	public RegistDetailInfo getCaseDetailInfo(String registNo) throws SOAPException {// Update 待测

		RegistDetailInfo registDetailInfo = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("报案号不能为空");
			}
			BLRegistFacade bLRegistFacade = new BLRegistFacade();
			RegistDto registDto = bLRegistFacade.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if(prpLregistDto==null) {
				throw new Exception("报案号信息无效。。。。");
			}
			registDetailInfo = new RegistDetailInfo();
			String damageAbstract = "";
			String damageTime = "";
			String driverName = "";
			String driverPhone = "";
			String indemnityDuty = "";
			String handleUnit = "";
			String woundRemark = "";
			String lossType = "";
			int perilCount = 0;
			
			//获取出险摘要
			if(registDto.getPrpLregistTextDtoList() != null){
		        Iterator<?> iterator = registDto.getPrpLregistTextDtoList().iterator();
		        while(iterator.hasNext()){
		          PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
		          if(StringUtils.rightTrim(prpLregistTextDtoTemp.getTextType()).equals("1"))
		          {
		        	  damageAbstract+=prpLregistTextDtoTemp.getContext();
		          }
		        }
		      } 
			//
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			damageTime = dateFormat.format(prpLregistDto.getDamageStartDate().getTime())+prpLregistDto.getDamageStartHour();
			//获取驾驶员信息
			if(registDto.getPrpLdriverDtoList() != null) {
				PrpLdriverDto prpLdriverDto = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(0);
				driverName = prpLdriverDto.getDriverName();
				driverPhone = prpLdriverDto.getDriverSeaRoute();
			}
			//获取伤情描述
			if(registDto.getPrpLpersonTraceDtoList()!=null) {
				for(Iterator<?> it=registDto.getPrpLpersonTraceDtoList().iterator();it.hasNext();) {
					PrpLpersonTraceDto prpLpersonTraceDto = (PrpLpersonTraceDto)it.next();
					woundRemark += prpLpersonTraceDto.getWoundRemark()+" ";
				}
			}
			
			PrpLextDto prpLextDto = registDto.getPrpLextDto();                    
			if (prpLextDto != null&&!isEmpty(prpLextDto.getFlag())) {
				String[] strs = {"空","车损","物损","盗抢","本车伤","三者伤"};
				for (String index : prpLextDto.getFlag().split(",")) {
					lossType += strs[Integer.parseInt(index)] + ",";
				}
				lossType = lossType.substring(0,lossType.length()-1);
			} 
			
			//获取出险次数
			Collection<?> registList = new UIRegistAction().findSamePolicyRegist(prpLregistDto.getPolicyNo());
			
			if(!isEmpty(registList)) {
				perilCount = registList.size();
			}
			
			UICodeAction uICodeAction = new UICodeAction();
			handleUnit = uICodeAction.translateCodeCode("HandleUnit", prpLregistDto.getHandleUnit(), true);
			
			registDetailInfo.setDamageAbstract(damageAbstract);
			registDetailInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			registDetailInfo.setDamageAreaCode(prpLregistDto.getDamageAreaCode());
			registDetailInfo.setDamageAreaName(prpLregistDto.getDamageAreaName());
			registDetailInfo.setDamageCode(prpLregistDto.getDamageCode());
			registDetailInfo.setDamageName(prpLregistDto.getDamageName());
			registDetailInfo.setDamageTime(damageTime);
			registDetailInfo.setDamageTypeCode(prpLregistDto.getDamageTypeCode());
			registDetailInfo.setDamageTypeName(prpLregistDto.getDamageTypeName());
			registDetailInfo.setDriverName(driverName);
			registDetailInfo.setDriverPhone(driverPhone);
			registDetailInfo.setHandleUnit(handleUnit);
			registDetailInfo.setIndemnityDuty(prpLregistDto.getIndemnityDuty());//
			registDetailInfo.setLicenseNo(prpLregistDto.getLicenseNo());
			registDetailInfo.setLossType(lossType);//
			registDetailInfo.setPerilCount(perilCount);
			registDetailInfo.setPhoneNumber(prpLregistDto.getPhoneNumber());
			registDetailInfo.setRegistNo(prpLregistDto.getRegistNo());
			registDetailInfo.setReportorName(prpLregistDto.getReportorName());
			registDetailInfo.setWoundRemark(woundRemark);
			
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return registDetailInfo;
	}
	
	/**
	 * 	数据交互：通过从任务列表传过来的报案号，读取客户电话号码，包括报案人电话号码、驾驶员电话号码等。
	 * @param  registNo——报案号
	 * @return 正常返回或者null
	 * @throws SOAPException
	 */
	public CustomerNumber getCustomerNumber(String registNo) throws SOAPException {//Update daice
		CustomerNumber customerNumber = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("报案号不能为空。。。");
			}
			// 具体业务。。。。。
			BLRegistFacade bLRegistFacade = new BLRegistFacade();
			RegistDto registDto = bLRegistFacade.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if(prpLregistDto==null) {
				throw new Exception("报案号信息无效。。。。");
			}
			customerNumber = new CustomerNumber();
			String driverPhone = "";
			String driverName = "";
			String customerPhone = "";
			String customerName = "";
			//获取驾驶员信息
			if(registDto.getPrpLdriverDtoList() != null) {
				PrpLdriverDto prpLdriverDto = (PrpLdriverDto)registDto.getPrpLdriverDtoList().get(0);
				driverPhone = prpLdriverDto.getDriverSeaRoute();
				driverName = prpLdriverDto.getDriverName();
			}

			//获取被保险人信息
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(prpLregistDto.getPolicyNo(), registDto.getPrpLregistDto().getDamageStartDate().toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			if(!isEmpty(policyDto.getPrpCinsuredDtoList())) {
				List<PrpCinsuredDto> prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
				for(PrpCinsuredDto prpCinsuredDto:prpCinsuredDtoList) {
					if("1".equals(prpCinsuredDto.getInsuredFlag())) {
						customerPhone = prpCinsuredDto.getPhoneNumber();
						customerName = prpCinsuredDto.getInsuredName();
						if(isEmpty(customerPhone)) {
							customerPhone = prpCinsuredDto.getMobile();
						}
						break;
					}
				}
			}
		
			customerNumber.setCustomerPhone(customerPhone);
			customerNumber.setCustomerName(customerName);
			customerNumber.setDriverPhone(driverPhone);
			customerNumber.setDriverName(driverName);
			customerNumber.setReportorPhone(prpLregistDto.getPhoneNumber());
			customerNumber.setReportName(prpLregistDto.getReportorName());
			

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return customerNumber;

	}
	
	/**
	 * 数据交互：根据前面界面传过来的员工号、报案号信息，将任务信息中的任务状态变更为正处理状态。
	 * @param userNo——员工号
	 * @param registNo——报案号
	 * @return 是否成功的标志。
	 * @throws SOAPException 
	 */
	public boolean acceptTaskSubmit(String userNo, String registNo) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(registNo)||isEmpty(userNo)) {
				throw new Exception("参数均不能为空。。。。");
			}

			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo = '"+registNo+"' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if(!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				if(!"2".equals(swfLogDto.getNodeStatus())&&(isEmpty(swfLogDto.getHandlerCode())||swfLogDto.getHandlerCode().equals(userNo))) {//节点不是正处理 且该节点处理人为空和该操作员
					swfLogDto.setNodeStatus("2");
					swfLogDto.setHandleTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString());
					if(isEmpty(swfLogDto.getHandlerCode())) {
						swfLogDto.setHandlerCode(userNo);
						swfLogDto.setHandlerName(new UICodeAction().translateUserCode(userNo, true));
					}
					bLSwfLogFacade.update(swfLogDto);
					flag = true;
				} else {
					throw new Exception("您无权处理该案件。。。"); 
				}
				
			} 
			

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return flag;
		
	}
	
	/**
	 * 根据前面界面传过来的报案号信息，将任务信息中的任务状态变更为完成状态。
	 * @param registNo——报案号
	 * @return
	 * @throws SOAPException 
	 */
	public boolean completeTaskSubmit(String registNo,String userCode) throws SOAPException {
		
		boolean flag = false;
		try {
			if (isEmpty(registNo) || isEmpty(userCode)) {
				throw new Exception("参数不能为空。。。。");
			}
			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo='"+registNo+"' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if (!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				if (!"4".equals(swfLogDto.getNodeStatus()) &&(isEmpty(swfLogDto.getHandlerCode())||swfLogDto.getHandlerCode().equals(userCode))) {// 操作员不空且为处于已完成状态
					BLPrpLcheckFacade blPrpLcheckFacade = new BLPrpLcheckFacade();
					PrpLcheckDto prpLcheckDto = blPrpLcheckFacade.findByPrimaryKey(registNo, 1);
					PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
					prpLclaimStatusDto.setStatus("4");
					prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
			        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
			        prpLclaimStatusDto.setNodeType("check");
			        prpLclaimStatusDto.setSerialNo(0);
			        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
			        //取得当前用户信息，写操作员信息到查勘中
			        prpLclaimStatusDto.setHandlerCode(userCode);
			        //prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
			        prpLclaimStatusDto.setInputDate(prpLcheckDto.getCheckDate() );
			        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			        BLPrpLclaimStatusFacade blPrpLclaimStatusFacade = new BLPrpLclaimStatusFacade();
			        blPrpLclaimStatusFacade.delete(prpLcheckDto.getRegistNo(), "check", 0);
			        blPrpLclaimStatusFacade.insert(prpLclaimStatusDto);
			        String riskType = new UICodeAction().translateRiskCodetoRiskType(prpLcheckDto.getRiskCode());
			        //查勘时，录入三者车、人伤、财产信息时，生成相应的调度信息
			        PrpLscheduleItemDto prpLscheduleItemDto = null;
			        ArrayList scheduleItemDtoList = new ArrayList(); 
			        String conditions = " registNo = '" + registNo + "' order by serialNo";
			        String conditions1 = " registNo = '"+registNo+"' order by personNo";
			        String conditions2 = " registNo = '" + registNo + "'";
			        BLPrpLthirdPartyFacade blPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			        BLPrpLthirdPropFacade blPrpLthirdPropFacade = new BLPrpLthirdPropFacade();
			        BLPrpLpersonTraceFacade blPrpLpersonTraceFacade = new BLPrpLpersonTraceFacade();
			        ArrayList prpLthirdPartyDtoList = (ArrayList)blPrpLthirdPartyFacade.findByConditions(conditions);
			        if(prpLthirdPartyDtoList.size() > 0){
			        	for(int i = 0;i < prpLthirdPartyDtoList.size();i++){
			        		PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)prpLthirdPartyDtoList.get(i);
					        prpLscheduleItemDto = new PrpLscheduleItemDto();
					        prpLscheduleItemDto.setScheduleID         (1);
					        prpLscheduleItemDto.setRegistNo           (prpLthirdPartyDto.getRegistNo());
					        prpLscheduleItemDto.setItemNo             (prpLthirdPartyDto.getSerialNo());
					        prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyDto.getInsureCarFlag() );
					        //表示是否选中
					        prpLscheduleItemDto.setSelectSend         ("1");
					        //表示没有调度成定损过
					        prpLscheduleItemDto.setSurveyTimes        (0);
					        prpLscheduleItemDto.setSurveyType         ("1");
					        prpLscheduleItemDto.setCheckSite          (prpLcheckDto.getCheckSite());
					        prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyDto.getLicenseNo() );
					        prpLscheduleItemDto.setScheduleObjectID   ("_");
					        prpLscheduleItemDto.setScheduleObjectName (" ");
					        prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current().toString() ,DateTime.YEAR_TO_DAY ));
					        prpLscheduleItemDto.setScheduleType       ("schel");
					        prpLscheduleItemDto.setNextNodeNo("certa");
					        
						    scheduleItemDtoList.add(prpLscheduleItemDto);
			        	}
			        }
			        ArrayList prpLthirdPropDtoList = (ArrayList)blPrpLthirdPropFacade.findByConditions(conditions);
					if(prpLthirdPropDtoList.size() > 0){
						 prpLscheduleItemDto = new PrpLscheduleItemDto();
				         prpLscheduleItemDto.setScheduleID(1);
				         prpLscheduleItemDto.setRegistNo(prpLcheckDto.getRegistNo());
				         prpLscheduleItemDto.setItemNo(-1);
				         //表示是否选中
				         prpLscheduleItemDto.setSelectSend("1");
				         //表示没有调度成定损过
				         prpLscheduleItemDto.setSurveyTimes(0);
				         prpLscheduleItemDto.setSurveyType("1");
				         prpLscheduleItemDto.setCheckSite(prpLcheckDto.getCheckSite() );
				         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
				             DateTime.YEAR_TO_DAY));
				         prpLscheduleItemDto.setScheduleType("schel");
				         prpLscheduleItemDto.setLicenseNo("财产损失");
				         prpLscheduleItemDto.setScheduleObjectID("_");
				         prpLscheduleItemDto.setScheduleObjectName(" ");
				         prpLscheduleItemDto.setNextNodeNo("propc");
				         scheduleItemDtoList.add(prpLscheduleItemDto);
					}
					ArrayList prpLpersonTraceDtoList = (ArrayList)blPrpLpersonTraceFacade.findByConditions(conditions1);
					if(prpLpersonTraceDtoList.size() > 0){
						prpLscheduleItemDto = new PrpLscheduleItemDto();
			            prpLscheduleItemDto.setScheduleID(1);
			            prpLscheduleItemDto.setRegistNo(prpLcheckDto.getRegistNo());
			            prpLscheduleItemDto.setItemNo(0);
			            //表示是否选中
			            prpLscheduleItemDto.setSelectSend("1");
			            //表示没有调度成定损过
			            prpLscheduleItemDto.setSurveyTimes(0);
			            prpLscheduleItemDto.setSurveyType("1");
			            prpLscheduleItemDto.setCheckSite(prpLcheckDto.getCheckSite() );
			            prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
			                DateTime.YEAR_TO_DAY));
			            prpLscheduleItemDto.setScheduleType("schel");
			            prpLscheduleItemDto.setLicenseNo("人伤");
			            prpLscheduleItemDto.setScheduleObjectID("_");
			            prpLscheduleItemDto.setScheduleObjectName(" ");
			            prpLscheduleItemDto.setNextNodeNo("wound");
			            scheduleItemDtoList.add(prpLscheduleItemDto);
					}
					BLPrpLscheduleItemFacade blPrpLscheduleItemFacade = new BLPrpLscheduleItemFacade();
					ArrayList prpLscheduleItemDtoList = (ArrayList)blPrpLscheduleItemFacade.findByConditions(conditions2);
					for(int y = 0;y < scheduleItemDtoList.size();y++){
						boolean isTrue = true;
						prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(y);
						if(prpLscheduleItemDtoList.size() > 0){
							for(int x = 0;x < prpLscheduleItemDtoList.size();x++){
								PrpLscheduleItemDto prpLscheduleItemDto1 = (PrpLscheduleItemDto)prpLscheduleItemDtoList.get(x);
								if(prpLscheduleItemDto.getRegistNo().equals(prpLscheduleItemDto1.getRegistNo()) &&
										prpLscheduleItemDto.getItemNo() == prpLscheduleItemDto1.getItemNo()){
									isTrue = false;
									break;
								}
							}
						}
						if(isTrue){
							blPrpLscheduleItemFacade.insert(prpLscheduleItemDto);
						}
					}
					String checkNo = prpLcheckDto.getRegistNo();
					String userNo = userCode;
					BLPrpDuserFacade blPrpDuserFacade = new BLPrpDuserFacade();
					com.sinosoft.platform.dto.domain.PrpDuserDto prpDuserDto = (com.sinosoft.platform.dto.domain.PrpDuserDto)blPrpDuserFacade.findByPrimaryKey(userCode);
					UserDto user  = new UserDto();
					user.setUserCode(prpDuserDto.getUserCode());
					user.setUserName(prpDuserDto.getUserName());
					user.setComCode(prpDuserDto.getComCode());
					user.setComName(prpDuserDto.getComName());
					String comCode=user.getComCode() ;
					String riskCode = prpLcheckDto.getRiskCode();
				    String activeSchedule = "0"; //通知调度，使调度工作流变成待处理状态
				    String registno =  registNo;
				    String autoScheduleFlag = "1";//自动调度标志
					String swfLogFlowID = swfLogDto.getFlowID(); //工作流号码
					String swfLogLogNo = String.valueOf(swfLogDto.getLogNo()); //工作流logno
					//工作流节点处理
					WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
					SwfLogDto swfLogDtoDealNode = new SwfLogDto();
					if (swfLogFlowID!=null && swfLogLogNo!=null){
						swfLogDtoDealNode.setFlowID(swfLogFlowID);
						swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
					} else {
						swfLogDtoDealNode.setNodeType("check");
						swfLogDtoDealNode.setBusinessNo(prpLcheckDto.getRegistNo());
					}
					swfLogDtoDealNode.setNodeStatus(prpLclaimStatusDto.getStatus());
					swfLogDtoDealNode.setNextBusinessNo(prpLcheckDto.getRegistNo());
					WorkFlowDto workFlowDto = null;
					
					//swfLogDtoDealNode.setKeyIn(checkDto.getPrpLcheckDto().getRegistNo());
					swfLogDtoDealNode.setKeyOut(checkNo);
					//回访是查勘提交过来的回访,没有typeflag的值,1表示查勘回访，2表示定损回访
					swfLogDtoDealNode.setTypeFlag("1");
					swfLogDtoDealNode.setKeyIn(prpLcheckDto.getRegistNo());	
					workFlowDto = workFlowViewHelper.viewToDto(user,swfLogDtoDealNode);
			           
			       //修改查勘通知调度的方式
			           UIWorkFlowAction uiWorkFlowAction  = new UIWorkFlowAction ();
			           //通知调度
			           if ("4".equals(swfLogDtoDealNode.getNodeStatus())&&"1".equals(activeSchedule)){
			              if (workFlowDto.getUpdateSwfLogDto()!=null){
			                	String flowID=workFlowDto.getUpdateSwfLogDto().getFlowID();
			                 		//查找没有完成的调度，比如正在处理的调度
			                 		String conditonss="flowId='"+flowID+"' and nodeType='sched' and nodestatus='2'";
			                 		Collection schedList = uiWorkFlowAction.findNodesByConditions(conditonss);
			                 		if (schedList!=null&&schedList.size() >0){
			                 			SwfLogDto swfLogDto1 = new SwfLogDto();
			                 			swfLogDto1 =(SwfLogDto) schedList.iterator().next() ;
			                 			swfLogDto1.setNodeStatus( "0");
			                 			swfLogDto1.setHandlerCode( "");
			                 			swfLogDto1.setHandlerName( "");
			                 			swfLogDto1.setTypeFlag("15");
			                 		    swfLogDto1.setFlowInTime(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND ).toString()  );
			                 			workFlowDto.setUpdateSwfLog2Dto( swfLogDto1);
			                 		  }
			                    }
			            }
			           //    不通知调度     
			           if ("4".equals(swfLogDtoDealNode.getNodeStatus())&&"0".equals(activeSchedule)){
			            //如果为查勘提交，则判断是不是需要通知调度的选项, activeSchedule.equals( "0")说明不需要通知调度的
			           	//虽然不需要通知，但是需要判断是否所有的调度都已经做完了，如果做完了，则需要结束调度任务
			           	  if (workFlowDto.getUpdateSwfLogDto()!=null){
			                	String flowID=workFlowDto.getUpdateSwfLogDto().getFlowID();
			                 		//查找没有完成的调度，比如正在处理的调度
			                 		String conditonss="flowId='"+flowID+"' and nodeType='sched' and nodestatus<'4'";
			                 		Collection schedList = uiWorkFlowAction.findNodesByConditions(conditonss);
			                 		if (schedList!=null&&schedList.size() >0){
			                 			String strSql=" registno='"+prpLcheckDto.getRegistNo()+"' and surveyTimes<1";
			           	                UIScheduleAction uiScheduleAction = new UIScheduleAction();
			           	                Collection scheduleItemList =uiScheduleAction.findItemByConditions(strSql);
			           	                if (scheduleItemList !=null && scheduleItemList.size() >0){
			           	        	        //没有完成调度呢。。
			           	        	        System.out.println("没有完成调度呢。。");
			           		               workFlowDto.setUpdateSwfLog2Dto(null);
			           	                }else{
			           	                    
			           	                    //如果查勘新增加了调度的数据呢？ 那也不能结束的
			           	                    //add by lixiang start 2005-10-18
			           	                    //reason:如果调度增加标的，还会引起调度提交操作
			           	                    if (scheduleItemDtoList==null || scheduleItemDtoList.size()==0){
			           	                        //modify by liyanjie 2005-12-21 start
			           	                    	//由于双代的缘故，整理查勘对象时，checkDto.prpLscheduleItemDtoList只保存了新增的项目，
			           	                    	//所以不用按原来的方法判断，直接看checkDto.getPrpLscheduleItemDtoList.size是否为0就可以了
			           	                    	//strSql=" registno='"+checkDto.getPrpLcheckDto().getRegistNo()+"'";
			           	                    	//if (checkDto.getPrpLscheduleItemDtoList().size()==uiScheduleAction.findScheduleItemCountByConditon(strSql))
			           	                    		//modify by liyanjie 2005-12-21 end
			           	                             SwfLogDto swfLogDto2 = new SwfLogDto();
			                 			             swfLogDto2 =(SwfLogDto) schedList.iterator().next() ;
			                 			             swfLogDto2.setNodeStatus( "4");
			                 			             workFlowDto.setUpdateSwfLog2Dto( swfLogDto2);
			                 			        }
			                 		     }
			           	                
			           	           }
			                 }
			           }
			           
			         //查勘保存后自动调度 开始
						if("1".equals(autoScheduleFlag) && "D".equals(riskType) ){				
							//1.取调度信息的大对象，调度id（scheduleID）用1
							UIScheduleAction uiScheduleAction = new UIScheduleAction();
						    ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(1,checkNo);
							//2.工作流各节点的处理
							boolean finishSchedule = true;// 是否完成调度
							//2.1取调度节点
							String strWhere = " flowid = '" + swfLogFlowID + "' and nodeType = 'sched'";
							String scheduleHandlerCode = "";
							String scheduleHandlerName = "";
							BLSwfLogFacade blSwflogFacade 		= new BLSwfLogFacade();
							SwfLogDto swfLogDtoScheduleNode 	= new SwfLogDto();
							Collection swflogCollection = blSwflogFacade.findByConditions(strWhere);
							if(swflogCollection.size() == 1){
								swfLogDtoScheduleNode = (SwfLogDto)swflogCollection.iterator().next();
								swfLogDtoScheduleNode.setNodeStatus(scheduleDto.getPrpLclaimStatusDto().getStatus());
								swfLogDtoScheduleNode.setNextBusinessNo(checkNo);
								scheduleHandlerCode = swfLogDtoScheduleNode.getHandlerCode();//记录下调度节点的处理员
								scheduleHandlerName = swfLogDtoScheduleNode.getHandlerName();
								
								//2.2新增定损节点
								Collection nextNodeList = new ArrayList();
								PrpLscheduleItemDto prplScheduleItemDto = new PrpLscheduleItemDto();
								String prplScheduleComCode = scheduleDto.getPrpLscheduleMainWFDto().getScheduleObjectID();
							    String prplScheduleComName = scheduleDto.getPrpLscheduleMainWFDto().getScheduleObjectName();
								for(int i = 0; i < scheduleDto.getPrpLscheduleItemDtoList().size(); i++){
									prplScheduleItemDto = (PrpLscheduleItemDto)scheduleDto.getPrpLscheduleItemDtoList().get(i);
									if (prplScheduleItemDto.getSurveyTimes() == 0) {
						                  SwfLogDto swfLogNextNode = new SwfLogDto();
						                  swfLogNextNode.setNodeNo(0);
						                  swfLogNextNode.setNodeType(prplScheduleItemDto.getNextNodeNo());
						                  swfLogNextNode.setHandlerCode("");
						                  swfLogNextNode.setHandlerName("");
						                  //保存调度号码和itemitemNo的号码
						                  swfLogNextNode.setScheduleID(prplScheduleItemDto.getScheduleID()) ;
						                  swfLogNextNode.setLossItemCode(prplScheduleItemDto.getItemNo() + "");
							              //保存车牌的号码
							              swfLogNextNode.setLossItemName(prplScheduleItemDto.getLicenseNo());
							              //保存是否保单车辆的标志
							              swfLogNextNode.setInsureCarFlag(prplScheduleItemDto.getInsureCarFlag()) ;
						                  //紧急标志位
						                  swfLogNextNode.setExigenceGree(prplScheduleItemDto.getExigenceGree());
						                  swfLogNextNode.setNewHandleDept(prplScheduleComCode);
						                  
						                  nextNodeList.add(swfLogNextNode);
						               }
								}
								//有需要新增调度的节点时，才进行自动调度
								if (nextNodeList.size() >0){
									swfLogDtoScheduleNode.setNextNodeListType("1");//如果得1，就是需要指定下一个节点的序列，如果不是，就是从模板上寻找下面的节点
									swfLogDtoScheduleNode.setSwfLogList(nextNodeList);
									
									//3.处理定损调度数据(prpLscheduleItem)，查勘调度数据(prpLscheduleMainWF)不用处理
								    for(int i = 0; i < scheduleDto.getPrpLscheduleItemDtoList().size(); i++){
								    	prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleDto.getPrpLscheduleItemDtoList().get(i);
								    	if(prpLscheduleItemDto.getSurveyTimes() == 0){
								    		prpLscheduleItemDto.setSurveyTimes(1);
								    		prpLscheduleItemDto.setScheduleObjectID(prplScheduleComCode);
								    		prpLscheduleItemDto.setScheduleObjectName(prplScheduleComName);
								    		prpLscheduleItemDto.setOperatorCode(user.getUserCode());
								    		if("".equals(prpLscheduleItemDto.getExigenceGree()) || prpLscheduleItemDto.getExigenceGree() == null){
								    			prpLscheduleItemDto.setExigenceGree("1");//案件状态1：一般案件，0：紧急案件
								    		}
								    	}
								    }
								    
								    //4. 半流程的特殊处理 
									WorkFlowDto workFlowDtoSchedule = workFlowViewHelper.viewToDto(user,swfLogDtoScheduleNode);
									
									// 上一步对工作流的处理将调度节点的处理员更新为当前提交查勘节点的处理员，此处将其还原为原来的处理员
									workFlowDtoSchedule.getUpdateSwfLogDto().setHandlerCode(scheduleHandlerCode);
									workFlowDtoSchedule.getUpdateSwfLogDto().setHandlerName(scheduleHandlerName);
									
									//5.保存调度及工作流信息
									 if ((workFlowDtoSchedule.getCreate()) || (workFlowDtoSchedule.getUpdate())
											|| (workFlowDtoSchedule.getSubmit())
											|| (workFlowDtoSchedule.getClose())) {
										uiScheduleAction.save(scheduleDto, workFlowDtoSchedule);
									} else {
										uiScheduleAction.save(scheduleDto, workFlowDtoSchedule);
										throw new Exception("报案号:" + checkNo
												+ ";注意:没有发现与工作流流程相关任何数据！！");
									}
							    }
								if ((workFlowDto.getCreate()) || (workFlowDto.getUpdate()) ||(workFlowDto.getSubmit())||(workFlowDto.getClose()))
								{ 
									uiScheduleAction.save(scheduleDto, workFlowDto);
								} else {
									throw new Exception(checkNo+";注意:没有发现与工作流流程相关任何数据！！");
								}
							}				
						}   
			           
					flag = true;
				} else {
					throw new Exception("您无权处理该案件。。。");
				}
			} 
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return flag;
		
	}
	
	/**
	 * 方法说明： 通过从任务列表传过来的报案号，读取任务相关信息，包括保单号、报案号、已出险次数、出险时间、出险地点、车牌号码、联系人、联系人地址、联系电话、联系人邮编等。
	 * @param registNo——报案号
	 * @return
	 * @throws SOAPException 
	 */
	public SurveyViewInfo getSurveyInfo(String registNo,String userNo) throws SOAPException {
		SurveyViewInfo surveyViewInfo = null;
		try {
			if (isEmpty(registNo) || isEmpty(userNo)) {
				throw new Exception("参数列表不能为空。。。");
			}
			BLRegistFacade bLRegistFacade = new BLRegistFacade();
			RegistDto registDto = bLRegistFacade.findByPrimaryKey(registNo);
			PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
			if(prpLregistDto==null) {
				throw new Exception("报案号信息无效。。。。");
			}
			surveyViewInfo = new SurveyViewInfo();
			String damageTime = "";
			int perilCount = 0;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			damageTime = dateFormat.format(prpLregistDto.getDamageStartDate().getTime())+prpLregistDto.getDamageStartHour();
			Collection<?> registList = new UIRegistAction().findSamePolicyRegist(prpLregistDto.getPolicyNo());
			
			if(!isEmpty(registList)) {
				perilCount = registList.size();
			}
			String policyNo = prpLregistDto.getPolicyNo();
			String LinkPolicyNo = "";
			String riskCode = prpLregistDto.getRiskCode();
			BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
			if("0506".equals(riskCode) || "0586".equals(riskCode) || "0576".equals(riskCode)){
				String conditions = " policyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
				}
			}else{
				String conditions = " mainPolicyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getPolicyNo();
				}
			}
			if(!isEmpty(LinkPolicyNo)){
				policyNo += "," + LinkPolicyNo;
			}
			UICodeAction uiCodeAction = new UICodeAction();
			String checkUserName = uiCodeAction.translateUserCode(userNo, true);
			//驾驶员信息
			BLPrpLdriverFacade blPrpLdriverFacade = new BLPrpLdriverFacade();
			PrpLdriverDto prpLdriverDto = blPrpLdriverFacade.findByPrimaryKey(registNo, 0);
			//查勘报告
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			String conditions = "registNo = '" + registNo +"' and textType = '3' order by lineNo" ;
			ArrayList prpLregistTextDtoList = (ArrayList)blPrpLregistTextFacade.findByConditions(conditions);
			String checkReport = "";
			for(int index = 0; index < prpLregistTextDtoList.size();index++){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList.get(index);
				checkReport += prpLregistTextDto.getContext();
			}
			surveyViewInfo.setDamageAddress(prpLregistDto.getDamageAddress());
			surveyViewInfo.setDamageTime(damageTime);//
			surveyViewInfo.setLicenseNo(prpLregistDto.getLicenseNo());
			surveyViewInfo.setLinkerAddress(prpLregistDto.getInsuredAddress());
			surveyViewInfo.setLinkerName(prpLregistDto.getLinkerName());
			surveyViewInfo.setLinkerPhone(prpLregistDto.getPhoneNumber());
			surveyViewInfo.setLinkerPostCode(prpLregistDto.getLinkerPostCode());
			surveyViewInfo.setPerilCount(perilCount);
			surveyViewInfo.setPolicyNo(policyNo);
			surveyViewInfo.setRegistNo(prpLregistDto.getRegistNo());
			surveyViewInfo.setFirstSiteFlag(prpLregistDto.getFirstSiteFlag());
			surveyViewInfo.setDamageCode(prpLregistDto.getDamageCode());
			surveyViewInfo.setIndemnityDuty(prpLregistDto.getIndemnityDuty());
			surveyViewInfo.setDamageAreaCode(prpLregistDto.getDamageAreaCode());
			surveyViewInfo.setClaimType(prpLregistDto.getClaimType());
			surveyViewInfo.setCheckUserName(checkUserName);
			surveyViewInfo.setDriverName(prpLdriverDto.getDriverName());
			surveyViewInfo.setDriverPhone(prpLdriverDto.getDriverSeaRoute());
			surveyViewInfo.setCertTypeCode(prpLdriverDto.getIdentifyType());
			surveyViewInfo.setCertNo(prpLdriverDto.getIdentifyNumber());
			surveyViewInfo.setSurveyReport(checkReport);
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return surveyViewInfo;
	}
	
	/**
	 * 将输入的等信息，暂时提交至数据库中的查勘记录表，并将任务信息中的任务状态变更为暂存状态。
	 *@param policyNo——保单号             
	*@param registNo——报案号
	*@param damageStartDate——出险日期 
	*@param damageStartHour——出险时间
	*@param damageAddress——出险地点
	*@param checkDate——查勘日期
	*@param checkStartHour——查勘时间
	*@param checkSite——查勘地点
	*@param firstSiteFlag——是否第一现场
	*@param checkType——查勘类型
	*@param check1——查勘人1
	*@param check2——查勘人2
	*@param damageCode——出险原因号
	*@param damageTypeCode——事故原因号 
	*@param indemnityDuty——事故责任
	*@param damageAreaCode——出险区域号
	*@param claimType——赔案类别
	*@param remark——备注
	 * @return 是否提交成功
	 * @throws SOAPException
	 */
	public boolean surveyInfoSubmit(String policyNo, String registNo, String damageStartDate, String damageStartHour, String damageAddress, String checkDate, String checkStartHour, String checkSite, String firstSiteFlag, String checkType, String check1, String check2, String damageCode, String damageTypeCode, String indemnityDuty, String damageAreaCode, String claimType, String remark, String driverName, String driverPhone, String certTypeCode, String certNo,String surveyReport) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(policyNo) || isEmpty(registNo) || isEmpty(damageAddress) || isEmpty(checkDate) || isEmpty(checkStartHour)
					|| isEmpty(checkSite) || isEmpty(firstSiteFlag) || isEmpty(checkType) || (isEmpty(check1)&&isEmpty(check2)) || isEmpty(damageCode) || isEmpty(damageTypeCode)
					|| isEmpty(indemnityDuty) || isEmpty(damageAreaCode) || isEmpty(claimType)
					|| isEmpty(driverName)|| isEmpty(certTypeCode) || isEmpty(certNo) || isEmpty(surveyReport)) {
				throw new Exception("参数均不能为空。。。。");
			}
			PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
			UICodeAction uICodeAction = new UICodeAction();
			BLPrpLcheckFacade bLPrpLcheckFacade = new BLPrpLcheckFacade();
			prpLcheckDto.setPolicyNo(policyNo);           
			prpLcheckDto.setRegistNo(registNo);
			prpLcheckDto.setRiskCode(policyNo.substring(1, 5));
			prpLcheckDto.setDamageStartDate(new DateTime(damageStartDate));
			prpLcheckDto.setDamageStartHour(damageStartHour);
			prpLcheckDto.setDamageAddress(damageAddress);
			prpLcheckDto.setCheckDate(new DateTime(checkDate));
//			prpLcheckDto.setCheckStartHour(checkStartHour);  //库中不存在该字段。
			prpLcheckDto.setRepeatInsureFlag("N");//不确定咱时设置为N
			prpLcheckDto.setReferSerialNo(1);//均设置为1
			prpLcheckDto.setCheckSite(checkSite);
			prpLcheckDto.setFirstSiteFlag(firstSiteFlag);
			prpLcheckDto.setCheckType(checkType);
			prpLcheckDto.setChecker1(check1);
			prpLcheckDto.setChecker2(check2);
			prpLcheckDto.setDamageCode(damageCode);
			prpLcheckDto.setDamageName(uICodeAction.translateCodeCode(UICodeAction.DAMAGECODE,damageCode,true));
			prpLcheckDto.setDamageTypeCode(damageTypeCode);
			prpLcheckDto.setDamageTypeName(uICodeAction.translateCodeCode(UICodeAction.DAMAGETYPECODE,damageTypeCode,true));
			prpLcheckDto.setIndemnityDuty(indemnityDuty);
			prpLcheckDto.setDamageAreaCode(damageAreaCode);
			prpLcheckDto.setDamageAreaName(uICodeAction.translateCodeCode(UICodeAction.DAMAGEAREACODE, damageAreaCode, true));
			prpLcheckDto.setClaimType(claimType);
			prpLcheckDto.setRemark(remark);
			
			if(bLPrpLcheckFacade.findByPrimaryKey(registNo, 1)==null) {//不存在则插入否则就更新
				bLPrpLcheckFacade.insert(prpLcheckDto);
			} else {
				bLPrpLcheckFacade.update(prpLcheckDto);
			}
			//驾驶员信息
			String conditions = "policyNo = '" + policyNo + "'";
			String licenseNo = "";
			BLPrpCitemCar blPrpCitemCar = new BLPrpCitemCar();
			blPrpCitemCar.query(conditions);
			if(blPrpCitemCar.getSize() > 0){
				licenseNo = blPrpCitemCar.getArr(0).getLicenseNo();
			}
			BLPrpLdriverFacade blPrpLdriverFacade = new BLPrpLdriverFacade();
			PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
			prpLdriverDto.setRegistNo(registNo);
			prpLdriverDto.setClaimNo(uICodeAction.translateBusinessCode(registNo, true));
			prpLdriverDto.setRiskCode(prpLcheckDto.getRiskCode());
			prpLdriverDto.setPolicyNo(policyNo);
			prpLdriverDto.setSerialNo(0);
			prpLdriverDto.setDriverName(driverName);
			prpLdriverDto.setDriverSeaRoute(driverPhone);
			//add by zhaolu 20060817 start
			//reason添加驾驶员证件号
			prpLdriverDto.setDrivingLicenseNo(licenseNo);
			prpLdriverDto.setIdentifyType(certTypeCode);
			prpLdriverDto.setIdentifyNumber(certNo);
			blPrpLdriverFacade.delete(registNo, 0);
			blPrpLdriverFacade.insert(prpLdriverDto);
			//查勘报告
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			ArrayList prpLregistTextDtoList = new ArrayList();
			PrpLregistTextDto prpLregistTextDto;
			String conditions1 = "registNo = '" + registNo +"' and textType = '3' " ;
			String[] rules = StringUtils.split(surveyReport,70);
	        for(int k=0;k<rules.length;k++){
	          prpLregistTextDto = new PrpLregistTextDto();
	          prpLregistTextDto.setRegistNo(registNo);
	          prpLregistTextDto.setContext(rules[k]);
	          prpLregistTextDto.setLineNo(k+1);
	          prpLregistTextDto.setTextType("3");
	          prpLregistTextDtoList.add(prpLregistTextDto);
	        }
	        blPrpLregistTextFacade.deleteByConditions(conditions1);
	        for(int index = 0; index < prpLregistTextDtoList.size();index++){
	        	prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList.get(index);
	        	blPrpLregistTextFacade.insert(prpLregistTextDto);
	        }
			//修改工作流
			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo='"+registNo+"' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if (!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				String nodeStatus = swfLogDto.getNodeStatus();
				if (nodeStatus.equals("0") || nodeStatus.equals("1") || nodeStatus.equals("2") || nodeStatus.equals("3")) {
					swfLogDto.setNodeStatus("2");
					// swfLogDto.setHandlerCode(user.getUserCode());
					// swfLogDto.setHandlerName(user.getUserName());
					if (isEmpty(swfLogDto.getKeyOut())) {
						swfLogDto.setKeyOut(registNo);
					}
					// swfLogDto.setLossItemCode();
					swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
					bLSwfLogFacade.update(swfLogDto);
					
					BLPrpLcheckFacade blPrpLcheckFacade = new BLPrpLcheckFacade();
					PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
					prpLclaimStatusDto.setStatus("2");
					prpLclaimStatusDto.setBusinessNo(prpLcheckDto.getRegistNo() );
			        prpLclaimStatusDto.setPolicyNo(prpLcheckDto.getPolicyNo());
			        prpLclaimStatusDto.setNodeType("check");
			        prpLclaimStatusDto.setSerialNo(0);
			        prpLclaimStatusDto.setRiskCode(prpLcheckDto.getRiskCode());
			        //取得当前用户信息，写操作员信息到查勘中
			        prpLclaimStatusDto.setHandlerCode(swfLogDto.getHandlerCode());
			        //prpLclaimStatusDto.setHandlerCode(prpLcheckDto.getOperatorCode() );
			        prpLclaimStatusDto.setInputDate(prpLcheckDto.getCheckDate() );
			        prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			        BLPrpLclaimStatusFacade blPrpLclaimStatusFacade = new BLPrpLclaimStatusFacade();
			        blPrpLclaimStatusFacade.delete(prpLcheckDto.getRegistNo(), "check", 0);
			        blPrpLclaimStatusFacade.insert(prpLclaimStatusDto);
					flag = true;
				}

			}
			
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}

		return flag;
	}
	
	/**
	 * 方法说明： 数据交互：通过选择不同的二级公司机构，根据公司代码获得不同三级公司机构。
	 * 
	 * @param companyNo 公司代码
	 * @return
	 * @throws SOAPException 
	 */
	public CompanyInfo[] getComanyCode(String companyNo) throws SOAPException {//Update 待测
		CompanyInfo[] companyInfoList = null;
		try {
			if (isEmpty(companyNo)) {
				throw new Exception("公司代码不能为空。。。");
			}
			// 具体业务。。。。。
			String conditions = " uppercomcode = '"+companyNo+"' and validstatus= '1' and ( comCode not like '0000%' or comCode like '00000013%' ) order by comcode";
			BLPrpDcompanyFacade bLPrpDcompanyFacade = new BLPrpDcompanyFacade();
			Collection<PrpDcompanyDto> companyList = bLPrpDcompanyFacade.findByConditions(conditions);
			if(!isEmpty(companyList)) {
				companyInfoList = new CompanyInfo[companyList.size()];
				int i = 0;
				for(PrpDcompanyDto element:companyList) {
					companyInfoList[i++] = new CompanyInfo(element.getComCode(), element.getComCName());
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return companyInfoList;
	}
	
	/**
	 * 数据交互：通过选择不同的公司，根据公司代码获得不同公司的员工的代码、姓名。
	 * @param companyNo——公司代码
	 * @return
	 * @throws SOAPException 
	 */
	public UserInfo[] getStaffByComanyCode(String companyNo) throws SOAPException {//Update 完成。
		UserInfo[] userInfoList = null;
		try {
			if (isEmpty(companyNo)) {
				throw new Exception("机构代码不能为空。。。。。");
			}

			UICodeAction uiCodeAction = new UICodeAction();
			String conditions = "  ValidStatus='1' " + " AND comCode in ( select ComCode from prpdCompany Start With ComCode = '" + companyNo + "' Connect By Prior comCode =  uppercomCode"
					+ " and prior comcode != comcode and validstatus='1')";
			Collection<PrpDuserDto> collection = uiCodeAction.findByConditions(UICodeAction.HANDERCODE, conditions, 0, 0);
			if (!isEmpty(collection)) {
				boolean checkPower = false;
				List<UserInfo> list = new ArrayList<UserInfo>();

				for (PrpDuserDto element : collection) {
					com.sinosoft.platform.dto.domain.PrpDuserDto platformPrpDuserDto = new com.sinosoft.platform.dto.domain.PrpDuserDto();
					BLPrpDcompany prpDcompany = new BLPrpDcompany();
					String upperComCode = prpDcompany.getCenterCode(element.getComCode());
					platformPrpDuserDto.setLoginComCode(upperComCode);
					platformPrpDuserDto.setUserCode(element.getUserCode());
					checkPower = UIPowerAction.checkPowerReturn(platformPrpDuserDto, Constants.TASK_CLAIM_CHECK);
					if (checkPower) {
						list.add(new UserInfo(element.getUserCode(), element.getUserName()));
					}
				}
				if(!isEmpty(list)) {
					userInfoList = list.toArray(new UserInfo[0]);
				}
			}

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return userInfoList;
	}
	
	/**
	 * 方法说明： 通过从任务列表传过来的报案号，读取查勘员暂存在数据库中的暂存任务相关信息
	 * 
	 * @param registNo
	 *            ——报案号
	 * @return 
	 * @throws SOAPException
	 */
	public StoredCheckInfo getStoreInfo(String registNo) throws SOAPException {
		StoredCheckInfo storedCheckInfo = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("报案号不能为空");
			}
			// 具体业务。。。。。
			BLPrpLcheckFacade bLPrpLcheckFacade = new BLPrpLcheckFacade();
			PrpLcheckDto prpLcheckDto = bLPrpLcheckFacade.findByPrimaryKey(registNo, 1);
			if(prpLcheckDto==null) {
				throw new Exception("查询数据不存在！");
			}
			storedCheckInfo = new StoredCheckInfo();
			String damageStartDate = "";
			String checkDate = "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			damageStartDate = dateFormat.format(prpLcheckDto.getDamageStartDate().getTime());
			checkDate = dateFormat.format(prpLcheckDto.getCheckDate().getTime());
			
			String policyNo = prpLcheckDto.getPolicyNo();
			String LinkPolicyNo = "";
			String riskCode = prpLcheckDto.getRiskCode();
			BLPrpCmainSub blPrpCmainSub = new BLPrpCmainSub();
			if("0506".equals(riskCode) || "0586".equals(riskCode) || "0576".equals(riskCode)){
				String conditions = " policyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getMainPolicyNo();
				}
			}else{
				String conditions = " mainPolicyNo = '" + policyNo + "'";
				blPrpCmainSub.query(conditions);
				if(blPrpCmainSub.getSize() > 0){
					LinkPolicyNo = blPrpCmainSub.getArr(0).getPolicyNo();
				}
			}
			if(!isEmpty(LinkPolicyNo)){
				policyNo += "," + LinkPolicyNo;
			}
			//驾驶员信息
			BLPrpLdriverFacade blPrpLdriverFacade = new BLPrpLdriverFacade();
			PrpLdriverDto prpLdriverDto = blPrpLdriverFacade.findByPrimaryKey(registNo, 0);
			//查勘报告
			BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
			String conditions = "registNo = '" + registNo +"' and textType = '3' order by lineNo" ;
			ArrayList prpLregistTextDtoList = (ArrayList)blPrpLregistTextFacade.findByConditions(conditions);
			String checkReport = "";
			for(int index = 0; index < prpLregistTextDtoList.size();index++){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)prpLregistTextDtoList.get(index);
				checkReport += prpLregistTextDto.getContext();
			}
			storedCheckInfo.setPolicyNo(policyNo);//保单号             
			storedCheckInfo.setRegistNo(prpLcheckDto.getRegistNo());//报案号
			storedCheckInfo.setDamageStartDate(damageStartDate);//出险日期 
			storedCheckInfo.setDamageStartHour(prpLcheckDto.getDamageStartHour());//出险时间
			storedCheckInfo.setDamageAddress(prpLcheckDto.getDamageAddress());//出险地点
			storedCheckInfo.setCheckDate(checkDate);//查勘日期
			storedCheckInfo.setCheckStartHour("10");//查勘时间
			storedCheckInfo.setCheckSite(prpLcheckDto.getCheckSite());//查勘地点
			storedCheckInfo.setFirstSiteFlag(prpLcheckDto.getFirstSiteFlag());//是否第一现场
			storedCheckInfo.setCheckType(prpLcheckDto.getCheckType());//查勘类型
			storedCheckInfo.setChecker1(prpLcheckDto.getChecker1());//查勘人1
			storedCheckInfo.setChecker2(prpLcheckDto.getChecker2());//查勘人2
			storedCheckInfo.setDamageCode(prpLcheckDto.getDamageCode());//出险原因号
			storedCheckInfo.setDamageTypeCode(prpLcheckDto.getDamageTypeCode());//事故原因号 
			storedCheckInfo.setIndemnityDuty(prpLcheckDto.getIndemnityDuty());//事故责任
			storedCheckInfo.setDamageAreaCode(prpLcheckDto.getDamageAreaCode());//出险区域号
			storedCheckInfo.setClaimType(prpLcheckDto.getClaimType());//赔案类别
			storedCheckInfo.setRemark(prpLcheckDto.getRemark());//备注
			BLPrpLregistFacade blPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = blPrpLregistFacade.findByPrimaryKey(prpLcheckDto.getRegistNo());
			if(prpLregistDto != null){
				storedCheckInfo.setLicenseNo(prpLregistDto.getLicenseNo());
				storedCheckInfo.setLinkerName(prpLregistDto.getLinkerName());
				storedCheckInfo.setLinkerPhone(prpLregistDto.getPhoneNumber());
				storedCheckInfo.setLinkerAddress(prpLregistDto.getInsuredAddress());
				storedCheckInfo.setLinkerPostCode(prpLregistDto.getLinkerPostCode());
			}
			storedCheckInfo.setDriverName(prpLdriverDto.getDriverName());
			storedCheckInfo.setDriverPhone(prpLdriverDto.getDriverSeaRoute());
			storedCheckInfo.setCertTypeCode(prpLdriverDto.getIdentifyType());
			storedCheckInfo.setCertNo(prpLdriverDto.getIdentifyNumber());
			storedCheckInfo.setSurveyReport(checkReport);
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return storedCheckInfo;

	}
	
	/**
	 * 转交任务修改任务信息
	 * @param reassignUserNo 转交人
	 * @param reassignCompanyNo 转交员工所属公司代码
	 * @param userNo 员工姓名
	 * @param CompanyNo 员工所属公司
	 * @param registNo 报案号
	 * @return
	 * @throws SOAPException 
	 */
	public boolean reassignTaskSubmit(String reassignUserNo, String reassignCompanyNo, String userNo, String CompanyNo, String registNo) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(reassignUserNo) || isEmpty(reassignCompanyNo) || isEmpty(userNo) || isEmpty(CompanyNo) || isEmpty(registNo)) {
				throw new Exception("参数列表不能为空。。。");
			}
			// 具体业务。。。。。
			BLSwfLogFacade bLSwfLogFacade = new BLSwfLogFacade();
			String condition = " registNo='" + registNo + "' and nodetype = 'check' and flowStatus!='0'";
			Collection<SwfLogDto> swfList = bLSwfLogFacade.findByConditions(condition);
			if (!isEmpty(swfList)) {
				SwfLogDto swfLogDto = swfList.iterator().next();
				String nodeStatus = swfLogDto.getNodeStatus();
				if (nodeStatus.equals("0") || nodeStatus.equals("1") || nodeStatus.equals("2") || nodeStatus.equals("3")) {
					if (swfLogDto.getHandlerCode().equals(reassignUserNo)) {
						UICodeAction uiCodeAction = new UICodeAction();
						String userName = uiCodeAction.translateUserCode(userNo, true);
						swfLogDto.setHandleDept(CompanyNo);
						swfLogDto.setHandlerCode(userNo);
						swfLogDto.setHandlerName(userName);
						swfLogDto.setHandleTime(new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString());
						bLSwfLogFacade.update(swfLogDto);// 更新工作流数据
						flag = true;
					}
					
				} else {
					throw new Exception("该节点处于不可转交状态！");
				}

			}

		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return flag;
	}
	
	
	/**
	 *方法说明：以File类读取文件并转化为字节数组，经base 64编码后成为一个字符串，在服务端获取到字符串后进行base 64解码成字节数组，然后将字节数组写入文件，存放在服务器的目录中，通过报案号将照片与案件关联。
	 * @param registNo——报案号
	 * @param vehicleID——受损车辆序号
	 * @param collectorName——照片搜集人
	 * @param fileName——文件名
	 * @param image——base 64编码（将文件转化为字节数组，然后编码）
	 * @param imageType——图片分类代码
	 * @param description——照片说明
	 * @return
	 * @throws SOAPException
	 */
	public boolean uploadImage(String registNo, String vehicleID ,String collectorName,String fileName,String image,String imageType,String description) throws SOAPException {
		boolean flag = false;
		try {
			if (isEmpty(registNo) || isEmpty(fileName) || isEmpty(image) || isEmpty(imageType)) {
				throw new Exception("相关参数不能为空。。。");
			}
			// 具体业务。。。。。
			// Base64解码
			FtpClient ftp = null;
			BLPrpLcertifyImgFacade imgFacade = new BLPrpLcertifyImgFacade();
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade.findByPrimaryKey(registNo);
			BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			String policyNo = prpLregistDto.getPolicyNo();
			String businessNo = registNo;
			String riskCode = prpLregistDto.getRiskCode();
			String nodeType = "certi";
			String lossItemName = null;
			String typeCode = null;
			String picName = null;
			String uploadYear = null;
			String remoteFileName = null;
			String fileExtName = null;
			String yearMonthDay = null;
			DateTime signInDate = null;
			String picPath = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			
			if("0".equals(vehicleID)) {//正常的资料
				lossItemName = "claim";
			} else if("99".equals(vehicleID)){
				lossItemName = "其他资料";
			} else{//与受损车辆相关
				lossItemName = bLPrpLthirdPartyFacade.findByPrimaryKey(registNo, Integer.parseInt(vehicleID)).getLicenseNo();
			}
			
			// 生成jpeg图片
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] buffer = decoder.decodeBuffer(image);
			for (int i = 0; i < buffer.length; ++i) {
				if (buffer[i] < 0) {// 调整异常数据
					buffer[i] += 256;
				}
			}

			Calendar c = Calendar.getInstance();
			uploadYear = String.valueOf(c.get(Calendar.YEAR));
			yearMonthDay = dateFormat.format(c.getTime());
			signInDate = new DateTime(DateTime.current().toString());
			int maxSerialNo = 0;
			int maxTypeCodeNo = 0;

			maxSerialNo = imgFacade.getCount("policyNo='" + policyNo + "' and businessNo='" + businessNo + "'")+1;
			String[] types = null;
			types = imageType.split("@@");
			typeCode = types[0];
			picName = types[1];
			maxTypeCodeNo = imgFacade.getCount("policyNo='" + policyNo + "' and businessNo='" + businessNo
					+ "' and typeCode='" + types[0] + "'")+1;
			PrpLcertifyImgDto prpLcertifyImgDto = new PrpLcertifyImgDto();

			fileName = fileName.replaceAll("\\\\", "/");
			int indexDisk = fileName.lastIndexOf("/");
			fileName = fileName.substring(indexDisk + 1);
			int indexExt = fileName.lastIndexOf(".");
			fileExtName = fileName.substring(indexExt + 1);
			remoteFileName = typeCode + "_" + maxTypeCodeNo + "." + fileExtName;
			picPath = "/" + uploadYear + "/" + yearMonthDay + "/" + riskCode + "/" + businessNo + "/" + typeCode
					+ vehicleID;
			
			String ftpUser = AppConfig.get("sysconst.FTP_USER");
			String ftpPass = AppConfig.get("sysconst.FTP_PASS");
			String ftpUrl  = AppConfig.get("sysconst.FTP_URL");
			String ftpDir  = AppConfig.get("sysconst.WRITEDIR");
			ftp = new FtpClient();
			ftp.open(ftpUrl);
			ftp.login(ftpUser, ftpPass);
			ftp.cd(ftpDir);
			ftp.setMode(FtpClient.BIN_MODE);
			ftp.mkdirs(picPath.substring(1));
			OutputStream out = ftp.getFileInputStream(ftp.pwd() + picPath + "/" + remoteFileName);
			out.write(buffer);
			out.flush();
			out.close();
			
			prpLcertifyImgDto.setPolicyNo(policyNo);
			prpLcertifyImgDto.setBusinessNo(businessNo);
			prpLcertifyImgDto.setSerialNo(maxSerialNo);
			prpLcertifyImgDto.setImgSize(buffer.length);
			prpLcertifyImgDto.setLossItemCode(vehicleID);
			prpLcertifyImgDto.setLossItemName(lossItemName);
			// prpLcertifyImgDto.setPicName(typeCode + maxTypeCodeNo);
			prpLcertifyImgDto.setCollectorName(collectorName);
			prpLcertifyImgDto.setUploadFileName(fileName);
			prpLcertifyImgDto.setDisplayName(description);
			prpLcertifyImgDto.setImgFileName(remoteFileName);
			prpLcertifyImgDto.setPicName(picName);
			prpLcertifyImgDto.setPicPath(picPath);
			prpLcertifyImgDto.setTypeCode(typeCode);
			prpLcertifyImgDto.setUploadNodeFlag(nodeType);
			prpLcertifyImgDto.setThirdPartyCode("11111111");
			prpLcertifyImgDto.setReceiveStatus("11");
			prpLcertifyImgDto.setFlag("1");
			prpLcertifyImgDto.setValidStatus("1");
			prpLcertifyImgDto.setSignInDate(signInDate);
			imgFacade.insert(prpLcertifyImgDto);
			
			BLPrpLcertifyDirectFacade blPrpLcertifyDirectFacade = new BLPrpLcertifyDirectFacade();
			String conditions = " registNo = '" + registNo + "'";
			int count = blPrpLcertifyDirectFacade.getCount(conditions);
			String conditions1 = " registNo = '" + registNo +"' and lossItemCode = '" + vehicleID + "' and typeCode = '" + typeCode + "'";
			ArrayList prpLcertifyDirectDtoList = (ArrayList)blPrpLcertifyDirectFacade.findByConditions(conditions1);
			PrpLcertifyDirectDto prpLcertifyDirectDto = new PrpLcertifyDirectDto();
			if(isEmpty(prpLcertifyDirectDtoList)){
				prpLcertifyDirectDto.setRegistNo(registNo);
				prpLcertifyDirectDto.setSerialNo(count + 1);
				prpLcertifyDirectDto.setRiskCode(prpLregistDto.getRiskCode());
				prpLcertifyDirectDto.setPolicyNo(prpLregistDto.getPolicyNo());
				if("99".equals(typeCode.substring(0, 2))){
					vehicleID = "0";
				}
				prpLcertifyDirectDto.setLossItemCode(vehicleID);
				prpLcertifyDirectDto.setTypeCode(typeCode);
				prpLcertifyDirectDto.setTypeName(picName);
				prpLcertifyDirectDto.setColumnValue("columevaue");
				prpLcertifyDirectDto.setCompelFlag("1");
				prpLcertifyDirectDto.setBusinessFlag("1");
				blPrpLcertifyDirectFacade.insert(prpLcertifyDirectDto);
			}
			
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SOAPException(e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 
	 * @param registNo
	 * @param vehicleID
	 * @param licensePlateMo
	 * @param frameNo
	 * @param vehicleType
	 * @param engineNo
	 * @param licensePlateBackground
	 * @param brandModel
	 * @param brandModelName
	 * @param insuranceCompany
	 * @param insuranceCompanyName
	 * @param vehiclesUsefulLife
	 * @param vehicleIdentificationNumber
	 * @param mileage
	 * @param liabilityProportion
	 * @param lossAmount
	 * @param injuredOrNot
	 * @param otherVehiclesDriverName
	 * @param otherVehiclesDriverIdNo
	 * @param policyNo
	 * @return
	 * @throws SOAPException
	 */
	public boolean vehiclesInfoSubmit(String registNo, String vehicleID, String licensePlateMo, String frameNo,
			String vehicleType, String engineNo, String licensePlateBackground, String brandModel,
			String brandModelName, String insuranceCompany, String insuranceCompanyName, String vehiclesUsefulLife,
			String vehicleIdentificationNumber, String mileage, String liabilityProportion, String lossAmount,
			String injuredOrNot, String otherVehiclesDriverName, String otherVehiclesDriverIdNo, String policyNo)
			throws SOAPException {

		boolean flag = false;
		try {
			if (isEmpty(registNo) || isEmpty(vehicleID)) {
				throw new Exception("参数列表不能为空。。。");
			}
			BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade.findByPrimaryKey(registNo);
			String riskCode = prpLregistDto.getRiskCode();
			
			PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
			prpLthirdPartyDto.setRegistNo(registNo);
			prpLthirdPartyDto.setRiskCode(riskCode);
			prpLthirdPartyDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(vehicleID)));
			prpLthirdPartyDto.setClaimNo(claimNo);
			prpLthirdPartyDto.setLicenseNo(licensePlateMo); //                                                                 
			prpLthirdPartyDto.setLicenseColorCode(licensePlateBackground); //                                                   
			prpLthirdPartyDto.setCarKindCode(vehicleType);//
			if ("1".equals(vehicleID)) {
				prpLthirdPartyDto.setInsureCarFlag("1"); // 是标的车
				prpLthirdPartyDto.setLossFlag(injuredOrNot);
				prpLthirdPartyDto.setCarPolicyNo(prpLregistDto.getPolicyNo());
			} else {
				prpLthirdPartyDto.setInsureCarFlag("0"); // 不为标的车
				prpLthirdPartyDto.setLossFlag("1");
				prpLthirdPartyDto.setPrpLthirdPartyDriveName(otherVehiclesDriverName); //                                             
				prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(otherVehiclesDriverIdNo);//
				// 三者车辆保单号码
				if (isEmpty(policyNo)) {// 保单号
					prpLthirdPartyDto.setCarPolicyNo("2111111111111111sssss");// 默认为1
				} else {
					prpLthirdPartyDto.setCarPolicyNo(policyNo);//
				}
			}
			prpLthirdPartyDto.setEngineNo(engineNo);//                                                                   
			prpLthirdPartyDto.setFrameNo(frameNo); //                                                                   
			prpLthirdPartyDto.setBrandName(brandModelName);
			prpLthirdPartyDto.setModelCode(brandModel);// 
			prpLthirdPartyDto.setRunDistance(Double.parseDouble(DataUtils.nullToZero(mileage)));//                    
			prpLthirdPartyDto.setUseYears(Integer.parseInt(DataUtils.nullToZero(vehiclesUsefulLife)));//                            
			prpLthirdPartyDto.setDutyPercent(Double.parseDouble(DataUtils.nullToZero(liabilityProportion)));//                    
			prpLthirdPartyDto.setInsuredFlag("1"); // 是否 保险
			prpLthirdPartyDto.setInsureComCode(insuranceCompany);
			prpLthirdPartyDto.setInsureComName(insuranceCompanyName);// 
			prpLthirdPartyDto.setVINNo(vehicleIdentificationNumber); //
			
			bLPrpLthirdPartyFacade.delete(registNo, Integer.parseInt(vehicleID));//先删再插
			bLPrpLthirdPartyFacade.insert(prpLthirdPartyDto);
			
			BLPrpLcheckLossFacade blPrpLcheckLossFacade = new BLPrpLcheckLossFacade();
			String conditions = " registNo = '" + registNo + "' and lossFeeType = '1' order by serialNo ";
			String conditions1 = " registNo = '" + registNo + "'";
			ArrayList prpLcheckLossDtoList = (ArrayList)blPrpLcheckLossFacade.findByConditions(conditions);
			int countPrpLcheckLoss = blPrpLcheckLossFacade.getCount(conditions1);
			int count = prpLcheckLossDtoList.size();
			int serialNo = Integer.parseInt(vehicleID);
			int index = 0;
			if(count == 0 && countPrpLcheckLoss > 0){
				index = countPrpLcheckLoss + 1;
			}else{
				if(count < serialNo){
					index = countPrpLcheckLoss + 1;
				}else{
					index = ((PrpLcheckLossDto)prpLcheckLossDtoList.get(serialNo-1)).getSerialNo();
				}
			}
			PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
			prpLcheckLossDto.setRegistNo(registNo);
			prpLcheckLossDto.setClaimNo(claimNo);
			prpLcheckLossDto.setRiskCode(riskCode);
			prpLcheckLossDto.setPolicyNo(prpLregistDto.getPolicyNo());
			prpLcheckLossDto.setSerialNo(index);
			prpLcheckLossDto.setReferSerialNo(index);
			prpLcheckLossDto.setKindCode("A");
			prpLcheckLossDto.setLossFeeType("1");
			prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(lossAmount)));
			prpLcheckLossDto.setFlag("");
			blPrpLcheckLossFacade.delete(registNo, index);
			blPrpLcheckLossFacade.insert(prpLcheckLossDto);
			flag = true;
			
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return flag;
	}
	
	/**
	 * 读取查勘记录暂存数据（包括标的车和三者车的信息）
	 * @param registNo
	 * @return
	 * @throws SOAPException
	 */
	public VehicleInfo[] getStoreVehiclesInfo(String registNo) throws SOAPException {
		
		VehicleInfo[] vehicleInfoList = null;
		try {
			if (isEmpty(registNo)) {
				throw new Exception("报案号不能为空。。。。。");
			}
			BLPrpLthirdPartyFacade bLPrpLthirdPartyFacade = new BLPrpLthirdPartyFacade();
			BLPrpLcheckLossFacade bLPrpLcheckLossFacade = new BLPrpLcheckLossFacade ();
			String conditions = " registNo='"+registNo+"' order by serialNo ";
			String conditions1 = " registNo='"+registNo+"' and lossFeeType = '1' order by serialNo ";
			ArrayList<PrpLthirdPartyDto> result = (ArrayList)bLPrpLthirdPartyFacade.findByConditions(conditions);
			ArrayList prpLcheckLossDtoList = (ArrayList)bLPrpLcheckLossFacade.findByConditions(conditions1);
			if (!isEmpty(result)) {// 结果有效的话
				vehicleInfoList = new VehicleInfo[result.size()];
				int index = 0;
				for (int i = 0; i < result.size();i++) {
					PrpLthirdPartyDto element =  result.get(i);
					VehicleInfo vehicleInfo =  new VehicleInfo();
					vehicleInfo.setBrandName(element.getBrandName());
					vehicleInfo.setCarKindCode(element.getCarKindCode());
					vehicleInfo.setCarPolicyNo(element.getCarPolicyNo());
					vehicleInfo.setDutyPercent(element.getDutyPercent());
					vehicleInfo.setEngineNo(element.getEngineNo());
					vehicleInfo.setFrameNo(element.getFrameNo());
					vehicleInfo.setInsureComCode(element.getInsureComCode());
					vehicleInfo.setInsureComName(element.getInsureComName());
					vehicleInfo.setLicenseColorCode(element.getLicenseColorCode());
					vehicleInfo.setLicenseNo(element.getLicenseNo());
					vehicleInfo.setLossFlag(element.getLossFlag());
					vehicleInfo.setModelCode(element.getModelCode());
					vehicleInfo.setPrpLthirdPartyDriveLicensNo(element.getPrpLthirdPartyDriveLicensNo());
					vehicleInfo.setPrpLthirdPartyDriveName(element.getPrpLthirdPartyDriveName());
					vehicleInfo.setRegistNo(element.getRegistNo());
					vehicleInfo.setRunDistance(element.getRunDistance());
					vehicleInfo.setSerialNo(element.getSerialNo());
					vehicleInfo.setUseYears(element.getUseYears());
					vehicleInfo.setVINNo(element.getVINNo());
					if(!isEmpty(prpLcheckLossDtoList)){
						vehicleInfo.setLossFee(((PrpLcheckLossDto)prpLcheckLossDtoList.get(i)).getLossFee());
					}else{
						vehicleInfo.setLossFee(0.00);
					}
					vehicleInfoList[index++] = vehicleInfo;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return vehicleInfoList;

	}
	
	/**
	 * 发送财产信息
	 */
	public PropInfo[] getStorePropertyDamage(String registNo) throws SOAPException{
		PropInfo[] propInfoList = null;
		try {
			if(isEmpty(registNo)){
				throw new Exception("报案号不能为空。。。。。");
			}
			BLPrpLthirdPropFacade blPrpLthirdPropFacade = new BLPrpLthirdPropFacade();
			BLPrpLcheckLossFacade bLPrpLcheckLossFacade = new BLPrpLcheckLossFacade ();
			String conditions = "registNo = '" + registNo + "' order by serialNo ";
			String conditions1 = " registNo='"+registNo+"' and lossFeeType = '3' order by serialNo ";
			ArrayList prpLthirdPropDtoList = (ArrayList)blPrpLthirdPropFacade.findByConditions(conditions);
			ArrayList prpLcheckLossDtoList = (ArrayList)bLPrpLcheckLossFacade.findByConditions(conditions1);
			if(!isEmpty(prpLthirdPropDtoList)){
				propInfoList = new PropInfo[prpLthirdPropDtoList.size()];
				int index = 0;
				for(int i = 0;i < prpLcheckLossDtoList.size();i++){
					PrpLthirdPropDto prpLthirdPropDto = (PrpLthirdPropDto)prpLthirdPropDtoList.get(i);
					PrpLcheckLossDto prpLcheckLossDto = (PrpLcheckLossDto)prpLcheckLossDtoList.get(i);
					PropInfo propInfo = new PropInfo();
					propInfo.setRegistNo(prpLthirdPropDto.getRegistNo());
					propInfo.setSerialNo(prpLthirdPropDto.getSerialNo());
					propInfo.setLossItemName(prpLthirdPropDto.getLossItemName());
					propInfo.setLossItemDesc(prpLthirdPropDto.getLossItemDesc());
					propInfo.setKindCode(prpLcheckLossDto.getKindCode());
					propInfo.setLossAmount(prpLcheckLossDto.getLossFee());
					propInfoList[index++] = propInfo;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return propInfoList;
	}
	/**
	 * 获得财产信息
	 */
	public boolean propertyDamageSubmit(String registNo,String lossItemId, String lossName, 
			String lossExtentDesc, String insuranceTypeCode,String lossAmount) throws SOAPException{
		boolean flag = false;
		try {
			if(isEmpty(registNo) || isEmpty(lossItemId)){
				throw new Exception("参数列表不能为空。。。");
			}
			BLPrpLthirdPropFacade blPrpLthirdPropDtoFacade = new BLPrpLthirdPropFacade();
			String riskCode = registNo.trim().substring(1,5);
			int index = Integer.parseInt(lossItemId);
			PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
			prpLthirdPropDto.setRegistNo(registNo.trim());
			prpLthirdPropDto.setRiskCode(riskCode);
			prpLthirdPropDto.setSerialNo(index);
			prpLthirdPropDto.setLicenseNo("");
			prpLthirdPropDto.setLossItemCode("");
			prpLthirdPropDto.setLossItemName(lossName);
			prpLthirdPropDto.setLossItemDesc(lossExtentDesc);
			prpLthirdPropDto.setFlag("");
			blPrpLthirdPropDtoFacade.delete(registNo, index);
			blPrpLthirdPropDtoFacade.insert(prpLthirdPropDto);
			
			BLPrpLcheckLossFacade blPrpLcheckLossFacade = new BLPrpLcheckLossFacade();
			String conditions = " registNo = '" + registNo + "' and lossFeeType = '3' ";
			String conditions1 = " registNo = '" + registNo + "'";
			ArrayList prpLcheckLossDtoList = (ArrayList)blPrpLcheckLossFacade.findByConditions(conditions);
			int countPrpLcheckLoss = blPrpLcheckLossFacade.getCount(conditions1);
			int count = prpLcheckLossDtoList.size();
			int serialNo = Integer.parseInt(lossItemId);
			index = 0;
			if(count == 0 && countPrpLcheckLoss > 0){
				index = countPrpLcheckLoss + 1;
			}else{
				if(count < serialNo){
					index = countPrpLcheckLoss + 1;
				}else{
					index = ((PrpLcheckLossDto)prpLcheckLossDtoList.get(serialNo-1)).getSerialNo();
				}
			}
			UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(registNo.trim(), true);
			BLPrpLregistFacade bLPrpLregistFacade = new BLPrpLregistFacade();
			PrpLregistDto prpLregistDto = bLPrpLregistFacade.findByPrimaryKey(registNo.trim());
			PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
			prpLcheckLossDto.setRegistNo(registNo.trim());
			prpLcheckLossDto.setClaimNo(claimNo);
			prpLcheckLossDto.setRiskCode(riskCode);
			prpLcheckLossDto.setPolicyNo(prpLregistDto.getPolicyNo());
			prpLcheckLossDto.setSerialNo(index);
			prpLcheckLossDto.setReferSerialNo(index);
			prpLcheckLossDto.setKindCode(insuranceTypeCode);
			prpLcheckLossDto.setLossFeeType("3");
			prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(lossAmount)));
			prpLcheckLossDto.setFlag("");
			blPrpLcheckLossFacade.delete(registNo, index);
			blPrpLcheckLossFacade.insert(prpLcheckLossDto);
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		
		return flag;
	}
	/**
	 * 发送人伤信息
	 */
	public PersonInfo[] getStoreInjuredPeopleTrackingInfo(String registNo) throws SOAPException{
		PersonInfo[] personInfoList = null;
		try {
			if(isEmpty(registNo)){
				throw new Exception("报案号不能为空。。。。。");
			}
			BLPrpLpersonTraceFacade blPrpLpersonTraceFacade = new BLPrpLpersonTraceFacade();
			String conditions = "registNo = '" + registNo + "'";
			Collection<PrpLpersonTraceDto> prpLpersonTraceDtoList = blPrpLpersonTraceFacade.findByConditions(conditions);
			if(!isEmpty(prpLpersonTraceDtoList)){
				personInfoList = new PersonInfo[prpLpersonTraceDtoList.size()];
				int index = 0;
				for(Iterator<PrpLpersonTraceDto> iter = prpLpersonTraceDtoList.iterator();iter.hasNext();){
					PrpLpersonTraceDto prpLpersonTraceDto = iter.next();
					PersonInfo personInfo = new PersonInfo();
					personInfo.setRegistNo(prpLpersonTraceDto.getRegistNo());
					personInfo.setPersonNo(prpLpersonTraceDto.getPersonNo());
					personInfo.setPersonName(prpLpersonTraceDto.getPersonName());
					personInfo.setPersonSex(prpLpersonTraceDto.getPersonSex());
					personInfo.setPersonAge(prpLpersonTraceDto.getPersonAge());
					personInfo.setJobName(prpLpersonTraceDto.getJobName());
					personInfo.setReferKind(prpLpersonTraceDto.getReferKind());
					personInfo.setPartDesc(prpLpersonTraceDto.getPartDesc());
					personInfo.setHospital(prpLpersonTraceDto.getHospital());
					personInfo.setMotionFlag(prpLpersonTraceDto.getMotionFlag());
					personInfo.setWoundRemark(prpLpersonTraceDto.getWoundRemark());
					personInfoList[index++] = personInfo;
				}
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return personInfoList;
	}
	
	/**
	 *获得人伤信息
	 * 
	 */
	public boolean injuredPeopleTrackingInfoSubmit(String registNo, String  injuredPeopleId,String injuredPeopleName, 
			String  gender, String age, String industry, String insuranceTypeCode, 
			String injurySite, String  injuryDesc, String  isOwnMedical, String  hospital) throws SOAPException{
		boolean flag = false;
		try {
			if(isEmpty(registNo) || isEmpty(injuredPeopleId)){
				throw new Exception("参数列表不能为空。。。");
			}
			BLPrpLpersonTraceFacade blPrpLpersonTraceFacade = new BLPrpLpersonTraceFacade();
			BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade	();
			String conditions = " registNo = '" + registNo +"' and riskCode = '" + registNo.trim().substring(1, 5) + "'";
			ArrayList prpLclaimDtoList= (ArrayList)blPrpLclaimFacade.findByConditions(conditions);
			String claimNo = "";
			String policyNo = "";
			if(!isEmpty(prpLclaimDtoList)){
				PrpLclaimDto prpLclaimDto = (PrpLclaimDto)prpLclaimDtoList.get(0);
				claimNo = prpLclaimDto.getClaimNo();
				policyNo = prpLclaimDto.getPolicyNo();
			}
			int personSerialNo = Integer.parseInt(injuredPeopleId);
			UICodeAction uiCodeAction = new UICodeAction();
			PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();
			prpLpersonTraceDto.setRegistNo(registNo);
			prpLpersonTraceDto.setClaimNo(claimNo);
			prpLpersonTraceDto.setPolicyNo(policyNo);
			prpLpersonTraceDto.setPersonNo(personSerialNo);
			prpLpersonTraceDto.setPersonName(injuredPeopleName);
			prpLpersonTraceDto.setPersonSex(gender);
			prpLpersonTraceDto.setPersonAge(Integer.parseInt(age));
			prpLpersonTraceDto.setIdentifyNumber("");
			prpLpersonTraceDto.setRelatePersonNo(0);
			prpLpersonTraceDto.setJobCode("");
			prpLpersonTraceDto.setJobName(industry);
			prpLpersonTraceDto.setReferKind(insuranceTypeCode);
			prpLpersonTraceDto.setPartDesc(injurySite);
			prpLpersonTraceDto.setHospital(hospital);
			prpLpersonTraceDto.setMotionFlag(isOwnMedical);
			prpLpersonTraceDto.setWoundRemark(injuryDesc);
			prpLpersonTraceDto.setFlag("");
			prpLpersonTraceDto.setRemark("");
			blPrpLpersonTraceFacade.delete(registNo, personSerialNo);
			blPrpLpersonTraceFacade.insert(prpLpersonTraceDto);
			flag = true;
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		}
		return flag;
		
	}
	
	private boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	private boolean isEmpty(Collection<?> collection) {
		if (collection != null && collection.size() > 0) {
			return false;
		}
		return true;
	}
	
	/**
	 * 获取用户登录信息
	 */
	public GisUserCompanyInfo getUserInfo(String userCode, String userPwd) throws SOAPException, Exception {

		String strComCode = "";
		String strPassWord = "";
		String strPrpDuserCon = "";
		String strPrpDcompanyCon = "";
		GisUserCompanyInfo gisUserCompanyInfo = new GisUserCompanyInfo();
		PrpDcompanyDto prpDcompanyDto = null;
		DBManager dbManager = new DBManager();

		try {
			if (isEmpty(userCode) || isEmpty(userPwd)) {
				throw new Exception("参数列表不能为空。。。");
			}
			strPassWord = EncryptUtils.md5(userPwd).toUpperCase();
			strPrpDuserCon = "SELECT USERCODE,USERNAME,USERENAME,PASSWORD,SEAL,"
					+ "PASSWORDSETDATE,PASSWORDEXPIREDATE,COMCODE,MAKECOM,ACCOUNTCODE,"
					+ "PHONE,MOBILE,ADDRESS,POSTCODE,EMAIL,USERFLAG,LOGINSYSTEM,"
					+ "NEWUSERCODE,VALIDSTATUS,ARTICLECODE,FLAG FROM PRPDUSER WHERE "
					+ "USERCODE = '" + userCode + "' AND PASSWORD = '" + strPassWord
					+ "' AND VALIDSTATUS = '1'";

			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			ResultSet resultSet = dbManager.executeQuery(strPrpDuserCon);
			while (resultSet.next()) {
				gisUserCompanyInfo.setUserCode(dbManager.getString(resultSet, 1));
				gisUserCompanyInfo.setUserName(dbManager.getString(resultSet, 2));
				gisUserCompanyInfo.setUserEName(dbManager.getString(resultSet, 3));
				gisUserCompanyInfo.setPassword(dbManager.getString(resultSet, 4));
				gisUserCompanyInfo.setSeal(dbManager.getString(resultSet, 5));
				gisUserCompanyInfo.setPasswordSetDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 6));
				gisUserCompanyInfo.setPasswordExpireDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));
				gisUserCompanyInfo.setUser_ComCode(dbManager.getString(resultSet, 8));
				gisUserCompanyInfo.setMakeCom(dbManager.getString(resultSet, 9));
				gisUserCompanyInfo.setAccountCode(dbManager.getString(resultSet, 10));
				gisUserCompanyInfo.setPhone(dbManager.getString(resultSet, 11));
				gisUserCompanyInfo.setMobile(dbManager.getString(resultSet, 12));
				gisUserCompanyInfo.setAddress(dbManager.getString(resultSet, 13));
				gisUserCompanyInfo.setUser_PostCode(dbManager.getString(resultSet, 14));
				gisUserCompanyInfo.setEmail(dbManager.getString(resultSet, 15));
				gisUserCompanyInfo.setUserFlag(dbManager.getString(resultSet, 16));
				gisUserCompanyInfo.setLoginSystem(dbManager.getString(resultSet, 17));
				gisUserCompanyInfo.setNewUserCode(dbManager.getString(resultSet, 18));
				gisUserCompanyInfo.setUser_ValidStatus(dbManager.getString(resultSet, 19));
				gisUserCompanyInfo.setUser_ArticleCode(dbManager.getString(resultSet, 20));
				gisUserCompanyInfo.setUser_Flag(dbManager.getString(resultSet, 21));
			}
			strComCode = gisUserCompanyInfo.getUser_ComCode();
			if (strComCode != null && !"".equals(strComCode)) {
				strPrpDcompanyCon = " SELECT COMCODE,COMCNAME,COMENAME,ADDRESSCNAME,"
						+ "ADDRESSENAME,POSTCODE,PHONENUMBER,TAXNUMBER,FAXNUMBER,"
						+ "UPPERCOMCODE,INSURERNAME,COMATTRIBUTE,COMTYPE,COMLEVEL,"
						+ "MANAGER,ACCOUNTLEADER,CASHIER,ACCOUNTANT,REMARK,NEWCOMCODE,"
						+ "VALIDSTATUS,ACNTUNIT,ARTICLECODE,ACCCODE,CENTERFLAG,"
						+ "OUTERPAYCODE,INNERPAYCODE,FLAG,WEBADDRESS,SERVICEPHONE,"
						+ "REPORTPHONE,AGENTCODE,AGREEMENTNO,COMPANYFLAG,SHORTCOMCNAME,"
						+ "SERVICEFLAG,DAAPLATFORMCOMCODE FROM PRPDCOMPANY WHERE " 
						+ "COMCODE = '" + strComCode + "'";

				resultSet = dbManager.executeQuery(strPrpDcompanyCon);
				while (resultSet.next()) {
					gisUserCompanyInfo.setComCode(dbManager.getString(resultSet, 1));
					gisUserCompanyInfo.setComCName(dbManager.getString(resultSet, 2));
					gisUserCompanyInfo.setComEName(dbManager.getString(resultSet, 3));
					gisUserCompanyInfo.setAddressCName(dbManager.getString(resultSet, 4));
					gisUserCompanyInfo.setAddressEName(dbManager.getString(resultSet, 5));
					gisUserCompanyInfo.setPostCode(dbManager.getString(resultSet, 6));
					gisUserCompanyInfo.setPhoneNumber(dbManager.getString(resultSet, 7));
					gisUserCompanyInfo.setTaxNumber(dbManager.getString(resultSet, 8));
					gisUserCompanyInfo.setFaxNumber(dbManager.getString(resultSet, 9));
					gisUserCompanyInfo.setUpperComCode(dbManager.getString(resultSet, 10));
					gisUserCompanyInfo.setInsurerName(dbManager.getString(resultSet, 11));
					gisUserCompanyInfo.setComAttribute(dbManager.getString(resultSet, 12));
					gisUserCompanyInfo.setComType(dbManager.getString(resultSet, 13));
					gisUserCompanyInfo.setComLevel(dbManager.getString(resultSet, 14));
					gisUserCompanyInfo.setManager(dbManager.getString(resultSet, 15));
					gisUserCompanyInfo.setAccountLeader(dbManager.getString(resultSet, 16));
					gisUserCompanyInfo.setCashier(dbManager.getString(resultSet, 17));
					gisUserCompanyInfo.setAccountant(dbManager.getString(resultSet, 18));
					gisUserCompanyInfo.setRemark(dbManager.getString(resultSet, 19));
					gisUserCompanyInfo.setNewComCode(dbManager.getString(resultSet, 20));
					gisUserCompanyInfo.setValidStatus(dbManager.getString(resultSet, 21));
					gisUserCompanyInfo.setAcntUnit(dbManager.getString(resultSet, 22));
					gisUserCompanyInfo.setArticleCode(dbManager.getString(resultSet, 23));
					gisUserCompanyInfo.setAccCode(dbManager.getString(resultSet, 24));
					gisUserCompanyInfo.setCenterFlag(dbManager.getString(resultSet, 25));
					gisUserCompanyInfo.setOuterPayCode(dbManager.getString(resultSet, 26));
					gisUserCompanyInfo.setInnerPayCode(dbManager.getString(resultSet, 27));
					gisUserCompanyInfo.setFlag(dbManager.getString(resultSet, 28));
					gisUserCompanyInfo.setWebAddress(dbManager.getString(resultSet, 29));
					gisUserCompanyInfo.setServicePhone(dbManager.getString(resultSet, 30));
					gisUserCompanyInfo.setReportPhone(dbManager.getString(resultSet, 31));
					gisUserCompanyInfo.setAgentCode(dbManager.getString(resultSet, 32));
					gisUserCompanyInfo.setAgreementNo(dbManager.getString(resultSet, 33));
					gisUserCompanyInfo.setCompanyFlag(dbManager.getString(resultSet, 34));
					gisUserCompanyInfo.setShortComCName(dbManager.getString(resultSet, 35));
					gisUserCompanyInfo.setServiceFlag(dbManager.getString(resultSet, 36));
					gisUserCompanyInfo.setDaaplatformComCode(dbManager.getString(resultSet, 37));
				}
				gisUserCompanyInfo.setWebTime(new Date());
			}
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisUserCompanyInfo;
	}

	/**
	 * 获取用户信息
	 */
	public GisUserInfo[] getUserList(String userCode, int startNum, int endNum) throws SOAPException,
			Exception {

		int count = 0;
		String strPrpDuserCon = "";
		GisUserInfo gisUserInfo = null;
		GisUserInfo[] gisUserInfoList = null;
		DBManager dbManager = new DBManager();

		strPrpDuserCon = "SELECT USERCODE,USERNAME,USERENAME,PASSWORD,SEAL,"
				+ "PASSWORDSETDATE,PASSWORDEXPIREDATE,COMCODE,MAKECOM,ACCOUNTCODE,"
				+ "PHONE,MOBILE,ADDRESS,POSTCODE,EMAIL,USERFLAG,LOGINSYSTEM,"
				+ "NEWUSERCODE,VALIDSTATUS,ARTICLECODE,FLAG FROM PRPDUSER WHERE ";
		if (isEmpty(userCode)) {
			// 返回用户表所有用户信息
			strPrpDuserCon += " VALIDSTATUS = '1' ORDER BY USERCODE ";
		} else {
			strPrpDuserCon += " USERCODE = '" + userCode
					+ "' AND VALIDSTATUS = '1' ORDER BY USERCODE ";
		}

		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			ResultSet resultSet = dbManager.executeQuery(strPrpDuserCon);
			if(isEmpty(userCode)){
				gisUserInfoList = new GisUserInfo[endNum - startNum + 1];
			} else {
				gisUserInfoList = new GisUserInfo[1];
			}
			if (isEmpty(userCode) && startNum > 1) {
				dbManager.locate(resultSet, startNum - 1);
			}
			while (resultSet.next()) {
				if ((count > endNum - startNum) && isEmpty(userCode)) {
					break;
				}
				gisUserInfo = new GisUserInfo();
				gisUserInfo.setUserCode(dbManager.getString(resultSet, 1));
				gisUserInfo.setUserName(dbManager.getString(resultSet, 2));
				gisUserInfo.setUserEName(dbManager.getString(resultSet, 3));
				gisUserInfo.setPassword(dbManager.getString(resultSet, 4));
				gisUserInfo.setSeal(dbManager.getString(resultSet, 5));
				gisUserInfo.setPasswordSetDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 6));
				gisUserInfo.setPasswordExpireDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));
				gisUserInfo.setComCode(dbManager.getString(resultSet, 8));
				gisUserInfo.setMakeCom(dbManager.getString(resultSet, 9));
				gisUserInfo.setAccountCode(dbManager.getString(resultSet, 10));
				gisUserInfo.setPhone(dbManager.getString(resultSet, 11));
				gisUserInfo.setMobile(dbManager.getString(resultSet, 12));
				gisUserInfo.setAddress(dbManager.getString(resultSet, 13));
				gisUserInfo.setPostCode(dbManager.getString(resultSet, 14));
				gisUserInfo.setEmail(dbManager.getString(resultSet, 15));
				gisUserInfo.setUserFlag(dbManager.getString(resultSet, 16));
				gisUserInfo.setLoginSystem(dbManager.getString(resultSet, 17));
				gisUserInfo.setNewUserCode(dbManager.getString(resultSet, 18));
				gisUserInfo.setValidStatus(dbManager.getString(resultSet, 19));
				gisUserInfo.setArticleCode(dbManager.getString(resultSet, 20));
				gisUserInfo.setFlag(dbManager.getString(resultSet, 21));
				gisUserInfoList[count] = gisUserInfo;
				count++;
			}
			//dataSet.setGisUserInfoList(gisUserInfoList);
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisUserInfoList;
	}
	
	/**
	 * 获取保单详细信息
	 */
	public GisPolicyInfo getPolicyInfoByPolicyNo(String policyNo) throws SOAPException, Exception {

		String strPrpCmainCon = "";
		DBPrpDcode dbPrpDcode = null;
		DBPrpDrisk dbPrpDrisk = null;
		DBPrpDuser dbPrpDuser = null;
		DBPrpDcompany dbPrpDcompany = null;
		DBManager dbManager = new DBManager();
		PrpCmainDto prpCmainDto = new PrpCmainDto();
		GisPolicyInfo gisPolicyInfo = new GisPolicyInfo();
		BLPrpCmainAction blPrpCmainAction = new BLPrpCmainAction();

		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbPrpDcode = new DBPrpDcode(dbManager);
			dbPrpDrisk = new DBPrpDrisk(dbManager);
			dbPrpDuser = new DBPrpDuser(dbManager);
			dbPrpDcompany = new DBPrpDcompany(dbManager);
			strPrpCmainCon = " POLICYNO = '" + policyNo + "'";
			prpCmainDto = blPrpCmainAction.findByPrimaryKey(dbManager, policyNo);
			if (prpCmainDto != null) {
				gisPolicyInfo.setProposalNo(prpCmainDto.getProposalNo());
				gisPolicyInfo.setPolicyNo(prpCmainDto.getPolicyNo());
				gisPolicyInfo.setRiskCode(prpCmainDto.getRiskCode());
				gisPolicyInfo
						.setRiskName(dbPrpDrisk.translateCode(prpCmainDto.getRiskCode(), true));
				gisPolicyInfo.setAppliCode(prpCmainDto.getAppliCode());
				gisPolicyInfo.setAppliName(prpCmainDto.getAppliName());
				gisPolicyInfo.setAppliAddress(prpCmainDto.getAppliAddress());
				gisPolicyInfo.setInsuredCode(prpCmainDto.getInsuredCode());
				gisPolicyInfo.setInsuredName(prpCmainDto.getInsuredName());
				gisPolicyInfo.setBusinessType1Name(dbPrpDcode.translateCode("BusinessType1",
						prpCmainDto.getBusinessType1(), true));
				gisPolicyInfo.setOperateDate(prpCmainDto.getOperateDate());
				gisPolicyInfo.setStartDate(prpCmainDto.getStartDate());
				gisPolicyInfo.setEndDate(prpCmainDto.getEndDate());
				gisPolicyInfo.setEndHour(prpCmainDto.getEndHour());
				gisPolicyInfo.setPureRate(prpCmainDto.getPureRate());
				gisPolicyInfo.setDisRate(prpCmainDto.getDisRate());
				gisPolicyInfo.setDisCount(prpCmainDto.getDiscount());
				gisPolicyInfo.setCurrency(prpCmainDto.getCurrency());
				gisPolicyInfo.setSumValue(prpCmainDto.getSumValue());
				gisPolicyInfo.setSumDiscount(prpCmainDto.getSumDiscount());
				gisPolicyInfo.setSumAmount(prpCmainDto.getSumAmount());
				gisPolicyInfo.setSumPremium(prpCmainDto.getSumPremium());
				gisPolicyInfo.setSumSubPrem(prpCmainDto.getSumSubPrem());
				gisPolicyInfo.setSumQuantity(prpCmainDto.getSumQuantity());
				gisPolicyInfo.setEndorseTimes(prpCmainDto.getEndorseTimes());
				gisPolicyInfo.setClaimTimes(prpCmainDto.getClaimTimes());
				gisPolicyInfo.setMakeComName(dbPrpDcompany.translateCode(prpCmainDto.getMakeCom(),
						true));
				gisPolicyInfo.setComName(dbPrpDcompany
						.translateCode(prpCmainDto.getComCode(), true));
				gisPolicyInfo.setUnderWriteCode(prpCmainDto.getUnderWriteCode());
				gisPolicyInfo.setUnderWriteName(prpCmainDto.getUnderWriteName());
				gisPolicyInfo.setOperatorCode(prpCmainDto.getOperatorCode());
				gisPolicyInfo.setOperatorName(dbPrpDuser.translateCode(prpCmainDto
						.getOperatorCode(), true));
				gisPolicyInfo.setInputDate(prpCmainDto.getInputDate());
				gisPolicyInfo.setInputHour(prpCmainDto.getInputHour());
				gisPolicyInfo.setUnderWriteEndDate(prpCmainDto.getUnderWriteEndDate());
				//dataSet.setGisPolicyInfo(gisPolicyInfo);
			} else {
				throw new Exception("无此保单号信息。。。");
			}
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisPolicyInfo;
	}
	
	/**
	 * 获取报案信息
	 */
	public GisRegistInfo[] getRegistInfo(String whereSql, int startNum, int endNum) throws SOAPException,
			Exception {
		
		int count = 0;
		String strContidions = "";
		DBPrpDrisk dbPrpDrisk = null;
		DBManager dbManager = new DBManager();
		GisRegistInfo[] gisRegistInfoList = null;
		
		strContidions = "SELECT T.REGISTNO,T.POLICYNO,T.RISKCODE,T.COMCODE,T.DAMAGECODE," +
				"T.DAMAGENAME,T.DAMAGESTARTDATE,T.REPORTDATE FROM (SELECT R.REGISTNO," +
				"R.POLICYNO,R.RISKCODE,R.COMCODE,R.DAMAGECODE,R.DAMAGENAME," +
				"R.DAMAGESTARTDATE,R.REPORTDATE,C.STARTDATE,C.BUSINESSPROVINCE," +
				"C.BUSINESSTOWN,C.BUSINESSCOUNTY,C.BUSINESSAREANAME,R.CLASSCODE," +
				"R.INPUTDATE,R.INSUREDNAME FROM PRPLREGIST R, PRPCMAIN C WHERE " +
				"R.POLICYNO = C.POLICYNO) T ";
		if(!isEmpty(whereSql)){
			strContidions += " WHERE " + whereSql ;
		}
		
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			dbPrpDrisk = new DBPrpDrisk(dbManager);
			ResultSet resultSet = dbManager.executeQuery(strContidions);
			gisRegistInfoList = new GisRegistInfo[endNum - startNum + 1];
			if (startNum > 1) {
				dbManager.locate(resultSet, startNum - 1);
			}
			while (resultSet.next()) {
				if ((count > endNum - startNum)) {
					break;
				}
				GisRegistInfo gisRegistInfo = new GisRegistInfo();
				gisRegistInfo.setRegistNo(dbManager.getString(resultSet, 1));
				gisRegistInfo.setPolicyNo(dbManager.getString(resultSet, 2));
				gisRegistInfo.setRiskCode(dbManager.getString(resultSet, 3));
				gisRegistInfo.setComCode(dbManager.getString(resultSet, 4));
				gisRegistInfo.setDamageCode(dbManager.getString(resultSet, 5));
				gisRegistInfo.setDamageName(dbManager.getString(resultSet, 6));
				gisRegistInfo.setDamageStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));
				gisRegistInfo.setReportDate(dbManager.getDateTime(resultSet, DateTime.YEAR_TO_DAY,
						8));
				gisRegistInfoList[count] = gisRegistInfo;
				count++;
			}
			for(int i = 0; i < gisRegistInfoList.length; i++){
				gisRegistInfoList[i].setRiskName(dbPrpDrisk.translateCode(gisRegistInfoList[i].getRiskCode(), true));
			}
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisRegistInfoList;
	}

	/**
	 * 获取报案详细信息
	 */
	public GisRegistDetailInfo getRegistDetailInfo(String registNo) throws SOAPException, Exception {

		String strContidions = "";
		DBManager dbManager = new DBManager();
		GisRegistDetailInfo gisRegistDetailInfo = null;

		strContidions = " SELECT M.POLICYNO,M.RISKCODE,M.BUSINESSPROVINCE,M.BUSINESSTOWN,"
				+ "M.BUSINESSCOUNTY,M.BUSINESSAREANAME,M.STARTDATE,R.LFLAG,R.LANGUAGE,"
				+ "R.INSUREDCODE,R.INSUREDNAME,R.REPORTDATE,R.REPORTHOUR,R.REPORTORNAME,"
				+ "R.REPORTTYPE,R.PHONENUMBER,R.LINKERNAME,R.REGISTNO,R.DAMAGESTARTDATE,"
				+ "R.DAMAGESTARTHOUR,R.DAMAGEENDDATE,R.DAMAGEENDHOUR,R.DAMAGECODE,R.DAMAGENAME,"
				+ "R.ADDRESSCODE,R.DAMAGEADDRESS,R.LOSSNAME,R.LOSSQUANTITY,R.ESTICURRENCY,"
				+ "R.ESTIMATELOSS,R.RECEIVERNAME,R.HANDLER1CODE,R.COMCODE,R.INPUTDATE,"
				+ "R.ACCEPTFLAG,R.REPEATINSUREFLAG,R.CANCELDATE,R.DEALERCODE,R.OPERATORCODE,"
				+ "R.MAKECOM,R.LOSSESNUMBER,R.LOSSESUNITCODE,R.BUSINESSTYPE,R.BUSINESSTYPE1,"
				+ "R.BUSINESSFLAG,R.OTHERFLAG FROM PRPCMAIN M,PRPLREGIST R WHERE "
				+ "M.POLICYNO = R.POLICYNO AND R.REGISTNO = '" + registNo + "'";
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			ResultSet resultSet = dbManager.executeQuery(strContidions);
			while (resultSet.next()) {
				gisRegistDetailInfo = new GisRegistDetailInfo();
				gisRegistDetailInfo.setPolicyNo(dbManager.getString(resultSet, 1));
				gisRegistDetailInfo.setRiskCode(dbManager.getString(resultSet, 2));
				gisRegistDetailInfo.setBusinessProvince(dbManager.getString(resultSet, 3));
				gisRegistDetailInfo.setBusinessTown(dbManager.getString(resultSet, 4));
				gisRegistDetailInfo.setBusinessCountry(dbManager.getString(resultSet, 5));
				gisRegistDetailInfo.setBusinessAreaName(dbManager.getString(resultSet, 6));
				gisRegistDetailInfo.setStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 7));

				gisRegistDetailInfo.setLFlag(dbManager.getString(resultSet, 8));
				gisRegistDetailInfo.setLanguage(dbManager.getString(resultSet, 9));
				gisRegistDetailInfo.setInsuredCode(dbManager.getString(resultSet, 10));
				gisRegistDetailInfo.setInsuredName(dbManager.getString(resultSet, 11));
				gisRegistDetailInfo.setReportDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 12));
				gisRegistDetailInfo.setReportHour(dbManager.getString(resultSet, 13));
				gisRegistDetailInfo.setReportorName(dbManager.getString(resultSet, 14));
				gisRegistDetailInfo.setReportType(dbManager.getString(resultSet, 15));
				gisRegistDetailInfo.setPhoneNumber(dbManager.getString(resultSet, 16));
				gisRegistDetailInfo.setLinkerName(dbManager.getString(resultSet, 17));
				gisRegistDetailInfo.setRegistNo(dbManager.getString(resultSet, 18));

				gisRegistDetailInfo.setDamageStartDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 19));
				gisRegistDetailInfo.setDamageStartHour(dbManager.getString(resultSet, 20));
				gisRegistDetailInfo.setDamageEndDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 21));
				gisRegistDetailInfo.setDamageEndHour(dbManager.getString(resultSet, 22));
				gisRegistDetailInfo.setDamageCode(dbManager.getString(resultSet, 23));
				gisRegistDetailInfo.setDamageName(dbManager.getString(resultSet, 24));
				gisRegistDetailInfo.setAddressCode(dbManager.getString(resultSet, 25));
				gisRegistDetailInfo.setDamageAddress(dbManager.getString(resultSet, 26));

				gisRegistDetailInfo.setLossName(dbManager.getString(resultSet, 27));
				gisRegistDetailInfo.setLossQuantity(dbManager.getString(resultSet, 28));
				gisRegistDetailInfo.setEstiCurrency(dbManager.getString(resultSet, 29));
				gisRegistDetailInfo.setEstimateLoss(dbManager.getString(resultSet, 30));

				gisRegistDetailInfo.setReceiverName(dbManager.getString(resultSet, 31));
				gisRegistDetailInfo.setHandler1Code(dbManager.getString(resultSet, 32));
				gisRegistDetailInfo.setComCode(dbManager.getString(resultSet, 33));
				gisRegistDetailInfo.setInputDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 34));
				gisRegistDetailInfo.setAcceptFlag(dbManager.getString(resultSet, 35));
				gisRegistDetailInfo.setRepeatInsureFlag(dbManager.getString(resultSet, 36));
				gisRegistDetailInfo.setCancelDate(dbManager.getDateTime(resultSet,
						DateTime.YEAR_TO_DAY, 37));
				gisRegistDetailInfo.setDealerCode(dbManager.getString(resultSet, 38));
				gisRegistDetailInfo.setOperatorCode(dbManager.getString(resultSet, 39));
				gisRegistDetailInfo.setMakeCom(dbManager.getString(resultSet, 40));
				gisRegistDetailInfo.setLossesNumber(dbManager.getString(resultSet, 41));
				gisRegistDetailInfo.setLossesUnitCode(dbManager.getString(resultSet, 42));
				gisRegistDetailInfo.setBusinessType(dbManager.getString(resultSet, 43));
				gisRegistDetailInfo.setBusinessType1(dbManager.getString(resultSet, 44));
				gisRegistDetailInfo.setBusinessFlag(dbManager.getString(resultSet, 45));
				gisRegistDetailInfo.setOtherFlag(dbManager.getString(resultSet, 46));
				//dataSet.setGisRegistDetailInfo(gisRegistDetailInfo);
			}
			resultSet.close();
		} catch (Exception e) {
			throw new SOAPException(e.getMessage());
		} finally {
			dbManager.close();
		}
		return gisRegistDetailInfo;
	}
}

