package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpxpform的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPformDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性endortype */
    private String endorType = "";
    /** 属性endortypename */
    private String endorTypeName = "";
    /** 属性layrow */
    private int layRow = 0;
    /** 属性laycol */
    private int layCol = 0;
    /** 属性formname */
    private String formName = "";
    /** 属性tablename */
    private String tableName = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpXPformDtoBase对象
     */
    public PrpXPformDtoBase(){
    }

    /**
     * 设置属性riskcode
     * @param riskCode 待设置的属性riskcode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskcode
     * @return 属性riskcode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性endortype
     * @param endorType 待设置的属性endortype的值
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * 获取属性endortype
     * @return 属性endortype的值
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * 设置属性endortypename
     * @param endorTypeName 待设置的属性endortypename的值
     */
    public void setEndorTypeName(String endorTypeName){
        this.endorTypeName = StringUtils.rightTrim(endorTypeName);
    }

    /**
     * 获取属性endortypename
     * @return 属性endortypename的值
     */
    public String getEndorTypeName(){
        return endorTypeName;
    }

    /**
     * 设置属性layrow
     * @param layRow 待设置的属性layrow的值
     */
    public void setLayRow(int layRow){
        this.layRow = layRow;
    }

    /**
     * 获取属性layrow
     * @return 属性layrow的值
     */
    public int getLayRow(){
        return layRow;
    }

    /**
     * 设置属性laycol
     * @param layCol 待设置的属性laycol的值
     */
    public void setLayCol(int layCol){
        this.layCol = layCol;
    }

    /**
     * 获取属性laycol
     * @return 属性laycol的值
     */
    public int getLayCol(){
        return layCol;
    }

    /**
     * 设置属性formname
     * @param formName 待设置的属性formname的值
     */
    public void setFormName(String formName){
        this.formName = StringUtils.rightTrim(formName);
    }

    /**
     * 获取属性formname
     * @return 属性formname的值
     */
    public String getFormName(){
        return formName;
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
