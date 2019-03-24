package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpccardeviceͶ�������������豸��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcarDeviceDtoBase implements Serializable{
    /** ���Ա��յ����� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա����� */
    private int itemNo = 0;
    /** ����˳��� */
    private int serialNo = 0;
    /** �����豸���� */
    private String deviceName = "";
    /** ���Աұ� */
    private String currency = "";
    /** �������� */
    private int quantity = 0;
    /** �����¼����ü� */
    private double purchasePrice = 0d;
    /** ����ʵ�ʼ�ֵ */
    private double actualValue = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCcarDeviceDtoBase����
     */
    public PrpCcarDeviceDtoBase(){
    }

    /**
     * �������Ա��յ�����
     * @param policyNo �����õ����Ա��յ������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա��յ�����
     * @return ���Ա��յ������ֵ
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
     * ��������˳���
     * @param serialNo �����õ�����˳��ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����˳���
     * @return ����˳��ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������豸����
     * @param deviceName �����õ������豸���Ƶ�ֵ
     */
    public void setDeviceName(String deviceName){
        this.deviceName = StringUtils.rightTrim(deviceName);
    }

    /**
     * ��ȡ�����豸����
     * @return �����豸���Ƶ�ֵ
     */
    public String getDeviceName(){
        return deviceName;
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
     * ������������
     * @param quantity �����õ�����������ֵ
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * ��ȡ��������
     * @return ����������ֵ
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * ���������¼����ü�
     * @param purchasePrice �����õ������¼����ü۵�ֵ
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * ��ȡ�����¼����ü�
     * @return �����¼����ü۵�ֵ
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * ��������ʵ�ʼ�ֵ
     * @param actualValue �����õ�����ʵ�ʼ�ֵ��ֵ
     */
    public void setActualValue(double actualValue){
        this.actualValue = actualValue;
    }

    /**
     * ��ȡ����ʵ�ʼ�ֵ
     * @return ����ʵ�ʼ�ֵ��ֵ
     */
    public double getActualValue(){
        return actualValue;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
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
