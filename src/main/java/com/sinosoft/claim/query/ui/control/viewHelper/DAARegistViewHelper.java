package com.sinosoft.claim.query.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gyic.claim.bl.facade.BLHousepolicylistFacade;
import com.gyic.claim.bl.facade.BLPlantingpolicylistFacade;
import com.gyic.claim.bl.facade.BLZh03PolicyListFacade;
import com.gyic.claim.bl.facade.BLHerdpolicylistFacade;
import com.gyic.claim.bl.facade.BLInsuremainlistFacade;
import com.gyic.claim.bl.facade.BLPrplcombineFacade;
import com.gyic.claim.bl.facade.BLPrplcompensateearFacade;
import com.gyic.claim.dto.custom.EarLabelRegistDto;
import com.gyic.claim.dto.custom.FamilyNoRegistDto;
import com.gyic.claim.dto.custom.IdcardRegistDto;
import com.gyic.claim.dto.domain.HerdpolicylistDto;
import com.gyic.claim.dto.domain.InsuremainlistDto;
import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.bl.action.domain.BLPrpLregistExtAction;
import com.sinosoft.claim.bl.facade.BLPrpDcompanyFacadeBase;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistFacade;
import com.sinosoft.claim.bl.facade.BLPrpLregistTextFacade;
import com.sinosoft.claim.bl.facade.BLSwfLogFacade;
import com.sinosoft.claim.bl.facade.BLSwfNodeFacadeBase;
import com.sinosoft.claim.dto.custom.CompensateFeeDto;
import com.sinosoft.claim.dto.custom.EndorseDto;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.custom.RegistDto;
import com.sinosoft.claim.dto.custom.TurnPageDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowQueryDto;
import com.sinosoft.claim.dto.domain.PrpCcarDriverDto;
import com.sinosoft.claim.dto.domain.PrpCengageDto;
import com.sinosoft.claim.dto.domain.PrpCitemCarDto;
import com.sinosoft.claim.dto.domain.PrpCitemKindDto;
import com.sinosoft.claim.dto.domain.PrpCmainCargoDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpLRegistRPolicyDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLdriverDto;
import com.sinosoft.claim.dto.domain.PrpLextDto;
import com.sinosoft.claim.dto.domain.PrpLpersonTraceDto;
import com.sinosoft.claim.dto.domain.PrpLregistDto;
import com.sinosoft.claim.dto.domain.PrpLregistExtDto;
import com.sinosoft.claim.dto.domain.PrpLregistTextDto;
import com.sinosoft.claim.dto.domain.PrpLrelatePersonDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleItemDto;
import com.sinosoft.claim.dto.domain.PrpLscheduleMainWFDto;
import com.sinosoft.claim.dto.domain.PrpLthirdCarLossDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPartyDto;
import com.sinosoft.claim.dto.domain.PrpLthirdPropDto;
import com.sinosoft.claim.dto.domain.PrpPheadDto;
import com.sinosoft.claim.dto.domain.PrplregisthisDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfNodeDto;
import com.sinosoft.claim.dto.domain.SwfPathDto;
import com.sinosoft.claim.ui.control.action.ICollections;
import com.sinosoft.claim.ui.control.action.UIClaimAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompanyAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIConfigAction;
import com.sinosoft.claim.ui.control.action.UIEndorseAction;
import com.sinosoft.claim.query.ui.control.actioin.UIPolicyAction;
import com.sinosoft.claim.ui.control.action.UIPowerInterface;
import com.sinosoft.claim.ui.control.action.UIPrpLregistRPolicyAction;
import com.sinosoft.claim.query.ui.control.actioin.UIRegistAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.query.ui.control.viewHelper.EndorseViewHelper;
import com.sinosoft.claim.util.BusinessRuleUtil;
import com.sinosoft.claim.util.StringConvert;
import com.sinosoft.nyx.blsvr.BLPlantingPolicyList;
import com.sinosoft.nyx.schema.PlantingPolicyListSchema;
import com.sinosoft.prpall.blsvr.pg.BLPrpPheadSub;
import com.sinosoft.prpall.dbsvr.cb.DBPrpCitemCarExt;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.prpall.pubfun.TransCodeCI;
import com.sinosoft.reins.out.bl.facade.BLFcoRepolicyFacade;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.datatype.PageRecord;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.utility.SysConfig;
import com.sinosoft.utility.string.ChgDate;
import com.sinosoft.claim.bl.facade.*;
import com.sinosoft.nyx.blsvr.*;




/**
 * <p>
 * Title: RegistViewHelper
 * </p>
 * <p>
 * Description:报案ViewHelper类，在该类中完成页面数据的整理
 * </p>
 * <p>
 * Copyright: Copyright 中科软科技股份有限公司(c) 2004
 * </p>
 * 
 * @author 车险理赔项目组 weishixin
 * @version 1.0 <br>
 *          policyListToView方法中增加出险时间
 */
public class DAARegistViewHelper extends RegistViewHelper {
	private static Log logger = LogFactory.getLog(DAARegistViewHelper.class);

	private int RULE_LENGTH = 70; // rule字段的长度
	

	/**
	 * 默认构造方法
	 */
	public DAARegistViewHelper() {
	}

	/**
	 * 保存报案时报案页面数据整理. 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理。
	 * 
	 * @param httpServletRequest
	 * @return registDto 报案数据传输数据结构
	 * @throws Exception
	 */
	public RegistDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		// 继承对regist,registText表的赋值
		RegistDto registDto = super.viewToDto(httpServletRequest);
		
		/*add by lym 20060605 for 强三 ---start---关联表的存储-----------------*/
		//目前只存储了强三的单号
		PrpLRegistRPolicyDto  prpLRegistRPolicyDto =new PrpLRegistRPolicyDto();
		PrpLRegistRPolicyDto  prpLRegistRPolicyDto_comp =new PrpLRegistRPolicyDto();
		String registNo     = (String) httpServletRequest.getAttribute("registNo");
		String mainPolicyNo = (String) httpServletRequest.getParameter("mainPolicyNo");
		String quaryPolicyNo = (String) httpServletRequest.getParameter("quaryPolicyNo");
		String policyNo     = (String) httpServletRequest.getParameter("prpLregistPolicyNo");
		String prpLregistRPPolicyRiskCode     = (String) httpServletRequest.getParameter("prpLregistRiskCode");
		UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
		
		String flowId ="";
		ArrayList   prpLRegistRPolicyDtoList = new  ArrayList();
		if (policyNo !=null && !policyNo.equals("") && mainPolicyNo !=null && !mainPolicyNo.equals("")){
			
		
			if ( quaryPolicyNo!=null && !quaryPolicyNo.equals("") && quaryPolicyNo.equals(policyNo)){
				prpLRegistRPolicyDto.setRegistFlag("1");
			}else {
				prpLRegistRPolicyDto.setRegistFlag("0");
			}
			prpLRegistRPolicyDto.setRiskCode(prpLregistRPPolicyRiskCode);
			prpLRegistRPolicyDto.setRegistNo(registNo);	
			prpLRegistRPolicyDto.setPolicyNo(policyNo);
			prpLRegistRPolicyDto.setValidStatus("1");
			prpLRegistRPolicyDto.setRegistValidStatus("1");
			prpLRegistRPolicyDto.setOperatorCode(user.getUserCode());
			prpLRegistRPolicyDto.setRegistComCode(user.getComCode());
			prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
	                DateTime.YEAR_TO_SECOND));
			UICodeAction uiCodeAction = new UICodeAction();
			String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(prpLregistRPPolicyRiskCode);
			if ("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)||"RISKCODE_DAU".equals(strConfigCode)){	
			  prpLRegistRPolicyDto.setPolicyType("3");
			}else {
				prpLRegistRPolicyDto.setPolicyType("1");
			}
			prpLRegistRPolicyDtoList.add(prpLRegistRPolicyDto);
			
			if ( quaryPolicyNo!=null && !quaryPolicyNo.equals("") && quaryPolicyNo.equals(mainPolicyNo)){
				prpLRegistRPolicyDto_comp.setRegistFlag("1");
			}else {
				prpLRegistRPolicyDto_comp.setRegistFlag("0");
			}
			//取得强制保险的险种代码
	       	//String compelRiskCode=BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAZ");
	       	//System.out.println("RISKCODE_DAZ:"+compelRiskCode);	
	        //转成对应的交强险险种号
	        TransCodeCI transCodeCI = new TransCodeCI();
	        String compelRiskCode = mainPolicyNo.substring(1, 5);
			prpLRegistRPolicyDto_comp.setRiskCode(compelRiskCode);
			prpLRegistRPolicyDto_comp.setRegistNo(registNo);	
			prpLRegistRPolicyDto_comp.setPolicyNo(mainPolicyNo);
			prpLRegistRPolicyDto_comp.setValidStatus("1");
			prpLRegistRPolicyDto_comp.setRegistValidStatus("1");
			prpLRegistRPolicyDto_comp.setOperatorCode(user.getUserCode());
			prpLRegistRPolicyDto_comp.setRegistComCode(user.getComCode());
			prpLRegistRPolicyDto_comp.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
	                DateTime.YEAR_TO_SECOND));
			strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(compelRiskCode);
			if ("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)||"RISKCODE_DAU".equals(strConfigCode)){	
				prpLRegistRPolicyDto_comp.setPolicyType("3");
			}else {
				prpLRegistRPolicyDto_comp.setPolicyType("1");
			}
			prpLRegistRPolicyDtoList.add(prpLRegistRPolicyDto_comp);
			
		//	registDto.setPrpLRegistRPolicyList(prpLRegistRPolicyDtoList);
		}
		else {
			
			prpLRegistRPolicyDto.setPolicyNo(policyNo);
			prpLRegistRPolicyDto.setRegistNo(registNo);
			UICodeAction uiCodeAction = new UICodeAction();
			String strConfigCode = uiCodeAction.translateRiskCodetoConfigCode(prpLregistRPPolicyRiskCode);
			if ("RISKCODE_DAZ".equals(strConfigCode)||"RISKCODE_DAY".equals(strConfigCode)||"RISKCODE_DAU".equals(strConfigCode)){	
			  prpLRegistRPolicyDto.setPolicyType("3");
			}else {
				prpLRegistRPolicyDto.setPolicyType("1");
			}
			prpLRegistRPolicyDto.setRiskCode(prpLregistRPPolicyRiskCode);
			prpLRegistRPolicyDto.setRegistFlag("1");
			prpLRegistRPolicyDto.setValidStatus("1");
			prpLRegistRPolicyDto.setRegistValidStatus("1");
			prpLRegistRPolicyDto.setOperatorCode(user.getUserCode());
			prpLRegistRPolicyDto.setRegistComCode(user.getComCode());
			if(!"".equals(httpServletRequest.getParameter("prpLregistInputDate")))
			{
				ChgDate idate = new ChgDate();
				String	currentTime = idate.getCurrentTime(" HH:mm:ss");

	            if(httpServletRequest.getParameter("prpLregistInputDate").length()<12)
	            {
	            	prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate")+currentTime,
		                DateTime.YEAR_TO_SECOND));
	            }
	            else
	            {
	            	prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
			                DateTime.YEAR_TO_SECOND));
	            }
			}
			else
			{
				prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
	                    DateTime.YEAR_TO_DAY));
			}
