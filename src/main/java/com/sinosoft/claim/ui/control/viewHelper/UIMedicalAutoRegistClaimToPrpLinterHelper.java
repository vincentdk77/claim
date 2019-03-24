package com.sinosoft.claim.ui.control.viewHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sinosoft.claim.bl.action.domain.PrpLinterInjuryPersonDto;
import com.sinosoft.claim.bl.facade.BLPrpLinterRequestFacade;
import com.sinosoft.claim.dto.domain.PrpLinterAccdentPersonDto;
import com.sinosoft.claim.dto.domain.PrpLinterCertifyDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimAppDto;
import com.sinosoft.claim.dto.domain.PrpLinterClaimKindDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvDetailDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompeInvMainDto;
import com.sinosoft.claim.dto.domain.PrpLinterCompePayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterPrepayFeeDto;
import com.sinosoft.claim.dto.domain.PrpLinterRequestDto;
import com.sinosoft.claim.dto.domain.PrpLinterSchedExtDto;
import com.sinosoft.claim.ui.control.action.UIBillAction;
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
import com.sinosoft.claim.webservice.NewMoleSurvey;
import com.sinosoft.claim.webservice.PrepayFeeInfoDto;
import com.sinosoft.claim.webservice.PrpCinsuredDtoInfo;
import com.sinosoft.claim.webservice.SchedExtInfoDto;
import com.sinosoft.prpall.blsvr.cb.BLPrpCmain;
import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * 对象转换类
 * 将接口的入参claimdRequestInfo转化为大对象prpLinterRequestDto
 */
public class UIMedicalAutoRegistClaimToPrpLinterHelper {
	
	String id = "";
	
