package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

public class AdvanceInfoDto {
	/** 垫付赔案编码*/
	private String advanceNo = "";
	/** 保险公司代码*/
	private String companyCode = "";
	/** 报案号码*/
	private String registNo = "";
	/** 赔案编码*/
	private String claimNo = "";
	/** 保单号码*/
	private String policyNo = "";
	/** 投保确认码*/
	private String proposalNo = "";
	/** 号牌号码*/
	private String licenseNo = "";
	/** 号牌种类*/
	private String carKindCode = "";
	/** 驾驶员名称*/
	private String driverName = "";
	/** 驾驶员证件号码*/
	private String drivingLicenseNo = "";
	/** 出险时间*/
	private Date damageDate = new Date();
	/** 全责方报案时间*/
	private Date reportDate = new Date();
	/** 全责方查勘时间*/
	private Date checkDate = new Date();
	/** 出险地点*/
	private String damageAddress = "";
	/** 查勘地点*/
	private String checkSite = "";
	/** 出险经过*/
	private String accidentDescription = "";
	/** 出险原因*/
	private String accidentReason = "";
	/** 全责方定损金额*/
	private double estimateAmount = 0d;
	/** 无责方赔偿金额*/
	private double settlementAmount = 0d;
	/** 付款方式*/
	private String payMode = "";
	/** 意见*/
	private String comment = "";
	
	/**
     * 获取出险经过
     * @return 出险经过
     */
	public String getAccidentDescription() {
		return accidentDescription;
	}
	/**
     * 设置出险经过
     * @param 出险经过
     */
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	
	/**
     * 获取出险原因
     * @return 出险原因
     */
	public String getAccidentReason() {
		return accidentReason;
	}
	/**
     * 设置出险原因
     * @param 出险原因
     */
	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}
	
	/**
     * 获取号牌种类
     * @return 号牌种类
     */
	public String getCarKindCode() {
		return carKindCode;
	}
	/**
     * 设置号牌种类
     * @param 号牌种类
     */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
	}
	
	/**
     * 获取查勘时间
     * @return 查勘时间
     */
	public Date getCheckDate() {
		return checkDate;
	}
	/**
     * 设置查勘时间
     * @param 查勘时间
     */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	/**
     * 获取查勘地点
     * @return 查勘时间
     */
	public String getCheckSite() {
		return checkSite;
	}
	/**
     * 设置查勘地点
     * @param 查勘时间
     */
	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	}
	
	/**
     * 获取赔案编码
     * @return 查勘时间
     */
	public String getClaimNo() {
		return claimNo;
	}
	/**
     * 设置赔案编码
     * @param 查勘时间
     */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	
	/**
     * 获取意见
     * @return 意见
     */
	public String getComment() {
		return comment;
	}
	/**
     * 设置意见
     * @param 意见
     */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
     * 获取保险公司代码
     * @return 保险公司代码
     */
	public String getCompanyCode() {
		return companyCode;
	}
	/**
     * 设置保险公司代码
     * @param 保险公司代码
     */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	/**
     * 获取出险地点
     * @return 出险地点
     */
	public String getDamageAddress() {
		return damageAddress;
	}
	/**
     * 设置出险地点
     * @param 出险地点
     */
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	
	/**
     * 获取出险时间
     * @return 出险时间
     */
	public Date getDamageDate() {
		return damageDate;
	}
	/**
     * 设置出险时间
     * @param 出险时间
     */
	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
	}
	
	/**
     * 获取驾驶员名称
     * @return 驾驶员名称
     */
	public String getDriverName() {
		return driverName;
	}
	/**
     * 设置驾驶员名称
     * @param 驾驶员名称
     */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	/**
     * 获取驾驶员证件号码
     * @return 驾驶员证件号码
     */
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	/**
     * 设置驾驶员证件号码
     * @param 驾驶员证件号码
     */
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}
	
	/**
     * 获取全责方定损金额
     * @return 全责方定损金额
     */
	public double getEstimateAmount() {
		return estimateAmount;
	}
	/**
     * 设置全责方定损金额
     * @param 全责方定损金额
     */
	public void setEstimateAmount(double estimateAmount) {
		this.estimateAmount = estimateAmount;
	}
	
	/**
     * 获取号牌号码
     * @return 号牌号码
     */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
     * 设置号牌号码
     * @param 号牌号码
     */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	/**
     * 获取付款方式
     * @return 付款方式
     */
	public String getPayMode() {
		return payMode;
	}
	/**
     * 设置付款方式
     * @param 付款方式
     */
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	
	/**
     * 获取保单号码
     * @return 保单号码
     */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
     * 设置保单号码
     * @param 保单号码
     */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	/**
     * 获取投保确认码
     * @return 投保确认码
     */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
     * 设置投保确认码
     * @param 投保确认码
     */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	
	/**
     * 获取报案号码
     * @return 报案号码
     */
	public String getRegistNo() {
		return registNo;
	}
	/**
     * 设置报案号码
     * @param 报案号码
     */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	
	/**
     * 获取报案时间
     * @return 报案时间
     */
	public Date getReportDate() {
		return reportDate;
	}
	/**
     * 设置报案时间
     * @param 报案时间
     */
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
	/**
     * 获取无责方赔偿金额
     * @return 无责方赔偿金额
     */
	public double getSettlementAmount() {
		return settlementAmount;
	}
	/**
     * 设置无责方赔偿金额
     * @param 无责方赔偿金额
     */
	public void setSettlementAmount(double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	/**
	 * 获取垫付赔案编码
	 * @return the perPayNo
	 */
	public String getAdvanceNo() {
		return advanceNo;
	}
	/**
	 * 设置垫付赔案编码
	 * @param perPayNo the perPayNo to set
	 */
	public void setAdvanceNo(String advanceNo) {
		this.advanceNo = advanceNo;
	}
	

}
