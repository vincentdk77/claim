package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class CvirturlItemKindDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**险别代码*/
	private String kindCode;
	/**险别名称*/
	private String kindName;
	/**方案类别*/
	private String rationType;
	/**标的明细名称*/
	private String itemDetailName;
	/**币别代码*/
	private String currency;
	/**币别名称*/
	private String currencyName;
	/**保险金额*/
	private String amount;
	/**保费*/
	private String premium;
	
	public CvirturlItemKindDtoInfo() {
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getRationType() {
		return rationType;
	}
	public void setRationType(String rationType) {
		this.rationType = rationType;
	}
	public String getItemDetailName() {
		return itemDetailName;
	}
	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getPremium() {
		return premium;
	}
	public void setPremium(String premium) {
		this.premium = premium;
	}
	

}
