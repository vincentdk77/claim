package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * �⽡�ձ����������������װ
 * @author feigai1
 *
 */
public class CIPropRegistRequestInDto {
//  ��/���ձ�־
	private String isGroup = "";
//	�ⰸ��	CLAIM_NO
	private String claimNo = "";
//	�ͻ�����	CUSTOMER_SEQUENCE_NO
	private String customerSequenceNo = "";
//	��������	ACCIDENT_DATE
	private String accidentDate = "";
//	�Ƿ����	SURVEY_OR_NOT
	private String 	surveyOrNot = "";
//	�᰸����	CLOSE_DATE
	private String 	closeDate = "";
//	����״̬	CLAIM_STATUS
	private String claimStatus = "";
//	�Ƿ��ؿ�	IS_REOPEN
	private String isReopen = "";
//	�ؿ�����	REOPEN_NUM
	private String reopenNum = "";
//	�ؿ�ԭ��	REOPEN_REASON
	private String reopenReason = "";
//	��������	REPORT_DATE
	private String reportDate = "";
//	������	REPORT_NO
	private String reportNo = "";
//	��������	REGISTRATION_DATE
	private String registrationDate = "";
//	������	REGISTRATION_NO
	private String registrationNo = "";
//	����ԭ��	ACCIDENT_REASON
	private String accidentReason = "";
//	���յص�	ACCIDENT_PLACE
	private String accidentPlace = "";
//	����������	REPORT_NAME
	private String reportName = "";
//	�Ա�	REPORT_GENDER
	private String reportGender = "";
//	��������	REPORT_BIRTHDAY
	private String reportBirthday = "";
//	֤�����	REPORT_CERTTYPE
	private String reportCertType = "";
//	֤������	REPORT_CERTNO
	private String reportCertNo = "";
//	��ϵ�绰	REPORT_PHONE
	private String reportPhone = "";
//	������ϵ��ַ	REPORT_ADDR
	private String reportAddr = "";
//	����������	ACC_NAME
	private String accName = "";
//	֤�����	ACC_CERTTYPE
	private String accCertType = "";
//	֤������	ACC_CERTNO
	private String accCertNo = "";
//	���ս��	ACC_RESULT
	private String accResult = "";
//	���ս��ʱ��	ACC_RESULT_DATE
	private String accResultDate = "";
//	ҵ������״̬	STATUS
	private String status = "";
//	������鿪ʼ����	INVESTIGATION_START_DATE
	private String investigationStartDate = "";
//	��������������	INVESTIGATION_END_DATE
	private String investigationEndDate = "";
//	�����������ʶ	REMOTE_CLAIM_INVESTIGATION
	private String remoteClaimInvestigation = "";
//	������������˹�ϵ	RELATIONSHIP
	private String relationship = "";
//	ҽ����ʶ	MEDICAL_CARE_LABLE
	private String medicalCareLable = "";
//	�籣����	SOCIAL_NUMBER
	private String socialNumber = "";
//	�⸶�ܽ��	ALL_CLAIM_AMOUNT
	private String allClaimAmount = "";
//	������
	private String policyNo = "";
//	�����б� �������ⰸ��Ϣ 
	private ArrayList<CIPropClaimPolicyInfoDto> ciPropClaimPolicyList = new ArrayList<CIPropClaimPolicyInfoDto>();
//	������������
//	�������
	private String policySequenceNo = "";
//	���������б�  �������ⰸ��Ϣ
	private ArrayList<CIPropClaimInsuredInfoDto> ciPropClaimInsuredList = new ArrayList<CIPropClaimInsuredInfoDto>(); 

	public CIPropRegistRequestInDto() {
	
	}
	
	public String getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getCustomerSequenceNo() {
		return customerSequenceNo;
	}

	public void setCustomerSequenceNo(String customerSequenceNo) {
		this.customerSequenceNo = customerSequenceNo;
	}

	public String getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(String accidentDate) {
		this.accidentDate = accidentDate;
	}

	public String getSurveyOrNot() {
		return surveyOrNot;
	}

	public void setSurveyOrNot(String surveyOrNot) {
		this.surveyOrNot = surveyOrNot;
	}

	public String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public String getIsReopen() {
		return isReopen;
	}

