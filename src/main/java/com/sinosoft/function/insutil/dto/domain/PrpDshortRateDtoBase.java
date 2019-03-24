package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdshortrate�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDshortRateDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����months */
    private int months = 0;
    /** ����shortrate */
    private double shortRate = 0d;
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDshortRateDtoBase����
     */
    public PrpDshortRateDtoBase(){
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������months
     * @param months �����õ�����months��ֵ
     */
    public void setMonths(int months){
        this.months = months;
    }

    /**
     * ��ȡ����months
     * @return ����months��ֵ
     */
    public int getMonths(){
        return months;
    }

    /**
     * ��������shortrate
     * @param shortRate �����õ�����shortrate��ֵ
     */
    public void setShortRate(double shortRate){
        this.shortRate = shortRate;
    }

    /**
     * ��ȡ����shortrate
     * @return ����shortrate��ֵ
     */
    public double getShortRate(){
        return shortRate;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
