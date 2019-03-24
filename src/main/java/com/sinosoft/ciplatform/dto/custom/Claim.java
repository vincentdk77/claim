package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Claim {
	private String confirmSequenceNo=""; 	//Ͷ��ȷ����
	private String claimCode="";	      	//�������
	private double unClaimAmount=0;//������
	private String claimNo="";		//������
	private String registNo="";		//������
	private String policyNO="";		//������
	private String caseType="";		//�����ⰸ����
	private String licenseNo="";	//���ճ��ƺ���
	private String licenseType="";	//���ճ�������
	private Date damageDate;		//����ʱ�� 
	private List thirdCarList = new ArrayList();//���߳���Ϣ
	private List carLossList = new ArrayList();  //������Ϣ
	private List propLossList = new ArrayList(); //������Ϣ
	private List personLossList = new ArrayList();//������Ϣ
	private String handleUnit = ""; //�¹ʴ�������
	private String damageTypeCode = ""; //�¹�ԭ��
	private String comCode = "";//���ӵĹ�������
	private Date claimDate;       //����ʱ��
	private Date startDate;              //��������
	private Date endDate;                 //����ֹ��
	private String damageText = "";     //���վ���
	private String reportorName = "";   //������
	private String indemnityDuty="";   //�¹�����
	private String rackNo="";   //���ճ������ܺ�
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
    
    /** �����¹����� */
    private String firstInvestigateTime = "";
    /** ���������־ */
    private String paySelfFlag = "";
    /** ���������־ */
    private String damageAddress = "";
    //add by liuxin 20080516 start for ������ǿ����Ϣ��ӿڵ���
    /**���Ե������Ƿ�Ϊ������*/
    private String  thirdVehicleFlag = "";  //1��  0��
    
    private List thirdPersonList = new ArrayList();//��������Ա��Ϣ
    //add by liuxin 20080516 end for ������ǿ����Ϣ��ӿڵ���
    
    private String manageTypeCode = "";//�¹ʴ�������

	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public String getDamageText() {
		return damageText;
	}
	public void setDamageText(String damageText) {
		this.damageText = damageText;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
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
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public Date getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
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
	public double getUnClaimAmount() {
		return unClaimAmount;
	}
	public void setUnClaimAmount(double unClaimAmount) {
		this.unClaimAmount = unClaimAmount;
	}

	public List getThirdCarList() {
		return thirdCarList;
	}
	public void setThirdCarList(List thirdCarList) {
		this.thirdCarList = thirdCarList;
	}
	public List getCarLossList() {
		return carLossList;
	}
	public void setCarLossList(List carLossList) {
		this.carLossList = carLossList;
	}
	public List getPropLossList() {
		return propLossList;
	}
	public void setPropLossList(List propLossList) {
		this.propLossList = propLossList;
	}
	public List getPersonLossList() {
		return personLossList;
	}
	public void setPersonLossList(List personLossList) {
		this.personLossList = personLossList;
	}
	public String getManageTypeCode() {
		return manageTypeCode;
	}
	public void setManageTypeCode(String manageTypeCode) {
		this.manageTypeCode = manageTypeCode;
	}
	/**
	 * �������߳���Ϣ
	 * @param thirdCar
	 */
	public void addThirdCar(ThirdCar thirdCar){
		this.thirdCarList.add(thirdCar);
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
     * @param entrustFlag �����õ�ί���ⰸ���
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
     * ����ί���ⰸ���
     * @param entrustFlag �����õ�ί���ⰸ���
     */
    public void setFirstInvestigateTime(String firstInvestigateTime){
    	this.firstInvestigateTime = firstInvestigateTime;
    }
    
    /**
     * ��ȡί���ⰸ���
     * @return ί���ⰸ���
     */
    public String getFirstInvestigateTime(){
    	return this.firstInvestigateTime;
    }
    
    /**
     * ���û��������־
     * @param entrustFlag �����õĻ��������־
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
     * �����¹ʵص�
     * @param damageAddress �����õ��¹ʵص�
     */
    public void setDamageAddress(String damageAddress){
    	this.damageAddress = damageAddress;
    }
    
    /**
     * ��ȡ�¹ʵص�
     * @return �¹ʵص�
     */
    public String getDamageAddress(){
    	return this.damageAddress;
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
    /**
     * ���ð�������
     * @param indemnityDuty �����õİ������α�־
     */
    public void setIndemnityDuty(String indemnityDuty){
    	this.indemnityDuty = indemnityDuty;
    }
    
    /**
     * ��ȡ�������α�־
     * @return �������α�־
     */
    public String getIndemnityDuty(){
    	return this.indemnityDuty;
    }
	public String getRackNo() {
		return rackNo;
	}
	public void setRackNo(String rackNo) {
		this.rackNo = rackNo;
	}
}