//			prpLRegistRPolicyDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLregistInputDate"),
//	                DateTime.YEAR_TO_DAY));
			prpLRegistRPolicyDtoList.add(prpLRegistRPolicyDto);
		}
		registDto.setPrpLRegistRPolicyList(prpLRegistRPolicyDtoList);
		/*add by lym 20060605 for 强三 ---end---关联表的存储-----------------*/
		
	
		/*---------------------三者车辆prpLthirdParty------------------------------------*/
		ArrayList thirdPartyDtoList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = null;

		// 从界面得到输入数组
		String prpLthirdPartyRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
		String prpLthirdPartyRiskCode = httpServletRequest
				.getParameter("prpLregistRiskCode");
		String prpLthirdPartyClaimNo = httpServletRequest
				.getParameter("prpLregistClaimNo");
		String prpLthirdPartyClauseType = httpServletRequest
				.getParameter("prpLregistClauseType");
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
		String[] prpLthirdPartySelectSend = httpServletRequest
				.getParameterValues("prpLthirdPartySelectSend");
		String[] prpLthirdPartyScheduleType = httpServletRequest
				.getParameterValues("scheduleType");

		/*----------包括查勘调度，定损调度 PrpLscheduleMainWF ,PrpLscheduleItem --------------*/
		ArrayList scheduleItemDtoList = new ArrayList();
		PrpLscheduleItemDto prpLscheduleItemDto = null;  
		PrpLscheduleMainWFDto prpLscheduleMainWFDto = null;
		// 通过代码对照表转换riskcode
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = registDto.getPrpLregistDto().getRiskCode();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		//添加意健险加入调查主表
			if ("D".equals(strRiskType)||"E".equals(strRiskType)) {
			  PrpLregistDto prpLregistDto =  registDto.getPrpLregistDto();
		        prpLscheduleMainWFDto = new  PrpLscheduleMainWFDto();
		        prpLscheduleMainWFDto.setScheduleID          (1);
		        prpLscheduleMainWFDto.setRegistNo            (prpLregistDto.getRegistNo() );
		        prpLscheduleMainWFDto.setSurveyNo  (0);

		        prpLscheduleMainWFDto.setClaimComCode        (prpLregistDto.getComCode()  );
		        prpLscheduleMainWFDto.setRiskCode            (prpLregistDto.getRiskCode() );
		        prpLscheduleMainWFDto.setPolicyNo            (prpLregistDto.getPolicyNo());
		        prpLscheduleMainWFDto.setOperatorCode        ("");
		        prpLscheduleMainWFDto.setInputDate           (new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
		        prpLscheduleMainWFDto.setInputHour           (DateTime.current().getHour() );
		        prpLscheduleMainWFDto.setScheduleObjectID  ("_" );
		        prpLscheduleMainWFDto.setScheduleObjectName(" ");
		        String scheduleType = httpServletRequest
				.getParameter("scheduleType");
		        prpLscheduleMainWFDto.setScheduleType      (scheduleType);
		        //prpLscheduleMainWFDto.setCheckInputDate    ( new DateTime(prpLscheduleMainWFCheckInputDate)     );
		        //prpLscheduleMainWFDto.setCheckOperatorCode ( prpLscheduleMainWFCheckOperatorCode  );
		        prpLscheduleMainWFDto.setCheckFlag         ("0");
		        prpLscheduleMainWFDto.setScheduleFlag("0");  //查勘调度没有被派出去的
		        prpLscheduleMainWFDto.setFlag                ("");
		        
		        //prpLscheduleMainWFDto.setCheckInfo         ( prpLscheduleMainWFCheckInfo          );
		        //prpLscheduleMainWFDto.setScheduleArea        (0);
		        //prpLscheduleMainWFDto.setFlag                (prpLscheduleMainWFFlag );
		        //prpLscheduleMainWFDto.setSaveType(prpLscheduleMainWFSaveType);
		        prpLscheduleMainWFDto.setCheckSite(registDto.getPrpLregistDto()
						.getDamageAddress());
		      }
		      //加入调度主表
		      registDto.setPrpLscheduleMainWFDto(prpLscheduleMainWFDto);
		      
		// 对象赋值
		// 三者车辆部分开始
		if (prpLthirdPartySerialNo == null) {
		} else {
			// System.out.print(prpLthirdPartySelectSend.length );
			for (int index = 1; index < prpLthirdPartySerialNo.length; index++) {
				prpLthirdPartyDto = new PrpLthirdPartyDto();
				prpLthirdPartyDto.setRegistNo(prpLthirdPartyRegistNo);
				prpLthirdPartyDto.setRiskCode(prpLthirdPartyRiskCode);
				prpLthirdPartyDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPartySerialNo[index])));
				prpLthirdPartyDto.setClaimNo(prpLthirdPartyClaimNo);
				prpLthirdPartyDto.setClauseType(prpLthirdPartyClauseType);
				prpLthirdPartyDto.setLicenseNo(prpLthirdPartyLicenseNo[index]);
				if(prpLthirdPartyLicenseColorCode==null){
				
				}else{
					prpLthirdPartyDto
					.setLicenseColorCode(prpLthirdPartyLicenseColorCode[index]);
				}
				if(prpLthirdPartyCarKindCode==null){
					
				}else{
				prpLthirdPartyDto
						.setCarKindCode(prpLthirdPartyCarKindCode[index]);
			    }
				prpLthirdPartyDto
						.setInsureCarFlag(prpLthirdPartyInsureCarFlag[index]);
				prpLthirdPartyDto.setEngineNo(prpLthirdPartyEngineNo[index]);
				prpLthirdPartyDto.setFrameNo(prpLthirdPartyFrameNo[index]);
				prpLthirdPartyDto.setBrandName(prpLthirdPartyBrandName[index]);  
				prpLthirdPartyDto.setModelCode(prpLthirdPartyModelCode[index]); //add 20060313 
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
				// 加入集合
				thirdPartyDtoList.add(prpLthirdPartyDto);
				// System.out.println("prpLthirdPartySelectSend
				// [index]"+prpLthirdPartySelectSend [index]) ;
				// 整理调度情况
				prpLscheduleItemDto = new PrpLscheduleItemDto();
				prpLscheduleItemDto.setScheduleID(1);
				prpLscheduleItemDto.setRegistNo(prpLthirdPartyRegistNo);
				prpLscheduleItemDto.setItemNo(prpLthirdPartyDto.getSerialNo());
				prpLscheduleItemDto.setInsureCarFlag(prpLthirdPartyDto
						.getInsureCarFlag());
				prpLscheduleItemDto.setClaimComCode(prpLthirdPartyDto
						.getInsureComCode());
				// 表示是否选中
				prpLscheduleItemDto
						.setSelectSend(prpLthirdPartySelectSend[index]);
				// 表示没有调度成定损过
				prpLscheduleItemDto.setSurveyTimes(0);
				prpLscheduleItemDto.setSurveyType("1");
				prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto()
						.getDamageAddress());
				prpLscheduleItemDto.setLicenseNo(prpLthirdPartyDto
						.getLicenseNo());
				prpLscheduleItemDto.setScheduleObjectID("_");
				prpLscheduleItemDto.setScheduleObjectName(" ");
				prpLscheduleItemDto.setInputDate(new DateTime(DateTime
						.current(), DateTime.YEAR_TO_DAY));
				// prpLscheduleItemDto.setResultInfo (prpLscheduleItemResultInfo
				// [index]);
				// prpLscheduleItemDto.setBookFlag (prpLscheduleItemBookFlag
				// [index]);
				prpLscheduleItemDto
				.setScheduleType("schel");
				prpLscheduleItemDto.setNextNodeNo("certa");
				// prpLscheduleItemDto.setFlag (prpLscheduleItemFlag [index]);
				// prpLscheduleItemDto.setNextNodeNo(strNextNode[index]);
				// prpLscheduleItemDto.setNextHandlerCode(nextHandlerCode[index]);
				// prpLscheduleItemDto.setNextHandlerName(nextHandlerName[index]);
				// 加入调度标的集合
				scheduleItemDtoList.add(prpLscheduleItemDto);
				// System.out.println (prpLscheduleItemDto.getItemNo() );

				// 设置调度的标签显示 shcheduleItemNote
				String strTemp = "";
				if (prpLscheduleItemDto.getItemNo() != 1)
					strTemp = "三者:";
				registDto.getPrpLregistDto().setScheduleItemNote(
						registDto.getPrpLregistDto().getScheduleItemNote()
								+ strTemp + prpLscheduleItemDto.getLicenseNo()
								+ "/");
				// 如果是查勘调度去的话，检查如何设置lossItemCode
				if (prpLscheduleItemDto.getSelectSend().equals("1")
						&& prpLscheduleItemDto.getScheduleType()
								.equals("sched")) {
					if (prpLscheduleItemDto.getItemNo() == 1) {
						registDto.getPrpLregistDto().setLossItemCode(
								prpLscheduleItemDto.getItemNo() + "");
					} else {
						if (registDto.getPrpLregistDto().getLossItemCode()
								.equals(""))
							registDto.getPrpLregistDto().setLossItemCode(
									prpLscheduleItemDto.getItemNo() + "");
					}
				}
			}

			// 报案集合中加入三者车辆
			registDto.setPrpLthirdPartyDtoList(thirdPartyDtoList);
			// 这里直接先读人伤跟踪了， 不再另写了。。如果选择了人伤的话
			String PrpLpersonTraceSelectSend = httpServletRequest
					.getParameter("prpLpersonTraceSelectSend");
			String PrpLpersonTraceScheduleType = httpServletRequest
					.getParameter("prpLpersonTraceScheduleType");
			if (PrpLpersonTraceSelectSend != null && PrpLpersonTraceSelectSend.equals("1")) {
				prpLscheduleItemDto = new PrpLscheduleItemDto();
				prpLscheduleItemDto.setScheduleID(1);
				prpLscheduleItemDto.setRegistNo(registDto.getPrpLregistDto()
						.getRegistNo());
				prpLscheduleItemDto.setItemNo(0);
				// 表示是否选中
				prpLscheduleItemDto.setSelectSend(PrpLpersonTraceSelectSend);
				// 表示没有调度成定损过
				prpLscheduleItemDto.setSurveyTimes(0);
				prpLscheduleItemDto.setSurveyType("1");
				prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto()
						.getDamageAddress());
				prpLscheduleItemDto.setInputDate(new DateTime(DateTime
						.current(), DateTime.YEAR_TO_DAY));
				prpLscheduleItemDto
				.setScheduleType("schel");
				prpLscheduleItemDto.setLicenseNo("人伤");
				prpLscheduleItemDto.setScheduleObjectID("_");
				prpLscheduleItemDto.setScheduleObjectName(" ");
				prpLscheduleItemDto.setNextNodeNo("wound");
				scheduleItemDtoList.add(prpLscheduleItemDto);
				// System.out.println(prpLscheduleItemDto.getItemNo());
				registDto.getPrpLregistDto().setScheduleItemNote(
						registDto.getPrpLregistDto().getScheduleItemNote()
								+ prpLscheduleItemDto.getLicenseNo() + "/");
			}

			// 这里直接先读财产定损了， 不再另写了。。如果选择了财产定损的话
			String prpLthirdPropSelectSend = httpServletRequest
					.getParameter("prpLthirdPropSelectSend");
			String prpLthirdPropScheduleType = httpServletRequest
					.getParameter("prpLthirdPropScheduleType");
			if (prpLthirdPropSelectSend != null && prpLthirdPropSelectSend.equals("1")) {
				prpLscheduleItemDto = new PrpLscheduleItemDto();
				prpLscheduleItemDto.setScheduleID(1);
				prpLscheduleItemDto.setRegistNo(registDto.getPrpLregistDto()
						.getRegistNo());
				prpLscheduleItemDto.setItemNo(-1);
				// 表示是否选中
				prpLscheduleItemDto.setSelectSend(prpLthirdPropSelectSend);
				// 表示没有调度成定损过
				prpLscheduleItemDto.setSurveyTimes(0);
				prpLscheduleItemDto.setSurveyType("1");
				prpLscheduleItemDto.setCheckSite(registDto.getPrpLregistDto()
						.getDamageAddress());
				prpLscheduleItemDto.setInputDate(new DateTime(DateTime
						.current(), DateTime.YEAR_TO_DAY));
				prpLscheduleItemDto.setScheduleType("schel");
				prpLscheduleItemDto.setLicenseNo("财产损失");
				prpLscheduleItemDto.setScheduleObjectID("_");
				prpLscheduleItemDto.setScheduleObjectName(" ");
				prpLscheduleItemDto.setNextNodeNo("propc");

				scheduleItemDtoList.add(prpLscheduleItemDto);
				// System.out.println(prpLscheduleItemDto.getItemNo());
				registDto.getPrpLregistDto().setScheduleItemNote(
						registDto.getPrpLregistDto().getScheduleItemNote()
								+ prpLscheduleItemDto.getLicenseNo() + "/");
			}
			// 报案集合中加入调度标的
		}
		registDto.setPrpLscheduleItemDtoList(scheduleItemDtoList);
		// Modify by chenrenda update begin 20050407
		// Reason:损失部位模块中加进零件代码、零件名称,损失部位代码与零件(项目)代码都以列表框形式展现
		/*---------------------损失部位 PrpLthirdCarLoss begin------------------------------------*/
		ArrayList thirdCarLossDtoList = new ArrayList();
		PrpLthirdCarLossDto prpLthirdCarLossDto = null;
		// 从界面得到输入数组
		String prpLthirdCarLossRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
		String prpLthirdCarLossRiskCode = httpServletRequest
				.getParameter("prpLregistRiskCode");
		String[] prpLthirdCarLossSerialNo = httpServletRequest
				.getParameterValues("RelateSerialNo");
		String[] prpLthirdCarLossItemNo = httpServletRequest
				.getParameterValues("prpLthirdCarLossItemNo");
		String[] prpLthirdCarLossLicenseNo = httpServletRequest
				.getParameterValues("prpLthirdCarLossLicenseNo");
		String[] prpLthirdCarLossPartCode = httpServletRequest
				.getParameterValues("partCode"); // 部件代码
		String[] prpLthirdCarLossPartName = httpServletRequest
				.getParameterValues("partName"); // 部件名称
		String[] prpLthirdCarLossCompCode = httpServletRequest
				.getParameterValues("compCode");// 零件代码
		String[] prpLthirdCarLossCompName = httpServletRequest
				.getParameterValues("compName");// 零件名称
		String[] prpLthirdCarLossLossGrade = httpServletRequest
				.getParameterValues("prpLthirdCarLossLossGrade");
		String[] prpLthirdCarLossLossDesc = httpServletRequest
				.getParameterValues("prpLthirdCarLossLossDesc");
		String[] prpLthirdCarLossFlag = httpServletRequest
				.getParameterValues("prpLthirdCarLossFlag");

		// 对象赋值
		// 损失部位部分开始
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

				// 加入集合
				thirdCarLossDtoList.add(prpLthirdCarLossDto);
			}
			// 报案集合中加入损失部位
			registDto.setPrpLthirdCarLossDtoList(thirdCarLossDtoList);
		}
		/*---------------------损失部位 PrpLthirdCarLoss end------------------------------------*/
		// Reason:页面中增加其它损失模块
		/*---------------------其它损失部位 PrpLthirdProp begin------------------------------------*/
		ArrayList thirdPropDtoList = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = null;

		// 从界面得到输入数组
		String prpLthirdPropRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
		String prpLthirdPropRiskCode = httpServletRequest
				.getParameter("prpLregistRiskCode");
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

		// 对象赋值
		// 损失部位部分开始
		if (prpLthirdPropItemNo == null) {
		} else {
			for (int index = 1; index < prpLthirdPropItemNo.length; index++) {

				prpLthirdPropDto = new PrpLthirdPropDto();
				prpLthirdPropDto.setRegistNo(prpLthirdPropRegistNo);
				prpLthirdPropDto.setRiskCode(prpLthirdPropRiskCode);
				prpLthirdPropDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLthirdPropItemNo[index])));
				prpLthirdPropDto.setLicenseNo(prpLthirdPropLicenseNo[index]);
				prpLthirdPropDto.setLossItemCode(lossItemCode[index]);
				prpLthirdPropDto.setLossItemName(LossItemName[index]);
				prpLthirdPropDto.setLossItemDesc(prpLthirdPropLossDesc[index]);
				prpLthirdPropDto.setFlag(prpLthirdPropFlag[index]);

				// 加入集合
				thirdPropDtoList.add(prpLthirdPropDto);
			}

			// 报案集合中加入损失部位
			registDto.setPrpLthirdPropDtoList(thirdPropDtoList);
		}
		/*---------------------其它损失部位 PrpLthirdProp end------------------------------------*/
		// Modify by chenrenda add end 20050407
		/*---------------------人员伤亡跟踪 PrpLpersonTrace ------------------------------------*/
		ArrayList personTraceDtoList = new ArrayList();
		PrpLpersonTraceDto prpLpersonTraceDto = null;
		// 从界面得到输入数组
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

		// 对象赋值
		// 人员伤亡跟踪 部分开始
		if (prpLpersonTracePersonNo == null) {
		} else {
			// System.out.println("人员伤亡跟踪部分开始 ");
			for (int index = 1; index < prpLpersonTracePersonNo.length; index++) {
				prpLpersonTraceDto = new PrpLpersonTraceDto();
				prpLpersonTraceDto.setRegistNo(prpLpersonTraceRegistNo);
				// prpLpersonTraceDto.setClaimNo(prpLpersonTraceClaimNo);
				prpLpersonTraceDto.setClaimNo(""); // 改为存空值 2005-9-20
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
				if (prpLpersonTraceReferKind == null) {
					prpLpersonTraceDto.setReferKind("");
				} else {
					prpLpersonTraceDto
							.setReferKind(prpLpersonTraceReferKind[index]);
				}

				prpLpersonTraceDto.setPartDesc(prpLpersonTracePartDesc[index]);
				prpLpersonTraceDto.setHospital(prpLpersonTraceHospital[index]);
				prpLpersonTraceDto
						.setMotionFlag(prpLpersonTraceMotionFlag[index]);
				prpLpersonTraceDto
						.setWoundRemark(prpLpersonTraceWoundRemark[index]);
				prpLpersonTraceDto.setRemark(prpLpersonTraceRemark[index]);
				prpLpersonTraceDto.setFlag(prpLpersonTraceFlag[index]);
				// 加入集合
				personTraceDtoList.add(prpLpersonTraceDto);
			}

			// 报案集合中加入损失部位
			registDto.setPrpLpersonTraceDtoList(personTraceDtoList);
		}

		/*---------------------报案信息补充说明 PrpLregistExt ------------------------------------*/
		ArrayList prpLregistExtDtoList = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = null;
		// 从界面得到输入数组
		String prpLregistExtRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
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

		// 对象赋值
		// 人员伤亡跟踪 部分开始
		if (prpLregistExtSerialNo == null) {
		} else {
			// System.out.println("人员伤亡跟踪部分开始 ");
			for (int index = 1; index < prpLregistExtSerialNo.length; index++) {
				prpLregistExtDto = new PrpLregistExtDto();
				prpLregistExtDto.setRegistNo(registDto.getPrpLregistDto()
						.getRegistNo());
				prpLregistExtDto.setRiskCode(prpLregistExtRiskCode);
				prpLregistExtDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(prpLregistExtSerialNo[index])));
				prpLregistExtDto.setInputDate(new DateTime(
						prpLregistExtInputDate[index], DateTime.YEAR_TO_DAY));
				prpLregistExtDto.setInputHour(prpLregistExtInputHour[index]);
				prpLregistExtDto
						.setOperatorCode(prpLregistExtOperatorCode[index]);
				prpLregistExtDto.setContext(prpLregistExtContext[index]);
				// 加入集合
				prpLregistExtDtoList.add(prpLregistExtDto);
			}
			// 报案集合中加入损失部位
			registDto.setPrpLregistExtDtoList(prpLregistExtDtoList);
		}

		/*---------------------驾驶员prpLdriver------------------------------------*/
		ArrayList driverList = new ArrayList();
		PrpLdriverDto prpLdriverDto = null;
		// 从界面得到输入数组
		String prpLdriverRegistNo = (String) httpServletRequest
				.getAttribute("registNo");
		String prpLdriverClaimNo = httpServletRequest
				.getParameter("prpLregistClaimNo");
		String prpLdriverRiskCode = httpServletRequest
				.getParameter("prpLregistRiskCode");
		String prpLdriverPolicyNo = httpServletRequest
				.getParameter("prpLregistPolicyNo");
		String[] prpLdriverSerialNo = httpServletRequest
				.getParameterValues("prpLdriverSerialNo");
		//String prpLdriverLicenseNo =
		 //httpServletRequest.getParameter("prpLregistLicenseNo");
		// String prpLdriverLicenseColorCode =
		// httpServletRequest.getParameter("prpLregistLicenseColorCode");
		//modify by zhaolu 20060817 start
		 String prpLdriverDrivingLicenseNo = httpServletRequest.getParameter("prpLdriverDrivingLicenseNo");
		//modify by zhaolu 20060817 end
		String prpLdriverDriverName = httpServletRequest
				.getParameter("prpLdriverDriverName");
		// String[] prpLdriverDriverSex =
		// httpServletRequest.getParameterValues("driverSex");
		// String[] prpLdriverDriverAge =
		// httpServletRequest.getParameterValues("prpLdriverDriverAge");
		// String[] prpLdriverDriverOccupation =
		// httpServletRequest.getParameterValues("driverOccupation");
		// String[] prpLdriverEducation =
		// httpServletRequest.getParameterValues("education");
		// String[] prpLdriverUnitAddress =
		// httpServletRequest.getParameterValues("prpLdriverUnitAddress");
		// String[] prpLdriverIdentifyNumber =
		// httpServletRequest.getParameterValues("prpLdriverIdentifyNumber");
		// String[] prpLdriverDriverGrade =
		// httpServletRequest.getParameterValues("prpLdriverDriverGrade" );
		// String[] prpLdriverDriverSeaRoute =
		// httpServletRequest.getParameterValues("prpLdriverDriverSeaRoute");
		// 根据驾驶员航线字段含义变更申请文档，将驾驶员航线字段改存驾驶员电话信息
		String prpLdriverDriverPhone = httpServletRequest
				.getParameter("prpLdriverDriverPhone");
		// String[] prpLdriverReceiveLicenseDate =
		// httpServletRequest.getParameterValues("prpLdriverReceiveLicenseDate");
		// String[] prpLdriverDrivingCarType =
		// httpServletRequest.getParameterValues("drivingCarType");
		// String[] prpLdriverDrivingYear =
		// httpServletRequest.getParameterValues("prpLdriverDrivingYear");
		// String[] prpLdriverAwardLicenseOrgan =
		// httpServletRequest.getParameterValues("prpLdriverAwardLicenseOrgan");
		// String[] prpLdriverSpecialCertificate =
		// httpServletRequest.getParameterValues("prpLdriverSpecialCertificate");
		// String[] prpLdriverFlag =
		// httpServletRequest.getParameterValues("prpLdriverFlag");

		// 对象赋值
		// 驾驶员部分开始

				prpLdriverDto = new PrpLdriverDto();
				prpLdriverDto.setRegistNo(prpLdriverRegistNo);
				prpLdriverDto.setClaimNo(prpLdriverClaimNo);
				prpLdriverDto.setRiskCode(prpLdriverRiskCode);
				prpLdriverDto.setPolicyNo(prpLdriverPolicyNo);
				// prpLdriverDto.setLicenseNo(prpLdriverLicenseNo);
				// prpLdriverDto.setLicenseColorCode(prpLdriverLicenseColorCode);
				//modify by zhaolu 20060818 start
				prpLdriverDto.setDrivingLicenseNo(prpLdriverDrivingLicenseNo);
				//modify by zhaolu 20060818 end
				prpLdriverDto.setDriverName(prpLdriverDriverName);
				// prpLdriverDto.setDriverSex(prpLdriverDriverSex[index]);
				// prpLdriverDto.setDriverAge(Integer.parseInt(DataUtils.nullToZero(prpLdriverDriverAge[index])));
				// prpLdriverDto.setDriverOccupation(prpLdriverDriverOccupation[index]);
				// prpLdriverDto.setEducation(prpLdriverEducation[index]);
				// prpLdriverDto.setUnitAddress(prpLdriverUnitAddress[index]);
				// prpLdriverDto.setIdentifyNumber(prpLdriverIdentifyNumber[index]);
				// prpLdriverDto.setReceiveLicenseDate(new
				// DateTime(prpLdriverReceiveLicenseDate[index],
				// DateTime.YEAR_TO_DAY));
				// prpLdriverDto.setDrivingCarType(prpLdriverDrivingCarType[index]);
				// prpLdriverDto.setDrivingYear(Integer.parseInt(DataUtils.nullToZero(prpLdriverDrivingYear[index])));
				// prpLdriverDto.setAwardLicenseOrgan(prpLdriverAwardLicenseOrgan[index]);
				// /***根据驾驶员航线字段含义变更申请文档，将驾驶员航线字段改存驾驶员电话信息****
				prpLdriverDto.setDriverSeaRoute(prpLdriverDriverPhone);
				// 加入集合
				driverList.add(prpLdriverDto);
			// 报案集合中加入驾驭员
			registDto.setPrpLdriverDtoList(driverList);
		// modify by wangwei add start 20050601
		// 原因：增加联系人信息
		ArrayList relatePersonList = new ArrayList();
		String[] prpSeriaNo = httpServletRequest
				.getParameterValues("prpLrelatePersonSeriaNo");
		String strPolicyNo = httpServletRequest
				.getParameter("prpLregistPolicyNo");
		String[] prpPersonName = httpServletRequest
				.getParameterValues("prpLrelatePersonPersonName");
		String[] prpPhoneNumber = httpServletRequest
				.getParameterValues("prpLrelatePersonPhoneNumber");
		String[] prpMobile = httpServletRequest
				.getParameterValues("prpLrelatePersonMobile");
		String[] prpRemark = httpServletRequest
				.getParameterValues("prpLrelatePersonRemark");

		if (prpSeriaNo != null) {
			for (int i = 1; i < prpSeriaNo.length; i++) {
				PrpLrelatePersonDto prpLrelatePersonDto = new PrpLrelatePersonDto();
				prpLrelatePersonDto.setRegistNo((String) httpServletRequest
						.getAttribute("registNo"));
				prpLrelatePersonDto
						.setSerialNo(Integer.parseInt(prpSeriaNo[i]));
				prpLrelatePersonDto.setPersonName(prpPersonName[i]);
				prpLrelatePersonDto.setPhoneNumber(prpPhoneNumber[i]);
				prpLrelatePersonDto.setMobile(prpMobile[i]);
				prpLrelatePersonDto.setRemark(prpRemark[i]);
				prpLrelatePersonDto.setPolicyNo(strPolicyNo);
				prpLrelatePersonDto.setPersonType("Link");
				prpLrelatePersonDto.setPersonCode("");
				prpLrelatePersonDto.setFlag("");

				// 加入集合中
				relatePersonList.add(prpLrelatePersonDto);
			}

			// 报案集合中联系人信息
			registDto.setPrpLrelatePersonDtoList(relatePersonList);
		}

		// modify by wangwei add end 20050601
		// modify by liuyanmei modfify 20051119 start
		// reason:itest bug 991 处理报案登记,当"第三者亡人数" "第三者伤人数" "车上人员亡人数"
		// "车上人员伤人数"四个字段其中任意一个没有填值,包括0也不填的情况下,点击"提交"报错
		String personDeathB = httpServletRequest
				.getParameter("prpLregistPersonDeathB");
		String prpLextFlag = httpServletRequest
		.getParameter("prpLextFlag");
		
		
		if (personDeathB == null || personDeathB.equals("") ) {
			personDeathB = "0";
		}
		String personInjureB = httpServletRequest
				.getParameter("prpLregistPersonInjureB");
		if (personInjureB == null || personInjureB.equals("") ) {
			personInjureB = "0";
		}
		String personDeathD1 = httpServletRequest
				.getParameter("prpLregistPersonDeathD1");
		if (personDeathD1 == null || personDeathD1.equals("") ) {
			personDeathD1 = "0";
		}
		String personInjureD1 = httpServletRequest
				.getParameter("prpLregistPersonInjureD1");
		if (personInjureD1 == null || personInjureD1.equals("") ) {
			personInjureD1 = "0";
		}
		
//add by guolei 3119属于农机具 车险
		if (registDto.getPrpLregistDto().getClassCode().equals("05")||registDto.getPrpLregistDto().getRiskCode().equals("3119")) {
			PrpLextDto prpLextDto = new PrpLextDto();
			String certiNo = (String) httpServletRequest
					.getAttribute("registNo");
			prpLextDto.setCertiNo(certiNo);
			prpLextDto.setCertiType("01");
			prpLextDto.setPersonDeathB(Integer.parseInt(personDeathB));
			prpLextDto.setPersonInjureB(Integer.parseInt(personInjureB));
			prpLextDto.setPersonDeathD1(Integer.parseInt(personDeathD1));
			prpLextDto.setPersonInjureD1(Integer.parseInt(personInjureD1));
			prpLextDto.setFlag(prpLextFlag);
			
			registDto.setPrpLextDto(prpLextDto);
		}
		// modify by liuyanmei modfify 20051119 end
		// 整理调度用的标的信息,去掉最后的一个"/"
		if (registDto.getPrpLregistDto().getScheduleItemNote().length() > 1) {
			String strTemp = registDto.getPrpLregistDto().getScheduleItemNote();
			strTemp = strTemp.substring(0, strTemp.length() - 1);
			registDto.getPrpLregistDto().setScheduleItemNote(strTemp);
		}
		return registDto;

	}

	/**
	 * 取初始化信息需要的数据的整理. 填写报案单时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等。取这些信息需要一些入参，
	 * 考虑到接口的一致性，将这些入参作为Dto方式传入，Dto利用聚合而非继承的方式。 整理采用继承的方式分层处理，具体的逻辑放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto 取初始化信息需要的数据
	 * @throws Exception
	 */
	public RegistDto iniViewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		RegistDto registDto = new RegistDto();
		return registDto;
	}

	/**
	 * 填写报案页面及查询报案request的生成.
	 * 填写报案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void dtoToView(HttpServletRequest httpServletRequest,
			RegistDto registDto) throws Exception {
		// 得到request的PrpLregistForm用于显示
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

		// 得到request的prpLthirdPartyForm用于显示
		Collection prpLthirdPartyList = registDto.getPrpLthirdPartyDtoList();
		httpServletRequest.setAttribute("prpLthirdPartyList",
				prpLthirdPartyList);

		// 得到request的prpLdriverForm用于显示
		Collection prpLdriverList = registDto.getPrpLdriverDtoList();
		httpServletRequest.setAttribute("prpLdriverList", prpLdriverList);

		// 得到request的prpLregistTextForm用于显示
		Collection prpLregistTextList = registDto.getPrpLregistTextDtoList();
	    httpServletRequest.setAttribute("prpLregistTextList",
				prpLregistTextList);
	}

	public void setRegistDtoView(HttpServletRequest httpServletRequest,
			String registNo) throws Exception {	
		HttpSession session = httpServletRequest.getSession();
		String policyNo = "";
		UICodeAction uiCodeAction = new UICodeAction();
		// 查询保单信息
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);
		// 给registForm赋值
		DateTime.setDateDelimiter("-");
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		String riskcodetemp1 = "";
		if(prpLregistDto != null)
		{
			riskcodetemp1 = prpLregistDto.getRiskCode();
		}
		ArrayList houselist = registDto.getPrplCompensateHouseDtoList();
		if(houselist != null && ("0310".equals(riskcodetemp1)||"0312".equals(riskcodetemp1)))
		{
			httpServletRequest.setAttribute("prplCompensateHouseDtoList", houselist);
		}
		policyNo = prpLregistDto.getPolicyNo();
		int intPayFee = this.checkPay(httpServletRequest, policyNo);
		
        /**
         * modify by mengdongdong start
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		PrpCmainDto cmainDto = (PrpCmainDto)new UIPolicyAction().findPrpCmainDtoByPrimaryKey(policyNo);
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(intPayFee == -2 && cmainDto.getPayTimes()>1){			
			delinquentfeeCase = getDelinquentfeeCase(cmainDto);
		}
		
		//设置分期付款未缴期数
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
        /**
         * modify by mengdongdong end
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		// 缴费标志
		prpLregistDto.setPayFlag(String.valueOf(intPayFee));
		prpLregistDto.setReportHour(StringConvert.toStandardTime(prpLregistDto
				.getReportHour()));
		prpLregistDto.setReportMinute(prpLregistDto.getReportHour().substring(
				3, 5));
		prpLregistDto.setReportHour(prpLregistDto.getReportHour().substring(0,
				2));
		prpLregistDto.setDamageStartHour(StringConvert
				.toStandardTime(prpLregistDto.getDamageStartHour()));
		prpLregistDto.setDamageStartMinute(prpLregistDto.getDamageStartHour()
				.substring(3, 5));
		prpLregistDto.setDamageStartHour(prpLregistDto.getDamageStartHour()
				.substring(0, 2));
		if("05".equals(prpLregistDto.getClassCode())){
			prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(),DateTime.YEAR_TO_SECOND));
		}else{
			prpLregistDto.setInputDate(new DateTime(prpLregistDto.getInputDate().toString(),DateTime.YEAR_TO_DAY));
		}
		// 根据保单号查询保单信息
		if (!prpLregistDto.getPolicyNo().equals("")) {
			policyNo = prpLregistDto.getPolicyNo();
			// System.out.println("prpLregistPolicyNo="+policyNo);
			EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			String damageDate = sf.format(prpLregistDto.getDamageStartDate());
			String damageHour = String.valueOf(prpLregistDto.getDamageStartHour());
			PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate,damageHour );
			// 将insured,itemkind信息放到session中,意外险用
			/*session.setAttribute("prpcinsuredDtoList", policyDto
					.getPrpCinsuredDtoList());
			session.setAttribute("prpcitemkindDtoList", policyDto
					.getPrpCitemKindDtoList());*/
			registDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
			prpLregistDto.setPolicyNo(policyNo);
			prpLregistDto.setHandler1Code(policyDto.getPrpCmainDto()
					.getHandler1Code());
			prpLregistDto.setStartDate(policyDto.getPrpCmainDto()
					.getStartDate().toString());
			prpLregistDto.setEndDate(policyDto.getPrpCmainDto().getEndDate()
					.toString());
			// add qinyongli 2005-7-18 增加共保字段
			httpServletRequest.setAttribute("coinsFlag", policyDto
					.getPrpCmainDto().getCoinsFlag());
			// add end
			prpLregistDto.setComCode(policyDto.getPrpCmainDto().getComCode());

			prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto()
					.getInsuredCode());

			// add by liuyanmei 20051212 start reason :被保险人显示****等**人
			/*ArrayList prpCinsuredDtoList = policyDto.getPrpCinsuredDtoList();
			PrpCinsuredDto prpCinsuredDto = new PrpCinsuredDto(); */
			String strInsuredName = "";
			
			int insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
			
			    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
					|| insureQuantity <= 1 ) {
				       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
				}
				else {
					   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";	
				}
			prpLregistDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
			prpLregistDto.setInsuredNameShow(strInsuredName);
			prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto()
					.getInsuredAddress());
			prpLregistDto.setSumAmount(policyDto.getPrpCmainDto()
					.getSumAmount());
			prpLregistDto.setEstiCurrencyName(uiCodeAction
					.translateCurrencyCode(prpLregistDto.getEstiCurrency(),
							true));
			String agentCode = "";
			if (policyDto.getPrpCmainDto() != null) {
				agentCode = policyDto.getPrpCmainDto().getAgentCode(); // 代理人代码
			}
			prpLregistDto.setAgentCode(agentCode);
			prpLregistDto.setAgentName(uiCodeAction
					.translateAgentName(agentCode));// 得到代理人名称
			// 设置报案操作的状态为 案件已提交
			if (registDto.getPrpLclaimStatusDto() != null) {
				if (registDto.getPrpLclaimStatusDto().getStatus().equals("7"))
					registDto.getPrpLclaimStatusDto().setStatus("3");
				prpLregistDto.setStatus(registDto.getPrpLclaimStatusDto()
						.getStatus());
			} else {
				// 已提交，已经处理完毕的状态
				prpLregistDto.setStatus("4");
			}
		}

		// 查询保单信息
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(prpLregistDto.getRiskCode());
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		String strTemp = "";
		if("D".equals(strRiskType)){
			if (policyDto.getPrpCitemKindDtoList() != null) {
				for (int i = 0; i < policyDto.getPrpCitemKindDtoList().size(); i++) {
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
							.getPrpCitemKindDtoList().get(i);
					strTemp = strTemp + "," + prpCitemKindDto.getKindCode();
				}
			}
		}
		prpLregistDto.setReferKind(strTemp);
		// modify by lixiang add 20050315 start
		// reason:加入保险标的信息的内容，界面上可以直接显示承保险别
		registDto.setPrpCitemKindDtoList(policyDto.getPrpCitemKindDtoList());
		// modify by lixiang add 20050315 end

		// Modify by chenrenda add begin 20050408
		// Reason:人伤跟踪信息模块中涉及险种以列表框多选形式显示
	    if("D".equals(strRiskType)){
	    	ArrayList itemKindList = policyDto.getPrpCitemKindDtoList();
			Collection itemKindListNew = new ArrayList();
            //modify by lym 20060626  start--------------------------
			String  qsFlag = (String )httpServletRequest.getAttribute("qsFlag");
	    	if ( qsFlag!=null && "Y".equals(qsFlag)){
				 String mainPolicyNo =(String )httpServletRequest.getAttribute("mainPolicyNo");
				 PolicyDto mainPolicyDto = endorseViewHelper.findForEndorBefore(mainPolicyNo);
				 ArrayList itemKindList_qs = mainPolicyDto.getPrpCitemKindDtoList();
				 PrpCitemKindDto  prpCitemKindDto_qs = (PrpCitemKindDto)itemKindList_qs.get(0);
				 itemKindList.add(prpCitemKindDto_qs);
			}
			
			itemKindListNew = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList);
			httpServletRequest.setAttribute("itemKindList", itemKindList);
			httpServletRequest.setAttribute("referKindList", itemKindListNew);
			String proposalNo = policyDto.getPrpCmainDto().getProposalNo();
			httpServletRequest.setAttribute("proposalNo", proposalNo);
	    }
		httpServletRequest.setAttribute("prpCmainDto", policyDto
				.getPrpCmainDto());
		// Modify by chenrenda add end 20050404

		// 出险原因、事故原因按照优先级别排序
		// 分别黙认显示为碰撞、疏忽大意、措施不当
		prpLregistDto.setPrpLregistDamageCode(prpLregistDto.getDamageCode());
		prpLregistDto.setPrpLregistDamageTypeCode(prpLregistDto
				.getDamageTypeCode());
		httpServletRequest.setAttribute("damageCodeList", ICollections
				.getDamageCodeList());
		httpServletRequest.setAttribute("damageTypeCodeList", ICollections
				.getDamageTypeCodeList());
		httpServletRequest.setAttribute("indemnityDutyList", ICollections
				.getIndemnityDutyList());
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());

		PrpLextDto prpLextDto = registDto.getPrpLextDto();
		if (prpLextDto != null) {
			prpLregistDto.setCertiNo(prpLextDto.getCertiNo());
			prpLregistDto.setCertiType(prpLextDto.getCertiType());
			prpLregistDto.setPersonDeathB(prpLextDto.getPersonDeathB());
			prpLregistDto.setPersonInjureB(prpLextDto.getPersonInjureB());
			prpLregistDto.setPersonDeathD1(prpLextDto.getPersonDeathD1());
			prpLregistDto.setPersonInjureD1(prpLextDto.getPersonInjureD1());
			prpLregistDto.setFlag(prpLextDto.getFlag());
		}

		// Modify by chenrenda add end 20050404
		httpServletRequest.setAttribute("prpLrelatePersonDtoList", registDto
				.getPrpLrelatePersonDtoList());
		// Modify by chenrenda add begin 20050418
		// Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
		String strPrpLnodeType = "regis";
		httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
		// Modify by chenrenda add end 20050418

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

		// 在界面上显示险种名称 2005-09-09
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLregistDto.getRiskCode(), true));
		httpServletRequest.setAttribute("riskType", strRiskType);
		// 给三者车辆多行列表准备数据
		Collection thirdPartyList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
		thirdPartyList = registDto.getPrpLthirdPartyDtoList();
		// 整理调度信息的
		ScheduleItemDtoToView(thirdPartyList, registDto
				.getPrpLscheduleItemDtoList());

		prpLthirdPartyDto.setThirdPartyList(thirdPartyList);
		prpLthirdPartyDto.setNodeType("regis");
		httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);

		// 给驾驶员多行多行列表准备数据
		Collection arrayListDriver = new ArrayList();
		PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
		arrayListDriver = registDto.getPrpLdriverDtoList();
		prpLdriverDto.setDriverList(arrayListDriver);
		httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);

		// modify by wangwei add start 20050614
		// 原因：增加货运险保单信息
		PrpCmainCargoDto prpCmain_cargoDto = policyDto.getPrpCmainCargoDto();
		//add by lixiang start at 2006-7-17
		//reason:增加进行运输工具的转换
		if (prpCmain_cargoDto!=null){
			prpCmain_cargoDto.setConveyance(uiCodeAction.translateCodeCode("TransMode",prpCmain_cargoDto.getConveyance(),true));
		}
		//add by lixiang end at 2006-7-17
		httpServletRequest.setAttribute("prpCmain_cargoDto", prpCmain_cargoDto);
		// modify by wangwei add end 20050614

		// 计算出险次数
		getSamePolicyRegistInfo(httpServletRequest, policyNo, registNo);

		// 原因：要在界面上显示一些立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(policyNo);
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);

		// 转换名称代码
		changeCodeToName(httpServletRequest, prpLregistDto);
		// 设置各个列表和下拉框的选择信息的
		setSelectionList(httpServletRequest, prpLregistDto);
		// 设置各个子表的信息
		setSubInfo(httpServletRequest, registDto);
		prpLregistDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
		prpLregistDto.setSignDate(policyDto.getPrpCmainDto().getSignDate());
		
		// 设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest, prpLregistDto.getRiskCode(),
				prpLregistDto.getComCode());

		// 意健险在提交前，所有的申请调查应该已经提交。 2005-08-04
		
		if ("E".equals(strRiskType)) {
			UIWorkFlowAction uiWorkFlowAction = new UIWorkFlowAction();
			int intCount = 0; // 没有提交的申请调查数目
			String strFlowID = httpServletRequest.getParameter("swfLogFlowID");
			String strSql = " FLOWID='" + strFlowID
					+ "' and NODETYPE='check' and NODESTATUS<>'4'";
			intCount = uiWorkFlowAction.findNodesByConditions(strSql).size();
			httpServletRequest.setAttribute("com.sinosoft.acciFlag",
					intCount > 0 ? "N" : "Y"); // 设置一个标志位：N表示不能提交，Y表示可以提交。
		}
		
	    //add by zhaolu 20060911 start
		//增加注销/拒赔原因
		Collection prpLregistTextList = registDto.getPrpLregistTextDtoList();
		StringBuffer context = new StringBuffer();
		if( prpLregistTextList != null )
		{
			Iterator iterator = prpLregistTextList.iterator();
			while(iterator.hasNext()){
				PrpLregistTextDto prpLregistTextDto = (PrpLregistTextDto)iterator.next();
				if( "2".equals(prpLregistTextDto.getTextType()) ){
					context.append("  ");
					context.append(prpLregistTextDto.getContext());
					context.append("\t");
					
				}
			}
		}
		httpServletRequest.setAttribute("context",context.toString());
	    //add by zhaolu 20060911 end
		
       ArrayList prplacciBenPersonDtoList = registDto.getPrplacciBenPersonDtoList();
       PrpLacciPersonDto prpLacciBenPersonDto = new PrpLacciPersonDto();
       prpLacciBenPersonDto.setPrpLacciBenPersonList(prplacciBenPersonDtoList);
       httpServletRequest.setAttribute("prpLacciPersonDto",prpLacciBenPersonDto); 
         
	}

	/**
	 * 填写报案页面及查询报案request的生成.
	 * 填写报案时页面需要一定的初始化信息，如地区代码、定额标的信息、车型种类等，将这些信息取出并放入request。
	 * 整理采用继承的方式分层处理，险种险类特有数据放在险种险类子类中整理.
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param proposalIniDto
	 *            取出的初始化信息Dto
	 * @throws Exception
	 */
	public void policyDtoToView(HttpServletRequest httpServletRequest,
			String policyNo, String damageDate, String damageHour)
			throws Exception {
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		String strInsuredName = ""; // add by liuyanmei
		int insureQuantity = 0; // add by liuyanmei
		int j = 0;
	
		// 查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		// PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo);
		// 根据出险时间找到保单
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,
				damageDate, damageHour);

		// add by liuyanmei 20051212 start
        //modify by liuyanmei 20060109 reason:只需显示一个人名字加人数，如：张三等10人
		insureQuantity = policyDto.getPrpCmainDto().getSumQuantity();
		
	    if (String.valueOf(insureQuantity) == null || String.valueOf(insureQuantity).equals("")
			|| insureQuantity <= 1 ) {
		       strInsuredName = policyDto.getPrpCmainDto().getInsuredName();
		}
		else {
			   strInsuredName = policyDto.getPrpCmainDto().getInsuredName()+"等"+insureQuantity+"人";	
		}
		// 将insured,itemkind信息放到session中,意外险用
	    //Modify by chenrenda begin 20070628，注释掉采用其它方式
	    //reason:对于非车团单业务，对于系统效率有影响
