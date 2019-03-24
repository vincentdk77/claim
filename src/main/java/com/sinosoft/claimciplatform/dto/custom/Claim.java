package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Claim {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private double unClaimAmount=0;//估损金额
	private String claimNo="";		//立案号
	private String registNo="";		//报案号
	private String policyNO="";		//保单号
	private String caseType="";		//理赔赔案类型
	private String licenseNo="";	//出险车牌号码
	private String licenseType="";	//出险车辆类型
	private String damageDate;		//出险时间 
	private String claimDate;		//立案时间 
	private String selfPayFlag = "";	//互碰自赔标志
	private String damageAddress = "";	//出险地点
	private List thirdCarList = new ArrayList();//三者车信息
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public double getUnClaimAmount() {
		return unClaimAmount;
	}
	public void setUnClaimAmount(double unClaimAmount) {
		this.unClaimAmount = unClaimAmount;
	}

	public List getThirdCarList() {
		return thirdCarList;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	
	public String getSelfPayFlag() {
		return selfPayFlag;
	}
	public void setSelfPayFlag(String selfPayFlag) {
		this.selfPayFlag = selfPayFlag;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	/**
	 * 增加三者车信息
	 * @param thirdCar
	 */
	public void addThirdCar(ThirdCar thirdCar){
		this.thirdCarList.add(thirdCar);
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	
}
