package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdinvest投资型险种投资信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDinvestDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性投资类型代码 */
    private String investType = "";
    /** 属性投资类型名称 */
    private String investName = "";
    /** 属性每份总保额 */
    private double unitAmount = 0d;
    /** 属性每份总保费 */
    private double unitPremium = 0d;
    /** 属性每份总投资金 */
    private double unitInvestment = 0d;
    /** 属性收益率 */
    private double interestRate = 0d;
    /** 属性投保年限 */
    private int investYear = 0;
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDinvestDtoBase对象
     */
    public PrpDinvestDtoBase(){
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
     * 设置属性投资类型代码
     * @param investType 待设置的属性投资类型代码的值
     */
    public void setInvestType(String investType){
        this.investType = StringUtils.rightTrim(investType);
    }

    /**
     * 获取属性投资类型代码
     * @return 属性投资类型代码的值
     */
    public String getInvestType(){
        return investType;
    }

    /**
     * 设置属性投资类型名称
     * @param investName 待设置的属性投资类型名称的值
     */
    public void setInvestName(String investName){
        this.investName = StringUtils.rightTrim(investName);
    }

    /**
     * 获取属性投资类型名称
     * @return 属性投资类型名称的值
     */
    public String getInvestName(){
        return investName;
    }

    /**
     * 设置属性每份总保额
     * @param unitAmount 待设置的属性每份总保额的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性每份总保额
     * @return 属性每份总保额的值
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * 设置属性每份总保费
     * @param unitPremium 待设置的属性每份总保费的值
     */
    public void setUnitPremium(double unitPremium){
        this.unitPremium = unitPremium;
    }

    /**
     * 获取属性每份总保费
     * @return 属性每份总保费的值
     */
    public double getUnitPremium(){
        return unitPremium;
    }

    /**
     * 设置属性每份总投资金
     * @param unitInvestment 待设置的属性每份总投资金的值
     */
    public void setUnitInvestment(double unitInvestment){
        this.unitInvestment = unitInvestment;
    }

    /**
     * 获取属性每份总投资金
     * @return 属性每份总投资金的值
     */
    public double getUnitInvestment(){
        return unitInvestment;
    }

    /**
     * 设置属性收益率
     * @param interestRate 待设置的属性收益率的值
     */
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    /**
     * 获取属性收益率
     * @return 属性收益率的值
     */
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * 设置属性投保年限
     * @param investYear 待设置的属性投保年限的值
     */
    public void setInvestYear(int investYear){
        this.investYear = investYear;
    }

    /**
     * 获取属性投保年限
     * @return 属性投保年限的值
     */
    public int getInvestYear(){
        return investYear;
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
