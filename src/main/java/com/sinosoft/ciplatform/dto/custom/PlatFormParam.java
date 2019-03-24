package com.sinosoft.ciplatform.dto.custom;

public class PlatFormParam {
	private String userName="";
	private String userPwd="";
	private String url="";
	private String comcode = "";
	private boolean CIflag;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public PlatFormParam(){
		
	}
	public PlatFormParam(String url,String userName,String password){
		this.userName = userName;
		this.userPwd = password;
		this.url = url;
	}
	public boolean isCIflag() {
		return CIflag;
	}
	public void setCIflag(boolean iflag) {
		CIflag = iflag;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
}
