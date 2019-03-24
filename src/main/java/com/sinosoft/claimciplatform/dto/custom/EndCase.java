package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EndCase {
	private String confirmSequenceNo = ""; // 投保确认码
	private String claimCode = ""; // 理赔编码
	private double sumPaid = 0; // 赔款总金额
	private double nodutyPaid = 0;//无责代赔金额
	private String registNo = ""; // 报案号
	private String claimNo = ""; // 立案编号
	private String endcaseNo = ""; // 赔案号码
	private String registTime; // 报案时间
	private String claimTime; // 立案时间
	private String endCaseTime; // 结案时间
	private String isInsuredDuty = ""; // 是否属于保险责任
	private String caseType = ""; // 理赔类型
	private String prepayreason = ""; // 垫付原因
	private String refusereason = ""; // 拒赔原因
	private String licenseNo = ""; // 出现车辆车牌号码
	private String licenseType = ""; // 出险车辆号牌种类
	private String driverName = ""; // 出险驾驶员
	private String certiType = ""; // 出险驾驶员证件类型
	private String certiCode = ""; // 出险驾驶员证件号码
	private String policyNo = ""; // 保单号码
	private String damageDate = ""; // 出险时间
	private String damageAdress = "";// 出险地点
	private String damageDescription = "";// 出险经过
	private String handleComcode = "";// 处理部门
	private String indemnityDuty = "";// 事故责任代码
	private String accidentDeath = "";// 是否发生有责任交通死亡事故的标志
	private String selfPayFlag = "";//互碰自赔标志
	private AccidentInfor accidentInfor; // 事故信息
	private List thirdCarList = new ArrayList(); // 第三方车牌号
	private List lossSituationList = new ArrayList(); // 损失赔偿情况
	
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

	public String getEndcaseNo() {
		return endcaseNo;
	}
	public void setEndcaseNo(String endcaseNo) {
		this.endcaseNo = endcaseNo;
	}
	public String getIsInsuredDuty() {
		return isInsuredDuty;
	}
	public void setIsInsuredDuty(String isInsuredDuty) {
		this.isInsuredDuty = isInsuredDuty;
	}
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}
	public String getDamageAdress() {
		return damageAdress;
	}
	public void setDamageAdress(String damageAdress) {
		this.damageAdress = damageAdress;
	}
	public String getDamageDescription() {
		return damageDescription;
	}
	public void setDamageDescription(String damageDescription) {
		this.damageDescription = damageDescription;
	}
	public String getHandleComcode() {
		return handleComcode;
	}
	public void setHandleComcode(String handleComcode) {
		this.handleComcode = handleComcode;
	}
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	public String getAccidentDeath() {
		return accidentDeath;
	}
	public void setAccidentDeath(String accidentDeath) {
		this.accidentDeath = accidentDeath;
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
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getClaimTime() {
		return claimTime;
	}
	public void setClaimTime(String claimTime) {
		this.claimTime = claimTime;
	}
	public String getEndCaseTime() {
		return endCaseTime;
	}
	public void setEndCaseTime(String endCaseTime) {
		this.endCaseTime = endCaseTime;
	}
	public String getSelfPayFlag() {
		return selfPayFlag;
	}
	public void setSelfPayFlag(String selfPayFlag) {
		this.selfPayFlag = selfPayFlag;
	}
	public double getNodutyPaid() {
		return nodutyPaid;
	}
	public void setNodutyPaid(double nodutyPaid) {
		this.nodutyPaid = nodutyPaid;
	}
	
}
