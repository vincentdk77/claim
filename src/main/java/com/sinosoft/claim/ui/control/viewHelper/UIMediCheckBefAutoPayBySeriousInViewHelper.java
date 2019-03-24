package com.sinosoft.claim.ui.control.viewHelper;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.sinosoft.claim.bl.facade.BLPrpJpayRefRecFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterPayRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrpLinterRecaseRequestFacade;
import com.sinosoft.claim.bl.facade.BLPrpLpaymainFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterAutoClaimDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterPayBackDetailFacade;
import com.sinosoft.claim.bl.facade.BLPrplinterrelationFacade;
import com.sinosoft.claim.dto.domain.PrpLinterPayDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLpaymainDto;
import com.sinosoft.claim.dto.domain.PrplinterAutoClaimDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterPayBackDetailDto;
import com.sinosoft.claim.dto.domain.PrplinterrelationDto;
import com.sinosoft.claim.webservice.DetelePayRequestInfo;
import com.sinosoft.claim.webservice.PayExtBySeriousInDto;
import com.sinosoft.claim.webservice.PayExtDto;
import com.sinosoft.claim.webservice.PayRequestBySeriousInInfo;
import com.sinosoft.claim.webservice.PayRequestBySeriousInInfo;
import com.sinosoft.claim.webservice.PayRequestBySeriousInInfo;
import com.sinosoft.claim.webservice.PaymentInfoBySeriousInDto;
import com.sinosoft.claim.webservice.PaymentInfoDto;

/**
 * �ӿڴ�������ĺϷ���У����
 * 
 * */
public class UIMediCheckBefAutoPayBySeriousInViewHelper {
	/**
	 * �ӿڴ�������ĺϷ���У��
	 * @param payRequestBySeriousInInfo
	 * 
	 * */
	public String checkBeforePay(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullFields(payRequestBySeriousInInfo);
		
		return returnStr;
	}
	
