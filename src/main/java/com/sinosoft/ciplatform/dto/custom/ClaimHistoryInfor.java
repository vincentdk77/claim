package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

public class ClaimHistoryInfor {

	/** ��������˾ */
	private String claimCompanyCode;

	/** ����ʱ�� */
	private Date accidentTime;

	/** ����ʱ�� */
	private Date reportTime;

	/** ����ʱ�� */
	private Date claimDate;

	/** �᰸ʱ�� */
	private Date endcaseDate;

	/** ������ */
	private double unclaimAmount;

	/** ����� */
	private double claimAmount;

	/** ����״̬ */
	private String status;

	public Date getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
	}

	public double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimCompanyCode() {
		return claimCompanyCode;
	}

	public void setClaimCompanyCode(String claimCompanyCode) {
		this.claimCompanyCode = claimCompanyCode;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public Date getEndcaseDate() {
		return endcaseDate;
	}

	public void setEndcaseDate(Date endcaseDate) {
		this.endcaseDate = endcaseDate;
	}

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getUnclaimAmount() {
		return unclaimAmount;
	}

	public void setUnclaimAmount(double unclaimAmount) {
		this.unclaimAmount = unclaimAmount;
	}

}
