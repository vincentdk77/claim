package com.sinosoft.common_claim.dto.domain;

/**
 * ������ղ�ѯ������
 * @author Administrator
 *
 */
public class CIAcciSdRiskRequestInDto {
	private String insuredName = "";//����������
	private String gender = "";//�������Ա�
	private String birthday = "";//�����˳������ڣ�YYYYMMDD
	private String credentialType = "";//������֤������
	private String credentialNo = "";//������֤������
	private String lossDate = "";//�������ڣ�YYYYMMDDHH
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