	/**
	 * �ǿ��ֶεķǿ���У�飬���в������������ֶ����ԣ�������ʾ��0^ĳ���Բ���Ϊ��
	 * @param payRequestBySeriousInInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkNotNullFields(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception{
		String returnStr = "";
		if(null == payRequestBySeriousInInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(payRequestBySeriousInInfo.getOutId()==null || "".equals(payRequestBySeriousInInfo.getOutId())){
			returnStr = "0^�ͻ���������������Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getOperateType()==null || "".equals(payRequestBySeriousInInfo.getOperateType())){
			returnStr = "0^�������Ͳ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getReceiverTypeOther()==null || "".equals(payRequestBySeriousInInfo.getReceiverTypeOther())){
			returnStr = "0^��������ʹ��벻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getReceiverTypeOtherName()==null || "".equals(payRequestBySeriousInInfo.getReceiverTypeOtherName())){
			returnStr = "0^������������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getReceiverFullName()==null || "".equals(payRequestBySeriousInInfo.getReceiverFullName())){
			returnStr = "0^��������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getCertifType()==null || "".equals(payRequestBySeriousInInfo.getCertifType())){
			returnStr = "0^�����֤�����Ͳ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getCertifNo()==null || "".equals(payRequestBySeriousInInfo.getCertifNo())){
			returnStr = "0^֤�����벻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getProvinceCode()==null || "".equals(payRequestBySeriousInInfo.getProvinceCode())){
			returnStr = "0^ʡ�����Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getCityCode()==null || "".equals(payRequestBySeriousInInfo.getCityCode())){
			returnStr = "0^�������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getAccountType()==null || "".equals(payRequestBySeriousInInfo.getAccountType())){
			returnStr = "0^�˺����Բ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBankType()==null || "".equals(payRequestBySeriousInInfo.getBankType())){
			returnStr = "0^���д��಻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBank()==null || "".equals(payRequestBySeriousInInfo.getBank())){
			returnStr = "0^�������в���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBankAccount()==null || "".equals(payRequestBySeriousInInfo.getBankAccount())){
			returnStr = "0^�����˺Ų���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBankAccount2()==null || "".equals(payRequestBySeriousInInfo.getBankAccount2())){
			returnStr = "0^�����˺Ų���Ϊ��";
			return returnStr;
		}
		if(!payRequestBySeriousInInfo.getBankAccount2().equals(payRequestBySeriousInInfo.getBankAccount())){
			returnStr = "0^���������˺Ų�һ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getMobilePhone()==null || "".equals(payRequestBySeriousInInfo.getMobilePhone())){
			returnStr = "0^�ֻ����벻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getAddress()==null || "".equals(payRequestBySeriousInInfo.getAddress())){
			returnStr = "0^��ϸ��ַ����Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getPayWay()==null || "".equals(payRequestBySeriousInInfo.getPayWay())){
			returnStr = "0^֧����ʽ����Ϊ��";
			return returnStr;
		}
//		if(payRequestBySeriousInInfo.getPayPurpose()==null || "".equals(payRequestBySeriousInInfo.getPayPurpose())){
//			returnStr = "0^��;˵������Ϊ��";
//			return returnStr;
//		}
		if(payRequestBySeriousInInfo.getOperatorCode() == null || "".equals(payRequestBySeriousInInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getOperatorName() == null || "".equals(payRequestBySeriousInInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getMakeCom() == null || "".equals(payRequestBySeriousInInfo.getMakeCom())){
			returnStr = "0^�����˻�������Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getMakeComName() == null || "".equals(payRequestBySeriousInInfo.getMakeComName())){
			returnStr = "0^�����˻������Ʋ���Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getOperatorDate()==null || "".equals(payRequestBySeriousInInfo.getOperatorDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getHandleText()==null || "".equals(payRequestBySeriousInInfo.getHandleText())){
			returnStr = "0^֧�������������Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getAccountFlag()==null || "".equals(payRequestBySeriousInInfo.getAccountFlag())){
			returnStr = "0^�˺������������Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getHandleCode()==null || "".equals(payRequestBySeriousInInfo.getHandleCode())){
			returnStr = "0^֧��������Ա���벻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getHandleDate()==null || "".equals(payRequestBySeriousInInfo.getHandleDate())){
			returnStr = "0^֧������ͨ��ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto()==null || payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto().length==0){
			returnStr = "0^�⸶��Ϣ����Ϊ��";
			return returnStr;
		} else {
			PaymentInfoBySeriousInDto[] paymentInfoBySeriousInDtos = payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto();
			PaymentInfoBySeriousInDto paymentInfoBySeriousInDto = null;
			for(int i=0;i<paymentInfoBySeriousInDtos.length;i++){
				if(paymentInfoBySeriousInDtos[i] != null){
					paymentInfoBySeriousInDto = paymentInfoBySeriousInDtos[i];
					if(paymentInfoBySeriousInDto.getRelationOutId()==null || "".equals(paymentInfoBySeriousInDto.getRelationOutId())){
						returnStr = "0^�⸶��Ϣ�еĹ��������������Ϊ��";
						return returnStr;
					}
					if(paymentInfoBySeriousInDto.getRelationOutIdType()==null || "".equals(paymentInfoBySeriousInDto.getRelationOutIdType())){
						returnStr = "0^�⸶��Ϣ�еĹ����������Ͳ���Ϊ��";
						return returnStr;
					}else{
						String relationOutIdType = "N,R";
						if(!relationOutIdType.contains(paymentInfoBySeriousInDto.getRelationOutIdType())){
							returnStr = "0^�⸶��Ϣ�еĹ����������Ͳ��Ϸ�";
							return returnStr;
						}
					}
					if(paymentInfoBySeriousInDto.getInsuredNamePay()==null || "".equals(paymentInfoBySeriousInDto.getInsuredNamePay())){
						returnStr = "0^�⸶��Ϣ�еı������˲���Ϊ��";
						return returnStr;
					}
					if(paymentInfoBySeriousInDto.getPaymentType()==null || "".equals(paymentInfoBySeriousInDto.getPaymentType())){
						returnStr = "0^�⸶��Ϣ�е�����������Ʋ���Ϊ��";
						return returnStr;
					}else{
						String paymentType = "Ԥ�����,���,�������,���ٲ÷� ,��ִ�з�,�����鿱��,��ʩ�ȷ�,�����Ϸ�,��ϵͳ�ڴ��鿱," +
								"������/����,�ⲿ���鿱��,����ʦ��,������,����������,�������鿱��,���ݰ��⸶,���ⲹ�ձ���,�帶��," +
								"Ԥ�������,Ԥ���ٲ÷�,Ԥ��ִ�з�,Ԥ�������鿱��,Ԥ�����Ϸ�,Ԥ���ڲ����鿱��,Ԥ���ⲿ���鿱��,Ԥ����ʦ��";
						if(!paymentType.contains(paymentInfoBySeriousInDto.getPaymentType())){
							returnStr = "0^�⸶��Ϣ�е�������Ͳ��Ϸ�";
							return returnStr;
						}
					}
					if(paymentInfoBySeriousInDto.getPaymentTypeCode()==null || "".equals(paymentInfoBySeriousInDto.getPaymentTypeCode())){
						returnStr = "0^�⸶��Ϣ�е�������ʹ��벻��Ϊ��";
						return returnStr;
					}else{
						String paymentTypeCode = "P50,P60,P61,P611,P612,P62,P63,P64,P65,P66,P67,P68,P69,P6B,P70,P71,P72," +
								"P97,Y61,Y611,Y612,Y62,Y64,Y65,Y67,Y68";
						if(!paymentTypeCode.contains(paymentInfoBySeriousInDto.getPaymentTypeCode())){
							returnStr = "0^�⸶��Ϣ�е�������ʹ��벻�Ϸ�";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^�⸶��Ϣ����Ϊ��";
					return returnStr;
				}
			}
			
		}
		PayExtBySeriousInDto[] payExtBySeriousInDtos = payRequestBySeriousInInfo.getPayExtBySeriousInDto();
		if(payExtBySeriousInDtos!=null && payExtBySeriousInDtos.length>0){
			PayExtBySeriousInDto payExtBySeriousInDto = null;
			for(int i=0;i<payExtBySeriousInDtos.length;i++){
				if(payExtBySeriousInDtos[i] != null){
					payExtBySeriousInDto = payExtBySeriousInDtos[i];
					if(payExtBySeriousInDto.getOperatorCodeName()==null || "".equals(payExtBySeriousInDto.getOperatorCodeName())){
						returnStr = "0^��������еĲ����˲���Ϊ��";
						return returnStr;
					}
				}else{
					returnStr = "0^�����������Ϊ��";
					return returnStr;
				}
			}
		}
		
		return returnStr;
	}
	
	public String checkBeforePayDelete(DetelePayRequestInfo detelePayRequestInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullPayDelete(detelePayRequestInfo);
		
		return returnStr;
	}
	
	public String checkNotNullPayDelete(DetelePayRequestInfo detelePayRequestInfo) throws Exception{
		String returnStr = "";
		if(null == detelePayRequestInfo){
			returnStr = "0^��ζ�����Ϊ��";
			return returnStr;
		}
		
		if(detelePayRequestInfo.getOutId()==null || "".equals(detelePayRequestInfo.getOutId())){
			returnStr = "0^�ͻ���������������Ϊ��";
			return returnStr;
		}
		if(detelePayRequestInfo.getOperatorCode() == null || "".equals(detelePayRequestInfo.getOperatorCode())){
			returnStr = "0^�����˴��벻��Ϊ��";
			return returnStr;
		}
		if(detelePayRequestInfo.getOperatorName() == null || "".equals(detelePayRequestInfo.getOperatorName())){
			returnStr = "0^���������Ʋ���Ϊ��";
			return returnStr;
		}
		if(detelePayRequestInfo.getMakeCom() == null || "".equals(detelePayRequestInfo.getMakeCom())){
			returnStr = "0^�����˻�������Ϊ��";
			return returnStr;
		}
		if(detelePayRequestInfo.getMakeComName() == null || "".equals(detelePayRequestInfo.getMakeComName())){
			returnStr = "0^�����˻������Ʋ���Ϊ��";
			return returnStr;
		}
		if(detelePayRequestInfo.getOperatorDate()==null || "".equals(detelePayRequestInfo.getOperatorDate())){
			returnStr = "0^����ʱ�䲻��Ϊ��";
			return returnStr;
		}
		if(detelePayRequestInfo.getHandleText()==null || "".equals(detelePayRequestInfo.getHandleText())){
			returnStr = "0^֧��ɾ���������Ϊ��";
			return returnStr;
		}
		return returnStr;
	}
	
}
