package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLLOCKLOG的数据传输对象基类<br>
 */
public class PrpLlocklogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性REGISTNO */
    private String registNo = "";
    /** 属性RECOVERYCODE */
    private String recoveryCode = "";
    /** 属性INPUTDATE */
    private DateTime inputDate = new DateTime();
    /** 属性NODETYPE */
    private String nodeType = "";
    /** 属性SERIALNO */
    private String riskCode = "";
    /** 属性RECOVERSTATUS */
    private String recoverStatus = "";
    /** 属性INSURERCODE */
    private String insurerCode = "";
    /** 属性INSURERAREA */
    private String insurerArea = "";
    /** 属性COVERAGETYPE */
    private String coverageType = "";
    /** 属性POLICYNO */
    private String policyNo = "";
    /** 属性CLAIMNOTIFICATIONNO */
    private String claimNotificationNo = "";
    /** 属性CLAIMSTATUS */
    private String claimStatus = "";
    /** 属性RECOVERYCODESTATUS */
    private String recoveryCodeStatus = "";
    /** 属性CLAIMPROGRESS*/
    private String claimProgress = "";

    /**
     *  默认构造方法,构造一个默认的PrpllocklogDtoBase对象
     */
    public PrpLlocklogDtoBase(){
    }

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getRecoveryCode() {
		return recoveryCode;
	}

	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
	}

	public DateTime getInputDate() {
		return inputDate;
	}

	public void setInputDate(DateTime inputDate) {
		this.inputDate = inputDate;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRecoverStatus() {
		return recoverStatus;
	}

	public void setRecoverStatus(String recoverStatus) {
		this.recoverStatus = recoverStatus;
	}

	public String getInsurerCode() {
		return insurerCode;
	}

	public void setInsurerCode(String insurerCode) {
		this.insurerCode = insurerCode;
	}

	public String getInsurerArea() {
		return insurerArea;
	}

	public void setInsurerArea(String insurerArea) {
		this.insurerArea = insurerArea;
	}

	public String getCoverageType() {
		return coverageType;
	}

	public void setCoverageType(String coverageType) {
		this.coverageType = coverageType;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getClaimNotificationNo() {
		return claimNotificationNo;
	}

	public void setClaimNotificationNo(String claimNotificationNo) {
		this.claimNotificationNo = claimNotificationNo;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getRecoveryCodeStatus() {
		return recoveryCodeStatus;
	}

	public void setRecoveryCodeStatus(String recoveryCodeStatus) {
		this.recoveryCodeStatus = recoveryCodeStatus;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getClaimProgress() {
		return claimProgress;
	}

	public void setClaimProgress(String claimProgress) {
		this.claimProgress = claimProgress;
	}

   
}
