package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 联系人信息回访清单
 * 联系人信息回访清单详细信息（LinkmanListMainInfo）
 * @author Administrator
 *
 */
public class LinkmanListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 保单：客户姓名                 */         
	 private String policyInsuredName        = "";
	/** 保单：客户联系人电话           */         
	 private String policyInsuredMobilePhone = "";
	/** 保单：客户联系人手机           */         
	 private String policyInsuredMobile      = "";
	/** 报案：报案人姓名               */         
	 private String registReportorName       = "";
	/** 报案：报案人电话               */         
	 private String registReportorPhone      = "";
	/** 报案：被保险人姓名             */         
	 private String registInsuredName        = "";
	/** 报案：被保险人固定电话         */         
	 private String registInsuredPhone       = "";
	/** 报案：被保险人手机号           */         
	 private String registInsuredMobilePhone = "";
	/** 报案：驾驶员姓名（仅车险）     */         
	 private String registDriverName         = "";
	/** 报案：驾驶员联系电话（仅车险） */         
	 private String registDriverPhone        = "";
	/** 理算：联系人                   */         
	 private String compeReceiverfullname    = "";
	/** 理算：联系人电话               */         
	 private String compeFamilyPhone         = "";
	 
	 private String registLinkerName ="";
	 private String registPhoneNumber ="";
	public LinkmanListMainInfo() {
		super();
	}
	public String getPolicyInsuredName() {
		return policyInsuredName;
	}
	public void setPolicyInsuredName(String policyInsuredName) {
		this.policyInsuredName = policyInsuredName;
	}
	public String getPolicyInsuredMobilePhone() {
		return policyInsuredMobilePhone;
	}
	public void setPolicyInsuredMobilePhone(String policyInsuredMobilePhone) {
		this.policyInsuredMobilePhone = policyInsuredMobilePhone;
	}
	public String getPolicyInsuredMobile() {
		return policyInsuredMobile;
	}
	public void setPolicyInsuredMobile(String policyInsuredMobile) {
		this.policyInsuredMobile = policyInsuredMobile;
	}
	public String getRegistReportorName() {
		return registReportorName;
	}
	public void setRegistReportorName(String registReportorName) {
		this.registReportorName = registReportorName;
	}
	public String getRegistReportorPhone() {
		return registReportorPhone;
	}
	public void setRegistReportorPhone(String registReportorPhone) {
		this.registReportorPhone = registReportorPhone;
	}
	public String getRegistInsuredName() {
		return registInsuredName;
	}
	public void setRegistInsuredName(String registInsuredName) {
		this.registInsuredName = registInsuredName;
	}
	public String getRegistInsuredPhone() {
		return registInsuredPhone;
	}
	public void setRegistInsuredPhone(String registInsuredPhone) {
		this.registInsuredPhone = registInsuredPhone;
	}
	public String getRegistInsuredMobilePhone() {
		return registInsuredMobilePhone;
	}
	public void setRegistInsuredMobilePhone(String registInsuredMobilePhone) {
		this.registInsuredMobilePhone = registInsuredMobilePhone;
	}
	public String getRegistDriverName() {
		return registDriverName;
	}
	public void setRegistDriverName(String registDriverName) {
		this.registDriverName = registDriverName;
	}
	public String getRegistDriverPhone() {
		return registDriverPhone;
	}
	public void setRegistDriverPhone(String registDriverPhone) {
		this.registDriverPhone = registDriverPhone;
	}
	public String getCompeReceiverfullname() {
		return compeReceiverfullname;
	}
	public void setCompeReceiverfullname(String compeReceiverfullname) {
		this.compeReceiverfullname = compeReceiverfullname;
	}
	public String getCompeFamilyPhone() {
		return compeFamilyPhone;
	}
	public void setCompeFamilyPhone(String compeFamilyPhone) {
		this.compeFamilyPhone = compeFamilyPhone;
	}
	public String getRegistLinkerName() {
		return registLinkerName;
	}
	public void setRegistLinkerName(String registLinkerName) {
		this.registLinkerName = registLinkerName;
	}
	public String getRegistPhoneNumber() {
		return registPhoneNumber;
	}
	public void setRegistPhoneNumber(String registPhoneNumber) {
		this.registPhoneNumber = registPhoneNumber;
	}
	
	 
	
	

}
