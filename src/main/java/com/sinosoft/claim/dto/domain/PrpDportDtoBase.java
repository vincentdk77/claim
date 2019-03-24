package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdport�ۿڴ�������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDportDtoBase implements Serializable{
    /** ���Ըۿڴ��� */
    private String portCode = "";
    /** ���Ըۿ��������� */
    private String portCName = "";
    /** ���Ըۿ�Ӣ������ */
    private String portEName = "";
    /** ���Թ������ */
    private String countryCode = "";
    /** ���Թ����������� */
    private String countryCName = "";
    /** ���Թ���Ӣ������ */
    private String countryEName = "";
    /** �����µĸۿڴ��� */
    private String newPortCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDportDtoBase����
     */
    public PrpDportDtoBase(){
    }

    /**
     * �������Ըۿڴ���
     * @param portCode �����õ����Ըۿڴ����ֵ
     */
    public void setPortCode(String portCode){
        this.portCode = StringUtils.rightTrim(portCode);
    }

    /**
     * ��ȡ���Ըۿڴ���
     * @return ���Ըۿڴ����ֵ
     */
    public String getPortCode(){
        return portCode;
    }

    /**
     * �������Ըۿ���������
     * @param portCName �����õ����Ըۿ��������Ƶ�ֵ
     */
    public void setPortCName(String portCName){
        this.portCName = StringUtils.rightTrim(portCName);
    }

    /**
     * ��ȡ���Ըۿ���������
     * @return ���Ըۿ��������Ƶ�ֵ
     */
    public String getPortCName(){
        return portCName;
    }

    /**
     * �������Ըۿ�Ӣ������
     * @param portEName �����õ����Ըۿ�Ӣ�����Ƶ�ֵ
     */
    public void setPortEName(String portEName){
        this.portEName = StringUtils.rightTrim(portEName);
    }

    /**
     * ��ȡ���Ըۿ�Ӣ������
     * @return ���Ըۿ�Ӣ�����Ƶ�ֵ
     */
    public String getPortEName(){
        return portEName;
    }

    /**
     * �������Թ������
     * @param countryCode �����õ����Թ�������ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ���Թ������
     * @return ���Թ�������ֵ
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * �������Թ�����������
     * @param countryCName �����õ����Թ����������Ƶ�ֵ
     */
    public void setCountryCName(String countryCName){
        this.countryCName = StringUtils.rightTrim(countryCName);
    }

    /**
     * ��ȡ���Թ�����������
     * @return ���Թ����������Ƶ�ֵ
     */
    public String getCountryCName(){
        return countryCName;
    }

    /**
     * �������Թ���Ӣ������
     * @param countryEName �����õ����Թ���Ӣ�����Ƶ�ֵ
     */
    public void setCountryEName(String countryEName){
        this.countryEName = StringUtils.rightTrim(countryEName);
    }

    /**
     * ��ȡ���Թ���Ӣ������
     * @return ���Թ���Ӣ�����Ƶ�ֵ
     */
    public String getCountryEName(){
        return countryEName;
    }

    /**
     * ���������µĸۿڴ���
     * @param newPortCode �����õ������µĸۿڴ����ֵ
     */
    public void setNewPortCode(String newPortCode){
        this.newPortCode = StringUtils.rightTrim(newPortCode);
    }

    /**
     * ��ȡ�����µĸۿڴ���
     * @return �����µĸۿڴ����ֵ
     */
    public String getNewPortCode(){
        return newPortCode;
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
