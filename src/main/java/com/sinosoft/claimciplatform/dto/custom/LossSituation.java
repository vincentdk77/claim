package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class LossSituation {
	private String policyNo=""; //������
	private double indemnitydutyrate=0; //�⳥���α���
	private String lossType=""; //��ʧ�⳥����
	private String riskcodeType=""; //�⳥��������
	private String riskcode=""; //�⳥���ִ���
	private double sumLoss=0; //��ʧ���
	private double sumPay=0; //�����
	private List lossSituationDetailList=new ArrayList(); //��ʧ�⳥�����ϸ
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
