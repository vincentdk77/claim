package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

/**
 *  �˻�����������֧����ѯʱ��չʾ��
 * @author Administrator
 *
 */
public class PrpLpayShowDto implements Serializable {
	
	/**��������*/
	private String policyType;
	/**��������*/
	private String policyNo;
	/**��������*/
	private String registNo;
	/**ҵ�񵥺�*/
	private String certiNo;
	/**ҵ�񵥺�*/
	private String claimNo;
	/**��������*/
	private String insuredName;
	/**���ƺ���*/
	private String licenseNo;
	/**��֧�����*/
	private double sumPaid = 0.00d;
	/**��֧�����*/
	private double havPaid = 0.00d;
	/**����ʱ��*/
	private String underWriteEndDate;
	/**֧������*/
	private String payType;
	/**�б���������*/
	private String comCode;
	/**�б���������*/
	private String comCodeName;
	/**����֧�����*/
	private double nowPaid = 0.00d;
	/**�Ƿ�ѡ��1����ѡ��0��գ�δ��ѡ��*/
	private String exist;
	/**���̲�ѯflowId*/
	private String flowId;
	/**�˻ر�־*/
	private String vflag;
	/**�⸶����*/
	private String payrefreason;
	/**����*/
	private String riskCode ;
	/**����*/
	private String classCode ;
	/**����ʱ��*/
	private String damageDate;
	/**������*/
	private String startDate;
	/**z�ձ�����*/
	private String endDate;
	/**�����嵥*/
	private String claimRelationNo;
	/**�嵥�������*/
	private String fkSerialNo;
	/**�嵥��Ա�⸶���*/
	private double billPaid;
	/**�嵥��Ա��֧�����*/
	private double billHavPay;
	/**�������˹����˴���	 */
	private String coinsCode;
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayGatherDto����
     */
    public PrpLpayShowDto(){
    }
    public String getCoinsCode() {
		return coinsCode;
	}
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}
	/**��������*/
    public String getPolicyType() {
		return policyType;
	}
    /**��������*/
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	/**��������*/
	public String getPolicyNo() {
		return policyNo;
	}
	/**��������*/
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**��������*/
	public String getRegistNo() {
		return registNo;
	}
	/**��������*/
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/**ҵ�񵥺�*/
	public String getCertiNo() {
		return certiNo;
	}
	/**ҵ�񵥺�*/
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}
	/**������*/
	public String getClaimNo() {
		return claimNo;
	}
	/**������*/
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	/**��������*/
	public String getInsuredName() {
		return insuredName;
	}
	/**��������*/
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	/**���ƺ���*/
	public String getLicenseNo() {
		return licenseNo;
	}
	/**���ƺ���*/
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/**��֧�����*/
	public double getSumPaid() {
		return sumPaid;
	}
	/**��֧�����*/
	public void setSumPaid(double sumPaid) {
		this.sumPaid = sumPaid;
	}
	/**��֧�����*/
	public double getHavPaid() {
		return havPaid;
	}
	/**��֧�����*/
	public void setHavPaid(double havPaid) {
		this.havPaid = havPaid;
	}
	/**����ʱ��*/
	public String getUnderWriteEndDate() {
		return underWriteEndDate;
	}
	/**����ʱ��*/
	public void setUnderWriteEndDate(String underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}
	/**֧������*/
	public String getPayType() {
		return payType;
	}
	/**֧������*/
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**�б���������*/
	public String getComCode() {
		return comCode;
	}
	/**�б���������*/
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/**�б���������*/
	public String getComCodeName() {
		return comCodeName;
	}
	/**�б���������*/
	public void setComCodeName(String comCodeName) {
		this.comCodeName = comCodeName;
	}
	/**����֧�����*/
	public double getNowPaid() {
		return nowPaid;
	}
	/**����֧�����*/
	public void setNowPaid(double nowPaid) {
		this.nowPaid = nowPaid;
	}
	/**�Ƿ�ѡ��1����ѡ��0��գ�δ��ѡ��*/
	public String getExist() {
		return exist;
	}
	/**�Ƿ�ѡ��1����ѡ��0��գ�δ��ѡ��*/
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
