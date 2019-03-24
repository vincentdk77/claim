package com.sinosoft.claimzy.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����AgriClaimDeamndDto�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class AgriClaimDemandDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
	/**�����������*/
	private String claimCode = ""; 
	/**���Ա�����*/
	private String registNo = "";
	  /**����������*/
	private String claimNo = "";
	  /**�����ⰸ��*/
	private String caseNo = "";
		/**����Ԥ�ⰸ��*/
	private String	preCompensateNo = "";
		/**����������Ϣ�Ƿ��ϴ�*/
	private String claimUploadFlag = "";
	  /**�����ⰸ��Ϣ�Ƿ��ϴ�*/
	private String  caseUploadFlag = "";
	  /**����ע��/������Ϣ�Ƿ��ϴ�*/
	private String cancelUploadFlag = "";
	  /**����Ԥ�ⰸ��Ϣ�Ƿ��ϴ�*/
	private String prepaidUploadFlag = ""; 
	  /**�������ִ���*/
	private String  riskCode = "";
	  /**���Ա�����*/
	private String policyNo = "";
	/**���Խӿ���Ӧ����*/
	private String responseCode = "";
	/**�������κ�*/
	private String batchNo = "";
	  
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�AgriClaimDeamndDtoBase����
     */
    public AgriClaimDemandDtoBase(){
    }

	public  String getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(String claimCode) {
		this.claimCode =StringUtils.rightTrim(claimCode);
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = StringUtils.rightTrim(registNo);
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = StringUtils.rightTrim(claimNo);
	}

	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = StringUtils.rightTrim(caseNo);
	}

	public String getPreCompensateNo() {
		return preCompensateNo;
	}

	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
	}

	public String getClaimUploadFlag() {
		return claimUploadFlag;
	}

	public void setClaimUploadFlag(String claimUploadFlag) {
		this.claimUploadFlag = StringUtils.rightTrim(claimUploadFlag);
	}

	public String getCaseUploadFlag() {
		return caseUploadFlag;
	}

	public void setCaseUploadFlag(String caseUploadFlag) {
		this.caseUploadFlag = StringUtils.rightTrim(caseUploadFlag);
	}

	public String getCancelUploadFlag() {
		return cancelUploadFlag;
	}

	public void setCancelUploadFlag(String cancelUploadFlag) {
		this.cancelUploadFlag = StringUtils.rightTrim(cancelUploadFlag);
	}

	public String getPrepaidUploadFlag() {
		return prepaidUploadFlag;
	}

	public void setPrepaidUploadFlag(String prepaidUploadFlag) {
		this.prepaidUploadFlag = StringUtils.rightTrim(prepaidUploadFlag);
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = StringUtils.rightTrim(riskCode);
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = StringUtils.rightTrim(policyNo);
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = StringUtils.rightTrim(responseCode);
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = StringUtils.rightTrim(batchNo);
	}
    
    
}
