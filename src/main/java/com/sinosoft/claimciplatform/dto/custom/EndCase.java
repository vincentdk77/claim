package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EndCase {
	private String confirmSequenceNo = ""; // Ͷ��ȷ����
	private String claimCode = ""; // �������
	private double sumPaid = 0; // ����ܽ��
	private double nodutyPaid = 0;//���������
	private String registNo = ""; // ������
	private String claimNo = ""; // �������
	private String endcaseNo = ""; // �ⰸ����
	private String registTime; // ����ʱ��
	private String claimTime; // ����ʱ��
	private String endCaseTime; // �᰸ʱ��
	private String isInsuredDuty = ""; // �Ƿ����ڱ�������
	private String caseType = ""; // ��������
	private String prepayreason = ""; // �渶ԭ��
	private String refusereason = ""; // ����ԭ��
	private String licenseNo = ""; // ���ֳ������ƺ���
	private String licenseType = ""; // ���ճ�����������
	private String driverName = ""; // ���ռ�ʻԱ
	private String certiType = ""; // ���ռ�ʻԱ֤������
	private String certiCode = ""; // ���ռ�ʻԱ֤������
	private String policyNo = ""; // ��������
	private String damageDate = ""; // ����ʱ��
	private String damageAdress = "";// ���յص�
	private String damageDescription = "";// ���վ���
	private String handleComcode = "";// ������
	private String indemnityDuty = "";// �¹����δ���
	private String accidentDeath = "";// �Ƿ��������ν�ͨ�����¹ʵı�־
	private String selfPayFlag = "";//���������־
	private AccidentInfor accidentInfor; // �¹���Ϣ
	private List thirdCarList = new ArrayList(); // ���������ƺ�
	private List lossSituationList = new ArrayList(); // ��ʧ�⳥���
	
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
