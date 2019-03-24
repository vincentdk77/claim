package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrateusual费率代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateUsualDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性费率期数 */
    private int ratePeriod = 0;
    /** 属性生效日期 */
    private DateTime validDate = new DateTime();
    /** 属性费率代码 */
    private String rateCode = "";
    /** 属性基准保费 */
    private double basePremium = 0d;
    /** 属性基准费率 */
    private double rate = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateUsualDtoBase对象
     */
    public PrpDrateUsualDtoBase(){
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
     * 设置属性费率期数
     * @param ratePeriod 待设置的属性费率期数的值
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * 获取属性费率期数
     * @return 属性费率期数的值
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * 设置属性生效日期
     * @param validDate 待设置的属性生效日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性生效日期
     * @return 属性生效日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性费率代码
     * @param rateCode 待设置的属性费率代码的值
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * 获取属性费率代码
     * @return 属性费率代码的值
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * 设置属性基准保费
     * @param basePremium 待设置的属性基准保费的值
     */
    public void setBasePremium(double basePremium){
        this.basePremium = basePremium;
    }

    /**
     * 获取属性基准保费
     * @return 属性基准保费的值
     */
    public double getBasePremium(){
        return basePremium;
    }

    /**
     * 设置属性基准费率
     * @param rate 待设置的属性基准费率的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性基准费率
     * @return 属性基准费率的值
     */
    public double getRate(){
        return rate;
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
