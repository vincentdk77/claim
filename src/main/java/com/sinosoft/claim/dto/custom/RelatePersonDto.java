package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class RelatePersonDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String serialNo = "";
    /** 人员名称 */
    private String personName = "";
    /** 联系电话 */
    private String phoneNumber = "";
    /** 移动电话 */
    private String mobile = "";
    /** 备注 */
    private String remark = "";
    
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}
