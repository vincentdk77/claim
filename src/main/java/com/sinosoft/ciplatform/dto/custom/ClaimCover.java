package com.sinosoft.ciplatform.dto.custom;



public class ClaimCover {
	private String liabilityRate="";	      	//�⳥���α���
	private String recoveryOrPayFlag="";			//׷��/�帶��־
	private String coverageCode="";			//�⳥���ִ���
	private String claimFeeType="";			//��ʧ�⳥���ʹ���
	private String claimAmount=""; 	//�����
	private String salvageFee = "";		//ʩ�ȷ�
	private String lossAmount = "";		//ʩ�ȷ�
	private String isDeviceItem = "";//ȫ���ͳ����գ��Ƿ������豸�ֶ�
	/**
	 * @return the liabilityRate
	 */
	public String getLiabilityRate() {
		return liabilityRate;
	}
	/**
	 * @param liabilityRate the liabilityRate to set
	 */
	public void setLiabilityRate(String liabilityRate) {
		this.liabilityRate = liabilityRate;
	}
	/**
	 * @return the recoveryOrPayFlag
	 */
	public String getRecoveryOrPayFlag() {
		return recoveryOrPayFlag;
	}
	/**
	 * @param recoveryOrPayFlag the recoveryOrPayFlag to set
	 */
	public void setRecoveryOrPayFlag(String recoveryOrPayFlag) {
		this.recoveryOrPayFlag = recoveryOrPayFlag;
	}
	/**
	 * @return the coverageCode
	 */
	public String getCoverageCode() {
		return coverageCode;
	}
	/**
	 * @param coverageCode the coverageCode to set
	 */
	public void setCoverageCode(String coverageCode) {
		this.coverageCode = coverageCode;
	}
	/**
	 * @return the claimFeeType
	 */
	public String getClaimFeeType() {
		return claimFeeType;
	}
	/**
	 * @param claimFeeType the claimFeeType to set
	 */
	public void setClaimFeeType(String claimFeeType) {
		this.claimFeeType = claimFeeType;
	}
	/**
	 * @return the claimAmount
	 */
	public String getClaimAmount() {
		return claimAmount;
	}
	/**
	 * @param claimAmount the claimAmount to set
	 */
	public void setClaimAmount(String claimAmount) {
		this.claimAmount = claimAmount;
	}
	/**
	 * @return the salvageFee
	 */
	public String getSalvageFee() {
		return salvageFee;
	}
	/**
	 * @param salvageFee the salvageFee to set
	 */
	public void setSalvageFee(String salvageFee) {
		this.salvageFee = salvageFee;
	}
	public String getLossAmount() {
		return lossAmount;
	}
	public void setLossAmount(String lossAmount) {
		this.lossAmount = lossAmount;
	}
	public String getIsDeviceItem() {
		return isDeviceItem;
	}
	public void setIsDeviceItem(String isDeviceItem) {
		this.isDeviceItem = isDeviceItem;
	}
}
