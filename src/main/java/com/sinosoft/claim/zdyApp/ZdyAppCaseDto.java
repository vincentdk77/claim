package com.sinosoft.claim.zdyApp;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class ZdyAppCaseDto {
	/** ������*/
	private String registNo = "";
	/** ��������*/
	private String data = "";
	/** ����ʱ��*/
	private DateTime transDate = new DateTime();
	/** ���ͳɹ�����־*/
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
