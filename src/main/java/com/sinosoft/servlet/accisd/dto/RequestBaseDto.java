package com.sinosoft.servlet.accisd.dto;
/**
 * 事故信息平台接口入参head信息
 * @author wxy
 * 20180704
 */
public class RequestBaseDto implements Cloneable {
	private String requestType    ;
	private String userCode       ;
	private String passWord       ;

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
	
}
