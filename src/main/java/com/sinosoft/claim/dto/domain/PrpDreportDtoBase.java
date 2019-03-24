package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdreport报表配置文件的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDreportDtoBase implements Serializable{
    /** 属性报表号 */
    private String reportCode = "";
    /** 属性报表名称 */
    private String reportName = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性行号 */
    private int row = 0;
    /** 属性列号 */
    private int col = 0;
    /** 属性工作域含义 */
    private String workField = "";
    /** 属性备用 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDreportDtoBase对象
     */
    public PrpDreportDtoBase(){
    }

    /**
     * 设置属性报表号
     * @param reportCode 待设置的属性报表号的值
     */
    public void setReportCode(String reportCode){
        this.reportCode = StringUtils.rightTrim(reportCode);
    }

    /**
     * 获取属性报表号
     * @return 属性报表号的值
     */
    public String getReportCode(){
        return reportCode;
    }

    /**
     * 设置属性报表名称
     * @param reportName 待设置的属性报表名称的值
     */
    public void setReportName(String reportName){
        this.reportName = StringUtils.rightTrim(reportName);
    }

    /**
     * 获取属性报表名称
     * @return 属性报表名称的值
     */
    public String getReportName(){
        return reportName;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性行号
     * @param row 待设置的属性行号的值
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * 获取属性行号
     * @return 属性行号的值
     */
    public int getRow(){
        return row;
    }

    /**
     * 设置属性列号
     * @param col 待设置的属性列号的值
     */
    public void setCol(int col){
        this.col = col;
    }

    /**
     * 获取属性列号
     * @return 属性列号的值
     */
    public int getCol(){
        return col;
    }

    /**
     * 设置属性工作域含义
     * @param workField 待设置的属性工作域含义的值
     */
    public void setWorkField(String workField){
        this.workField = StringUtils.rightTrim(workField);
    }

    /**
     * 获取属性工作域含义
     * @return 属性工作域含义的值
     */
    public String getWorkField(){
        return workField;
    }

    /**
     * 设置属性备用
     * @param flag 待设置的属性备用的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性备用
     * @return 属性备用的值
     */
    public String getFlag(){
        return flag;
    }
}
