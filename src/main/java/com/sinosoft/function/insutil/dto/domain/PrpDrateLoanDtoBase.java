package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdrateloan�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateLoanDtoBase implements Serializable{
    /** ����period */
    private int period = 0;
    /** ����classcode */
    private String classCode = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����kindname */
    private String kindName = "";
    /** ����comcode */
    private String comCode = "";
    /** ����years */
    private int years = 0;
    /** ����coefficient */
    private double coefficient = 0d;
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����validstatus */
    private String validStatus = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateLoanDtoBase����
     */
    public PrpDrateLoanDtoBase(){
    }

    /**
     * ��������period
     * @param period �����õ�����period��ֵ
     */
    public void setPeriod(int period){
        this.period = period;
    }

    /**
     * ��ȡ����period
     * @return ����period��ֵ
     */
    public int getPeriod(){
        return period;
    }

    /**
     * ��������classcode
     * @param classCode �����õ�����classcode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����classcode
     * @return ����classcode��ֵ
     */
    public String getClassCode(){
        return classCode;
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
     * ��������kindcode
     * @param kindCode �����õ�����kindcode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindcode
     * @return ����kindcode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������kindname
     * @param kindName �����õ�����kindname��ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ����kindname
     * @return ����kindname��ֵ
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������years
     * @param years �����õ�����years��ֵ
     */
    public void setYears(int years){
        this.years = years;
    }

    /**
     * ��ȡ����years
     * @return ����years��ֵ
     */
    public int getYears(){
        return years;
    }

    /**
     * ��������coefficient
     * @param coefficient �����õ�����coefficient��ֵ
     */
    public void setCoefficient(double coefficient){
        this.coefficient = coefficient;
    }

    /**
     * ��ȡ����coefficient
     * @return ����coefficient��ֵ
     */
    public double getCoefficient(){
        return coefficient;
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
