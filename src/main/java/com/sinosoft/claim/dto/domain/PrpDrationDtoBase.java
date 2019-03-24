package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdration定额保单标的险别代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性定额类型代码 */
    private String rationType = "";
    /** 属性定额类型名称 */
    private String rationName = "";
    /** 属性标的类别 */
    private String itemCode = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性保额 */
    private double amount = 0d;
    /** 属性费率 */
    private double rate = 0d;
    /** 属性保费 */
    private double premium = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrationDtoBase对象
     */
    public PrpDrationDtoBase(){
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性定额类型代码
     * @param rationType 待设置的属性定额类型代码的值
     */
    public void setRationType(String rationType){
        this.rationType = StringUtils.rightTrim(rationType);
    }

    /**
     * 获取属性定额类型代码
     * @return 属性定额类型代码的值
     */
    public String getRationType(){
        return rationType;
    }

    /**
     * 设置属性定额类型名称
     * @param rationName 待设置的属性定额类型名称的值
     */
    public void setRationName(String rationName){
        this.rationName = StringUtils.rightTrim(rationName);
    }

    /**
     * 获取属性定额类型名称
     * @return 属性定额类型名称的值
     */
    public String getRationName(){
        return rationName;
    }

    /**
     * 设置属性标的类别
     * @param itemCode 待设置的属性标的类别的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的类别
     * @return 属性标的类别的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性保额
     * @param amount 待设置的属性保额的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性保额
     * @return 属性保额的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性费率
     * @param rate 待设置的属性费率的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性费率
     * @return 属性费率的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性保费
     * @param premium 待设置的属性保费的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性保费
     * @return 属性保费的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
