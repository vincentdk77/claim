package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utipsele单证打印的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPseleDtoBase implements Serializable{
    /** 属性文件名 */
    private String fileName = "";
    /** 属性序号 */
    private String orderNo = "";
    /** 属性字段名称 */
    private String fieldName = "";
    /** 属性取数标志 */
    private String selFlag = "";
    /** 属性表名 */
    private String tabName = "";
    /** 属性WHERE条件 */
    private String whereClause = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPseleDtoBase对象
     */
    public UtiPseleDtoBase(){
    }

    /**
     * 设置属性文件名
     * @param fileName 待设置的属性文件名的值
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * 获取属性文件名
     * @return 属性文件名的值
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * 设置属性序号
     * @param orderNo 待设置的属性序号的值
     */
    public void setOrderNo(String orderNo){
        this.orderNo = StringUtils.rightTrim(orderNo);
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public String getOrderNo(){
        return orderNo;
    }

    /**
     * 设置属性字段名称
     * @param fieldName 待设置的属性字段名称的值
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * 获取属性字段名称
     * @return 属性字段名称的值
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * 设置属性取数标志
     * @param selFlag 待设置的属性取数标志的值
     */
    public void setSelFlag(String selFlag){
        this.selFlag = StringUtils.rightTrim(selFlag);
    }

    /**
     * 获取属性取数标志
     * @return 属性取数标志的值
     */
    public String getSelFlag(){
        return selFlag;
    }

    /**
     * 设置属性表名
     * @param tabName 待设置的属性表名的值
     */
    public void setTabName(String tabName){
        this.tabName = StringUtils.rightTrim(tabName);
    }

    /**
     * 获取属性表名
     * @return 属性表名的值
     */
    public String getTabName(){
        return tabName;
    }

    /**
     * 设置属性WHERE条件
     * @param whereClause 待设置的属性WHERE条件的值
     */
    public void setWhereClause(String whereClause){
        this.whereClause = StringUtils.rightTrim(whereClause);
    }

    /**
     * 获取属性WHERE条件
     * @return 属性WHERE条件的值
     */
    public String getWhereClause(){
        return whereClause;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
