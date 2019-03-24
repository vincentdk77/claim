package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PropRegistDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 险种名称 */
	private String riskCode;
	/** 保单号码 */
	private String policyNo;
	/** 出险时间：天 */
	private String damageStartDate;
	/** 出险小时：到分钟 */
	private String damageStartHour;
	/** 出险分钟 */
	private String damageStartMinute;
	/** 出险原因 */
	private String damageCode;
	/** 出险原因名称 */
	private String damageName;
	/** 报案人 */
	private String reportorName;
	/** 报案时间 */
	private String reportDate;
	/** 报案小时 */
	private String reportHour;
	/** 报案方式 */
	private String reportType;
	/** 联系人 */
	private String linkerName;
	/** 联系电话 */
	private String phoneNumber;
	/** 出险地邮政编码 */
	private String addressCode;
	/** 出险地点 */
	private String damageAddress;
	/** 币别 */
	private String estiCurrency;
	/** 报损金额 */
	private String estimateLoss;
	/** 受损标的 */
	private String lossName;
	/** 接报案员代码 */
	private String operatorCode;
	/** 接报案员姓名 */
	private String operatorName;
	/** 业理赔登记部门 */
	private String makeComName;
	/** 理赔登记部门代码 */
	private String makeCom;
	/** 户编码 */
	private String remark;
	/** 主/连带被保险人 */
	private String insuredCodeRemark;
	/** 出险摘要 */
	private String textContext;
	/** 巨灾一级代码 */
	private String catastropheCode1;
	/** 巨灾名称 */
	private String catastropheName1;
	/** 巨灾二级代码 */
	private String catastropheCode2;
	/** 巨灾名称 */
	private String catastropheName2;
	/** 联系人信息 */
	private String houseAddress; 
	private String houseRemark;  
	private String houseEstimateloss;    
	private String houseHukoubu; 
	private String houseIdcard;  
	private String houseName;  
	private String housePhone;  
	private String houseFloor;  
	private String houseBuildingnumber;  
	private String houseZhuannumber; 
	private String houseWanumber;   
	private String houseKitchennumber;  
	private String houseOthernumber; 
	
	private RelatePersonDto[] relatePersonDtoList;
	

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

	public String getInsuredCodeRemark() {
		return insuredCodeRemark;
	}

	public void setInsuredCodeRemark(String insuredCodeRemark) {
		this.insuredCodeRemark = insuredCodeRemark;
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

	public RelatePersonDto[] getRelatePersonDtoList() {
		return relatePersonDtoList;
	}

	public void setRelatePersonDtoList(RelatePersonDto[] relatePersonDtoList) {
		this.relatePersonDtoList = relatePersonDtoList;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getHouseRemark() {
		return houseRemark;
	}

	public void setHouseRemark(String houseRemark) {
		this.houseRemark = houseRemark;
	}

	public String getHouseEstimateloss() {
		return houseEstimateloss;
	}

	public void setHouseEstimateloss(String houseEstimateloss) {
		this.houseEstimateloss = houseEstimateloss;
	}

	public String getHouseHukoubu() {
		return houseHukoubu;
	}

	public void setHouseHukoubu(String houseHukoubu) {
		this.houseHukoubu = houseHukoubu;
	}

	public String getHouseIdcard() {
		return houseIdcard;
	}

	public void setHouseIdcard(String houseIdcard) {
		this.houseIdcard = houseIdcard;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHousePhone() {
		return housePhone;
	}

	public void setHousePhone(String housePhone) {
		this.housePhone = housePhone;
	}

	public String getHouseFloor() {
		return houseFloor;
	}

	public void setHouseFloor(String houseFloor) {
		this.houseFloor = houseFloor;
	}

	public String getHouseBuildingnumber() {
		return houseBuildingnumber;
	}

	public void setHouseBuildingnumber(String houseBuildingnumber) {
		this.houseBuildingnumber = houseBuildingnumber;
	}

	public String getHouseZhuannumber() {
		return houseZhuannumber;
	}

	public void setHouseZhuannumber(String houseZhuannumber) {
		this.houseZhuannumber = houseZhuannumber;
	}

	public String getHouseWanumber() {
		return houseWanumber;
	}

	public void setHouseWanumber(String houseWanumber) {
		this.houseWanumber = houseWanumber;
	}

	public String getHouseKitchennumber() {
		return houseKitchennumber;
	}

	public void setHouseKitchennumber(String houseKitchennumber) {
		this.houseKitchennumber = houseKitchennumber;
	}

	public String getHouseOthernumber() {
		return houseOthernumber;
	}

	public void setHouseOthernumber(String houseOthernumber) {
		this.houseOthernumber = houseOthernumber;
	}
	
}
