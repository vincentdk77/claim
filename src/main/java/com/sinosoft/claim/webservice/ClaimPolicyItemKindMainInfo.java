package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyItemKindMainInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 标的序号 */
	private String itemKindNoMain;
	/** 地址序号 */
	private String addressNo;
	/** 币别 */
	private String currency;
	/** 保额 */
	private String amount;
	/** 年费率 */
	private String rate;
	/** 保费 */
	private String premium;
	/** 标的类别 */
	private String itemCode;
	/** 标的名称 */
	private String itemDetailName;
	/** 以何种价值投保代码 */
	private String modeCodeMain;
	/** 以何种价值投保名称 */
	private String modeNameMain;
	/** 累计赔偿限额 */
	private String limitType04Main;
	/** 每次事故赔偿限额 */
	private String limitType01Main;
	/** 每次事故财产损失赔偿限额 */
	private String limitType03Main;
	/** 每次事故人身伤亡赔偿限额 */
	private String limitType07Main;
	/** 其中，每人赔偿限额 */
	private String limitType02Main;
	/** 每人责任限额 */
	private String limitType26Main;
	/** 投保座位数/数量 */
	private String quantityMain;
	/** 险别代码 */
	private String kindCodeMain;
	/** 险别名称 */
	private String kindNameMain;
	/** 短期费率方式 */
	private String shortRateFlagMain;
	/** 短期系数% */
	private String ShortRateMain;
	/** 单份保额 */
	private String baseAmountMain;
	/** 预期及经验赔付率调整系数 */
	private String payAdjustrateMain;
	/** 特别风险调整系数 */
	private String riskAdjustrateMain;
	/** 单份基准保费 */
	private String sigleBasePremiumMain;
	/** 单份保费 */
	private String basePremiumMain;
	/** 优惠系数% */
	private String discountMain;
	/** 分户名称 */
	private String familyNameMain;
	/** 每人保额 */
	private String unitAmountMain;
	/** 方案 */
	private String rationTypeMain;

	public String getItemKindNoMain() {
		return itemKindNoMain;
	}

	public void setItemKindNoMain(String itemKindNoMain) {
		this.itemKindNoMain = itemKindNoMain;
	}

	public String getAddressNo() {
		return addressNo;
	}

	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDetailName() {
		return itemDetailName;
	}

	public void setItemDetailName(String itemDetailName) {
		this.itemDetailName = itemDetailName;
	}

	public String getModeCodeMain() {
		return modeCodeMain;
	}

	public void setModeCodeMain(String modeCodeMain) {
		this.modeCodeMain = modeCodeMain;
	}

	public String getModeNameMain() {
		return modeNameMain;
	}

	public void setModeNameMain(String modeNameMain) {
		this.modeNameMain = modeNameMain;
	}

	public String getLimitType04Main() {
		return limitType04Main;
	}

	public void setLimitType04Main(String limitType04Main) {
		this.limitType04Main = limitType04Main;
	}

	public String getLimitType01Main() {
		return limitType01Main;
	}

	public void setLimitType01Main(String limitType01Main) {
		this.limitType01Main = limitType01Main;
	}

	public String getLimitType03Main() {
		return limitType03Main;
	}

	public void setLimitType03Main(String limitType03Main) {
		this.limitType03Main = limitType03Main;
	}

	public String getLimitType07Main() {
		return limitType07Main;
	}

	public void setLimitType07Main(String limitType07Main) {
		this.limitType07Main = limitType07Main;
	}

	public String getLimitType02Main() {
		return limitType02Main;
	}

	public void setLimitType02Main(String limitType02Main) {
		this.limitType02Main = limitType02Main;
	}

	public String getLimitType26Main() {
		return limitType26Main;
	}

	public void setLimitType26Main(String limitType26Main) {
		this.limitType26Main = limitType26Main;
	}

	public String getQuantityMain() {
		return quantityMain;
	}

	public void setQuantityMain(String quantityMain) {
		this.quantityMain = quantityMain;
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

	public String getShortRateFlagMain() {
		return shortRateFlagMain;
	}

	public void setShortRateFlagMain(String shortRateFlagMain) {
		this.shortRateFlagMain = shortRateFlagMain;
	}

	public String getShortRateMain() {
		return ShortRateMain;
	}

	public void setShortRateMain(String shortRateMain) {
		ShortRateMain = shortRateMain;
	}

	public String getBaseAmountMain() {
		return baseAmountMain;
	}

	public void setBaseAmountMain(String baseAmountMain) {
		this.baseAmountMain = baseAmountMain;
	}

	public String getPayAdjustrateMain() {
		return payAdjustrateMain;
	}

	public void setPayAdjustrateMain(String payAdjustrateMain) {
		this.payAdjustrateMain = payAdjustrateMain;
	}

	public String getRiskAdjustrateMain() {
		return riskAdjustrateMain;
	}

	public void setRiskAdjustrateMain(String riskAdjustrateMain) {
		this.riskAdjustrateMain = riskAdjustrateMain;
	}

	public String getSigleBasePremiumMain() {
		return sigleBasePremiumMain;
	}

	public void setSigleBasePremiumMain(String sigleBasePremiumMain) {
		this.sigleBasePremiumMain = sigleBasePremiumMain;
	}

	public String getBasePremiumMain() {
		return basePremiumMain;
	}

	public void setBasePremiumMain(String basePremiumMain) {
		this.basePremiumMain = basePremiumMain;
	}

	public String getDiscountMain() {
		return discountMain;
	}

	public void setDiscountMain(String discountMain) {
		this.discountMain = discountMain;
	}

	public String getFamilyNameMain() {
		return familyNameMain;
	}

	public void setFamilyNameMain(String familyNameMain) {
		this.familyNameMain = familyNameMain;
	}

	public String getUnitAmountMain() {
		return unitAmountMain;
	}

	public void setUnitAmountMain(String unitAmountMain) {
		this.unitAmountMain = unitAmountMain;
	}

	public String getRationTypeMain() {
		return rationTypeMain;
	}

	public void setRationTypeMain(String rationTypeMain) {
		this.rationTypeMain = rationTypeMain;
	}

}
