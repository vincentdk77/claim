package com.sinosoft.common_claim.dto.domain;

public class CIPropCancelCaseRequestInDto {
	private String claimCode="";	    //�������
	private String policyNO="";			//������
	private String registNo="";			//������
	private String claimNo="";			//������
	private String cancelType="";		//ע������
	private String canceReason = "";	//ע��ԭ��
	private String cancelDate ="" ;
	private String isGroup ="" ; //�Ƿ��ŵ�
	
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
	 * �������
	 * @return
	 */
	public String getClaimCode() {
		return claimCode;
	}
	/**
	 * �����������
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
