package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdration�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����rationtype */
    private String rationType = "";
    /** ����rationname */
    private String rationName = "";
    /** ����itemcode */
    private String itemCode = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����currency */
    private String currency = "";
    /** ����amount */
    private double amount = 0d;
    /** ����rate */
    private double rate = 0d;
    /** ����premium */
    private double premium = 0d;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrationDtoBase����
     */
    public PrpDrationDtoBase(){
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������rationtype
     * @param rationType �����õ�����rationtype��ֵ
     */
    public void setRationType(String rationType){
        this.rationType = StringUtils.rightTrim(rationType);
    }

    /**
     * ��ȡ����rationtype
     * @return ����rationtype��ֵ
     */
    public String getRationType(){
        return rationType;
    }

    /**
     * ��������rationname
     * @param rationName �����õ�����rationname��ֵ
     */
    public void setRationName(String rationName){
        this.rationName = StringUtils.rightTrim(rationName);
    }

    /**
     * ��ȡ����rationname
     * @return ����rationname��ֵ
     */
    public String getRationName(){
        return rationName;
    }

    /**
     * ��������itemcode
     * @param itemCode �����õ�����itemcode��ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ����itemcode
     * @return ����itemcode��ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������kindcode
     * @param kindCode �����õ�����kindcode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindcode
     * @return ����kindcode��ֵ
     */
    public String getKindCode(){
        return kindCode;
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
     * ��������amount
     * @param amount �����õ�����amount��ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ����amount
     * @return ����amount��ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * ��������rate
     * @param rate �����õ�����rate��ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ����rate
     * @return ����rate��ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * ��������premium
     * @param premium �����õ�����premium��ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ����premium
     * @return ����premium��ֵ
     */
    public double getPremium(){
        return premium;
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
