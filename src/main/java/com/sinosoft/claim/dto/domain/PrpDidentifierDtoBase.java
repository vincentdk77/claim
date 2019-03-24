package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdidentifier检验人代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDtoBase implements Serializable{
    /** 属性检验人代码 */
    private String identifierCode = "";
    /** 属性国家代码 */
    private String countryCode = "";
    /** 属性国家中文名称 */
    private String countryCName = "";
    /** 属性国家英文名称 */
    private String countryEName = "";
    /** 属性港口代码 */
    private String portCode = "";
    /** 属性港口名称 */
    private String portName = "";
    /** 属性优先级别 */
    private int identifierOrder = 0;
    /** 属性检验人名称 */
    private String identifierName = "";
    /** 属性检验人地址 */
    private String identifierAddress = "";
    /** 属性检验人类型 */
    private String identifierType = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDidentifierDtoBase对象
     */
    public PrpDidentifierDtoBase(){
    }

    /**
     * 设置属性检验人代码
     * @param identifierCode 待设置的属性检验人代码的值
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * 获取属性检验人代码
     * @return 属性检验人代码的值
     */
    public String getIdentifierCode(){
        return identifierCode;
    }

    /**
     * 设置属性国家代码
     * @param countryCode 待设置的属性国家代码的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性国家代码
     * @return 属性国家代码的值
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
     * 设置属性港口名称
     * @param portName 待设置的属性港口名称的值
     */
    public void setPortName(String portName){
        this.portName = StringUtils.rightTrim(portName);
    }

    /**
     * 获取属性港口名称
     * @return 属性港口名称的值
     */
    public String getPortName(){
        return portName;
    }

    /**
     * 设置属性优先级别
     * @param identifierOrder 待设置的属性优先级别的值
     */
    public void setIdentifierOrder(int identifierOrder){
        this.identifierOrder = identifierOrder;
    }

    /**
     * 获取属性优先级别
     * @return 属性优先级别的值
     */
    public int getIdentifierOrder(){
        return identifierOrder;
    }

    /**
     * 设置属性检验人名称
     * @param identifierName 待设置的属性检验人名称的值
     */
    public void setIdentifierName(String identifierName){
        this.identifierName = StringUtils.rightTrim(identifierName);
    }

    /**
     * 获取属性检验人名称
     * @return 属性检验人名称的值
     */
    public String getIdentifierName(){
        return identifierName;
    }

    /**
     * 设置属性检验人地址
     * @param identifierAddress 待设置的属性检验人地址的值
     */
    public void setIdentifierAddress(String identifierAddress){
        this.identifierAddress = StringUtils.rightTrim(identifierAddress);
    }

    /**
     * 获取属性检验人地址
     * @return 属性检验人地址的值
     */
    public String getIdentifierAddress(){
        return identifierAddress;
    }

    /**
     * 设置属性检验人类型
     * @param identifierType 待设置的属性检验人类型的值
     */
    public void setIdentifierType(String identifierType){
        this.identifierType = StringUtils.rightTrim(identifierType);
    }

    /**
     * 获取属性检验人类型
     * @return 属性检验人类型的值
     */
    public String getIdentifierType(){
        return identifierType;
    }

    /**
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
