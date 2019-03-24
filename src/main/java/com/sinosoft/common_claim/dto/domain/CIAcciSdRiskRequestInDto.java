package com.sinosoft.common_claim.dto.domain;

/**
 * 理赔风险查询基础类
 * @author Administrator
 *
 */
public class CIAcciSdRiskRequestInDto {
	private String insuredName = "";//出险人姓名
	private String gender = "";//出险人性别
	private String birthday = "";//出险人出生日期；YYYYMMDD
	private String credentialType = "";//出险人证件类型
	private String credentialNo = "";//出险人证件号码
	private String lossDate = "";//出险日期；YYYYMMDDHH
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCredentialType() {
		return credentialType;
	}
	public void setCredentialType(String credentialType) {
		this.credentialType = credentialType;
	}
	public String getCredentialNo() {
		return credentialNo;
	}
	public void setCredentialNo(String credentialNo) {
		this.credentialNo = credentialNo;
	}
	public String getLossDate() {
		return lossDate;
	}
	public void setLossDate(String lossDate) {
		this.lossDate = lossDate;
	}
	
	
}
