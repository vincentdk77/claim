package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdfieldext的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDfieldExtDtoBase implements Serializable{
    /** 属性codetype */
    private String codeType = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性codecode */
    private String codeCode = "";
    /** 属性codecname */
    private String codeCName = "";
    /** 属性columnname */
    private String columnName = "";
    /** 属性displayname */
    private String displayName = "";
    /** 属性keyflag */
    private String keyFlag = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDfieldExtDtoBase对象
     */
    public PrpDfieldExtDtoBase(){
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
     * 设置属性columnname
     * @param columnName 待设置的属性columnname的值
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * 获取属性columnname
     * @return 属性columnname的值
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * 设置属性displayname
     * @param displayName 待设置的属性displayname的值
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * 获取属性displayname
     * @return 属性displayname的值
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * 设置属性keyflag
     * @param keyFlag 待设置的属性keyflag的值
     */
    public void setKeyFlag(String keyFlag){
        this.keyFlag = StringUtils.rightTrim(keyFlag);
    }

    /**
     * 获取属性keyflag
     * @return 属性keyflag的值
     */
    public String getKeyFlag(){
        return keyFlag;
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
