package com.sinosoft.claimzy.dto.domain;
/**
 * 查询的需要上传的数据类
 * @author CDB
 *
 */
public class UploadData {
	/* 属性 报案号 */
	private String registNo = "";
	/* 属性 立案号 */
	private String claimNo = "";
	/* 属性 保单号 */
	private String policyNo = "";
	/* 属性 赔案号 */
	private String caseNo = "";
	/* 属性 预赔案号 */
	private String preCompensateNo = "";
	/* 属性 赔款计算书号 */
	private String compensateNo = "";
	/*属性 批次号*/
	private String batchNo = "";
	/*属性 业务号*/
	private String businessNo = "";
	/*属性 上传标志*/
	private String flag = "";
	/*属性 业务接口类型*/
	private String businessType = "";

    public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
     * 构造方法
     */
	public UploadData() {

	}

	/**
	 * 获取属性 registNo
	 * 
	 * @return the registNo
	 */
	public String getRegistNo() {
		return registNo;
	}

	/**
	 * 设置属性 registNo
	 * 
	 * @param registNo
	 *            the registNo to set
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	/**
	 * 获取属性 claimNo
	 * 
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * 设置属性 claimNo
	 * 
	 * @param claimNo
	 *            the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPreCompensateNo() {
		return preCompensateNo;
	}

	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	}

	public String getCompensateNo() {
		return compensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;

	}
	
}