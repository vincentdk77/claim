package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjrefpayrec���Ѻ��շ���ϵ��¼������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJrefPayRecDtoBase implements Serializable{
    /** ���Ա�������/��������/����������� */
    private String certiNo = "";
    /** ���Ա��θ������ */
    private int serialNo = 0;
    /** ���Գ�����ѱ�־ */
    private String payFlag = "";
    /** �����շ���� */
    private int order02No = 0;
    /** ���Խ��Ѽƻ����� */
    private int payTimes = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJrefPayRecDtoBase����
     */
    public PrpJrefPayRecDtoBase(){
    }

    /**
     * �������Ա�������/��������/�����������
     * @param certiNo �����õ����Ա�������/��������/������������ֵ
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * ��ȡ���Ա�������/��������/�����������
     * @return ���Ա�������/��������/������������ֵ
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * �������Ա��θ������
     * @param serialNo �����õ����Ա��θ�����ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ���Ա��θ������
     * @return ���Ա��θ�����ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Գ�����ѱ�־
     * @param payFlag �����õ����Գ�����ѱ�־��ֵ
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * ��ȡ���Գ�����ѱ�־
     * @return ���Գ�����ѱ�־��ֵ
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * ���������շ����
     * @param order02No �����õ������շ���ŵ�ֵ
     */
    public void setOrder02No(int order02No){
        this.order02No = order02No;
    }

    /**
     * ��ȡ�����շ����
     * @return �����շ���ŵ�ֵ
     */
    public int getOrder02No(){
        return order02No;
    }

    /**
     * �������Խ��Ѽƻ�����
     * @param payTimes �����õ����Խ��Ѽƻ�������ֵ
     */
    public void setPayTimes(int payTimes){
        this.payTimes = payTimes;
    }

    /**
     * ��ȡ���Խ��Ѽƻ�����
     * @return ���Խ��Ѽƻ�������ֵ
     */
    public int getPayTimes(){
        return payTimes;
    }
}
