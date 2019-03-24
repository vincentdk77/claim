package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class PlantingCaseListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**ũ������*/
	private String fCode;
	/**ũ������*/
	private String fName;
	/**Ͷ�����*/
	private String insureArea;
	/**�ձ�*/
	private String kindCode;
	/**��λ����*/
	private String amount = "0";
	/**�ܱ���*/
	private String sumAmount = "0";
	/**�ܱ���*/
	private String sumPremium= "0";
	/**����*/
	private String rate= "0";
	/**���ڷ��ʷ�ʽ*/
	private String shortRateFlag;
	/**���ڷ���*/
	private String shortRate= "0";
	/**�Խɱ���*/
	private String fPremium= "0";
	/**�����������*/
	private String centralPremium= "0";
	/**ʡ����������*/
	private String provincePremium= "0";
	/**�ط���������*/
	private String cityPremium= "0";
	/**������������*/
	private String townPremium= "0";
	/**��������*/
	private String otherPremium= "0";
	/**��������*/
	private String startDate;
	/**����ֹ��*/
	private String endDate;
	public PlantingCaseListInfo() {
		super();
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
	public String getInsureArea() {
		return insureArea;
	}
	public void setInsureArea(String insureArea) {
		this.insureArea = insureArea;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getSumPremium() {
		return sumPremium;
	}
	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getShortRate() {
		return shortRate;
	}
	public void setShortRate(String shortRate) {
		this.shortRate = shortRate;
	}
	public String getFPremium() {
		return fPremium;
	}
	public void setFPremium(String premium) {
		fPremium = premium;
	}
	public String getCentralPremium() {
		return centralPremium;
	}
	public void setCentralPremium(String centralPremium) {
		this.centralPremium = centralPremium;
	}
	public String getProvincePremium() {
		return provincePremium;
	}
	public void setProvincePremium(String provincePremium) {
		this.provincePremium = provincePremium;
	}
	public String getCityPremium() {
		return cityPremium;
	}
	public void setCityPremium(String cityPremium) {
		this.cityPremium = cityPremium;
	}
	public String getTownPremium() {
		return townPremium;
	}
	public void setTownPremium(String townPremium) {
		this.townPremium = townPremium;
	}
	public String getOtherPremium() {
		return otherPremium;
	}
	public void setOtherPremium(String otherPremium) {
		this.otherPremium = otherPremium;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getShortRateFlag() {
		return shortRateFlag;
	}
	public void setShortRateFlag(String shortRateFlag) {
		this.shortRateFlag = shortRateFlag;
	}
	

}
