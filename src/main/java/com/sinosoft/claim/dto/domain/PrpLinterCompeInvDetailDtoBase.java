package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǵ�ҽ�ƽӿڲ����м���ӱ�������嵥��Ϣ��ϸ������ݴ���������<br>
 */
public class PrpLinterCompeInvDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** �����嵥������� */
    private int serialNo = 0;
    /** �����嵥��ϸ��� */
    private int detilSerialNo = 0;
    /** ���Ա����������� */
    private String name = "";
    /** ����ҽ����� */
    private String medicalCard = "";
    /** �������֤���� */
    private String idCard = "";
    /** ���Է�Ʊ��� */
    private double sumInsured = 0D;
    /** �����⸶��� */
    private double settleSum = 0D;
    /** ���Ի��� */
    private String medicalFamily = "";
    /** ���Կ����� */
    private String bank = "";
    /** ���������˻� */
    private String creditCard = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCompeInvDetailDtoBase����
     */
    public PrpLinterCompeInvDetailDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * ���������嵥�������
     * @param serialNo �����õ������嵥������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����嵥�������
     * @return �����嵥������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������嵥��ϸ���
     * @param detilSerialNo �����õ������嵥��ϸ��ŵ�ֵ
     */
    public void setDetilSerialNo(int detilSerialNo){
        this.detilSerialNo = detilSerialNo;
    }

    /**
     * ��ȡ�����嵥��ϸ���
     * @return �����嵥��ϸ��ŵ�ֵ
     */
    public int getDetilSerialNo(){
        return detilSerialNo;
    }

    /**
     * �������Ա�����������
     * @param name �����õ����Ա����������Ƶ�ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ���Ա�����������
     * @return ���Ա����������Ƶ�ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������ҽ�����
     * @param medicalCard �����õ�����ҽ����ŵ�ֵ
     */
    public void setMedicalCard(String medicalCard){
        this.medicalCard = StringUtils.rightTrim(medicalCard);
    }

    /**
     * ��ȡ����ҽ�����
     * @return ����ҽ����ŵ�ֵ
     */
    public String getMedicalCard(){
        return medicalCard;
    }

    /**
     * �����������֤����
     * @param idCard �����õ��������֤�����ֵ
     */
    public void setIdCard(String idCard){
        this.idCard = StringUtils.rightTrim(idCard);
    }

    /**
     * ��ȡ�������֤����
     * @return �������֤�����ֵ
     */
    public String getIdCard(){
        return idCard;
    }

    /**
     * �������Է�Ʊ���
     * @param sumInsured �����õ����Է�Ʊ����ֵ
     */
    public void setSumInsured(double sumInsured){
        this.sumInsured = sumInsured;
    }

    /**
     * ��ȡ���Է�Ʊ���
     * @return ���Է�Ʊ����ֵ
     */
    public double getSumInsured(){
        return sumInsured;
    }

    /**
     * ���������⸶���
     * @param settleSum �����õ������⸶����ֵ
     */
    public void setSettleSum(double settleSum){
        this.settleSum = settleSum;
    }

    /**
     * ��ȡ�����⸶���
     * @return �����⸶����ֵ
     */
    public double getSettleSum(){
        return settleSum;
    }

    /**
     * �������Ի���
     * @param medicalFamily �����õ����Ի�����ֵ
     */
    public void setMedicalFamily(String medicalFamily){
        this.medicalFamily = StringUtils.rightTrim(medicalFamily);
    }

    /**
     * ��ȡ���Ի���
     * @return ���Ի�����ֵ
     */
    public String getMedicalFamily(){
        return medicalFamily;
    }

    /**
     * �������Կ�����
     * @param bank �����õ����Կ����е�ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ���Կ�����
     * @return ���Կ����е�ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * �������������˻�
     * @param creditCard �����õ����������˻���ֵ
     */
    public void setCreditCard(String creditCard){
        this.creditCard = StringUtils.rightTrim(creditCard);
    }

    /**
     * ��ȡ���������˻�
     * @return ���������˻���ֵ
     */
    public String getCreditCard(){
        return creditCard;
    }
}
