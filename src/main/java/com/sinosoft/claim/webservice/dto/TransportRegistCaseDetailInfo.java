package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * ���˱��հ�����ϸ��Ϣ ����Ϣ��TransportRegistCaseDetailInfo��
 * @author Administrator
 *
 */
public class TransportRegistCaseDetailInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ��������         */                          
	private String riskCode              ="";        
	/** ��������         */                          
	private String policyNo              ="";        
	/** ����ʱ�䣺��     */                          
	private String damageStartDate       ="";        
	/** ����ԭ�����     */                          
	private String damageCode            ="";        
	/** ����ԭ��         */                          
	private String damageName            ="";        
	/** ������           */                          
	private String reportorName          ="";        
	/** ����ʱ��         */                          
	private String reportDate            ="";        
	/** ����Сʱ         */                          
	private String reportHour            ="";        
	/** ������ʽ         */                          
	private String reportType            ="";        
	/** ��ϵ��           */                          
	private String linkerName            ="";        
	/** ��ϵ�绰         */                          
	private String phoneNumber           ="";        
	/** ���յ���������   */                          
	private String addressCode           ="";        
	/** ���յص�         */                          
	private String damageAddress         ="";        
	/** �ұ�             */                          
	private String estiCurrency          ="";        
	/** ������         */                          
	private String estimateLoss          ="";        
	/** ������         */                          
	private String LossName              ="";        
	/** ��ע             */                          
	private String remark                ="";        
	/** ��ϵ����Ϣ       */                          
	private RelatePersonDto[] relatePersonDtoList;        
	/** �ӱ���Ա����     */                          
	private String operatorCode          ="";        
	/** �ӱ���Ա����     */                          
	private String operatorName          ="";        
	/** ����Ǽǲ��Ŵ��� */                          
	private String makeCom               ="";        
	/** ����Ǽǲ���     */                          
	private String makeComName           ="";        
	/** ����ժҪ         */                          
	private String textContext           ="";        
	/** ����һ������     */                          
	private String catastropheCode1      ="";        
	/** ��������         */                          
	private String catastropheName1      ="";        
	/** ���ֶ�������     */                          
	private String catastropheCode2      ="";        
	/** ��������         */                          
	private String catastropheName2      ="";
	public TransportRegistCaseDetailInfo() {
		super();
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getDamageStartDate() {
		return damageStartDate;
	}
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}
	public String getDamageCode() {
		return damageCode;
	}
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}
	public String getDamageName() {
		return damageName;
	}
	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportHour() {
		return reportHour;
	}
	public void setReportHour(String reportHour) {
		this.reportHour = reportHour;
	}
	public String getReportType() {
		return reportType;
	}
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	public String getLinkerName() {
		return linkerName;
	}
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public String getEstiCurrency() {
		return estiCurrency;
	}
	public void setEstiCurrency(String estiCurrency) {
		this.estiCurrency = estiCurrency;
	}
	public String getEstimateLoss() {
		return estimateLoss;
	}
	public void setEstimateLoss(String estimateLoss) {
		this.estimateLoss = estimateLoss;
	}
	public String getLossName() {
		return LossName;
	}
	public void setLossName(String lossName) {
		LossName = lossName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public RelatePersonDto[] getRelatePersonDtoList() {
		return relatePersonDtoList;
	}
	public void setRelatePersonDtoList(RelatePersonDto[] relatePersonDtoList) {
		this.relatePersonDtoList = relatePersonDtoList;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getMakeCom() {
		return makeCom;
	}
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}
	public String getMakeComName() {
		return makeComName;
	}
	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}
	public String getTextContext() {
		return textContext;
	}
	public void setTextContext(String textContext) {
		this.textContext = textContext;
	}
	public String getCatastropheCode1() {
		return catastropheCode1;
	}
	public void setCatastropheCode1(String catastropheCode1) {
		this.catastropheCode1 = catastropheCode1;
	}
	public String getCatastropheName1() {
		return catastropheName1;
	}
	public void setCatastropheName1(String catastropheName1) {
		this.catastropheName1 = catastropheName1;
	}
	public String getCatastropheCode2() {
		return catastropheCode2;
	}
	public void setCatastropheCode2(String catastropheCode2) {
		this.catastropheCode2 = catastropheCode2;
	}
	public String getCatastropheName2() {
		return catastropheName2;
	}
	public void setCatastropheName2(String catastropheName2) {
		this.catastropheName2 = catastropheName2;
	}    
	

}