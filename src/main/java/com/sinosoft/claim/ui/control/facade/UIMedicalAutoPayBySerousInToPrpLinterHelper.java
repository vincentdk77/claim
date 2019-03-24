package com.sinosoft.claim.ui.control.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.claim.dto.domain.PrpLinterPayExtDto;
import com.sinosoft.claim.dto.domain.PrpLinterPayRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterPaymentInfoDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.webservice.PayExtDto;
import com.sinosoft.claim.webservice.PayRequestInfo;
import com.sinosoft.claim.webservice.PaymentInfoDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 对象转换类
 * 将接口的入参payRequestInfo转化为中间表对象prpLinterPayRequestDto
 */
public class UIMedicalAutoPayBySerousInToPrpLinterHelper {
	String id = "";
	
	/**
	 * 将接口的入参payRequestInfo转化为中间表对象prpLinterPayRequestDto
	 * @param payRequestInfo
	 * @return prpLinterPayRequestDto
	 * @throws Exception
	 */
	public PrpLinterPayRequestDto payRequestToPrpLinter(PayRequestInfo payRequestInfo) throws Exception{
		PrpLinterPayRequestDto prpLinterPayRequestDto = new PrpLinterPayRequestDto();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		id = sdf.format(date);
		//逐个属性赋值
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplinterrequest";
		int year = DateTime.current().getYear();
		String riskCode = "2801";
		id = uiBillAction.getNo(tableName, riskCode,"0000000000", year);
		prpLinterPayRequestDto.setId(id);
		prpLinterPayRequestDto.setAccountType(payRequestInfo.getAccountType());
		prpLinterPayRequestDto.setAddress(payRequestInfo.getAddress());
		prpLinterPayRequestDto.setBank(payRequestInfo.getBank());
		prpLinterPayRequestDto.setBankAccount(payRequestInfo.getBankAccount());
		prpLinterPayRequestDto.setBankAccount2(payRequestInfo.getBankAccount2());
		prpLinterPayRequestDto.setBankType(payRequestInfo.getBankType());
		prpLinterPayRequestDto.setCertifNo(payRequestInfo.getCertifNo());
		prpLinterPayRequestDto.setCertifType(payRequestInfo.getCertifType());
		prpLinterPayRequestDto.setCertifTypeName(payRequestInfo.getCertifTypeName());
		prpLinterPayRequestDto.setCityCode(payRequestInfo.getCityCode());
		prpLinterPayRequestDto.setEmail(payRequestInfo.getEmail());
		prpLinterPayRequestDto.setFamilyPhone(payRequestInfo.getFamilyPhone());
		prpLinterPayRequestDto.setHandleText(payRequestInfo.getHandleText());
		prpLinterPayRequestDto.setMakeCom(payRequestInfo.getMakeCom());
		prpLinterPayRequestDto.setMakeComName(payRequestInfo.getMakeComName());
		prpLinterPayRequestDto.setMobilePhone(payRequestInfo.getMobilePhone());
		prpLinterPayRequestDto.setOfficePhone(payRequestInfo.getOfficePhone());
		prpLinterPayRequestDto.setOperateType(payRequestInfo.getOperateType());
		prpLinterPayRequestDto.setOperatorCode(payRequestInfo.getOperatorCode());
		prpLinterPayRequestDto.setOperatorDate(new DateTime(payRequestInfo.getOperatorDate(),DateTime.YEAR_TO_SECOND));
		prpLinterPayRequestDto.setOperatorName(payRequestInfo.getOperatorName());
		prpLinterPayRequestDto.setOutId(payRequestInfo.getOutId());
		prpLinterPayRequestDto.setPaymentNo(payRequestInfo.getPaymentNo());
		prpLinterPayRequestDto.setPayPurpose(payRequestInfo.getPayPurpose());
		prpLinterPayRequestDto.setPayReason(payRequestInfo.getPayReason());
		prpLinterPayRequestDto.setPayWay(payRequestInfo.getPayWay());
		prpLinterPayRequestDto.setPostCode(payRequestInfo.getPostCode());
		prpLinterPayRequestDto.setProvinceCode(payRequestInfo.getProvinceCode());
		prpLinterPayRequestDto.setQqNumber(payRequestInfo.getQqNumber());
		prpLinterPayRequestDto.setReceiverFullName(payRequestInfo.getReceiverFullName());
		prpLinterPayRequestDto.setReceiverTypeOther(payRequestInfo.getReceiverTypeOther());
		prpLinterPayRequestDto.setReceiverTypeOtherName(payRequestInfo.getReceiverTypeOtherName());
		prpLinterPayRequestDto.setUnitLink(payRequestInfo.getUnitLink());
		prpLinterPayRequestDto.setUrgentType(payRequestInfo.getUrgentType());
		prpLinterPayRequestDto.setUrgentTypeName(payRequestInfo.getUrgentTypeName());
		prpLinterPayRequestDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLinterPayRequestDto.setAccountFlag(payRequestInfo.getAccountFlag());
		prpLinterPayRequestDto.setHandleDate(new DateTime(payRequestInfo.getHandleDate(),DateTime.YEAR_TO_SECOND));
		prpLinterPayRequestDto.setHandleCode(payRequestInfo.getHandleCode());
		//对象数组
		prpLinterPayRequestDto.setPrpLinterPayExtDto(this.getPrpLinterPayExtDtos(payRequestInfo));
		prpLinterPayRequestDto.setPrpLinterPaymentInfoDto(this.getPrpLinterPaymentInfoDtos(payRequestInfo));
		
		return prpLinterPayRequestDto;
	}
	
