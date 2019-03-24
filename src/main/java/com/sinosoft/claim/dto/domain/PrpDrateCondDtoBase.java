package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdratecond��������������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateCondDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ������������ */
    private DateTime validDate = new DateTime();
    /** ���Է������� */
    private int ratePeriod = 0;
    /** ������������ */
    private String condCode = "";
    /** ������������ */
    private String condName = "";
    /** ��������ȡֵ���� */
    private double lowerValue = 0d;
    /** ��������ȡֵ���� */
    private double upperValue = 0d;
    /** ����ȡֵ���� */
    private String valueCode = "";
    /** ����ȡֵ���� */
    private String valueName = "";
    /** ������ʼλ�� */
    private int startpos = 0;
    /** ������ֹλ�� */
    private int endpos = 0;
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDrateCondDtoBase����
     */
    public PrpDrateCondDtoBase(){
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
     * �������Է�������
     * @param ratePeriod �����õ����Է���������ֵ
     */
    public void setRatePeriod(int ratePeriod){
        this.ratePeriod = ratePeriod;
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է���������ֵ
     */
    public int getRatePeriod(){
        return ratePeriod;
    }

    /**
     * ����������������
     * @param condCode �����õ��������������ֵ
     */
    public void setCondCode(String condCode){
        this.condCode = StringUtils.rightTrim(condCode);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getCondCode(){
        return condCode;
    }

    /**
     * ����������������
     * @param condName �����õ������������Ƶ�ֵ
     */
    public void setCondName(String condName){
        this.condName = StringUtils.rightTrim(condName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getCondName(){
        return condName;
    }

    /**
     * ������������ȡֵ����
     * @param lowerValue �����õ���������ȡֵ���޵�ֵ
     */
    public void setLowerValue(double lowerValue){
        this.lowerValue = lowerValue;
    }

    /**
     * ��ȡ��������ȡֵ����
     * @return ��������ȡֵ���޵�ֵ
     */
    public double getLowerValue(){
        return lowerValue;
    }

    /**
     * ������������ȡֵ����
     * @param upperValue �����õ���������ȡֵ���޵�ֵ
     */
    public void setUpperValue(double upperValue){
        this.upperValue = upperValue;
    }

    /**
     * ��ȡ��������ȡֵ����
     * @return ��������ȡֵ���޵�ֵ
     */
    public double getUpperValue(){
        return upperValue;
    }

    /**
     * ��������ȡֵ����
     * @param valueCode �����õ�����ȡֵ�����ֵ
     */
    public void setValueCode(String valueCode){
        this.valueCode = StringUtils.rightTrim(valueCode);
    }

    /**
     * ��ȡ����ȡֵ����
     * @return ����ȡֵ�����ֵ
     */
    public String getValueCode(){
        return valueCode;
    }

    /**
     * ��������ȡֵ����
     * @param valueName �����õ�����ȡֵ���Ƶ�ֵ
     */
    public void setValueName(String valueName){
        this.valueName = StringUtils.rightTrim(valueName);
    }

    /**
     * ��ȡ����ȡֵ����
     * @return ����ȡֵ���Ƶ�ֵ
     */
    public String getValueName(){
        return valueName;
    }

    /**
     * ����������ʼλ��
     * @param startpos �����õ�������ʼλ�õ�ֵ
     */
    public void setStartpos(int startpos){
        this.startpos = startpos;
    }

    /**
     * ��ȡ������ʼλ��
     * @return ������ʼλ�õ�ֵ
     */
    public int getStartpos(){
        return startpos;
    }

    /**
     * ����������ֹλ��
     * @param endpos �����õ�������ֹλ�õ�ֵ
     */
    public void setEndpos(int endpos){
        this.endpos = endpos;
    }

    /**
     * ��ȡ������ֹλ��
     * @return ������ֹλ�õ�ֵ
     */
    public int getEndpos(){
        return endpos;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
