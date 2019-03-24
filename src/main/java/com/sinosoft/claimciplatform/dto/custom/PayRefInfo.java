package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.ciplatform.dto.custom.Paydata;

public class PayRefInfo {
	/**理赔编号*/
	private String claimCode = "";
	/**投保确认码*/
	private String confirmSequenceNo = "";
	/**序号*/
	private String serialNo = "";
	/**赔付类型*/
	//private String payType = "";
	/**赔付时间*/
	//private String payDate = "";
	/**赔付金额*/
	private double payAmount = 0D;
	/**保单号*/
	private String policyNO="";
	/**报案号*/
	private String registNo="";
	/**立案号*/
	private String claimNo="";
	/**计算书号序列*/
	private String compensateNos = "";
	
	private String preCompensateNos = "";
	/**赔款支付开户行*/
	private String bankName = "";
	/**赔款支付账户号*/
	private String accountNumber = "";
	/**赔款支付账户名*/
	private String accountName = "";
	/**收款账户明细列表*/
	private List<Paydata> payDataList = new ArrayList<Paydata>();
	
	public String getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
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

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getCompensateNos() {
		return compensateNos;
	}

	public void setCompensateNos(String compensateNos) {
		this.compensateNos = compensateNos;
	}

	public String getPreCompensateNos() {
		return preCompensateNos;
	}

	public void setPreCompensateNos(String preCompensateNos) {
		this.preCompensateNos = preCompensateNos;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public List<Paydata> getPayDataList() {
		return payDataList;
	}

	public void setPayDataList(List<Paydata> payDataList) {
		this.payDataList = payDataList;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}

	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	
}
