package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdkind�ձ���������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDkindDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ��������� */
    private String kindCName = "";
    /** �����ձ�Ӣ������ */
    private String kindEName = "";
    /** ���Է��ʴ��� */
    private String rateTypeFlag = "";
    /** ���Լ����ܱ����־ */
    private String calculateFlag = "";
    /** ������󸡶����� */
    private double maxFloatRate = 0d;
    /** ��������ۿ۱��� */
    private double maxDiscountRate = 0d;
    /** �����µ��ձ���� */
    private String newKindCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDkindDtoBase����
     */
    public PrpDkindDtoBase(){
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
     * ���������ձ���������
     * @param kindCName �����õ������ձ��������Ƶ�ֵ
     */
    public void setKindCName(String kindCName){
        this.kindCName = StringUtils.rightTrim(kindCName);
    }

    /**
     * ��ȡ�����ձ���������
     * @return �����ձ��������Ƶ�ֵ
     */
    public String getKindCName(){
        return kindCName;
    }

    /**
     * ���������ձ�Ӣ������
     * @param kindEName �����õ������ձ�Ӣ�����Ƶ�ֵ
     */
    public void setKindEName(String kindEName){
        this.kindEName = StringUtils.rightTrim(kindEName);
    }

    /**
     * ��ȡ�����ձ�Ӣ������
     * @return �����ձ�Ӣ�����Ƶ�ֵ
     */
    public String getKindEName(){
        return kindEName;
    }

    /**
     * �������Է��ʴ���
     * @param rateTypeFlag �����õ����Է��ʴ����ֵ
     */
    public void setRateTypeFlag(String rateTypeFlag){
        this.rateTypeFlag = StringUtils.rightTrim(rateTypeFlag);
    }

    /**
     * ��ȡ���Է��ʴ���
     * @return ���Է��ʴ����ֵ
     */
    public String getRateTypeFlag(){
        return rateTypeFlag;
    }

    /**
     * �������Լ����ܱ����־
     * @param calculateFlag �����õ����Լ����ܱ����־��ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ���Լ����ܱ����־
     * @return ���Լ����ܱ����־��ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * ����������󸡶�����
     * @param maxFloatRate �����õ�������󸡶�������ֵ
     */
    public void setMaxFloatRate(double maxFloatRate){
        this.maxFloatRate = maxFloatRate;
    }

    /**
     * ��ȡ������󸡶�����
     * @return ������󸡶�������ֵ
     */
    public double getMaxFloatRate(){
        return maxFloatRate;
    }

    /**
     * ������������ۿ۱���
     * @param maxDiscountRate �����õ���������ۿ۱�����ֵ
     */
    public void setMaxDiscountRate(double maxDiscountRate){
        this.maxDiscountRate = maxDiscountRate;
    }

    /**
     * ��ȡ��������ۿ۱���
     * @return ��������ۿ۱�����ֵ
     */
    public double getMaxDiscountRate(){
        return maxDiscountRate;
    }

    /**
     * ���������µ��ձ����
     * @param newKindCode �����õ������µ��ձ�����ֵ
     */
    public void setNewKindCode(String newKindCode){
        this.newKindCode = StringUtils.rightTrim(newKindCode);
    }

    /**
     * ��ȡ�����µ��ձ����
     * @return �����µ��ձ�����ֵ
     */
    public String getNewKindCode(){
        return newKindCode;
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
