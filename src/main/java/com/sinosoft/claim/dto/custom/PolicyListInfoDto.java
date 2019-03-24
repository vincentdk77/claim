package com.sinosoft.claim.dto.custom;

import java.io.Serializable;
import java.util.Date;


public class PolicyListInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 保单号 */
	private String policyNo;
	/** 被保险人名称 */
	private String insuredName;
	/** 保险起期 */
	private String startDate;
	/** 保险止期 */
	private String endDate;
	/** 险种代码 */
	private String riskCode;
	/** 险种名称 */
	private String riskName;
	/** 业务归属机构 */
	private String comName;
	/** 业务归属机构代码 */
	private String comCode;
	/** 归属业务员 */
	private String handler1Name;
	/** 归属业务员名称 */
	private String handler1code;
	/** 出险地点 */
	private String addressName;
	/** 起运日期(货运险) */
	private String startSiteDate;
	/** 起运地(货运险) */
	private String startSiteName;
	/** 目的地(货运险) */
	private String endSiteName;
	/** 运输工具代码(货运险) */
	private String conveyanceCode;
	/** 运输工具名称(货运险) */
	private String conveyanceName;
	/** 航次(货运险) */
	private String voyageNo;
	/** 出险次数 */
	private String damageTimes;
	/** 保险金额 */
	private String amount;
	
	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
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

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getHandler1Name() {
		return handler1Name;
	}

	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}

	public String getHandler1code() {
		return handler1code;
	}

	public void setHandler1code(String handler1code) {
		this.handler1code = handler1code;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getStartSiteDate() {
		return startSiteDate;
	}

	public void setStartSiteDate(String startSiteDate) {
		this.startSiteDate = startSiteDate;
	}

	public String getStartSiteName() {
		return startSiteName;
	}

	public void setStartSiteName(String startSiteName) {
		this.startSiteName = startSiteName;
	}

	public String getEndSiteName() {
		return endSiteName;
	}

	public void setEndSiteName(String endSiteName) {
		this.endSiteName = endSiteName;
	}

	public String getConveyanceCode() {
		return conveyanceCode;
	}

	public void setConveyanceCode(String conveyanceCode) {
		this.conveyanceCode = conveyanceCode;
	}

	public String getConveyanceName() {
		return conveyanceName;
	}

	public void setConveyanceName(String conveyanceName) {
		this.conveyanceName = conveyanceName;
	}

	public String getVoyageNo() {
		return voyageNo;
	}

	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}

	public String getDamageTimes() {
		return damageTimes;
	}

	public void setDamageTimes(String damageTimes) {
		this.damageTimes = damageTimes;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
