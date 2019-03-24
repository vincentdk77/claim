package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcoderisk通用代码险种对照表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeRiskDtoBase implements Serializable{
    /** 属性代码类型 */
    private String codeType = "";
    /** 属性业务代码 */
    private String codeCode = "";
    /** 属性险种代码 */
    private String riskCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcodeRiskDtoBase对象
     */
    public PrpDcodeRiskDtoBase(){
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
}
