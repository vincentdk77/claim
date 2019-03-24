package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class CvirturlItemKindDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**�ձ����*/
	private String kindCode;
	/**�ձ�����*/
	private String kindName;
	/**�������*/
	private String rationType;
	/**�����ϸ����*/
	private String itemDetailName;
	/**�ұ����*/
	private String currency;
	/**�ұ�����*/
	private String currencyName;
	/**���ս��*/
	private String amount;
	/**����*/
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
