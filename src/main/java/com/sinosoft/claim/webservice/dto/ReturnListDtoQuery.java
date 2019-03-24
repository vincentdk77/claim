package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 待回访清单接口  传入参数（ReturnListDtoQuery）
 * @author Administrator
 *
 */
public class ReturnListDtoQuery implements Serializable{
	private static final long serialVersionUID = 1L;
	/**机构*/
	private String comCode;
	/**机构名称*/
	private String comName;
	/**报案号*/
	private String registNo;
	/**保单号*/
	private String policyNo;
	/**险种*/
	private String riskCode;
	/**被保险人名称*/
	private String InsuredName;
	/**出险时间（yyyy-MM-dd）*/
	private String damageStartDate;
	/**出险时间（yyyy-MM-dd）*/
	private String damageEndDate;
	/**报案时间（yyyy-MM-dd）*/
	private String reportStartDate;
	/**报案时间（yyyy-MM-dd）*/
	private String reportEndDate;
	/**结案时间（yyyy-MM-dd）*/
	private String endCaseStartDate;
	/**结案时间（yyyy-MM-dd）*/
	private String endCaseEndDate;
	/**支付时间（yyyy-MM-dd）*/
	private String payrefStartDate;
	/**支付时间（yyyy-MM-dd）*/
	private String payrefEndDate;
	/**保单类型（意健险专用）（01：个人，02：集体）*/
	private String policyType;
	/**投保方式(农险专用)*/
	private String policyType2;
	/**当前页数*/
	private int pageNo;
	/**每页条数*/
	private int recordPerPage;
	
	
	public ReturnListDtoQuery() {
		super();
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getInsuredName() {
		return InsuredName;
	}
	public void setInsuredName(String insuredName) {
		InsuredName = insuredName;
	}
	public String getDamageStartDate() {
		return damageStartDate;
	}
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}
	public String getDamageEndDate() {
		return damageEndDate;
	}
	public void setDamageEndDate(String damageEndDate) {
		this.damageEndDate = damageEndDate;
	}
	public String getReportStartDate() {
		return reportStartDate;
	}
	public void setReportStartDate(String reportStartDate) {
		this.reportStartDate = reportStartDate;
	}
	public String getReportEndDate() {
		return reportEndDate;
	}
	public void setReportEndDate(String reportEndDate) {
		this.reportEndDate = reportEndDate;
	}
	public String getEndCaseStartDate() {
		return endCaseStartDate;
	}
	public void setEndCaseStartDate(String endCaseStartDate) {
		this.endCaseStartDate = endCaseStartDate;
	}
	public String getEndCaseEndDate() {
		return endCaseEndDate;
	}
	public void setEndCaseEndDate(String endCaseEndDate) {
		this.endCaseEndDate = endCaseEndDate;
	}
	public String getPayrefStartDate() {
		return payrefStartDate;
	}
	public void setPayrefStartDate(String payrefStartDate) {
		this.payrefStartDate = payrefStartDate;
	}
	public String getPayrefEndDate() {
		return payrefEndDate;
	}
	public void setPayrefEndDate(String payrefEndDate) {
		this.payrefEndDate = payrefEndDate;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public String getPolicyType2() {
		return policyType2;
	}
	public void setPolicyType2(String policyType2) {
		this.policyType2 = policyType2;
	}
	

}