//		session.setAttribute("prpcinsuredDtoList", policyDto
//				.getPrpCinsuredDtoList());
//		session.setAttribute("prpcitemkindDtoList", policyDto
//				.getPrpCitemKindDtoList());
		int intPayFee = this.checkPay(httpServletRequest, policyNo);
        //Modify by chenrenda end 20070628
        /**
         * modify by mengdongdong start
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(intPayFee == -2 && policyDto.getPrpCmainDto().getPayTimes()>1){			
			delinquentfeeCase = getDelinquentfeeCase(policyDto.getPrpCmainDto());
		}
		//System.out.println("缴费情况为:"+delinquentfeeCase);
		//设置分期付款未缴期数
		httpServletRequest.setAttribute("delinquentfeeCase",delinquentfeeCase);
        /**
         * modify by mengdongdong end
         * resion:当缴费不足时,要显示相应的缴费情况
         * 2006-1-19
         */
		
		// 原因：要在界面上显示一些立案信息
		UIClaimAction uiClaimAction = new UIClaimAction();
		Collection registClaimDtoList = (Collection) uiClaimAction
				.findByPolicyNo(policyNo);
		httpServletRequest.setAttribute("registClaimDtoList",
				registClaimDtoList);

		UIEndorseAction uiEndorseAction = new UIEndorseAction();
		Collection prpPheadDtoList = uiEndorseAction
				.findByPrpPheadConditions(" policyNo='" + policyNo + "'");
		httpServletRequest.setAttribute("prpPheadDtoList", prpPheadDtoList);

		// 原因：要在界面上显示一些保单信息
		PrpCmainDto prpCmainDto = (PrpCmainDto) policyDto.getPrpCmainDto();
		String proposalNo = prpCmainDto.getProposalNo();
		httpServletRequest.setAttribute("prpCmainDto", prpCmainDto);
		httpServletRequest.setAttribute("proposalNo", proposalNo);
		httpServletRequest.setAttribute("liabStartDate", policyDto
				.getLiabStartDate().toString());
		// 原因：要在界面上判断追溯期
		// 保存共保、是否股东信息 、临分信息
		// add start by qingyongli 2005-7-22
		httpServletRequest
				.setAttribute("coinsFlag", prpCmainDto.getCoinsFlag());
		httpServletRequest.setAttribute("shareHolderFlag", prpCmainDto
				.getShareHolderFlag());
		String conditions = "reinsType in ('1','2')  and policyno = '"
				+ prpCmainDto.getPolicyNo() + "'";
		BLFcoRepolicyFacade blFcoRepolicyFacade = new BLFcoRepolicyFacade();
		ArrayList reins = (ArrayList) blFcoRepolicyFacade
				.findByConditions(conditions);
		if (reins != null && reins.size() > 0) {
			httpServletRequest.setAttribute("tempReinsFlag", "1");
		} else {
			httpServletRequest.setAttribute("tempReinsFlag", "0");
		}
		// add end by qinyongli
		// 给registForm赋值
		DateTime.setDateDelimiter("-");
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		prpLregistDto.setPayFlag(String.valueOf(intPayFee));
		//		+ prpLregistDto.getPayFlag());
		prpLregistDto.setPolicyNo(policyNo);
		prpLregistDto.setClassCode(policyDto.getPrpCmainDto().getClassCode());
		String riskCode = policyDto.getPrpCmainDto().getRiskCode();
		prpLregistDto.setRiskCode(riskCode);
		prpLregistDto.setReceiverCode(user.getUserCode());
		prpLregistDto.setReceiverName(user.getUserName());
		prpLregistDto.setSumAmount(policyDto.getPrpCmainDto().getSumAmount());
		// 设置签单日期
		prpLregistDto.setSignDate(policyDto.getPrpCmainDto().getSignDate());
		prpLregistDto.setOthFlag(policyDto.getPrpCmainDto().getOthFlag());
		prpLregistDto.setUnderWriteEndDate(policyDto.getPrpCmainDto()
				.getUnderWriteEndDate());

		// 设置默认现场为非第一现场
		prpLregistDto.setFirstSiteFlag("0");
		// 得到归属业务员
		String handler1Code = policyDto.getPrpCmainDto().getHandler1Code();
		prpLregistDto.setHandler1Code(handler1Code);
		// 设置报案操作的状态为 新案件登记 (未处理任务)
		prpLregistDto.setStatus("1");
		// 设置归属业务机构
		String comCode = policyDto.getPrpCmainDto().getComCode();
		prpLregistDto.setComCode(comCode);
		UICodeAction uiCodeAction = new UICodeAction();
		String strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		if("Y".equals(strRiskType)&&policyDto.getPrpCmainCargoDto()==null){
			PrpCmainCargoDto prpCmainCargoDto = new PrpCmainCargoDto();
			prpCmainCargoDto.setPolicyNo(policyDto.getPrpCmainDto().getPolicyNo());
			prpCmainCargoDto.setEndSiteName("_____");
			prpCmainCargoDto.setEndSiteCode("");
			prpCmainCargoDto.setStartSiteCode("");
			prpCmainCargoDto.setStartSiteName("_____");
			policyDto.setPrpCmainCargoDto(prpCmainCargoDto);
		}
		
		if ("Y".equals(strRiskType)) {
			prpLregistDto.setDamageAddress(policyDto.getPrpCmainCargoDto()
					.getEndSiteName());
		}
		prpLregistDto.setStartDate(policyDto.getPrpCmainDto().getStartDate()
				.toString());
		prpLregistDto.setStartHour(policyDto.getPrpCmainDto().getStartHour()); 
		prpLregistDto.setEndDate(policyDto.getPrpCmainDto().getEndDate()
				.toString());
		prpLregistDto.setEndHour(policyDto.getPrpCmainDto().getEndHour()); 
		String estiCurrency = policyDto.getPrpCmainDto().getCurrency();
		prpLregistDto.setEstiCurrency(estiCurrency);
		// modify by dongcl add start 20050622
		prpLregistDto.setEstiCurrencyName(uiCodeAction.translateCurrencyCode(
				prpLregistDto.getEstiCurrency(), true));
		prpLregistDto.setLanguage(policyDto.getPrpCmainDto().getLanguage());
		prpLregistDto.setMakeCom(user.getComCode());
		prpLregistDto.setHandlerCode(policyDto.getPrpCmainDto()
				.getHandlerCode());
		prpLregistDto.setOperatorCode(user.getUserCode());
		// modify by dongchengliang 20050602 start
		prpLregistDto.setMakeComName(user.getComName());
		prpLregistDto.setOperatorName(user.getUserName());
		// modify by dongchengliang 20050602 end

		// modify by wangli add start 200504017
		DateTime systemFlowInTime = new DateTime(DateTime.current(),
				DateTime.YEAR_TO_SECOND);
		prpLregistDto.setFlowInTime(systemFlowInTime);
		// modify by wangli add start 200504017

		// modify by qinyongli add 2005－07－20 start
		// reason:获取报案出险延期天数
		UIConfigAction uiConfigAction = new UIConfigAction();
		String configValue = ""; // 获取报案出险延期天数
		configValue = uiConfigAction.getConfigValue("REPORT_DEFER_DAYS",
				prpLregistDto.getRiskCode());
		if (configValue == null || configValue.equals("")) {
			throw new UserException(1, 3, "platform", "请联系系统管理员，在平台配置系统中进行险种"
					+ prpLregistDto.getRiskCode() + "'报案出险延期天数'的初始化！");
		}
		httpServletRequest.setAttribute("configValue", configValue);
		// modify by qinyongli add 2005－07－20 end
		// 取得理赔登记机构信息
		prpLregistDto.setInsuredCode(policyDto.getPrpCmainDto()
				.getInsuredCode());
		// modify by liuyanmei
		prpLregistDto.setInsuredName(policyDto.getPrpCmainDto().getInsuredName());
		prpLregistDto.setAppliNameShow(policyDto.getPrpCmainDto().getAppliName());
		prpLregistDto.setInsuredNameShow(strInsuredName);
		prpLregistDto.setInsuredAddress(policyDto.getPrpCmainDto()
				.getInsuredAddress());
		//录入时间显示到时、分
		if("05".equals(prpLregistDto.getClassCode())){
			prpLregistDto.setInputDate(new DateTime(DateTime.current().toString(),
					DateTime.YEAR_TO_SECOND));
		}else{
			prpLregistDto.setInputDate(new DateTime(DateTime.current().toString(),
					DateTime.YEAR_TO_DAY));
		}
		// 初始化报案日期，出险日期
		prpLregistDto.setReportDate(new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY));
		prpLregistDto.setReportHour(String
				.valueOf(DateTime.current().getHour()));
		prpLregistDto.setReportMinute(String.valueOf(DateTime.current()
				.getMinute()));

		// 货运险出险时间缺省为启运日 2005-09-05
		if ("Y".equals(strRiskType)) {
			prpLregistDto.setDamageStartDate(new DateTime(DateTime.current()
					.toString(), DateTime.YEAR_TO_DAY));
		} else {
			prpLregistDto.setDamageStartDate(new DateTime(DateTime.current()
					.toString(), DateTime.YEAR_TO_DAY));
		}
		prpLregistDto.setDamageStartHour(String.valueOf(DateTime.current()
				.getHour()));
		prpLregistDto.setDamageStartMinute(String.valueOf(DateTime.current()
				.getMinute()));
		prpLregistDto.setDamageEndDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		prpLregistDto.setDamageEndHour(String.valueOf(DateTime.current()
				.getHour()));
		prpLregistDto.setLFlag("L");

		// (1)归属业务员名称的转换
		String handler1Code2 = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction.translateUserCode(handler1Code2,
				true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)归属业务机构的转换
		String comCode2 = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode2, true);
		prpLregistDto.setComName(comName);
     	
		String agentCode = "";
		if (policyDto.getPrpCmainDto() != null) {
			agentCode = policyDto.getPrpCmainDto().getAgentCode(); // 代理人代码
		}
		prpLregistDto.setAgentCode(agentCode);
		prpLregistDto.setAgentName(uiCodeAction.translateAgentName(agentCode));// 得到代理人名称
		// 默认的是否受理是Y,投其他公司的是N
		prpLregistDto.setAcceptFlag("Y");
		prpLregistDto.setRepeatInsureFlag("N");
		// 设置立案操作的状态为 案件修改 (正处理任务)
		if (policyDto.getPrpLclaimStatusDto() == null) {
			prpLregistDto.setStatus("1");
		} else {
			prpLregistDto.setStatus(policyDto.getPrpLclaimStatusDto()
					.getStatus());
		}
		// 给三者车辆多行列表准备数据
		Collection arrayList = new ArrayList();
		PrpLthirdPartyDto prpLthirdPartyDto = new PrpLthirdPartyDto();
		PrpLthirdPartyDto prpLthirdPartyDtoList = new PrpLthirdPartyDto();
		// 得到item_car表中信息
		PrpCitemCarDto PrpCitemCarDto = new PrpCitemCarDto();
		if (policyDto.getPrpCitemCarDtoList().size() > 0) {
			PrpCitemCarDto = (PrpCitemCarDto) policyDto.getPrpCitemCarDtoList()
					.get(0);
			prpLregistDto.setClauseType(PrpCitemCarDto.getClauseType());
			prpLregistDto.setLicenseNo(PrpCitemCarDto.getLicenseNo());
			prpLregistDto.setLicenseColorCode(PrpCitemCarDto
					.getLicenseColorCode());
			prpLregistDto.setCarKindCode(PrpCitemCarDto.getCarKindCode());
			prpLregistDto.setEngineNo(PrpCitemCarDto.getEngineNo());
			prpLregistDto.setFrameNo(PrpCitemCarDto.getFrameNo());
			prpLregistDto.setRunDistance(PrpCitemCarDto.getRunMiles());
			prpLregistDto.setUseYears(PrpCitemCarDto.getUseYears());
			prpLregistDto.setBrandName(PrpCitemCarDto.getBrandName());
			prpLregistDto.setModelCode(PrpCitemCarDto.getModelCode());
			// 三者车辆
			prpLthirdPartyDtoList.setSerialNo(1);
			prpLthirdPartyDtoList.setClauseType(prpLregistDto.getClauseType());
			prpLthirdPartyDtoList.setLicenseNo(PrpCitemCarDto.getLicenseNo());
			prpLthirdPartyDtoList.setLicenseColorCode(PrpCitemCarDto
					.getLicenseColorCode());
			prpLthirdPartyDtoList.setEngineNo(PrpCitemCarDto.getEngineNo());
			prpLthirdPartyDtoList.setFrameNo(PrpCitemCarDto.getFrameNo());
			prpLthirdPartyDtoList.setRunDistance(PrpCitemCarDto.getRunMiles());
			prpLthirdPartyDtoList.setUseYears(PrpCitemCarDto.getUseYears());
			prpLthirdPartyDtoList.setBrandName(PrpCitemCarDto.getBrandName());
			prpLthirdPartyDtoList.setModelCode(PrpCitemCarDto.getModelCode());
			prpLthirdPartyDtoList.setInsureCarFlag("1");
            prpLthirdPartyDtoList.setVINNo(PrpCitemCarDto.getVINNo());
			UICompanyAction uiCompanyAction = new UICompanyAction();
			prpLthirdPartyDtoList.setInsureComCode(policyDto.getPrpCmainDto()
					.getMakeCom());
			PrpDcompanyDto prpDcompanyDto = uiCompanyAction
					.findByPrimaryKey(policyDto.getPrpCmainDto().getMakeCom());
			if (prpDcompanyDto != null) {
				prpLthirdPartyDtoList.setInsureComName(prpDcompanyDto
						.getComCName());
			} else {
				prpLthirdPartyDtoList.setInsureComName("");
			}
			prpLthirdPartyDtoList.setCarKindCode(PrpCitemCarDto
					.getCarKindCode());
			arrayList.add(prpLthirdPartyDtoList);

		}
		//Modify by chenrenda begin 20070628
		//reason:对于非车团单业务,如果citemkind表数据量比较大时，系统效率有一定影响，改为只针对车险
		String strTemp = "";
		if ("D".equals(strRiskType)) {
			if (policyDto.getPrpCitemKindDtoList() != null) {
				for (int i = 0; i < policyDto.getPrpCitemKindDtoList().size(); i++) {
					PrpCitemKindDto prpCitemKindDto = (PrpCitemKindDto) policyDto
							.getPrpCitemKindDtoList().get(i);
					strTemp = strTemp + "," + prpCitemKindDto.getKindCode();
				}
			}
		}
		//Modify by chenrenda end 20070628
		prpLthirdPartyDto.setThirdPartyList(arrayList);
		prpLregistDto.setReferKind(strTemp);
		// 计算出险次数
		getSamePolicyRegistInfo(httpServletRequest, policyNo, prpLregistDto
				.getRegistNo());

		// 给驾驶员多行多行列表准备数据
		Collection arrayListDriver = new ArrayList();
		PrpLdriverDto prpLdriverDto = new PrpLdriverDto();
		PrpLdriverDto prpLdriverDtoList = new PrpLdriverDto();
		PrpCcarDriverDto prpCcarDriverDto = new PrpCcarDriverDto();
		if (policyDto.getPrpCcarDriverDtoList().size() > 0) {
			for (int i = 0; i < policyDto.getPrpCcarDriverDtoList().size(); i++) {
				prpCcarDriverDto = (PrpCcarDriverDto) policyDto
						.getPrpCcarDriverDtoList().get(i);
				if (prpCcarDriverDto.getChangelessFlag().equals("1")) {
					prpLdriverDtoList.setSerialNo(1);
					prpLdriverDtoList.setDrivingLicenseNo(prpCcarDriverDto
							.getDrivingLicenseNo());
					prpLdriverDtoList.setDriverName(prpCcarDriverDto
							.getDriverName());
					prpLdriverDtoList.setDriverSex(prpCcarDriverDto.getSex());
					prpLdriverDtoList.setIdentifyNumber(prpCcarDriverDto
							.getIdentifynumber());
					prpLdriverDtoList.setDriverAge(prpCcarDriverDto.getAge());
					prpLdriverDtoList.setEducation("");
					prpLdriverDtoList.setAwardLicenseOrgan(prpCcarDriverDto
							.getAwardLicenseOrgan());
					prpLdriverDtoList.setDrivingCarType(prpCcarDriverDto
							.getDrivingCarType());
					prpLdriverDtoList.setDriverOccupation(prpCcarDriverDto
							.getBusinessSource());

					// 添加驾驶员初次领证日期 2005-07-13
					prpLdriverDtoList.setReceiveLicenseDate(prpCcarDriverDto
							.getAcceptLicenseDate());
					arrayListDriver.add(prpLdriverDtoList);
				}
			}
		}
		prpLdriverDto.setDriverList(arrayListDriver);

		// 设置各个列表和下拉框的选择信息的
		setSelectionList(httpServletRequest, prpLregistDto);
		// 设置各个子表中的信息
		RegistDto registDto = new RegistDto();
		registDto.setPrpCengageDtoList(policyDto.getPrpCengageDtoList());
		// modify by lixiang add 20050315 start
		// reason:加入保险标的信息的内容，界面上可以直接显示承保险别
		registDto.setPrpCitemKindDtoList(policyDto.getPrpCitemKindDtoList());

		// modify by lixiang add 20050315 end
		registDto.setPrpLregistDto(prpLregistDto);
		// Modify by chenrenda add 20050409 begin
		// Reason:人伤跟踪信息模块中涉及险种以列表框多选形式显示
		
		//modify by lym 20060626  start--------------------------
		if("D".equals(strRiskType)){
			String qsFlag = (String )httpServletRequest.getAttribute("qsFlag");
		    ArrayList itemKindList = policyDto.getPrpCitemKindDtoList();
			if ( qsFlag!=null && "Y".equals(qsFlag)){
				 String mainPolicyNo =(String )httpServletRequest.getAttribute("mainPolicyNo");
				 PolicyDto mainPolicyDto = endorseViewHelper.findForEndorBefore(mainPolicyNo,
						damageDate, damageHour);
				 ArrayList itemKindList_qs = mainPolicyDto.getPrpCitemKindDtoList();
				 PrpCitemKindDto  prpCitemKindDto_qs = (PrpCitemKindDto)itemKindList_qs.get(0);
				 itemKindList.add(prpCitemKindDto_qs);
			}
			Collection itemKindListNew = new ArrayList();
			itemKindListNew = BusinessRuleUtil.getReferItemKindListByKindType("ThirdPersonLoss",itemKindList);
		  	httpServletRequest.setAttribute("referKindList", itemKindListNew);
		}
		//modify by lym 20060626  end--------------------------
	  	registDto.setPrpLscheduleMainWFDto(new PrpLscheduleMainWFDto());
		setSubInfo(httpServletRequest, registDto);
		// 设置工作流下一个节点提交的配置信息
		getSubmitNodes(httpServletRequest, prpLregistDto.getRiskCode(),
				prpLregistDto.getComCode());
		// Modify by chenrenda add begin 20050404
		// 出险原因、事故原因按照优先级别排序
		// 分别黙认显示为暴雨、疏忽大意、措施不当

		prpLregistDto.setPrpLregistDamageCode("001");
		prpLregistDto.setPrpLregistDamageTypeCode("009");
		prpLregistDto.setDamageTypeCode("009");
		prpLregistDto.setDamageTypeName("疏忽大意、措施不当");
		if ("D".equals(strRiskType)) {
		 // 车险出险原因代码：默认碰撞
			prpLregistDto.setDamageCode("204");
			prpLregistDto.setDamageName("碰撞");
			prpLregistDto.setClaimType("0");
			prpLregistDto.setClaimTypeName("一般赔案");
		} else if ("E".equals(strRiskType)) {
			prpLregistDto.setDamageCode("");
			prpLregistDto.setDamageName("");
			prpLregistDto.setDamageTypeCode(""); 
			prpLregistDto.setDamageTypeName("");
		}
		

		httpServletRequest.setAttribute("damageCodeList", ICollections
				.getDamageCodeList());
		httpServletRequest.setAttribute("damageTypeCodeList", ICollections
				.getDamageTypeCodeList());
		httpServletRequest.setAttribute("indemnityDutyList", ICollections
				.getIndemnityDutyList());

		// Reason:损失部位显示改为列表框方式
		httpServletRequest.setAttribute("partCodeList", ICollections
				.getPartCodeList());
		// Modify by chenrenda add end 20050404

		// Modify by chenrenda add begin 20050418
		// Reason:三个不同节点共用几个jsp文件时，客户端程序需要区分请求来自哪个节点
		String strPrpLnodeType = "regis";
		httpServletRequest.setAttribute("prpLnodeType", strPrpLnodeType);
		// Modify by chenrenda add end 20050418

		httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
		httpServletRequest.setAttribute("riskType", strRiskType);
		// 节点设置成报案，三者车辆
		prpLthirdPartyDto.setNodeType("regis");
		
		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		// add by qinyongli 2005-11-5 当修改出险时间时，刷新页面保存原来的值
		if (httpServletRequest.getParameter("modifyDamageDate") != null) {
			String reportName = httpServletRequest
					.getParameter("prpLregistReportorName");
			DateTime reportDate = new DateTime(httpServletRequest
					.getParameter("prpLregistReportDate"), DateTime.YEAR_TO_DAY);
			String reportHour = httpServletRequest
					.getParameter("prpLregistReportHour");
			String reportMinute = httpServletRequest
					.getParameter("prpLregistReportMinute");
			String reportType = httpServletRequest.getParameter("reportType");
			String registLink = httpServletRequest
					.getParameter("prpLregistLinkerName");
			String registLinkPhone = httpServletRequest
					.getParameter("prpLregistPhoneNumber");
			DateTime DamageDate = new DateTime(httpServletRequest
					.getParameter("prpLregistDamageStartDate"),
					DateTime.YEAR_TO_DAY);
			String theDamageHour = httpServletRequest
					.getParameter("prpLregistDamageStartHour");
			String theDamageMinute = httpServletRequest
					.getParameter("prpLregistDamageStartMinute");
			String prpLregistDamageAddress = httpServletRequest
					.getParameter("prpLregistDamageAddress");
			String prpLregistDamageCode = httpServletRequest
					.getParameter("prpLregistDamageCode");
			String prpLregistDamageName = httpServletRequest
					.getParameter("prpLregistDamageName");
			String prpLregistRegistNo = httpServletRequest
					.getParameter("prpLregistRegistNo");
			String prpLregistHandleUnit=httpServletRequest
			.getParameter("prpLregistHandleUnit");
			String prpLregistHandleUnitName=httpServletRequest
			.getParameter("prpLregistHandleUnitName");
			String prpLregistPersonDeathB=httpServletRequest
			.getParameter("prpLregistPersonDeathB");
			
			String prpLregistPersonInjureB=httpServletRequest
			.getParameter("prpLregistPersonInjureB");
			
			String prpLregistPersonDeathD1=httpServletRequest
			.getParameter("prpLregistPersonDeathD1");
			
			String prpLregistPersonInjureD1=httpServletRequest
			.getParameter("prpLregistPersonInjureD1");
			
			
			RegistDto registDtoTemp = viewToDto(httpServletRequest);
			if (registDtoTemp.getPrpLregistDto() !=null) {
				prpLregistDto.setReportorName(reportName);
				prpLregistDto.setReportorPhoneNumber(registDtoTemp.getPrpLregistDto().getReportorPhoneNumber());
				prpLregistDto.setLinkerName(registLink);
				
				prpLregistDto.setPhoneNumber (registDtoTemp.getPrpLregistDto().getPhoneNumber ());
				prpLregistDto.setLinkerPostCode( registDtoTemp.getPrpLregistDto().getLinkerPostCode());
				prpLregistDto.setLinkerAddress( registDtoTemp.getPrpLregistDto().getLinkerAddress());
			
				prpLregistDto.setDamageStartDate(DamageDate);
				prpLregistDto.setDamageStartHour(theDamageHour);
				prpLregistDto.setDamageStartMinute(theDamageMinute);
				prpLregistDto.setDamageCode(prpLregistDamageCode);
				prpLregistDto.setDamageName(prpLregistDamageName);
				prpLregistDto.setDamageAreaCode( registDtoTemp.getPrpLregistDto().getDamageAreaCode());
				prpLregistDto.setDamageAreaName( registDtoTemp.getPrpLregistDto().getDamageAreaName());
				prpLregistDto.setDamageAddress(prpLregistDamageAddress);
				prpLregistDto.setDamageAddressType( registDtoTemp.getPrpLregistDto().getDamageAddressType());
				
				prpLregistDto.setReportDate(reportDate);
				prpLregistDto.setReportHour(reportHour);
				prpLregistDto.setReportMinute(reportMinute);
				prpLregistDto.setReportType(reportType);
				prpLregistDto.setPersonDeathB( Long.parseLong( DataUtils.nullToZero(prpLregistPersonDeathB)));
				prpLregistDto.setPersonInjureB( Long.parseLong( DataUtils.nullToZero(prpLregistPersonInjureB)));
				
				prpLregistDto.setPersonDeathD1( Long.parseLong( DataUtils.nullToZero(prpLregistPersonDeathD1)));
				prpLregistDto.setPersonInjureD1( Long.parseLong( DataUtils.nullToZero(prpLregistPersonInjureD1)));
				
				
				prpLregistDto.setRegistNo(prpLregistRegistNo);
				prpLregistDto.setReportType(registDtoTemp.getPrpLregistDto().getReportType());
				prpLregistDto.setClaimType(registDtoTemp.getPrpLregistDto().getClaimType());
				prpLregistDto.setHandleUnit(prpLregistHandleUnit);
				prpLregistDto.setHandleUnitName( prpLregistHandleUnitName);
				
			}
			if (registDtoTemp.getPrpLthirdPartyDtoList()!=null){
				prpLthirdPartyDto.setThirdPartyList( registDtoTemp.getPrpLthirdPartyDtoList() );
			}
			if (registDtoTemp.getPrpLthirdCarLossDtoList() !=null){
			PrpLthirdCarLossDto prpLthirdCarLossDto =new PrpLthirdCarLossDto();
			prpLthirdCarLossDto.setThirdCarLossList(registDtoTemp.getPrpLthirdCarLossDtoList() );
			httpServletRequest.setAttribute("prpLthirdCarLossDto",
					prpLthirdCarLossDto);
			}
			
			if (registDtoTemp.getPrpLthirdPropDtoList() !=null){
				PrpLthirdPropDto prpLthirdPropDto =new PrpLthirdPropDto();
				prpLthirdPropDto.setThirdPropList(registDtoTemp.getPrpLthirdPropDtoList() );
				httpServletRequest.setAttribute("prpLthirdPropDto",
						prpLthirdPropDto);
			}
				
			if (registDtoTemp.getPrpLpersonTraceDtoList()  !=null){
				PrpLpersonTraceDto prpLpersonTraceDto=new PrpLpersonTraceDto();
				prpLpersonTraceDto.setPersonTraceList(registDtoTemp.getPrpLpersonTraceDtoList() );
				httpServletRequest.setAttribute("prpLpersonTraceDto",
						prpLpersonTraceDto);
			}
			
			if (registDtoTemp.getPrpLregistExtDtoList()   !=null){
				PrpLregistExtDto prpLregistExtDto=new PrpLregistExtDto();
				prpLregistExtDto.setRegistExtList(registDtoTemp.getPrpLregistExtDtoList() );
				httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);
			}
			
			if (registDtoTemp.getPrpLdriverDtoList ()   !=null){
				prpLdriverDto.setDriverList(registDtoTemp.getPrpLdriverDtoList ()  );
				httpServletRequest.setAttribute("prpLdriverDto", prpLdriverDto);
			}
		
			
			
			if (registDtoTemp.getPrpLregistTextDtoList()   !=null){
				String tempContext="";
				PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
				Iterator iterator = registDtoTemp.getPrpLregistTextDtoList().iterator();
				while (iterator.hasNext()) {
					PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
							.next();
					if (prpLregistTextDtoTemp.getTextType().equals("1")) {
						tempContext = tempContext
								+ prpLregistTextDtoTemp.getContext();
					}
				}
				prpLregistTextDto.setContext(tempContext);
				prpLregistTextDto.setTextType( "1");
				
				httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
				
			}
				
		}else{
			prpLregistDto.setDamageStartDate(new DateTime());
			prpLregistDto.setDamageStartHour("00");
			prpLregistDto.setDamageStartMinute("00");
		}
		// modify by qinyongli end
		
		httpServletRequest.setAttribute("prpLthirdPartyDto", prpLthirdPartyDto);
		if("ZH03".equals(riskCode))
		{
			prpLregistDto.setRemark(httpServletRequest.getParameter("faimlyNo"));
		}
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
		httpServletRequest.setAttribute("riskCName", uiCodeAction
				.translateRiskCode(prpLregistDto.getRiskCode(), true));

		// modify by wangwei add start 20050601
		// 原因：增加货运险保单信息
		PrpCmainCargoDto prpCmain_cargoDto = policyDto.getPrpCmainCargoDto();
		
		//add by lixiang start at 2006-7-17
		//reason:增加进行运输工具的转换
		if (prpCmain_cargoDto!=null){
			prpCmain_cargoDto.setConveyance(uiCodeAction.translateCodeCode("TransMode",prpCmain_cargoDto.getConveyance(),true));
		}
		//add by lixiang end at 2006-7-17
		httpServletRequest.setAttribute("prpCmain_cargoDto", prpCmain_cargoDto);
		
		strRiskType = uiCodeAction.translateRiskCodetoRiskType(riskCode);
		
		if ("Y".equals(strRiskType)) {
		    prpLregistDto.setAddressCode(prpCmain_cargoDto.getEndSiteCode());
			prpLregistDto.setDamageAddress(prpCmain_cargoDto.getEndSiteName());
		}
		// modify by wangwei add end 20050601
		httpServletRequest.setAttribute("prpLacciPersonDto", registDto
				.getPrpLacciPersonDto() == null ? new PrpLacciPersonDto()
				: registDto.getPrpLacciPersonDto());
		
