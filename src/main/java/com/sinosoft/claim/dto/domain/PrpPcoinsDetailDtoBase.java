package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpPcoinsDetail的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpPcoinsDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性endorseNo */
    private String endorseNo = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性serialNo */
    private long serialNo = 0L;
    /** 属性coinsCode */
    private String coinsCode = "";
    /** 属性coinsName */
    private String coinsName = "";
    /** 属性currency */
    private String currency = "";
    /** 属性coinsAmount */
    private double coinsAmount = 0D;
    /** 属性coinsPremium */
    private double coinsPremium = 0D;
    /** 属性agentFee */
    private double agentFee = 0D;
    /** 属性operateFee */
    private double operateFee = 0D;
    /** 属性chgCoinsAmount */
    private double chgCoinsAmount = 0D;
    /** 属性chgCoinsPremium */
    private double chgCoinsPremium = 0D;
    /** 属性chgAgentFee */
    private double chgAgentFee = 0D;
    /** 属性chgOperateFee */
    private double chgOperateFee = 0D;
    /** 属性middleCostFee */
    private double middleCostFee = 0D;
    /** 属性chgMiddleCostFee */
    private double chgMiddleCostFee = 0D;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpPcoinsDetailDtoBase对象
     */
    public PrpPcoinsDetailDtoBase(){
    }

    /**
     * 设置属性endorseNo
     * @param endorseNo 待设置的属性endorseNo的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性endorseNo
     * @return 属性endorseNo的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性coinsCode
     * @param coinsCode 待设置的属性coinsCode的值
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * 获取属性coinsCode
     * @return 属性coinsCode的值
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * 设置属性coinsName
     * @param coinsName 待设置的属性coinsName的值
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * 获取属性coinsName
     * @return 属性coinsName的值
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * 设置属性currency
     * @param currency 待设置的属性currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性currency
     * @return 属性currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性coinsAmount
     * @param coinsAmount 待设置的属性coinsAmount的值
     */
    public void setCoinsAmount(double coinsAmount){
        this.coinsAmount = coinsAmount;
    }

    /**
     * 获取属性coinsAmount
     * @return 属性coinsAmount的值
     */
    public double getCoinsAmount(){
        return coinsAmount;
    }

    /**
     * 设置属性coinsPremium
     * @param coinsPremium 待设置的属性coinsPremium的值
     */
    public void setCoinsPremium(double coinsPremium){
        this.coinsPremium = coinsPremium;
    }

    /**
     * 获取属性coinsPremium
     * @return 属性coinsPremium的值
     */
    public double getCoinsPremium(){
        return coinsPremium;
    }

    /**
     * 设置属性agentFee
     * @param agentFee 待设置的属性agentFee的值
     */
    public void setAgentFee(double agentFee){
        this.agentFee = agentFee;
    }

    /**
     * 获取属性agentFee
     * @return 属性agentFee的值
     */
    public double getAgentFee(){
        return agentFee;
    }

    /**
     * 设置属性operateFee
     * @param operateFee 待设置的属性operateFee的值
     */
    public void setOperateFee(double operateFee){
        this.operateFee = operateFee;
    }

    /**
     * 获取属性operateFee
     * @return 属性operateFee的值
     */
    public double getOperateFee(){
        return operateFee;
    }

    /**
     * 设置属性chgCoinsAmount
     * @param chgCoinsAmount 待设置的属性chgCoinsAmount的值
     */
    public void setChgCoinsAmount(double chgCoinsAmount){
        this.chgCoinsAmount = chgCoinsAmount;
    }

    /**
     * 获取属性chgCoinsAmount
     * @return 属性chgCoinsAmount的值
     */
    public double getChgCoinsAmount(){
        return chgCoinsAmount;
    }

    /**
     * 设置属性chgCoinsPremium
     * @param chgCoinsPremium 待设置的属性chgCoinsPremium的值
     */
    public void setChgCoinsPremium(double chgCoinsPremium){
        this.chgCoinsPremium = chgCoinsPremium;
    }

    /**
     * 获取属性chgCoinsPremium
     * @return 属性chgCoinsPremium的值
     */
    public double getChgCoinsPremium(){
        return chgCoinsPremium;
    }

    /**
     * 设置属性chgAgentFee
     * @param chgAgentFee 待设置的属性chgAgentFee的值
     */
    public void setChgAgentFee(double chgAgentFee){
        this.chgAgentFee = chgAgentFee;
    }

    /**
     * 获取属性chgAgentFee
     * @return 属性chgAgentFee的值
     */
    public double getChgAgentFee(){
        return chgAgentFee;
    }

    /**
     * 设置属性chgOperateFee
     * @param chgOperateFee 待设置的属性chgOperateFee的值
     */
    public void setChgOperateFee(double chgOperateFee){
        this.chgOperateFee = chgOperateFee;
    }

    /**
     * 获取属性chgOperateFee
     * @return 属性chgOperateFee的值
     */
    public double getChgOperateFee(){
        return chgOperateFee;
    }

    /**
     * 设置属性middleCostFee
     * @param middleCostFee 待设置的属性middleCostFee的值
     */
    public void setMiddleCostFee(double middleCostFee){
        this.middleCostFee = middleCostFee;
    }

    /**
     * 获取属性middleCostFee
     * @return 属性middleCostFee的值
     */
    public double getMiddleCostFee(){
        return middleCostFee;
    }

    /**
     * 设置属性chgMiddleCostFee
     * @param chgMiddleCostFee 待设置的属性chgMiddleCostFee的值
     */
    public void setChgMiddleCostFee(double chgMiddleCostFee){
        this.chgMiddleCostFee = chgMiddleCostFee;
    }

    /**
     * 获取属性chgMiddleCostFee
     * @return 属性chgMiddleCostFee的值
     */
    public double getChgMiddleCostFee(){
        return chgMiddleCostFee;
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
