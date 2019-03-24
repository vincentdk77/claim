package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrateusual���ʴ��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateUsualDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Է������� */
    private int ratePeriod = 0;
    /** ������Ч���� */
    private DateTime validDate = new DateTime();
    /** ���Է��ʴ��� */
    private String rateCode = "";
    /** ���Ի�׼���� */
    private double basePremium = 0d;
    /** ���Ի�׼���� */
    private double rate = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateUsualDtoBase����
     */
    public PrpDrateUsualDtoBase(){
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
     * �������Է�������
     * @param ratePeriod �����õ����Է���������ֵ
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է���������ֵ
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * ����������Ч����
     * @param validDate �����õ�������Ч���ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������Ч����
     * @return ������Ч���ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * �������Է��ʴ���
     * @param rateCode �����õ����Է��ʴ����ֵ
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * ��ȡ���Է��ʴ���
     * @return ���Է��ʴ����ֵ
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * �������Ի�׼����
     * @param basePremium �����õ����Ի�׼���ѵ�ֵ
     */
    public void setBasePremium(double basePremium){
        this.basePremium = basePremium;
    }

    /**
     * ��ȡ���Ի�׼����
     * @return ���Ի�׼���ѵ�ֵ
     */
    public double getBasePremium(){
        return basePremium;
    }

    /**
     * �������Ի�׼����
     * @param rate �����õ����Ի�׼���ʵ�ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ���Ի�׼����
     * @return ���Ի�׼���ʵ�ֵ
     */
    public double getRate(){
        return rate;
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
