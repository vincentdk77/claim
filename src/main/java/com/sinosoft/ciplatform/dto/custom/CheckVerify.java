package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckVerify {
	private String claimCode = "";	      	//�������
	private String serialNo = "";			//׷�Ӵ���
	private String policyNO ="";			//������
	private String registNo = "";			//������
	private String claimNo = "";			//������
	private String caseNo = "";			    //������
	private String confirmSequenceNo = "";  //Ͷ��ȷ����
	private List endCaseAppSituationList=new ArrayList();//׷���⳥���
	private double claimAmount = 0;         //�����
	private double sumCertainLoss = 0;      //�ܶ�����
	private String comCode ="";			    //��������
	private Date recaseDate;		        //�ؿ�����
	private String recaseReason = "";	    //��������
	private String manageType = "";	        //�¹�����
	private String indemnityDuty = "";      //��������
	private String licenseNo = "";          //���ճб��������ƺ��� 
	private String licenseKindCode = "";    //���ճб�������������
	private String AccidentDeath = "";	    //׷���ڼ��Ƿ��������ν�ͨ�����¹�	
	private List carLossList = new ArrayList();  //��ҵ�ճ�����ʧ���
	private List personLossList = new ArrayList();  //��ҵ��������ʧ���
	private List propLossList = new ArrayList();  //��ҵ�ղƲ���ʧ���
	
	private String surveyType = "";			 //�ֳ����
	private String surveyName = "";			 //�鿱��Ա����
	private String surveyStartTime ;		     //�鿱��ʼʱ��
	private String surveyEndTime ;			 //�鿱����ʱ��
	private String surveyPlace = "";		 //�鿱�ص�
	private String surveyDes = "";			 //�鿱���˵��
	private String esimateName = "";		 //������Ա����
	private String esimateStartTime ;		     //����ʼʱ��
	private String esimateEndTime ;			 //�������ʱ��
	private String assesorName = "";		 //������Ա����
	private String assesorStartTime ;		     //����ʼʱ��
	private String assesorEndTime ;			 //�������ʱ��
	
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
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
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
	public double getSumCertainLoss() {
		return sumCertainLoss;
	}
	public void setSumCertainLoss(double sumCertainLoss) {
		this.sumCertainLoss = sumCertainLoss;
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
	public String getManageType() {
		return manageType;
	}
	public void setManageType(String manageType) {
		this.manageType = manageType;
	}
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseKindCode() {
		return licenseKindCode;
	}
	public void setLicenseKindCode(String licenseKindCode) {
		this.licenseKindCode = licenseKindCode;
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
}
