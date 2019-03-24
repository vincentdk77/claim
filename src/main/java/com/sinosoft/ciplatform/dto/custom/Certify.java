package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Certify {
	private String claimCode = "";	      	//理赔编码
	private String policyNO ="";			//保单号
	private String registNo = "";			//报案号
	private String claimNo = "";			//立案号
	private String caseNo = "";			    //立案号
	private String comCode ="";			    //归属机构
	private String confirmSequenceNo = "";  //投保确认码
	
	private List certiList = new ArrayList();  //商业险车辆损失情况
	private String docStartTime ;		     //单证开始时间
	private String docEndTime ;			 //单证结束时间
	
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
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
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public List getCertiList() {
		return certiList;
	}
	public void setCertiList(List certiList) {
		this.certiList = certiList;
	}
	public String getDocStartTime() {
		return docStartTime;
	}
	public void setDocStartTime(String docStartTime) {
		this.docStartTime = docStartTime;
	}
	public String getDocEndTime() {
		return docEndTime;
	}
	public void setDocEndTime(String docEndTime) {
		this.docEndTime = docEndTime;
	}
}
