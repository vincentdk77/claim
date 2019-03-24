package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 理赔信息回访清单 返回数据传输对象
 * @author Administrator
 *
 */
public class CaseClaimListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**报案人*/
	private String reportorName;
	/**联系人*/
	private String linkerName;
	/**联系电话*/
	private String phoneNumber;
	/**出险时间*/
	private String damageStartDate;
	/**报案时间*/
	private String reportDate;
	/**结案时间*/
	private String endCaseDate;
	/**出险原因*/
	private String damageName;
	/**出险地点*/
	private String damageAddress;
	/**出险摘要*/
	private String context;
	/**验证环节的身份证号码（农房）*/
	private String houseIdCard;
	/**验证环节的户编号（农家福）*/
	private String zh03FamilyNo;
	public CaseClaimListMainInfo() {
		super();
	}
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
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
	public String getDamageStartDate() {
		return damageStartDate;
	}
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getEndCaseDate() {
		return endCaseDate;
	}
	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}
	public String getDamageName() {
		return damageName;
	}
	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getHouseIdCard() {
		return houseIdCard;
	}
	public void setHouseIdCard(String houseIdCard) {
		this.houseIdCard = houseIdCard;
	}
	public String getZh03FamilyNo() {
		return zh03FamilyNo;
	}
	public void setZh03FamilyNo(String zh03FamilyNo) {
		this.zh03FamilyNo = zh03FamilyNo;
	}

}
