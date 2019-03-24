package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

public class AdvanceInfoDto {
	/** �渶�ⰸ����*/
	private String advanceNo = "";
	/** ���չ�˾����*/
	private String companyCode = "";
	/** ��������*/
	private String registNo = "";
	/** �ⰸ����*/
	private String claimNo = "";
	/** ��������*/
	private String policyNo = "";
	/** Ͷ��ȷ����*/
	private String proposalNo = "";
	/** ���ƺ���*/
	private String licenseNo = "";
	/** ��������*/
	private String carKindCode = "";
	/** ��ʻԱ����*/
	private String driverName = "";
	/** ��ʻԱ֤������*/
	private String drivingLicenseNo = "";
	/** ����ʱ��*/
	private Date damageDate = new Date();
	/** ȫ�𷽱���ʱ��*/
	private Date reportDate = new Date();
	/** ȫ�𷽲鿱ʱ��*/
	private Date checkDate = new Date();
	/** ���յص�*/
	private String damageAddress = "";
	/** �鿱�ص�*/
	private String checkSite = "";
	/** ���վ���*/
	private String accidentDescription = "";
	/** ����ԭ��*/
	private String accidentReason = "";
	/** ȫ�𷽶�����*/
	private double estimateAmount = 0d;
	/** �����⳥���*/
	private double settlementAmount = 0d;
	/** ���ʽ*/
	private String payMode = "";
	/** ���*/
	private String comment = "";
	
	/**
     * ��ȡ���վ���
     * @return ���վ���
     */
	public String getAccidentDescription() {
		return accidentDescription;
	}
	/**
     * ���ó��վ���
     * @param ���վ���
     */
	public void setAccidentDescription(String accidentDescription) {
		this.accidentDescription = accidentDescription;
	}
	
	/**
     * ��ȡ����ԭ��
     * @return ����ԭ��
     */
	public String getAccidentReason() {
		return accidentReason;
	}
	/**
     * ���ó���ԭ��
     * @param ����ԭ��
     */
	public void setAccidentReason(String accidentReason) {
		this.accidentReason = accidentReason;
	}
	
	/**
     * ��ȡ��������
     * @return ��������
     */
	public String getCarKindCode() {
		return carKindCode;
	}
	/**
     * ���ú�������
     * @param ��������
     */
	public void setCarKindCode(String carKindCode) {
		this.carKindCode = carKindCode;
	}
	
	/**
     * ��ȡ�鿱ʱ��
     * @return �鿱ʱ��
     */
	public Date getCheckDate() {
		return checkDate;
	}
	/**
     * ���ò鿱ʱ��
     * @param �鿱ʱ��
     */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	
	/**
     * ��ȡ�鿱�ص�
     * @return �鿱ʱ��
     */
	public String getCheckSite() {
		return checkSite;
	}
	/**
     * ���ò鿱�ص�
     * @param �鿱ʱ��
     */
	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	}
	
	/**
     * ��ȡ�ⰸ����
     * @return �鿱ʱ��
     */
	public String getClaimNo() {
		return claimNo;
	}
	/**
     * �����ⰸ����
     * @param �鿱ʱ��
     */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	
	/**
     * ��ȡ���
     * @return ���
     */
	public String getComment() {
		return comment;
	}
	/**
     * �������
     * @param ���
     */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
     * ��ȡ���չ�˾����
     * @return ���չ�˾����
     */
	public String getCompanyCode() {
		return companyCode;
	}
	/**
     * ���ñ��չ�˾����
     * @param ���չ�˾����
     */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	/**
     * ��ȡ���յص�
     * @return ���յص�
     */
	public String getDamageAddress() {
		return damageAddress;
	}
	/**
     * ���ó��յص�
     * @param ���յص�
     */
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}
	
	/**
     * ��ȡ����ʱ��
     * @return ����ʱ��
     */
	public Date getDamageDate() {
		return damageDate;
	}
	/**
     * ���ó���ʱ��
     * @param ����ʱ��
     */
	public void setDamageDate(Date damageDate) {
		this.damageDate = damageDate;
	}
	
	/**
     * ��ȡ��ʻԱ����
     * @return ��ʻԱ����
     */
	public String getDriverName() {
		return driverName;
	}
	/**
     * ���ü�ʻԱ����
     * @param ��ʻԱ����
     */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	
	/**
     * ��ȡ��ʻԱ֤������
     * @return ��ʻԱ֤������
     */
	public String getDrivingLicenseNo() {
		return drivingLicenseNo;
	}
	/**
     * ���ü�ʻԱ֤������
     * @param ��ʻԱ֤������
     */
	public void setDrivingLicenseNo(String drivingLicenseNo) {
		this.drivingLicenseNo = drivingLicenseNo;
	}
	
	/**
     * ��ȡȫ�𷽶�����
     * @return ȫ�𷽶�����
     */
	public double getEstimateAmount() {
		return estimateAmount;
	}
	/**
     * ����ȫ�𷽶�����
     * @param ȫ�𷽶�����
     */
	public void setEstimateAmount(double estimateAmount) {
		this.estimateAmount = estimateAmount;
	}
	
	/**
     * ��ȡ���ƺ���
     * @return ���ƺ���
     */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
     * ���ú��ƺ���
     * @param ���ƺ���
     */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	/**
     * ��ȡ���ʽ
     * @return ���ʽ
     */
	public String getPayMode() {
		return payMode;
	}
	/**
     * ���ø��ʽ
     * @param ���ʽ
     */
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	
	/**
     * ��ȡ��������
     * @return ��������
     */
	public String getPolicyNo() {
		return policyNo;
	}
	/**
     * ���ñ�������
     * @param ��������
     */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	/**
     * ��ȡͶ��ȷ����
     * @return Ͷ��ȷ����
     */
	public String getProposalNo() {
		return proposalNo;
	}
	/**
     * ����Ͷ��ȷ����
     * @param Ͷ��ȷ����
     */
	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}
	
	/**
     * ��ȡ��������
     * @return ��������
     */
	public String getRegistNo() {
		return registNo;
	}
	/**
     * ���ñ�������
     * @param ��������
     */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	
	/**
     * ��ȡ����ʱ��
     * @return ����ʱ��
     */
	public Date getReportDate() {
		return reportDate;
	}
	/**
     * ���ñ���ʱ��
     * @param ����ʱ��
     */
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	
	/**
     * ��ȡ�����⳥���
     * @return �����⳥���
     */
	public double getSettlementAmount() {
		return settlementAmount;
	}
	/**
     * ���������⳥���
     * @param �����⳥���
     */
	public void setSettlementAmount(double settlementAmount) {
		this.settlementAmount = settlementAmount;
	}
	/**
	 * ��ȡ�渶�ⰸ����
	 * @return the perPayNo
	 */
	public String getAdvanceNo() {
		return advanceNo;
	}
	/**
	 * ���õ渶�ⰸ����
	 * @param perPayNo the perPayNo to set
	 */
	public void setAdvanceNo(String advanceNo) {
		this.advanceNo = advanceNo;
	}
	

}
