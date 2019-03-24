package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtcode的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtCodeDtoBase implements Serializable{
    /** 属性instructtype */
    private String instructType = "";
    /** 属性instructcode */
    private String instructCode = "";
    /** 属性instructname */
    private String instructName = "";
    /** 属性ctrlcode */
    private String ctrlCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPrtCodeDtoBase对象
     */
    public UtiPrtCodeDtoBase(){
    }

    /**
     * 设置属性instructtype
     * @param instructType 待设置的属性instructtype的值
     */
    public void setInstructType(String instructType){
        this.instructType = StringUtils.rightTrim(instructType);
    }

    /**
     * 获取属性instructtype
     * @return 属性instructtype的值
     */
    public String getInstructType(){
        return instructType;
    }

    /**
     * 设置属性instructcode
     * @param instructCode 待设置的属性instructcode的值
     */
    public void setInstructCode(String instructCode){
        this.instructCode = StringUtils.rightTrim(instructCode);
    }

    /**
     * 获取属性instructcode
     * @return 属性instructcode的值
     */
    public String getInstructCode(){
        return instructCode;
    }

    /**
     * 设置属性instructname
     * @param instructName 待设置的属性instructname的值
     */
    public void setInstructName(String instructName){
        this.instructName = StringUtils.rightTrim(instructName);
    }

    /**
     * 获取属性instructname
     * @return 属性instructname的值
     */
    public String getInstructName(){
        return instructName;
    }

    /**
     * 设置属性ctrlcode
     * @param ctrlCode 待设置的属性ctrlcode的值
     */
    public void setCtrlCode(String ctrlCode){
        this.ctrlCode = StringUtils.rightTrim(ctrlCode);
    }

    /**
     * 获取属性ctrlcode
     * @return 属性ctrlcode的值
     */
    public String getCtrlCode(){
        return ctrlCode;
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
