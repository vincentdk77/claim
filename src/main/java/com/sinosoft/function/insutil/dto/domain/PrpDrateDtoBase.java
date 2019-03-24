package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrate的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateDtoBase implements Serializable{
    /** 属性serialno */
    private int serialNo = 0;
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
    /** 属性possessnature */
    private String possessNature = "";
    /** 属性businesssource */
    private String businessSource = "";
    /** 属性businessdetail */
    private String businessDetail = "";
    /** 属性itemcode */
    private String itemCode = "";
    /** 属性itemname */
    private String itemName = "";
    /** 属性years */
    private int years = 0;
    /** 属性preturnover */
    private double preturnOver = 0d;
    /** 属性limittype */
    private String limitType = "";
    /** 属性currency */
    private String currency = "";
    /** 属性limitfeelower */
    private double limitFeeLower = 0d;
    /** 属性limitfeeupper */
    private double limitFeeUpper = 0d;
    /** 属性baseratelower */
    private double baseRateLower = 0d;
    /** 属性baserateupper */
    private double baseRateUpper = 0d;
    /** 属性rateratio */
    private double rateRatio = 0d;
    /** 属性premium */
    private double premium = 0d;
    /** 属性ratecode */
    private String rateCode = "";
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateDtoBase对象
     */
    public PrpDrateDtoBase(){
    }

    /**
     * 设置属性serialno
     * @param serialNo 待设置的属性serialno的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialno
     * @return 属性serialno的值
     */
    public int getSerialNo(){
        return serialNo;
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
     * 设置属性possessnature
     * @param possessNature 待设置的属性possessnature的值
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * 获取属性possessnature
     * @return 属性possessnature的值
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * 设置属性businesssource
     * @param businessSource 待设置的属性businesssource的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性businesssource
     * @return 属性businesssource的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性businessdetail
     * @param businessDetail 待设置的属性businessdetail的值
     */
    public void setBusinessDetail(String businessDetail){
        this.businessDetail = StringUtils.rightTrim(businessDetail);
    }

    /**
     * 获取属性businessdetail
     * @return 属性businessdetail的值
     */
    public String getBusinessDetail(){
        return businessDetail;
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
     * 设置属性itemname
     * @param itemName 待设置的属性itemname的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性itemname
     * @return 属性itemname的值
     */
    public String getItemName(){
        return itemName;
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
     * 设置属性preturnover
     * @param preturnOver 待设置的属性preturnover的值
     */
    public void setPreturnOver(double preturnOver){
        this.preturnOver = preturnOver;
    }

    /**
     * 获取属性preturnover
     * @return 属性preturnover的值
     */
    public double getPreturnOver(){
        return preturnOver;
    }

    /**
     * 设置属性limittype
     * @param limitType 待设置的属性limittype的值
     */
    public void setLimitType(String limitType){
        this.limitType = StringUtils.rightTrim(limitType);
    }

    /**
     * 获取属性limittype
     * @return 属性limittype的值
     */
    public String getLimitType(){
        return limitType;
    }

    /**
     * 设置属性currency
     * @param currency 待设置的属性currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性currency
     * @return 属性currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性limitfeelower
     * @param limitFeeLower 待设置的属性limitfeelower的值
     */
    public void setLimitFeeLower(double limitFeeLower){
        this.limitFeeLower = limitFeeLower;
    }

    /**
     * 获取属性limitfeelower
     * @return 属性limitfeelower的值
     */
    public double getLimitFeeLower(){
        return limitFeeLower;
    }

    /**
     * 设置属性limitfeeupper
     * @param limitFeeUpper 待设置的属性limitfeeupper的值
     */
    public void setLimitFeeUpper(double limitFeeUpper){
        this.limitFeeUpper = limitFeeUpper;
    }

    /**
     * 获取属性limitfeeupper
     * @return 属性limitfeeupper的值
     */
    public double getLimitFeeUpper(){
        return limitFeeUpper;
    }

    /**
     * 设置属性baseratelower
     * @param baseRateLower 待设置的属性baseratelower的值
     */
    public void setBaseRateLower(double baseRateLower){
        this.baseRateLower = baseRateLower;
    }

    /**
     * 获取属性baseratelower
     * @return 属性baseratelower的值
     */
    public double getBaseRateLower(){
        return baseRateLower;
    }

    /**
     * 设置属性baserateupper
     * @param baseRateUpper 待设置的属性baserateupper的值
     */
    public void setBaseRateUpper(double baseRateUpper){
        this.baseRateUpper = baseRateUpper;
    }

    /**
     * 获取属性baserateupper
     * @return 属性baserateupper的值
     */
    public double getBaseRateUpper(){
        return baseRateUpper;
    }

    /**
     * 设置属性rateratio
     * @param rateRatio 待设置的属性rateratio的值
     */
    public void setRateRatio(double rateRatio){
        this.rateRatio = rateRatio;
    }

    /**
     * 获取属性rateratio
     * @return 属性rateratio的值
     */
    public double getRateRatio(){
        return rateRatio;
    }

    /**
     * 设置属性premium
     * @param premium 待设置的属性premium的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性premium
     * @return 属性premium的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性ratecode
     * @param rateCode 待设置的属性ratecode的值
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * 获取属性ratecode
     * @return 属性ratecode的值
     */
    public String getRateCode(){
        return rateCode;
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
