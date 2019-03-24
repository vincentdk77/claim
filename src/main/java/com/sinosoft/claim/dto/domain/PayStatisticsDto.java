package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class PayStatisticsDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String comCode;
	private String inputDate;
	private String payDate;
	private String payStatus;
	private String registNo;
	private String insuredName;
	private String compensateNo;
	private String underWriteEnddate;
	private String endCaseDate;
	private String userName;
	private String sumPaid;
	private String sumDutyPaid;
	private String payPaid;
	private String policyNo;
	private String comName;
	private String payStatusName;
	private String paymentNo;
	private String certifno;
	private String receiverfullname;
	public String getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	public String getPayStatusName() {
		return payStatusName;
	}
	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getUnderWriteEnddate() {
		return underWriteEnddate;
	}
	public void setUnderWriteEnddate(String underWriteEnddate) {
		this.underWriteEnddate = underWriteEnddate;
	}
	public String getEndCaseDate() {
		return endCaseDate;
	}
	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(String sumPaid) {
		this.sumPaid = sumPaid;
	}
	public String getSumDutyPaid() {
		return sumDutyPaid;
	}
	public void setSumDutyPaid(String sumDutyPaid) {
		this.sumDutyPaid = sumDutyPaid;
	}
	public String getPayPaid() {
		return payPaid;
	}
	public void setPayPaid(String payPaid) {
		this.payPaid = payPaid;
	}
	public String getCertifno() {
		return certifno;
	}
	public void setCertifno(String certifno) {
		this.certifno = certifno;
	}
	public String getReceiverfullname() {
		return receiverfullname;
	}
	public void setReceiverfullname(String receiverfullname) {
		this.receiverfullname = receiverfullname;
	}
}
