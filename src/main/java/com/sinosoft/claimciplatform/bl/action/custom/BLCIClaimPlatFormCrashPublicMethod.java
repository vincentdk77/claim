package com.sinosoft.claimciplatform.bl.action.custom;

import com.sinosoft.claim.dto.domain.CiClaimCompelcrashDto;
import com.sinosoft.claimciplatform.dto.custom.CompelCrashDto;
import com.sinosoft.sysframework.common.datatype.DateTime;

public class BLCIClaimPlatFormCrashPublicMethod{
	public static CiClaimCompelcrashDto trasferACiClaimCompelcrashDto(
			CompelCrashDto compelCrashDto) {
		CiClaimCompelcrashDto ciClaimCompelcrashDto = new CiClaimCompelcrashDto();
		ciClaimCompelcrashDto.setRegistNo(compelCrashDto.getOwnAccidentInfor()
				.getReportNo());
		ciClaimCompelcrashDto.setPolicyNo(compelCrashDto.getOwnAccidentInfor()
				.getPolicyCode());
		ciClaimCompelcrashDto.setComCode(compelCrashDto.getOwnAccidentInfor()
				.getCompanyCode());
		ciClaimCompelcrashDto.setDriverName(compelCrashDto
				.getOwnAccidentInfor().getName());
		ciClaimCompelcrashDto.setIdNo(compelCrashDto.getOwnAccidentInfor()
				.getIdNo());
		ciClaimCompelcrashDto.setTelNo(compelCrashDto.getOwnAccidentInfor()
				.getTelNo());
		ciClaimCompelcrashDto.setCarNo(compelCrashDto.getOwnAccidentInfor()
				.getCarMark());
		ciClaimCompelcrashDto.setCarKind(compelCrashDto.getOwnAccidentInfor()
				.getVehicleType());
		ciClaimCompelcrashDto.setDamagePart(compelCrashDto
				.getOwnAccidentInfor().getDamagePart());
		ciClaimCompelcrashDto.setActorFlag("1");
		ciClaimCompelcrashDto.setRelatedRegistNo(compelCrashDto
				.getOtherAccidentInfor().getReportNo());
		ciClaimCompelcrashDto.setApplyCertainTime(trasTime(compelCrashDto.getApplyAssessmentTime()));
		ciClaimCompelcrashDto.setCertainStartTime(trasTime(compelCrashDto.getAssessStartTime()));
		ciClaimCompelcrashDto.setDamageDate(trasTime(compelCrashDto.getAccidentTime()));
		ciClaimCompelcrashDto.setFaultBehavior(compelCrashDto.getFaultBehavior());
		ciClaimCompelcrashDto.setFaultParty(compelCrashDto.getFaultParty());
		ciClaimCompelcrashDto.setReportDate(trasTime(compelCrashDto.getReportTime()));
		ciClaimCompelcrashDto.setDamageAddress(compelCrashDto.getAccidentPlace());
		return ciClaimCompelcrashDto;
	}

	public static CiClaimCompelcrashDto trasferBCiClaimCompelcrashDto(
			CompelCrashDto compelCrashDto) {
		CiClaimCompelcrashDto ciClaimCompelcrashDto = new CiClaimCompelcrashDto();
		ciClaimCompelcrashDto.setRegistNo(compelCrashDto
				.getOtherAccidentInfor().getReportNo());
		ciClaimCompelcrashDto.setPolicyNo(compelCrashDto
				.getOtherAccidentInfor().getPolicyCode());
		ciClaimCompelcrashDto.setComCode(compelCrashDto.getOtherAccidentInfor()
				.getCompanyCode());
		ciClaimCompelcrashDto.setDriverName(compelCrashDto
				.getOtherAccidentInfor().getName());
		ciClaimCompelcrashDto.setIdNo(compelCrashDto.getOtherAccidentInfor()
				.getIdNo());
		ciClaimCompelcrashDto.setTelNo(compelCrashDto.getOtherAccidentInfor()
				.getTelNo());
		ciClaimCompelcrashDto.setCarNo(compelCrashDto.getOtherAccidentInfor()
				.getCarMark());
		ciClaimCompelcrashDto.setCarKind(compelCrashDto.getOtherAccidentInfor()
				.getVehicleType());
		ciClaimCompelcrashDto.setDamagePart(compelCrashDto
				.getOtherAccidentInfor().getDamagePart());
		ciClaimCompelcrashDto.setActorFlag("2");
		ciClaimCompelcrashDto.setRelatedRegistNo(compelCrashDto
				.getOwnAccidentInfor().getReportNo());
		return ciClaimCompelcrashDto;
	}

	public static void setCiClaimCompelcrashDtoPubInfo(
			CiClaimCompelcrashDto ciClaimCompelcrashDto,
			CompelCrashDto compelCrashDto) {
		ciClaimCompelcrashDto.setFaultBehavior(compelCrashDto
				.getFaultBehavior());
		ciClaimCompelcrashDto.setFaultParty(compelCrashDto.getFaultParty());
		ciClaimCompelcrashDto.setDamageDate(trasTime(compelCrashDto
				.getAccidentTime()));
		ciClaimCompelcrashDto.setDamageAddress(compelCrashDto
				.getAccidentPlace());
		ciClaimCompelcrashDto.setReportDate(trasTime(compelCrashDto
				.getReportTime()));
		ciClaimCompelcrashDto.setApplyCertainTime(trasTime(compelCrashDto
				.getApplyAssessmentTime()));
		ciClaimCompelcrashDto.setCertainStartTime(trasTime(compelCrashDto.getAssessStartTime()));
		ciClaimCompelcrashDto.setAccidentNo(compelCrashDto.getAccidentNo());
	}
	public static DateTime  trasTime(String dateTime)
	{	
		DateTime	DateTime=new DateTime(dateTime.substring(0,2)+"-"+dateTime.substring(2,4)+"-"+dateTime.substring(4,6)
		+" "+dateTime.substring(6,8)+":"+dateTime.substring(8,10)+":00",new DateTime().YEAR_TO_SECOND);
		return DateTime;
      }
}
