package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compensate {
	private String confirmSequenceNo=""; 	//Ͷ��ȷ����
	private String claimCode="";	      	//�������
	private String compensateNo="";		    //�������
	private String claimNo="";		        //������
	private String registNo="";		        //������
	private String policyNo="";		        //������
	private String caseType="";				//�����ⰸ����	
	private String licenseNo="";			//���ճ��ƺ���
	private String licenseType="";			//���ճ�������
	private Date damageDate;				//����ʱ�� 
	private Date compensateDate;		    //����ʱ�� 
	private Date startDate;                 //��������
	private Date endDate;                   //����ֹ��
	private double sumPaid=0;			    //������
	private double claimCost=0;				//����
	private String comCode = "";			//���ӵĹ�������
	private String times = "";				//��������
	private Date payDate;					//֧������
	private String agentNo="";				//����Ա����
	private String agentName="";			//����Ա����
	private Date setLossTime; 				//����ʱ��
	
	private String numerationStartTime ="";	//���㿪ʼʱ��
	private String numerationEndTime ="";	//�������ʱ��
	private String assesorStartTime ="";	//���⿪ʼʱ��
	private String assesorEndTime ="";		//�������ʱ��
	private String assesorDes ="";			//�������
	private double otherAmount =0; 		    //�ܺ������
	private double assesorAmount=0; 		//�ܺ�����
	private String driverName ="";			//���ռ�ʻԱ����
	private String certiType ="";			//���ռ�ʻԱ֤������
	private String certiCode="";			//���ռ�ʻԱ֤����
	private String archivesNo="";			//���ռ�ʻԱ�������
	private String accidentPlace ="";		//���յص�
	private String proportionaClaim ="";	//�Ƿ�����⸶
	private String accidentPlaceMark ="";	//���յص�Ψһ��ʶ
	private List lossSituationList=new ArrayList(); //��ʧ�⳥���
	
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
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
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
	public Date getCompensateDate() {
		return compensateDate;
	}
	public void setCompensateDate(Date compensateDate) {
		this.compensateDate = compensateDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public double getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	public double getClaimCost() {
		return claimCost;
	}
	public void setClaimCost(double claimCost) {
		this.claimCost = claimCost;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
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
	public String getAssesorDes() {
		return assesorDes;
	}
	public void setAssesorDes(String assesorDes) {
		this.assesorDes = assesorDes;
	}
	public double getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(double otherAmount) {
		this.otherAmount = otherAmount;
	}
	public double getAssesorAmount() {
		return assesorAmount;
	}
	public void setAssesorAmount(double assesorAmount) {
		this.assesorAmount = assesorAmount;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getCertiCode() {
		return certiCode;
	}
	public void setCertiCode(String certiCode) {
		this.certiCode = certiCode;
	}
	public String getArchivesNo() {
		return archivesNo;
	}
	public void setArchivesNo(String archivesNo) {
		this.archivesNo = archivesNo;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public String getProportionaClaim() {
		return proportionaClaim;
	}
	public void setProportionaClaim(String proportionaClaim) {
		this.proportionaClaim = proportionaClaim;
	}
	public String getAccidentPlaceMark() {
		return accidentPlaceMark;
	}
	public void setAccidentPlaceMark(String accidentPlaceMark) {
		this.accidentPlaceMark = accidentPlaceMark;
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
}
