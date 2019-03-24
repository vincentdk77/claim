package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * 意健险报案请求对象数据组装
 * @author feigai1
 *
 */
public class CIPropRegistRequestInDto {
//  个/团险标志
	private String isGroup = "";
//	赔案号	CLAIM_NO
	private String claimNo = "";
//	客户编码	CUSTOMER_SEQUENCE_NO
	private String customerSequenceNo = "";
//	出险日期	ACCIDENT_DATE
	private String accidentDate = "";
//	是否调查	SURVEY_OR_NOT
	private String 	surveyOrNot = "";
//	结案日期	CLOSE_DATE
	private String 	closeDate = "";
//	理赔状态	CLAIM_STATUS
	private String claimStatus = "";
//	是否重开	IS_REOPEN
	private String isReopen = "";
//	重开次数	REOPEN_NUM
	private String reopenNum = "";
//	重开原因	REOPEN_REASON
	private String reopenReason = "";
//	报案日期	REPORT_DATE
	private String reportDate = "";
//	报案号	REPORT_NO
	private String reportNo = "";
//	立案日期	REGISTRATION_DATE
	private String registrationDate = "";
//	立案号	REGISTRATION_NO
	private String registrationNo = "";
//	出险原因	ACCIDENT_REASON
	private String accidentReason = "";
//	出险地点	ACCIDENT_PLACE
	private String accidentPlace = "";
//	报案人姓名	REPORT_NAME
	private String reportName = "";
//	性别	REPORT_GENDER
	private String reportGender = "";
//	出生日期	REPORT_BIRTHDAY
	private String reportBirthday = "";
//	证件类别	REPORT_CERTTYPE
	private String reportCertType = "";
//	证件号码	REPORT_CERTNO
	private String reportCertNo = "";
//	联系电话	REPORT_PHONE
	private String reportPhone = "";
//	具体联系地址	REPORT_ADDR
	private String reportAddr = "";
//	出险人姓名	ACC_NAME
	private String accName = "";
//	证件类别	ACC_CERTTYPE
	private String accCertType = "";
//	证件号码	ACC_CERTNO
	private String accCertNo = "";
//	出险结果	ACC_RESULT
	private String accResult = "";
//	出险结果时间	ACC_RESULT_DATE
	private String accResultDate = "";
//	业务流程状态	STATUS
	private String status = "";
//	理赔调查开始日期	INVESTIGATION_START_DATE
	private String investigationStartDate = "";
//	理赔调查结束日期	INVESTIGATION_END_DATE
	private String investigationEndDate = "";
//	异地理赔调查标识	REMOTE_CLAIM_INVESTIGATION
	private String remoteClaimInvestigation = "";
//	报案人与出险人关系	RELATIONSHIP
	private String relationship = "";
//	医保标识	MEDICAL_CARE_LABLE
	private String medicalCareLable = "";
//	社保卡号	SOCIAL_NUMBER
	private String socialNumber = "";
//	赔付总金额	ALL_CLAIM_AMOUNT
	private String allClaimAmount = "";
//	保单号
	private String policyNo = "";
//	保单列表 隶属于赔案信息 
	private ArrayList<CIPropClaimPolicyInfoDto> ciPropClaimPolicyList = new ArrayList<CIPropClaimPolicyInfoDto>();
//	团险特有属性
//	保单编号
	private String policySequenceNo = "";
//	被保险人列表  隶属于赔案信息
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
