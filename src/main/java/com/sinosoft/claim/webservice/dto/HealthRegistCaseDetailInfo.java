package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;
/**
 * 报案查询相关接口——意健险案件详细信息
 * @author Administrator
 *
 */
public class HealthRegistCaseDetailInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 险种名称
     */ 
	private String riskCode           = "";
	/** 保单号码
	     */ 
	private String policyNo           = "";
	/** 事故时间：天
	 */ 
	private String damageStartDate    = "";
	/** 事故小时
	     */ 
	private String damageStartHour    = "";
	/** 出险分钟
	     */ 
	private String damageStartMinute  = "";
	/** 事故原因代码
	 */ 
	private String damageCode         = "";
	/** 事故原因
	     */ 
	private String damageName         = "";
	/** 报案人
	       */ 
	private String reportorName       = "";
	/** 报案时间
	     */ 
	private String reportDate         = "";
	/** 报案小时
	     */ 
	private String reportHour         = "";
	/** 报案方式
	     */ 
	private String reportType         = "";
	/** 联系人
	       */ 
	private String linkerName         = "";
	/** 联系电话
	     */ 
	private String phoneNumber        = "";
	/** 联系地址
	     */ 
	private String linkerAddress      = "";
	/** 与事故者关系(1本人,2代理人,3其他)
	*/ 
	private String clauseType         = "";
	/** 事故地点
	     */ 
	private String damageAddress      = "";
	/** 事故类型
	     */ 
	private String damageTypeCode     = "";
	/** 事故类型名称
	 */ 
	private String damageTypeName     = "";
	/** 赔付人次默认0
	*/ 
	private String lossesNumber       = "";
	/** 是否呈报1：是  0 ：否
	*/ 
	private String reportFlag         = "";
	/** 币别
	         */ 
	private String estiCurrency       = "";
	/** 事故者信息(一条或者多条)
	
	*/ 
	private AcciPersonDto[] acciPersonDtoList;
	/** 接报案员代码
	 */ 
	private String operatorCode       = "";
	/** 接报案员姓名
	 */ 
	private String operatorName       = "";
	/** 理赔登记部门代码
	*/ 
	private String makeCom            = "";
	/** 理赔登记部门
	 */ 
	private String makeComName        = "";
	/** 备忘录
	       */ 
	private String remark             = "";
	/** 事故经过及其事故者现状
	*/ 
	private String context            = "";
	/** 巨灾一级代码
	 */ 
	private String catastropheCode1   = "";
	/** 巨灾名称
	     */ 
	private String catastropheName1   = "";
	/** 巨灾二级代码
	 */ 
	private String catastropheCode2   = "";
	/** 巨灾名称
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
