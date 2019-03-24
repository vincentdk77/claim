package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossForSHDto;

/**
 * �⽡�ս᰸������װ
 * @author feigai1
 *
 */
public class CIPropEndcaseRequestInDto {

	private String claimCode="";	      	//�������
	private String policySequenceNo="";	    //��������
	private String isGroup = "";		//�Ƿ��ŵ�
	private double sumPaid = 0;        //����ܽ��
	private String registNo="";		 //������
	private String claimNo="";       //�������
	private String policyNO="";	     //������
	private String endCaseNo="";     //�ⰸ��
	private String isReopen = "";    //�Ƿ��ؿ�
	private int reopenNum = 0;       //�ؿ�����
	private String reopenReason="";  //�ؿ�ԭ��
	
	private String caseType=""; //��������
	private String ClaimDate = ""; //����ʱ��
	private String damageDate  = "";//����ʱ��
	private String damageHour = "";			//����ʱ��
	private String reportDate = ""; //����ʱ��
	private String reportHour="";
	private String endCaseDate = "";//�᰸ʱ��
	private String reportName="" ; //����������
	private String phoneNumber = "";  //�����˵绰
	private String linkerName = "";  //��ϵ������
	private String linkerAddress="" ; //��ϵ�˵�ַ
	private String damagerArrea="" ; //���յص�
	private String damagerText="" ; //���վ���
	private String damageName="" ; //����ԭ��
	private String checkDate = "";//�鿱ʱ��
	private String remoteCheckType="" ; //����������
	private String claimAccount = "";//����ʺ�
	private String claimBank = "";//����˻�������
	private String claimName = "";//����ʺ�������
	
	private String customerSequenceNo = "";//�ͻ�����
	private String acciName=""; //����������
	private String identifyType=""; //������֤������
	private String identifyNumber=""; //������֤������
	private String damageTypeName=""; //���ֽ�����¹����ͣ�
	private String clauseType=""; //������������˹�ϵ
	private String HospitalCode=""; //ҽ�ƻ�������
	private String DiseaseCode=""; //��������

	private ArrayList<PrpLacciPersonDto> acciPersonList=new ArrayList<PrpLacciPersonDto>();   //��Ա��ʧ
	private ArrayList<PrpLpersonLossForSHDto> personLossList=new ArrayList<PrpLpersonLossForSHDto>();   //��Ա��ʧ


	public CIPropEndcaseRequestInDto() {
		
	}


	public String getClaimCode() {
		return claimCode;
	}


	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}


	public String getPolicySequenceNo() {
		return policySequenceNo;
	}


	public void setPolicySequenceNo(String policySequenceNo) {
		this.policySequenceNo = policySequenceNo;
	}


	public String getIsGroup() {
		return isGroup;
	}


	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}


	public double getSumPaid() {
		return sumPaid;
	}


	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}


	public String getRegistNo() {
		return registNo;
	}


	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}


	public String getClaimNo() {
		return claimNo;
	}


	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}


	public String getPolicyNO() {
		return policyNO;
	}


	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}


	public String getEndCaseNo() {
		return endCaseNo;
	}


	public void setEndCaseNo(String endCaseNo) {
		this.endCaseNo = endCaseNo;
	}


	public String getIsReopen() {
		return isReopen;
	}


	public void setIsReopen(String isReopen) {
		this.isReopen = isReopen;
	}


	public int getReopenNum() {
		return reopenNum;
	}


	public void setReopenNum(int reopenNum) {
		this.reopenNum = reopenNum;
	}


	public String getReopenReason() {
		return reopenReason;
	}


	public void setReopenReason(String reopenReason) {
		this.reopenReason = reopenReason;
	}


	public String getCaseType() {
		return caseType;
	}


	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}


	public String getClaimDate() {
		return ClaimDate;
	}


	public void setClaimDate(String claimDate) {
		ClaimDate = claimDate;
	}


	public String getDamageDate() {
		return damageDate;
	}


	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}


	public String getDamageHour() {
		return damageHour;
	}


	public void setDamageHour(String damageHour) {
		this.damageHour = damageHour;
	}


	public String getReportDate() {
		return reportDate;
	}


	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}


	public String getReportHour() {
		return reportHour;
	}


	public void setReportHour(String reportHour) {
		this.reportHour = reportHour;
	}


	public String getEndCaseDate() {
		return endCaseDate;
	}


	public void setEndCaseDate(String endCaseDate) {
		this.endCaseDate = endCaseDate;
	}


	public String getReportName() {
		return reportName;
	}


	public void setReportName(String reportName) {
		this.reportName = reportName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getLinkerName() {
		return linkerName;
	}


	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}


	public String getLinkerAddress() {
		return linkerAddress;
	}


	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = linkerAddress;
	}


	public String getDamagerArrea() {
		return damagerArrea;
	}


	public void setDamagerArrea(String damagerArrea) {
		this.damagerArrea = damagerArrea;
	}


	public String getDamagerText() {
		return damagerText;
	}


	public void setDamagerText(String damagerText) {
		this.damagerText = damagerText;
	}


	public String getDamageName() {
		return damageName;
	}


	public void setDamageName(String damageName) {
		this.damageName = damageName;
	}


	public String getCheckDate() {
		return checkDate;
	}


	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}


	public String getRemoteCheckType() {
		return remoteCheckType;
	}


	public void setRemoteCheckType(String remoteCheckType) {
		this.remoteCheckType = remoteCheckType;
	}


	public String getClaimAccount() {
		return claimAccount;
	}


	public void setClaimAccount(String claimAccount) {
		this.claimAccount = claimAccount;
	}


	public String getClaimBank() {
		return claimBank;
	}


	public void setClaimBank(String claimBank) {
		this.claimBank = claimBank;
	}


	public String getClaimName() {
		return claimName;
	}


	public void setClaimName(String claimName) {
		this.claimName = claimName;
	}


	public String getCustomerSequenceNo() {
		return customerSequenceNo;
	}


	public void setCustomerSequenceNo(String customerSequenceNo) {
		this.customerSequenceNo = customerSequenceNo;
	}


	public String getAcciName() {
		return acciName;
	}


	public void setAcciName(String acciName) {
		this.acciName = acciName;
	}


	public String getIdentifyType() {
		return identifyType;
	}


	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}


	public String getIdentifyNumber() {
		return identifyNumber;
	}


	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}


	public String getDamageTypeName() {
		return damageTypeName;
	}


	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = damageTypeName;
	}


	public String getClauseType() {
		return clauseType;
	}


	public void setClauseType(String clauseType) {
		this.clauseType = clauseType;
	}


	public ArrayList<PrpLacciPersonDto> getAcciPersonList() {
		return acciPersonList;
	}


	public void setAcciPersonList(ArrayList<PrpLacciPersonDto> acciPersonList) {
		this.acciPersonList = acciPersonList;
	}


	public ArrayList<PrpLpersonLossForSHDto> getPersonLossList() {
		return personLossList;
	}


	public void setPersonLossList(ArrayList<PrpLpersonLossForSHDto> personLossList) {
		this.personLossList = personLossList;
	}


	public String getHospitalCode() {
		return HospitalCode;
	}


	public void setHospitalCode(String hospitalCode) {
		HospitalCode = hospitalCode;
	}


	public String getDiseaseCode() {
		return DiseaseCode;
	}


	public void setDiseaseCode(String diseaseCode) {
		DiseaseCode = diseaseCode;
	}

}
