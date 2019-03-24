package com.sinosoft.ciplatform.dto.custom;

public class ThirdCar {
	private String licenseNo="";//号牌号码
	private String policyNo="";//号牌号码
	private String licenseKindCode="";//号牌种类
	private String insuredCompanyCode="";//保险公司代码
	private double realPaid = 0D;  //垫付金额
	
	public ThirdCar(){
	}
	public ThirdCar(String licenseNo){
		this.licenseNo = licenseNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	public String getLicenseKindCode() {
		return licenseKindCode;
	}
	public void setLicenseKindCode(String licenseKindCode) {
		this.licenseKindCode = licenseKindCode;
	}
	
	public String getInsuredCompanyCode() {
		return insuredCompanyCode;
	}
	public void setInsuredCompanyCode(String insuredCompanyCode) {
		this.insuredCompanyCode = insuredCompanyCode;
	}
	 /**
     * 设置属性realPaid
     * @param realPaid 待设置的属性realPaid的值
     */
    public void setRealPaid(double realPaid){
        this.realPaid = realPaid;
    }

    /**
     * 获取属性realPaid
     * @return 属性realPaid的值
     */
    public double getRealPaid(){
        return realPaid;
    }
	
}
