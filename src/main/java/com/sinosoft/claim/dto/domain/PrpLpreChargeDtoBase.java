package com.sinosoft.claim.dto.domain;

public class PrpLpreChargeDtoBase {
	
	/** �����ⰸ�� */
	private String preCompensateNo = "";
	/** ��� */
	private int serialNo ;
	/** ������ */
	private String claimNo = "";
	/** ���ִ��� */
	private String riskCode = "";
	/** ������ */
	private String policyNo = "";
	/** �ձ����*/
	private String kindCode = "";
	/** �ձ�����*/
	private String kindName = "";
	/** ���ô��� */
	private String chargeCode = "";
	/** �������� */
	private String chargeEName = "";
	/** �ұ���� */
	private String currenCY = "";
	/** ���ý�� */
	private double sumPrepaid= 0.0;
	
	
	public String getPreCompensateNo() {
		return preCompensateNo;
	}
	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getChargeCode() {
		return chargeCode;
	}
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
	}
	public String getChargeEName() {
		return chargeEName;
	}
	public void setChargeEName(String chargeEName) {
		this.chargeEName = chargeEName;
	}
	public String getCurrenCY() {
		return currenCY;
	}
	public void setCurrenCY(String currenCY) {
		this.currenCY = currenCY;
	}
	public double getSumPrepaid() {
		return sumPrepaid;
	}
	public void setSumPrepaid(double sumPrepaid) {
		this.sumPrepaid = sumPrepaid;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
}