	public void setIsReopen(String isReopen) {
		this.isReopen = isReopen;
	}

	public String getReopenNum() {
		return reopenNum;
	}

	public void setReopenNum(String reopenNum) {
		this.reopenNum = reopenNum;
	}

	public String getReopenReason() {
		return reopenReason;
	}

	public void setReopenReason(String reopenReason) {
		this.reopenReason = reopenReason;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getAccidentReason() {
		return accidentReason;
	}

	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}

	public String getAccidentPlace() {
		return accidentPlace;
	}

	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportGender() {
		return reportGender;
	}

	public void setReportGender(String reportGender) {
		this.reportGender = reportGender;
	}

	public String getReportBirthday() {
		return reportBirthday;
	}

	public void setReportBirthday(String reportBirthday) {
		this.reportBirthday = reportBirthday;
	}

	public String getReportCertType() {
		return reportCertType;
	}

	public void setReportCertType(String reportCertType) {
		this.reportCertType = reportCertType;
	}

	public String getReportCertNo() {
		return reportCertNo;
	}

	public void setReportCertNo(String reportCertNo) {
		this.reportCertNo = reportCertNo;
	}

	public String getReportPhone() {
		return reportPhone;
	}

	public void setReportPhone(String reportPhone) {
		this.reportPhone = reportPhone;
	}

	public String getReportAddr() {
		return reportAddr;
	}

	public void setReportAddr(String reportAddr) {
		this.reportAddr = reportAddr;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccCertType() {
		return accCertType;
	}

	public void setAccCertType(String accCertType) {
		this.accCertType = accCertType;
	}

	public String getAccCertNo() {
		return accCertNo;
	}

	public void setAccCertNo(String accCertNo) {
		this.accCertNo = accCertNo;
	}

	public String getAccResult() {
		return accResult;
	}

	public void setAccResult(String accResult) {
		this.accResult = accResult;
	}

	public String getAccResultDate() {
		return accResultDate;
	}

	public void setAccResultDate(String accResultDate) {
		this.accResultDate = accResultDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInvestigationStartDate() {
		return investigationStartDate;
	}

	public void setInvestigationStartDate(String investigationStartDate) {
		this.investigationStartDate = investigationStartDate;
	}

	public String getInvestigationEndDate() {
		return investigationEndDate;
	}

	public void setInvestigationEndDate(String investigationEndDate) {
		this.investigationEndDate = investigationEndDate;
	}

	public String getRemoteClaimInvestigation() {
		return remoteClaimInvestigation;
	}

	public void setRemoteClaimInvestigation(String remoteClaimInvestigation) {
		this.remoteClaimInvestigation = remoteClaimInvestigation;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getMedicalCareLable() {
		return medicalCareLable;
	}

	public void setMedicalCareLable(String medicalCareLable) {
		this.medicalCareLable = medicalCareLable;
	}

	public String getSocialNumber() {
		return socialNumber;
	}

	public void setSocialNumber(String socialNumber) {
		this.socialNumber = socialNumber;
	}

	public String getAllClaimAmount() {
		return allClaimAmount;
	}

	public void setAllClaimAmount(String allClaimAmount) {
		this.allClaimAmount = allClaimAmount;
	}

	public ArrayList<CIPropClaimPolicyInfoDto> getCiPropClaimPolicyList() {
		return ciPropClaimPolicyList;
	}

	public void setCiPropClaimPolicyList(
			ArrayList<CIPropClaimPolicyInfoDto> ciPropClaimPolicyList) {
		this.ciPropClaimPolicyList = ciPropClaimPolicyList;
	}

	public String getPolicySequenceNo() {
		return policySequenceNo;
	}

	public void setPolicySequenceNo(String policySequenceNo) {
		this.policySequenceNo = policySequenceNo;
	}

	public ArrayList<CIPropClaimInsuredInfoDto> getCiPropClaimInsuredList() {
		return ciPropClaimInsuredList;
	}

	public void setCiPropClaimInsuredList(
			ArrayList<CIPropClaimInsuredInfoDto> ciPropClaimInsuredList) {
		this.ciPropClaimInsuredList = ciPropClaimInsuredList;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}	
	
}
