package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;

public class CIPropClaimInsuredInfoDtoBase  implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIPropClaimInsuredInfoDtoBase����
     */
    public CIPropClaimInsuredInfoDtoBase(){
    }
	private String customerNo= "";//�ͻ����	
	private Date accidentDate= new Date();//��������	
	private String name= "";//�ͻ�����	
	private String gender= "";//�Ա�	
	private Date birthDay= new Date();//��������	
	private String certNo= "";//���֤����	
	private String certificateType= "";//֤�����	
	private String certificateNo= "";//֤������	
	private String nation= "";//����	
	private Date effectiveDate= new Date();//��Ч������ʼ����	
	private Date expireDate= new Date();//��Ч���޽�ֹ����	
	private String customerSequenceNo = "";
	
	private ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList ;//�����б� �����ڱ�����Ϣ 

	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public Date getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
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
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getCertNo() {
		return certNo;
	}
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	public String getCertificateType() {
		return certificateType;
	}
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public Date getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	public String getCustomerSequenceNo() {
		return customerSequenceNo;
	}
	public void setCustomerSequenceNo(String customerSequenceNo) {
		this.customerSequenceNo = customerSequenceNo;
	}
	public ArrayList<CIPropClaimCoverageInfoDto> getCiPropClaimCoverageList() {
		return ciPropClaimCoverageList;
	}
	public void setCiPropClaimCoverageList(
			ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList) {
		this.ciPropClaimCoverageList = ciPropClaimCoverageList;
	}


}
