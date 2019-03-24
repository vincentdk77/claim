package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpidcode的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDcodeDtoBase implements Serializable{
    /** 属性codetype */
    private String codeType = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性codecode */
    private String codeCode = "";
    /** 属性codecname */
    private String codeCName = "";
    /** 属性codeename */
    private String codeEName = "";
    /** 属性excodecode */
    private String excodecode = "";

    /**
     *  默认构造方法,构造一个默认的PrpIDcodeDtoBase对象
     */
    public PrpIDcodeDtoBase(){
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
     * 设置属性excodecode
     * @param excodecode 待设置的属性excodecode的值
     */
    public void setExcodecode(String excodecode){
        this.excodecode = StringUtils.rightTrim(excodecode);
    }

    /**
     * 获取属性excodecode
     * @return 属性excodecode的值
     */
    public String getExcodecode(){
        return excodecode;
    }
}
