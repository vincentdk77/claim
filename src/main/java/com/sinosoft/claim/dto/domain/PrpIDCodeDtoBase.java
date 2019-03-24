package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpidcode接口代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDCodeDtoBase implements Serializable{
    /** 属性接口代码类型 */
    private String codeType = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性代码 */
    private String codeCode = "";
    /** 属性代码中文名称 */
    private String codeCName = "";
    /** 属性代码英文名称 */
    private String codeEName = "";
    /** 属性接口数据库对照代码 */
    private String excodecode = "";

    /**
     *  默认构造方法,构造一个默认的PrpIDCodeDtoBase对象
     */
    public PrpIDCodeDtoBase(){
    }

    /**
     * 设置属性接口代码类型
     * @param codeType 待设置的属性接口代码类型的值
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * 获取属性接口代码类型
     * @return 属性接口代码类型的值
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
     * 设置属性代码
     * @param codeCode 待设置的属性代码的值
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * 获取属性代码
     * @return 属性代码的值
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * 设置属性代码中文名称
     * @param codeCName 待设置的属性代码中文名称的值
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * 获取属性代码中文名称
     * @return 属性代码中文名称的值
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * 设置属性代码英文名称
     * @param codeEName 待设置的属性代码英文名称的值
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * 获取属性代码英文名称
     * @return 属性代码英文名称的值
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * 设置属性接口数据库对照代码
     * @param excodecode 待设置的属性接口数据库对照代码的值
     */
    public void setExcodecode(String excodecode){
        this.excodecode = StringUtils.rightTrim(excodecode);
    }

    /**
     * 获取属性接口数据库对照代码
     * @return 属性接口数据库对照代码的值
     */
    public String getExcodecode(){
        return excodecode;
    }
}
