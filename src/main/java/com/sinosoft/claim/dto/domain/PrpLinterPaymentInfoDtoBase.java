package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�������ӱ�-----�⸶��Ϣ�����ݴ���������<br>
 */
public class PrpLinterPaymentInfoDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������id PK */
    private String id = "";
    /** ����������� PK */
    private int serialNo = 0;
    /** ���Ա������� */
    private String registNoPay = "";
    /** ���Ա������� */
    private String insuredNamePay = "";
    /** ����������� */
    private String certiNoPay = "";
    /** ����������� */
    private String paymentType = "";
    /** ����������ʹ��� */
    private String paymentTypeCode = "";
    /** ���Խ᰸��� */
    private double sumPaidPay = 0D;
    /** ������֧����� */
    private double havPaidPay = 0D;
    /** ���Ա���֧����� */
    private double paidPay = 0D;
    /** ���Թ���������� */
    private String relationOutId = "";
    /** ���Թ�����������(N��������R�ؿ�����) */
    private String relationOutIdType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterPaymentInfoDtoBase����
     */
    public PrpLinterPaymentInfoDtoBase(){
    }

    /**
     * ������������id PK
     * @param id �����õ���������id PK��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������id PK
     * @return ��������id PK��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ��������������� PK
     * @param serialNo �����õ������������ PK��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����������� PK
     * @return ����������� PK��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Ա�������
     * @param registNoPay �����õ����Ա��������ֵ
     */
    public void setRegistNoPay(String registNoPay){
        this.registNoPay = StringUtils.rightTrim(registNoPay);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNoPay(){
        return registNoPay;
    }

    /**
     * �������Ա�������
     * @param insuredNamePay �����õ����Ա������˵�ֵ
     */
    public void setInsuredNamePay(String insuredNamePay){
        this.insuredNamePay = StringUtils.rightTrim(insuredNamePay);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������˵�ֵ
     */
    public String getInsuredNamePay(){
        return insuredNamePay;
    }

    /**
     * ���������������
     * @param certiNoPay �����õ�����������ŵ�ֵ
     */
    public void setCertiNoPay(String certiNoPay){
        this.certiNoPay = StringUtils.rightTrim(certiNoPay);
    }

    /**
     * ��ȡ�����������
     * @return ����������ŵ�ֵ
     */
    public String getCertiNoPay(){
        return certiNoPay;
    }

    /**
     * ���������������
     * @param paymentType �����õ�����������͵�ֵ
     */
    public void setPaymentType(String paymentType){
        this.paymentType = StringUtils.rightTrim(paymentType);
    }

    /**
     * ��ȡ�����������
     * @return ����������͵�ֵ
     */
    public String getPaymentType(){
        return paymentType;
    }

    /**
     * ��������������ʹ���
     * @param paymentTypeCode �����õ�����������ʹ����ֵ
     */
    public void setPaymentTypeCode(String paymentTypeCode){
        this.paymentTypeCode = StringUtils.rightTrim(paymentTypeCode);
    }

    /**
     * ��ȡ����������ʹ���
     * @return ����������ʹ����ֵ
     */
    public String getPaymentTypeCode(){
        return paymentTypeCode;
    }

    /**
     * �������Խ᰸���
     * @param sumPaidPay �����õ����Խ᰸����ֵ
     */
    public void setSumPaidPay(double sumPaidPay){
        this.sumPaidPay = sumPaidPay;
    }

    /**
     * ��ȡ���Խ᰸���
     * @return ���Խ᰸����ֵ
     */
    public double getSumPaidPay(){
        return sumPaidPay;
    }

    /**
     * ����������֧�����
     * @param havPaidPay �����õ�������֧������ֵ
     */
    public void setHavPaidPay(double havPaidPay){
        this.havPaidPay = havPaidPay;
    }

    /**
     * ��ȡ������֧�����
     * @return ������֧������ֵ
     */
    public double getHavPaidPay(){
        return havPaidPay;
    }

    /**
     * �������Ա���֧�����
     * @param paidPay �����õ����Ա���֧������ֵ
     */
    public void setPaidPay(double paidPay){
        this.paidPay = paidPay;
    }

    /**
     * ��ȡ���Ա���֧�����
     * @return ���Ա���֧������ֵ
     */
    public double getPaidPay(){
        return paidPay;
    }

    /**
     * �������Թ����������
     * @param relationOutId �����õ����Թ������������ֵ
     */
    public void setRelationOutId(String relationOutId){
        this.relationOutId = StringUtils.rightTrim(relationOutId);
    }

    /**
     * ��ȡ���Թ����������
     * @return ���Թ������������ֵ
     */
    public String getRelationOutId(){
        return relationOutId;
    }

    /**
     * �������Թ�����������(N��������R�ؿ�����)
     * @param relationOutIdType �����õ����Թ�����������(N��������R�ؿ�����)��ֵ
     */
    public void setRelationOutIdType(String relationOutIdType){
        this.relationOutIdType = StringUtils.rightTrim(relationOutIdType);
    }

    /**
     * ��ȡ���Թ�����������(N��������R�ؿ�����)
     * @return ���Թ�����������(N��������R�ؿ�����)��ֵ
     */
    public String getRelationOutIdType(){
        return relationOutIdType;
    }
}
