package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrateusual的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateUsualDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性rateperiod */
    private int ratePeriod = 0;
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性ratecode */
    private String rateCode = "";
    /** 属性basepremium */
    private double basePremium = 0d;
    /** 属性rate */
    private double rate = 0d;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateUsualDtoBase对象
     */
    public PrpDrateUsualDtoBase(){
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
     * 设置属性rateperiod
     * @param ratePeriod 待设置的属性rateperiod的值
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * 获取属性rateperiod
     * @return 属性rateperiod的值
     */
    public int getRatePeriod(){
        return ratePeriod;
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
     * 设置属性ratecode
     * @param rateCode 待设置的属性ratecode的值
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * 获取属性ratecode
     * @return 属性ratecode的值
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * 设置属性basepremium
     * @param basePremium 待设置的属性basepremium的值
     */
    public void setBasePremium(double basePremium){
        this.basePremium = basePremium;
    }

    /**
     * 获取属性basepremium
     * @return 属性basepremium的值
     */
    public double getBasePremium(){
        return basePremium;
    }

    /**
     * 设置属性rate
     * @param rate 待设置的属性rate的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性rate
     * @return 属性rate的值
     */
    public double getRate(){
        return rate;
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
