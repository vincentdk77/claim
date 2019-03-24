package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpddeprecaterate�۾��ʱ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdeprecateRateDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ����������� */
    private String clauseType = "";
    /** ���Գ���������� */
    private String carKindCode = "";
    /** ���Գ����������� */
    private String carKindName = "";
    /** ����ÿ���۾��� */
    private double perYearRate = 0d;
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdeprecateRateDtoBase����
     */
    public PrpDdeprecateRateDtoBase(){
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
     * ���������������
     * @param clauseType �����õ�������������ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * �������Գ����������
     * @param carKindCode �����õ����Գ�����������ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ���Գ����������
     * @return ���Գ�����������ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * �������Գ�����������
     * @param carKindName �����õ����Գ����������Ƶ�ֵ
     */
    public void setCarKindName(String carKindName){
        this.carKindName = StringUtils.rightTrim(carKindName);
    }

    /**
     * ��ȡ���Գ�����������
     * @return ���Գ����������Ƶ�ֵ
     */
    public String getCarKindName(){
        return carKindName;
    }

    /**
     * ��������ÿ���۾���
     * @param perYearRate �����õ�����ÿ���۾��ʵ�ֵ
     */
    public void setPerYearRate(double perYearRate){
        this.perYearRate = perYearRate;
    }

    /**
     * ��ȡ����ÿ���۾���
     * @return ����ÿ���۾��ʵ�ֵ
     */
    public double getPerYearRate(){
        return perYearRate;
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
