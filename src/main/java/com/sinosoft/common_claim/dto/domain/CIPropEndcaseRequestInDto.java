package com.sinosoft.common_claim.dto.domain;

import java.util.ArrayList;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLpersonLossForSHDto;

/**
 * 意健险结案数据组装
 * @author feigai1
 *
 */
public class CIPropEndcaseRequestInDto {

	private String claimCode="";	      	//理赔编码
	private String policySequenceNo="";	    //保单编码
	private String isGroup = "";		//是否团单
	private double sumPaid = 0;        //赔款总金额
	private String registNo="";		 //报案号
	private String claimNo="";       //立案编号
	private String policyNO="";	     //保单号
	private String endCaseNo="";     //赔案号
	private String isReopen = "";    //是否重开
	private int reopenNum = 0;       //重开次数
	private String reopenReason="";  //重开原因
	
	private String caseType=""; //理赔类型
	private String ClaimDate = ""; //立案时间
	private String damageDate  = "";//出险时间
	private String damageHour = "";			//出险时间
	private String reportDate = ""; //报案时间
	private String reportHour="";
	private String endCaseDate = "";//结案时间
	private String reportName="" ; //报案人姓名
	private String phoneNumber = "";  //报案人电话
	private String linkerName = "";  //联系人姓名
	private String linkerAddress="" ; //联系人地址
	private String damagerArrea="" ; //出险地点
	private String damagerText="" ; //出险经过
	private String damageName="" ; //出险原因
	private String checkDate = "";//查勘时间
	private String remoteCheckType="" ; //异地理赔调查
	private String claimAccount = "";//赔款帐号
	private String claimBank = "";//赔款账户开户行
	private String claimName = "";//赔款帐号所有人
	
	private String customerSequenceNo = "";//客户编码
	private String acciName=""; //出险人姓名
	private String identifyType=""; //出险人证件类型
	private String identifyNumber=""; //出险人证件号码
	private String damageTypeName=""; //出现结果（事故类型）
	private String clauseType=""; //报案人与出险人关系
	private String HospitalCode=""; //医疗机构代码
	private String DiseaseCode=""; //疾病代码

	private ArrayList<PrpLacciPersonDto> acciPersonList=new ArrayList<PrpLacciPersonDto>();   //人员损失
	private ArrayList<PrpLpersonLossForSHDto> personLossList=new ArrayList<PrpLpersonLossForSHDto>();   //人员损失


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
