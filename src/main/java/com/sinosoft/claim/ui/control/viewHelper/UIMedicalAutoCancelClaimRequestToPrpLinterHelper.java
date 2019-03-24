package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCancelClaimRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.webservice.AccidentPersonInfoDto;
import com.sinosoft.claim.webservice.ClaimRequestInfo;
import com.sinosoft.claim.webservice.RegistCancelRequestInfo;
import com.sinosoft.claim.webservice.CertifyInfoDto;
import com.sinosoft.claim.webservice.NewMoleSurvey;
import com.sinosoft.claim.webservice.PrpCinsuredDtoInfo;
import com.sinosoft.claim.webservice.ReCaseRequestInfo;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 对象转换类
 * 将接口的入参cancelClaimRequestInfo转化为中间表对象prpLinterCancelClaimRequestDto
 */
public class UIMedicalAutoCancelClaimRequestToPrpLinterHelper {
String id = "";
	
	/**
	 * 将接口的入参cancelClaimRequestInfo转化为中间表对象prpLinterCancelClaimRequestDto
	 * @param cancelClaimRequestInfo
	 * @return prpLinterCancelClaimRequestDto
	 * @throws Exception
	 */
	public PrpLinterCancelClaimRequestDto cancelClaimRequestToPrpLinter(RegistCancelRequestInfo cancelClaimRequestInfo) throws Exception{
		PrpLinterCancelClaimRequestDto prpLinterCancelClaimRequestDto = new PrpLinterCancelClaimRequestDto();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		id = sdf.format(date);
		//逐个属性赋值
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplinterCancelClaimRequest";
		int year = DateTime.current().getYear();
		String riskCode = "2801";
		id = uiBillAction.getNo(tableName, riskCode,"0000000000", year);
		prpLinterCancelClaimRequestDto.setId(id);
		prpLinterCancelClaimRequestDto.setOutId(cancelClaimRequestInfo.getOutId());
		prpLinterCancelClaimRequestDto.setPolicyNo(cancelClaimRequestInfo.getPolicyNo());
		prpLinterCancelClaimRequestDto.setRegistNo(cancelClaimRequestInfo.getRegistNo());
		prpLinterCancelClaimRequestDto.setClaimNo(cancelClaimRequestInfo.getClaimNo());
		prpLinterCancelClaimRequestDto.setDamageStartDate(new DateTime(cancelClaimRequestInfo.getDamageStartDate()));
		prpLinterCancelClaimRequestDto.setDamageStartHour(cancelClaimRequestInfo.getDamageStartHour());
		prpLinterCancelClaimRequestDto.setDamageCode(cancelClaimRequestInfo.getDamageCode());
		prpLinterCancelClaimRequestDto.setReportorName(cancelClaimRequestInfo.getReportorName());
		prpLinterCancelClaimRequestDto.setReportDate(new DateTime(cancelClaimRequestInfo.getReportDate()));
		prpLinterCancelClaimRequestDto.setReportHour(cancelClaimRequestInfo.getReportHour());
		prpLinterCancelClaimRequestDto.setReportType(cancelClaimRequestInfo.getReportType());
		prpLinterCancelClaimRequestDto.setLinkerName(cancelClaimRequestInfo.getLinkerName());
		prpLinterCancelClaimRequestDto.setClauseType(cancelClaimRequestInfo.getClauseType());
		prpLinterCancelClaimRequestDto.setLinkerAddress(cancelClaimRequestInfo.getLinkerAddress());
		prpLinterCancelClaimRequestDto.setPhoneNumber(cancelClaimRequestInfo.getPhoneNumber());
		prpLinterCancelClaimRequestDto.setDamageAddress(cancelClaimRequestInfo.getDamageAddress());
		prpLinterCancelClaimRequestDto.setDamageTypeCode(cancelClaimRequestInfo.getDamageTypeCode());
		prpLinterCancelClaimRequestDto.setLossesNumber(cancelClaimRequestInfo.getLossesNumber());
		prpLinterCancelClaimRequestDto.setOperatorCode(cancelClaimRequestInfo.getOperatorCode());
		prpLinterCancelClaimRequestDto.setOperatorName(cancelClaimRequestInfo.getOperatorName());
		prpLinterCancelClaimRequestDto.setMakeCom(cancelClaimRequestInfo.getMakeCom());
		prpLinterCancelClaimRequestDto.setMakeComName(cancelClaimRequestInfo.getMakeComName());
		prpLinterCancelClaimRequestDto.setRemark(cancelClaimRequestInfo.getRemark());
		prpLinterCancelClaimRequestDto.setContext(cancelClaimRequestInfo.getContext());
		prpLinterCancelClaimRequestDto.setCancelDate(new DateTime(cancelClaimRequestInfo.getCancelDate(),DateTime.YEAR_TO_SECOND));
		prpLinterCancelClaimRequestDto.setDealerCode(cancelClaimRequestInfo.getDealerCode());
		prpLinterCancelClaimRequestDto.setCancelContext(cancelClaimRequestInfo.getCancelContext());
		prpLinterCancelClaimRequestDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLinterCancelClaimRequestDto.setOutRegistNo(cancelClaimRequestInfo.getOutRegistNo());
		prpLinterCancelClaimRequestDto.setCaseType(cancelClaimRequestInfo.getCaseType());
		prpLinterCancelClaimRequestDto.setCancelReson(cancelClaimRequestInfo.getCancelReson());
		prpLinterCancelClaimRequestDto.setNotion(cancelClaimRequestInfo.getNotion());
		prpLinterCancelClaimRequestDto.setHandleText(cancelClaimRequestInfo.getHandleText());
		//对象数组
		prpLinterCancelClaimRequestDto.setPrpLinterAccdentPersonDto(this.getPrpLinterAccdentPersonDtos(cancelClaimRequestInfo));
		prpLinterCancelClaimRequestDto.setPrpLinterCertifyDto(this.getPrpLinterCertifyDtos(cancelClaimRequestInfo));
		return prpLinterCancelClaimRequestDto;
	}
	
