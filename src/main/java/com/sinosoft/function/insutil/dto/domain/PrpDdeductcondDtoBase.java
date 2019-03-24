package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpddeductcond�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdeductcondDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����clausetype */
    private String clauseType = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����deductcondcode */
    private String deductCondCode = "";
    /** ����deductcondname */
    private String deductCondName = "";
    /** ����deductrate */
    private double deductRate = 0d;
    /** ����deductible */
    private double deductible = 0d;
    /** ����validdate */
    private DateTime validDate = new DateTime();
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdeductcondDtoBase����
     */
    public PrpDdeductcondDtoBase(){
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
     * ��������deductcondcode
     * @param deductCondCode �����õ�����deductcondcode��ֵ
     */
    public void setDeductCondCode(String deductCondCode){
        this.deductCondCode = StringUtils.rightTrim(deductCondCode);
    }

    /**
     * ��ȡ����deductcondcode
     * @return ����deductcondcode��ֵ
     */
    public String getDeductCondCode(){
        return deductCondCode;
    }

    /**
     * ��������deductcondname
     * @param deductCondName �����õ�����deductcondname��ֵ
     */
    public void setDeductCondName(String deductCondName){
        this.deductCondName = StringUtils.rightTrim(deductCondName);
    }

    /**
     * ��ȡ����deductcondname
     * @return ����deductcondname��ֵ
     */
    public String getDeductCondName(){
        return deductCondName;
    }

    /**
     * ��������deductrate
     * @param deductRate �����õ�����deductrate��ֵ
     */
    public void setDeductRate(double deductRate){
        this.deductRate = deductRate;
    }

    /**
     * ��ȡ����deductrate
     * @return ����deductrate��ֵ
     */
    public double getDeductRate(){
        return deductRate;
    }

    /**
     * ��������deductible
     * @param deductible �����õ�����deductible��ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ����deductible
     * @return ����deductible��ֵ
     */
    public double getDeductible(){
        return deductible;
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
