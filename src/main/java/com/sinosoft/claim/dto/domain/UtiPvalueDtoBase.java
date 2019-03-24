package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utipvalue单证打印数据的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPvalueDtoBase implements Serializable{
    /** 属性终端号 */
    private String ttyName = "";
    /** 属性标号 */
    private String labelNo = "";
    /** 属性值 */
    private String fieldValu = "";
    /** 属性行号 */
    private int lineNo = 0;

    /**
     *  默认构造方法,构造一个默认的UtiPvalueDtoBase对象
     */
    public UtiPvalueDtoBase(){
    }

    /**
     * 设置属性终端号
     * @param ttyName 待设置的属性终端号的值
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * 获取属性终端号
     * @return 属性终端号的值
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * 设置属性标号
     * @param labelNo 待设置的属性标号的值
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * 获取属性标号
     * @return 属性标号的值
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * 设置属性值
     * @param fieldValu 待设置的属性值的值
     */
    public void setFieldValu(String fieldValu){
        this.fieldValu = StringUtils.rightTrim(fieldValu);
    }

    /**
     * 获取属性值
     * @return 属性值的值
     */
    public String getFieldValu(){
        return fieldValu;
    }

    /**
     * 设置属性行号
     * @param lineNo 待设置的属性行号的值
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * 获取属性行号
     * @return 属性行号的值
     */
    public int getLineNo(){
        return lineNo;
    }
}
