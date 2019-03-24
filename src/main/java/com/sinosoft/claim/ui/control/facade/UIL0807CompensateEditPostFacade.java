package com.sinosoft.claim.ui.control.facade;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.custom.WorkFlowDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLhospitalizationPayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossDto;
import com.sinosoft.claim.dto.domain.SwfLogDto;
import com.sinosoft.claim.dto.domain.SwfPathLogDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UICompensateAction;
import com.sinosoft.claim.ui.control.action.UIWorkFlowAction;
import com.sinosoft.claim.ui.control.viewHelper.WorkFlowViewHelper;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.exceptionlog.UserException;

/**
 * 分发HTTP Post 车险理赔实赔编辑界面
 * <p>
 * Title: 车险理赔实赔编辑界面信息
 * </p>
 * <p>
 * Description: 车险理赔实赔编辑界面信息
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
public class UIL0807CompensateEditPostFacade extends Action {
	public ActionForward execute(
			ActionMapping actionMapping, 
			ActionForm actionForm,
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) throws Exception {
		String forward = ""; //向前流转
		try {
			String compensateNo = ""; //赔款计算书号
			String swfLogFlowID = httpServletRequest.getParameter("swfLogFlowID"); 
			String swfLogLogNo = httpServletRequest.getParameter("swfLogLogNo");
			int LogNo = Integer.parseInt(swfLogLogNo);
			UIWorkFlowAction uiworkflowaction = new UIWorkFlowAction();
			SwfLogDto swfLogDto = uiworkflowaction.findNodeByPrimaryKey(swfLogFlowID, LogNo);
			if (swfLogDto.getNodeType().equals("compe")) {
				swfLogDto.setHandlerCode("");
				swfLogDto.setHandlerName("");
			}
			uiworkflowaction.updateFlow(swfLogDto);
			UICodeAction uiCodeAction = new UICodeAction();
			int newCompensate = -1; 
			UserDto user = (UserDto) httpServletRequest.getSession().getAttribute("user");
			String riskCodeTemp = "2601";
			String caseType = "0";
			if (riskCodeTemp != null && riskCodeTemp.trim().length() > 0) {
				user.setRiskCode(riskCodeTemp);
			}
			String comCode = user.getComCode();
			String riskCode = user.getRiskCode();
			int year = DateTime.current().getYear();
			
			String strLastAccessedTime = "" + httpServletRequest.getSession().getLastAccessedTime() / 1000;
			String oldLastAccessedTime = (String) httpServletRequest.getSession().getAttribute("oldCompensateLastAccessedTime");
			
			
			if (oldLastAccessedTime.trim().equals("")) {
				
				httpServletRequest.getSession().setAttribute("oldCompensateLastAccessedTime", strLastAccessedTime);
				compensateNo = httpServletRequest.getParameter("prpLcompensateCompensateNo");
				if (compensateNo == null || compensateNo.length() < 1 || compensateNo.trim().equals("")) {
					UIBillAction uiBillAction = new UIBillAction();//
					String tableName = "prplcompensate";
					compensateNo = uiBillAction.getNo(tableName, httpServletRequest.getParameter("prpLcompensateClaimNo"), comCode, year);
					newCompensate = 1; 
				}
				httpServletRequest.setAttribute("compensateNo", compensateNo);
				
				CompensateDto compensateDto = new CompensateDto();

				/*---------------------实赔主表prpLcompensate------------------------------------*/
				PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
				prpLcompensateDto.setCompensateNo(compensateNo);
				prpLcompensateDto.setLFlag("L");
				prpLcompensateDto.setCaseNo("");
				prpLcompensateDto.setTimes(1);
				prpLcompensateDto.setClassCode("26");
				prpLcompensateDto.setRiskCode("2601");
				prpLcompensateDto.setClaimNo((String) httpServletRequest.getParameter("prpLcompensateClaimNo"));
				prpLcompensateDto.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
				//prpLcompensateDto.setDeductCond((String) httpServletRequest.getParameter("prpLcompensateDeductCond"));
				//prpLcompensateDto.setPreserveDate(new DateTime(httpServletRequest.getParameter("prpLcompensatePreserveDate")));
				//prpLcompensateDto.setCheckAgentCode((String) httpServletRequest.getParameter("prpLcompensateCheckagentcode"));
				//prpLcompensateDto.setCheckAgentName((String) httpServletRequest.getParameter("prpLcompensateCheckagentname"));
				//prpLcompensateDto.setSurveyorName((String) httpServletRequest.getParameter("prpLcompensateSurveyorname"));
				//prpLcompensateDto.setCounterClaimerName((String) httpServletRequest.getParameter("prpLcompensateCounterclaimername"));
				//prpLcompensateDto.setDutyDescription((String) httpServletRequest.getParameter("prpLcompensateDutyDescription"));
				prpLcompensateDto.setCurrency("CNY");
				prpLcompensateDto.setSumLoss(Double.parseDouble(httpServletRequest.getParameter("buchangFee").replaceAll(",", "")));
				//prpLcompensateDto.setSumRest(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumRest")));
				prpLcompensateDto.setSumDutyPaid(Double.parseDouble(httpServletRequest.getParameter("anxinFee").replaceAll(",", "")));
				//prpLcompensateDto.setSumNoDutyFee(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumNoDutyFee")));
				prpLcompensateDto.setSumPaid(Double.parseDouble(httpServletRequest.getParameter("anxinFee").replaceAll(",", "")));
				//prpLcompensateDto.setSumPrePaid(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumPrePaid")));
				prpLcompensateDto.setSumThisPaid(Double.parseDouble(httpServletRequest.getParameter("anxinFee").replaceAll(",", "")));
				prpLcompensateDto.setReceiverName((String) httpServletRequest.getParameter("insuredName"));
				//prpLcompensateDto.setBank((String) httpServletRequest.getParameter("prpLcompensateBank"));
				//prpLcompensateDto.setAccount((String) httpServletRequest.getParameter("prpLcompensateAccount"));
				prpLcompensateDto.setMakeCom("31000000");
				prpLcompensateDto.setComCode(comCode);
				prpLcompensateDto.setHandlerCode(user.getUserCode());
				prpLcompensateDto.setHandler1Code(user.getUserCode());
				prpLcompensateDto.setApproverCode(user.getUserCode());
				//prpLcompensateDto.setUnderWriteCode("");
				//prpLcompensateDto.setUnderWriteName("");
				//prpLcompensateDto.setStatisticsYM(new DateTime(httpServletRequest.getParameter("prpLcompensateStatisticsYM")));
				prpLcompensateDto.setOperatorCode(user.getUserCode());
				prpLcompensateDto.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
				//prpLcompensateDto.setUnderWriteEndDate(new DateTime(httpServletRequest.getParameter("prpLcompensateUnderWriteEndDate")));
				//prpLcompensateDto.setUnderWriteFlag((String) httpServletRequest.getParameter("prpLcompensateUnderWriteFlag"));
				//prpLcompensateDto.setRemark((String) httpServletRequest.getParameter("prpLcompensateRemark"));
				//prpLcompensateDto.setFlag((String) httpServletRequest.getParameter("prpLcompensateFlag"));
				prpLcompensateDto.setIndemnityDutyRate(100);
				//prpLcompensateDto.setIndemnityDuty((String) httpServletRequest.getParameter("prpLcompensateIndemnityDuty"));
				prpLcompensateDto.setCaseType(caseType);
				prpLcompensateDto.setFinallyFlag("1");
				//String prpLcompensateResult = httpServletRequest.getParameter("result");
				//prpLcompensateDto.setResult(prpLcompensateResult);
				prpLcompensateDto.setInsuredName(httpServletRequest.getParameter("insuredName"));
				//prpLcompensateDto.setDamageName(httpServletRequest.getParameter("prpLcompensateDamageName"));
				//prpLcompensateDto.setSumAmount(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumAmount")));
                compensateDto.setPrpLcompensateDto(prpLcompensateDto);
                
                /*---------------------状态内容prpLclaimStatus------------------------------------*/
        		PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
        		prpLclaimStatusDto.setNodeType("compe");
        		prpLclaimStatusDto.setSerialNo(0);
        		prpLclaimStatusDto.setTypeFlag("2");
        		prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
        		prpLclaimStatusDto.setBusinessNo(prpLcompensateDto.getCompensateNo());
        		prpLclaimStatusDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
        		prpLclaimStatusDto.setRiskCode("2601");
        		prpLclaimStatusDto.setHandlerCode(user.getUserCode());
        		prpLclaimStatusDto.setInputDate(prpLcompensateDto.getInputDate());
        		prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
        		compensateDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
				
        		
        		ArrayList prpLpersonLossDtoList = new ArrayList();
        		ArrayList prpLhospitalizationPayFeeDtoList = new ArrayList();
        		double hospitalFee = Double.parseDouble(httpServletRequest.getParameter("buchangFee").replaceAll(",", ""));
        		if(hospitalFee>5000 && hospitalFee<=30000){
        			PrpLpersonLossDto prpLpersonLossDto = new PrpLpersonLossDto();
        			prpLpersonLossDto.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
                    prpLpersonLossDto.setRiskCode("2601");
                    prpLpersonLossDto.setCompensateNo(compensateNo);
                    prpLpersonLossDto.setSerialNo(1);
                    //prpLpersonLossDto.setIdentifyNumber(prpLpersonLossIdentifyNumber);
                    prpLpersonLossDto.setFamilyNo(2);
                    //prpLpersonLossDto.setLiabCode(prpLpersonLossLiabCode[index]);
                    //prpLpersonLossDto.setLiabName(prpLpersonLossLiabName[index]);
                    //prpLpersonLossDto.setJobCode(prpLpersonLossJobCode[index]);
                    //prpLpersonLossDto.setJobName(prpLpersonLossJobName[index]);
                    //prpLpersonLossDto.setItemAddress(prpLpersonLossItemAddress[index]);
                    //prpLpersonLossDto.setUnit(prpLpersonLossUnit[index]);
                    prpLpersonLossDto.setCurrency("CNY");
                    //prpLpersonLossDto.setAmount(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossAmount[index])));
                    prpLpersonLossDto.setCurrency1("CNY");
                    //prpLpersonLossDto.setItemValue(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossItemValue[index])));
                    prpLpersonLossDto.setCurrency2("CNY");
                    //prpLpersonLossDto.setSumRest(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossSumRest[index])));
                    prpLpersonLossDto.setClaimRate(100);
                    //prpLpersonLossDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductible[index])));
                    prpLpersonLossDto.setCurrency4("CNY");
                    prpLpersonLossDto.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0101").replaceAll(",", ""))));
                    //prpLpersonLossDto.setFlag(prpLpersonLossFlag[index]);
                    //prpLpersonLossDto.setLiabDetailCode(prpLpersonLossLiabDetailCode[index]);
                    prpLpersonLossDto.setLiabDetailName("住院医疗");
                    //prpLpersonLossDto.setUnitAmount(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossUnitAmount[index])));
                    //prpLpersonLossDto.setInjuryGrade(prpLpersonLossInjuryGrade[index]);
                    prpLpersonLossDto.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
                    prpLpersonLossDto.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
                    prpLpersonLossDto.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
                    prpLpersonLossDto.setLossQuantity(1);
                    prpLpersonLossDto.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
                    prpLpersonLossDto.setCurrency3("CNY");
                    //prpLpersonLossDto.setFamilyName(prpLpersonLossFamilyName[index]);
                    //prpLpersonLossDto.setIndemnityDutyRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossIndemnityDutyRate[index])));
                    //prpLpersonLossDto.setDeductibleRate(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossDeductibleRate[index])));
                    //prpLpersonLossDto.setPersonNo(index);
                    //prpLpersonLossDto.setRemark(prpLpersonLossRemark[index]);
                    prpLpersonLossDto.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
                    prpLpersonLossDto.setPersonNo(1);
                    prpLpersonLossDto.setPersonName((String) httpServletRequest.getParameter("insuredName"));
                    prpLpersonLossDto.setSex((String) httpServletRequest.getParameter("sexCode"));
                    prpLpersonLossDto.setKindCode("001");
                    prpLpersonLossDto.setItemKindNo(1);
                    //prpLpersonLossDto.setdblMaxPaid(Double.parseDouble(prpLpersonLossMaxPaid[index2]));
                    //prpLpersonLossDto.setMaxpaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossMaxPaid[index2])));
                    //prpLpersonLossDto.setHispaid(Double.parseDouble(DataUtils.nullToZero(prpLpersonLossHisPaid[index2])));
                    prpLpersonLossDtoList.add(prpLpersonLossDto);
                    
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0101 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0101.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0101.setUnitType("01");
                    prpLhospitalizationPayFeeDto0101.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0101.setFeeType("01");
                    prpLhospitalizationPayFeeDto0101.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0101.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0101").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0101.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0101);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0102 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0102.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0102.setUnitType("02");
                    prpLhospitalizationPayFeeDto0102.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0102.setFeeType("01");
                    prpLhospitalizationPayFeeDto0102.setFeeRate(25);
                    prpLhospitalizationPayFeeDto0102.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0102").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0102.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0102);
        		}
        		if(hospitalFee>30000 && hospitalFee<=40000){
        			PrpLpersonLossDto prpLpersonLossDto1 = new PrpLpersonLossDto();
  			        prpLpersonLossDto1.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
                    prpLpersonLossDto1.setRiskCode("2601");
                    prpLpersonLossDto1.setCompensateNo(compensateNo);
                    prpLpersonLossDto1.setSerialNo(1);
                    prpLpersonLossDto1.setFamilyNo(2);
                    prpLpersonLossDto1.setCurrency("CNY");
                    prpLpersonLossDto1.setCurrency1("CNY");
                    prpLpersonLossDto1.setCurrency2("CNY");
                    prpLpersonLossDto1.setClaimRate(100);
                    prpLpersonLossDto1.setCurrency4("CNY");
		            prpLpersonLossDto1.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0101").replaceAll(",", ""))));
		            prpLpersonLossDto1.setLiabDetailName("住院医疗");
		            prpLpersonLossDto1.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
		            prpLpersonLossDto1.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
		            prpLpersonLossDto1.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
		            prpLpersonLossDto1.setLossQuantity(1);
		            prpLpersonLossDto1.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
		            prpLpersonLossDto1.setCurrency3("CNY");
		            prpLpersonLossDto1.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
		            prpLpersonLossDto1.setPersonNo(1);
		            prpLpersonLossDto1.setPersonName((String) httpServletRequest.getParameter("insuredName"));
		            prpLpersonLossDto1.setSex((String) httpServletRequest.getParameter("sexCode"));
		            prpLpersonLossDto1.setKindCode("001");
		            prpLpersonLossDto1.setItemKindNo(1);
                    prpLpersonLossDtoList.add(prpLpersonLossDto1);
                    
                    PrpLpersonLossDto prpLpersonLossDto2 = new PrpLpersonLossDto();
  			        prpLpersonLossDto2.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
	                prpLpersonLossDto2.setRiskCode("2601");
	                prpLpersonLossDto2.setCompensateNo(compensateNo);
	                prpLpersonLossDto2.setSerialNo(2);
	                prpLpersonLossDto2.setFamilyNo(2);
	                prpLpersonLossDto2.setCurrency("CNY");
	                prpLpersonLossDto2.setCurrency1("CNY");
	                prpLpersonLossDto2.setCurrency2("CNY");
	                prpLpersonLossDto2.setClaimRate(100);
	                prpLpersonLossDto2.setCurrency4("CNY");
	                prpLpersonLossDto2.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0201").replaceAll(",", ""))));
	                prpLpersonLossDto2.setLiabDetailName("住院医疗");
	                prpLpersonLossDto2.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
	                prpLpersonLossDto2.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
	                prpLpersonLossDto2.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
	                prpLpersonLossDto2.setLossQuantity(1);
	                prpLpersonLossDto2.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
	                prpLpersonLossDto2.setCurrency3("CNY");
	                prpLpersonLossDto2.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
	                prpLpersonLossDto2.setPersonNo(1);
	                prpLpersonLossDto2.setPersonName((String) httpServletRequest.getParameter("insuredName"));
	                prpLpersonLossDto2.setSex((String) httpServletRequest.getParameter("sexCode"));
	                prpLpersonLossDto2.setKindCode("001");
	                prpLpersonLossDto2.setItemKindNo(1);
	                prpLpersonLossDtoList.add(prpLpersonLossDto2);
	                
	                
	                
	                PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0101 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0101.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0101.setUnitType("01");
                    prpLhospitalizationPayFeeDto0101.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0101.setFeeType("01");
                    prpLhospitalizationPayFeeDto0101.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0101.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0101").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0101.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0101);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0102 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0102.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0102.setUnitType("02");
                    prpLhospitalizationPayFeeDto0102.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0102.setFeeType("01");
                    prpLhospitalizationPayFeeDto0102.setFeeRate(25);
                    prpLhospitalizationPayFeeDto0102.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0102").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0102.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0102);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0201 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0201.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0201.setUnitType("01");
                    prpLhospitalizationPayFeeDto0201.setSerialNo(2);
                    prpLhospitalizationPayFeeDto0201.setFeeType("02");
                    prpLhospitalizationPayFeeDto0201.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0201.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0201").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0201.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0201);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0202 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0202.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0202.setUnitType("02");
                    prpLhospitalizationPayFeeDto0202.setSerialNo(2);
                    prpLhospitalizationPayFeeDto0202.setFeeType("02");
                    prpLhospitalizationPayFeeDto0202.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0202.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0202").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0202.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0202);
                    
        		}
        		if(hospitalFee>40000 && hospitalFee<=45000){
        			PrpLpersonLossDto prpLpersonLossDto1 = new PrpLpersonLossDto();
  			        prpLpersonLossDto1.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
                    prpLpersonLossDto1.setRiskCode("2601");
                    prpLpersonLossDto1.setCompensateNo(compensateNo);
                    prpLpersonLossDto1.setSerialNo(1);
                    prpLpersonLossDto1.setFamilyNo(2);
                    prpLpersonLossDto1.setCurrency("CNY");
                    prpLpersonLossDto1.setCurrency1("CNY");
                    prpLpersonLossDto1.setCurrency2("CNY");
                    prpLpersonLossDto1.setClaimRate(100);
                    prpLpersonLossDto1.setCurrency4("CNY");
		            prpLpersonLossDto1.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0101").replaceAll(",", ""))));
		            prpLpersonLossDto1.setLiabDetailName("住院医疗");
		            prpLpersonLossDto1.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
		            prpLpersonLossDto1.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
		            prpLpersonLossDto1.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
		            prpLpersonLossDto1.setLossQuantity(1);
		            prpLpersonLossDto1.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
		            prpLpersonLossDto1.setCurrency3("CNY");
		            prpLpersonLossDto1.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
		            prpLpersonLossDto1.setPersonNo(1);
		            prpLpersonLossDto1.setPersonName((String) httpServletRequest.getParameter("insuredName"));
		            prpLpersonLossDto1.setSex((String) httpServletRequest.getParameter("sexCode"));
		            prpLpersonLossDto1.setKindCode("001");
		            prpLpersonLossDto1.setItemKindNo(1);
                    prpLpersonLossDtoList.add(prpLpersonLossDto1);
                    
                    PrpLpersonLossDto prpLpersonLossDto2 = new PrpLpersonLossDto();
  			        prpLpersonLossDto2.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
	                prpLpersonLossDto2.setRiskCode("2601");
	                prpLpersonLossDto2.setCompensateNo(compensateNo);
	                prpLpersonLossDto2.setSerialNo(2);
	                prpLpersonLossDto2.setFamilyNo(2);
	                prpLpersonLossDto2.setCurrency("CNY");
	                prpLpersonLossDto2.setCurrency1("CNY");
	                prpLpersonLossDto2.setCurrency2("CNY");
	                prpLpersonLossDto2.setClaimRate(100);
	                prpLpersonLossDto2.setCurrency4("CNY");
	                prpLpersonLossDto2.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0201").replaceAll(",", ""))));
	                prpLpersonLossDto2.setLiabDetailName("住院医疗");
	                prpLpersonLossDto2.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
	                prpLpersonLossDto2.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
	                prpLpersonLossDto2.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
	                prpLpersonLossDto2.setLossQuantity(1);
	                prpLpersonLossDto2.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
	                prpLpersonLossDto2.setCurrency3("CNY");
	                prpLpersonLossDto2.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
	                prpLpersonLossDto2.setPersonNo(1);
	                prpLpersonLossDto2.setPersonName((String) httpServletRequest.getParameter("insuredName"));
	                prpLpersonLossDto2.setSex((String) httpServletRequest.getParameter("sexCode"));
	                prpLpersonLossDto2.setKindCode("001");
	                prpLpersonLossDto2.setItemKindNo(1);
	                prpLpersonLossDtoList.add(prpLpersonLossDto2);
	                
	                PrpLpersonLossDto prpLpersonLossDto3 = new PrpLpersonLossDto();
  			        prpLpersonLossDto3.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
	                prpLpersonLossDto3.setRiskCode("2601");
	                prpLpersonLossDto3.setCompensateNo(compensateNo);
	                prpLpersonLossDto3.setSerialNo(3);
	                prpLpersonLossDto3.setFamilyNo(2);
	                prpLpersonLossDto3.setCurrency("CNY");
	                prpLpersonLossDto3.setCurrency1("CNY");
	                prpLpersonLossDto3.setCurrency2("CNY");
	                prpLpersonLossDto3.setClaimRate(100);
	                prpLpersonLossDto3.setCurrency4("CNY");
	                prpLpersonLossDto3.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0301").replaceAll(",", ""))));
	                prpLpersonLossDto3.setLiabDetailName("住院医疗");
	                prpLpersonLossDto3.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
	                prpLpersonLossDto3.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
	                prpLpersonLossDto3.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
	                prpLpersonLossDto3.setLossQuantity(1);
	                prpLpersonLossDto3.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
	                prpLpersonLossDto3.setCurrency3("CNY");
	                prpLpersonLossDto3.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
	                prpLpersonLossDto3.setPersonNo(1);
	                prpLpersonLossDto3.setPersonName((String) httpServletRequest.getParameter("insuredName"));
	                prpLpersonLossDto3.setSex((String) httpServletRequest.getParameter("sexCode"));
	                prpLpersonLossDto3.setKindCode("001");
	                prpLpersonLossDto3.setItemKindNo(1);
	                prpLpersonLossDtoList.add(prpLpersonLossDto3);
	                
	                
	                
	                PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0101 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0101.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0101.setUnitType("01");
                    prpLhospitalizationPayFeeDto0101.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0101.setFeeType("01");
                    prpLhospitalizationPayFeeDto0101.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0101.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0101").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0101.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0101);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0102 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0102.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0102.setUnitType("02");
                    prpLhospitalizationPayFeeDto0102.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0102.setFeeType("01");
                    prpLhospitalizationPayFeeDto0102.setFeeRate(25);
                    prpLhospitalizationPayFeeDto0102.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0102").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0102.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0102);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0201 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0201.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0201.setUnitType("01");
                    prpLhospitalizationPayFeeDto0201.setSerialNo(2);
                    prpLhospitalizationPayFeeDto0201.setFeeType("02");
                    prpLhospitalizationPayFeeDto0201.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0201.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0201").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0201.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0201);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0202 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0202.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0202.setUnitType("02");
                    prpLhospitalizationPayFeeDto0202.setSerialNo(2);
                    prpLhospitalizationPayFeeDto0202.setFeeType("02");
                    prpLhospitalizationPayFeeDto0202.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0202.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0202").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0202.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0202);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0301 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0301.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0301.setUnitType("01");
                    prpLhospitalizationPayFeeDto0301.setSerialNo(3);
                    prpLhospitalizationPayFeeDto0301.setFeeType("03");
                    prpLhospitalizationPayFeeDto0301.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0301.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0301").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0301.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0301);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0302 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0302.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0302.setUnitType("02");
                    prpLhospitalizationPayFeeDto0302.setSerialNo(3);
                    prpLhospitalizationPayFeeDto0302.setFeeType("03");
                    prpLhospitalizationPayFeeDto0302.setFeeRate(55);
                    prpLhospitalizationPayFeeDto0302.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0302").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0302.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0302);
        		}
        		compensateDto.setPrpLpersonLossDtoList(prpLpersonLossDtoList);
        		
        		if(hospitalFee>45000){
        			PrpLpersonLossDto prpLpersonLossDto1 = new PrpLpersonLossDto();
  			        prpLpersonLossDto1.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
                    prpLpersonLossDto1.setRiskCode("2601");
                    prpLpersonLossDto1.setCompensateNo(compensateNo);
                    prpLpersonLossDto1.setSerialNo(1);
                    prpLpersonLossDto1.setFamilyNo(2);
                    prpLpersonLossDto1.setCurrency("CNY");
                    prpLpersonLossDto1.setCurrency1("CNY");
                    prpLpersonLossDto1.setCurrency2("CNY");
                    prpLpersonLossDto1.setClaimRate(100);
                    prpLpersonLossDto1.setCurrency4("CNY");
		            prpLpersonLossDto1.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0101").replaceAll(",", ""))));
		            prpLpersonLossDto1.setLiabDetailName("住院医疗");
		            prpLpersonLossDto1.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
		            prpLpersonLossDto1.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
		            prpLpersonLossDto1.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
		            prpLpersonLossDto1.setLossQuantity(1);
		            prpLpersonLossDto1.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
		            prpLpersonLossDto1.setCurrency3("CNY");
		            prpLpersonLossDto1.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
		            prpLpersonLossDto1.setPersonNo(1);
		            prpLpersonLossDto1.setPersonName((String) httpServletRequest.getParameter("insuredName"));
		            prpLpersonLossDto1.setSex((String) httpServletRequest.getParameter("sexCode"));
		            prpLpersonLossDto1.setKindCode("001");
		            prpLpersonLossDto1.setItemKindNo(1);
                    prpLpersonLossDtoList.add(prpLpersonLossDto1);
                    
                    PrpLpersonLossDto prpLpersonLossDto2 = new PrpLpersonLossDto();
  			        prpLpersonLossDto2.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
	                prpLpersonLossDto2.setRiskCode("2601");
	                prpLpersonLossDto2.setCompensateNo(compensateNo);
	                prpLpersonLossDto2.setSerialNo(2);
	                prpLpersonLossDto2.setFamilyNo(2);
	                prpLpersonLossDto2.setCurrency("CNY");
	                prpLpersonLossDto2.setCurrency1("CNY");
	                prpLpersonLossDto2.setCurrency2("CNY");
	                prpLpersonLossDto2.setClaimRate(100);
	                prpLpersonLossDto2.setCurrency4("CNY");
	                prpLpersonLossDto2.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0201").replaceAll(",", ""))));
	                prpLpersonLossDto2.setLiabDetailName("住院医疗");
	                prpLpersonLossDto2.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
	                prpLpersonLossDto2.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
	                prpLpersonLossDto2.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
	                prpLpersonLossDto2.setLossQuantity(1);
	                prpLpersonLossDto2.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
	                prpLpersonLossDto2.setCurrency3("CNY");
	                prpLpersonLossDto2.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
	                prpLpersonLossDto2.setPersonNo(1);
	                prpLpersonLossDto2.setPersonName((String) httpServletRequest.getParameter("insuredName"));
	                prpLpersonLossDto2.setSex((String) httpServletRequest.getParameter("sexCode"));
	                prpLpersonLossDto2.setKindCode("001");
	                prpLpersonLossDto2.setItemKindNo(1);
	                prpLpersonLossDtoList.add(prpLpersonLossDto2);
	                
	                PrpLpersonLossDto prpLpersonLossDto3 = new PrpLpersonLossDto();
  			        prpLpersonLossDto3.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
	                prpLpersonLossDto3.setRiskCode("2601");
	                prpLpersonLossDto3.setCompensateNo(compensateNo);
	                prpLpersonLossDto3.setSerialNo(3);
	                prpLpersonLossDto3.setFamilyNo(2);
	                prpLpersonLossDto3.setCurrency("CNY");
	                prpLpersonLossDto3.setCurrency1("CNY");
	                prpLpersonLossDto3.setCurrency2("CNY");
	                prpLpersonLossDto3.setClaimRate(100);
	                prpLpersonLossDto3.setCurrency4("CNY");
	                prpLpersonLossDto3.setSumRealPay(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("fee0301").replaceAll(",", ""))));
	                prpLpersonLossDto3.setLiabDetailName("住院医疗");
	                prpLpersonLossDto3.setHospitalDays(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("damageDays"))));
	                prpLpersonLossDto3.setInHospDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
	                prpLpersonLossDto3.setOutHospDate(new DateTime(httpServletRequest.getParameter("damageEndDate")));                
	                prpLpersonLossDto3.setLossQuantity(1);
	                prpLpersonLossDto3.setSumLoss(Double.parseDouble(DataUtils.nullToZero((String) httpServletRequest.getParameter("buchangFee").replaceAll(",", ""))));
	                prpLpersonLossDto3.setCurrency3("CNY");
	                prpLpersonLossDto3.setAge(Integer.parseInt(DataUtils.nullToZero((String) httpServletRequest.getParameter("age"))));
	                prpLpersonLossDto3.setPersonNo(1);
	                prpLpersonLossDto3.setPersonName((String) httpServletRequest.getParameter("insuredName"));
	                prpLpersonLossDto3.setSex((String) httpServletRequest.getParameter("sexCode"));
	                prpLpersonLossDto3.setKindCode("001");
	                prpLpersonLossDto3.setItemKindNo(1);
	                prpLpersonLossDtoList.add(prpLpersonLossDto3);
	                
	                
	                
	                PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0101 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0101.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0101.setUnitType("01");
                    prpLhospitalizationPayFeeDto0101.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0101.setFeeType("01");
                    prpLhospitalizationPayFeeDto0101.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0101.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0101").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0101.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0101);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0102 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0102.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0102.setUnitType("02");
                    prpLhospitalizationPayFeeDto0102.setSerialNo(1);
                    prpLhospitalizationPayFeeDto0102.setFeeType("01");
                    prpLhospitalizationPayFeeDto0102.setFeeRate(25);
                    prpLhospitalizationPayFeeDto0102.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0102").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0102.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0102);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0201 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0201.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0201.setUnitType("01");
                    prpLhospitalizationPayFeeDto0201.setSerialNo(2);
                    prpLhospitalizationPayFeeDto0201.setFeeType("02");
                    prpLhospitalizationPayFeeDto0201.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0201.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0201").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0201.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0201);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0202 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0202.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0202.setUnitType("02");
                    prpLhospitalizationPayFeeDto0202.setSerialNo(2);
                    prpLhospitalizationPayFeeDto0202.setFeeType("02");
                    prpLhospitalizationPayFeeDto0202.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0202.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0202").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0202.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0202);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0301 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0301.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0301.setUnitType("01");
                    prpLhospitalizationPayFeeDto0301.setSerialNo(3);
                    prpLhospitalizationPayFeeDto0301.setFeeType("03");
                    prpLhospitalizationPayFeeDto0301.setFeeRate(35);
                    prpLhospitalizationPayFeeDto0301.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0301").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0301.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0301);
                    
                    PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0302 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0302.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0302.setUnitType("02");
                    prpLhospitalizationPayFeeDto0302.setSerialNo(3);
                    prpLhospitalizationPayFeeDto0302.setFeeType("03");
                    prpLhospitalizationPayFeeDto0302.setFeeRate(55);
                    prpLhospitalizationPayFeeDto0302.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0302").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0302.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0302);
        			
        			
        			PrpLhospitalizationPayFeeDto prpLhospitalizationPayFeeDto0402 = new PrpLhospitalizationPayFeeDto();
                    prpLhospitalizationPayFeeDto0402.setCompensateNo(compensateNo);
                    prpLhospitalizationPayFeeDto0402.setUnitType("02");
                    prpLhospitalizationPayFeeDto0402.setSerialNo(4);
                    prpLhospitalizationPayFeeDto0402.setFeeType("04");
                    prpLhospitalizationPayFeeDto0402.setFeeRate(90);
                    prpLhospitalizationPayFeeDto0402.setFee(Double.parseDouble(httpServletRequest.getParameter("fee0402").replaceAll(",", "")));
                    prpLhospitalizationPayFeeDto0402.setInputDate(new DateTime(DateTime.current().toString(), DateTime.YEAR_TO_DAY));
                    prpLhospitalizationPayFeeDtoList.add(prpLhospitalizationPayFeeDto0402);
        		}
				compensateDto.setPrpLhospitalizationPayFeeDtoList(prpLhospitalizationPayFeeDtoList);
				
					
				WorkFlowViewHelper workFlowViewHelper = new WorkFlowViewHelper();
				SwfLogDto swfLogDtoDealNode = new SwfLogDto();

				swfLogDtoDealNode.setNewMTask(newCompensate);

				if (!swfLogFlowID.equals("null") && !swfLogLogNo.equals("null")) {
					swfLogDtoDealNode.setFlowID(swfLogFlowID);
					swfLogDtoDealNode.setLogNo(Integer.parseInt(DataUtils.nullToZero(swfLogLogNo)));
				}

				if (newCompensate == 1) {
					swfLogDtoDealNode.setBusinessNo(compensateDto.getPrpLcompensateDto().getClaimNo()); //本节点的查找
					swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo());

				} else {
					swfLogDtoDealNode.setBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo()); //本节点的查找
					swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getClaimNo());
				}

				swfLogDtoDealNode.setKeyIn(compensateDto.getPrpLcompensateDto().getClaimNo());
				swfLogDtoDealNode.setNodeStatus((String) httpServletRequest.getParameter("buttonSaveType"));
				swfLogDtoDealNode.setKeyOut(compensateDto.getPrpLcompensateDto().getCompensateNo());

				if (("3".equals(caseType) || "4".equals(caseType) || "6".equals(caseType))
						&& "4".equals(swfLogDtoDealNode.getNodeStatus())) {
					swfLogDtoDealNode.setNextBusinessNo(compensateDto.getPrpLcompensateDto().getCompensateNo());
				}
			
				WorkFlowDto workFlowDto = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
				
			//------------------------------------------------------------
				//保存赔款计算书信息
				UICompensateAction uiCompensateAction = new UICompensateAction();
				int vericLogNo = 0;
				if (workFlowViewHelper.checkDealDto(workFlowDto)) {
					
					if (swfLogDtoDealNode.getNodeStatus().equals("4")) {
						WorkFlowDto workFlowDtoTemp =null;
						swfLogDtoDealNode.setNodeStatus("2");
						workFlowDtoTemp = workFlowViewHelper.viewToDto(user, swfLogDtoDealNode);
						compensateDto.getPrpLcompensateDto().setUnderWriteFlag("0");
						uiCompensateAction.save(compensateDto, workFlowDtoTemp);

						if (httpServletRequest.getParameter("buttonSaveType").equals("4")) {
							compensateDto.getPrpLcompensateDto().setUnderWriteFlag("9");
						}
                        
						if (workFlowDto.getSubmitSwfLogDtoList() != null
								&& workFlowDto.getSubmitSwfLogDtoList().size() > 0) {
							vericLogNo = ((SwfLogDto) workFlowDto.getSubmitSwfLogDtoList().get(0)).getLogNo();
						}

						
						UIWorkFlowUWInterFaceFacade uiWorkFlowUWInterFaceFacade = new UIWorkFlowUWInterFaceFacade();
						String UWflowID = uiWorkFlowUWInterFaceFacade.submitVericTask(workFlowDto.getUpdateSwfLogDto()
								.getFlowID(), vericLogNo + "", "22", "C", compensateDto.getPrpLcompensateDto()
								.getCompensateNo(), compensateDto.getPrpLcompensateDto().getRiskCode(), compensateDto
								.getPrpLcompensateDto().getClassCode(), compensateDto.getPrpLcompensateDto()
								.getComCode(), compensateDto.getPrpLcompensateDto().getHandlerCode(), compensateDto
								.getPrpLcompensateDto().getMakeCom(), user.getUserCode(), compensateDto
								.getPrpLcompensateDto().getHandler1Code(), "");
						if (UWflowID.length() < 15) {
							String msg = "案件'" + compensateNo + "'提交双核系统失败，请重新提交或者与管理员联系!";

							throw new UserException(1, 3, "工作流", msg);
						}
	                    
						
						if (newCompensate == 1){ 
							 int newCompeLogNo=0;
							if (workFlowDtoTemp.getSubmitSwfLogDtoList()!=null){
						     newCompeLogNo=((SwfLogDto)workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).getLogNo();
						    ((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0)).setNodeStatus ( "4");
							workFlowDto.setUpdate( true);
							workFlowDto.setUpdateSwfLogDto((SwfLogDto) workFlowDtoTemp.getSubmitSwfLogDtoList().get(0));
							}
							if (workFlowDto.getSubmitSwfLogDtoList()!=null){
								
								for (int i=0;i<workFlowDto.getSubmitSwfLogDtoList().size();i++){
									if (((SwfLogDto)workFlowDto.getSubmitSwfLogDtoList().get( i)).getLogNo() ==newCompeLogNo){
										workFlowDto.getSubmitSwfLogDtoList().remove(i);
										break;
									}
									
								}
							}
							
							if (workFlowDto.getSubmitSwfPathLogDtoList()!=null){
								
								for (int i=0;i<workFlowDto.getSubmitSwfPathLogDtoList().size();i++){
									if (((SwfPathLogDto)workFlowDto.getSubmitSwfPathLogDtoList().get( i)).getEndNodeNo() ==newCompeLogNo){
										workFlowDto.getSubmitSwfPathLogDtoList().remove(i);
										break;
									}
									
								}
							}
						}

					}
					uiCompensateAction.save(compensateDto, workFlowDto);
					compensateDto.getPrpLcompensateDto().setRemark("测试remark");
					user.setUserMessage(compensateNo);
				} else {
					uiCompensateAction.save(compensateDto);
					user.setUserMessage(compensateNo + ";注意:没有发现与工作流流程相关任何数据！！");
				}

				httpServletRequest.setAttribute("prpLcompensateDto", compensateDto.getPrpLcompensateDto());
			} else {
				
				throw new UserException(1, 3, "工作流", "请不要重复提交");
			}
			ActionMessages messages = new ActionMessages();

			if (httpServletRequest.getParameter("buttonSaveType").trim().equals("4")) {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.submit"));
			} else {
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("prompt.compensate.save"));
			}
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("db.prpLcompensate.compensateNo"));
			saveMessages(httpServletRequest, messages);
			forward = "success";
			String printFlag = httpServletRequest.getParameter("prpLcompensatePrintFlag");
			if (printFlag != null && printFlag.trim().equals("1")) {
				httpServletResponse.sendRedirect("/claim/ClaimPrint.do?printType=Compensate&CompensateNo="
						+ compensateNo);
			}
		} catch (UserException usee) {
			usee.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", usee.getErrorMessage());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			e.printStackTrace(new PrintWriter(stringWriter));
			e.printStackTrace();
			//错误信息处理
			ActionMessages errors = new ActionMessages();
			ActionMessage error = new ActionMessage("title.compensateBeforeEdit.editCompensate");
			errors.add(ActionMessages.GLOBAL_MESSAGE, error);
			httpServletRequest.setAttribute("errorMessage", stringWriter.toString());
			saveErrors(httpServletRequest, errors);
			forward = "error";

		} 
		return actionMapping.findForward(forward);
	}
}   
