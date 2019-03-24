package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utipvalue的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPvalueDtoBase implements Serializable{
    /** 属性ttyname */
    private String ttyName = "";
    /** 属性labelno */
    private String labelNo = "";
    /** 属性fieldvalu */
    private String fieldValu = "";
    /** 属性lineno */
    private int lineNo = 0;

    /**
     *  默认构造方法,构造一个默认的UtiPvalueDtoBase对象
     */
    public UtiPvalueDtoBase(){
    }

    /**
     * 设置属性ttyname
     * @param ttyName 待设置的属性ttyname的值
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * 获取属性ttyname
     * @return 属性ttyname的值
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * 设置属性labelno
     * @param labelNo 待设置的属性labelno的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性labelno
     * @return 属性labelno的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性fieldvalu
     * @param fieldValu 待设置的属性fieldvalu的值
     */
    public void setFieldValu(String fieldValu){
        this.fieldValu = StringUtils.rightTrim(fieldValu);
    }

    /**
     * 获取属性fieldvalu
     * @return 属性fieldvalu的值
     */
    public String getFieldValu(){
        return fieldValu;
    }

    /**
     * 设置属性lineno
     * @param lineNo 待设置的属性lineno的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性lineno
     * @return 属性lineno的值
     */
    public int getLineNo(){
        return lineNo;
    }
}
