package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdexch兑换率的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDexchDtoBase implements Serializable{
    /** 属性汇率日期 */
    private DateTime exchDate = new DateTime();
    /** 属性基准 */
    private double base = 0d;
    /** 属性基准币别 */
    private String baseCurrency = "";
    /** 属性兑换币别 */
    private String exchCurrency = "";
    /** 属性兑换汇率 */
    private double exchRate = 0d;
    /** 属性买进价 */
    private double buyPrice = 0d;
    /** 属性卖出价 */
    private double salePrice = 0d;
    /** 属性现价 */
    private double cashPrice = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDexchDtoBase对象
     */
    public PrpDexchDtoBase(){
    }

    /**
     * 设置属性汇率日期
     * @param exchDate 待设置的属性汇率日期的值
     */
    public void setExchDate(DateTime exchDate){
        this.exchDate = exchDate;
    }

    /**
     * 获取属性汇率日期
     * @return 属性汇率日期的值
     */
    public DateTime getExchDate(){
        return exchDate;
    }

    /**
     * 设置属性基准
     * @param base 待设置的属性基准的值
     */
    public void setBase(double base){
        this.base = base;
    }

    /**
     * 获取属性基准
     * @return 属性基准的值
     */
    public double getBase(){
        return base;
    }

    /**
     * 设置属性基准币别
     * @param baseCurrency 待设置的属性基准币别的值
     */
    public void setBaseCurrency(String baseCurrency){
        this.baseCurrency = StringUtils.rightTrim(baseCurrency);
    }

    /**
     * 获取属性基准币别
     * @return 属性基准币别的值
     */
    public String getBaseCurrency(){
        return baseCurrency;
    }

    /**
     * 设置属性兑换币别
     * @param exchCurrency 待设置的属性兑换币别的值
     */
    public void setExchCurrency(String exchCurrency){
        this.exchCurrency = StringUtils.rightTrim(exchCurrency);
    }

    /**
     * 获取属性兑换币别
     * @return 属性兑换币别的值
     */
    public String getExchCurrency(){
        return exchCurrency;
    }

    /**
     * 设置属性兑换汇率
     * @param exchRate 待设置的属性兑换汇率的值
     */
    public void setExchRate(double exchRate){
        this.exchRate = exchRate;
    }

    /**
     * 获取属性兑换汇率
     * @return 属性兑换汇率的值
     */
    public double getExchRate(){
        return exchRate;
    }

    /**
     * 设置属性买进价
     * @param buyPrice 待设置的属性买进价的值
     */
    public void setBuyPrice(double buyPrice){
        this.buyPrice = buyPrice;
    }

    /**
     * 获取属性买进价
     * @return 属性买进价的值
     */
    public double getBuyPrice(){
        return buyPrice;
    }

    /**
     * 设置属性卖出价
     * @param salePrice 待设置的属性卖出价的值
     */
    public void setSalePrice(double salePrice){
        this.salePrice = salePrice;
    }

    /**
     * 获取属性卖出价
     * @return 属性卖出价的值
     */
    public double getSalePrice(){
        return salePrice;
    }

    /**
     * 设置属性现价
     * @param cashPrice 待设置的属性现价的值
     */
    public void setCashPrice(double cashPrice){
        this.cashPrice = cashPrice;
    }

    /**
     * 获取属性现价
     * @return 属性现价的值
     */
    public double getCashPrice(){
        return cashPrice;
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
