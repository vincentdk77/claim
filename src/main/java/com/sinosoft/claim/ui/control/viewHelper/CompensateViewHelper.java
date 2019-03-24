package com.sinosoft.claim.ui.control.viewHelper;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gyic.claim.dto.domain.PrplcompensateearDto;
import com.sinosoft.claim.dto.custom.CompensateDto;
import com.sinosoft.claim.dto.custom.UserDto;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLcfeecoinsDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLclaimStatusDto;
import com.sinosoft.claim.dto.domain.PrpLcompensateDto;
import com.sinosoft.claim.dto.domain.PrpLctextDto;
import com.sinosoft.claim.dto.domain.PrpLinjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrplcompensatehouseDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.DataUtils;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * <p>
 * Title: CompensateViewHelper
 * </p>
 * <p>
 * Description:ʵ��ViewHelper�࣬�ڸ��������ҳ�����ݵ�����
 * </p>
 * <p>
 * Copyright: Copyright �п���Ƽ��ɷ����޹�˾(c) 2004
 * </p>
 * 
 * @author ����������Ŀ�� liubvo
 * @version 1.0 <br>
 */

public abstract class CompensateViewHelper {
	public static int RULE_LENGTH = 70; // rule�ֶεĳ���

	public static final String PAY_TEXT = "4";

	/**
	 * ȡ��ʼ����Ϣ��Ҫ�����ݵ�����. ��дʵ�ⵥʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȡ�ȡ��Щ��Ϣ��ҪһЩ��Σ�
	 * ���ǵ��ӿڵ�һ���ԣ�����Щ�����ΪDto��ʽ���룬Dto���þۺ϶��Ǽ̳еķ�ʽ�� ������ü̳еķ�ʽ�ֲ㴦��������߼�����������������������.
	 * 
	 * @param httpServletRequest
	 * @return RequestDto ȡ��ʼ����Ϣ��Ҫ������
	 * @throws Exception
	 */
	public abstract CompensateDto iniViewToDto(
			HttpServletRequest httpServletRequest) throws Exception;

	/**
	 * ��дʵ��ҳ�漰��ѯʵ��request������.
	 * ��дʵ��ʱҳ����Ҫһ���ĳ�ʼ����Ϣ����������롢��������Ϣ����������ȣ�����Щ��Ϣȡ��������request��
	 * ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������.
	 * 
	 * @param httpServletRequest
	 *            ���ظ�ҳ���request
	 * @param compensateDto
	 *            ȡ���ĳ�ʼ����ϢDto
	 * @throws Exception
	 */
	public abstract void dtoToView(HttpServletRequest httpServletRequest,
			CompensateDto compensateDto) throws Exception;

