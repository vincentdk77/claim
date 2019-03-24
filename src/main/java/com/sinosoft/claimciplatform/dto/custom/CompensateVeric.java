package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class CompensateVeric {
	private String confirmSequenceNo=""; 	//投保确认码
	private String claimCode="";	      	//理赔编码
	private String registNo="";	//报案号
	private String claimNo="";  //立案号
	private String policyNo="";//保单号
	private String claimType="";//互碰自赔标志
	private String compensateNo="";	//理算书号
	private String otherFee="";	//其他费用
	private String UnderWriteDesc="";//核赔意见
	private double sumPaid=0D;	//赔偿金额
	private String UnderWriteEnd = "";//核赔通过时间
	private List ClaimCoverList = new ArrayList();
	private List RecoveryOrPayList = new ArrayList();
	private List compensateVericList = new ArrayList();
    /** 第四版本新增字段 */
    /** 属性 是否涉诉 */
    private String isInvolving = "";
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getOtherFee() {
		return otherFee;
	}
	public void setOtherFee(String otherFee) {
		this.otherFee = otherFee;
	}
	public String getUnderWriteDesc() {
		return UnderWriteDesc;
	}
	public void setUnderWriteDesc(String underWriteDesc) {
		UnderWriteDesc = underWriteDesc;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	public String getUnderWriteEnd() {
		return UnderWriteEnd;
	}
	public void setUnderWriteEnd(String underWriteEnd) {
		UnderWriteEnd = underWriteEnd;
	}
	public List getClaimCoverList() {
		return ClaimCoverList;
	}
	public void setClaimCoverList(List claimCoverList) {
		ClaimCoverList = claimCoverList;
	}
	public List getRecoveryOrPayList() {
		return RecoveryOrPayList;
	}
	public void setRecoveryOrPayList(List recoveryOrPayList) {
		RecoveryOrPayList = recoveryOrPayList;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public List getCompensateVericList() {
		return compensateVericList;
	}
	public void setCompensateVericList(List compensateVericList) {
		this.compensateVericList = compensateVericList;
	}
	public String getIsInvolving() {
		return isInvolving;
	}
	public void setIsInvolving(String isInvolving) {
		this.isInvolving = isInvolving;
	}
	
	
}