//		
	}

	/**
	 * 根据报案号和保单号查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @throws Exception
	 */

	public void registDtoListToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo) throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		logger.info("根据报案号和保单号查询报案信息，对LIKE 进行了优化。");
		String conditions = "";
		conditions = " registNo = '" + registNo + "' AND policyNo = '"
				+ policyNo + "'";
		conditions = conditions
				+ "  And registno in (select BusinessNo from prpLclaimStatus where nodeType='regis') ";

		// 拼权限
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		//modify by zhaolu 20060817 start
		/**conditions = conditions
				+ uiPowerInterface.addPower(userDto.getUserCode(), "lpba", "a",
						BusinessRuleUtil.getOuterCode(httpServletRequest,
								"RISKCODE_DAA"));*/
		conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060817 end
		// 暂时不查本系统以外的数据，则使用条件
		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// 得到多行报案主表信息
		Collection registList = new ArrayList();
		Collection registLastList = new ArrayList();

		// System.out.println("conditions="+conditions);
		registList = (Collection) uiRegistAction.findByConditions(conditions);
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		Iterator it = registList.iterator();
		String operatorName = "";
		String operatorCode = "";
		UICodeAction uiCodeAction = new UICodeAction();
		while (it.hasNext()) {

			PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
			prpLregistDtoTemp = (PrpLregistDto) it.next();
			operatorCode = prpLregistDtoTemp.getOperatorCode();
			operatorName = uiCodeAction.translateUserCode(operatorCode, true);
			// System.out.println("handlerCode="+handlerCode);

			prpLregistDtoTemp.setOperatorName(operatorName);
			registLastList.add(prpLregistDtoTemp);
		}
		prpLregistDto.setRegistList(registLastList);

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}

	/**
	 * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */

	public void setPrpLregistDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo, String status,
			String operateDate, String riskCode, String insuredName,
			String pageNo, String recordPerPage) throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		status = StringUtils.rightTrim(status);
		operateDate = StringUtils.rightTrim(operateDate);
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		// prpLregistDto.setStatusName(statusName);
		prpLregistDto.setLicenseNo(licenseNo);
		riskCode = StringUtils.rightTrim(riskCode);
		insuredName = StringUtils.rightTrim(insuredName);
		String cancelFlag = StringUtils.rightTrim(httpServletRequest.getParameter("cancelFlag"));
		String registStartCancelDate = httpServletRequest.getParameter("registStartCancelDate");
	    String registEndCancelDate = httpServletRequest.getParameter("registEndCancelDate");
	    String queryRiskCode = httpServletRequest.getParameter("queryRiskCode");
 
		String conditions = " 1=1 ";
		if (registNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.registNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));
		}
		if(cancelFlag!=null){
			if(cancelFlag.equals("1")){
				if(registStartCancelDate != null && registStartCancelDate.length()>0){
			        conditions = conditions +" AND a.cancelDate >= '" + registStartCancelDate +"'";
			    }
				if(registEndCancelDate != null && registEndCancelDate.length()>0){
			        conditions = conditions +" AND a.cancelDate <= '" + registEndCancelDate +"'";
			    }
				if("".equals(registStartCancelDate) && "".equals(registEndCancelDate)){
					conditions = conditions + " AND (a.cancelDate is not null)";
				}
			}else if(cancelFlag.equals("0")){
				conditions = conditions + " AND a.cancelDate is null ";
			}
		}
	
		//		add by zhouliu start at 2006-6-9
//		reason:强三查询
		if (policyNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" c.policyNo", policyNo,
							httpServletRequest.getParameter("PolicyNoSign"));
		}
//		add by zhouliu end at 2006-6-9

	
//		if (riskCode.length() > 0) {
//			conditions = conditions
//					+ StringConvert.convertString(" a.riskCode", riskCode,
//							httpServletRequest.getParameter("RiskCodeSign"));
//		}
		if (queryRiskCode != null && !queryRiskCode.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertString("a.riskCode", queryRiskCode,
							"=");
		}
		if (insuredName.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.insuredName",
							insuredName, httpServletRequest
									.getParameter("InsuredNameSign"));
		}
        if(licenseNo.length() > 0){
        	conditions = conditions
        		 	+ StringConvert.convertString(" a.licenseNo",
        		 			licenseNo, httpServletRequest
							.getParameter("LicenseNoSign"));
        }
		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in (" + status + ")  AND (a.cancelDate is  null) ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							httpServletRequest.getParameter("OperateDateSign"));
		}
		String operateDateEnd = httpServletRequest.getParameter("OperateDateEnd");//操作时间截止
		operateDateEnd = StringUtils.rightTrim(operateDateEnd);
		if (operateDateEnd != null && !operateDateEnd.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDateEnd,
							httpServletRequest.getParameter("OperateDateSignEnd"));
		}
		
		 String comCode = StringUtils.rightTrim(httpServletRequest.getParameter("comCode"));
		 if(comCode!=null&&comCode.length()>0){
			 conditions = conditions +"  and exists (select 1  from prpdcompany  where uppercomcode = '"+comCode+"' and a.comcode = comcode) ";
		 }
		//start 用于电子档案数据库和核心数据库跨库查询条件拼接  add by jqzhang@gyic
		String strEarLabel = httpServletRequest.getParameter("EarLabel");
		String strFCardID = httpServletRequest.getParameter("FCardID");
		String strEarLabelSign = httpServletRequest.getParameter("EarLabelSign");
		String strFCardIDSign = httpServletRequest.getParameter("FCardIDSign");
		String strFname1 = httpServletRequest.getParameter("Fname1");
		String strFname1Sign = httpServletRequest.getParameter("Fname1Sign");
		String strFamilyNo = httpServletRequest.getParameter("FamilyNo");
		String strFamilyNoSign = httpServletRequest.getParameter("FamilyNoSign");
		String strFamilyFIDCard = httpServletRequest.getParameter("FamilyFIDCard");
		String strFamilyFIDCardSign = httpServletRequest.getParameter("FamilyFIDCardSign");
		String strFname = httpServletRequest.getParameter("Fname");
		String strFnameSign = httpServletRequest.getParameter("FnameSign");
		String strDZDACondition = "";
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			strDZDACondition = " and a.registno  in (" +
			" SELECT registno FROM prplcompensateear e" +
			" WHERE  e.nodetype='regis' " +
			StringConvert.convertString("e.Earno", strEarLabel, strEarLabelSign) + StringConvert.convertString("e.name", strFname,strFnameSign)//中央政策性养殖险专用
			+ ")";
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			strDZDACondition = " and a.policyno in (" +
			" SELECT policyno FROM Plantingpolicylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE  d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.Fname", strFname1,strFname1Sign) + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign)//中央政策性种植险专用
			+ ")";
		}

		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			strDZDACondition = "and a.policyno in (" +
			" SELECT policyno FROM ZH03policylist@NYXDB d,insuremainlist@NYXDB e " +
			" WHERE d.INUSRELISTCODE= e.INUSRELISTCODE and e.VALIDITY in ('2') and d.VALIDITY in ('1')  " +
			StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign) + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign)//农家福组合保险专用
			+ ")";
		}
		conditions = conditions + strDZDACondition;
		//end
		/*
		//start增加耳标查询条件
		String earLabel = httpServletRequest.getParameter("EarLabel");
		if(earLabel != null && !"".equals(earLabel.trim())){
			BLPrplcompensateearFacade blPrplcompensateearFacade = new BLPrplcompensateearFacade();
			String prplcompensateearDtoConditions = "Earno = '" + earLabel  + "' and nodetype='regis'";
			String fname = httpServletRequest.getParameter("Fname");
			if(fname != null && !"".equals(fname.trim())){
				prplcompensateearDtoConditions = prplcompensateearDtoConditions + "and name ='" + fname.trim() +"'";
			}
			ArrayList PrplcompensateearDtoList = (ArrayList)blPrplcompensateearFacade.findByConditions(prplcompensateearDtoConditions);
			if(PrplcompensateearDtoList != null && PrplcompensateearDtoList.size() >0){
				String condition = "and a.Registno in (";
				for(int i = 0; i < PrplcompensateearDtoList.size(); i++){
					PrplcompensateearDto prplcompensateearDto = new PrplcompensateearDto();
					prplcompensateearDto = (PrplcompensateearDto)PrplcompensateearDtoList.get(i);
					if(i == 0)
						condition = condition +"'"+ prplcompensateearDto.getRegistno()+ "'";
					else
						condition = condition + ",'" + prplcompensateearDto.getRegistno() +"'";
				}
				conditions = conditions + condition + ")";
			}
			else
				conditions = " 1!=1 and " + conditions;
		}
		//end增加耳标查询条件
		//start增加中央政策性种植险农户身份证查询条件
		String FCardID = httpServletRequest.getParameter("FCardID");
		if(FCardID != null && !"".equals(FCardID.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="FIDCARD = '" + FCardID.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND a.POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					conditions = conditions + mainConditions;
    				} 
    				else
                		conditions = " 1!=1 and " + conditions;	
            }
            else
				conditions = " 1!=1 and " + conditions;
		}
		//end增加中央政策性种植险农户身份证查询条件
		//start增加中央政策性种植险农户姓名查询条件
		String Fname1 = httpServletRequest.getParameter("Fname1");
		if(Fname1 != null && !"".equals(Fname1.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="Fname = '" + Fname1.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND a.POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					conditions = conditions + mainConditions;
    				} 
    				else
                		conditions = " 1!=1 and " + conditions;	
            }
            else
				conditions = " 1!=1 and " + conditions;
		}
		//end增加中央政策性种植险农户姓名查询条件
		 */
		 //add by zhaolu 20060802 start
		 //加入权限
        
	       /**com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
	       UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
	       conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),com.sinosoft.claim.util.BusinessRuleUtil.transTaskCode("regis"),"a",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
	       //uiPowerInterface.addPower(userDto.getUserCode(),"lp","swflog",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));*/
		   //add by zhaolu 20060815 start
		   //reason添加新权限
		   UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		   UIPowerInterface uiPowerInterface = new UIPowerInterface();
		   //modify by zhaolu 20060830 start
		   conditions = conditions + uiPowerInterface.addRiskPower(userDto,"a") + uiPowerInterface.addCustomerPower(userDto,"a","","ComCode");
		   //conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		   //modify by zhaolu 20060830 end
		   //add by zhaolu 20060815 end
	      
	      //从翻页取数据
	       String condition = httpServletRequest.getParameter("condition");
	       if(condition!=null && condition.trim().length()>0){ 
	          conditions = condition;
	       }
	       //add by zhaolu 20060802 end
		
		// conditions = conditions + " AND b.status IS NOT NULL";
		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// //System.out.println("DAARegistViewHelper condition
		// ######="+conditions);
		// 得到多行报案主表信息
		ArrayList registList = new ArrayList();
		PageRecord pageRecord = (PageRecord) uiRegistAction
				.findByQueryConditions(conditions, pageNo, recordPerPage);
		registList = (ArrayList) pageRecord.getResult();
		prpLregistDto.setRegistList(registList);

		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(registList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		turnPageDto.setCondition(conditions);
		prpLregistDto.setTurnPageDto(turnPageDto);
		// //System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}

	/**
	 * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件 Modify
	 *             By dongchengliang 2005-05-28 Reason:增加险种查询条件
	 */

	public void setPrpLregistDtoToView(HttpServletRequest httpServletRequest,
			WorkFlowQueryDto workFlowQueryDto)
			throws Exception {
		String registNo = StringUtils.rightTrim(workFlowQueryDto.getRegistNo());
		String policyNo = StringUtils.rightTrim(workFlowQueryDto.getPolicyNo());
		String licenseNo = StringUtils.rightTrim(workFlowQueryDto.getLicenseNo());
		String status = StringUtils.rightTrim(workFlowQueryDto.getStatus());
		String operateDate = StringUtils.rightTrim(workFlowQueryDto.getOperateDate());
		String riskCode = StringUtils.rightTrim(workFlowQueryDto.getRiskCode());
		String cancelFlag = StringUtils.rightTrim(workFlowQueryDto.getCancelFlag());
		String insuredName = StringUtils.rightTrim(workFlowQueryDto.getInsuredName()); 
		String registStartCancelDate = StringUtils.rightTrim(workFlowQueryDto.getRegistStartCancelDate()); 
		String registEndCancelDate = StringUtils.rightTrim(workFlowQueryDto.getRegistEndCancelDate());
		PrpLregistDto prpLregistDto = new PrpLregistDto();

	
		String conditions = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("a.registNo", registNo,
						workFlowQueryDto.getRegistNoSign());
		
		if (policyNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" c.policyNo", policyNo,
							workFlowQueryDto.getPolicyNoSign());
		}
		conditions = conditions
				+ StringConvert.convertString("a.riskCode", riskCode,
						workFlowQueryDto.getRiskCodeSign());
		conditions = conditions
				+ StringConvert.convertString("a.licenseNo", licenseNo,
						workFlowQueryDto.getLicenseNoSign());

		// 添加被保险人查询条件 2005-07-12
		conditions = conditions
				+ StringConvert.convertString("a.InsuredName", insuredName,
						workFlowQueryDto.getInsuredNameSign());

		if (status != null && status.trim().length() > 0) {
			conditions = conditions + " AND b.status in (" + status + ") ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							workFlowQueryDto.getOperateDateSign());
		}
		//add by miaowenjun 20060411 判断是否报案注销
		if(cancelFlag.equals("1")){
			if(registStartCancelDate != null && registStartCancelDate.length()>0){
		        conditions = conditions +" AND a.cancelDate >= '" + registStartCancelDate +"'";
		    }
			if(registEndCancelDate != null && registEndCancelDate.length()>0){
		        conditions = conditions +" AND a.cancelDate <= '" + registEndCancelDate +"'";
		    }
			if("".equals(registStartCancelDate) && "".equals(registEndCancelDate)){
				conditions = conditions + " AND (a.cancelDate is not null)";
			}
		}else if(cancelFlag.equals("0")){
			conditions = conditions + " AND a.cancelDate is null ";
		}
		//add end by miaowenjun 20060411
		// 拼权限
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		//modify by zhaolu 20060817 start

		conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060817 end
		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// 得到多行报案主表信息
		Collection registList = new ArrayList();
		registList = (Collection) uiRegistAction
				.findByQueryConditions(conditions);

		prpLregistDto.setRegistList(registList);

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}

	public void setPrpLregistDtoToPrint(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String insuredName,
			String licenseNo) throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		insuredName = StringUtils.rightTrim(insuredName);
		licenseNo = StringUtils.rightTrim(licenseNo);

		PrpLregistDto prpLregistDto = new PrpLregistDto();

		String conditions = " 1=1 ";
		if (!registNo.equals(""))
			conditions = conditions + " and registNo ='" + registNo + "'";
		if (!policyNo.equals(""))
			conditions = conditions + "and  policyNo ='" + policyNo + "'";
		if (!insuredName.equals(""))
			conditions = conditions + " and insuredName ='" + insuredName + "'";
		if (!licenseNo.equals(""))
			conditions = conditions + " and licenseNo ='" + licenseNo + "'";

		// 拼权限
		
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		//modify by zhaolu 20060817 start
		/**conditions = conditions
				+ uiPowerInterface.addPower(userDto.getUserCode(), "lpba",
						"prplregist", BusinessRuleUtil.getOuterCode(
								httpServletRequest, "RISKCODE_DAA"));*/
		conditions = conditions + uiPowerInterface.addPower(userDto,"prplregist","","ComCode");
		//modify by zhaolu 20060817 end
