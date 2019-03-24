package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 保單信息查詢接口出参
 * 
 * @author Administrator
 * 
 */
public class PrpallInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**投保单号*/
	private String proposalNo;
	/**保单号*/
	private String policyNo;
	/**保单起期*/
	private Date startDate;
	/**保单止期*/
	private Date endDate;
	/**险种*/
	private String riskCode;
	/**险别代码*/
	private String kindCode;
	/**险别名称*/
	private String kindName;
	/**连共保标志*/
	private String coinsFlag;
	/**专项业务类型*/
    private String articleType = "";
	/**大病医疗明细专项业务类型*/
    private String bigMedicalType = "";
    /**保费*/
    private double sumPremium= 0D;
    /**保额*/
    private double sumAmount = 0D;
    /**投保人名称*/
    private String appliName = "";
    /**被保险人名称*/
    private String insuredName = "";
	
	public String getProposalNo() {
		return proposalNo;
	}
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getKindCode() {
		return kindCode;
	}
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	public String getKindName() {
		return kindName;
	}
	public void setKindName(String kindName) {
		this.kindName = kindName;
	}
	public String getCoinsFlag() {
		return coinsFlag;
	}
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getArticleType() {
		return articleType;
	}
	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}
	public String getBigMedicalType() {
		return bigMedicalType;
	}
	public void setBigMedicalType(String bigMedicalType) {
		this.bigMedicalType = bigMedicalType;
	}
	public double getSumPremium() {
		return sumPremium;
	}
	public void setSumPremium(double sumPremium) {
		this.sumPremium = sumPremium;
	}
	public double getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(double sumAmount) {
		this.sumAmount = sumAmount;
	}
	public String getAppliName() {
		return appliName;
	}
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

}
