package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyMainLiabInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 交通工具类型 */
	private String businessDetail;
	/** 营运区域范围 */
	private String insureArea;
	/** 投保车辆总数 */
	private String electricPower;
	/** 核定载客人数总计(不包括驾驶员) */
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
