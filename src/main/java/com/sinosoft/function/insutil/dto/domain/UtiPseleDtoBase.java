package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utipsele的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPseleDtoBase implements Serializable{
    /** 属性filename */
    private String fileName = "";
    /** 属性orderno */
    private String orderNo = "";
    /** 属性fieldname */
    private String fieldName = "";
    /** 属性selflag */
    private String selFlag = "";
    /** 属性tabname */
    private String tabName = "";
    /** 属性whereclause */
    private String whereClause = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiPseleDtoBase对象
     */
    public UtiPseleDtoBase(){
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
     * 设置属性orderno
     * @param orderNo 待设置的属性orderno的值
     */
    public void setOrderNo(String orderNo){
        this.orderNo = StringUtils.rightTrim(orderNo);
    }

    /**
     * 获取属性orderno
     * @return 属性orderno的值
     */
    public String getOrderNo(){
        return orderNo;
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
     * 设置属性selflag
     * @param selFlag 待设置的属性selflag的值
     */
    public void setSelFlag(String selFlag){
        this.selFlag = StringUtils.rightTrim(selFlag);
    }

    /**
     * 获取属性selflag
     * @return 属性selflag的值
     */
    public String getSelFlag(){
        return selFlag;
    }

    /**
     * 设置属性tabname
     * @param tabName 待设置的属性tabname的值
     */
    public void setTabName(String tabName){
        this.tabName = StringUtils.rightTrim(tabName);
    }

    /**
     * 获取属性tabname
     * @return 属性tabname的值
     */
    public String getTabName(){
        return tabName;
    }

    /**
     * 设置属性whereclause
     * @param whereClause 待设置的属性whereclause的值
     */
    public void setWhereClause(String whereClause){
        this.whereClause = StringUtils.rightTrim(whereClause);
    }

    /**
     * 获取属性whereclause
     * @return 属性whereclause的值
     */
    public String getWhereClause(){
        return whereClause;
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
