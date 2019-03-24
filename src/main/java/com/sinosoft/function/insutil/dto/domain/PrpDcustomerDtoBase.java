package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcustomer的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerDtoBase implements Serializable{
    /** 属性customertype */
    private String customerType = "";
    /** 属性customercode */
    private String customerCode = "";
    /** 属性shorthandcode */
    private String shortHandCode = "";
    /** 属性customercname */
    private String customerCName = "";
    /** 属性customerename */
    private String customerEName = "";
    /** 属性addresscname */
    private String addressCName = "";
    /** 属性addressename */
    private String addressEName = "";
    /** 属性organizecode */
    private String organizeCode = "";
    /** 属性fathercode */
    private String fatherCode = "";
    /** 属性blackstate */
    private String blackState = "";
    /** 属性customerkind */
    private String customerKind = "";
    /** 属性customerflag */
    private String customerFlag = "";
    /** 属性articlecode */
    private String articleCode = "";
    /** 属性validstatus */
    private String validStatus = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcustomerDtoBase对象
     */
    public PrpDcustomerDtoBase(){
    }

    /**
     * 设置属性customertype
     * @param customerType 待设置的属性customertype的值
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * 获取属性customertype
     * @return 属性customertype的值
     */
    public String getCustomerType(){
        return customerType;
    }

    /**
     * 设置属性customercode
     * @param customerCode 待设置的属性customercode的值
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * 获取属性customercode
     * @return 属性customercode的值
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * 设置属性shorthandcode
     * @param shortHandCode 待设置的属性shorthandcode的值
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * 获取属性shorthandcode
     * @return 属性shorthandcode的值
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * 设置属性customercname
     * @param customerCName 待设置的属性customercname的值
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * 获取属性customercname
     * @return 属性customercname的值
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * 设置属性customerename
     * @param customerEName 待设置的属性customerename的值
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * 获取属性customerename
     * @return 属性customerename的值
     */
    public String getCustomerEName(){
        return customerEName;
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
     * 设置属性organizecode
     * @param organizeCode 待设置的属性organizecode的值
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * 获取属性organizecode
     * @return 属性organizecode的值
     */
    public String getOrganizeCode(){
        return organizeCode;
    }

    /**
     * 设置属性fathercode
     * @param fatherCode 待设置的属性fathercode的值
     */
    public void setFatherCode(String fatherCode){
        this.fatherCode = StringUtils.rightTrim(fatherCode);
    }

    /**
     * 获取属性fathercode
     * @return 属性fathercode的值
     */
    public String getFatherCode(){
        return fatherCode;
    }

    /**
     * 设置属性blackstate
     * @param blackState 待设置的属性blackstate的值
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * 获取属性blackstate
     * @return 属性blackstate的值
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * 设置属性customerkind
     * @param customerKind 待设置的属性customerkind的值
     */
    public void setCustomerKind(String customerKind){
        this.customerKind = StringUtils.rightTrim(customerKind);
    }

    /**
     * 获取属性customerkind
     * @return 属性customerkind的值
     */
    public String getCustomerKind(){
        return customerKind;
    }

    /**
     * 设置属性customerflag
     * @param customerFlag 待设置的属性customerflag的值
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * 获取属性customerflag
     * @return 属性customerflag的值
     */
    public String getCustomerFlag(){
        return customerFlag;
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
}
