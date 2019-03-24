package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class KindCodeDetailDtoInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 序号 */
	private String serialNo;
	/** 险别代码 */
	private String kindCode ;
	/** 险别名称 */
	private String kindName ;
	/** 标的代码 */
	private String itemCode ;
	/** 标的名称 */
	private String itemName ;
	/** 保额/限额 */
	private String amount ;
	/** 币别代码 */
	private String currency ;
	/** 币别名称 */
	private String currencyName ;
	
	public KindCodeDetailDtoInfo() {
		
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

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
}
