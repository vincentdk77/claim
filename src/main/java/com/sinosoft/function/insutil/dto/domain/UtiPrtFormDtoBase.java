package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtform的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtFormDtoBase implements Serializable{
    /** 属性headcode */
    private String headCode = "";
    /** 属性headname */
    private String headName = "";
    /** 属性headlength */
    private int headLength = 0;
    /** 属性headtype */
    private String headType = "";

    /**
     *  默认构造方法,构造一个默认的UtiPrtFormDtoBase对象
     */
    public UtiPrtFormDtoBase(){
    }

    /**
     * 设置属性headcode
     * @param headCode 待设置的属性headcode的值
     */
    public void setHeadCode(String headCode){
        this.headCode = StringUtils.rightTrim(headCode);
    }

    /**
     * 获取属性headcode
     * @return 属性headcode的值
     */
    public String getHeadCode(){
        return headCode;
    }

    /**
     * 设置属性headname
     * @param headName 待设置的属性headname的值
     */
    public void setHeadName(String headName){
        this.headName = StringUtils.rightTrim(headName);
    }

    /**
     * 获取属性headname
     * @return 属性headname的值
     */
    public String getHeadName(){
        return headName;
    }

    /**
     * 设置属性headlength
     * @param headLength 待设置的属性headlength的值
     */
    public void setHeadLength(int headLength){
        this.headLength = headLength;
    }

    /**
     * 获取属性headlength
     * @return 属性headlength的值
     */
    public int getHeadLength(){
        return headLength;
    }

    /**
     * 设置属性headtype
     * @param headType 待设置的属性headtype的值
     */
    public void setHeadType(String headType){
        this.headType = StringUtils.rightTrim(headType);
    }

    /**
     * 获取属性headtype
     * @return 属性headtype的值
     */
    public String getHeadType(){
        return headType;
    }
}
