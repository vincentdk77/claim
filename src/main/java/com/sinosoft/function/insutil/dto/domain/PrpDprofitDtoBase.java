package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdprofit的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDprofitDtoBase implements Serializable{
    /** 属性comcode */
    private String comCode = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性profitperiod */
    private int profitPeriod = 0;
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性profitcode */
    private String profitCode = "";
    /** 属性profitname */
    private String profitName = "";
    /** 属性serialno */
    private int serialNo = 0;
    /** 属性condition */
    private String condition = "";
    /** 属性fieldvaluelower */
    private double fieldValueLower = 0d;
    /** 属性fieldvalueupper */
    private double fieldValueUpper = 0d;
    /** 属性minprofitrate */
    private double minprofitrate = 0d;
    /** 属性profitrate */
    private double profitRate = 0d;
    /** 属性maxprofitrate */
    private double maxProfitRate = 0d;
    /** 属性profitflag */
    private String profitFlag = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDprofitDtoBase对象
     */
    public PrpDprofitDtoBase(){
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
     * 设置属性profitperiod
     * @param profitPeriod 待设置的属性profitperiod的值
     */
    public void setProfitPeriod(int profitPeriod){
        this.profitPeriod = profitPeriod;
    }

    /**
     * 获取属性profitperiod
     * @return 属性profitperiod的值
     */
    public int getProfitPeriod(){
        return profitPeriod;
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
     * 设置属性profitcode
     * @param profitCode 待设置的属性profitcode的值
     */
    public void setProfitCode(String profitCode){
        this.profitCode = StringUtils.rightTrim(profitCode);
    }

    /**
     * 获取属性profitcode
     * @return 属性profitcode的值
     */
    public String getProfitCode(){
        return profitCode;
    }

    /**
     * 设置属性profitname
     * @param profitName 待设置的属性profitname的值
     */
    public void setProfitName(String profitName){
        this.profitName = StringUtils.rightTrim(profitName);
    }

    /**
     * 获取属性profitname
     * @return 属性profitname的值
     */
    public String getProfitName(){
        return profitName;
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
     * 设置属性condition
     * @param condition 待设置的属性condition的值
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * 获取属性condition
     * @return 属性condition的值
     */
    public String getCondition(){
        return condition;
    }

    /**
     * 设置属性fieldvaluelower
     * @param fieldValueLower 待设置的属性fieldvaluelower的值
     */
    public void setFieldValueLower(double fieldValueLower){
        this.fieldValueLower = fieldValueLower;
    }

    /**
     * 获取属性fieldvaluelower
     * @return 属性fieldvaluelower的值
     */
    public double getFieldValueLower(){
        return fieldValueLower;
    }

    /**
     * 设置属性fieldvalueupper
     * @param fieldValueUpper 待设置的属性fieldvalueupper的值
     */
    public void setFieldValueUpper(double fieldValueUpper){
        this.fieldValueUpper = fieldValueUpper;
    }

    /**
     * 获取属性fieldvalueupper
     * @return 属性fieldvalueupper的值
     */
    public double getFieldValueUpper(){
        return fieldValueUpper;
    }

    /**
     * 设置属性minprofitrate
     * @param minprofitrate 待设置的属性minprofitrate的值
     */
    public void setMinprofitrate(double minprofitrate){
        this.minprofitrate = minprofitrate;
    }

    /**
     * 获取属性minprofitrate
     * @return 属性minprofitrate的值
     */
    public double getMinprofitrate(){
        return minprofitrate;
    }

    /**
     * 设置属性profitrate
     * @param profitRate 待设置的属性profitrate的值
     */
    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }

    /**
     * 获取属性profitrate
     * @return 属性profitrate的值
     */
    public double getProfitRate(){
        return profitRate;
    }

    /**
     * 设置属性maxprofitrate
     * @param maxProfitRate 待设置的属性maxprofitrate的值
     */
    public void setMaxProfitRate(double maxProfitRate){
        this.maxProfitRate = maxProfitRate;
    }

    /**
     * 获取属性maxprofitrate
     * @return 属性maxprofitrate的值
     */
    public double getMaxProfitRate(){
        return maxProfitRate;
    }

    /**
     * 设置属性profitflag
     * @param profitFlag 待设置的属性profitflag的值
     */
    public void setProfitFlag(String profitFlag){
        this.profitFlag = StringUtils.rightTrim(profitFlag);
    }

    /**
     * 获取属性profitflag
     * @return 属性profitflag的值
     */
    public String getProfitFlag(){
        return profitFlag;
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
