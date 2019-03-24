package com.sinosoft.claim.dto.domain;

public class PrpLRecoveryOrPayDtoBase {
	
	/** 计算书号 */
	private String compensateNo = "";
	/** 险种代码 */
	private String riskCode = "";
	/** 序号 */
	private int serialNo ;
	/** 追偿清付标志 */
	private String recoveryOrPayFlag = "";
	/** 追偿清付类型 */
	private String recoveryOrPayType = "";
	/** 追偿清付人 */
	private String recoveryOrPayMan = "";
	/** 清算码 */
	private String recoveryCode = "";
	/** 追偿清付金额 */
	private Double recoveryOrPayAmount = 0D;
	/** 清付备注 */
	private String recoveryRemark = "";
	/**立案号 */
	private String claimNo = "";
	/**清付人*/
	private String PayMan = "";
	/**追偿金额*/
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
