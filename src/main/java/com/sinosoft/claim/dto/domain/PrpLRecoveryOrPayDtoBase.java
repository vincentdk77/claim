package com.sinosoft.claim.dto.domain;

public class PrpLRecoveryOrPayDtoBase {
	
	/** ������� */
	private String compensateNo = "";
	/** ���ִ��� */
	private String riskCode = "";
	/** ��� */
	private int serialNo ;
	/** ׷���帶��־ */
	private String recoveryOrPayFlag = "";
	/** ׷���帶���� */
	private String recoveryOrPayType = "";
	/** ׷���帶�� */
	private String recoveryOrPayMan = "";
	/** ������ */
	private String recoveryCode = "";
	/** ׷���帶��� */
	private Double recoveryOrPayAmount = 0D;
	/** �帶��ע */
	private String recoveryRemark = "";
	/**������ */
	private String claimNo = "";
	/**�帶��*/
	private String PayMan = "";
	/**׷�����*/
	private Double recoveryBackAmount = 0D;
	
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getRecoveryOrPayFlag() {
		return recoveryOrPayFlag;
	}
	public void setRecoveryOrPayFlag(String recoveryOrPayFlag) {
		this.recoveryOrPayFlag = recoveryOrPayFlag;
	}
	public String getRecoveryOrPayType() {
		return recoveryOrPayType;
	}
	public void setRecoveryOrPayType(String recoveryOrPayType) {
		this.recoveryOrPayType = recoveryOrPayType;
	}
	public String getRecoveryOrPayMan() {
		return recoveryOrPayMan;
	}
	public void setRecoveryOrPayMan(String recoveryOrPayMan) {
		this.recoveryOrPayMan = recoveryOrPayMan;
	}
	public String getRecoveryCode() {
		return recoveryCode;
	}
	public void setRecoveryCode(String recoveryCode) {
		this.recoveryCode = recoveryCode;
	}
	public Double getRecoveryOrPayAmount() {
		return recoveryOrPayAmount;
	}
	public void setRecoveryOrPayAmount(Double recoveryOrPayAmount) {
		this.recoveryOrPayAmount = recoveryOrPayAmount;
	}
	public String getRecoveryRemark() {
		return recoveryRemark;
	}
	public void setRecoveryRemark(String recoveryRemark) {
		this.recoveryRemark = recoveryRemark;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPayMan() {
		return PayMan;
	}
	public void setPayMan(String payMan) {
		PayMan = payMan;
	}
	public Double getRecoveryBackAmount() {
		return recoveryBackAmount;
	}
	public void setRecoveryBackAmount(Double recoveryBackAmount) {
		this.recoveryBackAmount = recoveryBackAmount;
	}
	
}
