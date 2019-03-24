package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrateloan的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateLoanDtoBase implements Serializable{
    /** 属性period */
    private int period = 0;
    /** 属性classcode */
    private String classCode = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性kindname */
    private String kindName = "";
    /** 属性comcode */
    private String comCode = "";
    /** 属性years */
    private int years = 0;
    /** 属性coefficient */
    private double coefficient = 0d;
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateLoanDtoBase对象
     */
    public PrpDrateLoanDtoBase(){
    }

    /**
     * 设置属性period
     * @param period 待设置的属性period的值
     */
    public void setPeriod(int period){
        this.period = period;
    }

    /**
     * 获取属性period
     * @return 属性period的值
     */
    public int getPeriod(){
        return period;
    }

    /**
     * 设置属性classcode
     * @param classCode 待设置的属性classcode的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性classcode
     * @return 属性classcode的值
     */
    public String getClassCode(){
        return classCode;
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
     * 设置属性kindname
     * @param kindName 待设置的属性kindname的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性kindname
     * @return 属性kindname的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性comcode
     * @param comCode 待设置的属性comcode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comcode
     * @return 属性comcode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性years
     * @param years 待设置的属性years的值
     */
    public void setYears(int years){
        this.years = years;
    }

    /**
     * 获取属性years
     * @return 属性years的值
     */
    public int getYears(){
        return years;
    }

    /**
     * 设置属性coefficient
     * @param coefficient 待设置的属性coefficient的值
     */
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }

    /**
     * 获取属性coefficient
     * @return 属性coefficient的值
     */
    public double getCoefficient(){
        return coefficient;
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
