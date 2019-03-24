package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.custom.PolicyDto;
import com.sinosoft.claim.dto.domain.PrpCmainDto;
import com.sinosoft.claim.dto.domain.PrpDcompanyDto;
import com.sinosoft.claim.dto.domain.PrpDuserDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDcompany;
import com.sinosoft.claim.resource.dtofactory.domain.DBPrpDuser;
import com.sinosoft.claim.webservice.AccidentPersonInfoDto;
import com.sinosoft.claim.webservice.CertifyInfoDto;
import com.sinosoft.claim.webservice.ClaimAppDto;
import com.sinosoft.claim.webservice.ClaimKindDto;
import com.sinosoft.claim.webservice.ClaimRequestInfo;
import com.sinosoft.claim.webservice.CompeFeeInfoDto;
import com.sinosoft.claim.webservice.CompeInvDetailInfo;
import com.sinosoft.claim.webservice.CompeInvMainInfo;
import com.sinosoft.claim.webservice.CompePayFeeInfoDto;
import com.sinosoft.claim.webservice.InjuryPersonInfoDto;
import com.sinosoft.claim.webservice.PrepayFeeInfoDto;
import com.sinosoft.claim.webservice.SchedExtInfoDto;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * �ӿڴ�������ĺϷ���У����
 * 
 */
