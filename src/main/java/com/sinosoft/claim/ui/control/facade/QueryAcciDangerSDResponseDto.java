package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.List;

public class QueryAcciDangerSDResponseDto extends RequestBaseDto{
	private String InsuredName     ;
	private String Gender          ;
	private String Birthday        ;
	private String CredentialType  ;
	private String CredentialNo    ;
	private String IsRisk          ;
	private String LossTimes       ;
	private String SumClaimAmount  ;
	private String RefuseClaimTimes;
	private List<AcciDangerSDClaimInfoDto> claimInfoDtoList = new ArrayList<AcciDangerSDClaimInfoDto>();
	public String getInsuredName() {
		return InsuredName;
	}
	public void setInsuredName(String insuredName) {
		InsuredName = insuredName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getBirthday() {
		return Birthday;
	}
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	public String getCredentialType() {
		return CredentialType;
	}
	public void setCredentialType(String credentialType) {
		CredentialType = credentialType;
	}
	public String getCredentialNo() {
		return CredentialNo;
	}
	public void setCredentialNo(String credentialNo) {
		CredentialNo = credentialNo;
	}
	public String getIsRisk() {
		return IsRisk;
	}
	public void setIsRisk(String isRisk) {
		IsRisk = isRisk;
	}
	public String getLossTimes() {
		return LossTimes;
	}
	public void setLossTimes(String lossTimes) {
		LossTimes = lossTimes;
	}
	public String getSumClaimAmount() {
		return SumClaimAmount;
	}
	public void setSumClaimAmount(String sumClaimAmount) {
		SumClaimAmount = sumClaimAmount;
	}
	public String getRefuseClaimTimes() {
		return RefuseClaimTimes;
	}
	public void setRefuseClaimTimes(String refuseClaimTimes) {
		RefuseClaimTimes = refuseClaimTimes;
	}
	public List<AcciDangerSDClaimInfoDto> getClaimInfoDtoList() {
		return claimInfoDtoList;
	}
	public void setClaimInfoDtoList(List<AcciDangerSDClaimInfoDto> claimInfoDtoList) {
		this.claimInfoDtoList = claimInfoDtoList;
	}
}
