package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyPlanFeeInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** �ڴ� */
	private String payNo;
	/** �ɷ����� */
	private String planStartDate;
	/** �ɷ�ֹ�� */
	private String planEndDate;
	/** �ұ����� */
	private String currencyName;
	/** Ӧ�ɽ�� */
	private double dbPlanFee;
	/** ʵ�ɽ�� */
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
