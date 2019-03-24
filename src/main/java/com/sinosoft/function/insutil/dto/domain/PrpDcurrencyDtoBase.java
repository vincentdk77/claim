package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcurrency的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcurrencyDtoBase implements Serializable{
    /** 属性currencycode */
    private String currencyCode = "";
    /** 属性currencycname */
    private String currencyCName = "";
    /** 属性currencyename */
    private String currencyEName = "";
    /** 属性newcurrencycode */
    private String newCurrencyCode = "";
    /** 属性AccBookCode */
    private String accBookCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcurrencyDtoBase对象
     */
    public PrpDcurrencyDtoBase(){
    }

    /**
     * 设置属性currencycode
     * @param currencyCode 待设置的属性currencycode的值
     */
    public void setCurrencyCode(String currencyCode){
        this.currencyCode = StringUtils.rightTrim(currencyCode);
    }

    /**
     * 获取属性currencycode
     * @return 属性currencycode的值
     */
    public String getCurrencyCode(){
        return currencyCode;
    }

    /**
     * 设置属性currencycname
     * @param currencyCName 待设置的属性currencycname的值
     */
    public void setCurrencyCName(String currencyCName){
        this.currencyCName = StringUtils.rightTrim(currencyCName);
    }

    /**
     * 获取属性currencycname
     * @return 属性currencycname的值
     */
    public String getCurrencyCName(){
        return currencyCName;
    }

    /**
     * 设置属性currencyename
     * @param currencyEName 待设置的属性currencyename的值
     */
    public void setCurrencyEName(String currencyEName){
        this.currencyEName = StringUtils.rightTrim(currencyEName);
    }

    /**
     * 获取属性currencyename
     * @return 属性currencyename的值
     */
    public String getCurrencyEName(){
        return currencyEName;
    }

    /**
     * 设置属性newcurrencycode
     * @param newCurrencyCode 待设置的属性newcurrencycode的值
     */
    public void setNewCurrencyCode(String newCurrencyCode){
        this.newCurrencyCode = StringUtils.rightTrim(newCurrencyCode);
    }

    /**
     * 获取属性newcurrencycode
     * @return 属性newcurrencycode的值
     */
    public String getNewCurrencyCode(){
        return newCurrencyCode;
    }

    /**
     * 设置属性AccBookCode
     * @param accBookCode 待设置的属性AccBookCode的值
     */
    public void setAccBookCode(String accBookCode){
        this.accBookCode = StringUtils.rightTrim(accBookCode);
    }

    /**
     * 获取属性AccBookCode
     * @return 属性AccBookCode的值
     */
    public String getAccBookCode(){
        return accBookCode;
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
