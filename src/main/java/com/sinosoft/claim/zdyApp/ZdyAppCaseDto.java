package com.sinosoft.claim.zdyApp;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class ZdyAppCaseDto {
	/** 报案号*/
	private String registNo = "";
	/** 推送内容*/
	private String data = "";
	/** 推送时间*/
	private DateTime transDate = new DateTime();
	/** 推送成功与否标志*/
	private String transFlag = "";
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public DateTime getTransDate() {
		return transDate;
	}
	public void setTransDate(DateTime transDate) {
		this.transDate = transDate;
	}
	public String getTransFlag() {
		return transFlag;
	}
	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	}
	
}
