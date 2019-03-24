package com.sinosoft.claimciplatform.dto.custom;

public class ClaimCover {
	 private String RecoveryOrPayFlag = "";//追偿/清付标志
	 private String CoverageCode = "";//赔偿险种代码
	 private String LossFeeType = "";//损失赔偿类型
	 private String LiabilityRate = "";//赔偿责任比例
	 private Double ClaimAmount = 0D;//赔款金额
	 private Double SalvageFee = 0D;//施救费
	 
	 
	public ClaimCover() {
	}
	public String getRecoveryOrPayFlag() {
		return RecoveryOrPayFlag;
	}
	public void setRecoveryOrPayFlag(String recoveryOrPayFlag) {
		RecoveryOrPayFlag = recoveryOrPayFlag;
	}
	public String getCoverageCode() {
		return CoverageCode;
	}
	public void setCoverageCode(String coverageCode) {
		CoverageCode = coverageCode;
	}
	public String getLossFeeType() {
		return LossFeeType;
	}
	public void setLossFeeType(String lossFeeType) {
		LossFeeType = lossFeeType;
	}
	public String getLiabilityRate() {
		return LiabilityRate;
	}
	public void setLiabilityRate(String liabilityRate) {
		LiabilityRate = liabilityRate;
	}
	public Double getClaimAmount() {
		return ClaimAmount;
	}
	public void setClaimAmount(Double claimAmount) {
		ClaimAmount = claimAmount;
	}
	public Double getSalvageFee() {
		return SalvageFee;
	}
	public void setSalvageFee(Double salvageFee) {
		SalvageFee = salvageFee;
	}
	 
}
