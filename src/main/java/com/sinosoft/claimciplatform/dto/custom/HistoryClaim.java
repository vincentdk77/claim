package com.sinosoft.claimciplatform.dto.custom;

import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class HistoryClaim {
	private String claimCode = "";//理赔编码
	private int serialNo = 0;//序号
	private String claimCompany = "";//理赔受理公司
	private String licenseNo = "";//车牌号码
	private String vehicleType = "";//号牌种类
	private String isInsuredCar = "";//是否是承保车辆
	private String coverageType = "";//涉案险种类型
	private String registNo = "";//报案号
	private String claimNo = "";//立案号
	private String policyNo = "";//保单号
	private DateTime accidentTime = new DateTime();//出险时间
	private DateTime registTime = new DateTime();//报案时间
	private DateTime endCaseTime = new DateTime();//结案时间
	private double unClaimAmount = 0;//估损金额
	private double claimAmount = 0;//赔款金额
	private String caseStatus = "";//案件状态
	private String accidentPlace = "";//出险地点
	private String accidentDesc = "";//出险经过
	private String IndemnityDuty = "";//事故责任类型
	
	
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
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
	public String getIsInsuredCar() {
		return isInsuredCar;
	}
	public void setIsInsuredCar(String isInsuredCar) {
		this.isInsuredCar = isInsuredCar;
	}
	public String getCoverageType() {
		return coverageType;
	}
	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}
	public String getAccidentDesc() {
		return accidentDesc;
	}
	public void setAccidentDesc(String accidentDesc) {
		this.accidentDesc = accidentDesc;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}	
	
	public DateTime getAccidentTime() {
		return accidentTime;
	}
	public String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimCompany() {
		return claimCompany;
	}
	public void setClaimCompany(String claimCompany) {
		this.claimCompany = claimCompany;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getIndemnityDuty() {
		return IndemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		IndemnityDuty = indemnityDuty;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}	
	public double getUnClaimAmount() {
		return unClaimAmount;
	}
	
	public DateTime getRegistTime() {
		return registTime;
	}
	public void setRegistTime(DateTime registTime) {
		this.registTime = registTime;
	}
	public DateTime getEndCaseTime() {
		return endCaseTime;
	}
	public void setEndCaseTime(DateTime endCaseTime) {
		this.endCaseTime = endCaseTime;
	}
	public void setAccidentTime(DateTime accidentTime) {
		this.accidentTime = accidentTime;
	}
	public void setUnClaimAmount(double unClaimAmount) {
		this.unClaimAmount = unClaimAmount;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	
}
