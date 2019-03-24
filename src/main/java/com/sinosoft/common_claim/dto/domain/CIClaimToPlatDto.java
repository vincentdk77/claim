package com.sinosoft.common_claim.dto.domain;

public class CIClaimToPlatDto {

	/**报案号*/
	private String registNo;
	/**立案号*/
	private String claimNo;
	/**保单号*/
	private String policyNo;
	/**理算书号*/
	private String compensateNo;
	/**交强或商业险*/
	private String jqorsy;
	/**业务类型*/
	private String serviceType;
	/**省份*/
	private String province;
	/**重开赔案号*/
	private int serlalNo;
	private String payrefNo;
	
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getCompensateNo() {
		return compensateNo;
	}
	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;
	}
	public String getJqorsy() {
		return jqorsy;
	}
	public void setJqorsy(String jqorsy) {
		this.jqorsy = jqorsy;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public int getSerlalNo() {
		return serlalNo;
	}
	public void setSerlalNo(int serlalNo) {
		this.serlalNo = serlalNo;
	}
	public String getPayrefNo() {
		return payrefNo;
	}
	public void setPayrefNo(String payrefNo) {
		this.payrefNo = payrefNo;
	}
	
}
