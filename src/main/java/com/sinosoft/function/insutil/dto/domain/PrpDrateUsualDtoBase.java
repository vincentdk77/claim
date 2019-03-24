package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrateusual�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateUsualDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����rateperiod */
    private int ratePeriod = 0;
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����ratecode */
    private String rateCode = "";
    /** ����basepremium */
    private double basePremium = 0d;
    /** ����rate */
    private double rate = 0d;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateUsualDtoBase����
     */
    public PrpDrateUsualDtoBase(){
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
     * ��������rateperiod
     * @param ratePeriod �����õ�����rateperiod��ֵ
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * ��ȡ����rateperiod
     * @return ����rateperiod��ֵ
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * ��������validdate
     * @param validDate �����õ�����validdate��ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ����validdate
     * @return ����validdate��ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ��������ratecode
     * @param rateCode �����õ�����ratecode��ֵ
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * ��ȡ����ratecode
     * @return ����ratecode��ֵ
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * ��������basepremium
     * @param basePremium �����õ�����basepremium��ֵ
     */
    public void setBasePremium(double basePremium){
        this.basePremium = basePremium;
    }

    /**
     * ��ȡ����basepremium
     * @return ����basepremium��ֵ
     */
    public double getBasePremium(){
        return basePremium;
    }

    /**
     * ��������rate
     * @param rate �����õ�����rate��ֵ
     */
    public void setRate(double rate){
        this.rate = rate;
    }

    /**
     * ��ȡ����rate
     * @return ����rate��ֵ
     */
    public double getRate(){
        return rate;
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
