package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobLinkDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/** ��ϵ�˸�λ */
	private String staffPosition;
	/** ��Ա���� */
	private String staffType;
	/** ��Ա���� */
	private String staffName;
	/** �绰���� */
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