//		log.debug("要查询的条件conditions=" + conditions);
		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// 得到多行报案主表信息
		Collection registList = new ArrayList();
		registList = (Collection) uiRegistAction.findByConditions(conditions);
		if (registList == null || registList.size() == 0) {
			throw new UserException(-98, -1000,
					"uiRegistAction.findByConditions(" + conditions + ")");
		}
		prpLregistDto.setRegistList(registList);

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		// System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}

	/**
	 * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @throws Exception
	 *             Modify By sunhao 2004-08-24 Reason:增加车牌号，案件状态，操作时间查询条件
	 */

	public void setPrpLregistDtoToView(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo, String status,
			String operateDate, String riskCode, String insuredName)
			throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		status = StringUtils.rightTrim(status);
		operateDate = StringUtils.rightTrim(operateDate);
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		// prpLregistDto.setStatusName(statusName);
		// prpLregistDto.setLicenseNo(licenseNo);
		riskCode = StringUtils.rightTrim(riskCode);
		insuredName = StringUtils.rightTrim(insuredName);

		String IDCard = httpServletRequest.getParameter("IDCardFlag");

		String conditions = " 1=1 ";
		if (registNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.registNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));
		}
		if (policyNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.policyNo", policyNo,
							httpServletRequest.getParameter("PolicyNoSign"));
		}

		if (riskCode.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.riskCode", riskCode,
							httpServletRequest.getParameter("RiskCodeSign"));
		}

		if (insuredName.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.insuredName",
							insuredName, httpServletRequest
									.getParameter("InsuredNameSign"));
		}

		if (status.trim().length() > 0) {
			conditions = conditions + " AND b.status in (" + status + ") ";
		}
		if (operateDate != null && !operateDate.trim().equals("")) {
			conditions = conditions
					+ StringConvert.convertDate("b.operateDate", operateDate,
							httpServletRequest.getParameter("OperateDateSign"));
		}
		// conditions = conditions + " AND b.status IS NOT NULL";
		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// System.out.println("DAARegistViewHelper condition
		// ######="+conditions);
		// 得到多行报案主表信息
		Collection registList = new ArrayList();
		registList = (Collection) uiRegistAction
				.findByQueryConditions(conditions);

		prpLregistDto.setRegistList(registList);

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

	}

	//add by lym 20060605 for 强三 ----start
	/*计算强三出险次数*/
	public void getQsRegistInfo(HttpServletRequest httpServletRequest,
			String policyNo ) throws Exception {
		int intPerilCount =0;  //出险次数
		int intRecentCount=0;   //最近出险次数
		int intervalDay = 0;
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		String registNo="";
		
		UIRegistAction  uiRegistAction  = new UIRegistAction (); 
		UIPolicyAction  uiPolicyAction =new UIPolicyAction();
		PrpLRegistRPolicyDto prpLRegistRPolicyDto = new PrpLRegistRPolicyDto();
		PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);
	    ArrayList  prpLRegistRPolicyDtoList =	policyDto.getPrpLRegistRPolicyDtoList();
	    
	   if ( prpLRegistRPolicyDtoList!= null && prpLRegistRPolicyDtoList.size()>0) {
		    intPerilCount = prpLRegistRPolicyDtoList.size();  //出险次数
		    for ( int i =0; i< prpLRegistRPolicyDtoList.size();i++ ) {  //求最近五天内出险次数
		    	prpLRegistRPolicyDto = (PrpLRegistRPolicyDto) prpLRegistRPolicyDtoList.get(i);
		    	registNo = prpLRegistRPolicyDto.getRegistNo();
		    	RegistDto  registDto =uiRegistAction.findByPrimaryKey(registNo);
		    	PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		    	
		    	intervalDay = DateTime.intervalDay(prpLregistDto.getDamageStartDate(), 0, dateTime, 0);
				   
				 if (intervalDay <= Integer.parseInt(priorDate)) {
					intRecentCount++;
					//System.out.println("出险次数的时间差<5");
				 }
		    	
		    }
	   }
	  httpServletRequest.setAttribute("intPerilCount",String.valueOf(intPerilCount));
	  httpServletRequest.setAttribute("intRecentCount",String.valueOf(intRecentCount));
	}
	
	
	
	public boolean  checkDate(HttpServletRequest httpServletRequest,String policyNo,
			                String damageDate,int damageHour,int damageMinute)
	throws Exception {
	 boolean  valid = false ;
	   UIPolicyAction  uiPolicyAction  = new UIPolicyAction(); 
	   DBPrpCitemCarExt dbPrpCitemCarExt = new DBPrpCitemCarExt();
	   dbPrpCitemCarExt.getInfo(policyNo);
	   //即时生效的保单，保险期限用prpcitemCarExt中的保险期限进行判断
	   if("1".equals(dbPrpCitemCarExt.getImmediateValidFlag())){
		   String strWhere = " policyno='" + policyNo + "' And to_date('" + damageDate + " " + damageHour + 
		        ":" + damageMinute + ":00','yyyy-MM-dd HH24:MI:SS') " + 
		   		"  Between startdate And enddate";
		   if(dbPrpCitemCarExt.getCount(strWhere) > 0){
			   return true;
		   }else{
			   return false;
		   }
	   }
	   
	   PolicyDto policyDto = uiPolicyAction.findByPrimaryKey(policyNo);	   
	   PrpCmainDto  prpCmainDto =  policyDto.getPrpCmainDto();
	   
	   if (prpCmainDto==null) return false;	
	   DateTime startDate = prpCmainDto.getStartDate() ;
	   int startHour= prpCmainDto.getStartHour();
	   DateTime endDate =prpCmainDto.getEndDate();
	   int endHour=prpCmainDto.getEndHour();
	 
	 if ( startDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {  //起保日期>出险日期
 	 	valid =false;  
 	}else if ( startDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) { //起保日期<出险日期
 		
         if (endDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {//终保日期>出险日期
         	valid =true;
 		}
         else  if (endDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) { //终保日期<出险日期
        	 valid =false;
 		}
         else {  ////终保日期  = 出险日期
         	if ( endHour > damageHour){
         		valid =true; }
         	else {
         		valid =false;
         	}
         }
   	}else {  //起保日期 = 出险日期
 		if ( startHour > damageHour){
 			valid =false; 
 		}else {
 			 if (endDate.toString().compareTo(new DateTime(damageDate).toString()) >0 ) {
 				 valid =true;
 		     }
	             else  if (endDate.toString().compareTo(new DateTime(damageDate).toString()) <0 ) {
	            		valid =false; 
 		     }
	             else {
	            	if ( endHour > damageHour){
	            		valid =true; 
	    			}
	               	else {
	               		valid =false;
	               	}
	             } 	
 		}
 		
 	}
	
	  return valid;	
	}
	
	//add by lym 20060605 for 强三 ----end
	
	/**
	 * 查询已经报案的数据，计算出现次数来进行显示
	 * 
	 * @param httpServletRequest
	 * @param policyNo 保单号
	 * @param curRegistNo 当前报案号
	 * @throws Exception
	 */
	public void getSamePolicyRegistInfo(HttpServletRequest httpServletRequest,
			String policyNo, String curRegistNo) throws Exception {
		logger.info("查询当前保单的出险次数");
		UIRegistAction uiRegistAction = new UIRegistAction();
		ArrayList registList = new ArrayList();
		ArrayList registLastList = new ArrayList();
		PrpLregistDto prpLregistDtoTemp = new PrpLregistDto();
		PrpLregistDto prpLregistDtoPre = new PrpLregistDto();
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		UICodeAction uiCodeAction = new UICodeAction();
		String strOperatorCode = "";
		String strOperatorName = "";
		registList = (ArrayList) uiRegistAction.findSamePolicyRegist(policyNo);
		int intPerilCount = 0;
		int intRecentCount = 0; // 最近几天的出险次数
		String priorDate = AppConfig.get("sysconst.RegistViewLimitDay");
		DateTime dateTime = new DateTime(DateTime.current().toString(),
				DateTime.YEAR_TO_DAY);
		int intervalDay = 0;
		Iterator it = registList.iterator();
		// 转换操作人员的名称，以及计算个数,去掉由于出险部位引起的问题
		String oldRegistNo = "";
		String nowRegistNo = "";
		int rowNo = 0;
		int rowCount = 0;
		if (registList != null)
			rowCount = registList.size(); // 计算数据的数目
		String strBrandNameTemp = "";// 受损部位的名称

		if (curRegistNo == null)
			curRegistNo = "";
		for (rowNo = 0; rowNo < rowCount; rowNo++) {
			oldRegistNo = nowRegistNo;
			prpLregistDtoPre = prpLregistDtoTemp;
			prpLregistDtoTemp = (PrpLregistDto) registList.get(rowNo);
			nowRegistNo = prpLregistDtoTemp.getRegistNo();
			intervalDay = DateTime.intervalDay(prpLregistDtoTemp
					.getDamageStartDate(), 0, dateTime, 0);
			 /*System.out.println("出险次数的时间差=" + intervalDay + "|" + dateTime +
			 "|"
			 + prpLregistDtoTemp.getDamageStartDate());*/
            
			 if (intervalDay <= Integer.parseInt(priorDate)) {
				intRecentCount++;
				//System.out.println("出险次数的时间差<5");
			 }
			 
			// 如果为第一行，或者中间行，并且报案号不等于上一行的，或者小于最后一行的，
			if (rowNo == 0
					&& rowCount != 1
					|| ((rowNo != (rowCount - 1)) && (rowNo > 0) && (oldRegistNo
							.equals(nowRegistNo)))) {
				if (oldRegistNo.equals(nowRegistNo)) {
					prpLregistDtoTemp.setBrandName(prpLregistDtoPre
							.getBrandName()
							+ " " + prpLregistDtoTemp.getBrandName());
				}
				// add by zhulei begin 20050901
				// 接着就continue了，这里需要补个intPerilCount记数
				else {
					intPerilCount++;
				}
				// add by zhulei end 20050901 接着就continue了，这里需要补个intPerilCount记数
				continue;
			}
			// 添加上行记录

			if ((rowNo == rowCount - 1) && (oldRegistNo.equals(nowRegistNo))) {
				prpLregistDtoPre.setBrandName(prpLregistDtoPre.getBrandName()
						+ " " + prpLregistDtoTemp.getBrandName());
			}
			// modify by wangli update start 20050420
			// reason:如果是第一次出险 intPerilCount就不应该再增加
			// 本次出险不计算在内
			
			if ((rowNo == rowCount - 1) && !curRegistNo.equals(nowRegistNo)
					&& (!oldRegistNo.equals(nowRegistNo))) {
				
				intPerilCount++;
				strOperatorCode = prpLregistDtoTemp.getOperatorCode();
				strOperatorName = uiCodeAction.translateUserCode(
						strOperatorCode, true);
				prpLregistDtoTemp.setOperatorName(strOperatorName);
				prpLregistDtoTemp.setStatus(uiCodeAction.translateCodeCode(
						"ClaimStatus", prpLregistDtoTemp.getStatus(), true));
				prpLregistDtoTemp.setStatus(uiCodeAction.translateCodeCode(
						"ClaimStatus", prpLregistDtoTemp.getStatus(), true));
				prpLregistDtoTemp.setSerialNo(intPerilCount);
				registLastList.add(prpLregistDtoTemp);
			} else {
				if (rowCount != 1 && !curRegistNo.equals(nowRegistNo)) {
					/*if (intervalDay <= Integer.parseInt(priorDate)) {
						intRecentCount++;
					}*/
					intPerilCount++;
					strOperatorCode = prpLregistDtoPre.getOperatorCode();
					strOperatorName = uiCodeAction.translateUserCode(
							strOperatorCode, true);
					prpLregistDtoPre.setOperatorName(strOperatorName);
					prpLregistDtoPre.setStatus(uiCodeAction.translateCodeCode(
							"ClaimStatus", prpLregistDtoPre.getStatus(), true));
					prpLregistDtoPre.setStatus(uiCodeAction.translateCodeCode(
							"ClaimStatus", prpLregistDtoPre.getStatus(), true));
					prpLregistDtoPre.setSerialNo(intPerilCount);
					registLastList.add(prpLregistDtoPre);
				}
				// modify by wangli update end 20050420
			}
		}
		// 将查询出来的同个保单的数据放入PrpLregistDto的list
		prpLregistDto.setRegistList(registLastList);
		// 计算出险的次数
		prpLregistDto.setPerilCount(intPerilCount);
		prpLregistDto.setRecentCount(intRecentCount);

		httpServletRequest.setAttribute("policyNo", policyNo);
		httpServletRequest.setAttribute("curRegistNo", curRegistNo);

		httpServletRequest.setAttribute("prpLregistDto1", prpLregistDto);
		httpServletRequest.setAttribute("prpLregistDto1", prpLregistDto);
	}

	/**
	 * 报案前的保单查询 根据车牌号，操作时间，案件状态查询保单信息(此部分就是根据保单信息查询出保单的列表信息 )
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param pageNo
	 *            页码
	 * @param recordPerPage
	 *            每页显示的行数
	 * @throws Exception
	 */

	public void policyListToView(HttpServletRequest httpServletRequest,
			String pageNo, String recordPerPage) throws Exception {
		// System.out.println("-------&&----policyListToView----1
		// ---------------");
		// 根据输入的保单号，保单时间，被保险人，车牌，车驾号，发动机号生成SQL where 子句
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		// 保单号码
		String strPolicyNo = httpServletRequest.getParameter("PolicyNo");
		String strPolicyNoSign = httpServletRequest
				.getParameter("PolicyNoSign");
		//老系统保单号
		String strOldPolicyNo = httpServletRequest.getParameter("OldPolicyNo");
		String strOldPolicyNoSign = httpServletRequest.getParameter("OldPolicyNoSign");
		// 被保险人
		String strInsuredName = httpServletRequest.getParameter("InsuredName");
		String strInsuredNameSign = httpServletRequest
				.getParameter("InsuredNameSign");
		// 起保日期
		String strStartDate = httpServletRequest.getParameter("StartDate");
		String strStartDateSign = httpServletRequest
				.getParameter("StartDateSign");
		// 终保日期
		String strEndDate = httpServletRequest.getParameter("EndDate");
		String strEndDateSign = httpServletRequest.getParameter("EndDateSign");
		// 车牌号码
		String strLicenseNo = httpServletRequest.getParameter("LicenseNo");
		String strLicenseNoSign = httpServletRequest
				.getParameter("LicenseNoSign");
		// 发动机号
		String strEngineNo = httpServletRequest.getParameter("EngineNo");
		String strEngineNoSign = httpServletRequest
				.getParameter("EngineNoSign");
		// 车架号
		String strFrameNo = httpServletRequest.getParameter("FrameNo");
		String strFrameNoSign = httpServletRequest.getParameter("FrameNoSign");
		String strFnameFor32 = "";
		String strEarLabelFor32 = "";
		// 增加险种查询 by qinyongli 2005-8-26
		//String strRiskCode = httpServletRequest.getParameter("RiskCode");
		//String strRiskCodeSign = httpServletRequest.getParameter("RiskCodeSign");
		String strRiskType = httpServletRequest.getParameter("RiskType");
		String strRiskTypeSign = httpServletRequest.getParameter("RiskTypeSign");
		//String riskCode= httpServletRequest.getParameter("RiskCode");
		// modify by wangwei add start 2005-06-15
		// 原因：添加身份证号查询条件
		String strIdentifyNumber = httpServletRequest
				.getParameter("IdentifyNumber");
		String strIdentifyNumberSign = httpServletRequest
				.getParameter("IdentifyNumberSign");
		// modify by wangwei add end 2005-06-15

		// modify by wangli add start 200504017
		// DateTime systemFlowInTime = new
		// DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND );
		// .toString();//取系统时间
		// System.out.println("%%%%%%%%%%%%%%%%%%%%%%王立的测试
		// 系统时间×××××××××"+systemFlowInTime);
		// httpServletRequest.setAttribute("systemFlowInTime",systemFlowInTime);
		// prpLregistDto.setFlowInTime(systemFlowInTime);
		// modify by wangli add start 200504017
		// 出险日期
		String damageDate = httpServletRequest.getParameter("DamageDate");
		String damageHour = httpServletRequest.getParameter("DamageHour");
		//System.out.println("zhangting" + damageDate);
		// 后加入其它条件
		//保单流水号
		String strPolicyNoPrintNo = httpServletRequest.getParameter("PolicyNoPrintNo");
		String strPolicyNoPrintNoSign = httpServletRequest.getParameter("PolicyNoPrintNoSign");
		String strEarLabel = httpServletRequest.getParameter("EarLabel");
		String strFCardID = httpServletRequest.getParameter("FCardID");
		String strEarLabelSign = httpServletRequest.getParameter("EarLabelSign");
		String strFCardIDSign = httpServletRequest.getParameter("FCardIDSign");
		String strFname1 = httpServletRequest.getParameter("Fname1");
		String strFname1Sign = httpServletRequest.getParameter("Fname1Sign");
		String strFamilyNo = httpServletRequest.getParameter("FamilyNo");
		String strFamilyNoSign = httpServletRequest.getParameter("FamilyNoSign");
		String strFamilyFIDCard = httpServletRequest.getParameter("FamilyFIDCard");
		String strFamilyFIDCardSign = httpServletRequest.getParameter("FamilyFIDCardSign");
		String strFname = httpServletRequest.getParameter("Fname");
		String strFnameSign = httpServletRequest.getParameter("FnameSign");
		
		//针对【旅行意外伤害险】的个性化处理：增加专用的【姓名】和【身份证号】的查询条件
		String strInsuredNameSign_2743=httpServletRequest.getParameter("InsuredNameSign_2743");
		String strInsuredName_2743=httpServletRequest.getParameter("InsuredName_2743");
		String strIdentifyNumberSign_2743=httpServletRequest.getParameter("IdentifyNumberSign_2743");
		String strIdentifyNumber_2743=httpServletRequest.getParameter("IdentifyNumber_2743");
		String cinsuredConditons="";
		String cvirturlitemConditons="";
		
		//针对【0310农房】的个性化处理：增加专用的【姓名】和【身份证号】的查询条件 add by xiatian 
		String strAreasCode=httpServletRequest.getParameter("AreasCode");
		//String strAreaCode_0310=httpServletRequest.getParameter("AreaCode_0310");
		String strIdentifyNumberSign_0310=httpServletRequest.getParameter("IdentifyNumberSign_0310");
		String strIdentifyNumber_0310=httpServletRequest.getParameter("IdentifyNumber_0310");

		
		// 查询的条件
		String conditions = " 1=1 ";
		String conditions1 = " 1=1 ";
		String conditions2 = " 1=1 ";
		String conditions3 = " 1=1 ";
		conditions = conditions
				+ StringConvert.convertString("a.PolicyNo", strPolicyNo,
						strPolicyNoSign);
		//老系统的保单号存在新系统的PrpCmain表的Remark字段中
		conditions = conditions
		        + StringConvert.convertString("a.Remark", strOldPolicyNo, strOldPolicyNoSign);
		
		conditions = conditions
				+ StringConvert.convertString("a.InsuredName", strInsuredName,
						strInsuredNameSign);
		conditions = conditions
				+ StringConvert.convertString("b.LicenseNo", strLicenseNo,
						strLicenseNoSign);
		conditions = conditions
				+ StringConvert.convertString("b.FrameNo", strFrameNo,
						strFrameNoSign);
		conditions = conditions
				+ StringConvert.convertString("b.EngineNo", strEngineNo,
						strEngineNoSign);
		conditions = conditions
				+ StringConvert.convertDate("a.StartDate", strStartDate,
						strStartDateSign);
		conditions1 = conditions1
		+ StringConvert.convertDate("e.Starttime", strStartDate,
				strStartDateSign);
		
		conditions2 = conditions2
		+ StringConvert.convertDate("e.Starttime", strStartDate,
				strStartDateSign);
		conditions3 = conditions3
		+ StringConvert.convertDate("e.Starttime", strStartDate,
				strStartDateSign);
		conditions = conditions
				+ StringConvert.convertDate("a.EndDate", strEndDate,
						strEndDateSign);
		conditions1 = conditions1
		+ StringConvert.convertDate("e.Endtime", strEndDate,
				strEndDateSign);
		
		conditions2 = conditions2
		+ StringConvert.convertDate("e.Endtime", strEndDate,
				strEndDateSign);
		conditions3 = conditions3
		+ StringConvert.convertDate("e.Endtime", strEndDate,
				strEndDateSign);
		//System.err.println("conditions2_1:" + conditions2);
		
		conditions = conditions
		+ StringConvert.convertString("a.PrintNo", strPolicyNoPrintNo,
				strPolicyNoPrintNoSign);
		
		if(strRiskType != null && !"".equals(strRiskType)){
			conditions = conditions + " and a.riskcode=c.OuterCode ";
			conditions = conditions
			+ StringConvert.convertString("c.RiskType", strRiskType,
					strRiskTypeSign);
		}else{
			conditions = conditions + " and a.riskcode=c.OuterCode ";
		}
//		if (riskCode != null && !"".equals(riskCode)) {
//			conditions = conditions + " and a.riskcode='"+riskCode+"' ";
//		}
		// 增加身份号查询条件
		if (strIdentifyNumber != null && !strIdentifyNumber.equals("")) {
			conditions = conditions
					+ " AND a.PolicyNo in (Select distinct PolicyNo From Prpcinsured Where 1=1 "
					+ StringConvert.convertString("IdentifyNumber",
							strIdentifyNumber, strIdentifyNumberSign)
					+ StringConvert.convertString("a.PolicyNo", strPolicyNo,
							strPolicyNoSign) + ")";
		}
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			//strFnameFor32 = strFname;
			//strEarLabelFor32 = strEarLabel;
			//conditions = conditions + StringConvert.convertString("d.Earlabel", strEarLabel, strEarLabelSign);//中央政策性养殖险专用
			//conditions = conditions + StringConvert.convertString("d.Fname", strFname,strFnameSign);//中央政策性养殖险专用
			conditions1 = conditions1 + StringConvert.convertString("d.Earlabel", strEarLabel, strEarLabelSign);
			conditions1 = conditions1 + StringConvert.convertString("d.Fname", strFname,strFnameSign);
			if((strAreasCode != null && !"".equals(strAreasCode.trim())))
			{
				conditions1 = conditions1 + StringConvert.convertStringForEar("e.fareacode", strAreasCode,"*");//农房险专用
			}
		}

		else if((strFname1 != null && !"".equals(strFname1.trim()))||(strFCardID != null && !"".equals(strFCardID.trim()))){
			conditions = conditions + StringConvert.convertString("d.FIDCARD", strFCardID,strFCardIDSign);//中央政策性种植险专用
			conditions = conditions + StringConvert.convertString("d.Fname", strFname1,strFname1Sign);//中央政策性种植险专用
		}

		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			conditions3 = conditions3 + StringConvert.convertString("d.FamilyNo", strFamilyNo, strFamilyNoSign);//农家福组合保险专用
			conditions3 = conditions3 + StringConvert.convertString("d.FamilyFIDCard", strFamilyFIDCard, strFamilyFIDCardSign);//农家福组合保险专用
		}
		//针对2743险种的个性化处理
		else if((strInsuredName_2743 != null && !"".equals(strInsuredName_2743.trim())) || (strIdentifyNumber_2743 != null && !"".equals(strIdentifyNumber_2743.trim()))){
			cinsuredConditons=" and a.policyno in (select distinct policyno from prpcinsured where 1=1 and insuredflag='1'";
			cvirturlitemConditons=" union all select distinct policyno from prpcvirturlitem where 1=1";
			//拼接【被保险人】的查询条件
			if(strInsuredName_2743 != null && !"".equals(strInsuredName_2743.trim())){
				cinsuredConditons=cinsuredConditons+StringConvert.convertString("insuredname", strInsuredName_2743, strInsuredNameSign_2743);
				cvirturlitemConditons=cvirturlitemConditons+StringConvert.convertString("familyname", strInsuredName_2743, strInsuredNameSign_2743);
			}
			//拼接【身份证号】的查询条件
			if(strIdentifyNumber_2743 != null && !"".equals(strIdentifyNumber_2743.trim())){
				cinsuredConditons=cinsuredConditons+StringConvert.convertString("identifynumber", strIdentifyNumber_2743, strIdentifyNumberSign_2743);
				cvirturlitemConditons=cvirturlitemConditons+StringConvert.convertString("identifynumber", strIdentifyNumber_2743, strInsuredNameSign_2743);
			}
			cinsuredConditons=cinsuredConditons+StringConvert.convertString("a.PolicyNo", strPolicyNo, strPolicyNoSign);
			cvirturlitemConditons=cvirturlitemConditons+StringConvert.convertString("a.PolicyNo", strPolicyNo, strPolicyNoSign)+")";
			
			conditions=conditions+cinsuredConditons+cvirturlitemConditons;
		}
		//针对0310险种的个性化处理
		else if((strAreasCode != null && !"".equals(strAreasCode.trim()))||(strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim()))){
			conditions2 = conditions2 + StringConvert.convertString("d.idcard", strIdentifyNumber_0310, strIdentifyNumberSign_0310);//农房险专用
			conditions2 = conditions2 + StringConvert.convertString("e.fareacode", strAreasCode,"*");//农房险专用
			//System.err.println("conditions2_2:"+ conditions2);
		}
		

		

		//start增加耳标查询条件

		//if(strEarLabel != null && !"".equals(strEarLabel.trim())){
			/*
			BLHerdpolicylistFacade bLHerdpolicylistFacade = new BLHerdpolicylistFacade();
			InsuremainlistDto insuremainlistDto = new InsuremainlistDto();
			String herdpolicylistDtoConditions = "1=1";
			herdpolicylistDtoConditions = herdpolicylistDtoConditions + StringConvert.convertString("d.Earlabel", earLabel, earLabelSign);
			String fname = httpServletRequest.getParameter("Fname");
			if(fname != null && !"".equals(fname.trim())){
				herdpolicylistDtoConditions = herdpolicylistDtoConditions + "and d.fname ='" + fname.trim() +"'";
			}
			ArrayList herdPolicyListDtoList = (ArrayList)bLHerdpolicylistFacade.findByConditions(herdpolicylistDtoConditions);
			if(herdPolicyListDtoList != null && herdPolicyListDtoList.size() >0){
				String insuremainlistConditions = "Inusrelistcode in (";
				for(int i = 0; i < herdPolicyListDtoList.size(); i++){
					HerdpolicylistDto herdPolicyListDto = new HerdpolicylistDto();
					herdPolicyListDto = (HerdpolicylistDto)herdPolicyListDtoList.get(i);
					if(i == 0)
						insuremainlistConditions = insuremainlistConditions +"'"+ herdPolicyListDto.getInusrelistcode()+"'";
					else
						insuremainlistConditions = insuremainlistConditions + ",'" + herdPolicyListDto.getInusrelistcode()+"'";
				}
				insuremainlistConditions = insuremainlistConditions + ")";
				BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
				ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
				if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
					String mainConditions = "AND a.POLICYNO in (";
					for(int i = 0; i < insureMainListDtoList.size(); i++){
						InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
						InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
						if(i == 0)
							mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
						else
							mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
					}
					mainConditions = mainConditions + ")";
					conditions = conditions + mainConditions;
				}
				else
					conditions = " 1!=1 and " + conditions;
			}
			else
				conditions = " 1!=1 and " + conditions;
				*/
		//}
		//end增加耳标查询条件
		//start增加中央政策性种植险农户身份证查询条件
		/*String FCardID = httpServletRequest.getParameter("FCardID");
		if(FCardID != null && !"".equals(FCardID.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="FIDCARD = '" + FCardID.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND a.POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					conditions = conditions + mainConditions;
    				} 
    				else
                		conditions = " 1!=1 and " + conditions;	
            }
            else
				conditions = " 1!=1 and " + conditions;
		}
		//end增加中央政策性种植险农户身份证查询条件
		//start增加中央政策性种植险农户姓名查询条件
		String Fname1 = httpServletRequest.getParameter("Fname1");
		if(Fname1 != null && !"".equals(Fname1.trim())){
			BLPlantingPolicyList blPlantingPolicyList=new BLPlantingPolicyList();
            String plantingPolicyListConditions="Fname = '" + Fname1.trim()  + "'";
            blPlantingPolicyList.query(plantingPolicyListConditions);
            if(blPlantingPolicyList!=null&&blPlantingPolicyList.getSize()>0){
            	String insuremainlistConditions = "Inusrelistcode in (";
            	for(int i=0;i<blPlantingPolicyList.getSize();i++){
            		PlantingPolicyListSchema plantingPolicyListSchema=new PlantingPolicyListSchema();
            		plantingPolicyListSchema=blPlantingPolicyList.getArr(i);
            		if(i==0){
            			insuremainlistConditions = insuremainlistConditions +"'"+ plantingPolicyListSchema.getInusreListCode()+"'";	
            		}else{
            			insuremainlistConditions = insuremainlistConditions + ",'" + plantingPolicyListSchema.getInusreListCode()+"'";
            		}
            	}
            	insuremainlistConditions = insuremainlistConditions + ")";
    		    BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
    			ArrayList insureMainListDtoList = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);            		
    			if(insureMainListDtoList != null && insureMainListDtoList.size() >0){
    				String mainConditions = "AND a.POLICYNO in (";
    				for(int i = 0; i < insureMainListDtoList.size(); i++){
    					InsuremainlistDto InsuremainlistDto = new InsuremainlistDto();
    					InsuremainlistDto = (InsuremainlistDto)insureMainListDtoList.get(i);
    					if(i == 0)
    						mainConditions = mainConditions +"'"+ InsuremainlistDto.getPolicyno() +"'";
    					else
    						mainConditions = mainConditions + ",'" + InsuremainlistDto.getPolicyno()+"'";
    					}
    					mainConditions = mainConditions + ")";
    					conditions = conditions + mainConditions;
    				} 
    				else
                		conditions = " 1!=1 and " + conditions;	
            }
            else
				conditions = " 1!=1 and " + conditions;
		}*/
		//end增加中央政策性种植险农户姓名查询条件
		// 拼权限
		/**UIPowerInterface uiPowerInterface = new UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions
				+ uiPowerInterface.addPower(userDto.getUserCode(),
						com.sinosoft.claim.util.BusinessRuleUtil
								.transTaskCode(httpServletRequest
										.getParameter("nodeType")), "a",
						BusinessRuleUtil.getOuterCode(httpServletRequest,
								"RISKCODE_DAA"));*/
		//add by zhaolu 20060815 start
		//reason添加新权限
		UserDto userDto = (UserDto) httpServletRequest.getSession().getAttribute("user");
		UIPowerInterface uiPowerInterface = new UIPowerInterface();
		//modify by zhaolu 20060830 start
		//System.err.println("RiskPower:" + uiPowerInterface.addRiskPower(userDto,"a"));
		 //System.err.println("CustomerPower:" + uiPowerInterface.addCustomerPower(userDto,"a","","ComCode"));
		 conditions = conditions + uiPowerInterface.addRiskPower(userDto,"a") + uiPowerInterface.addCustomerPower(userDto,"a","","ComCode");
		 String contitionTemp = uiPowerInterface.addCustomerPower(userDto,"a","","ComCode");
		 contitionTemp = contitionTemp.replaceAll("a.ComCode","(substr(e.policyno,6,6)||'0000')");
		 //System.err.println("contitionTemp:" + contitionTemp);
		 //System.err.println("strEarLabelSign:"+ strEarLabelSign);
		 conditions1 = conditions1 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
		 conditions2 = conditions2 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
		 conditions3 = conditions3 + uiPowerInterface.addRiskPower(userDto,"e") + contitionTemp;
		 //System.err.println("conditions2_3:"+ conditions2);
		 //System.err.println("conditions1:"+ conditions1);
		 //非农险由总公司集中报案，各中支公司只能受理农险报案
		 
		 if(userDto.getComCode().indexOf("0000") != 0){
//			 conditions += " and a.Classcode in ('31','32','ZH','27','26','28') and a.riskCode!='3220' ";
//			 conditions1 += " and e.Classcode in ('31','32','ZH','27','26','28') and e.riskCode!='3220' ";
//			 conditions2 += " and e.Classcode in ('31','32','ZH','27','26','28') and e.riskCode!='3220' ";
//			 conditions3 += " and e.Classcode in ('31','32','ZH','27','26','28') and e.riskCode!='3220' ";
			 if("3477000000".equals(userDto.getComCode())){
				 conditions+=" and 1=0 ";
			 }else{
				 conditions += this.getPower("a");
				 conditions1 += this.getPower("e");
				 conditions2 += this.getPower("e");
				 conditions3 += this.getPower("e");
			 }
		 }		 
		 
		 //大病系统上线后，大病险种不再理赔系统中报案
		 String taskCode = SysConfig.getProperty("CLAIM_NOTALLOW_RISKKIND","claim");
		 if(null != taskCode && !"".equals(taskCode)){
			 conditions += " and a.riskCode not in ("+taskCode+") ";
		 }
		 
		//conditions = conditions + uiPowerInterface.addPower(userDto,"a","","ComCode");
		//modify by zhaolu 20060830 end
		//add by zhaolu 20060815 end
		// 查询报案信息
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		conditions += " and a.classcode <> '05' ";
		
		String condition = httpServletRequest.getParameter("condition");
		//System.err.println("condition:"+ condition);
		//System.err.println("condition-request"+ condition);
		if (condition != null && condition.trim().length() > 0) {
			conditions = condition;
			if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
				conditions1 = condition;
				//conditions = condition;
			}
			if((strAreasCode != null && !"".equals(strAreasCode.trim()))||(strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim()))){
				conditions2 = condition;
				//conditions = condition;
			}
			if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
				conditions3 = condition;
			}
			
		}
        // 得到多行报案主表信息
		//老理赔系统不允许车险报案
		
		PageRecord pageRecord = null;
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			//System.err.println("condition3:"+conditions1);
			pageRecord = (PageRecord) new BLHerdpolicylistFacade().findEarByConditions1(conditions1, Integer.parseInt(DataUtils
					.nullToZero(pageNo)), Integer.parseInt(DataUtils
					.nullToZero(recordPerPage)));
		}
		//0310专用
		else if(strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim())){
			//System.err.println(conditions2);
			pageRecord = (PageRecord) new BLHousepolicylistFacade().findIdcardByConditions1(conditions2, Integer.parseInt(DataUtils
					.nullToZero(pageNo)), Integer.parseInt(DataUtils
					.nullToZero(recordPerPage)));
		}
		else if(strAreasCode != null && !"".equals(strAreasCode.trim()))
		{
			//System.err.println("conditions21:"+ conditions2);
			pageRecord = (PageRecord) new BLHousepolicylistFacade().findAreacodeByConditions1(conditions2, Integer.parseInt(DataUtils
					.nullToZero(pageNo)), Integer.parseInt(DataUtils
					.nullToZero(recordPerPage)));
		}
		//end
		else if((strFCardID != null && !"".equals(strFCardID.trim()))||(strFname1 != null && !"".equals(strFname1.trim()))){
			pageRecord = (PageRecord) new BLPlantingpolicylistFacade().findPlantingByConditions(conditions, Integer.parseInt(DataUtils
					.nullToZero(pageNo)), Integer.parseInt(DataUtils
					.nullToZero(recordPerPage)));
		}
		else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
			pageRecord = (PageRecord) new BLZh03PolicyListFacade().findFamilyNoByConditions(conditions3, Integer.parseInt(DataUtils
					.nullToZero(pageNo)), Integer.parseInt(DataUtils
					.nullToZero(recordPerPage)));
		}
		else
		{
			pageRecord = (PageRecord) uiPolicyAction.findForRegistConditions(conditions, pageNo, recordPerPage);
		}
		
		ArrayList herdPolicyListResult = new ArrayList();
		List registList = (ArrayList) pageRecord.getResult();
		if (registList != null && registList.size() > 0) {
			for (int i = 0; i < registList.size(); i++) {
				PrpCmainDto prpCmainDto = null;
				if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
					prpCmainDto = ((EarLabelRegistDto) (((ArrayList) registList)
							.get(i))).getPrpCmainDto();
					BLClaimFacade bLClaimFacade = new BLClaimFacade();
					if(prpCmainDto != null)
					{
						PrpCmainDto tempcmain = bLClaimFacade.findByPolicyNoKey(prpCmainDto.getPolicyNo());
						if(tempcmain != null)
						{
							prpCmainDto.setOthFlag(tempcmain.getOthFlag());
							prpCmainDto.setUnderWriteFlag(tempcmain.getUnderWriteFlag());
							prpCmainDto.setStartDate(tempcmain.getStartDate());
							prpCmainDto.setEndDate(tempcmain.getEndDate());
							//prpCmainDto.setComCode(tempcmain.getComCode());
						}
						String areacode = prpCmainDto.getComCode();
						//System.err.println("areacode:" + areacode);
						BLAreas bLAreas = new BLAreas();
						String temparea = "";
						ArrayList<String> areas = (ArrayList<String>)bLAreas.getSupperArea(areacode);
						//System.err.println("size:" + areas.size());
						if(areas != null && areas.size() >0)
						{
							for(int k = areas.size()-1;k>=0;k--)
							{
								temparea = temparea + areas.get(k) + " ";
								
							}
						}
						//System.err.println("temparea:"+ temparea);
						prpCmainDto.setInsuredAddress(temparea);
					}
					
				}
				else if((strFamilyNo != null && !"".equals(strFamilyNo.trim()))||(strFamilyFIDCard != null && !"".equals(strFamilyFIDCard.trim()))){
					prpCmainDto = (PrpCmainDto) (((ArrayList) registList)
							.get(i));
					BLClaimFacade bLClaimFacade = new BLClaimFacade();
					if(prpCmainDto != null)
					{
						PrpCmainDto tempcmain = bLClaimFacade.findByPolicyNoKey(prpCmainDto.getPolicyNo());
						if(tempcmain != null)
						{
							prpCmainDto.setOthFlag(tempcmain.getOthFlag());
							prpCmainDto.setUnderWriteFlag(tempcmain.getUnderWriteFlag());
							prpCmainDto.setStartDate(tempcmain.getStartDate());
							prpCmainDto.setEndDate(tempcmain.getEndDate());
							prpCmainDto.setInsuredName(tempcmain.getInsuredName()+"等"+tempcmain.getSumQuantity()+"人");
							//prpCmainDto.setComCode(tempcmain.getComCode());
						}
					}
					
				}
				else if((strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim()))||(strAreasCode != null && !"".equals(strAreasCode.trim()))){
					prpCmainDto = ((IdcardRegistDto) (((ArrayList) registList)
							.get(i))).getPrpCmainDto();
					BLClaimFacade bLClaimFacade = new BLClaimFacade();
					if(prpCmainDto != null)
					{
						PrpCmainDto tempcmain = bLClaimFacade.findByPolicyNoKey(prpCmainDto.getPolicyNo());
						if(tempcmain != null)
						{
							prpCmainDto.setOthFlag(tempcmain.getOthFlag());
							prpCmainDto.setUnderWriteFlag(tempcmain.getUnderWriteFlag());
							prpCmainDto.setStartDate(tempcmain.getStartDate());
							prpCmainDto.setEndDate(tempcmain.getEndDate());
							//prpCmainDto.setComCode(tempcmain.getComCode());
						}
						String areacode = prpCmainDto.getComCode();
						//System.err.println("areacode:" + areacode);
						BLAreas bLAreas = new BLAreas();
						String temparea = "";
						ArrayList<String> areas = (ArrayList<String>)bLAreas.getSupperArea(areacode);
						//System.err.println("size:" + areas.size());
						if(areas != null && areas.size() >0)
						{
							for(int k = areas.size()-1;k>=0;k--)
							{
								temparea = temparea + areas.get(k) + " ";
								
							}
						}
						//System.err.println("temparea:"+ temparea);
						prpCmainDto.setInsuredAddress(temparea);
					}
					
					System.err.println("test:"+prpCmainDto.getPolicyNo());
				}
				
				else
				{
					prpCmainDto = (PrpCmainDto) (((ArrayList) registList)
							.get(i));
				}
				// 获取全单退保的生效日期 用处？？？
				EndorseDto endorseDto = new EndorseDto();
				UIEndorseAction uiEndorseAction = new UIEndorseAction();
				endorseDto = uiEndorseAction.findByConditions(prpCmainDto
						.getPolicyNo());
				PrpPheadDto prppheadDto = new PrpPheadDto();
				PrpPheadDto prppheadDto1 = new PrpPheadDto();
				if (endorseDto == null) {
					httpServletRequest.setAttribute("prppheadDto", prppheadDto);
				} else {
					ArrayList prppheadDtolist = endorseDto.getPrpPheadDtoList();
					if (prppheadDtolist.size() != 0 && prppheadDtolist != null) {
						//System.out.println("[有批单]");
						Iterator it = prppheadDtolist.iterator();
						while (it.hasNext()) {
							prppheadDto1 = (PrpPheadDto) it.next();
							if (prppheadDto1.getEndorType().equals("21")) {
								prppheadDto = prppheadDto1;
							}
						}
					} else {
						//System.out.println("[无批单]");
					}
					httpServletRequest.setAttribute("prppheadDto", prppheadDto);
				}
				// ----------------
             
				prpCmainDto.setDamageDate(damageDate);
				prpCmainDto.setDamageHour(damageHour);
				
				
				
				//System.out.println("aaaaa" + prpCmainDto.getDamageHour());
				DateTime timeNow = new DateTime(DateTime.current().toString(),
						DateTime.YEAR_TO_DAY);
				DateTime endDate = prpCmainDto.getEndDate();
				// prpCmainDto.setOthFlag(prpCmainDto.getOthFlag().substring(3,
				// 4));
				// System.out.println("----1------timeNow---"+timeNow);
				// System.out.println("----1------endDate---"+endDate);
				int interval = DateTime.intervalDay(endDate, 0, timeNow, 0);
				// System.out.println("----1------interval---="+interval);
				// 过期保单显示为红色，过期保单的处理？？？lixiang
				if (interval > 0) {
					prpCmainDto.setColorFlag("1");
				}
				else
				{
					prpCmainDto.setColorFlag("0");
				}
				System.err.println("ColorFlag:"+prpCmainDto.getColorFlag());
				UICodeAction uiCodeAction = new UICodeAction();
			    //add by lixiang start at 2006-1-20
				//reson:显示险种名称
				String strTemp =uiCodeAction.translateRiskCode(prpCmainDto.getRiskCode() ,true);
				if (strTemp!=null&&strTemp.length() >4) strTemp=strTemp.substring( 0,4);
				prpCmainDto.setRiskCode(strTemp);
                //add by lixiang end at 2006-1-20
				/*
				if(earLabel != null && !"".equals(earLabel.trim())){
					//start拼接耳标查询对应的农户信息
					
					ArrayList insureMainListDtoListRe = new ArrayList();
					ArrayList herdPolicyListDtoListRe = new ArrayList();
					InsuremainlistDto insuremainlistDtoRe = new InsuremainlistDto();
					HerdpolicylistDto herdpolicylistDto = new HerdpolicylistDto(); 
					
					BLInsuremainlistFacade bLInsuremainlistFacade = new BLInsuremainlistFacade();
					String insuremainlistConditions = "policyno = '" + prpCmainDto.getPolicyNo() + "'"; 
					insureMainListDtoListRe = (ArrayList)bLInsuremainlistFacade.findByConditions(insuremainlistConditions);
					if(insureMainListDtoListRe != null && insureMainListDtoListRe.size() >1)
						 throw new UserException(1,3,"","保单号:" + prpCmainDto.getPolicyNo() + "对应的清单主表记录数不唯一");
					if(insureMainListDtoListRe != null && insureMainListDtoListRe.size() == 1){
						BLHerdpolicylistFacade bLHerdpolicylistFacadeRe = new BLHerdpolicylistFacade();
						insuremainlistDtoRe = (InsuremainlistDto)insureMainListDtoListRe.get(0);
						String herdpolicylistDtoConditionsRe = "Earlabel = '" + earLabel + 
						//"' and kindcode = '" + kindCode +
						"' and INUSRELISTCODE = '" + insuremainlistDtoRe.getInusrelistcode() + "'";
						herdPolicyListDtoListRe = (ArrayList)bLHerdpolicylistFacadeRe.findByConditions(herdpolicylistDtoConditionsRe); 
						if(herdPolicyListDtoListRe != null && herdPolicyListDtoListRe.size() >1)
							 throw new UserException(1,3,"","保单号:" + prpCmainDto.getPolicyNo() + "对应的清单子表记录数不唯一");
						if(herdPolicyListDtoListRe != null && herdPolicyListDtoListRe.size() == 1)
							herdPolicyListResult.add(herdPolicyListDtoListRe.get(0));
						else
							herdPolicyListResult.add(herdpolicylistDto);
					}
					else
						herdPolicyListResult.add(herdpolicylistDto);
					//end拼接耳标查询对应的农户信息
					 
				}*/
			}/*if(earLabel != null && !"".equals(earLabel.trim())){
			httpServletRequest.setAttribute("herdPolicyListResult", herdPolicyListResult);}*/
		}
		
		/*
		 * System.out.println("---
		 * 当前页号---翻页的信息--pageRecord.getPageNo()--"+pageRecord.getPageNo());
		 * System.out.println("---
		 * 一页的条数---翻页的信息--pageRecord.getRowsPerPage()--"+pageRecord.getRowsPerPage());
		 * System.out.println("---总记录数---翻页的信息--pageRecord.getCount()--"+pageRecord.getCount());
		 * System.out.println("----总的页数--翻页的信息--pageRecord.getTotalPageCount()--"+pageRecord.getTotalPageCount());
		 * System.out.println("---返回的页数---翻页的信息----"+pageRecord.getPageCount());
		 */
		prpLregistDto.setRegistList(registList);
		TurnPageDto turnPageDto = new TurnPageDto();
		// 查询出来的一页的结构集
		turnPageDto.setResultList(registList);
		// 当前页号
		turnPageDto.setPageNo(pageRecord.getPageNo());
		// 一页的条数
		turnPageDto.setRecordPerPage(pageRecord.getRowsPerPage());
		// 查询出来的结果的总数
		turnPageDto.setTotalCount(pageRecord.getCount());
		// 返回总的页数
		turnPageDto.setTotalPage(pageRecord.getTotalPageCount());
		// 搜索条件
		//System.err.println("strEarLabel:"+ strEarLabel);
		if((strEarLabel != null && !"".equals(strEarLabel.trim()))||(strFname != null && !"".equals(strFname.trim()))){
			turnPageDto.setCondition(conditions1);
			//turnPageDto.setCondition(conditions);
		}
		else if((strAreasCode != null && !"".equals(strAreasCode.trim()))||(strIdentifyNumber_0310 != null && !"".equals(strIdentifyNumber_0310.trim()))){
			turnPageDto.setCondition(conditions2);
		}
		else
		{
			turnPageDto.setCondition(conditions);
		}
		prpLregistDto.setTurnPageDto(turnPageDto);

		// 设置客户类型
		if (!prpLregistDto.getInsuredCode().equals("")) {
			UICodeAction uiCodeAction = new UICodeAction();
			prpLregistDto.setCustomerType(uiCodeAction
					.getCustomerType(prpLregistDto.getInsuredCode()));
		}

		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);

	}

	/**
	 * 检查缴费标志 返回值 int -1为未缴费，0为未缴全，1为缴全
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param policyNo
	 *            立案号
	 * @throws Exception
	 */
	public int checkPay(HttpServletRequest httpServletRequest, String policyNo)
			throws Exception {
		// 取得赔款计算书信息
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo + "'";
		int intReturn = 0;
		intReturn = uiPolicyAction.checkPay(conditions);
		return intReturn;
	}
	
	public int[] getDelinquentfeeTime(String policyNo) throws Exception{
		UIPolicyAction uiPolicyAction = new UIPolicyAction();
		String conditions = " policyno = '" + policyNo + "'";
		return uiPolicyAction.getDelinquentfeeTime(conditions);
	}

	
	public String getDelinquentfeeCase(PrpCmainDto prpcmain) throws Exception{
		//欠费情况
		String delinquentfeeCase = "";
		//若费用未缴全,则针对分期付款的情况要提示哪几期费用未缴
		if(prpcmain.getPayTimes()<2){
			delinquentfeeCase = "缴费计划为 "+prpcmain.getPayTimes()+" 期";
		}else{
			int[] delinquentfeeTime = getDelinquentfeeTime(prpcmain.getPolicyNo());
			for (int i = 0; i < delinquentfeeTime.length; i++) {
				if(i==0){
					delinquentfeeCase = "缴费计划为 "+prpcmain.getPayTimes()+" 期";
				}
				delinquentfeeCase += "\n";
				delinquentfeeCase += "第 "+delinquentfeeTime[i]+" 期未缴费";
			}
		}
		return delinquentfeeCase;
	}
	/**
	 * 根据报案号和保单号,车牌号，操作时间，案件状态查询报案信息
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param registNo
	 *            报案号
	 * @param policyNo
	 *            保单号
	 * @param licenseNo
	 *            车牌号码
	 * @param riskCode
	 *            险别
	 * @param insuredName
	 *            被保险人名称
	 * @throws Exception
	 */
	public void getWorkFlowList(HttpServletRequest httpServletRequest,
			String registNo, String policyNo, String licenseNo,
			String riskCode, String insuredName) throws Exception {
		// 根据输入的保单号，报案号生成SQL where 子句
		registNo = StringUtils.rightTrim(registNo);
		policyNo = StringUtils.rightTrim(policyNo);
		licenseNo = StringUtils.rightTrim(licenseNo);
		insuredName = StringUtils.rightTrim(insuredName);
		riskCode = StringUtils.rightTrim(riskCode);
		PrpLregistDto prpLregistDto = new PrpLregistDto();
		// prpLregistDto.setStatusName(statusName);
		// prpLregistDto.setLicenseNo(licenseNo);
		riskCode = StringUtils.rightTrim(riskCode);
		insuredName = StringUtils.rightTrim(insuredName);

		String conditions = " 1=1 ";
		if (registNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.registNo", registNo,
							httpServletRequest.getParameter("RegistNoSign"));
		}
		if (policyNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.policyNo", policyNo,
							httpServletRequest.getParameter("PolicyNoSign"));
		}
		if (riskCode.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.riskCode", riskCode,
							httpServletRequest.getParameter("RiskCodeSign"));
		}
		if (insuredName.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.insuredName",
							insuredName, httpServletRequest
									.getParameter("InsuredNameSign"));
		}
		if (licenseNo.length() > 0) {
			conditions = conditions
					+ StringConvert.convertString(" a.licenseNo", licenseNo,
							httpServletRequest.getParameter("LicenseNoSign"));
		}
		// 拼权限
		com.sinosoft.claim.ui.control.action.UIPowerInterface uiPowerInterface = new com.sinosoft.claim.ui.control.action.UIPowerInterface();
		UserDto userDto = (UserDto) httpServletRequest.getSession()
				.getAttribute("user");
		conditions = conditions
				+ uiPowerInterface.addPower(userDto.getUserCode(),
						httpServletRequest.getParameter("taskCodeC"), "a",
						BusinessRuleUtil.getOuterCode(httpServletRequest,
								"RISKCODE_DAA"));

		// 查询报案信息
		UIRegistAction uiRegistAction = new UIRegistAction();

		// System.out.println("DAARegistViewHelper condition
		// ######="+conditions);
		// 得到多行报案主表信息
		Collection registList = new ArrayList();
		registList = (Collection) uiRegistAction.getWorkFlowList(conditions);

		prpLregistDto.setRegistList(registList);
		// System.out.println("editType="+httpServletRequest.getParameter("editType"));
		prpLregistDto.setEditType(httpServletRequest.getParameter("editType"));
		httpServletRequest.setAttribute("prpLregistDto", prpLregistDto);
	}

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
			RegistDto registDto) throws Exception {
		// 给损失部位多行多行列表准备数据
		Collection arrayListThirdCarLoss = new ArrayList();
		PrpLthirdCarLossDto prpLthirdCarLossDto = new PrpLthirdCarLossDto();
		arrayListThirdCarLoss = registDto.getPrpLthirdCarLossDtoList();
		prpLthirdCarLossDto.setThirdCarLossList(arrayListThirdCarLoss);
		prpLthirdCarLossDto.setPartName("前部");
		prpLthirdCarLossDto.setPartCode("1");
		httpServletRequest.setAttribute("prpLthirdCarLossDto",
				prpLthirdCarLossDto);

		// Modify by chenrenda add begin 20050412
		// Reason:在报案页面中加上其它损失模块
		Collection arrayListThirdProp = new ArrayList();
		PrpLthirdPropDto prpLthirdPropDto = new PrpLthirdPropDto();
		arrayListThirdProp = registDto.getPrpLthirdPropDtoList();

		prpLthirdPropDto.setThirdPropList(arrayListThirdProp);
		httpServletRequest.setAttribute("prpLthirdPropDto", prpLthirdPropDto);

		// Modify by chenrenda add end 20050412

		// 给人员伤亡跟踪多行多行列表准备数据
		Collection arrayListPersonTrace = new ArrayList();
		PrpLpersonTraceDto prpLpersonTraceDto = new PrpLpersonTraceDto();
		prpLpersonTraceDto = ScheduleItemDtoToView(prpLpersonTraceDto,
				registDto.getPrpLscheduleItemDtoList());
		arrayListPersonTrace = registDto.getPrpLpersonTraceDtoList();
		// Modify by chenrenda 20050409 begin
		if (registDto.getPrpLpersonTraceDtoList() != null) {
			Iterator personTraceDtoList = arrayListPersonTrace.iterator();
			while (personTraceDtoList.hasNext()) {
				PrpLpersonTraceDto prplpersonTraceDto = (PrpLpersonTraceDto) personTraceDtoList
						.next();
				String strReferKind = prplpersonTraceDto.getReferKind();
				prplpersonTraceDto.setPrpLpersonTraceReferKind(strReferKind);
			}
		}
		// Modify by chenrenda 20050409 end
		prpLpersonTraceDto.setPersonTraceList(arrayListPersonTrace);
		httpServletRequest.setAttribute("prpLpersonTraceDto",
				prpLpersonTraceDto);

		// 给报案信息补充说明多行列表准备数据
		Collection arrayListRegistExt = new ArrayList();
		PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
		prpLregistExtDto
				.setRegistNo(registDto.getPrpLregistDto().getRegistNo());
		prpLregistExtDto
				.setRiskCode(registDto.getPrpLregistDto().getRiskCode());
		arrayListRegistExt = registDto.getPrpLregistExtDtoList();
		prpLregistExtDto.setRegistExtList(arrayListRegistExt);
		httpServletRequest.setAttribute("prpLregistExtDto", prpLregistExtDto);

		// 给事故经过及其事故者现状准备数据
		PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
		String tempContext = "";
		if (registDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
						.next();
				if (prpLregistTextDtoTemp.getTextType().equals("1")) {
					tempContext = tempContext
							+ prpLregistTextDtoTemp.getContext();
				}
			}
		}
		prpLregistTextDto.setContext(tempContext);
		prpLregistTextDto.setTextType("1");
		httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
		// 给呈报信息准备数据
		PrpLregistTextDto prpLregistText4Dto = new PrpLregistTextDto();
		tempContext = "";
		if (registDto.getPrpLregistTextDtoList() != null) {
			Iterator iterator = registDto.getPrpLregistTextDtoList().iterator();
			while (iterator.hasNext()) {
				PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto) iterator
						.next();
				if (prpLregistTextDtoTemp.getTextType().equals("4")) {
					tempContext = tempContext
							+ prpLregistTextDtoTemp.getContext();
				}
			}
		}
		prpLregistText4Dto.setContext(tempContext);
		prpLregistText4Dto.setTextType("4");
		httpServletRequest.setAttribute("prpLregistText4Dto",
				prpLregistText4Dto);

		// modify by lixiang add 20050315 start
		// reason:加入保险标的信息的内容，界面上可以直接显示承保险别
		// 给保单投保标的准备数据
		Collection arrayPrpCitemKind = new ArrayList();
		PrpCitemKindDto prpCitemKindDto = new PrpCitemKindDto();
		arrayPrpCitemKind = registDto.getPrpCitemKindDtoList();
		prpCitemKindDto.setPrpCitemKindDtoList(arrayPrpCitemKind);
		httpServletRequest.setAttribute("prpCitemKindDto", prpCitemKindDto);

		// modify by lixiang add 20050315 end

		// 特别约定信息多行列表准备数据
		Collection cengageList = new ArrayList();
		PrpCengageDto prpCengageDto = new PrpCengageDto();
		cengageList = registDto.getPrpCengageDtoList();
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
		httpServletRequest.setAttribute("prpLscheduleMainWFDto", registDto.getPrpLscheduleMainWFDto());
	}

	/**
	 * 根据PrpRegistDto中的已经设置的代码内容，对代码进行名称转换
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLcheckDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void changeCodeToName(HttpServletRequest httpServletRequest,
			PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		// (1)归属业务员名称的转换
		String handler1Code = prpLregistDto.getHandler1Code();
		String handler1Name = uiCodeAction
				.translateUserCode(handler1Code, true);
		prpLregistDto.setHandler1Name(handler1Name);

		// (2)归属业务机构的转换
		String comCode = prpLregistDto.getComCode();
		String comName = uiCodeAction.translateComCode(comCode, true);
		prpLregistDto.setComName(comName);

		// (3)币别名称的转换
		String estiCurrency = prpLregistDto.getEstiCurrency();
		String estiCurrencyName = uiCodeAction.translateCurrencyCode(
				estiCurrency, true);
		prpLregistDto.setEstiCurrencyName(estiCurrencyName);

		// (4)理赔登记机构的转换
		String makeComCode = prpLregistDto.getMakeCom();
		String makeComName = uiCodeAction.translateComCode(makeComCode, true);
		prpLregistDto.setMakeComName(makeComName);

		// (5)条款名称的转换
		String clauseType = prpLregistDto.getClauseType();
		String clauseName = uiCodeAction.translateCodeCode("ClauseType",
				clauseType, true);
		prpLregistDto.setClauseName(clauseName);

		// (6)操作用户的转换
		String operatorCode = prpLregistDto.getOperatorCode();
		String operatorName = uiCodeAction
				.translateUserCode(operatorCode, true);
		prpLregistDto.setOperatorName(operatorName);

		// (7)处理部门的转换

		String handleUnit = prpLregistDto.getHandleUnit();
		String handleUnitName = "";
		if (handleUnit.length() > 0) {
			handleUnitName = uiCodeAction.translateCodeCode("HandleUnit",
					handleUnit, true);
			prpLregistDto.setHandleUnitName(handleUnitName);
		}
		//（8）赔案类别转换
		String claimType = prpLregistDto.getClaimType();
		if(claimType.length() > 0){
			prpLregistDto.setClaimTypeName(uiCodeAction.translateCodeCode("CaseCode", prpLregistDto.getClaimType(), true));
		}		
	}

	/**
	 * 获取选择框和列表框中的所有内容
	 * 
	 * @param httpServletRequest
	 *            返回给页面的request
	 * @param prpLregistDto
	 *            查勘的数据类
	 * @throws Exception
	 */
	private void setSelectionList(HttpServletRequest httpServletRequest,
			PrpLregistDto prpLregistDto) throws Exception {
		UICodeAction uiCodeAction = new UICodeAction();
		String riskCode = prpLregistDto.getRiskCode();
		// 得到报案类型列表
		Collection reportTypes = uiCodeAction.getCodeType("ReportType",
				riskCode);
		httpServletRequest.setAttribute("reportTypes", reportTypes);
		// 得到案件种类列表列表
		Collection claimTypes = uiCodeAction.getCodeType("CaseCode", riskCode);
		httpServletRequest.setAttribute("claimTypes", claimTypes);
		// 得到出险地址类型列表
		Collection damageAddressTypes = uiCodeAction.getCodeType(
				"DamageAddress", riskCode);
		httpServletRequest.setAttribute("damageAddressTypes",
				damageAddressTypes);
		// 得到车辆种类列表
		Collection carKindCodes = uiCodeAction.getCodeType("CarKind", riskCode);
		httpServletRequest.setAttribute("carKindCodes", carKindCodes);
		// 得到车牌底色列表
		Collection licenseColorCode = uiCodeAction.getCodeType("LicenseColor",
				riskCode);
		httpServletRequest.setAttribute("licenseColorCodes", licenseColorCode);
		// 得到得到性别
		Collection driverSex = uiCodeAction.getCodeType("SexCode", riskCode);
		httpServletRequest.setAttribute("driverSexs", driverSex);
		// 得到职业分类
		Collection driverOccupation = uiCodeAction.getCodeType("Occupation",
				riskCode);
		httpServletRequest.setAttribute("driverOccupations", driverOccupation);
		// 得到文化程度
		Collection education = uiCodeAction.getCodeType("Education", riskCode);
		httpServletRequest.setAttribute("educations", education);
	}

	/**
	 * 查询工作流可以用来选择的节点内容,在这里有点不同，因为如果查询出来的话，立案是一定有的，
	 * 但是报案下面的定损和查勘调度，结果有两个selection,一个是包括全部的节点，另一个只有可供选择的节点list
	 * 
	 * @param modelNo
	 *            String
	 * @param nodeNo
	 *            String
	 * @throws Exception
	 */
	private void getSubmitNodes(HttpServletRequest httpServletRequest,
			String riskCode, String comCode) throws Exception {
		// 报案节点特殊，无法从前面得到当前的modelNo号码，必须从数据库中获得
		int modelNo = 0; // 模板号,需要根据险种，操作员部门选择
		String nodeNo = "1"; // 节点号
		int nextNodeNo = 0;

		Collection pathList = new ArrayList(); // 可以选择的所有的下一个节点
		Collection userSelectList = new ArrayList(); // 需要用户来指定的下一个节点
		SwfPathDto swfPathDto = new SwfPathDto();
		WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
	
		modelNo = workFlowViewHelper.getModelNoByRiskComCode(riskCode, comCode);
	
		if (modelNo > 0 && nodeNo != null) {
			pathList = workFlowViewHelper.getNextSumbitNodes(modelNo + "",
					nodeNo);
			String[] selectNodeList = new String[pathList.size()];
			for (int i = 0; i < pathList.size(); i++) {
				SwfPathDto swfPathDtoTemp = new SwfPathDto();
				swfPathDtoTemp = (SwfPathDto) ((ArrayList) pathList).get(i);
				nextNodeNo = swfPathDtoTemp.getEndNodeNo();
				swfPathDto.setNextNodeNo(nextNodeNo);
				if (!swfPathDtoTemp.getDefaultFlag().equals("3")) {
					// 判断是可供选择的节点
					userSelectList.add(swfPathDtoTemp);
				}
				selectNodeList[i] = nextNodeNo + "";
			}
			swfPathDto.setNextNodeNoList(selectNodeList);
		}
		swfPathDto.setPathList(pathList);
		httpServletRequest.setAttribute("pathList", pathList);
		httpServletRequest.setAttribute("userSelectList", userSelectList);
		httpServletRequest.setAttribute("swfPathDto", swfPathDto);
	}

	/**
	 * 整理调度在车辆列表中的数据显示
	 * 
	 * @param itemType
	 *            String
	 * @param itemList
	 *            Collection
	 * @param scheduleItemList
	 *            Collection
	 * @throws exception
	 * @return Collection
	 */
	private Collection ScheduleItemDtoToView(Collection itemList,
			Collection scheduleItemList) throws Exception {
		if (scheduleItemList == null)
			return itemList;
		Collection itemToViewList = new ArrayList();
		PrpLthirdPartyDto prpLthirdpartyDto = null;
		if (itemList != null) {
			for (int j = 0; j < itemList.size(); j++) {
				prpLthirdpartyDto = (PrpLthirdPartyDto) ((ArrayList) itemList)
						.get(j);
				for (int i = 0; i < scheduleItemList.size(); i++) {
					PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto) ((ArrayList) scheduleItemList)
							.get(i);
					if (prpLthirdpartyDto.getSerialNo() == prpLscheduleItemDto
							.getItemNo()) {
						prpLthirdpartyDto.setSelectSend(prpLscheduleItemDto
								.getSelectSend());
						prpLthirdpartyDto.setScheduleType(prpLscheduleItemDto
								.getScheduleType());
						break;
					}
				}
				itemToViewList.add(prpLthirdpartyDto);
			}
		}
		return itemToViewList;
	}

	/**
	 * 整理调度在人员列表中的数据显示
	 * 
	 * @param prpLpersonTraceDto
	 *            PrpLpersonTraceDto
	 * @param scheduleItemList
	 *            Collection
	 * @throws exception
	 * @return Collection
	 */
	private PrpLpersonTraceDto ScheduleItemDtoToView(
			PrpLpersonTraceDto prpLpersonTraceDto, Collection scheduleItemList)
			throws Exception {
		if (scheduleItemList == null)
			return prpLpersonTraceDto;
		for (int i = 0; i < scheduleItemList.size(); i++) {
			PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto) ((ArrayList) scheduleItemList)
					.get(i);
			if (prpLscheduleItemDto.getItemNo() == 0) {
				prpLpersonTraceDto.setSelectSend(prpLscheduleItemDto
						.getSelectSend());
				prpLpersonTraceDto.setScheduleType(prpLscheduleItemDto
						.getScheduleType());
				break;
			}
		}
		return prpLpersonTraceDto;
	}

	/**
	 * 根据报案号得到该次报案的 已决 和 未决金额
	 * 
	 * @param registNo
	 * @author wangli 20050531
	 * @return
	 */
	public CompensateFeeDto getCompensateFeeByRegistNo(String registNo)
			throws Exception {

		double sumClaim = 0d;
		double sumPaid = 0d;
		double sumNoPaid = 0d;
		CompensateFeeDto compensateFeeDto = new CompensateFeeDto();
		UICodeAction uiCodeAction = new UICodeAction();
		UIClaimAction uiClaimAction = new UIClaimAction();
		UICompensateAction uiCompensateAction = new UICompensateAction();

		// 得立案号
		String claimNo = uiCodeAction.translateBusinessCode(registNo, true);

		if (claimNo != null && claimNo.length() > 0) {
			PrpLclaimDto prpLclaimDto = new PrpLclaimDto();

			prpLclaimDto = uiClaimAction.findByPrimaryKey(claimNo)
					.getPrpLclaimDto();
			if (prpLclaimDto != null) {
				// 保险损失金额
				sumClaim = prpLclaimDto.getSumClaim();
			}
			compensateFeeDto = uiCompensateAction
					.findCompensateFeeByClaimNo(claimNo);
			// 已决金额
			sumPaid = compensateFeeDto.getSumPaid();
			// 未决金额 ＝ 保险损失金额 － 已决金额
			sumNoPaid = sumClaim - sumPaid;
		}

		compensateFeeDto.setSumPaid(sumPaid);
		compensateFeeDto.setSumNoPaid(sumNoPaid);
		compensateFeeDto.setSumClaim(sumClaim);
		compensateFeeDto.setRegistNo(registNo);

		return compensateFeeDto;
	}

	/**
	 * 不予立案处理方法
	 * 
	 * @param httpServletRequest
	 *            请求对象
	 * @throws Exception
	 * @return RegistDto
	 */
	public RegistDto getNotGrandClaim(HttpServletRequest httpServletRequest)
			throws Exception {
		PrpLregistTextDto prpLregistTextDto = null;
		String registNo = httpServletRequest.getParameter("prpLclaimRegistNo");
		UIRegistAction uiRegistAction = new UIRegistAction();
		RegistDto registDto = uiRegistAction.findByPrimaryKey(registNo);

		// 回写CancelDate不予立案日期和DealerCode处理不予立案的操作员代码
		PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
		prpLregistDto.setCancelDate(new DateTime(httpServletRequest
				.getParameter("prpLclaimCancelDate")));
		prpLregistDto.setDealerCode(httpServletRequest
				.getParameter("prpLclaimDealerCode"));
		registDto.setPrpLregistDto(prpLregistDto);

		/*---------------------向报案文本表prpLregistText加入不予立案文本信息------------------------------------*/
		ArrayList prpLregistTextDtoList = registDto.getPrpLregistTextDtoList();
		if (prpLregistTextDtoList == null || prpLregistTextDtoList.size() < 1) {
			prpLregistTextDtoList = new ArrayList();
		}

		String TextTemp = httpServletRequest.getParameter("prpLclaimContext");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);

		// 得到连接串,下面将其切分到数组
		for (int k = 0; k < rules.length; k++) {
			prpLregistTextDto = new PrpLregistTextDto();
			prpLregistTextDto.setRegistNo((String) httpServletRequest
					.getParameter("prpLclaimRegistNo"));
			prpLregistTextDto.setContext(rules[k]);
			prpLregistTextDto.setLineNo(k + 1);
			prpLregistTextDto.setTextType("2"); // 类型2为不予立案类型保存在prplregistText表中
			prpLregistTextDtoList.add(prpLregistTextDto);
		}
		// 装入RegistDto
		registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);

		return registDto;
	}
    
    
    
    /**
     * 根据报案号和保单号查询报案信息
     * @param httpServletRequest 返回给页面的request
     * @param registNo       报案号
     * @param policyNo       保单号
     * @throws Exception
     */

    public void registCancelDtoToView(HttpServletRequest httpServletRequest,String registNo) throws Exception
    {
    	
    	//初始化变量
    	String conditions = "";//查询条件语句
        String msg = ""; //错误信息 
    	boolean  isCancel = false;
    	String  strCancel = "";
    	String strConditions = "";
    	//判断报案号是否合法
        if (registNo==null||registNo.equals(""))
        {
            msg = "没有接收到合法的报案号码！";
           throw new UserException(1,3,"报案注销",msg);
        }
        BLPrplcombineFacade bLPrplcombineFacade = new BLPrplcombineFacade();
        int combineCount = bLPrplcombineFacade.getCount(" registNo ='" + registNo.trim() +"'");
        if (combineCount > 0)
        {
            msg = "并案绑定中的案件需要解除绑定后注销！";
           throw new UserException(1,3,"报案注销",msg);
        }
        //报案注销不提供模糊查询
        registNo = StringUtils.rightTrim(registNo) ; 
        conditions = " RegistNo='" + registNo + "' ";
        strConditions  = conditions;
        //conditions = conditions +"  And registno in (select BusinessNo from prpLclaimStatus where nodeType='regis') ";

        //拼权限     
        UIPowerInterface uiPowerInterface = new UIPowerInterface();
        UserDto userDto = (UserDto)httpServletRequest.getSession().getAttribute("user");
        //conditions = conditions+uiPowerInterface.addPower(userDto.getUserCode(),"lpba","prplregist",BusinessRuleUtil.getOuterCode(httpServletRequest,"RISKCODE_DAA"));
       // System.out.println("condition1111s:"+conditions);
         
        //查询报案信息
        UIRegistAction uiRegistAction = new UIRegistAction();
        //  判断报案号码是否存在
        if (!uiRegistAction.isExist(registNo) )
        {
        	 msg = "没有接收到合法的报案号！";
             throw new UserException(1,3,"报案注销",msg);
         }
     
        //判断是否已经立案
        BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
        int intClaimSize = blPrpLclaimFacade.getCount(strConditions);
        
        UIPrpLregistRPolicyAction uiPrpLregistRPolicyAction = new UIPrpLregistRPolicyAction();
        String strSql="registNo='"+registNo+"'";
        List registPolicyList =(List)uiPrpLregistRPolicyAction.findByConditions(strSql);
        if(intClaimSize>0)
        {
       	  //需要判断是否所有的都已经立案，如果没有全部立案的话，还是可以进行报案注销的。
         if (registPolicyList.size() ==intClaimSize){	
        	
          msg = "该报案已经立案，请在立案中拒赔案件！";
          throw new UserException(1,3,"报案注销",msg);
         }
        
         }
         
         //得到多行报案主表信息
         Collection registList = new ArrayList();
         registList   = (Collection)uiRegistAction.findByConditions(conditions) ;
         
        
         PrpLregistDto prpLregistDto = new PrpLregistDto();
         PrpLregistTextDto prpLregistTextDto  = new PrpLregistTextDto();
         
         Iterator it = registList.iterator() ;
        
         if (it.hasNext() ) {
        	 prpLregistDto = (PrpLregistDto)it.next() ;
         }else{
        	 msg = "您无权读取报案信息！";
             throw new UserException(1,3,"报案注销",msg);
         }
         
         //增加强三多保单等的判断
         RegistDto registDto =new RegistDto();
         registDto.setPrpLregistDto(prpLregistDto );
          registDto.setPrpLRegistRPolicyList(registPolicyList );
         httpServletRequest.setAttribute("registDto",registDto);
		 httpServletRequest.setAttribute("prpLregistRPolicyNo",registDto.getPrpLRegistRPolicyDtoOfCompel());
		 
         //该报案是否已拒赔
         if(!(prpLregistDto.getCancelDate()==null || prpLregistDto.getCancelDate().isEmpty()||prpLregistDto.getDealerCode()==null || prpLregistDto.getDealerCode().trim().equals("")))
         {
         	isCancel = true;
         	strCancel = "1";
         }
         //增加大病系统同步过来的数据不能够注销
         if("2801".equals(prpLregistDto.getRiskCode())){
        	 BLPrplinterAutoClaimDetailFacade blClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
        	 ArrayList claimDetailList = (ArrayList)blClaimDetailFacade.findByConditions(conditions);
        	 if(claimDetailList!=null&&claimDetailList.size()>0){
        		 msg = "该报案为大病系统同步核心案件，不可以在理赔系统报案注销！";
                 throw new UserException(1,3,"报案注销",msg);
        	 }
        	 
         }
         //如已经注销，则取得注销原因
         //if(isCancel)
         //{
         	conditions = " RegistNo='" + registNo + "'  and texttype = '2'";
         	
         	BLPrpLregistTextFacade blPrpLregistTextFacade = new BLPrpLregistTextFacade();
         	
         	//得到报案注销原因
            Collection registTextList = new ArrayList();
            registTextList= blPrpLregistTextFacade.findByConditions(conditions);
            String tempContext = "";
            if(registTextList != null){
              Iterator iterator = registTextList.iterator();
              while(iterator.hasNext()){
                PrpLregistTextDto prpLregistTextDtoTemp = (PrpLregistTextDto)iterator.next();
                //tempContext = tempContext + StringUtils.replace(prpLregistTextDtoTemp.getContext(),"\r\n","\\r\\n")+"\\r\\n";
                String tmp = StringConvert.encode(prpLregistTextDtoTemp.getContext());
                tempContext = tempContext + StringUtils.replace(tmp,"\r\n","\\r\\n")+"\\r\\n";
              }  
            }
            prpLregistTextDto.setContext(tempContext);
            prpLregistTextDto.setTextType("2");
          
            
        //}
         httpServletRequest.setAttribute("prpLregistDto",prpLregistDto) ;
         httpServletRequest.setAttribute("prpLregistTextDto", prpLregistTextDto);
         httpServletRequest.setAttribute("strCancel", strCancel);
    }
    
    /**
     * 报案注销时数据整理
     * @param httpServletRequest
     * @return RegistDto 报案数据传输数据结构
     * @throws Exception
     */
     public RegistDto cancelViewToDto(HttpServletRequest httpServletRequest) throws Exception
     {
       
       //初始化变量
       int RULE_LENGTH = 70; //rule字段的长度  
       RegistDto registDto = new RegistDto ();
       String msg = "";
       UIRegistAction uiRegistAction = new UIRegistAction();
       
       //取得当前用户对象
       HttpSession session = httpServletRequest.getSession();
       UserDto   user     = (UserDto)session.getAttribute("user");
       
       //得到报案号
       String strRegistNo =   StringUtils.rightTrim(httpServletRequest.getParameter("prpLclaimRegistNo"));
      
       //  判断报案号码是否存在
       if (!uiRegistAction.isExist(strRegistNo) )
       {
       	   msg = "没有接收到合法的报案号！";
           throw new UserException(1,3,"报案注销",msg);
       }
       
       //得到报案对象
       registDto = uiRegistAction.findByPrimaryKey(strRegistNo);
       
       //收集报案注销原因
      
       ArrayList prpLregistTextDtoList = new ArrayList();
       //prpLregistTextDtoList =  registDto.getPrpLregistTextDtoList();
       int intSize = prpLregistTextDtoList.size();
       //String cancelReaseon = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
       
       String TextTemp = httpServletRequest.getParameter("prpLregistTextContextInnerHTML");
       String LINECR = "\r\n";       
       String[] rules = StringUtils.split(TextTemp, LINECR);
       
   	   //String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
	    //String[] rules = StringUtils.split(cancelReaseon,RULE_LENGTH);
       //prpLregistTextDtoList 中已经包含所有其它的数据
       //得到连接串,下面将其切分到数组 
       for(int k=0;k<rules.length;k++){
         //长度校验
         if(rules[k].getBytes().length > RULE_LENGTH)
         { 
           //System.err.println("length>FIELDLENGHT: "+rules[k]);
         }
         
         PrpLregistTextDto prpLregistTextDto = new PrpLregistTextDto();
         prpLregistTextDto.setRegistNo(strRegistNo);
         prpLregistTextDto.setContext(rules[k]);
         prpLregistTextDto.setLineNo(k+1);
         prpLregistTextDto.setTextType("2");
         prpLregistTextDtoList.add(prpLregistTextDto);
       }       
       
       //装入RegistDto
       registDto.setPrpLregistTextDtoList(prpLregistTextDtoList);
       
       
       //设置报案信息
       PrpLregistDto prpLregistDto = registDto.getPrpLregistDto() ;

       prpLregistDto.setCancelDate(new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY));
       prpLregistDto.setDealerCode(user.getUserCode());
       String strCancelReason = httpServletRequest.getParameter("CancelReason");
       String strCancelReasonName = httpServletRequest.getParameter("CancelReasonName");
       prpLregistDto.setCancelReason(strCancelReason);
       prpLregistDto.setCancelReasonName(strCancelReasonName);
       registDto.setPrpLregistDto(prpLregistDto);
       if(registDto.getPrpLRegistRPolicyList()!=null){
    	   for(int i=0;i<registDto.getPrpLRegistRPolicyList().size();i++){
    		 PrpLRegistRPolicyDto  prpLRegistRPolicyDto=(PrpLRegistRPolicyDto)registDto.getPrpLRegistRPolicyList().get(i);
	         prpLRegistRPolicyDto.setRegistValidStatus("0");
	         prpLRegistRPolicyDto.setValidStatus("0");
		     prpLRegistRPolicyDto.setCancelOperaterCode(user.getUserCode());
		     prpLRegistRPolicyDto.setCancelComCode(user.getComCode());
		     prpLRegistRPolicyDto.setCancelReason(registDto.getPrpLregistDto().getCancelReason());
		     prpLRegistRPolicyDto.setCancelReasonName(registDto.getPrpLregistDto().getCancelReasonName());
		     prpLRegistRPolicyDto.setCancelDate(registDto.getPrpLregistDto().getCancelDate().toString());
		     registDto.getPrpLRegistRPolicyList().set(i, prpLRegistRPolicyDto);
    	   }
       }
       return registDto;
   }
     public PrplregisthisDto getPrplregisthisDto(UserDto userDto,String type,String contextType, String str,String nodeType,String registNo,int count ) throws Exception{
     	PrplregisthisDto  prpLregistHisDto =new PrplregisthisDto();
     	prpLregistHisDto.setRegistno(registNo);
     	prpLregistHisDto.setSerialno(count);
     	prpLregistHisDto.setInputdate(new DateTime(new DateTime().current(),DateTime.YEAR_TO_SECOND).toString());
     	prpLregistHisDto.setOperatorcode(userDto.getUserCode());
     	prpLregistHisDto.setOperatorname(userDto.getUserName());
     	prpLregistHisDto.setComcode(userDto.getComCode());
     	prpLregistHisDto.setModifytype("01");
     	prpLregistHisDto.setNodetype(nodeType);
     	if("01".equals(type)){//报案注销
     		str="报案注销原因："+str;
     	}
     	prpLregistHisDto.setContext(str);
     	return prpLregistHisDto;
     }     
     /**
 	 * 报案前的保单查询 根据保单号码查询符合条件的报案信息
 	 * GYIC
 	 * @param httpServletRequest
 	 *            返回给页面的request
 	 * @param pageNo
 	 *            页码
 	 * @param recordPerPage
 	 *            每页显示的行数
 	 * @throws Exception
 	 */

 	public Collection registNoListToView(HttpServletRequest httpServletRequest) throws Exception {
 		String strPolicyNo = httpServletRequest.getParameter("prpCmainPolicyNo");
 		
 		Collection collection = null;
 		UIRegistAction uiRegistAction = new UIRegistAction();
 		collection = uiRegistAction.findForRegistNoConditions(strPolicyNo);
 		return collection;


 	}   
 	
 	 /**
 	 * 检查保单/关联保单是否在停驶区间内
 	 * GYIC 	 
 	 * @param policyNo
 	 *            商业险保单号
 	 * @param damageDate
  	 * @throws Exception
 	 */
 	public boolean checkIsStopping(String policyNo,String damageDate,String damageHour)throws Exception{
 		boolean isStopping = false;//在停驶期间的标志
 		String pauseDate = "";//停驶起期
 		String comebackDate = "";//停驶止期
 		int damageHourTemp = Integer.parseInt(damageHour);
 		int comebackHour = 0;
 		int pauseHour = 0;
 		String strWherePart = "PolicyNo= '" + policyNo + "' and validstatus='1' order by EndorseNo";
 		BLPrpPheadSub blPrpPheadSub = new BLPrpPheadSub();
 		blPrpPheadSub.query(strWherePart);
 		if(blPrpPheadSub.getSize() > 0){
 			pauseDate = blPrpPheadSub.getArr(0).getPauseDate();
 			comebackDate = blPrpPheadSub.getArr(0).getComebackDate();
 			comebackHour = Integer.parseInt(blPrpPheadSub.getArr(0).getComebackHour());
 			pauseHour = Integer.parseInt(blPrpPheadSub.getArr(0).getPauseHour());
 			if(comebackDate != null && !"".equals(comebackDate)){
 				if(PubTools.compareDate(pauseDate, damageDate) == -1 && PubTools.compareDate(damageDate, comebackDate) == -1 ){
 					isStopping = true;
 				}
 				if(PubTools.compareDate(damageDate, comebackDate) == 0 && damageHourTemp < comebackHour ){
 					isStopping = true;
 				}
 				if(PubTools.compareDate(damageDate, pauseDate) == 0 && pauseHour <= damageHourTemp ){
 					isStopping = true;
 				}
 			}else{
 				if(PubTools.compareDate(pauseDate, damageDate) == -1){
 					isStopping = true;
 				}
 				if(PubTools.compareDate(damageDate, pauseDate) == 0 && pauseHour <= damageHourTemp ){
 					isStopping = true;
 				}
 			}
 		}
 		return isStopping;
 	}
	/**
	 * 补充说明公共方法
	 * 显示补充说明参数 
	 * @param httpServletRequest
	 * @param registNo  报案号
	 * @throws Exception
	 */
	public void findPrplregistExt(HttpServletRequest httpServletRequest,String registNo) throws Exception{
		  //查询所有车险节点
	      BLSwfNodeFacadeBase blSwfNodeFacadeBase = new BLSwfNodeFacadeBase();
	      ArrayList<SwfNodeDto> swfNodeList = (ArrayList<SwfNodeDto>) blSwfNodeFacadeBase.findByConditions(" modelno=05 ");
	      httpServletRequest.setAttribute("swfNodeList", swfNodeList);
	      BLSwfLogFacade blSwfLogFacade = new BLSwfLogFacade();
	      String nodeType     = httpServletRequest.getParameter("nodeType");
	      String lossitemcode = httpServletRequest.getParameter("lossItemCode");
	      int  itemNo = 0;
	      if(("certa".equals(nodeType) || "propc".equals(nodeType)) && lossitemcode != null && !"".equals(lossitemcode)){
	    	  itemNo =  Integer.parseInt(lossitemcode);
	      }
	      if("patch".equals(nodeType)||"pview".equals(nodeType) || "cview".equals(nodeType)||"fview".equals(nodeType)){
		    	nodeType = "check";
		  }
	      //机构All
	      BLPrpDcompanyFacadeBase blPrpDcompanyFacadeBase = new BLPrpDcompanyFacadeBase();
	      ArrayList<PrpDcompanyDto> prpDcompanyAll = (ArrayList<PrpDcompanyDto>) blPrpDcompanyFacadeBase.findByConditions(" 1=1");
	      
	      //报案补充说明信息
	      BLPrpLregistExtAction blPrpLregistExtAction = new BLPrpLregistExtAction();
	      String sql = "";
	      if("check".equals(nodeType)||"certa".equals(nodeType) || "propc".equals(nodeType) || "propv".equals(nodeType)){
	    	  sql = " registNo='"+registNo+"'and (checkstatus='0' or taskid in (select g.taskid from prplschedulemainwf g "+
                           " where g.registno=prplregistext.registno "+
                           "  and g.scheduletype='Main' "+ 
                           " )) order by inputdate  ,serialNo ";
	      }
	      else if("surve".equals(nodeType)){
	    	  sql = " registNo='"+registNo+"'and nodetype <>'check' and (checkstatus='0' or taskid in (select g.taskid from prplschedulemainwf g "+
              " where g.registno=prplregistext.registno "+
              "  and g.scheduletype='Wound' "+ 
              " )) order by inputdate  ,serialNo ";
	      } 
	      else if("regis".equals(nodeType) || "SHOW".equals(httpServletRequest.getParameter("editType"))){
	    	  sql = " registNo='"+registNo+"' and checkstatus='0' and (flag is null or flag = '' or flag='Y') order by  inputdate,serialNo ";
	      }
	      else{
	    	  sql = " registNo='"+registNo+"' and checkstatus='0' order by  inputdate  ,serialNo ";
	      }
	      ArrayList<PrpLregistExtDto> prpLregistExtDtoList = (ArrayList<PrpLregistExtDto>) blPrpLregistExtAction.findByRegistNo(sql);
	      
	      //通过用户编号 获取用户姓名
	      UICodeAction uICodeAction = new UICodeAction();
	      if(prpLregistExtDtoList!=null&&prpLregistExtDtoList.size()!=0){
	    	  
	    
	      //给节点nodeName赋值
	      for(int i=0;i<prpLregistExtDtoList.size();i++){
	    	  for(int x=0;x<swfNodeList.size();x++){
	    		  if(prpLregistExtDtoList.get(i).getNodetype().equals(swfNodeList.get(x).getNodeType())){
	    			  if(prpLregistExtDtoList.get(i).getNodetype().equals("regis")){
	    				  if(swfNodeList.get(x).getNodeNo() == 1){
	    					  prpLregistExtDtoList.get(i).setNodetypeName(swfNodeList.get(x).getNodeName());
	    	    			  prpLregistExtDtoList.get(i).setOperatorCodeName(uICodeAction.translateUserCode(prpLregistExtDtoList.get(i).getOperatorCode(), true));
	    				  }
	    			  }else{
	    				  prpLregistExtDtoList.get(i).setNodetypeName(swfNodeList.get(x).getNodeName());
		    			  prpLregistExtDtoList.get(i).setOperatorCodeName(uICodeAction.translateUserCode(prpLregistExtDtoList.get(i).getOperatorCode(), true));
	    			  }
	    		  }else if("fusen".equals(prpLregistExtDtoList.get(i).getNodetype())){
	    			  prpLregistExtDtoList.get(i).setNodetypeName("复审");
	    			  prpLregistExtDtoList.get(i).setOperatorCodeName(uICodeAction.translateUserCode(prpLregistExtDtoList.get(i).getOperatorCode(), true));
	    		  }
	    	  }
	    	  //询价补充说明带入
	    	  if("askfee".equals(prpLregistExtDtoList.get(i).getNodetype())){
	    		  prpLregistExtDtoList.get(i).setNodetypeName("询价");
    			  prpLregistExtDtoList.get(i).setOperatorCodeName(uICodeAction.translateUserCode(prpLregistExtDtoList.get(i).getOperatorCode(), true));
	    	  }
	    	  for(int y=0;y<prpDcompanyAll.size();y++){
	    		  if(prpLregistExtDtoList.get(i).getComCode().equals(prpDcompanyAll.get(y).getComCode())){
	    			  prpLregistExtDtoList.get(i).setComCName(prpDcompanyAll.get(y).getComCName());
	    		  }
	    	  }
	      }
	      }
	      String editType = httpServletRequest.getParameter("editType");	//当前状态
	      String status = httpServletRequest.getParameter("status");		//提交按钮状态
	      //补充说明 修改当前节点 最后一条信息
	      if("2".equals(status)){
	    	  ArrayList<PrpLregistExtDto> arrayList = new ArrayList<PrpLregistExtDto>();
	    	  for(int i=0;i<prpLregistExtDtoList.size();i++){
	    		  if(prpLregistExtDtoList.get(i).getNodetype().equals(nodeType)){
	    			  arrayList.add(prpLregistExtDtoList.get(i));
	    			  
	    		  }
	    	  }
	    	  if(arrayList.size()>0){
	    		  prpLregistExtDtoList.remove(arrayList.get(arrayList.size()-1));
	    		  prpLregistExtDtoList.add(arrayList.get(arrayList.size()-1));
	    	  }
//	    	  for(int i=0;i<prpLregistExtDtoList.size();i++){
//	    		  System.out.println(i+" editType:"+editType+"         serialno:"+prpLregistExtDtoList.get(i).getSerialNo()+"      nodetype:"+prpLregistExtDtoList.get(i).getNodetype()+"      nodeType(yemian): "+nodeType+"   status:"+status);
//	    	  }
//	    	  System.out.println(arrayList.get(arrayList.size()-1).getSerialNo());
	      }
	      if(nodeType != null && !"".equals(nodeType)){
	    	  if(nodeType.equals("check") || nodeType.equals("certa") || nodeType.equals("propc")){
	    		  ArrayList<SwfLogDto> swfLogDto = (ArrayList<SwfLogDto>) blSwfLogFacade.findByConditions("registno='"+registNo+"' and nodetype='check' order by logno desc");
	    		  if(swfLogDto.size()>0){
	    			  if(swfLogDto.get(0).getNodeStatus().equals("2")){
	    				  //查勘节点
	    				  httpServletRequest.setAttribute("checkNodeType", "CHECKADD");	//当前节点
	    			  }else{
	    				  httpServletRequest.setAttribute("checkNodeType", "0");	//当前节点
	    			  }
	    		  }else{
	    			  httpServletRequest.setAttribute("checkNodeType", "0");	//当前节点
	    		  }
	    	  }else{
	    		  httpServletRequest.setAttribute("checkNodeType", "0");	//当前节点
	    	  }
	      }else{
	    	  httpServletRequest.setAttribute("checkNodeType", "0");	//当前节点
	      }
	      PrpLregistExtDto prpLregistExtDto = new PrpLregistExtDto();
	      BLSwfLogFacade swfLogFacade = new BLSwfLogFacade();
	      ArrayList swfNodeListTemp = new ArrayList();
	      SwfLogDto swfLogDto = new SwfLogDto();
	      String flowOutTime = "";
	      String flowtime = "";
	      String timeTemp = "";
	      int index = 0;
	      /**
	      if(prpLregistExtDtoList.size()>0){
	    	  
				for (int s = 0; s < prpLregistExtDtoList.size(); s++) {
					prpLregistExtDto = prpLregistExtDtoList.get(s);
					swfNodeListTemp = (ArrayList<SwfLogDto>) swfLogFacade.findByConditions(" registno = '" + registNo+ "' and nodetype = '"+ prpLregistExtDto.getNodetype()+ "' order by logno");
					if (swfNodeListTemp != null && swfNodeListTemp.size() > 0) {
						swfLogDto = (SwfLogDto)swfNodeListTemp.get(0);
						// 流出时间
						if(prpLregistExtDto.getInputHour()!=null && !"".equals(prpLregistExtDto.getInputHour())){
						flowOutTime = new DateTime(prpLregistExtDto.getInputDate()
								+ " " + prpLregistExtDto.getInputHour(),
								DateTime.YEAR_TO_SECOND).toString();
						} else {
							flowOutTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_SECOND).toString();
						}
						// 流入时间
						flowtime = swfLogDto.getFlowInTime();
						timeTemp = DateCompute.betweenDate(flowtime, flowOutTime);
						index = timeTemp.indexOf("钟");
						if (index != -1) {
							timeTemp = timeTemp.substring(0, index);
						}
						prpLregistExtDto.setCostTime(timeTemp);
					}

				}
	      }*/
	      /*
	      if(prpLregistExtDtoList.size()>0){
	    	  prpLregistExtDto = prpLregistExtDtoList.get(0);
			  swfNodeListTemp = (ArrayList<SwfLogDto>) swfLogFacade.findByConditions(" registno = '" + registNo+ "' and nodetype = '"+ prpLregistExtDto.getNodetype()+ "' order by logno");
			  if (swfNodeListTemp != null && swfNodeListTemp.size() > 0) {
				  swfLogDto = (SwfLogDto)swfNodeListTemp.get(0);
				  getCostTime(prpLregistExtDtoList,swfLogDto.getFlowInTime());
			  }
	      }*/
	      httpServletRequest.setAttribute("prpLregistExtDtoList", prpLregistExtDtoList);
	}
	
	public String getPower(String tableName) throws Exception {
		String sql = "";
		//1.非总共司报案的险类有以下这些
		String inClassCode = SysConfig.getProperty("registqueryInclass","claim");
		//2.在以上险类中，有部分险种特殊。例如以下这些险种，即使险类符合非总公司报案，但仍然要总公司报案
		String notInRiskCode = SysConfig.getProperty("registqueryNotInRisk","claim");
		if(inClassCode==null||inClassCode.trim().length()==0){
			sql = "and 1=2";
		}else{
			if(notInRiskCode==null||notInRiskCode.trim().length()==0){
				sql =  " and "+tableName+".Classcode in ("+inClassCode+")   ";
			}else{
				sql =  " and "+tableName+".Classcode in ("+inClassCode+")  and "+tableName+".riskCode not in ("+notInRiskCode+") ";
			}
		}
		return sql;
	}
 	
}
