package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class ClaimHistoryInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 报案号码 */
	private String registNo;
	/** 险种代码 */
	private String riskCode;
	/** 险种名称 */
	private String riskName;
	/** 保单号码 */
	private String policyNo;
	/** 被保险人代码 */
	private String insuredCode = "";
	/** 出险次数 */
	private String perilCount = "0";
	/** 被保险人名称 */
	private String insuredName = "";
	/** 出险日期起 */
	private Date damageStartDate;
	/** 出险开始小时 */
	private String damageStartHour = "";
	/** 出险开始分钟 */
	private String damageStartMinute = "";
	/** 出险原因代码 */
	private String damageCode = "";
	/** 出险原因说明 */
	private String damageName = "";
	/** 启保日期 */
	private String startDate = "";
	/** 终保日期 */
	private String endDate = "";
	private String startHour = "0";
	private String endHour = "0";
	/** 报案日期 */
	private String reportDate = "";
	/** 报案小时 */
	private String reportHour = "";
	/** 报案人 */
	private String reportorName = "";
	/** 报案形式 */
	private String reportType = "";
	/** 计算机输单日期 */
	private String inputDate = "";
	/** 联系电话 */
	private String phoneNumber = "";
	/** 联系人 */
	private String linkerName = "";
	/** 出险地代码 */
	private String addressCode = "";
	/** 出险地点 */
	private String damageAddress = "";
	/** 估损币别 */
	private String estiCurrency = "";
	/** 估损金额 */
	private String estimateLoss = "0";
	/** 受损标的 */
	private String lossName = "";
	/** 归属业务员代码 */
	private String handlerCode = "";
	/** 归属业务员名称 */
	private String handlerName = "";
	/** 业务归属机构代码 */
	private String comCode = "";
	/** 业务归属机构名称 */
	private String comName = "";
	/** 操作员代码 */
	private String operatorCode = "";
	/** 理赔登记机构 */
	private String makeCom = "";
	/** 操作员名称 */
	private String operatorName = "";
	/** 理赔登记机构名称 */
	private String makeComName = "";
	/** 接案人名称 */
	private String receiverName = "";
	/** 备注 */
	private String remark = "";

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}


	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public Date getDamageStartDate() {
		return damageStartDate;
	}

	public void setDamageStartDate(Date damageStartDate) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getReportorName() {
		return reportorName;
	}

	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLinkerName() {
		return linkerName;
	}

	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
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


	public String getLossName() {
		return lossName;
	}

	public void setLossName(String lossName) {
		this.lossName = lossName;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
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

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
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

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPerilCount() {
		return perilCount;
	}

	public void setPerilCount(String perilCount) {
		this.perilCount = perilCount;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour(String startHour) {
		this.startHour = startHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String getEstimateLoss() {
		return estimateLoss;
	}

	public void setEstimateLoss(String estimateLoss) {
		this.estimateLoss = estimateLoss;
	}
	
}
