package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpxpcol批文数据字典表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPcolDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性数据表名 */
    private String tableName = "";
    /** 属性字段顺序 */
    private int colSeq = 0;
    /** 属性字段名 */
    private String colName = "";
    /** 属性显示顺序 */
    private int dispSeq = 0;
    /** 属性字段中文说明 */
    private String colCName = "";
    /** 属性字段英文说明 */
    private String colEName = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpXPcolDtoBase对象
     */
    public PrpXPcolDtoBase(){
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
     * 设置属性数据表名
     * @param tableName 待设置的属性数据表名的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性数据表名
     * @return 属性数据表名的值
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * 设置属性字段顺序
     * @param colSeq 待设置的属性字段顺序的值
     */
    public void setColSeq(int colSeq){
        this.colSeq = colSeq;
    }

    /**
     * 获取属性字段顺序
     * @return 属性字段顺序的值
     */
    public int getColSeq(){
        return colSeq;
    }

    /**
     * 设置属性字段名
     * @param colName 待设置的属性字段名的值
     */
    public void setColName(String colName){
        this.colName = StringUtils.rightTrim(colName);
    }

    /**
     * 获取属性字段名
     * @return 属性字段名的值
     */
    public String getColName(){
        return colName;
    }

    /**
     * 设置属性显示顺序
     * @param dispSeq 待设置的属性显示顺序的值
     */
    public void setDispSeq(int dispSeq){
        this.dispSeq = dispSeq;
    }

    /**
     * 获取属性显示顺序
     * @return 属性显示顺序的值
     */
    public int getDispSeq(){
        return dispSeq;
    }

    /**
     * 设置属性字段中文说明
     * @param colCName 待设置的属性字段中文说明的值
     */
    public void setColCName(String colCName){
        this.colCName = StringUtils.rightTrim(colCName);
    }

    /**
     * 获取属性字段中文说明
     * @return 属性字段中文说明的值
     */
    public String getColCName(){
        return colCName;
    }

    /**
     * 设置属性字段英文说明
     * @param colEName 待设置的属性字段英文说明的值
     */
    public void setColEName(String colEName){
        this.colEName = StringUtils.rightTrim(colEName);
    }

    /**
     * 获取属性字段英文说明
     * @return 属性字段英文说明的值
     */
    public String getColEName(){
        return colEName;
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
