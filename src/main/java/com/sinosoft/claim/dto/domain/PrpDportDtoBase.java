package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdport港口代码的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDportDtoBase implements Serializable{
    /** 属性港口代码 */
    private String portCode = "";
    /** 属性港口中文名称 */
    private String portCName = "";
    /** 属性港口英文名称 */
    private String portEName = "";
    /** 属性国别代码 */
    private String countryCode = "";
    /** 属性国家中文名称 */
    private String countryCName = "";
    /** 属性国家英文名称 */
    private String countryEName = "";
    /** 属性新的港口代码 */
    private String newPortCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDportDtoBase对象
     */
    public PrpDportDtoBase(){
    }

    /**
     * 设置属性港口代码
     * @param portCode 待设置的属性港口代码的值
     */
    public void setPortCode(String portCode){
        this.portCode = StringUtils.rightTrim(portCode);
    }

    /**
     * 获取属性港口代码
     * @return 属性港口代码的值
     */
    public String getPortCode(){
        return portCode;
    }

    /**
     * 设置属性港口中文名称
     * @param portCName 待设置的属性港口中文名称的值
     */
    public void setPortCName(String portCName){
        this.portCName = StringUtils.rightTrim(portCName);
    }

    /**
     * 获取属性港口中文名称
     * @return 属性港口中文名称的值
     */
    public String getPortCName(){
        return portCName;
    }

    /**
     * 设置属性港口英文名称
     * @param portEName 待设置的属性港口英文名称的值
     */
    public void setPortEName(String portEName){
        this.portEName = StringUtils.rightTrim(portEName);
    }

    /**
     * 获取属性港口英文名称
     * @return 属性港口英文名称的值
     */
    public String getPortEName(){
        return portEName;
    }

    /**
     * 设置属性国别代码
     * @param countryCode 待设置的属性国别代码的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性国别代码
     * @return 属性国别代码的值
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * 设置属性国家中文名称
     * @param countryCName 待设置的属性国家中文名称的值
     */
    public void setCountryCName(String countryCName){
        this.countryCName = StringUtils.rightTrim(countryCName);
    }

    /**
     * 获取属性国家中文名称
     * @return 属性国家中文名称的值
     */
    public String getCountryCName(){
        return countryCName;
    }

    /**
     * 设置属性国家英文名称
     * @param countryEName 待设置的属性国家英文名称的值
     */
    public void setCountryEName(String countryEName){
        this.countryEName = StringUtils.rightTrim(countryEName);
    }

    /**
     * 获取属性国家英文名称
     * @return 属性国家英文名称的值
     */
    public String getCountryEName(){
        return countryEName;
    }

    /**
     * 设置属性新的港口代码
     * @param newPortCode 待设置的属性新的港口代码的值
     */
    public void setNewPortCode(String newPortCode){
        this.newPortCode = StringUtils.rightTrim(newPortCode);
    }

    /**
     * 获取属性新的港口代码
     * @return 属性新的港口代码的值
     */
    public String getNewPortCode(){
        return newPortCode;
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
