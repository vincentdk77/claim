package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpxpform批改数据字典表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPformDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性批改类型 */
    private String endorType = "";
    /** 属性批改类型名称 */
    private String endorTypeName = "";
    /** 属性form的行座标 */
    private int row = 0;
    /** 属性form的列座标 */
    private int col = 0;
    /** 属性FORM名称 */
    private String formName = "";
    /** 属性相关数据表名称 */
    private String tableName = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpXPformDtoBase对象
     */
    public PrpXPformDtoBase(){
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性批改类型
     * @param endorType 待设置的属性批改类型的值
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * 获取属性批改类型
     * @return 属性批改类型的值
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * 设置属性批改类型名称
     * @param endorTypeName 待设置的属性批改类型名称的值
     */
    public void setEndorTypeName(String endorTypeName){
        this.endorTypeName = StringUtils.rightTrim(endorTypeName);
    }

    /**
     * 获取属性批改类型名称
     * @return 属性批改类型名称的值
     */
    public String getEndorTypeName(){
        return endorTypeName;
    }

    /**
     * 设置属性form的行座标
     * @param row 待设置的属性form的行座标的值
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * 获取属性form的行座标
     * @return 属性form的行座标的值
     */
    public int getRow(){
        return row;
    }

    /**
     * 设置属性form的列座标
     * @param col 待设置的属性form的列座标的值
     */
    public void setCol(int col){
        this.col = col;
    }

    /**
     * 获取属性form的列座标
     * @return 属性form的列座标的值
     */
    public int getCol(){
        return col;
    }

    /**
     * 设置属性FORM名称
     * @param formName 待设置的属性FORM名称的值
     */
    public void setFormName(String formName){
        this.formName = StringUtils.rightTrim(formName);
    }

    /**
     * 获取属性FORM名称
     * @return 属性FORM名称的值
     */
    public String getFormName(){
        return formName;
    }

    /**
     * 设置属性相关数据表名称
     * @param tableName 待设置的属性相关数据表名称的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性相关数据表名称
     * @return 属性相关数据表名称的值
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
