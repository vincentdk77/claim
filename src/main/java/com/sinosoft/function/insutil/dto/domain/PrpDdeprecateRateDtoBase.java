package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpddeprecaterate�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdeprecateRateDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����clausetype */
    private String clauseType = "";
    /** ����carkindcode */
    private String carKindCode = "";
    /** ����carkindname */
    private String carKindName = "";
    /** ����peryearrate */
    private double perYearRate = 0d;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdeprecateRateDtoBase����
     */
    public PrpDdeprecateRateDtoBase(){
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
     * ��������clausetype
     * @param clauseType �����õ�����clausetype��ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ����clausetype
     * @return ����clausetype��ֵ
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * ��������carkindcode
     * @param carKindCode �����õ�����carkindcode��ֵ
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * ��ȡ����carkindcode
     * @return ����carkindcode��ֵ
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * ��������carkindname
     * @param carKindName �����õ�����carkindname��ֵ
     */
    public void setCarKindName(String carKindName){
        this.carKindName = StringUtils.rightTrim(carKindName);
    }

    /**
     * ��ȡ����carkindname
     * @return ����carkindname��ֵ
     */
    public String getCarKindName(){
        return carKindName;
    }

    /**
     * ��������peryearrate
     * @param perYearRate �����õ�����peryearrate��ֵ
     */
    public void setPerYearRate(double perYearRate){
        this.perYearRate = perYearRate;
    }

    /**
     * ��ȡ����peryearrate
     * @return ����peryearrate��ֵ
     */
    public double getPerYearRate(){
        return perYearRate;
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
