package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdration���������ձ���������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Զ������ʹ��� */
    private String rationType = "";
    /** ���Զ����������� */
    private String rationName = "";
    /** ���Ա����� */
    private String itemCode = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ���Ա��� */
    private double amount = 0d;
    /** ���Է��� */
    private double rate = 0d;
    /** ���Ա��� */
    private double premium = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrationDtoBase����
     */
    public PrpDrationDtoBase(){
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Զ������ʹ���
     * @param rationType �����õ����Զ������ʹ����ֵ
     */
    public void setRationType(String rationType){
        this.rationType = StringUtils.rightTrim(rationType);
    }

    /**
     * ��ȡ���Զ������ʹ���
     * @return ���Զ������ʹ����ֵ
     */
    public String getRationType(){
        return rationType;
    }

    /**
     * �������Զ�����������
     * @param rationName �����õ����Զ����������Ƶ�ֵ
     */
    public void setRationName(String rationName){
        this.rationName = StringUtils.rightTrim(rationName);
    }

    /**
     * ��ȡ���Զ�����������
     * @return ���Զ����������Ƶ�ֵ
     */
    public String getRationName(){
        return rationName;
    }

    /**
     * �������Ա�����
     * @param itemCode �����õ����Ա������ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա������ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Աұ����
     * @param currency �����õ����Աұ�����ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ա���
     * @param amount �����õ����Ա����ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա����ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * �������Է���
     * @param rate �����õ����Է��ʵ�ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ���Է���
     * @return ���Է��ʵ�ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * �������Ա���
     * @param premium �����õ����Ա��ѵ�ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��ѵ�ֵ
     */
    public double getPremium(){
        return premium;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
