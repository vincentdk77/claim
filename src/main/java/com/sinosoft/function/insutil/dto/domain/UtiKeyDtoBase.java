package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utikey的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiKeyDtoBase implements Serializable{
    /** 属性tablename */
    private String tableName = "";
    /** 属性fieldname */
    private String fieldName = "";
    /** 属性fieldmeaning */
    private String fieldMeaning = "";
    /** 属性headid */
    private String headID = "";
    /** 属性ColLength */
    private int colLength = 0;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiKeyDtoBase对象
     */
    public UtiKeyDtoBase(){
    }

    /**
     * 设置属性tablename
     * @param tableName 待设置的属性tablename的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性tablename
     * @return 属性tablename的值
     */
    public String getTableName(){
        return tableName;
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
     * 设置属性headid
     * @param headID 待设置的属性headid的值
     */
    public void setHeadID(String headID){
        this.headID = StringUtils.rightTrim(headID);
    }

    /**
     * 获取属性headid
     * @return 属性headid的值
     */
    public String getHeadID(){
        return headID;
    }

    /**
     * 设置属性ColLength
     * @param colLength 待设置的属性ColLength的值
     */
    public void setColLength(int colLength){
        this.colLength = colLength;
    }

    /**
     * 获取属性ColLength
     * @return 属性ColLength的值
     */
    public int getColLength(){
        return colLength;
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
