package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdclausekind条款险别关系表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:40<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseKindDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性关联险别代码 */
    private String relateKindCode = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDclauseKindDtoBase对象
     */
    public PrpDclauseKindDtoBase(){
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
     * 设置属性条款类别
     * @param clauseType 待设置的属性条款类别的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性条款类别
     * @return 属性条款类别的值
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性关联险别代码
     * @param relateKindCode 待设置的属性关联险别代码的值
     */
    public void setRelateKindCode(String relateKindCode){
        this.relateKindCode = StringUtils.rightTrim(relateKindCode);
    }

    /**
     * 获取属性关联险别代码
     * @return 属性关联险别代码的值
     */
    public String getRelateKindCode(){
        return relateKindCode;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
