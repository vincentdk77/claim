package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiplst清单信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPlstDtoBase implements Serializable{
    /** 属性文件名称 */
    private String fileName = "";
    /** 属性标号 */
    private String labelNo = "";
    /** 属性字段名 */
    private String fieldName = "";
    /** 属性字段含义 */
    private String fieldMeaning = "";
    /** 属性字段格式 */
    private String fieldFormat = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPlstDtoBase对象
     */
    public UtiPlstDtoBase(){
    }

    /**
     * 设置属性文件名称
     * @param fileName 待设置的属性文件名称的值
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * 获取属性文件名称
     * @return 属性文件名称的值
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * 设置属性标号
     * @param labelNo 待设置的属性标号的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性标号
     * @return 属性标号的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性字段名
     * @param fieldName 待设置的属性字段名的值
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * 获取属性字段名
     * @return 属性字段名的值
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * 设置属性字段含义
     * @param fieldMeaning 待设置的属性字段含义的值
     */
    public void setFieldMeaning(String fieldMeaning){
        this.fieldMeaning = StringUtils.rightTrim(fieldMeaning);
    }

    /**
     * 获取属性字段含义
     * @return 属性字段含义的值
     */
    public String getFieldMeaning(){
        return fieldMeaning;
    }

    /**
     * 设置属性字段格式
     * @param fieldFormat 待设置的属性字段格式的值
     */
    public void setFieldFormat(String fieldFormat){
        this.fieldFormat = StringUtils.rightTrim(fieldFormat);
    }

    /**
     * 获取属性字段格式
     * @return 属性字段格式的值
     */
    public String getFieldFormat(){
        return fieldFormat;
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
