package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 支付信息回访清单
 * 支付信息回访清单详细信息（PaymentListInfo）
 * @author Administrator
 *
 */
public class PaymentListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String insuredname;
	private String bank;
	private String account;
	private String receiverName;
	private String times = "0";
	private String intPerilCount = "0";
	private String sumdutyPaid = "0"; 
	private String sumnodutyFee = "0";
	private String sumpaid = "0";
	private String sumprepaid = "0";
	private String sumPreChargeAmount = "0";
	private String sumthispaid = "0";
	private String context;
	private String payrefDate;
	public PaymentListInfo() {
		super();
	}
	public String getInsuredname() {
		return insuredname;
	}
	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getPayrefDate() {
		return payrefDate;
	}
	public void setPayrefDate(String payrefDate) {
		this.payrefDate = payrefDate;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getIntPerilCount() {
		return intPerilCount;
	}
	public void setIntPerilCount(String intPerilCount) {
		this.intPerilCount = intPerilCount;
	}
	public String getSumdutyPaid() {
		return sumdutyPaid;
	}
	public void setSumdutyPaid(String sumdutyPaid) {
		this.sumdutyPaid = sumdutyPaid;
	}
	public String getSumnodutyFee() {
		return sumnodutyFee;
	}
	public void setSumnodutyFee(String sumnodutyFee) {
		this.sumnodutyFee = sumnodutyFee;
	}
	public String getSumpaid() {
		return sumpaid;
	}
	public void setSumpaid(String sumpaid) {
		this.sumpaid = sumpaid;
	}
	public String getSumprepaid() {
		return sumprepaid;
	}
	public void setSumprepaid(String sumprepaid) {
		this.sumprepaid = sumprepaid;
	}
	public String getSumPreChargeAmount() {
		return sumPreChargeAmount;
	}
	public void setSumPreChargeAmount(String sumPreChargeAmount) {
		this.sumPreChargeAmount = sumPreChargeAmount;
	}
	public String getSumthispaid() {
		return sumthispaid;
	}
	public void setSumthispaid(String sumthispaid) {
		this.sumthispaid = sumthispaid;
	}
	

}
