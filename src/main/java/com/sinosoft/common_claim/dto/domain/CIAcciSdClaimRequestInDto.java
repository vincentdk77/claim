package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;

/**
 * ɽ�������շ���Ԥ��ƽ̨�������Ǽǽӿ����ݻ�����
 */
public class CIAcciSdClaimRequestInDto {
	private String claimNo = "";//������/�ְ���
	private String groupClaimNo = "";//�����ⰸ��
	private String claimType = "";//�ⰸ����
	private String claimDate = "";//�������ڣ�YYYYMMDDHH
	private String lossDate = "";//�������ڣ�YYYYMMDDHH
	private String lossCause = "";//����ԭ��
	private String lossArea = "";//���յص�
	private String name = "";//����������
	private String gender = "";//�������Ա�
	private String birthday = "";//�����˳������ڣ�YYYYMMDD
	private String credentialType = "";//������֤������;
	private String credentialNo = "";//������֤������
	private String lossResult = "";//���ս��
	private String lossResultDate = "";//���ս�����ڣ�YYYYMMDDHH
	private String isCancelClaim = "";//�Ƿ���������'1'�ǡ���0����
	private String cancelDate = "";//�����������ڣ�YYYYMMDDHH
	private ArrayList<CIAcciSdClaimPolicyInfoDto> ciAcciSdClaimPolisyList= new ArrayList<CIAcciSdClaimPolicyInfoDto>();//������Ϣ����
	
	public CIAcciSdClaimRequestInDto(){
		
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getGroupClaimNo() {
		return groupClaimNo;
	}

	public void setGroupClaimNo(String groupClaimNo) {
		this.groupClaimNo = groupClaimNo;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}

	public String getLossDate() {
		return lossDate;
	}

	public void setLossDate(String lossDate) {
		this.lossDate = lossDate;
	}

	public String getLossCause() {
		return lossCause;
	}

	public void setLossCause(String lossCause) {
		this.lossCause = lossCause;
	}

	public String getLossArea() {
		return lossArea;
	}

	public void setLossArea(String lossArea) {
		this.lossArea = lossArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLossResult() {
		return lossResult;
	}

	public void setLossResult(String lossResult) {
		this.lossResult = lossResult;
	}

	public String getLossResultDate() {
		return lossResultDate;
	}

	public void setLossResultDate(String lossResultDate) {
		this.lossResultDate = lossResultDate;
	}

	public String getIsCancelClaim() {
		return isCancelClaim;
	}

	public void setIsCancelClaim(String isCancelClaim) {
		this.isCancelClaim = isCancelClaim;
	}

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public ArrayList<CIAcciSdClaimPolicyInfoDto> getCiAcciSdClaimPolisyList() {
		return ciAcciSdClaimPolisyList;
	}

	public void setCiAcciSdClaimPolisyList(
			ArrayList<CIAcciSdClaimPolicyInfoDto> ciAcciSdClaimPolisyList) {
		this.ciAcciSdClaimPolisyList = ciAcciSdClaimPolisyList;
	}
}
