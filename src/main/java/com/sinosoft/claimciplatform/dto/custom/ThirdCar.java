package com.sinosoft.claimciplatform.dto.custom;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class ThirdCar {
	private String claimCode = "";//理赔编码
	private String policyNo = "";//保单号
	private String licenseNo = "";//号牌号码
	private String vehicleType= "";//号牌种类
	private String claimCompany = "";//理赔受理公司
	private String claimStatus = "";//案件状态
	private String paySelfFlag = "";//互碰自赔标志
	private String registNo = "";//报案号
	private String claimNo = "";//立案号
	private String accidentPlace = "";//出险地点
	private String thirdClamCode = "";//三者理赔编码
	private String accidentDate = "";//出险时间
	private double sumpaid = 0D;//赔款总金额
	
	public ThirdCar(){
		
	}
	
	public ThirdCar(String licenseNo){
		this.licenseNo = licenseNo;
	}
	
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getClaimCompany() {
		return claimCompany;
	}
	public void setClaimCompany(String claimCompany) {
		this.claimCompany = claimCompany;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getPaySelfFlag() {
		return paySelfFlag;
	}
	public void setPaySelfFlag(String paySelfFlag) {
		this.paySelfFlag = paySelfFlag;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	
	public String getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}
	public double getSumpaid() {
		return sumpaid;
	}
	public void setSumpaid(double sumpaid) {
		this.sumpaid = sumpaid;
	}
	public String getThirdClamCode() {
		return thirdClamCode;
	}
	public void setThirdClamCode(String thirdClamCode) {
		this.thirdClamCode = thirdClamCode;
	}

}
