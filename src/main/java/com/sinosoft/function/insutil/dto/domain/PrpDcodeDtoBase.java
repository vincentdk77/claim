package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcode的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeDtoBase implements Serializable{
    /** 属性codetype */
    private String codeType = "";
    /** 属性codecode */
    private String codeCode = "";
    /** 属性codecname */
    private String codeCName = "";
    /** 属性codeename */
    private String codeEName = "";
    /** 属性newcodecode */
    private String newCodeCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcodeDtoBase对象
     */
    public PrpDcodeDtoBase(){
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
     * 设置属性codecode
     * @param codeCode 待设置的属性codecode的值
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * 获取属性codecode
     * @return 属性codecode的值
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * 设置属性codecname
     * @param codeCName 待设置的属性codecname的值
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * 获取属性codecname
     * @return 属性codecname的值
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * 设置属性codeename
     * @param codeEName 待设置的属性codeename的值
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * 获取属性codeename
     * @return 属性codeename的值
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * 设置属性newcodecode
     * @param newCodeCode 待设置的属性newcodecode的值
     */
    public void setNewCodeCode(String newCodeCode){
        this.newCodeCode = StringUtils.rightTrim(newCodeCode);
    }

    /**
     * 获取属性newcodecode
     * @return 属性newcodecode的值
     */
    public String getNewCodeCode(){
        return newCodeCode;
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
