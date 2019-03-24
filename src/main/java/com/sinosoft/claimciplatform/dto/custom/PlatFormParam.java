package com.sinosoft.claimciplatform.dto.custom;

public class PlatFormParam {
	private String userName="";
	private String userPwd="";
	private String url="";
	private String comCode = "";
	private String useFlag = "";
	private String riskcode = "";
	private String registDate = "";
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
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	
	/**
	 * 获取属性 useFlag
	 * @return the useFlag
	 */
	public String getUseFlag() {
		return useFlag;
	}
	/**
	 * 设置属性 useFlag
	 * @param useFlag the useFlag to set
	 */
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	/**
	 * 获取属性 riskcode
	 * @return the riskcode
	 */
	public String getRiskcode() {
		return riskcode;
	}
	/**
	 * 设置属性 riskcode
	 * @param riskcode the riskcode to set
	 */
	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}
	
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public PlatFormParam(String url,String userName,String password,String comCode){
		this.userName = userName;
		this.userPwd = password;
		this.url = url;
		this.comCode = comCode;
	}
}
