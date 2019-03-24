package com.sinosoft.claimciplatform.dto.custom;

import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class HistoryClaim {
	private String claimCode = "";//�������
	private int serialNo = 0;//���
	private String claimCompany = "";//��������˾
	private String licenseNo = "";//���ƺ���
	private String vehicleType = "";//��������
	private String isInsuredCar = "";//�Ƿ��ǳб�����
	private String coverageType = "";//�永��������
	private String registNo = "";//������
	private String claimNo = "";//������
	private String policyNo = "";//������
	private DateTime accidentTime = new DateTime();//����ʱ��
	private DateTime registTime = new DateTime();//����ʱ��
	private DateTime endCaseTime = new DateTime();//�᰸ʱ��
	private double unClaimAmount = 0;//������
	private double claimAmount = 0;//�����
	private String caseStatus = "";//����״̬
	private String accidentPlace = "";//���յص�
	private String accidentDesc = "";//���վ���
	private String IndemnityDuty = "";//�¹���������
	
	
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
