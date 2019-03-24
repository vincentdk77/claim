package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdidentifier�����˴��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDtoBase implements Serializable{
    /** ���Լ����˴��� */
    private String identifierCode = "";
    /** ���Թ��Ҵ��� */
    private String countryCode = "";
    /** ���Թ����������� */
    private String countryCName = "";
    /** ���Թ���Ӣ������ */
    private String countryEName = "";
    /** ���Ըۿڴ��� */
    private String portCode = "";
    /** ���Ըۿ����� */
    private String portName = "";
    /** �������ȼ��� */
    private int identifierOrder = 0;
    /** ���Լ��������� */
    private String identifierName = "";
    /** ���Լ����˵�ַ */
    private String identifierAddress = "";
    /** ���Լ��������� */
    private String identifierType = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDidentifierDtoBase����
     */
    public PrpDidentifierDtoBase(){
    }

    /**
     * �������Լ����˴���
     * @param identifierCode �����õ����Լ����˴����ֵ
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * ��ȡ���Լ����˴���
     * @return ���Լ����˴����ֵ
     */
    public String getIdentifierCode(){
        return identifierCode;
    }

    /**
     * �������Թ��Ҵ���
     * @param countryCode �����õ����Թ��Ҵ����ֵ
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * ��ȡ���Թ��Ҵ���
     * @return ���Թ��Ҵ����ֵ
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
     * �������Ըۿ�����
     * @param portName �����õ����Ըۿ����Ƶ�ֵ
     */
    public void setPortName(String portName){
        this.portName = StringUtils.rightTrim(portName);
    }

    /**
     * ��ȡ���Ըۿ�����
     * @return ���Ըۿ����Ƶ�ֵ
     */
    public String getPortName(){
        return portName;
    }

    /**
     * �����������ȼ���
     * @param identifierOrder �����õ��������ȼ����ֵ
     */
    public void setIdentifierOrder(int identifierOrder){
        this.identifierOrder = identifierOrder;
    }

    /**
     * ��ȡ�������ȼ���
     * @return �������ȼ����ֵ
     */
    public int getIdentifierOrder(){
        return identifierOrder;
    }

    /**
     * �������Լ���������
     * @param identifierName �����õ����Լ��������Ƶ�ֵ
     */
    public void setIdentifierName(String identifierName){
        this.identifierName = StringUtils.rightTrim(identifierName);
    }

    /**
     * ��ȡ���Լ���������
     * @return ���Լ��������Ƶ�ֵ
     */
    public String getIdentifierName(){
        return identifierName;
    }

    /**
     * �������Լ����˵�ַ
     * @param identifierAddress �����õ����Լ����˵�ַ��ֵ
     */
    public void setIdentifierAddress(String identifierAddress){
        this.identifierAddress = StringUtils.rightTrim(identifierAddress);
    }

    /**
     * ��ȡ���Լ����˵�ַ
     * @return ���Լ����˵�ַ��ֵ
     */
    public String getIdentifierAddress(){
        return identifierAddress;
    }

    /**
     * �������Լ���������
     * @param identifierType �����õ����Լ��������͵�ֵ
     */
    public void setIdentifierType(String identifierType){
        this.identifierType = StringUtils.rightTrim(identifierType);
    }

    /**
     * ��ȡ���Լ���������
     * @return ���Լ��������͵�ֵ
     */
    public String getIdentifierType(){
        return identifierType;
    }

    /**
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
