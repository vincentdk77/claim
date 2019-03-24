package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpCcoinsDetail�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCcoinsDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
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
    /** ����flag */
    private String flag = "";
    /** ����middleCostFee */
    private double middleCostFee = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCcoinsDetailDtoBase����
     */
    public PrpCcoinsDetailDtoBase(){
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
}
