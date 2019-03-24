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
 * 接口传入参数的合法性校验类
 * 
 * */
public class UIMediCheckBefAutoPayBySeriousInViewHelper {
	/**
	 * 接口传入参数的合法性校验
	 * @param payRequestBySeriousInInfo
	 * 
	 * */
	public String checkBeforePay(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception{
		String returnStr = "";
		returnStr = this.checkNotNullFields(payRequestBySeriousInInfo);
		
		return returnStr;
	}
	
	/**
	 * 非空字段的非空性校验，若有不满足条件的字段属性，返回提示：0^某属性不能为空
	 * @param payRequestBySeriousInInfo
	 * @return String
	 * @throws Exception
	 * */
	public String checkNotNullFields(PayRequestBySeriousInInfo payRequestBySeriousInInfo) throws Exception{
		String returnStr = "";
		if(null == payRequestBySeriousInInfo){
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(payRequestBySeriousInInfo.getOutId()==null || "".equals(payRequestBySeriousInInfo.getOutId())){
			returnStr = "0^客户端数据主键不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getOperateType()==null || "".equals(payRequestBySeriousInInfo.getOperateType())){
			returnStr = "0^操作类型不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getReceiverTypeOther()==null || "".equals(payRequestBySeriousInInfo.getReceiverTypeOther())){
			returnStr = "0^领款人类型代码不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getReceiverTypeOtherName()==null || "".equals(payRequestBySeriousInInfo.getReceiverTypeOtherName())){
			returnStr = "0^领款人类型名称不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getReceiverFullName()==null || "".equals(payRequestBySeriousInInfo.getReceiverFullName())){
			returnStr = "0^领款人名称不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getCertifType()==null || "".equals(payRequestBySeriousInInfo.getCertifType())){
			returnStr = "0^领款人证件类型不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getCertifNo()==null || "".equals(payRequestBySeriousInInfo.getCertifNo())){
			returnStr = "0^证件号码不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getProvinceCode()==null || "".equals(payRequestBySeriousInInfo.getProvinceCode())){
			returnStr = "0^省份名称不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getCityCode()==null || "".equals(payRequestBySeriousInInfo.getCityCode())){
			returnStr = "0^城市名称不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getAccountType()==null || "".equals(payRequestBySeriousInInfo.getAccountType())){
			returnStr = "0^账号属性不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBankType()==null || "".equals(payRequestBySeriousInInfo.getBankType())){
			returnStr = "0^银行大类不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBank()==null || "".equals(payRequestBySeriousInInfo.getBank())){
			returnStr = "0^开户银行不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBankAccount()==null || "".equals(payRequestBySeriousInInfo.getBankAccount())){
			returnStr = "0^银行账号不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getBankAccount2()==null || "".equals(payRequestBySeriousInInfo.getBankAccount2())){
			returnStr = "0^银行账号不能为空";
			return returnStr;
		}
		if(!payRequestBySeriousInInfo.getBankAccount2().equals(payRequestBySeriousInInfo.getBankAccount())){
			returnStr = "0^两次银行账号不一样";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getMobilePhone()==null || "".equals(payRequestBySeriousInInfo.getMobilePhone())){
			returnStr = "0^手机号码不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getAddress()==null || "".equals(payRequestBySeriousInInfo.getAddress())){
			returnStr = "0^详细地址不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getPayWay()==null || "".equals(payRequestBySeriousInInfo.getPayWay())){
			returnStr = "0^支付方式不能为空";
			return returnStr;
		}
//		if(payRequestBySeriousInInfo.getPayPurpose()==null || "".equals(payRequestBySeriousInInfo.getPayPurpose())){
//			returnStr = "0^用途说明不能为空";
//			return returnStr;
//		}
		if(payRequestBySeriousInInfo.getOperatorCode() == null || "".equals(payRequestBySeriousInInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getOperatorName() == null || "".equals(payRequestBySeriousInInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getMakeCom() == null || "".equals(payRequestBySeriousInInfo.getMakeCom())){
			returnStr = "0^操作人机构不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getMakeComName() == null || "".equals(payRequestBySeriousInInfo.getMakeComName())){
			returnStr = "0^操作人机构名称不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getOperatorDate()==null || "".equals(payRequestBySeriousInInfo.getOperatorDate())){
			returnStr = "0^操作时间不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getHandleText()==null || "".equals(payRequestBySeriousInInfo.getHandleText())){
			returnStr = "0^支付审批意见不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getAccountFlag()==null || "".equals(payRequestBySeriousInInfo.getAccountFlag())){
			returnStr = "0^账号类型意见不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getHandleCode()==null || "".equals(payRequestBySeriousInInfo.getHandleCode())){
			returnStr = "0^支付审批人员代码不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getHandleDate()==null || "".equals(payRequestBySeriousInInfo.getHandleDate())){
			returnStr = "0^支付审批通过时间不能为空";
			return returnStr;
		}
		if(payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto()==null || payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto().length==0){
			returnStr = "0^赔付信息不能为空";
			return returnStr;
		} else {
			PaymentInfoBySeriousInDto[] paymentInfoBySeriousInDtos = payRequestBySeriousInInfo.getPaymentInfoBySeriousInDto();
			PaymentInfoBySeriousInDto paymentInfoBySeriousInDto = null;
			for(int i=0;i<paymentInfoBySeriousInDtos.length;i++){
				if(paymentInfoBySeriousInDtos[i] != null){
					paymentInfoBySeriousInDto = paymentInfoBySeriousInDtos[i];
					if(paymentInfoBySeriousInDto.getRelationOutId()==null || "".equals(paymentInfoBySeriousInDto.getRelationOutId())){
						returnStr = "0^赔付信息中的关联案件外键不能为空";
						return returnStr;
					}
					if(paymentInfoBySeriousInDto.getRelationOutIdType()==null || "".equals(paymentInfoBySeriousInDto.getRelationOutIdType())){
						returnStr = "0^赔付信息中的关联案件类型不能为空";
						return returnStr;
					}else{
						String relationOutIdType = "N,R";
						if(!relationOutIdType.contains(paymentInfoBySeriousInDto.getRelationOutIdType())){
							returnStr = "0^赔付信息中的关联案件类型不合法";
							return returnStr;
						}
					}
					if(paymentInfoBySeriousInDto.getInsuredNamePay()==null || "".equals(paymentInfoBySeriousInDto.getInsuredNamePay())){
						returnStr = "0^赔付信息中的被保险人不能为空";
						return returnStr;
					}
					if(paymentInfoBySeriousInDto.getPaymentType()==null || "".equals(paymentInfoBySeriousInDto.getPaymentType())){
						returnStr = "0^赔付信息中的赔款类型名称不能为空";
						return returnStr;
					}else{
						String paymentType = "预付赔款,赔款,付检验费,付仲裁费 ,付执行费,机构查勘费,付施救费,付诉讼费,付系统内代查勘," +
								"付共损/救助,外部代查勘费,付律师费,付其他,间接理赔费用,代付赔款及查勘费,逃逸案赔付,理赔补收保费,清付款," +
								"预付检验费,预付仲裁费,预付执行费,预付机构查勘费,预付诉讼费,预付内部代查勘费,预付外部代查勘费,预付律师费";
						if(!paymentType.contains(paymentInfoBySeriousInDto.getPaymentType())){
							returnStr = "0^赔付信息中的赔款类型不合法";
							return returnStr;
						}
					}
					if(paymentInfoBySeriousInDto.getPaymentTypeCode()==null || "".equals(paymentInfoBySeriousInDto.getPaymentTypeCode())){
						returnStr = "0^赔付信息中的赔款类型代码不能为空";
						return returnStr;
					}else{
						String paymentTypeCode = "P50,P60,P61,P611,P612,P62,P63,P64,P65,P66,P67,P68,P69,P6B,P70,P71,P72," +
								"P97,Y61,Y611,Y612,Y62,Y64,Y65,Y67,Y68";
						if(!paymentTypeCode.contains(paymentInfoBySeriousInDto.getPaymentTypeCode())){
							returnStr = "0^赔付信息中的赔款类型代码不合法";
							return returnStr;
						}
					}
				}else{
					returnStr = "0^赔付信息不能为空";
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
						returnStr = "0^处理意见中的操作人不能为空";
						return returnStr;
					}
				}else{
					returnStr = "0^处理意见不能为空";
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
			returnStr = "0^入参对象不能为空";
			return returnStr;
		}
		
		if(detelePayRequestInfo.getOutId()==null || "".equals(detelePayRequestInfo.getOutId())){
			returnStr = "0^客户端数据主键不能为空";
			return returnStr;
		}
		if(detelePayRequestInfo.getOperatorCode() == null || "".equals(detelePayRequestInfo.getOperatorCode())){
			returnStr = "0^操作人代码不能为空";
			return returnStr;
		}
		if(detelePayRequestInfo.getOperatorName() == null || "".equals(detelePayRequestInfo.getOperatorName())){
			returnStr = "0^操作人名称不能为空";
			return returnStr;
		}
		if(detelePayRequestInfo.getMakeCom() == null || "".equals(detelePayRequestInfo.getMakeCom())){
			returnStr = "0^操作人机构不能为空";
			return returnStr;
		}
		if(detelePayRequestInfo.getMakeComName() == null || "".equals(detelePayRequestInfo.getMakeComName())){
			returnStr = "0^操作人机构名称不能为空";
			return returnStr;
		}
		if(detelePayRequestInfo.getOperatorDate()==null || "".equals(detelePayRequestInfo.getOperatorDate())){
			returnStr = "0^操作时间不能为空";
			return returnStr;
		}
		if(detelePayRequestInfo.getHandleText()==null || "".equals(detelePayRequestInfo.getHandleText())){
			returnStr = "0^支付删除意见不能为空";
			return returnStr;
		}
		return returnStr;
	}
	
}
