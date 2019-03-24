package com.sinosoft.ciplatform.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CIPlatformConfig的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CIPlatformConfigDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性configCode */
    private String configCode = "";
    /** 属性configName */
    private String configName = "";
    /** 属性comCode */
    private String comCode = "";
    /** 属性riskCode */
    private String riskCode = "";
    /** 属性version */
    private String version = "";
    /** 属性url */
    private String url = "";
    /** 属性userName */
    private String userName = "";
    /** 属性pwd */
    private String pwd = "";
    /** 属性configValue */
    private String configValue = "";
    /** 属性configValueDes */
    private String configValueDes = "";
    /** 属性validStatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的CIPlatformConfigDtoBase对象
     */
    public CIPlatformConfigDtoBase(){
    }

    /**
     * 设置属性configCode
     * @param configCode 待设置的属性configCode的值
     */
    public void setConfigCode(String configCode){
        this.configCode = StringUtils.rightTrim(configCode);
    }

    /**
     * 获取属性configCode
     * @return 属性configCode的值
     */
    public String getConfigCode(){
        return configCode;
    }

    /**
     * 设置属性configName
     * @param configName 待设置的属性configName的值
     */
    public void setConfigName(String configName){
        this.configName = StringUtils.rightTrim(configName);
    }

    /**
     * 获取属性configName
     * @return 属性configName的值
     */
    public String getConfigName(){
        return configName;
    }

    /**
     * 设置属性comCode
     * @param comCode 待设置的属性comCode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comCode
     * @return 属性comCode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性riskCode
     * @param riskCode 待设置的属性riskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskCode
     * @return 属性riskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性version
     * @param version 待设置的属性version的值
     */
    public void setVersion(String version){
        this.version = StringUtils.rightTrim(version);
    }

    /**
     * 获取属性version
     * @return 属性version的值
     */
    public String getVersion(){
        return version;
    }

    /**
     * 设置属性url
     * @param url 待设置的属性url的值
     */
    public void setUrl(String url){
        this.url = StringUtils.rightTrim(url);
    }

    /**
     * 获取属性url
     * @return 属性url的值
     */
    public String getUrl(){
        return url;
    }

    /**
     * 设置属性userName
     * @param userName 待设置的属性userName的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性userName
     * @return 属性userName的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性pwd
     * @param pwd 待设置的属性pwd的值
     */
    public void setPwd(String pwd){
        this.pwd = StringUtils.rightTrim(pwd);
    }

    /**
     * 获取属性pwd
     * @return 属性pwd的值
     */
    public String getPwd(){
        return pwd;
    }

    /**
     * 设置属性configValue
     * @param configValue 待设置的属性configValue的值
     */
    public void setConfigValue(String configValue){
        this.configValue = StringUtils.rightTrim(configValue);
    }

    /**
     * 获取属性configValue
     * @return 属性configValue的值
     */
    public String getConfigValue(){
        return configValue;
    }

    /**
     * 设置属性configValueDes
     * @param configValueDes 待设置的属性configValueDes的值
     */
    public void setConfigValueDes(String configValueDes){
        this.configValueDes = StringUtils.rightTrim(configValueDes);
    }

    /**
     * 获取属性configValueDes
     * @return 属性configValueDes的值
     */
    public String getConfigValueDes(){
        return configValueDes;
    }

    /**
     * 设置属性validStatus
     * @param validStatus 待设置的属性validStatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validStatus
     * @return 属性validStatus的值
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
