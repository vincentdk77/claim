package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ResidentAppInforList implements Serializable{
	private static final long serialVersionUID = 1L;
	/**ũ������*/
	private String fCode;
	/**ũ������*/
	private String fName;
	/**���֤����*/
	private String fIdcard;
	/**��ϵ�绰*/
	private String phone;
	/**Ͷ���˵�ַ*/
	private String appliAddress;
	/**������*/
	private String registNo;
	/**������*/
	private String claimNo;
	/**�����嵥��*/
	private String settleListCode;
	/**Ͷ�����*/
	private String insureArea;
	/**����*/
	private String amount;
	/**�⸶�ձ����*/
	private String kindCode;
	/**������Դ*/
	private String fieldSource;
	/**�⸶����*/
	private String claimRate;
	/**�������*/
	private String settleArea;
	/**��ʧ��*/
	private String lossRate;
	/**�⳥���*/
	private String settleSum;
	/**��ע*/
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
