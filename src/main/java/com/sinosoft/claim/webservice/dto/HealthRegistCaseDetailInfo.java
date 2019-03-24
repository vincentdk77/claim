package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;
/**
 * ������ѯ��ؽӿڡ����⽡�հ�����ϸ��Ϣ
 * @author Administrator
 *
 */
public class HealthRegistCaseDetailInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ��������
     */ 
	private String riskCode           = "";
	/** ��������
	     */ 
	private String policyNo           = "";
	/** �¹�ʱ�䣺��
	 */ 
	private String damageStartDate    = "";
	/** �¹�Сʱ
	     */ 
	private String damageStartHour    = "";
	/** ���շ���
	     */ 
	private String damageStartMinute  = "";
	/** �¹�ԭ�����
	 */ 
	private String damageCode         = "";
	/** �¹�ԭ��
	     */ 
	private String damageName         = "";
	/** ������
	       */ 
	private String reportorName       = "";
	/** ����ʱ��
	     */ 
	private String reportDate         = "";
	/** ����Сʱ
	     */ 
	private String reportHour         = "";
	/** ������ʽ
	     */ 
	private String reportType         = "";
	/** ��ϵ��
	       */ 
	private String linkerName         = "";
	/** ��ϵ�绰
	     */ 
	private String phoneNumber        = "";
	/** ��ϵ��ַ
	     */ 
	private String linkerAddress      = "";
	/** ���¹��߹�ϵ(1����,2������,3����)
	*/ 
	private String clauseType         = "";
	/** �¹ʵص�
	     */ 
	private String damageAddress      = "";
	/** �¹�����
	     */ 
	private String damageTypeCode     = "";
	/** �¹���������
	 */ 
	private String damageTypeName     = "";
	/** �⸶�˴�Ĭ��0
	*/ 
	private String lossesNumber       = "";
	/** �Ƿ�ʱ�1����  0 ����
	*/ 
	private String reportFlag         = "";
	/** �ұ�
	         */ 
	private String estiCurrency       = "";
	/** �¹�����Ϣ(һ�����߶���)
	
	*/ 
	private AcciPersonDto[] acciPersonDtoList;
	/** �ӱ���Ա����
	 */ 
	private String operatorCode       = "";
	/** �ӱ���Ա����
	 */ 
	private String operatorName       = "";
	/** ����Ǽǲ��Ŵ���
	*/ 
	private String makeCom            = "";
	/** ����Ǽǲ���
	 */ 
	private String makeComName        = "";
	/** ����¼
	       */ 
	private String remark             = "";
	/** �¹ʾ��������¹�����״
	*/ 
	private String context            = "";
	/** ����һ������
	 */ 
	private String catastropheCode1   = "";
	/** ��������
	     */ 
	private String catastropheName1   = "";
	/** ���ֶ�������
	 */ 
	private String catastropheCode2   = "";
	/** ��������
	     */ 
	private String catastropheName2   = "";
	public HealthRegistCaseDetailInfo() {
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
	public String getDamageStartHour() {
		return damageStartHour;
	}
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = damageStartHour;
	}
	public String getDamageStartMinute() {
		return damageStartMinute;
	}
	public void setDamageStartMinute(String damageStartMinute) {
		this.damageStartMinute = damageStartMinute;
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
	public String getLinkerAddress() {
		return linkerAddress;
	}
	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = linkerAddress;
	}
	public String getClauseType() {
		return clauseType;
	}
	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getDamageTypeName() {
		return damageTypeName;
	}
	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = damageTypeName;
	}
	public String getLossesNumber() {
		return lossesNumber;
	}
	public void setLossesNumber(String lossesNumber) {
		this.lossesNumber = lossesNumber;
	}
	public String getReportFlag() {
		return reportFlag;
	}
	public void setReportFlag(String reportFlag) {
		this.reportFlag = reportFlag;
	}
	public String getEstiCurrency() {
		return estiCurrency;
	}
	public void setEstiCurrency(String estiCurrency) {
		this.estiCurrency = estiCurrency;
	}
	public AcciPersonDto[] getAcciPersonDtoList() {
		return acciPersonDtoList;
	}
	public void setAcciPersonDtoList(AcciPersonDto[] acciPersonDtoList) {
		this.acciPersonDtoList = acciPersonDtoList;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
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
