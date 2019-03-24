package com.sinosoft.claim.ui.control.facade;

public class AcciDangerSDClaimInfoDto {
	private String CompanyCode;
	private String LossDate   ;
	private String LossResult ;
	private String ClaimAmount;
	public String getCompanyCode() {
		return CompanyCode;
	}
	public void setCompanyCode(String companyCode) {
		CompanyCode = companyCode;
	}
	public String getLossDate() {
		return LossDate;
	}
	public void setLossDate(String lossDate) {
		LossDate = lossDate;
	}
	public String getLossResult() {
		return LossResult;
	}
	public void setLossResult(String lossResult) {
		LossResult = lossResult;
	}
	public String getClaimAmount() {
		return ClaimAmount;
	}
	public void setClaimAmount(String claimAmount) {
		ClaimAmount = claimAmount;
	}
}
