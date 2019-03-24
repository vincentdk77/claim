package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 *  此基础类是用于支付查询时的展示类
 * @author Administrator
 *
 */
public class PrpLpayShowDto implements Serializable {
	
	/**保单类型*/
	private String policyType;
	/**保单号码*/
	private String policyNo;
	/**报案号码*/
	private String registNo;
	/**业务单号*/
	private String certiNo;
	/**业务单号*/
	private String claimNo;
	/**被保险人*/
	private String insuredName;
	/**号牌号码*/
	private String licenseNo;
	/**总支付金额*/
	private double sumPaid = 0.00d;
	/**已支付金额*/
	private double havPaid = 0.00d;
	/**流入时长*/
	private String underWriteEndDate;
	/**支付类型*/
	private String payType;
	/**承保机构代码*/
	private String comCode;
	/**承保机构名称*/
	private String comCodeName;
	/**本次支付金额*/
	private double nowPaid = 0.00d;
	/**是否勾选（1：勾选，0或空：未勾选）*/
	private String exist;
	/**流程查询flowId*/
	private String flowId;
	/**退回标志*/
	private String vflag;
	/**赔付类型*/
	private String payrefreason;
	/**险种*/
	private String riskCode ;
	/**险类*/
	private String classCode ;
	/**出险时间*/
	private String damageDate;
	/**起保日期*/
	private String startDate;
	/**z终保日期*/
	private String endDate;
	/**理赔清单*/
	private String claimRelationNo;
	/**清单主键序号*/
	private String fkSerialNo;
	/**清单人员赔付金额*/
	private double billPaid;
	/**清单人员已支付金额*/
	private double billHavPay;
	/**被保险人共保人代码	 */
	private String coinsCode;
	/**
     *  默认构造方法,构造一个默认的PrpLpayGatherDto对象
     */
    public PrpLpayShowDto(){
    }
    public String getCoinsCode() {
		return coinsCode;
	}
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}
	/**保单类型*/
    public String getPolicyType() {
		return policyType;
	}
    /**保单类型*/
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	/**保单号码*/
	public String getPolicyNo() {
		return policyNo;
	}
	/**保单号码*/
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**报案号码*/
	public String getRegistNo() {
		return registNo;
	}
	/**报案号码*/
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**业务单号*/
	public String getCertiNo() {
		return certiNo;
	}
	/**业务单号*/
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}
	/**立案号*/
	public String getClaimNo() {
		return claimNo;
	}
	/**立案号*/
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**被保险人*/
	public String getInsuredName() {
		return insuredName;
	}
	/**被保险人*/
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	/**号牌号码*/
	public String getLicenseNo() {
		return licenseNo;
	}
	/**号牌号码*/
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/**总支付金额*/
	public double getSumPaid() {
		return sumPaid;
	}
	/**总支付金额*/
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	/**已支付金额*/
	public double getHavPaid() {
		return havPaid;
	}
	/**已支付金额*/
	public void setHavPaid(double havPaid) {
		this.havPaid = havPaid;
	}
	/**流入时长*/
	public String getUnderWriteEndDate() {
		return underWriteEndDate;
	}
	/**流入时长*/
	public void setUnderWriteEndDate(String underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}
	/**支付类型*/
	public String getPayType() {
		return payType;
	}
	/**支付类型*/
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**承保机构代码*/
	public String getComCode() {
		return comCode;
	}
	/**承保机构代码*/
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**承保机构名称*/
	public String getComCodeName() {
		return comCodeName;
	}
	/**承保机构名称*/
	public void setComCodeName(String comCodeName) {
		this.comCodeName = comCodeName;
	}
	/**本次支付金额*/
	public double getNowPaid() {
		return nowPaid;
	}
	/**本次支付金额*/
	public void setNowPaid(double nowPaid) {
		this.nowPaid = nowPaid;
	}
	/**是否勾选（1：勾选，0或空：未勾选）*/
	public String getExist() {
		return exist;
	}
	/**是否勾选（1：勾选，0或空：未勾选）*/
	public void setExist(String exist) {
		this.exist = exist;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getVflag() {
		return vflag;
	}
	public void setVflag(String vflag) {
		this.vflag = vflag;
	}
	public String getPayrefreason() {
		return payrefreason;
	}
	public void setPayrefreason(String payrefreason) {
		this.payrefreason = payrefreason;
	}
	
	public void setRiskCode (String certiNo){
		if(null!=certiNo&&!"".equals(certiNo)){
			this.riskCode = certiNo.substring(1, 5);
		}
	}
	
	public String getRiskCode (){
		return riskCode;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		if(null!=certiNo&&!"".equals(certiNo)){
			this.classCode = certiNo.substring(1, 3);
		}
	}
	public String getDamageDate() {
		return damageDate;
	}
	public void setDamageDate(String damageDate) {
		this.damageDate = damageDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getClaimRelationNo() {
		return claimRelationNo;
	}
	public void setClaimRelationNo(String claimRelationNo) {
		this.claimRelationNo = claimRelationNo;
	}
	public String getFkSerialNo() {
		return fkSerialNo;
	}
	public void setFkSerialNo(String fkSerialNo) {
		this.fkSerialNo = fkSerialNo;
	}
	public double getBillPaid() {
		return billPaid;
	}
	public void setBillPaid(double billPaid) {
		this.billPaid = billPaid;
	}
	public double getBillHavPay() {
		return billHavPay;
	}
	public void setBillHavPay(double billHavPay) {
		this.billHavPay = billHavPay;
	}
}
