package com.sinosoft.webservice.newpayment.res;

import java.io.Serializable;

public class Head implements Serializable {
	private static final long serialVersionUID = 1L;
	private String TransType;
	private String TransID;
	private String ChannelCode;
	private String ErrorCode;
	private String ErrorMessage;
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String transType) {
		TransType = transType;
	}
	public String getTransID() {
		return TransID;
	}
	public void setTransID(String transID) {
		TransID = transID;
	}
	public String getChannelCode() {
		return ChannelCode;
	}
	public void setChannelCode(String channelCode) {
		ChannelCode = channelCode;
	}
	public String getErrorCode() {
		return ErrorCode;
	}
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	
}
