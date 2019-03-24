package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EndCaseAppend {
	private String claimCode = "";	      	//理赔编码
	private String serialNo = "";			//追加次数
	private String policyNO ="";			//保单号
	private String registNo = "";			//报案号
	private String claimNo = "";			//立案号
	private String caseNo = "";			    //立案号
	private List endCaseAppSituationList=new ArrayList();//追加赔偿情况
	private double claimAmount = 0;         //赔款金额
	private String comCode ="";			    //归属机构
	private Date recaseDate;		        //重开日期
	private String recaseReason = "";	    //归属机构
	private String AccidentDeath = "";	    //追加期间是否发生有责任交通死亡事故
	private List carLossList = new ArrayList();  //商业险车辆损失情况
	private List personLossList = new ArrayList();  //商业险人伤损失情况
	private List propLossList = new ArrayList();  //商业险财产损失情况
	
	private String surveyType = "";			 //现场类别
	private String surveyName = "";			 //查勘人员姓名
	private String surveyStartTime ;		     //查勘开始时间
	private String surveyEndTime ;			 //查勘结束时间
	private String surveyPlace = "";		 //查勘地点
	private String surveyDes = "";			 //查勘情况说明
	private String esimateName = "";		 //定损人员姓名
	private String esimateStartTime ;		     //定损开始时间
	private String esimateEndTime ;			 //定损结束时间
	private String assesorName = "";		 //核损人员姓名
	private String assesorStartTime ;		     //核损开始时间
	private String assesorEndTime ;			 //核损结束时间
	private String numerationStartTime ="";	//厘算开始时间
	private String numerationEndTime ="";	//厘算结束时间
	private String docStartTime ;		     //单证开始时间
	private String docEndTime ;			 //单证结束时间
	private double indemnitydutyRate =0.00;    //赔偿责任比例
	
	public String getAccidentDeath() {
		return AccidentDeath;
	}
	public void setAccidentDeath(String accidentDeath) {
		AccidentDeath = accidentDeath;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public List getEndCaseAppSituationList() {
		return endCaseAppSituationList;
	}
	public void setEndCaseAppSituationList(List endCaseAppSituations) {
		this.endCaseAppSituationList = endCaseAppSituations;
	}
	public void addEndCaseAppSituation(EndCaseAppSituation endCaseAppSituation) {
		this.endCaseAppSituationList.add(endCaseAppSituation);
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public Date getRecaseDate() {
		return recaseDate;
	}
	public void setRecaseDate(Date recaseDate) {
		this.recaseDate = recaseDate;
	}
	public String getRecaseReason() {
		return recaseReason;
	}
	public void setRecaseReason(String recaseReason) {
		this.recaseReason = recaseReason;
	}
	public List getCarLossList() {
		return carLossList;
	}
	public void setCarLossList(List carLossList) {
		this.carLossList = carLossList;
	}
	public List getPersonLossList() {
		return personLossList;
	}
	public void setPersonLossList(List personLossList) {
		this.personLossList = personLossList;
	}
	public List getPropLossList() {
		return propLossList;
	}
	public void setPropLossList(List propLossList) {
		this.propLossList = propLossList;
	}
	
	public String getSurveyType() {
		return surveyType;
	}
	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}
	public String getSurveyName() {
		return surveyName;
	}
	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}
	public String getSurveyPlace() {
		return surveyPlace;
	}
	public void setSurveyPlace(String surveyPlace) {
		this.surveyPlace = surveyPlace;
	}
	public String getSurveyDes() {
		return surveyDes;
	}
	public void setSurveyDes(String surveyDes) {
		this.surveyDes = surveyDes;
	}
	public String getEsimateName() {
		return esimateName;
	}
	public void setEsimateName(String esimateName) {
		this.esimateName = esimateName;
	}
	public String getAssesorName() {
		return assesorName;
	}
	public void setAssesorName(String assesorName) {
		this.assesorName = assesorName;
	}
	public String getSurveyStartTime() {
		return surveyStartTime;
	}
	public void setSurveyStartTime(String surveyStartTime) {
		this.surveyStartTime = surveyStartTime;
	}
	public String getSurveyEndTime() {
		return surveyEndTime;
	}
	public void setSurveyEndTime(String surveyEndTime) {
		this.surveyEndTime = surveyEndTime;
	}
	public String getEsimateStartTime() {
		return esimateStartTime;
	}
	public void setEsimateStartTime(String esimateStartTime) {
		this.esimateStartTime = esimateStartTime;
	}
	public String getEsimateEndTime() {
		return esimateEndTime;
	}
	public void setEsimateEndTime(String esimateEndTime) {
		this.esimateEndTime = esimateEndTime;
	}
	public String getAssesorStartTime() {
		return assesorStartTime;
	}
	public void setAssesorStartTime(String assesorStartTime) {
		this.assesorStartTime = assesorStartTime;
	}
	public String getAssesorEndTime() {
		return assesorEndTime;
	}
	public void setAssesorEndTime(String assesorEndTime) {
		this.assesorEndTime = assesorEndTime;
	}
	public String getNumerationStartTime() {
		return numerationStartTime;
	}
	public void setNumerationStartTime(String numerationStartTime) {
		this.numerationStartTime = numerationStartTime;
	}
	public String getNumerationEndTime() {
		return numerationEndTime;
	}
	public void setNumerationEndTime(String numerationEndTime) {
		this.numerationEndTime = numerationEndTime;
	}
	public String getDocStartTime() {
		return docStartTime;
	}
	public void setDocStartTime(String docStartTime) {
		this.docStartTime = docStartTime;
	}
	public String getDocEndTime() {
		return docEndTime;
	}
	public void setDocEndTime(String docEndTime) {
		this.docEndTime = docEndTime;
	}
	public double getIndemnitydutyRate() {
		return indemnitydutyRate;
	}
	public void setIndemnitydutyRate(double indemnitydutyRate) {
		this.indemnitydutyRate = indemnitydutyRate;
	}
	
	
	
}
