package com.sinosoft.claim.webservice;

/**
 * 驻点员App农户清单(养殖险)查询基础类
 * @author CDB
 *
 */
public class FindAppFarmerInfoList {
	private static final long serialVersionUID = 1L;
	/**农户代码*/
	private String fCode;
	/**农户姓名*/
	private String fName;
	/**身份证号码/组织机构代码证*/
	private String fIdcard;
	/**联系电话*/
	private String phone;
	/**投保人地址*/
	private String appliAddress;
	/**报案号*/
	private String registNo;
	/**立案号*/
	private String claimNo;
	/**案件清单号*/
	private String settleListCode;
	/**保额*/
	private String amount;
	/**耳标号*/
	private String earlable;
	/**养殖地点*/
	private String breedingArea;
	/**开户银行*/
	private String bankName;
	/**银行帐号*/
	private String bankAccount;
	/**死亡数量*/
	private String deadnumber;
	/**扑杀数量*/
	private String killNumber;
	/**赔偿金额(养殖险)*/
	private String settleAmount;
	/**投保数量(面积)*/
	private String insureArea;
	/**受损面积*/
	private String settleArea;
	
    public String getInsureArea() {
		return insureArea;
	}
	public void setInsureArea(String insureArea) {
		this.insureArea = insureArea;
	}
	public String getEarlable() {
		return earlable;
	}
	public void setEarlable(String earlable) {
		this.earlable = earlable;
	}
	public String getBreedingArea() {
		return breedingArea;
	}
	public void setBreedingArea(String breedingArea) {
		this.breedingArea = breedingArea;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getDeadnumber() {
		return deadnumber;
	}
	public void setDeadnumber(String deadnumber) {
		this.deadnumber = deadnumber;
	}
	public String getKillNumber() {
		return killNumber;
	}
	public void setKillNumber(String killNumber) {
		this.killNumber = killNumber;
	}
	public String getSettleAmount() {
		return settleAmount;
	}
	public void setSettleAmount(String settleAmount) {
		this.settleAmount = settleAmount;
	}
	public FindAppFarmerInfoList(){
		
	}
	public String getFCode() {
		return fCode;
	}
	public void setFCode(String code) {
		fCode = code;
	}
	public String getFName() {
		return fName;
	}
	public void setFName(String name) {
		fName = name;
	}
	public String getFIdcard() {
		return fIdcard;
	}
	public void setFIdcard(String idcard) {
		fIdcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAppliAddress() {
		return appliAddress;
	}
	public void setAppliAddress(String appliAddress) {
		this.appliAddress = appliAddress;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getSettleListCode() {
		return settleListCode;
	}
	public void setSettleListCode(String settleListCode) {
		this.settleListCode = settleListCode;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSettleArea() {
		return settleArea;
	}
	public void setSettleArea(String settleArea) {
		this.settleArea = settleArea;
	}
}
