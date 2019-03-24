package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterRecaseRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
import com.sinosoft.claim.webservice.AccidentPersonInfoDto;
import com.sinosoft.claim.webservice.CertifyInfoDto;
import com.sinosoft.claim.webservice.ClaimAppDto;
import com.sinosoft.claim.webservice.CompeFeeInfoDto;
import com.sinosoft.claim.webservice.CompeInvDetailInfo;
import com.sinosoft.claim.webservice.CompeInvMainInfo;
import com.sinosoft.claim.webservice.CompePayFeeInfoDto;
import com.sinosoft.claim.webservice.InjuryPersonInfoDto;
import com.sinosoft.claim.webservice.NewMoleSurvey;
import com.sinosoft.claim.webservice.PrpCinsuredDtoInfo;
import com.sinosoft.claim.webservice.ReCaseRequestInfo;
import com.sinosoft.claim.webservice.SchedExtInfoDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 对象转换类
 * 将接口的入参ReCaseRequestInfo转化为大对象prpLinterReCaseRequestDto
 */
public class UIMedicalRecaseInfoToPrpLinterRecaseHelper {
	String id = "";
	/**
	 * 将接口的入参reCaseRequestInfo转化为大对象PrpLinterRecaseRequestDto
	 * @param claimdRequestInfo
	 * @return prpLinterRecaseRequestDto
	 * @throws Exception
	 */
	public PrpLinterRecaseRequestDto requestToPrpLinterRecase(ReCaseRequestInfo reCaseRequestInfo) throws Exception{
		PrpLinterRecaseRequestDto prpLinterRecaseRequestDto = new PrpLinterRecaseRequestDto();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		id = sdf.format(date);
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplinterRecaseRequest";
		int year = DateTime.current().getYear();
		String riskCode = "2801";
		id = uiBillAction.getNo(tableName, riskCode,"0000000000", year);
		prpLinterRecaseRequestDto.setId(id);
		prpLinterRecaseRequestDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLinterRecaseRequestDto.setOutId(reCaseRequestInfo.getOutId());
		prpLinterRecaseRequestDto.setRelationOutId(reCaseRequestInfo.getRelationOutId());
		prpLinterRecaseRequestDto.setPolicyno(reCaseRequestInfo.getPolicyNo());
		prpLinterRecaseRequestDto.setRegistno(reCaseRequestInfo.getRegistNo());
		prpLinterRecaseRequestDto.setClaimno(reCaseRequestInfo.getClaimNo());
		prpLinterRecaseRequestDto.setAppRecaseReason(reCaseRequestInfo.getAppRecaseReason());
		prpLinterRecaseRequestDto.setReClaimNotion(reCaseRequestInfo.getReClaimNotion());
		prpLinterRecaseRequestDto.setReClaimHandleText(reCaseRequestInfo.getReClaimHandleText());
		prpLinterRecaseRequestDto.setLossesNumber(reCaseRequestInfo.getLossesNumber());
		prpLinterRecaseRequestDto.setOperatorCode(reCaseRequestInfo.getOperatorCode());
		prpLinterRecaseRequestDto.setOperatorName(reCaseRequestInfo.getOperatorName());
		prpLinterRecaseRequestDto.setMakeCom(reCaseRequestInfo.getMakeCom());
		prpLinterRecaseRequestDto.setMakeComName(reCaseRequestInfo.getMakeComName());
		prpLinterRecaseRequestDto.setBank(reCaseRequestInfo.getBank());
		prpLinterRecaseRequestDto.setReceiverName(reCaseRequestInfo.getReceiverName());
		prpLinterRecaseRequestDto.setAccount(reCaseRequestInfo.getAccount());
		prpLinterRecaseRequestDto.setAccountOK(reCaseRequestInfo.getAccountOK());
		prpLinterRecaseRequestDto.setZeroLossType(reCaseRequestInfo.getZeroLossType());
		prpLinterRecaseRequestDto.setSumNoDutyFee(reCaseRequestInfo.getSumNoDutyFee());
		prpLinterRecaseRequestDto.setPrplCompensateSumPaid(reCaseRequestInfo.getPrplCompensateSumPaid());
		prpLinterRecaseRequestDto.setPrplCompensateSumPrePaid(reCaseRequestInfo.getPrplCompensateSumPrePaid());
		prpLinterRecaseRequestDto.setSumChargePaid(reCaseRequestInfo.getSumChargePaid());
		prpLinterRecaseRequestDto.setSumThisPaid(reCaseRequestInfo.getSumThisPaid());
		prpLinterRecaseRequestDto.setCompeContext(reCaseRequestInfo.getCompeContext());
		prpLinterRecaseRequestDto.setNotion(reCaseRequestInfo.getNotion());
		prpLinterRecaseRequestDto.setHandleText(reCaseRequestInfo.getHandleText());
		prpLinterRecaseRequestDto.setApplyRecaseTime(new DateTime(reCaseRequestInfo.getApplyRecaseTime(),DateTime.YEAR_TO_SECOND));
		prpLinterRecaseRequestDto.setApplyRecaseUser(reCaseRequestInfo.getApplyRecaseUser());
		prpLinterRecaseRequestDto.setAuditRecaseTime(new DateTime(reCaseRequestInfo.getAuditRecaseTime(),DateTime.YEAR_TO_SECOND));
		prpLinterRecaseRequestDto.setAuditUser(reCaseRequestInfo.getAuditUser());
		prpLinterRecaseRequestDto.setVericTime(new DateTime(reCaseRequestInfo.getVericTime(),DateTime.YEAR_TO_SECOND));
		prpLinterRecaseRequestDto.setVericUser(reCaseRequestInfo.getVericUser());
		
		//标示交互成功
		prpLinterRecaseRequestDto.setMutualFlag("1");
		
		//对象数组
		prpLinterRecaseRequestDto.setPrpLinterAccdentPersonDto(getPrpLinterAccdentPersonDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterSchedExtDto(getPrpLinterSchedExtDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterCertifyDto(getPrpLinterCertifyDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterClaimAppDto(getPrpLinterClaimAppDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterCompeFeeDto(getPrpLinterCompeFeeDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterCompePayFeeDto(getPrpLinterCompePayFeeDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterCompeInvMainDto(getPrpLinterCompeInvMainDtos(reCaseRequestInfo));
		prpLinterRecaseRequestDto.setPrpLinterInjuryPersonDto(getPrpLinterInjuryPersonDtos(reCaseRequestInfo));
		
		return prpLinterRecaseRequestDto;
	}
	private PrpLinterInjuryPersonDto getPrpLinterInjuryPersonDtos(ReCaseRequestInfo reCaseRequestInfo){
		PrpLinterInjuryPersonDto prpLinterInjuryPersonDto = new PrpLinterInjuryPersonDto();
		InjuryPersonInfoDto injuryPerson = reCaseRequestInfo.getInjuryPersonInfoDto();
		prpLinterInjuryPersonDto.setId(id);
		prpLinterInjuryPersonDto.setAcciName(injuryPerson.getAcciName());
		prpLinterInjuryPersonDto.setIdentifyNumber(injuryPerson.getIdentifyNumber());
		prpLinterInjuryPersonDto.setSex(injuryPerson.getSex());
		return prpLinterInjuryPersonDto;
	}
	/**
	 * 将接口的入参claimdRequestInfo的AccidentPersonInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的AccidentPersonInfoDto对象数组
	 * @param claimdRequestInfo
	 * @return PrpLinterAccdentPersonDto[]
	 * @throws Exception
	 */
	private PrpLinterAccdentPersonDto[] getPrpLinterAccdentPersonDtos(ReCaseRequestInfo reCaseRequestInfo){
		PrpLinterAccdentPersonDto pap[] = null;
		String policyNo = reCaseRequestInfo.getPolicyNo();
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
	 * 将接口的入参reCaseRequestInfo的SchedExtInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterSchedExtDto对象数组
	 * @param reCaseRequestInfo
	 * @return PrpLinterSchedExtDto[]
	 * @throws Exception
	 */
	private PrpLinterSchedExtDto[] getPrpLinterSchedExtDtos(ReCaseRequestInfo reCaseRequestInfo){
		SchedExtInfoDto[] se = reCaseRequestInfo.getSchedExtInfoDto();
		PrpLinterSchedExtDto[] pse = null;
		if(se == null){
			return pse;
		}
		pse = new PrpLinterSchedExtDto[se.length];
		for(int i=0;i<se.length;i++){
			if(se[i] != null){
				pse[i] = new PrpLinterSchedExtDto();
				pse[i].setId(id);
				pse[i].setContext(se[i].getContext());
				pse[i].setOperatorCode(se[i].getOperatorCode());
				pse[i].setSerialNo(se[i].getSerialNo());
			}
		}
		return pse;
	}
	
	/**
	 * 将接口的入参reCaseRequestInfo的ClaimAppDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterClaimAppDto对象数组
	 * @param reCaseRequestInfo
	 * @return PrpLinterClaimAppDto[]
	 * @throws Exception
	 */
	private PrpLinterClaimAppDto[] getPrpLinterClaimAppDtos(ReCaseRequestInfo reCaseRequestInfo){
		ClaimAppDto[] ca = reCaseRequestInfo.getClaimAppDto();
		PrpLinterClaimAppDto[] pca = null;
		if(ca == null){
			return pca;
		}
		pca = new PrpLinterClaimAppDto[ca.length];
		for(int i=0;i<ca.length;i++){
			if(ca[i] != null){
				pca[i] = new PrpLinterClaimAppDto();
				pca[i].setId(id);
				pca[i].setAcciName(ca[i].getAcciName());
				pca[i].setIdentifyNumber(ca[i].getIdentifyNumber());
				pca[i].setPhone(ca[i].getPhone());
				pca[i].setProposerAddress(ca[i].getProposerAddress());
				pca[i].setRelationCode(ca[i].getRelationCode());
				pca[i].setSerialNo(ca[i].getSerialNo());
			}
		}
		return pca;
	}
	
	/**
	 * 将接口的入参reCaseRequestInfo的CertifyInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCertifyDto对象数组
	 * @param reCaseRequestInfo
	 * @return PrpLinterCertifyDto[]
	 * @throws Exception
	 */
	private PrpLinterCertifyDto[] getPrpLinterCertifyDtos(ReCaseRequestInfo reCaseRequestInfo){
		CertifyInfoDto[] ap = reCaseRequestInfo.getCertifyInfoDto();
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
	
	/**
	 * 将接口的入参reCaseRequestInfo的CompeFeeInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCompeFeeDto对象数组
	 * @param reCaseRequestInfo
	 * @return PrpLinterCompeFeeDto[]
	 * @throws Exception
	 */
	private PrpLinterCompeFeeDto[] getPrpLinterCompeFeeDtos(ReCaseRequestInfo reCaseRequestInfo){
		CompeFeeInfoDto[] ap = reCaseRequestInfo.getCompeFeeInfoDto();
		PrpLinterCompeFeeDto[] pap = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterCompeFeeDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PrpLinterCompeFeeDto();
				pap[i].setId(id);
				pap[i].setSerialNo(i);
				pap[i].setClaimRete(ap[i].getClaimRete());
				pap[i].setKindCode(ap[i].getKindCode());
				pap[i].setKindName(ap[i].getKindName());
				pap[i].setCurrency(ap[i].getCurrency());
				pap[i].setDeductible(ap[i].getDeductible());
				pap[i].setItemKindNo(ap[i].getItemKindNo());
				pap[i].setRemark(ap[i].getRemark());
				pap[i].setSumLoss(ap[i].getSumLoss());
				pap[i].setSumRealPay(ap[i].getSumRealPay());
				pap[i].setSumRest(ap[i].getSumRest());
			}
		}
		return pap;
	}
	
	/**
	 * 将接口的入参reCaseRequestInfo的CompePayFeeInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCompePayFeeDto对象数组
	 * @param reCaseRequestInfo
	 * @return PrpLinterCompePayFeeDto[]
	 * @throws Exception
	 */
	private PrpLinterCompePayFeeDto[] getPrpLinterCompePayFeeDtos(ReCaseRequestInfo reCaseRequestInfo){
		CompePayFeeInfoDto[] ap = reCaseRequestInfo.getCompePayFeeInfoDto();
		PrpLinterCompePayFeeDto[] pap = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterCompePayFeeDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PrpLinterCompePayFeeDto();
				pap[i].setId(id);
				pap[i].setSerialNo(i);
				pap[i].setChargeAmount(ap[i].getChargeAmount());
				pap[i].setCheckDeptName(ap[i].getCheckDeptName());
				pap[i].setCodeCName(ap[i].getCodeCName());
				pap[i].setCodeCode(ap[i].getCodeCode());
				pap[i].setCurrency(ap[i].getCurrency());
				pap[i].setCurrencyName(ap[i].getCurrencyName());
				pap[i].setItemKindNo(ap[i].getItemKindNoForCharge());
				pap[i].setKindCode(ap[i].getKindCode());
				pap[i].setKindName(ap[i].getKindName());
				pap[i].setSumRealPay(ap[i].getSumRealPay());
				pap[i].setPreChargeAmount(ap[i].getPreChargeAmount());
				pap[i].setCheckDeptCode(ap[i].getCheckDeptCode());
			}
		}
		return pap;
	}

	/**
	 * 将接口的入参reCaseRequestInfo的PrpLinterCompeInvMainDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCompeInvMainDto对象数组
	 * @param reCaseRequestInfo
	 * @return PrpLinterCompeInvMainDto[]
	 * @throws Exception
	 */
	private PrpLinterCompeInvMainDto[] getPrpLinterCompeInvMainDtos(ReCaseRequestInfo reCaseRequestInfo){
		CompeInvMainInfo[] ap = reCaseRequestInfo.getCompeInvMainInfo();
		PrpLinterCompeInvMainDto[] pap = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterCompeInvMainDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if( ap[i] != null){
				pap[i] = new PrpLinterCompeInvMainDto();
				pap[i].setId(id);
				pap[i].setSerialNo(i);
				pap[i].setSettleListCode(ap[i].getSettleListCode());
				pap[i].setRegistNo(ap[i].getRegistNo());
				pap[i].setClaimNo(ap[i].getClaimNo());
				pap[i].setCompensateNo(ap[i].getCompensateNo());
				pap[i].setDateSourceName(ap[i].getDateSourceName());
				CompeInvDetailInfo[] cid = ap[i].getCompeInvDetailInfo();
				PrpLinterCompeInvDetailDto[] plc = new PrpLinterCompeInvDetailDto[cid.length];
				if(cid != null){
					for(int j=0;j<cid.length;j++){
						if(cid[j] != null){
							plc[j] = new PrpLinterCompeInvDetailDto();
							plc[j].setId(id);
							plc[j].setSerialNo(cid[j].getSerialNo());
							plc[j].setBank(cid[j].getBank());
							plc[j].setCreditCard(cid[j].getCreditCard());
							plc[j].setDetilSerialNo(cid[j].getDetilSerialNo());
							plc[j].setIdCard(cid[j].getIdCard());
							plc[j].setMedicalCard(cid[j].getMedicalCard());
							plc[j].setMedicalFamily(cid[j].getMedicalFamily());
							plc[j].setName(cid[j].getName());
							plc[j].setSettleSum(cid[j].getSettleSum());
							plc[j].setSumInsured(cid[j].getSumInsured());
						}
					}
					pap[i].setPrpLinterCompeInvDetailDto(plc);
				}
			}
		}
		return pap;
	}

}
