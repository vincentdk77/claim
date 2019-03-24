package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class PayExtBySeriousInDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** ÐòºÅ */
	private int serialNo;
	/** ²Ù×÷ÈË */
	private String operatorCodeName;
	/** ÄÚÈÝ */
	private String context;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getOperatorCodeName() {
		return operatorCodeName;
	}

	public void setOperatorCodeName(String operatorCodeName) {
		this.operatorCodeName = operatorCodeName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
	
}
