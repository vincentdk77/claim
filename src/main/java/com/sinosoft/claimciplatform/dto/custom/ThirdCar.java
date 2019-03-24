package com.sinosoft.claimciplatform.dto.custom;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class ThirdCar {
	private String claimCode = "";//�������
	private String policyNo = "";//������
	private String licenseNo = "";//���ƺ���
	private String vehicleType= "";//��������
	private String claimCompany = "";//��������˾
	private String claimStatus = "";//����״̬
	private String paySelfFlag = "";//���������־
	private String registNo = "";//������
	private String claimNo = "";//������
	private String accidentPlace = "";//���յص�
	private String thirdClamCode = "";//�����������
	private String accidentDate = "";//����ʱ��
	private double sumpaid = 0D;//����ܽ��
	
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
