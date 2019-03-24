package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyItemKindZHSubInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 标志位 1：投保项目一，2：投保项目二，3：投保项目三 */
	private String flag;
	/** 标的序号 */
	private String itemKindNoSub;
	/** 条款代码 */
	private String kindCodeSub;
	/** 条款名称 */
	private String kindNameSub;
	/** 方案 */
	private String rationTypeSub;
	/** 币别 */
	private String currencySub;
	/** 短期费率方式 */
	private String shortRateFlagSub;
	/** 短期系数% */
	private String ShortRateSub;
	/** 每人保额 */
	private String unitAmountSub;
	/** 人数 */
	private String quantitySub;
	/** 保费 */
	private String premiumSub;
	/** 费率 */
	private String rateSub;
	/** 保额 */
	private String amountSub;
	/** 优惠系数 */
	private String discountSub;
	/** 保险金额(元)／户 */
	private String baseAmountSub;
	/** 户数 */
	private String sumDoorSub;
	/** 条款内容 */
	private String itemKindSub_Context;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getItemKindNoSub() {
		return itemKindNoSub;
	}

	public void setItemKindNoSub(String itemKindNoSub) {
		this.itemKindNoSub = itemKindNoSub;
	}

	public String getKindCodeSub() {
		return kindCodeSub;
	}

	public void setKindCodeSub(String kindCodeSub) {
		this.kindCodeSub = kindCodeSub;
	}

	public String getKindNameSub() {
		return kindNameSub;
	}

	public void setKindNameSub(String kindNameSub) {
		this.kindNameSub = kindNameSub;
	}

	public String getRationTypeSub() {
		return rationTypeSub;
	}

	public void setRationTypeSub(String rationTypeSub) {
		this.rationTypeSub = rationTypeSub;
	}

	public String getCurrencySub() {
		return currencySub;
	}

	public void setCurrencySub(String currencySub) {
		this.currencySub = currencySub;
	}

	public String getShortRateFlagSub() {
		return shortRateFlagSub;
	}

	public void setShortRateFlagSub(String shortRateFlagSub) {
		this.shortRateFlagSub = shortRateFlagSub;
	}

	public String getShortRateSub() {
		return ShortRateSub;
	}

	public void setShortRateSub(String shortRateSub) {
		ShortRateSub = shortRateSub;
	}

	public String getUnitAmountSub() {
		return unitAmountSub;
	}

	public void setUnitAmountSub(String unitAmountSub) {
		this.unitAmountSub = unitAmountSub;
	}

	public String getQuantitySub() {
		return quantitySub;
	}

	public void setQuantitySub(String quantitySub) {
		this.quantitySub = quantitySub;
	}

	public String getPremiumSub() {
		return premiumSub;
	}

	public void setPremiumSub(String premiumSub) {
		this.premiumSub = premiumSub;
	}

	public String getRateSub() {
		return rateSub;
	}

	public void setRateSub(String rateSub) {
		this.rateSub = rateSub;
	}

	public String getAmountSub() {
		return amountSub;
	}

	public void setAmountSub(String amountSub) {
		this.amountSub = amountSub;
	}

	public String getDiscountSub() {
		return discountSub;
	}

	public void setDiscountSub(String discountSub) {
		this.discountSub = discountSub;
	}

	public String getBaseAmountSub() {
		return baseAmountSub;
	}

	public void setBaseAmountSub(String baseAmountSub) {
		this.baseAmountSub = baseAmountSub;
	}

	public String getSumDoorSub() {
		return sumDoorSub;
	}

	public void setSumDoorSub(String sumDoorSub) {
		this.sumDoorSub = sumDoorSub;
	}

	public String getItemKindSub_Context() {
		return itemKindSub_Context;
	}

	public void setItemKindSub_Context(String itemKindSub_Context) {
		this.itemKindSub_Context = itemKindSub_Context;
	}

}
