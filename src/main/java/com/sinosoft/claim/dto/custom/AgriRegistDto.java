package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class AgriRegistDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** �������� */
	private String riskCode;
	/** �������� */
	private String policyNo;
	/** ����ʱ�䣺�� */
	private String damageStartDate;
	/** ����Сʱ */
	private String damageStartHour;
	/** ���շ��� */
	private String damageStartMinute;
	/** ����ԭ�� */
	private String damageCode;
	/** ����ԭ������ */
	private String damageName;
	/** ��ϸ����ԭ�� */
	private String[] damageMessage;
	/** ������ */
	private String reportorName;
	/** ����ʱ�� */
	private String reportDate;
	/** ����Сʱ */
	private String reportHour;
	/** ������ʽ */
	private String reportType;
	/** ��ϵ�� */
	private String linkerName;
	/** ��ϵ�绰 */
	private String phoneNumber;
	/** �⸶���� */
	private String lossesNumber;
	/** �⸶��λ */
	private String lossesUnitCode;
	/** ���յ��������� */
	private String addressCode;
	/** ���յص� */
	private String damageAddress;
	/** �ұ� */
	private String estiCurrency;
	/** ������ */
	private String estimateLoss;
	/** ������ */
	private String lossName;
	/** �ӱ���Ա���� */
	private String operatorCode;
	/** �ӱ���Ա���� */
	private String operatorName;
	/** ҵ����Ǽǲ��� */
	private String makeComName;
	/** ����Ǽǲ��Ŵ��� */
	private String makeCom;
	/** ��ע */
	private String remark;
	/** ����ժҪ */
	private String textContext;
	/** ����һ������ */
	private String catastropheCode1;
	/** �������� */
	private String catastropheName1;
	/** ���ֶ������� */
	private String catastropheCode2;
	/** �������� */
	private String catastropheName2;
	/** �¹�����Ϣ */
	private AcciPersonDto[] acciPersonDtoList;
	/** ������嵥 ��ֳ��ר�� */
	private EarNoDto[] earNoDtoList;

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

	public String[] getDamageMessage() {
		return damageMessage;
	}

	public void setDamageMessage(String[] damageMessage) {
		this.damageMessage = damageMessage;
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

	public String getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(String lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
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
		return lossName;
	}

	public void setLossName(String lossName) {
		this.lossName = lossName;
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

	public String getMakeComName() {
		return makeComName;
	}

	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public AcciPersonDto[] getAcciPersonDtoList() {
		return acciPersonDtoList;
	}

	public void setAcciPersonDtoList(AcciPersonDto[] acciPersonDtoList) {
		this.acciPersonDtoList = acciPersonDtoList;
	}

	public EarNoDto[] getEarNoDtoList() {
		return earNoDtoList;
	}

	public void setEarNoDtoList(EarNoDto[] earNoDtoList) {
		this.earNoDtoList = earNoDtoList;
	}

}
