package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdport的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDportDtoBase implements Serializable{
    /** 属性portcode */
    private String portCode = "";
    /** 属性portcname */
    private String portCName = "";
    /** 属性portename */
    private String portEName = "";
    /** 属性countrycode */
    private String countryCode = "";
    /** 属性countrycname */
    private String countryCName = "";
    /** 属性countryename */
    private String countryEName = "";
    /** 属性newportcode */
    private String newPortCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDportDtoBase对象
     */
    public PrpDportDtoBase(){
    }

    /**
     * 设置属性portcode
     * @param portCode 待设置的属性portcode的值
     */
    public void setPortCode(String portCode){
        this.portCode = StringUtils.rightTrim(portCode);
    }

    /**
     * 获取属性portcode
     * @return 属性portcode的值
     */
    public String getPortCode(){
        return portCode;
    }

    /**
     * 设置属性portcname
     * @param portCName 待设置的属性portcname的值
     */
    public void setPortCName(String portCName){
        this.portCName = StringUtils.rightTrim(portCName);
    }

    /**
     * 获取属性portcname
     * @return 属性portcname的值
     */
    public String getPortCName(){
        return portCName;
    }

    /**
     * 设置属性portename
     * @param portEName 待设置的属性portename的值
     */
    public void setPortEName(String portEName){
        this.portEName = StringUtils.rightTrim(portEName);
    }

    /**
     * 获取属性portename
     * @return 属性portename的值
     */
    public String getPortEName(){
        return portEName;
    }

    /**
     * 设置属性countrycode
     * @param countryCode 待设置的属性countrycode的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性countrycode
     * @return 属性countrycode的值
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * 设置属性countrycname
     * @param countryCName 待设置的属性countrycname的值
     */
    public void setCountryCName(String countryCName){
        this.countryCName = StringUtils.rightTrim(countryCName);
    }

    /**
     * 获取属性countrycname
     * @return 属性countrycname的值
     */
    public String getCountryCName(){
        return countryCName;
    }

    /**
     * 设置属性countryename
     * @param countryEName 待设置的属性countryename的值
     */
    public void setCountryEName(String countryEName){
        this.countryEName = StringUtils.rightTrim(countryEName);
    }

    /**
     * 获取属性countryename
     * @return 属性countryename的值
     */
    public String getCountryEName(){
        return countryEName;
    }

    /**
     * 设置属性newportcode
     * @param newPortCode 待设置的属性newportcode的值
     */
    public void setNewPortCode(String newPortCode){
        this.newPortCode = StringUtils.rightTrim(newPortCode);
    }

    /**
     * 获取属性newportcode
     * @return 属性newportcode的值
     */
    public String getNewPortCode(){
        return newPortCode;
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
