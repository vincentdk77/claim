package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class CvirturlItemDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**����������*/
	private String benName;
	/**���������֤��*/
	private String benIdentifyNumber;
	/**�����������˱�ע*/
	private String remark;
	/**������ ����������(�������������ݲ���ͬʱ����)*/
	private String benType;
	
	public CvirturlItemDtoInfo() {
	}
	public String getBenName() {
		return benName;
	}
	public void setBenName(String benName) {
		this.benName = benName;
	}
	public String getBenIdentifyNumber() {
		return benIdentifyNumber;
	}
	public void setBenIdentifyNumber(String benIdentifyNumber) {
		this.benIdentifyNumber = benIdentifyNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBenType() {
		return benType;
	}
	public void setBenType(String benType) {
		this.benType = benType;
	}
	
}
