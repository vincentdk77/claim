package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrplPayeeInfo的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrplPayeeInfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性receiverFullName */
    private String receiverFullName = "";
    /** 属性receiverTypeOther */
    private String receiverTypeOther = "";
    /** 属性receiverTypeOtherName */
    private String receiverTypeOtherName = "";
    /** 属性certifNo */
    private String certifNo = "";
    /** 属性certifType */
    private String certifType = "";
    /** 属性bank */
    private String bank = "";
    /** 属性bankAccount */
    private String bankAccount = "";
    /** 属性bankType */
    private String bankType = "";
    /** 属性accountFlag */
    private String accountFlag = "";
    /** 属性accountType */
    private String accountType = "";
    /** 属性routeNum */
    private String routeNum = "";
    /** 属性city */
    private String city = "";
    /** 属性province */
    private String province = "";
    /** 属性mobilePhone */
    private String mobilePhone = "";
    /** 属性inputDate */
    private String inputDate = "";

    /**
     *  默认构造方法,构造一个默认的PrplPayeeInfoDtoBase对象
     */
    public PrplPayeeInfoDtoBase(){
    }

    /**
     * 设置属性receiverFullName
     * @param receiverFullName 待设置的属性receiverFullName的值
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * 获取属性receiverFullName
     * @return 属性receiverFullName的值
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * 设置属性receiverTypeOther
     * @param receiverTypeOther 待设置的属性receiverTypeOther的值
     */
    public void setReceiverTypeOther(String receiverTypeOther){
        this.receiverTypeOther = StringUtils.rightTrim(receiverTypeOther);
    }

    /**
     * 获取属性receiverTypeOther
     * @return 属性receiverTypeOther的值
     */
    public String getReceiverTypeOther(){
        return receiverTypeOther;
    }

    /**
     * 设置属性receiverTypeOtherName
     * @param receiverTypeOtherName 待设置的属性receiverTypeOtherName的值
     */
    public void setReceiverTypeOtherName(String receiverTypeOtherName){
        this.receiverTypeOtherName = StringUtils.rightTrim(receiverTypeOtherName);
    }

    /**
     * 获取属性receiverTypeOtherName
     * @return 属性receiverTypeOtherName的值
     */
    public String getReceiverTypeOtherName(){
        return receiverTypeOtherName;
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
     * 设置属性routeNum
     * @param routeNum 待设置的属性routeNum的值
     */
    public void setRouteNum(String routeNum){
        this.routeNum = StringUtils.rightTrim(routeNum);
    }

    /**
     * 获取属性routeNum
     * @return 属性routeNum的值
     */
    public String getRouteNum(){
        return routeNum;
    }

    /**
     * 设置属性city
     * @param city 待设置的属性city的值
     */
    public void setCity(String city){
        this.city = StringUtils.rightTrim(city);
    }

    /**
     * 获取属性city
     * @return 属性city的值
     */
    public String getCity(){
        return city;
    }

    /**
     * 设置属性province
     * @param province 待设置的属性province的值
     */
    public void setProvince(String province){
        this.province = StringUtils.rightTrim(province);
    }

    /**
     * 获取属性province
     * @return 属性province的值
     */
    public String getProvince(){
        return province;
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

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
}
