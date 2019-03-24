package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcustomer�ͻ���Ϣ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerDtoBase implements Serializable{
    /** ���Կͻ�����(1����/2��λ) */
    private String customerType = "";
    /** ���Կͻ����� */
    private String customerCode = "";
    /** �����ٲ������� */
    private String shortHandCode = "";
    /** ���Կͻ��������� */
    private String customerCName = "";
    /** ���Կͻ�Ӣ������ */
    private String customerEName = "";
    /** ���Ե�ַ�������� */
    private String addressCName = "";
    /** ���Ե�ַӢ������ */
    private String addressEName = "";
    /** ���Է�����֯��������/�������֤���� */
    private String organizeCode = "";
    /** ���Ժ�������־ */
    private String blackState = "";
    /** ������ʱ/��ʽ��־ */
    private String customerFlag = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcustomerDtoBase����
     */
    public PrpDcustomerDtoBase(){
    }

    /**
     * �������Կͻ�����(1����/2��λ)
     * @param customerType �����õ����Կͻ�����(1����/2��λ)��ֵ
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * ��ȡ���Կͻ�����(1����/2��λ)
     * @return ���Կͻ�����(1����/2��λ)��ֵ
     */
    public String getCustomerType(){
        return customerType;
    }

    /**
     * �������Կͻ�����
     * @param customerCode �����õ����Կͻ������ֵ
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * ��ȡ���Կͻ�����
     * @return ���Կͻ������ֵ
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * ���������ٲ�������
     * @param shortHandCode �����õ������ٲ��������ֵ
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * ��ȡ�����ٲ�������
     * @return �����ٲ��������ֵ
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * �������Կͻ���������
     * @param customerCName �����õ����Կͻ��������Ƶ�ֵ
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * ��ȡ���Կͻ���������
     * @return ���Կͻ��������Ƶ�ֵ
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * �������Կͻ�Ӣ������
     * @param customerEName �����õ����Կͻ�Ӣ�����Ƶ�ֵ
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * ��ȡ���Կͻ�Ӣ������
     * @return ���Կͻ�Ӣ�����Ƶ�ֵ
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * �������Ե�ַ��������
     * @param addressCName �����õ����Ե�ַ�������Ƶ�ֵ
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * ��ȡ���Ե�ַ��������
     * @return ���Ե�ַ�������Ƶ�ֵ
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * �������Ե�ַӢ������
     * @param addressEName �����õ����Ե�ַӢ�����Ƶ�ֵ
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * ��ȡ���Ե�ַӢ������
     * @return ���Ե�ַӢ�����Ƶ�ֵ
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * �������Է�����֯��������/�������֤����
     * @param organizeCode �����õ����Է�����֯��������/�������֤�����ֵ
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * ��ȡ���Է�����֯��������/�������֤����
     * @return ���Է�����֯��������/�������֤�����ֵ
     */
    public String getOrganizeCode(){
        return organizeCode;
    }

    /**
     * �������Ժ�������־
     * @param blackState �����õ����Ժ�������־��ֵ
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * ��ȡ���Ժ�������־
     * @return ���Ժ�������־��ֵ
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * ����������ʱ/��ʽ��־
     * @param customerFlag �����õ�������ʱ/��ʽ��־��ֵ
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * ��ȡ������ʱ/��ʽ��־
     * @return ������ʱ/��ʽ��־��ֵ
     */
    public String getCustomerFlag(){
        return customerFlag;
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
}
