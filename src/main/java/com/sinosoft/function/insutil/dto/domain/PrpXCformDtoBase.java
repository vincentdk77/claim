package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpxcform的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXCformDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性filetype */
    private String fileType = "";
    /** 属性layrow */
    private int layRow = 0;
    /** 属性laycol */
    private int layCol = 0;
    /** 属性filename */
    private String fileName = "";
    /** 属性tablename */
    private String tableName = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpXCformDtoBase对象
     */
    public PrpXCformDtoBase(){
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
     * 设置属性filetype
     * @param fileType 待设置的属性filetype的值
     */
    public void setFileType(String fileType){
        this.fileType = StringUtils.rightTrim(fileType);
    }

    /**
     * 获取属性filetype
     * @return 属性filetype的值
     */
    public String getFileType(){
        return fileType;
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
