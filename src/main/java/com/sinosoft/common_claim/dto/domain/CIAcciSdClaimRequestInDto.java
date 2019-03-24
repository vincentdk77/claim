package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;

/**
 * 山东意外险风险预警平台，立案登记接口数据基础类
 */
public class CIAcciSdClaimRequestInDto {
	private String claimNo = "";//立案号/分案号
	private String groupClaimNo = "";//团体赔案号
	private String claimType = "";//赔案类型
	private String claimDate = "";//立案日期；YYYYMMDDHH
	private String lossDate = "";//出险日期；YYYYMMDDHH
	private String lossCause = "";//出险原因
	private String lossArea = "";//出险地点
	private String name = "";//出险人姓名
	private String gender = "";//出险人性别
	private String birthday = "";//出险人出生日期；YYYYMMDD
	private String credentialType = "";//出险人证件类型;
	private String credentialNo = "";//出险人证件号码
	private String lossResult = "";//出险结果
	private String lossResultDate = "";//出险结果日期；YYYYMMDDHH
	private String isCancelClaim = "";//是否撤销案件；'1'是、‘0’否
	private String cancelDate = "";//案件撤销日期；YYYYMMDDHH
	private ArrayList<CIAcciSdClaimPolicyInfoDto> ciAcciSdClaimPolisyList= new ArrayList<CIAcciSdClaimPolicyInfoDto>();//保单信息对象
	
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
