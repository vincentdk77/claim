package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpccargodetail货运险货运明细信息的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcargoDetailDtoBase implements Serializable{
    /** 属性保单号/协议号 */
    private String policyNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性批次 */
    private int batchNo = 0;
    /** 属性顺序号 */
    private int serialNo = 0;
    /** 属性保单类别 */
    private String policyType = "";
    /** 属性运输工具 */
    private String conveyance = "";
    /** 属性运具牌号 */
    private String bLNo = "";
    /** 属性航次 */
    private String voyageNo = "";
    /** 属性货票运单号 */
    private String carryBillNo = "";
    /** 属性货物名称 */
    private String detailName = "";
    /** 属性起运日期 */
    private DateTime startDate = new DateTime();
    /** 属性起运地 */
    private String startSiteName = "";
    /** 属性中转地 */
    private String viaSiteName = "";
    /** 属性目的地 */
    private String endSiteName = "";
    /** 属性包装及数量 */
    private String quantity = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性货物价值 */
    private double sumValue = 0d;
    /** 属性保额 */
    private double sumAmount = 0d;
    /** 属性费率 */
    private double rate = 0d;
    /** 属性保费 */
    private double sumPremium = 0d;
    /** 属性结算标志 */
    private String settleFlag = "";
    /** 属性备注字段 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCcargoDetailDtoBase对象
     */
    public PrpCcargoDetailDtoBase(){
    }

    /**
     * 设置属性保单号/协议号
     * @param policyNo 待设置的属性保单号/协议号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号/协议号
     * @return 属性保单号/协议号的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * @param batchNo 待设置的属性批次的值
     */
    public void setBatchNo(int batchNo){
        this.batchNo = batchNo;
    }

    /**
     * 获取属性批次
     * @return 属性批次的值
     */
    public int getBatchNo(){
        return batchNo;
    }

    /**
     * 设置属性顺序号
     * @param serialNo 待设置的属性顺序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性顺序号
     * @return 属性顺序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性保单类别
     * @param policyType 待设置的属性保单类别的值
     */
    public void setPolicyType(String policyType){
        this.policyType = StringUtils.rightTrim(policyType);
    }

    /**
     * 获取属性保单类别
     * @return 属性保单类别的值
     */
    public String getPolicyType(){
        return policyType;
    }

    /**
     * 设置属性运输工具
     * @param conveyance 待设置的属性运输工具的值
     */
    public void setConveyance(String conveyance){
        this.conveyance = StringUtils.rightTrim(conveyance);
    }

    /**
     * 获取属性运输工具
     * @return 属性运输工具的值
     */
    public String getConveyance(){
        return conveyance;
    }

    /**
     * 设置属性运具牌号
     * @param bLNo 待设置的属性运具牌号的值
     */
    public void setBLNo(String bLNo){
        this.bLNo = StringUtils.rightTrim(bLNo);
    }

    /**
     * 获取属性运具牌号
     * @return 属性运具牌号的值
     */
    public String getBLNo(){
        return bLNo;
    }

    /**
     * 设置属性航次
     * @param voyageNo 待设置的属性航次的值
     */
    public void setVoyageNo(String voyageNo){
        this.voyageNo = StringUtils.rightTrim(voyageNo);
    }

    /**
     * 获取属性航次
     * @return 属性航次的值
     */
    public String getVoyageNo(){
        return voyageNo;
    }

    /**
     * 设置属性货票运单号
     * @param carryBillNo 待设置的属性货票运单号的值
     */
    public void setCarryBillNo(String carryBillNo){
        this.carryBillNo = StringUtils.rightTrim(carryBillNo);
    }

    /**
     * 获取属性货票运单号
     * @return 属性货票运单号的值
     */
    public String getCarryBillNo(){
        return carryBillNo;
    }

    /**
     * 设置属性货物名称
     * @param detailName 待设置的属性货物名称的值
     */
    public void setDetailName(String detailName){
        this.detailName = StringUtils.rightTrim(detailName);
    }

    /**
     * 获取属性货物名称
     * @return 属性货物名称的值
     */
    public String getDetailName(){
        return detailName;
    }

    /**
     * 设置属性起运日期
     * @param startDate 待设置的属性起运日期的值
     */
    public void setStartDate(DateTime startDate){
        this.startDate = startDate;
    }

    /**
     * 获取属性起运日期
     * @return 属性起运日期的值
     */
    public DateTime getStartDate(){
        return startDate;
    }

    /**
     * 设置属性起运地
     * @param startSiteName 待设置的属性起运地的值
     */
    public void setStartSiteName(String startSiteName){
        this.startSiteName = StringUtils.rightTrim(startSiteName);
    }

    /**
     * 获取属性起运地
     * @return 属性起运地的值
     */
    public String getStartSiteName(){
        return startSiteName;
    }

    /**
     * 设置属性中转地
     * @param viaSiteName 待设置的属性中转地的值
     */
    public void setViaSiteName(String viaSiteName){
        this.viaSiteName = StringUtils.rightTrim(viaSiteName);
    }

    /**
     * 获取属性中转地
     * @return 属性中转地的值
     */
    public String getViaSiteName(){
        return viaSiteName;
    }

    /**
     * 设置属性目的地
     * @param endSiteName 待设置的属性目的地的值
     */
    public void setEndSiteName(String endSiteName){
        this.endSiteName = StringUtils.rightTrim(endSiteName);
    }

    /**
     * 获取属性目的地
     * @return 属性目的地的值
     */
    public String getEndSiteName(){
        return endSiteName;
    }

    /**
     * 设置属性包装及数量
     * @param quantity 待设置的属性包装及数量的值
     */
    public void setQuantity(String quantity){
        this.quantity = StringUtils.rightTrim(quantity);
    }

    /**
     * 获取属性包装及数量
     * @return 属性包装及数量的值
     */
    public String getQuantity(){
        return quantity;
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
     * 设置属性货物价值
     * @param sumValue 待设置的属性货物价值的值
     */
    public void setSumValue(double sumValue){
        this.sumValue = sumValue;
    }

    /**
     * 获取属性货物价值
     * @return 属性货物价值的值
     */
    public double getSumValue(){
        return sumValue;
    }

    /**
     * 设置属性保额
     * @param sumAmount 待设置的属性保额的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性保额
     * @return 属性保额的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性费率
     * @param rate 待设置的属性费率的值
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * 获取属性费率
     * @return 属性费率的值
     */
    public double getRate(){
        return rate;
    }

    /**
     * 设置属性保费
     * @param sumPremium 待设置的属性保费的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性保费
     * @return 属性保费的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性结算标志
     * @param settleFlag 待设置的属性结算标志的值
     */
    public void setSettleFlag(String settleFlag){
        this.settleFlag = StringUtils.rightTrim(settleFlag);
    }

    /**
     * 获取属性结算标志
     * @return 属性结算标志的值
     */
    public String getSettleFlag(){
        return settleFlag;
    }

    /**
     * 设置属性备注字段
     * @param remark 待设置的属性备注字段的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注字段
     * @return 属性备注字段的值
     */
    public String getRemark(){
        return remark;
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
