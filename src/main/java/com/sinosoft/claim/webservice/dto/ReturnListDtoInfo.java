package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 待回访清单接口
 * 待回访清单详细信息（ReturnListDtoInfo）
 * @author Administrator
 *
 */
public class ReturnListDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**机构*/
	private String comCode;
	/**机构名称*/
	private String comName;
	/**报案号*/
	private String registNo;
	/**保单号*/
	private String policyNo;
	/**险种*/
	private String riskCode;
	/**被保险人名称*/
	private String InsuredName;
	/**被保险人联系电话*/
	private String InsuredPhoneNumber;
	/**出险原因*/
	private String damageReason;
	/**出险时间*/
	private String damageDate;
	/**报案时间*/
	private String reportDate;
	/**结案时间*/
	private String endCaseDate;
	/**支付时间*/
	private String payrefDate;
	/**报案人*/
	private String reportorName;
	/**报案人联系电话*/
	private String reportorPhoneNumber;
	/**联系人*/
	private String linkerName;
	/**联系电话*/
	private String linkerPhoneNumber;
	/**报案操作人员*/
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
