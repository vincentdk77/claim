package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyItemDeviceInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 所有人 */
	private String holder;
	/** 抵押权人 */
	private String pawner;
	/** 生产厂家 1526发动机号*/
	private String productWorkshop;
	/** 产品名称 1526车架号*/
	private String productName;
	/** 出厂日期 */
	private String factoryDate;
	/** 产品型号 1526厂牌型号*/
	private String productModel;
	/** 出厂编号 1526号牌号码*/
	private String factoryNo;
	/** 发动机号 */
	private String engineNo;
	/** 底盘号 */
	private String underpanNo;
	/** 车架号 */
	private String frameNo;
	/** 使用地点 1526单层/双层/卧铺*/
	private String useAddress;
	/** 年折旧率 */
	private String yearOldRate;
	/** 使用区域 */
	private String useArea;
	/** 是否安装了GPS */
	private String GPS;
	/** 设备已使用年限 */
	private String limitYear;
	/** 序号 */
	private String itemNo;
	/** 核定载客（人） */
	private String preUseTemperature;
	/** 运营公路等级 */
	private String fuelName;

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getPawner() {
		return pawner;
	}

	public void setPawner(String pawner) {
		this.pawner = pawner;
	}

	public String getProductWorkshop() {
		return productWorkshop;
	}

	public void setProductWorkshop(String productWorkshop) {
		this.productWorkshop = productWorkshop;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFactoryDate() {
		return factoryDate;
	}

	public void setFactoryDate(String factoryDate) {
		this.factoryDate = factoryDate;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getFactoryNo() {
		return factoryNo;
	}

	public void setFactoryNo(String factoryNo) {
		this.factoryNo = factoryNo;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getUnderpanNo() {
		return underpanNo;
	}

	public void setUnderpanNo(String underpanNo) {
		this.underpanNo = underpanNo;
	}

	public String getFrameNo() {
		return frameNo;
	}

	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}

	public String getUseAddress() {
		return useAddress;
	}

	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}

	public String getYearOldRate() {
		return yearOldRate;
	}

	public void setYearOldRate(String yearOldRate) {
		this.yearOldRate = yearOldRate;
	}

	public String getUseArea() {
		return useArea;
	}

	public void setUseArea(String useArea) {
		this.useArea = useArea;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String gps) {
		GPS = gps;
	}

	public String getLimitYear() {
		return limitYear;
	}

	public void setLimitYear(String limitYear) {
		this.limitYear = limitYear;
	}

	public String getItemNo() {
		return itemNo;
	}

	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	public String getPreUseTemperature() {
		return preUseTemperature;
	}

	public void setPreUseTemperature(String preUseTemperature) {
		this.preUseTemperature = preUseTemperature;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

}
