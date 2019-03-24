package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;

public class CarLoss {
	private String licenseNo = "";
	private String licenseType = "";
	private String driverName = "";
	private String driverIdentifyNo = "";
	private double sumLoss;
	private String insureCarFlag = "";
	private String verifyLossRepairFactory = "";
	private String compensateRepairFactory = "";
	private double sumDuty;
	private String indemnityCode = "";
	private double sumManager;
	private double sumRest;
	
	private String lossPart = "";            //��ʧ��λ
	private double totalWorkHour;            //����ܹ�ʱ
	private String changePartName = "";      //�����������
	private String changeOrRepairPart = "";  //�Ƿ��������������
	private double changePartNum;            //�����������
	private double changePartFee;            //����������Ϸѣ����ۣ�
	private double changePartTime;           //���������ʱ
	private double changePartManpowerFee;    //��������˹���
	private String repairPartName = "";      //�����������
	private double repairPartNum;            //�����������
	private double repairPartFee;            //����������Ϸѣ����ۣ�
	private double repairPartTime;           //���������ʱ
	private double repairPartManpowerFee;    //��������˹���
	private String repairMethord = "";       //����ʽ
	private String oemPartCode = "";         //ԭ�������	
	private String defineFlag = "";          //�����־
	private String subjionFlag = "";         //������־
	
	private String esimateName = "";                 //������Ա
	private String assesorName = "";                  //������Ա 
	
	private String esimateStartTime = "" ;		     //����ʼʱ��
	private String esimateEndTime = "";			 //�������ʱ��
	private String assesorStartTime = "" ;		     //����ʼʱ��
	private String assesorEndTime = "";			 //�������ʱ��
	
	ArrayList carLossList = new ArrayList();
	ArrayList carLossDetailList = new ArrayList();
	
	public String getCompensateRepairFactory() {
		return compensateRepairFactory;
	}
	public void setCompensateRepairFactory(String compensateRepairFactory) {
		this.compensateRepairFactory = compensateRepairFactory;
	}
	public String getDriverIdentifyNo() {
		return driverIdentifyNo;
	}
	public void setDriverIdentifyNo(String driverIdentifyNo) {
		this.driverIdentifyNo = driverIdentifyNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getInsureCarFlag() {
		return insureCarFlag;
	}
	public void setInsureCarFlag(String insureCarFlag) {
		this.insureCarFlag = insureCarFlag;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getLicenseType() {
		return licenseType;
	}
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public double getSumLoss() {
		return sumLoss;
	}
	public void setSumLoss(double sumLoss) {
		this.sumLoss = sumLoss;
	}
	public String getVerifyLossRepairFactory() {
		return verifyLossRepairFactory;
	}
	public void setVerifyLossRepairFactory(String verifyLossRepairFactory) {
		this.verifyLossRepairFactory = verifyLossRepairFactory;
	}
	public ArrayList getCarLossList() {
		return carLossList;
	}
	public void setCarLossList(ArrayList carLossList) {
		this.carLossList = carLossList;
	}
	public ArrayList getCarLossDetailList() {
		return carLossDetailList;
	}
	public void setCarLossDetailList(ArrayList carLossDetailList) {
		this.carLossDetailList = carLossDetailList;
	}
	public double getSumDuty() {
		return sumDuty;
	}
	public void setSumDuty(double sumDuty) {
		this.sumDuty = sumDuty;
	}
	public void setIndemnityCode(String indemnityCode) {
		this.indemnityCode = indemnityCode;
	}
	public String getIndemnityCode() {
		return indemnityCode;
	}
	public double getSumManager() {
		return sumManager;
	}
	public void setSumManager(double sumManager) {
		this.sumManager = sumManager;
	}
	public double getSumRest() {
		return sumRest;
	}
	public void setSumRest(double sumRest) {
		this.sumRest = sumRest;
	}
	public double getTotalWorkHour() {
		return totalWorkHour;
	}
	public void setTotalWorkHour(double totalWorkHour) {
		this.totalWorkHour = totalWorkHour;
	}
	public String getChangePartName() {
		return changePartName;
	}
	public void setChangePartName(String changePartName) {
		this.changePartName = changePartName;
	}
	public String getChangeOrRepairPart() {
		return changeOrRepairPart;
	}
	public void setChangeOrRepairPart(String changeOrRepairPart) {
		this.changeOrRepairPart = changeOrRepairPart;
	}
	public double getChangePartNum() {
		return changePartNum;
	}
	public void setChangePartNum(double changePartNum) {
		this.changePartNum = changePartNum;
	}
	public double getChangePartFee() {
		return changePartFee;
	}
	public void setChangePartFee(double changePartFee) {
		this.changePartFee = changePartFee;
	}
	public double getChangePartTime() {
		return changePartTime;
	}
	public void setChangePartTime(double changePartTime) {
		this.changePartTime = changePartTime;
	}
	public double getChangePartManpowerFee() {
		return changePartManpowerFee;
	}
	public void setChangePartManpowerFee(double changePartManpowerFee) {
		this.changePartManpowerFee = changePartManpowerFee;
	}
	public double getRepairPartNum() {
		return repairPartNum;
	}
	public void setRepairPartNum(double repairPartNum) {
		this.repairPartNum = repairPartNum;
	}
	public double getRepairPartFee() {
		return repairPartFee;
	}
	public void setRepairPartFee(double repairPartFee) {
		this.repairPartFee = repairPartFee;
	}
	public double getRepairPartTime() {
		return repairPartTime;
	}
	public void setRepairPartTime(double repairPartTime) {
		this.repairPartTime = repairPartTime;
	}
	public double getRepairPartManpowerFee() {
		return repairPartManpowerFee;
	}
	public void setRepairPartManpowerFee(double repairPartManpowerFee) {
		this.repairPartManpowerFee = repairPartManpowerFee;
	}
	public String getRepairPartName() {
		return repairPartName;
	}
	public void setRepairPartName(String repairPartName) {
		this.repairPartName = repairPartName;
	}
	public String getRepairMethord() {
		return repairMethord;
	}
	public void setRepairMethord(String repairMethord) {
		this.repairMethord = repairMethord;
	}
	public String getOemPartCode() {
		return oemPartCode;
	}
	public void setOemPartCode(String oemPartCode) {
		this.oemPartCode = oemPartCode;
	}
	public String getDefineFlag() {
		return defineFlag;
	}
	public void setDefineFlag(String defineFlag) {
		this.defineFlag = defineFlag;
	}
	public String getSubjionFlag() {
		return subjionFlag;
	}
	public void setSubjionFlag(String subjionFlag) {
		this.subjionFlag = subjionFlag;
	}
	public String getLossPart() {
		return lossPart;
	}
	public void setLossPart(String lossPart) {
		this.lossPart = lossPart;
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
