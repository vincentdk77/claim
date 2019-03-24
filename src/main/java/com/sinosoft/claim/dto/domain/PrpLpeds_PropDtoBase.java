package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpeds_Prop财产损失接口数据表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpeds_PropDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性损失项目名称 */
    private String lossItemName = "";
    /** 属性费用名称 */
    private String feeTypeName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性单价 */
    private double unitPrice = 0d;
    /** 属性受损标的数量 */
    private double lossQuantity = 0d;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性赔偿比例 */
    private double lossRate = 0d;
    /** 属性核定损金额 */
    private double sumDefLoss = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性是否处理标志 */
    private String transmitFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpeds_PropDtoBase对象
     */
    public PrpLpeds_PropDtoBase(){
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性保单标的子险序号
     * @param itemKindNo 待设置的属性保单标的子险序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性保单标的子险序号
     * @return 属性保单标的子险序号的值
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
     * 设置属性损失项目名称
     * @param lossItemName 待设置的属性损失项目名称的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性损失项目名称
     * @return 属性损失项目名称的值
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * 设置属性费用名称
     * @param feeTypeName 待设置的属性费用名称的值
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getFeeTypeName(){
        return feeTypeName;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性单价
     * @param unitPrice 待设置的属性单价的值
     */
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    /**
     * 获取属性单价
     * @return 属性单价的值
     */
    public double getUnitPrice(){
        return unitPrice;
    }

    /**
     * 设置属性受损标的数量
     * @param lossQuantity 待设置的属性受损标的数量的值
     */
    public void setLossQuantity(double lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * 获取属性受损标的数量
     * @return 属性受损标的数量的值
     */
    public double getLossQuantity(){
        return lossQuantity;
    }

    /**
     * 设置属性数量单位
     * @param unit 待设置的属性数量单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性数量单位
     * @return 属性数量单位的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性赔偿比例
     * @param lossRate 待设置的属性赔偿比例的值
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * 获取属性赔偿比例
     * @return 属性赔偿比例的值
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * 设置属性核定损金额
     * @param sumDefLoss 待设置的属性核定损金额的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性核定损金额
     * @return 属性核定损金额的值
     */
    public double getSumDefLoss(){
        return sumDefLoss;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性是否处理标志
     * @param transmitFlag 待设置的属性是否处理标志的值
     */
    public void setTransmitFlag(String transmitFlag){
        this.transmitFlag = StringUtils.rightTrim(transmitFlag);
    }

    /**
     * 获取属性是否处理标志
     * @return 属性是否处理标志的值
     */
    public String getTransmitFlag(){
        return transmitFlag;
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
