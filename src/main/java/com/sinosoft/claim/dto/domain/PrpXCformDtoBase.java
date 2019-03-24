package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpxcform承保数据字典表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXCformDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性文件类型 */
    private String fileType = "";
    /** 属性form的行座标 */
    private int row = 0;
    /** 属性form的列座标 */
    private int col = 0;
    /** 属性文件名称 */
    private String fileName = "";
    /** 属性相关数据表名 */
    private String tableName = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpXCformDtoBase对象
     */
    public PrpXCformDtoBase(){
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
     * 设置属性文件类型
     * @param fileType 待设置的属性文件类型的值
     */
    public void setFileType(String fileType){
        this.fileType = StringUtils.rightTrim(fileType);
    }

    /**
     * 获取属性文件类型
     * @return 属性文件类型的值
     */
    public String getFileType(){
        return fileType;
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
     * 设置属性相关数据表名
     * @param tableName 待设置的属性相关数据表名的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性相关数据表名
     * @return 属性相关数据表名的值
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
