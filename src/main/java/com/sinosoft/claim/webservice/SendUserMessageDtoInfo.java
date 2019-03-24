package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class SendUserMessageDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String[] policyNo;
	private String userType;
	private String userTypeName;
	private String userName;
	private String phoneNumber;
	public SendUserMessageDtoInfo() {
		super();
	}
	public String[] getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String[] policyNo) {
		this.policyNo = policyNo;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
