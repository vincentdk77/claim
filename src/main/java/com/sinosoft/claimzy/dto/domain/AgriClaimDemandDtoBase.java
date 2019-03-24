package com.sinosoft.claimzy.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是AgriClaimDeamndDto的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class AgriClaimDemandDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
	/**属性理赔编码*/
	private String claimCode = ""; 
	/**属性报案号*/
	private String registNo = "";
	  /**属性立案号*/
	private String claimNo = "";
	  /**属性赔案号*/
	private String caseNo = "";
		/**属性预赔案号*/
	private String	preCompensateNo = "";
		/**属性立案信息是否上传*/
	private String claimUploadFlag = "";
	  /**属性赔案信息是否上传*/
	private String  caseUploadFlag = "";
	  /**属性注销/拒赔信息是否上传*/
	private String cancelUploadFlag = "";
	  /**属性预赔案信息是否上传*/
	private String prepaidUploadFlag = ""; 
	  /**属性险种代码*/
	private String  riskCode = "";
	  /**属性保单号*/
	private String policyNo = "";
	/**属性接口响应代码*/
	private String responseCode = "";
	/**属性批次号*/
	private String batchNo = "";
	  
	/**
     *  默认构造方法,构造一个默认的AgriClaimDeamndDtoBase对象
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
