package com.sinosoft.claimciplatform.dto.custom;

public class CancelCase {
	private String claimCode="";	      	//�������
	private String policyNO="";			//������
	private String registNo="";			//������
	private String claimNo="";			//������
	private String cancelType = "";		//ע������
	private String cancelReason = "";
	private String cancelReasonName = "";
	private String cancelDesc = "";
	public String getClaimNo() {
		return claimNo;
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

	public String getCancelType() {
		return cancelType;
	}

	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public String getCancelReasonName() {
		return cancelReasonName;
	}

	public void setCancelReasonName(String cancelReasonName) {
		this.cancelReasonName = cancelReasonName;
	}

	public String getCancelDesc() {
		return cancelDesc;
	}

	public void setCancelDesc(String cancelDesc) {
		this.cancelDesc = cancelDesc;
	}
	
}
