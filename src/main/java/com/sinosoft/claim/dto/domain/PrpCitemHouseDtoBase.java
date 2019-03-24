package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpCitemHouse的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCitemHouseDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性PolicyNo */
    private String policyNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性ItemNo */
    private long itemNo = 0L;
    /** 属性Structure */
    private String structure = "";
    /** 属性BuildArea */
    private double buildArea = 0D;
    /** 属性Remark */
    private String remark = "";
    /** 属性flag */
    private String flag = "";
    /** 属性UnitValue */
    private double unitValue = 0D;
    /** 属性SumValue */
    private double sumValue = 0D;
    /** 属性BuildTime */
    private DateTime buildTime = new DateTime();
    /** 属性UseAge */
    private String useAge = "";

    /**
     *  默认构造方法,构造一个默认的PrpCitemHouseDtoBase对象
     */
    public PrpCitemHouseDtoBase(){
    }

    /**
     * 设置属性PolicyNo
     * @param policyNo 待设置的属性PolicyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性PolicyNo
     * @return 属性PolicyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性ItemNo
     * @param itemNo 待设置的属性ItemNo的值
     */
    public void setItemNo(long itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性ItemNo
     * @return 属性ItemNo的值
     */
    public long getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性Structure
     * @param structure 待设置的属性Structure的值
     */
    public void setStructure(String structure){
        this.structure = StringUtils.rightTrim(structure);
    }

    /**
     * 获取属性Structure
     * @return 属性Structure的值
     */
    public String getStructure(){
        return structure;
    }

    /**
     * 设置属性BuildArea
     * @param buildArea 待设置的属性BuildArea的值
     */
    public void setBuildArea(double buildArea){
        this.buildArea = buildArea;
    }

    /**
     * 获取属性BuildArea
     * @return 属性BuildArea的值
     */
    public double getBuildArea(){
        return buildArea;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
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

    /**
     * 设置属性UnitValue
     * @param unitValue 待设置的属性UnitValue的值
     */
    public void setUnitValue(double unitValue){
        this.unitValue = unitValue;
    }

    /**
     * 获取属性UnitValue
     * @return 属性UnitValue的值
     */
    public double getUnitValue(){
        return unitValue;
    }

    /**
     * 设置属性SumValue
     * @param sumValue 待设置的属性SumValue的值
     */
    public void setSumValue(double sumValue){
        this.sumValue = sumValue;
    }

    /**
     * 获取属性SumValue
     * @return 属性SumValue的值
     */
    public double getSumValue(){
        return sumValue;
    }

    /**
     * 设置属性BuildTime
     * @param buildTime 待设置的属性BuildTime的值
     */
    public void setBuildTime(DateTime buildTime){
        this.buildTime = buildTime;
    }

    /**
     * 获取属性BuildTime
     * @return 属性BuildTime的值
     */
    public DateTime getBuildTime(){
        return buildTime;
    }

    /**
     * 设置属性UseAge
     * @param useAge 待设置的属性UseAge的值
     */
    public void setUseAge(String useAge){
        this.useAge = StringUtils.rightTrim(useAge);
    }

    /**
     * 获取属性UseAge
     * @return 属性UseAge的值
     */
    public String getUseAge(){
        return useAge;
    }
}
