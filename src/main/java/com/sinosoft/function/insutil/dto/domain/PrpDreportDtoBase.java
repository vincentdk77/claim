package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdreport的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDreportDtoBase implements Serializable{
    /** 属性reportcode */
    private String reportCode = "";
    /** 属性reportname */
    private String reportName = "";
    /** 属性serialno */
    private int serialNo = 0;
    /** 属性layrow */
    private int layRow = 0;
    /** 属性laycol */
    private int layCol = 0;
    /** 属性workfield */
    private String workField = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDreportDtoBase对象
     */
    public PrpDreportDtoBase(){
    }

    /**
     * 设置属性reportcode
     * @param reportCode 待设置的属性reportcode的值
     */
    public void setReportCode(String reportCode){
        this.reportCode = StringUtils.rightTrim(reportCode);
    }

    /**
     * 获取属性reportcode
     * @return 属性reportcode的值
     */
    public String getReportCode(){
        return reportCode;
    }

    /**
     * 设置属性reportname
     * @param reportName 待设置的属性reportname的值
     */
    public void setReportName(String reportName){
        this.reportName = StringUtils.rightTrim(reportName);
    }

    /**
     * 获取属性reportname
     * @return 属性reportname的值
     */
    public String getReportName(){
        return reportName;
    }

    /**
     * 设置属性serialno
     * @param serialNo 待设置的属性serialno的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialno
     * @return 属性serialno的值
     */
    public int getSerialNo(){
        return serialNo;
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
     * 设置属性workfield
     * @param workField 待设置的属性workfield的值
     */
    public void setWorkField(String workField){
        this.workField = StringUtils.rightTrim(workField);
    }

    /**
     * 获取属性workfield
     * @return 属性workfield的值
     */
    public String getWorkField(){
        return workField;
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
