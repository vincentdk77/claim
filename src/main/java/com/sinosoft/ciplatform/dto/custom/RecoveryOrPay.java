package com.sinosoft.ciplatform.dto.custom;



public class RecoveryOrPay {
	private int serialNo;	      	//׷��/�帶���
	private String recoveryOrPayFlag="";//׷��/�帶��־
	private String recoveryOrPayType="";//׷��/�帶����
	private String recoveryOrPayMan="";	//׷��/�帶��
	private String recoveryCode=""; //������
	private String recoveryOrPayAmount = "";//׷��/�帶���
	private String recoveryRemark = "";	//�帶��ע

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
