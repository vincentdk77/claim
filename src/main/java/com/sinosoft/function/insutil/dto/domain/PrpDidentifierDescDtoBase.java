package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdidentifierdesc的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDescDtoBase implements Serializable{
    /** 属性identifiercode */
    private String identifierCode = "";
    /** 属性lineno */
    private int lineNo = 0;
    /** 属性mark */
    private String mark = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDidentifierDescDtoBase对象
     */
    public PrpDidentifierDescDtoBase(){
    }

    /**
     * 设置属性identifiercode
     * @param identifierCode 待设置的属性identifiercode的值
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * 获取属性identifiercode
     * @return 属性identifiercode的值
     */
    public String getIdentifierCode(){
        return identifierCode;
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

    /**
     * 设置属性mark
     * @param mark 待设置的属性mark的值
     */
    public void setMark(String mark){
        this.mark = StringUtils.rightTrim(mark);
    }

    /**
     * 获取属性mark
     * @return 属性mark的值
     */
    public String getMark(){
        return mark;
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