	/**
	 * 将接口的入参cancelClaimRequestInfo的AccidentPersonInfoDto对象数组
	 * 转化为大对象prpLinterCancelClaimRequestDto的PrpLinterAccdentPersonDto对象数组
	 * @param claimdRequestInfo
	 * @return PrpLinterAccdentPersonDto[]
	 * @throws Exception
	 */
	private PrpLinterAccdentPersonDto[] getPrpLinterAccdentPersonDtos(RegistCancelRequestInfo cancelClaimRequestInfo){
		PrpLinterAccdentPersonDto pap[] = null;
		String policyNo = cancelClaimRequestInfo.getPolicyNo();
		String riskCode = "2801";
		String fname = "";
		String fidCard = "";
		BLPrpCmain  bLPrpCmain = new BLPrpCmain();
		try{
			bLPrpCmain.getData(policyNo);
			if(bLPrpCmain.getSize()>0){
				riskCode = bLPrpCmain.getArr(0).getRiskCode();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		NewMoleSurvey newMoleSurvey = new NewMoleSurvey();
		PrpCinsuredDtoInfo[] prpCinsuredDtoInfoList = newMoleSurvey.getPrpCinsuredVirturlItem(policyNo, riskCode, fname, fidCard);
		if(null != prpCinsuredDtoInfoList && prpCinsuredDtoInfoList.length>0){
			pap = new PrpLinterAccdentPersonDto[prpCinsuredDtoInfoList.length];
			for(int i=0;i<prpCinsuredDtoInfoList.length;i++){
				PrpCinsuredDtoInfo prpCinsuredDtoInfo = prpCinsuredDtoInfoList[i];
				if(prpCinsuredDtoInfo != null){
					pap[i] = new PrpLinterAccdentPersonDto();
					pap[i].setId(id);
					pap[i].setAcciCode(prpCinsuredDtoInfo.getInsuredCode());
					pap[i].setAcciName(prpCinsuredDtoInfo.getInsuredName());
					if(null != prpCinsuredDtoInfo.getAge() && !"".equals(prpCinsuredDtoInfo.getAge())){
						pap[i].setAge(Integer.parseInt(prpCinsuredDtoInfo.getAge()));
					}
					pap[i].setIdentifyNumber(prpCinsuredDtoInfo.getIdentifyNumber());
					pap[i].setSerialNo(Integer.parseInt(prpCinsuredDtoInfo.getFamilyno()));
					pap[i].setSex(prpCinsuredDtoInfo.getSex());
				}
			}
		}
		
		return pap;
	}
	
	
	/**
	 * 将接口的入参claimRequestInfo的CertifyInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCertifyDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterCertifyDto[]
	 * @throws Exception
	 */
	private PrpLinterCertifyDto[] getPrpLinterCertifyDtos(RegistCancelRequestInfo registCancelRequestInfo){
		CertifyInfoDto[] ap = registCancelRequestInfo.getCertifyInfoDto();
		PrpLinterCertifyDto[] pap = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterCertifyDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PrpLinterCertifyDto();
				pap[i].setId(id);
				pap[i].setCertifyDirectCheck(ap[i].getCertifyDirectCheck());
				pap[i].setSerialNo(i);
				pap[i].setTypeCode(ap[i].getTypeCode());
				pap[i].setTypeName(ap[i].getTypeName());
				pap[i].setUploadFlag(ap[i].getUploadFlag());
			}
		}
		return pap;
	}
	
}

