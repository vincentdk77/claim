package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HouseKindCodeDtoInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**��� */
	private String serialNo = "0";
	/**�ձ���� */
	private String kindCode;
	/**�ձ����� */
	private String kindName;
	/**��Ĵ��� */
	private String itemCode;
	/**������� */
	private String itemName;
	/**����/�޶� */
	private String amount;
	/**�ұ� */
	private String currency;
	
	public HouseKindCodeDtoInfo() {
		
	}

	
	public String getSerialNo() {
		return serialNo;
	}


	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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
}
