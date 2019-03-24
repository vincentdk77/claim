package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrisk的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性riskcname */
    private String riskCName = "";
    /** 属性riskename */
    private String riskEName = "";
    /** 属性classcode */
    private String classCode = "";
    /** 属性calculator */
    private int calculator = 0;
    /** 属性EndDateFlag */
    private String endDateFlag = "";
    /** 属性riskflag */
    private String riskFlag = "";
    /** 属性starthour */
    private int startHour = 0;
    /** 属性newriskcode */
    private String newRiskCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性articlecode */
    private String articleCode = "";
    /** 属性manageflag */
    private String manageFlag = "";
    /** 属性settletype */
    private String settleType = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDriskDtoBase对象
     */
    public PrpDriskDtoBase(){
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
     * 设置属性riskcname
     * @param riskCName 待设置的属性riskcname的值
     */
    public void setRiskCName(String riskCName){
        this.riskCName = StringUtils.rightTrim(riskCName);
    }

    /**
     * 获取属性riskcname
     * @return 属性riskcname的值
     */
    public String getRiskCName(){
        return riskCName;
    }

    /**
     * 设置属性riskename
     * @param riskEName 待设置的属性riskename的值
     */
    public void setRiskEName(String riskEName){
        this.riskEName = StringUtils.rightTrim(riskEName);
    }

    /**
     * 获取属性riskename
     * @return 属性riskename的值
     */
    public String getRiskEName(){
        return riskEName;
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
     * 设置属性calculator
     * @param calculator 待设置的属性calculator的值
     */
    public void setCalculator(int calculator){
        this.calculator = calculator;
    }

    /**
     * 获取属性calculator
     * @return 属性calculator的值
     */
    public int getCalculator(){
        return calculator;
    }

    /**
     * 设置属性EndDateFlag
     * @param endDateFlag 待设置的属性EndDateFlag的值
     */
    public void setEndDateFlag(String endDateFlag){
        this.endDateFlag = StringUtils.rightTrim(endDateFlag);
    }

    /**
     * 获取属性EndDateFlag
     * @return 属性EndDateFlag的值
     */
    public String getEndDateFlag(){
        return endDateFlag;
    }

    /**
     * 设置属性riskflag
     * @param riskFlag 待设置的属性riskflag的值
     */
    public void setRiskFlag(String riskFlag){
        this.riskFlag = StringUtils.rightTrim(riskFlag);
    }

    /**
     * 获取属性riskflag
     * @return 属性riskflag的值
     */
    public String getRiskFlag(){
        return riskFlag;
    }

    /**
     * 设置属性starthour
     * @param startHour 待设置的属性starthour的值
     */
    public void setStartHour(int startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性starthour
     * @return 属性starthour的值
     */
    public int getStartHour(){
        return startHour;
    }

    /**
     * 设置属性newriskcode
     * @param newRiskCode 待设置的属性newriskcode的值
     */
    public void setNewRiskCode(String newRiskCode){
        this.newRiskCode = StringUtils.rightTrim(newRiskCode);
    }

    /**
     * 获取属性newriskcode
     * @return 属性newriskcode的值
     */
    public String getNewRiskCode(){
        return newRiskCode;
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
     * 设置属性articlecode
     * @param articleCode 待设置的属性articlecode的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性articlecode
     * @return 属性articlecode的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性manageflag
     * @param manageFlag 待设置的属性manageflag的值
     */
    public void setManageFlag(String manageFlag){
        this.manageFlag = StringUtils.rightTrim(manageFlag);
    }

    /**
     * 获取属性manageflag
     * @return 属性manageflag的值
     */
    public String getManageFlag(){
        return manageFlag;
    }

    /**
     * 设置属性settletype
     * @param settleType 待设置的属性settletype的值
     */
    public void setSettleType(String settleType){
        this.settleType = StringUtils.rightTrim(settleType);
    }

    /**
     * 获取属性settletype
     * @return 属性settletype的值
     */
    public String getSettleType(){
        return settleType;
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
