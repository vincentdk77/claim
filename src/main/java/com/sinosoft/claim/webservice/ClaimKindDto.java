package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class ClaimKindDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** �����¹������� */
    private String familyName = "";
    /** ���Ա����� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** ���Աұ���� */
    private String currency = "";
    /** ����Ԥ�Ƹ������ */
    private double sumClaim = 0D;
    /** �������:p���z���� */
    private String lossFeeType = "";
    /** ���Բ�ֵ */
    private double kindRest = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�ClaimKindDto����
     */
    public ClaimKindDto(){
    }

    /**
     * ���������¹�������
     * @param familyName �����õ������¹������Ƶ�ֵ
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * ��ȡ�����¹�������
     * @return �����¹������Ƶ�ֵ
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * �������Ա�����
     * @param itemKindNo �����õ����Ա����ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
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
     * ���������ձ�����
     * @param kindName �����õ������ձ����Ƶ�ֵ
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * ��ȡ�����ձ�����
     * @return �����ձ����Ƶ�ֵ
     */
    public String getKindName(){
        return kindName;
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
     * ��������Ԥ�Ƹ������
     * @param sumClaim �����õ�����Ԥ�Ƹ�������ֵ
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * ��ȡ����Ԥ�Ƹ������
     * @return ����Ԥ�Ƹ�������ֵ
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * �����������:p���z����
     * @param lossFeeType �����õ��������:p���z���õ�ֵ
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * ��ȡ�������:p���z����
     * @return �������:p���z���õ�ֵ
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * �������Բ�ֵ
     * @param kindRest �����õ����Բ�ֵ��ֵ
     */
    public void setKindRest(double kindRest){
        this.kindRest = kindRest;
    }

    /**
     * ��ȡ���Բ�ֵ
     * @return ���Բ�ֵ��ֵ
     */
    public double getKindRest(){
        return kindRest;
    }
}
