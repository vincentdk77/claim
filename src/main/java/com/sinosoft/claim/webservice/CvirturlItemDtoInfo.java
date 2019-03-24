package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class CvirturlItemDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**受益者姓名*/
	private String benName;
	/**受益人身份证号*/
	private String benIdentifyNumber;
	/**受益人受益人备注*/
	private String remark;
	/**受益人 受益人类型(和上面三项数据不能同时存在)*/
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
