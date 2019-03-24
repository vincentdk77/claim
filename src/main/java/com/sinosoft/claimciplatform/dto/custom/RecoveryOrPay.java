package com.sinosoft.claimciplatform.dto.custom;

public class RecoveryOrPay {
	private int SerialNo ;//序号
	private String RecoveryOrPayFlag = "";//追偿/清付标志
	private String RecoveryOrPayType = "";//追偿/清付类型
	private String RecoveryOrPayMan = "";//追偿/清付人
	private String RecoveryCode = "";//清算码
	private Double RecoveryOrPayAmount = 0D;//追偿/清付金额
	private String RecoveryRemark = "";//清付备注
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
