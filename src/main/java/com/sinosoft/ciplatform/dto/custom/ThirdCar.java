package com.sinosoft.ciplatform.dto.custom;

public class ThirdCar {
	private String licenseNo="";//���ƺ���
	private String policyNo="";//���ƺ���
	private String licenseKindCode="";//��������
	private String insuredCompanyCode="";//���չ�˾����
	private double realPaid = 0D;  //�渶���
	
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
     * ��������realPaid
     * @param realPaid �����õ�����realPaid��ֵ
     */
    public void setRealPaid(double realPaid){
        this.realPaid = realPaid;
    }

    /**
     * ��ȡ����realPaid
     * @return ����realPaid��ֵ
     */
    public double getRealPaid(){
        return realPaid;
    }
	
}
