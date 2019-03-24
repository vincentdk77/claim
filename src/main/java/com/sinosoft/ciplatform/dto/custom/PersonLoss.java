package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;

public class PersonLoss {
	private String personName = "";
	//add by liuxin 20080516 start for ������ǿ����Ϣ��ӿڵ���
	private String identifyNumber = "";
	//add by liuxin 20080516 end for ������ǿ����Ϣ��ӿڵ���
	private String age = "";
	private double sumLoss;
	private double sumDuty;
	private String indemnityCode = "";//�⸶��ϸ
	
	private int personNo = 0;          //��Ա���
	private String feeType = "";       //��������
	private String injuryType = "";    //�������
	private String injuryLevel = "";   //�˲г̶�
	private String injuryPart = "";    //���˲�λ
	private String hospital = "";      //���ƻ�������

	private String esimateName = "";     //������Ա
	private String assesorName = "";     //������Ա
	
	private String esimateStartTime = "" ;		     //����ʼʱ��
	private String esimateEndTime = "";			 //�������ʱ��
	private String assesorStartTime = "" ;		     //����ʼʱ��
	private String assesorEndTime = "";			 //�������ʱ��
	
	ArrayList personLossDetailList = new ArrayList();
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public double getSumLoss() {
		return sumLoss;
	}
	public void setSumLoss(double sumLoss) {
		this.sumLoss = sumLoss;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public double getSumDuty() {
		return sumDuty;
	}
	public void setSumDuty(double sumDuty) {
		this.sumDuty = sumDuty;
	}
	public String getIndemnityCode() {
		return indemnityCode;
	}
	public void setIndemnityCode(String indemnityCode) {
		this.indemnityCode = indemnityCode;
	}
	public int getPersonNo() {
		return personNo;
	}
	public void setPersonNoe(int personNo) {
		this.personNo = personNo;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getInjuryType() {
		return injuryType;
	}
	public void setInjuryType(String injuryType) {
		this.injuryType = injuryType;
	}
	public String getInjuryLevel() {
		return injuryLevel;
	}
	public void setInjuryLevel(String injuryLevel) {
		this.injuryLevel = injuryLevel;
	}
	public String getInjuryPart() {
		return injuryPart;
	}
	public void setInjuryPart(String injuryPart) {
		this.injuryPart = injuryPart;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public ArrayList getPersonLossDetailList() {
		return personLossDetailList;
	}
	public void setPersonLossDetailList(ArrayList personLossDetailList) {
		this.personLossDetailList = personLossDetailList;
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
