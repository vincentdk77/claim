package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjprofit优惠记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJprofitDtoBase implements Serializable{
    /** 属性保险单号次 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性批单号次 */
    private String endorseNo = "";
    /** 属性优惠序号 */
    private int profitNo = 0;
    /** 属性标的险别序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性标的类别代码 */
    private String itemCode = "";
    /** 属性标的名细名称 */
    private String itemDetailName = "";
    /** 属性优惠原因 */
    private String profitReasonCode = "";
    /** 属性保单保费 */
    private double sumPremium = 0d;
    /** 属性优惠率 */
    private double profitRate = 0d;
    /** 属性币别 */
    private String currency = "";
    /** 属性优惠金额 */
    private double totalProfit = 0d;
    /** 属性安全奖给付方式 */
    private String safeBountyFlag = "";
    /** 属性是否冲减保费 */
    private String minusFlag = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性付费标志 */
    private String refundFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpJprofitDtoBase对象
     */
    public PrpJprofitDtoBase(){
    }

    /**
     * 设置属性保险单号次
     * @param policyNo 待设置的属性保险单号次的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保险单号次
     * @return 属性保险单号次的值
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
     * 设置属性批单号次
     * @param endorseNo 待设置的属性批单号次的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号次
     * @return 属性批单号次的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性优惠序号
     * @param profitNo 待设置的属性优惠序号的值
     */
    public void setProfitNo(int profitNo){
        this.profitNo = profitNo;
    }

    /**
     * 获取属性优惠序号
     * @return 属性优惠序号的值
     */
    public int getProfitNo(){
        return profitNo;
    }

    /**
     * 设置属性标的险别序号
     * @param itemKindNo 待设置的属性标的险别序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的险别序号
     * @return 属性标的险别序号的值
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
     * 设置属性标的类别代码
     * @param itemCode 待设置的属性标的类别代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的类别代码
     * @return 属性标的类别代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性标的名细名称
     * @param itemDetailName 待设置的属性标的名细名称的值
     */
    public void setItemDetailName(String itemDetailName){
        this.itemDetailName = StringUtils.rightTrim(itemDetailName);
    }

    /**
     * 获取属性标的名细名称
     * @return 属性标的名细名称的值
     */
    public String getItemDetailName(){
        return itemDetailName;
    }

    /**
     * 设置属性优惠原因
     * @param profitReasonCode 待设置的属性优惠原因的值
     */
    public void setProfitReasonCode(String profitReasonCode){
        this.profitReasonCode = StringUtils.rightTrim(profitReasonCode);
    }

    /**
     * 获取属性优惠原因
     * @return 属性优惠原因的值
     */
    public String getProfitReasonCode(){
        return profitReasonCode;
    }

    /**
     * 设置属性保单保费
     * @param sumPremium 待设置的属性保单保费的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性保单保费
     * @return 属性保单保费的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性优惠率
     * @param profitRate 待设置的属性优惠率的值
     */
    public void setProfitRate(double profitRate){
        this.profitRate = profitRate;
    }

    /**
     * 获取属性优惠率
     * @return 属性优惠率的值
     */
    public double getProfitRate(){
        return profitRate;
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
     * 设置属性优惠金额
     * @param totalProfit 待设置的属性优惠金额的值
     */
    public void setTotalProfit(double totalProfit){
        this.totalProfit = totalProfit;
    }

    /**
     * 获取属性优惠金额
     * @return 属性优惠金额的值
     */
    public double getTotalProfit(){
        return totalProfit;
    }

    /**
     * 设置属性安全奖给付方式
     * @param safeBountyFlag 待设置的属性安全奖给付方式的值
     */
    public void setSafeBountyFlag(String safeBountyFlag){
        this.safeBountyFlag = StringUtils.rightTrim(safeBountyFlag);
    }

    /**
     * 获取属性安全奖给付方式
     * @return 属性安全奖给付方式的值
     */
    public String getSafeBountyFlag(){
        return safeBountyFlag;
    }

    /**
     * 设置属性是否冲减保费
     * @param minusFlag 待设置的属性是否冲减保费的值
     */
    public void setMinusFlag(String minusFlag){
        this.minusFlag = StringUtils.rightTrim(minusFlag);
    }

    /**
     * 获取属性是否冲减保费
     * @return 属性是否冲减保费的值
     */
    public String getMinusFlag(){
        return minusFlag;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性复核人代码
     * @param approverCode 待设置的属性复核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性复核人代码
     * @return 属性复核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性计算机输单日期
     * @param inputDate 待设置的属性计算机输单日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期
     * @return 属性计算机输单日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性付费标志
     * @param refundFlag 待设置的属性付费标志的值
     */
    public void setRefundFlag(String refundFlag){
        this.refundFlag = StringUtils.rightTrim(refundFlag);
    }

    /**
     * 获取属性付费标志
     * @return 属性付费标志的值
     */
    public String getRefundFlag(){
        return refundFlag;
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
