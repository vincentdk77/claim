package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * ���ط��嵥�ӿ�  ���������ReturnListDtoQuery��
 * @author Administrator
 *
 */
public class ReturnListDtoQuery implements Serializable{
	private static final long serialVersionUID = 1L;
	/**����*/
	private String comCode;
	/**��������*/
	private String comName;
	/**������*/
	private String registNo;
	/**������*/
	private String policyNo;
	/**����*/
	private String riskCode;
	/**������������*/
	private String InsuredName;
	/**����ʱ�䣨yyyy-MM-dd��*/
	private String damageStartDate;
	/**����ʱ�䣨yyyy-MM-dd��*/
	private String damageEndDate;
	/**����ʱ�䣨yyyy-MM-dd��*/
	private String reportStartDate;
	/**����ʱ�䣨yyyy-MM-dd��*/
	private String reportEndDate;
	/**�᰸ʱ�䣨yyyy-MM-dd��*/
	private String endCaseStartDate;
	/**�᰸ʱ�䣨yyyy-MM-dd��*/
	private String endCaseEndDate;
	/**֧��ʱ�䣨yyyy-MM-dd��*/
	private String payrefStartDate;
	/**֧��ʱ�䣨yyyy-MM-dd��*/
	private String payrefEndDate;
	/**�������ͣ��⽡��ר�ã���01�����ˣ�02�����壩*/
	private String policyType;
	/**Ͷ����ʽ(ũ��ר��)*/
	private String policyType2;
	/**��ǰҳ��*/
	private int pageNo;
	/**ÿҳ����*/
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
