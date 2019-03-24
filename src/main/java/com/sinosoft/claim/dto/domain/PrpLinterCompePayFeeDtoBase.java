package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���Ǽ�������������Ϣ�����ݴ���������<br>
 */
public class PrpLinterCompePayFeeDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** �����������pk */
    private int serialNo = 0;
    /** ���Ա����� */
    private int itemKindNo = 0;
    /** ���Է��ô��� */
    private String codeCode = "";
    /** ���Է������� */
    private String codeCName = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** �����ձ����� */
    private String kindName = "";
    /** ���Դ��鿱�������� */
    private String checkDeptName = "";
    /** ���Աұ����Ĭ��CNY */
    private String currency = "";
    /** ���Աұ����� */
    private String currencyName = "";
    /** ���Է��ý�� */
    private double chargeAmount = 0D;
    /** ����Ԥ������ */
    private double preChargeAmount = 0D;
    /** ���Լ�������� */
    private double sumRealPay = 0D;
    /** ���Դ��鿱�������� */
    private String checkDeptCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterCompePayFeeDtoBase����
     */
    public PrpLinterCompePayFeeDtoBase(){
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
     * ���������������pk
     * @param serialNo �����õ������������pk��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�����������pk
     * @return �����������pk��ֵ
     */
    public int getSerialNo(){
        return serialNo;
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
     * �������Է��ô���
     * @param codeCode �����õ����Է��ô����ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ���Է��ô���
     * @return ���Է��ô����ֵ
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * �������Է�������
     * @param codeCName �����õ����Է������Ƶ�ֵ
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * ��ȡ���Է�������
     * @return ���Է������Ƶ�ֵ
     */
    public String getCodeCName(){
        return codeCName;
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
     * �������Դ��鿱��������
     * @param checkDeptName �����õ����Դ��鿱�������Ƶ�ֵ
     */
    public void setCheckDeptName(String checkDeptName){
        this.checkDeptName = StringUtils.rightTrim(checkDeptName);
    }

    /**
     * ��ȡ���Դ��鿱��������
     * @return ���Դ��鿱�������Ƶ�ֵ
     */
    public String getCheckDeptName(){
        return checkDeptName;
    }

    /**
     * �������Աұ����Ĭ��CNY
     * @param currency �����õ����Աұ����Ĭ��CNY��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����Ĭ��CNY
     * @return ���Աұ����Ĭ��CNY��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Աұ�����
     * @param currencyName �����õ����Աұ����Ƶ�ֵ
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

    /**
     * ��ȡ���Աұ�����
     * @return ���Աұ����Ƶ�ֵ
     */
    public String getCurrencyName(){
        return currencyName;
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
     * ��������Ԥ������
     * @param preChargeAmount �����õ�����Ԥ�����õ�ֵ
     */
    public void setPreChargeAmount(double preChargeAmount){
        this.preChargeAmount = preChargeAmount;
    }

    /**
     * ��ȡ����Ԥ������
     * @return ����Ԥ�����õ�ֵ
     */
    public double getPreChargeAmount(){
        return preChargeAmount;
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
     * �������Դ��鿱��������
     * @param checkDeptCode �����õ����Դ��鿱���������ֵ
     */
    public void setCheckDeptCode(String checkDeptCode){
        this.checkDeptCode = StringUtils.rightTrim(checkDeptCode);
    }

    /**
     * ��ȡ���Դ��鿱��������
     * @return ���Դ��鿱���������ֵ
     */
    public String getCheckDeptCode(){
        return checkDeptCode;
    }
}
