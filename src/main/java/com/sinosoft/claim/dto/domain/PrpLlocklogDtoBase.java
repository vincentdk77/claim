package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLLOCKLOG�����ݴ���������<br>
 */
public class PrpLlocklogDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����REGISTNO */
    private String registNo = "";
    /** ����RECOVERYCODE */
    private String recoveryCode = "";
    /** ����INPUTDATE */
    private DateTime inputDate = new DateTime();
    /** ����NODETYPE */
    private String nodeType = "";
    /** ����SERIALNO */
    private String riskCode = "";
    /** ����RECOVERSTATUS */
    private String recoverStatus = "";
    /** ����INSURERCODE */
    private String insurerCode = "";
    /** ����INSURERAREA */
    private String insurerArea = "";
    /** ����COVERAGETYPE */
    private String coverageType = "";
    /** ����POLICYNO */
    private String policyNo = "";
    /** ����CLAIMNOTIFICATIONNO */
    private String claimNotificationNo = "";
    /** ����CLAIMSTATUS */
    private String claimStatus = "";
    /** ����RECOVERYCODESTATUS */
    private String recoveryCodeStatus = "";
    /** ����CLAIMPROGRESS*/
    private String claimProgress = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpllocklogDtoBase����
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
