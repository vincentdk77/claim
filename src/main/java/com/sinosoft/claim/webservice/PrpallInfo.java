package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * ������Ϣ��ԃ�ӿڳ���
 * 
 * @author Administrator
 * 
 */
public class PrpallInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**Ͷ������*/
	private String proposalNo;
	/**������*/
	private String policyNo;
	/**��������*/
	private Date startDate;
	/**����ֹ��*/
	private Date endDate;
	/**����*/
	private String riskCode;
	/**�ձ����*/
	private String kindCode;
	/**�ձ�����*/
	private String kindName;
	/**��������־*/
	private String coinsFlag;
	/**ר��ҵ������*/
    private String articleType = "";
	/**��ҽ����ϸר��ҵ������*/
    private String bigMedicalType = "";
    /**����*/
    private double sumPremium= 0D;
    /**����*/
    private double sumAmount = 0D;
    /**Ͷ��������*/
    private String appliName = "";
    /**������������*/
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