public class UIMedicalCheckBeforeAutoClaimViewHelper {
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkBeforeClaim(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullFiels(claimRequestInfo);
		if("".equals(returnStr)){
			returnStr = this.checkLegalityOfFees(claimRequestInfo);
			if("".equals(returnStr)){
				returnStr = this.checkFlagFieldsRange(claimRequestInfo);
				if("".equals(returnStr)){
					returnStr = this.checkOperatorCodeAndMakeCom(claimRequestInfo);
					if("".equals(returnStr)){
						returnStr = this.checkExistenceOfOutId(claimRequestInfo);
						if("".equals(returnStr)){
							returnStr = this.checkPolicyNoAndDamageStartDate(claimRequestInfo);
							if("".equals(returnStr)){
								returnStr = this.checkClaimInputdate(claimRequestInfo);
							}
						}
					}
				}
			}
		}
		return returnStr;
	}
	
	
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkBeforeRegist(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkRegistNotNullFiels(claimRequestInfo);
		if("".equals(returnStr)){
			returnStr = this.checkRegistFlagFieldsRange(claimRequestInfo);
			if("".equals(returnStr)){
				returnStr = this.checkRegistOperatorCodeAndMakeCom(claimRequestInfo);
				if("".equals(returnStr)){
					returnStr = this.checkExistenceOfRegist(claimRequestInfo);
					if("".equals(returnStr)){
						returnStr = this.checkPolicyNoAndDamageStartDate(claimRequestInfo);
						if("".equals(returnStr)){
							returnStr = this.checkRegistInputdate(claimRequestInfo);
						}
					}
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkBeforeCompe(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkCompeNotNullFiels(claimRequestInfo);
		if("".equals(returnStr)){
			returnStr = this.checkCompeLegalityOfFees(claimRequestInfo);
			if("".equals(returnStr)){
				returnStr = this.checkCompeFlagFieldsRange(claimRequestInfo);
				if("".equals(returnStr)){
					returnStr = this.checkCompeOperatorCodeAndMakeCom(claimRequestInfo);
					if("".equals(returnStr)){
						returnStr = this.checkExistenceOfCompe(claimRequestInfo);
						if("".equals(returnStr)){
							returnStr = this.checkPolicyNoAndDamageStartDate(claimRequestInfo);
							if("".equals(returnStr)){
								returnStr = this.checkCompeInputdate(claimRequestInfo);
							}
						}
					}
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkNotNullFiels(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == claimRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(claimRequestInfo.getPolicyno() == null || "".equals(claimRequestInfo.getPolicyno())){
			returnStr = "0^�����Ų���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOutId() == null || "".equals(claimRequestInfo.getOutId())){
			returnStr = "0^�ͻ���������������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOutRigstNo() == null || "".equals(claimRequestInfo.getOutRigstNo())){
			returnStr = "0^�ͻ��˱�����ˮ�Ų���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartDate() == null || "".equals(claimRequestInfo.getDamageStartDate())){
			returnStr = "0^�¹����ڲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartHour() == null || "".equals(claimRequestInfo.getDamageStartHour())){
			returnStr = "0^�¹�ʱ���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageCode() == null || "".equals(claimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportDate() == null || "".equals(claimRequestInfo.getReportDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportHour() == null || "".equals(claimRequestInfo.getReportHour())){
			returnStr = "0^����ʱ���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportType() == null || "".equals(claimRequestInfo.getReportType())){
			returnStr = "0^������ʽ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getLinkerName() == null || "".equals(claimRequestInfo.getLinkerName())){
			returnStr = "0^��ϵ�˲���Ϊ��";
			return returnStr;
		}
//		if(claimRequestInfo.getPhoneNumber() == null || "".equals(claimRequestInfo.getPhoneNumber())){
//			returnStr = "0^��ϵ�绰����Ϊ��";
//			return returnStr;
//		}
		if(claimRequestInfo.getClauseType() == null || "".equals(claimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageAddress() == null || "".equals(claimRequestInfo.getDamageAddress())){
			returnStr = "0^�¹ʵص㲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeCode() == null || "".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorCode() == null || "".equals(claimRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorName() == null || "".equals(claimRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getMakeCom() == null || "".equals(claimRequestInfo.getMakeCom())){
			returnStr = "0^���⴦���������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getMakeComName() == null || "".equals(claimRequestInfo.getMakeComName())){
			returnStr = "0^���⴦��������Ʋ���Ϊ��";
			return returnStr;
		}
//		if(claimRequestInfo.getAccidentPersonInfoDto() == null || claimRequestInfo.getAccidentPersonInfoDto().length == 0){
//			returnStr = "0^�¹�����Ϣ����Ϊ��";
//			return returnStr;
//		} else {
//			AccidentPersonInfoDto[] accidentPersonDtos = claimRequestInfo.getAccidentPersonInfoDto();
//			AccidentPersonInfoDto accidentPerson = null;
//			for(int i=0;i<accidentPersonDtos.length;i++){
//				if(accidentPersonDtos[i] != null){
//					accidentPerson = accidentPersonDtos[i];
//					if(accidentPerson.getAcciCode()==null || "".equals(accidentPerson.getAcciCode())){
//						returnStr = "0^�¹�����Ϣ�е��¹��ߴ��벻��Ϊ��";
//						return returnStr;
//					}
//					if(accidentPerson.getAcciName()==null || "".equals(accidentPerson.getAcciName())){
//						returnStr = "0^�¹�����Ϣ�е��¹������Ʋ���Ϊ��";
//						return returnStr;
//					}
//					if(accidentPerson.getSex()==null || "".equals(accidentPerson.getSex())){
//						returnStr = "0^�¹�����Ϣ�е��Ա���Ϊ��";
//						return returnStr;
//					}else{
//						String sex = "1,2,9";
//						if(!sex.contains(accidentPerson.getSex())){
//							returnStr = "0^�¹�����Ϣ�е��Ա𲻺Ϸ�";
//							return returnStr;
//						}
//					}
//					if(accidentPerson.getIdentifyNumber()==null || "".equals(accidentPerson.getIdentifyNumber())){
//						returnStr = "0^�¹�����Ϣ�е����֤���벻��Ϊ��";
//						return returnStr;
//					}
//				}else{
//					returnStr = "0^�¹�����Ϣ����Ϊ��";
//					return returnStr;
//				}
//			}
//		}
		if(claimRequestInfo.getScheduleObjectId() == null || "".equals(claimRequestInfo.getScheduleObjectId())){
			returnStr = "0^���Ȳ鿱�����������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckSite() == null || "".equals(claimRequestInfo.getCheckSite())){
			returnStr = "0^�鿱��ַ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckType() == null || "".equals(claimRequestInfo.getCheckType())){
			returnStr = "0^�鿱���Ͳ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckDate() == null || "".equals(claimRequestInfo.getCheckDate())){
			returnStr = "0^�鿱���ڲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckNature() == null || "".equals(claimRequestInfo.getCheckNature())){
			returnStr = "0^�鿱���ʲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getUnitType() == null || "".equals(claimRequestInfo.getUnitType())){
			returnStr = "0^�鿱����λ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckContext() == null || "".equals(claimRequestInfo.getCheckContext())){
			returnStr = "0^�鿱���治��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCurrency() == null || "".equals(claimRequestInfo.getCurrency())){
			returnStr = "0^�ұ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeName() == null || "".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^�¹��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReplevyFlag() == null || "".equals(claimRequestInfo.getReplevyFlag())){
			returnStr = "0^�Ƿ������׷������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getThirdComFlag() == null || "".equals(claimRequestInfo.getThirdComFlag())){
			returnStr = "0^�Ƿ������������н鲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getClaimType() == null || "".equals(claimRequestInfo.getClaimType())){
			returnStr = "0^�������ʹ��벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getRegistTime() == null || "".equals(claimRequestInfo.getRegistTime())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getRegistUser() == null || "".equals(claimRequestInfo.getRegistUser())){
			returnStr = "0^������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCompeTime() == null || "".equals(claimRequestInfo.getCompeTime())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCompeUser() == null || "".equals(claimRequestInfo.getCompeUser())){
			returnStr = "0^������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getVericTime() == null || "".equals(claimRequestInfo.getVericTime())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getVericUser() == null || "".equals(claimRequestInfo.getVericUser())){
			returnStr = "0^������Ա���벻��Ϊ��";
			return returnStr;
		}
		
		if(claimRequestInfo.getClaimAppDto() == null || claimRequestInfo.getClaimAppDto().length == 0){
			returnStr = "0^������������Ϣ����Ϊ��";
			return returnStr;
		}else{
			ClaimAppDto[] claimAppDtos = claimRequestInfo.getClaimAppDto();
			ClaimAppDto claimApp = null;
			for(int i=0;i<claimAppDtos.length;i++){
				if(claimAppDtos[i] != null){
					claimApp = claimAppDtos[i];
					if(claimApp.getAcciName()==null || "".equals(claimApp.getAcciName())){
						returnStr = "0^������������Ϣ�е���������Ϊ��";
						return returnStr;
					}
					if(claimApp.getIdentifyNumber()==null || "".equals(claimApp.getIdentifyNumber())){
						returnStr = "0^������������Ϣ�е����֤���벻��Ϊ��";
						return returnStr;
					}
					if(claimApp.getRelationCode()==null || "".equals(claimApp.getRelationCode())){
						returnStr = "0^������������Ϣ�е����¹��߹�ϵ����Ϊ��";
						return returnStr;
					}else{
						String relationCode = "1,2,3";
						if(!relationCode.contains(claimApp.getRelationCode())){
							returnStr = "0^������������Ϣ�е����¹��߹�ϵ���Ϸ�";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^������������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getClaimKindDto() == null || claimRequestInfo.getClaimKindDto().length == 0){
			returnStr = "0^�����ձ��������Ϣ����Ϊ��";
			return returnStr;
		}else{
			ClaimKindDto[] claimKindDtos = claimRequestInfo.getClaimKindDto();
			ClaimKindDto claimKind = null;
			for(int i=0;i<claimKindDtos.length;i++){
				if(claimKindDtos[i] != null){
					claimKind = claimKindDtos[i];
					if(claimKind.getFamilyName()==null || "".equals(claimKind.getFamilyName())){
						returnStr = "0^������������Ϣ�е��¹������Ʋ���Ϊ��";
						return returnStr;
					}
					if(claimKind.getKindCode()==null || "".equals(claimKind.getKindCode())){
						returnStr = "0^������������Ϣ�е��ձ���벻��Ϊ��";
						return returnStr;
					}
					if(claimKind.getKindName()==null || "".equals(claimKind.getKindName())){
						returnStr = "0^������������Ϣ�е��ձ����Ʋ���Ϊ��";
						return returnStr;
					}
					if(claimKind.getCurrency()==null || "".equals(claimKind.getCurrency())){
						returnStr = "0^������������Ϣ�еıұ���벻��Ϊ��";
						return returnStr;
					}
					if(claimKind.getLossFeeType()==null || "".equals(claimKind.getLossFeeType())){
						returnStr = "0^������������Ϣ�е������Ϊ��";
						return returnStr;
					}else{
						String lossFeeType = "P,Z";
						if(!lossFeeType.contains(claimKind.getLossFeeType())){
							returnStr = "0^������������Ϣ�е���𲻺Ϸ�";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^������������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getCompeFeeInfoDto() == null || claimRequestInfo.getCompeFeeInfoDto().length == 0){
			returnStr = "0^�����������Ϣ����Ϊ��";
			return returnStr;
		}else{
			CompeFeeInfoDto[] compeFeeDtos = claimRequestInfo.getCompeFeeInfoDto();
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					if(compeFee.getKindCode()==null || "".equals(compeFee.getKindCode())){
						returnStr = "0^�����������Ϣ�е��ձ���벻��Ϊ��";
						return returnStr;
					}
					if(compeFee.getKindName()==null || "".equals(compeFee.getKindName())){
						returnStr = "0^�����������Ϣ�е��ձ����Ʋ���Ϊ��";
						return returnStr;
					}
					if(compeFee.getCurrency()==null || "".equals(compeFee.getCurrency())){
						returnStr = "0^�����������Ϣ�еıұ���벻��Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^�����������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getNotion() == null || "".equals(claimRequestInfo.getNotion())){
			returnStr = "0^��������Ƭ�ﲻ��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getHandleText() == null || "".equals(claimRequestInfo.getHandleText())){
			returnStr = "0^����ǩ�������������Ϊ��";
			return returnStr;
		}
		
		
		SchedExtInfoDto[] schedExtDtos = claimRequestInfo.getSchedExtInfoDto();
		if(schedExtDtos != null && schedExtDtos.length>0){
			SchedExtInfoDto schedExt = null;
			for(int i=0;i<schedExtDtos.length;i++){
				if(schedExtDtos[i] != null){
					schedExt = schedExtDtos[i];
					if(schedExt.getOperatorCode()==null || "".equals(schedExt.getOperatorCode())){
						returnStr = "0^����˵����Ϣ�еĲ����˲���Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^����˵����Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		CertifyInfoDto[] certifyDtos = claimRequestInfo.getCertifyInfoDto();
		if(certifyDtos != null && certifyDtos.length >0){
			CertifyInfoDto certify = null;
			for(int i=0;i<certifyDtos.length;i++){
				if(certifyDtos[i] != null){
					certify = certifyDtos[i];
					if(certify.getTypeCode()==null || "".equals(certify.getTypeCode())){
						returnStr = "0^��֤��Ϣ�еĵ�֤���Ͳ���Ϊ��";
						return returnStr;
					}else{
						String typeCode = "102,105,A001,A002,A004,A006,B003,B004,B005,B038," +
								"B039,B095,B40,C006,C008,C024,C027,C028,C052,C075,C076,Z001";
						if(!typeCode.contains(certify.getTypeCode())){
							returnStr = "0^��֤��Ϣ�еĵ�֤���Ͳ��Ϸ�";
							return returnStr;
						}
					}
					if(certify.getTypeName()==null || "".equals(certify.getTypeName())){
						returnStr = "0^��֤��Ϣ�еĵ�֤�嵥���Ʋ���Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^��֤��Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		
		PrepayFeeInfoDto[] prepayFeeDtos = claimRequestInfo.getPrepayFeeInfoDto();
		if(prepayFeeDtos != null && prepayFeeDtos.length>0){
			PrepayFeeInfoDto prepayFee = null;
			for(int i=0;i<prepayFeeDtos.length;i++){
				if(prepayFeeDtos[i] != null){
					prepayFee = prepayFeeDtos[i];
					if(prepayFee.getChargeCode()==null || "".equals(prepayFee.getChargeCode())){
						returnStr = "0^������Ϣ�еķ��ô��벻��Ϊ��";
						return returnStr;
					}else{
						String chargeCode = "03,04,05,07,13,14,15,99";
						if(!chargeCode.contains(prepayFee.getChargeCode())){
							returnStr = "0^������Ϣ�еķ��ô��벻�Ϸ�";
							return returnStr;
						}
					}
					if(prepayFee.getChargeName()==null || "".equals(prepayFee.getChargeName())){
						returnStr = "0^������Ϣ�еķ������Ʋ���Ϊ��";
						return returnStr;
					}else{
						String chargeName = "ʩ�ȷ�,�鿱��,���Ϸ�,���������,������,ϵͳ�ڴ��鿱,��ʦ��,����";
						if(!chargeName.contains(prepayFee.getChargeName())){
							returnStr = "0^������Ϣ�еķ������Ʋ��Ϸ�";
							return returnStr;
						}
					}
					if(prepayFee.getCurrency()==null || "".equals(prepayFee.getCurrency())){
						returnStr = "0^������Ϣ�еıұ���벻��Ϊ��";
						return returnStr;
					}
					if(prepayFee.getKindCode()==null || "".equals(prepayFee.getKindCode())){
						returnStr = "0^������Ϣ�е��ձ���벻��Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		CompePayFeeInfoDto[] compePayFeeDtos = claimRequestInfo.getCompePayFeeInfoDto();
		if(compePayFeeDtos != null && compePayFeeDtos.length>0){
			CompePayFeeInfoDto compePayFee = null;
			for(int i=0;i<compePayFeeDtos.length;i++){
				if(compePayFeeDtos[i] != null){
					compePayFee = compePayFeeDtos[i];
					if(compePayFee.getKindCode()==null || "".equals(compePayFee.getKindCode())){
						returnStr = "0^��������������Ϣ�е��ձ���벻��Ϊ��";
						return returnStr;
					}
					if(compePayFee.getKindName()==null || "".equals(compePayFee.getKindName())){
						returnStr = "0^��������������Ϣ�е��ձ����Ʋ���Ϊ��";
						return returnStr;
					}
					if(compePayFee.getCodeCName()==null || "".equals(compePayFee.getCodeCName())){
						returnStr = "0^��������������Ϣ�еķ������Ʋ���Ϊ��";
						return returnStr;
					}else{
						String codeCName = "ʩ�ȷ�,�鿱��,���Ϸ�,���������,������,ϵͳ�ڴ��鿱,��ʦ��,����";
						if(!codeCName.contains(compePayFee.getCodeCName())){
							returnStr = "0^��������������Ϣ�еķ������Ʋ��Ϸ�";
							return returnStr;
						}
					}
					if(compePayFee.getCodeCode()==null || "".equals(compePayFee.getCodeCode())){
						returnStr = "0^��������������Ϣ�еķ��ô��벻��Ϊ��";
						return returnStr;
					}else{
						String codeCode = "03,04,05,07,13,14,15,99";
						if(!codeCode.contains(compePayFee.getCodeCode())){
							returnStr = "0^��������������Ϣ�еķ��ô��벻�Ϸ�";
							return returnStr;
						}
					}
					/*if(compePayFee.getCheckDeptName()==null || "".equals(compePayFee.getCheckDeptName())){
						returnStr = "0^��������������Ϣ�еĴ��鿱��������Ϊ��";
						return returnStr;
					}*/
					if(compePayFee.getCurrency()==null || "".equals(compePayFee.getCurrency())){
						returnStr = "0^��������������Ϣ�еıұ���벻��Ϊ��";
						return returnStr;
					}
					if(compePayFee.getCurrencyName()==null || "".equals(compePayFee.getCurrencyName())){
						returnStr = "0^��������������Ϣ�еıұ����Ʋ���Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^��������������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		CompeInvMainInfo[] compeInvMainDtos = claimRequestInfo.getCompeInvMainInfo();
		if(compeInvMainDtos != null && compeInvMainDtos.length>0){
			CompeInvMainInfo compeInvMain = null;
			for(int i=0;i<compeInvMainDtos.length;i++){
				if(compeInvMainDtos[i] != null){
					compeInvMain = compeInvMainDtos[i];
					if(compeInvMain.getRegistNo()==null || "".equals(compeInvMain.getRegistNo())){
						returnStr = "0^�����������嵥��Ϣ�еı����Ų���Ϊ��";
						return returnStr;
					}
					if(compeInvMain.getClaimNo()==null || "".equals(compeInvMain.getClaimNo())){
						returnStr = "0^�����������嵥��Ϣ�е������Ų���Ϊ��";
						return returnStr;
					}
					
					CompeInvDetailInfo[] compeInvDetailInfos = compeInvMain.getCompeInvDetailInfo();
					if(compeInvDetailInfos!=null && compeInvDetailInfos.length>0){
						CompeInvDetailInfo compeInvDetail = null;
						for(int j=0;j<compeInvDetailInfos.length;j++){
							if(compeInvDetailInfos[j] != null){
								compeInvDetail = compeInvDetailInfos[j];
								if(compeInvDetail.getName()==null || "".equals(compeInvDetail.getName())){
									returnStr = "0^�����������嵥��ϸ��Ϣ�еı������˲���Ϊ��";
									return returnStr;
								}
								if(compeInvDetail.getMedicalCard()==null || "".equals(compeInvDetail.getMedicalCard())){
									returnStr = "0^�����������嵥��ϸ��Ϣ�е�ҽ����Ų���Ϊ��";
									return returnStr;
								}
								if(compeInvDetail.getIdCard()==null || "".equals(compeInvDetail.getIdCard())){
									returnStr = "0^�����������嵥��ϸ��Ϣ�е����֤���벻��Ϊ��";
									return returnStr;
								}if(compeInvDetail.getMedicalFamily()==null || "".equals(compeInvDetail.getMedicalFamily())){
									returnStr = "0^�����������嵥��ϸ��Ϣ�еĻ�������Ϊ��";
									return returnStr;
								}
								if(compeInvDetail.getBank()==null || "".equals(compeInvDetail.getBank())){
									returnStr = "0^�����������嵥��ϸ��Ϣ�еĿ����в���Ϊ��";
									return returnStr;
								}
								if(compeInvDetail.getCreditCard()==null || "".equals(compeInvDetail.getCreditCard())){
									returnStr = "0^�����������嵥��ϸ��Ϣ�е������˻�����Ϊ��";
									return returnStr;
								}
							}
						}
					}
				}
			}
		}
		
		//�жϳ�������Ϣ�Ƿ�Ϊ��  ����Ǵ������������Ժ��ж�������˵���� ����ע�ͽ⿪����
		InjuryPersonInfoDto injuryPersonDto = claimRequestInfo.getInjuryPersonInfoDto();
		if(injuryPersonDto != null){
			if(injuryPersonDto.getAcciName()==null || "".equals(injuryPersonDto.getAcciName())){
				returnStr = "0^�����������������Ϊ��";
				return returnStr;
			}
			if(injuryPersonDto.getIdentifyNumber()==null || "".equals(injuryPersonDto.getIdentifyNumber())){
				returnStr = "0^������������֤���벻��Ϊ��";
				return returnStr;
			}
			if(injuryPersonDto.getSex()==null || "".equals(injuryPersonDto.getSex())){
				returnStr = "0^����������Ա���Ϊ��";
				return returnStr;
			}
		}else{
			returnStr ="0^�����������ϸ��Ϣ����Ϊ��";
			return returnStr;
		}
		return returnStr;
	}
	
	
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkRegistNotNullFiels(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == claimRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(claimRequestInfo.getPolicyno() == null || "".equals(claimRequestInfo.getPolicyno())){
			returnStr = "0^�����Ų���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOutRigstNo() == null || "".equals(claimRequestInfo.getOutRigstNo())){
			returnStr = "0^�ͻ��˱�����ˮ�Ų���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartDate() == null || "".equals(claimRequestInfo.getDamageStartDate())){
			returnStr = "0^�¹����ڲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartHour() == null || "".equals(claimRequestInfo.getDamageStartHour())){
			returnStr = "0^�¹�ʱ���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageCode() == null || "".equals(claimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportDate() == null || "".equals(claimRequestInfo.getReportDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportHour() == null || "".equals(claimRequestInfo.getReportHour())){
			returnStr = "0^����ʱ���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportType() == null || "".equals(claimRequestInfo.getReportType())){
			returnStr = "0^������ʽ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getLinkerName() == null || "".equals(claimRequestInfo.getLinkerName())){
			returnStr = "0^��ϵ�˲���Ϊ��";
			return returnStr;
		}
//		if(claimRequestInfo.getPhoneNumber() == null || "".equals(claimRequestInfo.getPhoneNumber())){
//			returnStr = "0^��ϵ�绰����Ϊ��";
//			return returnStr;
//		}
		if(claimRequestInfo.getClauseType() == null || "".equals(claimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageAddress() == null || "".equals(claimRequestInfo.getDamageAddress())){
			returnStr = "0^�¹ʵص㲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeCode() == null || "".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorCode() == null || "".equals(claimRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorName() == null || "".equals(claimRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getMakeCom() == null || "".equals(claimRequestInfo.getMakeCom())){
			returnStr = "0^���⴦���������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getMakeComName() == null || "".equals(claimRequestInfo.getMakeComName())){
			returnStr = "0^���⴦��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCurrency() == null || "".equals(claimRequestInfo.getCurrency())){
			returnStr = "0^�ұ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeName() == null || "".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^�¹��������Ʋ���Ϊ��";
			return returnStr;
		}
		
		if(claimRequestInfo.getRegistTime() == null || "".equals(claimRequestInfo.getRegistTime())){
			returnStr = "0^�������ڲ���ʱ�䲻��Ϊ��";
			return returnStr;
		}
		
		if(claimRequestInfo.getRegistUser() == null || "".equals(claimRequestInfo.getRegistUser())){
			returnStr = "0^����������Ա���벻��Ϊ��";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkCompeNotNullFiels(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == claimRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(claimRequestInfo.getPolicyno() == null || "".equals(claimRequestInfo.getPolicyno())){
			returnStr = "0^�����Ų���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOutRigstNo() == null || "".equals(claimRequestInfo.getOutRigstNo())){
			returnStr = "0^�ͻ��˱�����ˮ�Ų���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartDate() == null || "".equals(claimRequestInfo.getDamageStartDate())){
			returnStr = "0^�¹����ڲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartHour() == null || "".equals(claimRequestInfo.getDamageStartHour())){
			returnStr = "0^�¹�ʱ���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageCode() == null || "".equals(claimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportDate() == null || "".equals(claimRequestInfo.getReportDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportHour() == null || "".equals(claimRequestInfo.getReportHour())){
			returnStr = "0^����ʱ���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReportType() == null || "".equals(claimRequestInfo.getReportType())){
			returnStr = "0^������ʽ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getLinkerName() == null || "".equals(claimRequestInfo.getLinkerName())){
			returnStr = "0^��ϵ�˲���Ϊ��";
			return returnStr;
		}
//		if(claimRequestInfo.getPhoneNumber() == null || "".equals(claimRequestInfo.getPhoneNumber())){
//			returnStr = "0^��ϵ�绰����Ϊ��";
//			return returnStr;
//		}
		if(claimRequestInfo.getClauseType() == null || "".equals(claimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageAddress() == null || "".equals(claimRequestInfo.getDamageAddress())){
			returnStr = "0^�¹ʵص㲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeCode() == null || "".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorCode() == null || "".equals(claimRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorName() == null || "".equals(claimRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getMakeCom() == null || "".equals(claimRequestInfo.getMakeCom())){
			returnStr = "0^���⴦���������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getMakeComName() == null || "".equals(claimRequestInfo.getMakeComName())){
			returnStr = "0^���⴦��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getScheduleObjectId() == null || "".equals(claimRequestInfo.getScheduleObjectId())){
			returnStr = "0^���Ȳ鿱�����������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckSite() == null || "".equals(claimRequestInfo.getCheckSite())){
			returnStr = "0^�鿱��ַ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckType() == null || "".equals(claimRequestInfo.getCheckType())){
			returnStr = "0^�鿱���Ͳ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckDate() == null || "".equals(claimRequestInfo.getCheckDate())){
			returnStr = "0^�鿱���ڲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckNature() == null || "".equals(claimRequestInfo.getCheckNature())){
			returnStr = "0^�鿱���ʲ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getUnitType() == null || "".equals(claimRequestInfo.getUnitType())){
			returnStr = "0^�鿱����λ����Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCheckContext() == null || "".equals(claimRequestInfo.getCheckContext())){
			returnStr = "0^�鿱���治��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCurrency() == null || "".equals(claimRequestInfo.getCurrency())){
			returnStr = "0^�ұ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeName() == null || "".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^�¹��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getReplevyFlag() == null || "".equals(claimRequestInfo.getReplevyFlag())){
			returnStr = "0^�Ƿ������׷������Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getThirdComFlag() == null || "".equals(claimRequestInfo.getThirdComFlag())){
			returnStr = "0^�Ƿ������������н鲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getClaimType() == null || "".equals(claimRequestInfo.getClaimType())){
			returnStr = "0^�������ʹ��벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getRegistTime() == null || "".equals(claimRequestInfo.getRegistTime())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getRegistUser() == null || "".equals(claimRequestInfo.getRegistUser())){
			returnStr = "0^������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCompeTime() == null || "".equals(claimRequestInfo.getCompeTime())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getCompeUser() == null || "".equals(claimRequestInfo.getCompeUser())){
			returnStr = "0^������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(claimRequestInfo.getClaimAppDto() == null || claimRequestInfo.getClaimAppDto().length == 0){
			returnStr = "0^������������Ϣ����Ϊ��";
			return returnStr;
		}else{
			ClaimAppDto[] claimAppDtos = claimRequestInfo.getClaimAppDto();
			ClaimAppDto claimApp = null;
			for(int i=0;i<claimAppDtos.length;i++){
				if(claimAppDtos[i] != null){
					claimApp = claimAppDtos[i];
					if(claimApp.getAcciName()==null || "".equals(claimApp.getAcciName())){
						returnStr = "0^������������Ϣ�е���������Ϊ��";
						return returnStr;
					}
					if(claimApp.getIdentifyNumber()==null || "".equals(claimApp.getIdentifyNumber())){
						returnStr = "0^������������Ϣ�е����֤���벻��Ϊ��";
						return returnStr;
					}
					if(claimApp.getRelationCode()==null || "".equals(claimApp.getRelationCode())){
						returnStr = "0^������������Ϣ�е����¹��߹�ϵ����Ϊ��";
						return returnStr;
					}else{
						String relationCode = "1,2,3";
						if(!relationCode.contains(claimApp.getRelationCode())){
							returnStr = "0^������������Ϣ�е����¹��߹�ϵ���Ϸ�";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^������������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getClaimKindDto() == null || claimRequestInfo.getClaimKindDto().length == 0){
			returnStr = "0^�����ձ��������Ϣ����Ϊ��";
			return returnStr;
		}else{
			ClaimKindDto[] claimKindDtos = claimRequestInfo.getClaimKindDto();
			ClaimKindDto claimKind = null;
			for(int i=0;i<claimKindDtos.length;i++){
				if(claimKindDtos[i] != null){
					claimKind = claimKindDtos[i];
					if(claimKind.getFamilyName()==null || "".equals(claimKind.getFamilyName())){
						returnStr = "0^������������Ϣ�е��¹������Ʋ���Ϊ��";
						return returnStr;
					}
					if(claimKind.getKindCode()==null || "".equals(claimKind.getKindCode())){
						returnStr = "0^������������Ϣ�е��ձ���벻��Ϊ��";
						return returnStr;
					}
					if(claimKind.getKindName()==null || "".equals(claimKind.getKindName())){
						returnStr = "0^������������Ϣ�е��ձ����Ʋ���Ϊ��";
						return returnStr;
					}
					if(claimKind.getCurrency()==null || "".equals(claimKind.getCurrency())){
						returnStr = "0^������������Ϣ�еıұ���벻��Ϊ��";
						return returnStr;
					}
					if(claimKind.getLossFeeType()==null || "".equals(claimKind.getLossFeeType())){
						returnStr = "0^������������Ϣ�е������Ϊ��";
						return returnStr;
					}else{
						String lossFeeType = "P,Z";
						if(!lossFeeType.contains(claimKind.getLossFeeType())){
							returnStr = "0^������������Ϣ�е���𲻺Ϸ�";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^������������Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		SchedExtInfoDto[] schedExtDtos = claimRequestInfo.getSchedExtInfoDto();
		if(schedExtDtos != null && schedExtDtos.length>0){
			SchedExtInfoDto schedExt = null;
			for(int i=0;i<schedExtDtos.length;i++){
				if(schedExtDtos[i] != null){
					schedExt = schedExtDtos[i];
					if(schedExt.getOperatorCode()==null || "".equals(schedExt.getOperatorCode())){
						returnStr = "0^����˵����Ϣ�еĲ����˲���Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^����˵����Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		//�жϳ�������Ϣ�Ƿ�Ϊ��
		InjuryPersonInfoDto[] injuryPersonInfoDto = claimRequestInfo.getInjuryPersonInfoArrayDto();
		if(injuryPersonInfoDto != null && injuryPersonInfoDto.length>0){
			InjuryPersonInfoDto injuryPersonInfo = null;
			for(int i=0;i<injuryPersonInfoDto.length;i++){
				if(injuryPersonInfoDto[i] != null){
					injuryPersonInfo = injuryPersonInfoDto[i];
					if(injuryPersonInfo.getAcciName()==null || "".equals(injuryPersonInfo.getAcciName())){
						returnStr = "0^�����������������Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^�����������ϸ��Ϣ����Ϊ��";
					return returnStr;
				}
			}
		}
		
		return returnStr;
	}
	
	/**
	 * ��־λ�ֶεķ�ΧУ�飬���в������������ֶ����ԣ�������ʾ��0^ĳ�������ݲ��Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkFlagFieldsRange(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(claimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ�򲻺Ϸ�";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(claimRequestInfo.getReportType())){
			returnStr = "0^������ʽ���Ϸ�";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(claimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ���Ϸ�";
			return returnStr;
		}
		if(!"999".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ��Ϸ�";
			return returnStr;
		}
		String currency="HKD,DEM,DKK,GBP,ECU,USD,ESP,EUR,FIM,FRF,NLG,NOK,NTD,NZD,HPH,SDR,SEK,SGD,ITL,JPY,MOP,MYR,THB,AUD,BEF,ATS,CNY,ASF,CAD,CHF";
		if(!currency.contains(claimRequestInfo.getCurrency())){
			returnStr = "0^�ұ𲻺Ϸ�";
			return returnStr;
		}
		if(!"����".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^�¹��������Ʋ��Ϸ�";
			return returnStr;
		}
		String claimType = "0,1,5,7,8,B";
		if(!claimType.contains(claimRequestInfo.getClaimType())){
			returnStr = "0^�������ʹ��벻�Ϸ�";
			return returnStr;
		}
		String caseType = "5,7,8";
		if(!caseType.contains(claimRequestInfo.getCaseType())){
			returnStr = "0^�ⰸ���Ͳ��Ϸ�";
			return returnStr;
		}
		String notion = "01,02,03,04,05";
		if(!notion.contains(claimRequestInfo.getNotion())){
			returnStr = "0^����Ƭ�ﲻ�Ϸ�";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * ��־λ�ֶεķ�ΧУ�飬���в������������ֶ����ԣ�������ʾ��0^ĳ�������ݲ��Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkRegistFlagFieldsRange(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(claimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ�򲻺Ϸ�";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(claimRequestInfo.getReportType())){
			returnStr = "0^������ʽ���Ϸ�";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(claimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ���Ϸ�";
			return returnStr;
		}
		if(!"999".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ��Ϸ�";
			return returnStr;
		}
		String currency="HKD,DEM,DKK,GBP,ECU,USD,ESP,EUR,FIM,FRF,NLG,NOK,NTD,NZD,HPH,SDR,SEK,SGD,ITL,JPY,MOP,MYR,THB,AUD,BEF,ATS,CNY,ASF,CAD,CHF";
		if(!currency.contains(claimRequestInfo.getCurrency())){
			returnStr = "0^�ұ𲻺Ϸ�";
			return returnStr;
		}
		if(!"����".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^�¹��������Ʋ��Ϸ�";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * ��־λ�ֶεķ�ΧУ�飬���в������������ֶ����ԣ�������ʾ��0^ĳ�������ݲ��Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkCompeFlagFieldsRange(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(claimRequestInfo.getDamageCode())){
			returnStr = "0^�¹�ԭ�򲻺Ϸ�";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(claimRequestInfo.getReportType())){
			returnStr = "0^������ʽ���Ϸ�";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(claimRequestInfo.getClauseType())){
			returnStr = "0^���¹��߹�ϵ���Ϸ�";
			return returnStr;
		}
		if(!"999".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^�¹����Ͳ��Ϸ�";
			return returnStr;
		}
		String currency="HKD,DEM,DKK,GBP,ECU,USD,ESP,EUR,FIM,FRF,NLG,NOK,NTD,NZD,HPH,SDR,SEK,SGD,ITL,JPY,MOP,MYR,THB,AUD,BEF,ATS,CNY,ASF,CAD,CHF";
		if(!currency.contains(claimRequestInfo.getCurrency())){
			returnStr = "0^�ұ𲻺Ϸ�";
			return returnStr;
		}
		if(!"����".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^�¹��������Ʋ��Ϸ�";
			return returnStr;
		}
		String claimType = "0,1,5,7,8,B";
		if(!claimType.contains(claimRequestInfo.getClaimType())){
			returnStr = "0^�������ʹ��벻�Ϸ�";
			return returnStr;
		}
		String caseType = "5,7,8";
		if(!caseType.contains(claimRequestInfo.getCaseType())){
			returnStr = "0^�ⰸ���Ͳ��Ϸ�";
			return returnStr;
		}
		String notion = "01,02,03,04,05";
		if(!notion.contains(claimRequestInfo.getNotion())){
			returnStr = "0^����Ƭ�ﲻ�Ϸ�";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * У���ⲿoutId�Ƿ����м���д��ڣ��Ѿ����ڵĻ�����������Ϣ
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkExistenceOfOutId(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		Collection collection = 
			blPrpLinterRequestFacade.findByConditionsWithChild(" OutRigstNo='"+claimRequestInfo.getOutRigstNo()+"' ");
		if(collection != null){
			Iterator it = collection.iterator();
			if(it.hasNext()){
				PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)it.next();
				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getClaimAutoFlag())){
					returnStr = "2^�������Ѿ�����������ϵͳ����᰸�ӿڣ������ظ�����";
					return returnStr;
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * У���ⲿoutId�Ƿ����м���д��ڣ��Ѿ����ڵĻ�����������Ϣ
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkExistenceOfRegist(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		Collection collection = 
			blPrpLinterRequestFacade.findByConditionsWithRegistChild(" OutRigstNo='"+claimRequestInfo.getOutRigstNo()+"' ");
		if(collection != null){
			Iterator it = collection.iterator();
			if(it.hasNext()){
				PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)it.next();
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getRegistAutoFlag())){
					returnStr = "2^�������Ѿ�����������ϵͳ�����ӿڣ������ظ�����";
					return returnStr;
				}	
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getCompeAutoFlag())){
					returnStr = "1^�������Ѿ�����������ϵͳ�����ӿڣ����ɽ��������ӿ�";
					return returnStr;
				}
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getClaimAutoFlag())){
					returnStr = "1^�������Ѿ�����������ϵͳ����᰸�ӿڣ����ɽ��������ӿ�";
					return returnStr;
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * У���ⲿoutId�Ƿ����м���д��ڣ��Ѿ����ڵĻ�����������Ϣ
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkExistenceOfCompe(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		Collection collection = 
			blPrpLinterRequestFacade.findByConditionsWithChild(" OutRigstNo='"+claimRequestInfo.getOutRigstNo()+"' ");
		if(collection != null){
			Iterator it = collection.iterator();
			if(it.hasNext()){
				PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)it.next();
				PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = prpLinterRequestDto.getPrplinterAutoClaimDetailDto();
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getCompeAutoFlag())){
					returnStr = "2^�������Ѿ�����������ϵͳ����ӿ�,�����ظ�����";
					return returnStr;
				}
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getClaimAutoFlag())){
					returnStr = "2^�������Ѿ�����������ϵͳ����᰸�ӿ�,���ɽ�������ӿ�";
					return returnStr;
				}
			}
		}
		ArrayList interRequest = (ArrayList)blPrpLinterRequestFacade.findByConditions(" OutRigstNo='"+claimRequestInfo.getOutRigstNo()+"' ");
		if(interRequest!=null&&interRequest.size()>1){
			returnStr = "2^�����ݽ���������ϵͳ��Σ�1�����ϣ�";
			return returnStr;
		}
		return returnStr;
	}
	
	/**
	 * �ж�ҵ�񵥺ŵ���Ч��У�飨���������Ƿ���Ч����������ʾ��0^������Ϣ������
	 * �ж��¹�ʱ�䣬������Ч��֮�ڣ�������ʾ��0^�¹�ʱ�䲻�ڱ�����Ч����
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkPolicyNoAndDamageStartDate(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		String policyNo = claimRequestInfo.getPolicyno();
		Date damageDateStr = claimRequestInfo.getDamageStartDate();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String damageDate = "";
		if(null != damageDateStr){
			damageDate = simple.format(damageDateStr);
		}
		String damageHour = claimRequestInfo.getDamageStartHour();
		// ��ѯ������Ϣ
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate, damageHour);
		if(policyDto == null || policyDto.getPrpCmainDto()==null){
			returnStr = "0^������Ϣ������";
			return returnStr;
		}
		PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
		if(claimRequestInfo.getDamageStartDate().before(prpCmainDto.getStartDate()) 
				|| claimRequestInfo.getDamageStartDate().after(prpCmainDto.getEndDate())){
			returnStr = "0^�¹�ʱ�䲻�ڱ�����Ч����";
			return returnStr;
		}

		return returnStr;
	}
	
	/**
	 * ���Ϸ���У�飬������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception  
	 */
	public String checkLegalityOfFees(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		/** --����  sumClaim = ��(claimkindDto.sumClaim) */
		//�ж������������Ƿ�����Ӷ����Ԥ�Ƹ������֮��
		double sumClaim = 0.0;
		ClaimKindDto[] claimKindDtos = claimRequestInfo.getClaimKindDto();
		if(claimKindDtos!=null && claimKindDtos.length>0){
			ClaimKindDto claimKind = null;
			for(int i=0;i<claimKindDtos.length;i++){
				if(claimKindDtos[i] != null){
					claimKind = claimKindDtos[i];
					sumClaim += claimKind.getSumClaim();
				}
			}
			if(claimRequestInfo.getSumClaim() != sumClaim){
				returnStr = "0^��������������Ӷ����Ԥ�Ƹ������֮��";
				return returnStr;
			}
		}
		
		/** --����   sumNoDutyFee = ��(compepayfeeinfodto.chargeAmount)
	             	sumThisPaid = ��(compeFeeinfodto.sumrealpay)
	             	prplcompensatesumpaid = sumNoDutyFee + sumThisPaid  */
		//�жϷ��úϼ��Ƿ�����Ӷ���ķ��ý��֮��
		double sumNoDutyFee = 0.0;
		CompePayFeeInfoDto[] compePayFeeDtos = claimRequestInfo.getCompePayFeeInfoDto();
		if(compePayFeeDtos!=null && compePayFeeDtos.length>0){
			CompePayFeeInfoDto compePayFee = null;
			for(int i=0;i<compePayFeeDtos.length;i++){
				if(compePayFeeDtos[i] != null){
					compePayFee = compePayFeeDtos[i];
					sumNoDutyFee += compePayFee.getChargeAmount();
				}
			}
			if(claimRequestInfo.getSumNoDutyFee() != sumNoDutyFee){
				returnStr = "0^���úϼƲ������Ӷ���ķ��ý��֮��";
				return returnStr;
			}
		}
		//�жϱ��θ�������Ƿ�����Ӷ���ĸ������֮��
		double sumThisPaid = 0.0;
		CompeFeeInfoDto[] compeFeeDtos = claimRequestInfo.getCompeFeeInfoDto();
		if(compeFeeDtos!=null && compeFeeDtos.length>0){
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					sumThisPaid += compeFee.getSumRealPay();
				}
			}
			if(claimRequestInfo.getSumThisPaid() != sumThisPaid){
				returnStr = "0^���θ����������Ӷ���ĸ������֮��";
				return returnStr;
			}
		}
		//�ж����ϼ��Ƿ���ڷ��úϼ��뱾�θ������֮��
		if(claimRequestInfo.getPrplCompensateSumPaid() != claimRequestInfo.getSumNoDutyFee() + claimRequestInfo.getSumThisPaid()){
			returnStr = "0^���ϼƲ����ڷ��úϼ��뱾�θ������֮��";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * ���Ϸ���У�飬������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception  
	 */
	public String checkCompeLegalityOfFees(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		/** --����  sumClaim = ��(claimkindDto.sumClaim) */
		//�ж������������Ƿ�����Ӷ����Ԥ�Ƹ������֮��
		double sumClaim = 0.0;
		ClaimKindDto[] claimKindDtos = claimRequestInfo.getClaimKindDto();
		if(claimKindDtos!=null && claimKindDtos.length>0){
			ClaimKindDto claimKind = null;
			for(int i=0;i<claimKindDtos.length;i++){
				if(claimKindDtos[i] != null){
					claimKind = claimKindDtos[i];
					sumClaim += claimKind.getSumClaim();
				}
			}
			if(claimRequestInfo.getSumClaim() != sumClaim){
				returnStr = "0^��������������Ӷ����Ԥ�Ƹ������֮��";
				return returnStr;
			}
		}
		
		/** --����   sumNoDutyFee = ��(compepayfeeinfodto.chargeAmount)
	             	sumThisPaid = ��(compeFeeinfodto.sumrealpay)
	             	prplcompensatesumpaid = sumNoDutyFee + sumThisPaid  */
		//�жϷ��úϼ��Ƿ�����Ӷ���ķ��ý��֮��
		double sumNoDutyFee = 0.0;
		CompePayFeeInfoDto[] compePayFeeDtos = claimRequestInfo.getCompePayFeeInfoDto();
		if(compePayFeeDtos!=null && compePayFeeDtos.length>0){
			CompePayFeeInfoDto compePayFee = null;
			for(int i=0;i<compePayFeeDtos.length;i++){
				if(compePayFeeDtos[i] != null){
					compePayFee = compePayFeeDtos[i];
					sumNoDutyFee += compePayFee.getChargeAmount();
				}
			}
			if(claimRequestInfo.getSumNoDutyFee() != sumNoDutyFee){
				returnStr = "0^���úϼƲ������Ӷ���ķ��ý��֮��";
				return returnStr;
			}
		}
		//�жϱ��θ�������Ƿ�����Ӷ���ĸ������֮��
		double sumThisPaid = 0.0;
		CompeFeeInfoDto[] compeFeeDtos = claimRequestInfo.getCompeFeeInfoDto();
		if(compeFeeDtos!=null && compeFeeDtos.length>0){
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					sumThisPaid += compeFee.getSumRealPay();
				}
			}
			if(claimRequestInfo.getSumThisPaid() != sumThisPaid){
				returnStr = "0^���θ����������Ӷ���ĸ������֮��";
				return returnStr;
			}
		}
		//�ж����ϼ��Ƿ���ڷ��úϼ��뱾�θ������֮��
		if(claimRequestInfo.getPrplCompensateSumPaid() != claimRequestInfo.getSumNoDutyFee() + claimRequestInfo.getSumThisPaid()){
			returnStr = "0^���ϼƲ����ڷ��úϼ��뱾�θ������֮��";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkOperatorCodeAndMakeCom(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		String operatorCode = claimRequestInfo.getOperatorCode();
		String makeCom = claimRequestInfo.getMakeCom();
		String scheduleObjectId = claimRequestInfo.getScheduleObjectId();
		String registUser = claimRequestInfo.getRegistUser();
		String compeUser = claimRequestInfo.getCompeUser();
		String vericUser = claimRequestInfo.getVericUser();
		
		DBManager dbManager = new DBManager();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
    		PrpDuserDto prpDuserDto = dbPrpDuser.findByPrimaryKey(operatorCode);
    		if(prpDuserDto==null){
    			returnStr = "0^�����˴��벻�Ϸ�";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^���⴦��������Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDcompanyDto prpDcompany = dbPrpDcompany.findByPrimaryKey(scheduleObjectId);
    		if(prpDcompany == null){
    			returnStr = "0^���Ȳ鿱����λ���Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto1 = dbPrpDuser.findByPrimaryKey(registUser);
    		if(prpDuserDto1==null){
    			returnStr = "0^������Ա���벻�Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto2 = dbPrpDuser.findByPrimaryKey(compeUser);
    		if(prpDuserDto2==null){
    			returnStr = "0^������Ա���벻�Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto3 = dbPrpDuser.findByPrimaryKey(vericUser);
    		if(prpDuserDto3==null){
    			returnStr = "0^������Ա���벻�Ϸ�";
    			return returnStr;
    		}
    		
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
		return returnStr;
	}
	
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkRegistOperatorCodeAndMakeCom(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		String operatorCode = claimRequestInfo.getOperatorCode();
		String makeCom = claimRequestInfo.getMakeCom();
		String scheduleObjectId = claimRequestInfo.getScheduleObjectId();
		String registUser = claimRequestInfo.getRegistUser();
		
		DBManager dbManager = new DBManager();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
    		PrpDuserDto prpDuserDto = dbPrpDuser.findByPrimaryKey(operatorCode);
    		if(prpDuserDto==null){
    			returnStr = "0^�����˴��벻�Ϸ�";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^���⴦��������Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto1 = dbPrpDuser.findByPrimaryKey(registUser);
    		if(prpDuserDto1 == null){
    			returnStr = "0^���������˴��벻�Ϸ�";
    			return returnStr;
    		}
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
		return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkCompeOperatorCodeAndMakeCom(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		String operatorCode = claimRequestInfo.getOperatorCode();
		String makeCom = claimRequestInfo.getMakeCom();
		String scheduleObjectId = claimRequestInfo.getScheduleObjectId();
		String registUser = claimRequestInfo.getRegistUser();
		String compeUser = claimRequestInfo.getCompeUser();
		DBManager dbManager = new DBManager();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
    		PrpDuserDto prpDuserDto = dbPrpDuser.findByPrimaryKey(operatorCode);
    		if(prpDuserDto==null){
    			returnStr = "0^�����˴��벻�Ϸ�";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^���⴦��������Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDcompanyDto prpDcompany = dbPrpDcompany.findByPrimaryKey(scheduleObjectId);
    		if(prpDcompany == null){
    			returnStr = "0^���Ȳ鿱����λ���Ϸ�";
    			return returnStr;
    		}
    		PrpDuserDto prpDuserDto1 = dbPrpDuser.findByPrimaryKey(registUser);
    		if(prpDuserDto1 == null){
    			returnStr = "0^���������˴��벻�Ϸ�";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto2 = dbPrpDuser.findByPrimaryKey(compeUser);
    		if(prpDuserDto2==null){
    			returnStr = "0^������Ա���벻�Ϸ�";
    			return returnStr;
    		}
    		
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
		return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkRegistInputdate(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		System.err.println("RegistTime===="+sf.format(claimRequestInfo.getRegistTime()));
		DateTime RegistTime = new DateTime(claimRequestInfo.getRegistTime(),DateTime.YEAR_TO_DAY);
		int flag = 0;
		DBManager dbManager = new DBManager();
		try{
            dbManager.open(AppConfig.get("sysconst.DBJNDI"));
            DBPrpDuser dbPrpDuser = new DBPrpDuser(dbManager);
            Calendar cal = Calendar.getInstance();
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = String.valueOf(cal.get(Calendar.MONTH));
            
            int iYear = 0;
            String iEndDate = "";
            PubTools  pubTools  = new PubTools();
            Date date = new Date();
            iEndDate  = sf.format(date);
            iEndDate =  pubTools.getMonthEnd(iEndDate, "1", 1);
            
           System.err.println("outregist="+claimRequestInfo.getOutRigstNo()+" ==RegistTime==="+ RegistTime.toString()+"iEndDate==="+iEndDate);  
           flag =  PubTools.compareDate(RegistTime.toString(), iEndDate);
           if(flag>0){
        	   
           }else{
        	   returnStr = "0^��������ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
     		   return returnStr;
           }
        }catch(Exception exception){
            throw exception;
        }finally{
            dbManager.close();
        }
        return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkCompeInputdate(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		DateTime RegistTime = new DateTime(claimRequestInfo.getRegistTime(),DateTime.YEAR_TO_DAY);
		DateTime CompeTime = new DateTime(claimRequestInfo.getCompeTime(),DateTime.YEAR_TO_DAY);
		int flag = 0;
		String outRigstNo = claimRequestInfo.getOutRigstNo();
		BLPrpLinterRequestFacade  blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		ArrayList interRequest = (ArrayList)blPrpLinterRequestFacade.findByConditions("outRigstNo='"+outRigstNo+"'");
		try{
            Calendar cal = Calendar.getInstance();
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = String.valueOf(cal.get(Calendar.MONTH));
            
            int iYear = 0;
            String iEndDate = "";
            
            PubTools  pubTools  = new PubTools();
            Date date = new Date();
            iEndDate  = sf.format(date);
            iEndDate =  pubTools.getMonthEnd(iEndDate, "1", 1);
            
           System.err.println("outregist="+claimRequestInfo.getOutRigstNo()+" ==CompeTime==="+ CompeTime.toString()+"iEndDate==="+iEndDate);  
           flag =  PubTools.compareDate(CompeTime.toString(), iEndDate);
           if(flag>0){
        	   
           }else{
        	   returnStr = "0^��������ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
     		   return returnStr;
           }
           if(interRequest!=null&&interRequest.size()>0){
        	   PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)interRequest.get(0);
           }else{
        	  int registFlag =  PubTools.compareDate(RegistTime.toString(), iEndDate);
        	  if(registFlag>0){
           	   
              }else{
           	      returnStr = "0^��������ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
        		  return returnStr;
              }
           }
        }catch(Exception exception){
            throw exception;
        }finally{
        	
        }
        return returnStr;
	}
	
	/**
	 * �жϲ����˴��롢���⴦����������Ȳ鿱��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkClaimInputdate(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		DateTime VericTime = new DateTime(claimRequestInfo.getVericTime(),DateTime.YEAR_TO_DAY);
		DateTime RegistTime = new DateTime(claimRequestInfo.getRegistTime(),DateTime.YEAR_TO_DAY);
		DateTime CompeTime = new DateTime(claimRequestInfo.getCompeTime(),DateTime.YEAR_TO_DAY);
		String outRigstNo = claimRequestInfo.getOutRigstNo();
		BLPrpLinterRequestFacade  blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		ArrayList interRequest = (ArrayList)blPrpLinterRequestFacade.findByConditions("outRigstNo='"+outRigstNo+"'");
		int flag = 0;
		try{
            Calendar cal = Calendar.getInstance();
            String year = String.valueOf(cal.get(Calendar.YEAR));
            String month = String.valueOf(cal.get(Calendar.MONTH));
            
            int iYear = 0;
            String iEndDate = "";
            PubTools  pubTools  = new PubTools();
            Date date = new Date();
            iEndDate  = sf.format(date);
            iEndDate =  pubTools.getMonthEnd(iEndDate, "1", 1);
            System.err.println("outregist="+claimRequestInfo.getOutRigstNo()+" ==VericTime==="+ VericTime.toString()+"iEndDate==="+iEndDate);  
           
           flag =  PubTools.compareDate(VericTime.toString(), iEndDate);
           if(flag>0){
        	   
           }else{
        	   returnStr = "0^����᰸����ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
     		   return returnStr;
           }
           if(interRequest!=null&&interRequest.size()>0){
        	   PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)interRequest.get(0);
        	   prpLinterRequestDto.getRegistAutoFlag();
        	   prpLinterRequestDto.getCompeAutoFlag();
        	   if(!"1".equals(prpLinterRequestDto.getCompeAutoFlag())){
        		  int compeFlag =  PubTools.compareDate(CompeTime.toString(), iEndDate);
             	  if(compeFlag>0){
                	   
                   }else{
                	      returnStr = "0^��������ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
             		  return returnStr;
                   }
        	   }
           }else{
        	  int registFlag =  PubTools.compareDate(RegistTime.toString(), iEndDate);
        	  if(registFlag>0){
           	   
              }else{
           	      returnStr = "0^��������ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
        		  return returnStr;
              }
        	  int compeFlag =  PubTools.compareDate(CompeTime.toString(), iEndDate);
        	  if(compeFlag>0){
           	   
              }else{
           	      returnStr = "0^��������ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
        		  return returnStr;
              }
           }
          
        }catch(Exception exception){
            throw exception;
        }finally{
           
        }
        return returnStr;
	}

}
