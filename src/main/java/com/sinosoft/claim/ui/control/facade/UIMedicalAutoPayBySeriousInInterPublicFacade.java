package com.sinosoft.claim.ui.control.facade;

import com.sinosoft.claim.dto.domain.PrpLinterPayDeleteRequestDto;
import com.sinosoft.claim.webservice.DetelePayRequestInfo;
import com.sinosoft.claim.webservice.PayExtBySeriousInDto;
import com.sinosoft.claim.webservice.PayExtDto;
import com.sinosoft.claim.webservice.PayRequestBySeriousInInfo;
import com.sinosoft.claim.webservice.PayRequestInfo;
import com.sinosoft.claim.webservice.PaymentInfoBySeriousInDto;
import com.sinosoft.claim.webservice.PaymentInfoDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

public class UIMedicalAutoPayBySeriousInInterPublicFacade {

	/**
	 * 将接口的入参payRequestBySeriousInInfo
	 * 转化为大对象payRequestInfo
	 * @param payRequestBySeriousInInfo
	 * @return payRequestInfo
	 * @throws Exception
	 */
	public PayRequestInfo ConvertPayRequestBySeriousIn(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception {
		PayRequestInfo payRequestInfo = new PayRequestInfo();
		payRequestInfo.setAccountType(payRequestBySeriousInInfo.getAccountType());
		payRequestInfo.setAddress(payRequestBySeriousInInfo.getAddress());
		payRequestInfo.setBank(payRequestBySeriousInInfo.getBank());
		payRequestInfo.setBankAccount(payRequestBySeriousInInfo.getBankAccount());
		payRequestInfo.setBankAccount2(payRequestBySeriousInInfo.getBankAccount2());
		payRequestInfo.setBankType(payRequestBySeriousInInfo.getBankType());
		payRequestInfo.setCertifNo(payRequestBySeriousInInfo.getCertifNo());
		payRequestInfo.setCertifType(payRequestBySeriousInInfo.getCertifType());
		payRequestInfo.setCertifTypeName(payRequestBySeriousInInfo.getCertifTypeName());
		payRequestInfo.setCityCode(payRequestBySeriousInInfo.getCityCode());
		payRequestInfo.setEmail(payRequestBySeriousInInfo.getEmail());
		payRequestInfo.setFamilyPhone(payRequestBySeriousInInfo.getFamilyPhone());
		payRequestInfo.setHandleText(payRequestBySeriousInInfo.getHandleText());
		payRequestInfo.setMakeCom(payRequestBySeriousInInfo.getMakeCom());
		payRequestInfo.setMakeComName(payRequestBySeriousInInfo.getMakeComName());
		payRequestInfo.setMobilePhone(payRequestBySeriousInInfo.getMobilePhone());
		payRequestInfo.setOfficePhone(payRequestBySeriousInInfo.getOfficePhone());
		payRequestInfo.setOperateType(payRequestBySeriousInInfo.getOperateType());
		payRequestInfo.setOperatorCode(payRequestBySeriousInInfo.getOperatorCode());
		payRequestInfo.setOperatorDate(payRequestBySeriousInInfo.getOperatorDate());
		payRequestInfo.setOperatorName(payRequestBySeriousInInfo.getOperatorName());
		payRequestInfo.setOutId(payRequestBySeriousInInfo.getOutId());
		payRequestInfo.setPaymentNo(payRequestBySeriousInInfo.getPaymentNo());
		payRequestInfo.setPayPurpose(payRequestBySeriousInInfo.getPayPurpose());
		payRequestInfo.setPayReason(payRequestBySeriousInInfo.getPayReason());
		payRequestInfo.setPayWay(payRequestBySeriousInInfo.getPayWay());
		payRequestInfo.setPostCode(payRequestBySeriousInInfo.getPostCode());
		payRequestInfo.setProvinceCode(payRequestBySeriousInInfo.getProvinceCode());
		payRequestInfo.setQqNumber(payRequestBySeriousInInfo.getQqNumber());
		payRequestInfo.setReceiverFullName(payRequestBySeriousInInfo.getReceiverFullName());
		payRequestInfo.setReceiverTypeOther(payRequestBySeriousInInfo.getReceiverTypeOther());
		payRequestInfo.setReceiverTypeOtherName(payRequestBySeriousInInfo.getReceiverTypeOtherName());
		payRequestInfo.setUnitLink(payRequestBySeriousInInfo.getUnitLink());
		payRequestInfo.setUrgentType(payRequestBySeriousInInfo.getUrgentType());
		payRequestInfo.setUrgentTypeName(payRequestBySeriousInInfo.getUrgentTypeName());
		payRequestInfo.setAccountFlag(payRequestBySeriousInInfo.getAccountFlag());
		payRequestInfo.setHandleDate(payRequestBySeriousInInfo.getHandleDate());
		payRequestInfo.setHandleCode(payRequestBySeriousInInfo.getHandleCode());
		//对象数组
		payRequestInfo.setPayExtDto(this.ConvertPayExtBySeriousIn(payRequestBySeriousInInfo));
		payRequestInfo.setPaymentInfoDto(this.ConvertPaymentInfoBySeriousIn(payRequestBySeriousInInfo));
		return payRequestInfo;
	}
	
	/**
	 * 将接口的入参payRequestBySeriousInInfo的PaymentInfoDto对象数组
	 * 转化为大对象payRequestInfo的PaymentInfoDto对象数组
	 * @param payRequestBySeriousInInfo
	 * @return PaymentInfoDto[]
	 * @throws Exception
	 */
	private PaymentInfoDto[] ConvertPaymentInfoBySeriousIn(PayRequestBySeriousInInfo payRequestBySeriousInInfo){
		PaymentInfoBySeriousInDto ap[] = payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto();
		PaymentInfoDto pap[] = null;
		if(ap == null){
			return pap;
		}
		pap = new PaymentInfoDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PaymentInfoDto();
				pap[i].setCertiNoPay(ap[i].getCertiNoPay());
				pap[i].setHavPaidPay(ap[i].getHavPaidPay());
				pap[i].setInsuredNamePay(ap[i].getInsuredNamePay());
				pap[i].setPaidPay(ap[i].getPaidPay());
				pap[i].setPaymentType(ap[i].getPaymentType());
				pap[i].setPaymentTypeCode(ap[i].getPaymentTypeCode());
				pap[i].setRegistNoPay(ap[i].getRegistNoPay());
				pap[i].setSumPaidPay(ap[i].getSumPaidPay());
				pap[i].setRelationOutId(ap[i].getRelationOutId());
				pap[i].setRelationOutIdType(ap[i].getRelationOutIdType());
			}
		}
		return pap;
	}
	
	/**
	 * 将接口的入参payRequestBySeriousInInfo的PayExtBySeriousInDto对象数组
	 * 转化为大对象payRequestInfo的PayExtDto对象数组
	 * @param payRequestBySeriousInInfo
	 * @return PayExtDto[]
	 * @throws Exception
	 */
	public PayExtDto[] ConvertPayExtBySeriousIn(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception {
		PayExtBySeriousInDto ap[] = payRequestBySeriousInInfo.getPayExtBySeriousInDto();
		PayExtDto pap[] = null;
		if(ap == null){
			return pap;
		}
		pap = new PayExtDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PayExtDto();
				pap[i].setContext(ap[i].getContext());
				pap[i].setOperatorCodeName(ap[i].getOperatorCodeName());
				pap[i].setSerialNo(ap[i].getSerialNo());
			}
		}
		return pap;
	
	}
	
	public PrpLinterPayDeleteRequestDto ConvertPayDeleteRequestByPayDelete(DetelePayRequestInfo detelePayRequestInfo) throws Exception {
		PrpLinterPayDeleteRequestDto payDeleteRequestInfo = new PrpLinterPayDeleteRequestDto();
		payDeleteRequestInfo.setHandleText(detelePayRequestInfo.getHandleText());
		payDeleteRequestInfo.setMakeCom(detelePayRequestInfo.getMakeCom());
		payDeleteRequestInfo.setMakeComName(detelePayRequestInfo.getMakeComName());
		payDeleteRequestInfo.setOperatorCode(detelePayRequestInfo.getOperatorCode());
		payDeleteRequestInfo.setOperatorDate(new DateTime(detelePayRequestInfo.getOperatorDate(),DateTime.YEAR_TO_SECOND));
		payDeleteRequestInfo.setOperatorName(detelePayRequestInfo.getOperatorName());
		payDeleteRequestInfo.setOutId(detelePayRequestInfo.getOutId());
		return payDeleteRequestInfo;
	}
	
}
