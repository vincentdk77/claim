package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtform复杂横纵表头的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtFormDtoBase implements Serializable{
    /** 属性表头编码 */
    private String headCode = "";
    /** 属性表头名称 */
    private String headName = "";
    /** 属性表头长度 */
    private int headLength = 0;
    /** 属性横(h)纵(v)标志 */
    private String headType = "";

    /**
     *  默认构造方法,构造一个默认的UtiPrtFormDtoBase对象
     */
    public UtiPrtFormDtoBase(){
    }

    /**
     * 设置属性表头编码
     * @param headCode 待设置的属性表头编码的值
     */
    public void setHeadCode(String headCode){
        this.headCode = StringUtils.rightTrim(headCode);
    }

    /**
     * 获取属性表头编码
     * @return 属性表头编码的值
     */
    public String getHeadCode(){
        return headCode;
    }

    /**
     * 设置属性表头名称
     * @param headName 待设置的属性表头名称的值
     */
    public void setHeadName(String headName){
        this.headName = StringUtils.rightTrim(headName);
    }

    /**
     * 获取属性表头名称
     * @return 属性表头名称的值
     */
    public String getHeadName(){
        return headName;
    }

    /**
     * 设置属性表头长度
     * @param headLength 待设置的属性表头长度的值
     */
    public void setHeadLength(int headLength){
        this.headLength = headLength;
    }

    /**
     * 获取属性表头长度
     * @return 属性表头长度的值
     */
    public int getHeadLength(){
        return headLength;
    }

    /**
     * 设置属性横(h)纵(v)标志
     * @param headType 待设置的属性横(h)纵(v)标志的值
     */
    public void setHeadType(String headType){
        this.headType = StringUtils.rightTrim(headType);
    }

    /**
     * 获取属性横(h)纵(v)标志
     * @return 属性横(h)纵(v)标志的值
     */
    public String getHeadType(){
        return headType;
    }
}
