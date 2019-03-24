package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpDcompany机构代码表的数据传输对象基类<br>
 * 创建于 2004-11-09 18:30:39.076<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcompanyDtoBase implements Serializable{
    /** 属性ComCode */
    private String comCode = "";
    /** 属性ComCName */
    private String comCName = "";
    /** 属性ComEName */
    private String comEName = "";
    /** 属性AddressCName */
    private String addressCName = "";
    /** 属性AddressEName */
    private String addressEName = "";
    /** 属性PostCode */
    private String postCode = "";
    /** 属性PhoneNumber */
    private String phoneNumber = "";
    /** 属性FaxNumber */
    private String faxNumber = "";
    /** 属性TaxNumber */
    private String taxNumber = "";
    /** 属性UpperComCode */
    private String upperComCode = "";
    /** 属性InsurerName */
    private String insurerName = "";
    /** 属性ComAttribute */
    private String comAttribute = "";
    /** 属性Manager */
    private String manager = "";
    /** 属性AccountLeader */
    private String accountLeader = "";
    /** 属性Cashier */
    private String cashier = "";
    /** 属性ComType */
    private String comType = "";
    /** 属性ComLevel */
    private String comLevel = "";
    /** 属性Accountant */
    private String accountant = "";
    /** 属性Remark */
    private String remark = "";
    /** 属性NewComCode */
    private String newComCode = "";
    /** 属性ValidStatus */
    private String validStatus = "";
    /** 属性AcntUnit */
    private String acntUnit = "";
    /** 属性ArticleCode */
    private String articleCode = "";
    /** 属性AccCode */
    private String accCode = "";
    /** 属性CenterFlag */
    private String centerFlag = "";
    /** 属性OuterPayCode */
    private String outerPayCode = "";
    /** 属性InnerPayCode */
    private String innerPayCode = "";
    /** 属性Flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcompanyDtoBase对象
     */
    public PrpDcompanyDtoBase(){
    }

    /**
     * 设置属性ComCode
     * @param comCode 待设置的属性ComCode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性ComCode
     * @return 属性ComCode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性ComCName
     * @param comCName 待设置的属性ComCName的值
     */
    public void setComCName(String comCName){
        this.comCName = StringUtils.rightTrim(comCName);
    }

    /**
     * 获取属性ComCName
     * @return 属性ComCName的值
     */
    public String getComCName(){
        return comCName;
    }

    /**
     * 设置属性ComEName
     * @param comEName 待设置的属性ComEName的值
     */
    public void setComEName(String comEName){
        this.comEName = StringUtils.rightTrim(comEName);
    }

    /**
     * 获取属性ComEName
     * @return 属性ComEName的值
     */
    public String getComEName(){
        return comEName;
    }

    /**
     * 设置属性AddressCName
     * @param addressCName 待设置的属性AddressCName的值
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * 获取属性AddressCName
     * @return 属性AddressCName的值
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * 设置属性AddressEName
     * @param addressEName 待设置的属性AddressEName的值
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * 获取属性AddressEName
     * @return 属性AddressEName的值
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * 设置属性PostCode
     * @param postCode 待设置的属性PostCode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性PostCode
     * @return 属性PostCode的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性PhoneNumber
     * @param phoneNumber 待设置的属性PhoneNumber的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性PhoneNumber
     * @return 属性PhoneNumber的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性FaxNumber
     * @param faxNumber 待设置的属性FaxNumber的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性FaxNumber
     * @return 属性FaxNumber的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性TaxNumber
     * @param taxNumber 待设置的属性TaxNumber的值
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = StringUtils.rightTrim(taxNumber);
    }

    /**
     * 获取属性TaxNumber
     * @return 属性TaxNumber的值
     */
    public String getTaxNumber(){
        return taxNumber;
    }

    /**
     * 设置属性UpperComCode
     * @param upperComCode 待设置的属性UpperComCode的值
     */
    public void setUpperComCode(String upperComCode){
        this.upperComCode = StringUtils.rightTrim(upperComCode);
    }

    /**
     * 获取属性UpperComCode
     * @return 属性UpperComCode的值
     */
    public String getUpperComCode(){
        return upperComCode;
    }

    /**
     * 设置属性InsurerName
     * @param insurerName 待设置的属性InsurerName的值
     */
    public void setInsurerName(String insurerName){
        this.insurerName = StringUtils.rightTrim(insurerName);
    }

    /**
     * 获取属性InsurerName
     * @return 属性InsurerName的值
     */
    public String getInsurerName(){
        return insurerName;
    }

    /**
     * 设置属性ComAttribute
     * @param comAttribute 待设置的属性ComAttribute的值
     */
    public void setComAttribute(String comAttribute){
        this.comAttribute = StringUtils.rightTrim(comAttribute);
    }

    /**
     * 获取属性ComAttribute
     * @return 属性ComAttribute的值
     */
    public String getComAttribute(){
        return comAttribute;
    }

    /**
     * 设置属性Manager
     * @param manager 待设置的属性Manager的值
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * 获取属性Manager
     * @return 属性Manager的值
     */
    public String getManager(){
        return manager;
    }

    /**
     * 设置属性AccountLeader
     * @param accountLeader 待设置的属性AccountLeader的值
     */
    public void setAccountLeader(String accountLeader){
        this.accountLeader = StringUtils.rightTrim(accountLeader);
    }

    /**
     * 获取属性AccountLeader
     * @return 属性AccountLeader的值
     */
    public String getAccountLeader(){
        return accountLeader;
    }

    /**
     * 设置属性Cashier
     * @param cashier 待设置的属性Cashier的值
     */
    public void setCashier(String cashier){
        this.cashier = StringUtils.rightTrim(cashier);
    }

    /**
     * 获取属性Cashier
     * @return 属性Cashier的值
     */
    public String getCashier(){
        return cashier;
    }

    /**
     * 设置属性ComType
     * @param comType 待设置的属性ComType的值
     */
    public void setComType(String comType){
        this.comType = StringUtils.rightTrim(comType);
    }

    /**
     * 获取属性ComType
     * @return 属性ComType的值
     */
    public String getComType(){
        return comType;
    }

    /**
     * 设置属性ComLevel
     * @param comLevel 待设置的属性ComLevel的值
     */
    public void setComLevel(String comLevel){
        this.comLevel = StringUtils.rightTrim(comLevel);
    }

    /**
     * 获取属性ComLevel
     * @return 属性ComLevel的值
     */
    public String getComLevel(){
        return comLevel;
    }

    /**
     * 设置属性Accountant
     * @param accountant 待设置的属性Accountant的值
     */
    public void setAccountant(String accountant){
        this.accountant = StringUtils.rightTrim(accountant);
    }

    /**
     * 获取属性Accountant
     * @return 属性Accountant的值
     */
    public String getAccountant(){
        return accountant;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性NewComCode
     * @param newComCode 待设置的属性NewComCode的值
     */
    public void setNewComCode(String newComCode){
        this.newComCode = StringUtils.rightTrim(newComCode);
    }

    /**
     * 获取属性NewComCode
     * @return 属性NewComCode的值
     */
    public String getNewComCode(){
        return newComCode;
    }

    /**
     * 设置属性ValidStatus
     * @param validStatus 待设置的属性ValidStatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性ValidStatus
     * @return 属性ValidStatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性AcntUnit
     * @param acntUnit 待设置的属性AcntUnit的值
     */
    public void setAcntUnit(String acntUnit){
        this.acntUnit = StringUtils.rightTrim(acntUnit);
    }

    /**
     * 获取属性AcntUnit
     * @return 属性AcntUnit的值
     */
    public String getAcntUnit(){
        return acntUnit;
    }

    /**
     * 设置属性ArticleCode
     * @param articleCode 待设置的属性ArticleCode的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性ArticleCode
     * @return 属性ArticleCode的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性AccCode
     * @param accCode 待设置的属性AccCode的值
     */
    public void setAccCode(String accCode){
        this.accCode = StringUtils.rightTrim(accCode);
    }

    /**
     * 获取属性AccCode
     * @return 属性AccCode的值
     */
    public String getAccCode(){
        return accCode;
    }

    /**
     * 设置属性CenterFlag
     * @param centerFlag 待设置的属性CenterFlag的值
     */
    public void setCenterFlag(String centerFlag){
        this.centerFlag = StringUtils.rightTrim(centerFlag);
    }

    /**
     * 获取属性CenterFlag
     * @return 属性CenterFlag的值
     */
    public String getCenterFlag(){
        return centerFlag;
    }

    /**
     * 设置属性OuterPayCode
     * @param outerPayCode 待设置的属性OuterPayCode的值
     */
    public void setOuterPayCode(String outerPayCode){
        this.outerPayCode = StringUtils.rightTrim(outerPayCode);
    }

    /**
     * 获取属性OuterPayCode
     * @return 属性OuterPayCode的值
     */
    public String getOuterPayCode(){
        return outerPayCode;
    }

    /**
     * 设置属性InnerPayCode
     * @param innerPayCode 待设置的属性InnerPayCode的值
     */
    public void setInnerPayCode(String innerPayCode){
        this.innerPayCode = StringUtils.rightTrim(innerPayCode);
    }

    /**
     * 获取属性InnerPayCode
     * @return 属性InnerPayCode的值
     */
    public String getInnerPayCode(){
        return innerPayCode;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }
}
