package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiprtcode打印控制指令代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPrtCodeDtoBase implements Serializable{
    /** 属性指令类别 */
    private String instructType = "";
    /** 属性指令代码 */
    private String instructCode = "";
    /** 属性指令名称 */
    private String instructName = "";
    /** 属性控制字符 */
    private String ctrlCode = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPrtCodeDtoBase对象
     */
    public UtiPrtCodeDtoBase(){
    }

    /**
     * 设置属性指令类别
     * @param instructType 待设置的属性指令类别的值
     */
    public void setInstructType(String instructType){
        this.instructType = StringUtils.rightTrim(instructType);
    }

    /**
     * 获取属性指令类别
     * @return 属性指令类别的值
     */
    public String getInstructType(){
        return instructType;
    }

    /**
     * 设置属性指令代码
     * @param instructCode 待设置的属性指令代码的值
     */
    public void setInstructCode(String instructCode){
        this.instructCode = StringUtils.rightTrim(instructCode);
    }

    /**
     * 获取属性指令代码
     * @return 属性指令代码的值
     */
    public String getInstructCode(){
        return instructCode;
    }

    /**
     * 设置属性指令名称
     * @param instructName 待设置的属性指令名称的值
     */
    public void setInstructName(String instructName){
        this.instructName = StringUtils.rightTrim(instructName);
    }

    /**
     * 获取属性指令名称
     * @return 属性指令名称的值
     */
    public String getInstructName(){
        return instructName;
    }

    /**
     * 设置属性控制字符
     * @param ctrlCode 待设置的属性控制字符的值
     */
    public void setCtrlCode(String ctrlCode){
        this.ctrlCode = StringUtils.rightTrim(ctrlCode);
    }

    /**
     * 获取属性控制字符
     * @return 属性控制字符的值
     */
    public String getCtrlCode(){
        return ctrlCode;
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
