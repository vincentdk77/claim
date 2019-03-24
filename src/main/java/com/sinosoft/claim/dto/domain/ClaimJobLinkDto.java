package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobLinkDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 联系人岗位 */
	private String staffPosition;
	/** 人员类型 */
	private String staffType;
	/** 人员姓名 */
	private String staffName;
	/** 电话号码 */
	private String staffPhone;

	public String getStaffPosition() {
		return staffPosition;
	}

	public void setStaffPosition(String staffPosition) {
		this.staffPosition = staffPosition;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
}
