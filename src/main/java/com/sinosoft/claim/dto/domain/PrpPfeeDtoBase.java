package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prppfee批改保额保费变化表的数据传输对象基类<br>
 * 创建于 2004-11-22 15:24:12.828<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPfeeDtoBase implements Serializable{
    /** 属性批单号码 */
    private String endorseNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性保额变化量 */
    private double chgAmount = 0d;
    /** 属性保费变化量 */
    private double chgPremium = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpPfeeDtoBase对象
     */
    public PrpPfeeDtoBase(){
    }

    /**
     * 设置属性批单号码
     * @param endorseNo 待设置的属性批单号码的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号码
     * @return 属性批单号码的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性保额变化量
     * @param chgAmount 待设置的属性保额变化量的值
     */
    public void setChgAmount(double chgAmount){
        this.chgAmount = chgAmount;
    }

    /**
     * 获取属性保额变化量
     * @return 属性保额变化量的值
     */
    public double getChgAmount(){
        return chgAmount;
    }

    /**
     * 设置属性保费变化量
     * @param chgPremium 待设置的属性保费变化量的值
     */
    public void setChgPremium(double chgPremium){
        this.chgPremium = chgPremium;
    }

    /**
     * 获取属性保费变化量
     * @return 属性保费变化量的值
     */
    public double getChgPremium(){
        return chgPremium;
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
