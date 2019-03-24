package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * ���ط��嵥�ӿ�
 * ���ط��嵥��ϸ��Ϣ��ReturnListDtoInfo��
 * @author Administrator
 *
 */
public class ReturnListDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**����*/
	private String comCode;
	/**��������*/
	private String comName;
	/**������*/
	private String registNo;
	/**������*/
	private String policyNo;
	/**����*/
	private String riskCode;
	/**������������*/
	private String InsuredName;
	/**����������ϵ�绰*/
	private String InsuredPhoneNumber;
	/**����ԭ��*/
	private String damageReason;
	/**����ʱ��*/
	private String damageDate;
	/**����ʱ��*/
	private String reportDate;
	/**�᰸ʱ��*/
	private String endCaseDate;
	/**֧��ʱ��*/
	private String payrefDate;
	/**������*/
	private String reportorName;
	/**��������ϵ�绰*/
	private String reportorPhoneNumber;
	/**��ϵ��*/
	private String linkerName;
	/**��ϵ�绰*/
	private String linkerPhoneNumber;
	/**����������Ա*/
	private String registOperator;
	public ReturnListDtoInfo() {
		super();
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getInsuredName() {
		return InsuredName;
	}
	public void setInsuredName(String insuredName) {
		InsuredName = insuredName;
	}
	public String getInsuredPhoneNumber() {
		return InsuredPhoneNumber;
	}
	public void setInsuredPhoneNumber(String insuredPhoneNumber) {
		InsuredPhoneNumber = insuredPhoneNumber;
	}
	public String getDamageReason() {
		return damageReason;
	}
	public void setDamageReason(String damageReason) {
		this.damageReason = damageReason;
	}
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getEndCaseDate() {
		return endCaseDate;
	}
	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}
	public String getPayrefDate() {
		return payrefDate;
	}
	public void setPayrefDate(String payrefDate) {
		this.payrefDate = payrefDate;
	}
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}
	public String getReportorPhoneNumber() {
		return reportorPhoneNumber;
	}
	public void setReportorPhoneNumber(String reportorPhoneNumber) {
		this.reportorPhoneNumber = reportorPhoneNumber;
	}
	public String getLinkerName() {
		return linkerName;
	}
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}
	public String getLinkerPhoneNumber() {
		return linkerPhoneNumber;
	}
	public void setLinkerPhoneNumber(String linkerPhoneNumber) {
		this.linkerPhoneNumber = linkerPhoneNumber;
	}
	public String getRegistOperator() {
		return registOperator;
	}
	public void setRegistOperator(String registOperator) {
		this.registOperator = registOperator;
	}
	
	


}
