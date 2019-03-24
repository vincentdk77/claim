package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDdeductCond-��������������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDdeductCondDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �������� */
    private String riskCode = "";
    /** ����������� */
    private String clauseType = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���������������� */
    private String deductCondCode = "";
    /** ���������������� */
    private String deductCondName = "";
    /** ���������� */
    private double deductRate = 0D;
    /** ��������� */
    private double deductible = 0D;
    /** ������������ */
    private DateTime validDate = new DateTime();
    /** ���Ա�־λ */
    private String flag = "";
    /** �������� */
    private String dEDUCTPERIOD = "";
    /** ���Կ�ʼ������������ʵĳ��մ��� */
    private int baseTimes = 0;
    /** ���Էⶥ������ */
    private double maxDeductRate = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDdeductCondDtoBase����
     */
    public PrpDdeductCondDtoBase(){
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
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
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������������������
     * @param deductCondCode �����õ������������������ֵ
     */
    public void setDeductCondCode(String deductCondCode){
        this.deductCondCode = StringUtils.rightTrim(deductCondCode);
    }

    /**
     * ��ȡ����������������
     * @return �����������������ֵ
     */
    public String getDeductCondCode(){
        return deductCondCode;
    }

    /**
     * ��������������������
     * @param deductCondName �����õ����������������Ƶ�ֵ
     */
    public void setDeductCondName(String deductCondName){
        this.deductCondName = StringUtils.rightTrim(deductCondName);
    }

    /**
     * ��ȡ����������������
     * @return ���������������Ƶ�ֵ
     */
    public String getDeductCondName(){
        return deductCondName;
    }

    /**
     * ��������������
     * @param deductRate �����õ����������ʵ�ֵ
     */
    public void setDeductRate(double deductRate){
        this.deductRate = deductRate;
    }

    /**
     * ��ȡ����������
     * @return ���������ʵ�ֵ
     */
    public double getDeductRate(){
        return deductRate;
    }

    /**
     * �������������
     * @param deductible �����õ�����������ֵ
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * ��ȡ���������
     * @return ����������ֵ
     */
    public double getDeductible(){
        return deductible;
    }

    /**
     * ����������������
     * @param validDate �����õ������������ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������������
     * @return �����������ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
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

    /**
     * ������������
     * @param dEDUCTPERIOD �����õ�����������ֵ
     */
    public void setDEDUCTPERIOD(String dEDUCTPERIOD){
        this.dEDUCTPERIOD = StringUtils.rightTrim(dEDUCTPERIOD);
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public String getDEDUCTPERIOD(){
        return dEDUCTPERIOD;
    }

    /**
     * �������Կ�ʼ������������ʵĳ��մ���
     * @param baseTimes �����õ����Կ�ʼ������������ʵĳ��մ�����ֵ
     */
    public void setBaseTimes(int baseTimes){
        this.baseTimes = baseTimes;
    }

    /**
     * ��ȡ���Կ�ʼ������������ʵĳ��մ���
     * @return ���Կ�ʼ������������ʵĳ��մ�����ֵ
     */
    public int getBaseTimes(){
        return baseTimes;
    }

    /**
     * �������Էⶥ������
     * @param maxDeductRate �����õ����Էⶥ�����ʵ�ֵ
     */
    public void setMaxDeductRate(double maxDeductRate){
        this.maxDeductRate = maxDeductRate;
    }

    /**
     * ��ȡ���Էⶥ������
     * @return ���Էⶥ�����ʵ�ֵ
     */
    public double getMaxDeductRate(){
        return maxDeductRate;
    }
}
