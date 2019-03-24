package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpClimit�����ݴ���������<br>
 * ������ 2006-06-09 15:31:28.531<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpClimitDtoBase implements Serializable{
    /** ����PolicyNo */
    private String policyNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����LimitGrade */
    private String limitGrade = "";
    /** ����LimitNo */
    private double limitNo = 0d;
    /** ����LimitType */
    private String limitType = "";
    /** ����Currency */
    private String currency = "";
    /** ����LimitFee */
    private double limitFee = 0d;
    /** ����CalculateFlag */
    private String calculateFlag = "";
    /** ����LimitFlag */
    private String limitFlag = "";
    /** ����Flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpClimitDtoBase����
     */
    public PrpClimitDtoBase(){
    }

    /**
     * ��������PolicyNo
     * @param policyNo �����õ�����PolicyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����PolicyNo
     * @return ����PolicyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������LimitGrade
     * @param limitGrade �����õ�����LimitGrade��ֵ
     */
    public void setLimitGrade(String limitGrade){
        this.limitGrade = StringUtils.rightTrim(limitGrade);
    }

    /**
     * ��ȡ����LimitGrade
     * @return ����LimitGrade��ֵ
     */
    public String getLimitGrade(){
        return limitGrade;
    }

    /**
     * ��������LimitNo
     * @param limitNo �����õ�����LimitNo��ֵ
     */
    public void setLimitNo(double limitNo){
        this.limitNo = limitNo;
    }

    /**
     * ��ȡ����LimitNo
     * @return ����LimitNo��ֵ
     */
    public double getLimitNo(){
        return limitNo;
    }

    /**
     * ��������LimitType
     * @param limitType �����õ�����LimitType��ֵ
     */
    public void setLimitType(String limitType){
        this.limitType = StringUtils.rightTrim(limitType);
    }

    /**
     * ��ȡ����LimitType
     * @return ����LimitType��ֵ
     */
    public String getLimitType(){
        return limitType;
    }

    /**
     * ��������Currency
     * @param currency �����õ�����Currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����Currency
     * @return ����Currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������LimitFee
     * @param limitFee �����õ�����LimitFee��ֵ
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * ��ȡ����LimitFee
     * @return ����LimitFee��ֵ
     */
    public double getLimitFee(){
        return limitFee;
    }

    /**
     * ��������CalculateFlag
     * @param calculateFlag �����õ�����CalculateFlag��ֵ
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * ��ȡ����CalculateFlag
     * @return ����CalculateFlag��ֵ
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * ��������LimitFlag
     * @param limitFlag �����õ�����LimitFlag��ֵ
     */
    public void setLimitFlag(String limitFlag){
        this.limitFlag = StringUtils.rightTrim(limitFlag);
    }

    /**
     * ��ȡ����LimitFlag
     * @return ����LimitFlag��ֵ
     */
    public String getLimitFlag(){
        return limitFlag;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
