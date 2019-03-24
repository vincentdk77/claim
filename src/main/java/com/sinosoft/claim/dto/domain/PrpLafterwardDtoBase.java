package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLafterward-������ô��������ݴ���������<br>
 * ������ 2005-03-18 17:53:35.187<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLafterwardDtoBase implements Serializable{
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ������� */
    private int serialNo = 0;
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Է��������� */
    private String chargeCode = "";
    /** ���Է������� */
    private String chargeName = "";
    /** ���Աұ� */
    private String currency = "";
    /** ���Է��ý�� */
    private double chargeAmount = 0d;
    /** ���Լ�������� */
    private double sumRealPay = 0d;
    /** ���Դ������� */
    private DateTime dealDate = new DateTime();
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLafterwardDtoBase����
     */
    public PrpLafterwardDtoBase(){
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
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
     * �������Է���������
     * @param chargeCode �����õ����Է����������ֵ
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * ��ȡ���Է���������
     * @return ���Է����������ֵ
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * �������Է�������
     * @param chargeName �����õ����Է������Ƶ�ֵ
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getChargeName(){
        return chargeName;
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
     * �������Է��ý��
     * @param chargeAmount �����õ����Է��ý���ֵ
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * ��ȡ���Է��ý��
     * @return ���Է��ý���ֵ
     */
    public double getChargeAmount(){
        return chargeAmount;
    }

    /**
     * �������Լ��������
     * @param sumRealPay �����õ����Լ���������ֵ
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * ��ȡ���Լ��������
     * @return ���Լ���������ֵ
     */
    public double getSumRealPay(){
        return sumRealPay;
    }

    /**
     * �������Դ�������
     * @param dealDate �����õ����Դ������ڵ�ֵ
     */
    public void setDealDate(DateTime dealDate){
        this.dealDate = dealDate;
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������ڵ�ֵ
     */
    public DateTime getDealDate(){
        return dealDate;
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
