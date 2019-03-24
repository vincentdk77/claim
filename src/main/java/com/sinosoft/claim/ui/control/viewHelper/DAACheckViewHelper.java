package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.claim.bl.facade.BLPrpLRegistRPolicyFacade;
import com.sinosoft.claim.bl.facade.BLPrplcompensatehouseFacade;
import com.sinosoft.claim.dto.custom.AcciCheckDto;
import com.sinosoft.claim.dto.custom.CheckDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistClaimInfoDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.ScheduleDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCinsuredDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpLAcciCheckChargeDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckDto;
import com.sinosoft.claim.dto.domain.PrpLacciCheckTextDto;
import com.sinosoft.claim.dto.domain.PrpLcheckDto;
import com.sinosoft.claim.dto.domain.PrpLcheckExtDto;
import com.sinosoft.claim.dto.domain.PrpLcheckItemDto;
import com.sinosoft.claim.dto.domain.PrpLcheckLossDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIAcciCheckAction;
import com.sinosoft.claim.ui.control.action.UICheckAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIScheduleAction;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * <p>
 * Title: CheckViewHelper
 * </p>
 * <p>
 * Description:查勘ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 liubvo
 * @version 1.0 <br>
 */

public class DAACheckViewHelper extends CheckViewHelper {
	
	private static Log logger = LogFactory.getLog(DAACheckViewHelper.class);
	/**
	 * 默认构造方法
	 */
	public DAACheckViewHelper() {
	}
	
	/**
	 * 保存查勘时查勘页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return checkDto 查勘数据传输数据结构
	 * @throws Exception
	 */
	public CheckDto viewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		//继承对check,checkText表的赋值
		CheckDto checkDto = super.viewToDto(httpServletRequest);
		//Modify by chenrenda add begin 20050418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		ArrayList prpLcheckLossDtoList = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = null;
		int intCheckLossIndex = 1;//序号
		String prpLcheckLossRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLcheckLossPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo");
		String prpLcheckLossClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLcheckLossRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		//Modify by chenrenda add end 20050418
		
		//add by lixiang start at 2005-12-28
		//reason: 因为考虑到录入的时候，可能没有立案，但是在提交的时候，做了立案，导致立案号没写入。
		//先取立案号码，很重要，不要从页面上取得。。。
		String claimNo=prpLcheckLossClaimNo;
		if (claimNo==null||claimNo.length()<2){
			UICodeAction uiCodeAction = new UICodeAction();
			claimNo=uiCodeAction.translateBusinessCode(prpLcheckLossRegistNo ,true);
		}
		
		//add by lixiang end at 2005-12-28
		
		/*---------------------三者车辆prpLthirdParty------------------------------------*/
		ArrayList thirdPartyDtoList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = null;
		//从界面得到输入数组
		String prpLthirdPartyClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLthirdPartyRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String prpLthirdPartyRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLthirdPartyClauseType = httpServletRequest
		.getParameter("prpLcheckClauseType");
		String[] prpLthirdPartySerialNo = httpServletRequest
		.getParameterValues("prpLthirdPartySerialNo");
		String[] prpLthirdPartyLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdPartyLicenseNo");
		String[] prpLthirdPartyLicenseColorCode = httpServletRequest
		.getParameterValues("licenseColorCode");
		String[] prpLthirdPartyCarKindCode = httpServletRequest
		.getParameterValues("carKindCode");
		String[] prpLthirdPartyInsureCarFlag = httpServletRequest
		.getParameterValues("insureCarFlag");
		String[] prpLthirdPartyCarOwner = httpServletRequest
		.getParameterValues("prpLthirdPartyCarOwner");
		String[] prpLthirdPartyEngineNo = httpServletRequest
		.getParameterValues("prpLthirdPartyEngineNo");
		String[] prpLthirdPartyFrameNo = httpServletRequest
		.getParameterValues("prpLthirdPartyFrameNo");
		String[] prpLthirdPartyModelCode = httpServletRequest
		.getParameterValues("prpLthirdPartyModelCode");
		String[] prpLthirdPartyBrandName = httpServletRequest
		.getParameterValues("prpLthirdPartyBrandName");
		String[] prpLthirdPartyRunDistance = httpServletRequest
		.getParameterValues("prpLthirdPartyRunDistance");
		String[] prpLthirdPartyUseYears = httpServletRequest
		.getParameterValues("prpLthirdPartyUseYears");
		String[] prpLthirdPartyDutyPercent = httpServletRequest
		.getParameterValues("prpLthirdPartyDutyPercent");
		String[] prpLthirdPartyInsuredFlag = httpServletRequest
		.getParameterValues("insuredFlag");
		String[] prpLthirdPartyInsureComCode = httpServletRequest
		.getParameterValues("prpLthirdPartyInsureComCode");
		String[] prpLthirdPartyInsureComName = httpServletRequest
		.getParameterValues("prpLthirdPartyInsureComName");
		String[] prpLthirdPartyFlag = httpServletRequest
		.getParameterValues("prpLthirdPartyFlag");
		String[] prpLthirdPartyVINNo = httpServletRequest
		.getParameterValues("prpLthirdPartyVINNo");
		String[] prpLthirdPartyLossFlag = httpServletRequest
		.getParameterValues("prpLthirdPartyLossFlag");
		String[] prpLthirdPartyDriveName = httpServletRequest
		.getParameterValues("prpLthirdPartyDriveName");
		String[] prpLthirdPartyDriveLicensNo = httpServletRequest
		.getParameterValues("prpLthirdPartyDriveLicensNo");
		String[] prpLthirdPartyCarPolicyNo = httpServletRequest
		.getParameterValues("prpLthirdPartyCarPolicyNo");
		
		//Modify by chenrenda add begin 20050418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		String[] prpLthirdPartyKindCode = httpServletRequest
		.getParameterValues("prpLthirdPartyKindCode");
		String[] prpLthirdPartyLossFee = httpServletRequest
		.getParameterValues("prpLthirdPartyLossFee");
		
		//Modify by chenrenda add end 20050418
		   //add by liyanjie 2005-12-18 start 界面上车辆对应的是否为新增车辆的标志
		  String[] prpLthirdPartyNewAddFlag       = httpServletRequest.getParameterValues("prpLthirdPartyNewAddFlag");
		  //add by liyanjie 2005-12-18 end  界面上车辆对应的是否为新增车辆的标志
		
