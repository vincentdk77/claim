package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sinosoft.ciplatform.dto.custom.Paydata;

public class Payinfor {
	private String confirmSequenceNo = ""; // Ͷ��ȷ����
	private String claimCode = ""; // �������
	private String compensateNo = ""; // �������
	private String claimNo = ""; // ������
	private String registNo = ""; // ������
	private String policyNo = ""; // ������
	private String caseType = ""; // �����ⰸ����
	private String licenseNo = ""; // ���ճ��ƺ���
	private String licenseType = ""; // ���ճ�������
	private Date damageDate; // ����ʱ��
	private Date compensateDate; // ����ʱ��
	private Date startDate; // ��������
	private Date endDate; // ����ֹ��
	private double sumPaid = 0; // ������
	private double claimCost = 0; // ����
	private String comCode = "";// ���ӵĹ�������
//	private String times = "";// ��������
//	private Date payDate; // ֧������
	private String agentNo = "";// ����Ա����
	private String agentName = "";// ����Ա����
	private Date setLossTime; // ����ʱ��
	//2011
//	private String payType="";
	private String serialNo = "";//�ϴ����
	private String compensateNos = "";
	private String preCompensateNos = "";
	/**�տ��ʻ���ϸ�б�*/
	List<Paydata> payDataList = new ArrayList<Paydata>();
	/**���֧��������*/
	private String bankName = "";
	/**���֧���˻���*/
	private String accountNumber = "";
	/**���֧���˻���*/
	private String accountName = "";

	/**
	 * @return the serialNo
	 */
	public String getSerialNo() {
		return serialNo;
	}

	/**
	 * @param serialNo the serialNo to set
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	/**
	 * @return the compensateNos
	 */
	public String getCompensateNos() {
		return compensateNos;
	}

	/**
	 * @param compensateNos the compensateNos to set
	 */
	public void setCompensateNos(String compensateNos) {
		this.compensateNos = compensateNos;
	}

	/**
	 * @return the preCompensateNos
	 */
	public String getPreCompensateNos() {
		return preCompensateNos;
	}

	/**
	 * @param preCompensateNos the preCompensateNos to set
	 */
	public void setPreCompensateNos(String preCompensateNos) {
		this.preCompensateNos = preCompensateNos;
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

//	public String getTimes() {
//		return times;
//	}
//
//	public void setTimes(String times) {
//		this.times = times;
//	}

//	public Date getPayDate() {
//		return payDate;
//	}
//
//	public void setPayDate(Date payDate) {
//		this.payDate = payDate;
//	}

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

//	/**
//	 * @return the payType
//	 */
//	public String getPayType() {
//		return payType;
//	}
//
//	/**
//	 * @param payType the payType to set
//	 */
//	public void setPayType(String payType) {
//		this.payType = payType;
//	}

	public List<Paydata> getPayDataList() {
		return payDataList;
	}

	public void setPayDataList(List<Paydata> payDataList) {
		this.payDataList = payDataList;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	

}
