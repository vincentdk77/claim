package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdtype的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDtypeDtoBase implements Serializable{
    /** 属性codetype */
    private String codeType = "";
    /** 属性codetypedesc */
    private String codeTypeDesc = "";
    /** 属性newcodetype */
    private String newCodeType = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDtypeDtoBase对象
     */
    public PrpDtypeDtoBase(){
    }

    /**
     * 设置属性codetype
     * @param codeType 待设置的属性codetype的值
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * 获取属性codetype
     * @return 属性codetype的值
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * 设置属性codetypedesc
     * @param codeTypeDesc 待设置的属性codetypedesc的值
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * 获取属性codetypedesc
     * @return 属性codetypedesc的值
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }

    /**
     * 设置属性newcodetype
     * @param newCodeType 待设置的属性newcodetype的值
     */
    public void setNewCodeType(String newCodeType){
        this.newCodeType = StringUtils.rightTrim(newCodeType);
    }

    /**
     * 获取属性newcodetype
     * @return 属性newcodetype的值
     */
    public String getNewCodeType(){
        return newCodeType;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
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
