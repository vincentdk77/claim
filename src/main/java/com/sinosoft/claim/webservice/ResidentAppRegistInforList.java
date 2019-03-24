package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ResidentAppRegistInforList implements Serializable{
	private static final long serialVersionUID = 1L;
	/**报案号*/
	private String registNo;
	/**立案号*/
	private String claimNo;
	/**计算书号*/
	private String[] compensateNo;
	/**保单号*/
	private String policyNo;
	/**被保险人姓名*/
	private String insuredName;
	/**险种*/
	private String riskCode;
	/**出险地点*/
	private String damageAreaCode;
	/**案件处理状态*/
	private String caseType;
	/**理赔清单号*/
	private String[] settleListCode;
	/**出险时间*/
	private String damageStartDate;
	/**赔付次数*/
	private int[] times;
	/**赔付数量*/
	private Double[] lossesNumber;
	/**受益户次*/
	private int[] damageInsured;
	/**出险原因*/
	private String damageCode;
	/**总赔付金额*/
	private Double[] sumPaid;
	/**本次赔付金额*/
	private Double[] sumThisPaid;
	/**出险原因中文说明*/
	private String damageName;
	/**报案时间*/
	private String registTime;
	/**扑杀数量*/
	private Double[] killQuantity;
	/**死亡数量*/
	private Double[] deathQunatity;
	
	
	public Double[] getKillQuantity() {
		return killQuantity;
	}
	public void setKillQuantity(Double[] killQuantity) {
		this.killQuantity = killQuantity;
	}
	public Double[] getDeathQunatity() {
		return deathQunatity;
	}
	public void setDeathQunatity(Double[] deathQunatity) {
		this.deathQunatity = deathQunatity;
	}
	public int[] getTimes() {
		return times;
	}
	public void setTimes(int[] times) {
		this.times = times;
	}
	public Double[] getLossesNumber() {
		return lossesNumber;
	}
	public void setLossesNumber(Double[] lossesNumber) {
		this.lossesNumber = lossesNumber;
	}
	public int[] getDamageInsured() {
		return damageInsured;
	}
	public void setDamageInsured(int[] damageInsured) {
		this.damageInsured = damageInsured;
	}
	public String getDamageCode() {
		return damageCode;
	}
	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}
	public Double[] getSumPaid() {
		return sumPaid;
	}
	public void setSumPaid(Double[] sumPaid) {
		this.sumPaid = sumPaid;
	}
	public Double[] getSumThisPaid() {
		return sumThisPaid;
	}
	public void setSumThisPaid(Double[] sumThisPaid) {
		this.sumThisPaid = sumThisPaid;
	}
	public String getDamageName() {
		return damageName;
	}
	public void setDamageName(String damageName) {
		this.damageName = damageName;
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
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getDamageAreaCode() {
		return damageAreaCode;
	}
	public void setDamageAreaCode(String damageAreaCode) {
		this.damageAreaCode = damageAreaCode;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String[] getSettleListCode() {
		return settleListCode;
	}
	public void setSettleListCode(String[] settleListCode) {
		this.settleListCode = settleListCode;
	}
	public String getDamageStartDate() {
		return damageStartDate;
	}
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}
	public String[] getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String[] compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	

}
