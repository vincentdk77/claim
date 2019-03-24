package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcompany的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcompanyDtoBase implements Serializable{
    /** 属性comcode */
    private String comCode = "";
    /** 属性comcname */
    private String comCName = "";
    /** 属性comename */
    private String comEName = "";
    /** 属性addresscname */
    private String addressCName = "";
    /** 属性addressename */
    private String addressEName = "";
    /** 属性postcode */
    private String postCode = "";
    /** 属性phonenumber */
    private String phoneNumber = "";
    /** 属性税号 */
    private String taxNumber = "";
    /** 属性faxnumber */
    private String faxNumber = "";
    /** 属性uppercomcode */
    private String upperComCode = "";
    /** 属性insurername */
    private String insurerName = "";
    /** 属性单位性质 */
    private String comAttribute = "";
    /** 属性comtype */
    private String comType = "";
    /** 属性comlevel */
    private String comLevel = "";
    /** 属性manager */
    private String manager = "";
    /** 属性财务领导 */
    private String accountLeader = "";
    /** 属性出纳员 */
    private String cashier = "";
    /** 属性accountant */
    private String accountant = "";
    /** 属性remark */
    private String remark = "";
    /** 属性newcomcode */
    private String newComCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性acntunit */
    private String acntUnit = "";
    /** 属性articlecode */
    private String articleCode = "";
    /** 属性acccode */
    private String accCode = "";
    /** 属性核算单位标志 */
    private String centerFlag = "";
    /** 属性OuterPayCode */
    private String outerPayCode = "";
    /** 属性InnerPayCode */
    private String innerPayCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcompanyDtoBase对象
     */
    public PrpDcompanyDtoBase(){
    }

    /**
     * 设置属性comcode
     * @param comCode 待设置的属性comcode的值
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
     * 设置属性comcname
     * @param comCName 待设置的属性comcname的值
     */
    public void setComCName(String comCName){
        this.comCName = StringUtils.rightTrim(comCName);
    }

    /**
     * 获取属性comcname
     * @return 属性comcname的值
     */
    public String getComCName(){
        return comCName;
    }

    /**
     * 设置属性comename
     * @param comEName 待设置的属性comename的值
     */
    public void setComEName(String comEName){
        this.comEName = StringUtils.rightTrim(comEName);
    }

    /**
     * 获取属性comename
     * @return 属性comename的值
     */
    public String getComEName(){
        return comEName;
    }

    /**
     * 设置属性addresscname
     * @param addressCName 待设置的属性addresscname的值
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * 获取属性addresscname
     * @return 属性addresscname的值
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * 设置属性addressename
     * @param addressEName 待设置的属性addressename的值
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * 获取属性addressename
     * @return 属性addressename的值
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * 设置属性postcode
     * @param postCode 待设置的属性postcode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性postcode
     * @return 属性postcode的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性phonenumber
     * @param phoneNumber 待设置的属性phonenumber的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性phonenumber
     * @return 属性phonenumber的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性税号
     * @param taxNumber 待设置的属性税号的值
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = StringUtils.rightTrim(taxNumber);
    }

    /**
     * 获取属性税号
     * @return 属性税号的值
     */
    public String getTaxNumber(){
        return taxNumber;
    }

    /**
     * 设置属性faxnumber
     * @param faxNumber 待设置的属性faxnumber的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性faxnumber
     * @return 属性faxnumber的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性uppercomcode
     * @param upperComCode 待设置的属性uppercomcode的值
     */
    public void setUpperComCode(String upperComCode){
        this.upperComCode = StringUtils.rightTrim(upperComCode);
    }

    /**
     * 获取属性uppercomcode
     * @return 属性uppercomcode的值
     */
    public String getUpperComCode(){
        return upperComCode;
    }

    /**
     * 设置属性insurername
     * @param insurerName 待设置的属性insurername的值
     */
    public void setInsurerName(String insurerName){
        this.insurerName = StringUtils.rightTrim(insurerName);
    }

    /**
     * 获取属性insurername
     * @return 属性insurername的值
     */
    public String getInsurerName(){
        return insurerName;
    }

    /**
     * 设置属性单位性质
     * @param comAttribute 待设置的属性单位性质的值
     */
    public void setComAttribute(String comAttribute){
        this.comAttribute = StringUtils.rightTrim(comAttribute);
    }

    /**
     * 获取属性单位性质
     * @return 属性单位性质的值
     */
    public String getComAttribute(){
        return comAttribute;
    }

    /**
     * 设置属性comtype
     * @param comType 待设置的属性comtype的值
     */
    public void setComType(String comType){
        this.comType = StringUtils.rightTrim(comType);
    }

    /**
     * 获取属性comtype
     * @return 属性comtype的值
     */
    public String getComType(){
        return comType;
    }

    /**
     * 设置属性comlevel
     * @param comLevel 待设置的属性comlevel的值
     */
    public void setComLevel(String comLevel){
        this.comLevel = StringUtils.rightTrim(comLevel);
    }

    /**
     * 获取属性comlevel
     * @return 属性comlevel的值
     */
    public String getComLevel(){
        return comLevel;
    }

    /**
     * 设置属性manager
     * @param manager 待设置的属性manager的值
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * 获取属性manager
     * @return 属性manager的值
     */
    public String getManager(){
        return manager;
    }

    /**
     * 设置属性财务领导
     * @param accountLeader 待设置的属性财务领导的值
     */
    public void setAccountLeader(String accountLeader){
        this.accountLeader = StringUtils.rightTrim(accountLeader);
    }

    /**
     * 获取属性财务领导
     * @return 属性财务领导的值
     */
    public String getAccountLeader(){
        return accountLeader;
    }

    /**
     * 设置属性出纳员
     * @param cashier 待设置的属性出纳员的值
     */
    public void setCashier(String cashier){
        this.cashier = StringUtils.rightTrim(cashier);
    }

    /**
     * 获取属性出纳员
     * @return 属性出纳员的值
     */
    public String getCashier(){
        return cashier;
    }

    /**
     * 设置属性accountant
     * @param accountant 待设置的属性accountant的值
     */
    public void setAccountant(String accountant){
        this.accountant = StringUtils.rightTrim(accountant);
    }

    /**
     * 获取属性accountant
     * @return 属性accountant的值
     */
    public String getAccountant(){
        return accountant;
    }

    /**
     * 设置属性remark
     * @param remark 待设置的属性remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性remark
     * @return 属性remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性newcomcode
     * @param newComCode 待设置的属性newcomcode的值
     */
    public void setNewComCode(String newComCode){
        this.newComCode = StringUtils.rightTrim(newComCode);
    }

    /**
     * 获取属性newcomcode
     * @return 属性newcomcode的值
     */
    public String getNewComCode(){
        return newComCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性acntunit
     * @param acntUnit 待设置的属性acntunit的值
     */
    public void setAcntUnit(String acntUnit){
        this.acntUnit = StringUtils.rightTrim(acntUnit);
    }

    /**
     * 获取属性acntunit
     * @return 属性acntunit的值
     */
    public String getAcntUnit(){
        return acntUnit;
    }

    /**
     * 设置属性articlecode
     * @param articleCode 待设置的属性articlecode的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性articlecode
     * @return 属性articlecode的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性acccode
     * @param accCode 待设置的属性acccode的值
     */
    public void setAccCode(String accCode){
        this.accCode = StringUtils.rightTrim(accCode);
    }

    /**
     * 获取属性acccode
     * @return 属性acccode的值
     */
    public String getAccCode(){
        return accCode;
    }

    /**
     * 设置属性核算单位标志
     * @param centerFlag 待设置的属性核算单位标志的值
     */
    public void setCenterFlag(String centerFlag){
        this.centerFlag = StringUtils.rightTrim(centerFlag);
    }

    /**
     * 获取属性核算单位标志
     * @return 属性核算单位标志的值
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
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
