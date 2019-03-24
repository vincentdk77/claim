package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * ������Ϣ�ط��嵥 �������ݴ������
 * @author Administrator
 *
 */
public class CaseClaimListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**������*/
	private String reportorName;
	/**��ϵ��*/
	private String linkerName;
	/**��ϵ�绰*/
	private String phoneNumber;
	/**����ʱ��*/
	private String damageStartDate;
	/**����ʱ��*/
	private String reportDate;
	/**�᰸ʱ��*/
	private String endCaseDate;
	/**����ԭ��*/
	private String damageName;
	/**���յص�*/
	private String damageAddress;
	/**����ժҪ*/
	private String context;
	/**��֤���ڵ����֤���루ũ����*/
	private String houseIdCard;
	/**��֤���ڵĻ���ţ�ũ�Ҹ���*/
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
