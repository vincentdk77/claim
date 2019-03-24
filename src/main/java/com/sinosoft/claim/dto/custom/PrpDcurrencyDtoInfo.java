package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PrpDcurrencyDtoInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ���Աұ���� */
	private String currencyCode = "";
	/** ���Աұ��������� */
	private String currencyCName = "";

	public PrpDcurrencyDtoInfo(String currencyCode, String currencyCName) {
		this.currencyCode = currencyCode;
		this.currencyCName = currencyCName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCName() {
		return currencyCName;
	}

	public void setCurrencyCName(String currencyCName) {
		this.currencyCName = currencyCName;
	}
}
