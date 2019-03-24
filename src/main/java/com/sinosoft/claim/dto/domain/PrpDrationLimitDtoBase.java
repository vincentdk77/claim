package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrationlimit������޶�������ձ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrationLimitDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** �����޶�/���⼶�� */
    private String limitGrade = "";
    /** �����޶�/���������� */
    private String limitCode = "";
    /** ���Զ������ʹ��� */
    private String rationType = "";
    /** ���Ա����� */
    private String itemCode = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ����Ͷ����ʽ/���η��� */
    private String modeCode = "";
    /** ���Աұ���� */
    private String currency = "";
    /** �����⳥�޶� */
    private double limitFee = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrationLimitDtoBase����
     */
    public PrpDrationLimitDtoBase(){
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
     * ���������޶�/���⼶��
     * @param limitGrade �����õ������޶�/���⼶���ֵ
     */
    public void setLimitGrade(String limitGrade){
        this.limitGrade = StringUtils.rightTrim(limitGrade);
    }

    /**
     * ��ȡ�����޶�/���⼶��
     * @return �����޶�/���⼶���ֵ
     */
    public String getLimitGrade(){
        return limitGrade;
    }

    /**
     * ���������޶�/����������
     * @param limitCode �����õ������޶�/�����������ֵ
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * ��ȡ�����޶�/����������
     * @return �����޶�/�����������ֵ
     */
    public String getLimitCode(){
        return limitCode;
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
     * ��������Ͷ����ʽ/���η���
     * @param modeCode �����õ�����Ͷ����ʽ/���η����ֵ
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * ��ȡ����Ͷ����ʽ/���η���
     * @return ����Ͷ����ʽ/���η����ֵ
     */
    public String getModeCode(){
        return modeCode;
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
     * ���������⳥�޶�
     * @param limitFee �����õ������⳥�޶��ֵ
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * ��ȡ�����⳥�޶�
     * @return �����⳥�޶��ֵ
     */
    public double getLimitFee(){
        return limitFee;
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
