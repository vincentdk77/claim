package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDaccidentDeduct-�¹����������ʵ����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDaccidentDeductDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �������ִ��� */
    private String riskCode = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����⳥���δ��� */
    private String indemnityDuty = "";
    /** ���Է���ˮƽ */
    private String dangerLevel = "";
    /** ���������� */
    private double deductibleRate = 0D;
    /** ������Ч״̬λ */
    private String validStatus = "";
    /** ������Ч���� */
    private DateTime validDate = new DateTime();
    /** �������� */
    private String deductPeriod = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDaccidentDeductDtoBase����
     */
    public PrpDaccidentDeductDtoBase(){
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
     * ���������⳥���δ���
     * @param indemnityDuty �����õ������⳥���δ����ֵ
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * ��ȡ�����⳥���δ���
     * @return �����⳥���δ����ֵ
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * �������Է���ˮƽ
     * @param dangerLevel �����õ����Է���ˮƽ��ֵ
     */
    public void setDangerLevel(String dangerLevel){
        this.dangerLevel = StringUtils.rightTrim(dangerLevel);
    }

    /**
     * ��ȡ���Է���ˮƽ
     * @return ���Է���ˮƽ��ֵ
     */
    public String getDangerLevel(){
        return dangerLevel;
    }

    /**
     * ��������������
     * @param deductibleRate �����õ����������ʵ�ֵ
     */
    public void setDeductibleRate(double deductibleRate){
        this.deductibleRate = deductibleRate;
    }

    /**
     * ��ȡ����������
     * @return ���������ʵ�ֵ
     */
    public double getDeductibleRate(){
        return deductibleRate;
    }

    /**
     * ����������Ч״̬λ
     * @param validStatus �����õ�������Ч״̬λ��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ������Ч״̬λ
     * @return ������Ч״̬λ��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ����������Ч����
     * @param validDate �����õ�������Ч���ڵ�ֵ
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * ��ȡ������Ч����
     * @return ������Ч���ڵ�ֵ
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * ������������
     * @param deductPeriod �����õ�����������ֵ
     */
    public void setDeductPeriod(String deductPeriod){
        this.deductPeriod = StringUtils.rightTrim(deductPeriod);
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public String getDeductPeriod(){
        return deductPeriod;
    }
}
