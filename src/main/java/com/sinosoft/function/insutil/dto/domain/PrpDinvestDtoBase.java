package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdinvest�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDinvestDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����rationtype */
    private String rationType = "";
    /** ����investname */
    private String investName = "";
    /** ����periods */
    private int periods = 0;
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����unitamount */
    private double unitAmount = 0d;
    /** ����unitpremium */
    private double unitPremium = 0d;
    /** ����unitinvestment */
    private double unitInvestment = 0d;
    /** ����interestrate */
    private double interestRate = 0d;
    /** ����investyear */
    private int investYear = 0;
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDinvestDtoBase����
     */
    public PrpDinvestDtoBase(){
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
     * ��������rationtype
     * @param rationType �����õ�����rationtype��ֵ
     */
    public void setRationType(String rationType){
        this.rationType = StringUtils.rightTrim(rationType);
    }

    /**
     * ��ȡ����rationtype
     * @return ����rationtype��ֵ
     */
    public String getRationType(){
        return rationType;
    }

    /**
     * ��������investname
     * @param investName �����õ�����investname��ֵ
     */
    public void setInvestName(String investName){
        this.investName = StringUtils.rightTrim(investName);
    }

    /**
     * ��ȡ����investname
     * @return ����investname��ֵ
     */
    public String getInvestName(){
        return investName;
    }

    /**
     * ��������periods
     * @param periods �����õ�����periods��ֵ
     */
    public void setPeriods(int periods){
        this.periods = periods;
    }

    /**
     * ��ȡ����periods
     * @return ����periods��ֵ
     */
    public int getPeriods(){
        return periods;
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
     * ��������unitamount
     * @param unitAmount �����õ�����unitamount��ֵ
     */
    public void setUnitAmount(double unitAmount){
        this.unitAmount = unitAmount;
    }

    /**
     * ��ȡ����unitamount
     * @return ����unitamount��ֵ
     */
    public double getUnitAmount(){
        return unitAmount;
    }

    /**
     * ��������unitpremium
     * @param unitPremium �����õ�����unitpremium��ֵ
     */
    public void setUnitPremium(double unitPremium){
        this.unitPremium = unitPremium;
    }

    /**
     * ��ȡ����unitpremium
     * @return ����unitpremium��ֵ
     */
    public double getUnitPremium(){
        return unitPremium;
    }

    /**
     * ��������unitinvestment
     * @param unitInvestment �����õ�����unitinvestment��ֵ
     */
    public void setUnitInvestment(double unitInvestment){
        this.unitInvestment = unitInvestment;
    }

    /**
     * ��ȡ����unitinvestment
     * @return ����unitinvestment��ֵ
     */
    public double getUnitInvestment(){
        return unitInvestment;
    }

    /**
     * ��������interestrate
     * @param interestRate �����õ�����interestrate��ֵ
     */
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    /**
     * ��ȡ����interestrate
     * @return ����interestrate��ֵ
     */
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * ��������investyear
     * @param investYear �����õ�����investyear��ֵ
     */
    public void setInvestYear(int investYear){
        this.investYear = investYear;
    }

    /**
     * ��ȡ����investyear
     * @return ����investyear��ֵ
     */
    public int getInvestYear(){
        return investYear;
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
