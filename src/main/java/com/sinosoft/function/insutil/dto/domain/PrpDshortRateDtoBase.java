package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdshortrate的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshortRateDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性months */
    private int months = 0;
    /** 属性shortrate */
    private double shortRate = 0d;
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDshortRateDtoBase对象
     */
    public PrpDshortRateDtoBase(){
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
     * 设置属性months
     * @param months 待设置的属性months的值
     */
    public void setMonths(int months){
        this.months = months;
    }

    /**
     * 获取属性months
     * @return 属性months的值
     */
    public int getMonths(){
        return months;
    }

    /**
     * 设置属性shortrate
     * @param shortRate 待设置的属性shortrate的值
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * 获取属性shortrate
     * @return 属性shortrate的值
     */
    public double getShortRate(){
        return shortRate;
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
