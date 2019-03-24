package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdexch的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDexchDtoBase implements Serializable{
    /** 属性exchdate */
    private DateTime exchDate = new DateTime();
    /** 属性base */
    private double base = 0d;
    /** 属性basecurrency */
    private String baseCurrency = "";
    /** 属性exchcurrency */
    private String exchCurrency = "";
    /** 属性exchrate */
    private double exchRate = 0d;
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDexchDtoBase对象
     */
    public PrpDexchDtoBase(){
    }

    /**
     * 设置属性exchdate
     * @param exchDate 待设置的属性exchdate的值
     */
    public void setExchDate(DateTime exchDate){
        this.exchDate = exchDate;
    }

    /**
     * 获取属性exchdate
     * @return 属性exchdate的值
     */
    public DateTime getExchDate(){
        return exchDate;
    }

    /**
     * 设置属性base
     * @param base 待设置的属性base的值
     */
    public void setBase(double base){
        this.base = base;
    }

    /**
     * 获取属性base
     * @return 属性base的值
     */
    public double getBase(){
        return base;
    }

    /**
     * 设置属性basecurrency
     * @param baseCurrency 待设置的属性basecurrency的值
     */
    public void setBaseCurrency(String baseCurrency){
        this.baseCurrency = StringUtils.rightTrim(baseCurrency);
    }

    /**
     * 获取属性basecurrency
     * @return 属性basecurrency的值
     */
    public String getBaseCurrency(){
        return baseCurrency;
    }

    /**
     * 设置属性exchcurrency
     * @param exchCurrency 待设置的属性exchcurrency的值
     */
    public void setExchCurrency(String exchCurrency){
        this.exchCurrency = StringUtils.rightTrim(exchCurrency);
    }

    /**
     * 获取属性exchcurrency
     * @return 属性exchcurrency的值
     */
    public String getExchCurrency(){
        return exchCurrency;
    }

    /**
     * 设置属性exchrate
     * @param exchRate 待设置的属性exchrate的值
     */
    public void setExchRate(double exchRate){
        this.exchRate = exchRate;
    }

    /**
     * 获取属性exchrate
     * @return 属性exchrate的值
     */
    public double getExchRate(){
        return exchRate;
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
