package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcprofitdetail优惠折扣明细表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCprofitDetailDtoBase implements Serializable{
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性优惠折扣类型 */
    private String profitType = "";
    /** 属性期次 */
    private int profitPeriod = 0;
    /** 属性标的子险序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性优惠折扣代码 */
    private String profitCode = "";
    /** 属性优惠折扣名称 */
    private String profitName = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性条件描述 */
    private String condition = "";
    /** 属性条件具体值 */
    private double fieldValue = 0d;
    /** 属性优惠折扣比率(%) */
    private double profitRate = 0d;
    /** 属性该条件是否选中标志 */
    private String chooseFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCprofitDetailDtoBase对象
     */
    public PrpCprofitDetailDtoBase(){
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性优惠折扣类型
     * @param profitType 待设置的属性优惠折扣类型的值
     */
    public void setProfitType(String profitType){
        this.profitType = StringUtils.rightTrim(profitType);
    }

    /**
     * 获取属性优惠折扣类型
     * @return 属性优惠折扣类型的值
     */
    public String getProfitType(){
        return profitType;
    }

    /**
     * 设置属性期次
     * @param profitPeriod 待设置的属性期次的值
     */
    public void setProfitPeriod(int profitPeriod){
        this.profitPeriod = profitPeriod;
    }

    /**
     * 获取属性期次
     * @return 属性期次的值
     */
    public int getProfitPeriod(){
        return profitPeriod;
    }

    /**
     * 设置属性标的子险序号
     * @param itemKindNo 待设置的属性标的子险序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的子险序号
     * @return 属性标的子险序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
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
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
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
     * 设置属性条件具体值
     * @param fieldValue 待设置的属性条件具体值的值
     */
    public void setFieldValue(double fieldValue){
        this.fieldValue = fieldValue;
    }

    /**
     * 获取属性条件具体值
     * @return 属性条件具体值的值
     */
    public double getFieldValue(){
        return fieldValue;
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
     * 设置属性该条件是否选中标志
     * @param chooseFlag 待设置的属性该条件是否选中标志的值
     */
    public void setChooseFlag(String chooseFlag){
        this.chooseFlag = StringUtils.rightTrim(chooseFlag);
    }

    /**
     * 获取属性该条件是否选中标志
     * @return 属性该条件是否选中标志的值
     */
    public String getChooseFlag(){
        return chooseFlag;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
