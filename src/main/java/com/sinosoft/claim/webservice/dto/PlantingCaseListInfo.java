package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class PlantingCaseListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**农户代码*/
	private String fCode;
	/**农户姓名*/
	private String fName;
	/**投保面积*/
	private String insureArea;
	/**险别*/
	private String kindCode;
	/**单位保额*/
	private String amount = "0";
	/**总保额*/
	private String sumAmount = "0";
	/**总保费*/
	private String sumPremium= "0";
	/**费率*/
	private String rate= "0";
	/**短期费率方式*/
	private String shortRateFlag;
	/**短期费率*/
	private String shortRate= "0";
	/**自缴保费*/
	private String fPremium= "0";
	/**中央财政补贴*/
	private String centralPremium= "0";
	/**省级财政补贴*/
	private String provincePremium= "0";
	/**地方财政补贴*/
	private String cityPremium= "0";
	/**县区财政补贴*/
	private String townPremium= "0";
	/**其他补贴*/
	private String otherPremium= "0";
	/**保险起期*/
	private String startDate;
	/**保险止期*/
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
