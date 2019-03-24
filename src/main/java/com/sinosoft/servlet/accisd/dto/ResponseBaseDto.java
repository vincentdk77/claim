package com.sinosoft.servlet.accisd.dto;
/**
 * 事故信息平台接口返参head信息
 * @author wxy
 * 20180704
 */
public class ResponseBaseDto implements Cloneable {
	private String requestType ;
	private String responseCode     ;
	private String errorCode   ;
	private String errorMessage;
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
