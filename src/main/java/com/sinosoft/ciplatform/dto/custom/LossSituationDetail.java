package com.sinosoft.ciplatform.dto.custom;

public class LossSituationDetail {
	private String lossType=""; //��ʧ�⳥����
	private String lossTypeDetail=""; //��ʧ�⳥����ϸ��
	private String kindCode = "";  
	private double sumLoss=0; //��ʧ���
	private double sumPay=0;//��ʧ�⳥���
	private double indemnitydutyrate=0;//�⳥���α���
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
	public String getLossTypeDetail() {
		return lossTypeDetail;
	}
	public void setLossTypeDetail(String lossTypeDetail) {
		this.lossTypeDetail = lossTypeDetail;
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
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	
}
