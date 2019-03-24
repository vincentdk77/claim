package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpUndoCancelFee���ϻ�ɾ�������켣��������ݴ���������<br>
 * ������ 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUndoCancelFeeDtoBase implements Serializable{
    /** ���Բ������ʹ��� */
    private String operateTypeCode = "";
    /** ���Ե�֤�� */
    private String certiNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Աұ���� */
    private String currency = "";
    /** �����ܱ���仯�� */
    private double amount = 0d;
    /** �����ܱ��ѣ��仯�� */
    private double premium = 0d;
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpUndoCancelFeeDtoBase����
     */
    public PrpUndoCancelFeeDtoBase(){
    }

    /**
     * �������Բ������ʹ���
     * @param operateTypeCode �����õ����Բ������ʹ����ֵ
     */
    public void setOperateTypeCode(String operateTypeCode){
        this.operateTypeCode = StringUtils.rightTrim(operateTypeCode);
    }

    /**
     * ��ȡ���Բ������ʹ���
     * @return ���Բ������ʹ����ֵ
     */
    public String getOperateTypeCode(){
        return operateTypeCode;
    }

    /**
     * �������Ե�֤��
     * @param certiNo �����õ����Ե�֤�ŵ�ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ե�֤��
     * @return ���Ե�֤�ŵ�ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Աұ����
     * @param currency �����õ����Աұ�����ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ���������ܱ���仯��
     * @param amount �����õ������ܱ���仯����ֵ
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * ��ȡ�����ܱ���仯��
     * @return �����ܱ���仯����ֵ
     */
    public double getAmount(){
        return amount;
    }

    /**
     * ���������ܱ��ѣ��仯��
     * @param premium �����õ������ܱ��ѣ��仯����ֵ
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * ��ȡ�����ܱ��ѣ��仯��
     * @return �����ܱ��ѣ��仯����ֵ
     */
    public double getPremium(){
        return premium;
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
