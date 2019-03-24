package com.sinosoft.claimciplatform.dto.custom;

public class EndCaseAppSituation {
	private String lossType=""; //赔款类型
	private double appPaySum; //追加赔款金额
	public double getAppPaySum() {
		return appPaySum;
	}
	public void setAppPaySum(double appPaySum) {
		this.appPaySum = appPaySum;
	}
	public String getLossType() {
		return lossType;
	}
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}
}
