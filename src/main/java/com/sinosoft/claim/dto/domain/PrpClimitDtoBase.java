package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpClimit的数据传输对象基类<br>
 * 创建于 2006-06-09 15:31:28.531<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpClimitDtoBase implements Serializable{
    /** 属性PolicyNo */
    private String policyNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性LimitGrade */
    private String limitGrade = "";
    /** 属性LimitNo */
    private double limitNo = 0d;
    /** 属性LimitType */
    private String limitType = "";
    /** 属性Currency */
    private String currency = "";
    /** 属性LimitFee */
    private double limitFee = 0d;
    /** 属性CalculateFlag */
    private String calculateFlag = "";
    /** 属性LimitFlag */
    private String limitFlag = "";
    /** 属性Flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpClimitDtoBase对象
     */
    public PrpClimitDtoBase(){
    }

    /**
     * 设置属性PolicyNo
     * @param policyNo 待设置的属性PolicyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性PolicyNo
     * @return 属性PolicyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性LimitGrade
     * @param limitGrade 待设置的属性LimitGrade的值
     */
    public void setLimitGrade(String limitGrade){
        this.limitGrade = StringUtils.rightTrim(limitGrade);
    }

    /**
     * 获取属性LimitGrade
     * @return 属性LimitGrade的值
     */
    public String getLimitGrade(){
        return limitGrade;
    }

    /**
     * 设置属性LimitNo
     * @param limitNo 待设置的属性LimitNo的值
     */
    public void setLimitNo(double limitNo){
        this.limitNo = limitNo;
    }

    /**
     * 获取属性LimitNo
     * @return 属性LimitNo的值
     */
    public double getLimitNo(){
        return limitNo;
    }

    /**
     * 设置属性LimitType
     * @param limitType 待设置的属性LimitType的值
     */
    public void setLimitType(String limitType){
        this.limitType = StringUtils.rightTrim(limitType);
    }

    /**
     * 获取属性LimitType
     * @return 属性LimitType的值
     */
    public String getLimitType(){
        return limitType;
    }

    /**
     * 设置属性Currency
     * @param currency 待设置的属性Currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性Currency
     * @return 属性Currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性LimitFee
     * @param limitFee 待设置的属性LimitFee的值
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * 获取属性LimitFee
     * @return 属性LimitFee的值
     */
    public double getLimitFee(){
        return limitFee;
    }

    /**
     * 设置属性CalculateFlag
     * @param calculateFlag 待设置的属性CalculateFlag的值
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * 获取属性CalculateFlag
     * @return 属性CalculateFlag的值
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * 设置属性LimitFlag
     * @param limitFlag 待设置的属性LimitFlag的值
     */
    public void setLimitFlag(String limitFlag){
        this.limitFlag = StringUtils.rightTrim(limitFlag);
    }

    /**
     * 获取属性LimitFlag
     * @return 属性LimitFlag的值
     */
    public String getLimitFlag(){
        return limitFlag;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }
}
