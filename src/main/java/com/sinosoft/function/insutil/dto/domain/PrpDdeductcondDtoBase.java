package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpddeductcond的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdeductcondDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性clausetype */
    private String clauseType = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性deductcondcode */
    private String deductCondCode = "";
    /** 属性deductcondname */
    private String deductCondName = "";
    /** 属性deductrate */
    private double deductRate = 0d;
    /** 属性deductible */
    private double deductible = 0d;
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDdeductcondDtoBase对象
     */
    public PrpDdeductcondDtoBase(){
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
     * 设置属性deductcondcode
     * @param deductCondCode 待设置的属性deductcondcode的值
     */
    public void setDeductCondCode(String deductCondCode){
        this.deductCondCode = StringUtils.rightTrim(deductCondCode);
    }

    /**
     * 获取属性deductcondcode
     * @return 属性deductcondcode的值
     */
    public String getDeductCondCode(){
        return deductCondCode;
    }

    /**
     * 设置属性deductcondname
     * @param deductCondName 待设置的属性deductcondname的值
     */
    public void setDeductCondName(String deductCondName){
        this.deductCondName = StringUtils.rightTrim(deductCondName);
    }

    /**
     * 获取属性deductcondname
     * @return 属性deductcondname的值
     */
    public String getDeductCondName(){
        return deductCondName;
    }

    /**
     * 设置属性deductrate
     * @param deductRate 待设置的属性deductrate的值
     */
    public void setDeductRate(double deductRate){
        this.deductRate = deductRate;
    }

    /**
     * 获取属性deductrate
     * @return 属性deductrate的值
     */
    public double getDeductRate(){
        return deductRate;
    }

    /**
     * 设置属性deductible
     * @param deductible 待设置的属性deductible的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性deductible
     * @return 属性deductible的值
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * 设置属性validdate
     * @param validDate 待设置的属性validdate的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性validdate
     * @return 属性validdate的值
     */
    public DateTime getValidDate(){
        return validDate;
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