	/**
	 * 将接口的入参payRequestInfo的PaymentInfoDto对象数组
	 * 转化为大对象prpLinterPayRequestDto的PrpLinterPaymentInfoDto对象数组
	 * @param payRequestInfo
	 * @return PrpLinterPaymentInfoDto[]
	 * @throws Exception
	 */
	private PrpLinterPaymentInfoDto[] getPrpLinterPaymentInfoDtos(PayRequestInfo payRequestInfo){
		PaymentInfoDto ap[] = payRequestInfo.getPaymentInfoDto();
		PrpLinterPaymentInfoDto pap[] = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterPaymentInfoDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PrpLinterPaymentInfoDto();
				pap[i].setId(id);
				pap[i].setCertiNoPay(ap[i].getCertiNoPay());
				pap[i].setHavPaidPay(ap[i].getHavPaidPay());
				pap[i].setInsuredNamePay(ap[i].getInsuredNamePay());
				pap[i].setPaidPay(ap[i].getPaidPay());
				pap[i].setPaymentType(ap[i].getPaymentTypeCode());
				pap[i].setPaymentTypeCode(ap[i].getPaymentTypeCode());
				pap[i].setRegistNoPay(ap[i].getRegistNoPay());
				pap[i].setSerialNo(i + 1);
				pap[i].setSumPaidPay(ap[i].getSumPaidPay());
				pap[i].setRelationOutId(ap[i].getRelationOutId());
				pap[i].setRelationOutIdType(ap[i].getRelationOutIdType());
			}
		}
		return pap;
	}

	/**
	 * 将接口的入参payRequestInfo的PayExtDto对象数组
	 * 转化为大对象prpLinterPayRequestDto的PrpLinterPayExtDto对象数组
	 * @param payRequestInfo
	 * @return PrpLinterPayExtDto[]
	 * @throws Exception
	 */
	private PrpLinterPayExtDto[] getPrpLinterPayExtDtos(PayRequestInfo payRequestInfo){
		PayExtDto ap[] = payRequestInfo.getPayExtDto();
		PrpLinterPayExtDto pap[] = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterPayExtDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PrpLinterPayExtDto();
				pap[i].setId(id);
				pap[i].setContext(ap[i].getContext());
				pap[i].setOperatorCodeName(ap[i].getOperatorCodeName());
				pap[i].setSerialNo(i + 1);
			}
		}
		return pap;
	}

}
