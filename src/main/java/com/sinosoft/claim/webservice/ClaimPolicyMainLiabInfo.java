package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyMainLiabInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ��ͨ�������� */
	private String businessDetail;
	/** Ӫ������Χ */
	private String insureArea;
	/** Ͷ���������� */
	private String electricPower;
	/** �˶��ؿ������ܼ�(��������ʻԱ) */
	private String staffCount;

	public String getBusinessDetail() {
		return businessDetail;
	}

	public void setBusinessDetail(String businessDetail) {
		this.businessDetail = businessDetail;
	}

	public String getInsureArea() {
		return insureArea;
	}

	public void setInsureArea(String insureArea) {
		this.insureArea = insureArea;
	}

	public String getElectricPower() {
		return electricPower;
	}

	public void setElectricPower(String electricPower) {
		this.electricPower = electricPower;
	}

	public String getStaffCount() {
		return staffCount;
	}

	public void setStaffCount(String staffCount) {
		this.staffCount = staffCount;
	}
}
