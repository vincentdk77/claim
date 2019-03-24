package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdlimit的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDlimitDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性limitcode */
    private String limitCode = "";
    /** 属性limitcname */
    private String limitCName = "";
    /** 属性limitename */
    private String limitEName = "";
    /** 属性limitpriority */
    private String limitPriority = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性itemcode */
    private String itemCode = "";
    /** 属性modecode */
    private String modeCode = "";
    /** 属性limitfee */
    private double limitFee = 0d;
    /** 属性limitrelation */
    private String limitRelation = "";
    /** 属性limitrelationdesc */
    private String limitRelationDesc = "";
    /** 属性newlimitcode */
    private String newLimitCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性limitflag */
    private String limitFlag = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDlimitDtoBase对象
     */
    public PrpDlimitDtoBase(){
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
     * 设置属性limitcode
     * @param limitCode 待设置的属性limitcode的值
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * 获取属性limitcode
     * @return 属性limitcode的值
     */
    public String getLimitCode(){
        return limitCode;
    }

    /**
     * 设置属性limitcname
     * @param limitCName 待设置的属性limitcname的值
     */
    public void setLimitCName(String limitCName){
        this.limitCName = StringUtils.rightTrim(limitCName);
    }

    /**
     * 获取属性limitcname
     * @return 属性limitcname的值
     */
    public String getLimitCName(){
        return limitCName;
    }

    /**
     * 设置属性limitename
     * @param limitEName 待设置的属性limitename的值
     */
    public void setLimitEName(String limitEName){
        this.limitEName = StringUtils.rightTrim(limitEName);
    }

    /**
     * 获取属性limitename
     * @return 属性limitename的值
     */
    public String getLimitEName(){
        return limitEName;
    }

    /**
     * 设置属性limitpriority
     * @param limitPriority 待设置的属性limitpriority的值
     */
    public void setLimitPriority(String limitPriority){
        this.limitPriority = StringUtils.rightTrim(limitPriority);
    }

    /**
     * 获取属性limitpriority
     * @return 属性limitpriority的值
     */
    public String getLimitPriority(){
        return limitPriority;
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
     * 设置属性itemcode
     * @param itemCode 待设置的属性itemcode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性itemcode
     * @return 属性itemcode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性modecode
     * @param modeCode 待设置的属性modecode的值
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * 获取属性modecode
     * @return 属性modecode的值
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * 设置属性limitfee
     * @param limitFee 待设置的属性limitfee的值
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * 获取属性limitfee
     * @return 属性limitfee的值
     */
    public double getLimitFee(){
        return limitFee;
    }

    /**
     * 设置属性limitrelation
     * @param limitRelation 待设置的属性limitrelation的值
     */
    public void setLimitRelation(String limitRelation){
        this.limitRelation = StringUtils.rightTrim(limitRelation);
    }

    /**
     * 获取属性limitrelation
     * @return 属性limitrelation的值
     */
    public String getLimitRelation(){
        return limitRelation;
    }

    /**
     * 设置属性limitrelationdesc
     * @param limitRelationDesc 待设置的属性limitrelationdesc的值
     */
    public void setLimitRelationDesc(String limitRelationDesc){
        this.limitRelationDesc = StringUtils.rightTrim(limitRelationDesc);
    }

    /**
     * 获取属性limitrelationdesc
     * @return 属性limitrelationdesc的值
     */
    public String getLimitRelationDesc(){
        return limitRelationDesc;
    }

    /**
     * 设置属性newlimitcode
     * @param newLimitCode 待设置的属性newlimitcode的值
     */
    public void setNewLimitCode(String newLimitCode){
        this.newLimitCode = StringUtils.rightTrim(newLimitCode);
    }

    /**
     * 获取属性newlimitcode
     * @return 属性newlimitcode的值
     */
    public String getNewLimitCode(){
        return newLimitCode;
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
     * 设置属性limitflag
     * @param limitFlag 待设置的属性limitflag的值
     */
    public void setLimitFlag(String limitFlag){
        this.limitFlag = StringUtils.rightTrim(limitFlag);
    }

    /**
     * 获取属性limitflag
     * @return 属性limitflag的值
     */
    public String getLimitFlag(){
        return limitFlag;
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
