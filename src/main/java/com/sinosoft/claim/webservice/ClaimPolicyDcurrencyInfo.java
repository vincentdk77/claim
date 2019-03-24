package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyDcurrencyInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** �ұ� */
	private String currency;
	/** �ұ����� */
	private String currencyName;
	/** ���� */
	private String amout;
	/** ���� */
	private String premium;
	/** ���ܱұ�һ��� */
	private String sumExchangeRate;
	/** ���ܱұ𱣶� */
	private String sumAmout;
	/** ���ܱұ𱣷� */
	private String sumPremium;
	/** ֧���ұ�һ��� */
	private String payExchangeRate;
	/** ֧���ұ𱣶� */
	private String payAmout;
	/** ֧���ұ�𱣷� */
	private String payPremium;

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getAmout() {
		return amout;
	}

	public void setAmout(String amout) {
		this.amout = amout;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getSumExchangeRate() {
		return sumExchangeRate;
	}

	public void setSumExchangeRate(String sumExchangeRate) {
		this.sumExchangeRate = sumExchangeRate;
	}

	public String getSumAmout() {
		return sumAmout;
	}

	public void setSumAmout(String sumAmout) {
		this.sumAmout = sumAmout;
	}

	public String getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}

	public String getPayExchangeRate() {
		return payExchangeRate;
	}

	public void setPayExchangeRate(String payExchangeRate) {
		this.payExchangeRate = payExchangeRate;
	}

	public String getPayAmout() {
		return payAmout;
	}

	public void setPayAmout(String payAmout) {
		this.payAmout = payAmout;
	}

	public String getPayPremium() {
		return payPremium;
	}

	public void setPayPremium(String payPremium) {
		this.payPremium = payPremium;
	}

}
