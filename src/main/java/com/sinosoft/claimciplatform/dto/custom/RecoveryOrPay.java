package com.sinosoft.claimciplatform.dto.custom;

public class RecoveryOrPay {
	private int SerialNo ;//���
	private String RecoveryOrPayFlag = "";//׷��/�帶��־
	private String RecoveryOrPayType = "";//׷��/�帶����
	private String RecoveryOrPayMan = "";//׷��/�帶��
	private String RecoveryCode = "";//������
	private Double RecoveryOrPayAmount = 0D;//׷��/�帶���
	private String RecoveryRemark = "";//�帶��ע
	public int getSerialNo() {
		return SerialNo;
	}
	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}
	public String getRecoveryOrPayFlag() {
		return RecoveryOrPayFlag;
	}
	public void setRecoveryOrPayFlag(String recoveryOrPayFlag) {
		RecoveryOrPayFlag = recoveryOrPayFlag;
	}
	public String getRecoveryOrPayType() {
		return RecoveryOrPayType;
	}
	public void setRecoveryOrPayType(String recoveryOrPayType) {
		RecoveryOrPayType = recoveryOrPayType;
	}
	public String getRecoveryOrPayMan() {
		return RecoveryOrPayMan;
	}
	public void setRecoveryOrPayMan(String recoveryOrPayMan) {
		RecoveryOrPayMan = recoveryOrPayMan;
	}
	public String getRecoveryCode() {
		return RecoveryCode;
	}
	public void setRecoveryCode(String recoveryCode) {
		RecoveryCode = recoveryCode;
	}
	public Double getRecoveryOrPayAmount() {
		return RecoveryOrPayAmount;
	}
	public void setRecoveryOrPayAmount(Double recoveryOrPayAmount) {
		RecoveryOrPayAmount = recoveryOrPayAmount;
	}
	public String getRecoveryRemark() {
		return RecoveryRemark;
	}
	public void setRecoveryRemark(String recoveryRemark) {
		RecoveryRemark = recoveryRemark;
	}
	
}
