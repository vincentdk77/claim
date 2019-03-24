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
 * 接口传入参数的合法性校验类
 * 
 */
public class UIMedicalCheckBeforeAutoClaimViewHelper {
	/**
	 * 接口传入参数的合法性校验
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
	 * 接口传入参数的合法性校验
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
	 * 接口传入参数的合法性校验
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
	 * 非空字段的非空性校验，若有不满足条件的字段属性，返回提示：0^某属性不能为空
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkNotNullFiels(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == claimRequestInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(claimRequestInfo.getPolicyno() == null || "".equals(claimRequestInfo.getPolicyno())){
			returnStr = "0^保单号不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOutId() == null || "".equals(claimRequestInfo.getOutId())){
			returnStr = "0^客户端数据主键不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOutRigstNo() == null || "".equals(claimRequestInfo.getOutRigstNo())){
			returnStr = "0^客户端报案流水号不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartDate() == null || "".equals(claimRequestInfo.getDamageStartDate())){
			returnStr = "0^事故日期不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartHour() == null || "".equals(claimRequestInfo.getDamageStartHour())){
			returnStr = "0^事故时分秒不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageCode() == null || "".equals(claimRequestInfo.getDamageCode())){
			returnStr = "0^事故原因不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportDate() == null || "".equals(claimRequestInfo.getReportDate())){
			returnStr = "0^报案时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportHour() == null || "".equals(claimRequestInfo.getReportHour())){
			returnStr = "0^报案时分秒不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportType() == null || "".equals(claimRequestInfo.getReportType())){
			returnStr = "0^报案方式不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getLinkerName() == null || "".equals(claimRequestInfo.getLinkerName())){
			returnStr = "0^联系人不能为空";
			return returnStr;
		}
//		if(claimRequestInfo.getPhoneNumber() == null || "".equals(claimRequestInfo.getPhoneNumber())){
//			returnStr = "0^联系电话不能为空";
//			return returnStr;
//		}
		if(claimRequestInfo.getClauseType() == null || "".equals(claimRequestInfo.getClauseType())){
			returnStr = "0^与事故者关系不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageAddress() == null || "".equals(claimRequestInfo.getDamageAddress())){
			returnStr = "0^事故地点不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeCode() == null || "".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^事故类型不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorCode() == null || "".equals(claimRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorName() == null || "".equals(claimRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getMakeCom() == null || "".equals(claimRequestInfo.getMakeCom())){
			returnStr = "0^理赔处理机构不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getMakeComName() == null || "".equals(claimRequestInfo.getMakeComName())){
			returnStr = "0^理赔处理机构名称不能为空";
			return returnStr;
		}
//		if(claimRequestInfo.getAccidentPersonInfoDto() == null || claimRequestInfo.getAccidentPersonInfoDto().length == 0){
//			returnStr = "0^事故者信息不能为空";
//			return returnStr;
//		} else {
//			AccidentPersonInfoDto[] accidentPersonDtos = claimRequestInfo.getAccidentPersonInfoDto();
//			AccidentPersonInfoDto accidentPerson = null;
//			for(int i=0;i<accidentPersonDtos.length;i++){
//				if(accidentPersonDtos[i] != null){
//					accidentPerson = accidentPersonDtos[i];
//					if(accidentPerson.getAcciCode()==null || "".equals(accidentPerson.getAcciCode())){
//						returnStr = "0^事故者信息中的事故者代码不能为空";
//						return returnStr;
//					}
//					if(accidentPerson.getAcciName()==null || "".equals(accidentPerson.getAcciName())){
//						returnStr = "0^事故者信息中的事故者名称不能为空";
//						return returnStr;
//					}
//					if(accidentPerson.getSex()==null || "".equals(accidentPerson.getSex())){
//						returnStr = "0^事故者信息中的性别不能为空";
//						return returnStr;
//					}else{
//						String sex = "1,2,9";
//						if(!sex.contains(accidentPerson.getSex())){
//							returnStr = "0^事故者信息中的性别不合法";
//							return returnStr;
//						}
//					}
//					if(accidentPerson.getIdentifyNumber()==null || "".equals(accidentPerson.getIdentifyNumber())){
//						returnStr = "0^事故者信息中的身份证号码不能为空";
//						return returnStr;
//					}
//				}else{
//					returnStr = "0^事故者信息不能为空";
//					return returnStr;
//				}
//			}
//		}
		if(claimRequestInfo.getScheduleObjectId() == null || "".equals(claimRequestInfo.getScheduleObjectId())){
			returnStr = "0^调度查勘处理机构不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckSite() == null || "".equals(claimRequestInfo.getCheckSite())){
			returnStr = "0^查勘地址不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckType() == null || "".equals(claimRequestInfo.getCheckType())){
			returnStr = "0^查勘类型不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckDate() == null || "".equals(claimRequestInfo.getCheckDate())){
			returnStr = "0^查勘日期不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckNature() == null || "".equals(claimRequestInfo.getCheckNature())){
			returnStr = "0^查勘性质不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getUnitType() == null || "".equals(claimRequestInfo.getUnitType())){
			returnStr = "0^查勘处理单位不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckContext() == null || "".equals(claimRequestInfo.getCheckContext())){
			returnStr = "0^查勘报告不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCurrency() == null || "".equals(claimRequestInfo.getCurrency())){
			returnStr = "0^币别不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeName() == null || "".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^事故类型名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReplevyFlag() == null || "".equals(claimRequestInfo.getReplevyFlag())){
			returnStr = "0^是否可能有追偿不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getThirdComFlag() == null || "".equals(claimRequestInfo.getThirdComFlag())){
			returnStr = "0^是否有其他理赔中介不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getClaimType() == null || "".equals(claimRequestInfo.getClaimType())){
			returnStr = "0^案件类型代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getRegistTime() == null || "".equals(claimRequestInfo.getRegistTime())){
			returnStr = "0^报案时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getRegistUser() == null || "".equals(claimRequestInfo.getRegistUser())){
			returnStr = "0^报案人员代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCompeTime() == null || "".equals(claimRequestInfo.getCompeTime())){
			returnStr = "0^理算时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCompeUser() == null || "".equals(claimRequestInfo.getCompeUser())){
			returnStr = "0^理算人员代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getVericTime() == null || "".equals(claimRequestInfo.getVericTime())){
			returnStr = "0^核赔时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getVericUser() == null || "".equals(claimRequestInfo.getVericUser())){
			returnStr = "0^核赔人员代码不能为空";
			return returnStr;
		}
		
		if(claimRequestInfo.getClaimAppDto() == null || claimRequestInfo.getClaimAppDto().length == 0){
			returnStr = "0^索赔申请人信息不能为空";
			return returnStr;
		}else{
			ClaimAppDto[] claimAppDtos = claimRequestInfo.getClaimAppDto();
			ClaimAppDto claimApp = null;
			for(int i=0;i<claimAppDtos.length;i++){
				if(claimAppDtos[i] != null){
					claimApp = claimAppDtos[i];
					if(claimApp.getAcciName()==null || "".equals(claimApp.getAcciName())){
						returnStr = "0^索赔申请人信息中的姓名不能为空";
						return returnStr;
					}
					if(claimApp.getIdentifyNumber()==null || "".equals(claimApp.getIdentifyNumber())){
						returnStr = "0^索赔申请人信息中的身份证号码不能为空";
						return returnStr;
					}
					if(claimApp.getRelationCode()==null || "".equals(claimApp.getRelationCode())){
						returnStr = "0^索赔申请人信息中的与事故者关系不能为空";
						return returnStr;
					}else{
						String relationCode = "1,2,3";
						if(!relationCode.contains(claimApp.getRelationCode())){
							returnStr = "0^索赔申请人信息中的与事故者关系不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^索赔申请人信息不能为空";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getClaimKindDto() == null || claimRequestInfo.getClaimKindDto().length == 0){
			returnStr = "0^立案险别估损金额信息不能为空";
			return returnStr;
		}else{
			ClaimKindDto[] claimKindDtos = claimRequestInfo.getClaimKindDto();
			ClaimKindDto claimKind = null;
			for(int i=0;i<claimKindDtos.length;i++){
				if(claimKindDtos[i] != null){
					claimKind = claimKindDtos[i];
					if(claimKind.getFamilyName()==null || "".equals(claimKind.getFamilyName())){
						returnStr = "0^立案估损金额信息中的事故者名称不能为空";
						return returnStr;
					}
					if(claimKind.getKindCode()==null || "".equals(claimKind.getKindCode())){
						returnStr = "0^立案估损金额信息中的险别代码不能为空";
						return returnStr;
					}
					if(claimKind.getKindName()==null || "".equals(claimKind.getKindName())){
						returnStr = "0^立案估损金额信息中的险别名称不能为空";
						return returnStr;
					}
					if(claimKind.getCurrency()==null || "".equals(claimKind.getCurrency())){
						returnStr = "0^立案估损金额信息中的币别代码不能为空";
						return returnStr;
					}
					if(claimKind.getLossFeeType()==null || "".equals(claimKind.getLossFeeType())){
						returnStr = "0^立案估损金额信息中的类别不能为空";
						return returnStr;
					}else{
						String lossFeeType = "P,Z";
						if(!lossFeeType.contains(claimKind.getLossFeeType())){
							returnStr = "0^立案估损金额信息中的类别不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^立案估损金额信息不能为空";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getCompeFeeInfoDto() == null || claimRequestInfo.getCompeFeeInfoDto().length == 0){
			returnStr = "0^计算书费用信息不能为空";
			return returnStr;
		}else{
			CompeFeeInfoDto[] compeFeeDtos = claimRequestInfo.getCompeFeeInfoDto();
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					if(compeFee.getKindCode()==null || "".equals(compeFee.getKindCode())){
						returnStr = "0^计算书费用信息中的险别代码不能为空";
						return returnStr;
					}
					if(compeFee.getKindName()==null || "".equals(compeFee.getKindName())){
						returnStr = "0^计算书费用信息中的险别名称不能为空";
						return returnStr;
					}
					if(compeFee.getCurrency()==null || "".equals(compeFee.getCurrency())){
						returnStr = "0^计算书费用信息中的币别代码不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^计算书费用信息不能为空";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getNotion() == null || "".equals(claimRequestInfo.getNotion())){
			returnStr = "0^核赔审批片语不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getHandleText() == null || "".equals(claimRequestInfo.getHandleText())){
			returnStr = "0^核赔签署审批意见不能为空";
			return returnStr;
		}
		
		
		SchedExtInfoDto[] schedExtDtos = claimRequestInfo.getSchedExtInfoDto();
		if(schedExtDtos != null && schedExtDtos.length>0){
			SchedExtInfoDto schedExt = null;
			for(int i=0;i<schedExtDtos.length;i++){
				if(schedExtDtos[i] != null){
					schedExt = schedExtDtos[i];
					if(schedExt.getOperatorCode()==null || "".equals(schedExt.getOperatorCode())){
						returnStr = "0^补充说明信息中的操作人不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^补充说明信息不能为空";
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
						returnStr = "0^单证信息中的单证类型不能为空";
						return returnStr;
					}else{
						String typeCode = "102,105,A001,A002,A004,A006,B003,B004,B005,B038," +
								"B039,B095,B40,C006,C008,C024,C027,C028,C052,C075,C076,Z001";
						if(!typeCode.contains(certify.getTypeCode())){
							returnStr = "0^单证信息中的单证类型不合法";
							return returnStr;
						}
					}
					if(certify.getTypeName()==null || "".equals(certify.getTypeName())){
						returnStr = "0^单证信息中的单证清单名称不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^单证信息不能为空";
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
						returnStr = "0^费用信息中的费用代码不能为空";
						return returnStr;
					}else{
						String chargeCode = "03,04,05,07,13,14,15,99";
						if(!chargeCode.contains(prepayFee.getChargeCode())){
							returnStr = "0^费用信息中的费用代码不合法";
							return returnStr;
						}
					}
					if(prepayFee.getChargeName()==null || "".equals(prepayFee.getChargeName())){
						returnStr = "0^费用信息中的费用名称不能为空";
						return returnStr;
					}else{
						String chargeName = "施救费,查勘费,诉讼法,检验鉴定费,公估费,系统内代查勘,律师费,其他";
						if(!chargeName.contains(prepayFee.getChargeName())){
							returnStr = "0^费用信息中的费用名称不合法";
							return returnStr;
						}
					}
					if(prepayFee.getCurrency()==null || "".equals(prepayFee.getCurrency())){
						returnStr = "0^费用信息中的币别代码不能为空";
						return returnStr;
					}
					if(prepayFee.getKindCode()==null || "".equals(prepayFee.getKindCode())){
						returnStr = "0^费用信息中的险别代码不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^费用信息不能为空";
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
						returnStr = "0^计算书赔款费用信息中的险别代码不能为空";
						return returnStr;
					}
					if(compePayFee.getKindName()==null || "".equals(compePayFee.getKindName())){
						returnStr = "0^计算书赔款费用信息中的险别名称不能为空";
						return returnStr;
					}
					if(compePayFee.getCodeCName()==null || "".equals(compePayFee.getCodeCName())){
						returnStr = "0^计算书赔款费用信息中的费用名称不能为空";
						return returnStr;
					}else{
						String codeCName = "施救费,查勘费,诉讼费,检验鉴定费,公估费,系统内代查勘,律师费,其他";
						if(!codeCName.contains(compePayFee.getCodeCName())){
							returnStr = "0^计算书赔款费用信息中的费用名称不合法";
							return returnStr;
						}
					}
					if(compePayFee.getCodeCode()==null || "".equals(compePayFee.getCodeCode())){
						returnStr = "0^计算书赔款费用信息中的费用代码不能为空";
						return returnStr;
					}else{
						String codeCode = "03,04,05,07,13,14,15,99";
						if(!codeCode.contains(compePayFee.getCodeCode())){
							returnStr = "0^计算书赔款费用信息中的费用代码不合法";
							return returnStr;
						}
					}
					/*if(compePayFee.getCheckDeptName()==null || "".equals(compePayFee.getCheckDeptName())){
						returnStr = "0^计算书赔款费用信息中的代查勘机构不能为空";
						return returnStr;
					}*/
					if(compePayFee.getCurrency()==null || "".equals(compePayFee.getCurrency())){
						returnStr = "0^计算书赔款费用信息中的币别代码不能为空";
						return returnStr;
					}
					if(compePayFee.getCurrencyName()==null || "".equals(compePayFee.getCurrencyName())){
						returnStr = "0^计算书赔款费用信息中的币别名称不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^计算书赔款费用信息不能为空";
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
						returnStr = "0^计算书理算清单信息中的报案号不能为空";
						return returnStr;
					}
					if(compeInvMain.getClaimNo()==null || "".equals(compeInvMain.getClaimNo())){
						returnStr = "0^计算书理算清单信息中的立案号不能为空";
						return returnStr;
					}
					
