package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdinvest的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDinvestDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性rationtype */
    private String rationType = "";
    /** 属性investname */
    private String investName = "";
    /** 属性periods */
    private int periods = 0;
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性unitamount */
    private double unitAmount = 0d;
    /** 属性unitpremium */
    private double unitPremium = 0d;
    /** 属性unitinvestment */
    private double unitInvestment = 0d;
    /** 属性interestrate */
    private double interestRate = 0d;
    /** 属性investyear */
    private int investYear = 0;
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDinvestDtoBase对象
     */
    public PrpDinvestDtoBase(){
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
     * 设置属性investname
     * @param investName 待设置的属性investname的值
     */
    public void setInvestName(String investName){
        this.investName = StringUtils.rightTrim(investName);
    }

    /**
     * 获取属性investname
     * @return 属性investname的值
     */
    public String getInvestName(){
        return investName;
    }

    /**
     * 设置属性periods
     * @param periods 待设置的属性periods的值
     */
    public void setPeriods(int periods){
        this.periods = periods;
    }

    /**
     * 获取属性periods
     * @return 属性periods的值
     */
    public int getPeriods(){
        return periods;
    }

    /**
     * 设置属性validdate
     * @param validDate 待设置的属性validdate的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性validdate
     * @return 属性validdate的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性unitamount
     * @param unitAmount 待设置的属性unitamount的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性unitamount
     * @return 属性unitamount的值
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * 设置属性unitpremium
     * @param unitPremium 待设置的属性unitpremium的值
     */
    public void setUnitPremium(double unitPremium){
        this.unitPremium = unitPremium;
    }

    /**
     * 获取属性unitpremium
     * @return 属性unitpremium的值
     */
    public double getUnitPremium(){
        return unitPremium;
    }

    /**
     * 设置属性unitinvestment
     * @param unitInvestment 待设置的属性unitinvestment的值
     */
    public void setUnitInvestment(double unitInvestment){
        this.unitInvestment = unitInvestment;
    }

    /**
     * 获取属性unitinvestment
     * @return 属性unitinvestment的值
     */
    public double getUnitInvestment(){
        return unitInvestment;
    }

    /**
     * 设置属性interestrate
     * @param interestRate 待设置的属性interestrate的值
     */
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    /**
     * 获取属性interestrate
     * @return 属性interestrate的值
     */
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * 设置属性investyear
     * @param investYear 待设置的属性investyear的值
     */
    public void setInvestYear(int investYear){
        this.investYear = investYear;
    }

    /**
     * 获取属性investyear
     * @return 属性investyear的值
     */
    public int getInvestYear(){
        return investYear;
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
