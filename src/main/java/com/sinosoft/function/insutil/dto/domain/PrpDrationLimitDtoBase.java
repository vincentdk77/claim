package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrationlimit的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationLimitDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性limitgrade */
    private String limitGrade = "";
    /** 属性limitcode */
    private String limitCode = "";
    /** 属性rationtype */
    private String rationType = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性itemcode */
    private String itemCode = "";
    /** 属性modecode */
    private String modeCode = "";
    /** 属性currency */
    private String currency = "";
    /** 属性limitfee */
    private double limitFee = 0d;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrationLimitDtoBase对象
     */
    public PrpDrationLimitDtoBase(){
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
     * 设置属性limitgrade
     * @param limitGrade 待设置的属性limitgrade的值
     */
    public void setLimitGrade(String limitGrade){
        this.limitGrade = StringUtils.rightTrim(limitGrade);
    }

    /**
     * 获取属性limitgrade
     * @return 属性limitgrade的值
     */
    public String getLimitGrade(){
        return limitGrade;
    }

    /**
     * 设置属性limitcode
     * @param limitCode 待设置的属性limitcode的值
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * 获取属性limitcode
     * @return 属性limitcode的值
     */
    public String getLimitCode(){
        return limitCode;
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
     * 设置属性modecode
     * @param modeCode 待设置的属性modecode的值
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * 获取属性modecode
     * @return 属性modecode的值
     */
    public String getModeCode(){
        return modeCode;
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
     * 设置属性limitfee
     * @param limitFee 待设置的属性limitfee的值
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * 获取属性limitfee
     * @return 属性limitfee的值
     */
    public double getLimitFee(){
        return limitFee;
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
