package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utipfield单证打印的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPfieldDtoBase implements Serializable{
    /** 属性文件名称 */
    private String fileName = "";
    /** 属性标号(格式标号) */
    private String labelNo = "";
    /** 属性字段名称 */
    private String fieldName = "";
    /** 属性取数标志 */
    private String selFlag = "";
    /** 属性表名 */
    private String tabName = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPfieldDtoBase对象
     */
    public UtiPfieldDtoBase(){
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
     * 设置属性标号(格式标号)
     * @param labelNo 待设置的属性标号(格式标号)的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性标号(格式标号)
     * @return 属性标号(格式标号)的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性字段名称
     * @param fieldName 待设置的属性字段名称的值
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * 获取属性字段名称
     * @return 属性字段名称的值
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * 设置属性取数标志
     * @param selFlag 待设置的属性取数标志的值
     */
    public void setSelFlag(String selFlag){
        this.selFlag = StringUtils.rightTrim(selFlag);
    }

    /**
     * 获取属性取数标志
     * @return 属性取数标志的值
     */
    public String getSelFlag(){
        return selFlag;
    }

    /**
     * 设置属性表名
     * @param tabName 待设置的属性表名的值
     */
    public void setTabName(String tabName){
        this.tabName = StringUtils.rightTrim(tabName);
    }

    /**
     * 获取属性表名
     * @return 属性表名的值
     */
    public String getTabName(){
        return tabName;
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
