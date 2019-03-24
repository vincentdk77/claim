package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyInsuredInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 客户代码 */
	private String insuredCode;
	/** 客户名称 */
	private String insuredName;
	/** 客户类型 */
	private String insuredType;
	/** 客户标识 */
	private String insuredFlag;
	/** 证件类型 */
	private String identifyType;
	/** 证件号码 */
	private String identifyNumber;
	/** 客户语种 */
	private String insuredLanguage;
	/** 客户地址 */
	private String insuredAddress;
	/** 客户性质 */
	private String insuredNature;
	/** 是被保险人的 */
	private String insuredIdentity;
	/** 开户银行 */
	private String insuredBank;
	/** 账号 */
	private String insuredAccount;
	/** 联系人姓名 */
	private String insuredLinkerName;
	/** 联系人地址 */
	private String insuredPostAddress;
	/** 联系人邮编 */
	private String insuredPostCode;
	/** 联系人电话 */
	private String insuredPhoneNumber;
	/** 联系人手机 */
	private String insuredMobile;
	/** 投保人风险等级 */
	private String insuredRiskLevel;
	/** 法定代表人 */
	private String aLeaderName;
	/** 法定代表人身份证号码 */
	private String aLeaderID;

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

	public String getInsuredType() {
		return insuredType;
	}

	public void setInsuredType(String insuredType) {
		this.insuredType = insuredType;
	}

	public String getInsuredFlag() {
		return insuredFlag;
	}

	public void setInsuredFlag(String insuredFlag) {
		this.insuredFlag = insuredFlag;
	}

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getInsuredLanguage() {
		return insuredLanguage;
	}

	public void setInsuredLanguage(String insuredLanguage) {
		this.insuredLanguage = insuredLanguage;
	}

	public String getInsuredAddress() {
		return insuredAddress;
	}

	public void setInsuredAddress(String insuredAddress) {
		this.insuredAddress = insuredAddress;
	}

	public String getInsuredNature() {
		return insuredNature;
	}

	public void setInsuredNature(String insuredNature) {
		this.insuredNature = insuredNature;
	}

	public String getInsuredIdentity() {
		return insuredIdentity;
	}

	public void setInsuredIdentity(String insuredIdentity) {
		this.insuredIdentity = insuredIdentity;
	}

	public String getInsuredBank() {
		return insuredBank;
	}

	public void setInsuredBank(String insuredBank) {
		this.insuredBank = insuredBank;
	}

	public String getInsuredAccount() {
		return insuredAccount;
	}

	public void setInsuredAccount(String insuredAccount) {
		this.insuredAccount = insuredAccount;
	}

	public String getInsuredLinkerName() {
		return insuredLinkerName;
	}

	public void setInsuredLinkerName(String insuredLinkerName) {
		this.insuredLinkerName = insuredLinkerName;
	}

	public String getInsuredPostAddress() {
		return insuredPostAddress;
	}

	public void setInsuredPostAddress(String insuredPostAddress) {
		this.insuredPostAddress = insuredPostAddress;
	}

	public String getInsuredPostCode() {
		return insuredPostCode;
	}

	public void setInsuredPostCode(String insuredPostCode) {
		this.insuredPostCode = insuredPostCode;
	}

	public String getInsuredPhoneNumber() {
		return insuredPhoneNumber;
	}

	public void setInsuredPhoneNumber(String insuredPhoneNumber) {
		this.insuredPhoneNumber = insuredPhoneNumber;
	}

	public String getInsuredMobile() {
		return insuredMobile;
	}

	public void setInsuredMobile(String insuredMobile) {
		this.insuredMobile = insuredMobile;
	}

	public String getInsuredRiskLevel() {
		return insuredRiskLevel;
	}

	public void setInsuredRiskLevel(String insuredRiskLevel) {
		this.insuredRiskLevel = insuredRiskLevel;
	}

	public String getALeaderName() {
		return aLeaderName;
	}

	public void setALeaderName(String leaderName) {
		aLeaderName = leaderName;
	}

	public String getALeaderID() {
		return aLeaderID;
	}

	public void setALeaderID(String leaderID) {
		aLeaderID = leaderID;
	}

}
