package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLbillPay的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLbillPayDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性paymentNo */
    private String paymentNo = "";
    /** 属性registNo */
    private String registNo = "";
    /** 属性payAmount */
    private double payAmount = 0D;
    /** 属性bankType */
    private String bankType = "";
    /** 属性bank */
    private String bank = "";
    /** 属性accountType */
    private String accountType = "";
    /** 属性receiverfullName */
    private String receiverfullName = "";
    /** 属性certifType */
    private String certifType = "";
    /** 属性address */
    private String address = "";
    /** 属性certifNo */
    private String certifNo = "";
    /** 属性mobilePhone */
    private String mobilePhone = "";
    /** 属性operatorcode */
    private String operatorcode = "";
    /** 属性bankAccount */
    private String bankAccount = "";
    /** 属性comcode */
    private String comCode = "";
    /** 属性provinceName */
    private String provinceName = "";
    /** 属性cityName */
    private String cityName = "";
    /** 属性accountFlag */
    private String accountFlag = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性strSerialNo*/
    private String strSerialNo = "";
    /** 属性strPayAmount*/
    private String strPayAmount = "";
    private String payWay = "";
    private String payReason = "";
    private String payPurpose = "";
    private String routeNum = "";
    /**
     *  默认构造方法,构造一个默认的PrpLbillPayDtoBase对象
     */
    public PrpLbillPayDtoBase(){
    }

    /**
     * 设置属性paymentNo
     * @param paymentNo 待设置的属性paymentNo的值
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * 获取属性paymentNo
     * @return 属性paymentNo的值
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性payAmount
     * @param payAmount 待设置的属性payAmount的值
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * 获取属性payAmount
     * @return 属性payAmount的值
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * 设置属性bankType
     * @param bankType 待设置的属性bankType的值
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * 获取属性bankType
     * @return 属性bankType的值
     */
    public String getBankType(){
        return bankType;
    }

    /**
     * 设置属性bank
     * @param bank 待设置的属性bank的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性bank
     * @return 属性bank的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性accountType
     * @param accountType 待设置的属性accountType的值
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * 获取属性accountType
     * @return 属性accountType的值
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * 设置属性receiverfullName
     * @param receiverfullName 待设置的属性receiverfullName的值
     */
    public void setReceiverfullName(String receiverfullName){
        this.receiverfullName = StringUtils.rightTrim(receiverfullName);
    }

    /**
     * 获取属性receiverfullName
     * @return 属性receiverfullName的值
     */
    public String getReceiverfullName(){
        return receiverfullName;
    }

    /**
     * 设置属性certifType
     * @param certifType 待设置的属性certifType的值
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * 获取属性certifType
     * @return 属性certifType的值
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * 设置属性address
     * @param address 待设置的属性address的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性address
     * @return 属性address的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性certifNo
     * @param certifNo 待设置的属性certifNo的值
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * 获取属性certifNo
     * @return 属性certifNo的值
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * 设置属性mobilePhone
     * @param mobilePhone 待设置的属性mobilePhone的值
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * 获取属性mobilePhone
     * @return 属性mobilePhone的值
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * 设置属性operatorcode
     * @param operatorcode 待设置的属性operatorcode的值
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * 获取属性operatorcode
     * @return 属性operatorcode的值
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * 设置属性bankAccount
     * @param bankAccount 待设置的属性bankAccount的值
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * 获取属性bankAccount
     * @return 属性bankAccount的值
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * 设置属性comcode
     * @param comcode 待设置的属性comcode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comcode
     * @return 属性comcode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性provinceName
     * @param provinceName 待设置的属性provinceName的值
     */
    public void setProvinceName(String provinceName){
        this.provinceName = StringUtils.rightTrim(provinceName);
    }

    /**
     * 获取属性provinceName
     * @return 属性provinceName的值
     */
    public String getProvinceName(){
        return provinceName;
    }

    /**
     * 设置属性cityName
     * @param cityName 待设置的属性cityName的值
     */
    public void setCityName(String cityName){
        this.cityName = StringUtils.rightTrim(cityName);
    }

    /**
     * 获取属性cityName
     * @return 属性cityName的值
     */
    public String getCityName(){
        return cityName;
    }

    /**
     * 设置属性accountFlag
     * @param accountFlag 待设置的属性accountFlag的值
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * 获取属性accountFlag
     * @return 属性accountFlag的值
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
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
