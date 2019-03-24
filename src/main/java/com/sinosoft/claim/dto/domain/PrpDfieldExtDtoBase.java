package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdfieldext扩展字段的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDfieldExtDtoBase implements Serializable{
    /** 属性代码类型 */
    private String codeType = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性业务代码 */
    private String codeCode = "";
    /** 属性代码中文含义 */
    private String codeCName = "";
    /** 属性扩充字段名 */
    private String columnName = "";
    /** 属性显示名称 */
    private String displayName = "";
    /** 属性键标志 */
    private String keyFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDfieldExtDtoBase对象
     */
    public PrpDfieldExtDtoBase(){
    }

    /**
     * 设置属性代码类型
     * @param codeType 待设置的属性代码类型的值
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * 获取属性代码类型
     * @return 属性代码类型的值
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性业务代码
     * @param codeCode 待设置的属性业务代码的值
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * 获取属性业务代码
     * @return 属性业务代码的值
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * 设置属性代码中文含义
     * @param codeCName 待设置的属性代码中文含义的值
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * 获取属性代码中文含义
     * @return 属性代码中文含义的值
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * 设置属性扩充字段名
     * @param columnName 待设置的属性扩充字段名的值
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * 获取属性扩充字段名
     * @return 属性扩充字段名的值
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * 设置属性显示名称
     * @param displayName 待设置的属性显示名称的值
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * 获取属性显示名称
     * @return 属性显示名称的值
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * 设置属性键标志
     * @param keyFlag 待设置的属性键标志的值
     */
    public void setKeyFlag(String keyFlag){
        this.keyFlag = StringUtils.rightTrim(keyFlag);
    }

    /**
     * 获取属性键标志
     * @return 属性键标志的值
     */
    public String getKeyFlag(){
        return keyFlag;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
