package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class PaymentInfoDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** �������� */
	private String registNoPay;
	/** �������� */
	private String insuredNamePay;
	/** ������� */
	private String certiNoPay;
	/** ������� */
	private String paymentType;
	/** ������ʹ��� */
	private String paymentTypeCode;
	/** �᰸��� */
	private double sumPaidPay;
	/** ��֧����� */
	private double havPaidPay;
	/** ����֧����� */
	private double paidPay;
	/** ���Թ���������� */
    private String relationOutId = "";
    /** ���Թ�����������(N��������R�ؿ�����) */
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
     * �������Թ����������
     * @param relationOutId �����õ����Թ������������ֵ
     */
    public void setRelationOutId(String relationOutId){
        this.relationOutId = StringUtils.rightTrim(relationOutId);
    }

    /**
     * ��ȡ���Թ����������
     * @return ���Թ������������ֵ
     */
    public String getRelationOutId(){
        return relationOutId;
    }

    /**
     * �������Թ�����������(N��������R�ؿ�����)
     * @param relationOutIdType �����õ����Թ�����������(N��������R�ؿ�����)��ֵ
     */
    public void setRelationOutIdType(String relationOutIdType){
        this.relationOutIdType = StringUtils.rightTrim(relationOutIdType);
    }

    /**
     * ��ȡ���Թ�����������(N��������R�ؿ�����)
     * @return ���Թ�����������(N��������R�ؿ�����)��ֵ
     */
    public String getRelationOutIdType(){
        return relationOutIdType;
    }

}
