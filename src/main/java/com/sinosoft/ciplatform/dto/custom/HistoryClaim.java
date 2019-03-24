package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

public class HistoryClaim {
	private String claimCompany="";//��������˾ 
	private String carMark="";//�永�������ƺ���
	private String vehicleType="";//�永������������
	private String isInsuredCar="";//�Ƿ��ǳб�����
	private String coverageType="";//�永��������
	private String registNo="";//������
	private String claimNo="";//������
	private String policyNo="";//������
	private Date accidentTime;//����ʱ��
	private Date registTime;//����ʱ��
	private Date endCaseTime;//�᰸ʱ��
	private double unClaimAmount=0;//������
	private double claimAmount=0;//�����
	private String caseStatus="";//����״̬
	private String accidentPlace="";//���յص�
	private String accidentDesc="";//���վ���
	private String IndemnityDuty="";//�¹���������
	private String endCaseno="";//�᰸��
	public String getCarMark() {
		return carMark;
	}
	public void setCarMark(String carMark) {
		this.carMark = carMark;
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
	public Date getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
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
	public Date getEndCaseTime() {
		return endCaseTime;
	}
	public void setEndCaseTime(Date endCaseTime) {
		this.endCaseTime = endCaseTime;
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
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public double getUnClaimAmount() {
		return unClaimAmount;
	}
	public void setUnClaimAmount(double unClaimAmount) {
		this.unClaimAmount = unClaimAmount;
	}
	public String getEndCaseno() {
		return endCaseno;
	}
	public void setEndCaseno(String endCaseno) {
		this.endCaseno = endCaseno;
	}
}
