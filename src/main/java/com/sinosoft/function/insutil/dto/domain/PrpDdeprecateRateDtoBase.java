package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpddeprecaterate的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdeprecateRateDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性clausetype */
    private String clauseType = "";
    /** 属性carkindcode */
    private String carKindCode = "";
    /** 属性carkindname */
    private String carKindName = "";
    /** 属性peryearrate */
    private double perYearRate = 0d;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDdeprecateRateDtoBase对象
     */
    public PrpDdeprecateRateDtoBase(){
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
     * 设置属性clausetype
     * @param clauseType 待设置的属性clausetype的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性clausetype
     * @return 属性clausetype的值
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * 设置属性carkindcode
     * @param carKindCode 待设置的属性carkindcode的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性carkindcode
     * @return 属性carkindcode的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性carkindname
     * @param carKindName 待设置的属性carkindname的值
     */
    public void setCarKindName(String carKindName){
        this.carKindName = StringUtils.rightTrim(carKindName);
    }

    /**
     * 获取属性carkindname
     * @return 属性carkindname的值
     */
    public String getCarKindName(){
        return carKindName;
    }

    /**
     * 设置属性peryearrate
     * @param perYearRate 待设置的属性peryearrate的值
     */
    public void setPerYearRate(double perYearRate){
        this.perYearRate = perYearRate;
    }

    /**
     * 获取属性peryearrate
     * @return 属性peryearrate的值
     */
    public double getPerYearRate(){
        return perYearRate;
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
