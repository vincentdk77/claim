package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcbatch����������������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCbatchDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Ե�֤���� */
    private String visaCode = "";
    /** ������ʼ���� */
    private String billStartNo = "";
    /** ������ֹ���� */
    private String billEndNo = "";
    /** �����ܵ��� */
    private int billCount = 0;
    /** ���Աұ���� */
    private String currency = "";
    /** �����ܱ��� */
    private double sumAmount = 0d;
    /** �����ܱ��� */
    private double sumPremium = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCbatchDtoBase����
     */
    public PrpCbatchDtoBase(){
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ե�֤����
     * @param visaCode �����õ����Ե�֤�����ֵ
     */
    public void setVisaCode(String visaCode){
        this.visaCode = StringUtils.rightTrim(visaCode);
    }

    /**
     * ��ȡ���Ե�֤����
     * @return ���Ե�֤�����ֵ
     */
    public String getVisaCode(){
        return visaCode;
    }

    /**
     * ����������ʼ����
     * @param billStartNo �����õ�������ʼ���ŵ�ֵ
     */
    public void setBillStartNo(String billStartNo){
        this.billStartNo = StringUtils.rightTrim(billStartNo);
    }

    /**
     * ��ȡ������ʼ����
     * @return ������ʼ���ŵ�ֵ
     */
    public String getBillStartNo(){
        return billStartNo;
    }

    /**
     * ����������ֹ����
     * @param billEndNo �����õ�������ֹ���ŵ�ֵ
     */
    public void setBillEndNo(String billEndNo){
        this.billEndNo = StringUtils.rightTrim(billEndNo);
    }

    /**
     * ��ȡ������ֹ����
     * @return ������ֹ���ŵ�ֵ
     */
    public String getBillEndNo(){
        return billEndNo;
    }

    /**
     * ���������ܵ���
     * @param billCount �����õ������ܵ�����ֵ
     */
    public void setBillCount(int billCount){
        this.billCount = billCount;
    }

    /**
     * ��ȡ�����ܵ���
     * @return �����ܵ�����ֵ
     */
    public int getBillCount(){
        return billCount;
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
     * ���������ܱ���
     * @param sumAmount �����õ������ܱ����ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ�����ܱ���
     * @return �����ܱ����ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * ���������ܱ���
     * @param sumPremium �����õ������ܱ��ѵ�ֵ
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * ��ȡ�����ܱ���
     * @return �����ܱ��ѵ�ֵ
     */
    public double getSumPremium(){
        return sumPremium;
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