					CompeInvDetailInfo[] compeInvDetailInfos = compeInvMain.getCompeInvDetailInfo();
					if(compeInvDetailInfos!=null && compeInvDetailInfos.length>0){
						CompeInvDetailInfo compeInvDetail = null;
						for(int j=0;j<compeInvDetailInfos.length;j++){
							if(compeInvDetailInfos[j] != null){
								compeInvDetail = compeInvDetailInfos[j];
								if(compeInvDetail.getName()==null || "".equals(compeInvDetail.getName())){
									returnStr = "0^计算书理算清单明细信息中的被保险人不能为空";
									return returnStr;
								}
								if(compeInvDetail.getMedicalCard()==null || "".equals(compeInvDetail.getMedicalCard())){
									returnStr = "0^计算书理算清单明细信息中的医保编号不能为空";
									return returnStr;
								}
								if(compeInvDetail.getIdCard()==null || "".equals(compeInvDetail.getIdCard())){
									returnStr = "0^计算书理算清单明细信息中的身份证号码不能为空";
									return returnStr;
								}if(compeInvDetail.getMedicalFamily()==null || "".equals(compeInvDetail.getMedicalFamily())){
									returnStr = "0^计算书理算清单明细信息中的户名不能为空";
									return returnStr;
								}
								if(compeInvDetail.getBank()==null || "".equals(compeInvDetail.getBank())){
									returnStr = "0^计算书理算清单明细信息中的开户行不能为空";
									return returnStr;
								}
								if(compeInvDetail.getCreditCard()==null || "".equals(compeInvDetail.getCreditCard())){
									returnStr = "0^计算书理算清单明细信息中的银行账户不能为空";
									return returnStr;
								}
							}
						}
					}
				}
			}
		}
		
		//判断出险人信息是否为空  这个是处理数组的如果以后有多个出险人的情况 将此注释解开即可
		InjuryPersonInfoDto injuryPersonDto = claimRequestInfo.getInjuryPersonInfoDto();
		if(injuryPersonDto != null){
			if(injuryPersonDto.getAcciName()==null || "".equals(injuryPersonDto.getAcciName())){
				returnStr = "0^具体出险人姓名不能为空";
				return returnStr;
			}
			if(injuryPersonDto.getIdentifyNumber()==null || "".equals(injuryPersonDto.getIdentifyNumber())){
				returnStr = "0^具体出险人身份证号码不能为空";
				return returnStr;
			}
			if(injuryPersonDto.getSex()==null || "".equals(injuryPersonDto.getSex())){
				returnStr = "0^具体出险人性别不能为空";
				return returnStr;
			}
		}else{
			returnStr ="0^具体出险人明细信息不能为空";
			return returnStr;
		}
		return returnStr;
	}
	
	
	
	/**
	 * 非空字段的非空性校验，若有不满足条件的字段属性，返回提示：0^某属性不能为空
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkRegistNotNullFiels(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == claimRequestInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(claimRequestInfo.getPolicyno() == null || "".equals(claimRequestInfo.getPolicyno())){
			returnStr = "0^保单号不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOutRigstNo() == null || "".equals(claimRequestInfo.getOutRigstNo())){
			returnStr = "0^客户端报案流水号不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartDate() == null || "".equals(claimRequestInfo.getDamageStartDate())){
			returnStr = "0^事故日期不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartHour() == null || "".equals(claimRequestInfo.getDamageStartHour())){
			returnStr = "0^事故时分秒不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageCode() == null || "".equals(claimRequestInfo.getDamageCode())){
			returnStr = "0^事故原因不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportDate() == null || "".equals(claimRequestInfo.getReportDate())){
			returnStr = "0^报案时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportHour() == null || "".equals(claimRequestInfo.getReportHour())){
			returnStr = "0^报案时分秒不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportType() == null || "".equals(claimRequestInfo.getReportType())){
			returnStr = "0^报案方式不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getLinkerName() == null || "".equals(claimRequestInfo.getLinkerName())){
			returnStr = "0^联系人不能为空";
			return returnStr;
		}
//		if(claimRequestInfo.getPhoneNumber() == null || "".equals(claimRequestInfo.getPhoneNumber())){
//			returnStr = "0^联系电话不能为空";
//			return returnStr;
//		}
		if(claimRequestInfo.getClauseType() == null || "".equals(claimRequestInfo.getClauseType())){
			returnStr = "0^与事故者关系不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageAddress() == null || "".equals(claimRequestInfo.getDamageAddress())){
			returnStr = "0^事故地点不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeCode() == null || "".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^事故类型不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorCode() == null || "".equals(claimRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorName() == null || "".equals(claimRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getMakeCom() == null || "".equals(claimRequestInfo.getMakeCom())){
			returnStr = "0^理赔处理机构不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getMakeComName() == null || "".equals(claimRequestInfo.getMakeComName())){
			returnStr = "0^理赔处理机构名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCurrency() == null || "".equals(claimRequestInfo.getCurrency())){
			returnStr = "0^币别不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeName() == null || "".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^事故类型名称不能为空";
			return returnStr;
		}
		
		if(claimRequestInfo.getRegistTime() == null || "".equals(claimRequestInfo.getRegistTime())){
			returnStr = "0^报案环节操作时间不能为空";
			return returnStr;
		}
		
		if(claimRequestInfo.getRegistUser() == null || "".equals(claimRequestInfo.getRegistUser())){
			returnStr = "0^报案操作人员代码不能为空";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 非空字段的非空性校验，若有不满足条件的字段属性，返回提示：0^某属性不能为空
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkCompeNotNullFiels(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		if(null == claimRequestInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(claimRequestInfo.getPolicyno() == null || "".equals(claimRequestInfo.getPolicyno())){
			returnStr = "0^保单号不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOutRigstNo() == null || "".equals(claimRequestInfo.getOutRigstNo())){
			returnStr = "0^客户端报案流水号不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartDate() == null || "".equals(claimRequestInfo.getDamageStartDate())){
			returnStr = "0^事故日期不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageStartHour() == null || "".equals(claimRequestInfo.getDamageStartHour())){
			returnStr = "0^事故时分秒不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageCode() == null || "".equals(claimRequestInfo.getDamageCode())){
			returnStr = "0^事故原因不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportDate() == null || "".equals(claimRequestInfo.getReportDate())){
			returnStr = "0^报案时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportHour() == null || "".equals(claimRequestInfo.getReportHour())){
			returnStr = "0^报案时分秒不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReportType() == null || "".equals(claimRequestInfo.getReportType())){
			returnStr = "0^报案方式不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getLinkerName() == null || "".equals(claimRequestInfo.getLinkerName())){
			returnStr = "0^联系人不能为空";
			return returnStr;
		}
//		if(claimRequestInfo.getPhoneNumber() == null || "".equals(claimRequestInfo.getPhoneNumber())){
//			returnStr = "0^联系电话不能为空";
//			return returnStr;
//		}
		if(claimRequestInfo.getClauseType() == null || "".equals(claimRequestInfo.getClauseType())){
			returnStr = "0^与事故者关系不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageAddress() == null || "".equals(claimRequestInfo.getDamageAddress())){
			returnStr = "0^事故地点不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeCode() == null || "".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^事故类型不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorCode() == null || "".equals(claimRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getOperatorName() == null || "".equals(claimRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getMakeCom() == null || "".equals(claimRequestInfo.getMakeCom())){
			returnStr = "0^理赔处理机构不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getMakeComName() == null || "".equals(claimRequestInfo.getMakeComName())){
			returnStr = "0^理赔处理机构名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getScheduleObjectId() == null || "".equals(claimRequestInfo.getScheduleObjectId())){
			returnStr = "0^调度查勘处理机构不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckSite() == null || "".equals(claimRequestInfo.getCheckSite())){
			returnStr = "0^查勘地址不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckType() == null || "".equals(claimRequestInfo.getCheckType())){
			returnStr = "0^查勘类型不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckDate() == null || "".equals(claimRequestInfo.getCheckDate())){
			returnStr = "0^查勘日期不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckNature() == null || "".equals(claimRequestInfo.getCheckNature())){
			returnStr = "0^查勘性质不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getUnitType() == null || "".equals(claimRequestInfo.getUnitType())){
			returnStr = "0^查勘处理单位不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCheckContext() == null || "".equals(claimRequestInfo.getCheckContext())){
			returnStr = "0^查勘报告不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCurrency() == null || "".equals(claimRequestInfo.getCurrency())){
			returnStr = "0^币别不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getDamageTypeName() == null || "".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^事故类型名称不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getReplevyFlag() == null || "".equals(claimRequestInfo.getReplevyFlag())){
			returnStr = "0^是否可能有追偿不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getThirdComFlag() == null || "".equals(claimRequestInfo.getThirdComFlag())){
			returnStr = "0^是否有其他理赔中介不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getClaimType() == null || "".equals(claimRequestInfo.getClaimType())){
			returnStr = "0^案件类型代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getRegistTime() == null || "".equals(claimRequestInfo.getRegistTime())){
			returnStr = "0^报案时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getRegistUser() == null || "".equals(claimRequestInfo.getRegistUser())){
			returnStr = "0^报案人员代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCompeTime() == null || "".equals(claimRequestInfo.getCompeTime())){
			returnStr = "0^理算时间不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getCompeUser() == null || "".equals(claimRequestInfo.getCompeUser())){
			returnStr = "0^理算人员代码不能为空";
			return returnStr;
		}
		if(claimRequestInfo.getClaimAppDto() == null || claimRequestInfo.getClaimAppDto().length == 0){
			returnStr = "0^索赔申请人信息不能为空";
			return returnStr;
		}else{
			ClaimAppDto[] claimAppDtos = claimRequestInfo.getClaimAppDto();
			ClaimAppDto claimApp = null;
			for(int i=0;i<claimAppDtos.length;i++){
				if(claimAppDtos[i] != null){
					claimApp = claimAppDtos[i];
					if(claimApp.getAcciName()==null || "".equals(claimApp.getAcciName())){
						returnStr = "0^索赔申请人信息中的姓名不能为空";
						return returnStr;
					}
					if(claimApp.getIdentifyNumber()==null || "".equals(claimApp.getIdentifyNumber())){
						returnStr = "0^索赔申请人信息中的身份证号码不能为空";
						return returnStr;
					}
					if(claimApp.getRelationCode()==null || "".equals(claimApp.getRelationCode())){
						returnStr = "0^索赔申请人信息中的与事故者关系不能为空";
						return returnStr;
					}else{
						String relationCode = "1,2,3";
						if(!relationCode.contains(claimApp.getRelationCode())){
							returnStr = "0^索赔申请人信息中的与事故者关系不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^索赔申请人信息不能为空";
					return returnStr;
				}
			}
		}
		if(claimRequestInfo.getClaimKindDto() == null || claimRequestInfo.getClaimKindDto().length == 0){
			returnStr = "0^立案险别估损金额信息不能为空";
			return returnStr;
		}else{
			ClaimKindDto[] claimKindDtos = claimRequestInfo.getClaimKindDto();
			ClaimKindDto claimKind = null;
			for(int i=0;i<claimKindDtos.length;i++){
				if(claimKindDtos[i] != null){
					claimKind = claimKindDtos[i];
					if(claimKind.getFamilyName()==null || "".equals(claimKind.getFamilyName())){
						returnStr = "0^立案估损金额信息中的事故者名称不能为空";
						return returnStr;
					}
					if(claimKind.getKindCode()==null || "".equals(claimKind.getKindCode())){
						returnStr = "0^立案估损金额信息中的险别代码不能为空";
						return returnStr;
					}
					if(claimKind.getKindName()==null || "".equals(claimKind.getKindName())){
						returnStr = "0^立案估损金额信息中的险别名称不能为空";
						return returnStr;
					}
					if(claimKind.getCurrency()==null || "".equals(claimKind.getCurrency())){
						returnStr = "0^立案估损金额信息中的币别代码不能为空";
						return returnStr;
					}
					if(claimKind.getLossFeeType()==null || "".equals(claimKind.getLossFeeType())){
						returnStr = "0^立案估损金额信息中的类别不能为空";
						return returnStr;
					}else{
						String lossFeeType = "P,Z";
						if(!lossFeeType.contains(claimKind.getLossFeeType())){
							returnStr = "0^立案估损金额信息中的类别不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^立案估损金额信息不能为空";
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
						returnStr = "0^补充说明信息中的操作人不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^补充说明信息不能为空";
					return returnStr;
				}
			}
		}
		
		//判断出险人信息是否为空
		InjuryPersonInfoDto[] injuryPersonInfoDto = claimRequestInfo.getInjuryPersonInfoArrayDto();
		if(injuryPersonInfoDto != null && injuryPersonInfoDto.length>0){
			InjuryPersonInfoDto injuryPersonInfo = null;
			for(int i=0;i<injuryPersonInfoDto.length;i++){
				if(injuryPersonInfoDto[i] != null){
					injuryPersonInfo = injuryPersonInfoDto[i];
					if(injuryPersonInfo.getAcciName()==null || "".equals(injuryPersonInfo.getAcciName())){
						returnStr = "0^具体出险人姓名不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^具体出险人明细信息不能为空";
					return returnStr;
				}
			}
		}
		
		return returnStr;
	}
	
	/**
	 * 标志位字段的范围校验，若有不满足条件的字段属性，返回提示：0^某属性数据不合法
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkFlagFieldsRange(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(claimRequestInfo.getDamageCode())){
			returnStr = "0^事故原因不合法";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(claimRequestInfo.getReportType())){
			returnStr = "0^报案方式不合法";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(claimRequestInfo.getClauseType())){
			returnStr = "0^与事故者关系不合法";
			return returnStr;
		}
		if(!"999".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^事故类型不合法";
			return returnStr;
		}
		String currency="HKD,DEM,DKK,GBP,ECU,USD,ESP,EUR,FIM,FRF,NLG,NOK,NTD,NZD,HPH,SDR,SEK,SGD,ITL,JPY,MOP,MYR,THB,AUD,BEF,ATS,CNY,ASF,CAD,CHF";
		if(!currency.contains(claimRequestInfo.getCurrency())){
			returnStr = "0^币别不合法";
			return returnStr;
		}
		if(!"其它".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^事故类型名称不合法";
			return returnStr;
		}
		String claimType = "0,1,5,7,8,B";
		if(!claimType.contains(claimRequestInfo.getClaimType())){
			returnStr = "0^案件类型代码不合法";
			return returnStr;
		}
		String caseType = "5,7,8";
		if(!caseType.contains(claimRequestInfo.getCaseType())){
			returnStr = "0^赔案类型不合法";
			return returnStr;
		}
		String notion = "01,02,03,04,05";
		if(!notion.contains(claimRequestInfo.getNotion())){
			returnStr = "0^审批片语不合法";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 标志位字段的范围校验，若有不满足条件的字段属性，返回提示：0^某属性数据不合法
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkRegistFlagFieldsRange(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(claimRequestInfo.getDamageCode())){
			returnStr = "0^事故原因不合法";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(claimRequestInfo.getReportType())){
			returnStr = "0^报案方式不合法";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(claimRequestInfo.getClauseType())){
			returnStr = "0^与事故者关系不合法";
			return returnStr;
		}
		if(!"999".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^事故类型不合法";
			return returnStr;
		}
		String currency="HKD,DEM,DKK,GBP,ECU,USD,ESP,EUR,FIM,FRF,NLG,NOK,NTD,NZD,HPH,SDR,SEK,SGD,ITL,JPY,MOP,MYR,THB,AUD,BEF,ATS,CNY,ASF,CAD,CHF";
		if(!currency.contains(claimRequestInfo.getCurrency())){
			returnStr = "0^币别不合法";
			return returnStr;
		}
		if(!"其它".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^事故类型名称不合法";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 标志位字段的范围校验，若有不满足条件的字段属性，返回提示：0^某属性数据不合法
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkCompeFlagFieldsRange(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		
		String damageCode = "3b8,150";
		if(!damageCode.contains(claimRequestInfo.getDamageCode())){
			returnStr = "0^事故原因不合法";
			return returnStr;
		}
		String reportType = "10,11,99";
		if(!reportType.contains(claimRequestInfo.getReportType())){
			returnStr = "0^报案方式不合法";
			return returnStr;
		}
		String clauseType = "1,2,3";
		if(!clauseType.contains(claimRequestInfo.getClauseType())){
			returnStr = "0^与事故者关系不合法";
			return returnStr;
		}
		if(!"999".equals(claimRequestInfo.getDamageTypeCode())){
			returnStr = "0^事故类型不合法";
			return returnStr;
		}
		String currency="HKD,DEM,DKK,GBP,ECU,USD,ESP,EUR,FIM,FRF,NLG,NOK,NTD,NZD,HPH,SDR,SEK,SGD,ITL,JPY,MOP,MYR,THB,AUD,BEF,ATS,CNY,ASF,CAD,CHF";
		if(!currency.contains(claimRequestInfo.getCurrency())){
			returnStr = "0^币别不合法";
			return returnStr;
		}
		if(!"其它".equals(claimRequestInfo.getDamageTypeName())){
			returnStr = "0^事故类型名称不合法";
			return returnStr;
		}
		String claimType = "0,1,5,7,8,B";
		if(!claimType.contains(claimRequestInfo.getClaimType())){
			returnStr = "0^案件类型代码不合法";
			return returnStr;
		}
		String caseType = "5,7,8";
		if(!caseType.contains(claimRequestInfo.getCaseType())){
			returnStr = "0^赔案类型不合法";
			return returnStr;
		}
		String notion = "01,02,03,04,05";
		if(!notion.contains(claimRequestInfo.getNotion())){
			returnStr = "0^审批片语不合法";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 校验外部outId是否在中间表中存在，已经存在的话返回流程信息
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
					returnStr = "2^该数据已经交互过理赔系统核赔结案接口，不可重复交互";
					return returnStr;
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * 校验外部outId是否在中间表中存在，已经存在的话返回流程信息
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
					returnStr = "2^该数据已经交互过理赔系统报案接口，不可重复交互";
					return returnStr;
				}	
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getCompeAutoFlag())){
					returnStr = "1^该数据已经交互过理赔系统立案接口，不可交互报案接口";
					return returnStr;
				}
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getClaimAutoFlag())){
					returnStr = "1^该数据已经交互过理赔系统核赔结案接口，不可交互报案接口";
					return returnStr;
				}
			}
		}
		return returnStr;
	}
	
	/**
	 * 校验外部outId是否在中间表中存在，已经存在的话返回流程信息
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
					returnStr = "2^该数据已经交互过理赔系统理算接口,不可重复交互";
					return returnStr;
				}
				if(prpLinterRequestDto != null && "1".equals(prpLinterRequestDto.getClaimAutoFlag())){
					returnStr = "2^该数据已经交互过理赔系统核赔结案接口,不可交互核赔接口";
					return returnStr;
				}
			}
		}
		ArrayList interRequest = (ArrayList)blPrpLinterRequestFacade.findByConditions(" OutRigstNo='"+claimRequestInfo.getOutRigstNo()+"' ");
		if(interRequest!=null&&interRequest.size()>1){
			returnStr = "2^该数据交互过理赔系统多次（1次以上）";
			return returnStr;
		}
		return returnStr;
	}
	
	/**
	 * 判断业务单号的有效性校验（保单号码是否有效），返回提示：0^保单信息不存在
	 * 判断事故时间，不在有效期之内，返回提示：0^事故时间不在保单有效期内
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
		// 查询保单信息
		EndorseViewHelper endorseViewHelper = new EndorseViewHelper();
		PolicyDto policyDto = endorseViewHelper.findForEndorBefore(policyNo,damageDate, damageHour);
		if(policyDto == null || policyDto.getPrpCmainDto()==null){
			returnStr = "0^保单信息不存在";
			return returnStr;
		}
		PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
		if(claimRequestInfo.getDamageStartDate().before(prpCmainDto.getStartDate()) 
				|| claimRequestInfo.getDamageStartDate().after(prpCmainDto.getEndDate())){
			returnStr = "0^事故时间不在保单有效期内";
			return returnStr;
		}

		return returnStr;
	}
	
	/**
	 * 金额合法性校验，返回提示：0^***不合法
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception  
	 */
	public String checkLegalityOfFees(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		/** --立案  sumClaim = Σ(claimkindDto.sumClaim) */
		//判断立案估损金额是否等于子对象的预计给付金额之和
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
				returnStr = "0^立案估损金额不等于子对象的预计给付金额之和";
				return returnStr;
			}
		}
		
		/** --理赔   sumNoDutyFee = Σ(compepayfeeinfodto.chargeAmount)
	             	sumThisPaid = Σ(compeFeeinfodto.sumrealpay)
	             	prplcompensatesumpaid = sumNoDutyFee + sumThisPaid  */
		//判断费用合计是否等于子对象的费用金额之和
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
				returnStr = "0^费用合计不等于子对象的费用金额之和";
				return returnStr;
			}
		}
		//判断本次给付金额是否等于子对象的给付金额之和
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
				returnStr = "0^本次给付金额不等于子对象的给付金额之和";
				return returnStr;
			}
		}
		//判断赔款合计是否等于费用合计与本次给付金额之和
		if(claimRequestInfo.getPrplCompensateSumPaid() != claimRequestInfo.getSumNoDutyFee() + claimRequestInfo.getSumThisPaid()){
			returnStr = "0^赔款合计不等于费用合计与本次给付金额之和";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 金额合法性校验，返回提示：0^***不合法
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception  
	 */
	public String checkCompeLegalityOfFees(ClaimRequestInfo claimRequestInfo) throws Exception{
		String returnStr = "";
		/** --立案  sumClaim = Σ(claimkindDto.sumClaim) */
		//判断立案估损金额是否等于子对象的预计给付金额之和
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
				returnStr = "0^立案估损金额不等于子对象的预计给付金额之和";
				return returnStr;
			}
		}
		
		/** --理赔   sumNoDutyFee = Σ(compepayfeeinfodto.chargeAmount)
	             	sumThisPaid = Σ(compeFeeinfodto.sumrealpay)
	             	prplcompensatesumpaid = sumNoDutyFee + sumThisPaid  */
		//判断费用合计是否等于子对象的费用金额之和
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
				returnStr = "0^费用合计不等于子对象的费用金额之和";
				return returnStr;
			}
		}
		//判断本次给付金额是否等于子对象的给付金额之和
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
				returnStr = "0^本次给付金额不等于子对象的给付金额之和";
				return returnStr;
			}
		}
		//判断赔款合计是否等于费用合计与本次给付金额之和
		if(claimRequestInfo.getPrplCompensateSumPaid() != claimRequestInfo.getSumNoDutyFee() + claimRequestInfo.getSumThisPaid()){
			returnStr = "0^赔款合计不等于费用合计与本次给付金额之和";
			return returnStr;
		}
		
		return returnStr;
	}
	
	/**
	 * 判断操作人代码、理赔处理机构、调度查勘处理机构是否合法，若不合法，返回提示：0^***不合法
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
    			returnStr = "0^操作人代码不合法";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^理赔处理机构不合法";
    			return returnStr;
    		}
    		
    		PrpDcompanyDto prpDcompany = dbPrpDcompany.findByPrimaryKey(scheduleObjectId);
    		if(prpDcompany == null){
    			returnStr = "0^调度查勘处理单位不合法";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto1 = dbPrpDuser.findByPrimaryKey(registUser);
    		if(prpDuserDto1==null){
    			returnStr = "0^报案人员代码不合法";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto2 = dbPrpDuser.findByPrimaryKey(compeUser);
    		if(prpDuserDto2==null){
    			returnStr = "0^理算人员代码不合法";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto3 = dbPrpDuser.findByPrimaryKey(vericUser);
    		if(prpDuserDto3==null){
    			returnStr = "0^核赔人员代码不合法";
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
	 * 判断操作人代码、理赔处理机构、调度查勘处理机构是否合法，若不合法，返回提示：0^***不合法
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
    			returnStr = "0^操作人代码不合法";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^理赔处理机构不合法";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto1 = dbPrpDuser.findByPrimaryKey(registUser);
    		if(prpDuserDto1 == null){
    			returnStr = "0^报案操作人代码不合法";
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
	 * 判断操作人代码、理赔处理机构、调度查勘处理机构是否合法，若不合法，返回提示：0^***不合法
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
    			returnStr = "0^操作人代码不合法";
    			return returnStr;
    		}
    		
    		DBPrpDcompany dbPrpDcompany = new DBPrpDcompany(dbManager);
    		PrpDcompanyDto prpDcompanyDto = dbPrpDcompany.findByPrimaryKey(makeCom);
    		if(prpDcompanyDto==null){
    			returnStr = "0^理赔处理机构不合法";
    			return returnStr;
    		}
    		
    		PrpDcompanyDto prpDcompany = dbPrpDcompany.findByPrimaryKey(scheduleObjectId);
    		if(prpDcompany == null){
    			returnStr = "0^调度查勘处理单位不合法";
    			return returnStr;
    		}
    		PrpDuserDto prpDuserDto1 = dbPrpDuser.findByPrimaryKey(registUser);
    		if(prpDuserDto1 == null){
    			returnStr = "0^报案操作人代码不合法";
    			return returnStr;
    		}
    		
    		PrpDuserDto prpDuserDto2 = dbPrpDuser.findByPrimaryKey(compeUser);
    		if(prpDuserDto2==null){
    			returnStr = "0^理算人员代码不合法";
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
	 * 判断操作人代码、理赔处理机构、调度查勘处理机构是否合法，若不合法，返回提示：0^***不合法
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
        	   returnStr = "0^报案操作时间小于当前月第一天不能同步";
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
	 * 判断操作人代码、理赔处理机构、调度查勘处理机构是否合法，若不合法，返回提示：0^***不合法
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
        	   returnStr = "0^立案操作时间小于当前月第一天不能同步";
     		   return returnStr;
           }
           if(interRequest!=null&&interRequest.size()>0){
        	   PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)interRequest.get(0);
           }else{
        	  int registFlag =  PubTools.compareDate(RegistTime.toString(), iEndDate);
        	  if(registFlag>0){
           	   
              }else{
           	      returnStr = "0^报案操作时间小于当前月第一天不能同步";
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
	 * 判断操作人代码、理赔处理机构、调度查勘处理机构是否合法，若不合法，返回提示：0^***不合法
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
        	   returnStr = "0^核赔结案操作时间小于当前月第一天不能同步";
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
                	      returnStr = "0^立案操作时间小于当前月第一天不能同步";
             		  return returnStr;
                   }
        	   }
           }else{
        	  int registFlag =  PubTools.compareDate(RegistTime.toString(), iEndDate);
        	  if(registFlag>0){
           	   
              }else{
           	      returnStr = "0^报案操作时间小于当前月第一天不能同步";
        		  return returnStr;
              }
        	  int compeFlag =  PubTools.compareDate(CompeTime.toString(), iEndDate);
        	  if(compeFlag>0){
           	   
              }else{
           	      returnStr = "0^立案操作时间小于当前月第一天不能同步";
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
