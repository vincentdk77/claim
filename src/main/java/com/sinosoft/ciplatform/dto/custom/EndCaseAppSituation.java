package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class EndCaseAppSituation {
	private String lossType=""; //�������
	private String kindCode=""; //�ձ�����
	private double appPaySum; //׷�������
	private String riskcodeType=""; //�⳥��������
	
	private List endCaseSituationDetailList=new ArrayList(); //��ʧ�⳥�����ϸ
	
	public List getEndCaseSituationDetailList() {
		return endCaseSituationDetailList;
	}
	public void setEndCaseSituationDetailList(List endCaseSituationDetailList) {
		this.endCaseSituationDetailList = endCaseSituationDetailList;
	}
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
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getRiskcodeType() {
		return riskcodeType;
	}
	public void setRiskcodeType(String riskcodeType) {
		this.riskcodeType = riskcodeType;
	}
	
}
