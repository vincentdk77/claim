package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpjrefrecdetail���ѵǼ���ϸ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJrefRecDetailDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ե������� */
    private String certiType = "";
    /** ���Ա�������/��������/����������� */
    private String certiNo = "";
    /** ���Ա��θ������ */
    private int serialNo = 0;
    /** ���Ա���ձ���� */
    private int itemKindNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Ա�Ĵ��� */
    private String itemCode = "";
    /** ����Ӧ������ */
    private String currency1 = "";
    /** ����Ӧ����� */
    private double refundFee = 0d;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJrefRecDetailDtoBase����
     */
    public PrpJrefRecDetailDtoBase(){
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
     * �������Ե�������
     * @param certiType �����õ����Ե������͵�ֵ
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * ��ȡ���Ե�������
     * @return ���Ե������͵�ֵ
     */
    public String getCertiType(){
        return certiType;
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
     * �������Ա���ձ����
     * @param itemKindNo �����õ����Ա���ձ���ŵ�ֵ
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * ��ȡ���Ա���ձ����
     * @return ���Ա���ձ���ŵ�ֵ
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
     * �������Ա�Ĵ���
     * @param itemCode �����õ����Ա�Ĵ����ֵ
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * ��ȡ���Ա�Ĵ���
     * @return ���Ա�Ĵ����ֵ
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * ��������Ӧ������
     * @param currency1 �����õ�����Ӧ�����ֵ�ֵ
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * ��ȡ����Ӧ������
     * @return ����Ӧ�����ֵ�ֵ
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * ��������Ӧ�����
     * @param refundFee �����õ�����Ӧ������ֵ
     */
    public void setRefundFee(double refundFee){
        this.refundFee = refundFee;
    }

    /**
     * ��ȡ����Ӧ�����
     * @return ����Ӧ������ֵ
     */
    public double getRefundFee(){
        return refundFee;
    }
}
