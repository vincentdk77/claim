package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpxpcol的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPcolDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性tablename */
    private String tableName = "";
    /** 属性colseq */
    private int colSeq = 0;
    /** 属性colname */
    private String colName = "";
    /** 属性dispseq */
    private int dispSeq = 0;
    /** 属性colcname */
    private String colCName = "";
    /** 属性colename */
    private String colEName = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpXPcolDtoBase对象
     */
    public PrpXPcolDtoBase(){
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
     * 设置属性colseq
     * @param colSeq 待设置的属性colseq的值
     */
    public void setColSeq(int colSeq){
        this.colSeq = colSeq;
    }

    /**
     * 获取属性colseq
     * @return 属性colseq的值
     */
    public int getColSeq(){
        return colSeq;
    }

    /**
     * 设置属性colname
     * @param colName 待设置的属性colname的值
     */
    public void setColName(String colName){
        this.colName = StringUtils.rightTrim(colName);
    }

    /**
     * 获取属性colname
     * @return 属性colname的值
     */
    public String getColName(){
        return colName;
    }

    /**
     * 设置属性dispseq
     * @param dispSeq 待设置的属性dispseq的值
     */
    public void setDispSeq(int dispSeq){
        this.dispSeq = dispSeq;
    }

    /**
     * 获取属性dispseq
     * @return 属性dispseq的值
     */
    public int getDispSeq(){
        return dispSeq;
    }

    /**
     * 设置属性colcname
     * @param colCName 待设置的属性colcname的值
     */
    public void setColCName(String colCName){
        this.colCName = StringUtils.rightTrim(colCName);
    }

    /**
     * 获取属性colcname
     * @return 属性colcname的值
     */
    public String getColCName(){
        return colCName;
    }

    /**
     * 设置属性colename
     * @param colEName 待设置的属性colename的值
     */
    public void setColEName(String colEName){
        this.colEName = StringUtils.rightTrim(colEName);
    }

    /**
     * 获取属性colename
     * @return 属性colename的值
     */
    public String getColEName(){
        return colEName;
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
