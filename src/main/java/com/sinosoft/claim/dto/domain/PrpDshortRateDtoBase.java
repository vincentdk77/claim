package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdshortrate�¶��ڷ��ʱ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshortRateDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** �����·��� */
    private int months = 0;
    /** ���Է��� */
    private double shortRate = 0d;
    /** ����״̬ */
    private String validStatus = "";
    /** ����״̬λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDshortRateDtoBase����
     */
    public PrpDshortRateDtoBase(){
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
     * ���������·���
     * @param months �����õ������·�����ֵ
     */
    public void setMonths(int months){
        this.months = months;
    }

    /**
     * ��ȡ�����·���
     * @return �����·�����ֵ
     */
    public int getMonths(){
        return months;
    }

    /**
     * �������Է���
     * @param shortRate �����õ����Է��ʵ�ֵ
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * ��ȡ���Է���
     * @return ���Է��ʵ�ֵ
     */
    public double getShortRate(){
        return shortRate;
    }

    /**
     * ��������״̬
     * @param validStatus �����õ�����״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����״̬
     * @return ����״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������״̬λ
     * @param flag �����õ�����״̬λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����״̬λ
     * @return ����״̬λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
