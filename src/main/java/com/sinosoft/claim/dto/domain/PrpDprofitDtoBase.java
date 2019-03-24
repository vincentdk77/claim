package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdprofit优惠折扣条件表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDprofitDtoBase implements Serializable{
    /** 属性地区代码 */
    private String comcode = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性批次 */
    private int profitPeriod = 0;
    /** 属性启用日期 */
    private DateTime validDate = new DateTime();
    /** 属性优惠折扣代码 */
    private String profitCode = "";
    /** 属性优惠折扣名称 */
    private String profitName = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性条件描述 */
    private String condition = "";
    /** 属性字段值下限 */
    private double fieldValueLower = 0d;
    /** 属性字段值上限 */
    private double fieldValueUpper = 0d;
    /** 属性折扣率下限 */
    private double minprofitrate = 0d;
    /** 属性优惠折扣比率(%) */
    private double profitRate = 0d;
    /** 属性最大优惠折扣比率(%) */
    private double maxProfitRate = 0d;
    /** 属性折扣条件标志 */
    private String profitFlag = "";
    /** 属性有效状态 */
    private String validStatus = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDprofitDtoBase对象
     */
    public PrpDprofitDtoBase(){
    }

    /**
     * 设置属性地区代码
     * @param comcode 待设置的属性地区代码的值
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * 获取属性地区代码
     * @return 属性地区代码的值
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性批次
     * @param profitPeriod 待设置的属性批次的值
     */
    public void setProfitPeriod(int profitPeriod){
        this.profitPeriod = profitPeriod;
    }

    /**
     * 获取属性批次
     * @return 属性批次的值
     */
    public int getProfitPeriod(){
        return profitPeriod;
    }

    /**
     * 设置属性启用日期
     * @param validDate 待设置的属性启用日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性启用日期
     * @return 属性启用日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性优惠折扣代码
     * @param profitCode 待设置的属性优惠折扣代码的值
     */
    public void setProfitCode(String profitCode){
        this.profitCode = StringUtils.rightTrim(profitCode);
    }

    /**
     * 获取属性优惠折扣代码
     * @return 属性优惠折扣代码的值
     */
    public String getProfitCode(){
        return profitCode;
    }

    /**
     * 设置属性优惠折扣名称
     * @param profitName 待设置的属性优惠折扣名称的值
     */
    public void setProfitName(String profitName){
        this.profitName = StringUtils.rightTrim(profitName);
    }

    /**
     * 获取属性优惠折扣名称
     * @return 属性优惠折扣名称的值
     */
    public String getProfitName(){
        return profitName;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性条件描述
     * @param condition 待设置的属性条件描述的值
     */
    public void setCondition(String condition){
        this.condition = StringUtils.rightTrim(condition);
    }

    /**
     * 获取属性条件描述
     * @return 属性条件描述的值
     */
    public String getCondition(){
        return condition;
    }

    /**
     * 设置属性字段值下限
     * @param fieldValueLower 待设置的属性字段值下限的值
     */
    public void setFieldValueLower(double fieldValueLower){
        this.fieldValueLower = fieldValueLower;
    }

    /**
     * 获取属性字段值下限
     * @return 属性字段值下限的值
     */
    public double getFieldValueLower(){
        return fieldValueLower;
    }

    /**
     * 设置属性字段值上限
     * @param fieldValueUpper 待设置的属性字段值上限的值
     */
    public void setFieldValueUpper(double fieldValueUpper){
        this.fieldValueUpper = fieldValueUpper;
    }

    /**
     * 获取属性字段值上限
     * @return 属性字段值上限的值
     */
    public double getFieldValueUpper(){
        return fieldValueUpper;
    }

    /**
     * 设置属性折扣率下限
     * @param minprofitrate 待设置的属性折扣率下限的值
     */
    public void setMinprofitrate(double minprofitrate){
        this.minprofitrate = minprofitrate;
    }

    /**
     * 获取属性折扣率下限
     * @return 属性折扣率下限的值
     */
    public double getMinprofitrate(){
        return minprofitrate;
    }

    /**
     * 设置属性优惠折扣比率(%)
     * @param profitRate 待设置的属性优惠折扣比率(%)的值
     */
    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }

    /**
     * 获取属性优惠折扣比率(%)
     * @return 属性优惠折扣比率(%)的值
     */
    public double getProfitRate(){
        return profitRate;
    }

    /**
     * 设置属性最大优惠折扣比率(%)
     * @param maxProfitRate 待设置的属性最大优惠折扣比率(%)的值
     */
    public void setMaxProfitRate(double maxProfitRate){
        this.maxProfitRate = maxProfitRate;
    }

    /**
     * 获取属性最大优惠折扣比率(%)
     * @return 属性最大优惠折扣比率(%)的值
     */
    public double getMaxProfitRate(){
        return maxProfitRate;
    }

    /**
     * 设置属性折扣条件标志
     * @param profitFlag 待设置的属性折扣条件标志的值
     */
    public void setProfitFlag(String profitFlag){
        this.profitFlag = StringUtils.rightTrim(profitFlag);
    }

    /**
     * 获取属性折扣条件标志
     * @return 属性折扣条件标志的值
     */
    public String getProfitFlag(){
        return profitFlag;
    }

    /**
     * 设置属性有效状态
     * @param validStatus 待设置的属性有效状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性有效状态
     * @return 属性有效状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
