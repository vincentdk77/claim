package com.sinosoft.ciplatform.dto.custom;



public class RecoveryOrPay {
	private int serialNo;	      	//追偿/清付序号
	private String recoveryOrPayFlag="";//追偿/清付标志
	private String recoveryOrPayType="";//追偿/清付类型
	private String recoveryOrPayMan="";	//追偿/清付人
	private String recoveryCode=""; //清算码
	private String recoveryOrPayAmount = "";//追偿/清付金额
	private String recoveryRemark = "";	//清付备注

	/**
	 * @return the recoveryOrPayFlag
	 */
	public String getRecoveryOrPayFlag() {
		return recoveryOrPayFlag;
	}
	/**
	 * @param recoveryOrPayFlag the recoveryOrPayFlag to set
	 */
	public void setRecoveryOrPayFlag(String recoveryOrPayFlag) {
		this.recoveryOrPayFlag = recoveryOrPayFlag;
	}
	/**
	 * @return the recoveryOrPayType
	 */
	public String getRecoveryOrPayType() {
		return recoveryOrPayType;
	}
	/**
	 * @param recoveryOrPayType the recoveryOrPayType to set
	 */
	public void setRecoveryOrPayType(String recoveryOrPayType) {
		this.recoveryOrPayType = recoveryOrPayType;
	}
	/**
	 * @return the recoveryOrPayMan
	 */
	public String getRecoveryOrPayMan() {
		return recoveryOrPayMan;
	}
	/**
	 * @param recoveryOrPayMan the recoveryOrPayMan to set
	 */
	public void setRecoveryOrPayMan(String recoveryOrPayMan) {
		this.recoveryOrPayMan = recoveryOrPayMan;
	}
	/**
	 * @return the recoveryCode
	 */
	public String getRecoveryCode() {
		return recoveryCode;
	}
	/**
	 * @param recoveryCode the recoveryCode to set
	 */
	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
	}
	/**
	 * @return the recoveryOrPayAmount
	 */
	public String getRecoveryOrPayAmount() {
		return recoveryOrPayAmount;
	}
	/**
	 * @param recoveryOrPayAmount the recoveryOrPayAmount to set
	 */
	public void setRecoveryOrPayAmount(String recoveryOrPayAmount) {
		this.recoveryOrPayAmount = recoveryOrPayAmount;
	}
	/**
	 * @return the recoveryRemark
	 */
	public String getRecoveryRemark() {
		return recoveryRemark;
	}
	/**
	 * @param recoveryRemark the recoveryRemark to set
	 */
	public void setRecoveryRemark(String recoveryRemark) {
		this.recoveryRemark = recoveryRemark;
	}
	/**
	 * @return the serialNo
	 */
	public int getSerialNo() {
		return serialNo;
	}
	/**
	 * @param serialNo the serialNo to set
	 */
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
}
