package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLclaimPolicy-���������嵥������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimPolicyDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Աұ� */
    private String currency = "";
    /** �����ܱ��� */
    private double sumAmount = 0d;
    /** �����ܱ��� */
    private double sumPremium = 0d;
    /** ���Ա��� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLclaimPolicyDtoBase����
     */
    public PrpLclaimPolicyDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * �������Ա���
     * @param flag �����õ����Ա��õ�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��õ�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
