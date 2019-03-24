package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpgradeext��λ��չ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpGradeExtDtoBase implements Serializable{
    /** ���Ը�λ���� */
    private String gradeCode = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Ա��� */
    private double sumAmount = 0d;
    /** �������շ��� */
    private double rate = 0d;
    /** ������� */
    private double sumPaid = 0d;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpGradeExtDtoBase����
     */
    public PrpGradeExtDtoBase(){
    }

    /**
     * �������Ը�λ����
     * @param gradeCode �����õ����Ը�λ�����ֵ
     */
    public void setGradeCode(String gradeCode){
        this.gradeCode = StringUtils.rightTrim(gradeCode);
    }

    /**
     * ��ȡ���Ը�λ����
     * @return ���Ը�λ�����ֵ
     */
    public String getGradeCode(){
        return gradeCode;
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
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Ա���
     * @param sumAmount �����õ����Ա����ֵ
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա����ֵ
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * �����������շ���
     * @param rate �����õ��������շ��ʵ�ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ�������շ���
     * @return �������շ��ʵ�ֵ
     */
    public double getRate(){
        return rate;
    }

    /**
     * �����������
     * @param sumPaid �����õ���������ֵ
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * ��ȡ�������
     * @return ��������ֵ
     */
    public double getSumPaid(){
        return sumPaid;
    }
}
