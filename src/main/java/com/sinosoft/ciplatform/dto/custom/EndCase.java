package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinosoft.prpall.pubfun.ComCodeTools;

public class EndCase {
	private String confirmSequenceNo=""; 	//Ͷ��ȷ����
	private String claimCode="";	      	//�������
	private double sumPaid=0;        //����ܽ��(��������)
	private double sumLoss=0;        //��ʧ�ܽ��
	private double sumDutyPaid=0;        //����ܽ��(����������)
	private double sumNoDutyPaid=0;		//���������
	private int personNum=0;      //��������
	private double otherAmount=0;    //��������
	private String registNo="";			//������
	private String claimNo="";   //�������
	private String endCaseNo="";   //�᰸��
	private Date registTime; //����ʱ��
	private Date claimTime; //����ʱ��
	private Date endCaseTime;  //�᰸ʱ��
	private boolean isInsuredDuty = true;			//�Ƿ����ڱ�������
	private String caseType=""; //��������
	private String prepayreason="";				  //�渶ԭ��
	private String refusereason="";	//����ԭ��
	private String  licenseNo="";					//���ֳ������ƺ���
	private String licenseType="";   //���ճ�����������
	private String driverName="";		//���ռ�ʻԱ
	private String driverSex="";		//���ռ�ʻԱ�Ա�
	private String driverArea="";		//���ռ�ʻԱ����
	private String archivesNo="";		//���ռ�ʻԱ�������
	private String certiType="";  //���ռ�ʻԱ֤������
	private String certiCode=""; //���ռ�ʻԱ֤������
	private String reportorName = "";       //������
	private String policyNo=""; //��������
	private Date damageDate;			//����ʱ�� 
	private Date startDate;
	private Date endDate;
	private AccidentInfor accidentInfor; //�¹���Ϣ
	private List thirdCarList=new ArrayList();   //���������ƺ�
	private List lossSituationList=new ArrayList(); //��ʧ�⳥���
	private List lossSituationDetailList = new ArrayList();  
	private String handleUnit = ""; //�¹ʴ�����
	private String manageType = ""; //�¹ʴ�������
	private String damageTypeCode = ""; //�¹�ԭ��
	private String damageAddress ="";//���յص�
	private String dirverSex = "";//���ռ�ʻԱ���Ա�
	private String dirverAddress = "";//���ռ�ʻԱ�Ĺ�����
	private String comCode = "";//���ӵĹ�������
	private List carLossList = new ArrayList();  //��ҵ�ճ�����ʧ���
	private List personLossList = new ArrayList();  //��ҵ��������ʧ���
	private List propLossList = new ArrayList();  //��ҵ�ղƲ���ʧ���
	private String personDeath = "";//��Ա����
	//sunmingtao �㽭��ҵ��
	private double carSumLoss=0;    //������ʧ���
	private double carSumPaid=0;    //���������
	private double propSumLoss=0;    //�Ʋ���ʧ���
	private double propSumPaid=0;    //�Ʋ������
	private double personSumLoss=0;    //��Ա��ʧ���
	private double personSumPaid=0;    //��Ա�����
	private double chargePaid=0;    //��Ա�����
	private List prplchargeList = new ArrayList();  //��ҵ�ղƲ���ʧ���
	private String damageCode="";// ����ԭ��
	private String optionType="";// �㽭��ҵ�¹ʴ�������
//	sunmingtao �㽭��ҵ��
	private String rackNo = "";//���ճ������ܺ�
	private String agentNo = "";//����Ա����
	private String agentName = "";//����Ա����
	private Date setLossTime ;//����ʱ��
	private String claimType = "";//��������
	private	double chargeSumLoss=0;  //�ܷ�����ʧ���
	private double chargeSumPaid=0;  //�ܷ��������
	
	 /** �����Ƿ������˱�� */
    private String injuryFlag = "";
    
    /** �����Ƿ��е������ */
    private String brigandageFlag = "";
    
    /** �����Ƿ��·��ͨ�¹ʱ�� */
    private String roadFlag = "";
    
    /** �����Ƿ��н����¹����� */
    private String acciLetterFlag = "";
    
    /** �����¹����� */
    private String acciLetterNo = "";
    
    /** �Ƿ������� */
    private String paySelfFlag = "";
	
    /** �Ƿ�����渶 */
    private String irresponsibilityPayment = "";
    
