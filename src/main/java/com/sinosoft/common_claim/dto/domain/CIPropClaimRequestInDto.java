package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 * 意健险立案数据组装数据
 * @author feigai1
 *
 */
public class CIPropClaimRequestInDto {
	
	private String isGroup = "";
	private String centerCode = "";
	private String policySequenceNo= "";//保单编码
	private String claimNo = "";//赔案号
	private String customerSequenceNo = "";//客户编码
	private Date accidentDate =  new Date();//出险日期	
	private String surveyOrNot = "";//是否调查	
	private Date closeDate = new Date();//结案日期	
	private String claimStatus = "";//理赔状态	
	private String isReopen = "";//是否重开	
	private int reopenNum = 0;//重开次数	
	private String reopenReason = "";//重开原因	
	private Date reportDate = new Date();//报案日期	
	private String reportNo = "";//报案号	
	private Date registrationDate =  new Date();//立案日期	
	private String registrationNo = "";//立案号	
	private String accidentReason = "";//出险原因	
	private String accidentPlace = "";//出险地点	
	private String reportName = "";//报案人姓名	
	private String reportGender = "";//性别	
	private Date reportBirthday =  new Date();//出生日期	
	private String reportCerttype = "";//证件类别	
	private String reportCertno = "";//证件号码	
	private String reportPhone = "";//联系电话	
	private String reportAddr = "";//具体联系地址	
	private String accName = "";//出险人姓名	
	private String accCertType = "";//证件类别
	private String accCertNo = "";//证件号码	
	private String accResult = "";//出险结果	
	private Date accResultDate = new Date();//出险结果时间	
	private String status = "";//业务流程状态	
	private Date investigationStartDate = new Date();//理赔调查开始日期	
	private Date investigationEndDate = new Date();//理赔调查结束日期	
	private String remoteClaimInvestigation = "";//异地理赔调查标识	
	private String relationShip = "";//报案人与出险人关系	
	private String medicalCareLable = "";//医保标识	
	private String socialNumber = "";//社保卡号	
	private String allClaimAmount = "";//赔付总金额	

	private ArrayList<CIPropClaimPolicyInfoDto> ciPropClaimPolicyList ;//保单列表 隶属于赔案信息 
	private ArrayList<CIPropClaimInsuredInfoDto> ciPropClaimInsuredList ;////被保险人列表  隶属于赔案信息 
	
	
	public String getIsGroup() {
		return isGroup;
	}
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public String getPolicySequenceNo() {
		return policySequenceNo;
	}
	public void setPolicySequenceNo(String policySequenceNo) {
		this.policySequenceNo = policySequenceNo;
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
	public Date getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getSurveyOrNot() {
		return surveyOrNot;
	}
	public void setSurveyOrNot(String surveyOrNot) {
		this.surveyOrNot = surveyOrNot;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
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
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
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
	public Date getReportBirthday() {
		return reportBirthday;
	}
	public void setReportBirthday(Date reportBirthday) {
		this.reportBirthday = reportBirthday;
	}
	public String getReportCerttype() {
		return reportCerttype;
	}
	public void setReportCerttype(String reportCerttype) {
		this.reportCerttype = reportCerttype;
	}
	public String getReportCertno() {
		return reportCertno;
	}
	public void setReportCertno(String reportCertno) {
		this.reportCertno = reportCertno;
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
	public Date getAccResultDate() {
		return accResultDate;
	}
	public void setAccResultDate(Date accResultDate) {
		this.accResultDate = accResultDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInvestigationStartDate() {
		return investigationStartDate;
	}
	public void setInvestigationStartDate(Date investigationStartDate) {
		this.investigationStartDate = investigationStartDate;
	}
	public Date getInvestigationEndDate() {
		return investigationEndDate;
	}
	public void setInvestigationEndDate(Date investigationEndDate) {
		this.investigationEndDate = investigationEndDate;
	}
	public String getRemoteClaimInvestigation() {
		return remoteClaimInvestigation;
	}
	public void setRemoteClaimInvestigation(String remoteClaimInvestigation) {
		this.remoteClaimInvestigation = remoteClaimInvestigation;
	}
	public String getRelationShip() {
		return relationShip;
	}
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
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
	public ArrayList<CIPropClaimInsuredInfoDto> getCiPropClaimInsuredList() {
		return ciPropClaimInsuredList;
	}
	public void setCiPropClaimInsuredList(
			ArrayList<CIPropClaimInsuredInfoDto> ciPropClaimInsuredList) {
		this.ciPropClaimInsuredList = ciPropClaimInsuredList;
	}


	
	
}
