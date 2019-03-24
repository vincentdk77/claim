package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdratecond的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateCondDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性rateperiod */
    private int ratePeriod = 0;
    /** 属性condcode */
    private String condCode = "";
    /** 属性condname */
    private String condName = "";
    /** 属性lowervalue */
    private double lowerValue = 0d;
    /** 属性uppervalue */
    private double upperValue = 0d;
    /** 属性valuecode */
    private String valueCode = "";
    /** 属性valuename */
    private String valueName = "";
    /** 属性startpos */
    private int startPos = 0;
    /** 属性endpos */
    private int endPos = 0;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateCondDtoBase对象
     */
    public PrpDrateCondDtoBase(){
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
     * 设置属性rateperiod
     * @param ratePeriod 待设置的属性rateperiod的值
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * 获取属性rateperiod
     * @return 属性rateperiod的值
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * 设置属性condcode
     * @param condCode 待设置的属性condcode的值
     */
    public void setCondCode(String condCode){
        this.condCode = StringUtils.rightTrim(condCode);
    }

    /**
     * 获取属性condcode
     * @return 属性condcode的值
     */
    public String getCondCode(){
        return condCode;
    }

    /**
     * 设置属性condname
     * @param condName 待设置的属性condname的值
     */
    public void setCondName(String condName){
        this.condName = StringUtils.rightTrim(condName);
    }

    /**
     * 获取属性condname
     * @return 属性condname的值
     */
    public String getCondName(){
        return condName;
    }

    /**
     * 设置属性lowervalue
     * @param lowerValue 待设置的属性lowervalue的值
     */
    public void setLowerValue(double lowerValue){
        this.lowerValue = lowerValue;
    }

    /**
     * 获取属性lowervalue
     * @return 属性lowervalue的值
     */
    public double getLowerValue(){
        return lowerValue;
    }

    /**
     * 设置属性uppervalue
     * @param upperValue 待设置的属性uppervalue的值
     */
    public void setUpperValue(double upperValue){
        this.upperValue = upperValue;
    }

    /**
     * 获取属性uppervalue
     * @return 属性uppervalue的值
     */
    public double getUpperValue(){
        return upperValue;
    }

    /**
     * 设置属性valuecode
     * @param valueCode 待设置的属性valuecode的值
     */
    public void setValueCode(String valueCode){
        this.valueCode = StringUtils.rightTrim(valueCode);
    }

    /**
     * 获取属性valuecode
     * @return 属性valuecode的值
     */
    public String getValueCode(){
        return valueCode;
    }

    /**
     * 设置属性valuename
     * @param valueName 待设置的属性valuename的值
     */
    public void setValueName(String valueName){
        this.valueName = StringUtils.rightTrim(valueName);
    }

    /**
     * 获取属性valuename
     * @return 属性valuename的值
     */
    public String getValueName(){
        return valueName;
    }

    /**
     * 设置属性startpos
     * @param startPos 待设置的属性startpos的值
     */
    public void setStartPos(int startPos){
        this.startPos = startPos;
    }

    /**
     * 获取属性startpos
     * @return 属性startpos的值
     */
    public int getStartPos(){
        return startPos;
    }

    /**
     * 设置属性endpos
     * @param endPos 待设置的属性endpos的值
     */
    public void setEndPos(int endPos){
        this.endPos = endPos;
    }

    /**
     * 获取属性endpos
     * @return 属性endpos的值
     */
    public int getEndPos(){
        return endPos;
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
