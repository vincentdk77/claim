package com.sinosoft.ciplatform.dto.domain;

import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * ��������ƽ̨���߳���Ϣ������ݴ���������<br>
 * ������2010-03-29
 */
public class CIClaimThirdCarDtoBase {
	private String claimCode      = "";//������루��ĳ���
	private int serialNo       = 0;//���
	private String policyNo       = "";//������
	private String thirdClaimCode = "";//������루���߳���
	private String carMark        = "";//���ƺ���
	private String vehicleType    = "";//��������
	private String claimCompany   = "";//����˾����
	private String claimStatus    = "";//����״̬
	private String paySelfFlag    = "";//���������־
	private String registNo       = "";//������
	private String claimNo        = "";//������
	private DateTime accidentDate   = new DateTime();//����ʱ��
	private String accidentPlace  = "";//���յص�
	private double sumPaid        = 0;//�����
	
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getThirdClaimCode() {
		return thirdClaimCode;
	}
	public void setThirdClaimCode(String thirdClaimCode) {
		this.thirdClaimCode = thirdClaimCode;
	}
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
	public DateTime getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(DateTime accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}

	
}
