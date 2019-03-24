package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prppprofit优惠信息表的数据传输对象基类<br>
 * 创建于 2004-11-22 15:24:14.218<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPprofitDtoBase implements Serializable{
    /** 属性批单号 */
    private String endorseNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性优惠折扣类型 */
    private String profitType = "";
    /** 属性标的险别序号 */
    private int itemkindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性总优惠(折扣)率(%) */
    private double discount = 0d;
    /** 属性优惠（折扣）金额 */
    private double totalProfit = 0d;
    /** 属性是否冲减保费 */
    private String minusFlag = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性输入日期 */
    private DateTime inputDate = new DateTime();
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpPprofitDtoBase对象
     */
    public PrpPprofitDtoBase(){
    }

    /**
     * 设置属性批单号
     * @param endorseNo 待设置的属性批单号的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性批单号
     * @return 属性批单号的值
     */
    public String getEndorseNo(){
        return endorseNo;
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
     * 设置属性标的险别序号
     * @param itemkindNo 待设置的属性标的险别序号的值
     */
    public void setItemkindNo(int itemkindNo){
        this.itemkindNo = itemkindNo;
    }

    /**
     * 获取属性标的险别序号
     * @return 属性标的险别序号的值
     */
    public int getItemkindNo(){
        return itemkindNo;
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
     * 设置属性总优惠(折扣)率(%)
     * @param discount 待设置的属性总优惠(折扣)率(%)的值
     */
    public void setDiscount(double discount){
        this.discount = discount;
    }

    /**
     * 获取属性总优惠(折扣)率(%)
     * @return 属性总优惠(折扣)率(%)的值
     */
    public double getDiscount(){
        return discount;
    }

    /**
     * 设置属性优惠（折扣）金额
     * @param totalProfit 待设置的属性优惠（折扣）金额的值
     */
    public void setTotalProfit(double totalProfit){
        this.totalProfit = totalProfit;
    }

    /**
     * 获取属性优惠（折扣）金额
     * @return 属性优惠（折扣）金额的值
     */
    public double getTotalProfit(){
        return totalProfit;
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
     * 设置属性输入日期
     * @param inputDate 待设置的属性输入日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性输入日期
     * @return 属性输入日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
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
