package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class LossSituation {
	private String policyNo=""; //保单号
	private double indemnitydutyrate=0; //赔偿责任比例
	private String lossType=""; //损失赔偿类型
	private String riskcodeType=""; //赔偿险种类型
	private String riskcode=""; //赔偿险种代码
	private double sumLoss=0; //损失金额
	private double sumPay=0; //赔款金额
	private List lossSituationDetailList=new ArrayList(); //损失赔偿情况明细
	public double getIndemnitydutyrate() {
		return indemnitydutyrate;
	}
	public void setIndemnitydutyrate(double indemnitydutyrate) {
		this.indemnitydutyrate = indemnitydutyrate;
	}
	public String getLossType() {
		return lossType;
	}
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRiskcode() {
		return riskcode;
	}
	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}
	public String getRiskcodeType() {
		return riskcodeType;
	}
	public void setRiskcodeType(String riskcodeType) {
		this.riskcodeType = riskcodeType;
	}
	public double getSumLoss() {
		return sumLoss;
	}
	public void setSumLoss(double sumLoss) {
		this.sumLoss = sumLoss;
	}
	public double getSumPay() {
		return sumPay;
	}
	public void setSumPay(double sumPay) {
		this.sumPay = sumPay;
	}
	public List getLossSituationDetailList() {
		return lossSituationDetailList;
	}
	public void setLossSituationDetailList(List lossSituationDetailList) {
		this.lossSituationDetailList = lossSituationDetailList;
	}
	public void addLossSituationDetail(LossSituationDetail lossSituationDetail){
		this.lossSituationDetailList.add(lossSituationDetail);
	}
}
