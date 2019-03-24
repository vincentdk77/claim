package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcurrency�ұ���������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcurrencyDtoBase implements Serializable{
    /** ���Աұ���� */
    private String currencyCode = "";
    /** ���Աұ��������� */
    private String currencyCName = "";
    /** ���Աұ�Ӣ������ */
    private String currencyEName = "";
    /** �������±ұ���� */
    private String newCurrencyCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcurrencyDtoBase����
     */
    public PrpDcurrencyDtoBase(){
    }
    public PrpDcurrencyDtoBase(String currencyCode,String currencyCName){
    	
    	this.currencyCode = currencyCode;
    	this.currencyCName = currencyCName;
    }
    /**
     * �������Աұ����
     * @param currencyCode �����õ����Աұ�����ֵ
     */
    public void setCurrencyCode(String currencyCode){
        this.currencyCode = StringUtils.rightTrim(currencyCode);
    }

    /**
     * ��ȡ���Աұ����
     * @return ���Աұ�����ֵ
     */
    public String getCurrencyCode(){
        return currencyCode;
    }

    /**
     * �������Աұ���������
     * @param currencyCName �����õ����Աұ��������Ƶ�ֵ
     */
    public void setCurrencyCName(String currencyCName){
        this.currencyCName = StringUtils.rightTrim(currencyCName);
    }

    /**
     * ��ȡ���Աұ���������
     * @return ���Աұ��������Ƶ�ֵ
     */
    public String getCurrencyCName(){
        return currencyCName;
    }

    /**
     * �������Աұ�Ӣ������
     * @param currencyEName �����õ����Աұ�Ӣ�����Ƶ�ֵ
     */
    public void setCurrencyEName(String currencyEName){
        this.currencyEName = StringUtils.rightTrim(currencyEName);
    }

    /**
     * ��ȡ���Աұ�Ӣ������
     * @return ���Աұ�Ӣ�����Ƶ�ֵ
     */
    public String getCurrencyEName(){
        return currencyEName;
    }

    /**
     * �����������±ұ����
     * @param newCurrencyCode �����õ��������±ұ�����ֵ
     */
    public void setNewCurrencyCode(String newCurrencyCode){
        this.newCurrencyCode = StringUtils.rightTrim(newCurrencyCode);
    }

    /**
     * ��ȡ�������±ұ����
     * @return �������±ұ�����ֵ
     */
    public String getNewCurrencyCode(){
        return newCurrencyCode;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