    //add by liuxin 20080516 start for ������ǿ����Ϣ��ӿڵ���
    /**  �������Ƿ�Ϊ���������� */
	private String thirdVehicleFlag = ""; //0�� 1��
	private List thirdPersonList = new ArrayList();//��������Ա��Ϣ
	//add by liuxin 20080516 end for ������ǿ����Ϣ��ӿڵ���
	
	public AccidentInfor getAccidentInfor() {
		return accidentInfor;
	}
	public void setAccidentInfor(AccidentInfor accidentInfor) {
		this.accidentInfor = accidentInfor;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getCertiCode() {
		return certiCode;
	}
	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getEndCaseNo() {
		return endCaseNo;
	}
	public void setEndCaseNo(String endCaseNo) {
		this.endCaseNo = endCaseNo;
	}
	public Date getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(Date claimTime) {
		this.claimTime = claimTime;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public Date getEndCaseTime() {
		return endCaseTime;
	}
	public void setEndCaseTime(Date endCaseTime) {
		this.endCaseTime = endCaseTime;
	}
	public boolean isInsuredDuty() {
		return isInsuredDuty;
	}
	public void setInsuredDuty(boolean isInsuredDuty) {
		this.isInsuredDuty = isInsuredDuty;
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

	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getPrepayreason() {
		return prepayreason;
	}
	public void setPrepayreason(String prepayreason) {
		this.prepayreason = prepayreason;
	}
	public String getRefusereason() {
		return refusereason;
	}
	public void setRefusereason(String refusereason) {
		this.refusereason = refusereason;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public Date getRegistTime() {
		return registTime;
	}
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	public List getThirdCarList() {
		return thirdCarList;
	}
	public void addThirdCar(ThirdCar thirdCar) {
		thirdCarList.add(thirdCar);
	}
	public Date getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	public List getLossSituationList() {
		return lossSituationList;
	}
	public void setLossSituationList(List lossSituationList) {
		this.lossSituationList = lossSituationList;
	}
	public void addLossSituation(LossSituation lossSituation) {
		lossSituationList.add(lossSituation);
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getDirverAddress() {
		return dirverAddress;
	}
	public void setDirverAddress(String dirverAddress) {
		this.dirverAddress = dirverAddress;
	}
	public String getDirverSex() {
		return dirverSex;
	}
	public void setDirverSex(String dirverSex) {
		this.dirverSex = dirverSex;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getManageType() {
		return manageType;
	}
	public void setManageType(String manageType) {
		this.manageType = manageType;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getpersonDeath() {
		return personDeath;
	}
	public void setPersonDeath(String personDeath) {
		this.personDeath = personDeath;
	}
	  
	public List getCarLossList() {
		return carLossList;
	}
	public void setCarLossList(List carLossList) {
		this.carLossList = carLossList;
	}
	public String getDriverArea() {
		return driverArea;
	}
	public void setDriverArea(String driverArea) {
		this.driverArea = driverArea;
	}
	public String getDriverSex() {
		return driverSex;
	}
	public void setDriverSex(String driverSex) {
		this.driverSex = driverSex;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List getLossSituationDetailList() {
		return lossSituationDetailList;
	}
	public void setLossSituationDetailList(List lossSituationDetailList) {
		this.lossSituationDetailList = lossSituationDetailList;
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
	public String getReportorName() {
		return reportorName;
	}
	public void setReportorName(String reportorName) {
		this.reportorName = reportorName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public double getSumLoss() {
		return sumLoss;
	}
	public void setSumLoss(double sumLoss) {
		this.sumLoss = sumLoss;
	}
	public double getSumDutyPaid() {
		return sumDutyPaid;
	}
	public void setSumDutyPaid(double sumDutyPaid) {
		this.sumDutyPaid = sumDutyPaid;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public double getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	/**
     * ����ί���ⰸ���
     * @param entrustFlag �����õ�ί���ⰸ���
     */
    public void setInjuryFlag(String injuryFlag){
    	this.injuryFlag = injuryFlag;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getInjuryFlag(){
    	return this.injuryFlag;
    }
    
    /**
     * ����ί���ⰸ���
     * @param entrustFlag �����õ�ί���ⰸ���
     */
    public void setBrigandageFlag(String brigandageFlag){
    	this.brigandageFlag = brigandageFlag;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getBrigandageFlag(){
    	return this.brigandageFlag;
    }
    
    /**
     * ����ί���ⰸ���
     * @param entrustFlag �����õ�ί���ⰸ���
     */
    public void setRoadFlag(String roadFlag){
    	this.roadFlag = roadFlag;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getRoadFlag(){
    	return this.roadFlag;
    }
    
    /**
     * ����ί���ⰸ���
     * @param entrustFlag �����õ�ί���ⰸ���
     */
    public void setAcciLetterFlag(String acciLetterFlag){
    	this.acciLetterFlag = acciLetterFlag;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getAcciLetterFlag(){
    	return this.acciLetterFlag;
    }
    
    /**
     * ����ί���ⰸ���
     * @param acciLetterNo �����õ�ί���ⰸ���
     */
    public void setAcciLetterNo(String acciLetterNo){
    	this.acciLetterNo = acciLetterNo;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getAcciLetterNo(){
    	return this.acciLetterNo;
    }
    
    /**
     * ���û��������־
     * @param paySelfFlag �����õĻ��������־
     */
    public void setPaySelfFlag(String paySelfFlag){
    	this.paySelfFlag = paySelfFlag;
    }
    
    /**
     * ��ȡ���������־
     * @return ���������־
     */
    public String getPaySelfFlag(){
    	return this.paySelfFlag;
    }
    /**
     * ����ί���ⰸ���
     * @param entrustFlag �����õ�ί���ⰸ���
     */
    public void setIrresponsibilityPayment(String irresponsibilityPayment){
    	this.irresponsibilityPayment = irresponsibilityPayment;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getIrresponsibilityPayment(){
    	return this.irresponsibilityPayment;
    }
    
    //add by liuxin 20080516 start for ������ǿ����Ϣ��ӿڵ���
	public String getThirdVehicleFlag() {
		return thirdVehicleFlag;
	}
	public void setThirdVehicleFlag(String thirdVehicleFlag) {
		this.thirdVehicleFlag = thirdVehicleFlag;
	}
	
	public List getThirdPersonList() {
		return thirdPersonList;
	}
	public void setThirdPersonList(List thirdPersonList) {
		this.thirdPersonList = thirdPersonList;
	}
	//add by liuxin 20080516 end for ������ǿ����Ϣ��ӿڵ���
	public double getCarSumLoss() {
		return carSumLoss;
	}
	public void setCarSumLoss(double carSumLoss) {
		this.carSumLoss = carSumLoss;
	}	
	public double getCarSumPaid() {
		return carSumPaid;
	}
	public void setCarSumPaid(double carSumPaid) {
		this.carSumPaid = carSumPaid;
	}	
	public double getPropSumLoss() {
		return propSumLoss;
	}
	public void setPropSumLoss(double propSumLoss) {
		this.propSumLoss = propSumLoss;
	}	
	public double getPropSumPaid() {
		return propSumPaid;
	}
	public void setPropSumPaid(double propSumPaid) {
		this.propSumPaid = propSumPaid;
	}	
	public double getPersonSumLoss() {
		return personSumLoss;
	}
	public void setPersonSumLoss(double personSumLoss) {
		this.personSumLoss = personSumLoss;
	}	
	public double getPersonSumPaid() {
		return personSumPaid;
	}
	public void setPersonSumPaid(double personSumPaid) {
		this.personSumPaid = personSumPaid;
	}
	public List getPrplchargeList() {
		return prplchargeList;
	}
	public void setPrplchargeList(List prplchargeList) {
		this.prplchargeList = prplchargeList;
	}
	public double getChargePaid() {
		return chargePaid;
	}
	public void setChargePaid(double chargePaid) {
		this.chargePaid = chargePaid;
	}
	public String getDamageCode() {
		return damageCode;
	}
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Date getSetLossTime() {
		return setLossTime;
	}
	public void setSetLossTime(Date setLossTime) {
		this.setLossTime = setLossTime;
	}

	public double getSumNoDutyPaid() {
		return sumNoDutyPaid;
	}
	public void setSumNoDutyPaid(double sumNoDutyPaid) {
		this.sumNoDutyPaid = sumNoDutyPaid;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	/**
	 * @return the chargeSumLoss
	 */
	public double getChargeSumLoss() {
		return chargeSumLoss;
	}
	/**
	 * @param chargeSumLoss the chargeSumLoss to set
	 */
	public void setChargeSumLoss(double chargeSumLoss) {
		this.chargeSumLoss = chargeSumLoss;
	}
	/**
	 * @return the chargeSumPaid
	 */
	public double getChargeSumPaid() {
		return chargeSumPaid;
	}
	/**
	 * @param chargeSumPaid the chargeSumPaid to set
	 */
	public void setChargeSumPaid(double chargeSumPaid) {
		this.chargeSumPaid = chargeSumPaid;
	}
}
