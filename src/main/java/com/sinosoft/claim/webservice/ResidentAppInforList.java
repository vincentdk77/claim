package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ResidentAppInforList implements Serializable{
	private static final long serialVersionUID = 1L;
	/**农户代码*/
	private String fCode;
	/**农户姓名*/
	private String fName;
	/**身份证号码*/
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
	/**投保面积*/
	private String insureArea;
	/**保额*/
	private String amount;
	/**赔付险别代码*/
	private String kindCode;
	/**土地来源*/
	private String fieldSource;
	/**赔付比例*/
	private String claimRate;
	/**受损面积*/
	private String settleArea;
	/**损失率*/
	private String lossRate;
	/**赔偿金额*/
	private String settleSum;
	/**备注*/
	private String reMark;
	
    public ResidentAppInforList(){
		
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
	public String getInsureArea() {
		return insureArea;
	}
	public void setInsureArea(String insureArea) {
		this.insureArea = insureArea;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getFieldSource() {
		return fieldSource;
	}
	public void setFieldSource(String fieldSource) {
		this.fieldSource = fieldSource;
	}
	public String getClaimRate() {
		return claimRate;
	}
	public void setClaimRate(String claimRate) {
		this.claimRate = claimRate;
	}
	public String getSettleArea() {
		return settleArea;
	}
	public void setSettleArea(String settleArea) {
		this.settleArea = settleArea;
	}
	public String getLossRate() {
		return lossRate;
	}
	public void setLossRate(String lossRate) {
		this.lossRate = lossRate;
	}
	public String getSettleSum() {
		return settleSum;
	}
	public void setSettleSum(String settleSum) {
		this.settleSum = settleSum;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	
	
	
	

}
