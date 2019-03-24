package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyItemKindZHMainInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 标志位 1：投保项目一，2：投保项目二，3：投保项目三 */
	private String flag;
	/** 标的序号 */
	private String itemKindNoMain;
	/** 条款名称,险别代码 */
	private String kindCodeMain;
	/** 条款名称,险别名称 */
	private String kindNameMain;
	/** 方案 */
	private String rationTypeMain;
	/** 币别 */
	private String currency;
	/** 短期费率方式 */
	private String shortRateFlagMain;
	/** 短期系数% */
	private String shortRateMain;
	/** 每人保额 */
	private String unitAmountMain;
	/** 人数 */
	private String quantityMain;
	/** 保额 */
	private String amountMain;
	/** 年费率 */
	private String rateMain;
	/** 保费 */
	private String premiumMain;
	/** 优惠系数 */
	private String discountMain;
	/** 标的类别 */
	private String itemCode;
	/** 标的类别名称 */
	private String itemName;
	/** 标的项目 */
	private String itemDetailName;
	/** 地址序号 */
	private String addressNoMain;
	/** 保险金额(元)／户 */
	private String baseAmountMain;
	/** 户数 */
	private String SumDoorMain;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getItemKindNoMain() {
		return itemKindNoMain;
	}

	public void setItemKindNoMain(String itemKindNoMain) {
		this.itemKindNoMain = itemKindNoMain;
	}

	public String getKindCodeMain() {
		return kindCodeMain;
	}

	public void setKindCodeMain(String kindCodeMain) {
		this.kindCodeMain = kindCodeMain;
	}

	public String getKindNameMain() {
		return kindNameMain;
	}

	public void setKindNameMain(String kindNameMain) {
		this.kindNameMain = kindNameMain;
	}

	public String getRationTypeMain() {
		return rationTypeMain;
	}

	public void setRationTypeMain(String rationTypeMain) {
		this.rationTypeMain = rationTypeMain;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getShortRateFlagMain() {
		return shortRateFlagMain;
	}

	public void setShortRateFlagMain(String shortRateFlagMain) {
		this.shortRateFlagMain = shortRateFlagMain;
	}

	public String getShortRateMain() {
		return shortRateMain;
	}

	public void setShortRateMain(String shortRateMain) {
		this.shortRateMain = shortRateMain;
	}

	public String getUnitAmountMain() {
		return unitAmountMain;
	}

	public void setUnitAmountMain(String unitAmountMain) {
		this.unitAmountMain = unitAmountMain;
	}

	public String getQuantityMain() {
		return quantityMain;
	}

	public void setQuantityMain(String quantityMain) {
		this.quantityMain = quantityMain;
	}

	public String getAmountMain() {
		return amountMain;
	}

	public void setAmountMain(String amountMain) {
		this.amountMain = amountMain;
	}

	public String getRateMain() {
		return rateMain;
	}

	public void setRateMain(String rateMain) {
		this.rateMain = rateMain;
	}

	public String getPremiumMain() {
		return premiumMain;
	}

	public void setPremiumMain(String premiumMain) {
		this.premiumMain = premiumMain;
	}

	public String getDiscountMain() {
		return discountMain;
	}

	public void setDiscountMain(String discountMain) {
		this.discountMain = discountMain;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDetailName() {
		return itemDetailName;
	}

	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}

	public String getAddressNoMain() {
		return addressNoMain;
	}

	public void setAddressNoMain(String addressNoMain) {
		this.addressNoMain = addressNoMain;
	}

	public String getBaseAmountMain() {
		return baseAmountMain;
	}

	public void setBaseAmountMain(String baseAmountMain) {
		this.baseAmountMain = baseAmountMain;
	}

	public String getSumDoorMain() {
		return SumDoorMain;
	}

	public void setSumDoorMain(String sumDoorMain) {
		SumDoorMain = sumDoorMain;
	}

}
