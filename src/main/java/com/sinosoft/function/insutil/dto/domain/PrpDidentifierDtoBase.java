package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdidentifier的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDtoBase implements Serializable{
    /** 属性identifiercode */
    private String identifierCode = "";
    /** 属性countrycode */
    private String countryCode = "";
    /** 属性countrycname */
    private String countryCName = "";
    /** 属性countryename */
    private String countryEName = "";
    /** 属性portcode */
    private String portCode = "";
    /** 属性portname */
    private String portName = "";
    /** 属性identifierorder */
    private int identifierOrder = 0;
    /** 属性identifiername */
    private String identifierName = "";
    /** 属性identifieraddress */
    private String identifierAddress = "";
    /** 属性identifiertype */
    private String identifierType = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDidentifierDtoBase对象
     */
    public PrpDidentifierDtoBase(){
    }

    /**
     * 设置属性identifiercode
     * @param identifierCode 待设置的属性identifiercode的值
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * 获取属性identifiercode
     * @return 属性identifiercode的值
     */
    public String getIdentifierCode(){
        return identifierCode;
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
     * 设置属性portname
     * @param portName 待设置的属性portname的值
     */
    public void setPortName(String portName){
        this.portName = StringUtils.rightTrim(portName);
    }

    /**
     * 获取属性portname
     * @return 属性portname的值
     */
    public String getPortName(){
        return portName;
    }

    /**
     * 设置属性identifierorder
     * @param identifierOrder 待设置的属性identifierorder的值
     */
    public void setIdentifierOrder(int identifierOrder){
        this.identifierOrder = identifierOrder;
    }

    /**
     * 获取属性identifierorder
     * @return 属性identifierorder的值
     */
    public int getIdentifierOrder(){
        return identifierOrder;
    }

    /**
     * 设置属性identifiername
     * @param identifierName 待设置的属性identifiername的值
     */
    public void setIdentifierName(String identifierName){
        this.identifierName = StringUtils.rightTrim(identifierName);
    }

    /**
     * 获取属性identifiername
     * @return 属性identifiername的值
     */
    public String getIdentifierName(){
        return identifierName;
    }

    /**
     * 设置属性identifieraddress
     * @param identifierAddress 待设置的属性identifieraddress的值
     */
    public void setIdentifierAddress(String identifierAddress){
        this.identifierAddress = StringUtils.rightTrim(identifierAddress);
    }

    /**
     * 获取属性identifieraddress
     * @return 属性identifieraddress的值
     */
    public String getIdentifierAddress(){
        return identifierAddress;
    }

    /**
     * 设置属性identifiertype
     * @param identifierType 待设置的属性identifiertype的值
     */
    public void setIdentifierType(String identifierType){
        this.identifierType = StringUtils.rightTrim(identifierType);
    }

    /**
     * 获取属性identifiertype
     * @return 属性identifiertype的值
     */
    public String getIdentifierType(){
        return identifierType;
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
