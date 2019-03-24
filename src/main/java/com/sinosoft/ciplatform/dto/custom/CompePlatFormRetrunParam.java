package com.sinosoft.ciplatform.dto.custom;

public class CompePlatFormRetrunParam {
	
	private String requestType = "";

	private String responseCode = "";

	private String errorMessage = "";
	
	private String ciPlatFormCode="";

	public String getCiPlatFormCode() {
		return ciPlatFormCode;
	}

	public void setCiPlatFormCode(String ciPlatFormCode) {
		this.ciPlatFormCode = ciPlatFormCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

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

}
