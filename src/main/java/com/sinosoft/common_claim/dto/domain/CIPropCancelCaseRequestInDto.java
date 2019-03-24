package com.sinosoft.common_claim.dto.domain;

public class CIPropCancelCaseRequestInDto {
	private String claimCode="";	    //理赔编码
	private String policyNO="";			//保单号
	private String registNo="";			//报案号
	private String claimNo="";			//立案号
	private String cancelType="";		//注销类型
	private String canceReason = "";	//注销原因
	private String cancelDate ="" ;
	private String isGroup ="" ; //是否团单
	
	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}

	public String getCanceReason() {
		return canceReason;
	}

	public void setCanceReason(String canceReason) {
		this.canceReason = canceReason;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getPolicyNO() {
		return policyNO;
	}

	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	/**
	 * 理赔编码
	 * @return
	 */
	public String getClaimCode() {
		return claimCode;
	}
	/**
	 * 设置理赔编码
	 * @param claimCode
	 */
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	public String getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}
}
