package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utittycode的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyCodeDtoBase implements Serializable{
    /** 属性ttycode */
    private String ttyCode = "";
    /** 属性ttytype */
    private String ttyType = "";
    /** 属性ttyname */
    private String ttyName = "";
    /** 属性prttype */
    private String prtType = "";
    /** 属性prtname */
    private String prtName = "";
    /** 属性prtmode */
    private String prtMode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiTtyCodeDtoBase对象
     */
    public UtiTtyCodeDtoBase(){
    }

    /**
     * 设置属性ttycode
     * @param ttyCode 待设置的属性ttycode的值
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * 获取属性ttycode
     * @return 属性ttycode的值
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * 设置属性ttytype
     * @param ttyType 待设置的属性ttytype的值
     */
    public void setTtyType(String ttyType){
        this.ttyType = StringUtils.rightTrim(ttyType);
    }

    /**
     * 获取属性ttytype
     * @return 属性ttytype的值
     */
    public String getTtyType(){
        return ttyType;
    }

    /**
     * 设置属性ttyname
     * @param ttyName 待设置的属性ttyname的值
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * 获取属性ttyname
     * @return 属性ttyname的值
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * 设置属性prttype
     * @param prtType 待设置的属性prttype的值
     */
    public void setPrtType(String prtType){
        this.prtType = StringUtils.rightTrim(prtType);
    }

    /**
     * 获取属性prttype
     * @return 属性prttype的值
     */
    public String getPrtType(){
        return prtType;
    }

    /**
     * 设置属性prtname
     * @param prtName 待设置的属性prtname的值
     */
    public void setPrtName(String prtName){
        this.prtName = StringUtils.rightTrim(prtName);
    }

    /**
     * 获取属性prtname
     * @return 属性prtname的值
     */
    public String getPrtName(){
        return prtName;
    }

    /**
     * 设置属性prtmode
     * @param prtMode 待设置的属性prtmode的值
     */
    public void setPrtMode(String prtMode){
        this.prtMode = StringUtils.rightTrim(prtMode);
    }

    /**
     * 获取属性prtmode
     * @return 属性prtmode的值
     */
    public String getPrtMode(){
        return prtMode;
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