	/**
	 * 将接口的入参claimdRequestInfo转化为大对象prpLinterRequestDto
	 * @param claimdRequestInfo
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto claimToPrpLinter(ClaimRequestInfo claimRequestInfo) throws Exception{
		PrpLinterRequestDto prpLinterRequestDto = new PrpLinterRequestDto();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		id = sdf.format(date);
		
		String OutRigstNo = claimRequestInfo.getOutRigstNo();
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		String conditions = " OutRigstNo='"+OutRigstNo+"'";
		ArrayList interRequestList = (ArrayList)blPrpLinterRequestFacade.findByConditions(conditions);
		if(interRequestList!=null&&interRequestList.size()>0){
			prpLinterRequestDto = (PrpLinterRequestDto)interRequestList.get(0);
			id = prpLinterRequestDto.getId();
			if("1".equals(prpLinterRequestDto.getCompeAutoFlag())){
				
				
			}else if("".equals(prpLinterRequestDto.getCompeAutoFlag())&&"1".equals(prpLinterRequestDto.getRegistAutoFlag())){
				
				prpLinterRequestDto.setOutRigstNo(claimRequestInfo.getOutRigstNo());
				prpLinterRequestDto.setCheckContext(claimRequestInfo.getCheckContext());
				prpLinterRequestDto.setCheckDate(new DateTime(claimRequestInfo.getCheckDate()));
				prpLinterRequestDto.setChecker2(claimRequestInfo.getChecker2());
				prpLinterRequestDto.setCheckEstimateLoss(claimRequestInfo.getCheckEstimateLoss());
				prpLinterRequestDto.setCheckInfo(claimRequestInfo.getCheckInfo());
				prpLinterRequestDto.setCheckNature(claimRequestInfo.getCheckNature());
				prpLinterRequestDto.setCheckRemark(claimRequestInfo.getCheckRemark());
				prpLinterRequestDto.setCheckSite(claimRequestInfo.getCheckSite());
				prpLinterRequestDto.setCheckType(claimRequestInfo.getCheckType());
				prpLinterRequestDto.setClaimno(claimRequestInfo.getClaimno());
				prpLinterRequestDto.setClaimType(claimRequestInfo.getClaimType());
				prpLinterRequestDto.setEstimateFee(claimRequestInfo.getEstimateFee());
				prpLinterRequestDto.setEstimateLoss(claimRequestInfo.getEstimateLoss());
				//标示交互成功
				prpLinterRequestDto.setMutualFlag("1");
				prpLinterRequestDto.setNextHandlerCode(claimRequestInfo.getNextHandlerCode());
				prpLinterRequestDto.setNextHandlerName(claimRequestInfo.getNextHandlerName());
				prpLinterRequestDto.setPolicyno(claimRequestInfo.getPolicyno());
//				prpLinterRequestDto.setRegistno(claimRequestInfo.getRegistno());
				prpLinterRequestDto.setReplevyFlag(claimRequestInfo.getReplevyFlag());
				prpLinterRequestDto.setScheduleObjectId(claimRequestInfo.getScheduleObjectId());
				prpLinterRequestDto.setSumClaim(claimRequestInfo.getSumClaim());
				prpLinterRequestDto.setThirdComFlag(claimRequestInfo.getThirdComFlag());
				prpLinterRequestDto.setUnitType(claimRequestInfo.getUnitType());
				prpLinterRequestDto.setOutId(claimRequestInfo.getOutId());
				prpLinterRequestDto.setCompeTime(new DateTime(claimRequestInfo.getCompeTime(),DateTime.YEAR_TO_SECOND));
				prpLinterRequestDto.setCompeUser(claimRequestInfo.getCompeUser());
				//对象数组
				prpLinterRequestDto.setPrpLinterSchedExtDto(this.getPrpLinterSchedExtDtos(claimRequestInfo));
				prpLinterRequestDto.setPrpLinterClaimAppDto(this.getPrpLinterClaimAppDtos(claimRequestInfo));
				prpLinterRequestDto.setPrpLinterClaimKindDto(this.getPrpLinterClaimKindDtos(claimRequestInfo));
//				prpLinterRequestDto.setPrpLinterInjuryPersonArrayDto(this.getPrpLinterInjuryPersonArrayDto(claimRequestInfo));
				prpLinterRequestDto.setPrpLinterInjuryPersonDto(this.getPrpLinterInjuryPersonDtos(claimRequestInfo));
			}
			
		}else{
			UIBillAction uiBillAction = new UIBillAction();
			String tableName = "prplinterrequest";
			int year = DateTime.current().getYear();
			String  policyNo = claimRequestInfo.getPolicyno();
			BLPrpCmain  bLPrpCmain = new BLPrpCmain();
			bLPrpCmain.getData(policyNo);
			String riskCode = "2801";
			id = uiBillAction.getNo(tableName, riskCode,
					bLPrpCmain.getArr(0).getComCode(), year);
			
			prpLinterRequestDto.setId(id);
			prpLinterRequestDto.setDamageStartDate(new DateTime(claimRequestInfo.getDamageStartDate()));
			prpLinterRequestDto.setDamageStartHour(claimRequestInfo.getDamageStartHour());
			prpLinterRequestDto.setDamageCode(claimRequestInfo.getDamageCode());
			prpLinterRequestDto.setReportName(claimRequestInfo.getReportName());
			prpLinterRequestDto.setReportDate(new DateTime(claimRequestInfo.getReportDate()));
			prpLinterRequestDto.setReportHour(claimRequestInfo.getReportHour());
			prpLinterRequestDto.setReportType(claimRequestInfo.getReportType());
			prpLinterRequestDto.setLinkerName(claimRequestInfo.getLinkerName());
			prpLinterRequestDto.setPhoneNumber(claimRequestInfo.getPhoneNumber());
			prpLinterRequestDto.setLinkerAddress(claimRequestInfo.getLinkerAddress());
			prpLinterRequestDto.setClauseType(claimRequestInfo.getClauseType());
			prpLinterRequestDto.setDamageAddress(claimRequestInfo.getDamageAddress());
			prpLinterRequestDto.setDamageTypeCode(claimRequestInfo.getDamageTypeCode());
			prpLinterRequestDto.setDamageTypeName(claimRequestInfo.getDamageTypeName());
			prpLinterRequestDto.setLossesNumber(claimRequestInfo.getLossesNumber());
			prpLinterRequestDto.setOperatorCode(claimRequestInfo.getOperatorCode());
			prpLinterRequestDto.setOperatorName(claimRequestInfo.getOperatorName());
			prpLinterRequestDto.setMakeCom(claimRequestInfo.getMakeCom());
			prpLinterRequestDto.setMakeComName(claimRequestInfo.getMakeComName());
			prpLinterRequestDto.setReceiverName(claimRequestInfo.getReceiverName());
			prpLinterRequestDto.setContext(claimRequestInfo.getContext());
			prpLinterRequestDto.setCurrency(claimRequestInfo.getCurrency());
			prpLinterRequestDto.setRemark(claimRequestInfo.getRemark());
			prpLinterRequestDto.setRegistTime(new DateTime(claimRequestInfo.getRegistTime(),DateTime.YEAR_TO_SECOND));
			prpLinterRequestDto.setRegistUser(claimRequestInfo.getRegistUser());
			prpLinterRequestDto.setPrpLinterAccdentPersonDto(this.getPrpLinterAccdentPersonDtos(claimRequestInfo));
			
			
			//立案
			prpLinterRequestDto.setOutRigstNo(claimRequestInfo.getOutRigstNo());
			prpLinterRequestDto.setCheckContext(claimRequestInfo.getCheckContext());
			prpLinterRequestDto.setCheckDate(new DateTime(claimRequestInfo.getCheckDate()));
			prpLinterRequestDto.setChecker2(claimRequestInfo.getChecker2());
			prpLinterRequestDto.setCheckEstimateLoss(claimRequestInfo.getCheckEstimateLoss());
			prpLinterRequestDto.setCheckInfo(claimRequestInfo.getCheckInfo());
			prpLinterRequestDto.setCheckNature(claimRequestInfo.getCheckNature());
			prpLinterRequestDto.setCheckRemark(claimRequestInfo.getCheckRemark());
			prpLinterRequestDto.setCheckSite(claimRequestInfo.getCheckSite());
			prpLinterRequestDto.setCheckType(claimRequestInfo.getCheckType());
			prpLinterRequestDto.setClaimno(claimRequestInfo.getClaimno());
			prpLinterRequestDto.setClaimType(claimRequestInfo.getClaimType());
			prpLinterRequestDto.setEstimateFee(claimRequestInfo.getEstimateFee());
			prpLinterRequestDto.setEstimateLoss(claimRequestInfo.getEstimateLoss());
			//标示交互成功
			prpLinterRequestDto.setMutualFlag("1");
			prpLinterRequestDto.setNextHandlerCode(claimRequestInfo.getNextHandlerCode());
			prpLinterRequestDto.setNextHandlerName(claimRequestInfo.getNextHandlerName());
			prpLinterRequestDto.setPolicyno(claimRequestInfo.getPolicyno());
//			prpLinterRequestDto.setRegistno(claimRequestInfo.getRegistno());
			prpLinterRequestDto.setReplevyFlag(claimRequestInfo.getReplevyFlag());
			prpLinterRequestDto.setScheduleObjectId(claimRequestInfo.getScheduleObjectId());
			prpLinterRequestDto.setSumClaim(claimRequestInfo.getSumClaim());
			prpLinterRequestDto.setThirdComFlag(claimRequestInfo.getThirdComFlag());
			prpLinterRequestDto.setUnitType(claimRequestInfo.getUnitType());
			prpLinterRequestDto.setOutId(claimRequestInfo.getOutId());
			prpLinterRequestDto.setCompeTime(new DateTime(claimRequestInfo.getCompeTime(),DateTime.YEAR_TO_SECOND));
			prpLinterRequestDto.setCompeUser(claimRequestInfo.getCompeUser());
			//对象数组
			prpLinterRequestDto.setPrpLinterSchedExtDto(this.getPrpLinterSchedExtDtos(claimRequestInfo));
			prpLinterRequestDto.setPrpLinterClaimAppDto(this.getPrpLinterClaimAppDtos(claimRequestInfo));
			prpLinterRequestDto.setPrpLinterClaimKindDto(this.getPrpLinterClaimKindDtos(claimRequestInfo));
			
//			prpLinterRequestDto.setPrpLinterInjuryPersonArrayDto(this.getPrpLinterInjuryPersonArrayDto(claimRequestInfo));
			prpLinterRequestDto.setPrpLinterInjuryPersonDto(this.getPrpLinterInjuryPersonDtos(claimRequestInfo));
		}
		
		prpLinterRequestDto.setDamageCode(claimRequestInfo.getDamageCode());
		prpLinterRequestDto.setReportType(claimRequestInfo.getReportType());
		prpLinterRequestDto.setLinkerName(claimRequestInfo.getLinkerName());
		prpLinterRequestDto.setClauseType(claimRequestInfo.getClauseType());
		prpLinterRequestDto.setDamageAddress(claimRequestInfo.getDamageAddress());
		prpLinterRequestDto.setDamageTypeCode(claimRequestInfo.getDamageTypeCode());
		prpLinterRequestDto.setDamageTypeName(claimRequestInfo.getDamageTypeName());
		prpLinterRequestDto.setAccount(claimRequestInfo.getAccount());
		prpLinterRequestDto.setAccountOK(claimRequestInfo.getAccountOK());
		prpLinterRequestDto.setBank(claimRequestInfo.getBank());
		prpLinterRequestDto.setCaseType(claimRequestInfo.getCaseType());
		prpLinterRequestDto.setCertifyContext(claimRequestInfo.getCertifyContext());
		prpLinterRequestDto.setCompeContext(claimRequestInfo.getCompeContext());
		prpLinterRequestDto.setHandleText(claimRequestInfo.getHandleText());
		prpLinterRequestDto.setInputDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLinterRequestDto.setMakeCom(claimRequestInfo.getMakeCom());
		prpLinterRequestDto.setMakeComName(claimRequestInfo.getMakeComName());
		//标示交互成功
		prpLinterRequestDto.setMutualFlag("1");
		prpLinterRequestDto.setNotion(claimRequestInfo.getNotion());
		prpLinterRequestDto.setOperatorCode(claimRequestInfo.getOperatorCode());
		prpLinterRequestDto.setOperatorName(claimRequestInfo.getOperatorName());
		prpLinterRequestDto.setPayAppContext(claimRequestInfo.getPayAppContext());
		prpLinterRequestDto.setPolicyno(claimRequestInfo.getPolicyno());
		prpLinterRequestDto.setPrepayReport(claimRequestInfo.getPrepayReport());
		prpLinterRequestDto.setPrplCompensateSumPaid(claimRequestInfo.getPrplCompensateSumPaid());
		prpLinterRequestDto.setPrplCompensateSumPrePaid(claimRequestInfo.getPrplCompensateSumPrePaid());
		prpLinterRequestDto.setReceiverName(claimRequestInfo.getReceiverName());
		prpLinterRequestDto.setSumChargePaid(claimRequestInfo.getSumChargePaid());
		prpLinterRequestDto.setSumNoDutyFee(claimRequestInfo.getSumNoDutyFee());
		prpLinterRequestDto.setSumPrePaid(claimRequestInfo.getSumPrePaid());
		prpLinterRequestDto.setSumThisPaid(claimRequestInfo.getSumThisPaid());
		prpLinterRequestDto.setZeroLossType(claimRequestInfo.getZeroLossType());
		prpLinterRequestDto.setOutId(claimRequestInfo.getOutId());
		prpLinterRequestDto.setClaimAutoFlag("1");
		prpLinterRequestDto.setVericTime(new DateTime(claimRequestInfo.getVericTime(),DateTime.YEAR_TO_SECOND));
		prpLinterRequestDto.setVericUser(claimRequestInfo.getVericUser());
		//对象数组
		prpLinterRequestDto.setPrpLinterCertifyDto(this.getPrpLinterCertifyDtos(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterCompeFeeDto(this.getPrpLinterCompeFeeDtos(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterCompePayFeeDto(this.getPrpLinterCompePayFeeDtos(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterPrepayFeeDto(this.getPrpLinterPrepayFeeDtos(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterCompeInvMainDto(this.getPrpLinterCompeInvMainDtos(claimRequestInfo));
//		prpLinterRequestDto.setPrpLinterInjuryPersonArrayDto(this.getPrpLinterInjuryPersonArrayDto(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterInjuryPersonDto(this.getPrpLinterInjuryPersonDtos(claimRequestInfo));
		return prpLinterRequestDto;
	}
	
	
	/**
	 * 将接口的入参claimdRequestInfo转化为大对象prpLinterRequestDto
	 * @param claimdRequestInfo
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto registToPrpLinter(ClaimRequestInfo claimRequestInfo) throws Exception{
		PrpLinterRequestDto prpLinterRequestDto = new PrpLinterRequestDto();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		id = sdf.format(date);
		
		UIBillAction uiBillAction = new UIBillAction();
		String tableName = "prplinterrequest";
		int year = DateTime.current().getYear();
		String  policyNo = claimRequestInfo.getPolicyno();
		BLPrpCmain  bLPrpCmain = new BLPrpCmain();
		bLPrpCmain.getData(policyNo);
		String riskCode = "2801";
		id = uiBillAction.getNo(tableName, riskCode,
				bLPrpCmain.getArr(0).getComCode(), year);
		
		prpLinterRequestDto.setId(id);
		prpLinterRequestDto.setOutRigstNo(claimRequestInfo.getOutRigstNo());
		prpLinterRequestDto.setClauseType(claimRequestInfo.getClauseType());
		prpLinterRequestDto.setContext(claimRequestInfo.getContext());
		prpLinterRequestDto.setCurrency(claimRequestInfo.getCurrency());
		prpLinterRequestDto.setDamageAddress(claimRequestInfo.getDamageAddress());
		prpLinterRequestDto.setDamageCode(claimRequestInfo.getDamageCode());
		prpLinterRequestDto.setDamageStartDate(new DateTime(claimRequestInfo.getDamageStartDate()));
		prpLinterRequestDto.setDamageStartHour(claimRequestInfo.getDamageStartHour());
		prpLinterRequestDto.setDamageTypeCode(claimRequestInfo.getDamageTypeCode());
		prpLinterRequestDto.setDamageTypeName(claimRequestInfo.getDamageTypeName());
		prpLinterRequestDto.setInputRegistDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLinterRequestDto.setLinkerAddress(claimRequestInfo.getLinkerAddress());
		prpLinterRequestDto.setLinkerName(claimRequestInfo.getLinkerName());
		prpLinterRequestDto.setLossesNumber(claimRequestInfo.getLossesNumber());
		prpLinterRequestDto.setMakeCom(claimRequestInfo.getMakeCom());
		prpLinterRequestDto.setMakeComName(claimRequestInfo.getMakeComName());
		prpLinterRequestDto.setMutualFlag("1");
		prpLinterRequestDto.setOperatorCode(claimRequestInfo.getOperatorCode());
		prpLinterRequestDto.setOperatorName(claimRequestInfo.getOperatorName());
		prpLinterRequestDto.setPhoneNumber(claimRequestInfo.getPhoneNumber());
		prpLinterRequestDto.setPolicyno(claimRequestInfo.getPolicyno());
		prpLinterRequestDto.setReceiverName(claimRequestInfo.getReceiverName());
//		prpLinterRequestDto.setRegistno(claimRequestInfo.getRegistno());
		prpLinterRequestDto.setRemark(claimRequestInfo.getRemark());
		prpLinterRequestDto.setReportDate(new DateTime(claimRequestInfo.getReportDate()));
		prpLinterRequestDto.setReportHour(claimRequestInfo.getReportHour());
		prpLinterRequestDto.setReportName(claimRequestInfo.getReportName());
		prpLinterRequestDto.setReportType(claimRequestInfo.getReportType());
		prpLinterRequestDto.setOutId(claimRequestInfo.getOutId());
		prpLinterRequestDto.setRegistTime(new DateTime(claimRequestInfo.getRegistTime(),DateTime.YEAR_TO_SECOND));
		prpLinterRequestDto.setRegistUser(claimRequestInfo.getRegistUser());
		prpLinterRequestDto.setRegistAutoFlag("1");
		//对象数组
		prpLinterRequestDto.setPrpLinterAccdentPersonDto(this.getPrpLinterAccdentPersonDtos(claimRequestInfo));
		
		return prpLinterRequestDto;
	}
	
	/**
	 * 将接口的入参claimdRequestInfo转化为大对象prpLinterRequestDto
	 * @param claimdRequestInfo
	 * @return prpLinterRequestDto
	 * @throws Exception
	 */
	public PrpLinterRequestDto compeToPrpLinter(ClaimRequestInfo claimRequestInfo) throws Exception{
		PrpLinterRequestDto prpLinterRequestDto = new PrpLinterRequestDto();
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmsssss");
		id = sdf.format(date);
		
		String OutRigstNo = claimRequestInfo.getOutRigstNo();
		BLPrpLinterRequestFacade blPrpLinterRequestFacade = new BLPrpLinterRequestFacade();
		String conditions = " OutRigstNo='"+OutRigstNo+"'";
		ArrayList interRequestList = (ArrayList)blPrpLinterRequestFacade.findByConditions(conditions);
		if(interRequestList!=null&&interRequestList.size()>0){
			prpLinterRequestDto = (PrpLinterRequestDto)interRequestList.get(0);
			id = prpLinterRequestDto.getId();
			prpLinterRequestDto.setDamageCode(claimRequestInfo.getDamageCode());
			prpLinterRequestDto.setReportType(claimRequestInfo.getReportType());
			prpLinterRequestDto.setLinkerName(claimRequestInfo.getLinkerName());
			prpLinterRequestDto.setClauseType(claimRequestInfo.getClauseType());
			prpLinterRequestDto.setDamageAddress(claimRequestInfo.getDamageAddress());
			prpLinterRequestDto.setDamageTypeCode(claimRequestInfo.getDamageTypeCode());
			prpLinterRequestDto.setDamageTypeName(claimRequestInfo.getDamageTypeName());
		}else{
			UIBillAction uiBillAction = new UIBillAction();
			String tableName = "prplinterrequest";
			int year = DateTime.current().getYear();
			String  policyNo = claimRequestInfo.getPolicyno();
			BLPrpCmain  bLPrpCmain = new BLPrpCmain();
			bLPrpCmain.getData(policyNo);
			String riskCode = "2801";
			id = uiBillAction.getNo(tableName, riskCode,
					bLPrpCmain.getArr(0).getComCode(), year);
			prpLinterRequestDto.setId(id);
			prpLinterRequestDto.setDamageStartDate(new DateTime(claimRequestInfo.getDamageStartDate()));
			prpLinterRequestDto.setDamageStartHour(claimRequestInfo.getDamageStartHour());
			prpLinterRequestDto.setDamageCode(claimRequestInfo.getDamageCode());
			prpLinterRequestDto.setReportName(claimRequestInfo.getReportName());
			prpLinterRequestDto.setReportDate(new DateTime(claimRequestInfo.getReportDate()));
			prpLinterRequestDto.setReportHour(claimRequestInfo.getReportHour());
			prpLinterRequestDto.setReportType(claimRequestInfo.getReportType());
			prpLinterRequestDto.setLinkerName(claimRequestInfo.getLinkerName());
			prpLinterRequestDto.setPhoneNumber(claimRequestInfo.getPhoneNumber());
			prpLinterRequestDto.setLinkerAddress(claimRequestInfo.getLinkerAddress());
			prpLinterRequestDto.setClauseType(claimRequestInfo.getClauseType());
			prpLinterRequestDto.setDamageAddress(claimRequestInfo.getDamageAddress());
			prpLinterRequestDto.setDamageTypeCode(claimRequestInfo.getDamageTypeCode());
			prpLinterRequestDto.setDamageTypeName(claimRequestInfo.getDamageTypeName());
			prpLinterRequestDto.setLossesNumber(claimRequestInfo.getLossesNumber());
			prpLinterRequestDto.setOperatorCode(claimRequestInfo.getOperatorCode());
			prpLinterRequestDto.setOperatorName(claimRequestInfo.getOperatorName());
			prpLinterRequestDto.setMakeCom(claimRequestInfo.getMakeCom());
			prpLinterRequestDto.setMakeComName(claimRequestInfo.getMakeComName());
			prpLinterRequestDto.setReceiverName(claimRequestInfo.getReceiverName());
			prpLinterRequestDto.setContext(claimRequestInfo.getContext());
			prpLinterRequestDto.setCurrency(claimRequestInfo.getCurrency());
			prpLinterRequestDto.setRemark(claimRequestInfo.getRemark());
			prpLinterRequestDto.setRegistTime(new DateTime(claimRequestInfo.getRegistTime(),DateTime.YEAR_TO_SECOND));
			prpLinterRequestDto.setRegistUser(claimRequestInfo.getRegistUser());
			prpLinterRequestDto.setPrpLinterAccdentPersonDto(this.getPrpLinterAccdentPersonDtos(claimRequestInfo));
		}
		prpLinterRequestDto.setOutRigstNo(claimRequestInfo.getOutRigstNo());
		prpLinterRequestDto.setCheckContext(claimRequestInfo.getCheckContext());
		prpLinterRequestDto.setCheckDate(new DateTime(claimRequestInfo.getCheckDate()));
		prpLinterRequestDto.setChecker2(claimRequestInfo.getChecker2());
		prpLinterRequestDto.setCheckEstimateLoss(claimRequestInfo.getCheckEstimateLoss());
		prpLinterRequestDto.setCheckInfo(claimRequestInfo.getCheckInfo());
		prpLinterRequestDto.setCheckNature(claimRequestInfo.getCheckNature());
		prpLinterRequestDto.setCheckRemark(claimRequestInfo.getCheckRemark());
		prpLinterRequestDto.setCheckSite(claimRequestInfo.getCheckSite());
		prpLinterRequestDto.setCheckType(claimRequestInfo.getCheckType());
		prpLinterRequestDto.setClaimno(claimRequestInfo.getClaimno());
		prpLinterRequestDto.setClaimType(claimRequestInfo.getClaimType());
		prpLinterRequestDto.setEstimateFee(claimRequestInfo.getEstimateFee());
		prpLinterRequestDto.setEstimateLoss(claimRequestInfo.getEstimateLoss());
		//标示交互成功
		prpLinterRequestDto.setMutualFlag("1");
		prpLinterRequestDto.setNextHandlerCode(claimRequestInfo.getNextHandlerCode());
		prpLinterRequestDto.setNextHandlerName(claimRequestInfo.getNextHandlerName());
		prpLinterRequestDto.setPolicyno(claimRequestInfo.getPolicyno());
//		prpLinterRequestDto.setRegistno(claimRequestInfo.getRegistno());
		prpLinterRequestDto.setReplevyFlag(claimRequestInfo.getReplevyFlag());
		prpLinterRequestDto.setScheduleObjectId(claimRequestInfo.getScheduleObjectId());
		prpLinterRequestDto.setSumClaim(claimRequestInfo.getSumClaim());
		prpLinterRequestDto.setThirdComFlag(claimRequestInfo.getThirdComFlag());
		prpLinterRequestDto.setUnitType(claimRequestInfo.getUnitType());
		prpLinterRequestDto.setOutId(claimRequestInfo.getOutId());
		prpLinterRequestDto.setCompeTime(new DateTime(claimRequestInfo.getCompeTime(),DateTime.YEAR_TO_SECOND));
		prpLinterRequestDto.setCompeUser(claimRequestInfo.getCompeUser());
		prpLinterRequestDto.setInputCompeDate(new DateTime(DateTime.current(),DateTime.YEAR_TO_SECOND));
		prpLinterRequestDto.setCompeAutoFlag("1");
		//对象数组
		prpLinterRequestDto.setPrpLinterSchedExtDto(this.getPrpLinterSchedExtDtos(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterClaimAppDto(this.getPrpLinterClaimAppDtos(claimRequestInfo));
		prpLinterRequestDto.setPrpLinterClaimKindDto(this.getPrpLinterClaimKindDtos(claimRequestInfo));
		return prpLinterRequestDto;
	}
	
	/**
	 * 
	 * @param claimdRequestInfo
	 * @return PrpLinterAccdentPersonDto[]
	 * @throws Exception
	 */
	private PrpLinterAccdentPersonDto[] getPrpLinterAccdentPersonDtos(ClaimRequestInfo claimRequestInfo){
		PrpLinterAccdentPersonDto pap[] = null;
		String policyNo = claimRequestInfo.getPolicyno();
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
	 * 将接口的入参claimRequestInfo的SchedExtInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterSchedExtDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterSchedExtDto[]
	 * @throws Exception
	 */
	private PrpLinterSchedExtDto[] getPrpLinterSchedExtDtos(ClaimRequestInfo claimRequestInfo){
		SchedExtInfoDto[] se = claimRequestInfo.getSchedExtInfoDto();
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
	 * 将接口的入参claimRequestInfo的ClaimAppDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterClaimAppDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterClaimAppDto[]
	 * @throws Exception
	 */
	private PrpLinterClaimAppDto[] getPrpLinterClaimAppDtos(ClaimRequestInfo claimRequestInfo){
		ClaimAppDto[] ca = claimRequestInfo.getClaimAppDto();
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
	 * 将接口的入参claimRequestInfo的ClaimKindDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterClaimKindDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterClaimKindDto[]
	 * @throws Exception
	 */
	private PrpLinterInjuryPersonDto getPrpLinterInjuryPersonDtos(ClaimRequestInfo claimRequestInfo){
		InjuryPersonInfoDto ip = claimRequestInfo.getInjuryPersonInfoDto();
		PrpLinterInjuryPersonDto pjp = null;
		if(ip == null){
			return pjp;
		}
			pjp = new PrpLinterInjuryPersonDto();
			pjp.setId(id);
			pjp.setAcciName(ip.getAcciName());
			pjp.setSex(ip.getSex());
			pjp.setIdentifyNumber(ip.getIdentifyNumber());
		return pjp;
	}
	/**
	 * 将接口中的injuryPersonInfoDto对象转化为PrpLinterInjuryPersonDto对象*/
	private PrpLinterInjuryPersonDto[] getPrpLinterInjuryPersonArrayDto(ClaimRequestInfo claimRequestInfo){
		InjuryPersonInfoDto[] ip = claimRequestInfo.getInjuryPersonInfoArrayDto();
		PrpLinterInjuryPersonDto[] pca = null;
		if(ip == null){
			return pca;
		}
		pca = new PrpLinterInjuryPersonDto[ip.length];
		for(int i=0;i<ip.length;i++){
			if(ip[i] != null){
				pca[i] = new PrpLinterInjuryPersonDto();
				pca[i].setId(id);
				pca[i].setAcciName(ip[i].getAcciName());
				pca[i].setIdentifyNumber(ip[i].getIdentifyNumber());
				pca[i].setSex(ip[i].getSex());
			}
		}
		return pca;
	}
	private PrpLinterClaimKindDto[] getPrpLinterClaimKindDtos(ClaimRequestInfo claimRequestInfo){
		ClaimKindDto[] ck = claimRequestInfo.getClaimKindDto();
		PrpLinterClaimKindDto[] pck = null;
		if(ck == null){
			return pck;
		}
		pck = new PrpLinterClaimKindDto[ck.length];
		for(int i=0;i<ck.length;i++){
			if(ck[i] != null){
				pck[i] = new PrpLinterClaimKindDto();
				pck[i].setId(id);
				pck[i].setCurrency(ck[i].getCurrency());
				pck[i].setFamilyName(ck[i].getFamilyName());
				pck[i].setItemKindNo(ck[i].getItemKindNo());
				pck[i].setKindCode(ck[i].getKindCode());
				pck[i].setKindName(ck[i].getKindName());
				pck[i].setKindRest(ck[i].getKindRest());
				pck[i].setLossFeeType(ck[i].getLossFeeType());
				pck[i].setSerialNo(i);
				pck[i].setSumClaim(ck[i].getSumClaim());
			}
		}
		return pck;
	}
	
	/**
	 * 将接口的入参claimRequestInfo的PrepayFeeInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterPrepayFeeDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterPrepayFeeDto[]
	 * @throws Exception
	 */
	private PrpLinterPrepayFeeDto[] getPrpLinterPrepayFeeDtos(ClaimRequestInfo claimRequestInfo){
		PrepayFeeInfoDto[] ap = claimRequestInfo.getPrepayFeeInfoDto();
		PrpLinterPrepayFeeDto[] pap = null;
		if(ap == null){
			return pap;
		}
		pap = new PrpLinterPrepayFeeDto[ap.length];
		for(int i=0;i<ap.length;i++){
			if(ap[i] != null){
				pap[i] = new PrpLinterPrepayFeeDto();
				pap[i].setId(id);
				pap[i].setChargeCode(ap[i].getChargeCode());
				pap[i].setChargeName(ap[i].getChargeName());
				pap[i].setChargeReport(ap[i].getChargeReport());
				pap[i].setCurrency(ap[i].getCurrency());
				pap[i].setKindCode(ap[i].getKindCode());
				pap[i].setSerialNo(ap[i].getSerialNo());
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
	private PrpLinterCertifyDto[] getPrpLinterCertifyDtos(ClaimRequestInfo claimRequestInfo){
		CertifyInfoDto[] ap = claimRequestInfo.getCertifyInfoDto();
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
	 * 将接口的入参claimRequestInfo的CompeFeeInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCompeFeeDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterCompeFeeDto[]
	 * @throws Exception
	 */
	private PrpLinterCompeFeeDto[] getPrpLinterCompeFeeDtos(ClaimRequestInfo claimRequestInfo){
		CompeFeeInfoDto[] ap = claimRequestInfo.getCompeFeeInfoDto();
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
	 * 将接口的入参claimRequestInfo的CompePayFeeInfoDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCompePayFeeDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterCompePayFeeDto[]
	 * @throws Exception
	 */
	private PrpLinterCompePayFeeDto[] getPrpLinterCompePayFeeDtos(ClaimRequestInfo claimRequestInfo){
		CompePayFeeInfoDto[] ap = claimRequestInfo.getCompePayFeeInfoDto();
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
	 * 将接口的入参claimRequestInfo的PrpLinterCompeInvMainDto对象数组
	 * 转化为大对象prpLinterRequestDto的PrpLinterCompeInvMainDto对象数组
	 * @param claimRequestInfo
	 * @return PrpLinterCompeInvMainDto[]
	 * @throws Exception
	 */
	private PrpLinterCompeInvMainDto[] getPrpLinterCompeInvMainDtos(ClaimRequestInfo claimRequestInfo){
		CompeInvMainInfo[] ap = claimRequestInfo.getCompeInvMainInfo();
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
