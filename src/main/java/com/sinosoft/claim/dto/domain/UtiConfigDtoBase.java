package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是uticonfig（无用数据表）的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiConfigDtoBase implements Serializable{
    /** 属性cfgid */
    private String cfgid = "";
    /** 属性cfgoth */
    private String cfgoth = "";
    /** 属性cfgothmean */
    private String cfgothmean = "";
    /** 属性cfgvalue */
    private String cfgvalue = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiConfigDtoBase对象
     */
    public UtiConfigDtoBase(){
    }

    /**
     * 设置属性cfgid
     * @param cfgid 待设置的属性cfgid的值
     */
    public void setCfgid(String cfgid){
        this.cfgid = StringUtils.rightTrim(cfgid);
    }

    /**
     * 获取属性cfgid
     * @return 属性cfgid的值
     */
    public String getCfgid(){
        return cfgid;
    }

    /**
     * 设置属性cfgoth
     * @param cfgoth 待设置的属性cfgoth的值
     */
    public void setCfgoth(String cfgoth){
        this.cfgoth = StringUtils.rightTrim(cfgoth);
    }

    /**
     * 获取属性cfgoth
     * @return 属性cfgoth的值
     */
    public String getCfgoth(){
        return cfgoth;
    }

    /**
     * 设置属性cfgothmean
     * @param cfgothmean 待设置的属性cfgothmean的值
     */
    public void setCfgothmean(String cfgothmean){
        this.cfgothmean = StringUtils.rightTrim(cfgothmean);
    }

    /**
     * 获取属性cfgothmean
     * @return 属性cfgothmean的值
     */
    public String getCfgothmean(){
        return cfgothmean;
    }

    /**
     * 设置属性cfgvalue
     * @param cfgvalue 待设置的属性cfgvalue的值
     */
    public void setCfgvalue(String cfgvalue){
        this.cfgvalue = StringUtils.rightTrim(cfgvalue);
    }

    /**
     * 获取属性cfgvalue
     * @return 属性cfgvalue的值
     */
    public String getCfgvalue(){
        return cfgvalue;
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
