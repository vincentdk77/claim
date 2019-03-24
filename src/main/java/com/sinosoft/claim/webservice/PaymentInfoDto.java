package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class PaymentInfoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 报案号码 */
	private String registNoPay;
	/** 被保险人 */
	private String insuredNamePay;
	/** 理算书号 */
	private String certiNoPay;
	/** 赔款类型 */
	private String paymentType;
	/** 赔款类型代码 */
	private String paymentTypeCode;
	/** 结案金额 */
	private double sumPaidPay;
	/** 已支付金额 */
	private double havPaidPay;
	/** 本次支付金额 */
	private double paidPay;
	/** 属性关联案件外键 */
    private String relationOutId = "";
    /** 属性关联案件类型(N正常案件R重开案件) */
    private String relationOutIdType = "";

	public String getRegistNoPay() {
		return registNoPay;
	}

	public void setRegistNoPay(String registNoPay) {
		this.registNoPay = registNoPay;
	}

	public String getInsuredNamePay() {
		return insuredNamePay;
	}

	public void setInsuredNamePay(String insuredNamePay) {
		this.insuredNamePay = insuredNamePay;
	}

	public String getCertiNoPay() {
		return certiNoPay;
	}

	public void setCertiNoPay(String certiNoPay) {
		this.certiNoPay = certiNoPay;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentTypeCode() {
		return paymentTypeCode;
	}

	public void setPaymentTypeCode(String paymentTypeCode) {
		this.paymentTypeCode = paymentTypeCode;
	}

	public double getSumPaidPay() {
		return sumPaidPay;
	}

	public void setSumPaidPay(double sumPaidPay) {
		this.sumPaidPay = sumPaidPay;
	}

	public double getHavPaidPay() {
		return havPaidPay;
	}

	public void setHavPaidPay(double havPaidPay) {
		this.havPaidPay = havPaidPay;
	}

	public double getPaidPay() {
		return paidPay;
	}

	public void setPaidPay(double paidPay) {
		this.paidPay = paidPay;
	}
	
	/**
     * 设置属性关联案件外键
     * @param relationOutId 待设置的属性关联案件外键的值
     */
    public void setRelationOutId(String relationOutId){
        this.relationOutId = StringUtils.rightTrim(relationOutId);
    }

    /**
     * 获取属性关联案件外键
     * @return 属性关联案件外键的值
     */
    public String getRelationOutId(){
        return relationOutId;
    }

    /**
     * 设置属性关联案件类型(N正常案件R重开案件)
     * @param relationOutIdType 待设置的属性关联案件类型(N正常案件R重开案件)的值
     */
    public void setRelationOutIdType(String relationOutIdType){
        this.relationOutIdType = StringUtils.rightTrim(relationOutIdType);
    }

    /**
     * 获取属性关联案件类型(N正常案件R重开案件)
     * @return 属性关联案件类型(N正常案件R重开案件)的值
     */
    public String getRelationOutIdType(){
        return relationOutIdType;
    }

}
