package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class HouseCaseListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**农户姓名*/
	private String name;
	/**农户身份证*/
	private String idCard;
	/**险别*/
	private String kindCode;
	/**家庭地址*/
	private String address;
	/**楼房层数*/
	private String floor;
	/**楼房间数*/
	private String buildIngNumber;
	/**砖墙瓦顶*/
	private String zhuanNumber;
	/**土墙瓦顶*/
	private String waNumber;
	/**厨房间数*/
	private String kitchenNumber;
	/**总保额*/
	private String sumAmount = "0";
	/**总保费*/
	private String sumpremium = "0";
	/**费率*/
	private String rate = "0";
	/**自缴保费*/
	private String fpremium = "0";
	/**省级财政补贴*/
	private String provincepremium = "0";
	/**地方财政补贴*/
	private String citypremium = "0";
	/**县区财政补贴*/
	private String townpremium = "0";
	/**其他补贴*/
	private String otherpremium = "0";
	/**保险起期*/
	private String startDate;
	/**保险止期*/
	private String endDate;
	/**联系电话*/
	private String phone;
	/**备注*/
	private String remark;
	public HouseCaseListInfo() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public String getBuildIngNumber() {
		return buildIngNumber;
	}
	public void setBuildIngNumber(String buildIngNumber) {
		this.buildIngNumber = buildIngNumber;
	}
	public String getZhuanNumber() {
		return zhuanNumber;
	}
	public void setZhuanNumber(String zhuanNumber) {
		this.zhuanNumber = zhuanNumber;
	}
	public String getWaNumber() {
		return waNumber;
	}
	public void setWaNumber(String waNumber) {
		this.waNumber = waNumber;
	}
	public String getKitchenNumber() {
		return kitchenNumber;
	}
	public void setKitchenNumber(String kitchenNumber) {
		this.kitchenNumber = kitchenNumber;
	}
	
	public String getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getSumpremium() {
		return sumpremium;
	}
	public void setSumpremium(String sumpremium) {
		this.sumpremium = sumpremium;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getFpremium() {
		return fpremium;
	}
	public void setFpremium(String fpremium) {
		this.fpremium = fpremium;
	}
	public String getProvincepremium() {
		return provincepremium;
	}
	public void setProvincepremium(String provincepremium) {
		this.provincepremium = provincepremium;
	}
	public String getCitypremium() {
		return citypremium;
	}
	public void setCitypremium(String citypremium) {
		this.citypremium = citypremium;
	}
	public String getTownpremium() {
		return townpremium;
	}
	public void setTownpremium(String townpremium) {
		this.townpremium = townpremium;
	}
	public String getOtherpremium() {
		return otherpremium;
	}
	public void setOtherpremium(String otherpremium) {
		this.otherpremium = otherpremium;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	


}