		//调度标底用的
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = new PrpLscheduleItemDto();
		//对象赋值
		if (prpLthirdPartySerialNo == null
				|| prpLthirdPartyLicenseColorCode == null) {
		} else {
			//三者车辆部分开始
			for (int index = 1; index < prpLthirdPartySerialNo.length; index++) {
				prpLthirdPartyDto = new PrpLthirdPartyDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:预估损失模块合到涉案车辆信息中
				prpLcheckLossDto = new PrpLcheckLossDto();
				prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				prpLcheckLossDto.setClaimNo(claimNo);
				prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setReferSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartySerialNo[index])));
				//modify by wuxiaodong 050906 begain reasion
				// 车险查堪时要求提供多险别的输入，为此将险别存入到carloss里，但由于checkloss表kindcode字段不允许为空，所以此填入一个师直为默认值
				//prpLcheckLossDto.setKindCode(prpLthirdPartyKindCode[index]);
				prpLcheckLossDto.setKindCode("A");
				//modify by wuxiaodong 050906 end
				prpLcheckLossDto.setLossFeeType("1");
				prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPartyLossFee[index])));
				prpLcheckLossDto.setFlag("");
				intCheckLossIndex++;
				prpLcheckLossDtoList.add(prpLcheckLossDto);
				//Modify by chenrenda update end 20050418
				
				prpLthirdPartyDto.setRegistNo(prpLthirdPartyRegistNo);
				prpLthirdPartyDto.setRiskCode(prpLthirdPartyRiskCode);
				prpLthirdPartyDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartySerialNo[index])));
				prpLthirdPartyDto.setClaimNo(claimNo);
				prpLthirdPartyDto.setClauseType(prpLthirdPartyClauseType);
				prpLthirdPartyDto.setLicenseNo(prpLthirdPartyLicenseNo[index]);
				prpLthirdPartyDto
				.setLicenseColorCode(prpLthirdPartyLicenseColorCode[index]);
				prpLthirdPartyDto
				.setCarKindCode(prpLthirdPartyCarKindCode[index]);
				prpLthirdPartyDto
				.setInsureCarFlag(prpLthirdPartyInsureCarFlag[index]);
				prpLthirdPartyDto.setEngineNo(prpLthirdPartyEngineNo[index]);
				prpLthirdPartyDto.setFrameNo(prpLthirdPartyFrameNo[index]);
				prpLthirdPartyDto.setBrandName(prpLthirdPartyBrandName[index]);
				prpLthirdPartyDto.setModelCode(prpLthirdPartyModelCode[index]);
				
				
				prpLthirdPartyDto.setRunDistance(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPartyRunDistance[index])));
				prpLthirdPartyDto.setUseYears(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartyUseYears[index])));
				prpLthirdPartyDto.setDutyPercent(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPartyDutyPercent[index])));
				prpLthirdPartyDto
				.setInsuredFlag(prpLthirdPartyInsuredFlag[index]);
				prpLthirdPartyDto
				.setInsureComCode(prpLthirdPartyInsureComCode[index]);
				prpLthirdPartyDto
				.setInsureComName(prpLthirdPartyInsureComName[index]);
				prpLthirdPartyDto.setVINNo(prpLthirdPartyVINNo[index]);
				prpLthirdPartyDto.setLossFlag(prpLthirdPartyLossFlag[index]);
				//三者车驾驶员名称，身份证号码
				prpLthirdPartyDto.setPrpLthirdPartyDriveName(prpLthirdPartyDriveName[index-1]);
				prpLthirdPartyDto.setPrpLthirdPartyDriveLicensNo(prpLthirdPartyDriveLicensNo[index-1]);
				//三者车辆保单号码
				prpLthirdPartyDto.setCarPolicyNo(prpLthirdPartyCarPolicyNo[index]);
				//加入集合
				thirdPartyDtoList.add(prpLthirdPartyDto);
				 //整理调度情况
		        
		        prpLscheduleItemDto = new PrpLscheduleItemDto();
		        prpLscheduleItemDto.setScheduleID         (1);
		        prpLscheduleItemDto.setRegistNo           (prpLthirdPartyRegistNo);
		        prpLscheduleItemDto.setItemNo             (prpLthirdPartyDto.getSerialNo());
		        prpLscheduleItemDto.setInsureCarFlag      (prpLthirdPartyDto.getInsureCarFlag() );
		        
		        //modify by liyanjie 2005-12-18 start 如果是双代案件,查勘加了三者车,新增的定损任务给出险地(claimcomcode=查勘调度的claimcomcode);
		        //System.out.println("------ 增加定损 ---commiFlag:"+commiFlag);
		        //BLPrpLscheduleMainWFFacade blPrpLscheduleMainWF = new BLPrpLscheduleMainWFFacade();
		    	//PrpLscheduleMainWFDto prpLscheduleMainWFDto = blPrpLscheduleMainWF.findByPrimaryKey(1,prpLthirdPartyRegistNo);
		        //if( (!(commiFlag == null )) && "1".equals(commiFlag)){
		        //	prpLscheduleItemDto.setCommiItemFlag(commiFlag);
		        //}
		        //if(!(prpLscheduleMainWFDto==null)){
		        //prpLscheduleItemDto.setClaimComCode(prpLscheduleMainWFDto.getClaimComCode()); //新增的车辆定损任务给出险地调度中心,即与查勘调度是同一个调度中心
		     		//}else{ 
		     		//prpLscheduleItemDto.setClaimComCode("");  //万一取数据失败,先用这个充下数吧,不过一般是不可能的
		     		//}
		        System.out.println("------ 增加定损 ---ClaimComCode:"+prpLscheduleItemDto.getClaimComCode());
		        //modify by liyanjie 2005-12-17 end
		        
		        //表示是否选中
		        prpLscheduleItemDto.setSelectSend         ("1");
		        //表示没有调度成定损过
		        prpLscheduleItemDto.setSurveyTimes        (0);
		        prpLscheduleItemDto.setSurveyType         ("1");
		        prpLscheduleItemDto.setCheckSite          (checkDto.getPrpLcheckDto().getCheckSite());
		        prpLscheduleItemDto.setLicenseNo          (prpLthirdPartyDto.getLicenseNo() );
		        prpLscheduleItemDto.setScheduleObjectID   ("_");
		        prpLscheduleItemDto.setScheduleObjectName (" ");
		        prpLscheduleItemDto.setInputDate          (new DateTime(DateTime.current().toString() ,DateTime.YEAR_TO_DAY ));
		        prpLscheduleItemDto.setScheduleType       ("schel");
		        prpLscheduleItemDto.setNextNodeNo("certa");
		        
		        //if(prpLthirdPartyNewAddFlag[index].equals("new")){			//如果是新增的定损,保存  add if条件  by liyanjie
			        //加入调度标的集合
			        scheduleItemDtoList.add(prpLscheduleItemDto);
		       // }
				
			}
			
			//查勘集合中加入三者车辆
			checkDto.setPrpLthirdPartyDtoList(thirdPartyDtoList);
		}
		/*---------------------驾驶员prpLdriver------------------------------------*/
		ArrayList driverList = new ArrayList();
		PrpLdriverDto prpLdriverDto = null;
		
		//从界面得到输入数组
		String prpLdriverRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLdriverClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLdriverRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String prpLdriverPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo");
		String[] prpLdriverSerialNo = httpServletRequest
		.getParameterValues("prpLdriverSerialNo");
		/* modify by liuyanmei delete 20051116 
		 * reason : 驾驶员信息只需要姓名电话 
		 *  
		
		 String[] prpLdriverLicenseColorCode = httpServletRequest
		 .getParameterValues("prpLdriverLicenseColorCode");
		 String[] prpLdriverDrivingLicenseNo = httpServletRequest
		 .getParameterValues("prpLdriverDrivingLicenseNo");
		 */
		String[] prpLdriverDriverName = httpServletRequest
		.getParameterValues("prpLdriverDriverName");
		String[] prpLdriverDriverPhone = httpServletRequest
		.getParameterValues("prpLdriverDriverPhone");
		//add by zhaolu 20060817 start
		//reason添加驾驶员证件号 
		 String[] prpLdriverLicenseNo = httpServletRequest
		 .getParameterValues("prpLdriverDrivingLicenseNo");
		 String[] prpLdriverIdentifyType = httpServletRequest
		 .getParameterValues("identifyType");
		 String[] prpLdriverIdentifyNumber = httpServletRequest
		 .getParameterValues("prpLdriverIdentifyNumber");
		//add by zhaolu 20060817 end
		/* modify by liuyanmei delete 20051116 
		 * reason : 驾驶员信息只需要姓名电话 
		 String[] prpLdriverDriverSex = httpServletRequest
		 .getParameterValues("driverSex");
		 String[] prpLdriverDriverAge = httpServletRequest
		 .getParameterValues("prpLdriverDriverAge");
		 String[] prpLdriverDriverOccupation = httpServletRequest
		 .getParameterValues("prpLdriverDriverOccupation");
		 String[] prpLdriverEducation = httpServletRequest
		 .getParameterValues("education");
		 String[] prpLdriverUnitAddress = httpServletRequest
		 .getParameterValues("prpLdriverUnitAddress");
		 String[] prpLdriverIdentifyNumber = httpServletRequest
		 .getParameterValues("prpLdriverIdentifyNumber");
		 String[] prpLdriverDriverGrade = httpServletRequest
		 .getParameterValues("prpLdriverDriverGrade");
		 String[] prpLdriverDriverSeaRoute = httpServletRequest
		 .getParameterValues("prpLdriverDriverSeaRoute");
		 String[] prpLdriverReceiveLicenseDate = httpServletRequest
		 .getParameterValues("prpLdriverReceiveLicenseDate");
		 String[] prpLdriverDrivingCarType = httpServletRequest
		 .getParameterValues("drivingCarType");
		 String[] prpLdriverDrivingYear = httpServletRequest
		 .getParameterValues("prpLdriverDrivingYear");
		 String[] prpLdriverAwardLicenseOrgan = httpServletRequest
		 .getParameterValues("prpLdriverAwardLicenseOrgan");
		 String[] prpLdriverSpecialCertificate = httpServletRequest
		 .getParameterValues("prpLdriverSpecialCertificate");
		 String[] prpLdriverFlag = httpServletRequest
		 .getParameterValues("prpLdriverFlag");
		 // modify by liuyanmei delete 20051116  */ 
		
		//对象赋值
		//if (prpLdriverSerialNo == null || prpLdriverDriverSex == null)
		if (prpLdriverSerialNo == null ) {
		} else {
			//驾驶员部分开始
			for (int index = 1; index < prpLdriverSerialNo.length; index++) {
				prpLdriverDto = new PrpLdriverDto();
				prpLdriverDto.setRegistNo(prpLdriverRegistNo);
				prpLdriverDto.setClaimNo(claimNo);
				prpLdriverDto.setRiskCode(prpLdriverRiskCode);
				prpLdriverDto.setPolicyNo(prpLdriverPolicyNo);
				prpLdriverDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLdriverSerialNo[index])));
				prpLdriverDto.setDriverName(prpLdriverDriverName[index]);
				prpLdriverDto.setDriverSeaRoute(prpLdriverDriverPhone[index]);
				//add by zhaolu 20060817 start
				//reason添加驾驶员证件号
				prpLdriverDto.setDrivingLicenseNo(prpLdriverLicenseNo[index]);
				prpLdriverDto.setIdentifyType(prpLdriverIdentifyType[index]);
				prpLdriverDto.setIdentifyNumber(prpLdriverIdentifyNumber[index]);
				//add by zhaolu 20060817 end
				/* modify by liuyanmei delete 20051116 
				 * reason : 驾驶员信息只需要姓名电话 
				 prpLdriverDto.setLicenseNo(prpLdriverLicenseNo[index]);
				 prpLdriverDto.setLicenseColorCode(prpLdriverLicenseColorCode[index]);
				 prpLdriverDto.setDrivingLicenseNo(prpLdriverDrivingLicenseNo[index]);
				 prpLdriverDto.setDriverName(prpLdriverDriverName[index]);
				 prpLdriverDto.setDriverSex(prpLdriverDriverSex[index]);
				 prpLdriverDto.setDriverAge(Integer.parseInt(DataUtils
				 .nullToZero(prpLdriverDriverAge[index])));
				 prpLdriverDto
				 .setDriverOccupation(prpLdriverDriverOccupation[index]);
				 prpLdriverDto.setEducation(prpLdriverEducation[index]);
				 prpLdriverDto.setUnitAddress(prpLdriverUnitAddress[index]);
				 prpLdriverDto
				 .setIdentifyNumber(prpLdriverIdentifyNumber[index]);
				 prpLdriverDto.setDriverGrade(Integer.parseInt(DataUtils
				 .nullToZero(prpLdriverDriverGrade[index])));
				 prpLdriverDto
				 .setDriverSeaRoute(prpLdriverDriverSeaRoute[index]);
				 prpLdriverDto.setReceiveLicenseDate(new DateTime(
				 prpLdriverReceiveLicenseDate[index],
				 DateTime.YEAR_TO_DAY));
				 prpLdriverDto
				 .setDrivingCarType(prpLdriverDrivingCarType[index]);
				 prpLdriverDto.setDrivingYear(Integer.parseInt(DataUtils
				 .nullToZero(prpLdriverDrivingYear[index])));
				 prpLdriverDto
				 .setAwardLicenseOrgan(prpLdriverAwardLicenseOrgan[index]);
				 prpLdriverDto
				 .setSpecialCertificate(prpLdriverSpecialCertificate[index]);
				 prpLdriverDto.setFlag(prpLdriverFlag[index]);
				 //end    */
				//加入集合
				driverList.add(prpLdriverDto);
			}
			
			//查勘集合中加入驾驭员
			checkDto.setPrpLdriverDtoList(driverList);
		}
		/*---------------------查勘扩展信息PrpLcheckExtDto------------------------------------*/
		ArrayList prpLcheckExtDtoList = new ArrayList();
		PrpLcheckExtDto prpLcheckExtDto = null;
		
		//从界面得到输入数组
		String prpLcheckExtRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLcheckExtPolicyNo = httpServletRequest
		.getParameter("prpLcheckPolicyNo");
		String prpLcheckExtClaimNo = httpServletRequest
		.getParameter("prpLcheckClaimNo");
		String prpLcheckExtRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String prpLcheckExtColumnValue01 = httpServletRequest
		.getParameter("CheckExt01");
		String prpLcheckExtColumnValue02 = httpServletRequest
		.getParameter("CheckExt02");
		String prpLcheckExtColumnValue03 = httpServletRequest
		.getParameter("CheckExt03");
		String prpLcheckExtColumnValue04 = httpServletRequest
		.getParameter("CheckExt04");
		String prpLcheckExtColumnValue05 = httpServletRequest
		.getParameter("CheckExt05");
		String prpLcheckExtColumnValue06 = httpServletRequest
		.getParameter("CheckExt06");
		String prpLcheckExtColumnValue07 = httpServletRequest
		.getParameter("CheckExt07");
		String prpLcheckExtColumnValue08 = httpServletRequest
		.getParameter("CheckExt08");
		String prpLcheckExtColumnValue09 = httpServletRequest
		.getParameter("CheckExt09");
		String prpLcheckExtColumnValue10 = httpServletRequest
		.getParameter("CheckExt10");
		String prpLcheckExtColumnValue11 = httpServletRequest
		.getParameter("CheckExt11");
		String prpLcheckExtColumnValue12 = httpServletRequest
		.getParameter("CheckExt12");
		String prpLcheckExtColumnValue13 = httpServletRequest
		.getParameter("CheckExt13");
		String prpLcheckExtColumnValue14 = httpServletRequest
		.getParameter("CheckExt14");
		String prpLcheckExtColumnValue15 = httpServletRequest
		.getParameter("CheckExt15");
		String prpLcheckExtColumnValue16 = httpServletRequest
		.getParameter("CheckExt16");
		String prpLcheckExtColumnValue17 = httpServletRequest
		.getParameter("CheckExt17");
		String prpLcheckExtColumnValue18 = httpServletRequest
		.getParameter("CheckExt18");
		String prpLcheckExtColumnValue19 = httpServletRequest
		.getParameter("CheckExt19");
		
		//第一条记录
		boolean hasExtColumn = false; //表示有记录的
		
		if (prpLcheckExtColumnValue01 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt01Serial")));
			prpLcheckExtDto.setColumnName("CheckExt01");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt01Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue01);
			prpLcheckExtDto.setFlag("0");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第二条记录
		if (prpLcheckExtColumnValue02 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt02Serial")));
			prpLcheckExtDto.setColumnName("CheckExt02");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt02Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue02);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第三条记录
		if (prpLcheckExtColumnValue03 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt03Serial")));
			prpLcheckExtDto.setColumnName("CheckExt03");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt03Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue03);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第四条记录
		if (prpLcheckExtColumnValue04 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt04Serial")));
			prpLcheckExtDto.setColumnName("CheckExt04");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt04Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue04);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第五条记录
		if (prpLcheckExtColumnValue05 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt05Serial")));
			prpLcheckExtDto.setColumnName("CheckExt05");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt05Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue05);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第六条记录
		if (prpLcheckExtColumnValue06 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt06Serial")));
			prpLcheckExtDto.setColumnName("CheckExt06");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt06Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue06);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第七条记录
		if (prpLcheckExtColumnValue07 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt07Serial")));
			prpLcheckExtDto.setColumnName("CheckExt07");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt07Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue07);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第八条记录
		if (prpLcheckExtColumnValue08 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt08Serial")));
			prpLcheckExtDto.setColumnName("CheckExt08");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt08Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue08);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第九条记录
		if (prpLcheckExtColumnValue09 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt09Serial")));
			prpLcheckExtDto.setColumnName("CheckExt09");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt09Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue09);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十条记录
		if (prpLcheckExtColumnValue10 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt10Serial")));
			prpLcheckExtDto.setColumnName("CheckExt10");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt10Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue10);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十一条记录
		if (prpLcheckExtColumnValue11 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt11Serial")));
			prpLcheckExtDto.setColumnName("CheckExt11");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt11Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue11);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十二条记录
		if (prpLcheckExtColumnValue12 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt12Serial")));
			prpLcheckExtDto.setColumnName("CheckExt12");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt12Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue12);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十三条记录
		if (prpLcheckExtColumnValue13 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt13Serial")));
			prpLcheckExtDto.setColumnName("CheckExt13");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt13Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue13);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十四条记录
		if (prpLcheckExtColumnValue14 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt14Serial")));
			prpLcheckExtDto.setColumnName("CheckExt14");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt14Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue14);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十五条记录
		if (prpLcheckExtColumnValue15 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt15Serial")));
			prpLcheckExtDto.setColumnName("CheckExt15");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt15Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue15);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十六条记录
		if (prpLcheckExtColumnValue16 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt16Serial")));
			prpLcheckExtDto.setColumnName("CheckExt16");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt16Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue16);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//第十七条记录
		if (prpLcheckExtColumnValue17 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt17Serial")));
			prpLcheckExtDto.setColumnName("CheckExt17");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt17Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue17);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//  第十八条记录
		if (prpLcheckExtColumnValue18 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt18Serial")));
			prpLcheckExtDto.setColumnName("CheckExt18");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt18Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue18);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//  第十九条记录
		if (prpLcheckExtColumnValue19 != null) {
			prpLcheckExtDto = new PrpLcheckExtDto();
			prpLcheckExtDto.setPolicyNo(prpLcheckExtPolicyNo);
			prpLcheckExtDto.setRiskCode(prpLcheckExtRiskCode);
			prpLcheckExtDto.setRegistNo(prpLcheckExtRegistNo);
			prpLcheckExtDto.setClaimNo(claimNo);
			prpLcheckExtDto.setSerialNo(Integer.parseInt(httpServletRequest
					.getParameter("CheckExt19Serial")));
			prpLcheckExtDto.setColumnName("CheckExt19");
			prpLcheckExtDto.setDisplayName(httpServletRequest
					.getParameter("CheckExt19Dis"));
			prpLcheckExtDto.setColumnValue(prpLcheckExtColumnValue19);
			prpLcheckExtDto.setFlag("");
			//加入集合
			prpLcheckExtDtoList.add(prpLcheckExtDto);
			hasExtColumn = true;
		}
		//查勘扩展信息
		if (hasExtColumn) {
			checkDto.setPrpLcheckExtDtoList(prpLcheckExtDtoList);
		}
		
		/*---------------------事故估损金额PrpLcheckLossDto------------------------------------*/
		//Modify by chenrenda remark begin 20050418
		//Reason:在查勘页面中估损金额模块合到涉案车辆、财产损失、人伤信息中
		//ArrayList prpLcheckLossDtoList = new ArrayList();
		//PrpLcheckLossDto prpLcheckLossDto = null;
		//String prpLcheckLossRegistNo =
		// (String)httpServletRequest.getAttribute("registNo");
		//String prpLcheckLossPolicyNo =
		// httpServletRequest.getParameter("prpLcheckPolicyNo");
		//String prpLcheckLossClaimNo =
		// httpServletRequest.getParameter("prpLcheckClaimNo");
		//String prpLcheckLossRiskCode =
		// httpServletRequest.getParameter("prpLcheckRiskCode");
		//String[] prpLcheckLossSerialNo =
		// httpServletRequest.getParameterValues("prpLcheckLossSerialNo");
		//String[] prpLcheckLossReferSerialNo =
		// httpServletRequest.getParameterValues("prpLcheckLossReferSerialNo");
		//String[] prpLcheckLossKindCode =
		// httpServletRequest.getParameterValues("prpLcheckLossKindCode");
		//String[] prpLcheckLossLossFeeType =
		// httpServletRequest.getParameterValues("lossFeeType");
		//String[] prpLcheckLossLossFee =
		// httpServletRequest.getParameterValues("prpLcheckLossLossFee");
		//String[] prpLcheckLossFlag =
		// httpServletRequest.getParameterValues("prpLcheckLossFlag");
		//对象赋值
		//事故估损金额
		/*
		 * if (prpLcheckLossSerialNo ==null) {} else { for(int index = 1;index <
		 * prpLcheckLossSerialNo.length; index++) { prpLcheckLossDto = new
		 * PrpLcheckLossDto();
		 * prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
		 * prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
		 * prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
		 * prpLcheckLossDto.setClaimNo(claimNo);
		 * 
		 * prpLcheckLossDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLcheckLossSerialNo[index])));
		 * prpLcheckLossDto.setReferSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLcheckLossReferSerialNo[index])));
		 * prpLcheckLossDto.setKindCode(prpLcheckLossKindCode[index]);
		 * prpLcheckLossDto.setLossFeeType(prpLcheckLossLossFeeType[index]);
		 * prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(prpLcheckLossLossFee[index])));
		 * prpLcheckLossDto.setFlag(prpLcheckLossFlag[index]);
		 * 
		 * prpLcheckLossDtoList.add(prpLcheckLossDto); }
		 * checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList); }
		 */
		//Modify by chenrenda remark end 20050418
		//Modify by chenrenda add begin 20050407
		//Reason:页面中增加其它损失模块
		/*---------------------其它损失部位 PrpLthirdProp begin------------------------------------*/
		ArrayList thirdPropDtoList = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = null;
		
		//从界面得到输入数组
		String prpLthirdPropRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLthirdPropRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String[] prpLthirdPropItemNo = httpServletRequest
		.getParameterValues("prpLthirdPropItemNo");
		String[] prpLthirdPropLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdPropLicenseNo");
		String[] lossItemCode = httpServletRequest
		.getParameterValues("prpLthirdLossItemCode");
		String[] LossItemName = httpServletRequest
		.getParameterValues("prpLthirdLossItemName");
		String[] prpLthirdPropLossDesc = httpServletRequest
		.getParameterValues("prpLthirdPropLossDesc");
		String[] prpLthirdPropFlag = httpServletRequest
		.getParameterValues("prpLthirdPropFlag");
		
		//Modify by chenrenda add begin 20050418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		String[] prpLthirdPropKindCode = httpServletRequest
		.getParameterValues("prpLthirdPropKindCode");
		String[] prpLthirdPropLossFee = httpServletRequest
		.getParameterValues("prpLthirdPropLossFee");
		//Modify by chenrenda add end 20050418
		   String[] prpLthirdPropNewAddFlag      =httpServletRequest.getParameterValues("prpLthirdPropNewAddFlag" );//是否新增项目的标志
		   
		//对象赋值
		//损失部位部分开始
		if (prpLthirdPropItemNo == null) {
		} else {
			for (int index = 1; index < prpLthirdPropItemNo.length; index++) {
				
				prpLthirdPropDto = new PrpLthirdPropDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:预估损失模块合到涉案车辆信息中
				prpLcheckLossDto = new PrpLcheckLossDto();
				prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				prpLcheckLossDto.setClaimNo(claimNo);
				prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				System.out.println("**********prpLthirdProp****:"
						+ intCheckLossIndex);
				prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
				prpLcheckLossDto.setKindCode(prpLthirdPropKindCode[index]);
				prpLcheckLossDto.setLossFeeType("3");
				prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils
						.nullToZero(prpLthirdPropLossFee[index])));
				prpLcheckLossDto.setFlag("");
				intCheckLossIndex++;
				prpLcheckLossDtoList.add(prpLcheckLossDto);
				//Modify by chenrenda update end 20050418
				
				prpLthirdPropDto.setRegistNo(prpLthirdPropRegistNo);
				prpLthirdPropDto.setRiskCode(prpLthirdPropRiskCode);
				prpLthirdPropDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPropItemNo[index])));
				prpLthirdPropDto.setLicenseNo(prpLthirdPropLicenseNo[index]);
				prpLthirdPropDto.setLossItemCode(lossItemCode[index]);
				prpLthirdPropDto.setLossItemName(LossItemName[index]);
				prpLthirdPropDto.setLossItemDesc(prpLthirdPropLossDesc[index]);
				prpLthirdPropDto.setFlag(prpLthirdPropFlag[index]);
				
				//加入集合
				thirdPropDtoList.add(prpLthirdPropDto);
				
			}
