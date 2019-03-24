package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Regist {
	private String confirmSequenceNo=""; 	//Ͷ��ȷ����
	private String claimCode="";	      	//�������
	private String policyNO="";			//������
	private String registNo="";			//������
	private String claimNo="";			//������
	private String damageDate;			//����ʱ��
	private String licenseNo="";			//���ƺ���
	private String licenseType="";			//��������
	private String selfPayFlag = "";	//���������־
	private String damageAddress = "";	//���յص�
	private String reportDate = "";		//����ʱ��
	private List thirdCarList = new ArrayList();//���߳���Ϣ
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
	 * �������߳���Ϣ
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
