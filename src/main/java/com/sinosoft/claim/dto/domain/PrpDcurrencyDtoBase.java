package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcurrency币别代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcurrencyDtoBase implements Serializable{
    /** 属性币别代码 */
    private String currencyCode = "";
    /** 属性币别中文名称 */
    private String currencyCName = "";
    /** 属性币别英文名称 */
    private String currencyEName = "";
    /** 属性最新币别代码 */
    private String newCurrencyCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcurrencyDtoBase对象
     */
    public PrpDcurrencyDtoBase(){
    }
    public PrpDcurrencyDtoBase(String currencyCode,String currencyCName){
    	
    	this.currencyCode = currencyCode;
    	this.currencyCName = currencyCName;
    }
    /**
     * 设置属性币别代码
     * @param currencyCode 待设置的属性币别代码的值
     */
    public void setCurrencyCode(String currencyCode){
        this.currencyCode = StringUtils.rightTrim(currencyCode);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrencyCode(){
        return currencyCode;
    }

    /**
     * 设置属性币别中文名称
     * @param currencyCName 待设置的属性币别中文名称的值
     */
    public void setCurrencyCName(String currencyCName){
        this.currencyCName = StringUtils.rightTrim(currencyCName);
    }

    /**
     * 获取属性币别中文名称
     * @return 属性币别中文名称的值
     */
    public String getCurrencyCName(){
        return currencyCName;
    }

    /**
     * 设置属性币别英文名称
     * @param currencyEName 待设置的属性币别英文名称的值
     */
    public void setCurrencyEName(String currencyEName){
        this.currencyEName = StringUtils.rightTrim(currencyEName);
    }

    /**
     * 获取属性币别英文名称
     * @return 属性币别英文名称的值
     */
    public String getCurrencyEName(){
        return currencyEName;
    }

    /**
     * 设置属性最新币别代码
     * @param newCurrencyCode 待设置的属性最新币别代码的值
     */
    public void setNewCurrencyCode(String newCurrencyCode){
        this.newCurrencyCode = StringUtils.rightTrim(newCurrencyCode);
    }

    /**
     * 获取属性最新币别代码
     * @return 属性最新币别代码的值
     */
    public String getNewCurrencyCode(){
        return newCurrencyCode;
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
