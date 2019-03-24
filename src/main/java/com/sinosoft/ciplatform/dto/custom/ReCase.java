package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReCase {
	private String confirmSequenceNo = ""; // 投保确认码
	private String claimCode = ""; // 理赔编码
	private String registNo = ""; // 报案号
	private String claimNo = ""; // 立案号
	private String policyNo = ""; // 保单号
	private String reOpenCause = ""; // 重开原因
	private Date reOpenDate ; // 重开时间
	/**
	 * @return the confirmSequenceNo
	 */
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	/**
	 * @param confirmSequenceNo the confirmSequenceNo to set
	 */
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	/**
	 * @return the claimCode
	 */
	public String getClaimCode() {
		return claimCode;
	}
	/**
	 * @param claimCode the claimCode to set
	 */
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	/**
	 * @return the registNo
	 */
	public String getRegistNo() {
		return registNo;
	}
	/**
	 * @param registNo the registNo to set
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**
	 * @return the reOpenCause
	 */
	public String getReOpenCause() {
		return reOpenCause;
	}
	/**
	 * @param reOpenCause the reOpenCause to set
	 */
	public void setReOpenCause(String reOpenCause) {
		this.reOpenCause = reOpenCause;
	}
	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	/**
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}
	/**
	 * @param claimNo the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**
	 * @return the reOpenDate
	 */
	public Date getReOpenDate() {
		return reOpenDate;
	}
	/**
	 * @param reOpenDate the reOpenDate to set
	 */
	public void setReOpenDate(Date reOpenDate) {
		this.reOpenDate = reOpenDate;
	}


}
