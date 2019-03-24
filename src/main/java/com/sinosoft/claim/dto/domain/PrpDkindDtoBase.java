package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdkind险别代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDkindDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别中文名称 */
    private String kindCName = "";
    /** 属性险别英文名称 */
    private String kindEName = "";
    /** 属性费率代码 */
    private String rateTypeFlag = "";
    /** 属性计入总保额标志 */
    private String calculateFlag = "";
    /** 属性最大浮动比例 */
    private double maxFloatRate = 0d;
    /** 属性最大折扣比例 */
    private double maxDiscountRate = 0d;
    /** 属性新的险别代码 */
    private String newKindCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDkindDtoBase对象
     */
    public PrpDkindDtoBase(){
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
     * 设置属性险别中文名称
     * @param kindCName 待设置的属性险别中文名称的值
     */
    public void setKindCName(String kindCName){
        this.kindCName = StringUtils.rightTrim(kindCName);
    }

    /**
     * 获取属性险别中文名称
     * @return 属性险别中文名称的值
     */
    public String getKindCName(){
        return kindCName;
    }

    /**
     * 设置属性险别英文名称
     * @param kindEName 待设置的属性险别英文名称的值
     */
    public void setKindEName(String kindEName){
        this.kindEName = StringUtils.rightTrim(kindEName);
    }

    /**
     * 获取属性险别英文名称
     * @return 属性险别英文名称的值
     */
    public String getKindEName(){
        return kindEName;
    }

    /**
     * 设置属性费率代码
     * @param rateTypeFlag 待设置的属性费率代码的值
     */
    public void setRateTypeFlag(String rateTypeFlag){
        this.rateTypeFlag = StringUtils.rightTrim(rateTypeFlag);
    }

    /**
     * 获取属性费率代码
     * @return 属性费率代码的值
     */
    public String getRateTypeFlag(){
        return rateTypeFlag;
    }

    /**
     * 设置属性计入总保额标志
     * @param calculateFlag 待设置的属性计入总保额标志的值
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * 获取属性计入总保额标志
     * @return 属性计入总保额标志的值
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * 设置属性最大浮动比例
     * @param maxFloatRate 待设置的属性最大浮动比例的值
     */
    public void setMaxFloatRate(double maxFloatRate){
        this.maxFloatRate = maxFloatRate;
    }

    /**
     * 获取属性最大浮动比例
     * @return 属性最大浮动比例的值
     */
    public double getMaxFloatRate(){
        return maxFloatRate;
    }

    /**
     * 设置属性最大折扣比例
     * @param maxDiscountRate 待设置的属性最大折扣比例的值
     */
    public void setMaxDiscountRate(double maxDiscountRate){
        this.maxDiscountRate = maxDiscountRate;
    }

    /**
     * 获取属性最大折扣比例
     * @return 属性最大折扣比例的值
     */
    public double getMaxDiscountRate(){
        return maxDiscountRate;
    }

    /**
     * 设置属性新的险别代码
     * @param newKindCode 待设置的属性新的险别代码的值
     */
    public void setNewKindCode(String newKindCode){
        this.newKindCode = StringUtils.rightTrim(newKindCode);
    }

    /**
     * 获取属性新的险别代码
     * @return 属性新的险别代码的值
     */
    public String getNewKindCode(){
        return newKindCode;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
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
