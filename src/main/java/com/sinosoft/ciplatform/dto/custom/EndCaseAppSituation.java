package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class EndCaseAppSituation {
	private String lossType=""; //赔款类型
	private String kindCode=""; //险别类型
	private double appPaySum; //追加赔款金额
	private String riskcodeType=""; //赔偿险种类型
	
	private List endCaseSituationDetailList=new ArrayList(); //损失赔偿情况明细
	
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
