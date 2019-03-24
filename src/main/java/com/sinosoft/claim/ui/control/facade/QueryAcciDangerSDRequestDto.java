package com.sinosoft.claim.ui.control.facade;

public class QueryAcciDangerSDRequestDto extends RequestBaseDto{
	private String InsuredName   ;
	private String Gender        ;
	private String Birthday      ;
	private String CredentialType;
	private String CredentialNo  ;
	private String LossDate      ;
	private String registNo      ;
	private String areaFlag      ;
	
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
	public String getLossDate() {
		return LossDate;
	}
	public void setLossDate(String lossDate) {
		LossDate = lossDate;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getAreaFlag() {
		return areaFlag;
	}
	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}
	
}
