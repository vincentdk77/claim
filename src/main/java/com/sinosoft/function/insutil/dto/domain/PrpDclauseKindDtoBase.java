package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdclausekind的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseKindDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性clausetype */
    private String clauseType = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性relatekindcode */
    private String relateKindCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDclauseKindDtoBase对象
     */
    public PrpDclauseKindDtoBase(){
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
     * 设置属性clausetype
     * @param clauseType 待设置的属性clausetype的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性clausetype
     * @return 属性clausetype的值
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * 设置属性kindcode
     * @param kindCode 待设置的属性kindcode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性kindcode
     * @return 属性kindcode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性relatekindcode
     * @param relateKindCode 待设置的属性relatekindcode的值
     */
    public void setRelateKindCode(String relateKindCode){
        this.relateKindCode = StringUtils.rightTrim(relateKindCode);
    }

    /**
     * 获取属性relatekindcode
     * @return 属性relatekindcode的值
     */
    public String getRelateKindCode(){
        return relateKindCode;
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
