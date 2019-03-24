package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyPlanFeeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 期次 */
	private String payNo;
	/** 缴费起期 */
	private String planStartDate;
	/** 缴费止期 */
	private String planEndDate;
	/** 币别名称 */
	private String currencyName;
	/** 应缴金额 */
	private double dbPlanFee;
	/** 实缴金额 */
	private double dbPayRefFee;

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public double getDbPlanFee() {
		return dbPlanFee;
	}

	public void setDbPlanFee(double dbPlanFee) {
		this.dbPlanFee = dbPlanFee;
	}

	public double getDbPayRefFee() {
		return dbPayRefFee;
	}

	public void setDbPayRefFee(double dbPayRefFee) {
		this.dbPayRefFee = dbPayRefFee;
	}
}
