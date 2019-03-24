package com.sinosoft.ciplatform.dto.custom;

public class CancelCase {
	private String claimCode="";	      	//理赔编码
	private String policyNO="";			//保单号
	private String registNo="";			//报案号
	private String claimNo="";			//立案号
	private String comCode="";			//归属机构
	private String confirmSequenceNo=""; 	//投保确认码
	private String cancelDesc=""; //案件描述
	private String cancelCause=""; //案件注销原因
	private String cancelType="";//案件注销类型 1报案，2立案
	
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
	/**
	 * 归属机构
	 * @return
	 */
	public String getComCode() {
		return comCode;
	}

	/**
	 * 设置归属机构
	 * @param claimCode
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getCancelCause() {
		return cancelCause;
	}
	public void setCancelCause(String cancelCause) {
		this.cancelCause = cancelCause;
	}
	public String getCancelType() {
		return cancelType;
	}
	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}
}
