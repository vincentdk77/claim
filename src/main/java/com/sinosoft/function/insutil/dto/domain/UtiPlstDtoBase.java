package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiplst的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPlstDtoBase implements Serializable{
    /** 属性filename */
    private String fileName = "";
    /** 属性labelno */
    private String labelNo = "";
    /** 属性fieldname */
    private String fieldName = "";
    /** 属性fieldmeaning */
    private String fieldMeaning = "";
    /** 属性fieldformat */
    private String fieldFormat = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPlstDtoBase对象
     */
    public UtiPlstDtoBase(){
    }

    /**
     * 设置属性filename
     * @param fileName 待设置的属性filename的值
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * 获取属性filename
     * @return 属性filename的值
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * 设置属性labelno
     * @param labelNo 待设置的属性labelno的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性labelno
     * @return 属性labelno的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性fieldname
     * @param fieldName 待设置的属性fieldname的值
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * 获取属性fieldname
     * @return 属性fieldname的值
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * 设置属性fieldmeaning
     * @param fieldMeaning 待设置的属性fieldmeaning的值
     */
    public void setFieldMeaning(String fieldMeaning){
        this.fieldMeaning = StringUtils.rightTrim(fieldMeaning);
    }

    /**
     * 获取属性fieldmeaning
     * @return 属性fieldmeaning的值
     */
    public String getFieldMeaning(){
        return fieldMeaning;
    }

    /**
     * 设置属性fieldformat
     * @param fieldFormat 待设置的属性fieldformat的值
     */
    public void setFieldFormat(String fieldFormat){
        this.fieldFormat = StringUtils.rightTrim(fieldFormat);
    }

    /**
     * 获取属性fieldformat
     * @return 属性fieldformat的值
     */
    public String getFieldFormat(){
        return fieldFormat;
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
