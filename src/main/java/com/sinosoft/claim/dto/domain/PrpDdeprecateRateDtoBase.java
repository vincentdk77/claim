package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpddeprecaterate折旧率表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdeprecateRateDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性车辆种类名称 */
    private String carKindName = "";
    /** 属性每年折旧率 */
    private double perYearRate = 0d;
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDdeprecateRateDtoBase对象
     */
    public PrpDdeprecateRateDtoBase(){
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
     * 设置属性条款类别
     * @param clauseType 待设置的属性条款类别的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性条款类别
     * @return 属性条款类别的值
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * 设置属性车辆种类代码
     * @param carKindCode 待设置的属性车辆种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类代码
     * @return 属性车辆种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性车辆种类名称
     * @param carKindName 待设置的属性车辆种类名称的值
     */
    public void setCarKindName(String carKindName){
        this.carKindName = StringUtils.rightTrim(carKindName);
    }

    /**
     * 获取属性车辆种类名称
     * @return 属性车辆种类名称的值
     */
    public String getCarKindName(){
        return carKindName;
    }

    /**
     * 设置属性每年折旧率
     * @param perYearRate 待设置的属性每年折旧率的值
     */
    public void setPerYearRate(double perYearRate){
        this.perYearRate = perYearRate;
    }

    /**
     * 获取属性每年折旧率
     * @return 属性每年折旧率的值
     */
    public double getPerYearRate(){
        return perYearRate;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
