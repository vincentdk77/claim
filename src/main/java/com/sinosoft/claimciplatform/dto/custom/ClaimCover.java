package com.sinosoft.claimciplatform.dto.custom;

public class ClaimCover {
	 private String RecoveryOrPayFlag = "";//׷��/�帶��־
	 private String CoverageCode = "";//�⳥���ִ���
	 private String LossFeeType = "";//��ʧ�⳥����
	 private String LiabilityRate = "";//�⳥���α���
	 private Double ClaimAmount = 0D;//�����
	 private Double SalvageFee = 0D;//ʩ�ȷ�
	 
	 
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
