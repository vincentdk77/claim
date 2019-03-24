package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.webservice.AccidentPersonInfoDto;
import com.sinosoft.claim.webservice.CertifyInfoDto;
import com.sinosoft.claim.webservice.ClaimAppDto;
import com.sinosoft.claim.webservice.ClaimRequestInfo;
import com.sinosoft.claim.webservice.CompeFeeInfoDto;
import com.sinosoft.claim.webservice.CompeInvDetailInfo;
import com.sinosoft.claim.webservice.CompeInvMainInfo;
import com.sinosoft.claim.webservice.CompePayFeeInfoDto;
import com.sinosoft.claim.webservice.InjuryPersonInfoDto;
import com.sinosoft.claim.webservice.ReCaseRequestInfo;
import com.sinosoft.claim.webservice.SchedExtInfoDto;
import com.sinosoft.prpall.pubfun.PubTools;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * �󲡽ӿ��ؿ��ⰸ��������ĺϷ���У����
 * 
 */
public class UIMedicalCheckDateBeforeClaimRecaseViewHelper {
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkBeforeClaim(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		/**
		 * ��һ����У��ǿ�
		 * �ڶ�����У��Ϸ���
		 * ��������outIDУ��
		 * �����������У��
		 */
		returnStr=checkNotNullFiels(reCaseRequestInfo);//�ǿ�У��
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkFlagFieldsRange(reCaseRequestInfo);//�Ϸ�У��
		}
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkExistenceOfOutId(reCaseRequestInfo);//outIDУ��
		}
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkLegalityOfFees(reCaseRequestInfo);//���У��
		}
		if("".equals(returnStr)||returnStr.length()<1){
			returnStr = checkClaimInputdate(reCaseRequestInfo);//����ʱ��У��
		}
		return returnStr;
	}
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkNotNullFiels(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		if(null == reCaseRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getOutId()==null||"".equals(reCaseRequestInfo.getOutId())){
			returnStr = "0^�ͻ���������������Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getRelationOutId()==null||"".equals(reCaseRequestInfo.getRelationOutId())){
			returnStr = "0^�ͻ������ݹ�����������Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getReClaimNotion()==null||"".equals(reCaseRequestInfo.getReClaimNotion())){
			returnStr = "0^�ؿ�����Ƭ�ﲻ��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getReClaimHandleText()==null||"".equals(reCaseRequestInfo.getReClaimHandleText())){
			returnStr = "0^�ؿ��ⰸ��������������Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getOperatorCode() == null || "".equals(reCaseRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getOperatorName() == null || "".equals(reCaseRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getMakeCom() == null || "".equals(reCaseRequestInfo.getMakeCom())){
			returnStr = "0^���⴦���������Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getMakeComName() == null || "".equals(reCaseRequestInfo.getMakeComName())){
			returnStr = "0^���⴦��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getApplyRecaseTime() == null || "".equals(reCaseRequestInfo.getApplyRecaseTime())){
			returnStr = "0^�ؿ��ⰸ����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getApplyRecaseUser() == null || "".equals(reCaseRequestInfo.getApplyRecaseUser())){
			returnStr = "0^�ؿ��ⰸ������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getAuditRecaseTime() == null || "".equals(reCaseRequestInfo.getAuditRecaseTime())){
			returnStr = "0^����ؿ��ⰸʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getAuditUser() == null || "".equals(reCaseRequestInfo.getAuditUser())){
			returnStr = "0^�����Ա���벻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getVericTime() == null || "".equals(reCaseRequestInfo.getVericTime())){
			returnStr = "0^����ͨ��ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getVericUser() == null || "".equals(reCaseRequestInfo.getVericUser())){
			returnStr = "0^������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getClaimAppDto() == null || reCaseRequestInfo.getClaimAppDto().length == 0){
			returnStr = "0^������������Ϣ����Ϊ��";
			return returnStr;
		}else{
			ClaimAppDto[] claimAppDtos = reCaseRequestInfo.getClaimAppDto();
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
		
		if(reCaseRequestInfo.getCompeFeeInfoDto() == null || reCaseRequestInfo.getCompeFeeInfoDto().length == 0){
			returnStr = "0^�����������Ϣ����Ϊ��";
			return returnStr;
		}else{
			CompeFeeInfoDto[] compeFeeDtos = reCaseRequestInfo.getCompeFeeInfoDto();
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
		if(reCaseRequestInfo.getNotion() == null || "".equals(reCaseRequestInfo.getNotion())){
			returnStr = "0^��������Ƭ�ﲻ��Ϊ��";
			return returnStr;
		}
		if(reCaseRequestInfo.getHandleText() == null || "".equals(reCaseRequestInfo.getHandleText())){
			returnStr = "0^����ǩ�������������Ϊ��";
			return returnStr;
		}
		
		SchedExtInfoDto[] schedExtDtos = reCaseRequestInfo.getSchedExtInfoDto();
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
		
		CertifyInfoDto[] certifyDtos = reCaseRequestInfo.getCertifyInfoDto();
		if(certifyDtos != null && certifyDtos.length >0){
			CertifyInfoDto certify = null;
			for(int i=0;i<certifyDtos.length;i++){
				if(certifyDtos[i] != null){
					certify = certifyDtos[i];
					if(certify.getTypeCode()==null || "".equals(certify.getTypeCode())){
						returnStr = "0^��֤��Ϣ�еĵ�֤���Ͳ���Ϊ��";
						return returnStr;
					}else{
						String typeCode = "0102,0105,A001,A002,A004,A006,B003,B004,B005,B038," +
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
		
		
		
		CompePayFeeInfoDto[] compePayFeeDtos = reCaseRequestInfo.getCompePayFeeInfoDto();
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
		
		CompeInvMainInfo[] compeInvMainDtos = reCaseRequestInfo.getCompeInvMainInfo();
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
		// �жϳ�������Ϣ�Ƿ�Ϊ��
		InjuryPersonInfoDto injuryPersonInfoDto = reCaseRequestInfo
				.getInjuryPersonInfoDto();
		if (injuryPersonInfoDto != null) {
			if (injuryPersonInfoDto.getAcciName() == null
					|| "".equals(injuryPersonInfoDto.getAcciName())) {
				returnStr = "0^�����������������Ϊ��";
				return returnStr;
			}
			if (injuryPersonInfoDto.getIdentifyNumber() == null
					|| "".equals(injuryPersonInfoDto.getIdentifyNumber())) {
				returnStr = "0^������������֤���벻��Ϊ��";
				return returnStr;
			}
			if (injuryPersonInfoDto.getSex() == null
					|| "".equals(injuryPersonInfoDto.getSex())) {
				returnStr = "0^����������Ա���Ϊ��";
				return returnStr;
			}
		} else {
			returnStr = "0^�����������ϸ��Ϣ����Ϊ��";
			return returnStr;
		}
		
		return returnStr;
	}
	/**
	 * ��־λ�ֶεķ�ΧУ�飬���в������������ֶ����ԣ�������ʾ��0^ĳ�������ݲ��Ϸ�
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkFlagFieldsRange(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		
		String notion = "01,02,03,04,05";
		if(!notion.contains(reCaseRequestInfo.getNotion())){
			returnStr = "0^����Ƭ�ﲻ�Ϸ�";
			return returnStr;
		}
		String zeroLossTypesString = "1,2,3";
		if(reCaseRequestInfo.getZeroLossType()!=null&&!"".equals(reCaseRequestInfo.getZeroLossType())&&!zeroLossTypesString.contains(reCaseRequestInfo.getZeroLossType())){
			returnStr = "0^���⸶ԭ�򲻺Ϸ�";
			return returnStr;
		}
		return returnStr;
	}
	
	/**
	 * У���ⲿoutId�Ƿ����м���д��ڣ���������ʾ������Ϣ
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkExistenceOfOutId(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		BLPrplinterAutoClaimDetailFacade blPrplinterAutoClaimDetailFacade = new BLPrplinterAutoClaimDetailFacade();
		Collection collection = 
			blPrpLinterRequestFacade.findByConditions(" OutId='"+reCaseRequestInfo.getRelationOutId()+"' ");
		if(collection == null||collection.isEmpty()){
			returnStr = "0^������δ����������ϵͳ";
			return returnStr;
		}else{
			PrpLinterRequestDto prpLinterRequestDto = (PrpLinterRequestDto)collection.iterator().next();
			String id = prpLinterRequestDto.getId();
			Collection claimDetailList = blPrplinterAutoClaimDetailFacade.findByConditions(" id='"+id+"' ");
			if(claimDetailList==null || claimDetailList.size()<1){
				returnStr = "0^��ذ���û�н᰸�������ؿ�";
				return returnStr;
			}
			PrplinterAutoClaimDetailDto prplinterAutoClaimDetailDto = (PrplinterAutoClaimDetailDto)claimDetailList.iterator().next();
			if(!prplinterAutoClaimDetailDto.getEndcaSuccFlag().equals("1")){
				returnStr = "0^��ذ���û�н᰸�������ؿ�";
				return returnStr;
			}
		}
		BLPrpLinterRecaseRequestFacade blPrpLinterRecaseRequestFacade = new BLPrpLinterRecaseRequestFacade();
		Collection collection2 = 
				blPrpLinterRecaseRequestFacade.findByConditions(" OutId='"+reCaseRequestInfo.getOutId()+"' ");
			if(collection2 != null){
				Iterator it = collection2.iterator();
				if(it.hasNext()){
					PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = (PrpLinterRecaseRequestDto)it.next();
					PrpLinterRecaseDetailDto prpLinterRecaseDetailDto= prpLinterRecaseRequestDto.getPrpLinterRecaseDetailDto();
					if(prpLinterRecaseDetailDto != null && prpLinterRecaseDetailDto.getEndcaSuccFlag() == "1"){
						returnStr = "2^�������Ѿ�����������ϵͳ�������ؿ��ⰸ�ɹ�";
						return returnStr;
					}else{
						returnStr = "2^�������Ѿ�����������ϵͳ�������ؿ��ⰸʧ��";
						return returnStr;
					}
				}
			}
		return returnStr;
	}
	
	
	
	/**
	 * ���Ϸ���У�飬������ʾ��0^***���Ϸ�
	 * @param reCaseRequestInfo
	 * @return String
	 * @throws Exception  
	 */
	public String checkLegalityOfFees(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		
		/** --����   sumNoDutyFee = ��(compepayfeeinfodto.chargeAmount)
	             	sumThisPaid = ��(compeFeeinfodto.sumrealpay)
	             	prplcompensatesumpaid = sumNoDutyFee + sumThisPaid  */
		//�жϷ��úϼ��Ƿ�����Ӷ���ķ��ý��֮��
		double sumNoDutyFee = 0.0;
		CompePayFeeInfoDto[] compePayFeeDtos = reCaseRequestInfo.getCompePayFeeInfoDto();
		if(compePayFeeDtos!=null && compePayFeeDtos.length>0){
			CompePayFeeInfoDto compePayFee = null;
			for(int i=0;i<compePayFeeDtos.length;i++){
				if(compePayFeeDtos[i] != null){
					compePayFee = compePayFeeDtos[i];
					sumNoDutyFee += compePayFee.getChargeAmount();
				}
			}
			if(reCaseRequestInfo.getSumNoDutyFee() != sumNoDutyFee){
				returnStr = "0^���úϼƲ������Ӷ���ķ��ý��֮��";
				return returnStr;
			}
		}
		//�жϱ��θ�������Ƿ�����Ӷ���ĸ������֮��
		double sumThisPaid = 0.0;
		CompeFeeInfoDto[] compeFeeDtos = reCaseRequestInfo.getCompeFeeInfoDto();
		if(compeFeeDtos!=null && compeFeeDtos.length>0){
			CompeFeeInfoDto compeFee = null;
			for(int i=0;i<compeFeeDtos.length;i++){
				if(compeFeeDtos[i] != null){
					compeFee = compeFeeDtos[i];
					sumThisPaid += compeFee.getSumRealPay();
				}
			}
			if(reCaseRequestInfo.getSumThisPaid() != sumThisPaid){
				returnStr = "0^���θ����������Ӷ���ĸ������֮��";
				return returnStr;
			}
		}
		//�ж����ϼ��Ƿ���ڷ��úϼ��뱾�θ������֮��
		if(reCaseRequestInfo.getPrplCompensateSumPaid() != reCaseRequestInfo.getSumNoDutyFee() + reCaseRequestInfo.getSumThisPaid()){
			returnStr = "0^���ϼƲ����ڷ��úϼ��뱾�θ������֮��";
			return returnStr;
		}
		
		return returnStr;
	}
	
	
	/**
	 * �жϺ��������Ƿ�Ϸ��������Ϸ���������ʾ��0^***���Ϸ�
	 * @param claimRequestInfo
	 * @return String
	 * @throws Exception
	 */
	public String checkClaimInputdate(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		String returnStr = "";
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		DateTime VericTime = new DateTime(reCaseRequestInfo.getVericTime(),DateTime.YEAR_TO_DAY);
		String outId = reCaseRequestInfo.getOutId();
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
            System.err.println("OutId="+reCaseRequestInfo.getOutId()+" ==VericTime==="+ VericTime.toString()+"iEndDate==="+iEndDate);  
           
            flag =  PubTools.compareDate(VericTime.toString(), iEndDate);
            if(flag>0){
        	   
            }else{
        	   returnStr = "0^����᰸����ʱ��С�ڵ�ǰ�µ�һ�첻��ͬ��";
     		   return returnStr;
            }
          
        }catch(Exception exception){
            throw exception;
        }finally{
           
        }
        return returnStr;
	}
}
