package com.sinosoft.claimciplatform.dto.custom;

public class EndCaseAppSituation {
	private String lossType=""; //�������
	private double appPaySum; //׷�������
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
