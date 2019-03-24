package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdration的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性rationtype */
    private String rationType = "";
    /** 属性rationname */
    private String rationName = "";
    /** 属性itemcode */
    private String itemCode = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性currency */
    private String currency = "";
    /** 属性amount */
    private double amount = 0d;
    /** 属性rate */
    private double rate = 0d;
    /** 属性premium */
    private double premium = 0d;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrationDtoBase对象
     */
    public PrpDrationDtoBase(){
    }

    /**
     * 设置属性riskcode
     * @param riskCode 待设置的属性riskcode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskcode
     * @return 属性riskcode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性rationtype
     * @param rationType 待设置的属性rationtype的值
     */
    public void setRationType(String rationType){
        this.rationType = StringUtils.rightTrim(rationType);
    }

    /**
     * 获取属性rationtype
     * @return 属性rationtype的值
     */
    public String getRationType(){
        return rationType;
    }

    /**
     * 设置属性rationname
     * @param rationName 待设置的属性rationname的值
     */
    public void setRationName(String rationName){
        this.rationName = StringUtils.rightTrim(rationName);
    }

    /**
     * 获取属性rationname
     * @return 属性rationname的值
     */
    public String getRationName(){
        return rationName;
    }

    /**
     * 设置属性itemcode
     * @param itemCode 待设置的属性itemcode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性itemcode
     * @return 属性itemcode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性kindcode
     * @param kindCode 待设置的属性kindcode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性kindcode
     * @return 属性kindcode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性currency
     * @param currency 待设置的属性currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性currency
     * @return 属性currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性amount
     * @param amount 待设置的属性amount的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性amount
     * @return 属性amount的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性rate
     * @param rate 待设置的属性rate的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性rate
     * @return 属性rate的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性premium
     * @param premium 待设置的属性premium的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性premium
     * @return 属性premium的值
     */
    public double getPremium(){
        return premium;
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
