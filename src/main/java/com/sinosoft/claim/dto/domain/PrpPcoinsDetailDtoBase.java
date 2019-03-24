package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpPcoinsDetail�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpPcoinsDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����endorseNo */
    private String endorseNo = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����serialNo */
    private long serialNo = 0L;
    /** ����coinsCode */
    private String coinsCode = "";
    /** ����coinsName */
    private String coinsName = "";
    /** ����currency */
    private String currency = "";
    /** ����coinsAmount */
    private double coinsAmount = 0D;
    /** ����coinsPremium */
    private double coinsPremium = 0D;
    /** ����agentFee */
    private double agentFee = 0D;
    /** ����operateFee */
    private double operateFee = 0D;
    /** ����chgCoinsAmount */
    private double chgCoinsAmount = 0D;
    /** ����chgCoinsPremium */
    private double chgCoinsPremium = 0D;
    /** ����chgAgentFee */
    private double chgAgentFee = 0D;
    /** ����chgOperateFee */
    private double chgOperateFee = 0D;
    /** ����middleCostFee */
    private double middleCostFee = 0D;
    /** ����chgMiddleCostFee */
    private double chgMiddleCostFee = 0D;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPcoinsDetailDtoBase����
     */
    public PrpPcoinsDetailDtoBase(){
    }

    /**
     * ��������endorseNo
     * @param endorseNo �����õ�����endorseNo��ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ����endorseNo
     * @return ����endorseNo��ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * ��������coinsCode
     * @param coinsCode �����õ�����coinsCode��ֵ
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * ��ȡ����coinsCode
     * @return ����coinsCode��ֵ
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * ��������coinsName
     * @param coinsName �����õ�����coinsName��ֵ
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * ��ȡ����coinsName
     * @return ����coinsName��ֵ
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * ��������currency
     * @param currency �����õ�����currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����currency
     * @return ����currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������coinsAmount
     * @param coinsAmount �����õ�����coinsAmount��ֵ
     */
    public void setCoinsAmount(double coinsAmount){
        this.coinsAmount = coinsAmount;
    }

    /**
     * ��ȡ����coinsAmount
     * @return ����coinsAmount��ֵ
     */
    public double getCoinsAmount(){
        return coinsAmount;
    }

    /**
     * ��������coinsPremium
     * @param coinsPremium �����õ�����coinsPremium��ֵ
     */
    public void setCoinsPremium(double coinsPremium){
        this.coinsPremium = coinsPremium;
    }

    /**
     * ��ȡ����coinsPremium
     * @return ����coinsPremium��ֵ
     */
    public double getCoinsPremium(){
        return coinsPremium;
    }

    /**
     * ��������agentFee
     * @param agentFee �����õ�����agentFee��ֵ
     */
    public void setAgentFee(double agentFee){
        this.agentFee = agentFee;
    }

    /**
     * ��ȡ����agentFee
     * @return ����agentFee��ֵ
     */
    public double getAgentFee(){
        return agentFee;
    }

    /**
     * ��������operateFee
     * @param operateFee �����õ�����operateFee��ֵ
     */
    public void setOperateFee(double operateFee){
        this.operateFee = operateFee;
    }

    /**
     * ��ȡ����operateFee
     * @return ����operateFee��ֵ
     */
    public double getOperateFee(){
        return operateFee;
    }

    /**
     * ��������chgCoinsAmount
     * @param chgCoinsAmount �����õ�����chgCoinsAmount��ֵ
     */
    public void setChgCoinsAmount(double chgCoinsAmount){
        this.chgCoinsAmount = chgCoinsAmount;
    }

    /**
     * ��ȡ����chgCoinsAmount
     * @return ����chgCoinsAmount��ֵ
     */
    public double getChgCoinsAmount(){
        return chgCoinsAmount;
    }

    /**
     * ��������chgCoinsPremium
     * @param chgCoinsPremium �����õ�����chgCoinsPremium��ֵ
     */
    public void setChgCoinsPremium(double chgCoinsPremium){
        this.chgCoinsPremium = chgCoinsPremium;
    }

    /**
     * ��ȡ����chgCoinsPremium
     * @return ����chgCoinsPremium��ֵ
     */
    public double getChgCoinsPremium(){
        return chgCoinsPremium;
    }

    /**
     * ��������chgAgentFee
     * @param chgAgentFee �����õ�����chgAgentFee��ֵ
     */
    public void setChgAgentFee(double chgAgentFee){
        this.chgAgentFee = chgAgentFee;
    }

    /**
     * ��ȡ����chgAgentFee
     * @return ����chgAgentFee��ֵ
     */
    public double getChgAgentFee(){
        return chgAgentFee;
    }

    /**
     * ��������chgOperateFee
     * @param chgOperateFee �����õ�����chgOperateFee��ֵ
     */
    public void setChgOperateFee(double chgOperateFee){
        this.chgOperateFee = chgOperateFee;
    }

    /**
     * ��ȡ����chgOperateFee
     * @return ����chgOperateFee��ֵ
     */
    public double getChgOperateFee(){
        return chgOperateFee;
    }

    /**
     * ��������middleCostFee
     * @param middleCostFee �����õ�����middleCostFee��ֵ
     */
    public void setMiddleCostFee(double middleCostFee){
        this.middleCostFee = middleCostFee;
    }

    /**
     * ��ȡ����middleCostFee
     * @return ����middleCostFee��ֵ
     */
    public double getMiddleCostFee(){
        return middleCostFee;
    }

    /**
     * ��������chgMiddleCostFee
     * @param chgMiddleCostFee �����õ�����chgMiddleCostFee��ֵ
     */
    public void setChgMiddleCostFee(double chgMiddleCostFee){
        this.chgMiddleCostFee = chgMiddleCostFee;
    }

    /**
     * ��ȡ����chgMiddleCostFee
     * @return ����chgMiddleCostFee��ֵ
     */
    public double getChgMiddleCostFee(){
        return chgMiddleCostFee;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
