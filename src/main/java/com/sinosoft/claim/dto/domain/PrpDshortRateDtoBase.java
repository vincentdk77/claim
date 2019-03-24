package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdshortrate月短期费率表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshortRateDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性月份数 */
    private int months = 0;
    /** 属性费率 */
    private double shortRate = 0d;
    /** 属性状态 */
    private String validStatus = "";
    /** 属性状态位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDshortRateDtoBase对象
     */
    public PrpDshortRateDtoBase(){
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
     * 设置属性月份数
     * @param months 待设置的属性月份数的值
     */
    public void setMonths(int months){
        this.months = months;
    }

    /**
     * 获取属性月份数
     * @return 属性月份数的值
     */
    public int getMonths(){
        return months;
    }

    /**
     * 设置属性费率
     * @param shortRate 待设置的属性费率的值
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * 获取属性费率
     * @return 属性费率的值
     */
    public double getShortRate(){
        return shortRate;
    }

    /**
     * 设置属性状态
     * @param validStatus 待设置的属性状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性状态
     * @return 属性状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性状态位
     * @param flag 待设置的属性状态位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性状态位
     * @return 属性状态位的值
     */
    public String getFlag(){
        return flag;
    }
}