//			增加财产损失定损调度信息，如果有人，就进行调度
			System.out.println(" 财产损失判断开始。。。。。。。。");
			if (thirdPropDtoList != null && thirdPropDtoList.size() > 0) {
				System.out.println(" 财产损失有内容。。。。。。。。");	
		         prpLscheduleItemDto = new PrpLscheduleItemDto();
		         prpLscheduleItemDto.setScheduleID(1);
		         prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
		         prpLscheduleItemDto.setItemNo(-1);
		         //表示是否选中
		         prpLscheduleItemDto.setSelectSend("1");
		         //表示没有调度成定损过
		         prpLscheduleItemDto.setSurveyTimes(0);
		         prpLscheduleItemDto.setSurveyType("1");
		         prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
		         prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
		             DateTime.YEAR_TO_DAY));
		         prpLscheduleItemDto.setScheduleType("schel");
		         prpLscheduleItemDto.setLicenseNo("财产损失");
		         prpLscheduleItemDto.setScheduleObjectID("_");
		         prpLscheduleItemDto.setScheduleObjectName(" ");
		         prpLscheduleItemDto.setNextNodeNo("propc");
		        	scheduleItemDtoList.add(prpLscheduleItemDto);

			}

			//报案集合中加入损失部位
			checkDto.setPrpLthirdPropDtoList(thirdPropDtoList);
			}
		/*---------------------其它损失部位 PrpLthirdProp end------------------------------------*/
		//Modify by chenrenda add end 20050407
		/*---------------------人员伤亡跟踪 PrpLpersonTrace ------------------------------------*/
		ArrayList personTraceDtoList = new ArrayList();
		PrpLpersonTraceDto prpLpersonTraceDto = null;
		//从界面得到输入数组
		String prpLpersonTraceRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLpersonTraceClaimNo = httpServletRequest
		.getParameter("prpLregistRiskCode");
		String prpLpersonTracePolicyNo = httpServletRequest
		.getParameter("prpLregistPolicyNo");
		String[] prpLpersonTracePersonNo = httpServletRequest
		.getParameterValues("prpLpersonTracePersonNo");
		String[] prpLpersonTracePersonName = httpServletRequest
		.getParameterValues("prpLpersonTracePersonName");
		String[] prpLpersonTracePersonSex = httpServletRequest
		.getParameterValues("personSex");
		String[] prpLpersonTracePersonAge = httpServletRequest
		.getParameterValues("prpLpersonTracePersonAge");
		String[] prpLpersonTraceIdentifyNumber = httpServletRequest
		.getParameterValues("prpLpersonTraceIdentifyNumber");
		String[] prpLpersonTraceRelatePersonNo = httpServletRequest
		.getParameterValues("prpLpersonTraceRelatePersonNo");
		String[] prpLpersonTraceJobCode = httpServletRequest
		.getParameterValues("prpLpersonTraceJobCode");
		String[] prpLpersonTraceJobName = httpServletRequest
		.getParameterValues("prpLpersonTraceJobName");
		String[] prpLpersonTraceReferKind = httpServletRequest
		.getParameterValues("prpLpersonTraceReferKind");
		String[] prpLpersonTracePartDesc = httpServletRequest
		.getParameterValues("prpLpersonTracePartDesc");
		String[] prpLpersonTraceHospital = httpServletRequest
		.getParameterValues("prpLpersonTraceHospital");
		String[] prpLpersonTraceMotionFlag = httpServletRequest
		.getParameterValues("motionFlag");
		String[] prpLpersonTraceWoundRemark = httpServletRequest
		.getParameterValues("prpLpersonTraceWoundRemark");
		String[] prpLpersonTraceRemark = httpServletRequest
		.getParameterValues("prpLpersonTraceRemark");
		String[] prpLpersonTraceFlag = httpServletRequest
		.getParameterValues("prpLpersonTraceFlag");

	     String[] prpLpersonTraceNewAddFlag      =httpServletRequest.getParameterValues("prpLpersonTraceNewAddFlag" );//是否新增项目的标志
	   
		//Modify by chenrenda add begin 20050418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中
		//String[] prpLpersonTraceLossFee =
		// httpServletRequest.getParameterValues("prpLpersonTraceLossFee" );
		//Modify by chenrenda add end 20050418
		
		//对象赋值
		//人员伤亡跟踪 部分开始
		if (prpLpersonTracePersonNo == null) {
		} else {
			System.out.println("人员伤亡跟踪部分开始 ");
			for (int index = 1; index < prpLpersonTracePersonNo.length; index++) {
				prpLpersonTraceDto = new PrpLpersonTraceDto();
				
				//Modify by chenrenda update begin 20050418
				//Reason:预估损失模块合到人伤信息中
				//人伤跟踪信息中去掉损失金额 2005-07-26
				/*
				 * prpLcheckLossDto = new PrpLcheckLossDto();
				 * prpLcheckLossDto.setRegistNo(prpLcheckLossRegistNo);
				 * prpLcheckLossDto.setClaimNo(claimNo);
				 * prpLcheckLossDto.setRiskCode(prpLcheckLossRiskCode);
				 * prpLcheckLossDto.setPolicyNo(prpLcheckLossPolicyNo);
				 * prpLcheckLossDto.setSerialNo(intCheckLossIndex);
				 * prpLcheckLossDto.setReferSerialNo(intCheckLossIndex);
				 * prpLcheckLossDto.setKindCode(prpLpersonTraceReferKind[index]); //
				 * prpLcheckLossDto.setKindCode("B");
				 * prpLcheckLossDto.setLossFeeType("2");
				 * prpLcheckLossDto.setLossFee(Double.parseDouble(DataUtils.nullToZero(prpLpersonTraceLossFee[index])));
				 * prpLcheckLossDto.setFlag(""); intCheckLossIndex++;
				 * prpLcheckLossDtoList.add(prpLcheckLossDto);
				 */
				//Modify by chenrenda update end 20050418
				prpLpersonTraceDto.setRegistNo(prpLpersonTraceRegistNo);
				prpLpersonTraceDto.setClaimNo(claimNo);
				prpLpersonTraceDto.setPolicyNo(prpLpersonTracePolicyNo);
				prpLpersonTraceDto.setPersonNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonTracePersonNo[index])));
				prpLpersonTraceDto
				.setPersonName(prpLpersonTracePersonName[index]);
				prpLpersonTraceDto
				.setPersonSex(prpLpersonTracePersonSex[index]);
				prpLpersonTraceDto.setPersonAge(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonTracePersonAge[index])));
				prpLpersonTraceDto
				.setIdentifyNumber(prpLpersonTraceIdentifyNumber[index]);
				prpLpersonTraceDto.setRelatePersonNo(Integer.parseInt(DataUtils
						.nullToZero(prpLpersonTraceRelatePersonNo[index])));
				prpLpersonTraceDto.setJobCode(prpLpersonTraceJobCode[index]);
				prpLpersonTraceDto.setJobName(prpLpersonTraceJobName[index]);
				if(prpLpersonTraceReferKind!=null){
				prpLpersonTraceDto
				.setReferKind(prpLpersonTraceReferKind[index]);
				}
				// prpLpersonTraceDto.setReferKind ("B");
				prpLpersonTraceDto.setPartDesc(prpLpersonTracePartDesc[index]);
				prpLpersonTraceDto.setHospital(prpLpersonTraceHospital[index]);
				prpLpersonTraceDto
				.setMotionFlag(prpLpersonTraceMotionFlag[index]);
				prpLpersonTraceDto
				.setWoundRemark(prpLpersonTraceWoundRemark[index]);
				prpLpersonTraceDto.setRemark(prpLpersonTraceRemark[index]);
				prpLpersonTraceDto.setFlag(prpLpersonTraceFlag[index]);
				//加入集合
				personTraceDtoList.add(prpLpersonTraceDto);
			}
			//报案集合中加入损失部位
			checkDto.setPrpLpersonTraceDtoList(personTraceDtoList);
		}
        if (personTraceDtoList!=null&&personTraceDtoList.size() >0){
            prpLscheduleItemDto = new PrpLscheduleItemDto();
            prpLscheduleItemDto.setScheduleID(1);
            prpLscheduleItemDto.setRegistNo(checkDto.getPrpLcheckDto() .getRegistNo());
            prpLscheduleItemDto.setItemNo(0);
            //表示是否选中
            prpLscheduleItemDto.setSelectSend("1");
            //表示没有调度成定损过
            prpLscheduleItemDto.setSurveyTimes(0);
            prpLscheduleItemDto.setSurveyType("1");
            prpLscheduleItemDto.setCheckSite(checkDto.getPrpLcheckDto().getCheckSite() );
            prpLscheduleItemDto.setInputDate(new DateTime(DateTime.current(),
                DateTime.YEAR_TO_DAY));
            prpLscheduleItemDto.setScheduleType("schel");
            prpLscheduleItemDto.setLicenseNo("人伤");
            prpLscheduleItemDto.setScheduleObjectID("_");
            prpLscheduleItemDto.setScheduleObjectName(" ");
            prpLscheduleItemDto.setNextNodeNo("wound");
           // if(prpLpersonTraceNewAddFlag[prpLpersonTraceDto.getPersonNo()].equals("new")){		
            	scheduleItemDtoList.add(prpLscheduleItemDto);
           // }
        }
        //整理数据，整理定损调度的数据，如果当提交的时候。。将新的数据放入prplscheduleItem中，并保留已经调度过的数据
        if (checkDto.getPrpLclaimStatusDto() .getStatus().equals("4")
           &&scheduleItemDtoList.size() >0 ){ //本次查勘查找到有新的调度任务
           //检查定损调度的情况，如果存在定损调度，检查是否已经调度过，如果没有调度过，按照没有调度过处理
           Collection prpLscheduleItemList = new ArrayList();
           //查询调度过的
           String strSql =" registno ='"+checkDto.getPrpLcheckDto() .getRegistNo()
                         +"' and surveyTimes=1";
           //查询数据
           UIScheduleAction uiScheduleAction=new UIScheduleAction();
           prpLscheduleItemList =uiScheduleAction.findItemByConditions(strSql) ;
           PrpLscheduleItemDto prpLscheduleItemoldDto=new PrpLscheduleItemDto();
           ArrayList scheduleItemLastList = new ArrayList();
           if (prpLscheduleItemList ==null || prpLscheduleItemList.size()<1){
              //不用检查scheduleITem的。。
              checkDto.setPrpLscheduleItemDtoList(scheduleItemDtoList) ;
           }else
           { //检查整理好的数据中，是否已经有已经调度过的数据

               ////System.out.println("prpLscheduleItemList.size()"+prpLscheduleItemList.size());
             //scheduleItemDtoList 是指原来从调度已经调度过的数据，无论怎么样，都是不能被删除的。
             //只要检查 scheduleItemDtoList中存在 prpLscheduleItemList中没有的，就增加prpLscheduleItemList好了。
             
            boolean blnotFind=true; 
            //scheduleItemDtoList，查勘这里收集的调度数据
             for (int i =0;i<scheduleItemDtoList.size() ;i++)
             {
               prpLscheduleItemDto = new PrpLscheduleItemDto();
               prpLscheduleItemDto = (PrpLscheduleItemDto)scheduleItemDtoList.get(i);
               //原则，相同的，以原来的数据为准，没有的已后来的为准
               blnotFind=true;
               for (int j =0;j<prpLscheduleItemList.size() ;j++)
               {
                 prpLscheduleItemoldDto= new PrpLscheduleItemDto();
                 prpLscheduleItemoldDto = (PrpLscheduleItemDto)((ArrayList)prpLscheduleItemList).get(j);
                 if (prpLscheduleItemDto.getItemNo()==prpLscheduleItemoldDto.getItemNo() )
                 { //如果存在旧的数据，就要用旧的数据，不要用新的数据
                   blnotFind=false;
                   break;
                 }
                 //原则，相同的，以原来的数据为准，没有的已后来的为准
               }
               
               if (blnotFind)  scheduleItemLastList.add(prpLscheduleItemDto) ;
             }
             
             //最后把原来已经调度过的数据再增加回去
            scheduleItemLastList.addAll(prpLscheduleItemList);
            checkDto.setPrpLscheduleItemDtoList(scheduleItemLastList) ;
           }
         }

		//Modify by chenrenda add begin 20050408
		//Reason:损失部位模块信息调整到涉案车辆信息中，相应模块做调整
		/*---------------------损失部位 PrpLthirdCarLoss begin------------------------------------*/
		ArrayList thirdCarLossDtoList = new ArrayList();
		PrpLthirdCarLossDto prpLthirdCarLossDto = null;
		//从界面得到输入数组
		String prpLthirdCarLossRegistNo = (String) httpServletRequest
		.getAttribute("registNo");
		String prpLthirdCarLossRiskCode = httpServletRequest
		.getParameter("prpLcheckRiskCode");
		String[] prpLthirdCarLossSerialNo = httpServletRequest
		.getParameterValues("RelateSerialNo");
		String[] prpLthirdCarLossItemNo = httpServletRequest
		.getParameterValues("prpLthirdCarLossItemNo");
		String[] prpLthirdCarLossLicenseNo = httpServletRequest
		.getParameterValues("prpLthirdCarLossLicenseNo");
		//Modify by chenrenda update begin 20050407
		String[] prpLthirdCarLossPartCode = httpServletRequest
		.getParameterValues("partCode"); //部件代码
		String[] prpLthirdCarLossPartName = httpServletRequest
		.getParameterValues("partName"); //部件名称
		String[] prpLthirdCarLossCompCode = httpServletRequest
		.getParameterValues("compCode");//零件代码
		String[] prpLthirdCarLossCompName = httpServletRequest
		.getParameterValues("compName");//零件名称
		String[] prpLthirdCarLossLossGrade = httpServletRequest
		.getParameterValues("prpLthirdCarLossLossGrade");
		String[] prpLthirdCarLossLossDesc = httpServletRequest
		.getParameterValues("prpLthirdCarLossLossDesc");
		String[] prpLthirdCarLossFlag = httpServletRequest
		.getParameterValues("prpLthirdCarLossFlag");
		String[] prpLthirdCarLossKindCode = httpServletRequest
		.getParameterValues("kindCode"); //险别代友 add by wuxiaodong
		// 车险查堪要求可以多险同时出
		
		//对象赋值
		//损失部位部分开始
		if (prpLthirdCarLossSerialNo == null) {
		} else {
			for (int index = 1; index < prpLthirdCarLossSerialNo.length; index++) {
				
				prpLthirdCarLossDto = new PrpLthirdCarLossDto();
				prpLthirdCarLossDto.setRegistNo(prpLthirdCarLossRegistNo);
				prpLthirdCarLossDto.setRiskCode(prpLthirdCarLossRiskCode);
				prpLthirdCarLossDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdCarLossSerialNo[index])));
				prpLthirdCarLossDto.setItemNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdCarLossItemNo[index])));
				prpLthirdCarLossDto
				.setLicenseNo(prpLthirdCarLossLicenseNo[index]);
				prpLthirdCarLossDto
				.setCompCode(prpLthirdCarLossCompCode[index]);
				prpLthirdCarLossDto
				.setCompName(prpLthirdCarLossCompName[index]);
				prpLthirdCarLossDto
				.setLossGrade(prpLthirdCarLossLossGrade[index]);
				prpLthirdCarLossDto
				.setLossDesc(prpLthirdCarLossLossDesc[index]);
				prpLthirdCarLossDto.setFlag(prpLthirdCarLossFlag[index]);
				prpLthirdCarLossDto
				.setPartCode(prpLthirdCarLossPartCode[index]);
				prpLthirdCarLossDto
				.setPartName(prpLthirdCarLossPartName[index]);
				if(prpLthirdCarLossKindCode!=null){
				prpLthirdCarLossDto
				.setKindCode(prpLthirdCarLossKindCode[index]);
				}
				//加入集合
				thirdCarLossDtoList.add(prpLthirdCarLossDto);
			}
			//查勘集合中加入损失部位
			checkDto.setPrpLthirdCarLossDtoList(thirdCarLossDtoList);
		}
		/*---------------------损失部位 PrpLthirdCarLoss end------------------------------------*/
		//Modify by chenrenda add end 20050408
		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		//从界面得到输入数组
		String prpLregistExtRegistNo = (String) httpServletRequest
		.getParameter("prpLregistExtRegistNo");
		String prpLregistExtRiskCode = httpServletRequest
		.getParameter("prpLregistExtRiskCode");
		String[] prpLregistExtSerialNo = httpServletRequest
		.getParameterValues("prpLregistExtSerialNo");
		String[] prpLregistExtInputDate = httpServletRequest
		.getParameterValues("prpLregistExtInputDate");
		String[] prpLregistExtInputHour = httpServletRequest
		.getParameterValues("prpLregistExtInputHour");
		String[] prpLregistExtOperatorCode = httpServletRequest
		.getParameterValues("prpLregistExtOperatorCode");
		String[] prpLregistExtContext = httpServletRequest
		.getParameterValues("prpLregistExtContext");
		
		//对象赋值
		//人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo == null) {
		} else {
			//System.out.println("人员伤亡跟踪部分开始 ");
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(prpLregistExtRegistNo);
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(
						prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto
				.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				//加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			//报案集合中加入损失部位
			checkDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}
		//Modify by chenrenda add begin 20051418
		//Reason:损失模块信息合到涉案车辆、人伤、财产损失信息中;最后损失信息放入checkDto对象中
		checkDto.setPrpLcheckLossDtoList(prpLcheckLossDtoList);
		//Modify by chenrenda add end 20051418
		//add by qinyongli start 2005-8-30 加入货运险查勘信息
		//modify by liuyanmei add 货运险险种包括02%的 在if条件中加入02的
		UICodeAction uiCodeAction = new UICodeAction();
		if(prpLcheckLossRiskCode!=null&&prpLcheckLossRiskCode.length()>0){
			String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckLossRiskCode);
			
			if ("Y".equals(strRiskType)) {
				PrpLextDto prpLextDto = new PrpLextDto();
				
				String prpLextRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
				String prpLextAppliCheckDate = httpServletRequest
				.getParameter("prpLextAppliCheckDate");
				String prpLextAppliPhone = httpServletRequest
				.getParameter("prpLextAppliPhone");
				String prpLextInsuredPhone = httpServletRequest
				.getParameter("prpLextInsuredPhone");
				String prplextSailStartDate = httpServletRequest
				.getParameter("prplextSailStartDate");
				String prpLextSumValue = httpServletRequest
				.getParameter("prpLextSumValue");
				String prpLextLoadCheckCompany = httpServletRequest
				.getParameter("prpLextLoadCheckCompany");
				String prpLextUnloadDate = httpServletRequest
				.getParameter("prpLextUnloadDate");
				String prpLextCurrency = httpServletRequest
				.getParameter("prpLextCurrency");
				String prpLextValue2 = httpServletRequest
				.getParameter("prpLextValue2");
				String prpLextValue1 = httpServletRequest
				.getParameter("prpLextValue1");
				String prpLextRestQuantity = httpServletRequest
				.getParameter("prpLextRestQuantity");
				String prpLextLoadingNo = httpServletRequest
				.getParameter("prpLextLoadingNo");
				String prpLextInvoiceNo = httpServletRequest
				.getParameter("prpLextInvoiceNo");
				String prpLextSalvor = httpServletRequest
				.getParameter("prpLextSalvor");
				
				//给DTO赋值，将界面得到得数值保存在DTO对象中
				prpLextDto.setCertiNo(prpLextRegistNo);
				prpLextDto.setCertiType("02");
				prpLextDto.setAppliCheckDate(new DateTime(prpLextAppliCheckDate,
						DateTime.YEAR_TO_DAY));
				prpLextDto.setAppliPhone(prpLextAppliPhone);
				prpLextDto.setInsuredPhone(prpLextInsuredPhone);
				prpLextDto.setSailStartDate(new DateTime(prplextSailStartDate,
						DateTime.YEAR_TO_DAY));
				prpLextDto.setCargoValue(Double.parseDouble(prpLextSumValue));
				prpLextDto.setCargoLossCheckCom(prpLextLoadCheckCompany);
				prpLextDto.setUnloadDate(new DateTime(prpLextUnloadDate,
						DateTime.YEAR_TO_DAY));
				prpLextDto.setCurrency(prpLextCurrency);
				prpLextDto.setSalvor(prpLextSalvor);
				prpLextDto.setValue2(prpLextValue2);
				prpLextDto.setValue1(prpLextValue1);
				prpLextDto.setRestQuantity(Integer.parseInt(prpLextRestQuantity));
				prpLextDto.setRemark(prpLextLoadingNo);//用备注存储，提单运单号码
				prpLextDto.setValue3(prpLextInvoiceNo);//value3存储发票号码
				checkDto.setPrpLextDto(prpLextDto);
				System.out.println("=====@@@@@@@@@@@@@@@@@#######$$$$$$%%%%%&&&&&&***currency=="+prpLextCurrency);
			}
			System.out.println("=====@@@@@@@@@@@@@@@@@####");
			//若是意健险则还要保存相应的调查费用信息
			strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckLossRiskCode);
			
			if ("E".equals(strRiskType)) {
				//获得相应的调查号
				String prpLacciCheckCheckNo = httpServletRequest.getParameter("prpLacciCheckCheckNo");
				//获得费用类别代码
				String[] prpLAcciCheckChargeCode = httpServletRequest.getParameterValues("prpLAcciCheckChargeCode");
				//获得费用类别名称
				String[] prpLAcciCheckChargeName = httpServletRequest.getParameterValues("prpLAcciCheckChargeName");
				//获得币别代码
				String[] prpLAcciCheckChargeCurrency = httpServletRequest.getParameterValues("prpLAcciCheckChargeCurrency");
//				//获得币别名称
//				String[] prpLAcciCheckChargeCurrencyName = httpServletRequest.getParameterValues("prpLAcciCheckChargeCurrencyName");
				//获得费用金额
				String[] prpLAcciCheckChargeAmount = httpServletRequest.getParameterValues("prpLAcciCheckChargeAmount");
				//定义调查费用List
				List PrpLAcciCheckChargeList = new ArrayList();
				double chargeAmount = 0;
				for (int i = 1; i < prpLAcciCheckChargeCode.length; i++) {
					PrpLAcciCheckChargeDto prpLAcciCheckChargeDto = new PrpLAcciCheckChargeDto();
					prpLAcciCheckChargeDto.setCheckNo(prpLacciCheckCheckNo);
					prpLAcciCheckChargeDto.setSerialNo(i);
					prpLAcciCheckChargeDto.setChargeCode(prpLAcciCheckChargeCode[i]);
					prpLAcciCheckChargeDto.setChargeName(prpLAcciCheckChargeName[i]);
					prpLAcciCheckChargeDto.setCurrency(prpLAcciCheckChargeCurrency[i]);
					chargeAmount = Double.valueOf(prpLAcciCheckChargeAmount[i]).doubleValue();
					prpLAcciCheckChargeDto.setChargeAmount(chargeAmount);
					PrpLAcciCheckChargeList.add(prpLAcciCheckChargeDto);
				}
				checkDto.getAcciCheckDto().setPrpLAcciCheckChargeDtoList(PrpLAcciCheckChargeList);
			}
		}
		return checkDto;
	}
	
	/**
	 * 取初始化信息需要的数据的整理. 填写查勘单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public CheckDto iniViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		CheckDto checkDto = new CheckDto();
		return checkDto;
	}
	
	/**
	 * 填写查勘页面及查询查勘request的生成.
	 * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			CheckDto checkDto) throws Exception {
		//得到request的PrpLcheckForm用于显示
		PrpLcheckDto prpLcheckDto = checkDto.getPrpLcheckDto();
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	public void checkDtoView(HttpServletRequest httpServletRequest,
			String checkNo) throws Exception {
		
		String riskCode = httpServletRequest.getParameter("riskCode");  
		//System.err.println("riskCode3:"+ riskCode);
		
	    String strRiskType = new UICodeAction().translateRiskCodetoRiskType(riskCode);
	    String editType     = httpServletRequest.getParameter("editType");
	    //System.err.println("editType:"+ editType);

		//意健险在这个环节的checktNo为调查号,长度大于21位,需要截取为21长.
//		if (checkNo.length() > 21) {
//			checkNo = checkNo.substring(0, 21);
//		}
//		
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	    //String lossItemName = "";
		// httpServletRequest.getParameter("lossItemName");
		//String insureCarFlag
		// =httpServletRequest.getParameter("insureCarFlag");
		UICheckAction uiCheckAction = new UICheckAction();
		CheckDto checkDto = uiCheckAction.findByPrimaryKey(checkNo);
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto = checkDto.getPrpLcheckDto();
		UICodeAction uiCodeAction =new UICodeAction();
		//原因：区分意健和非意键险
		
		RegistDto registDto = new UIRegistAction().findByPrimaryKey(checkNo);
		
		if ("0310".equals(riskCode)||"0312".equals(riskCode))
		{
			ArrayList prplCompensateHouseDtoList = new ArrayList();//清单列表
			if (checkNo != null)
			{
			
			BLPrplcompensatehouseFacade bLPrplcompensatehouseFacade = new BLPrplcompensatehouseFacade();

			if (editType.equals("EDIT") || editType.equals("SHOW"))
			{
				//String nodetype = httpServletRequest.getParameter("nodeType");
				//System.err.println("nodeType:"+ nodetype);
				String condition = " registno='" + checkNo + "' and nodetype='check' ";
				prplCompensateHouseDtoList = (ArrayList) bLPrplcompensatehouseFacade.findByConditions(condition);
			}
			httpServletRequest.setAttribute("prplCompensateHouseDtoList",prplCompensateHouseDtoList);
					
		    }
		}
		
		//调查号为25位，区分查勘号。为了允许查看以前的调查信息 add by xiatian 
		if ("E".equals(strRiskType) && checkNo.length()==25) {
			UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
			
			//按调查号进行查询 2005-08-16
			AcciCheckDto acciCheckDto = uiAcciCheckAction
			.findByPrimaryKey(checkNo);
			PrpLacciCheckDto prpLacciCheckDto = acciCheckDto
			.getPrpLacciCheckDto();
			httpServletRequest.setAttribute("acciCheckDto",acciCheckDto);
			if (prpLacciCheckDto != null) {
				//得到报案时间
				prpLacciCheckDto.setDamageStartDate(acciCheckDto
						.getPrpLregistDto().getDamageStartDate());
				String timeTemp = StringConvert.toStandardTime(acciCheckDto
						.getPrpLregistDto().getDamageStartHour());
				prpLacciCheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
				prpLacciCheckDto.setDamageStartHour(timeTemp.substring(0, 2));
				prpLacciCheckDto.setDamageAddress(acciCheckDto
						.getPrpLregistDto().getDamageAddress());
				prpLacciCheckDto.setPolicyNo(acciCheckDto.getPrpLregistDto()
						.getPolicyNo());
				
				//得到当前的时间
				prpLacciCheckDto.setCheckDate(new DateTime(DateTime.current()
						.toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckHour(String.valueOf(DateTime.current()
						.getHour()));
				prpLacciCheckDto.setDamageStartMinute2(String.valueOf(DateTime
						.current().getMinute()));
				
				prpLacciCheckDto.setCheckEndDate(new DateTime(DateTime
						.current().toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckEndHour(String.valueOf(DateTime
						.current().getHour()));
				prpLacciCheckDto.setDamageStartMinute3(String.valueOf(DateTime
						.current().getMinute()));
				
				//增加调查费用币别start
			
				String currencyName = uiCodeAction.translateCurrencyCode(
						prpLacciCheckDto.getCurrency(), true);
				prpLacciCheckDto.setCurrencyName(currencyName);
				//增加调查费用币别end
				
				//添加备注信息
				//prpLacciCheckDto.setRemark(acciCheckDto.getPrpLregistDto().getRemark());
				httpServletRequest.setAttribute("prpLacciCheckDto",
						prpLacciCheckDto);
				
				//[调查描述]给调查描述多行列表准备数据
				PrpLacciCheckTextDto prpLacciCheckTextDto = new PrpLacciCheckTextDto();
				String tempContext = "";
				if (checkDto.getAcciCheckDto().getPrpLacciCheckTextDtoList() != null) {
					Iterator iterator = checkDto.getAcciCheckDto()
					.getPrpLacciCheckTextDtoList().iterator();
					while (iterator.hasNext()) {
						PrpLacciCheckTextDto prpLacciCheckTextDtoTemp2 = (PrpLacciCheckTextDto) iterator
						.next();
						tempContext = tempContext
						+ prpLacciCheckTextDtoTemp2.getContext();
					}
				}
				prpLacciCheckTextDto.setContext(tempContext);
				prpLacciCheckTextDto.setTextType("3");
				httpServletRequest.setAttribute("prpLacciCheckTextDto",
						prpLacciCheckTextDto);
				
				if (prpLcheckDto == null) {
					prpLcheckDto = new PrpLcheckDto();
				}
				
				if (checkDto.getPrpLclaimStatusDto() != null) {
					if (checkDto.getPrpLclaimStatusDto().getStatus()
							.equals("7"))
						checkDto.getPrpLclaimStatusDto().setStatus("3");
					prpLcheckDto.setStatus(checkDto.getPrpLclaimStatusDto()
							.getStatus());
				} else {
					//已提交，已经处理完毕的状态
					prpLcheckDto.setStatus("4");
				}
				String nodeStatus = httpServletRequest.getParameter("status");
				if (nodeStatus != null) {
					prpLcheckDto.setStatus(nodeStatus);
				}
				
				prpLcheckDto.setRiskCode(acciCheckDto.getPrpLacciCheckDto()
						.getRiskCode());
				
				changeCodeToName(httpServletRequest, prpLcheckDto);
				
				DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
				//查询相同保单号的出险次数
				//modify by zhulei 20050902 意健险需要不同的处理，否则PolicyNo和RegistNo取不到值
				//modify by   项目组  孙兆云 险类27修改为07
			    
				
					dAARegistViewHelper.getSamePolicyRegistInfo(
							httpServletRequest, acciCheckDto
							.getPrpLacciCheckDto().getPolicyNo(),
							acciCheckDto.getPrpLacciCheckDto().getRegistNo());
				
				//Modify by chenrenda add begin 20050418
				//Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
				String strPrpLnodeType = "check";
				httpServletRequest
				.setAttribute("prpLnodeType", strPrpLnodeType);
				//Modify by chenrenda add end 20050418
				
				//设置各个子表信息项到窗体表单
				//setSubInfo(httpServletRequest,checkDto);
				//设置工作流下一个节点提交的配置信息
				getSubmitNodes(httpServletRequest);
				//设置主查勘信息内容到窗体表单
				httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
			} else {
				throw new Exception("数据库中没有这条数据！");
			}
		} else {
			//modify by wangwei add end 2005-06-18
			
			//根据查询出来的数据内容，给PrpLcheckDto赋值
			
			//为了同步工作流
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&＝＝＝＝＝       "+prpLcheckDto);
			//     prpLcheckDto.setLossItemName(lossItemName);
			if(prpLcheckDto == null){
				httpServletRequest.setAttribute("errorMessage", "该案查勘信息不存在，可能还未进行查勘");
			}
			prpLcheckDto.setLossItemCode(prpLcheckDto.getReferSerialNo() + "");
			//     prpLcheckDto.setInsureCarFlag(insureCarFlag);
			//    System.out.println("------liujianbo-----"+prpLcheckDto.getLossItemCode()+"|"+prpLcheckDto.getLossItemName()+"|"+prpLcheckDto.getInsureCarFlag());
			//设置查勘操作的状态为 案件修改 (正处理任务)
			if (checkDto.getPrpLclaimStatusDto() != null) {
				if (checkDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					checkDto.getPrpLclaimStatusDto().setStatus("3");
				prpLcheckDto.setStatus(checkDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				//已提交，已经处理完毕的状态
				prpLcheckDto.setStatus("4");
			}
			String nodeStatus = httpServletRequest.getParameter("status");
			if (nodeStatus != null) {
				prpLcheckDto.setStatus(nodeStatus);
			}
			
			//UIRegistAction uiRegistAction = new UIRegistAction();
			//RegistDto registDto = uiRegistAction.findByPrimaryKey(checkNo);
		  //[没有车损险时，页面上不显示选择标的车是否受损的标志]-20060426-start--------------------------
		   String damageDate = String.valueOf(registDto.getPrpLregistDto()
					.getDamageStartDate());
			String damageHour = registDto.getPrpLregistDto()
					.getDamageStartHour();

			String kindCode = "";
			String kindAFlag = "0"; //出险时有无保车损险的标志 1：有 0：无
			String kindBFlag = "0"; //出险时有无保三者险的标志 1：有 0：无
			EndorseViewHelper endorViewHelper = new EndorseViewHelper();
			// 根据出险时间找到保单
			PolicyDto damagePolicyDto = endorViewHelper.findForEndorBefore(
					registDto.getPrpLregistDto().getPolicyNo(), damageDate,
					damageHour);
			ArrayList prpCitemKindDtoList = new ArrayList();
			prpCitemKindDtoList = damagePolicyDto.getPrpCitemKindDtoList();
			if (prpCitemKindDtoList != null && prpCitemKindDtoList.size() > 0) {
				for (int k = 0; k < prpCitemKindDtoList.size(); k++) {
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) prpCitemKindDtoList
							.get(k);
					kindCode = prpCitemKindDto.getKindCode();
					if (kindCode.equals("A")) {
						kindAFlag = "1";
					}

				}
			}
			httpServletRequest.setAttribute("kindAFlag", kindAFlag);

           //[没有车损险时，页面上不显示选择标的车是否受损的标志]-20060426-end------------------------
			
			prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto()
					.getDamageStartDate());
			prpLcheckDto.setDamageEndDate(registDto.getPrpLregistDto()
					.getDamageEndDate());
			prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
					.getEstimateFee());
			prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
					.getEstimateLoss());
			//registDto.getPrpLregistDto().setDamageStartHour(StringConvert.toStandardTime(registDto.getPrpLregistDto().getDamageStartHour()));
			String timeTemp = StringConvert.toStandardTime(registDto
					.getPrpLregistDto().getDamageStartHour());
			prpLcheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
			timeTemp = StringConvert.toStandardTime(registDto
					.getPrpLregistDto().getDamageEndHour());
			prpLcheckDto.setDamageEndMinute(timeTemp.substring(3, 5));
			prpLcheckDto.setDamageEndHour(timeTemp.substring(0, 2));
			//prpLcheckDto.setDamageAddress(registDto.getPrpLregistDto()
			//		.getDamageAddress());
			//modify by lixiang add 20050308 start
			//reason:为了保证立案后三者车的顺利保存
			//如果立案取出赔案号，否则会出现问题
			//UICodeAction uiCodeAction = new UICodeAction();
			String claimNo = uiCodeAction.translateBusinessCode(checkNo, true);
			prpLcheckDto.setClaimNo(claimNo);
			//modify by lixiang add 20050308 end
			//modify by caopeng add 20051219 start
			if(registDto!=null && registDto.getPrpLregistDto()!=null){
				prpLcheckDto.setLossItemName(registDto.getPrpLregistDto().getLicenseNo());
				prpLcheckDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
			}
			//modify by caopeng add 20051219 end
			//设置相关代码的中文转换
			changeCodeToName(httpServletRequest, prpLcheckDto);
			
			//设置窗体表单中各个多选框中列表信息的内容
			setSelectionList(httpServletRequest, prpLcheckDto);
			DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
			//查询相同保单号的出险次数
			dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
					prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo());
			
			//Modify by chenrenda add begin 20050418
			//Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
			String strPrpLnodeType = "check";
			httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
			//Modify by chenrenda add end 20050418
			
			//设置各个子表信息项到窗体表单
			setSubInfo(httpServletRequest, checkDto);
			
			//设置工作流下一个节点提交的配置信息
			getSubmitNodes(httpServletRequest);
			//设置主查勘信息内容到窗体表单
			httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
			
			//在界面上显示险种名称 2005-09-09
			httpServletRequest.setAttribute("riskCName", uiCodeAction
					.translateRiskCode(prpLcheckDto.getRiskCode(), true));
			
			httpServletRequest.setAttribute("prpLregistDto", registDto
					.getPrpLregistDto());
			//modify by wangwei add start 2005-06-15
			// 原因：转换代理人
			httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
					.getIdentifierName());
			//modify by wangwei add end 2005-06-15
			String policyNo = prpLcheckDto.getPolicyNo();
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, registDto.getPrpLregistDto().getDamageStartDate()
					.toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			//add by qinyongli 2005-8-30 start
			//reason:增加货运险扩展信息   
			//modify by liuyanmei add 货运险险种包括02%的  在if条件中加入02的
		    strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckDto.getRiskCode());
			if ("Y".equals(strRiskType)) {
				PrpLextDto prpLextDto = (PrpLextDto) checkDto.getPrpLextDto();
				
				String currency = prpLextDto.getCurrency();
				String currencyName = uiCodeAction.translateCurrencyCode(
						currency, true);
				prpLextDto.setCurrencyCname(currencyName);
				
				if (policyDto != null && prpLextDto != null) {
					prpLextDto.setSumAmount(String.valueOf(policyDto
							.getPrpCmainDto().getSumAmount())); //保额，从保单带入
					prpLextDto.setLimitAmount("0"); //免赔额 暂时未赋值
					String rootComName = AppConfig.get("sysconst.ROOTCOMCNAME");
					prpLextDto.setPrpCompanyName(rootComName);
					ArrayList itemKind = policyDto.getPrpCitemKindDtoList();
					String itemAll = "";
					if (itemKind != null && itemKind.size() > 0) {
						Iterator item = itemKind.iterator();
						while (item.hasNext()) {
							PrpCitemKindDto itemKindDto = (PrpCitemKindDto) item
							.next();
							itemAll = itemAll + itemKindDto.getItemDetailName();
							double account = itemKindDto.getQuantity();
							String model = itemKindDto.getModel();
							if (account > 0) {
								itemAll = itemAll + "; 共" + account + model;
							}
							prpLextDto.setLimitAmount(String
									.valueOf(itemKindDto.getDeductible())); //免赔额
							break;
						}
					}
				}
				if (policyDto != null) {
					PrpCmainCargoDto prpCmainCargoDto = policyDto
					.getPrpCmainCargoDto();
					if("Y".equals(strRiskType)&&prpCmainCargoDto==null){
						prpCmainCargoDto = new PrpCmainCargoDto();
						prpCmainCargoDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
						prpCmainCargoDto.setEndSiteName("_____");
						prpCmainCargoDto.setEndSiteCode("");
						prpCmainCargoDto.setStartSiteCode("");
						prpCmainCargoDto.setStartSiteName("_____");
					}
					httpServletRequest.setAttribute("prpLcarGoDto", prpCmainCargoDto);
				}
				if (prpLextDto == null) {
					prpLextDto = new PrpLextDto();
				}
				httpServletRequest.setAttribute("prpLextDto", prpLextDto);
			}
			//add end by qinyongli
			
			//获取定损信息
			//DAACertainLossViewHelper daaCertainLossViewHelper = new
			// DAACertainLossViewHelper();
			//daaCertainLossViewHelper.registDtoToView(httpServletRequest,checkNo,BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
		}
	}
	
	/**
	 * 填写查勘页面及查询查勘request的生成.
	 * 填写查勘时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void registDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String editType) throws Exception {
		// 意健险在这个环节的registNo为调查号,长度大于21位,需要截取为21长.
		if (registNo.length() > 21) {
			registNo = registNo.substring(0, 21);
		}	
		
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
	    if (user==null){
			user = new UserDto();
		}
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		registDto.getPrpLdriverDtoList();
	    UICheckAction uiCheckAction = new UICheckAction();
		UICodeAction uiCodeAction = new UICodeAction();
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);
		
		
        //[没有车损险时，页面上不显示选择标的车是否受损的标志]-20060426-start--------------------------
			
		String  damageDate = String.valueOf(registDto.getPrpLregistDto().getDamageStartDate());
		String  damageHour = registDto.getPrpLregistDto().getDamageStartHour();
		//String  policyNo   = registDto.getPrpLregistDto().getPolicyNo();
		String kindCode ="";
		String kindAFlag ="0";  //出险时有无保车损险的标志 1：有 0：无
		String kindBFlag ="0";  //出险时有无保三者险的标志 1：有 0：无
		EndorseViewHelper  endorViewHelper = new EndorseViewHelper();
		// 根据出险时间找到保单
		PolicyDto damagePolicyDto = endorViewHelper.findForEndorBefore(registDto
				.getPrpLregistDto().getPolicyNo(), damageDate, damageHour);
        ArrayList  prpCitemKindDtoList =new ArrayList();
        prpCitemKindDtoList =  damagePolicyDto.getPrpCitemKindDtoList(); 
        if ( prpCitemKindDtoList!=null && prpCitemKindDtoList.size()>0){
		   for ( int k =0; k<prpCitemKindDtoList.size();k++){
			  PrpCitemKindDto prpCitemKindDto =(PrpCitemKindDto) prpCitemKindDtoList.get(k);
			  kindCode = prpCitemKindDto.getKindCode();
			  if (kindCode.equals("A")) {
			  	  kindAFlag ="1";
			  }
			
		   }
        }
		httpServletRequest.setAttribute("kindAFlag",kindAFlag);
		
		
		//[没有车损险时，页面上不显示选择标的车是否受损的标志]-20060426-end--------------------------
		
			
		//原因：区分意健和非意键险
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if ( "E".equals(strRiskType) ) {
			UIAcciCheckAction uiAcciCheckAction = new UIAcciCheckAction();
			
			//按调查号进行查询 2005-08-16
			AcciCheckDto acciCheckDto = uiAcciCheckAction
			.findByPrimaryKey(httpServletRequest.getParameter("keyIn"));
			PrpLacciCheckDto prpLacciCheckDto = acciCheckDto
			.getPrpLacciCheckDto();
			httpServletRequest.setAttribute("acciCheckDto",acciCheckDto);
			
			if (prpLacciCheckDto != null) {
				//得到报案时间
				prpLacciCheckDto.setDamageStartDate(acciCheckDto
						.getPrpLregistDto().getDamageStartDate());
				String timeTemp = StringConvert.toStandardTime(acciCheckDto
						.getPrpLregistDto().getDamageStartHour());
				prpLacciCheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
				prpLacciCheckDto.setDamageStartHour(timeTemp.substring(0, 2));
				prpLacciCheckDto.setDamageAddress(acciCheckDto
						.getPrpLregistDto().getDamageAddress());
				prpLacciCheckDto.setPolicyNo(acciCheckDto.getPrpLregistDto()
						.getPolicyNo());
				
				//从报案表中得到出险代码和出险原因 2005-09-02
				prpLacciCheckDto.setDamageCode(registDto.getPrpLregistDto()
						.getDamageCode());
				prpLacciCheckDto.setDamageName(registDto.getPrpLregistDto()
						.getDamageName());
				
				//从报案表中得到事故类型 205-09-06
				prpLacciCheckDto.setDamageTypeCode(registDto.getPrpLregistDto()
						.getDamageTypeCode());
				prpLacciCheckDto.setDamageTypeName(registDto.getPrpLregistDto()
						.getDamageTypeName());
				
				//得到当前的时间
				prpLacciCheckDto.setCheckDate(new DateTime(DateTime.current()
						.toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckHour(String.valueOf(DateTime.current()
						.getHour()));
				prpLacciCheckDto.setDamageStartMinute2(String.valueOf(DateTime
						.current().getMinute()));
				
				prpLacciCheckDto.setCheckEndDate(new DateTime(DateTime
						.current().toString(), DateTime.YEAR_TO_DAY));
				prpLacciCheckDto.setCheckEndHour(String.valueOf(DateTime
						.current().getHour()));
				prpLacciCheckDto.setDamageStartMinute3(String.valueOf(DateTime
						.current().getMinute()));
				
				//添加备注信息
				prpLacciCheckDto.setRemark(acciCheckDto.getPrpLregistDto()
						.getRemark());
				//设置默认币别为"人民币"
				prpLacciCheckDto.setCurrency("CNY");
				String currencyName = uiCodeAction.translateCurrencyCode(
						prpLacciCheckDto.getCurrency(), true);
				prpLacciCheckDto.setCurrencyName(currencyName);
				httpServletRequest.setAttribute("prpLacciCheckDto",
						prpLacciCheckDto);
				//赔款费用数据-----------------------------------------------------
				//货币代码的列表
				/* Collection collection = uiCodeAction.getCurrencyList();
				 Iterator iterator1 = collection.iterator();
				 HashMap currencyTemp = new HashMap();
				 while (iterator1.hasNext()) {
				 PrpDcurrencyDto prpDcurrencyDto = (PrpDcurrencyDto) iterator1.next();
				 currencyTemp.put(prpDcurrencyDto.getCurrencyCode(), prpDcurrencyDto.getCurrencyCName());
				 }
				 
				 Collection arrayList3 = new ArrayList();
				 PrpLchargeDto prpLchargeDto = new PrpLchargeDto();
				 arrayList3 = acciCheckDto.getPrpLchargeDtoList();
				 if (arrayList3 != null) {
				 Iterator iteraotrChargeDto = arrayList3.iterator();
				 PrpLchargeDto prpLchargeDtoTemp = null;
				 while (iteraotrChargeDto.hasNext()) {
				 prpLchargeDtoTemp = (PrpLchargeDto) iteraotrChargeDto.next();
				 prpLchargeDtoTemp.setKindName(uiCodeAction.translateKindCode(prpLchargeDtoTemp.getRiskCode(),
				 prpLchargeDtoTemp.getKindCode(), true));
				 
				 
				 if (currencyTemp.containsKey(prpLchargeDtoTemp.getCurrency())) {
				 prpLchargeDtoTemp.setCurrencyName(currencyTemp.get(prpLchargeDtoTemp.getCurrency()).toString());
				 }
				 }
				 }
				 prpLchargeDto.setPrpLchargeList(arrayList3);
				 httpServletRequest.setAttribute("prpLchargeDto", prpLchargeDto);
				 
				 */
				
				
				//------------------------------------------------------------------
				//[调查描述]给调查描述多行列表准备数据
				PrpLacciCheckTextDto prpLacciCheckTextDto = new PrpLacciCheckTextDto();
				String tempContext = "";
				if (registDto.getAcciCheckDto().getPrpLacciCheckTextDtoList() != null) {
					Iterator iterator = registDto.getAcciCheckDto()
					.getPrpLacciCheckTextDtoList().iterator();
					while (iterator.hasNext()) {
						PrpLacciCheckTextDto prpLacciCheckTextDtoTemp2 = (PrpLacciCheckTextDto) iterator
						.next();
						tempContext = tempContext
						+ prpLacciCheckTextDtoTemp2.getContext();
					}
				}
				prpLacciCheckTextDto.setContext(tempContext);
				prpLacciCheckTextDto.setTextType("3");
				httpServletRequest.setAttribute("prpLacciCheckTextDto",
						prpLacciCheckTextDto);
				//add by qinyongli begin 2005-7-19
				//得到共保信息
				String policyNo = prpLacciCheckDto.getPolicyNo();
				EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
				PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
						policyNo, acciCheckDto.getPrpLregistDto()
						.getDamageStartDate().toString(), acciCheckDto
						.getPrpLregistDto().getDamageStartHour());
				if (policyDto != null) {
					httpServletRequest.setAttribute("coinsFlag", policyDto
							.getPrpCmainDto().getCoinsFlag());
					httpServletRequest.setAttribute("shareHolderFlag",
							policyDto.getPrpCmainDto().getShareHolderFlag());
				}
				//add by qinyongli end 2005-7-19
			} else {
				throw new Exception("数据库中没有这条数据！");
			}
		}
		
		//原因：要在界面上显示一些立案信息
		com.sinosoft.claim.ui.control.action.UIClaimAction uiClaimAction = new com.sinosoft.claim.ui.control.action.UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
		.findByPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);
		
		//原因：需要在货运险的查勘页面中保单中带入查勘处理单位
		/*
		 * UIPolicyAction uiPolicyAction = new UIPolicyAction(); PolicyDto
		 * policyDto =
		 * uiPolicyAction.findByPrimaryKey(registDto.getPrpLregistDto().getPolicyNo());
		 * if (policyDto.getPrpCmainCargoDto() != null) { if
		 * (policyDto.getPrpCmainCargoDto().getRiskCode().startsWith("10")) {
		 * httpServletRequest.setAttribute("com.sinosoft.agentCode",
		 * uiCodeAction.translateAgentName(policyDto.getPrpCmainCargoDto().getCheckAgentCode())); }
		 * else { httpServletRequest.setAttribute("com.sinosoft.agentCode", ""); } }
		 * else { httpServletRequest.setAttribute("com.sinosoft.agentCode", ""); }
		 */
		httpServletRequest.setAttribute("com.sinosoft.agentCode", registDto
				.getIdentifierName());
		//modify by wangwei add end 2005-06-07
		
		//查询是否已经录入过查勘信息。
		
		if (uiCheckAction.isExist(registNo)) {
			//System.out.println("已经有查勘信息了");
			checkDtoView(httpServletRequest, registNo);
			return;
		}
		String insureCarFlag = httpServletRequest.getParameter("insureCarFlag"); //是否为本保单车辆
		String lossItemCode = httpServletRequest.getParameter("lossItemCode"); //损失标的
		String lossItemName = httpServletRequest.getParameter("lossItemName"); //车牌名称
		
		//如果有数值的话，重新给界面复制
		
		//根据查询出来的数据内容，给PrpLcheckDto赋值
		//设置数值
		//prpLcheckDto.setInsureCarFlag(insureCarFlag);
		prpLcheckDto.setReferSerialNo(1);
		//prpLcheckDto.setLossItemCode(lossItemCode);
		//prpLcheckDto.setLossItemName(lossItemName);
		
		prpLcheckDto.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		//如果在查勘前已经立案了，那么如果不把赔案号放入的话会出问题
		
		prpLcheckDto.setClaimNo(claimNo);
		prpLcheckDto.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		prpLcheckDto.setPolicyNo(registDto.getPrpLregistDto().getPolicyNo());
		//prpLcheckDto.setCheckType("L");
		
		////查勘界面的查勘类型由调度表带出 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckType(registDto.getPrpLscheduleMainWFDto()
					.getFlag());
		}
		
		//modify by wangwei add start 20050602
		//原因：增加报损金额和报损费用
		prpLcheckDto.setRegistEstimateLoss(registDto.getPrpLregistDto()
				.getEstimateLoss());
		prpLcheckDto.setRegistEstimateFee(registDto.getPrpLregistDto()
				.getEstimateFee());
		//modity by wangwei add end 20050602
		
		//prpLcheckDto.setCheckNature(registDto.getPrpLregistDto().getCheckNature());
		//prpLcheckDto.setCheckDate(registDto.getPrpLregistDto().getCheckDate());
		prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		//modify by lixiang remark 20050309 start
		// prpLcheckDto.setCheckSite(registDto.getPrpLregistDto().getDamageAddress());
		//reason:查勘界面出险地点由报案带出，查勘地址默认为出险地点
		//modify by lixiang remark 20050309 end
		
		//查勘界面的查勘地址由调度表带出 2005-07-12
		if (registDto.getPrpLscheduleMainWFDto() != null) {
			prpLcheckDto.setCheckSite(registDto.getPrpLscheduleMainWFDto()
					.getCheckSite());
		}
		
		prpLcheckDto.setFirstSiteFlag(registDto.getPrpLregistDto()
				.getFirstSiteFlag());
		prpLcheckDto.setClaimType(registDto.getPrpLregistDto().getClaimType());
		
		//================互碰自赔案件时用到，查堪 赔案类别先从立案取，立案没有从报案取===============================
		if ("D".equals(strRiskType) && registClaimDtoList != null && registClaimDtoList.size() > 0) {
			Iterator it = registClaimDtoList.iterator();
			while(it.hasNext()){
                RegistClaimInfoDto registClaimDto = (RegistClaimInfoDto) it.next();
                if(registClaimDto.getRegistNo().equals(registNo)){
                	if(registClaimDto.getClaimType() != null && !registClaimDto.getClaimType().equals("")){
                		prpLcheckDto.setClaimType(registClaimDto.getClaimType());
                	}
                	break;
                }
		
            }
		}   
		
		//================================================================================================
		
		
		prpLcheckDto
		.setDamageCode(registDto.getPrpLregistDto().getDamageCode());
		prpLcheckDto
		.setDamageName(registDto.getPrpLregistDto().getDamageName());
		prpLcheckDto.setDamageTypeCode(registDto.getPrpLregistDto()
				.getDamageTypeCode());
		prpLcheckDto.setDamageTypeName(registDto.getPrpLregistDto()
				.getDamageTypeName());
		//prpLcheckDto.setReferKind(registDto.getPrpLregistDto().getReferKind());
		/////////////////////////bobobo//////////////////
		prpLcheckDto.setReferKind("A,M,L");
		prpLcheckDto.setDamageAreaCode(registDto.getPrpLregistDto()
				.getDamageAreaCode());
		prpLcheckDto.setDamageAddressType(registDto.getPrpLregistDto()
				.getDamageAddressType());
		//prpLcheckDto.setIndemnityDuty(registDto.getPrpLregistDto().getIndemnityDuty());
		//prpLcheckDto.setClaimFlag(registDto.getPrpLregistDto().getClaimFlag());
		
		//modify by lixiang add 20050304 start
		//reason:查勘人1默认为操作人远的名称
		
		prpLcheckDto.setChecker1(user.getUserName());
		//System.out.println("prpLcheckDto.setChecker1"+prpLcheckDto.getChecker1());
		//modify by lixiang add 20050304 end
		
		//prpLcheckDto.setChecker2(registDto.getPrpLregistDto().getChecker2());
		//prpLcheckDto.setCheckUnitName(registDto.getPrpLregistDto().getCheckUnitName());
		prpLcheckDto
		.setHandleUnit(registDto.getPrpLregistDto().getHandleUnit());
		prpLcheckDto.setRemark(registDto.getPrpLregistDto().getRemark());
		prpLcheckDto.setFlag(registDto.getPrpLregistDto().getFlag());
		
		//add by wuxiaodong 050905 beegain reasion 用户显示报案时的币别
		prpLcheckDto
		.setCurrency(registDto.getPrpLregistDto().getEstiCurrency());
		//add by wuxiaodong 050905 end
		
		prpLcheckDto.setDamageAddress(registDto.getPrpLregistDto()
				.getDamageAddress());
		prpLcheckDto.setStatus(registDto.getPrpLregistDto().getStatus());
		prpLcheckDto.setEditType(registDto.getPrpLregistDto().getEditType());
		prpLcheckDto
		.setClauseType(registDto.getPrpLregistDto().getClauseType());
		prpLcheckDto
		.setClauseName(registDto.getPrpLregistDto().getClauseName());//code
		prpLcheckDto.setDamageStartDate(registDto.getPrpLregistDto()
				.getDamageStartDate());
		//prpLcheckDto.setDamageStartHour(registDto.getPrpLregistDto().getDamageStartHour());
		
		prpLcheckDto.setDamageEndDate(registDto.getPrpLregistDto()
				.getDamageEndDate());
		
		//向查勘页面添加被保险人信息  2005-09-26
		prpLcheckDto.setInsuredName(registDto.getPrpLregistDto().getInsuredName());
		
		//prpLcheckDto.setDamageEndHour(registDto.getPrpLregistDto().getDamageEndHour());
		String timeTemp = StringConvert.toStandardTime(registDto
				.getPrpLregistDto().getDamageStartHour());
		prpLcheckDto.setDamageStartMinute(timeTemp.substring(3, 5));
		prpLcheckDto.setDamageStartHour(timeTemp.substring(0, 2));
		timeTemp = StringConvert.toStandardTime(registDto.getPrpLregistDto()
				.getDamageEndHour());
		prpLcheckDto.setDamageEndMinute(timeTemp.substring(3, 5));
		prpLcheckDto.setDamageEndHour(timeTemp.substring(0, 2));
		
		prpLcheckDto.setDamageAreaName(registDto.getPrpLregistDto()
				.getDamageAreaName());
		//prpLcheckDto.setHandleUnitName(registDto.getPrpLregistDto().getHandleUnitName());//未知
		
		//默认查勘日期
		prpLcheckDto.setCheckDate(new DateTime(DateTime.current(),
				DateTime.YEAR_TO_DAY));
		//设置查勘操作的状态为 新案件登记 (未处理任务)
		prpLcheckDto.setStatus("1");
		
		//设置相关代码的中文转换
		changeCodeToName(httpServletRequest, prpLcheckDto);
		//设置窗体表单中各个多选框中列表信息的内容
		//System.out.println("prpLcheckDto.getHandleUnitName()="+prpLcheckDto.getHandleUnitName()
		// );
		setSelectionList(httpServletRequest, prpLcheckDto);
		//查询相同保单号的出险次数
		DAARegistViewHelper dAARegistViewHelper = new DAARegistViewHelper();
		dAARegistViewHelper.getSamePolicyRegistInfo(httpServletRequest,
				prpLcheckDto.getPolicyNo(), prpLcheckDto.getRegistNo());
		
		//设置主查勘信息内容到窗体表单
		//如果是三者车辆，那么因为不保存，又要通过校验，所以必须在特定域中放如初始化的数值
		/*
		 * if
		 * ((prpLcheckDto.getRiskCode().equals(BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA")))&&!insureCarFlag.equals("1")) {
		 * prpLcheckDto.setCheckSite("0 "); prpLcheckDto.setChecker1("0");
		 * prpLcheckDto.setChecker2("0 ");
		 * 
		 * }else {//默认值 prpLcheckDto.setInsureCarFlag("1");
		 * prpLcheckDto.setReferSerialNo(1); }
		 */
		//设置各个子表信息项到窗体表单
		CheckDto checkDto = new CheckDto();
		/*
		 * ArrayList arraylist1= new ArrayList();
		 * if(registDto.getPrpLthirdPartyDtoList() != null) {
		 * arraylist1.add(registDto.getPrpLthirdPartyDtoList().get(0)); }
		 */
		checkDto.setPrpLthirdPartyDtoList(registDto.getPrpLthirdPartyDtoList());
		checkDto.setPrpLdriverDtoList(registDto.getPrpLdriverDtoList());
		checkDto.setPrpLpersonTraceDtoList(registDto
				.getPrpLpersonTraceDtoList());
		checkDto.setPrpLthirdCarLossDtoList(registDto
				.getPrpLthirdCarLossDtoList());
		checkDto.setPrpLthirdPropDtoList(registDto.getPrpLthirdPropDtoList());
		checkDto.setPrpLregistExtDtoList(registDto.getPrpLregistExtDtoList());
		//modify by luqin add 2005-06-21 start
		checkDto.setPrpLregistTextDtoList(registDto.getPrpLregistTextDtoList());
		//modify by luqin add 2005-06-21 end
		
		//modify by wangli add start 20050408
		//保存特别约定信息
		checkDto.setPrpLcheckDto(prpLcheckDto);
		//modify by wangli add end 20050408
		
		//Modify by chenrenda add begin 20050418
		//Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
		String strPrpLnodeType = "check";
		httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
		//Modify by chenrenda add end 20050418
		
		 CheckDto checkDtoTemp = uiCheckAction.findByPrimaryKey(registNo);
		 checkDto.setPrpLcheckLossDtoList(checkDtoTemp.getPrpLcheckLossDtoList());

		//设置各个子表中的信息和显示
		setSubInfo(httpServletRequest, checkDto);
		
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
		
		//获取定损信息
		DAACertainLossViewHelper daaCertainLossViewHelper = new DAACertainLossViewHelper();
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
		daaCertainLossViewHelper.registDtoToView(httpServletRequest, registNo,
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		
		
		//在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLcheckDto.getRiskCode(), true));
		
		String policyNo = prpLcheckDto.getPolicyNo();
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
				registDto.getPrpLregistDto().getDamageStartDate().toString(),
				registDto.getPrpLregistDto().getDamageStartHour());
		if (policyDto != null) {
			httpServletRequest.setAttribute("coinsFlag", policyDto
					.getPrpCmainDto().getCoinsFlag());
			httpServletRequest.setAttribute("shareHolderFlag", policyDto
					.getPrpCmainDto().getShareHolderFlag());
		}
		//add by qinyongli 2005-8-30 start
		//reason:增加货运险扩展信息
		 strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLcheckDto.getRiskCode());
		if ("Y".equals(strRiskType)) {
    		PrpLextDto prpLextDto = new PrpLextDto();
			String itemAll = "";
			//查询联系方式 1.被保险人2.投保人
			if (policyDto != null) {
				ArrayList insuredList = policyDto.getPrpCinsuredDtoList();
				if (insuredList != null && insuredList.size() > 0) {
					Iterator insured = insuredList.iterator();
					while (insured.hasNext()) {
						PrpCinsuredDto prpCinsuredDto = (PrpCinsuredDto) insured
						.next();
						if (prpCinsuredDto.getInsuredFlag().equals("1")
								&& !prpCinsuredDto.getPhoneNumber().equals("")) {//被保险人
							prpLextDto.setInsuredPhone(prpCinsuredDto
									.getPhoneNumber());
						} else if (prpCinsuredDto.getInsuredFlag().equals("2")
								&& !prpCinsuredDto.getPhoneNumber().equals("")) {//投保人
							prpLextDto.setAppliPhone(prpCinsuredDto
									.getPhoneNumber());
						}
					}
					
				}
				prpLextDto.setSailStartDate(policyDto.getPrpCmainDto()
						.getStartDate());//起运日期，取起保日期
				prpLextDto.setSumAmount(String.valueOf(policyDto
						.getPrpCmainDto().getSumAmount())); //保额，从保单带入
				
				prpLextDto.setCargoValue(policyDto.getPrpCmainDto()
						.getSumValue()); //货价
				String rootComName = AppConfig.get("sysconst.ROOTCOMCNAME");
				prpLextDto.setPrpCompanyName(rootComName);
				ArrayList itemKind = policyDto.getPrpCitemKindDtoList();
				if (itemKind != null && itemKind.size() > 0) {
					Iterator item = itemKind.iterator();
					
					while (item.hasNext()) {
						PrpCitemKindDto itemKindDto = (PrpCitemKindDto) item
						.next();
						itemAll = itemAll + itemKindDto.getItemDetailName();
						double account = itemKindDto.getQuantity();
						String model = itemKindDto.getModel();
						if (account > 0) {
							itemAll = itemAll + "; 共" + account + model;
						}
						prpLextDto.setLimitAmount(String.valueOf(itemKindDto
								.getDeductible())); //免赔额
						break;
					}
					if (itemAll.length() > 29) {
						itemAll = itemAll.substring(0, 28);
					}
				}
				prpLextDto.setValue1(itemAll); //保险标的
				//modify by wuxiaodong 050905 begai reasion
				// 由于业务对运输方式及工具的存储字段不唯一，所以在此处要做一个处理
				PrpCmainCargoDto prpCmainCargoDto = policyDto
				.getPrpCmainCargoDto();
				if("Y".equals(strRiskType)&&prpCmainCargoDto==null){
					prpCmainCargoDto = new PrpCmainCargoDto();
					prpCmainCargoDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
					prpCmainCargoDto.setEndSiteName("_____");
					prpCmainCargoDto.setEndSiteCode("");
					prpCmainCargoDto.setStartSiteCode("");
					prpCmainCargoDto.setStartSiteName("_____");
				}
				prpLextDto.setValue3(prpCmainCargoDto.getInvoiceNo()); //发票号码
				prpLextDto.setRemark(prpCmainCargoDto.getLadingNo() 
						+ prpCmainCargoDto.getCarryBillNo());
				if (prpCmainCargoDto != null) {
					if (prpCmainCargoDto.getBLNo() == null
							|| prpCmainCargoDto.getBLNo() == "") {
						prpCmainCargoDto
						.setBLNo(uiCodeAction.translateCodeCode(
								"ConveyanceType", prpCmainCargoDto
								.getConveyance(), true));
					}
				}
				prpLextDto.setValue2(String.valueOf(registDto
						.getPrpLregistDto().getEstimateLoss())); //估损金额
				prpLextDto.setCurrency("CNY");
				prpLextDto.setCurrencyCname("人民币");
				httpServletRequest.setAttribute("prpLcarGoDto",
						prpCmainCargoDto);
				//modify by wuxiaodong 050905 end
			}
			httpServletRequest.setAttribute("prpLextDto", prpLextDto);
		}
		
		//add end by qinyongli
		//////////
	}
	
	/**
	 * 根据赔案号和报案号查询查勘信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            赔案号
	 * @param claimNo
	 *            报案号
	 * @throws Exception
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo) throws Exception {
		logger.info("根据赔案号和报案号查询查勘信息 == DAACheckViewHelper -- setPrpLcheckDtoToView");
		//checkNo,policyNo,claimNo
		//根据输入的保单号，查勘号生成SQL where 子句
		policyNo = StringUtils.rightTrim(policyNo);
		registNo = StringUtils.rightTrim(registNo);
		String conditions = "";
		conditions = " registNo = '" + registNo + "' and policyNo = '" + policyNo + "'";
		//查询预赔信息
		UICheckAction uiCheckAction = new UICheckAction();
		
		//得到多行查勘主表信息
		Collection checkList = new ArrayList();
		checkList = (Collection) uiCheckAction.findByConditions(conditions);
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
		//设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest);
	}
	
	//add by zhaolu 20060802 start
	//reason:增加分页查询
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto,String pageNo,String recordPerPage) throws Exception {
		//根据输入的保单号，查勘号生成SQL where 子句
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		int intPageNo = Integer.parseInt(pageNo);
		int intRecordPerPage = Integer.parseInt(recordPerPage);
		String conditions = " 1=1 ";
		//添加区分新农险标识
		conditions = conditions +" and a.registno in (select registno from swflog where (systemflag is null or systemflag <> 'agri') and nodetype='check') "; 
		conditions = conditions
		+ StringConvert.convertString("a.registNo", registNo,
				workFlowQueryDto.getRegistNoSign());
		conditions = conditions
		+ StringConvert.convertString("a.claimNo", claimNo,
				workFlowQueryDto.getClaimNoSign());
		//从session里取扶贫/大户标志
        String strHPflag = (String)httpServletRequest.getSession().getAttribute("flag");
        if(strHPflag != null && !strHPflag.equals("") && !strHPflag.equals("null")) {
      	  if(strHPflag.equals("Large")) {
      		  conditions = conditions +  " and a.policyno in (select policyno from prpcmain where policytype in('H24', 'I28', 'E2', 'Q2'))";
      	  }
            if(strHPflag.equals("Retaol")) {
          	  conditions = conditions +  " and a.policyno in (select policyno from prpcmain where policytype in('H23', 'I27', 'E1', 'Q1'))";
      	  }
        }
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//添加被保险人查询条件 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("c.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			//拼案件状态			
			int newIndex = 0;
			String statusTemp = "";
			while(true){
				if((newIndex = status.trim().indexOf(",")) != -1){
					statusTemp += status.trim().substring(0,newIndex) + "','";
					status =status.trim().substring(newIndex + 1,status.trim().length());					
				}else{
					break;
				}
			}
			status = statusTemp + status;			
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
			+ StringConvert.convertDate("b.operateDate", operateDate,
					workFlowQueryDto.getOperateDateSign());
		}
		
		
	    // 拼权限
		//modify by zhaolu 20060816 start
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by zhaolu 20060816 end
		//modify by wangwei add start 2005-06-13
		//原因：需要根据不同的条件查询意键险和非意健险
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by  都邦项目组  孙兆云  27险类修改为07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		
		//modify by wangwei add end 2005-06-13    
		
		//     因为prplcheck表中无comcode字段，不符合使用addPower的条件，所以使用报案表prpLregist关联控制
		//modify by zhaolu 20060816 start
		
		conditions = conditions
	   	+ " and ( 1=1 " +uiPowerInterface.addPower(userDto,"gg","","handledept");
		conditions = conditions
		+ uiPowerInterface.addPower(userDto,"gg","","comcode").replaceFirst("AND", "or") + ")";
		//modify by zhaolu 20060816 end

		String condition = httpServletRequest.getParameter("condition");
		if(condition != null)
		{
			conditions = condition;
		}
		
		//查询预赔信息
		UICheckAction uiCheckAction = new UICheckAction();
		
		//得到多行查勘主表信息
		ArrayList checkList = new ArrayList();
		//Collection checkList = new ArrayList();
		
		PageRecord pageRecord = null;
		
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//原因：意健险和非意健险查询不同的表
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//checkList = (Collection) uiCheckAction
			//.findByQueryConditionsAcci(conditions);
			pageRecord = (PageRecord)uiCheckAction.findByQueryConditionsAcci(conditions,intPageNo,intRecordPerPage);
			checkList = (ArrayList)pageRecord.getResult();
			
		} else {
			
			//checkList = (Collection) uiCheckAction
			//.findByQueryConditions(conditions);
			pageRecord = (PageRecord)uiCheckAction.findByQueryConditions(conditions,intPageNo,intRecordPerPage);
			checkList = (ArrayList)pageRecord.getResult();
		}
		//modify by wangwei add end 2005-06-18
		TurnPageDto turnPageDto = new TurnPageDto();
		turnPageDto.setResultList(checkList);
		turnPageDto.setPageNo(pageRecord.getPageNo());
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		turnPageDto.setTotalCount(pageRecord.getCount());
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		turnPageDto.setCondition(conditions);
		System.out.println("end search,please waiting for result...");
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		prpLcheckDto.setTurnPageDto(turnPageDto);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	//add by zhaolu 20060802 end
	
	
	/**
	 * 根据PrpCheckDto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param checkDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setSubInfo(HttpServletRequest httpServletRequest,
			CheckDto checkDto) throws Exception {
		
		//给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto.setRegistNo(checkDto.getPrpLcheckDto().getRegistNo());
		prpLregistExtDto.setRiskCode(checkDto.getPrpLcheckDto().getRiskCode());
		arrayListRegistExt = checkDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
		
		//[查勘报告]给报案文件多行列表准备数据
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (checkDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = checkDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
				.next();
				tempContext = tempContext + prpLregistTextDtoTemp.getContext();
			}
		}
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("3");
		httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
		
		//[涉案车辆]给三者车辆多行列表准备数据
		Collection arrayList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
		arrayList = checkDto.getPrpLthirdPartyDtoList();
		prpLthirdPartyDto.setThirdPartyList(arrayList);
		prpLthirdPartyDto.setNodeType("check");
		httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);
		
		//[驾驶员]给驾驶员多行多行列表准备数据
		Collection arrayListDriver = new ArrayList();
		PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
		arrayListDriver = checkDto.getPrpLdriverDtoList();
		prpLdriverDto.setDriverList(arrayListDriver);
		httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
		
		//[查勘信息]查勘报告多行列表准备数据
		/*
		 * Collection arrayLTextList = new ArrayList(); PrpLregistTextDto
		 * prpLregistTextDto = new PrpLregistTextDto();
		 * prpLregistTextDto.setTextType("3") ; arrayLTextList =
		 * checkDto.getPrpLregistTextDtoList() ;
		 * prpLregistTextDto.setRegistTextList(arrayLTextList) ;
		 * httpServletRequest.setAttribute("prpLregistTextDto",
		 * prpLregistTextDto);
		 */
		//查勘扩展信息多行列表准备数据
		Collection arrayList1 = new ArrayList();
		PrpLcheckExtDto prpLcheckExtDto = new PrpLcheckExtDto();
		arrayList1 = checkDto.getPrpLcheckExtDtoList();
		prpLcheckExtDto.setPrpLcheckExtList(arrayList1);
		httpServletRequest.setAttribute("prpLcheckExtDto", prpLcheckExtDto);
		
		//事故估损金额多行列表准备数据
		ArrayList arrayList2 = new ArrayList();
		PrpLcheckLossDto prpLcheckLossDto = new PrpLcheckLossDto();
		arrayList2 = checkDto.getPrpLcheckLossDtoList();
		if (arrayList2 != null) {
			for (int indexCheck = 0; indexCheck < arrayList2.size(); indexCheck++) {
				PrpLcheckLossDto prpLcheckLossDto1 = new PrpLcheckLossDto();
				prpLcheckLossDto1 = (PrpLcheckLossDto) arrayList2
				.get(indexCheck);
				
				UICodeAction uiCodeAction = new UICodeAction();
				//对险别进行转换
				String kindCode = prpLcheckLossDto1.getKindCode();
				String riskcode = checkDto.getPrpLcheckDto().getRiskCode();
		        //转成对应的商业险险险种号
		        TransCodeCI transCodeCI = new TransCodeCI();
		        String busiRiskCode = transCodeCI.convertToRiskCodeBusi(riskcode);
				String kindName = uiCodeAction.translateKindCode(
						busiRiskCode, kindCode, true);
				prpLcheckLossDto1.setKindName(kindName);
			}
		}
		prpLcheckLossDto.setPrpLcheckLossList(arrayList2);
		httpServletRequest.setAttribute("prpLcheckLossDto", prpLcheckLossDto);
		
		//给人员伤亡跟踪多行多行列表准备数据
		Collection arrayListPersonTrace = new ArrayList();
		PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();
		arrayListPersonTrace = checkDto.getPrpLpersonTraceDtoList();
		prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace);
		prpLpersonTraceDto.setNodeType("check");
		//Modify by chenrenda 20050409 begin
		
		if (checkDto.getPrpLpersonTraceDtoList() != null) {
			Iterator personTraceDtoList = arrayListPersonTrace.iterator();
			while (personTraceDtoList.hasNext()) {
				PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto) personTraceDtoList
				.next();
				String strReferKind = prplpersonTraceDto.getReferKind();
				prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);
			}
		}
		//Modify by chenrenda 20050409 end
		
		httpServletRequest.setAttribute("prpLpersonTraceDto",
				prpLpersonTraceDto);
		
		//modify by wangli add start 20050407
		//查询保单信息 显示特别约定列表
		String policyNo = checkDto.getPrpLcheckDto().getPolicyNo();
		ArrayList itemKindList = new ArrayList();
		Collection itemKindListNew = new ArrayList();
		//根据保单号查询特别约定信息
		String registNo = checkDto.getPrpLcheckDto().getRegistNo();
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		
		//判断是否关联
		BLPrpLRegistRPolicyFacade blRegistRPolicy = new BLPrpLRegistRPolicyFacade();
		boolean compelFlag = blRegistRPolicy.getCompelFlag(registNo);
		if (compelFlag){
           httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		}

		if (!policyNo.equals("") && policyNo != null) {
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(
					policyNo, registDto.getPrpLregistDto().getDamageStartDate()
					.toString(), registDto.getPrpLregistDto()
					.getDamageStartHour());
			
			itemKindList = policyDto.getPrpCitemKindDtoList();
			checkDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
		}
		//特别约定信息多行列表准备数据
		Collection cengageList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		cengageList = checkDto.getPrpCengageDtoList();
		ArrayList cengageListTemp = new ArrayList();
		if (cengageList != null) {
			Iterator iteratorCengage = cengageList.iterator();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
				.next();
				if (prpCengageDtoTemp.getClauseCode() != null
						&& prpCengageDtoTemp.getClauseCode().length() > 0
						&& prpCengageDtoTemp.getClauseCode().charAt(0) == 'T') {
					cengageListTemp.add(prpCengageDtoTemp);
				}
			}
			boolean cFlag = false;
			cengageList = new ArrayList();
			cengageList.addAll(cengageListTemp);
			cengageListTemp = new ArrayList();
			iteratorCengage = cengageList.iterator();
			PrpCengageDto prpCengageDtoTemp1 = new PrpCengageDto();
			while (iteratorCengage.hasNext()) {
				PrpCengageDto prpCengageDtoTemp = (PrpCengageDto) iteratorCengage
				.next();
				if (prpCengageDtoTemp.getTitleFlag().equals("0")) {
					cFlag = true;
					cengageListTemp.add(prpCengageDtoTemp1);
					prpCengageDtoTemp1 = new PrpCengageDto();
					PropertyUtils.copyProperties(prpCengageDtoTemp1,
							prpCengageDtoTemp);
				} else {
					prpCengageDtoTemp1.setContext(prpCengageDtoTemp1
							.getContext()
							+ prpCengageDtoTemp.getClauses() + "<br>");
				}
			}
			cengageListTemp.add(prpCengageDtoTemp1);
			if (cengageListTemp.size() > 0) {
				cengageListTemp.remove(0);
			}
		}
		prpCengageDto.setPrpCengageList(cengageListTemp);
		httpServletRequest.setAttribute("prpCengageDto", prpCengageDto);
		//modify by wangli add end 20050407
		
		//Modify by chenrenda add 20050409 begin
		//Reason:人伤跟踪信息模块中涉及险种以列表框多选形式显示
		//将险别名称改成D1-车上人员责任险的方式,只包括三者险与车上人员责任险
		
		Collection prpLcheckInsuredItemKindNew = new ArrayList();
		Collection prpLcheckThirdItemKindNew = new ArrayList();
		/*------------------------------------------
		for (int i = 0; i < itemKindList.size(); i++) {
			PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) itemKindList
			.get(i);
			prpCitemKindDto.setKindName(prpCitemKindDto.getKindCode() + "-"
					+ prpCitemKindDto.getKindName());
			if (prpCitemKindDto.getKindCode().equalsIgnoreCase("B")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("D3")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("D4")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("A")
					|| prpCitemKindDto.getKindCode().equalsIgnoreCase("BZ")) {
				itemKindListNew.add(prpCitemKindDto);
			}
			prpLcheckItemKindNew.add(prpCitemKindDto);
		}------------------------------------------------*/
	
		if (compelFlag){//如果关联
			String mainPolicyNo ="";	
			PrpLRegistRPolicyDto prpLregistRPolicyDto=(PrpLRegistRPolicyDto) httpServletRequest.getAttribute("prpLregistRPolicyNo");
			if ( prpLregistRPolicyDto !=null){
				mainPolicyNo =prpLregistRPolicyDto.getPolicyNo();
			}
			EndorseViewHelper  endorseViewHelper =new EndorseViewHelper();
			if ( mainPolicyNo !=null && !mainPolicyNo.equals("")  && !policyNo.equals(mainPolicyNo)){	//暂时这样， 
				PolicyDto mainPolicyDto = endorseViewHelper.findForEndorBefore(mainPolicyNo);
				ArrayList itemKindList_qs = mainPolicyDto.getPrpCitemKindDtoList();
				for(int index = 0;index < itemKindList_qs.size();index++){
					PrpCitemKindDto  prpCitemKindDto_qs = (PrpCitemKindDto)itemKindList_qs.get(index);
					itemKindList.add(prpCitemKindDto_qs);
				}
			}
		}
		itemKindListNew = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList);
		Collection prpLcheckItemKindNew = new ArrayList();
		Collection prpLcheckPropItemKindNew = new ArrayList();
		prpLcheckPropItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("ThirdPropLoss",itemKindList);
		prpLcheckItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("MainCarLoss",itemKindList);
		prpLcheckThirdItemKindNew =BusinessRuleUtil.getReferItemKindListByKindType("ThirdCarLoss",itemKindList);
		prpLcheckItemKindNew.addAll(prpLcheckThirdItemKindNew);
		httpServletRequest.setAttribute("referKindList", itemKindListNew);
		httpServletRequest.setAttribute("prpLcheckPropItemKindList", prpLcheckPropItemKindNew);
		httpServletRequest.setAttribute("prpLcheckItemKindList",
				prpLcheckItemKindNew); 
		
		
				
		//Modify by chenrenda add 20050409 end
		
		//Modify by chenrenda add begin 20050408
		//Reason:损失部位模块合到涉到车辆信息中后，其它相应模块做调整
		//给损失部位多行多行列表准备数据
		Collection arrayListThirdCarLoss = new ArrayList();
		PrpLthirdCarLossDto prpLthirdCarLossDto = new PrpLthirdCarLossDto();
		arrayListThirdCarLoss = checkDto.getPrpLthirdCarLossDtoList();
		prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss);
		httpServletRequest.setAttribute("prpLthirdCarLossDto",
				prpLthirdCarLossDto);
		
		//Reason:损失部位显示改为列表框方式
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());
		//Modify by chenrenda add end 20050408
		
		//Modify by chenrenda add begin 20050412
		//Reason:在查勘页面中加上其它损失模块
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = checkDto.getPrpLthirdPropDtoList();
		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		//prpLthirdPropDto.setPrpLthirdPropKindCode("B");
		httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);
		
		//Modify by chenrenda add end 20050412
		
	}
	
	/**
	 * 获取选择框和列表框中的所有内容
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLcheckDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLcheckDto prpLcheckDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		
		//查勘性质列表
		Collection checkNatures = uiCodeAction.getCodeType("CheckNature",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("checkNatures", checkNatures);
		//赔案类别
		Collection caseCodes = uiCodeAction.getCodeType("CaseCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("caseCodes", caseCodes);
		//出险地点分类
		Collection damageAddresss = uiCodeAction.getCodeType("DamageAddress",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("damageAddresss", damageAddresss);
		//事故赔偿责任
		Collection indemnityDutys = uiCodeAction.getCodeType("IndemnityDuty",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("indemnityDutys", indemnityDutys);
		
		//得到实赔类型列表
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		//得到案件种类列表列表
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		//得到出险地址类型列表
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", BusinessRuleUtil.getOuterCode(
						httpServletRequest, "RISKCODE_DAA"));
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		//得到车辆种类列表
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		//得到车牌底色列表
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
		//得到赔偿责任列表
		Collection indemnityDuty = uiCodeAction.getCodeType("IndemnityDuty",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("indemnityDutys", indemnityDuty);
		//得到赔案类别列表
		Collection escapeFlags = uiCodeAction.getCodeType("CaseCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("escapeFlags", escapeFlags);
		//得到得到性别
		Collection driverSex = uiCodeAction.getCodeType("SexCode",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("driverSexs", driverSex);
		//得到职业分类
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		//得到文化程度
		Collection education = uiCodeAction.getCodeType("Education",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("educations", education);
		//得到证件类型
		Collection identifyTypes = uiCodeAction.getCodeType("IdentifyType",
				BusinessRuleUtil.getOuterCode(httpServletRequest,
				"RISKCODE_DAA"));
		httpServletRequest.setAttribute("identifyTypes", identifyTypes);
	}
	
	/**
	 * 根据PrpCheckDto中的已经设置的代码内容，对代码进行名称转换
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLcheckDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLcheckDto prpLcheckDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		//(1)条款名称的转换
		String clauseType = prpLcheckDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLcheckDto.setClauseName(clauseName);
		prpLcheckDto.setDamageAreaName(uiCodeAction.translateCodeCode(
				"DamageAreaCode", prpLcheckDto.getDamageAreaCode(), true));
		
		//(2)处理部门的中文转换
		String strHandleUnit = prpLcheckDto.getHandleUnit();
		String strHandleUnitName = uiCodeAction.translateComCode(strHandleUnit,
				true);
		
		//System.out.println("strHandleUnitName
		// =================================="+strHandleUnitName );;
		prpLcheckDto.setHandleUnitName(strHandleUnitName);
	}
	
	public void getCheckScheduleDtoToView(HttpServletRequest httpServletRequest)
	throws Exception {
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		// 目的是取得没有被处理完毕的调度任务，然后list出来。
		Collection scheduleDtoList = new ArrayList();
		UICheckAction uiCheckAction = new UICheckAction();
		//查找符合条件的调度任务
		String conditions = "";
		//conditions = " CheckFlag='0' order by registNo,scheduleid " ;
		conditions = " selectSend='1' and insurecarflag='1' order by registNo,scheduleid";
		
		System.out.println("搜索前.");
		scheduleDtoList = (Collection) uiCheckAction
		.findNewScheduleTaskList(conditions);
		System.out.println("搜索后." + scheduleDtoList.toString());
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		
		scheduleDtoList = changeOperatorCodeToName(scheduleDtoList);
		prpLcheckItemDto.setCheckItemList(scheduleDtoList);
		// prpLcheckItemDto.setCheckOperatorCode(user.getUserCode() );
		//将查询出来的 任务列表放到界面上显示
		// httpServletRequest.setAttribute("prpLscheduleMainWFDto",prpLscheduleMainWFDto)
		// ;
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
		
	}
	
	private Collection changeOperatorCodeToName(Collection scheduleList)
	throws Exception {
		Collection scheduleListChange = new ArrayList();
		Iterator it = scheduleList.iterator();
		UICodeAction uiCodeAction = new UICodeAction();
		
		String operatorCode = "";
		String operatorName = "";
		while (it.hasNext()) {
			PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
			prpLcheckItemDto = (PrpLcheckItemDto) it.next();
			operatorCode = prpLcheckItemDto.getOperatorCode();
			operatorName = uiCodeAction.translateUserCode(operatorCode, true);
			prpLcheckItemDto.setOperatorName(operatorName);
			scheduleListChange.add(prpLcheckItemDto);
		}
		return scheduleListChange;
	}
	
	public void getCheckScheduleDealDtoToView(
			HttpServletRequest httpServletRequest, String registNo,
			String scheduleID) throws Exception {
		
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		int intscheduleID = Integer.parseInt(scheduleID);
		
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//根据查询出来的数据内容，给PrpLscheduleDto赋值
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		
		//设置扩展属性
		prpLscheduleMainWFDto.setLinkerName(registDto.getPrpLregistDto()
				.getLinkerName());
		prpLscheduleMainWFDto.setPhoneNumber(registDto.getPrpLregistDto()
				.getPhoneNumber());
		//prpLscheduleMainWFDto.setOperatorName(user.getUserName() );
		if (registDto.getPrpLregistTextDtoList() != null) {
			PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
			prpLregistTextDto = (PrpLregistTextDto) registDto
			.getPrpLregistTextDtoList().iterator().next();
			prpLscheduleMainWFDto.setRegistText(prpLregistTextDto.getContext());
		}
		
		//设置查勘操作的状态为 案件修改 (正处理任务)
		if (scheduleDto.getPrpLclaimStatusDto() != null) {
			prpLscheduleMainWFDto.setStatus(scheduleDto
					.getPrpLscheduleMainWFDto().getStatus());
		} else {
			//已提交，已经处理完毕的状态
			prpLscheduleMainWFDto.setStatus("4");
		}
		
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//设置相关代码的中文转换
		//changeCodeToName(httpServletRequest,scheduleDto);
		//设置窗体表单中各个多选框中列表信息的内容
		// setSelectionList(httpServletRequest,scheduleDto);
		//设置主查勘信息内容到窗体表单
		httpServletRequest.setAttribute("prpLscheduleMainWFDto",
				prpLscheduleMainWFDto);
		//设置各个子表信息项到窗体表单
		setCheckItemInfo(httpServletRequest, scheduleDto);
	}
	
	/**
	 * 根据Dto中的各子表内的信息填充界面
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param scheduleDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setCheckItemInfo(HttpServletRequest httpServletRequest,
			ScheduleDto scheduleDto) throws Exception {
		ArrayList checkItemList = new ArrayList();
		checkItemList = scheduleDto.getPrpLcheckItemDtoList();
		/*
		 * Iterator it = scheduleItemList.iterator() ; int i =1;
		 * 
		 * while (it.hasNext() ) { PrpLscheduleItemDto prpLscheduleItemDto =new
		 * PrpLscheduleItemDto(); prpLthirdPartyTempDto
		 * =(PrpLthirdPartyDto)it.next() ; prpLscheduleItemDto.setScheduleID
		 * (scheduleDto.getPrpLscheduleMainWFDto().getScheduleID() );
		 * prpLscheduleItemDto.setRegistNo
		 * (scheduleDto.getPrpLscheduleMainWFDto().getRegistNo());
		 * prpLscheduleItemDto.setItemNo (i);
		 * prpLscheduleItemDto.setInsureCarFlag
		 * (prpLthirdPartyTempDto.getInsureCarFlag ());
		 * prpLscheduleItemDto.setClaimComCode
		 * (scheduleDto.getPrpLscheduleMainWFDto().getClaimComCode ());
		 * //prpLscheduleItemDto.setSelectSend ("0");
		 * //prpLscheduleItemDto.setSurveyTimes ();
		 * //prpLscheduleItemDto.setSurveyType
		 * (prpLthirdPartyTempDto.getSurveyType ());
		 * //prpLscheduleItemDto.setCheckSite
		 * (prpLthirdPartyTempDto.getCheckSite ());
		 * prpLscheduleItemDto.setLicenseNo (prpLthirdPartyTempDto.getLicenseNo
		 * ()); //prpLscheduleItemDto.setScheduleObjectID
		 * (prpLthirdPartyTempDto.getScheduleObjectID ());
		 * //prpLscheduleItemDto.setScheduleObjectName
		 * (prpLthirdPartyTempDto.getScheduleObjectName());
		 * prpLscheduleItemDto.setInputDate (new
		 * DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY)); //
		 * prpLscheduleItemDto.setResultInfo
		 * (prpLthirdPartyTempDto.getResultInfo ()); //
		 * prpLscheduleItemDto.setBookFlag (prpLthirdPartyTempDto.getBookFlag
		 * ()); // prpLscheduleItemDto.setScheduleType
		 * (prpLthirdPartyTempDto.getScheduleType ()); //加入集合
		 * scheduleItemList.add(prpLscheduleItemDto); i++; }
		 */
		scheduleDto.setPrpLscheduleItemDtoList(checkItemList);
		PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
		prpLcheckItemDto.setCheckItemList(checkItemList);
		httpServletRequest.setAttribute("prpLcheckItemDto", prpLcheckItemDto);
	}
	
	/**
	 * 保存查勘时查勘页面数据整理.
	 * 
	 * @param httpServletRequest
	 * @return scheduleDto 查勘数据传输数据结构
	 * @throws Exception
	 */
	public ScheduleDto checkViewToDto(HttpServletRequest httpServletRequest)
	throws Exception {
		//取得当前用户信息，写操作员信息到查勘中
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String registNo = httpServletRequest
		.getParameter("prpLscheduleMainWFRegistNo"); //报案号
		String scheduleID = httpServletRequest
		.getParameter("prpLscheduleMainWFScheduleID"); //调度号
		String prpLscheduleMainWFCheckFlag = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckFlag"); //查勘状态
		String prpLscheduleMainWFCheckInfo = httpServletRequest
		.getParameter("prpLscheduleMainWFCheckInfo"); //查勘情况内容
		//String prpLscheduleMainWFCheckInputDate=
		String prpLscheduleMainWFCheckOperatorCode = user.getUserCode();
		int intscheduleID = Integer.parseInt(scheduleID);
		
		//首先从数据库中取得调度的所有信息
		UIScheduleAction uiScheduleAction = new UIScheduleAction();
		ScheduleDto scheduleDto = uiScheduleAction.findByPrimaryKey(
				intscheduleID, registNo);
		
		//根据查询出来的数据内容，给PrpLscheduleDto赋值
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = new PrpLscheduleMainWFDto();
		prpLscheduleMainWFDto = scheduleDto.getPrpLscheduleMainWFDto();
		prpLscheduleMainWFDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
		prpLscheduleMainWFDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
		prpLscheduleMainWFDto.setCheckInputDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLscheduleMainWFDto
		.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
		scheduleDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		
		//-------------完成主表控制-------------------------------
		ArrayList checkItemList = new ArrayList();
		ArrayList checkItemListTemp = new ArrayList();
		checkItemListTemp = scheduleDto.getPrpLcheckItemDtoList();
		Iterator it = checkItemListTemp.iterator();
		while (it.hasNext()) {
			PrpLcheckItemDto prpLcheckItemDto = new PrpLcheckItemDto();
			prpLcheckItemDto = (PrpLcheckItemDto) it.next();
			prpLcheckItemDto.setCheckFlag(prpLscheduleMainWFCheckFlag);
			prpLcheckItemDto.setCheckInfo(prpLscheduleMainWFCheckInfo);
			//prpLcheckItemDto.setInputDate(new
			// DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
			prpLcheckItemDto
			.setCheckOperatorCode(prpLscheduleMainWFCheckOperatorCode);
			//加入查勘标的集合
			checkItemList.add(prpLcheckItemDto);
		}
		// 调度集合中修改查勘标的
		scheduleDto.setPrpLcheckItemDtoList(checkItemList);
		return scheduleDto;
	}
	
	/**
	 * 根据赔案号,报案号,案件状态，车牌号码，操作时间查询查勘信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param claimNo
	 *            赔案号
	 * @param registNo
	 *            报案号
	 * @param licenseNo
	 *            车牌号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */
	
	public void setPrpLcheckDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto) throws Exception {
		//根据输入的保单号，查勘号生成SQL where 子句
		String claimNo = StringUtils.rightTrim(workFlowQueryDto.getClaimNo());
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName());
		String conditions = " 1=1 ";
		conditions = conditions
		+ StringConvert.convertString("a.registNo", registNo,
				workFlowQueryDto.getRegistNoSign());
		conditions = conditions
		+ StringConvert.convertString("a.claimNo", claimNo,
				workFlowQueryDto.getClaimNoSign());
		//add by zhouliu start at 2006-6-9
		//reason:强三查询
		conditions = conditions
		+ StringConvert.convertString("d.policyNo", policyNo, 
				workFlowQueryDto.getPolicyNoSign());
		//add by zhouliu end at 2006-6-9
		conditions = conditions
		+ StringConvert.convertString("c.LicenseNo", licenseNo,
				workFlowQueryDto.getLicenseNoSign());
		//添加被保险人查询条件 2006-04-12 miaowenjun
		conditions = conditions
				+ StringConvert.convertString("c.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in ('" + status + "')";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
			+ StringConvert.convertDate("b.operateDate", operateDate,
					workFlowQueryDto.getOperateDateSign());
		}
		//     拼权限
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
		.getAttribute("user");
		
		//modify by wangwei add start 2005-06-13
		//原因：需要根据不同的条件查询意键险和非意健险
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			//modify by   项目组  孙兆云  27险类修改为07
			conditions = conditions
			+ " and (b.riskcode like '07%' or b.riskcode like '26%')";
		} else {
			conditions = conditions
			+ " and b.riskcode not like '07%' and b.riskcode not like '26%'";
		}
		//modify by wangwei add end 2005-06-13    
		
		//     因为prplcheck表中无comcode字段，不符合使用addPower的条件，所以使用报案表prpLregist关联控制
		conditions = conditions
		+ uiPowerInterface.addPower(userDto,"c","","ComCode");
		
		//查询预赔信息
		UICheckAction uiCheckAction = new UICheckAction();
		
		//得到多行查勘主表信息
		Collection checkList = new ArrayList();
		System.out.println("start to search,please waiting ...");
		
		//modify by wangwei add start 2005-06-18
		//原因：意健险和非意健险查询不同的表
		if (httpServletRequest.getParameter("type") != null
				&& httpServletRequest.getParameter("type").equals("acci")) {
			checkList = (Collection) uiCheckAction
			.findByQueryConditionsAcci(conditions);
		} else {
			checkList = (Collection) uiCheckAction
			.findByQueryConditions(conditions);
		}
		//modify by wangwei add end 2005-06-18
		
		System.out.println("end search,please waiting for result...");
		PrpLcheckDto prpLcheckDto = new PrpLcheckDto();
		prpLcheckDto.setCheckList(checkList);
		System.out.println("finish add list");
		System.out.println("editType="
				+ httpServletRequest.getParameter("editType"));
		prpLcheckDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLcheckDto", prpLcheckDto);
	}
	
	/**
	 * 查询工作流可以用来选择的节点内容
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest)
	throws Exception {
		String modelNo = httpServletRequest.getParameter("modelNo"); //模板号
		String nodeNo = httpServletRequest.getParameter("nodeNo"); //节点号
		int nextNodeNo = 0;
		Collection pathList = new ArrayList();
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
		System.out.println("$$$$$$$$$$$$$$$$44" + modelNo + "++" + nodeNo);
		if (modelNo != null && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo, nodeNo);
			if (pathList.iterator().hasNext()) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) pathList.iterator().next();
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
			}
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}
	
}