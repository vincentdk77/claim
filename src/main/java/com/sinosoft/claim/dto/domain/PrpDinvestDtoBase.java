package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdinvestͶ��������Ͷ����Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDinvestDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ����Ͷ�����ʹ��� */
    private String investType = "";
    /** ����Ͷ���������� */
    private String investName = "";
    /** ����ÿ���ܱ��� */
    private double unitAmount = 0d;
    /** ����ÿ���ܱ��� */
    private double unitPremium = 0d;
    /** ����ÿ����Ͷ�ʽ� */
    private double unitInvestment = 0d;
    /** ���������� */
    private double interestRate = 0d;
    /** ����Ͷ������ */
    private int investYear = 0;
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDinvestDtoBase����
     */
    public PrpDinvestDtoBase(){
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
     * ��������Ͷ�����ʹ���
     * @param investType �����õ�����Ͷ�����ʹ����ֵ
     */
    public void setInvestType(String investType){
        this.investType = StringUtils.rightTrim(investType);
    }

    /**
     * ��ȡ����Ͷ�����ʹ���
     * @return ����Ͷ�����ʹ����ֵ
     */
    public String getInvestType(){
        return investType;
    }

    /**
     * ��������Ͷ����������
     * @param investName �����õ�����Ͷ���������Ƶ�ֵ
     */
    public void setInvestName(String investName){
        this.investName = StringUtils.rightTrim(investName);
    }

    /**
     * ��ȡ����Ͷ����������
     * @return ����Ͷ���������Ƶ�ֵ
     */
    public String getInvestName(){
        return investName;
    }

    /**
     * ��������ÿ���ܱ���
     * @param unitAmount �����õ�����ÿ���ܱ����ֵ
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * ��ȡ����ÿ���ܱ���
     * @return ����ÿ���ܱ����ֵ
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * ��������ÿ���ܱ���
     * @param unitPremium �����õ�����ÿ���ܱ��ѵ�ֵ
     */
    public void setUnitPremium(double unitPremium){
        this.unitPremium = unitPremium;
    }

    /**
     * ��ȡ����ÿ���ܱ���
     * @return ����ÿ���ܱ��ѵ�ֵ
     */
    public double getUnitPremium(){
        return unitPremium;
    }

    /**
     * ��������ÿ����Ͷ�ʽ�
     * @param unitInvestment �����õ�����ÿ����Ͷ�ʽ��ֵ
     */
    public void setUnitInvestment(double unitInvestment){
        this.unitInvestment = unitInvestment;
    }

    /**
     * ��ȡ����ÿ����Ͷ�ʽ�
     * @return ����ÿ����Ͷ�ʽ��ֵ
     */
    public double getUnitInvestment(){
        return unitInvestment;
    }

    /**
     * ��������������
     * @param interestRate �����õ����������ʵ�ֵ
     */
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    /**
     * ��ȡ����������
     * @return ���������ʵ�ֵ
     */
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * ��������Ͷ������
     * @param investYear �����õ�����Ͷ�����޵�ֵ
     */
    public void setInvestYear(int investYear){
        this.investYear = investYear;
    }

    /**
     * ��ȡ����Ͷ������
     * @return ����Ͷ�����޵�ֵ
     */
    public int getInvestYear(){
        return investYear;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
