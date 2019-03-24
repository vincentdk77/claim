package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrationlimit定额保单限额免赔对照表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationLimitDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性限额/免赔级别 */
    private String limitGrade = "";
    /** 属性限额/免赔类别代码 */
    private String limitCode = "";
    /** 属性定额类型代码 */
    private String rationType = "";
    /** 属性标的类别 */
    private String itemCode = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性投保方式/责任分类 */
    private String modeCode = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性赔偿限额 */
    private double limitFee = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrationLimitDtoBase对象
     */
    public PrpDrationLimitDtoBase(){
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
     * 设置属性限额/免赔级别
     * @param limitGrade 待设置的属性限额/免赔级别的值
     */
    public void setLimitGrade(String limitGrade){
        this.limitGrade = StringUtils.rightTrim(limitGrade);
    }

    /**
     * 获取属性限额/免赔级别
     * @return 属性限额/免赔级别的值
     */
    public String getLimitGrade(){
        return limitGrade;
    }

    /**
     * 设置属性限额/免赔类别代码
     * @param limitCode 待设置的属性限额/免赔类别代码的值
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * 获取属性限额/免赔类别代码
     * @return 属性限额/免赔类别代码的值
     */
    public String getLimitCode(){
        return limitCode;
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
     * 设置属性投保方式/责任分类
     * @param modeCode 待设置的属性投保方式/责任分类的值
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * 获取属性投保方式/责任分类
     * @return 属性投保方式/责任分类的值
     */
    public String getModeCode(){
        return modeCode;
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
     * 设置属性赔偿限额
     * @param limitFee 待设置的属性赔偿限额的值
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * 获取属性赔偿限额
     * @return 属性赔偿限额的值
     */
    public double getLimitFee(){
        return limitFee;
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
