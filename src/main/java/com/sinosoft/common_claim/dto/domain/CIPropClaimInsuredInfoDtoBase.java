package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Date;

public class CIPropClaimInsuredInfoDtoBase  implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
     *  默认构造方法,构造一个默认的CIPropClaimInsuredInfoDtoBase对象
     */
    public CIPropClaimInsuredInfoDtoBase(){
    }
	private String customerNo= "";//客户序号	
	private Date accidentDate= new Date();//出险日期	
	private String name= "";//客户姓名	
	private String gender= "";//性别	
	private Date birthDay= new Date();//出生年月	
	private String certNo= "";//身份证号码	
	private String certificateType= "";//证件类别	
	private String certificateNo= "";//证件号码	
	private String nation= "";//民族	
	private Date effectiveDate= new Date();//有效期限起始日期	
	private Date expireDate= new Date();//有效期限截止日期	
	private String customerSequenceNo = "";
	
	private ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList ;//险种列表 隶属于保单信息 

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
