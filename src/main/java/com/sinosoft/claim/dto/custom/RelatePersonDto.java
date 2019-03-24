package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class RelatePersonDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String serialNo = "";
    /** ��Ա���� */
    private String personName = "";
    /** ��ϵ�绰 */
    private String phoneNumber = "";
    /** �ƶ��绰 */
    private String mobile = "";
    /** ��ע */
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
