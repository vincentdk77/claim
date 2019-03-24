package com.sinosoft.claim.ui.control.facade;
/**
 * 事故信息平台接口入参head信息
 * @author wxy
 * 20180704
 */
public class RequestBaseDto implements Cloneable {
	private String requestType    ;
	private String userCode       ;
	private String passWord       ;
	private String institutionCode;
	private String acciAreaCode   ;
	private String ResponseCode;
	private String ErrorCode;
	private String ErrorMessage;

	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	public String getAcciAreaCode() {
		return acciAreaCode;
	}
	public void setAcciAreaCode(String acciAreaCode) {
		this.acciAreaCode = acciAreaCode;
	}
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
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
