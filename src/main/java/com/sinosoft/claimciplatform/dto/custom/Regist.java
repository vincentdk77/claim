package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Regist {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private String policyNO="";			//保单号
	private String registNo="";			//报案号
	private String claimNo="";			//立案号
	private String damageDate;			//出险时间
	private String licenseNo="";			//号牌号码
	private String licenseType="";			//号牌类型
	private String selfPayFlag = "";	//互碰自赔标志
	private String damageAddress = "";	//出险地点
	private String reportDate = "";		//报案时间
	private List thirdCarList = new ArrayList();//三者车信息
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
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
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public List getThirdCarList() {
		return thirdCarList;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
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
	
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	/**
	 * 增加三者车信息
	 * @param thirdCar
	 */
	public void addThirdCar(ThirdCar thirdCar){
		this.thirdCarList.add(thirdCar);
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	
}
