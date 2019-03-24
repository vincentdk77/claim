package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyDcurrencyInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 币别 */
	private String currency;
	/** 币别名称 */
	private String currencyName;
	/** 保额 */
	private String amout;
	/** 保费 */
	private String premium;
	/** 汇总币别兑换率 */
	private String sumExchangeRate;
	/** 汇总币别保额 */
	private String sumAmout;
	/** 汇总币别保费 */
	private String sumPremium;
	/** 支付币别兑换率 */
	private String payExchangeRate;
	/** 支付币别保额 */
	private String payAmout;
	/** 支付币别别保费 */
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
