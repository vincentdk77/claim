package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcitem���ձ����Ŀ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCitemDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** ���Ա����Ŀ������ */
    private String itemCode = "";
    /** ���Ա����Ŀ������� */
    private String itemName = "";
    /** ���Լӳɱ��� */
    private double plusRate = 0d;
    /** ���Ա�ĵ�ַ��� */
    private int addressNo = 0;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCitemDtoBase����
     */
    public PrpCitemDtoBase(){
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
     * �������Ա�����
     * @param itemNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * �������Ա����Ŀ������
     * @param itemCode �����õ����Ա����Ŀ�������ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա����Ŀ������
     * @return ���Ա����Ŀ�������ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * �������Ա����Ŀ�������
     * @param itemName �����õ����Ա����Ŀ������Ƶ�ֵ
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * ��ȡ���Ա����Ŀ�������
     * @return ���Ա����Ŀ������Ƶ�ֵ
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * �������Լӳɱ���
     * @param plusRate �����õ����Լӳɱ�����ֵ
     */
    public void setPlusRate(double plusRate){
        this.plusRate = plusRate;
    }

    /**
     * ��ȡ���Լӳɱ���
     * @return ���Լӳɱ�����ֵ
     */
    public double getPlusRate(){
        return plusRate;
    }

    /**
     * �������Ա�ĵ�ַ���
     * @param addressNo �����õ����Ա�ĵ�ַ��ŵ�ֵ
     */
    public void setAddressNo(int addressNo){
        this.addressNo = addressNo;
    }

    /**
     * ��ȡ���Ա�ĵ�ַ���
     * @return ���Ա�ĵ�ַ��ŵ�ֵ
     */
    public int getAddressNo(){
        return addressNo;
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
