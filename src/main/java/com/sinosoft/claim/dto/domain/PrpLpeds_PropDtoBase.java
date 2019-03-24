package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpeds_Prop�Ʋ���ʧ�ӿ����ݱ�����ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpeds_PropDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ���Ա������������� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ������ʧ��Ŀ���� */
    private String lossItemName = "";
    /** ���Է������� */
    private String feeTypeName = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Ե��� */
    private double unitPrice = 0d;
    /** �������������� */
    private double lossQuantity = 0d;
    /** ����������λ */
    private String unit = "";
    /** �����⳥���� */
    private double lossRate = 0d;
    /** ���Ժ˶����� */
    private double sumDefLoss = 0d;
    /** ���Ա�ע */
    private String remark = "";
    /** �����Ƿ����־ */
    private String transmitFlag = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpeds_PropDtoBase����
     */
    public PrpLpeds_PropDtoBase(){
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �������Ա�������������
     * @param itemKindNo �����õ����Ա������������ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�������������
     * @return ���Ա������������ŵ�ֵ
     */
    public int getItemKindNo(){
        return itemKindNo;
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
     * ����������ʧ��Ŀ����
     * @param lossItemName �����õ�������ʧ��Ŀ���Ƶ�ֵ
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * ��ȡ������ʧ��Ŀ����
     * @return ������ʧ��Ŀ���Ƶ�ֵ
     */
    public String getLossItemName(){
        return lossItemName;
    }

    /**
     * �������Է�������
     * @param feeTypeName �����õ����Է������Ƶ�ֵ
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getFeeTypeName(){
        return feeTypeName;
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
     * �������Ե���
     * @param unitPrice �����õ����Ե��۵�ֵ
     */
    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
    }

    /**
     * ��ȡ���Ե���
     * @return ���Ե��۵�ֵ
     */
    public double getUnitPrice(){
        return unitPrice;
    }

    /**
     * ������������������
     * @param lossQuantity �����õ�����������������ֵ
     */
    public void setLossQuantity(double lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * ��ȡ��������������
     * @return ����������������ֵ
     */
    public double getLossQuantity(){
        return lossQuantity;
    }

    /**
     * ��������������λ
     * @param unit �����õ�����������λ��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ����������λ
     * @return ����������λ��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * ���������⳥����
     * @param lossRate �����õ������⳥������ֵ
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * ��ȡ�����⳥����
     * @return �����⳥������ֵ
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * �������Ժ˶�����
     * @param sumDefLoss �����õ����Ժ˶������ֵ
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * ��ȡ���Ժ˶�����
     * @return ���Ժ˶������ֵ
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
     * ���������Ƿ����־
     * @param transmitFlag �����õ������Ƿ����־��ֵ
     */
    public void setTransmitFlag(String transmitFlag){
        this.transmitFlag = StringUtils.rightTrim(transmitFlag);
    }

    /**
     * ��ȡ�����Ƿ����־
     * @return �����Ƿ����־��ֵ
     */
    public String getTransmitFlag(){
        return transmitFlag;
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
