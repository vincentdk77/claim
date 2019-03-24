package com.sinosoft.claimciplatform.dto.custom;


public class CompelCrashArgDto {
	
	
	private String aRegsitNo; //我方报案号

	private String bRegsitNo; //他方报案号
	
	public  String ciPlatFormCode;//信息平台名称
		
	public String getCiPlatFormCode() {
		return ciPlatFormCode;
	}

	public void setCiPlatFormCode(String ciPlatFormCode) {
		this.ciPlatFormCode = ciPlatFormCode;
	}

	public String getARegsitNo() {
		return aRegsitNo;
	}

	public void setARegsitNo(String regsitNo) {
		aRegsitNo = regsitNo;
	}

	public String getBRegsitNo() {
		return bRegsitNo;
	}

	public void setBRegsitNo(String regsitNo) {
		bRegsitNo = regsitNo;
	}

}
