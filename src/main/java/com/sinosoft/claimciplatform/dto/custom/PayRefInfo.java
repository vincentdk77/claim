package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.ciplatform.dto.custom.Paydata;

public class PayRefInfo {
	/**������*/
	private String claimCode = "";
	/**Ͷ��ȷ����*/
	private String confirmSequenceNo = "";
	/**���*/
	private String serialNo = "";
	/**�⸶����*/
	//private String payType = "";
	/**�⸶ʱ��*/
	//private String payDate = "";
	/**�⸶���*/
	private double payAmount = 0D;
	/**������*/
	private String policyNO="";
	/**������*/
	private String registNo="";
	/**������*/
	private String claimNo="";
	/**�����������*/
	private String compensateNos = "";
	
	private String preCompensateNos = "";
	/**���֧��������*/
	private String bankName = "";
	/**���֧���˻���*/
	private String accountNumber = "";
	/**���֧���˻���*/
	private String accountName = "";
	/**�տ��˻���ϸ�б�*/
	private List<Paydata> payDataList = new ArrayList<Paydata>();
	
	public String getClaimCode() {
		return claimCode;
	}

	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}

	public double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}

	public String getPolicyNO() {
		return policyNO;
	}

	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
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

	public String getCompensateNos() {
		return compensateNos;
	}

	public void setCompensateNos(String compensateNos) {
		this.compensateNos = compensateNos;
	}

	public String getPreCompensateNos() {
		return preCompensateNos;
	}

	public void setPreCompensateNos(String preCompensateNos) {
		this.preCompensateNos = preCompensateNos;
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

	public List<Paydata> getPayDataList() {
		return payDataList;
	}

	public void setPayDataList(List<Paydata> payDataList) {
		this.payDataList = payDataList;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}

	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	
}
