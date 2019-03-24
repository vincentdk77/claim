package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class HouseCaseListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**ũ������*/
	private String name;
	/**ũ�����֤*/
	private String idCard;
	/**�ձ�*/
	private String kindCode;
	/**��ͥ��ַ*/
	private String address;
	/**¥������*/
	private String floor;
	/**¥������*/
	private String buildIngNumber;
	/**שǽ�߶�*/
	private String zhuanNumber;
	/**��ǽ�߶�*/
	private String waNumber;
	/**��������*/
	private String kitchenNumber;
	/**�ܱ���*/
	private String sumAmount = "0";
	/**�ܱ���*/
	private String sumpremium = "0";
	/**����*/
	private String rate = "0";
	/**�Խɱ���*/
	private String fpremium = "0";
	/**ʡ����������*/
	private String provincepremium = "0";
	/**�ط���������*/
	private String citypremium = "0";
	/**������������*/
	private String townpremium = "0";
	/**��������*/
	private String otherpremium = "0";
	/**��������*/
	private String startDate;
	/**����ֹ��*/
	private String endDate;
	/**��ϵ�绰*/
	private String phone;
	/**��ע*/
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