	/**
	 * ����ʵ��ʱʵ��ҳ����������. ������ü̳еķ�ʽ�ֲ㴦�����������������ݷ���������������������
	 * 
	 * @param httpServletRequest
	 * @return compensateDto ʵ�����ݴ������ݽṹ
	 * @throws Exception
	 */
	public CompensateDto viewToDto(HttpServletRequest httpServletRequest)
			throws Exception {
		CompensateDto compensateDto = new CompensateDto();
		/*---------------------ʵ������prpLcompensate------------------------------------*/
		String caseType = httpServletRequest
				.getParameter("prpLcompensateCaseType");
		PrpLcompensateDto prpLcompensateDto = new PrpLcompensateDto();
		prpLcompensateDto.setCompensateNo((String) httpServletRequest.getAttribute("compensateNo"));
		prpLcompensateDto.setLFlag((String) httpServletRequest.getParameter("LFlag"));
		prpLcompensateDto.setCaseNo((String) httpServletRequest.getParameter("prpLcompensateCaseNo"));
		prpLcompensateDto.setTimes(Integer.parseInt(httpServletRequest.getParameter("prpLcompensateTimes")));
		prpLcompensateDto.setClassCode((String) httpServletRequest.getParameter("prpLcompensateClassCode"));
		prpLcompensateDto.setRiskCode((String) httpServletRequest.getParameter("prpLcompensateRiskCode"));
		prpLcompensateDto.setClaimNo((String) httpServletRequest.getParameter("prpLcompensateClaimNo"));
		prpLcompensateDto.setPolicyNo((String) httpServletRequest.getParameter("prpLcompensatePolicyNo"));
		prpLcompensateDto.setDeductCond((String) httpServletRequest.getParameter("prpLcompensateDeductCond"));
		prpLcompensateDto.setPreserveDate(new DateTime(httpServletRequest.getParameter("prpLcompensatePreserveDate")));
		prpLcompensateDto.setCheckAgentCode((String) httpServletRequest.getParameter("prpLcompensateCheckagentcode"));
		prpLcompensateDto.setCheckAgentName((String) httpServletRequest.getParameter("prpLcompensateCheckagentname"));
		prpLcompensateDto.setSurveyorName((String) httpServletRequest.getParameter("prpLcompensateSurveyorname"));
		prpLcompensateDto.setCounterClaimerName((String) httpServletRequest.getParameter("prpLcompensateCounterclaimername"));
		prpLcompensateDto.setDutyDescription((String) httpServletRequest.getParameter("prpLcompensateDutyDescription"));
		prpLcompensateDto.setCurrency((String) httpServletRequest.getParameter("prpLcompensateCurrency"));
		prpLcompensateDto.setSumLoss(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumLoss")));
		prpLcompensateDto.setSumRest(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumRest")));
		prpLcompensateDto.setSumDutyPaid(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumDutyPaid")));
		prpLcompensateDto.setSumNoDutyFee(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumNoDutyFee")));
		prpLcompensateDto.setSumPaid(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumPaid")));
		prpLcompensateDto.setSumPrePaid(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumPrePaid")));
		prpLcompensateDto.setSumThisPaid(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumThisPaid")));
		prpLcompensateDto.setReceiverName((String) httpServletRequest.getParameter("prpLcompensateReceiverName"));
		prpLcompensateDto.setBank((String) httpServletRequest.getParameter("prpLcompensateBank"));
		prpLcompensateDto.setAccount((String) httpServletRequest.getParameter("prpLcompensateAccount"));
		prpLcompensateDto.setMakeCom((String) httpServletRequest.getParameter("prpLcompensateMakeCom"));
		prpLcompensateDto.setComCode((String) httpServletRequest.getParameter("prpLcompensateComCode"));
		prpLcompensateDto.setHandlerCode((String) httpServletRequest.getParameter("prpLcompensateHandlerCode"));
		prpLcompensateDto.setHandler1Code((String) httpServletRequest.getParameter("prpLcompensateHandler1Code"));
		prpLcompensateDto.setApproverCode((String) httpServletRequest.getParameter("prpLcompensateApproverCode"));
		prpLcompensateDto.setUnderWriteCode((String) httpServletRequest.getParameter("prpLcompensateUnderWriteCode"));
		prpLcompensateDto.setUnderWriteName((String) httpServletRequest.getParameter("prpLcompensateUnderWriteName"));
		prpLcompensateDto.setStatisticsYM(new DateTime(httpServletRequest.getParameter("prpLcompensateStatisticsYM")));
		prpLcompensateDto.setOperatorCode((String) httpServletRequest.getParameter("prpLcompensateOperatorCode"));
		prpLcompensateDto.setInputDate(new DateTime(httpServletRequest.getParameter("prpLcompensateInputDate")));
		prpLcompensateDto.setUnderWriteEndDate(new DateTime(httpServletRequest.getParameter("prpLcompensateUnderWriteEndDate")));
		prpLcompensateDto.setUnderWriteFlag((String) httpServletRequest.getParameter("prpLcompensateUnderWriteFlag"));
		prpLcompensateDto.setRemark((String) httpServletRequest.getParameter("prpLcompensateRemark"));
		prpLcompensateDto.setFlag((String) httpServletRequest.getParameter("prpLcompensateFlag"));
		prpLcompensateDto.setDamageStartDate(new DateTime(httpServletRequest.getParameter("damageStartDate")));
		prpLcompensateDto.setDamageStartHour((String)httpServletRequest.getParameter("prpLcompensatedamageStartHour"));
		prpLcompensateDto.setIndemnityDutyRate(Double.parseDouble(httpServletRequest
						.getParameter("prpLcompensateIndemnityDutyRate")));
		prpLcompensateDto.setIndemnityDuty((String) httpServletRequest.getParameter("indemnityDuty"));
		prpLcompensateDto.setCaseType(caseType);
		prpLcompensateDto.setFinallyFlag((String) httpServletRequest.getParameter("prpLcompensateFinallyFlag"));

		//��ȡҳ���ѡ�ġ��Ƿ����ߡ���ֵ������ֵ��prpLcompensateDto�е�lawsuitFlag�ֶ��С�
		String prpLcompensateDtoLawsuitFlag = httpServletRequest.getParameter("prpLcompensateDtoLawsuitFlag");
		if(prpLcompensateDtoLawsuitFlag != null && !"".equals(prpLcompensateDtoLawsuitFlag)){
			prpLcompensateDto.setLawsuitFlag(prpLcompensateDtoLawsuitFlag);
		}
		//prpLcompensateDto.setFinallyFlag("1");
        String prpLcompensateResult = httpServletRequest.getParameter("result");// ��ȡ�������
		prpLcompensateDto.setResult(prpLcompensateResult);
    	prpLcompensateDto.setInsuredName(httpServletRequest.getParameter("prpLcompensateInsuredName"));
        prpLcompensateDto.setDamageName(httpServletRequest.getParameter("prpLcompensateDamageName"));
		prpLcompensateDto.setSumAmount(Double.parseDouble(httpServletRequest.getParameter("prpLcompensateSumAmount")));
		prpLcompensateDto.setClaimType(httpServletRequest.getParameter("claimType"));
		String coinsFlag = httpServletRequest.getParameter("coinsFlag") ; 
		if(coinsFlag != null && !"".equals(coinsFlag)){
			String prpLcompensateCoinsPaidLossType = httpServletRequest.getParameter("prpLcompensateCoinsPaidLossType") ; 
			double prpLcompensateCoinsSumPaid = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcompensateCoinsSumPaid"))) ; 
			double prpLcompensateCoinsOtherSumPaid = Double.parseDouble(DataUtils.nullToZero(httpServletRequest.getParameter("prpLcompensateCoinsOtherSumPaid"))) ; 
			prpLcompensateDto.setCoinsPaidLossType(prpLcompensateCoinsPaidLossType) ; 
			prpLcompensateDto.setCoinsSumPaid(prpLcompensateCoinsSumPaid) ; 
			if(prpLcompensateCoinsPaidLossType != null && "1".equals(prpLcompensateCoinsPaidLossType)){//ѡ��ȫ��100%�⸶ʱ
				String[] arrCoinsSerialNo = httpServletRequest.getParameterValues("CoinsSerialNo");
		        String[] arrCoinsType = httpServletRequest.getParameterValues("CoinsType");
		        String[] arrCoinsChiefFlag = httpServletRequest.getParameterValues("CoinsChiefFlag");
		        String[] arrCoinsCode = httpServletRequest.getParameterValues("CoinsCode");
		        String[] arrCoinsName = httpServletRequest.getParameterValues("CoinsName");
		        String[] arrCoinsRate = httpServletRequest.getParameterValues("CoinsRate");
		        String[] arrCoinsSumpaid = httpServletRequest.getParameterValues("CoinsSumpaid");
		        //����������÷�̯
		        String[] arrChargeCoinsSerialNo = httpServletRequest.getParameterValues("ChargeCoinsSerialNo");
		        String[] arrChargeCoinsCode = httpServletRequest.getParameterValues("ChargeCoinsCode");
		        String[] arrChargeCoinsName = httpServletRequest.getParameterValues("ChargeCoinsName");
		        String[] arrCoinschargeCode = httpServletRequest.getParameterValues("CoinschargeCode");
		        String[] arrCoinsChargeName = httpServletRequest.getParameterValues("CoinsChargeName");
		        String[] arrChargeCoinsSumpaid = httpServletRequest.getParameterValues("ChargeCoinsSumpaid");
		        
		        ArrayList prpLcfeeCoinsDtoList = new ArrayList();
		        PrpLcfeecoinsDto prpLcfeecoinsDto = null ; 
		        if(arrCoinsSerialNo != null ){
		        	for (int i = 1; i < arrCoinsSerialNo.length; i++) {
						if(Double.parseDouble(DataUtils.nullToZero(arrCoinsSumpaid[i])) != 0 ){
							prpLcfeecoinsDto = new PrpLcfeecoinsDto() ; 
							prpLcfeecoinsDto.setBusinessNo(prpLcompensateDto.getCompensateNo());
					        prpLcfeecoinsDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(arrCoinsSerialNo[i])));
					        prpLcfeecoinsDto.setRiskCode(prpLcompensateDto.getRiskCode());
					        prpLcfeecoinsDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
					        prpLcfeecoinsDto.setCurrency(prpLcompensateDto.getCurrency());
					        prpLcfeecoinsDto.setCoinsCode(arrCoinsCode[i]);
					        prpLcfeecoinsDto.setCoinsName(arrCoinsName[i]);
					        prpLcfeecoinsDto.setCoinsType(arrCoinsType[i]);
					        prpLcfeecoinsDto.setCoinsRate(Double.parseDouble(DataUtils.nullToZero(arrCoinsRate[i])));
					        prpLcfeecoinsDto.setChiefFlag(DataUtils.nullToZero(arrCoinsChiefFlag[i]));
					        prpLcfeecoinsDto.setLossFeeType("C");
					        prpLcfeecoinsDto.setChargeCode("");
					        prpLcfeecoinsDto.setChargeName("");
					        double sumPaid 
					        	= Math.round(Double.parseDouble(DataUtils.nullToZero(arrCoinsSumpaid[i])) / Double.parseDouble(DataUtils.nullToZero(arrCoinsRate[i])) * 100);
					        prpLcfeecoinsDto.setSumpaid(sumPaid);
					        prpLcfeecoinsDto.setCoinsSumpaid(Double.parseDouble(DataUtils.nullToZero(arrCoinsSumpaid[i])));
					        prpLcfeecoinsDto.setFlag("");
					        prpLcfeeCoinsDtoList.add(prpLcfeecoinsDto);
						}
					}
		        }
		        int size = prpLcfeeCoinsDtoList.size();
		        //����������÷�̯
		        if(arrChargeCoinsSerialNo != null){
		        	for (int z = 1; z < arrCoinsSerialNo.length; z++) {
			        	for (int i = 0; i < arrChargeCoinsSerialNo.length; i++) {
			        		size++;
							prpLcfeecoinsDto = new PrpLcfeecoinsDto() ;
							prpLcfeecoinsDto.setBusinessNo(prpLcompensateDto.getCompensateNo());
					        prpLcfeecoinsDto.setSerialNo(size);
					        prpLcfeecoinsDto.setRiskCode(prpLcompensateDto.getRiskCode());
					        prpLcfeecoinsDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
					        prpLcfeecoinsDto.setCurrency(prpLcompensateDto.getCurrency());
					        prpLcfeecoinsDto.setCoinsCode(arrChargeCoinsCode[i]);
					        prpLcfeecoinsDto.setCoinsName(arrChargeCoinsName[i]);
					        prpLcfeecoinsDto.setCoinsType(arrCoinsType[1]);
					        prpLcfeecoinsDto.setLossFeeType("L");
					        prpLcfeecoinsDto.setChargeCode(arrCoinschargeCode[i]);
					        prpLcfeecoinsDto.setChargeName(arrCoinsChargeName[i]);
					        double tempSumpaid
					        	= Math.round(Double.parseDouble(DataUtils.nullToZero(arrChargeCoinsSumpaid[i])) / Double.parseDouble(DataUtils.nullToZero(arrCoinsRate[z])) * 100);
					        prpLcfeecoinsDto.setSumpaid(tempSumpaid);
					        prpLcfeecoinsDto.setChiefFlag(DataUtils.nullToZero(arrCoinsChiefFlag[1]));
					        prpLcfeecoinsDto.setCoinsRate(Double.parseDouble(DataUtils.nullToZero(arrCoinsRate[z])));
					        double tempCoinsSumpaid 
					        	= Math.round(tempSumpaid * Double.parseDouble(DataUtils.nullToZero(arrCoinsRate[z])) / 100);
					        prpLcfeecoinsDto.setCoinsSumpaid(tempCoinsSumpaid);
					        prpLcfeeCoinsDtoList.add(prpLcfeecoinsDto);
						}
		        	}
		        }
		        compensateDto.setPrpLcfeecoinsList(prpLcfeeCoinsDtoList);
			}
		}
				
		//============���ݰ��ձ�������������ֶ� START=============
		String strObjectName = httpServletRequest.getParameter("prpLcompensateOjectName");
		String strObjectType = httpServletRequest.getParameter("prpLcompensateOjectType");
		String strObjectCode = httpServletRequest.getParameter("prpLcompensateOjectCode");
		if(strObjectName != null && strObjectType != null && strObjectCode != null){
			prpLcompensateDto.setOjectName(strObjectName);
			prpLcompensateDto.setOjectType(strObjectType);
			prpLcompensateDto.setOjectCode(strObjectCode);
		}
		//============���ݰ��ձ�������������ֶ� END===============
		//============���ݱ�����������������ֶ� START=============
		String prpLcompensateZeroLossType = httpServletRequest.getParameter("prpLcompensateZeroLossType");//���⸶ԭ��
		String prpLcompensateZeroLossCaseType = httpServletRequest.getParameter("prpLcompensateZeroLossCaseType");//ע����������
		String prpLcompensateDetailReason = httpServletRequest.getParameter("prpLcompensateDetailReason");//��ϸԭ��
		if(null != prpLcompensateZeroLossType ){
			prpLcompensateDto.setZeroLossType(prpLcompensateZeroLossType);
			if("1".equals(prpLcompensateZeroLossType)){
				if(null != prpLcompensateZeroLossCaseType){
					prpLcompensateDto.setZeroLossCaseType(prpLcompensateZeroLossCaseType);
				}
				if(null != prpLcompensateDetailReason){
					prpLcompensateDto.setZeroLossDetailReason(prpLcompensateDetailReason);
				}
			}else if("2".equals(prpLcompensateZeroLossType)){
				prpLcompensateDto.setZeroLossCaseType("0");
				if(null != prpLcompensateDetailReason){
					prpLcompensateDto.setZeroLossDetailReason(prpLcompensateDetailReason);
				}
			}
		}
		//============���ݱ�����������������ֶ� END=============
		
		//add by wunier 20080103
		//reason:ũ�ո������������
        String prpLcompensateLossesNumber = httpServletRequest.getParameter("prpLcompensateLossesNumber");
        if(prpLcompensateLossesNumber!=null&&!"".equals(prpLcompensateLossesNumber)){
        prpLcompensateDto.setLossesNumber(Double.parseDouble(prpLcompensateLossesNumber));
        }
        prpLcompensateDto.setLossesUnitCode(httpServletRequest.getParameter("lossesUnitCode"));
        String prpLcompensateDamageInsured = httpServletRequest.getParameter("prpLcompensateDamageInsured");
        if(prpLcompensateDamageInsured!=null&&!"".equals(prpLcompensateDamageInsured)){
        prpLcompensateDto.setDamageInsured(Double.parseDouble(prpLcompensateDamageInsured));
        }
        String prpLcompensateDisasterArea = httpServletRequest.getParameter("prpLcompensateDisasterArea");
        if(prpLcompensateDisasterArea!=null&&!"".equals(prpLcompensateDisasterArea)){
        prpLcompensateDto.setDisasterArea(Double.parseDouble(prpLcompensateDisasterArea));
        }
        prpLcompensateDto.setDisasterUnit(httpServletRequest.getParameter("disasterUnit"));
        String prpLcompensateAffectedArea = httpServletRequest.getParameter("prpLcompensateAffectedArea");
        if(prpLcompensateAffectedArea!=null&&!"".equals(prpLcompensateAffectedArea)){
        prpLcompensateDto.setAffectedArea(Double.parseDouble(prpLcompensateAffectedArea));
        }
        prpLcompensateDto.setAffectedUnit(httpServletRequest.getParameter("affectedUnit"));
        String prpLcompensateNoProductionArea = httpServletRequest.getParameter("prpLcompensateNoProductionArea");
        if(prpLcompensateNoProductionArea!=null&&!"".equals(prpLcompensateNoProductionArea)){
        prpLcompensateDto.setNoProductionArea(Double.parseDouble(prpLcompensateNoProductionArea));
        }
        prpLcompensateDto.setNoProductionUnit(httpServletRequest.getParameter("noProductionUnit"));
        String prpLcompensateDeathQuantity = httpServletRequest.getParameter("prpLcompensateDeathQuantity");
        if(prpLcompensateDeathQuantity!=null&&!"".equals(prpLcompensateDeathQuantity)){
        prpLcompensateDto.setDeathQuantity(Double.parseDouble(prpLcompensateDeathQuantity));
        prpLcompensateDto.setDeathUnit(httpServletRequest.getParameter("deathUnit"));
        }
        String prpLcompensateKillQuantity = httpServletRequest.getParameter("prpLcompensateKillQuantity");
        //yx
        String prpLcompensateClaimNotification = httpServletRequest.getParameter("prpLcompensateClaimNotification");
        String prpLcompensateInncentTreatment = httpServletRequest.getParameter("prpLcompensateInncentTreatment");
        prpLcompensateDto.setClaimNotification(prpLcompensateClaimNotification);
        prpLcompensateDto.setInncentTreatment(prpLcompensateInncentTreatment);
        
        if(prpLcompensateKillQuantity!=null&&!"".equals(prpLcompensateKillQuantity)){
        prpLcompensateDto.setKillQuantity(Double.parseDouble(prpLcompensateKillQuantity));
        prpLcompensateDto.setKillUnit(httpServletRequest.getParameter("killUnit"));
        }
		//end by wunier 20080103
        
        /** add by wuzheng ����ҽ�����ͣ�������ͳ��ר�� 20080601 begin */
        prpLcompensateDto.setMedicalType(httpServletRequest.getParameter("medicalType"));
        /** add by wuzheng ����ҽ�����ͣ�������ͳ��ר�� 20080601 end */
        
        //�����з�������־����Ҫ���ڽ�ǿ��
        prpLcompensateDto.setWoundGrade(httpServletRequest.getParameter("prpLpersonWoundGrade"));
        
        //���������嵥�����ţ��������������� ��ֲ��
        String claimRelationNo = httpServletRequest.getParameter("settleListCode");
        if(null!=claimRelationNo&&!"".equals(claimRelationNo)){
        	prpLcompensateDto.setClaimRelationNo(httpServletRequest.getParameter("settleListCode"));
        }
        
		// �ӵ�ArrayList��
		compensateDto.setPrpLcompensateDto(prpLcompensateDto);

		/*---------------------�ı���PrpLctextDto------------------------------------*/
		ArrayList prpLctextDtoList = new ArrayList();
		String TextTemp = httpServletRequest
				.getParameter("prpLctextContextInnerHTML");
		String[] rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo((String) httpServletRequest.getAttribute("compensateNo"));
			prpLctextDto.setContext(rules[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType("7");//�������
			prpLctextDtoList.add(prpLctextDto);
		}
		//add by miaowenjun 20070129 ������������� start
		TextTemp = httpServletRequest
				.getParameter("prpLctextContextInnerHTML1");
		rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo((String) httpServletRequest.getAttribute("compensateNo"));
			prpLctextDto.setContext(rules[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType("1");//���������
			prpLctextDtoList.add(prpLctextDto);
		}
		//add by miaowenjun 20070129 ������������� end
		TextTemp = httpServletRequest.getParameter("prpLctextContextPayTextInnerHTML");
		rules = StringUtils.split(TextTemp, RULE_LENGTH);
		// �õ����Ӵ�,���潫���зֵ�����
		for (int k = 0; k < rules.length; k++) {
			PrpLctextDto prpLctextDto = new PrpLctextDto();
			prpLctextDto.setCompensateNo((String) httpServletRequest.getAttribute("compensateNo"));
			prpLctextDto.setContext(rules[k]);
			prpLctextDto.setLineNo(k + 1);
			prpLctextDto.setTextType(PAY_TEXT);
			prpLctextDtoList.add(prpLctextDto);
		}
		// compensateDto
		compensateDto.setPrpLctextDtoDtoList(prpLctextDtoList);

        //�¹�����Ϣģ��
        ArrayList prpLacciBenPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciBenPersonProposerDto = null;
        String[] prpLacciPersonAcciCode = httpServletRequest.getParameterValues("prpLacciPersonAcciCode");
        String[] prpLacciBenPersonSerialNo = httpServletRequest.getParameterValues("prpLacciBenPersonSerialNo");
        String[] prpLacciPersonAcciName = httpServletRequest.getParameterValues("prpLacciPersonAcciName");
        String[] prpLacciPersonFamilyNo = httpServletRequest.getParameterValues("prpLacciPersonFamilyNo");
        String[] prpLacciPersonAge = httpServletRequest.getParameterValues("prpLacciPersonAge");
        String[] prpLacciPersonSex = httpServletRequest.getParameterValues("prpLacciPersonSex");
        String[] prpLacciPersonIdentifyNumber = httpServletRequest.getParameterValues("prpLacciPersonIdentifyNumber");
        String[] prpLacciPersonAddress = httpServletRequest.getParameterValues("prpLacciPersonAddress");
        //����ֵ
        if (prpLacciPersonFamilyNo ==null) {
        } else { 
        	
            for (int index = 1; index < prpLacciPersonFamilyNo.length; index++) {
            	prpLacciBenPersonProposerDto = new PrpLacciPersonDto();
            	prpLacciBenPersonProposerDto.setCertiNo((String) httpServletRequest.getParameter("registno"));
            	prpLacciBenPersonProposerDto.setCertiType("01"); //�¹�����Ϣ
            	prpLacciBenPersonProposerDto.setPolicyNo(httpServletRequest.getParameter("policyno"));
            	//prpLacciBenPersonProposerDto.setSerialNo(uiPolicyAction.findBySeriaNo("1=1") + 1);
                  //�ֻ���Ŵӽ�����ȡ
            	prpLacciBenPersonProposerDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(prpLacciBenPersonSerialNo[index])));
            	prpLacciBenPersonProposerDto.setFamilyNo(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonFamilyNo[index])));
            	prpLacciBenPersonProposerDto.setAcciCode(prpLacciPersonAcciCode[index]);
            	prpLacciBenPersonProposerDto.setAcciName(prpLacciPersonAcciName[index]);
            	prpLacciBenPersonProposerDto.setAge(Integer.parseInt(DataUtils.nullToZero(prpLacciPersonAge[index])));
            	prpLacciBenPersonProposerDto.setSex(prpLacciPersonSex[index]);
            	prpLacciBenPersonProposerDto.setIdentifyNumber(prpLacciPersonIdentifyNumber[index]);
            	prpLacciBenPersonProposerDto.setAddress(prpLacciPersonAddress[index]);//�ݴ�ţ����Ϣ
                //���뼯��
            	prpLacciBenPersonList.add(prpLacciBenPersonProposerDto);
            }
        }
        compensateDto.setPrpLacciBenPersonList(prpLacciBenPersonList); 
        
        
        String riskcodetemp = (String) httpServletRequest.getParameter("prpLcompensateRiskCode");
        if("0310".equals(riskcodetemp)||"0312".equals(riskcodetemp))
        {
			ArrayList prplCompensateHouseDtoList = new ArrayList();
			PrplcompensatehouseDto prplCompensateHouseDto = null;
			//String   prplCheckPolicyNoShow  = httpServletRequest.getParameter("prplCheckPolicyNoShow");
			//String   prplCheckRegistNoShow  = httpServletRequest.getParameter("prplCheckRegistNoShow");
			String[] prplCompensateHouseCaseNo=httpServletRequest.getParameterValues("prplCompensateHouseCaseNo");
			String[] prplCompensateHouseClaimNo=httpServletRequest.getParameterValues("prplCompensateHouseClaimNo");
			String[] prplCompensateHouseNodeNo=httpServletRequest.getParameterValues("prplCompensateHouseNodeNo");
			String[] prplCompensateHouseNodeType=httpServletRequest.getParameterValues("prplCompensateHouseNodeType");
			String[] prplCompensateHousePolicyNo=httpServletRequest.getParameterValues("prplCompensateHousePolicyNo");
			String[] prplCompensateHouseRegistNo=httpServletRequest.getParameterValues("prplCompensateHouseRegistNo");
			String[] prplCompensateHouseDamageCode=httpServletRequest.getParameterValues("prplCompensateHouseDamageCode");
			String[] prplCompensateHouseDamageStartDate=httpServletRequest.getParameterValues("prplCompensateHouseDamageStartDate");
			String[] prplCompensateHouseCompensateNo=httpServletRequest.getParameterValues("prplCompensateHouseCompensateNo");
			String[] prplCompensateHouseDamageName=httpServletRequest.getParameterValues("prplCompensateHouseDamageName");
			String[] prplCompensateHouseKindCode=httpServletRequest.getParameterValues("prplCompensateHouseKindCode");
			
			
			String[] prplCompensateHouseName=httpServletRequest.getParameterValues("prplCompensateHouseName");
			String[] prplCompensateHouseIDcard=httpServletRequest.getParameterValues("prplCompensateHouseIDcard");
			String[] prplCompensateHousehukoubu=httpServletRequest.getParameterValues("prplCompensateHousehukoubu");
			String[] prplCompensateHouseAddress=httpServletRequest.getParameterValues("prplCompensateHouseAddress");
			String[] prplCompensateHousePhone=httpServletRequest.getParameterValues("prplCompensateHousePhone");
			String[] prplCompensateHouseRemark=httpServletRequest.getParameterValues("prplCompensateHouseRemark");
			
			String[] prplCompensateHouseEstimateLoss=httpServletRequest.getParameterValues("prplCompensateHouseEstimateLoss");
			
  			String prplCompensateHouseBuildingnumber=httpServletRequest.getParameter("prplCompensateHouseBuildingnumber");
			String prplCompensateHouseZhuannumber=httpServletRequest.getParameter("prplCompensateHouseZhuannumber");
			String prplCompensateHouseWanumber=httpServletRequest.getParameter("prplCompensateHouseWanumber");
			String prplCompensateHouseKitchennumber=httpServletRequest.getParameter("prplCompensateHouseKitchennumber");
			String prplCompensateHouseOthernumber=httpServletRequest.getParameter("prplCompensateHouseOthernumber");
			String prplCompensateHouseFloor=httpServletRequest.getParameter("prplCompensateHouseFloor");
			
			if (prplCompensateHouseIDcard == null){
		     }else{
		    	 for(int index = 1;index < prplCompensateHouseIDcard.length;index++)
		    	 {
		    		 prplCompensateHouseDto = new PrplcompensatehouseDto();
		    		 prplCompensateHouseDto.setAddress(prplCompensateHouseAddress[index]);
		    		 prplCompensateHouseDto.setBusinessno((String) httpServletRequest.getAttribute("compensateNo"));
		    		 prplCompensateHouseDto.setCaseno(prplCompensateHouseCaseNo[index]);
		    		 prplCompensateHouseDto.setClaimno((String) httpServletRequest.getParameter("prpLcompensateClaimNo"));
		    		 prplCompensateHouseDto.setCompensateno((String) httpServletRequest.getAttribute("compensateNo"));
		    		 prplCompensateHouseDto.setDamagecode(prplCompensateHouseDamageCode[index]);
		    		 prplCompensateHouseDto.setDamagename(prplCompensateHouseDamageName[index]);
		    		 prplCompensateHouseDto.setDamagestartdate(new DateTime(httpServletRequest.getParameter("prpLcompensateDamageStartDate"),DateTime.YEAR_TO_DAY));
		    		 prplCompensateHouseDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateHouseEstimateLoss[index])));
		    		 prplCompensateHouseDto.setHukoubu(prplCompensateHousehukoubu[index]);
		    		 prplCompensateHouseDto.setIdcard(prplCompensateHouseIDcard[index]);
		    		 prplCompensateHouseDto.setKindcode("001");
		    		 prplCompensateHouseDto.setName(prplCompensateHouseName[index]);
		    		 prplCompensateHouseDto.setPhone(prplCompensateHousePhone[index]);
		    	     prplCompensateHouseDto.setNodeno(8);
		    	     prplCompensateHouseDto.setRegistno((String) httpServletRequest.getParameter("registno"));
		    	     prplCompensateHouseDto.setPolicyno(httpServletRequest.getParameter("prpLcompensatePolicyNo"));
		    	     prplCompensateHouseDto.setRemark(prplCompensateHouseRemark[index]);
		    		 prplCompensateHouseDto.setNodetype("compe");
					 prplCompensateHouseDto.setFloor(prplCompensateHouseFloor);
		    		 prplCompensateHouseDto.setBuildingnumber(prplCompensateHouseBuildingnumber);
		    		 prplCompensateHouseDto.setZhuannumber(prplCompensateHouseZhuannumber);
		    		 prplCompensateHouseDto.setWanumber(prplCompensateHouseWanumber);
		    		 prplCompensateHouseDto.setKitchennumber(prplCompensateHouseKitchennumber);
		    		 prplCompensateHouseDto.setOthernumber(prplCompensateHouseOthernumber);
					 
					 prplCompensateHouseDtoList.add(prplCompensateHouseDto);
		    	 }
		    	 compensateDto.setPrplCompensateHouseDtoList(prplCompensateHouseDtoList); 	 
		     }
        }
        
        
        /*---------------------�������Ϣ��prpLcompensateear------------------------------------*/
        ArrayList prplCompensateEarDtoList = new ArrayList();
		PrplcompensateearDto prplCompensateEarDto = null;
  
		//�ӽ���õ���������
		String   prpLcompensateClaimNo  = httpServletRequest.getParameter("prpLcompensateClaimNo");
		String   prpLcompensatePolicyNo  = httpServletRequest.getParameter("prpLcompensatePolicyNo");
		String   prpLcompensateDamageStartDate  = httpServletRequest.getParameter("prpLcompensateDamageStartDate");
		String   reportDate  = httpServletRequest.getParameter("reportDate");
		String   damageCode  = httpServletRequest.getParameter("damageCode");
		String   damageName  = httpServletRequest.getParameter("damageName");
		String[] prpLlossDtoKindCode = httpServletRequest.getParameterValues("prpLlossDtoKindCode");
		
		
		String[] prplCompensateEarAccount=httpServletRequest.getParameterValues("prplCompensateEarAccount");
		String[] prplCompensateEarBank=httpServletRequest.getParameterValues("prplCompensateEarBank");
		String[] prplCompensateEarBreedingAreaCode=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaCode");
		String[] prplCompensateEarBreedingAreaName=httpServletRequest.getParameterValues("prplCompensateEarBreedingAreaName");
		String[] prplCompensateEarCaseNo=httpServletRequest.getParameterValues("prplCompensateEarCaseNo");
		String[] prplCompensateEarClaimNo=httpServletRequest.getParameterValues("prplCompensateEarClaimNo");
		String[] prplCompensateEarClaimRate=httpServletRequest.getParameterValues("prplCompensateEarClaimRate");
		String[] prplCompensateEarCombineNo=httpServletRequest.getParameterValues("prplCompensateEarCombineNo");
		String[] prplCompensateEarCompensateNo=httpServletRequest.getParameterValues("prplCompensateEarCompensateNo");
		String[] prplCompensateEarCullNumber=httpServletRequest.getParameterValues("prplCompensateEarCullNumber");
		String[] prplCompensateEarDamageCode=httpServletRequest.getParameterValues("prplCompensateEarDamageCode");
		String[] prplCompensateEarDamageEndDate=httpServletRequest.getParameterValues("prplCompensateEarDamageEndDate");
		String[] prplCompensateEarDamageName=httpServletRequest.getParameterValues("prplCompensateEarDamageName");
		String[] prplCompensateEarDamageStartDate=httpServletRequest.getParameterValues("prplCompensateEarDamageStartDate");
		String[] prplCompensateEarDamageStartHour=httpServletRequest.getParameterValues("prplCompensateEarDamageStartHour");
		String[] prplCompensateEarDeadNumber=httpServletRequest.getParameterValues("prplCompensateEarDeadNumber");
		String[] prplCompensateEarDeadReason=httpServletRequest.getParameterValues("prplCompensateEarDeadReason");
		String[] prplCompensateEarDeductible=httpServletRequest.getParameterValues("prplCompensateEarDeductible");
		String[] prplCompensateEarDeductibleRate=httpServletRequest.getParameterValues("prplCompensateEarDeductibleRate");
		String[] prplCompensateEarEarNo=httpServletRequest.getParameterValues("prplCompensateEarEarNo");
		String[] prplCompensateEarEstimateLoss=httpServletRequest.getParameterValues("prplCompensateEarEstimateLoss");
		String[] prplCompensateEarFCode=httpServletRequest.getParameterValues("prplCompensateEarFCode");
		String[] prplCompensateEarId_Card=httpServletRequest.getParameterValues("prplCompensateEarId_Card");
		String[] prplCompensateEarInusreListCode=httpServletRequest.getParameterValues("prplCompensateEarInusreListCode");
		String[] prplCompensateEarKindCode=httpServletRequest.getParameterValues("prplCompensateEarKindCode");
		String[] prplCompensateEarName=httpServletRequest.getParameterValues("prplCompensateEarName");
		String[] prplCompensateEarNodeNo=httpServletRequest.getParameterValues("prplCompensateEarNodeNo");
		String[] prplCompensateEarNodeType=httpServletRequest.getParameterValues("prplCompensateEarNodeType");
		String[] prplCompensateEarPolicyNo=httpServletRequest.getParameterValues("prplCompensateEarPolicyNo");
		String[] prplCompensateEarRegistNo=httpServletRequest.getParameterValues("prplCompensateEarRegistNo");
		String[] prplCompensateEarReportTime=httpServletRequest.getParameterValues("prplCompensateEarReportTime");
		String[] prplCompensateEarRestFee=httpServletRequest.getParameterValues("prplCompensateEarRestFee");
		String[] prplCompensateEarSumRealpay=httpServletRequest.getParameterValues("prplCompensateEarSumRealpay");
		String[] prplCompensateEarUnitAmount=httpServletRequest.getParameterValues("prplCompensateEarUnitAmount");


		//end��ֳ�ն����嵥�б��ֶζ���
		if (prplCompensateEarEarNo == null){
		}else{
			for(int index = 1;index < prplCompensateEarEarNo.length;index++)
			{
				prplCompensateEarDto = new PrplcompensateearDto();
						
				prplCompensateEarDto.setAccount(prplCompensateEarAccount[index]);
				prplCompensateEarDto.setBank(prplCompensateEarBank[index]);
				prplCompensateEarDto.setBreedingareacode(prplCompensateEarBreedingAreaCode[index]);
				prplCompensateEarDto.setBreedingareaname(prplCompensateEarBreedingAreaName[index]);
				prplCompensateEarDto.setCaseno(prplCompensateEarCaseNo[index]);
				prplCompensateEarDto.setClaimno(prpLcompensateClaimNo);
				prplCompensateEarDto.setClaimrate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarClaimRate[index])));
				prplCompensateEarDto.setCombineno(httpServletRequest.getParameter("CombineNo"));
				prplCompensateEarDto.setCompensateno((String) httpServletRequest.getAttribute("compensateNo"));
				prplCompensateEarDto.setCullnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarCullNumber[index])));
				prplCompensateEarDto.setDamagecode(damageCode);
				prplCompensateEarDto.setDamageenddate(new DateTime(prplCompensateEarDamageEndDate[index],DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagename(damageName);
				prplCompensateEarDto.setDamagestartdate(new DateTime(prpLcompensateDamageStartDate,DateTime.YEAR_TO_DAY));
				prplCompensateEarDto.setDamagestarthour(prplCompensateEarDamageStartHour[index]);
				prplCompensateEarDto.setDeadnumber(Integer.valueOf(DataUtils.nullToZero(prplCompensateEarDeadNumber[index])));
				prplCompensateEarDto.setDeadreason(prplCompensateEarDeadReason[index]);
				prplCompensateEarDto.setDeductible(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductible[index])));
				prplCompensateEarDto.setDeductiblerate(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarDeductibleRate[index])));
				prplCompensateEarDto.setEarno(prplCompensateEarEarNo[index]);
				prplCompensateEarDto.setEstimateloss(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
				prplCompensateEarDto.setFcode(prplCompensateEarFCode[index]);
				prplCompensateEarDto.setId_card(prplCompensateEarId_Card[index]);
				prplCompensateEarDto.setInusrelistcode(prplCompensateEarInusreListCode[index]);
				prplCompensateEarDto.setKindcode(prpLlossDtoKindCode[1]);
				prplCompensateEarDto.setName(prplCompensateEarName[index]);
				prplCompensateEarDto.setNodeno(7);
				prplCompensateEarDto.setNodetype("compe");
				prplCompensateEarDto.setPolicyno(prpLcompensatePolicyNo);
				prplCompensateEarDto.setRegistno((String) httpServletRequest.getParameter("registno"));
				prplCompensateEarDto.setBusinessno((String) httpServletRequest.getAttribute("compensateNo"));
				prplCompensateEarDto.setReporttime(reportDate);
				prplCompensateEarDto.setRestfee(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarRestFee[index])));
				prplCompensateEarDto.setSumrealpay(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarEstimateLoss[index])));
				prplCompensateEarDto.setUnitamount(Double.parseDouble(DataUtils.nullToZero(prplCompensateEarUnitAmount[index])));

				
    			prplCompensateEarDtoList.add(prplCompensateEarDto);
			}
		}
		compensateDto.setPrpLcompensateeartDtoList(prplCompensateEarDtoList);
        
        /*-------------------������������Ϣ-------start------------------------------------*/
        ArrayList prpLacciPersonList = new ArrayList();
        PrpLacciPersonDto   prpLacciPersonProposerDto = null;
        //�ӽ���õ���������
        
        String   proposerClaimNo = (String) httpServletRequest.getParameter("claimNo");
        String   proposerPolicyNo = httpServletRequest.getParameter("proposerPolicyNo");
        String[] proposerName = httpServletRequest.getParameterValues("proposerName");
        String[] proposerSerialNo = httpServletRequest.getParameterValues("prpLacciPersonSerialNo");
        String[] proposerIdentifyNumber = httpServletRequest.getParameterValues("proposerIdentifyNumber");
        String[] proposerRelation = httpServletRequest.getParameterValues("relationCode");
        String[] proposerPhone = httpServletRequest.getParameterValues("proposerPhone");
        String[] proposerAddress = httpServletRequest.getParameterValues("proposerAddress");
        String   proposerFamilyNo= httpServletRequest.getParameter("personFamilyNo");
        //-----------------------------------
       
        //����ֵ
        if (proposerSerialNo ==null) {
        } else { 
        	 
            for (int index = 1; index < proposerSerialNo.length; index++) {
            	prpLacciPersonProposerDto =new  PrpLacciPersonDto();
                prpLacciPersonProposerDto.setAcciName(proposerName[index]);
                prpLacciPersonProposerDto.setCertiNo(proposerClaimNo);
                prpLacciPersonProposerDto.setCertiType("03");
                prpLacciPersonProposerDto.setPolicyNo(proposerPolicyNo);
                prpLacciPersonProposerDto.setFlag("1");   //��־��������
                prpLacciPersonProposerDto.setIdentifyNumber(proposerIdentifyNumber[index]);
                prpLacciPersonProposerDto.setSerialNo(Integer.parseInt(DataUtils.nullToZero(proposerSerialNo[index])));
                prpLacciPersonProposerDto.setAddress(proposerAddress[index]);
                prpLacciPersonProposerDto.setFamilyNo(0);  //��ͥ���
                prpLacciPersonProposerDto.setPhone(proposerPhone[index]);
                prpLacciPersonProposerDto.setRelationCode(proposerRelation[index]);
                String relationName="";
                
                if(proposerRelation[index].equals("1")){
                	relationName ="�������˱���";	
                }
                else if(proposerRelation[index].equals("2")){
                	relationName ="ָ��������";	
                }
                else if(proposerRelation[index].equals("3")){
                	relationName ="��������֮�̳���";	
                }
                else if(proposerRelation[index].equals("4")){
                	relationName ="��������֮�໤��";	
                }
                prpLacciPersonProposerDto.setRelationName(relationName);
                prpLacciPersonProposerDto.setFamilyNo(1);
                
                //���뼯��
                prpLacciPersonList.add(prpLacciPersonProposerDto);
            }
            //�⽡�����������м�������������
            compensateDto.setPrpLacciPersonDtoList(prpLacciPersonList);
        }
        /*-------------------������������Ϣ-------end------------------------------------*/
        
        
        /*-------------------�����������Ϣ-------------------------------------------*/
        String injuryPersonName = (String) httpServletRequest.getParameter("injuryPersonName");
        String injuryPersonGender =  (String) httpServletRequest.getParameter("injuryPersonGender");
        String injuryPersonIdNum =  (String) httpServletRequest.getParameter("injuryPersonIdNum");
        if(injuryPersonName!=null&&!"".equals(injuryPersonName)){
	         PrpLinjuryPersonDto prpLinjuryPersonDto = new PrpLinjuryPersonDto();
	         prpLinjuryPersonDto.setCompensateNo((String) httpServletRequest.getAttribute("compensateNo"));
	    	 prpLinjuryPersonDto.setAcciName(injuryPersonName);
	         prpLinjuryPersonDto.setSex(injuryPersonGender);
	         prpLinjuryPersonDto.setIdentifyNumber(injuryPersonIdNum);
	         ArrayList prpLinjuryPersonList = new ArrayList();
	         prpLinjuryPersonList.add(prpLinjuryPersonDto);
	         compensateDto.setPrpLinjuryPersonList(prpLinjuryPersonList);
        }
        
		/*---------------------״̬����prpLclaimStatus------------------------------------*/
		PrpLclaimStatusDto prpLclaimStatusDto = new PrpLclaimStatusDto();
		if (caseType != null && !caseType.equals("null")) {
			if (caseType.trim().equals("3") || caseType.trim().equals("4")
					|| caseType.trim().equals("6")) {
				prpLclaimStatusDto.setTypeFlag(caseType);
				prpLclaimStatusDto.setNodeType("speci");
				prpLclaimStatusDto.setSerialNo(Integer.parseInt(DataUtils
						.nullToZero(caseType)));
			} else {
				prpLclaimStatusDto.setNodeType("compe");
				prpLclaimStatusDto.setSerialNo(0);
				prpLclaimStatusDto.setTypeFlag("2");
			}
		} else {
			prpLclaimStatusDto.setNodeType("compe");
			prpLclaimStatusDto.setSerialNo(0);
			prpLclaimStatusDto.setTypeFlag("2");
		}

		prpLclaimStatusDto.setStatus(httpServletRequest.getParameter("buttonSaveType"));
		prpLclaimStatusDto.setBusinessNo(prpLcompensateDto.getCompensateNo());
		prpLclaimStatusDto.setPolicyNo(prpLcompensateDto.getPolicyNo());
		prpLclaimStatusDto.setRiskCode(httpServletRequest.getParameter("prpLcompensateRiskCode"));
	
		// ȡ�õ�ǰ�û���Ϣ��д����Ա��Ϣ��ʵ����
		HttpSession session = httpServletRequest.getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		prpLclaimStatusDto.setHandlerCode(user.getUserCode());
		prpLclaimStatusDto.setInputDate(prpLcompensateDto.getInputDate());
		prpLclaimStatusDto.setOperateDate(new DateTime(DateTime.current()
				.toString(), DateTime.YEAR_TO_DAY));
		compensateDto.setPrpLclaimStatusDto(prpLclaimStatusDto);
		PrpLclaimDto prpLclaimDto = null;
		Object buttonStatus = httpServletRequest.getParameter("buttonSaveType");
		if (buttonStatus != null && buttonStatus.toString().trim().equals("4")) {
			prpLclaimDto = new PrpLclaimDto();
			prpLclaimDto.setClaimNo(httpServletRequest.getParameter("prpLprepayClaimNo"));
			prpLclaimDto.setSumPaid(Double.parseDouble(DataUtils
					.nullToZero(httpServletRequest.getParameter("prpLprepaySumPrePaid"))));
		}
		compensateDto.setPrpLclaimDto(prpLclaimDto);
		return compensateDto;
	}

}
