package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyItemDeviceInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������ */
	private String holder;
	/** ��ѺȨ�� */
	private String pawner;
	/** �������� 1526��������*/
	private String productWorkshop;
	/** ��Ʒ���� 1526���ܺ�*/
	private String productName;
	/** �������� */
	private String factoryDate;
	/** ��Ʒ�ͺ� 1526�����ͺ�*/
	private String productModel;
	/** ������� 1526���ƺ���*/
	private String factoryNo;
	/** �������� */
	private String engineNo;
	/** ���̺� */
	private String underpanNo;
	/** ���ܺ� */
	private String frameNo;
	/** ʹ�õص� 1526����/˫��/����*/
	private String useAddress;
	/** ���۾��� */
	private String yearOldRate;
	/** ʹ������ */
	private String useArea;
	/** �Ƿ�װ��GPS */
	private String GPS;
	/** �豸��ʹ������ */
	private String limitYear;
	/** ��� */
	private String itemNo;
	/** �˶��ؿͣ��ˣ� */
	private String preUseTemperature;
	/** ��Ӫ��·�ȼ� */
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
