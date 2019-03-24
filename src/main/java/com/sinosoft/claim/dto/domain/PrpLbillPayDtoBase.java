package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLbillPay�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLbillPayDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����paymentNo */
    private String paymentNo = "";
    /** ����registNo */
    private String registNo = "";
    /** ����payAmount */
    private double payAmount = 0D;
    /** ����bankType */
    private String bankType = "";
    /** ����bank */
    private String bank = "";
    /** ����accountType */
    private String accountType = "";
    /** ����receiverfullName */
    private String receiverfullName = "";
    /** ����certifType */
    private String certifType = "";
    /** ����address */
    private String address = "";
    /** ����certifNo */
    private String certifNo = "";
    /** ����mobilePhone */
    private String mobilePhone = "";
    /** ����operatorcode */
    private String operatorcode = "";
    /** ����bankAccount */
    private String bankAccount = "";
    /** ����comcode */
    private String comCode = "";
    /** ����provinceName */
    private String provinceName = "";
    /** ����cityName */
    private String cityName = "";
    /** ����accountFlag */
    private String accountFlag = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����strSerialNo*/
    private String strSerialNo = "";
    /** ����strPayAmount*/
    private String strPayAmount = "";
    private String payWay = "";
    private String payReason = "";
    private String payPurpose = "";
    private String routeNum = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLbillPayDtoBase����
     */
    public PrpLbillPayDtoBase(){
    }

    /**
     * ��������paymentNo
     * @param paymentNo �����õ�����paymentNo��ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ����paymentNo
     * @return ����paymentNo��ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������payAmount
     * @param payAmount �����õ�����payAmount��ֵ
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * ��ȡ����payAmount
     * @return ����payAmount��ֵ
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * ��������bankType
     * @param bankType �����õ�����bankType��ֵ
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * ��ȡ����bankType
     * @return ����bankType��ֵ
     */
    public String getBankType(){
        return bankType;
    }

    /**
     * ��������bank
     * @param bank �����õ�����bank��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����bank
     * @return ����bank��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������accountType
     * @param accountType �����õ�����accountType��ֵ
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * ��ȡ����accountType
     * @return ����accountType��ֵ
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * ��������receiverfullName
     * @param receiverfullName �����õ�����receiverfullName��ֵ
     */
    public void setReceiverfullName(String receiverfullName){
        this.receiverfullName = StringUtils.rightTrim(receiverfullName);
    }

    /**
     * ��ȡ����receiverfullName
     * @return ����receiverfullName��ֵ
     */
    public String getReceiverfullName(){
        return receiverfullName;
    }

    /**
     * ��������certifType
     * @param certifType �����õ�����certifType��ֵ
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * ��ȡ����certifType
     * @return ����certifType��ֵ
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * ��������address
     * @param address �����õ�����address��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����address
     * @return ����address��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������certifNo
     * @param certifNo �����õ�����certifNo��ֵ
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * ��ȡ����certifNo
     * @return ����certifNo��ֵ
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * ��������mobilePhone
     * @param mobilePhone �����õ�����mobilePhone��ֵ
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * ��ȡ����mobilePhone
     * @return ����mobilePhone��ֵ
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * ��������operatorcode
     * @param operatorcode �����õ�����operatorcode��ֵ
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * ��ȡ����operatorcode
     * @return ����operatorcode��ֵ
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * ��������bankAccount
     * @param bankAccount �����õ�����bankAccount��ֵ
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * ��ȡ����bankAccount
     * @return ����bankAccount��ֵ
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * ��������comcode
     * @param comcode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������provinceName
     * @param provinceName �����õ�����provinceName��ֵ
     */
    public void setProvinceName(String provinceName){
        this.provinceName = StringUtils.rightTrim(provinceName);
    }

    /**
     * ��ȡ����provinceName
     * @return ����provinceName��ֵ
     */
    public String getProvinceName(){
        return provinceName;
    }

    /**
     * ��������cityName
     * @param cityName �����õ�����cityName��ֵ
     */
    public void setCityName(String cityName){
        this.cityName = StringUtils.rightTrim(cityName);
    }

    /**
     * ��ȡ����cityName
     * @return ����cityName��ֵ
     */
    public String getCityName(){
        return cityName;
    }

    /**
     * ��������accountFlag
     * @param accountFlag �����õ�����accountFlag��ֵ
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * ��ȡ����accountFlag
     * @return ����accountFlag��ֵ
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

	public String getStrSerialNo() {
		return strSerialNo;
	}

	public void setStrSerialNo(String strSerialNo) {
		this.strSerialNo = strSerialNo;
	}

	public String getStrPayAmount() {
		return strPayAmount;
	}

	public void setStrPayAmount(String strPayAmount) {
		this.strPayAmount = strPayAmount;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayReason() {
		return payReason;
	}

	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}

	public String getPayPurpose() {
		return payPurpose;
	}

	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	}

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}
	
}
