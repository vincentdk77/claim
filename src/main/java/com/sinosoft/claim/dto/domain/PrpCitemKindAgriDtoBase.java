package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCitemKindAgri的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCitemKindAgriDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性PolicyNo */
    private String policyNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性ItemKindNo */
    private long itemKindNo = 0L;
    /** 属性UnitOutput */
    private double unitOutput = 0D;
    /** 属性UnitCost */
    private double unitCost = 0D;
    /** 属性PropoRation */
    private double propoRtion = 0D;
    /** 属性DepreciAtionRate */
    private double depreciAtionRate = 0D;
    /** 属性UnitAmount */
    private double unitAmount = 0D;
    /** 属性GrossQuantity */
    private double grossQuantity = 0D;
    /** 属性DiscountType */
    private String discountType = "";
    /** 属性Flag */
    private String flag = "";
    /** 属性Remark */
    private String remark = "";
    /** 属性KindCode */
    private String kindCode = "";
    /** 茬次保额*/
    private double timesAmount ;
    /** 茬次比例*/
    private double distributingRate;
    /**
     *  默认构造方法,构造一个默认的PrpCitemKindAgriDtoBase对象
     */
    public PrpCitemKindAgriDtoBase(){
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
     * 设置属性ItemKindNo
     * @param itemKindNo 待设置的属性ItemKindNo的值
     */
    public void setItemKindNo(long itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性ItemKindNo
     * @return 属性ItemKindNo的值
     */
    public long getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性UnitOutput
     * @param unitOutput 待设置的属性UnitOutput的值
     */
    public void setUnitOutput(double unitOutput){
        this.unitOutput = unitOutput;
    }

    /**
     * 获取属性UnitOutput
     * @return 属性UnitOutput的值
     */
    public double getUnitOutput(){
        return unitOutput;
    }

    /**
     * 设置属性UnitCost
     * @param unitCost 待设置的属性UnitCost的值
     */
    public void setUnitCost(double unitCost){
        this.unitCost = unitCost;
    }

    /**
     * 获取属性UnitCost
     * @return 属性UnitCost的值
     */
    public double getUnitCost(){
        return unitCost;
    }

    /**
     * 设置属性PropoRation
     * @param propoRation 待设置的属性PropoRation的值
     */
    public void setPropoRtion(double propoRtion){
        this.propoRtion = propoRtion;
    }

    /**
     * 获取属性PropoRation
     * @return 属性PropoRation的值
     */
    public double getPropoRtion(){
        return propoRtion;
    }

    /**
     * 设置属性DepreciAtionRate
     * @param depreciAtionRate 待设置的属性DepreciAtionRate的值
     */
    public void setDepreciAtionRate(double depreciAtionRate){
        this.depreciAtionRate = depreciAtionRate;
    }

    /**
     * 获取属性DepreciAtionRate
     * @return 属性DepreciAtionRate的值
     */
    public double getDepreciAtionRate(){
        return depreciAtionRate;
    }

    /**
     * 设置属性UnitAmount
     * @param unitAmount 待设置的属性UnitAmount的值
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * 获取属性UnitAmount
     * @return 属性UnitAmount的值
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * 设置属性GrossQuantity
     * @param grossQuantity 待设置的属性GrossQuantity的值
     */
    public void setGrossQuantity(double grossQuantity){
        this.grossQuantity = grossQuantity;
    }

    /**
     * 获取属性GrossQuantity
     * @return 属性GrossQuantity的值
     */
    public double getGrossQuantity(){
        return grossQuantity;
    }

    /**
     * 设置属性DiscountType
     * @param discountType 待设置的属性DiscountType的值
     */
    public void setDiscountType(String discountType){
        this.discountType = StringUtils.rightTrim(discountType);
    }

    /**
     * 获取属性DiscountType
     * @return 属性DiscountType的值
     */
    public String getDiscountType(){
        return discountType;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
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
     * 设置属性KindCode
     * @param kindCode 待设置的属性KindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性KindCode
     * @return 属性KindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

	public double getTimesAmount() {
		return timesAmount;
	}

	public void setTimesAmount(double timesAmount) {
		this.timesAmount = timesAmount;
	}

	public double getDistributingRate() {
		return distributingRate;
	}

	public void setDistributingRate(double distributingRate) {
		this.distributingRate = distributingRate;
	}

}
