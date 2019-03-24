package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utikey键值信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiKeyDtoBase implements Serializable{
    /** 属性表名 */
    private String tableName = "";
    /** 属性字段名 */
    private String fieldName = "";
    /** 属性名称 */
    private String fieldMeaning = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiKeyDtoBase对象
     */
    public UtiKeyDtoBase(){
    }

    /**
     * 设置属性表名
     * @param tableName 待设置的属性表名的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性表名
     * @return 属性表名的值
     */
    public String getTableName(){
        return tableName;
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
     * 设置属性名称
     * @param fieldMeaning 待设置的属性名称的值
     */
    public void setFieldMeaning(String fieldMeaning){
        this.fieldMeaning = StringUtils.rightTrim(fieldMeaning);
    }

    /**
     * 获取属性名称
     * @return 属性名称的值
     */
    public String getFieldMeaning(){
        return fieldMeaning;
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
