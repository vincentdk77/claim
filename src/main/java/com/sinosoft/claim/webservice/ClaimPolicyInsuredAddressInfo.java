package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyInsuredAddressInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** �������� */
	private String addressCode;
	/** ��ַ */
	private String addressName;

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

}
