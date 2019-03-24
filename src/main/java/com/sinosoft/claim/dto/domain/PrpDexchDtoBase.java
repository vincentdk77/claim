package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdexch�һ��ʵ����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDexchDtoBase implements Serializable{
    /** ���Ի������� */
    private DateTime exchDate = new DateTime();
    /** ���Ի�׼ */
    private double base = 0d;
    /** ���Ի�׼�ұ� */
    private String baseCurrency = "";
    /** ���Զһ��ұ� */
    private String exchCurrency = "";
    /** ���Զһ����� */
    private double exchRate = 0d;
    /** ��������� */
    private double buyPrice = 0d;
    /** ���������� */
    private double salePrice = 0d;
    /** �����ּ� */
    private double cashPrice = 0d;
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDexchDtoBase����
     */
    public PrpDexchDtoBase(){
    }

    /**
     * �������Ի�������
     * @param exchDate �����õ����Ի������ڵ�ֵ
     */
    public void setExchDate(DateTime exchDate){
        this.exchDate = exchDate;
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի������ڵ�ֵ
     */
    public DateTime getExchDate(){
        return exchDate;
    }

    /**
     * �������Ի�׼
     * @param base �����õ����Ի�׼��ֵ
     */
    public void setBase(double base){
        this.base = base;
    }

    /**
     * ��ȡ���Ի�׼
     * @return ���Ի�׼��ֵ
     */
    public double getBase(){
        return base;
    }

    /**
     * �������Ի�׼�ұ�
     * @param baseCurrency �����õ����Ի�׼�ұ��ֵ
     */
    public void setBaseCurrency(String baseCurrency){
        this.baseCurrency = StringUtils.rightTrim(baseCurrency);
    }

    /**
     * ��ȡ���Ի�׼�ұ�
     * @return ���Ի�׼�ұ��ֵ
     */
    public String getBaseCurrency(){
        return baseCurrency;
    }

    /**
     * �������Զһ��ұ�
     * @param exchCurrency �����õ����Զһ��ұ��ֵ
     */
    public void setExchCurrency(String exchCurrency){
        this.exchCurrency = StringUtils.rightTrim(exchCurrency);
    }

    /**
     * ��ȡ���Զһ��ұ�
     * @return ���Զһ��ұ��ֵ
     */
    public String getExchCurrency(){
        return exchCurrency;
    }

    /**
     * �������Զһ�����
     * @param exchRate �����õ����Զһ����ʵ�ֵ
     */
    public void setExchRate(double exchRate){
        this.exchRate = exchRate;
    }

    /**
     * ��ȡ���Զһ�����
     * @return ���Զһ����ʵ�ֵ
     */
    public double getExchRate(){
        return exchRate;
    }

    /**
     * �������������
     * @param buyPrice �����õ���������۵�ֵ
     */
    public void setBuyPrice(double buyPrice){
        this.buyPrice = buyPrice;
    }

    /**
     * ��ȡ���������
     * @return ��������۵�ֵ
     */
    public double getBuyPrice(){
        return buyPrice;
    }

    /**
     * ��������������
     * @param salePrice �����õ����������۵�ֵ
     */
    public void setSalePrice(double salePrice){
        this.salePrice = salePrice;
    }

    /**
     * ��ȡ����������
     * @return ���������۵�ֵ
     */
    public double getSalePrice(){
        return salePrice;
    }

    /**
     * ���������ּ�
     * @param cashPrice �����õ������ּ۵�ֵ
     */
    public void setCashPrice(double cashPrice){
        this.cashPrice = cashPrice;
    }

    /**
     * ��ȡ�����ּ�
     * @return �����ּ۵�ֵ
     */
    public double getCashPrice(){
        return cashPrice;
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
