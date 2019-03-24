package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyItemKindSubInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 标的序号 */
	private String itemKindNoSub;
	/** 条款代码 */
	private String kindCodeSub;
	/** 条款名称 */
	private String kindNameSub;
	/** 币别 */
	private String currencySub;
	/** 保费 */
	private String premiumSub;
	/** 年费率 */
	private String rateSub;
	/** 保额 */
	private String amountSub;
	/** 累计赔偿限额 */
	private String limitType04Sub;
	/** 每次事故赔偿限额 */
	private String limitType01Sub;
	/** 附加险/附加条款的条款内容 */
	private String itemKindSub_Context;
	/** 每人责任限额 */
	private String limitType26Sub;
	/** 累计责任限额 */
	private String limitType02Sub;
	/** 投保座位数/数量 */
	private String quantitySub;
	/** 短期费率方式 */
	private String shortRateFlagSub;
	/** 短期系数% */
	private String ShortRateSub;
	/** 运输风险调整系数 */
	private String transRiskAdjustRateSub;
	/** 规模调整系数 */
	private String scaleAdjustRateSub;
	/** 预期及经验赔付率调整系数 */
	private String payAdjustRateSub;
	/** 特别风险调整系数 */
	private String riskAdjustRateSub;
	/** 优惠系数% */
	private String discountSub;
	/** 分户名称 */
	private String familyNameSub;
	/** 每人保额 */
	private String unitAmountSub;
	/** 方案 */
	private String rationTypeSub;

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

	public String getCurrencySub() {
		return currencySub;
	}

	public void setCurrencySub(String currencySub) {
		this.currencySub = currencySub;
	}

	public String getAmountSub() {
		return amountSub;
	}

	public void setAmountSub(String amountSub) {
		this.amountSub = amountSub;
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

	public String getLimitType04Sub() {
		return limitType04Sub;
	}

	public void setLimitType04Sub(String limitType04Sub) {
		this.limitType04Sub = limitType04Sub;
	}

	public String getLimitType01Sub() {
		return limitType01Sub;
	}

	public void setLimitType01Sub(String limitType01Sub) {
		this.limitType01Sub = limitType01Sub;
	}

	public String getItemKindSub_Context() {
		return itemKindSub_Context;
	}

	public void setItemKindSub_Context(String itemKindSub_Context) {
		this.itemKindSub_Context = itemKindSub_Context;
	}

	public String getLimitType26Sub() {
		return limitType26Sub;
	}

	public void setLimitType26Sub(String limitType26Sub) {
		this.limitType26Sub = limitType26Sub;
	}

	public String getLimitType02Sub() {
		return limitType02Sub;
	}

	public void setLimitType02Sub(String limitType02Sub) {
		this.limitType02Sub = limitType02Sub;
	}

	public String getQuantitySub() {
		return quantitySub;
	}

	public void setQuantitySub(String quantitySub) {
		this.quantitySub = quantitySub;
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

	public String getTransRiskAdjustRateSub() {
		return transRiskAdjustRateSub;
	}

	public void setTransRiskAdjustRateSub(String transRiskAdjustRateSub) {
		this.transRiskAdjustRateSub = transRiskAdjustRateSub;
	}

	public String getScaleAdjustRateSub() {
		return scaleAdjustRateSub;
	}

	public void setScaleAdjustRateSub(String scaleAdjustRateSub) {
		this.scaleAdjustRateSub = scaleAdjustRateSub;
	}

	public String getPayAdjustRateSub() {
		return payAdjustRateSub;
	}

	public void setPayAdjustRateSub(String payAdjustRateSub) {
		this.payAdjustRateSub = payAdjustRateSub;
	}

	public String getRiskAdjustRateSub() {
		return riskAdjustRateSub;
	}

	public void setRiskAdjustRateSub(String riskAdjustRateSub) {
		this.riskAdjustRateSub = riskAdjustRateSub;
	}

	public String getDiscountSub() {
		return discountSub;
	}

	public void setDiscountSub(String discountSub) {
		this.discountSub = discountSub;
	}

	public String getFamilyNameSub() {
		return familyNameSub;
	}

	public void setFamilyNameSub(String familyNameSub) {
		this.familyNameSub = familyNameSub;
	}

	public String getUnitAmountSub() {
		return unitAmountSub;
	}

	public void setUnitAmountSub(String unitAmountSub) {
		this.unitAmountSub = unitAmountSub;
	}

	public String getRationTypeSub() {
		return rationTypeSub;
	}

	public void setRationTypeSub(String rationTypeSub) {
		this.rationTypeSub = rationTypeSub;
	}

}
