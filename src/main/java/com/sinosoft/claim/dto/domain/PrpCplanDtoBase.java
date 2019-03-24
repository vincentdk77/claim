package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcplan�շѼƻ�������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCplanDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ������������ */
    private String endorseNo = "";
    /** ���Խ��Ѵ������ */
    private int serialNo = 0;
    /** ���Խ����ڴ� */
    private int payNo = 0;
    /** ���Խ���ԭ�� */
    private String payReason = "";
    /** ���Լƻ����ѽ�ֹ���� */
    private DateTime planDate = new DateTime();
    /** ���Աұ� */
    private String currency = "";
    /** ����Ӧ���ѽ�� */
    private double planFee = 0d;
    /** ������Ƿ��� */
    private double delinquentFee = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCplanDtoBase����
     */
    public PrpCplanDtoBase(){
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ����������������
     * @param endorseNo �����õ��������������ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * �������Խ��Ѵ������
     * @param serialNo �����õ����Խ��Ѵ�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Խ��Ѵ������
     * @return ���Խ��Ѵ�����ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Խ����ڴ�
     * @param payNo �����õ����Խ����ڴε�ֵ
     */
    public void setPayNo(int payNo){
        this.payNo = payNo;
    }

    /**
     * ��ȡ���Խ����ڴ�
     * @return ���Խ����ڴε�ֵ
     */
    public int getPayNo(){
        return payNo;
    }

    /**
     * �������Խ���ԭ��
     * @param payReason �����õ����Խ���ԭ���ֵ
     */
    public void setPayReason(String payReason){
        this.payReason = StringUtils.rightTrim(payReason);
    }

    /**
     * ��ȡ���Խ���ԭ��
     * @return ���Խ���ԭ���ֵ
     */
    public String getPayReason(){
        return payReason;
    }

    /**
     * �������Լƻ����ѽ�ֹ����
     * @param planDate �����õ����Լƻ����ѽ�ֹ���ڵ�ֵ
     */
    public void setPlanDate(DateTime planDate){
        this.planDate = planDate;
    }

    /**
     * ��ȡ���Լƻ����ѽ�ֹ����
     * @return ���Լƻ����ѽ�ֹ���ڵ�ֵ
     */
    public DateTime getPlanDate(){
        return planDate;
    }

    /**
     * �������Աұ�
     * @param currency �����õ����Աұ��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ�
     * @return ���Աұ��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������Ӧ���ѽ��
     * @param planFee �����õ�����Ӧ���ѽ���ֵ
     */
    public void setPlanFee(double planFee){
        this.planFee = planFee;
    }

    /**
     * ��ȡ����Ӧ���ѽ��
     * @return ����Ӧ���ѽ���ֵ
     */
    public double getPlanFee(){
        return planFee;
    }

    /**
     * ����������Ƿ���
     * @param delinquentFee �����õ�������Ƿ����ֵ
     */
    public void setDelinquentFee(double delinquentFee){
        this.delinquentFee = delinquentFee;
    }

    /**
     * ��ȡ������Ƿ���
     * @return ������Ƿ����ֵ
     */
    public double getDelinquentFee(){
        return delinquentFee;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
